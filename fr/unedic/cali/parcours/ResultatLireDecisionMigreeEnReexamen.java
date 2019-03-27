package fr.unedic.cali.parcours;

import fr.unedic.cohabitation.sigma.migration.dom.DemandeMigreeAsuV1;
import fr.unedic.util.services.Resultat;

public class ResultatLireDecisionMigreeEnReexamen
  extends Resultat
{
  private DemandeMigreeAsuV1 m_demandeLue = null;
  
  public ResultatLireDecisionMigreeEnReexamen()
  {
    m_demandeLue = new DemandeMigreeAsuV1();
  }
  
  public DemandeMigreeAsuV1 getDemandeLue()
  {
    return m_demandeLue;
  }
  
  public void setDemandeLue(DemandeMigreeAsuV1 p_demandeLue)
  {
    m_demandeLue = p_demandeLue;
  }
}

/* Location:
 * Qualified Name:     ResultatLireDecisionMigreeEnReexamen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */