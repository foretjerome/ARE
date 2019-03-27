package fr.unedic.cali.utilitaire.filtres.objetChronoPeriode;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.CompteurIndexPASContratTravail;
import fr.unedic.util.temps.Temporel;
import java.util.Collection;

public class FiltreActiviteSalariePourIdentifiant
  extends FiltreActiviteSalarieAbstrait
{
  private static final long serialVersionUID = 1L;
  String m_identifiant;
  
  public FiltreActiviteSalariePourIdentifiant(String p_identifiant, Collection<String> p_listeContexteUtilisationPeriodeGlobale)
  {
    super(p_listeContexteUtilisationPeriodeGlobale);
    m_identifiant = p_identifiant;
  }
  
  public FiltreActiviteSalariePourIdentifiant(String p_identifiant, String p_contexteUtilisationPeriodeGlobale)
  {
    super(p_contexteUtilisationPeriodeGlobale);
    m_identifiant = p_identifiant;
  }
  
  public boolean accepterElement(Temporel p_temporel)
  {
    boolean retour = false;
    String identifiantARechercher = m_identifiant;
    if (identifiantARechercher != null)
    {
      ActiviteSalarie periode = (ActiviteSalarie)p_temporel;
      String identifiantPeriode = periode.getIdentifiant();
      if (m_estContexteUtilisationPeriodeGlobale)
      {
        identifiantARechercher = CompteurIndexPASContratTravail.recupererPrefixeIdentifiant(m_identifiant);
        identifiantPeriode = CompteurIndexPASContratTravail.recupererPrefixeIdentifiant(identifiantPeriode);
      }
      retour = identifiantARechercher.equals(identifiantPeriode);
    }
    return retour;
  }
}

/* Location:
 * Qualified Name:     FiltreActiviteSalariePourIdentifiant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */