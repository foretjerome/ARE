package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.cre.CRModificationDonnee;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.outilsfonctionnels.ArrayListCREM;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.ChronologieDebuts;
import java.util.ArrayList;
import java.util.Collection;

public class ResultatServiceDemande
  extends Resultat
{
  protected ChronologieDebuts m_chronoDemandes = null;
  protected DemandeSpec m_demande = null;
  protected ArrayList m_listeDifferencesReexamen = null;
  protected Collection m_listeMotifsReexamenAvantReexamen;
  protected String m_motifPrincipalReexamenAvantReexamen;
  protected ArrayListCREM m_listeComparaisonCREMDonneesImposees = null;
  protected ArrayListCREM m_listeComparaisonCREMDecision = null;
  protected ArrayListCREM m_listeComparaisonCREMConstituant = null;
  protected CRModificationDonnee m_crem = null;
  
  public ResultatServiceDemande() {}
  
  public ResultatServiceDemande(int p_etat)
  {
    super(p_etat);
  }
  
  public DemandeSpec getDemande()
  {
    return m_demande;
  }
  
  public ChronologieDebuts getChronoDemandes()
  {
    return m_chronoDemandes;
  }
  
  public void setDemande(DemandeSpec p_demande)
  {
    m_demande = p_demande;
  }
  
  public void setChronoDemandes(ChronologieDebuts p_chronoDemande)
  {
    m_chronoDemandes = p_chronoDemande;
  }
  
  public ArrayList getListeDifferencesReexamen()
  {
    return m_listeDifferencesReexamen;
  }
  
  public void setListeDifferencesReexamen(ArrayList p_listeDifferencesReexamen)
  {
    m_listeDifferencesReexamen = p_listeDifferencesReexamen;
  }
  
  public Collection getListeMotifsReexamenAvantReexamen()
  {
    return m_listeMotifsReexamenAvantReexamen;
  }
  
  public void setListeMotifsReexamenAvantReexamen(Collection p_listeMotifsReexamenAvantReexamen)
  {
    m_listeMotifsReexamenAvantReexamen = p_listeMotifsReexamenAvantReexamen;
  }
  
  public String getMotifPrincipalReexamenAvantReexamen()
  {
    return m_motifPrincipalReexamenAvantReexamen;
  }
  
  public void setMotifPrincipalReexamenAvantReexamen(String p_motifPrincipalReexamenAvantReexamen)
  {
    m_motifPrincipalReexamenAvantReexamen = p_motifPrincipalReexamenAvantReexamen;
  }
  
  public ArrayListCREM getListeComparaisonCREMConstituant()
  {
    return m_listeComparaisonCREMConstituant;
  }
  
  public void setListeComparaisonCREMConstituant(ArrayListCREM p_listeComparaisonCREMConstituant)
  {
    m_listeComparaisonCREMConstituant = p_listeComparaisonCREMConstituant;
  }
  
  public ArrayListCREM getListeComparaisonCREMDecision()
  {
    return m_listeComparaisonCREMDecision;
  }
  
  public void setListeComparaisonCREMDecision(ArrayListCREM p_listeComparaisonCREMDecision)
  {
    m_listeComparaisonCREMDecision = p_listeComparaisonCREMDecision;
  }
  
  public ArrayListCREM getListeComparaisonCREMDonneesImposees()
  {
    return m_listeComparaisonCREMDonneesImposees;
  }
  
  public void setListeComparaisonCREMDonneesImposees(ArrayListCREM p_listeComparaisonCREMDonneesImposees)
  {
    m_listeComparaisonCREMDonneesImposees = p_listeComparaisonCREMDonneesImposees;
  }
  
  public CRModificationDonnee getCREM()
  {
    return m_crem;
  }
  
  public void setCREM(CRModificationDonnee p_crem)
  {
    m_crem = p_crem;
  }
}

/* Location:
 * Qualified Name:     ResultatServiceDemande
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */