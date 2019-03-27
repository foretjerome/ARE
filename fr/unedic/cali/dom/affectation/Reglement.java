package fr.unedic.cali.dom.affectation;

import java.util.Hashtable;
import java.util.Map;
import java.util.StringTokenizer;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Reglement
{
  public static final String REGLEMENT_ANNEXE_1 = "A1";
  public static final String REGLEMENT_ANNEXE_10 = "A10";
  public static final String REGLEMENT_ANNEXE_11 = "A11";
  public static final String REGLEMENT_ANNEXE_2A = "A2a";
  public static final String REGLEMENT_ANNEXE_2B = "A2b";
  public static final String REGLEMENT_ANNEXE_3 = "A3";
  public static final String REGLEMENT_ANNEXE_4 = "A4";
  public static final String REGLEMENT_ANNEXE_5 = "A5";
  public static final String REGLEMENT_ANNEXE_6 = "A6";
  public static final String REGLEMENT_ANNEXE_7 = "A7";
  public static final String REGLEMENT_ANNEXE_8 = "A8";
  public static final String REGLEMENT_ANNEXE_9A = "A9A";
  public static final String REGLEMENT_ANNEXE_9B = "A9B";
  public static final String REGLEMENT_GENERAL = "RG";
  public static final String REGLEMENT_GENERAL_INTERIMAIRE = "RG5";
  public static final String REGLEMENT_GENERAL_PARTICULIER = "RGP";
  public static final String RG_OP = "OP";
  private ProduitSpec produit = null;
  private String nomReglement;
  private String libelle;
  private static Map<String, Reglement> listeDeReglements = null;
  
  private Reglement(String pNomReglement, ProduitSpec pProduit)
  {
    nomReglement = pNomReglement;
    produit = pProduit;
    libelle = getLibelleBouchon(pNomReglement);
  }
  
  public static synchronized Reglement getInstance(String pNomReglement, ProduitSpec pProduit)
  {
    if (listeDeReglements == null) {
      listeDeReglements = new Hashtable();
    }
    String clef = pNomReglement + "|" + pProduit.getNom();
    
    Reglement reglement = (Reglement)listeDeReglements.get(clef);
    if (reglement == null)
    {
      reglement = new Reglement(pNomReglement, pProduit);
      listeDeReglements.put(clef, reglement);
    }
    return reglement;
  }
  
  public static Reglement getInstance(String nomUnique)
  {
    StringTokenizer nom = new StringTokenizer(nomUnique, "|");
    String nomReglementCourant = nom.nextToken();
    String nomProduitCourant = nom.nextToken();
    
    return getInstance(nomReglementCourant, Parametres.getProduit(nomProduitCourant));
  }
  
  public ProduitSpec getProduit()
  {
    return produit;
  }
  
  public void setProduit(ProduitSpec pProduit)
  {
    produit = pProduit;
  }
  
  public String getNomReglement()
  {
    return nomReglement;
  }
  
  public String toString()
  {
    return getNomReglement() + " / " + getProduit().getNom();
  }
  
  public boolean equals(Object object)
  {
    boolean estEgal = false;
    if ((object instanceof Reglement))
    {
      Reglement aComparer = (Reglement)object;
      estEgal = (reglementsEgaux(aComparer)) && ((getProduit().estIdentiqueAuProduit(aComparer.getProduit())) || (aComparer.getProduit().estIdentiqueAuProduit(getProduit())));
    }
    return estEgal;
  }
  
  public boolean reglementsEgaux(Reglement reglementAComparer)
  {
    boolean reglementsEgaux = false;
    if (reglementAComparer != null) {
      reglementsEgaux = estNomReglementIdentique(reglementAComparer.getNomReglement());
    }
    return reglementsEgaux;
  }
  
  public boolean estNomReglementIdentique(String nomReglementAComparer)
  {
    boolean estNomIdentique = getNomReglement().equals(nomReglementAComparer);
    
    boolean estReglementGeneralParticulier = ("RGP".equals(getNomReglement())) || ("RGP".equals(nomReglementAComparer));
    
    boolean estReglementGeneral = ("RG".equals(getNomReglement())) || ("RG".equals(nomReglementAComparer));
    if ((estReglementGeneralParticulier) && (estReglementGeneral)) {
      estNomIdentique = true;
    }
    return estNomIdentique;
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getNomReglement()).append(getProduit().getCode()).toHashCode();
  }
  
  public void setNomReglement(String pNomReglement)
  {
    nomReglement = pNomReglement;
  }
  
  public String getLibelle()
  {
    return libelle;
  }
  
  public String getLibelleCourt()
  {
    String libelleCourt = getNomReglement();
    if (libelleCourt.equals("RGP")) {
      libelleCourt = "RG(P)";
    }
    return libelleCourt.toUpperCase();
  }
  
  public void setLibelle(String pLibelle)
  {
    libelle = pLibelle;
  }
  
  private String getLibelleBouchon(String pNomReglement)
  {
    String libelleCourant;
    String libelleCourant;
    if (pNomReglement.equals("RG"))
    {
      libelleCourant = "Règlement général";
    }
    else
    {
      String libelleCourant;
      if (pNomReglement.equals("RGP")) {
        libelleCourant = "Règlement général particulier";
      } else {
        libelleCourant = "Annexe ".concat(pNomReglement);
      }
    }
    return libelleCourant;
  }
  
  public void jdoPostLoad() {}
  
  public void jdoPreClear() {}
  
  public void jdoPreDelete() {}
  
  public void jdoPreStore() {}
}

/* Location:
 * Qualified Name:     Reglement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */