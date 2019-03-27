package fr.unedic.cali.outilsfonctionnels.cohabitation.sigma.restitutioninscrdude;

import fr.pe.cali.client.ManagerAppelsServicesD98;
import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.cohab.sigma.CodesErreurs;
import fr.unedic.cali.autresdoms.cohab.sigma.restitutioninscrdude.dom.StructureOutRestitutionInscriptionDude;
import fr.unedic.cali.autresdoms.cohab.sigma.restitutioninscrdude.dom.spec.StructureInRestitutionInscriptionDudeSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.restitutioninscrdude.dom.spec.StructureOutRestitutionInscriptionDudeSpec;
import fr.unedic.logique.donnees.rac.commun.dra.d98.zu.CXINS;
import fr.unedic.logique.donnees.rac.commun.dra.d98.zu.SA98LD_IN;
import fr.unedic.logique.donnees.rac.commun.dra.d98.zu.SA98LD_OUT;
import fr.unedic.logique.donnees.rac.commun.dra.d98.zu.ZI98LDZJ5C;
import fr.unedic.logique.donnees.rac.commun.dra.d98.zu.ZJ5C;
import fr.unedic.logique.donnees.rac.commun.dra.d98.zu.ZJ5D;
import fr.unedic.logique.donnees.rac.commun.dra.d98.zu.ZJ6F;
import fr.unedic.logique.donnees.rac.commun.dra.d98.zu.ZO98LDZJ5D;
import fr.unedic.logique.donnees.rac.commun.dra.d98.zu.ZO98LDZJ6F;
import fr.unedic.logique.donnees.rac.commun.dra.d98.zu.ZO98LDZJ6FIT;
import fr.unedic.logique.donnees.rac.commun.dra.d98.zu.ZO98LDZJ6FLT;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.List;

public class AppelV1RestitutionInscriptionDude
{
  public static final String SAN = "SAN";
  public static final String VIDE = "";
  public static final String PEC_DEFAUT = "11";
  
  public StructureOutRestitutionInscriptionDudeSpec lireRestitutionInscriptionDude(StructureInRestitutionInscriptionDudeSpec structureInRestitutionInscriptionDude)
    throws ApplicativeException, TechniqueException, CoucheLogiqueException
  {
    StructureOutRestitutionInscriptionDudeSpec structureOutRestitutionInscrDude = new StructureOutRestitutionInscriptionDude();
    try
    {
      SA98LD_IN serviceRestitustionInscDudeIn = SA98LD_IN.getInstance();
      ZI98LDZJ5C sa98ldIn = serviceRestitustionInscDudeIn.setNewZI98LDZJ5C();
      
      String cspec = null;
      
      Damj dsins = null;
      
      ZJ5C zoneComIn = sa98ldIn.setNewZJ5C_DUDE_SA98LD_IN___RESTIT_INS_GIDE();
      zoneComIn.setCXALA_IDENTIFIANT_NATIONAL_ALADIN(new BigDecimal(structureInRestitutionInscriptionDude.getNumeroAllocataire()));
      zoneComIn.setCXASS_CODE_ASSEDIC(structureInRestitutionInscriptionDude.getCodeAssedic());
      zoneComIn.setCXIN_IDENTIFIANT_DE_L_INDIVIDU(structureInRestitutionInscriptionDude.getIdentifiantSigma());
      
      SA98LD_OUT serviceRestitustionInscDudeOut = appelService(serviceRestitustionInscDudeIn);
      
      ZO98LDZJ5D sa98ldOutD = serviceRestitustionInscDudeOut.getZO98LDZJ5D();
      ZO98LDZJ6F sa98ldOutF = serviceRestitustionInscDudeOut.getZO98LDZJ6F();
      
      ZJ5D zj5d = sa98ldOutD.getZJ5D_DUDE_SA98LD_OU___RESTIT_INS_GIDE();
      String codeOccurence = zj5d.getCDPINS_TYPE_PRE_INSCRIPTION_DE();
      if (codeOccurence != null)
      {
        int nombreOccurences = sa98ldOutF.getZO98LDZJ6FLT().getNbListZO98LDZJ6FIT();
        for (int i = 0; i < nombreOccurences; i++)
        {
          ZJ6F zj6f = ((ZO98LDZJ6FIT)sa98ldOutF.getZO98LDZJ6FLT().getListZO98LDZJ6FIT().get(i)).getZJ6F_DUDE_SA98LD_OU___RESTIT_INS_GIDE();
          String codeCourant = zj6f.getCXINS_CLE_SEGMENT_type_inscription_DE().getCDTINS_TYPE_INSCRIPTION_DE();
          if ((codeOccurence.equals(codeCourant)) || (("SAN".equals(codeOccurence)) && (("".equals(codeCourant)) || (codeCourant == null))))
          {
            cspec = zj6f.getCodeErreurCSPEC_TYPE_DE_PRISE_EN_CHARGE();
            if ((cspec == null) || ("".equals(cspec))) {
              cspec = zj6f.getCodeErreurCSPECA_TYPE_DE_PRISE_EN_CHARGE();
            }
            if ((cspec == null) || ("".equals(cspec))) {
              cspec = "11";
            }
            dsins = zj6f.getDSINS_DATE_INSCRIPTION();
            if (dsins != null) {
              break;
            }
            dsins = zj6f.getDSINS1_DATE_INSCRIPTION(); break;
          }
        }
      }
      if (codeOccurence == null) {
        throw new CoucheLogiqueException("PR_COJAC_L_SA98LD_ABSENCE_OCCURENCE", "Le code de l’occurrence retour du SA98 est null");
      }
      if (dsins == null) {
        throw new CoucheLogiqueException("PR_COJAC_L_SA98LD_ABSENCE_DATE_PREINSCRIPTION", "Impossible de déterminer la date de préinscirption. DSINS null");
      }
      if (cspec == null) {
        throw new CoucheLogiqueException("PR_COJAC_L_SA98LD_ABSENCE_PEC", "Impossible de déterminer les informations relatives à la PEC. CSPEC de l’occurrence est null ");
      }
      if (cspec.length() != 2) {
        throw new CoucheLogiqueException("PR_COJAC_L_SA98LD_FORMAT_PEC", "Impossible de déterminer les informations relatives à la PEC. CSPEC n’est pas formaté correctement");
      }
      structureOutRestitutionInscrDude.setDatePreInscription(dsins);
      structureOutRestitutionInscrDude.setSousTypePEC(cspec.substring(1, 2));
      structureOutRestitutionInscrDude.setTypePEC(cspec.substring(0, 1));
    }
    catch (ApplicativeException ae)
    {
      throw CodesErreurs.getErreurServiceV1(ae, "SA98LD", structureInRestitutionInscriptionDude.getNumeroAllocataire());
    }
    return structureOutRestitutionInscrDude;
  }
  
  public SA98LD_OUT appelService(SA98LD_IN donneesIn)
    throws TechniqueException, ApplicativeException
  {
    ManagerAppelsServicesD98 managerService = new ManagerAppelsServicesD98();
    return managerService.SA98LD_DUDE_Restit_INS_DUDE(donneesIn.getZI98LDZJ5C());
  }
}

/* Location:
 * Qualified Name:     AppelV1RestitutionInscriptionDude
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */