package fr.unedic.cali.autresdoms.cohab.sigma.demande.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.demande.dom.spec.StructureInDemandeV1Spec;
import fr.unedic.cali.autresdoms.cohab.sigma.dom.StructureIn;

public class StructureInDemandeV1
  extends StructureIn
  implements StructureInDemandeV1Spec
{
  private String m_idDemande;
  private String m_typeDemande;
  private String m_identifiantRecherche;
  
  public String getIdentifiantDemande()
  {
    return m_idDemande;
  }
  
  public String getTypeDemande()
  {
    return m_typeDemande;
  }
  
  public String getIdentifiantRecherche()
  {
    return m_identifiantRecherche;
  }
  
  public void setIdentifiantDemande(String p_identifiant)
  {
    m_idDemande = p_identifiant;
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
 * Qualified Name:     StructureInDemandeV1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */