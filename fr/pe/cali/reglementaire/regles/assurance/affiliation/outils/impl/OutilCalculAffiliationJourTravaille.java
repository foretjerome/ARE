package fr.pe.cali.reglementaire.regles.assurance.affiliation.outils.impl;

import fr.pe.cali.reglementaire.dom.impl.CriteresFabriqueReglementaire;
import fr.pe.cali.reglementaire.outils.spec.IOutilCorpsRegle;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.dom.DonneesEntreeCalculAffiliationJoursTravailles;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.dom.ResultatCalculAffiliationJoursTravailles;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.dom.SemaineCivile;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.outils.spec.IOutilCalculAffiliationJoursTravailles;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.outils.spec.IOutilFonctionnelAffiliationJoursTravailles;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutilCalculAffiliationJourTravaille
  implements IOutilCalculAffiliationJoursTravailles
{
  private static final String NOM_OUTIL = "OutilCalculAffiJoursTravaillesConvention2017";
  
  public boolean estApplicablePourCriteres(CriteresFabriqueReglementaire criteres)
  {
    return true;
  }
  
  public IOutilCorpsRegle creerNouvelleInstance()
  {
    return new OutilCalculAffiliationJourTravaille();
  }
  
  public String getNomOutil()
  {
    return "OutilCalculAffiJoursTravaillesConvention2017";
  }
  
  public ResultatCalculAffiliationJoursTravailles calculer(DonneesEntreeCalculAffiliationJoursTravailles donneesEntree)
  {
    ResultatCalculAffiliationJoursTravailles resultat = new ResultatCalculAffiliationJoursTravailles();
    
    ConteneurTravailAffiliation conteneur = new ConteneurTravailAffiliation(donneesEntree);
    conteneur.setSemainesCiviles(initialiserSemaineCivile(conteneur.getPeriodeRecherche()));
    conteneur.setPeriodesParticipantes(determinerActivitesParticipantes(donneesEntree, resultat));
    
    getOutilAffiliation().calculerAffiliation(conteneur);
    resultat.setNombreJoursAffiliation(conteneur.getQuantiteAffiliation());
    
    getOutilAssimilation().traiterAssimilation(conteneur);
    resultat.setNombreJoursAssimilation(conteneur.getQuantiteAssimilation());
    
    resultat.setNombreJoursAppartenance(resultat.getNombreJoursAffiliation() + resultat.getNombreJoursAssimilation());
    
    Chronologie chronologieActiviteParticipantes = new ChronologiePeriodes();
    chronologieActiviteParticipantes.ajouter((Chronologie)conteneur.getPeriodesParticipantes().get(Integer.valueOf(1)));
    chronologieActiviteParticipantes.ajouter((Chronologie)conteneur.getPeriodesParticipantes().get(Integer.valueOf(3)));
    resultat.setActiviteParticipantes(chronologieActiviteParticipantes);
    resultat.setJustificationRepartitionJoursTravailles(conteneur.getJoursTravaillesParActivite());
    resultat.setJustificationSemaineCivile(convertirEnListeTrieeEtFiltree(conteneur.getSemainesCiviles()));
    resultat.setPeriodeRecherche(conteneur.getPeriodeRecherche());
    resultat.setPlafondAssimilation(conteneur.getPlafondAssimilation());
    resultat.setPeriodesAssimilees(conteneur.getPeriodesAssimilees());
    return resultat;
  }
  
  protected Map<Integer, Chronologie> determinerActivitesParticipantes(DonneesEntreeCalculAffiliationJoursTravailles donneesEntree, ResultatCalculAffiliationJoursTravailles resultat)
  {
    return donneesEntree.getOutilFonctionnel().determinerChronologieActivitesParticipantes(donneesEntree.getPasseProfessionnel(), resultat, donneesEntree.getListeContexte(), donneesEntree.getPeriodeRecherche(), donneesEntree.getDateExamen());
  }
  
  protected Map<Damj, SemaineCivile> initialiserSemaineCivile(Periode periodeRecherche)
  {
    Map<Damj, SemaineCivile> semainesCivile = new HashMap();
    if (periodeRecherche.getDebut().getDebutSemaine().coincideAvec(periodeRecherche.getFin().getDebutSemaine()))
    {
      SemaineCivile semaineCivile = new SemaineCivile(periodeRecherche.getDebut(), periodeRecherche.getFin());
      semainesCivile.put(semaineCivile.getSemaineCivile().getDebut().getDebutSemaine(), semaineCivile);
    }
    else
    {
      Damj dateDebutPeriode = periodeRecherche.getDebut();
      Damj dateFinPeriode = dateDebutPeriode.getFinSemaine();
      while (dateFinPeriode.estAvantOuCoincideAvec(periodeRecherche.getFin()))
      {
        semainesCivile.put(dateDebutPeriode.getDebutSemaine(), new SemaineCivile(dateDebutPeriode, dateFinPeriode));
        
        dateDebutPeriode = dateFinPeriode.lendemain();
        dateFinPeriode = dateDebutPeriode.getFinSemaine();
      }
      if (periodeRecherche.chevauche(new Periode(dateDebutPeriode, dateFinPeriode))) {
        semainesCivile.put(dateDebutPeriode.getDebutSemaine(), new SemaineCivile(dateDebutPeriode, periodeRecherche.getFin()));
      }
    }
    return semainesCivile;
  }
  
  protected List<SemaineCivile> convertirEnListeTrieeEtFiltree(Map<Damj, SemaineCivile> mapSemaines)
  {
    List<SemaineCivile> listeARetourner = new ArrayList();
    for (SemaineCivile semaineCivile : mapSemaines.values()) {
      if (!semaineCivile.getListeElements().isEmpty()) {
        listeARetourner.add(semaineCivile);
      }
    }
    Collections.sort(listeARetourner, new ComparateurSemaineCivile());
    return listeARetourner;
  }
  
  protected OutilTraitementAffiliation getOutilAffiliation()
  {
    return new OutilTraitementAffiliation();
  }
  
  protected OutilTraitementAssimilation getOutilAssimilation()
  {
    return new OutilTraitementAssimilation();
  }
}

/* Location:
 * Qualified Name:     OutilCalculAffiliationJourTravaille
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */