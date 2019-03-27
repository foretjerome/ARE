package fr.unedic.cali.autresdoms.cohab.mapping;

import fr.unedic.cali.autresdoms.cohab.dom.DonneesMoisMandate;
import fr.unedic.cali.autresdoms.cohab.dom.IndividuCohabAbstrait;
import fr.unedic.cali.autresdoms.cohab.sigma.evtactualisation.dom.spec.BlocageActuSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.evtactualisation.dom.spec.DonneesEvtActuSpec;
import fr.unedic.cali.calcul.dom.periode.PeriodeAbsenceAuPointage;
import fr.unedic.cali.calcul.dom.periode.PeriodeAbsenceRetourAMS;
import fr.unedic.cali.calcul.dom.periode.PeriodeAbsenceRetourUL961;
import fr.unedic.cali.calcul.dom.periode.PeriodeEvenementBloquant;
import fr.unedic.cali.calcul.dom.periode.PeriodePresenceRetourUL961;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Periode;
import java.util.Collection;
import java.util.Iterator;

public class MapperEvtActualisation
{
  public static void mapper(IndividuCohabAbstrait individu, BlocageActuSpec periodesEvtActualisation)
    throws CoucheLogiqueException
  {
    LireListePeriodeResultatEvtActualisation resultatService = new LireListePeriodeResultatEvtActualisation();
    
    Iterator iterateurCollecAbsencePointage = periodesEvtActualisation.getPeriodesNonPayables().iterator();
    while (iterateurCollecAbsencePointage.hasNext())
    {
      Periode periodeANeutraliser = (Periode)iterateurCollecAbsencePointage.next();
      PeriodeAbsenceAuPointage objetChronoPeriodeANeutraliser = new PeriodeAbsenceAuPointage(periodeANeutraliser.getDebut(), periodeANeutraliser.getFin());
      
      resultatService.ajouterPeriodeEvtActualisation(objetChronoPeriodeANeutraliser);
    }
    if (periodesEvtActualisation.isEvtBloquant())
    {
      PeriodeEvenementBloquant objetChronoPeriodeInterruptive = new PeriodeEvenementBloquant(periodesEvtActualisation.getDateEvtBloquant());
      
      objetChronoPeriodeInterruptive.setLibelleEvtBloquant(mapperLibelle(periodesEvtActualisation.getLibelleEvtBloquant()));
      resultatService.ajouterPeriodeEvtActualisation(objetChronoPeriodeInterruptive);
    }
    Iterator iterateurCollecAbsenceRetourUL961 = periodesEvtActualisation.getPeriodesAbsenceRetourUL961().iterator();
    while (iterateurCollecAbsenceRetourUL961.hasNext())
    {
      Periode periodeAbsenceRetourUL961 = (Periode)iterateurCollecAbsenceRetourUL961.next();
      PeriodeAbsenceRetourUL961 objetChronoPeriodeAbsenceRetourUL961 = new PeriodeAbsenceRetourUL961(periodeAbsenceRetourUL961.getDebut(), periodeAbsenceRetourUL961.getFin());
      
      resultatService.ajouterPeriodeEvtActualisation(objetChronoPeriodeAbsenceRetourUL961);
    }
    Iterator iterateurCollecPresenceRetourUL961 = periodesEvtActualisation.getPeriodesPresenceRetourUL961().iterator();
    while (iterateurCollecPresenceRetourUL961.hasNext())
    {
      Periode periode = (Periode)iterateurCollecPresenceRetourUL961.next();
      PeriodePresenceRetourUL961 periodePresenceRetourUL961 = new PeriodePresenceRetourUL961(periode.getDebut(), periode.getFin());
      resultatService.ajouterPeriodeEvtActualisation(periodePresenceRetourUL961);
    }
    Iterator iteratorRetourAMS = periodesEvtActualisation.getPeriodesAbsenceRetourAMS().iterator();
    while (iteratorRetourAMS.hasNext())
    {
      Periode periodeRetourAMS = (Periode)iteratorRetourAMS.next();
      PeriodeAbsenceRetourAMS periodeAbsenceRetourAMS = new PeriodeAbsenceRetourAMS(periodeRetourAMS.getDebut(), periodeRetourAMS.getFin());
      
      resultatService.ajouterPeriodeEvtActualisation(periodeAbsenceRetourAMS);
    }
    if (periodesEvtActualisation.isEvtBloquant()) {
      resultatService.setDateBlocageActualisation(periodesEvtActualisation.getDateEvtBloquant());
    }
    if (periodesEvtActualisation.getDonneesMoisMandates() != null)
    {
      Iterator iterateurDonneesMoisMandates = periodesEvtActualisation.getDonneesMoisMandates().iterator();
      while (iterateurDonneesMoisMandates.hasNext())
      {
        DonneesEvtActuSpec donneesEvtActu = (DonneesEvtActuSpec)iterateurDonneesMoisMandates.next();
        resultatService.getDonneesMoisActualisation().add(new DonneesMoisMandate(donneesEvtActu));
      }
    }
    individu.setChronoPeriodeEvtActualisation(resultatService.getChronoPeriodesEvtActualisation());
    individu.setDateBlocageActualisation(resultatService.getDateBlocageActualisation());
    individu.setDonneesMoisActualisation(resultatService.getDonneesMoisActualisation());
  }
  
  private static String mapperLibelle(String pLibelle)
    throws CoucheLogiqueException
  {
    String libelle = null;
    if (pLibelle.equals("blocage pour signal. pension d'inval. sur le DSM")) {
      libelle = "blocage pour signal. pension d'inval. sur le DSM";
    } else if (pLibelle.equals("blocage pour signal. pension de retraite sur le DSM")) {
      libelle = "blocage pour signal. pension de retraite sur le DSM";
    } else if (pLibelle.equals("blocage ADE si actu sans déclaration TO")) {
      libelle = "blocage ADE si actu sans déclaration TO";
    } else if (pLibelle.equals("blocage pour arret recherche d'empl. sign. sur le DSM")) {
      libelle = "blocage pour arret recherche d'empl. sign. sur le DSM";
    } else if (pLibelle.equals("blocage pour changement de situation et D.E. en CRP")) {
      libelle = "blocage pour changement de situation et D.E. en CRP";
    } else if (pLibelle.equals("blocage pour signal maternité sans date sur le DSM")) {
      libelle = "blocage pour signal maternité sans date sur le DSM";
    } else if (pLibelle.equals("DSM en multi-déclaration recyclée")) {
      libelle = "DSM en multi-déclaration recyclée";
    } else if (pLibelle.equals("blocage pour motif divers")) {
      libelle = "blocage pour motif divers";
    }
    String libelleSuite = mapperLibelleSuite(pLibelle);
    if (libelleSuite != null) {
      libelle = libelleSuite;
    }
    return libelle;
  }
  
  private static String mapperLibelleSuite(String pLibelle)
    throws CoucheLogiqueException
  {
    String libelle = null;
    if (pLibelle.equals("blocage paiement pour DE migre NCP en renouvellement")) {
      libelle = "blocage paiement pour DE migre NCP en renouvellement";
    } else if (pLibelle.equals("blocage pour signal formation")) {
      libelle = "blocage pour signal formation";
    } else if (pLibelle.equals("Blocage pour actu avec activité déclarée en CTP")) {
      libelle = "Blocage pour actu avec activité déclarée en CTP";
    } else if (pLibelle.equals("Blocage pour actu avec activité déclarée en CTP")) {
      libelle = "Blocage pour actu avec activité déclarée en CTP";
    } else if (pLibelle.equals("blocage pour changement de situation et D.E. en CTP")) {
      libelle = "blocage pour changement de situation et D.E. en CTP";
    } else if (pLibelle.equals("blocage pour D.E. en CTP ayant déclaré du TO")) {
      libelle = "blocage pour D.E. en CTP ayant déclaré du TO";
    } else if (pLibelle.equals("Blocage suite info CNAV décès certifié")) {
      libelle = "Blocage suite info CNAV décès certifié";
    } else if (pLibelle.equals("Blocage suite info CNAV décès présumé")) {
      libelle = "Blocage suite info CNAV décès présumé";
    } else if (pLibelle.equals("Blocage indemnisation pour DE en fin de formation")) {
      libelle = "Blocage indemnisation pour DE en fin de formation";
    }
    return libelle;
  }
}

/* Location:
 * Qualified Name:     MapperEvtActualisation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */