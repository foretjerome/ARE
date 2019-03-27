package fr.unedic.cali.outilsfonctionnels;

class TracesTemps$Appel
{
  private Long millis;
  private String ligneCode;
  
  public TracesTemps$Appel(TracesTemps paramTracesTemps, Long p_millis, String p_ligneCode)
  {
    millis = p_millis;
    ligneCode = p_ligneCode;
  }
  
  public Long getMillis()
  {
    return millis;
  }
  
  public String getLigneCode()
  {
    return ligneCode;
  }
}

/* Location:
 * Qualified Name:     TracesTemps.Appel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */