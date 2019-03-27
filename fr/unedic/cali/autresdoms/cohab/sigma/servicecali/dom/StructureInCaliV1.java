package fr.unedic.cali.autresdoms.cohab.sigma.servicecali.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.dom.StructureIn;
import fr.unedic.cali.autresdoms.cohab.sigma.servicecali.dom.spec.StructureInCaliV1Spec;
import fr.unedic.util.temps.Damj;

public class StructureInCaliV1
  extends StructureIn
  implements StructureInCaliV1Spec
{
  private int m_identifiantPriseEnCharge;
  private Damj m_dateDeRecherchePec;
  private Damj m_dateDebutEvtActualisation;
  private Damj m_dateFinEvtActualisation;
  private Damj m_dateRechercheFormation;
  private int m_identifiantFormation;
  private String m_typeSegment;
  private String m_identifiantDemande;
  private String m_typeDemande;
  private String m_identifiantRecherche;
  
  public Damj getDateRecherchePec()
  {
    return m_dateDeRecherchePec;
  }
  
  public int getIdentifiantPriseEnCharge()
  {
    return m_identifiantPriseEnCharge;
  }
  
  public void setDateRecherchePec(Damj p_dateRecherche)
  {
    m_dateDeRecherchePec = p_dateRecherche;
  }
  
  public void setIdentifiantPriseEnCharge(int p_identifiantPriseEnCharge)
  {
    m_identifiantPriseEnCharge = p_identifiantPriseEnCharge;
  }
  
  public Damj getDateDebutEvtActualisation()
  {
    return m_dateDebutEvtActualisation;
  }
  
  public Damj getDateFinEvtActualisation()
  {
    return m_dateFinEvtActualisation;
  }
  
  public void setDateDebutEvtActualisation(Damj p_dateDebut)
  {
    m_dateDebutEvtActualisation = p_dateDebut;
  }
  
  public void setDateFinEvtActualisation(Damj p_dateFin)
  {
    m_dateFinEvtActualisation = p_dateFin;
  }
  
  public Damj getDateRechercheFormation()
  {
    return m_dateRechercheFormation;
  }
  
  public void setDateRechercheFormation(Damj p_dateRecherche)
  {
    m_dateRechercheFormation = p_dateRecherche;
  }
  
  public int getIdentifiantActionFormation()
  {
    return m_identifiantFormation;
  }
  
  public void setIdentifiantActionFormation(int p_identifiant)
  {
    m_identifiantFormation = p_identifiant;
  }
  
  public String getIdentifiantDemande()
  {
    return m_identifiantDemande;
  }
  
  public String getTypeSegment()
  {
    return m_typeSegment;
  }
  
  public void setIdentifiantDemande(String p_identifiantDemande)
  {
    m_identifiantDemande = p_identifiantDemande;
  }
  
  public void setTypeSegment(String p_typeSegment)
  {
    m_typeSegment = p_typeSegment;
  }
  
  public String getTypeDemande()
  {
    return m_typeDemande;
  }
  
  public String getIdentifiantRecherche()
  {
    return m_identifiantRecherche;
  }
  
  public void setTypeDemande(String p_typeDemande)
  {
    m_typeDemande = p_typeDemande;
  }
  
  public void setIdentifiantRecherche(String p_identifiant)
  {
    m_identifiantRecherche = p_identifiant;
  }
}

/* Location:
 * Qualified Name:     StructureInCaliV1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */