package fr.unedic.cali.outilsfonctionnels;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OutilActionFormationJeune
{
  private static final Pattern FORME_1 = Pattern.compile("^41C\\w\\w8.*");
  private static final Pattern FORME_2 = Pattern.compile("^40C\\d\\d((09)|(10))12.*");
  
  public static boolean estFormationJeune(String p_numeroConvention)
  {
    return (FORME_1.matcher(p_numeroConvention).matches()) || (FORME_2.matcher(p_numeroConvention).matches());
  }
}

/* Location:
 * Qualified Name:     OutilActionFormationJeune
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */