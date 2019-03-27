package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class RevenuAnnualisePans
  extends ObjetChronoPeriode
{
  private static final long serialVersionUID = -7659600172961867490L;
  private BigDecimal m_reel;
  private BigDecimal m_forfaitPerso;
  private BigDecimal m_forfait;
  private Collection m_collectionRevenuPans = null;
  private int m_typeRevenu;
  private static final BigDecimal ZERO = new BigDecimal("0");
  
  public RevenuAnnualisePans(Periode p_periode)
  {
    super(p_periode);
    m_collectionRevenuPans = new ArrayList();
    m_reel = ZERO;
  }
  
  public RevenuAnnualisePans(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
    m_collectionRevenuPans = new ArrayList();
    m_reel = ZERO;
  }
  
  public RevenuAnnualisePans(Damj p_dateDebut, Damj p_dateFin, Collection p_collectionRevenuPans)
  {
    super(p_dateDebut, p_dateFin);
    m_collectionRevenuPans = new ArrayList();
    setCollectionRevenuPans(p_collectionRevenuPans);
    m_reel = ZERO;
  }
  
  public BigDecimal getNbMois()
  {
    BigDecimal nombreMois = new BigDecimal("0");
    ArrayList listePeriodesMoisCivils = getPeriode().decouperEnMoisCivils();
    for (int boucle = 0; boucle < listePeriodesMoisCivils.size(); boucle++)
    {
      Periode periodeMoisCivilCourant = (Periode)listePeriodesMoisCivils.get(boucle);
      if ((!periodeMoisCivilCourant.getDebut().estLeDebutDuMois()) || (!periodeMoisCivilCourant.getFin().estLaFinDuMois()))
      {
        BigDecimal joursActivite = new BigDecimal(periodeMoisCivilCourant.getDuree());
        BigDecimal joursMois = new BigDecimal(Damj.getNbJoursMois(periodeMoisCivilCourant.getDebut().getMois(), periodeMoisCivilCourant.getDebut().getAnnee()));
        
        nombreMois = nombreMois.add(joursActivite.divide(joursMois, 2, 4));
      }
      else
      {
        nombreMois = nombreMois.add(new BigDecimal(1));
      }
    }
    return nombreMois.max(new BigDecimal(1));
  }
  
  public BigDecimal getForfaitPerso()
  {
    return m_forfaitPerso;
  }
  
  public void setForfaitPerso(BigDecimal p_forfaitPerso)
  {
    m_forfaitPerso = p_forfaitPerso;
  }
  
  public BigDecimal getReel()
  {
    return m_reel;
  }
  
  public void setReel(BigDecimal p_reel)
  {
    m_reel = p_reel;
  }
  
  public Collection getCollectionRevenuPans()
  {
    return m_collectionRevenuPans;
  }
  
  public void setCollectionRevenuPans(Collection p_collectionRevenuPans)
  {
    m_collectionRevenuPans = p_collectionRevenuPans;
  }
  
  public ObjetMetierSpec copie()
  {
    return this;
  }
  
  public int getTypeRevenu()
  {
    return m_typeRevenu;
  }
  
  public void setTypeRevenu(int p_typeRevenu)
  {
    m_typeRevenu = p_typeRevenu;
  }
  
  public BigDecimal getForfait()
  {
    return m_forfait;
  }
  
  public void setForfait(BigDecimal p_forfait)
  {
    m_forfait = p_forfait;
  }
  
  public BigDecimal getRemuneration()
  {
    BigDecimal remuneration = ZERO;
    if ((getReel() != null) && (ZERO.compareTo(getReel()) != 0)) {
      remuneration = getReel();
    } else if (getTypeRevenu() == 3)
    {
      if ((getCollectionRevenuPans() != null) && (!getCollectionRevenuPans().isEmpty()))
      {
        Iterator it2 = getCollectionRevenuPans().iterator();
        while (it2.hasNext())
        {
          RevenuPans revenuPans = (RevenuPans)it2.next();
          remuneration = remuneration.add(revenuPans.getMontant());
        }
      }
    }
    else if ((getForfaitPerso() != null) && (getTypeRevenu() == 2)) {
      remuneration = getForfaitPerso();
    } else {
      remuneration = getForfait();
    }
    return remuneration;
  }
}

/* Location:
 * Qualified Name:     RevenuAnnualisePans
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */