package fr.unedic.cali.calcul.parametres;

import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.calcul.dom.EvenementParametre;
import fr.unedic.util.temps.ChronologieStandard;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public abstract class AccesParametreIdemnisation
  extends AccesPersistanceParametre
{
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
      if (Log.isTraceActive(AccesParametreIdemnisation.class, Niveau.DEBUG)) {
        Log.ecritTrace(Niveau.DEBUG, AccesParametreIdemnisation.class, "getChronoValeursParametre", e);
      }
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
  
  public Damj getDerniereDateActive()
  {
    Damj derniereDateActive = new Damj(Damj.NUIT_DES_TEMPS);
    Iterator mesCles = m_table.keySet().iterator();
    while (mesCles.hasNext())
    {
      DateAcces maCle = (DateAcces)mesCles.next();
      if (maCle.getDateEffet().estApres(derniereDateActive)) {
        derniereDateActive = maCle.getDateEffet();
      }
    }
    return derniereDateActive;
  }
  
  public ArrayList getListeValeursParametre(CleAcces p_cle)
  {
    throw new NoSuchElementException();
  }
  
  protected abstract void initialiser();
  
  public abstract void remplir(EvenementParametre paramEvenementParametre, DateAcces paramDateAcces);
}

/* Location:
 * Qualified Name:     AccesParametreIdemnisation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */