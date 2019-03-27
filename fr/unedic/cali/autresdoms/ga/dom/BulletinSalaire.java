package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.List;

public class BulletinSalaire
  extends TravailSalarie
{
  private List m_listeInformationOrigine;
  private BigDecimal m_montantEtt;
  
  public BulletinSalaire(Periode p_periode)
  {
    super(p_periode);
  }
  
  public int getOrigineInformation()
  {
    return 2;
  }
  
  public boolean estQualifiable()
  {
    return false;
  }
  
  public List getListeInformationOrigine()
  {
    return m_listeInformationOrigine;
  }
  
  public void setListeInformationOrigine(List p_listeInformationOrigine)
  {
    m_listeInformationOrigine = p_listeInformationOrigine;
  }
  
  public BigDecimal getMontantEtt()
  {
    return m_montantEtt;
  }
  
  public void setMontantEtt(BigDecimal p_montantEtt)
  {
    m_montantEtt = p_montantEtt;
  }
  
  public int getPrioriteStatut()
  {
    return 3;
  }
}

/* Location:
 * Qualified Name:     BulletinSalaire
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */