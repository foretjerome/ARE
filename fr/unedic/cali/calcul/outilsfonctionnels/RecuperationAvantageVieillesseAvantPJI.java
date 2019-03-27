package fr.unedic.cali.calcul.outilsfonctionnels;

import fr.unedic.cali.calcul.OutillagePeriodes;
import fr.unedic.cali.calcul.dom.periode.PeriodeAvantageVieillesse;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalcul;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.QuantiteEuro;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import java.util.Iterator;

public class RecuperationAvantageVieillesseAvantPJI
{
  static final int SOIXANTE_ANS = 60;
  
  public static PeriodeAvantageVieillesse recupererPeriodeAvADate(IndividuSpec individu, Damj date)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes chronologieAvantagesVieillesse = null;
    
    chronologieAvantagesVieillesse = OutillagePeriodes.recupererPensionsInvaliditeEtAvantagesVieillesse(individu, Boolean.valueOf(false));
    PeriodeAvantageVieillesse result = null;
    if (chronologieAvantagesVieillesse != null)
    {
      Iterator iterateur = chronologieAvantagesVieillesse.iterer();
      while (iterateur.hasNext())
      {
        ObjetChronoPeriodeCalcul objetChronoPeriodeCalcul = (ObjetChronoPeriodeCalcul)iterateur.next();
        if ((objetChronoPeriodeCalcul.getDateDebut().estAvantOuCoincideAvec(date)) && ((objetChronoPeriodeCalcul.getDateFin() == null) || (objetChronoPeriodeCalcul.getDateFin().estApres(date))) && ((objetChronoPeriodeCalcul instanceof PeriodeAvantageVieillesse))) {
          if ((result != null) && (result.getDateDebut().coincideAvec(((PeriodeAvantageVieillesse)objetChronoPeriodeCalcul).getDateDebut()))) {
            result.setQuantiteEuro(new QuantiteEuro(result.getQuantiteEuro().ajouter(((PeriodeAvantageVieillesse)objetChronoPeriodeCalcul).getQuantiteEuro()).getValeur()));
          } else {
            result = (PeriodeAvantageVieillesse)objetChronoPeriodeCalcul.copie();
          }
        }
      }
    }
    return result;
  }
  
  public static PeriodeAvantageVieillesse recupererPeriodeAvMayotteADate(IndividuSpec individu, Damj date)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes chronologieAvantagesVieillesse = null;
    
    chronologieAvantagesVieillesse = OutillagePeriodes.recupererPensionsInvaliditeEtAvantagesVieillesse(individu, Boolean.valueOf(true));
    PeriodeAvantageVieillesse result = null;
    if (chronologieAvantagesVieillesse != null)
    {
      Iterator iterateur = chronologieAvantagesVieillesse.iterer();
      while (iterateur.hasNext())
      {
        ObjetChronoPeriodeCalcul objetChronoPeriodeCalcul = (ObjetChronoPeriodeCalcul)iterateur.next();
        if ((objetChronoPeriodeCalcul.getDateDebut().estAvantOuCoincideAvec(date)) && ((objetChronoPeriodeCalcul.getDateFin() == null) || (objetChronoPeriodeCalcul.getDateFin().estApres(date))) && ((objetChronoPeriodeCalcul instanceof PeriodeAvantageVieillesse))) {
          if ((result != null) && (result.getDateDebut().coincideAvec(((PeriodeAvantageVieillesse)objetChronoPeriodeCalcul).getDateDebut()))) {
            result.setQuantiteEuro(new QuantiteEuro(result.getQuantiteEuro().ajouter(((PeriodeAvantageVieillesse)objetChronoPeriodeCalcul).getQuantiteEuro()).getValeur()));
          } else {
            result = (PeriodeAvantageVieillesse)objetChronoPeriodeCalcul.copie();
          }
        }
      }
    }
    return result;
  }
}

/* Location:
 * Qualified Name:     RecuperationAvantageVieillesseAvantPJI
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */