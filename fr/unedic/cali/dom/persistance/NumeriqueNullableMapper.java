package fr.unedic.cali.dom.persistance;

import fr.unedic.util.services.ApplicativeRuntimeException;
import xcalia.lido.api.mapper.CustomMapper;

public class NumeriqueNullableMapper
  implements CustomMapper
{
  public Class getStorageType()
  {
    return NumeriqueNullableMapper.NumericNullableCustomDatabaseTypeDefinition.class;
  }
  
  public Object fromStorage(Object p_dbObject)
  {
    Integer resultat = (Integer)p_dbObject;
    return resultat;
  }
  
  public Object toStorage(Object p_javaObject)
  {
    if ((p_javaObject != null) && 
      (!(p_javaObject instanceof Integer))) {
      throw new ApplicativeRuntimeException("PR_UTIL_L_MAPPING", "Mauvais mapping ! type de classe attendu en paramètre et type effectivement passé en paramètre : java.lang.Integer " + p_javaObject.getClass().getName());
    }
    return p_javaObject;
  }
}

/* Location:
 * Qualified Name:     NumeriqueNullableMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */