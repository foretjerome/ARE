package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.util.Mathematiques;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;

public class PansMensuel
  extends PeriodeTravailJustifiee
  implements PansSpec
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
  
  protected PansMensuel() {}
  
  public PansMensuel(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public BigDecimal getNombreHeuresProratise()
  {
    return Mathematiques.arrondiASup(new BigDecimal("151").multiply(new BigDecimal(getPeriode().getDuree() / Damj.getNbJoursMois(getDateDebut().getMois(), getDateDebut().getAnnee()))), 2);
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
    PansMensuel copie = new PansMensuel();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    PansMensuel copie = (PansMensuel)p_copie;
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
 * Qualified Name:     PansMensuel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */