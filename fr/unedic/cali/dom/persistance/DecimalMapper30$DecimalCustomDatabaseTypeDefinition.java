package fr.unedic.cali.dom.persistance;

import java.math.BigDecimal;
import xcalia.lido.api.ds.CustomDatabaseTypeDefinition;

public class DecimalMapper30$DecimalCustomDatabaseTypeDefinition
  implements CustomDatabaseTypeDefinition
{
  public int getSQLType()
  {
    return 3;
  }
  
  public String getDatabaseType()
  {
    return "DECIMAL(3,0)";
  }
  
  public Class getStorageType()
  {
    return BigDecimal.class;
  }
}

/* Location:
 * Qualified Name:     DecimalMapper30.DecimalCustomDatabaseTypeDefinition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */