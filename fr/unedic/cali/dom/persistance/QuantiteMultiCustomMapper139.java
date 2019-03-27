package fr.unedic.cali.dom.persistance;

import fr.unedic.util.Quantite;
import fr.unedic.util.QuantiteEuro;
import fr.unedic.util.QuantiteJour;
import fr.unedic.util.QuantiteJoursCalendaires;
import fr.unedic.util.QuantiteJoursOuvrables;
import fr.unedic.util.QuantiteJoursOuvres;
import fr.unedic.util.QuantiteMois;
import fr.unedic.util.QuantiteMonnaie;
import fr.unedic.util.QuantiteTaux;
import fr.unedic.util.Unite;
import fr.unedic.util.UniteMonaitaire;
import fr.unedic.util.services.ApplicativeRuntimeException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import xcalia.lido.api.mapper.CustomMapper;

public class QuantiteMultiCustomMapper139
  implements CustomMapper
{
  private static final String PRECISION = "13";
  private static final String RADIX = "9";
  
  public Class getStorageType()
  {
    return QuantiteMultiCustomMapper139.QuantiteMultiCustomSubTypes.class;
  }
  
  public Object fromStorage(Object p_obj)
  {
    Quantite quantite = null;
    if (p_obj != null)
    {
      Map subFieldValues = (Map)p_obj;
      
      String e = (String)subFieldValues.get("{exists}");
      int exists = 0;
      if (e != null) {
        exists = Integer.parseInt(e);
      }
      if (exists == 1)
      {
        BigDecimal valeur = (BigDecimal)subFieldValues.get("{valeur}");
        String unite = ((String)subFieldValues.get("{unite}")).trim();
        if ("1".equals(unite)) {
          quantite = new QuantiteMois(valeur);
        } else if ("21".equals(unite)) {
          quantite = new QuantiteMonnaie(valeur, UniteMonaitaire.FRANCS_SUISSES);
        } else if ("22".equals(unite)) {
          quantite = new QuantiteEuro(valeur);
        } else if ("52".equals(unite)) {
          quantite = new QuantiteTaux(valeur);
        } else if ("4".equals(unite)) {
          quantite = new QuantiteJour(valeur);
        } else if ("7".equals(unite)) {
          quantite = new QuantiteJoursCalendaires(valeur);
        } else if ("6".equals(unite)) {
          quantite = new QuantiteJoursOuvrables(valeur);
        } else if ("5".equals(unite)) {
          quantite = new QuantiteJoursOuvres(valeur);
        } else {
          quantite = new Quantite(valeur, Unite.getParCode(unite));
        }
      }
    }
    return quantite;
  }
  
  public Object toStorage(Object p_obj)
  {
    Map valuesToWrite = new HashMap();
    if (p_obj != null)
    {
      if (!(p_obj instanceof Quantite)) {
        throw new ApplicativeRuntimeException("PR_UTIL_L_MAPPING", "Mauvais mapping ! type de classe attendu en paramètre et type effectivement passé en paramètre : fr.unedic.util.Quantite " + p_obj.getClass().getName());
      }
      valuesToWrite.put("{exists}", "1");
      valuesToWrite.put("{valeur}", ((Quantite)p_obj).getValeur());
      valuesToWrite.put("{unite}", ((Quantite)p_obj).getUnite().getCode());
    }
    else
    {
      valuesToWrite.put("{exists}", "0");
      valuesToWrite.put("{valeur}", null);
      valuesToWrite.put("{unite}", null);
    }
    return valuesToWrite;
  }
}

/* Location:
 * Qualified Name:     QuantiteMultiCustomMapper139
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */