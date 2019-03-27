package fr.unedic.cali.autresdoms.ga.mapping;

import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeGaec;
import fr.unedic.cali.fabriques.FabriqueStrategieTypeConventionAfpeOuAfpr;
import fr.unedic.cali.outilsfonctionnels.OutilActionFormationJeune;
import fr.unedic.cali.outilsfonctionnels.strategies.CritereStrategie;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieTypeConventionAfpeOuAfprSpec;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ChampsPeriodeActivite;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ListePeriodeFormation;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ListePeriodesAbsenceFormation;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.PeriodeAbsenceFormation;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.PeriodeActivite;
import fr.unedic.util.Quantite;
import fr.unedic.util.Unite;
import fr.unedic.util.UniteAffiliation;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;

class MapperActionFormation
{
  static fr.unedic.cali.autresdoms.ga.dom.ActionFormation mapper(PeriodeActivite periodeActiviteGa)
    throws CoucheLogiqueException
  {
    fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ActionFormation actionFormationGa = periodeActiviteGa.getActionFormation();
    
    Periode periode = new Periode(periodeActiviteGa.getChampsPeriodeActivite().getDateDebut(), periodeActiviteGa.getChampsPeriodeActivite().getDateFin());
    
    fr.unedic.cali.autresdoms.ga.dom.ActionFormation actionFormationCali = new fr.unedic.cali.autresdoms.ga.dom.ActionFormation(periode);
    
    Unite heures = UniteAffiliation.HEURE_TRAVAIL;
    Quantite qteTotale = new Quantite(actionFormationGa.getQuantiteHoraireTotal(), heures);
    Quantite qteHebdo = new Quantite(actionFormationGa.getQuantiteHoraireHebdo(), heures);
    
    int typeConventionCali = convertirTypeConvention(actionFormationGa.getTypeConvention(), actionFormationGa.getDatePrescription(), actionFormationGa.getNumeroConvention());
    
    actionFormationCali.setIdentifiant(periodeActiviteGa.getChampsPeriodeActivite().getIdPeriodeActivite());
    actionFormationCali.setNomOrganismeFormation(actionFormationGa.getLibelleOrganisme());
    actionFormationCali.setNumeroConvention(actionFormationGa.getNumeroConvention());
    actionFormationCali.setLibelleLieu(actionFormationGa.getLibelleLieu());
    actionFormationCali.setDureeTotale(qteTotale);
    actionFormationCali.setQuantiteHoraireHebdo(qteHebdo);
    actionFormationCali.setTypeConvention(typeConventionCali);
    actionFormationCali.setTypePlanFormation(actionFormationGa.getTypeFormation());
    actionFormationCali.setStatut(actionFormationGa.getEtatFormation());
    actionFormationCali.setMontantPlafondPriseEnCharge(actionFormationGa.getPlafondConvention());
    actionFormationCali.setPourcentagePriseEnCharge(CodeGa.valueOf(actionFormationGa.getPourentageEngage()));
    actionFormationCali.setIdentifiantConvention(actionFormationGa.getIdentifiantConvention());
    actionFormationCali.setDatePrescription(actionFormationGa.getDatePrescription());
    actionFormationCali.setOrigineSaisieFormation(actionFormationGa.getOrigineSaisieFormation());
    
    actionFormationCali.setCategorieFinancement(actionFormationGa.getCategorieFinancement());
    if (actionFormationGa.getAffDerogatoire() != null)
    {
      if (actionFormationGa.getAffDerogatoire().equals("O")) {
        actionFormationCali.setAffDerogatoire("O");
      } else if (actionFormationGa.getAffDerogatoire().equals("N")) {
        actionFormationCali.setAffDerogatoire("N");
      } else if (actionFormationGa.getAffDerogatoire().equals(" ")) {
        actionFormationCali.setAffDerogatoire("X");
      }
    }
    else {
      actionFormationCali.setAffDerogatoire("X");
    }
    ChronologiePeriodes listePeriodeFormationCali = creerListePeriodeFormation(actionFormationGa, actionFormationCali);
    actionFormationCali.setListePeriodeFormation(listePeriodeFormationCali);
    if (actionFormationGa.getBeneficiaireRSA() != null)
    {
      if (actionFormationGa.getBeneficiaireRSA().intValue() == 0) {
        actionFormationCali.setTypeBeneficiaireRSA(0);
      } else if (actionFormationGa.getBeneficiaireRSA().intValue() == 1) {
        actionFormationCali.setTypeBeneficiaireRSA(1);
      } else if (actionFormationGa.getBeneficiaireRSA().intValue() == 2) {
        actionFormationCali.setTypeBeneficiaireRSA(2);
      }
    }
    else {
      actionFormationCali.setTypeBeneficiaireRSA(0);
    }
    ListePeriodesAbsenceFormation listePeriodesAbsenceFormationGaec = actionFormationGa.getListePeriodesAbsenceFormation();
    ChronologiePeriodes listePeriodeAbsenceFormationCali = creerListePeriodeAbsenceFormation(listePeriodesAbsenceFormationGaec);
    actionFormationCali.setListePeriodeAbsenceFormation(listePeriodeAbsenceFormationCali);
    
    return actionFormationCali;
  }
  
  private static ChronologiePeriodes creerListePeriodeFormation(fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ActionFormation actionFormationGa, fr.unedic.cali.autresdoms.ga.dom.ActionFormation actionFormationCali)
  {
    String typeMesurePourEmploi = actionFormationGa.getTypeMesureEmploi();
    ListePeriodeFormation listePeriodeFormationGaec = actionFormationGa.getListePeriodeFormation();
    if (listePeriodeFormationGaec == null) {
      return null;
    }
    ChronologiePeriodes listePeriodeFormationCali = new ChronologiePeriodes();
    
    Damj dateFinActionFormation = Damj.NUIT_DES_TEMPS;
    int nbElements = listePeriodeFormationGaec.getNbListPeriodeFormation();
    for (int i = 0; i < nbElements; i++)
    {
      fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.PeriodeFormation periodeFormationGaec = listePeriodeFormationGaec.getListePeriodeFormation(i);
      listePeriodeFormationCali.ajouter(creerPeriodeFormation(periodeFormationGaec, typeMesurePourEmploi));
      if ((periodeFormationGaec != null) && (periodeFormationGaec.getDateFinPeriode() != null) && (periodeFormationGaec.getDateFinPeriode().estApres(dateFinActionFormation)) && (periodeFormationGaec.getDateFinPeriode().estContenueDans(actionFormationCali.getPeriode()))) {
        dateFinActionFormation = periodeFormationGaec.getDateFinPeriode();
      }
    }
    if (dateFinActionFormation.estContenueDans(actionFormationCali.getPeriode())) {
      actionFormationCali.setDateFin(dateFinActionFormation);
    }
    return listePeriodeFormationCali;
  }
  
  private static fr.unedic.cali.autresdoms.ga.dom.PeriodeFormation creerPeriodeFormation(fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.PeriodeFormation periodeFormationGaec, String typeMesurePourEmploi)
  {
    Periode periodePrevisionnelle = new Periode(periodeFormationGaec.getDateDebutPeriode(), periodeFormationGaec.getDateFinPeriode());
    fr.unedic.cali.autresdoms.ga.dom.PeriodeFormation periodeFormationCali = new fr.unedic.cali.autresdoms.ga.dom.PeriodeFormation(periodePrevisionnelle);
    if ((periodeFormationGaec.getDateDebutPeriodeEffective() != null) && (periodeFormationGaec.getDateFinPeriodeEffective() != null))
    {
      Periode periodeEffective = new Periode(periodeFormationGaec.getDateDebutPeriodeEffective(), periodeFormationGaec.getDateFinPeriodeEffective());
      
      periodeFormationCali.setPeriodeEffective(periodeEffective);
    }
    periodeFormationCali.setIdentifiant(periodeFormationGaec.getIdentifiant());
    periodeFormationCali.setTypeMesurePourEmploi(typeMesurePourEmploi);
    return periodeFormationCali;
  }
  
  private static ChronologiePeriodes creerListePeriodeAbsenceFormation(ListePeriodesAbsenceFormation listePeriodesAbsenceFormationGaec)
  {
    if (listePeriodesAbsenceFormationGaec == null) {
      return null;
    }
    ChronologiePeriodes listePeriodeAbsenceFormationCali = new ChronologiePeriodes();
    int nbElements = listePeriodesAbsenceFormationGaec.getNbListPeriodeAbsenceFormation();
    for (int i = 0; i < nbElements; i++)
    {
      PeriodeAbsenceFormation periodeAbsenceFormationGaec = listePeriodesAbsenceFormationGaec.getListePeriodesAbsenceFormation(i);
      if ((periodeAbsenceFormationGaec.getMotifAbsenceFormation() == null) || (periodeAbsenceFormationGaec.getMotifAbsenceFormation().isEmpty()) || (periodeAbsenceFormationGaec.getMotifAbsenceFormation().equals("08"))) {
        listePeriodeAbsenceFormationCali.ajouter(creerPeriodeAbsenceFormation(periodeAbsenceFormationGaec));
      }
    }
    return listePeriodeAbsenceFormationCali;
  }
  
  private static PeriodeGaec creerPeriodeAbsenceFormation(PeriodeAbsenceFormation periodeAbsenceFormationGaec)
  {
    PeriodeGaec periodeAbsenceFormationCali = new PeriodeGaec(periodeAbsenceFormationGaec.getDateDebut(), periodeAbsenceFormationGaec.getDateFin());
    
    periodeAbsenceFormationCali.setDateConnaissanceInfo(periodeAbsenceFormationGaec.getDateOrigineInfo());
    periodeAbsenceFormationCali.setIdentifiant(periodeAbsenceFormationGaec.getIdentifiant());
    return periodeAbsenceFormationCali;
  }
  
  private static int convertirTypeConvention(String typeConventionGa, Damj dateActionFormation, String numeroConvention)
    throws CoucheLogiqueException
  {
    int typeConventionCali;
    int typeConventionCali;
    if (typeConventionGa.equals("I"))
    {
      typeConventionCali = 1;
    }
    else
    {
      int typeConventionCali;
      if (typeConventionGa.equals("J"))
      {
        typeConventionCali = 2;
      }
      else
      {
        int typeConventionCali;
        if (typeConventionGa.equals("C"))
        {
          int typeConventionCali;
          if (OutilActionFormationJeune.estFormationJeune(numeroConvention)) {
            typeConventionCali = 8;
          } else {
            typeConventionCali = 3;
          }
        }
        else
        {
          int typeConventionCali;
          if (typeConventionGa.equals("P"))
          {
            CritereStrategie criteres = new CritereStrategie();
            criteres.setDatePivot(dateActionFormation);
            FabriqueStrategieTypeConventionAfpeOuAfpr fabrique = new FabriqueStrategieTypeConventionAfpeOuAfpr();
            StrategieTypeConventionAfpeOuAfprSpec strategie = (StrategieTypeConventionAfpeOuAfprSpec)fabrique.getStrategie(criteres);
            typeConventionCali = strategie.getTypeConventionAfpeOuAfpr();
          }
          else
          {
            int typeConventionCali;
            if (typeConventionGa.equals("N"))
            {
              typeConventionCali = 5;
            }
            else
            {
              int typeConventionCali;
              if (typeConventionGa.equals("X"))
              {
                typeConventionCali = 6;
              }
              else
              {
                int typeConventionCali;
                if (typeConventionGa.equals("F"))
                {
                  typeConventionCali = 11;
                }
                else
                {
                  int typeConventionCali;
                  if (typeConventionGa.equals("A"))
                  {
                    typeConventionCali = 9;
                  }
                  else
                  {
                    int typeConventionCali;
                    if (typeConventionGa.equals("O"))
                    {
                      typeConventionCali = 0;
                    }
                    else
                    {
                      int typeConventionCali;
                      if (typeConventionGa.equals("B"))
                      {
                        typeConventionCali = 10;
                      }
                      else
                      {
                        int typeConventionCali;
                        if (typeConventionGa.equals(String.valueOf(1)))
                        {
                          typeConventionCali = 12;
                        }
                        else
                        {
                          int typeConventionCali;
                          if (typeConventionGa.equals(String.valueOf(2)))
                          {
                            typeConventionCali = 13;
                          }
                          else
                          {
                            int typeConventionCali;
                            if (typeConventionGa.equals(String.valueOf(3)))
                            {
                              typeConventionCali = 14;
                            }
                            else
                            {
                              int typeConventionCali;
                              if (typeConventionGa.equals(String.valueOf(4)))
                              {
                                typeConventionCali = 15;
                              }
                              else
                              {
                                int typeConventionCali;
                                if (typeConventionGa.equals(String.valueOf(5)))
                                {
                                  typeConventionCali = 16;
                                }
                                else
                                {
                                  typeConventionCali = 6;
                                  if (Log.isTraceActive(MapperActionFormation.class, Niveau.DEBUG)) {
                                    Log.ecritTrace(Niveau.DEBUG, MapperActionFormation.class, "creerActionFormation", "Type de convention GA : '" + typeConventionGa + "' inconnu");
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return typeConventionCali;
  }
}

/* Location:
 * Qualified Name:     MapperActionFormation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */