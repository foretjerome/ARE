package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.affectation.parametres.AccesDecorReglementaire;
import fr.unedic.cali.dom.ConteneurAccesDecorReglementaire;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.ObjetAlertesNonBloquantes;
import fr.unedic.cali.outilsfonctionnels.DetectionTypeChomage;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.ArrayList;
import java.util.Hashtable;

public class DecorReglementaire2009
  extends DecorReglementaire
{
  public DecorReglementaire2009(Periode periodeValiditeDecor, String identifiantDecor)
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
  {
    Damj dateARE2009 = ProduitAsuCge01P04.getInstance().getPeriodeValidite().getDebut();
    DemandeSpec demande = conteneur.getDemande();
    if ((demande != null) && 
      (conteneur.getDateEngagementProcedureLicenciement() == null) && 
      (conteneur.getDateFinContrat().estApresOuCoincideAvec(dateARE2009)) && 
      (conteneur.getDateRuptureContrat() != null) && (conteneur.getDateRuptureContrat().estAvant(dateARE2009)))
    {
      ArrayList listeAlertesNonBloquantes = new ArrayList();
      listeAlertesNonBloquantes.add(new ObjetAlertesNonBloquantes(conteneur.getDateFinContrat(), conteneur.getDateFinContrat(), 2));
      
      demande.getAlertesNonBloquantes().put("A16MNB2", listeAlertesNonBloquantes);
    }
  }
  
  protected Damj getDatePivot(ConteneurAccesDecorReglementaire conteneur)
    throws CoucheLogiqueException
  {
    Damj retour = conteneur.getDateFinContrat();
    if ((retour.estAvant(AccesDecorReglementaire.DATE_010714)) && (conteneur.getDateEngagementProcedureLicenciement() != null) && (!conteneur.isDerogation())) {
      retour = conteneur.getDateEngagementProcedureLicenciement();
    } else if ((DetectionTypeChomage.estChomageEconomique(conteneur.getCodeMotifRupture())) && (retour.estApresOuCoincideAvec(AccesDecorReglementaire.DATE_010714))) {
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
 * Qualified Name:     DecorReglementaire2009
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */