package fr.unedic.cali.util;

public final class TriState
{
  public static final int UNKNOWN = -1;
  public static final int FALSE = 0;
  public static final int TRUE = 1;
  private static TriState[] s_instances = { new TriState(-1), new TriState(0), new TriState(1) };
  private int m_value = -1;
  
  public static TriState getInstance(int p_value)
  {
    int value = p_value;
    if ((value < -1) || (value > 1)) {
      value = -1;
    }
    return s_instances[(p_value + 1)];
  }
  
  public static TriState valueOf(String p_strValue)
  {
    int value = -1;
    if (p_strValue != null) {
      if ((p_strValue.equalsIgnoreCase("o")) || (p_strValue.equalsIgnoreCase("oui"))) {
        value = 1;
      } else if ((p_strValue.equalsIgnoreCase("n")) || (p_strValue.equalsIgnoreCase("non"))) {
        value = 0;
      }
    }
    return getInstance(value);
  }
  
  private TriState(int p_value)
  {
    m_value = p_value;
  }
  
  public boolean estVrai()
  {
    return m_value == 1;
  }
  
  public boolean estFaux()
  {
    return m_value == 0;
  }
  
  public boolean estInconnu()
  {
    return m_value == -1;
  }
}

/* Location:
 * Qualified Name:     TriState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */