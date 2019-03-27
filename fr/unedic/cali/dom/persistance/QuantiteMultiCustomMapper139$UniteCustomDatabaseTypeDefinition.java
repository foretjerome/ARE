package fr.unedic.cali.dom.persistance;

import xcalia.lido.api.ds.CustomDatabaseTypeDefinition;

public class QuantiteMultiCustomMapper139$UniteCustomDatabaseTypeDefinition
  implements CustomDatabaseTypeDefinition
{
  public int getSQLType()
  {
    return 1;
  }
  
  public String getDatabaseType()
  {
    return "CHAR(2)";
  }
  
  public Class getStorageType()
  {
    return String.class;
  }
}

/* Location:
 * Qualified Name:     QuantiteMultiCustomMapper139.UniteCustomDatabaseTypeDefinition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */