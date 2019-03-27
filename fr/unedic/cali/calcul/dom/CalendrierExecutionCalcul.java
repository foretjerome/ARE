package fr.unedic.cali.calcul.dom;

import fr.unedic.cali.calcul.dom.gen.CalendrierExecutionCalculGen;
import fr.unedic.cali.calcul.dom.periode.DsmTravail;
import fr.unedic.cali.calcul.dom.periode.PeriodeNonDeclareeSanction;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class CalendrierExecutionCalcul
  extends CalendrierExecutionCalculGen
  implements CalendrierExecutionCalculSpec
{
  public static final Map LIB_ETAT_ATTRIBUTION = new HashMap();
  protected transient IndividuSpec m_demandeur;
  
  static
  {
    LIB_ETAT_ATTRIBUTION.put(Integer.valueOf(1), "AVANT EXECUTION");
    LIB_ETAT_ATTRIBUTION.put(Integer.valueOf(2), "PENDANT EXECUTION");
    LIB_ETAT_ATTRIBUTION.put(Integer.valueOf(3), "APRES EXECUTION");
    LIB_ETAT_ATTRIBUTION.put(Integer.valueOf(4), "ABANDONNEE");
    LIB_ETAT_ATTRIBUTION.put(Integer.valueOf(5), "ARRETEE");
    LIB_ETAT_ATTRIBUTION.put(Integer.valueOf(6), "DROIT ETEINT");
  }
  
  public CalendrierExecutionCalcul(DomPCSpec pc)
  {
    super(pc);
  }
  
  public Damj getPremierJourIndemnisable()
  {
    return getDateDebut();
  }
  
  public void setPremierJourIndemnisable(Damj premierJourIndemnisable)
  {
    setDateDebut(premierJourIndemnisable);
  }
  
  public Damj getDernierJourIndemnisable()
  {
    return getDateFin();
  }
  
  public void setDernierJourIndemnisable(Damj dernierJourIndemnisable)
  {
    setDateFin(dernierJourIndemnisable);
  }
  
  public Periode getPeriode()
  {
    return super.getPeriode();
  }
  
  public void setPeriode(Periode periode)
  {
    super.setPeriode(periode);
  }
  
  public void setDateDebut(Damj dateDebut)
  {
    if (dateDebut != null)
    {
      Damj dateFin = getDateFin();
      if (dateFin != null)
      {
        if (dateDebut.estApres(dateFin)) {
          dateFin = dateDebut;
        }
        setPeriode(new Periode(dateDebut, dateFin));
      }
    }
  }
  
  public void setDateFin(Damj dateFin)
  {
    if (dateFin != null)
    {
      Damj dateDebut = getDateDebut();
      if (dateDebut != null)
      {
        if (dateFin.estAvant(dateDebut)) {
          dateDebut = dateFin;
        }
        setPeriode(new Periode(dateDebut, dateFin));
      }
    }
  }
  
  public void copieElements(ObjetMetierSpec pcopie)
  {
    CalendrierExecutionCalcul copie = (CalendrierExecutionCalcul)pcopie;
    copie.setDateDebut(getDateDebut());
    copie.setDateFin(getDateFin());
    m_demandeur = m_demandeur;
    copie.setEtatAttribution(getEtatAttribution());
    copie.setDernierJourIndemnisablePourSuivi(getDernierJourIndemnisablePourSuivi());
    
    copie.remplacerCollectionPNDS(getCollectionPNDS());
    
    copie.remplacerCollectionDNJ(getCollectionDNJ());
    
    copie.setEtatAuDJI(getEtatAuDJI());
  }
  
  public void jdoPreDelete()
  {
    DomManager.supprimer(super.getCollectionDNJ());
    DomManager.supprimer(super.getCollectionPNDS());
    DomManager.supprimer(super.getEtatAuDji());
  }
  
  public void marquerGraphePersistant()
  {
    DomManager.persisterEnProfondeur(super.getEtatAuDji());
    DomManager.persisterEnProfondeur(super.getCollectionPNDS());
    DomManager.persisterEnProfondeur(super.getCollectionDNJ());
  }
  
  public boolean equals(Object object)
  {
    if (!(object instanceof CalendrierExecutionCalcul)) {
      return false;
    }
    CalendrierExecutionCalcul ut = (CalendrierExecutionCalcul)object;
    return this == ut;
  }
  
  public int hashCode()
  {
    return System.identityHashCode(this);
  }
  
  public Collection getListePNDS()
  {
    return super.getCollectionPNDS();
  }
  
  public void ajouterListePNDS(PeriodeNonDeclareeSanction pnds)
  {
    super.ajouterPNDS(pnds);
  }
  
  public Collection getListeDNJ()
  {
    return super.getCollectionDNJ();
  }
  
  public void ajouterListeDNJ(Collection listeDNJ)
  {
    for (Iterator it = listeDNJ.iterator(); it.hasNext();) {
      super.ajouterDNJ((DsmTravail)it.next());
    }
  }
  
  public EtatAuDji getEtatAuDJI()
  {
    return super.getEtatAuDji();
  }
  
  public void setEtatAuDJI(EtatAuDji etatAuDji)
  {
    DomManager.supprimer(super.getEtatAuDji(), etatAuDji);
    super.setEtatAuDji(etatAuDji);
  }
  
  public Damj getDateEpuisementDuree()
  {
    return null;
  }
  
  public CalendrierExecutionCalculPeriodique dupliquerEtatAuDji()
  {
    return null;
  }
  
  public void remplacerCollectionPNDS(Collection collectionACopier)
  {
    for (Iterator i = super.getCollectionPNDS().iterator(); i.hasNext();)
    {
      PeriodeNonDeclareeSanction objet = (PeriodeNonDeclareeSanction)i.next();
      DomManager.supprimer(objet);
    }
    super.remplacerCollectionPNDS(collectionACopier);
  }
  
  public void remplacerCollectionDNJ(Collection collectionACopier)
  {
    for (Iterator i = super.getCollectionDNJ().iterator(); i.hasNext();)
    {
      DsmTravail objet = (DsmTravail)i.next();
      DomManager.supprimer(objet);
    }
    super.remplacerCollectionDNJ(collectionACopier);
  }
  
  public CalendrierExecutionCalcul() {}
  
  public void reinitialiserCalendrier(Damj date) {}
  
  public void jdoPostLoad() {}
  
  public void jdoPreStore() {}
  
  public void jdoPreClear() {}
}

/* Location:
 * Qualified Name:     CalendrierExecutionCalcul
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */