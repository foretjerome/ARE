package fr.unedic.cali.autresdoms.d12i.mapping;

import fr.pe.d12dal.dictionnaire.StatutDeclarationInstructionEnumeration;
import fr.pe.d12dal.service.es.dal.InfosDalCALI;
import fr.pe.d12dal.service.es.dal.InfosDalCALI_periodesAffiliations;
import fr.pe.d12dal.service.es.dal.InfosLiquidationDal;
import fr.pe.d12dal.service.es.dal.PeriodeAffiliation;
import fr.pe.d12dal.service.es.dal.RetourLireDALCALI;
import fr.pe.d12dal.service.es.dal.RetourLireDALCALI_listeInfosDALCALI;
import fr.unedic.cali.autresdoms.d12i.dom.DemandeInstruction;
import fr.unedic.cali.autresdoms.d12i.dom.DonneesDAL;
import fr.unedic.cali.autresdoms.d12i.dom.DonneesNPDE;
import fr.unedic.cali.autresdoms.d12i.dom.PeriodeAffiliationInstruction;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Temporel;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class MapperInstruction
{
  private static final String D12_INSTRUCTION_TOP_OUI = "2";
  private static final String D12_INSTRUCTION_TOP_NON = "1";
  
  public static Map<String, DemandeInstruction> mapperListeDonneesDALetNPDE(RetourLireDALCALI retourService)
  {
    HashMap<String, DemandeInstruction> map = new HashMap();
    RetourLireDALCALI_listeInfosDALCALI liste = retourService.getListeInfosDALCALI();
    for (int i = 0; i < liste.getNbListInfosDalCALI(); i++)
    {
      InfosDalCALI infoDal = liste.getListeInfosDALCALI(i);
      
      DonneesDAL donneesDal = alimenterDonneesDALpourNPDE(infoDal);
      
      DonneesNPDE donneesNPDE = alimenterDonneesNPDEpourNPDE(infoDal);
      
      DemandeInstruction demandeInstruction = new DemandeInstruction();
      demandeInstruction.setDonneesDal(donneesDal);
      demandeInstruction.setDonneesNPDE(donneesNPDE);
      
      map.put(infoDal.getRefExterne(), demandeInstruction);
    }
    return map;
  }
  
  private static DonneesDAL alimenterDonneesDALpourNPDE(InfosDalCALI infoDal)
  {
    DonneesDAL donneesDal = new DonneesDAL();
    donneesDal.setBrouillon(false);
    if ("02".equals(infoDal.getStatutDemande())) {
      donneesDal.setBrouillon(true);
    }
    alimenterCategorie(infoDal.getArtisteNonSalarie(), infoDal.getMarinPecheur(), infoDal.getDockerOccasionnel(), infoDal.getDetenuLibere(), infoDal.getSalarieExpatrie(), donneesDal);
    if (donneesDal.estBrouillon()) {
      donneesDal.setCategorieParticuliere(0);
    }
    String refusPropositionFNE = infoDal.getRefusPropositionFNE();
    alimenterRefusFNE(refusPropositionFNE, donneesDal);
    if (infoDal.getDateDJA() != null) {
      donneesDal.setDernierJourAtteste(Damj.dateVersDamj(infoDal.getDateDJA()));
    }
    return donneesDal;
  }
  
  protected static void alimenterRefusFNE(String refusPropositionFNE, DonneesDAL donneesDal)
  {
    if ("1".equalsIgnoreCase(refusPropositionFNE)) {
      donneesDal.setRefusPropositionFNE("N");
    } else if ("2".equalsIgnoreCase(refusPropositionFNE)) {
      donneesDal.setRefusPropositionFNE("O");
    } else {
      donneesDal.setRefusPropositionFNE(" ");
    }
  }
  
  protected static void alimenterCategorie(Boolean artisteNonSalarie, Boolean marinPecheur, Boolean docker, Boolean detenu, Boolean expatrie, DonneesDAL donneesDal)
  {
    if (Boolean.TRUE.equals(artisteNonSalarie)) {
      donneesDal.setCategorieParticuliere(1);
    } else if (Boolean.TRUE.equals(marinPecheur)) {
      donneesDal.setCategorieParticuliere(2);
    } else if (Boolean.TRUE.equals(docker)) {
      donneesDal.setCategorieParticuliere(3);
    } else if (Boolean.TRUE.equals(detenu)) {
      donneesDal.setCategorieParticuliere(4);
    } else if (Boolean.TRUE.equals(expatrie)) {
      donneesDal.setCategorieParticuliere(5);
    } else {
      donneesDal.setCategorieParticuliere(0);
    }
  }
  
  private static DonneesNPDE alimenterDonneesNPDEpourNPDE(InfosDalCALI infoDal)
  {
    DonneesNPDE donneesNPDE = new DonneesNPDE();
    donneesNPDE.initialiserAFaux();
    
    InfosLiquidationDal infosLiq = infoDal.getInfosLiquidationDAL();
    if (infosLiq != null) {
      alimenterInfoLiquidation(infosLiq, donneesNPDE);
    }
    donneesNPDE.setIdentifiantDemandeInstruction(infoDal.getIdentifiantDemandeInstruction());
    
    InfosDalCALI_periodesAffiliations periodesAffi = infoDal.getPeriodesAffiliations();
    ArrayList<Temporel> listePeriodesAffiliationDeclaree = new ArrayList();
    List<PeriodeAffiliationInstruction> periodesProposition = new ArrayList();
    if (periodesAffi != null) {
      for (int numPeriode = 0; numPeriode < periodesAffi.getNbListPeriodeAffiliation(); numPeriode++)
      {
        PeriodeAffiliation periodeAffiliationCourante = periodesAffi.getPeriodesAffiliations(numPeriode);
        
        Date dateDebut = periodeAffiliationCourante.getDateDebut();
        Date dateFin = periodeAffiliationCourante.getDateFin();
        Damj dateDebutCali = Damj.dateVersDamj(dateDebut);
        if (dateDebutCali == null) {
          dateDebutCali = Damj.NUIT_DES_TEMPS;
        }
        Damj dateFinCali = Damj.dateVersDamj(dateFin);
        if (dateFinCali == null) {
          dateFinCali = Damj.FIN_DES_TEMPS;
        }
        PeriodeAffiliationInstruction periodeCali = new PeriodeAffiliationInstruction(dateDebutCali, dateFinCali);
        if (StatutDeclarationInstructionEnumeration.E_2.getValeur().equals(periodeAffiliationCourante.getStatutDeclaration())) {
          listePeriodesAffiliationDeclaree.add(periodeCali);
        }
        String topPropositionCSP = periodeAffiliationCourante.getTopPropositionCSP();
        if ("2".equalsIgnoreCase(topPropositionCSP)) {
          periodeCali.setTopPropositionCSP("O");
        } else {
          periodeCali.setTopPropositionCSP("N");
        }
        String topPropositionPAP = periodeAffiliationCourante.getTopPropositionPAP();
        if ("2".equalsIgnoreCase(topPropositionPAP)) {
          periodeCali.setTopPropositionPAP(Boolean.valueOf(true));
        } else if ("1".equalsIgnoreCase(topPropositionPAP)) {
          periodeCali.setTopPropositionPAP(Boolean.valueOf(false));
        }
        periodesProposition.add(periodeCali);
      }
    }
    donneesNPDE.setListePeriodesEtPropositionCsp(periodesProposition);
    donneesNPDE.setListePeriodeAffiliationDeclaree(listePeriodesAffiliationDeclaree);
    return donneesNPDE;
  }
  
  protected static void alimenterInfoLiquidation(InfosLiquidationDal infosLiq, DonneesNPDE donneesNPDE)
  {
    if (infosLiq.getTopDemandeComplete() != null) {
      donneesNPDE.setEstDemandeComplete(infosLiq.getTopDemandeComplete().booleanValue());
    }
    if (infosLiq.getTopDemandeLiquidable() != null) {
      donneesNPDE.setEstLiquidable(infosLiq.getTopDemandeLiquidable().booleanValue());
    }
    if (infosLiq.getTopLiquidationAuto() != null) {
      donneesNPDE.setEstLiquAuto(infosLiq.getTopLiquidationAuto().booleanValue());
    }
    if (infosLiq.getTopPresenceFormation() != null) {
      donneesNPDE.setEstPresenceFormation(infosLiq.getTopPresenceFormation().booleanValue());
    }
    if (infosLiq.getTopDemandeWebKO() != null) {
      donneesNPDE.setDemandeWebKO(infosLiq.getTopDemandeWebKO().booleanValue());
    }
    if (infosLiq.getTopLiquidationStandardAuto() != null) {
      donneesNPDE.setLiquidationStandardAutoPossible(infosLiq.getTopLiquidationStandardAuto().booleanValue());
    }
  }
}

/* Location:
 * Qualified Name:     MapperInstruction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */