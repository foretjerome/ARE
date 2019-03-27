package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.util.services.CoucheLogiqueException;
import java.util.HashMap;
import java.util.Map;

public class ContexteDecoupage
{
  public static final String TYPE_CONTEXTE_DECOUPAGE_AUCUN = "AUCUN";
  public static final String TYPE_CONTEXTE_DECOUPAGE_PMVS = "MVS";
  public static final String TYPE_CONTEXTE_DECOUPAGE_CSR = "CSR";
  public static final String TYPE_CONTEXTE_DECOUPAGE_METIER = "METIER";
  public static final String TYPE_CONTEXTE_DECOUPAGE_TOUS = "TOUS";
  public static final int[] EVENEMENTS_A_DECOUPER = { 14, 49 };
  public static Map<String, Integer> motifRupturePourContexteDecoupage = new HashMap();
  public static Map<Integer, String> contexteDecoupagePourEvenement = new HashMap();
  
  static
  {
    motifRupturePourContexteDecoupage.put("CSR", Integer.valueOf(99));
    contexteDecoupagePourEvenement.put(Integer.valueOf(14), "CSR");
    
    motifRupturePourContexteDecoupage.put("MVS", Integer.valueOf(97));
    contexteDecoupagePourEvenement.put(Integer.valueOf(49), "MVS");
  }
  
  public static int getMotifRupturePourContexteDecoupage(String contexteDecoupage)
    throws CoucheLogiqueException
  {
    Integer retour = (Integer)motifRupturePourContexteDecoupage.get(contexteDecoupage);
    if (retour == null) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("PR_CALI_OBJET_NON_TROUVEE", new Object[] { "Le contexte de découpage" });
    }
    return retour.intValue();
  }
  
  public static String getContexteDecoupagePourEvenement(int natureEvenement)
  {
    return (String)contexteDecoupagePourEvenement.get(Integer.valueOf(natureEvenement));
  }
}

/* Location:
 * Qualified Name:     ContexteDecoupage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */