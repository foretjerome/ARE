package fr.unedic.cali.autresdoms.ga.mapping;

import fr.unedic.cali.autresdoms.ga.dom.Metier;
import fr.unedic.cali.fabriques.FabriqueStrategiePECCACIRMAetCUI;
import fr.unedic.cali.outilsfonctionnels.strategies.CritereStrategie;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategiePECCACIRMAetCUISpec;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ChampsPeriodeActivite;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.Indemnite;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ListeOrigineInformation;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ListePrimes;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.OrigineInformation;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.PeriodeActivite;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.QuantiteTravail;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.Salaire;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class MapperBulletinSalaire
{
  static fr.unedic.cali.autresdoms.ga.dom.BulletinSalaire mapper(PeriodeActivite p_periodeActiviteGa)
    throws CoucheLogiqueException
  {
    fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.BulletinSalaire bulletinSalaireGa = p_periodeActiviteGa.getBulletinSalaire();
    Periode periode = FabriquePeriode.creer(p_periodeActiviteGa.getChampsPeriodeActivite().getDateDebut(), p_periodeActiviteGa.getChampsPeriodeActivite().getDateFin());
    
    fr.unedic.cali.autresdoms.ga.dom.BulletinSalaire bulletinSalaireCali = new fr.unedic.cali.autresdoms.ga.dom.BulletinSalaire(periode);
    
    bulletinSalaireCali.setIdentifiant(p_periodeActiviteGa.getChampsPeriodeActivite().getIdPeriodeActivite());
    if (bulletinSalaireGa.getContratParticulier() != null)
    {
      bulletinSalaireCali.getMetier().setContratTypeParticulier(bulletinSalaireGa.getContratParticulier().intValue());
      if ((bulletinSalaireCali.getMetier().getContratTypeParticulier() == 22) || (bulletinSalaireCali.getMetier().getContratTypeParticulier() == 21))
      {
        CritereStrategie critereCACIRMA = new CritereStrategie();
        critereCACIRMA.setDatePivot(bulletinSalaireCali.getDateDebut());
        StrategiePECCACIRMAetCUISpec strategieCACIRMA = (StrategiePECCACIRMAetCUISpec)FabriqueStrategiePECCACIRMAetCUI.getInstance().getStrategie(critereCACIRMA);
        
        bulletinSalaireCali.getMetier().setContratTypeParticulier(strategieCACIRMA.mapperTypeContratParticulier(bulletinSalaireCali.getMetier().getContratTypeParticulier()));
      }
    }
    QuantiteTravail qteTravailGaec = bulletinSalaireGa.getQuantiteTravail();
    if (qteTravailGaec != null) {
      MapperQuantiteTravail.ajouter(bulletinSalaireCali, qteTravailGaec);
    }
    Salaire salaireGaec = bulletinSalaireGa.getSalaire();
    if (salaireGaec != null) {
      MapperSalaire.ajouterSalaire(bulletinSalaireCali, salaireGaec, p_periodeActiviteGa);
    }
    ListePrimes listePrimes = bulletinSalaireGa.getListePrimes();
    MapperPrime.ajouter(bulletinSalaireCali, listePrimes);
    
    Indemnite indemniteGaec = bulletinSalaireGa.getIndemnite();
    if (indemniteGaec != null) {
      MapperIndemnite.ajouter(bulletinSalaireCali, indemniteGaec);
    }
    if (bulletinSalaireGa.getCategorieParticuliere() != null) {
      bulletinSalaireCali.getMetier().setCategorieEmploiParticulier(bulletinSalaireGa.getCategorieParticuliere().intValue());
    }
    if (bulletinSalaireGa.getEntreprise() != null) {
      MapperEntreprise.mapper(bulletinSalaireCali.getEntreprise(), bulletinSalaireGa.getEntreprise(), bulletinSalaireCali.getDateFin());
    }
    boolean enConflit = BooleanGa.valueOf(p_periodeActiviteGa.getChampsPeriodeActivite().getBEnConflit());
    bulletinSalaireCali.setEnConflit(enConflit);
    
    ListeOrigineInformation listeOrigineInfo = p_periodeActiviteGa.getChampsPeriodeActivite().getListeOrigineInformation();
    List listeInformationOrigine = new ArrayList();
    if (listeOrigineInfo != null) {
      for (int i = 0; i < listeOrigineInfo.getNbListOrigineInformation(); i++) {
        listeInformationOrigine.add(listeOrigineInfo.getListeOrigineInformation(i).getCodeOrigineInformation());
      }
    }
    bulletinSalaireCali.setListeInformationOrigine(listeInformationOrigine);
    
    bulletinSalaireCali.setMontantEtt(bulletinSalaireGa.getMontantETT());
    
    return bulletinSalaireCali;
  }
}

/* Location:
 * Qualified Name:     MapperBulletinSalaire
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */