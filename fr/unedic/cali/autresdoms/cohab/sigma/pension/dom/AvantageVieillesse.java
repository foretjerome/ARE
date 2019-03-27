package fr.unedic.cali.autresdoms.cohab.sigma.pension.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.pension.dom.spec.AvantageVieillesseSpec;
import fr.unedic.util.QuantiteEuro;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public class AvantageVieillesse
  implements AvantageVieillesseSpec
{
  Damj m_dateDebut = null;
  Damj m_dateFin = null;
  String m_codeNature = null;
  QuantiteEuro m_quantiteEuro = null;
  
  public Damj getDateDebut()
  {
    return m_dateDebut;
  }
  
  public void setDateDebut(Damj p_dateDebut)
  {
    m_dateDebut = (p_dateDebut != null ? new Damj(p_dateDebut) : null);
  }
  
  public Damj getDateFin()
  {
    return m_dateFin;
  }
  
  public void setDateFin(Damj p_dateFin)
  {
    m_dateFin = (p_dateFin != null ? new Damj(p_dateFin) : null);
  }
  
  public String getCodeNature()
  {
    return m_codeNature;
  }
  
  public void setCodeNature(String p_codeNature)
  {
    m_codeNature = p_codeNature;
  }
  
  public QuantiteEuro getMontant()
  {
    return m_quantiteEuro;
  }
  
  public void setMontant(BigDecimal p_montant)
  {
    m_quantiteEuro = (p_montant != null ? new QuantiteEuro(p_montant) : null);
  }
}

/* Location:
 * Qualified Name:     AvantageVieillesse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */