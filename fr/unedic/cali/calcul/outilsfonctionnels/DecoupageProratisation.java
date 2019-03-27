package fr.unedic.cali.calcul.outilsfonctionnels;

import fr.unedic.cali.calcul.outilsfonctionnels.proratisation.PeriodeProratisationFactory;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Periode;

public class DecoupageProratisation
{
  public static ChronologiePeriodes decoupageEtProratisationPeriodesActivites(Periode p_periodeDeReference, ChronologiePeriodes p_chronologieDePeriodesAProratiser)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes retour = null;
    try
    {
      retour = PeriodeProratisationFactory.decoupeEtProratiseParType(p_chronologieDePeriodesAProratiser, p_periodeDeReference);
    }
    catch (CoucheLogiqueException cle)
    {
      throw new CoucheLogiqueException("HG_PR_CALI_L_DECOUPAGE_ET_PRORATISATION", "Erreur durant le découpage et la proratisation des périodes d'activités", cle);
    }
    return retour;
  }
}

/* Location:
 * Qualified Name:     DecoupageProratisation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */