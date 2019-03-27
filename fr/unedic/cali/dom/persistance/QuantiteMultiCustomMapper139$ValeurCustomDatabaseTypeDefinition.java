package fr.unedic.cali.dom.persistance;

import java.math.BigDecimal;
import xcalia.lido.api.ds.CustomDatabaseTypeDefinition;

public class QuantiteMultiCustomMapper139$ValeurCustomDatabaseTypeDefinition
  implements CustomDatabaseTypeDefinition
{
  public int getSQLType()
  {
    return 3;
  }
  
  public String getDatabaseType()
  {
    return "DECIMAL(13,9)";
  }
  
  public Class getStorageType()
  {
    return BigDecimal.class;
  }
}

/* Location:
 * Qualified Name:     QuantiteMultiCustomMapper139.ValeurCustomDatabaseTypeDefinition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */