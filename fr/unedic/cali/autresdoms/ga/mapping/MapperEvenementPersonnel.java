package fr.unedic.cali.autresdoms.ga.mapping;

import fr.unedic.cali.autresdoms.ga.dom.Incident;
import fr.unedic.cali.autresdoms.ga.dom.Indemnisation;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeEvenementPersonnel;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeEvenementPersonnelIndemnisable;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeIndemnisationCaf;
import fr.unedic.cali.autresdoms.ga.dom.spec.DeclareSpec;
import fr.unedic.cali.autresdoms.ga.dom.spec.IncidentSpec;
import fr.unedic.cali.parametres.GestionnaireDateApplication;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ChampsPeriodeActivite;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.EvenementPersonnel;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.IndemnisationMaladie;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ListeIndemnisationMaladie;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ListeOrigineInformation;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.OrigineInformation;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.PeriodeActivite;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public final class MapperEvenementPersonnel
{
  private static final String VALEUR_PEP_INDEMNISEE = "2";
  
  static IncidentSpec mapperEvenementPersonnelInterne(EvenementPersonnel evt, ChampsPeriodeActivite champs)
    throws CoucheLogiqueException
  {
    if ((evt.getIndemnisable() != null) && (evt.getIndemnisable().booleanValue()))
    {
      if (evt.getEvenementSecu().booleanValue()) {
        return mapperEvenementSecu(evt, champs);
      }
      if (estEvenementCaf(evt)) {
        return mapperEvenementCaf(evt, champs);
      }
      return mapperIncident(evt, champs);
    }
    return mapperEvenementNonIndemnisable(evt, champs);
  }
  
  static PeriodeEvenementPersonnel mapperEvenementPersonnel(PeriodeActivite periodeGa)
    throws CoucheLogiqueException
  {
    EvenementPersonnel evenementPersonnelGa = periodeGa.getEvenementPersonnel();
    PeriodeEvenementPersonnel periodeCali = null;
    ChampsPeriodeActivite champs = periodeGa.getChampsPeriodeActivite();
    if (evenementPersonnelGa.getIndemnisable().booleanValue()) {
      periodeCali = mapperEvenementIndemnisable(evenementPersonnelGa, champs);
    } else {
      periodeCali = mapperEvenementNonIndemnisable(evenementPersonnelGa, champs);
    }
    if (periodeCali != null) {
      definitionEtatJustifiePepHorsContrat(periodeCali, periodeGa.getChampsPeriodeActivite().getListeOrigineInformation());
    }
    return periodeCali;
  }
  
  private static void definitionEtatJustifiePepHorsContrat(DeclareSpec periodeCali, ListeOrigineInformation listeOrigineInformation)
  {
    boolean justifie = false;
    if (listeOrigineInformation != null)
    {
      int i = 0;
      while ((i < listeOrigineInformation.getNbListOrigineInformation()) && (!justifie))
      {
        int code = listeOrigineInformation.getListeOrigineInformation(i).getCodeOrigineInformation().intValue();
        i++;
        switch (code)
        {
        case 1: 
        case 12: 
        case 40: 
        case 41: 
        case 42: 
        case 43: 
        case 44: 
        case 45: 
        case 46: 
          justifie = true;
        }
      }
    }
    periodeCali.setEstJustifie(justifie);
  }
  
  private static void definitionEtatJustifiePepEvtSecu(DeclareSpec periodeCali, ListeOrigineInformation listeOrigineInformation)
  {
    boolean justifie = false;
    if (listeOrigineInformation != null)
    {
      int i = 0;
      while ((i < listeOrigineInformation.getNbListOrigineInformation()) && (!justifie))
      {
        int code = listeOrigineInformation.getListeOrigineInformation(i).getCodeOrigineInformation().intValue();
        i++;
        switch (code)
        {
        case 22: 
        case 23: 
        case 24: 
        case 25: 
          justifie = true;
        }
      }
    }
    periodeCali.setEstJustifie(justifie);
  }
  
  private static PeriodeEvenementPersonnel mapperEvenementIndemnisable(EvenementPersonnel evtPersonnelGa, ChampsPeriodeActivite champs)
    throws CoucheLogiqueException
  {
    PeriodeEvenementPersonnel periodeCali = null;
    if (evtPersonnelGa.getEvenementSecu().booleanValue()) {
      periodeCali = mapperEvenementSecu(evtPersonnelGa, champs);
    } else if (estEvenementCaf(evtPersonnelGa)) {
      periodeCali = mapperEvenementCaf(evtPersonnelGa, champs);
    }
    return periodeCali;
  }
  
  private static PeriodeEvenementPersonnel mapperEvenementNonIndemnisable(EvenementPersonnel evt, ChampsPeriodeActivite champs)
  {
    PeriodeEvenementPersonnel periodeArretNonIndemnisable = new PeriodeEvenementPersonnel();
    periodeArretNonIndemnisable.setTypePep(0);
    mapperElementsPeriode(periodeArretNonIndemnisable, evt, champs);
    mapperOriginesInfo(champs.getListeOrigineInformation(), periodeArretNonIndemnisable);
    return periodeArretNonIndemnisable;
  }
  
  private static PeriodeIndemnisationCaf mapperEvenementCaf(EvenementPersonnel evtPersonnelGa, ChampsPeriodeActivite champs)
    throws CoucheLogiqueException
  {
    PeriodeIndemnisationCaf periodeIndemnisationCaf = new PeriodeIndemnisationCaf();
    periodeIndemnisationCaf.setDateConnaissanceInfo(champs.getDateConnaissanceInfo());
    
    mapperElementsPeriodeIndemnisation(evtPersonnelGa, champs, periodeIndemnisationCaf);
    mapperElementsPeriode(periodeIndemnisationCaf, evtPersonnelGa, champs);
    
    mapperOriginesInfo(champs.getListeOrigineInformation(), periodeIndemnisationCaf);
    
    periodeIndemnisationCaf.setNatureAllocation(Integer.parseInt(evtPersonnelGa.getNatureAllocation()));
    return periodeIndemnisationCaf;
  }
  
  private static PeriodeEvenementPersonnelIndemnisable mapperEvenementSecu(EvenementPersonnel evtPersonnelGa, ChampsPeriodeActivite champs)
    throws CoucheLogiqueException
  {
    PeriodeEvenementPersonnelIndemnisable periodeCali = new PeriodeEvenementPersonnelIndemnisable();
    periodeCali.setDateConnaissanceInfo(champs.getDateConnaissanceInfo());
    switch (Integer.parseInt(evtPersonnelGa.getNature()))
    {
    case 25: 
    case 26: 
      periodeCali.setTypePep(3);
      break;
    default: 
      periodeCali.setTypePep(2);
    }
    if (evtPersonnelGa.getBArticleD3221() != null) {
      periodeCali.setMaladieGrave(evtPersonnelGa.getBArticleD3221().booleanValue());
    }
    mapperPeriodeIndemnisable(evtPersonnelGa, champs, periodeCali);
    
    definitionEtatJustifiePepEvtSecu(periodeCali, champs.getListeOrigineInformation());
    return periodeCali;
  }
  
  private static PeriodeEvenementPersonnel mapperPeriodeIndemnisable(EvenementPersonnel evtPersonnelGa, ChampsPeriodeActivite champs, PeriodeEvenementPersonnelIndemnisable periodeindemnisable)
    throws CoucheLogiqueException
  {
    mapperElementsPeriodeIndemnisation(evtPersonnelGa, champs, periodeindemnisable);
    mapperElementsPeriode(periodeindemnisable, evtPersonnelGa, champs);
    
    mapperOriginesInfo(champs.getListeOrigineInformation(), periodeindemnisable);
    
    return periodeindemnisable;
  }
  
  private static void mapperElementsPeriodeIndemnisation(EvenementPersonnel evtPersonnelGa, ChampsPeriodeActivite champs, PeriodeEvenementPersonnelIndemnisable periodeindemnisable)
    throws CoucheLogiqueException
  {
    Damj dateMEP16SI4 = GestionnaireDateApplication.getInstance().recupererDateApplication("Date de la MEP 16SI4");
    
    Damj dateConnaissanceInfo = periodeindemnisable.getDateConnaissanceInfo();
    if ((dateConnaissanceInfo != null) && (dateConnaissanceInfo.estAvant(dateMEP16SI4))) {
      mapperElementsPeriodeIndemnisationAvantMep16SI4(periodeindemnisable, champs);
    } else {
      mapperElementsPeriodeIndemnisation(periodeindemnisable, evtPersonnelGa);
    }
  }
  
  private static void mapperElementsPeriodeIndemnisation(PeriodeEvenementPersonnelIndemnisable periodeArret, EvenementPersonnel evtPersonnelGa)
    throws CoucheLogiqueException
  {
    ListeIndemnisationMaladie listeIndemnisationMaladie = evtPersonnelGa.getListeIndemnisationMaladie();
    if (listeIndemnisationMaladie != null)
    {
      int nbIndemnisationMaladie = listeIndemnisationMaladie.getNbListIndemnisationMaladie();
      for (int i = 0; i < nbIndemnisationMaladie; i++)
      {
        IndemnisationMaladie indemnisationGa = listeIndemnisationMaladie.getListeIndemnisationMaladie(i);
        Indemnisation indemnisationCali = creerPeriodeIndemnisation(indemnisationGa, periodeArret.getDateConnaissanceInfo());
        periodeArret.ajouter(indemnisationCali);
      }
    }
  }
  
  private static void mapperElementsPeriodeIndemnisationAvantMep16SI4(PeriodeEvenementPersonnelIndemnisable periodeArret, ChampsPeriodeActivite champs)
  {
    Damj debut = champs.getDateDebut();
    Damj fin = champs.getDateFin();
    
    Indemnisation indemnisationCali = new Indemnisation(FabriquePeriode.creer(debut, fin));
    indemnisationCali.setEstIndemnise(true);
    
    periodeArret.ajouter(indemnisationCali);
  }
  
  private static Indemnisation creerPeriodeIndemnisation(IndemnisationMaladie indemnisationGa, Damj dateConnaissanceInfo)
    throws CoucheLogiqueException
  {
    Damj debut = indemnisationGa.getDateDebutIndemnisation();
    Damj fin = indemnisationGa.getDateFinIndemnisation();
    
    Indemnisation indemnisationCali = new Indemnisation(FabriquePeriode.creer(debut, fin));
    indemnisationCali.setMontantIndemnisation(indemnisationGa.getMontant());
    
    boolean estIndemnise = estIndemnise(indemnisationGa.getIndemnisation(), dateConnaissanceInfo);
    indemnisationCali.setEstIndemnise(estIndemnise);
    
    return indemnisationCali;
  }
  
  protected static boolean estIndemnise(String indemnisation, Damj dateConnaissanceInfo)
    throws CoucheLogiqueException
  {
    boolean estIndemnise = false;
    
    Damj dateMEP16SI4 = GestionnaireDateApplication.getInstance().recupererDateApplication("Date de la MEP 16SI4");
    if ((indemnisation != null) && (!indemnisation.isEmpty()))
    {
      if (indemnisation.equals("2")) {
        estIndemnise = true;
      }
    }
    else if ((dateConnaissanceInfo != null) && (dateConnaissanceInfo.estAvant(dateMEP16SI4))) {
      estIndemnise = true;
    }
    return estIndemnise;
  }
  
  private static Incident mapperIncident(EvenementPersonnel evtPersonnelGa, ChampsPeriodeActivite champs)
  {
    Incident incident = new Incident();
    incident.setNature(Integer.parseInt(evtPersonnelGa.getNature()));
    incident.setDateDebut(champs.getDateDebut());
    incident.setDateFin(champs.getDateFin());
    incident.setIntensite(CodeGa.valueOf(evtPersonnelGa.getIntensite()));
    
    mapperOriginesInfo(champs.getListeOrigineInformation(), incident);
    return incident;
  }
  
  private static boolean estEvenementCaf(EvenementPersonnel evtPersonnelGa)
  {
    switch (Integer.parseInt(evtPersonnelGa.getNature()))
    {
    case 32: 
    case 33: 
      return true;
    }
    return false;
  }
  
  private static void mapperOriginesInfo(ListeOrigineInformation listeOrginesInfoGa, IncidentSpec periodeCali)
  {
    if (listeOrginesInfoGa != null) {
      for (int i = 0; i < listeOrginesInfoGa.getNbListOrigineInformation(); i++)
      {
        BigDecimal origineInfo = listeOrginesInfoGa.getListeOrigineInformation(i).getCodeOrigineInformation();
        if (origineInfo != null) {
          periodeCali.ajouterOrigineInformation(origineInfo.intValue());
        }
      }
    }
  }
  
  private static void mapperElementsPeriode(PeriodeEvenementPersonnel periodeArret, EvenementPersonnel evtPersonnelGa, ChampsPeriodeActivite champs)
  {
    periodeArret.setNature(Integer.parseInt(evtPersonnelGa.getNature()));
    periodeArret.setIntensite(CodeGa.valueOf(evtPersonnelGa.getIntensite()));
    periodeArret.setDateDebut(champs.getDateDebut());
    periodeArret.setIdContratTravail(evtPersonnelGa.getIdContratTravail());
    if (evtPersonnelGa.getStatutFin() != null) {
      periodeArret.setStatutFin(evtPersonnelGa.getStatutFin().intValue());
    }
    if (champs.getDateFin() != null) {
      periodeArret.setDateFin(champs.getDateFin());
    } else {
      periodeArret.setDateFin(Damj.FIN_DES_TEMPS);
    }
    periodeArret.setIdentifiant(champs.getIdPeriodeActivite());
  }
}

/* Location:
 * Qualified Name:     MapperEvenementPersonnel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */