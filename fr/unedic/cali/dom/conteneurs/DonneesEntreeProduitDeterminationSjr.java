package fr.unedic.cali.dom.conteneurs;

import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.dom.conteneurs.spec.DonneesEntreeProduitDeterminationSjrSpec;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.outilsfonctionnels.OutilTrace;
import fr.unedic.cali.util.OutilDomToString;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologieEvenements;
import fr.unedic.util.temps.ComparateurTemporelsSurDateDebut;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.NonConformiteException;
import java.math.BigDecimal;
import java.util.Hashtable;
import java.util.Iterator;

public class DonneesEntreeProduitDeterminationSjr
  implements DonneesEntreeProduitDeterminationSjrSpec
{
  private Hashtable m_tableParametresProduit = new Hashtable();
  private BigDecimal m_parametrePlafondDiviseurPrc;
  
  public boolean ajouterParametre(String p_nomParametre, DonneeEntreeParametre p_parametre)
  {
    boolean ajoutOk = true;
    try
    {
      Chronologie chronoParametres = null;
      if (m_tableParametresProduit.containsKey(p_nomParametre))
      {
        chronoParametres = (Chronologie)m_tableParametresProduit.get(p_nomParametre);
        chronoParametres.ajouter(p_parametre);
      }
      else
      {
        chronoParametres = new ChronologieEvenements();
        chronoParametres.ajouter(p_parametre);
        m_tableParametresProduit.put(p_nomParametre, chronoParametres);
      }
    }
    catch (NonConformiteException ex)
    {
      OutilTrace.ecrireTrace(Niveau.DEBUG, new Object[] { "Exception levée lors de l'ajout d'un paramètre temporel." }, ex);
      ajoutOk = false;
    }
    return ajoutOk;
  }
  
  public BigDecimal getParametrePlafondDiviseurPrc()
  {
    return m_parametrePlafondDiviseurPrc;
  }
  
  public void setParametrePlafondDiviseurPrc(BigDecimal p_parametrePlafondDiviseurPrc)
  {
    m_parametrePlafondDiviseurPrc = p_parametrePlafondDiviseurPrc;
  }
  
  public DonneeEntreeParametre getParametreActif(String p_nomParametre, Damj p_dateRecherche)
  {
    DonneeEntreeParametre parametreRetourne = null;
    
    Chronologie chronoParametres = (Chronologie)m_tableParametresProduit.get(p_nomParametre);
    if ((chronoParametres != null) && (!chronoParametres.estVide()))
    {
      chronoParametres.setComparateur(new ComparateurTemporelsSurDateDebut());
      
      Iterator it = chronoParametres.iterer();
      DonneeEntreeParametre parametreCourant = null;
      while (it.hasNext())
      {
        parametreCourant = (DonneeEntreeParametre)it.next();
        if (!parametreCourant.getDateEffet().estAvantOuCoincideAvec(p_dateRecherche)) {
          break;
        }
        parametreRetourne = parametreCourant;
      }
      if (parametreRetourne == null) {
        leverAlerteA11MB12(p_nomParametre, p_dateRecherche);
      }
    }
    return parametreRetourne;
  }
  
  private void leverAlerteA11MB12(String p_nomParametre, Damj p_dateRecherche)
  {
    try
    {
      GestionnaireErreur.getInstance().genererException("PR_CALI_L_ALERTE_A11MB12", new String[] { p_nomParametre, p_dateRecherche.toString() }, 3);
    }
    catch (CoucheLogiqueException ex) {}
  }
  
  public String toString()
  {
    return OutilDomToString.toString(this);
  }
  
  public void supprimerParametre(String p_nomParametre)
  {
    m_tableParametresProduit.remove(p_nomParametre);
  }
}

/* Location:
 * Qualified Name:     DonneesEntreeProduitDeterminationSjr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */