package fr.unedic.cali.dom.persistance;

import xcalia.lido.api.mapper.CustomMapper;

public class NumericToTinyIntCustomMapper
  implements CustomMapper
{
  public Object fromStorage(Object arg0)
  {
    return (Integer)arg0;
  }
  
  public Class getStorageType()
  {
    return NumericToTinyIntCustomMapper.TinyIntCustomDatabaseTypeDefinition.class;
  }
  
  public Object toStorage(Object arg0)
  {
    return (Integer)arg0;
  }
}

/* Location:
 * Qualified Name:     NumericToTinyIntCustomMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */