package fr.unedic.cali.autresdoms.ga.dom;

import org.apache.commons.lang.StringUtils;

public class CompteurIndexPASContratTravail
{
  public static final String SEPARATEUR_GAEC_INDEX = "-";
  private int m_index;
  private String m_prefixIdentifiant;
  
  public static String recupererPrefixeIdentifiant(String p_identifiant)
  {
    if (p_identifiant != null)
    {
      String[] elements = decouperIdentifiant(p_identifiant);
      if ((elements != null) && (elements.length > 1)) {
        return elements[0];
      }
      return null;
    }
    return null;
  }
  
  public static String recupererSuffixeIdentifiant(String p_identifiant)
  {
    if (p_identifiant != null)
    {
      String[] elements = decouperIdentifiant(p_identifiant);
      if ((elements != null) && (elements.length == 2)) {
        return elements[1];
      }
      return null;
    }
    return null;
  }
  
  private static String[] decouperIdentifiant(String p_identifiant)
  {
    return StringUtils.split(p_identifiant, "-");
  }
  
  public CompteurIndexPASContratTravail(String p_prefixIdentifiant)
  {
    m_prefixIdentifiant = p_prefixIdentifiant;
    m_index = 0;
  }
  
  public String getProchainIndexPAS()
  {
    return m_prefixIdentifiant + "-" + m_index++;
  }
}

/* Location:
 * Qualified Name:     CompteurIndexPASContratTravail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */