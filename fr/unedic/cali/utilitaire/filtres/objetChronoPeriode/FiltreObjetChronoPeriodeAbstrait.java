package fr.unedic.cali.utilitaire.filtres.objetChronoPeriode;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.ContratTravail;
import fr.unedic.cali.autresdoms.ga.dom.InformationPeriodeGlobale;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Temporel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public abstract class FiltreObjetChronoPeriodeAbstrait
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = 1L;
  protected boolean m_estActiviteSalariee = false;
  protected ActiviteSalarie m_activiteSalarie = null;
  protected InformationPeriodeGlobale m_informationPeriodeGlobale = null;
  protected Damj m_dateDebutPeriodeGlobale = null;
  protected Damj m_dateFinPeriodeGlobale = null;
  protected Damj m_dateRuptureContratTravailGlobale = null;
  protected String m_motifFinGlobale = null;
  protected boolean m_estContexteUtilisationPeriodeGlobale = false;
  protected Collection<String> m_listeContexteUtilisationPeriodeGlobale;
  
  public FiltreObjetChronoPeriodeAbstrait(Collection<String> listeContexteUtilisationPeriodeGlobale)
  {
    m_listeContexteUtilisationPeriodeGlobale = listeContexteUtilisationPeriodeGlobale;
  }
  
  public FiltreObjetChronoPeriodeAbstrait(String contexteUtilisationPeriodeGlobale)
  {
    m_listeContexteUtilisationPeriodeGlobale = creerListeUtilisationPeriodeGlobale(contexteUtilisationPeriodeGlobale);
  }
  
  public boolean accepter(Temporel temporel)
  {
    boolean retour = false;
    renseignerDonneesActivite(temporel, m_listeContexteUtilisationPeriodeGlobale);
    retour = super.accepter(temporel);
    return retour;
  }
  
  protected void renseignerDonneesActivite(Temporel temporel, Collection<String> listeContexteUtilisationPeriodeGlobale)
  {
    m_estActiviteSalariee = estActiviteSalarie(temporel);
    if (m_estActiviteSalariee)
    {
      m_activiteSalarie = ((ActiviteSalarie)temporel);
      m_informationPeriodeGlobale = m_activiteSalarie.getInformationPeriodeGlobale();
      m_dateDebutPeriodeGlobale = m_informationPeriodeGlobale.getDateDebutPeriode();
      m_dateFinPeriodeGlobale = m_informationPeriodeGlobale.getDateFinPeriode();
      if (m_informationPeriodeGlobale.getDateFinPeriode() == null) {
        m_dateFinPeriodeGlobale = Damj.FIN_DES_TEMPS;
      }
      m_dateRuptureContratTravailGlobale = m_informationPeriodeGlobale.getDateRuptureContratTravail();
      m_motifFinGlobale = m_informationPeriodeGlobale.getMotifFin();
      m_estContexteUtilisationPeriodeGlobale = estContexteUtilisationPeriodeGlobale(listeContexteUtilisationPeriodeGlobale);
    }
  }
  
  private boolean estContexteUtilisationPeriodeGlobale(Collection<String> listeContexteUtilisationPeriodeGlobale)
  {
    boolean retour = false;
    Collection<String> contextesDecoupageContrat = m_activiteSalarie.getContrat().getContextesDecoupage();
    if ((listeContexteUtilisationPeriodeGlobale != null) && (!listeContexteUtilisationPeriodeGlobale.isEmpty()) && (contextesDecoupageContrat != null) && (!contextesDecoupageContrat.isEmpty())) {
      if (listeContexteUtilisationPeriodeGlobale.contains("TOUS"))
      {
        retour = true;
      }
      else
      {
        Iterator<String> iterateur = contextesDecoupageContrat.iterator();
        boolean aucunContexteNonTrouve = true;
        while ((iterateur.hasNext()) && (aucunContexteNonTrouve))
        {
          String contexteDecoupage = (String)iterateur.next();
          if ((listeContexteUtilisationPeriodeGlobale.contains(contexteDecoupage)) && (aucunContexteNonTrouve))
          {
            aucunContexteNonTrouve = true;
          }
          else
          {
            aucunContexteNonTrouve = false;
            break;
          }
        }
        retour = aucunContexteNonTrouve;
      }
    }
    return retour;
  }
  
  public int getTypeElementManipule()
  {
    return 3;
  }
  
  protected boolean estActiviteSalarie(Temporel temporel)
  {
    return temporel instanceof ActiviteSalarie;
  }
  
  protected ArrayList<String> creerListeUtilisationPeriodeGlobale(String contexteUtilisationPeriodeGlobale)
  {
    ArrayList<String> contexteUilisationPeriodeGlobale = null;
    String stringVide = "";
    if ((contexteUtilisationPeriodeGlobale != null) && (!contexteUtilisationPeriodeGlobale.equals(stringVide)))
    {
      contexteUilisationPeriodeGlobale = new ArrayList();
      contexteUilisationPeriodeGlobale.add(contexteUtilisationPeriodeGlobale);
    }
    return contexteUilisationPeriodeGlobale;
  }
}

/* Location:
 * Qualified Name:     FiltreObjetChronoPeriodeAbstrait
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */