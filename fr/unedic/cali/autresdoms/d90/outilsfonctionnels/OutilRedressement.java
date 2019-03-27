package fr.unedic.cali.autresdoms.d90.outilsfonctionnels;

import fr.unedic.cali.autresdoms.d90.dom.Redressement;
import fr.unedic.cali.autresdoms.d90.dom.spec.RedressementSpec;
import org.apache.commons.lang.StringUtils;

public class OutilRedressement
{
  public static RedressementSpec getInstance()
  {
    return new Redressement();
  }
  
  public static boolean estEnModeListe(RedressementSpec p_redressement)
  {
    return (p_redressement != null) && (StringUtils.equalsIgnoreCase(p_redressement.getModeRedressement(), "List"));
  }
}

/* Location:
 * Qualified Name:     OutilRedressement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */