package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalculTransient;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.QuantiteEuro;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class PeriodePrime
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 7079429152951313134L;
  public static final int TYPE_EXCEPTIONNELLE = 0;
  public static final int TYPE_NORMALLE = 1;
  public static final int TYPE_ICRS = 2;
  private int m_type;
  private QuantiteEuro m_montant;
  private String m_identifiantEmployeur;
  private transient boolean m_estMigree;
  private int m_typeActivite;
  private String m_identifiant;
  private Periode m_periodeOrigine;
  
  public PeriodePrime(Damj p_dateDebut, Damj p_dateFin, QuantiteEuro p_montant, int p_type, String p_identifiantEmployeur)
  {
    super(p_dateDebut, p_dateFin);
    m_type = p_type;
    m_montant = p_montant;
    m_identifiantEmployeur = p_identifiantEmployeur;
  }
  
  protected PeriodePrime() {}
  
  public Damj getDatePaiement()
  {
    return getDateDebut();
  }
  
  public QuantiteEuro getMontant()
  {
    return m_montant;
  }
  
  public ObjetMetierSpec copie()
  {
    PeriodePrime copie = new PeriodePrime();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    PeriodePrime copie = (PeriodePrime)p_copie;
    
    super.copieElements(p_copie);
    
    m_montant = getMontant();
    m_type = getType();
    m_identifiantEmployeur = getIdentifiantEmployeur();
    m_identifiant = getIdentifiant();
    m_typeActivite = getTypeActivite();
  }
  
  public void setMontant(QuantiteEuro p_montant)
  {
    m_montant = p_montant;
  }
  
  public int getType()
  {
    return m_type;
  }
  
  public void setType(int p_type)
  {
    m_type = p_type;
  }
  
  public String getIdentifiantEmployeur()
  {
    return m_identifiantEmployeur;
  }
  
  public void setIdentifiantEmployeur(String p_identifiantEmployeur)
  {
    m_identifiantEmployeur = p_identifiantEmployeur;
  }
  
  public boolean estMigree()
  {
    return m_estMigree;
  }
  
  public void setEstMigree(boolean p_estMigree)
  {
    m_estMigree = p_estMigree;
  }
  
  public int getTypeActivite()
  {
    return m_typeActivite;
  }
  
  public void setTypeActivite(int p_typeActivite)
  {
    m_typeActivite = p_typeActivite;
  }
  
  public String getIdentifiant()
  {
    return m_identifiant;
  }
  
  public void setIdentifiant(String p_identifiant)
  {
    m_identifiant = p_identifiant;
  }
  
  public Periode getPeriodeOrigine()
  {
    return m_periodeOrigine;
  }
  
  public void setPeriodeOrigine(Periode p_periodeOrigine)
  {
    m_periodeOrigine = p_periodeOrigine;
  }
}

/* Location:
 * Qualified Name:     PeriodePrime
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */