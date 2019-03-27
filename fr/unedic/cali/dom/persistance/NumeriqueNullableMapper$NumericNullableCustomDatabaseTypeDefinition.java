package fr.unedic.cali.dom.persistance;

import xcalia.lido.api.ds.CustomDatabaseTypeDefinition;

public class NumeriqueNullableMapper$NumericNullableCustomDatabaseTypeDefinition
  implements CustomDatabaseTypeDefinition
{
  public int getSQLType()
  {
    return 2;
  }
  
  public String getDatabaseType()
  {
    return null;
  }
  
  public Class getStorageType()
  {
    return Integer.class;
  }
}

/* Location:
 * Qualified Name:     NumeriqueNullableMapper.NumericNullableCustomDatabaseTypeDefinition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */