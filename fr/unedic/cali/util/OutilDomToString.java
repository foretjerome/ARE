package fr.unedic.cali.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;

public class OutilDomToString
{
  private static final String PREFIXE_GET = "get";
  private static final String PREFIXE_IS = "is";
  private static final String SUFFIXE_GEN = "Gen";
  private static final String SUFFIXE_PC = "PC";
  private static final String PREFIXE_COLLECTION = "getCollection";
  private static final String PREFIXE_LISTE = "List";
  private static final String LISTE_VIDE = "[Liste vide]";
  private static final String OBJ_NULL = "null";
  private static ArrayList listeObjet = new ArrayList();
  
  public static synchronized String toString(Object objet)
  {
    StringBuffer retour = new StringBuffer("");
    
    String decalage = genererDecalage(new Exception().getStackTrace());
    
    Class classeObjet = objet.getClass();
    
    listeObjet.add(objet);
    Iterator iter;
    while (classeObjet != null)
    {
      classeObjet = classeObjet.getSuperclass();
      if ((classeObjet != null) && (classeObjet.getName().endsWith("Gen")))
      {
        TreeMap listeMethodes = new TreeMap();
        Method[] methodes = classeObjet.getDeclaredMethods();
        if ((methodes != null) && (methodes.length > 0))
        {
          for (int i = 0; i < methodes.length; i++)
          {
            Method methode = methodes[i];
            String nom = recupNom(methode.getName());
            if (nom != null)
            {
              String prefixe = "2";
              if (methode.getReturnType().isPrimitive()) {
                prefixe = "1";
              }
              listeMethodes.put(prefixe + nom, methode);
            }
          }
          if (listeMethodes.values() != null) {
            for (iter = listeMethodes.values().iterator(); iter.hasNext();)
            {
              Method methode = (Method)iter.next();
              String nom = recupNom(methode.getName());
              Object resultat = null;
              try
              {
                resultat = methode.invoke(objet, null);
              }
              catch (Exception e)
              {
                resultat = "";
              }
              if ((resultat instanceof Collection))
              {
                StringBuffer retourListe = new StringBuffer("");
                Collection liste = (Collection)resultat;
                if (!liste.isEmpty())
                {
                  int cpt = 0;
                  for (Iterator it = liste.iterator(); it.hasNext();)
                  {
                    cpt++;
                    Object o = it.next();
                    retourListe.append("\n" + decalage + "\t" + nom.substring("List".length()) + " " + cpt);
                    if (o != null) {
                      retourListe.append(o.toString().replaceAll("\n\t", "\n\t\t"));
                    } else {
                      retourListe.append("null");
                    }
                  }
                  resultat = retourListe;
                }
                else
                {
                  resultat = "[Liste vide]";
                }
              }
              else if ((resultat != null) && (!listeContient(resultat)))
              {
                listeObjet.add(resultat);
                String temp = resultat.toString();
                listeObjet.remove(resultat);
                resultat = temp;
              }
              else
              {
                resultat = null;
              }
              retour.append("\n" + decalage + nom + " = " + resultat);
            }
          }
        }
      }
    }
    listeObjet.remove(objet);
    return retour.toString();
  }
  
  private static String recupNom(String name)
  {
    String retour = null;
    if ((name != null) && 
      ((name.startsWith("get")) || (name.startsWith("is"))) && (!name.endsWith("PC")) && (!name.startsWith("getCollection"))) {
      if (name.startsWith("get")) {
        retour = name.substring("get".length());
      } else {
        retour = name.substring("is".length());
      }
    }
    return retour;
  }
  
  private static boolean listeContient(Object resultat)
  {
    for (Iterator iterator = listeObjet.iterator(); iterator.hasNext();) {
      if (iterator.next() == resultat) {
        return true;
      }
    }
    return false;
  }
  
  private static String genererDecalage(StackTraceElement[] stackTrace)
  {
    String retour = "";
    if ((stackTrace != null) && (stackTrace.length > 0)) {
      for (int i = 0; i < stackTrace.length; i++)
      {
        StackTraceElement elem = stackTrace[i];
        if ((elem.getClassName().equals(OutilDomToString.class.getName())) && (i != 0)) {
          retour = retour + "\t";
        }
      }
    }
    return retour;
  }
}

/* Location:
 * Qualified Name:     OutilDomToString
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */