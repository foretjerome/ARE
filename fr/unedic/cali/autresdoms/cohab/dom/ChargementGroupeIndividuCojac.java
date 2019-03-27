package fr.unedic.cali.autresdoms.cohab.dom;

import fr.unedic.cali.autresdoms.cohab.mapping.LireListePensionsInvaliditeChainees;
import fr.unedic.cali.autresdoms.cohab.mapping.LireListePensionsInvaliditeEtAvantagesVieillesse;
import fr.unedic.cali.autresdoms.cohab.mapping.LireListePeriodeResultatEvtActualisation;
import java.util.Collection;

public class ChargementGroupeIndividuCojac
{
  private transient LireAllocataireResultat m_lireAllocataireResultat;
  private transient Collection m_listePecNonMappees;
  private transient Collection m_listePecSansFiltreNonMappees;
  private transient Collection m_lireDecisionSuivi;
  private transient LireListePeriodeResultatEvtActualisation m_periodeEvtAcutalisation;
  private transient LireListePensionsInvaliditeEtAvantagesVieillesse m_pensionInvaliditeEtAvgtVeillesse;
  private transient Collection m_listeDemandes;
  private transient Collection m_listeDemandesV1DAL;
  private transient Collection m_listeDemandesV1RNV;
  private transient Collection m_ressourcesLieesADemande;
  private transient Collection m_ressourcesDdte;
  private transient LireListePensionsInvaliditeChainees m_pensionsInvaliditesChainees;
  
  public LireAllocataireResultat getLireAllocataireResultat()
  {
    return m_lireAllocataireResultat;
  }
  
  public void setLireAllocataireResultat(LireAllocataireResultat p_lireAllocataireResultat)
  {
    m_lireAllocataireResultat = p_lireAllocataireResultat;
  }
  
  public Collection getLireDecisionSuivi()
  {
    return m_lireDecisionSuivi;
  }
  
  public void setLireDecisionSuivi(Collection p_lireDecisionSuivi)
  {
    m_lireDecisionSuivi = p_lireDecisionSuivi;
  }
  
  public Collection getListeDemandes()
  {
    return m_listeDemandes;
  }
  
  public void setListeDemandes(Collection p_listeDemandes)
  {
    m_listeDemandes = p_listeDemandes;
  }
  
  public Collection getListePecNonMappees()
  {
    return m_listePecNonMappees;
  }
  
  public void setListePecNonMappees(Collection p_listePecNonMappees)
  {
    m_listePecNonMappees = p_listePecNonMappees;
  }
  
  public Collection getListePecSansFiltreNonMappees()
  {
    return m_listePecSansFiltreNonMappees;
  }
  
  public void setListePecSansFiltreNonMappees(Collection p_listePecSansFiltreNonMappees)
  {
    m_listePecSansFiltreNonMappees = p_listePecSansFiltreNonMappees;
  }
  
  public LireListePensionsInvaliditeEtAvantagesVieillesse getPensionInvaliditeEtAvgtVeillesse()
  {
    return m_pensionInvaliditeEtAvgtVeillesse;
  }
  
  public void setPensionInvaliditeEtAvgtVeillesse(LireListePensionsInvaliditeEtAvantagesVieillesse p_pensionInvaliditeEtAvgtVeillesse)
  {
    m_pensionInvaliditeEtAvgtVeillesse = p_pensionInvaliditeEtAvgtVeillesse;
  }
  
  public LireListePeriodeResultatEvtActualisation getPeriodeEvtAcutalisation()
  {
    return m_periodeEvtAcutalisation;
  }
  
  public void setPeriodeEvtAcutalisation(LireListePeriodeResultatEvtActualisation p_periodeEvtAcutalisation)
  {
    m_periodeEvtAcutalisation = p_periodeEvtAcutalisation;
  }
  
  public Collection getListeDemandesV1DAL()
  {
    return m_listeDemandesV1DAL;
  }
  
  public void setListeDemandesV1DAL(Collection p_listeDemandesV1DAL)
  {
    m_listeDemandesV1DAL = p_listeDemandesV1DAL;
  }
  
  public Collection getListeDemandesV1RNV()
  {
    return m_listeDemandesV1RNV;
  }
  
  public void setListeDemandesV1RNV(Collection p_listeDemandesV1RNV)
  {
    m_listeDemandesV1RNV = p_listeDemandesV1RNV;
  }
  
  public Collection getRessourcesLieesADemande()
  {
    return m_ressourcesLieesADemande;
  }
  
  public void setRessourcesLieesADemande(Collection p_ressourcesLieesADemande)
  {
    m_ressourcesLieesADemande = p_ressourcesLieesADemande;
  }
  
  public Collection getRessourcesDdte()
  {
    return m_ressourcesDdte;
  }
  
  public void setRessourcesDdte(Collection p_ressourcesDdte)
  {
    m_ressourcesDdte = p_ressourcesDdte;
  }
  
  public LireListePensionsInvaliditeChainees getPensionsInvaliditesChainees()
  {
    return m_pensionsInvaliditesChainees;
  }
  
  public void setPensionsInvaliditesChainees(LireListePensionsInvaliditeChainees p_pensionsInvaliditesChainees)
  {
    m_pensionsInvaliditesChainees = p_pensionsInvaliditesChainees;
  }
}

/* Location:
 * Qualified Name:     ChargementGroupeIndividuCojac
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */