package fr.unedic.cali.dom;

import fr.unedic.cali.autresdoms.d90.dom.Demande;

public class ResultatAppelLiquidation
{
  public static final int ETAT_LIQUIDATION_ECHEC = 0;
  public static final int ETAT_LIQUIDATION_REMISE_EN_CAUSE = 1;
  public static final int ETAT_LIQUIDATION_RECONDUCTION_DECISION_NON_VALIDEE = 2;
  public static final int ETAT_LIQUIDATION_RECONDUCTION_DECISION_VALIDEE = 3;
  private DemandeSpec m_demandeLiquidee;
  private int m_etatLiquidation;
  private Demande m_demandeVisu;
  
  public Demande getDemandeVisu()
  {
    return m_demandeVisu;
  }
  
  public void setDemandeVisu(Demande p_demandeVisu)
  {
    m_demandeVisu = p_demandeVisu;
  }
  
  public DemandeSpec getDemandeLiquidee()
  {
    return m_demandeLiquidee;
  }
  
  public void setDemandeLiquidee(DemandeSpec p_demandeLiquidee)
  {
    m_demandeLiquidee = p_demandeLiquidee;
  }
  
  public int getEtatLiquidation()
  {
    return m_etatLiquidation;
  }
  
  public void setEtatLiquidation(int p_etatLiquidation)
  {
    m_etatLiquidation = p_etatLiquidation;
  }
}

/* Location:
 * Qualified Name:     ResultatAppelLiquidation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */