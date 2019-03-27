package fr.unedic.cali.autresdoms.d90.dom.spec;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.util.services.CoucheLogiqueException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

public abstract interface ElementBasePivotEchangeComparableSpec
{
  public static final Collection<String> METHODES_COMMUNES_A_EXCLURE = Collections.unmodifiableList(Arrays.asList(new String[] { "getClass", "getPC", "getGenericPC", "getIdentifiant", "getListeMethodesAExclurePourComparaison", "estComparableAvec", "comparer", "getTspElementPourEcartsBases" }));
  
  public abstract Collection<?> getListeMethodesAExclurePourComparaison();
  
  public abstract Map<?, ?> recupererParametresEcartsBases();
  
  public abstract boolean estComparableAvec(ElementBasePivotEchangeComparableSpec paramElementBasePivotEchangeComparableSpec)
    throws ApplicativeException;
  
  public abstract Collection<?> comparer(ElementBasePivotEchangeComparableSpec paramElementBasePivotEchangeComparableSpec)
    throws CoucheLogiqueException;
  
  public abstract Date getTspElementPourEcartsBases();
  
  public abstract void setTspElementPourEcartsBases(Date paramDate);
}

/* Location:
 * Qualified Name:     ElementBasePivotEchangeComparableSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */