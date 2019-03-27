package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class PansMensuelNonRemuneree
  extends PeriodeTravailJustifiee
{
  private static final long serialVersionUID = -4699437181097728000L;
  private int m_typeActivite;
  private Damj m_dateDebutActiviteConservee;
  private String m_identifiant;
  private boolean presenceGain;
  
  public boolean isGainsSurPeriodePresent()
  {
    return presenceGain;
  }
  
  public void setGainsSurPeriodePresent(boolean gainsSurPeriodePresent)
  {
    presenceGain = gainsSurPeriodePresent;
  }
  
  protected PansMensuelNonRemuneree() {}
  
  public PansMensuelNonRemuneree(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public int getTypeActivite()
  {
    return m_typeActivite;
  }
  
  public void setTypeActivite(int p_typeActivite)
  {
    m_typeActivite = p_typeActivite;
  }
  
  public Damj getDateDebutActiviteConservee()
  {
    return m_dateDebutActiviteConservee;
  }
  
  public void setDateDebutActiviteConservee(Damj p_dateDebutActiviteConservee)
  {
    m_dateDebutActiviteConservee = p_dateDebutActiviteConservee;
  }
  
  public ObjetMetierSpec copie()
  {
    PansMensuelNonRemuneree copie = new PansMensuelNonRemuneree();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    PansMensuelNonRemuneree copie = (PansMensuelNonRemuneree)p_copie;
    super.copieElements(copie);
    copie.setTypeActivite(getTypeActivite());
    copie.setDateDebutActiviteConservee(getDateDebutActiviteConservee());
    copie.setIdentifiant(getIdentifiant());
    copie.setGainsSurPeriodePresent(isGainsSurPeriodePresent());
  }
  
  public String getIdentifiant()
  {
    return m_identifiant;
  }
  
  public void setIdentifiant(String p_identifiant)
  {
    m_identifiant = p_identifiant;
  }
}

/* Location:
 * Qualified Name:     PansMensuelNonRemuneree
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */