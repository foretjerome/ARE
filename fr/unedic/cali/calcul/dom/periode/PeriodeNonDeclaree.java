package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.cali.autresdoms.ga.dom.spec.PeriodeGaecSpec;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalculTransient;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class PeriodeNonDeclaree
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 2681674199723494698L;
  PeriodeNonDeclareeSanction m_periodeNonDeclareeSanction = null;
  boolean m_estSanctionnable;
  PeriodeGaecSpec activite;
  
  public PeriodeGaecSpec getActivite()
  {
    return activite;
  }
  
  public void setActivite(PeriodeGaecSpec activite)
  {
    this.activite = activite;
  }
  
  protected PeriodeNonDeclaree() {}
  
  public PeriodeNonDeclaree(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public PeriodeNonDeclareeSanction getPeriodeNonDeclareeSanction()
  {
    return m_periodeNonDeclareeSanction;
  }
  
  public void setPeriodeNonDeclareeSanction(PeriodeNonDeclareeSanction p_periodeNonDeclareeSanction)
  {
    m_periodeNonDeclareeSanction = p_periodeNonDeclareeSanction;
  }
  
  public boolean estSanctionnable()
  {
    return m_estSanctionnable;
  }
  
  public void setEstSanctionnable(boolean p_estSanctionnable)
  {
    m_estSanctionnable = p_estSanctionnable;
  }
  
  public ObjetMetierSpec copie()
  {
    PeriodeNonDeclaree copie = new PeriodeNonDeclaree();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    PeriodeNonDeclaree copie = (PeriodeNonDeclaree)p_copie;
    
    super.copieElements(copie);
    if (getPeriodeNonDeclareeSanction() != null) {
      m_periodeNonDeclareeSanction = ((PeriodeNonDeclareeSanction)getPeriodeNonDeclareeSanction().copie());
    }
    m_estSanctionnable = estSanctionnable();
  }
}

/* Location:
 * Qualified Name:     PeriodeNonDeclaree
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */