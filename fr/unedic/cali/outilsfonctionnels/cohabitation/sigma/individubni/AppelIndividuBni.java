package fr.unedic.cali.outilsfonctionnels.cohabitation.sigma.individubni;

import fr.pe.cali.client.ManagerAppelsServicesD01;
import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.cohab.sigma.CodesErreurs;
import fr.unedic.cali.autresdoms.cohab.sigma.individubni.dom.StructureOutIndividuBniR0;
import fr.unedic.cali.autresdoms.cohab.sigma.individubni.dom.spec.StructureInIndividuBniSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.individubni.dom.spec.StructureOutIndividuBniR0Spec;
import fr.unedic.logique.donnees.rac.commun.dra.d01.zu.SA01R0_IN;
import fr.unedic.logique.donnees.rac.commun.dra.d01.zu.SA01R0_OUT;
import fr.unedic.logique.donnees.rac.commun.dra.zu.MI2J;
import fr.unedic.logique.donnees.rac.commun.dra.zu.MI30;
import fr.unedic.logique.donnees.rac.commun.dra.zu.ZI01R0MI30;
import fr.unedic.logique.donnees.rac.commun.dra.zu.ZO01R0MI2J;
import fr.unedic.logique.donnees.rac.commun.dra.zu.ZO01R0MI2JIT;
import fr.unedic.logique.donnees.rac.commun.dra.zu.ZO01R0MI2JLT;
import java.math.BigDecimal;
import java.util.List;

public class AppelIndividuBni
{
  public static final String ERR_SA01R1 = "DRA SA01R1          UD001000";
  
  public StructureOutIndividuBniR0Spec lireIndividuBniR0(StructureInIndividuBniSpec criteresIndividuBni)
    throws ApplicativeException, TechniqueException
  {
    String cxalaIndividuBni = criteresIndividuBni.getNumeroAllocataire();
    StructureOutIndividuBniR0Spec structureOutIndividuBni = new StructureOutIndividuBniR0();
    try
    {
      SA01R0_IN bniIn = SA01R0_IN.getInstance();
      ZI01R0MI30 d01In = bniIn.setNewZI01R0MI30();
      MI30 zoneComIn = d01In.setNewMI30_communication__in_SA01R1();
      
      zoneComIn.setFIRCH_type_de_recherche_individu("R");
      zoneComIn.setCDEPU_TOP_RECHERCHE_D_E__EPURE("O");
      zoneComIn.setCDACF_TOP_RECHERCHE_D_E__ACTIF("O");
      zoneComIn.setCDETT_TOP_RECHERCHE_SALARIE_E_T_T_("O");
      zoneComIn.setCDINA_TOP_RECHERCHE_D_E__INACTIF("O");
      zoneComIn.setCXASS_CODE_ASSEDIC("");
      if (cxalaIndividuBni != null) {
        zoneComIn.setCXCLIF_IDENTIFIANT_BNI_SIGMA(cxalaIndividuBni.toUpperCase());
      }
      SA01R0_OUT bniOut = appelService(bniIn);
      ZO01R0MI2J d01Out = bniOut.getZO01R0MI2J();
      
      ZO01R0MI2JLT liste = d01Out.getZO01R0MI2JLT();
      String cxala = "";
      String codeAssedic = "";
      String rsin = "";
      String cincp = "";
      String lzocn = "";
      if ((liste != null) && (liste.getNbListZO01R0MI2JIT() > 0))
      {
        MI2J mi2j = ((ZO01R0MI2JIT)liste.getListZO01R0MI2JIT().get(0)).getMI2J_communication__out_SA01R0();
        if (mi2j != null)
        {
          cxala = mi2j.getCXALA_IDENTIFIANT_NATIONAL_ALADIN().toString();
          
          codeAssedic = mi2j.getCXASS_CODE_ASSEDIC();
          
          rsin = mi2j.getCXIN_IDENTIFIANT_DE_L_INDIVIDU();
          
          cincp = mi2j.getCINCP_CODE_ETAT_MIGRATION_NCP();
          
          lzocn = mi2j.getLZOCN_ORIGINE_CERTIFICATION_IDENTITE();
        }
      }
      structureOutIndividuBni.setNumeroAllocataire(cxala);
      structureOutIndividuBni.setIdentifiantSigma(rsin);
      structureOutIndividuBni.setCodeAssedic(codeAssedic);
      structureOutIndividuBni.setCodeEtatMigrationNCP(cincp);
      structureOutIndividuBni.setOrigineCertification(lzocn);
    }
    catch (ApplicativeException ae)
    {
      throw CodesErreurs.getErreurServiceV1(ae, "SA01R0", criteresIndividuBni.getNumeroAllocataire());
    }
    return structureOutIndividuBni;
  }
  
  public SA01R0_OUT appelService(SA01R0_IN donneesIn)
    throws TechniqueException, ApplicativeException
  {
    ManagerAppelsServicesD01 managerService = new ManagerAppelsServicesD01();
    SA01R0_OUT sortie = SA01R0_OUT.getInstance();
    sortie.setZO01R0MI2J(managerService.SA01R0_BNI_chapeau_V1_rech_DP___ajout_ncp(donneesIn.getZI01R0MI30()));
    return sortie;
  }
}

/* Location:
 * Qualified Name:     AppelIndividuBni
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */