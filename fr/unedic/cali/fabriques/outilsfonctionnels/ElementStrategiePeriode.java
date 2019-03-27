package fr.unedic.cali.fabriques.outilsfonctionnels;

import fr.unedic.cali.fabriques.outilsfonctionnels.spec.ElementStrategieSpec;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieSpec;
import fr.unedic.cali.parametres.GestionnaireDateApplication;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ElementStrategiePeriode
  implements ElementStrategieSpec
{
  private String dateDebut;
  private String dateFin;
  private StrategieSpec strategie;
  
  public ElementStrategiePeriode(String dateDebut, String dateFin, StrategieSpec strategie)
  {
    this.dateDebut = dateDebut;
    this.dateFin = dateFin;
    this.strategie = strategie;
  }
  
  public boolean estEligible(Damj dateAppel)
    throws CoucheLogiqueException
  {
    return construirePeriodeApplication().contient(dateAppel);
  }
  
  public StrategieSpec recupererStrategie(Damj dateAppel)
    throws CoucheLogiqueException
  {
    return strategie;
  }
  
  private Periode construirePeriodeApplication()
    throws CoucheLogiqueException
  {
    return new Periode(GestionnaireDateApplication.getInstance().recupererDateApplication(dateDebut), GestionnaireDateApplication.getInstance().recupererDateApplication(dateFin));
  }
  
  public boolean estChevauchantAutrePeriode(ElementStrategiePeriode autreElementStrategiePeriode)
    throws CoucheLogiqueException
  {
    return construirePeriodeApplication().chevauche(autreElementStrategiePeriode.construirePeriodeApplication());
  }
}

/* Location:
 * Qualified Name:     ElementStrategiePeriode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */