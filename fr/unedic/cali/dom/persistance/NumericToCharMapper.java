package fr.unedic.cali.dom.persistance;

import fr.unedic.util.services.ApplicativeRuntimeException;
import xcalia.lido.api.mapper.CustomMapper;

public class NumericToCharMapper
  implements CustomMapper
{
  public Class getStorageType()
  {
    return NumericToCharMapper.NumericToCharCustomDatabaseTypeDefinition.class;
  }
  
  public Object fromStorage(Object dbObject)
  {
    if (dbObject == null) {
      return Integer.valueOf(0);
    }
    return Integer.valueOf((String)dbObject);
  }
  
  public Object toStorage(Object javaObject)
  {
    if (javaObject != null)
    {
      if (!(javaObject instanceof Integer)) {
        throw new ApplicativeRuntimeException("PR_UTIL_L_MAPPING", "Mauvais mapping ! type de classe attendu en paramètre et type effectivement passé en paramètre : java.lang.Integer " + javaObject.getClass().getName());
      }
      return javaObject.toString();
    }
    return "0";
  }
}

/* Location:
 * Qualified Name:     NumericToCharMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */