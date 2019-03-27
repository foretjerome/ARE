package fr.unedic.cali.autresdoms.ga.mapping;

import fr.unedic.cali.autresdoms.ga.dom.PeriodeFormation;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeFormationAssimilable;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeGaec;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ChampsPeriodeActivite;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.FormationNonIndemnisable;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ListeOrigineInformation;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.OrigineInformation;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.PeriodeActivite;
import fr.unedic.util.Quantite;
import fr.unedic.util.UniteAffiliation;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.ArrayList;

public class MapperFormationNonIndemnisable
{
  static PeriodeGaec mapper(PeriodeActivite p_periodeGa)
  {
    FormationNonIndemnisable formationNonIndemnisableGa = p_periodeGa.getFormationNonIndemnisable();
    
    PeriodeFormation periodeFormationCali = null;
    
    Periode periode = FabriquePeriode.creer(p_periodeGa.getChampsPeriodeActivite().getDateDebut(), p_periodeGa.getChampsPeriodeActivite().getDateFin());
    
    int origineRemuneration = formationNonIndemnisableGa.getOrigineRemuneration().intValue();
    if (estPeriodeFormationAssimilable(formationNonIndemnisableGa))
    {
      PeriodeFormationAssimilable formationAssimilable = new PeriodeFormationAssimilable(periode);
      if ((origineRemuneration == 1) || (origineRemuneration == 2)) {
        formationAssimilable.setImputableSurDuree(true);
      }
      periodeFormationCali = formationAssimilable;
    }
    else
    {
      periodeFormationCali = new PeriodeFormation(periode);
    }
    periodeFormationCali.setOrigineRemuneration(origineRemuneration);
    
    periodeFormationCali.setListeOriginesInformation(mapperOriginesInfo(p_periodeGa.getChampsPeriodeActivite().getListeOrigineInformation()));
    if (formationNonIndemnisableGa.getDureeTotaleHeures() != null) {
      periodeFormationCali.setDureeTotale(new Quantite(formationNonIndemnisableGa.getDureeTotaleHeures(), UniteAffiliation.HEURE_TRAVAIL));
    } else {
      periodeFormationCali.setDureeTotale(new Quantite(0, UniteAffiliation.HEURE_TRAVAIL));
    }
    periodeFormationCali.setNomOrganismeFormation(formationNonIndemnisableGa.getNomOrganisme());
    
    periodeFormationCali.setIntitule(formationNonIndemnisableGa.getIntitule());
    
    periodeFormationCali.setIdentifiant(p_periodeGa.getChampsPeriodeActivite().getIdPeriodeActivite());
    
    return periodeFormationCali;
  }
  
  private static ArrayList mapperOriginesInfo(ListeOrigineInformation p_listeOrginesInfoGa)
  {
    ArrayList listeRetour = new ArrayList();
    if (p_listeOrginesInfoGa != null) {
      for (int i = 0; i < p_listeOrginesInfoGa.getNbListOrigineInformation(); i++)
      {
        BigDecimal origineInfo = p_listeOrginesInfoGa.getListeOrigineInformation(i).getCodeOrigineInformation();
        if (origineInfo != null) {
          listeRetour.add(Integer.valueOf(origineInfo.intValue()));
        }
      }
    }
    return listeRetour;
  }
  
  private static boolean estPeriodeFormationAssimilable(FormationNonIndemnisable p_formationNonIndemnisableGa)
  {
    return (p_formationNonIndemnisableGa.getType() != null) && ((p_formationNonIndemnisableGa.getType().intValue() == 1) || (p_formationNonIndemnisableGa.getType().intValue() == 3));
  }
}

/* Location:
 * Qualified Name:     MapperFormationNonIndemnisable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */