package fr.unedic.cali.dom;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.cali.dom.pc.MontantBaseAbstraitPC;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.Quantite;

public class MontantBaseAbstraitNonSumatraPC
  extends MontantBaseAbstraitPC
{
  MontantBaseAbstraitNonSumatra m_om;
  
  public MontantBaseAbstraitNonSumatraPC(MontantBaseAbstraitNonSumatra p_sumatra)
  {
    m_om = p_sumatra;
  }
  
  public Object createOM()
  {
    return m_om;
  }
  
  public ObjetMetierSpec copie()
  {
    return m_om.copie();
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    throw ExceptionUtil.shouldNotPassHere("");
  }
  
  public boolean equals(Object p_arg0)
  {
    throw ExceptionUtil.shouldNotPassHere("");
  }
  
  public boolean getAvecPrecompteCRC()
  {
    throw ExceptionUtil.shouldNotPassHere("");
  }
  
  public Quantite getCrc()
  {
    throw ExceptionUtil.shouldNotPassHere("");
  }
  
  public Object getGenericPC()
  {
    throw ExceptionUtil.shouldNotPassHere("");
  }
  
  public String getIdentifiant()
  {
    throw ExceptionUtil.shouldNotPassHere("");
  }
  
  public String getJustificationCalculMontant()
  {
    throw ExceptionUtil.shouldNotPassHere("");
  }
  
  public Quantite getMontantBrut()
  {
    throw ExceptionUtil.shouldNotPassHere("");
  }
  
  public DomPCSpec getPC()
  {
    throw ExceptionUtil.shouldNotPassHere("");
  }
  
  public String getType()
  {
    throw ExceptionUtil.shouldNotPassHere("");
  }
  
  public int hashCode()
  {
    throw ExceptionUtil.shouldNotPassHere("");
  }
  
  public boolean isEstAvecPrecompte()
  {
    throw ExceptionUtil.shouldNotPassHere("");
  }
  
  public void jdoPostLoad()
  {
    throw ExceptionUtil.shouldNotPassHere("");
  }
  
  public void jdoPreClear()
  {
    throw ExceptionUtil.shouldNotPassHere("");
  }
  
  public void jdoPreDelete()
  {
    throw ExceptionUtil.shouldNotPassHere("");
  }
  
  public void jdoPreStore()
  {
    throw ExceptionUtil.shouldNotPassHere("");
  }
  
  public void marquerGraphePersistant()
  {
    throw ExceptionUtil.shouldNotPassHere("");
  }
  
  public void setAvecPrecompteCRC(boolean p_avecPrecompteCRC)
  {
    throw ExceptionUtil.shouldNotPassHere("");
  }
  
  public void setPC(DomPCSpec p_montantBaseAbstraitPC)
  {
    throw ExceptionUtil.shouldNotPassHere("");
  }
  
  public void supprimerEnProfondeur()
    throws TechniqueException
  {
    throw ExceptionUtil.shouldNotPassHere("");
  }
  
  public String toString()
  {
    throw ExceptionUtil.shouldNotPassHere("");
  }
}

/* Location:
 * Qualified Name:     MontantBaseAbstraitNonSumatraPC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */