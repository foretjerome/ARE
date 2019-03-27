package fr.unedic.cali.autresdoms.ga.dom.spec;

import fr.unedic.cali.autresdoms.ga.dom.Indemnite;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeMesureActivite;
import fr.unedic.cali.autresdoms.ga.dom.Prime;
import fr.unedic.util.QuantiteEuro;
import fr.unedic.util.QuantiteJourSpec;
import fr.unedic.util.temps.Chronologie;
import java.util.Collection;

public abstract interface SalarieSpec
  extends CertifieSpec
{
  public abstract Chronologie getListeSalaires();
  
  public abstract void setListeSalaires(Chronologie paramChronologie);
  
  public abstract void ajouterSalaire(RemunerationSpec paramRemunerationSpec);
  
  public abstract Chronologie getListePeriodesMesureActivite();
  
  public abstract void setListePeriodesMesureActivite(Chronologie paramChronologie);
  
  public abstract void ajouterPeriodeMesureActivite(PeriodeMesureActivite paramPeriodeMesureActivite);
  
  public abstract void setListePrimes(Chronologie paramChronologie);
  
  public abstract void ajouterPrime(Prime paramPrime);
  
  public abstract Chronologie getListePrimes();
  
  public abstract Collection<Indemnite> getListeIndemnites();
  
  public abstract void setListeIndemnites(Collection<Indemnite> paramCollection);
  
  public abstract void ajouterIndemnite(Indemnite paramIndemnite);
  
  public abstract QuantiteEuro getQuantiteEuroIccp();
  
  public abstract void setQuantiteEuroIccp(QuantiteEuro paramQuantiteEuro);
  
  public abstract QuantiteEuro getQuantiteEuroIndemniteTransactionnelle();
  
  public abstract void setQuantiteEuroIndemniteTransactionnelle(QuantiteEuro paramQuantiteEuro);
  
  public abstract QuantiteEuro getQuantiteEuroIslr();
  
  public abstract void setQuantiteEuroIslr(QuantiteEuro paramQuantiteEuro);
  
  public abstract QuantiteJourSpec getQuantiteJourIccp();
  
  public abstract void setQuantiteJourIccp(QuantiteJourSpec paramQuantiteJourSpec);
}

/* Location:
 * Qualified Name:     SalarieSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */