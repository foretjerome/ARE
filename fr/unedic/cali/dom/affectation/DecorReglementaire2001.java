package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.dom.ConteneurAccesDecorReglementaire;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.ArrayList;

public class DecorReglementaire2001
  extends DecorReglementaire
{
  public DecorReglementaire2001(Periode periodeValiditeDecor, String identifiantDecor)
  {
    periodeValidite = periodeValiditeDecor;
    idDecor = identifiantDecor;
    listeProduits = new ArrayList();
  }
  
  public boolean estValide(ConteneurAccesDecorReglementaire conteneur)
  {
    return false;
  }
  
  protected void leverAlertes(ConteneurAccesDecorReglementaire conteneur)
    throws CoucheLogiqueException
  {}
  
  protected Damj getDatePivot(ConteneurAccesDecorReglementaire conteneur)
    throws CoucheLogiqueException
  {
    return conteneur.getDateFinContrat();
  }
}

/* Location:
 * Qualified Name:     DecorReglementaire2001
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */