package fr.pe.cali.reglementaire.outils.logs;

import fr.pe.cali.reglementaire.outils.spec.IOutilCorpsRegle;
import fr.unedic.cali.outilsfonctionnels.OutilTrace;

public class OutilLog
{
  private boolean logActive = false;
  private static final String PREFIX = "<";
  private static final String SEPARATION = " : '";
  private static final String SUFFIXE = "'>";
  private static final String PREFIX_ENTREE = "<DONNEES_ENTREE>";
  private static final String SUFFIXE_ENTREE = "</DONNEES_ENTREE>";
  private static final String ELEMENT_OUTIL = "Implementation";
  private static final String PREFIX_RESUTLAT = "<RESULTAT>";
  private static final String SUFFIXE_RESULTAT = "</RESULTAT>";
  
  public OutilLog()
  {
    logActive = true;
  }
  
  public boolean isLogActive()
  {
    return (logActive) && (OutilTrace.isLogActivePourNiveauDebug());
  }
  
  public void activerLog()
  {
    logActive = true;
  }
  
  public void desactiverLog()
  {
    logActive = false;
  }
  
  public static String formaterElement(String nomElement, String valeurElement)
  {
    StringBuffer buffer = new StringBuffer();
    buffer.append("<");
    buffer.append(nomElement);
    buffer.append(" : '");
    buffer.append(valeurElement);
    buffer.append("'>");
    return buffer.toString();
  }
  
  public static String formaterDonneesEnEntreeFabrique(String donneesEntree)
  {
    StringBuffer buffer = new StringBuffer();
    buffer.append("<DONNEES_ENTREE>");
    buffer.append(donneesEntree);
    buffer.append("</DONNEES_ENTREE>");
    return buffer.toString();
  }
  
  public static String formaterOutilReglementaire(IOutilCorpsRegle outil)
  {
    return formaterElement("Implementation", outil.getNomOutil());
  }
  
  public static String formaterDonneesResultatFabrique(String resultat)
  {
    StringBuffer buffer = new StringBuffer();
    buffer.append("<RESULTAT>");
    buffer.append(resultat);
    buffer.append("</RESULTAT>");
    return buffer.toString();
  }
  
  public static void ecrireTrace(String message)
  {
    OutilTrace.ecrireMessagePourNiveauDebug(message);
  }
}

/* Location:
 * Qualified Name:     OutilLog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */