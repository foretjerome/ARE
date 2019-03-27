package fr.unedic.cali.dom.persistance;

import fr.unedic.util.services.ApplicativeRuntimeException;
import java.math.BigDecimal;
import xcalia.lido.api.mapper.CustomMapper;

public class DecimalMapper22
  implements CustomMapper
{
  private static final String PRECISION = "2";
  private static final String RADIX = "2";
  
  public void setSize(int size) {}
  
  public void setJavaType(Class fieldClass) {}
  
  public Class getStorageType()
  {
    return DecimalMapper22.DecimalCustomDatabaseTypeDefinition.class;
  }
  
  public Object fromStorage(Object dbObject)
  {
    if (dbObject == null) {
      return null;
    }
    return dbObject;
  }
  
  public Object toStorage(Object javaObject)
  {
    if ((javaObject != null) && (!(javaObject instanceof BigDecimal))) {
      throw new ApplicativeRuntimeException("PR_UTIL_L_MAPPING", "Mauvais mapping ! type de classe attendu en paramètre et type effectivement passé en paramètre : java.math.BigDecimal " + javaObject.getClass().getName());
    }
    return javaObject;
  }
}

/* Location:
 * Qualified Name:     DecimalMapper22
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */