package fr.unedic.cali.autresdoms.cohab.sigma.servicecali.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.dom.Criteres;
import fr.unedic.cali.autresdoms.cohab.sigma.servicecali.dom.spec.CriteresCaliSpec;
import fr.unedic.util.temps.Damj;

public class CriteresCali
  extends Criteres
  implements CriteresCaliSpec
{
  private String m_numeroAllocataire;
  private int m_identifiantPriseEnCharge;
  private Damj m_dateDeRecherchePec;
  private Damj m_dateDispense;
  private Damj m_dateDebutEvtActualisation;
  private Damj m_dateFinEvtActualisation;
  private int m_identifiantActionFormation;
  private Damj m_dateRechercheFormation;
  private String m_idDAL;
  private String m_typeSegmentV1;
  private String m_typeDemande;
  private String m_identifiantRecherche;
  
  public int getIdentifiantPriseEnCharge()
  {
    return m_identifiantPriseEnCharge;
  }
  
  public void setIdentifiantPriseEnCharge(int p_identifiantPriseEnCharge)
  {
    m_identifiantPriseEnCharge = p_identifiantPriseEnCharge;
  }
  
  public Damj getDateRecherchePec()
  {
    return m_dateDeRecherchePec;
  }
  
  public void setDateRecherchePec(Damj p_dateRecherche)
  {
    m_dateDeRecherchePec = p_dateRecherche;
  }
  
  public Damj getDateDispense()
  {
    return m_dateDispense;
  }
  
  public void setDateDispense(Damj p_dateDispense)
  {
    m_dateDispense = p_dateDispense;
  }
  
  public Damj getDateDebutEvtActualisation()
  {
    return m_dateDebutEvtActualisation;
  }
  
  public void setDateDebutEvtActualisation(Damj p_dateDebut)
  {
    m_dateDebutEvtActualisation = p_dateDebut;
  }
  
  public Damj getDateFinEvtActualisation()
  {
    return m_dateFinEvtActualisation;
  }
  
  public void setDateFinEvtActualisation(Damj p_dateFin)
  {
    m_dateFinEvtActualisation = p_dateFin;
  }
  
  public int getIdentifiantActionFormation()
  {
    return m_identifiantActionFormation;
  }
  
  public void setIdentifiantActionFormation(int p_identifiant)
  {
    m_identifiantActionFormation = p_identifiant;
  }
  
  public Damj getDateRechercheFormation()
  {
    return m_dateRechercheFormation;
  }
  
  public void setDateRechercheFormation(Damj p_dateRecherche)
  {
    m_dateRechercheFormation = p_dateRecherche;
  }
  
  public String getNumeroAllocataire()
  {
    return m_numeroAllocataire;
  }
  
  public void setNumeroAllocataire(String p_numeroAllocataire)
  {
    m_numeroAllocataire = p_numeroAllocataire;
  }
  
  public String toString()
  {
    return "CriteresFormation [" + getNumeroAllocataire() + ", " + getIdentifiantActionFormation() + ", " + (getDateRechercheFormation() == null ? null : getDateRechercheFormation().formater()) + "]";
  }
  
  public String getIdentifiantDemande()
  {
    return m_idDAL;
  }
  
  public String getTypeSegmentV1()
  {
    return m_typeSegmentV1;
  }
  
  public void setIdentifiantDemande(String p_idDAL)
  {
    m_idDAL = p_idDAL;
  }
  
  public void setTypeSegment(String p_typeSegmentV1)
  {
    m_typeSegmentV1 = p_typeSegmentV1;
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
 * Qualified Name:     CriteresCali
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */