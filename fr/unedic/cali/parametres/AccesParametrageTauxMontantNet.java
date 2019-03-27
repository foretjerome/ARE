package fr.unedic.cali.parametres;

import fr.unedic.cali.util.ParametresAbstrait;
import fr.unedic.util.temps.ChronologieStandard;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public final class AccesParametrageTauxMontantNet
  extends ParametresAbstrait
{
  private static AccesParametrageTauxMontantNet instance;
  private ChronologieStandard chrono;
  
  private AccesParametrageTauxMontantNet()
  {
    chrono = new ChronologieStandard();
    initialiser();
  }
  
  public static AccesParametrageTauxMontantNet getInstance()
  {
    if (instance == null) {
      instance = new AccesParametrageTauxMontantNet();
    }
    return instance;
  }
  
  private void initialiser()
  {
    ajouter(new DateAcces(new Damj(2000, 1, 1)), new ValeurParametre(new BigDecimal("0.2101")));
    ajouter(new DateAcces(new Damj(2001, 1, 1)), new ValeurParametre(new BigDecimal("0.2080")));
    ajouter(new DateAcces(new Damj(2002, 1, 1)), new ValeurParametre(new BigDecimal("0.2090")));
    ajouter(new DateAcces(new Damj(2003, 1, 1)), new ValeurParametre(new BigDecimal("0.2120")));
    ajouter(new DateAcces(new Damj(2005, 1, 1)), new ValeurParametre(new BigDecimal("0.2136")));
    ajouter(new DateAcces(new Damj(2006, 1, 1)), new ValeurParametre(new BigDecimal("0.2150")));
    ajouter(new DateAcces(new Damj(2007, 1, 1)), new ValeurParametre(new BigDecimal("0.2146")));
    
    ChronologieStandard chronoStandart = getChronoValeursParametre();
    chrono = new ChronologieStandard();
    chrono.ajouter(chronoStandart);
  }
  
  public BigDecimal get(Damj date)
  {
    BigDecimal taux = null;
    EvenementParametrageTauxMontantNet evtCourant = null;
    Iterator it = chrono.iterer();
    while (it.hasNext())
    {
      EvenementParametrageTauxMontantNet evt = (EvenementParametrageTauxMontantNet)it.next();
      if (!evt.getDateEffet().estAvantOuCoincideAvec(date)) {
        break;
      }
      evtCourant = evt;
    }
    if (evtCourant != null) {
      taux = evtCourant.getVal();
    }
    return taux;
  }
  
  public ChronologieStandard getChronoValeursParametre()
  {
    Set keys = m_table.keySet();
    Iterator it = keys.iterator();
    while (it.hasNext())
    {
      DateAcces cle = (DateAcces)it.next();
      ValeurParametre valeur = (ValeurParametre)m_table.get(cle);
      Damj maDate = cle.getDateEffet();
      EvenementParametrageTauxMontantNet monEvenement = new EvenementParametrageTauxMontantNet(maDate);
      initAjoutEvenement(monEvenement, valeur.getValeur());
    }
    return chrono;
  }
  
  private void initAjoutEvenement(EvenementParametrageTauxMontantNet monEvenement, BigDecimal valeur)
  {
    monEvenement.setTauxConv(valeur);
    ajouterEvenement(chrono, monEvenement);
  }
  
  private void ajouterEvenement(ChronologieStandard asuC, EvenementParametrageTauxMontantNet evtCat)
  {
    Damj damjParam = evtCat.getDateEffet();
    boolean trouve = false;
    asuC.iterer();
    while ((asuC.encoreSuivant()) && (!trouve))
    {
      EvenementParametrageTauxMontantNet evtAsu = (EvenementParametrageTauxMontantNet)asuC.elementSuivant();
      Damj damjAsu = evtAsu.getDateEffet();
      if (damjParam.equals(damjAsu))
      {
        evtAsu.repercuter(evtCat);
        trouve = true;
      }
    }
    if (!trouve) {
      asuC.ajouter(evtCat);
    }
  }
}

/* Location:
 * Qualified Name:     AccesParametrageTauxMontantNet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */