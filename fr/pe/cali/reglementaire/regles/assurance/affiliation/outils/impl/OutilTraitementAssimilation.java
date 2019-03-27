package fr.pe.cali.reglementaire.regles.assurance.affiliation.outils.impl;

import fr.pe.cali.reglementaire.regles.assurance.affiliation.dom.PeriodeAssimilee;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.dom.SemaineCivile;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeFormationAssimilable;
import fr.unedic.util.Quantite;
import fr.unedic.util.UniteAffiliation;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class OutilTraitementAssimilation
{
  private static final BigDecimal NUMERATEUR_PLAFOND = BigDecimal.valueOf(2L);
  private static final BigDecimal DENOMINATEUR_PLAFOND = BigDecimal.valueOf(3L);
  private static final BigDecimal COEFFICIENT_JOURS_CALENDAIRES_HEURES = BigDecimal.valueOf(5L);
  private static final BigDecimal COEFFICIENT_HEURE_JOUR_TRAVAILLE = BigDecimal.valueOf(0.142857143D);
  
  public void traiterAssimilation(ConteneurTravailAffiliation conteneur)
  {
    int plafond = determinerPlafondAssimiliation(conteneur.getQuantiteAffiliation());
    int quantiteAssimilee = 0;
    if (!conteneur.isIgnorerAssimiliation())
    {
      Chronologie formationsAssimilables = (Chronologie)conteneur.getPeriodesParticipantes().get(Integer.valueOf(3));
      
      Iterator<PeriodeFormationAssimilable> itformations = formationsAssimilables.iterer();
      
      List<PeriodeAssimilee> listePeriodesAssimilees = new ArrayList();
      while (itformations.hasNext())
      {
        PeriodeFormationAssimilable formationCourante = (PeriodeFormationAssimilable)itformations.next();
        PeriodeAssimilee periodeAssimilee = traiterFormation(formationCourante, conteneur.getPeriodeRecherche(), conteneur.getSemainesCiviles());
        listePeriodesAssimilees.add(periodeAssimilee);
        quantiteAssimilee += periodeAssimilee.getNombreJoursTravailles();
      }
      conteneur.setPeriodesAssimilees(listePeriodesAssimilees);
      quantiteAssimilee = appliquerPlafond(quantiteAssimilee, plafond);
    }
    conteneur.setQuantiteAssimilation(quantiteAssimilee);
    conteneur.setPlafondAssimilation(plafond);
  }
  
  protected int determinerPlafondAssimiliation(int quantiteAffiliation)
  {
    return BigDecimal.valueOf(quantiteAffiliation).multiply(NUMERATEUR_PLAFOND).divide(DENOMINATEUR_PLAFOND, 0, 4).intValue();
  }
  
  protected PeriodeAssimilee traiterFormation(PeriodeFormationAssimilable formation, Periode periodeRecherche, Map<Damj, SemaineCivile> semainesCiviles)
  {
    PeriodeAssimilee periodeAssimilee = new PeriodeAssimilee();
    periodeAssimilee.setPeriode(formation.getPeriode());
    periodeAssimilee.setLibelle(formation.getIntitule());
    BigDecimal heuresInitiales = recupererHeuresInitiales(formation);
    List<Damj> joursAssimables = determinerJourAssimilables(formation.getPeriode(), periodeRecherche, semainesCiviles);
    periodeAssimilee.setListeJoursRetenues(joursAssimables);
    int nombreJoursProrata = joursAssimables.size();
    BigDecimal heuresRetenues = determinerHeuresRetenues(heuresInitiales, formation.getPeriode().getDuree(), nombreJoursProrata);
    int nombreJoursTravaillesRetenues = convertirHeuresEnJoursTravailles(heuresRetenues);
    periodeAssimilee.setHeuresIntiales(heuresInitiales);
    periodeAssimilee.setHeuresRetenues(heuresRetenues);
    periodeAssimilee.setNombreJoursTravailles(nombreJoursTravaillesRetenues);
    return periodeAssimilee;
  }
  
  protected BigDecimal recupererHeuresInitiales(PeriodeFormationAssimilable formation)
  {
    BigDecimal heures;
    BigDecimal heures;
    if (OutilQuantiteAffiliation.getInstance().isQuantiteValide(formation.getDureeTotale())) {
      heures = formation.getDureeTotale().getValeur();
    } else {
      heures = BigDecimal.valueOf(formation.getPeriode().getDuree()).multiply(COEFFICIENT_JOURS_CALENDAIRES_HEURES);
    }
    return heures;
  }
  
  protected List<Damj> determinerJourAssimilables(Periode periodeFormation, Periode periodeRecherche, Map<Damj, SemaineCivile> semainesCiviles)
  {
    Damj dateRecherchee = periodeFormation.getDebut();
    SemaineCivile semaineCourante = null;
    List<Damj> jourAAssimiler = new ArrayList();
    while (dateRecherchee.estAvantOuCoincideAvec(periodeFormation.getFin()))
    {
      if (periodeRecherche.contient(dateRecherchee))
      {
        if ((semaineCourante == null) || (!semaineCourante.getSemaineCivile().contient(dateRecherchee))) {
          semaineCourante = (SemaineCivile)semainesCiviles.get(dateRecherchee.getDebutSemaine());
        }
        if (!semaineCourante.estJourChevauchantActivite(dateRecherchee)) {
          jourAAssimiler.add(dateRecherchee);
        }
      }
      dateRecherchee = dateRecherchee.lendemain();
    }
    return jourAAssimiler;
  }
  
  protected BigDecimal determinerHeuresRetenues(BigDecimal heuresInitiales, int dureeTotale, int dureeProrata)
  {
    Quantite heures = new Quantite(heuresInitiales, UniteAffiliation.HEURE_TRAVAIL);
    
    return OutilQuantiteAffiliation.getInstance().proratiserQuantite(heures, dureeTotale, dureeProrata).getValeur().setScale(2, 4);
  }
  
  protected int convertirHeuresEnJoursTravailles(BigDecimal heures)
  {
    return heures.multiply(COEFFICIENT_HEURE_JOUR_TRAVAILLE).setScale(0, 0).intValue();
  }
  
  protected int appliquerPlafond(int quantiteAssimilee, int plafond)
  {
    return Math.min(quantiteAssimilee, plafond);
  }
}

/* Location:
 * Qualified Name:     OutilTraitementAssimilation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */