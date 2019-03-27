package fr.pe.cali.reglementaire.decors.produitsreglementaires;

import fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.caa14.ProduitReglementaireCAA14P01;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.caa14.ProduitReglementaireCAA14P02;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.cge01.ProduitReglementaireCGE01P02;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.cge01.ProduitReglementaireCGE01P03;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.cge01.ProduitReglementaireCGE01P04;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.cge01.ProduitReglementaireCGE01P05;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.cge01.ProduitReglementaireCGE01P06;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.cge01.ProduitReglementaireCGE01P07;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.cge01.ProduitReglementaireCGE01P6B;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.csa06.ProduitReglementaireCSA06P01;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.csa06.ProduitReglementaireCSA06P02;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.csa06.ProduitReglementaireCSA06P03;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.csa06.ProduitReglementaireCSA06P04;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.csa06.ProduitReglementaireCSA06P05;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.csa06.ProduitReglementaireCSA06P06;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.csa06.ProduitReglementaireCSA06P5B;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.cva10.ProduitReglementaireCVA10P01;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.cva10.ProduitReglementaireCVA10P02;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.cve13.ProduitReglementaireCVE13P01;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.exp03.p01.ProduitReglementaireEXP03P01;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.fds12.ProduitReglementaireFDS12P02;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.fds12.ProduitReglementaireFDS12P03;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.spe02.ProduitReglementaireSPE02P03;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.spe02.ProduitReglementaireSPE02P04;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.spe02.ProduitReglementaireSPE02P05;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.spe02.ProduitReglementaireSPE02P06;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.ssp07.ProduitReglementaireSSP07P03;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.ssp07.ProduitReglementaireSSP07P05;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.inr.ces06.ProduitReglementaireCES06P01;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.solidarite.cge01.ProduitReglementaireCGE01P01;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.solidarite.cpa02.ProduitReglementaireCPA02P01;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class ReferentielProduitReglementaire
{
  private static ReferentielProduitReglementaire referentiel = new ReferentielProduitReglementaire();
  private Map<String, ProduitReglementaire> mapProduitReglementaire;
  
  private ReferentielProduitReglementaire()
  {
    mapProduitReglementaire = new HashMap();
    
    mapProduitReglementaire.put("ASU_CAA14_01", ProduitReglementaireCAA14P01.getInstance());
    mapProduitReglementaire.put("ASU_CAA14_02", ProduitReglementaireCAA14P02.getInstance());
    mapProduitReglementaire.put("ASU_CGE01_02", ProduitReglementaireCGE01P02.getInstance());
    mapProduitReglementaire.put("ASU_CGE01_03", ProduitReglementaireCGE01P03.getInstance());
    mapProduitReglementaire.put("ASU_CGE01_04", ProduitReglementaireCGE01P04.getInstance());
    mapProduitReglementaire.put("ASU_CGE01_05", ProduitReglementaireCGE01P05.getInstance());
    mapProduitReglementaire.put("ASU_CGE01_06", ProduitReglementaireCGE01P06.getInstance());
    mapProduitReglementaire.put("ASU_CGE01_6B", ProduitReglementaireCGE01P6B.getInstance());
    mapProduitReglementaire.put("ASU_CGE01_07", ProduitReglementaireCGE01P07.getInstance());
    mapProduitReglementaire.put("ASU_CSA06_01", ProduitReglementaireCSA06P01.getInstance());
    mapProduitReglementaire.put("ASU_CSA06_02", ProduitReglementaireCSA06P02.getInstance());
    mapProduitReglementaire.put("ASU_CSA06_03", ProduitReglementaireCSA06P03.getInstance());
    mapProduitReglementaire.put("ASU_CSA06_04", ProduitReglementaireCSA06P04.getInstance());
    mapProduitReglementaire.put("ASU_CSA06_05", ProduitReglementaireCSA06P05.getInstance());
    mapProduitReglementaire.put("ASU_CSA06_5B", ProduitReglementaireCSA06P5B.getInstance());
    mapProduitReglementaire.put("ASU_CSA06_06", ProduitReglementaireCSA06P06.getInstance());
    mapProduitReglementaire.put("ASU_CVA10_01", ProduitReglementaireCVA10P01.getInstance());
    mapProduitReglementaire.put("ASU_CVA10_02", ProduitReglementaireCVA10P02.getInstance());
    mapProduitReglementaire.put("ASU_CVE13_01", ProduitReglementaireCVE13P01.getInstance());
    mapProduitReglementaire.put("ASU_EXP03_01", ProduitReglementaireEXP03P01.getInstance());
    
    mapProduitReglementaire.put("ASU_SPE02_03", ProduitReglementaireSPE02P03.getInstance());
    mapProduitReglementaire.put("ASU_SPE02_04", ProduitReglementaireSPE02P04.getInstance());
    mapProduitReglementaire.put("ASU_SPE02_05", ProduitReglementaireSPE02P05.getInstance());
    mapProduitReglementaire.put("ASU_SPE02_06", ProduitReglementaireSPE02P06.getInstance());
    
    mapProduitReglementaire.put("ASU_SSP07_03", ProduitReglementaireSSP07P03.getInstance());
    mapProduitReglementaire.put("ASU_SSP07_05", ProduitReglementaireSSP07P05.getInstance());
    
    mapProduitReglementaire.put("ASU_FDS12_02", ProduitReglementaireFDS12P02.getInstance());
    mapProduitReglementaire.put("ASU_FDS12_03", ProduitReglementaireFDS12P03.getInstance());
    
    mapProduitReglementaire.put("SOL_CGE01_01", ProduitReglementaireCGE01P01.getInstance());
    
    mapProduitReglementaire.put("SOL_CPA02_01", ProduitReglementaireCPA02P01.getInstance());
    
    mapProduitReglementaire.put("INR_CES06_01", ProduitReglementaireCES06P01.getInstance());
  }
  
  public static ReferentielProduitReglementaire getInstance()
  {
    return referentiel;
  }
  
  public Collection<ProduitReglementaire> getListeProduitReglementaire()
  {
    return mapProduitReglementaire.values();
  }
  
  public ProduitReglementaire recupererProduitReglementaire(String codeProduit)
  {
    return (ProduitReglementaire)mapProduitReglementaire.get(codeProduit);
  }
}

/* Location:
 * Qualified Name:     ReferentielProduitReglementaire
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */