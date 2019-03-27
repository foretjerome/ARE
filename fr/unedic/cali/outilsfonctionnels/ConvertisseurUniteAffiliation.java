package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.util.Convertisseur;
import fr.unedic.util.Mathematiques;
import fr.unedic.util.Quantite;
import fr.unedic.util.Unite;
import fr.unedic.util.UniteAffiliation;
import fr.unedic.util.UniteInvalideException;
import java.math.BigDecimal;
import java.util.Hashtable;
import java.util.NoSuchElementException;

public class ConvertisseurUniteAffiliation
  implements Convertisseur
{
  protected static ConvertisseurUniteAffiliation s_instance = null;
  protected Hashtable m_conversions = new Hashtable();
  
  protected ConvertisseurUniteAffiliation()
  {
    m_conversions.put("heure de travail_jour d'affiliation", Mathematiques.diviseParDefaut(BigDecimal.ONE, new BigDecimal("5")));
    
    m_conversions.put("heure de travail_vacation", Mathematiques.diviseParDefaut(new BigDecimal("2"), new BigDecimal("5")));
    
    m_conversions.put("heure de travail_embarquement administratif", Mathematiques.diviseParDefaut(BigDecimal.ONE, new BigDecimal("5")));
    
    m_conversions.put("heure de travail_jour contribution", Mathematiques.diviseParDefaut(BigDecimal.ONE, new BigDecimal("5")));
    
    m_conversions.put("heure de travail_jour de suspension", Mathematiques.diviseParDefaut(BigDecimal.ONE, new BigDecimal("5")));
    
    m_conversions.put("heure de travail_cachet groupe", Mathematiques.diviseParDefaut(BigDecimal.ONE, new BigDecimal("8")));
    
    m_conversions.put("heure de travail_cachet isole", Mathematiques.diviseParDefaut(BigDecimal.ONE, new BigDecimal("12")));
    
    m_conversions.put("cachet isole_heure de travail", new BigDecimal("12"));
    
    m_conversions.put(UniteAffiliation.JOUR + "_" + "embarquement administratif", BigDecimal.ONE);
    
    m_conversions.put("heure de travail_heure de travail", BigDecimal.ONE);
  }
  
  public static synchronized ConvertisseurUniteAffiliation getInstance()
  {
    if (s_instance == null) {
      s_instance = new ConvertisseurUniteAffiliation();
    }
    return s_instance;
  }
  
  private BigDecimal chercherConversion(Unite p_uniteDepart, Unite p_uniteArrivee)
  {
    BigDecimal valeurConversion = (BigDecimal)m_conversions.get(p_uniteDepart.getNom() + "_" + p_uniteArrivee.getNom());
    if (valeurConversion != null) {
      return valeurConversion;
    }
    throw new NoSuchElementException("Pas de conversion pour les unités : " + p_uniteDepart.getNom() + " -> " + p_uniteArrivee.getNom());
  }
  
  public Quantite convertir(Quantite p_quantiteInitiale, Unite p_nouvelleUnite)
    throws UniteInvalideException
  {
    Quantite quantiteApresConversion = null;
    
    BigDecimal facteurConversion = getFacteurConversion((UniteAffiliation)p_quantiteInitiale.getUnite(), (UniteAffiliation)p_nouvelleUnite);
    quantiteApresConversion = new Quantite(facteurConversion.multiply(p_quantiteInitiale.getValeur()), p_nouvelleUnite);
    
    return quantiteApresConversion;
  }
  
  private BigDecimal getFacteurConversion(UniteAffiliation p_uniteDepart, UniteAffiliation p_uniteArrivee)
    throws UniteInvalideException
  {
    BigDecimal facteur = BigDecimal.ZERO;
    try
    {
      BigDecimal valeurConversion = chercherConversion(p_uniteDepart, p_uniteArrivee);
      facteur = valeurConversion;
    }
    catch (NoSuchElementException ex)
    {
      try
      {
        BigDecimal valeurConversion = chercherConversion(p_uniteArrivee, p_uniteDepart);
        facteur = Mathematiques.diviseParDefaut(BigDecimal.ONE, valeurConversion);
      }
      catch (NoSuchElementException exce)
      {
        try
        {
          facteur = getFacteurConversion(p_uniteDepart, (UniteAffiliation)UniteAffiliation.get("heure de travail")).multiply(getFacteurConversion((UniteAffiliation)UniteAffiliation.get("heure de travail"), p_uniteArrivee));
        }
        catch (NoSuchElementException excep)
        {
          throw new UniteInvalideException("Pas de conversion de " + p_uniteDepart.getNom() + " vers " + p_uniteArrivee.getNom());
        }
      }
    }
    return facteur;
  }
}

/* Location:
 * Qualified Name:     ConvertisseurUniteAffiliation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */