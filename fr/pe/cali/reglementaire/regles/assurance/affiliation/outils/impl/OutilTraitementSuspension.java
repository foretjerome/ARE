package fr.pe.cali.reglementaire.regles.assurance.affiliation.outils.impl;

import fr.pe.cali.reglementaire.dom.impl.CriteresFabriqueReglementaire;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.dom.SemaineCivile;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.fabrique.FabriqueCorpsReglePeriodesSuspensionsNonAssimilables;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.outils.spec.IOutilPeriodeNonAssimilable;
import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.Entreprise;
import fr.unedic.cali.autresdoms.ga.dom.spec.IncidentSpec;
import fr.unedic.cali.dom.affectation.ProduitAsuSpec;
import fr.unedic.cali.dom.affectation.Reglement;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreIncident;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltreChevauchePeriode;
import fr.unedic.util.temps.FiltresTemporel;
import fr.unedic.util.temps.Periode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class OutilTraitementSuspension
{
  public void traiterSuspension(ConteneurTravailAffiliation conteneur)
  {
    Chronologie suspensions = recupererPeriodesSuspension(conteneur.getActiviteCourante(), conteneur.getPeriodeRecherche());
    Iterator<?> itSuspension = suspensions.iterer();
    List<Damj> joursDeSuspension = new ArrayList();
    while (itSuspension.hasNext())
    {
      IncidentSpec incident = (IncidentSpec)itSuspension.next();
      if ((conteneur.isAssimilerSuspensionNonAssimilables()) || (recupererOutilPeriodeAssimilable(conteneur.getDateFaitGenerateur(), conteneur.getProduit()).estAssimilable(incident, conteneur.getOutilFonctionnel()))) {
        ajouterSuspension(joursDeSuspension, incident, conteneur.getPeriodeRecherche());
      }
    }
    repartirJoursSuspensionSurSemaineCivile(joursDeSuspension, conteneur.getListePndsCourantes(), conteneur.getSemainesCiviles(), conteneur.getActiviteCourante());
  }
  
  protected Chronologie recupererPeriodesSuspension(ActiviteSalarie activiteSalarie, Periode periodeRecherche)
  {
    FiltresTemporel filtreET = new FiltresTemporel();
    filtreET.ajouterFiltre(new FiltreIncident());
    filtreET.ajouterFiltre(new FiltreChevauchePeriode(periodeRecherche));
    return activiteSalarie.getListePeriodesIncident().copier(filtreET);
  }
  
  protected void ajouterSuspension(List<Damj> joursSuspension, IncidentSpec incident, Periode periodeRecherchee)
  {
    List<Damj> joursAAjouter = new ArrayList();
    Damj dateRecherchee = incident.getDateDebut();
    while ((dateRecherchee.estAvantOuCoincideAvec(incident.getDateFin())) && (dateRecherchee.estAvantOuCoincideAvec(periodeRecherchee.getFin())))
    {
      if ((periodeRecherchee.contient(dateRecherchee)) && (!joursSuspension.contains(dateRecherchee))) {
        joursAAjouter.add(dateRecherchee);
      }
      dateRecherchee = dateRecherchee.lendemain();
    }
    joursSuspension.addAll(joursAAjouter);
  }
  
  protected void repartirJoursSuspensionSurSemaineCivile(List<Damj> joursSuspension, List<Damj> joursSanctionnes, Map<Damj, SemaineCivile> semainesCiviles, ActiviteSalarie activite)
  {
    SemaineCivile semaineCourante = null;
    for (Damj jourSuspension : joursSuspension) {
      if (!joursSanctionnes.contains(jourSuspension))
      {
        if ((semaineCourante == null) || (!semaineCourante.getSemaineCivile().contient(jourSuspension))) {
          semaineCourante = (SemaineCivile)semainesCiviles.get(jourSuspension.getDebutSemaine());
        }
        semaineCourante.ajouterJoursTravailles(activite.getIdentifiant(), activite.getEntreprise().getLibelleEntreprise(), activite.getDateDebut(), activite.getDateFin(), activite.getReglement().getNomReglement(), 2, jourSuspension);
      }
    }
  }
  
  protected IOutilPeriodeNonAssimilable recupererOutilPeriodeAssimilable(Damj dateFaitGenerateur, ProduitAsuSpec produit)
  {
    FabriqueCorpsReglePeriodesSuspensionsNonAssimilables fabrique = FabriqueCorpsReglePeriodesSuspensionsNonAssimilables.getInstance();
    CriteresFabriqueReglementaire criteres = new CriteresFabriqueReglementaire();
    criteres.setCodeProduit(produit.getNomUnique());
    criteres.setDate(dateFaitGenerateur);
    return fabrique.recupererOutilCorpsRegle(criteres);
  }
}

/* Location:
 * Qualified Name:     OutilTraitementSuspension
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */