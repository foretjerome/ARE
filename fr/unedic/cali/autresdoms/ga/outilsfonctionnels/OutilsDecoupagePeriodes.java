package fr.unedic.cali.autresdoms.ga.outilsfonctionnels;

import fr.unedic.cali.autresdoms.ga.dom.ContexteDecoupage;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ChampsPeriodeActivite;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.EvenementPersonnel;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.EvenementPersonnelComplet;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ListeEvenementPersonnnel;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ListeSalaires;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.PeriodeActivite;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.Salaire;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.OutilFonctionnel;
import fr.unedic.util.temps.Damj;

public class OutilsDecoupagePeriodes
  implements OutilFonctionnel
{
  public static boolean contientPeriodesADecouper(PeriodeActivite p_periodeActiviteGa)
  {
    fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ContratTravail contratTravailGa = p_periodeActiviteGa.getContratTravail();
    ListeEvenementPersonnnel listeEvenementPersonnnel = contratTravailGa.getListeEvenementPersonnnel();
    if ((listeEvenementPersonnnel != null) && (listeEvenementPersonnnel.getNbListEvenementPersonnelComplet() > 0)) {
      for (int i = 0; i < listeEvenementPersonnnel.getNbListEvenementPersonnelComplet(); i++)
      {
        EvenementPersonnelComplet evt = listeEvenementPersonnnel.getListeEvenementPersonnnel(i);
        if (estUnEvenementDeTypeDecoupage(evt)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean estUnEvenementDeTypeDecoupage(EvenementPersonnelComplet p_evenementPersonnel)
  {
    boolean retour = false;
    for (int i = 0; i < ContexteDecoupage.EVENEMENTS_A_DECOUPER.length; i++) {
      if (Integer.parseInt(p_evenementPersonnel.getEvenementPersonnel().getNature()) == ContexteDecoupage.EVENEMENTS_A_DECOUPER[i]) {
        return true;
      }
    }
    return retour;
  }
  
  public static String recupererContexteDecoupagePourEvenementGaec(EvenementPersonnelComplet p_evenementPersonnel)
  {
    int natureEvenement = Integer.parseInt(p_evenementPersonnel.getEvenementPersonnel().getNature());
    return ContexteDecoupage.getContexteDecoupagePourEvenement(natureEvenement);
  }
  
  public static fr.unedic.cali.autresdoms.ga.dom.ContratTravail redefinirProchainContratCali(PeriodeActivite p_periodeActiviteGa, fr.unedic.cali.autresdoms.ga.dom.ContratTravail p_contratTravailCali, Damj p_dateEtude)
    throws CoucheLogiqueException
  {
    Damj dateRupture = p_periodeActiviteGa.getChampsPeriodeActivite().getDateFin();
    if ((dateRupture != null) && (dateRupture.estAvant(p_dateEtude))) {
      return null;
    }
    ListeEvenementPersonnnel listeEvtPerso = p_periodeActiviteGa.getContratTravail().getListeEvenementPersonnnel();
    int nbEvtPerso = listeEvtPerso.getNbListEvenementPersonnelComplet();
    for (int i = 0; i < nbEvtPerso; i++)
    {
      EvenementPersonnelComplet evt = listeEvtPerso.getListeEvenementPersonnnel(i);
      String contexteDecoupage = recupererContexteDecoupagePourEvenementGaec(evt);
      if (contexteDecoupage != null)
      {
        Damj dateDebutEvt = evt.getChampsPeriodeActivite().getDateDebut();
        Damj dateFinEvt = evt.getChampsPeriodeActivite().getDateFin();
        
        p_contratTravailCali.ajouterContexteDecoupage(contexteDecoupage);
        if ((dateFinEvt == null) || (!dateFinEvt.estAvant(p_dateEtude)))
        {
          if (dateDebutEvt.estApres(p_dateEtude))
          {
            Damj dateDernierJourSuspensionAvantVeille = dateDebutEvt.veille();
            p_contratTravailCali.setDateRuptureContratTravail(dateDernierJourSuspensionAvantVeille);
            p_contratTravailCali.setCodeMotifFin(ContexteDecoupage.getMotifRupturePourContexteDecoupage(contexteDecoupage));
            p_contratTravailCali.setDernierJourTravaillePaye(determinerDJTPPourContratCali(p_periodeActiviteGa, dateDernierJourSuspensionAvantVeille));
            
            p_contratTravailCali.setPreavis(null);
            return p_contratTravailCali;
          }
          if (dateDebutEvt.coincideAvec(p_dateEtude))
          {
            p_contratTravailCali.setDateRuptureContratTravail(dateFinEvt);
            
            p_contratTravailCali.setEstDernierContratCaliCreePourDecoupage(estDernierContratCaliCreePourDecoupage(dateFinEvt, dateRupture));
            if ("CSR".equals(contexteDecoupage)) {
              p_contratTravailCali.setEstSuspensionChomageSansRCT(true);
            }
            p_contratTravailCali.setEstSuspensionDecoupee(true);
            
            return p_contratTravailCali;
          }
        }
      }
    }
    p_contratTravailCali.setEstDernierContratCaliCreePourDecoupage(true);
    return p_contratTravailCali;
  }
  
  private static boolean estDernierContratCaliCreePourDecoupage(Damj p_dateFinEvt, Damj p_dateRupture)
  {
    return (p_dateFinEvt == null) || (p_dateFinEvt.equals(Damj.FIN_DES_TEMPS)) || ((p_dateRupture != null) && (p_dateFinEvt.estApresOuCoincideAvec(p_dateRupture)));
  }
  
  private static Damj determinerDJTPPourContratCali(PeriodeActivite p_periodeActiviteGa, Damj p_dateDernierJourAvantSuspension)
    throws CoucheLogiqueException
  {
    ListeSalaires listeSalaires = p_periodeActiviteGa.getContratTravail().getListeSalaires();
    
    Salaire dernierSalaireRetenu = null;
    if (listeSalaires != null)
    {
      int nbSalaires = listeSalaires.getNbListSalaire();
      for (int i = 0; i < nbSalaires; i++)
      {
        Salaire salaireCourant = listeSalaires.getListeSalaires(i);
        if ((salaireCourant.getDateFin().estAvantOuCoincideAvec(p_dateDernierJourAvantSuspension)) && ((dernierSalaireRetenu == null) || (dernierSalaireRetenu.getDateFin().estAvant(salaireCourant.getDateFin())))) {
          dernierSalaireRetenu = salaireCourant;
        }
      }
    }
    if (dernierSalaireRetenu == null) {
      return null;
    }
    return dernierSalaireRetenu.getDateFin();
  }
}

/* Location:
 * Qualified Name:     OutilsDecoupagePeriodes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */