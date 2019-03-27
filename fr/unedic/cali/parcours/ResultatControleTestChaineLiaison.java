package fr.unedic.cali.parcours;

import fr.unedic.util.services.Resultat;

public class ResultatControleTestChaineLiaison
  extends Resultat
{
  private boolean m_fluxSigma;
  private boolean m_fluxGaec;
  private boolean m_asyncV2;
  private boolean m_syncV2;
  private boolean m_syncV1;
  private boolean m_persistanceCali;
  private boolean m_persistanceGaec;
  
  public boolean isFluxSigma()
  {
    return m_fluxSigma;
  }
  
  public boolean isAsyncV2()
  {
    return m_asyncV2;
  }
  
  public void setAsyncV2(boolean p_asyncV2)
  {
    m_asyncV2 = p_asyncV2;
  }
  
  public boolean isFluxGaec()
  {
    return m_fluxGaec;
  }
  
  public void setFluxGaec(boolean p_fluxGaec)
  {
    m_fluxGaec = p_fluxGaec;
  }
  
  public void setFluxSigma(boolean p_fluxSigma)
  {
    m_fluxSigma = p_fluxSigma;
  }
  
  public boolean isPersistanceCali()
  {
    return m_persistanceCali;
  }
  
  public void setPersistanceCali(boolean p_persistanceCali)
  {
    m_persistanceCali = p_persistanceCali;
  }
  
  public boolean isPersistanceGaec()
  {
    return m_persistanceGaec;
  }
  
  public void setPersistanceGaec(boolean p_persistanceGaec)
  {
    m_persistanceGaec = p_persistanceGaec;
  }
  
  public boolean isSyncV1()
  {
    return m_syncV1;
  }
  
  public void setSyncV1(boolean p_syncV1)
  {
    m_syncV1 = p_syncV1;
  }
  
  public boolean isSyncV2()
  {
    return m_syncV2;
  }
  
  public void setSyncV2(boolean p_syncV2)
  {
    m_syncV2 = p_syncV2;
  }
}

/* Location:
 * Qualified Name:     ResultatControleTestChaineLiaison
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */