package fr.unedic.cali.autresdoms.d90.outilsfonctionnels;

import fr.unedic.cali.autresdoms.d90.dom.EcartBasePivotEchange;
import fr.unedic.cali.autresdoms.d90.dom.spec.ElementBasePivotEchangeComparableSpec;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.util.services.CoucheLogiqueException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class OutilComparaison
{
  public static Collection comparer(ElementBasePivotEchangeComparableSpec p_premierElement, ElementBasePivotEchangeComparableSpec p_deuxiemeElement)
    throws CoucheLogiqueException
  {
    Class classePremierElement = p_premierElement.getClass();
    
    Collection listeEcartsBases = new ArrayList();
    
    Collection listeMethodesAExclure = p_premierElement.getListeMethodesAExclurePourComparaison();
    listeMethodesAExclure.addAll(ElementBasePivotEchangeComparableSpec.METHODES_COMMUNES_A_EXCLURE);
    
    Object resultatPremierElement = null;
    Object resultatDeuxiemeElement = null;
    
    Method[] listeMethodesDeClasse = classePremierElement.getMethods();
    for (int i = 0; i < listeMethodesDeClasse.length; i++)
    {
      Method methode = listeMethodesDeClasse[i];
      if (!listeMethodesAExclure.contains(methode.getName()))
      {
        boolean invocationMethodeReussie = false;
        boolean resultatMethodeComparable = estUneMethodeAComparer(methode);
        if (resultatMethodeComparable)
        {
          Class typeMethode = null;
          try
          {
            resultatPremierElement = methode.invoke(p_premierElement, null);
            resultatDeuxiemeElement = methode.invoke(p_deuxiemeElement, null);
            typeMethode = methode.getReturnType();
            invocationMethodeReussie = true;
          }
          catch (Exception e)
          {
            GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_INVOCATION_METHODE", new Object[] { methode.getName() });
          }
          boolean resultatsIdentiques = false;
          if (invocationMethodeReussie) {
            resultatsIdentiques = comparerAttribut(resultatPremierElement, resultatDeuxiemeElement, typeMethode);
          }
          if (!resultatsIdentiques)
          {
            Map parametresEcartBase = p_premierElement.recupererParametresEcartsBases();
            parametresEcartBase.put("attributNomCompare", methode.getName());
            parametresEcartBase.put("attributValeurAvant", resultatPremierElement);
            parametresEcartBase.put("attributValeurApres", resultatDeuxiemeElement);
            EcartBasePivotEchange ecartBase = new EcartBasePivotEchange(parametresEcartBase, "MAJ");
            listeEcartsBases.add(ecartBase);
          }
        }
      }
    }
    return listeEcartsBases;
  }
  
  private static boolean estUneMethodeAComparer(Method p_methode)
  {
    boolean typeDeRetourAccepte = false;
    String nomMethode = p_methode.getName();
    boolean nomMethodeAccepte = (nomMethode.startsWith("get")) || (nomMethode.startsWith("is")) || (nomMethode.startsWith("est"));
    String typeDeRetour = p_methode.getReturnType().getName();
    typeDeRetourAccepte = (typeDeRetour != Collection.class.getName()) && (typeDeRetour != List.class.getName());
    return (nomMethodeAccepte) && (typeDeRetourAccepte);
  }
  
  private static boolean comparerAttribut(Object p_resultatPremierElement, Object p_resultatDeuxiemeElement, Class p_typeDeRetour)
  {
    if ((p_resultatPremierElement != null) && (p_resultatDeuxiemeElement != null))
    {
      if (p_typeDeRetour.getName().equals(BigDecimal.class.getName()))
      {
        BigDecimal valeurAvant = (BigDecimal)p_resultatPremierElement;
        BigDecimal valeurApres = ((BigDecimal)p_resultatDeuxiemeElement).setScale(valeurAvant.scale(), 1);
        
        return ((BigDecimal)p_resultatPremierElement).compareTo(valeurApres) == 0;
      }
      if (p_typeDeRetour.getName().equals(String.class.getName())) {
        return rTrim((String)p_resultatPremierElement).equals(rTrim((String)p_resultatDeuxiemeElement));
      }
      return p_resultatPremierElement.equals(p_resultatDeuxiemeElement);
    }
    return (p_resultatPremierElement == null) && (p_resultatDeuxiemeElement == null);
  }
  
  private static String rTrim(String p_string)
  {
    if (p_string == null) {
      return null;
    }
    if ((p_string.length() < 1) || ((p_string.length() == 1) && (p_string.equals(" ")))) {
      return "";
    }
    int i = p_string.length() - 1;
    while ((i >= 0) && (p_string.charAt(i) == ' ')) {
      i--;
    }
    return p_string.substring(0, i + 1);
  }
}

/* Location:
 * Qualified Name:     OutilComparaison
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */