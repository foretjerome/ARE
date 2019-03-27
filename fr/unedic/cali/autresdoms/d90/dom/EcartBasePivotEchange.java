package fr.unedic.cali.autresdoms.d90.dom;

import java.util.Date;
import java.util.Map;

public class EcartBasePivotEchange
{
  public static final String TYPE_DEMANDE_PIVOT = "Demande Pivot";
  public static final String TYPE_DECISION_PIVOT = "Decision Pivot";
  public static final String TYPE_ATTRIBUTION_PIVOT = "Attribution Pivot";
  public static final String TYPE_AIDES_PIVOT = "Aides Pivot";
  public static final String TYPE_AIDE = "Aide";
  public static final String TYPE_PBJC = "PBJC";
  public static final String TYPE_PRIME = "Prime";
  public static final String TYPE_ENQUETE = "Enquete";
  public static final String TYPE_DROIT = "Droit";
  public static final String TYPE_INDIVIDU = "Individu";
  public static final String TYPE_DISPOSITIF = "Dispositif";
  public static final String TYPE_DIFFERENCE_NOUVEAU = "NOUVEAU";
  public static final String TYPE_DIFFERENCE_MANQUANT = "MANQUANT";
  public static final String TYPE_DIFFERENCE_MAJ = "MAJ";
  public static final String PARAMETRE_NOM_COMPARE = "attributNomCompare";
  public static final String PARAMETRE_TYPE = "attributType";
  public static final String PARAMETRE_TYPE_DIFFERENCE = "attributTypeDifference";
  public static final String PARAMETRE_CLE_TECHNIQUE = "cleTechnique";
  public static final String PARAMETRE_CLE_FONCTIONNELLE = "cleFonctionnelle";
  public static final String PARAMETRE_VALEUR_AVANT = "attributValeurAvant";
  public static final String PARAMETRE_VALEUR_APRES = "attributValeurApres";
  public static final String PARAMETRE_TIMESTAMP_AVANT = "timestampAvant";
  private String m_type;
  private String m_cleTechnique;
  private String m_cleFonctionnelle;
  private String m_typeDifference;
  private String m_nomAttributCompare;
  private String m_valeurAvant;
  private String m_valeurApres;
  private Date m_timestampValeurAvant;
  
  public EcartBasePivotEchange() {}
  
  public EcartBasePivotEchange(Map p_parametresEcartBase, String p_typeDifferenceEcartBase)
  {
    m_typeDifference = p_typeDifferenceEcartBase;
    m_type = ((String)p_parametresEcartBase.get("attributType"));
    if (p_parametresEcartBase.containsKey("timestampAvant")) {
      m_timestampValeurAvant = ((Date)p_parametresEcartBase.get("timestampAvant"));
    }
    if (p_parametresEcartBase.containsKey("cleFonctionnelle")) {
      m_cleFonctionnelle = ((String)p_parametresEcartBase.get("cleFonctionnelle"));
    }
    if (p_parametresEcartBase.containsKey("attributNomCompare"))
    {
      m_nomAttributCompare = ((String)p_parametresEcartBase.get("attributNomCompare"));
      m_cleTechnique = ((String)p_parametresEcartBase.get("cleTechnique") + m_nomAttributCompare.hashCode());
    }
    else
    {
      m_cleTechnique = ((String)p_parametresEcartBase.get("cleTechnique"));
    }
    Object valeurAvant = p_parametresEcartBase.get("attributValeurAvant");
    if (valeurAvant != null) {
      m_valeurAvant = valeurAvant.toString();
    }
    Object valeurApres = p_parametresEcartBase.get("attributValeurApres");
    if (valeurApres != null) {
      m_valeurApres = valeurApres.toString();
    }
  }
  
  public String getType()
  {
    return m_type;
  }
  
  public void setType(String p_type)
  {
    m_type = p_type;
  }
  
  public String getCleTechnique()
  {
    return m_cleTechnique;
  }
  
  public void setCleTechnique(String p_cleTechnique)
  {
    m_cleTechnique = p_cleTechnique;
  }
  
  public String getCleFonctionnelle()
  {
    return m_cleFonctionnelle;
  }
  
  public void setCleFonctionnelle(String p_cleFonctionnelle)
  {
    m_cleFonctionnelle = p_cleFonctionnelle;
  }
  
  public String getTypeDifference()
  {
    return m_typeDifference;
  }
  
  public void setTypeDifference(String p_typeDifference)
  {
    m_typeDifference = p_typeDifference;
  }
  
  public String getNomAttributCompare()
  {
    return m_nomAttributCompare;
  }
  
  public void setNomAttributCompare(String p_nomAttributCompare)
  {
    m_nomAttributCompare = p_nomAttributCompare;
  }
  
  public String getValeurAvant()
  {
    return m_valeurAvant;
  }
  
  public void setValeurAvant(String p_valeurAvant)
  {
    m_valeurAvant = p_valeurAvant;
  }
  
  public String getValeurApres()
  {
    return m_valeurApres;
  }
  
  public void setValeurApres(String p_valeurApres)
  {
    m_valeurApres = p_valeurApres;
  }
  
  public Date getTimestampValeurAvant()
  {
    return m_timestampValeurAvant;
  }
  
  public void setTimestampValeurAvant(Date p_timestampValeurAvant)
  {
    m_timestampValeurAvant = p_timestampValeurAvant;
  }
}

/* Location:
 * Qualified Name:     EcartBasePivotEchange
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */