package fr.unedic.cali.autresdoms.cohab.sigma.demande.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.demande.dom.spec.CriteresDemandeSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.dom.Criteres;

public class CriteresDemande
  extends Criteres
  implements CriteresDemandeSpec
{
  private String m_identifiantDemande;
  private String m_numeroAllocataire;
  private String m_typeDemande;
  private String m_identifiantRecherche;
  
  public String getNumeroAllocataire()
  {
    return m_numeroAllocataire;
  }
  
  public String getIdentifiantDemande()
  {
    return m_identifiantDemande;
  }
  
  public String getTypeDemande()
  {
    return m_typeDemande;
  }
  
  public String getIdentifiantRecherche()
  {
    return m_identifiantRecherche;
  }
  
  public void setNumeroAllocataire(String p_numeroAllocataire)
  {
    m_numeroAllocataire = p_numeroAllocataire;
  }
  
  public void setIdentifiantDemande(String p_identifiant)
  {
    m_identifiantDemande = p_identifiant;
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
 * Qualified Name:     CriteresDemande
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */