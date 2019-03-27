package fr.unedic.cali.autresdoms.ga.mapping;

import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeIntensite;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.HorairesTravail;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ListeIntensitesTravailHeures;
import fr.unedic.util.temps.Periode;

class MapperIntensite
{
  static void ajouter(PeriodeActiviteSalarie p_pasGaec, ListeIntensitesTravailHeures p_listeIntensiteGaec)
  {
    if (p_listeIntensiteGaec == null) {
      return;
    }
    int nbElements = p_listeIntensiteGaec.getNbListHorairesTravail();
    for (int i = 0; i < nbElements; i++)
    {
      HorairesTravail horairesGaec = p_listeIntensiteGaec.getListeIntensitesTravailHeures(i);
      Periode periode = FabriquePeriode.creer(horairesGaec.getDateDebIntensite(), horairesGaec.getDateFinIntensite());
      if (periode.chevauche(p_pasGaec.getPeriode())) {
        ajouter(p_pasGaec, horairesGaec);
      }
    }
  }
  
  private static void ajouter(PeriodeActiviteSalarie pasGaec, HorairesTravail horairesGaec)
  {
    Periode periode = FabriquePeriode.creer(horairesGaec.getDateDebIntensite(), horairesGaec.getDateFinIntensite());
    periode = periode.periodeIntersection(pasGaec.getPeriode());
    PeriodeIntensite intensiteCali = new PeriodeIntensite(periode);
    if (horairesGaec.getNatureHoraire() != null) {
      intensiteCali.setUniteHoraire(convertirUniteIntensite(horairesGaec.getNatureHoraire()));
    }
    intensiteCali.setHorairesEntreprise(horairesGaec.getHorairesEntreprise());
    intensiteCali.setHorairesSalarie(horairesGaec.getHorairesSalarie());
    
    pasGaec.ajouterIntensite(intensiteCali);
  }
  
  private static int convertirUniteIntensite(String p_uniteGaec)
  {
    int uniteCali;
    if (p_uniteGaec.equals("02"))
    {
      uniteCali = 2;
    }
    else
    {
      int uniteCali;
      if (p_uniteGaec.equals("01"))
      {
        uniteCali = 1;
      }
      else
      {
        int uniteCali;
        if (p_uniteGaec.equals("03")) {
          uniteCali = 3;
        } else {
          throw new RuntimeException("Unité d'intensité GA '" + p_uniteGaec + "' non reconnue");
        }
      }
    }
    int uniteCali;
    return uniteCali;
  }
}

/* Location:
 * Qualified Name:     MapperIntensite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */