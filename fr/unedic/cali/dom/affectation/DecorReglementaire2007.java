package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.affectation.parametres.AccesDecorReglementaire;
import fr.unedic.cali.dom.ConteneurAccesDecorReglementaire;
import fr.unedic.cali.outilsfonctionnels.DetectionTypeChomage;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.ArrayList;

public class DecorReglementaire2007
  extends DecorReglementaire
{
  public DecorReglementaire2007(Periode periodeValiditeDecor, String identifiantDecor)
  {
    periodeValidite = periodeValiditeDecor;
    idDecor = identifiantDecor;
    listeProduits = new ArrayList();
  }
  
  public boolean estValide(ConteneurAccesDecorReglementaire conteneur)
    throws CoucheLogiqueException
  {
    return estDecorValide(conteneur);
  }
  
  protected void leverAlertes(ConteneurAccesDecorReglementaire conteneur)
    throws CoucheLogiqueException
  {}
  
  protected Damj getDatePivot(ConteneurAccesDecorReglementaire conteneur)
    throws CoucheLogiqueException
  {
    Damj retour = conteneur.getDateFinContrat();
    if ((retour.estApres(periodeValidite.getFin())) && (retour.estAvant(AccesDecorReglementaire.DATE_010714)) && (conteneur.getDateEngagementProcedureLicenciement() != null))
    {
      if (conteneur.getDateEngagementProcedureLicenciement().estAvantOuCoincideAvec(periodeValidite.getFin())) {
        retour = periodeValidite.getFin();
      } else {
        retour = conteneur.getDateEngagementProcedureLicenciement();
      }
    }
    else if ((DetectionTypeChomage.estChomageEconomique(conteneur.getCodeMotifRupture())) && (retour.estApresOuCoincideAvec(AccesDecorReglementaire.DATE_010714))) {
      if (conteneur.getDateEngagementProcedureLicenciement() != null) {
        retour = conteneur.getDateEngagementProcedureLicenciement();
      } else if (conteneur.getDateRuptureContrat() != null) {
        retour = conteneur.getDateRuptureContrat();
      }
    }
    return retour;
  }
}

/* Location:
 * Qualified Name:     DecorReglementaire2007
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */