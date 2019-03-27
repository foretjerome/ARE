package fr.unedic.cali.dom.persistance;

import xcalia.lido.api.ds.CustomDatabaseTypeDefinition;

public class NumericToCharMapper$NumericToCharCustomDatabaseTypeDefinition
  implements CustomDatabaseTypeDefinition
{
  public int getSQLType()
  {
    return 1;
  }
  
  public String getDatabaseType()
  {
    return "CHAR(1)";
  }
  
  public Class getStorageType()
  {
    return String.class;
  }
}

/* Location:
 * Qualified Name:     NumericToCharMapper.NumericToCharCustomDatabaseTypeDefinition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */