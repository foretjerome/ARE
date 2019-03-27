package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.dom.ConteneurAccesDecorReglementaire;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.ArrayList;

public class DecorReglementaire2016
  extends DecorReglementaire
{
  public DecorReglementaire2016(Periode periodeValiditeDecor, String identifiantDecor)
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
    if (conteneur.getDateEngagementProcedureLicenciement() != null) {
      retour = conteneur.getDateEngagementProcedureLicenciement();
    }
    return retour;
  }
}

/* Location:
 * Qualified Name:     DecorReglementaire2016
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */