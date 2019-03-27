package fr.unedic.cali.outilsfonctionnels.cohabitation.sigma.tranchedevie;

import fr.pe.cali.client.ManagerAppelsServicesD01;
import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.cohab.sigma.CodesErreurs;
import fr.unedic.cali.autresdoms.cohab.sigma.tranchedevie.dom.StructureOutTrancheDeVie;
import fr.unedic.cali.autresdoms.cohab.sigma.tranchedevie.dom.spec.StructureInTrancheDeVieSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.tranchedevie.dom.spec.StructureOutTrancheDeVieSpec;
import fr.unedic.logique.donnees.rac.commun.dra.d01.zu.SA01TB_IN;
import fr.unedic.logique.donnees.rac.commun.dra.d01.zu.SA01TB_OUT;
import fr.unedic.logique.donnees.rac.commun.dra.zu.MI8G;
import fr.unedic.logique.donnees.rac.commun.dra.zu.MI8H;
import fr.unedic.logique.donnees.rac.commun.dra.zu.ZI01TBMI8G;
import fr.unedic.logique.donnees.rac.commun.dra.zu.ZO01TBMI8H;
import fr.unedic.util.services.CoucheLogiqueException;

public class AppelTrancheDeVie
{
  private static final String NOM_SERVICE = "SA01TB";
  public static String ERR_UW001000 = "R01H SA01TB          UW001000";
  public static String ERR_UW002000 = "R01H SA01TB          UW002000";
  public static String ERR_UW003000 = "R01H SA01TB          UW003000";
  public static String ERR_UW004000 = "R01H SA01TB          UW004000";
  public static String ERR_UW005000 = "R01H SA01TB          UW005000";
  public static String ERR_UW006000 = "R01H SA01TB          UW006000";
  public static String ERR_UW007000 = "R01H SA01TB          UW007000";
  
  public StructureOutTrancheDeVieSpec lireTrancheDeVie(StructureInTrancheDeVieSpec structureIn)
    throws TechniqueException, CoucheLogiqueException
  {
    StructureOutTrancheDeVieSpec structureOut = null;
    try
    {
      SA01TB_IN bniIn = creerSA01TB_IN(structureIn);
      
      SA01TB_OUT bniOut = appelService(bniIn);
      
      structureOut = creerStructureOutTrancheDeVie(bniOut);
    }
    catch (ApplicativeException ae)
    {
      throw CodesErreurs.getErreurServiceV1(ae, "SA01TB", "CXALAK:" + structureIn.getIdentifiantNCP() + " - ASS/RSIN:" + structureIn.getCodeAssedic() + "/" + structureIn.getRSIN());
    }
    return structureOut;
  }
  
  private StructureOutTrancheDeVieSpec creerStructureOutTrancheDeVie(SA01TB_OUT bniOut)
  {
    StructureOutTrancheDeVieSpec stOut = new StructureOutTrancheDeVie();
    
    MI8H mi8h = bniOut.getZO01TBMI8H().getMI8H_ZC__OUT_SA01TB();
    
    stOut.setCodeAntenne(mi8h.getCDANT_ANTENNE_DE_L_INDIVIDU());
    stOut.setCodeAssedic(mi8h.getCXASS_CODE_ASSEDIC());
    stOut.setIdentifiantBNI(mi8h.getCXALA_IDENTIFIANT_NATIONAL_ALADIN());
    stOut.setIdentifiantDNA(mi8h.getISDNA_Valeur_Identifiant_DNA());
    stOut.setIdentifiantNCP(mi8h.getCXALAK_IDENTIFIANT_ALIAS_NCP());
    stOut.setRSIN(mi8h.getCXIN_IDENTIFIANT_DE_L_INDIVIDU());
    stOut.setTopReferent(mi8h.getFFREF_TOP_REFERENT());
    
    return stOut;
  }
  
  private SA01TB_IN creerSA01TB_IN(StructureInTrancheDeVieSpec stIn)
  {
    SA01TB_IN bniIn = SA01TB_IN.getInstance();
    ZI01TBMI8G zI01TBMI8G = ZI01TBMI8G.getInstance();
    MI8G mI8G = MI8G.getInstance();
    
    mI8G.setCXALAK_IDENTIFIANT_ALIAS_NCP(stIn.getIdentifiantNCP());
    mI8G.setCXASS_CODE_ASSEDIC(stIn.getCodeAssedic());
    mI8G.setCXIN_IDENTIFIANT_DE_L_INDIVIDU(stIn.getRSIN());
    
    zI01TBMI8G.setMI8G_ZC__IN_SA01TB(mI8G);
    bniIn.setZI01TBMI8G(zI01TBMI8G);
    
    return bniIn;
  }
  
  public SA01TB_OUT appelService(SA01TB_IN donneesIn)
    throws TechniqueException, ApplicativeException
  {
    ManagerAppelsServicesD01 managerService = new ManagerAppelsServicesD01();
    SA01TB_OUT sortie = SA01TB_OUT.getInstance();
    sortie.setZO01TBMI8H(managerService.SA01TB_SA_BATCH_NCP(donneesIn.getZI01TBMI8G()));
    return sortie;
  }
}

/* Location:
 * Qualified Name:     AppelTrancheDeVie
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */