package fr.unedic.cali.autresdoms.d90.outilsfonctionnels;

import fr.unedic.cali.autresdoms.d90.dom.comportement.ComportementTPDefaut;
import fr.unedic.cali.autresdoms.d90.dom.spec.ComportementSpec;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

public class OutilComportement
{
  private static Map s_listeElements = new HashMap();
  private static boolean s_estInitialise = false;
  
  private static void inscrireElements() {}
  
  private static void definirComportementTPParDefaut()
  {
    ComportementSpec comportementTPDefaut = new ComportementTPDefaut();
    inscrireElement(comportementTPDefaut);
  }
  
  public static ComportementSpec getComportementParDefaut()
  {
    return getComportement("comportementTPDefaut");
  }
  
  private static void inscrireElement(ComportementSpec p_comportement)
  {
    if (p_comportement != null)
    {
      if (s_listeElements == null) {
        s_listeElements = new HashMap();
      }
      s_listeElements.put(p_comportement.getIdentifiantComportement().toUpperCase(), p_comportement);
    }
  }
  
  public static ComportementSpec getComportement(String p_identifiantComportement)
  {
    if (p_identifiantComportement != null)
    {
      if (!s_estInitialise)
      {
        inscrireElements();
        s_estInitialise = true;
      }
      return (ComportementSpec)s_listeElements.get(p_identifiantComportement.toUpperCase());
    }
    return null;
  }
  
  public static boolean reexaminerDecisionsMigrees(ComportementSpec p_comportement)
  {
    return (p_comportement != null) && (StringUtils.equals("R", p_comportement.getRexamenDecisionMigrees()));
  }
  
  public static boolean reconduireDecisionsMigrees(ComportementSpec p_comportement)
  {
    return (p_comportement != null) && (StringUtils.equals("D", p_comportement.getRexamenDecisionMigrees()));
  }
  
  public static boolean remettreEnCauseDecisionsMigrees(ComportementSpec p_comportement)
  {
    return (p_comportement != null) && (StringUtils.equals("C", p_comportement.getRexamenDecisionMigrees()));
  }
  
  public static ComportementSpec definirProchainComportementAAppliquer(ComportementSpec p_comportement)
  {
    if ((p_comportement == null) || ((p_comportement.isApplicationSurPremiereDecision()) && (p_comportement.isUtilise()))) {
      return getComportementParDefaut();
    }
    return p_comportement;
  }
}

/* Location:
 * Qualified Name:     OutilComportement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */