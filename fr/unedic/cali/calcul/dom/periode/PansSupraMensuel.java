package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.util.Mathematiques;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;

public class PansSupraMensuel
  extends PeriodeTravailJustifiee
  implements PansSpec
{
  private static final long serialVersionUID = -4699437181097728000L;
  private int m_typeActivite;
  private Damj m_dateDebutActiviteConservee;
  private Damj dateEcheanceJustificationRevenu;
  private boolean presenceGain;
  private String m_identifiant;
  
  public boolean isGainsSurPeriodePresent()
  {
    return presenceGain;
  }
  
  public void setGainsSurPeriodePresent(boolean presenceGain)
  {
    this.presenceGain = presenceGain;
  }
  
  public Damj getDateEcheanceJustificationRevenu()
  {
    return dateEcheanceJustificationRevenu;
  }
  
  public void setDateEcheanceJustificationRevenu(Damj dateEcheanceJustificationRevenu)
  {
    this.dateEcheanceJustificationRevenu = dateEcheanceJustificationRevenu;
  }
  
  protected PansSupraMensuel() {}
  
  public PansSupraMensuel(Damj p_dateDebut, Damj p_dateFin)
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
    PansSupraMensuel copie = new PansSupraMensuel();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    PansSupraMensuel copie = (PansSupraMensuel)p_copie;
    super.copieElements(copie);
    copie.setTypeActivite(getTypeActivite());
    copie.setDateDebutActiviteConservee(getDateDebutActiviteConservee());
    copie.setIdentifiant(getIdentifiant());
    copie.setGainsSurPeriodePresent(isGainsSurPeriodePresent());
    copie.setDateEcheanceJustificationRevenu(getDateEcheanceJustificationRevenu());
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
 * Qualified Name:     PansSupraMensuel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */