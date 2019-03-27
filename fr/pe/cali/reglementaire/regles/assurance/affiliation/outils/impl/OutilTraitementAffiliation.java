package fr.pe.cali.reglementaire.regles.assurance.affiliation.outils.impl;

import fr.pe.cali.reglementaire.regles.assurance.affiliation.dom.ElementSemaineCivile;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.dom.SemaineCivile;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.outils.conversion.impl.OutilConversionPmaEnJoursTravailles;
import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.Entreprise;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeMesureActivite;
import fr.unedic.cali.dom.affectation.Reglement;
import fr.unedic.cali.dom.pnds.PeriodeNonDeclareeSanction;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import fr.unedic.util.temps.Temporel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class OutilTraitementAffiliation
{
  private static final int PLAFOND_AFFI_SUR_SEMAINE_CIVILE = 5;
  
  public void calculerAffiliation(ConteneurTravailAffiliation conteneur)
  {
    Chronologie activiteParticipantes = (Chronologie)conteneur.getPeriodesParticipantes().get(Integer.valueOf(1));
    activiteParticipantes.iterer();
    
    List<Damj> listeJoursSanctionnesCourant = new ArrayList();
    conteneur.setListePndsCourantes(listeJoursSanctionnesCourant);
    while (activiteParticipantes.encoreSuivant())
    {
      ActiviteSalarie activiteCourante = (ActiviteSalarie)activiteParticipantes.elementSuivant();
      conteneur.setActiviteCourante(activiteCourante);
      List<Damj> listeJoursTravaillesCourant = determinerJoursTravaillesPourActivite(activiteCourante, conteneur.getPeriodeRecherche());
      if ((!conteneur.isIgnorerPNDS()) && (conteneur.getPnds() != null))
      {
        listeJoursSanctionnesCourant = traiterListePnds((PeriodeNonDeclareeSanction)conteneur.getPnds().get(activiteCourante), conteneur.getPeriodeRecherche());
        conteneur.setListePndsCourantes(listeJoursSanctionnesCourant);
      }
      conteneur.getJoursTravaillesParActivite().put(activiteCourante.getIdentifiant(), listeJoursTravaillesCourant);
      repartirJoursTravaillesEtSanctionnesSurSemaineCivile(listeJoursTravaillesCourant, listeJoursSanctionnesCourant, conteneur.getSemainesCiviles(), activiteCourante);
      getOutilTraitementSuspension().traiterSuspension(conteneur);
    }
    int quantiteAffiliation = consoliderAffiliationSemainesCiviles(conteneur.getSemainesCiviles());
    conteneur.setQuantiteAffiliation(quantiteAffiliation);
  }
  
  protected List<Damj> determinerJoursTravaillesPourActivite(ActiviteSalarie activiteSalarie, Periode periodeRecherche)
  {
    List<Damj> listeJoursTravailles = new ArrayList();
    Chronologie listePMAs = activiteSalarie.getListePeriodesMesureActivite();
    OutilConversionPmaEnJoursTravailles outilConversion = OutilConversionPmaEnJoursTravailles.getInstance();
    listePMAs.iterer();
    while (listePMAs.encoreSuivant())
    {
      PeriodeMesureActivite pma = (PeriodeMesureActivite)listePMAs.elementSuivant();
      listeJoursTravailles.addAll(outilConversion.convertirPma(pma, periodeRecherche));
    }
    return listeJoursTravailles;
  }
  
  protected void repartirJoursTravaillesEtSanctionnesSurSemaineCivile(List<Damj> joursTravailles, List<Damj> joursSanctionnes, Map<Damj, SemaineCivile> semainesCiviles, ActiviteSalarie activite)
  {
    SemaineCivile semaineCourante = null;
    for (Damj jourTravaille : joursTravailles) {
      if (!joursSanctionnes.contains(jourTravaille))
      {
        if ((semaineCourante == null) || (!semaineCourante.getSemaineCivile().contient(jourTravaille))) {
          semaineCourante = (SemaineCivile)semainesCiviles.get(jourTravaille.getDebutSemaine());
        }
        semaineCourante.ajouterJoursTravailles(activite.getIdentifiant(), activite.getEntreprise().getLibelleEntreprise(), activite.getDateDebut(), activite.getDateFin(), activite.getReglement().getNomReglement(), 1, jourTravaille);
      }
    }
    for (Damj jourSanctionne : joursSanctionnes)
    {
      if ((semaineCourante == null) || (!semaineCourante.getSemaineCivile().contient(jourSanctionne))) {
        semaineCourante = (SemaineCivile)semainesCiviles.get(jourSanctionne.getDebutSemaine());
      }
      semaineCourante.ajouterJoursSanctionnes(activite.getIdentifiant(), activite.getEntreprise().getLibelleEntreprise(), activite.getDateDebut(), activite.getDateFin(), activite.getReglement().getNomReglement(), 1, jourSanctionne);
      
      semaineCourante.setEstSanctionne(true);
    }
  }
  
  protected List<Damj> traiterListePnds(PeriodeNonDeclareeSanction pnds, Periode periodeRecherche)
  {
    List<Damj> joursSanctionnes = new ArrayList();
    if ((pnds != null) && (pnds.getChronoPeriodePNDS() != null))
    {
      ChronologiePeriodes listePndsFusionnees = pnds.getChronoPeriodePNDS().fusionnerChevauchementPeriodes();
      Iterator<Temporel> itListePnds = listePndsFusionnees.iterer();
      while (itListePnds.hasNext())
      {
        Temporel pndsCourante = (Temporel)itListePnds.next();
        joursSanctionnes.addAll(traiterPnds(pndsCourante, periodeRecherche));
      }
    }
    return joursSanctionnes;
  }
  
  protected List<Damj> traiterPnds(Temporel pnds, Periode periodeRecherche)
  {
    List<Damj> joursSanctionnes = new ArrayList();
    Damj dateRecherchee = pnds.getDateDebut();
    while (dateRecherchee.estAvantOuCoincideAvec(pnds.getDateFin()))
    {
      if (periodeRecherche.contient(dateRecherchee)) {
        joursSanctionnes.add(dateRecherchee);
      }
      dateRecherchee = dateRecherchee.lendemain();
    }
    return joursSanctionnes;
  }
  
  protected int consoliderAffiliationSemainesCiviles(Map<Damj, SemaineCivile> semainesCiviles)
  {
    int quantiteAffiliation = 0;
    for (SemaineCivile semaineCivile : semainesCiviles.values())
    {
      int nombreJoursEmploi = determinerNombreJourEmploi(semaineCivile);
      int nombreJoursTravailles = determinerNombreJoursTravailles(semaineCivile);
      int nombreJourAffiSemaineCivile = appliquerFormuleAffiliationSurSemaineCivile(nombreJoursTravailles, nombreJoursEmploi);
      semaineCivile.setNombreJoursEmploi(nombreJoursEmploi);
      semaineCivile.setTotalJoursTravailles(nombreJoursTravailles);
      semaineCivile.setQuantiteRetenue(nombreJourAffiSemaineCivile);
      quantiteAffiliation += nombreJourAffiSemaineCivile;
    }
    return quantiteAffiliation;
  }
  
  protected int determinerNombreJourEmploi(SemaineCivile semaineCivile)
  {
    int nbJourEmploi = 0;
    
    Damj dateRecherchee = semaineCivile.getSemaineCivile().getDebut();
    while (dateRecherchee.estAvantOuCoincideAvec(semaineCivile.getSemaineCivile().getFin()))
    {
      if (semaineCivile.estJourEmploi(dateRecherchee)) {
        nbJourEmploi++;
      }
      dateRecherchee = dateRecherchee.lendemain();
    }
    return nbJourEmploi;
  }
  
  protected int determinerNombreJoursTravailles(SemaineCivile semaineCivile)
  {
    int nombreJoursTravaillesTotal = 0;
    List<ElementSemaineCivile> listeElements = semaineCivile.getListeElements();
    for (ElementSemaineCivile elementCouante : listeElements) {
      nombreJoursTravaillesTotal += elementCouante.getNombreJoursTravailles();
    }
    return nombreJoursTravaillesTotal;
  }
  
  protected int appliquerFormuleAffiliationSurSemaineCivile(int nombreJoursTravailles, int nombreJoursEmploi)
  {
    return Math.min(Math.min(nombreJoursEmploi, nombreJoursTravailles), 5);
  }
  
  protected OutilTraitementSuspension getOutilTraitementSuspension()
  {
    return new OutilTraitementSuspension();
  }
}

/* Location:
 * Qualified Name:     OutilTraitementAffiliation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */