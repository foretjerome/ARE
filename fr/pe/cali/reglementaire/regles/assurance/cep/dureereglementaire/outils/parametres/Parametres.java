package fr.pe.cali.reglementaire.regles.assurance.cep.dureereglementaire.outils.parametres;

import fr.unedic.util.UniteAffiliation;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parametres
  implements IParametres
{
  private static final BigDecimal PLANCHER = BigDecimal.valueOf(122L);
  private Map<String, List<UniteAffiliation>> parametresUnite = new HashMap();
  private static IParametres instance = new Parametres();
  
  private Parametres()
  {
    List<UniteAffiliation> listeRg = new ArrayList();
    listeRg.add(UniteAffiliation.JOUR_TRAVAILLE);
    parametresUnite.put("RG", listeRg);
    
    List<UniteAffiliation> listeRgInterimaire = new ArrayList();
    listeRgInterimaire.add(UniteAffiliation.JOUR_TRAVAILLE);
    parametresUnite.put("RG5", listeRgInterimaire);
    
    List<UniteAffiliation> listeA1 = new ArrayList();
    listeA1.add(UniteAffiliation.JOUR_TRAVAILLE);
    parametresUnite.put("A1", listeA1);
    
    List<UniteAffiliation> listeA9A = new ArrayList();
    listeA9A.add(UniteAffiliation.JOUR_TRAVAILLE);
    parametresUnite.put("A9A", listeA9A);
    
    List<UniteAffiliation> listeA2A = new ArrayList();
    listeA2A.add(UniteAffiliation.EMBARQUEMENT_ADMINISTRATIF);
    listeA2A.add(UniteAffiliation.HEURE_TRAVAIL);
    parametresUnite.put("A2a", listeA2A);
    
    List<UniteAffiliation> listeA2B = new ArrayList();
    listeA2B.add(UniteAffiliation.EMBARQUEMENT_ADMINISTRATIF);
    listeA2B.add(UniteAffiliation.HEURE_TRAVAIL);
    parametresUnite.put("A2b", listeA2B);
    
    List<UniteAffiliation> listeA3 = new ArrayList();
    listeA3.add(UniteAffiliation.VACATION);
    parametresUnite.put("A3", listeA3);
    
    List<UniteAffiliation> listeA5 = new ArrayList();
    listeA5.add(UniteAffiliation.HEURE_TRAVAIL);
    parametresUnite.put("A5", listeA5);
  }
  
  public List<UniteAffiliation> getUnitesPourReglement(String nomReglement)
  {
    return (List)parametresUnite.get(nomReglement);
  }
  
  public BigDecimal getPlancher()
  {
    return PLANCHER;
  }
  
  public static IParametres getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     Parametres
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */