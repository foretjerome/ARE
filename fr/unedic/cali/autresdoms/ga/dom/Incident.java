package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.cali.autresdoms.ga.dom.spec.AppartenanceSpec;
import fr.unedic.cali.autresdoms.ga.dom.spec.IncidentSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.Unite;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Incident
  extends ObjetChronoPeriode
  implements IncidentSpec, AppartenanceSpec
{
  public static final BigDecimal TEMPS_PLEIN = new BigDecimal("1");
  private BigDecimal m_intensite;
  private int m_nature;
  private List m_listeOrigineInformation;
  
  public Incident() {}
  
  public Incident(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public Incident(Periode p_periode)
  {
    super(p_periode);
  }
  
  public Hashtable getListeQuantitesAppartenance()
  {
    Hashtable hashtable = new Hashtable();
    Unite jour = Unite.get("jour d'affiliation");
    Quantite quantite = new Quantite(String.valueOf(getDuree()), jour);
    hashtable.put(jour, quantite);
    return hashtable;
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
  
  public boolean estTempsPlein()
  {
    return m_intensite.equals(TEMPS_PLEIN);
  }
  
  public String toString()
  {
    StringBuffer sb = new StringBuffer();
    sb.append("Incident, Période : ");
    sb.append(getPeriode());
    sb.append(" - ");
    sb.append("Intensité : ");
    sb.append(getIntensite());
    sb.append(" - ");
    sb.append("Nature (Ga) : ");
    sb.append(getNature());
    sb.append(" - ");
    sb.append("Origine info : ");
    sb.append(getListeOrigineInformation());
    return sb.toString();
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
    m_listeOrigineInformation.add(Integer.valueOf(p_origineInformation));
  }
  
  public ObjetMetierSpec copie()
  {
    return this;
  }
  
  public void copieElements(ObjetMetierSpec p_copie) {}
  
  public boolean estSanctionne()
  {
    return false;
  }
  
  public int getNatureAppartenance()
  {
    return 0;
  }
  
  public boolean isDerogationPlafondMensuel()
  {
    return false;
  }
  
  public boolean produitAppartenance()
  {
    return true;
  }
  
  public Periode getPeriode()
  {
    return super.getPeriode();
  }
}

/* Location:
 * Qualified Name:     Incident
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */