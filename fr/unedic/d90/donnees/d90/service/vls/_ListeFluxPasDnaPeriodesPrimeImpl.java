package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.databean.DataList;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _ListeFluxPasDnaPeriodesPrimeImpl
  extends ListeFluxPasDnaPeriodesPrime
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _ListeFluxPasDnaPeriodesPrime m_listeFluxPasDnaPeriodesPrime;
  
  public _ListeFluxPasDnaPeriodesPrimeImpl()
  {
    m_listeFluxPasDnaPeriodesPrime = new _ListeFluxPasDnaPeriodesPrime();
  }
  
  public _ListeFluxPasDnaPeriodesPrimeImpl(_ListeFluxPasDnaPeriodesPrime pIn)
  {
    ExceptionUtil.assertMethodParamNotNull("_ListeFluxPasDnaPeriodesPrime", pIn);
    
    m_listeFluxPasDnaPeriodesPrime = pIn;
  }
  
  public Object getObjet()
  {
    return m_listeFluxPasDnaPeriodesPrime;
  }
  
  public String getIdentifiant()
  {
    return m_listeFluxPasDnaPeriodesPrime.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_listeFluxPasDnaPeriodesPrime.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_listeFluxPasDnaPeriodesPrime.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_listeFluxPasDnaPeriodesPrime.set_C_ETAT(pCode);
  }
  
  public _ListeFluxPasDnaPeriodesPrime getListeFluxPasDnaPeriodesPrimeInfra()
  {
    return m_listeFluxPasDnaPeriodesPrime;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    boolean resultat = false;
    for (int i = 0; getNbListeFluxPasDnaPeriodesPrime() > i; i++) {
      if (getListeFluxPasDnaPeriodesPrime(i).isEnErreur())
      {
        resultat = true;
        break;
      }
    }
    return resultat;
  }
  
  public int getNbListeFluxPasDnaPeriodesPrime()
  {
    if (m_listeFluxPasDnaPeriodesPrime != null)
    {
      DataList liste = m_listeFluxPasDnaPeriodesPrime.getInternalListeFluxPasDnaPeriodesPrime();
      if (liste != null) {
        return liste.getNbElement();
      }
      return 0;
    }
    return 0;
  }
  
  public int getNbListFluxPasDnaPeriodePrime()
  {
    return getNbListeFluxPasDnaPeriodesPrime();
  }
  
  public List getListFluxPasDnaPeriodePrime()
  {
    List retour = new ArrayList();
    if (m_listeFluxPasDnaPeriodesPrime != null)
    {
      _FluxPasDnaPeriodePrime[] table = m_listeFluxPasDnaPeriodesPrime.getListeFluxPasDnaPeriodesPrime();
      for (int i = 0; i < table.length; i++) {
        if (table[i] == null) {
          retour.add(null);
        } else {
          retour.add(new _FluxPasDnaPeriodePrimeImpl(table[i]));
        }
      }
    }
    return retour;
  }
  
  public List getListeFluxPasDnaPeriodesPrime()
  {
    return (List)m_listeFluxPasDnaPeriodesPrime.getInternalListeFluxPasDnaPeriodesPrime();
  }
  
  public FluxPasDnaPeriodePrime getListeFluxPasDnaPeriodesPrime(int pIndex)
  {
    FluxPasDnaPeriodePrime retour = null;
    if ((m_listeFluxPasDnaPeriodesPrime != null) && (m_listeFluxPasDnaPeriodesPrime.getInternalListeFluxPasDnaPeriodesPrime() != null) && 
      (m_listeFluxPasDnaPeriodesPrime.getNbListeFluxPasDnaPeriodesPrime() > pIndex) && 
      (m_listeFluxPasDnaPeriodesPrime.getListeFluxPasDnaPeriodesPrime()[pIndex] != null)) {
      retour = new _FluxPasDnaPeriodePrimeImpl(m_listeFluxPasDnaPeriodesPrime.getListeFluxPasDnaPeriodesPrime()[pIndex]);
    }
    return retour;
  }
  
  public FluxPasDnaPeriodePrime getListeFluxPasDnaPeriodesPrime(String pId)
  {
    for (int i = 0; m_listeFluxPasDnaPeriodesPrime.getListeFluxPasDnaPeriodesPrime().length > i; i++) {
      if (m_listeFluxPasDnaPeriodesPrime.getListeFluxPasDnaPeriodesPrime()[i].get_IDENT().equals(pId))
      {
        if (m_listeFluxPasDnaPeriodesPrime.getListeFluxPasDnaPeriodesPrime()[i] == null) {
          return null;
        }
        return new _FluxPasDnaPeriodePrimeImpl(m_listeFluxPasDnaPeriodesPrime.getListeFluxPasDnaPeriodesPrime()[i]);
      }
    }
    return null;
  }
  
  public FluxPasDnaPeriodePrime addFluxPasDnaPeriodePrime()
  {
    _FluxPasDnaPeriodePrimeImpl item = new _FluxPasDnaPeriodePrimeImpl();
    m_listeFluxPasDnaPeriodesPrime.getInternalListeFluxPasDnaPeriodesPrime().addElement(item.getFluxPasDnaPeriodePrimeInfra());
    return item;
  }
  
  public void addFluxPasDnaPeriodePrime(FluxPasDnaPeriodePrime pFluxPasDnaPeriodePrime)
  {
    m_listeFluxPasDnaPeriodesPrime.getInternalListeFluxPasDnaPeriodesPrime().addElement(((_FluxPasDnaPeriodePrimeImpl)pFluxPasDnaPeriodePrime).getFluxPasDnaPeriodePrimeInfra());
  }
  
  public FluxPasDnaPeriodePrime addListeFluxPasDnaPeriodesPrime()
  {
    return addFluxPasDnaPeriodePrime();
  }
  
  public void addListeFluxPasDnaPeriodesPrime(FluxPasDnaPeriodePrime pFluxPasDnaPeriodePrime)
  {
    addFluxPasDnaPeriodePrime(pFluxPasDnaPeriodePrime);
  }
  
  public void removeFluxPasDnaPeriodePrime(String pIndex)
  {
    int posTab = 0;
    DataList liste = m_listeFluxPasDnaPeriodesPrime.getInternalListeFluxPasDnaPeriodesPrime();
    int longueur = liste.getNbElement();
    for (int i = 0; longueur > i; i++) {
      if (((_FluxPasDnaPeriodePrime)liste.getElement(i)).get_IDENT().equals(pIndex))
      {
        liste.removeElement(i);
        break;
      }
    }
  }
  
  public void removeFluxPasDnaPeriodePrime(FluxPasDnaPeriodePrime pFluxPasDnaPeriodePrime)
  {
    m_listeFluxPasDnaPeriodesPrime.getInternalListeFluxPasDnaPeriodesPrime().removeElement(((_FluxPasDnaPeriodePrimeImpl)pFluxPasDnaPeriodePrime).getFluxPasDnaPeriodePrimeInfra());
  }
}

/* Location:
 * Qualified Name:     _ListeFluxPasDnaPeriodesPrimeImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */