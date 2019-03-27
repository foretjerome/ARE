package fr.unedic.cali.autresdoms.ga.mapping;

import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ChampsPeriodeActivite;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.PeriodeActivite;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.Salaire;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Periode;

public class MapperChequeEmploiService
{
  static fr.unedic.cali.autresdoms.ga.dom.ChequeEmploiService mapper(PeriodeActivite p_periodeActiviteGa)
    throws CoucheLogiqueException
  {
    Periode periode = FabriquePeriode.creer(p_periodeActiviteGa.getChampsPeriodeActivite().getDateDebut(), p_periodeActiviteGa.getChampsPeriodeActivite().getDateFin());
    
    fr.unedic.cali.autresdoms.ga.dom.ChequeEmploiService chequeEmploiServiceCali = new fr.unedic.cali.autresdoms.ga.dom.ChequeEmploiService(periode);
    
    chequeEmploiServiceCali.setIdentifiant(p_periodeActiviteGa.getChampsPeriodeActivite().getIdPeriodeActivite());
    
    fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ChequeEmploiService chequeEmploiServiceGaec = p_periodeActiviteGa.getChequeEmploiService();
    if (chequeEmploiServiceGaec.getEntreprise() != null) {
      MapperEntreprise.mapper(chequeEmploiServiceCali.getEntreprise(), chequeEmploiServiceGaec.getEntreprise(), chequeEmploiServiceCali.getDateFin());
    }
    Salaire salaireGa = chequeEmploiServiceGaec.getSalaire();
    if (salaireGa != null) {
      MapperSalaire.ajouterSalaire(chequeEmploiServiceCali, salaireGa, p_periodeActiviteGa);
    }
    if (chequeEmploiServiceGaec.getQuantiteTravail() != null) {
      MapperQuantiteTravail.ajouter(chequeEmploiServiceCali, chequeEmploiServiceGaec.getQuantiteTravail());
    }
    chequeEmploiServiceCali.setAlsaceMoselle(BooleanGa.valueOf(chequeEmploiServiceGaec.getAlsaceMoselle()));
    
    boolean enConflit = BooleanGa.valueOf(p_periodeActiviteGa.getChampsPeriodeActivite().getBEnConflit());
    chequeEmploiServiceCali.setEnConflit(enConflit);
    
    return chequeEmploiServiceCali;
  }
}

/* Location:
 * Qualified Name:     MapperChequeEmploiService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */