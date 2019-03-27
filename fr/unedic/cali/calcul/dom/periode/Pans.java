package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteNonSalariePeriodique;
import fr.unedic.util.Mathematiques;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Pans
  extends PeriodeTravailJustifiee
  implements PansSpec
{
  private static final long serialVersionUID = -4699437181097728000L;
  public static final int TYPE_REVENU_REEL = 0;
  public static final int TYPE_REVENU_FORFAIT = 1;
  public static final int TYPE_REVENU_FORFAIT_PERSO = 2;
  public static final int TYPE_REVENU_MONTANT_AJUSTE = 3;
  public static final Map LIB_TYPE_REVENU = new HashMap();
  
  static
  {
    LIB_TYPE_REVENU.put(Integer.valueOf(0), "REVENU REEL");
    LIB_TYPE_REVENU.put(Integer.valueOf(1), "REVENU FORFAIT");
    LIB_TYPE_REVENU.put(Integer.valueOf(2), "REVENU FORFAIT PERSO");
    LIB_TYPE_REVENU.put(Integer.valueOf(3), "REVENU MONTANT AJUSTE");
  }
  
  private Damj m_dateAccordACCREDDTE = null;
  private int m_etatAccordACCREDDTE = 0;
  private Periode m_periodeInitiale;
  private int m_typeActivite;
  private Damj m_dateDebutActiviteConservee;
  private int m_revenu = 0;
  private String m_identifiant;
  
  public Pans(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public boolean estForfait()
  {
    if ((getTypeRevenu() == 1) || (getTypeRevenu() == 2)) {
      return true;
    }
    return false;
  }
  
  public int getTypeRevenu()
  {
    return m_revenu;
  }
  
  public void setTypeRevenu(int p_revenu)
  {
    m_revenu = p_revenu;
  }
  
  public BigDecimal getNombreHeuresProratise()
  {
    return Mathematiques.arrondiASup(new BigDecimal("151").multiply(new BigDecimal(getPeriode().getDuree() / Damj.getNbJoursMois(getDateDebut().getMois(), getDateDebut().getAnnee()))), 2);
  }
  
  public int getEtatAccordACCREDDTE()
  {
    return m_etatAccordACCREDDTE;
  }
  
  public void setEtatAccordACCREDDTE(int p_etatAccordACCREDDTE)
  {
    m_etatAccordACCREDDTE = p_etatAccordACCREDDTE;
  }
  
  public Damj getDateAccordACCREDDTE()
  {
    return m_dateAccordACCREDDTE;
  }
  
  public void setDateAccordACCREDDTE(Damj p_dateAccordACCREDDTE)
  {
    m_dateAccordACCREDDTE = p_dateAccordACCREDDTE;
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
    Pans copie = new Pans();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    Pans copie = (Pans)p_copie;
    super.copieElements(copie);
    copie.setDateAccordACCREDDTE(getDateAccordACCREDDTE());
    copie.setEtatAccordACCREDDTE(getEtatAccordACCREDDTE());
    copie.setPeriodeInitiale(getPeriodeInitiale());
    copie.setTypeActivite(getTypeActivite());
    copie.setDateDebutActiviteConservee(getDateDebutActiviteConservee());
    copie.setTypeRevenu(getTypeRevenu());
    copie.setIdentifiant(getIdentifiant());
  }
  
  public void miseAjourDDTE(PeriodeActiviteNonSalariePeriodique p_periodeActivite)
  {
    setDateAccordACCREDDTE(Damj.max(p_periodeActivite.getDateValidationPANS(), p_periodeActivite.getDateDebut()));
    setEtatAccordACCREDDTE(p_periodeActivite.getStatusDDTE());
  }
  
  public Periode getPeriodeInitiale()
  {
    return m_periodeInitiale;
  }
  
  public void setPeriodeInitiale(Periode p_periodeInitiale)
  {
    m_periodeInitiale = p_periodeInitiale;
  }
  
  public String getIdentifiant()
  {
    return m_identifiant;
  }
  
  public void setIdentifiant(String p_identifiant)
  {
    m_identifiant = p_identifiant;
  }
  
  protected Pans() {}
}

/* Location:
 * Qualified Name:     Pans
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */