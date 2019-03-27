package fr.pe.cali.reglementaire.dom.impl;

import fr.pe.cali.reglementaire.outils.logs.OutilLog;
import fr.unedic.util.temps.Damj;
import java.util.List;

public class CriteresFabriqueReglementaire
{
  private String codeProduit;
  private Damj date;
  private List<String> listeContextesFonctionnels;
  private List<String> listeContextesReglementaires;
  private static final String ELEMENT_PRODUIT = "Produit";
  private static final String ELEMENT_DATE_RECHERCHE = "Date de recherche";
  private static final String ELEMENT_CTX_FONC = "Ctx fonc";
  private static final String ELEMENT_CTX_REGL = "Ctx regl.";
  private static final String PREFIXE = "<CRITERES>";
  private static final String SUFFIXE = "</CRITERES>";
  private static final String AUCUN = "Aucun";
  
  public String getCodeProduit()
  {
    return codeProduit;
  }
  
  public void setCodeProduit(String codeProduit)
  {
    this.codeProduit = codeProduit;
  }
  
  public Damj getDate()
  {
    return date;
  }
  
  public void setDate(Damj date)
  {
    this.date = date;
  }
  
  public List<String> getListeContextesFonctionnels()
  {
    return listeContextesFonctionnels;
  }
  
  public void setListeContextesFonctionnels(List<String> listeContextesFonctionnels)
  {
    this.listeContextesFonctionnels = listeContextesFonctionnels;
  }
  
  public List<String> getListeContextesReglementaires()
  {
    return listeContextesReglementaires;
  }
  
  public void setListeContextesReglementaires(List<String> listeContextesReglementaires)
  {
    this.listeContextesReglementaires = listeContextesReglementaires;
  }
  
  public String toString()
  {
    StringBuffer buffer = new StringBuffer();
    buffer.append("<CRITERES>");
    buffer.append(OutilLog.formaterElement("Date de recherche", getDate().toString()));
    buffer.append(OutilLog.formaterElement("Produit", getCodeProduit()));
    traiterListeContexte(getListeContextesFonctionnels(), "Ctx fonc", buffer);
    traiterListeContexte(getListeContextesReglementaires(), "Ctx regl.", buffer);
    buffer.append("</CRITERES>");
    return buffer.toString();
  }
  
  private void traiterListeContexte(List<String> listeContexte, String element, StringBuffer buffer)
  {
    if (listeContexte != null) {
      for (String ctxCourant : listeContexte) {
        buffer.append(OutilLog.formaterElement(element, ctxCourant));
      }
    } else {
      buffer.append(OutilLog.formaterElement(element, "Aucun"));
    }
  }
}

/* Location:
 * Qualified Name:     CriteresFabriqueReglementaire
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */