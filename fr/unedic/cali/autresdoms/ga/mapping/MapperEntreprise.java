package fr.unedic.cali.autresdoms.ga.mapping;

import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteSalarie;
import fr.unedic.cali.dom.affectation.ProduitAsuCve13P01;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;

public final class MapperEntreprise
{
  private static final Damj DATE_FIN_CTP = ProduitAsuCve13P01.getInstance().getPeriodeValidite().getFin();
  
  static void mapper(fr.unedic.cali.autresdoms.ga.dom.Entreprise entreprise, fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.Entreprise entrepriseGa, Damj dateFin)
    throws CoucheLogiqueException
  {
    if (entrepriseGa != null)
    {
      entreprise.setLibelleEntreprise(entrepriseGa.getLibelleEntreprise());
      
      entreprise.setNumeroAffiliation(entrepriseGa.getNumAffiliation());
      entreprise.setCodeNAF(entrepriseGa.getCodeNaf());
      entreprise.setNumeroConventionGestion(entrepriseGa.getConventionGestion());
      entreprise.setIdentifiantBNE(entrepriseGa.getBne());
      entreprise.setUrssaf(entrepriseGa.getUrssaf());
      entreprise.setNumeroGuso(entrepriseGa.getGuso());
      
      mapperSiret(entreprise, entrepriseGa.getSiret());
      
      entreprise.setCodePostalEntreprise("");
      
      entreprise.setDateEntreeCTP(entrepriseGa.getDateEntreeCTP());
      entreprise.setEffectif(entrepriseGa.getTrancheEntreprise());
      if (entrepriseGa.getCodeBassinEmploi() != null) {
        determinerCodeBassinCTP(entreprise, entrepriseGa, dateFin);
      }
      if ((entrepriseGa.getCodeRegime() != null) && ("C2".equalsIgnoreCase(entrepriseGa.getCodeRegime()))) {
        entreprise.setEstEmployeurAdherantATitreIrrevocable(true);
      }
      if (entrepriseGa.getEstTypeSecteurPublic() != null) {
        entreprise.setEstSecteurPublic(entrepriseGa.getEstTypeSecteurPublic().booleanValue());
      }
      if ((entrepriseGa.getCertificationSociale() != null) && (2 == entrepriseGa.getCertificationSociale().intValue())) {
        entreprise.setCertificationSocialeEntreprise(true);
      } else {
        entreprise.setCertificationSocialeEntreprise(false);
      }
    }
  }
  
  private static void determinerCodeBassinCTP(fr.unedic.cali.autresdoms.ga.dom.Entreprise entreprise, fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.Entreprise entrepriseGa, Damj dateFin)
    throws CoucheLogiqueException
  {
    switch (entrepriseGa.getCodeBassinEmploi().intValue())
    {
    case 0: 
    case 3: 
      entreprise.setCodeBassinCTP(3);
      break;
    case 1: 
    case 2: 
      determinerCodeBassinCTP0609(entreprise, entrepriseGa, dateFin);
      break;
    }
  }
  
  private static void determinerCodeBassinCTP0609(fr.unedic.cali.autresdoms.ga.dom.Entreprise entreprise, fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.Entreprise entrepriseGa, Damj dateFin)
    throws CoucheLogiqueException
  {
    Damj entreeCTP = entreprise.getDateEntreeCTP();
    if ((dateFin == null) || (dateFin.estApres(DATE_FIN_CTP)) || ((entreeCTP != null) && (dateFin.estAvant(entreeCTP)))) {
      entreprise.setCodeBassinCTP(3);
    } else if (entreeCTP == null) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_INCOHERENCE_EMPLOYEUR_CTP", new Object[] { dateFin });
    } else if (dateFin.estApresOuCoincideAvec(entreeCTP)) {
      entreprise.setCodeBassinCTP(entrepriseGa.getCodeBassinEmploi().intValue());
    }
  }
  
  protected static void mapperSiret(fr.unedic.cali.autresdoms.ga.dom.Entreprise contratTravailCali, String siretGaec)
  {
    int neuf = 9;
    if ((siretGaec != null) && (siretGaec.length() >= 9))
    {
      String siren = siretGaec.substring(0, 9);
      
      contratTravailCali.setSiren(siren);
    }
  }
  
  protected static void mapperSiret(PeriodeActiviteSalarie periodeSalarieeCali, String siretGaec)
  {
    int neuf = 9;
    if ((siretGaec != null) && (siretGaec.length() >= 9))
    {
      String siren = siretGaec.substring(0, 9);
      
      periodeSalarieeCali.setSiren(siren);
    }
  }
}

/* Location:
 * Qualified Name:     MapperEntreprise
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */