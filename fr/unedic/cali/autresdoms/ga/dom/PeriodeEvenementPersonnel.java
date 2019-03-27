package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.cali.autresdoms.ga.dom.spec.ConflitSpec;
import fr.unedic.cali.autresdoms.ga.dom.spec.DeclareSpec;
import fr.unedic.cali.autresdoms.ga.dom.spec.IncidentSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PeriodeEvenementPersonnel
  extends PeriodeGaec
  implements ConflitSpec, IncidentSpec, DeclareSpec
{
  public static final int INDETERMINE = -1;
  public static final int PERIODE_ARRET_NON_INDEMNISABLE = 0;
  public static final int PERIODE_INDEMNISABLE = 1;
  public static final int PERIODE_INDEMNISATION_IJSS = 2;
  public static final int PERIODE_INDEMNISATION_CAF = 3;
  public static final int CONGE_ADOPTION_MATERNITE = 3;
  private boolean m_enConflit;
  private boolean m_estJustifie;
  private int statutFin;
  private String idContratTravail;
  private boolean estFctPresente;
  private int m_nature;
  private int m_typePep;
  private BigDecimal m_intensite;
  private List m_listeOrigineInformation;
  
  public PeriodeEvenementPersonnel()
  {
    initInstance();
  }
  
  public PeriodeEvenementPersonnel(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
    initInstance();
  }
  
  public PeriodeEvenementPersonnel(Periode p_periode)
  {
    super(p_periode);
    initInstance();
  }
  
  private void initInstance()
  {
    m_listeOrigineInformation = new ArrayList();
    m_intensite = IncidentSpec.TEMPS_PLEIN;
    m_nature = 0;
    m_typePep = -1;
    m_enConflit = false;
    m_estJustifie = false;
    statutFin = 0;
  }
  
  public boolean estEnConflit()
  {
    return m_enConflit;
  }
  
  public void setEnConflit(boolean p_enConflit)
  {
    m_enConflit = p_enConflit;
  }
  
  public boolean estTempsPlein()
  {
    return m_intensite.compareTo(TEMPS_PLEIN) == 0;
  }
  
  public List getListeOrigineInformation()
  {
    return m_listeOrigineInformation != null ? m_listeOrigineInformation : new ArrayList();
  }
  
  public void ajouterOrigineInformation(int p_origineInformation)
  {
    if (m_listeOrigineInformation == null) {
      m_listeOrigineInformation = new ArrayList();
    }
    m_listeOrigineInformation.add(new Integer(p_origineInformation));
  }
  
  public BigDecimal getIntensite()
  {
    return m_intensite;
  }
  
  public void setIntensite(BigDecimal p_decimal)
  {
    m_intensite = p_decimal;
  }
  
  public int getNature()
  {
    return m_nature;
  }
  
  public void setNature(int p_nature)
  {
    m_nature = p_nature;
  }
  
  public int getTypePep()
  {
    return m_typePep;
  }
  
  public void setTypePep(int p_typePep)
  {
    m_typePep = p_typePep;
  }
  
  public boolean estJustifie()
  {
    return m_estJustifie;
  }
  
  public void setEstJustifie(boolean p_estJustifie)
  {
    m_estJustifie = p_estJustifie;
  }
  
  public boolean estPeriodeDisponibilite()
  {
    return (getNature() == 56) || (getNature() == 58);
  }
  
  public boolean estPeriodeSuspensive()
  {
    return (getNature() == 11) || (getNature() == 55);
  }
  
  public int getStatutFin()
  {
    return statutFin;
  }
  
  public void setStatutFin(int statutFin)
  {
    this.statutFin = statutFin;
  }
  
  public String getIdContratTravail()
  {
    return idContratTravail;
  }
  
  public void setIdContratTravail(String idContratTravail)
  {
    this.idContratTravail = idContratTravail;
  }
  
  public boolean estFctPresente()
  {
    return estFctPresente;
  }
  
  public void setEstFctPresente(boolean estFctPresente)
  {
    this.estFctPresente = estFctPresente;
  }
}

/* Location:
 * Qualified Name:     PeriodeEvenementPersonnel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */