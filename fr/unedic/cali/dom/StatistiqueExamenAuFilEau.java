package fr.unedic.cali.dom;

import fr.unedic.cali.dom.gen.StatistiqueExamenAuFilEauGen;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;

public class StatistiqueExamenAuFilEau
  extends StatistiqueExamenAuFilEauGen
  implements ObjetPersistantSpec
{
  private static final long serialVersionUID = 1L;
  public static final int RESULTAT_AUCUN = 0;
  public static final int RESULTAT_OD = 1;
  public static final int RESULTAT_LIMITE_NBRE_FCT = 2;
  public static final int RESULTAT_BLOCAGE_LIQUIDATION = 3;
  
  public StatistiqueExamenAuFilEau() {}
  
  public StatistiqueExamenAuFilEau(DomPCSpec pc)
  {
    super(pc);
  }
  
  public ObjetMetierSpec copie()
  {
    StatistiqueExamenAuFilEau copie = new StatistiqueExamenAuFilEau();
    copieElements(copie);
    return copie;
  }
  
  public String getIdentifiant()
  {
    return DomManager.getIdentifiant(this);
  }
  
  public void marquerGraphePersistant() {}
}

/* Location:
 * Qualified Name:     StatistiqueExamenAuFilEau
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */