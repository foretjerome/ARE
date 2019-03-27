package fr.unedic.cali.fabriques;

import fr.unedic.cali.dom.affectation.GammeAbstrait;
import fr.unedic.cali.dom.affectation.GammeAri;
import fr.unedic.cali.dom.affectation.GammeAsu;
import fr.unedic.cali.dom.affectation.GammeRbf;
import fr.unedic.cali.dom.affectation.GammeSpec;

public class FabriqueGammes
{
  private static FabriqueGammes s_instance = new FabriqueGammes();
  
  public static FabriqueGammes getInstance()
  {
    return s_instance;
  }
  
  public GammeSpec getGamme(String p_gamme)
  {
    GammeAbstrait gamme = null;
    if ((p_gamme.equals("RBF_03")) || (p_gamme.equals("RBF_04")) || (p_gamme.equals("RBF_02"))) {
      gamme = GammeRbf.getInstance();
    } else if ((p_gamme.equals("RBF_05")) || (p_gamme.equals("ARI_02"))) {
      gamme = GammeAri.getInstance();
    } else if ((p_gamme.equals("ASU_07")) || (p_gamme.equals("ASU_01"))) {
      gamme = GammeAsu.getInstance();
    } else if ((p_gamme.equals("ASU_13")) || (p_gamme.equals("ASU_14")) || (p_gamme.equals("ASU_15"))) {
      gamme = GammeAsu.getInstance();
    } else if ((p_gamme.equals("ASU_21")) || (p_gamme.equals("ASU_22"))) {
      gamme = GammeAsu.getInstance();
    }
    return gamme;
  }
}

/* Location:
 * Qualified Name:     FabriqueGammes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */