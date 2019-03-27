package fr.unedic.cali.parametres;

import fr.unedic.util.temps.ChronologieStandard;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public abstract class AccesParametreIndemnisation
{
  protected HashMap m_table = new HashMap();
  
  public ChronologieStandard getChronoValeursParametre()
  {
    try
    {
      ChronologieStandard monRetour = new ChronologieStandard();
      
      Iterator mesCles = m_table.keySet().iterator();
      while (mesCles.hasNext())
      {
        DateAcces maCle = (DateAcces)mesCles.next();
        
        EvenementParametre monEvenement = new EvenementParametre(maCle.getDateEffet());
        remplir(monEvenement, maCle);
        monRetour.ajouter(monEvenement);
      }
      return monRetour;
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return null;
  }
  
  public ArrayList getListeValeursParametre()
  {
    ArrayList monRetour = new ArrayList();
    
    Iterator mesCles = m_table.keySet().iterator();
    while (mesCles.hasNext())
    {
      DateAcces maCle = (DateAcces)mesCles.next();
      
      EvenementParametre monEvenement = new EvenementParametre(maCle.getDateEffet());
      remplir(monEvenement, maCle);
      monRetour.add(monEvenement);
    }
    return monRetour;
  }
  
  public ArrayList getListeValeursParametre(CleAcces p_cle)
  {
    throw new NoSuchElementException();
  }
  
  protected abstract void initialiser();
  
  public abstract void remplir(EvenementParametre paramEvenementParametre, DateAcces paramDateAcces);
}

/* Location:
 * Qualified Name:     AccesParametreIndemnisation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */