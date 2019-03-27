package fr.unedic.cali.dom.persistance;

import java.math.BigDecimal;
import xcalia.lido.api.ds.CustomDatabaseTypeDefinition;

public class DecimalMapper22$DecimalCustomDatabaseTypeDefinition
  implements CustomDatabaseTypeDefinition
{
  public int getSQLType()
  {
    return 3;
  }
  
  public String getDatabaseType()
  {
    return "DECIMAL(2,2)";
  }
  
  public Class getStorageType()
  {
    return BigDecimal.class;
  }
}

/* Location:
 * Qualified Name:     DecimalMapper22.DecimalCustomDatabaseTypeDefinition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */