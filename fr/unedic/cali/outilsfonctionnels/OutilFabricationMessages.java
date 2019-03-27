package fr.unedic.cali.outilsfonctionnels;

import org.apache.commons.lang.StringUtils;

public class OutilFabricationMessages
{
  public static String parametrerMessage(String p_message, String p_parametre, String p_valeur)
  {
    return StringUtils.replace(p_message, p_parametre, p_valeur);
  }
}

/* Location:
 * Qualified Name:     OutilFabricationMessages
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */