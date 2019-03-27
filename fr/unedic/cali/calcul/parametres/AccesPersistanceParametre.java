package fr.unedic.cali.calcul.parametres;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

public abstract class AccesPersistanceParametre
{
  protected HashMap m_table = new HashMap();
  
  public abstract ArrayList getListeValeursParametre();
  
  public abstract ArrayList getListeValeursParametre(CleAcces paramCleAcces);
  
  public ValeursParametre getValeurs(CleAcces p_cle)
  {
    ValeursParametre valeursParametre = (ValeursParametre)m_table.get(p_cle);
    if (valeursParametre == null) {
      throw new NoSuchElementException("Paramètre non trouvé dans la table " + getClass().getName() + ":" + p_cle.toString());
    }
    return valeursParametre;
  }
  
  protected abstract void initialiser();
}

/* Location:
 * Qualified Name:     AccesPersistanceParametre
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */