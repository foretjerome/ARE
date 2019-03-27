package fr.unedic.cali.calcul.aides.cons;

import java.util.ArrayList;
import java.util.List;

public class ConstantesAide
{
  public static final String NON_DEROGATOIRE = "N";
  public static final String DEROGATOIRE = "O";
  public static final int CODE_SOUS_PRODUIT_TRANS = 15;
  public static final int CODE_SOUS_PRODUIT_HEBER = 16;
  public static final int CODE_SOUS_PRODUIT_REPAS = 17;
  public static final int CODE_SOUS_PRODUIT_DEROG = 25;
  public static final int CODE_SOUS_PRODUIT_AGEPI = 1;
  public static final int CODE_SOUS_PRODUIT_APRE = 1;
  public static final String EST_BENEFIAIRE_CSP = "CS";
  public static final String EST_BENEFIAIRE_RSA = "RS";
  public static final String EST_PMSMP = "PM";
  public static final int COMPLEMENT_TYPE_MONTANT_FORMATION_NON_DEROG = 13;
  public static final int COMPLEMENT_TYPE_MONTANT_FORMATION_DEROG = 23;
  public static final int COMPLEMENT_TYPE_MONTANT_RECHERCHE_NON_DEROG = 14;
  public static final int COMPLEMENT_TYPE_MONTANT_RECHERCHE_DEROG = 24;
  public static final int COMPLEMENT_TYPE_MONTANT_REPRISE_NON_DEROG = 15;
  public static final int COMPLEMENT_TYPE_MONTANT_REPRISE_DEROG = 25;
  public static List<String> s_codeSousProduit = new ArrayList();
  
  static
  {
    s_codeSousProduit.add(String.valueOf(15));
    s_codeSousProduit.add(String.valueOf(16));
    s_codeSousProduit.add(String.valueOf(17));
    s_codeSousProduit.add(String.valueOf(25));
  }
}

/* Location:
 * Qualified Name:     ConstantesAide
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */