package fr.unedic.cali.dom.persistance;

import fr.unedic.util.persistance.mapper.BooleanMapper;

public class BooleanNullableMapper
  extends BooleanMapper
{
  public Object fromStorage(Object p_dbObject)
  {
    if (p_dbObject != null)
    {
      if ("1".equals((String)p_dbObject)) {
        return Boolean.TRUE;
      }
      if ("0".equals((String)p_dbObject)) {
        return Boolean.FALSE;
      }
    }
    return null;
  }
  
  public Object toStorage(Object p_javaObject)
  {
    if (p_javaObject != null)
    {
      if (!(p_javaObject instanceof Boolean)) {
        throw new RuntimeException("ERR_CUSTOM_MAPPER_TO_STORAGEjava.lang.Boolean " + p_javaObject.getClass().getName());
      }
      if (((Boolean)p_javaObject).booleanValue()) {
        return "1";
      }
      return "0";
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     BooleanNullableMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */