package fr.unedic.cali.calcul.dom;

import fr.unedic.util.ObjetMetierSpec;
import java.math.BigDecimal;

public class CompteursMobilite
  implements ObjetMetierSpec
{
  private static final long serialVersionUID = 1L;
  private boolean plafond = false;
  private boolean deltaApplique = false;
  private BigDecimal cumulAttribue = null;
  private BigDecimal cumulIndemnise = null;
  private BigDecimal montantEngage = null;
  private BigDecimal desengagement = null;
  private BigDecimal ndEngage = null;
  private BigDecimal ndIndemnise = null;
  private BigDecimal ndADesengager = null;
  
  public boolean isPlafond()
  {
    return plafond;
  }
  
  public void setPlafond(boolean p_plafond)
  {
    plafond = p_plafond;
  }
  
  public BigDecimal getCumulAttribue()
  {
    return cumulAttribue;
  }
  
  public String getCumulAttribueF()
  {
    return cumulAttribue.setScale(2, 0).toString();
  }
  
  public void setCumulAttribue(BigDecimal p_cumulAttribue)
  {
    cumulAttribue = p_cumulAttribue;
  }
  
  public BigDecimal getCumulIndemnise()
  {
    return cumulIndemnise;
  }
  
  public String getCumulIndemniseF()
  {
    return cumulIndemnise.setScale(2, 0).toString();
  }
  
  public void setCumulIndemnise(BigDecimal p_cumulIndemnise)
  {
    cumulIndemnise = p_cumulIndemnise;
  }
  
  public BigDecimal getMontantEngage()
  {
    return montantEngage;
  }
  
  public String getMontantEngageF()
  {
    return montantEngage.setScale(2, 0).toString();
  }
  
  public void setMontantEngage(BigDecimal p_montantEngage)
  {
    montantEngage = p_montantEngage;
  }
  
  public BigDecimal getDesengagement()
  {
    return desengagement;
  }
  
  public String getDesengagementF()
  {
    return desengagement.setScale(2, 0).toString();
  }
  
  public void setDesengagement(BigDecimal p_desengagement)
  {
    desengagement = p_desengagement;
  }
  
  public BigDecimal getNdEngage()
  {
    return ndEngage;
  }
  
  public String getNdEngageF()
  {
    return ndEngage.setScale(2, 0).toString();
  }
  
  public void setNdEngage(BigDecimal p_ndEngage)
  {
    ndEngage = p_ndEngage;
  }
  
  public BigDecimal getNdIndemnise()
  {
    return ndIndemnise;
  }
  
  public String getNdIndemniseF()
  {
    return ndIndemnise.setScale(2, 0).toString();
  }
  
  public void setNdIndemnise(BigDecimal p_ndIndemnise)
  {
    ndIndemnise = p_ndIndemnise;
  }
  
  public BigDecimal getNdADesengager()
  {
    return ndADesengager;
  }
  
  public String getNdADesengagerF()
  {
    return ndADesengager.setScale(2, 0).toString();
  }
  
  public void setNdADesengager(BigDecimal p_ndADesengager)
  {
    ndADesengager = p_ndADesengager;
  }
  
  public boolean isDeltaApplique()
  {
    return deltaApplique;
  }
  
  public void setDeltaApplique(boolean p_deltaApplique)
  {
    deltaApplique = p_deltaApplique;
  }
  
  public ObjetMetierSpec copie()
  {
    CompteursMobilite copie = new CompteursMobilite();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    CompteursMobilite copie = (CompteursMobilite)p_copie;
    copie.setPlafond(isPlafond());
    copie.setDeltaApplique(isDeltaApplique());
    copie.setCumulAttribue(getCumulAttribue());
    copie.setCumulIndemnise(getCumulIndemnise());
    copie.setDesengagement(getDesengagement());
    copie.setMontantEngage(getMontantEngage());
    copie.setNdADesengager(getNdADesengager());
    copie.setNdEngage(getNdEngage());
    copie.setNdIndemnise(getNdIndemnise());
  }
}

/* Location:
 * Qualified Name:     CompteursMobilite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */