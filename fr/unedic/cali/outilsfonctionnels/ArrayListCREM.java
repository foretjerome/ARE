package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.cre.CRModificationDonnee;
import fr.unedic.archi.logique.cre.TypeModification;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class ArrayListCREM
{
  ArrayList m_listeComparaison = new ArrayList();
  private static final String AUCUNE_VALEUR = "<Aucune Valeur>";
  public static final String VALEUR_VIDE = "";
  
  public ArrayListCREM(Hashtable p_avant, Hashtable p_apres)
  {
    Iterator itAvant = p_avant.keySet().iterator();
    while (itAvant.hasNext())
    {
      Object cle = itAvant.next();
      
      String valeurAvant = (String)p_avant.get(cle);
      String valeurApres = (String)p_apres.get(cle);
      
      m_listeComparaison.add(new ElementComparaisonCREM((String)cle, valeurAvant, valeurApres));
    }
  }
  
  public boolean hasModification()
  {
    boolean hasModification = false;
    
    Iterator it = m_listeComparaison.iterator();
    while (it.hasNext())
    {
      ElementComparaisonCREM elm = (ElementComparaisonCREM)it.next();
      if ((elm.getTypeModification().equals(TypeModification.CREATION)) || (elm.getTypeModification().equals(TypeModification.MODIFICATION)) || (elm.getTypeModification().equals(TypeModification.SUPPRESSION))) {
        return true;
      }
    }
    return hasModification;
  }
  
  public CRModificationDonnee genererFilsCREM(CRModificationDonnee p_crmParent)
    throws TechniqueException
  {
    Iterator it = m_listeComparaison.iterator();
    while (it.hasNext())
    {
      ElementComparaisonCREM elm = (ElementComparaisonCREM)it.next();
      if (elm.getTypeModification().equals(TypeModification.CREATION)) {
        p_crmParent.notifierModificationDonnee(elm.getLibelleElement(), elm.getTypeModification(), elm.getValeurApresCREM());
      } else if (elm.getTypeModification().equals(TypeModification.MODIFICATION)) {
        p_crmParent.notifierModificationDonnee(elm.getLibelleElement(), elm.getTypeModification(), elm.getValeurAvantCREM(), elm.getValeurApresCREM());
      } else if (elm.getTypeModification().equals(TypeModification.SUPPRESSION)) {
        p_crmParent.notifierModificationDonnee(elm.getLibelleElement(), elm.getTypeModification(), elm.getValeurAvantCREM());
      }
    }
    return p_crmParent;
  }
  
  public TypeModification getTypeModificationPrincipale()
  {
    TypeModification tm = TypeModification.SANS_MODIFICATION;
    Iterator it = m_listeComparaison.iterator();
    while (it.hasNext())
    {
      ElementComparaisonCREM elm = (ElementComparaisonCREM)it.next();
      if (elm.getTypeModification().equals(TypeModification.CREATION))
      {
        if ((tm.equals(TypeModification.SANS_MODIFICATION)) || (tm.equals(TypeModification.CREATION))) {
          tm = TypeModification.CREATION;
        } else {
          tm = TypeModification.MODIFICATION;
        }
      }
      else if (elm.getTypeModification().equals(TypeModification.MODIFICATION)) {
        tm = TypeModification.MODIFICATION;
      } else if (elm.getTypeModification().equals(TypeModification.SUPPRESSION)) {
        if ((tm.equals(TypeModification.SANS_MODIFICATION)) || (tm.equals(TypeModification.SUPPRESSION))) {
          tm = TypeModification.SUPPRESSION;
        } else {
          tm = TypeModification.MODIFICATION;
        }
      }
    }
    return tm;
  }
  
  public String toString()
  {
    StringBuffer buffer = new StringBuffer();
    
    Iterator it = m_listeComparaison.iterator();
    while (it.hasNext())
    {
      ElementComparaisonCREM elm = (ElementComparaisonCREM)it.next();
      
      buffer.append(elm.getLibelleElement() + " : " + elm.getTypeModification().getValeur() + " [" + (elm.getValeurAvantCREM() == "" ? "<Aucune Valeur>" : elm.getValeurAvantCREM()) + ";" + (elm.getValeurApresCREM() == "" ? "<Aucune Valeur>" : elm.getValeurApresCREM()) + "]");
      
      buffer.append("\n");
    }
    return buffer.toString();
  }
  
  public boolean equals(Object p_arg0)
  {
    ArrayListCREM listCREM = (ArrayListCREM)p_arg0;
    
    return m_listeComparaison.equals(m_listeComparaison);
  }
  
  public ArrayList getListeComparaison()
  {
    return m_listeComparaison;
  }
}

/* Location:
 * Qualified Name:     ArrayListCREM
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */