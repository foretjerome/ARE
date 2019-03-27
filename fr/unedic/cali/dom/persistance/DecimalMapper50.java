package fr.unedic.cali.dom.persistance;

import fr.unedic.util.services.ApplicativeRuntimeException;
import java.math.BigDecimal;
import xcalia.lido.api.mapper.CustomMapper;

public class DecimalMapper50
  implements CustomMapper
{
  private static final String PRECISION = "5";
  private static final String RADIX = "0";
  
  public void setSize(int p_size) {}
  
  public void setJavaType(Class p_fieldClass) {}
  
  public Class getStorageType()
  {
    return DecimalMapper50.DecimalCustomDatabaseTypeDefinition.class;
  }
  
  public Object fromStorage(Object p_dbObject)
  {
    if (p_dbObject == null) {
      return null;
    }
    return (BigDecimal)p_dbObject;
  }
  
  public Object toStorage(Object p_javaObject)
  {
    if ((p_javaObject != null) && 
      (!(p_javaObject instanceof BigDecimal))) {
      throw new ApplicativeRuntimeException("PR_UTIL_L_MAPPING", "Mauvais mapping ! type de classe attendu en paramètre et type effectivement passé en paramètre : java.math.BigDecimal " + p_javaObject.getClass().getName());
    }
    return p_javaObject;
  }
}

/* Location:
 * Qualified Name:     DecimalMapper50
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */