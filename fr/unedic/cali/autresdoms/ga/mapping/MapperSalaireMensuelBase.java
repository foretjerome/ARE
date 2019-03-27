package fr.unedic.cali.autresdoms.ga.mapping;

import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteSalarie;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ListeSalairesMensuelsBase;
import fr.unedic.util.temps.Periode;

public class MapperSalaireMensuelBase
{
  static void ajouter(PeriodeActiviteSalarie p_pasGaec, ListeSalairesMensuelsBase p_listeSalairesMensuelsBaseGaec)
  {
    if (p_listeSalairesMensuelsBaseGaec == null) {
      return;
    }
    int nbElements = p_listeSalairesMensuelsBaseGaec.getNbListSalaireMensuelBase();
    for (int i = 0; i < nbElements; i++)
    {
      fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.SalaireMensuelBase salaireMensuelBaseGaec = p_listeSalairesMensuelsBaseGaec.getListeSalairesMensuelsBase(i);
      Periode periode = FabriquePeriode.creer(salaireMensuelBaseGaec.getDateDeb(), salaireMensuelBaseGaec.getDateFin());
      if (periode.chevauche(p_pasGaec.getPeriode())) {
        ajouter(p_pasGaec, salaireMensuelBaseGaec);
      }
    }
  }
  
  private static void ajouter(PeriodeActiviteSalarie p_pasGaec, fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.SalaireMensuelBase p_salaireMensuelBaseGaec)
  {
    Periode periode = FabriquePeriode.creer(p_salaireMensuelBaseGaec.getDateDeb(), p_salaireMensuelBaseGaec.getDateFin());
    periode = periode.periodeIntersection(p_pasGaec.getPeriode());
    fr.unedic.cali.autresdoms.ga.dom.SalaireMensuelBase salaireMensuelBaseCali = new fr.unedic.cali.autresdoms.ga.dom.SalaireMensuelBase(periode);
    
    salaireMensuelBaseCali.setMontantSalaireMensuel(p_salaireMensuelBaseGaec.getMontantSalaireMensuel());
    
    p_pasGaec.ajouterSalaireMensuelBase(salaireMensuelBaseCali);
  }
}

/* Location:
 * Qualified Name:     MapperSalaireMensuelBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */