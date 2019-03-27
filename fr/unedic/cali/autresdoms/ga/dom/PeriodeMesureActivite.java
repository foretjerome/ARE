package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.cali.dom.affectation.Reglement;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.Unite;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class PeriodeMesureActivite
  extends ObjetChronoPeriode
{
  private static final long serialVersionUID = 7740228743766033679L;
  private Hashtable<Unite, Quantite> listeQuantitesAffiliation = new Hashtable();
  private String identifiant;
  private ActiviteSalarie periodeActiviteSalarie;
  private transient boolean presenceHeureComplementaire = false;
  
  public PeriodeMesureActivite() {}
  
  public PeriodeMesureActivite(Damj dateDebut, Damj dateFin)
  {
    super(dateDebut, dateFin);
  }
  
  public PeriodeMesureActivite(Periode periode)
  {
    super(periode);
  }
  
  public Hashtable getListeQuantitesAffiliation()
  {
    return listeQuantitesAffiliation;
  }
  
  public Quantite getQuantiteAffiliation(Unite unite)
  {
    Hashtable listeQuantitesAffiliation = getListeQuantitesAffiliation();
    Quantite retour = (Quantite)listeQuantitesAffiliation.get(unite);
    
    return retour;
  }
  
  public void ajouterQuantiteAffiliation(Quantite quantite)
  {
    if (quantite == null) {
      throw new IllegalArgumentException("La quantité à ajouter ne doit pas être null");
    }
    listeQuantitesAffiliation.put(quantite.getUnite(), quantite);
  }
  
  public void initQuantiteAffiliation()
  {
    Unite jour = Unite.get("jour d'affiliation");
    Unite heure = Unite.get("heure de travail");
    Unite vacation = Unite.get("vacation");
    Unite embarquementAdministratif = Unite.get("embarquement administratif");
    
    Unite cachetIsole = Unite.get("cachet isole");
    Unite cachetGroupe = Unite.get("cachet groupe");
    Quantite qteDureeCalendaireJour = new Quantite(new BigDecimal(getDuree()), jour);
    
    Reglement reglement = null;
    if (periodeActiviteSalarie != null) {
      reglement = periodeActiviteSalarie.getReglement();
    }
    if ((reglement == null) && (listeQuantitesAffiliation.isEmpty())) {
      listeQuantitesAffiliation.put(jour, qteDureeCalendaireJour);
    }
    if ((reglement.estNomReglementIdentique("RG")) || (reglement.estNomReglementIdentique("A6")))
    {
      Quantite qte = (Quantite)listeQuantitesAffiliation.get(jour);
      if (qte == null) {
        listeQuantitesAffiliation.put(jour, qteDureeCalendaireJour);
      }
      qte = (Quantite)listeQuantitesAffiliation.get(heure);
      if (qte == null) {
        listeQuantitesAffiliation.put(heure, new Quantite(0, heure));
      }
    }
    else if (reglement.estNomReglementIdentique("A1"))
    {
      Quantite qte = (Quantite)listeQuantitesAffiliation.get(jour);
      if (qte == null) {
        qte = qteDureeCalendaireJour;
      }
      listeQuantitesAffiliation.clear();
      listeQuantitesAffiliation.put(jour, qte);
    }
    else if (reglement.estNomReglementIdentique("A2a"))
    {
      Quantite qte = (Quantite)listeQuantitesAffiliation.get(embarquementAdministratif);
      if (qte == null) {
        listeQuantitesAffiliation.put(embarquementAdministratif, new Quantite(0, embarquementAdministratif));
      }
      qte = (Quantite)listeQuantitesAffiliation.get(heure);
      if (qte == null) {
        listeQuantitesAffiliation.put(heure, new Quantite(0, heure));
      }
    }
    else if (reglement.estNomReglementIdentique("A2b"))
    {
      Quantite qte = (Quantite)listeQuantitesAffiliation.get(embarquementAdministratif);
      if (qte == null) {
        qte = new Quantite(getDuree(), embarquementAdministratif);
      }
      listeQuantitesAffiliation.clear();
      listeQuantitesAffiliation.put(embarquementAdministratif, qte);
    }
    else if (reglement.estNomReglementIdentique("A3"))
    {
      Quantite qte = (Quantite)listeQuantitesAffiliation.get(vacation);
      listeQuantitesAffiliation.clear();
      if (qte == null) {
        qte = new Quantite(0, vacation);
      }
      listeQuantitesAffiliation.put(vacation, qte);
    }
    else if ((reglement.estNomReglementIdentique("A4")) || (reglement.estNomReglementIdentique("RG5")))
    {
      Quantite qte = (Quantite)listeQuantitesAffiliation.get(heure);
      if (qte == null) {
        qte = new Quantite(0, heure);
      }
      Quantite qteCachetIsole = (Quantite)listeQuantitesAffiliation.get(cachetIsole);
      if (qteCachetIsole == null) {
        qteCachetIsole = new Quantite(0, cachetIsole);
      }
      Quantite qteCachetGroupe = (Quantite)listeQuantitesAffiliation.get(cachetGroupe);
      if (qteCachetGroupe == null) {
        qteCachetGroupe = new Quantite(0, cachetGroupe);
      }
      listeQuantitesAffiliation.clear();
      listeQuantitesAffiliation.put(heure, qte);
      listeQuantitesAffiliation.put(cachetIsole, qteCachetIsole);
      listeQuantitesAffiliation.put(cachetGroupe, qteCachetGroupe);
    }
    else if (reglement.estNomReglementIdentique("A5"))
    {
      Quantite qte = (Quantite)listeQuantitesAffiliation.get(heure);
      if (qte == null) {
        qte = new Quantite(0, heure);
      }
      listeQuantitesAffiliation.clear();
      listeQuantitesAffiliation.put(heure, qte);
    }
    else if (reglement.estNomReglementIdentique("A9B"))
    {
      listeQuantitesAffiliation.clear();
      listeQuantitesAffiliation.put(jour, qteDureeCalendaireJour);
    }
    else if (listeQuantitesAffiliation.isEmpty())
    {
      listeQuantitesAffiliation.put(jour, qteDureeCalendaireJour);
    }
  }
  
  public String getIdentifiant()
  {
    return identifiant;
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    identifiant = pIdentifiant;
  }
  
  public Periode getPeriode()
  {
    return super.getPeriode();
  }
  
  public void setPeriodeActiviteSalarie(ActiviteSalarie periode)
  {
    periodeActiviteSalarie = periode;
  }
  
  public ActiviteSalarie getPeriodeActiviteSalarie()
  {
    return periodeActiviteSalarie;
  }
  
  public ObjetMetierSpec copie()
  {
    PeriodeMesureActivite copiePMA = new PeriodeMesureActivite();
    super.copieElements(copiePMA);
    copieElements(copiePMA);
    return copiePMA;
  }
  
  public void copieElements(ObjetMetierSpec copie)
  {
    PeriodeMesureActivite copiePMA = (PeriodeMesureActivite)copie;
    copiePMA.setIdentifiant(getIdentifiant());
    copiePMA.setPeriodeActiviteSalarie(periodeActiviteSalarie);
    copiePMA.setPriorite(getPriorite());
    copiePMA.setTypeDateEffet(getTypeDateEffet());
    copiePMA.setPresenceHeureComplementaire(isPresenceHeureComplementaire());
    Iterator<?> itKeys = getListeQuantitesAffiliation().keySet().iterator();
    while (itKeys.hasNext())
    {
      Object key = itKeys.next();
      Quantite value = (Quantite)getListeQuantitesAffiliation().get(key);
      copiePMA.ajouterQuantiteAffiliation(value);
    }
  }
  
  public boolean isPresenceHeureComplementaire()
  {
    return presenceHeureComplementaire;
  }
  
  public void setPresenceHeureComplementaire(boolean pPresenceHeureComplementaire)
  {
    presenceHeureComplementaire = pPresenceHeureComplementaire;
  }
}

/* Location:
 * Qualified Name:     PeriodeMesureActivite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */