package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.cali.autresdoms.ga.dom.spec.AppartenanceSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.UniteAffiliation;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.Hashtable;

public class PeriodeFormationAssimilable
  extends PeriodeFormation
  implements AppartenanceSpec
{
  boolean m_imputableSurDuree = false;
  
  public PeriodeFormationAssimilable() {}
  
  public PeriodeFormationAssimilable(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public PeriodeFormationAssimilable(Periode p_periode)
  {
    super(p_periode);
  }
  
  public int getNatureAppartenance()
  {
    return 1;
  }
  
  public Hashtable getListeQuantitesAppartenance()
  {
    Hashtable hashtable = new Hashtable();
    if (getDureeTotale() != null) {
      hashtable.put(UniteAffiliation.HEURE_TRAVAIL, new Quantite(getDureeTotale().getValeur(), UniteAffiliation.HEURE_TRAVAIL));
    } else {
      hashtable.put(UniteAffiliation.HEURE_TRAVAIL, new Quantite("0", UniteAffiliation.HEURE_TRAVAIL));
    }
    return hashtable;
  }
  
  public String toString()
  {
    StringBuffer sb = new StringBuffer();
    sb.append("Période formation assimilable");
    sb.append("Période : ");
    sb.append(getPeriode());
    sb.append(" - ");
    sb.append("Durée totale (heures) : ");
    sb.append(getDureeTotale());
    sb.append("organisme formation : ");
    sb.append(getNomOrganismeFormation());
    sb.append("origine rémunération : ");
    sb.append(getOrigineRemuneration());
    return sb.toString();
  }
  
  public boolean produitAppartenance()
  {
    return true;
  }
  
  public boolean isDerogationPlafondMensuel()
  {
    return false;
  }
  
  public boolean estSanctionne()
  {
    return false;
  }
  
  public boolean estImputableSurDuree()
  {
    return m_imputableSurDuree;
  }
  
  public void setImputableSurDuree(boolean p_imputableSurDuree)
  {
    m_imputableSurDuree = p_imputableSurDuree;
  }
}

/* Location:
 * Qualified Name:     PeriodeFormationAssimilable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */