package fr.unedic.cali.outilsfonctionnels.cohabitation.sigma.rechercheAliasNCP;

import fr.pe.cali.client.ManagerAppelsServicesD01;
import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.cohab.sigma.CodesErreurs;
import fr.unedic.cali.autresdoms.cohab.sigma.rechercheAliasNCP.dom.StructureOutRechercheAliasNCP;
import fr.unedic.cali.autresdoms.cohab.sigma.rechercheAliasNCP.dom.StructureOutRechercheAliasNCPReferent;
import fr.unedic.cali.autresdoms.cohab.sigma.rechercheAliasNCP.dom.spec.StructureInRechercheAliasNCPSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.rechercheAliasNCP.dom.spec.StructureOutRechercheAliasNCPReferentSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.rechercheAliasNCP.dom.spec.StructureOutRechercheAliasNCPSpec;
import fr.unedic.logique.donnees.rac.commun.dra.d01.zu.SA01TB_IN;
import fr.unedic.logique.donnees.rac.commun.dra.d01.zu.SA01TB_OUT;
import fr.unedic.logique.donnees.rac.commun.dra.d01.zu.SA01TN_IN;
import fr.unedic.logique.donnees.rac.commun.dra.d01.zu.SA01TN_OUT;
import fr.unedic.logique.donnees.rac.commun.dra.zu.MI89;
import fr.unedic.logique.donnees.rac.commun.dra.zu.MI8G;
import fr.unedic.logique.donnees.rac.commun.dra.zu.MI8H;
import fr.unedic.logique.donnees.rac.commun.dra.zu.ZI01TBMI8G;
import fr.unedic.logique.donnees.rac.commun.dra.zu.ZI01TNMI89;
import fr.unedic.logique.donnees.rac.commun.dra.zu.ZO01TBMI8H;
import fr.unedic.logique.donnees.rac.commun.dra.zu.ZO01TNMI89;
import fr.unedic.logique.donnees.rac.commun.dra.zu.ZO01TNMI89IT;
import fr.unedic.logique.donnees.rac.commun.dra.zu.ZO01TNMI89LT;
import fr.unedic.logique.service.rac.commun.dra.d01.DomaineD01Fabrique;
import java.math.BigDecimal;
import java.util.List;

public class AppelRechercheAliasNCP
{
  public StructureOutRechercheAliasNCPSpec lireIndividuNCP(StructureInRechercheAliasNCPSpec criteresIndividuBni)
    throws ApplicativeException, TechniqueException
  {
    StructureOutRechercheAliasNCPSpec structureOutIndividuBni = new StructureOutRechercheAliasNCP();
    try
    {
      SA01TN_IN bniIn = SA01TN_IN.getInstance();
      ZI01TNMI89 d01In = bniIn.setNewZI01TNMI89();
      
      SA01TN_OUT bniOut = null;
      ZO01TNMI89 d01Out = null;
      
      MI89 mi89 = null;
      
      MI89 zoneComIn = d01In.setNewMI89_COMMUNICATION__IN_ET__OUT_SA01TN();
      
      String cxala = criteresIndividuBni.getNumeroAllocataire();
      String rsin = criteresIndividuBni.getIdentifiantSigma();
      String cincp = criteresIndividuBni.getCodeAliasNCP();
      String codeAssedic = criteresIndividuBni.getCodeAssedic();
      
      BigDecimal bdCxala = null;
      if (cxala != null) {
        bdCxala = new BigDecimal(cxala);
      }
      zoneComIn.setCXALA_IDENTIFIANT_NATIONAL_ALADIN(bdCxala);
      zoneComIn.setCXALAK_IDENTIFIANT_ALIAS_NCP(cincp);
      zoneComIn.setCXASS_CODE_ASSEDIC(codeAssedic);
      zoneComIn.setCXIN_IDENTIFIANT_DE_L_INDIVIDU(rsin);
      
      bniOut = appelServiceS0101TN(bniIn);
      d01Out = bniOut.getZO01TNMI89();
      
      ZO01TNMI89LT liste = d01Out.getZO01TNMI89LT();
      cxala = "";
      codeAssedic = "";
      rsin = "";
      cincp = "";
      if ((liste != null) && (liste.getNbListZO01TNMI89IT() > 0))
      {
        mi89 = ((ZO01TNMI89IT)liste.getListZO01TNMI89IT().get(0)).getMI89_COMMUNICATION__IN_ET__OUT_SA01TN();
        if (mi89 != null)
        {
          cxala = mi89.getCXALA_IDENTIFIANT_NATIONAL_ALADIN().toString();
          
          codeAssedic = mi89.getCXASS_CODE_ASSEDIC();
          
          rsin = mi89.getCXIN_IDENTIFIANT_DE_L_INDIVIDU();
          
          cincp = mi89.getCXALAK_IDENTIFIANT_ALIAS_NCP();
        }
      }
      if (cincp == null)
      {
        structureOutIndividuBni = null;
      }
      else
      {
        structureOutIndividuBni.setNumeroAllocataire(cxala);
        structureOutIndividuBni.setIdentifiantSigma(rsin);
        structureOutIndividuBni.setCodeAssedic(codeAssedic);
        structureOutIndividuBni.setCodeAliasNCP(cincp);
      }
    }
    catch (ApplicativeException ae)
    {
      if ((ae.getCode().equals("R01H SA01I5          UR003000")) || (ae.getCode().equals("R01H SA01TN          UW104000")) || (ae.getCode().equals("R01H SA01TN          UW105000"))) {
        structureOutIndividuBni = null;
      } else {
        throw CodesErreurs.getErreurServiceV1(ae, "SA01TN", criteresIndividuBni.getNumeroAllocataire());
      }
    }
    return structureOutIndividuBni;
  }
  
  public StructureOutRechercheAliasNCPReferentSpec lireIndividuNCPReferent(StructureInRechercheAliasNCPSpec p_criteresIndividuBni)
    throws ApplicativeException, TechniqueException
  {
    StructureOutRechercheAliasNCPReferentSpec structureOutIndividuBni = new StructureOutRechercheAliasNCPReferent();
    DomaineD01Fabrique.getDomaineD01ServiceSync();
    try
    {
      SA01TB_IN bniIn = SA01TB_IN.getInstance();
      ZI01TBMI8G d01In = bniIn.setNewZI01TBMI8G();
      MI8G zoneComIn = d01In.setNewMI8G_ZC__IN_SA01TB();
      
      String rsin = p_criteresIndividuBni.getIdentifiantSigma();
      String cincp = p_criteresIndividuBni.getCodeAliasNCP();
      String codeAssedic = p_criteresIndividuBni.getCodeAssedic();
      
      zoneComIn.setCXASS_CODE_ASSEDIC(codeAssedic);
      zoneComIn.setCXIN_IDENTIFIANT_DE_L_INDIVIDU(rsin);
      zoneComIn.setCXALAK_IDENTIFIANT_ALIAS_NCP(cincp);
      
      SA01TB_OUT bniOut = appelServiceS0101TB(bniIn);
      ZO01TBMI8H d01Out = bniOut.getZO01TBMI8H();
      
      MI8H mi8h = d01Out.getMI8H_ZC__OUT_SA01TB();
      if (mi8h != null) {
        if (mi8h.getCXALAK_IDENTIFIANT_ALIAS_NCP() != null)
        {
          structureOutIndividuBni.setNumeroAllocataire(mi8h.getCXALA_IDENTIFIANT_NATIONAL_ALADIN().toString());
          structureOutIndividuBni.setCodeAssedic(mi8h.getCXASS_CODE_ASSEDIC());
          structureOutIndividuBni.setIdentifiantSigma(mi8h.getCXIN_IDENTIFIANT_DE_L_INDIVIDU());
          structureOutIndividuBni.setCodeAliasNCP(mi8h.getCXALAK_IDENTIFIANT_ALIAS_NCP());
          structureOutIndividuBni.setTopReferent(mi8h.getFFREF_TOP_REFERENT());
          structureOutIndividuBni.setCodeAntenne(mi8h.getCDANT_ANTENNE_DE_L_INDIVIDU());
          structureOutIndividuBni.setIdentifiantDNA(mi8h.getISDNA_Valeur_Identifiant_DNA());
        }
        else
        {
          structureOutIndividuBni = null;
        }
      }
    }
    catch (ApplicativeException ae)
    {
      throw CodesErreurs.getErreurServiceV1(ae, "SA01TB", p_criteresIndividuBni.getNumeroAllocataire());
    }
    return structureOutIndividuBni;
  }
  
  public SA01TN_OUT appelServiceS0101TN(SA01TN_IN donneesIn)
    throws TechniqueException, ApplicativeException
  {
    ManagerAppelsServicesD01 managerService = new ManagerAppelsServicesD01();
    SA01TN_OUT sortie = SA01TN_OUT.getInstance();
    sortie.setZO01TNMI89(managerService.SA01TN_RECHERCHE_CORRESPONDANCE_CXALA_ALIAS(donneesIn.getZI01TNMI89()));
    return sortie;
  }
  
  public SA01TB_OUT appelServiceS0101TB(SA01TB_IN donneesIn)
    throws TechniqueException, ApplicativeException
  {
    ManagerAppelsServicesD01 managerService = new ManagerAppelsServicesD01();
    SA01TB_OUT sortie = SA01TB_OUT.getInstance();
    sortie.setZO01TBMI8H(managerService.SA01TB_SA_BATCH_NCP(donneesIn.getZI01TBMI8G()));
    return sortie;
  }
}

/* Location:
 * Qualified Name:     AppelRechercheAliasNCP
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */