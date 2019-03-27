package fr.unedic.cali.dom.persistance.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

public class PersistanceFactoryStore
{
  private static PersistanceFactoryStore s_instance;
  private PersistenceManagerFactory m_factory;
  
  private PersistanceFactoryStore()
  {
    try
    {
      Properties p = new Properties();
      InputStream in = null;
      try
      {
        in = PersistanceFactoryStore.class.getResourceAsStream("/cali.properties");
        if (in == null) {
          throw new RuntimeException("cali.properties n'est pas à la racine du classpath");
        }
        p.load(in);
      }
      finally
      {
        if (in != null) {
          in.close();
        }
      }
      m_factory = JDOHelper.getPersistenceManagerFactory(p);
    }
    catch (IOException e)
    {
      throw new RuntimeException(e.toString());
    }
  }
  
  public static PersistanceFactoryStore getInstance()
  {
    if (s_instance == null) {
      s_instance = new PersistanceFactoryStore();
    }
    return s_instance;
  }
  
  public PersistenceManagerFactory getFactory()
  {
    return m_factory;
  }
}

/* Location:
 * Qualified Name:     PersistanceFactoryStore
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */