package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.affectation.parametres.AccesDecorReglementaire;
import fr.unedic.cali.dom.ConteneurAccesDecorReglementaire;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.outilsfonctionnels.DetectionTypeChomage;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.ArrayList;

public class DecorReglementaire2014Beta
  extends DecorReglementaire
{
  public DecorReglementaire2014Beta(Periode periodeValiditeDecor, Periode periodeValiditeDateExamenDecor, String identifiantDecor)
  {
    periodeValidite = periodeValiditeDecor;
    periodeValiditeDateExamen = periodeValiditeDateExamenDecor;
    idDecor = identifiantDecor;
    listeProduits = new ArrayList();
  }
  
  public boolean estValide(ConteneurAccesDecorReglementaire conteneur)
    throws CoucheLogiqueException
  {
    return estDecorValide(conteneur);
  }
  
  public boolean estDecorEnCoursSelonDate(ConteneurAccesDecorReglementaire conteneur)
  {
    return (getPeriodeValidite().contient(conteneur.getDateFinContrat())) && (getPeriodeValiditeDateExamen().contient(conteneur.getDemande().getDateRecherche()));
  }
  
  protected void leverAlertes(ConteneurAccesDecorReglementaire conteneur)
    throws CoucheLogiqueException
  {}
  
  protected boolean estDecorValide(ConteneurAccesDecorReglementaire conteneur)
    throws CoucheLogiqueException
  {
    boolean retour = false;
    if (conteneur.getDateRecherche() != null)
    {
      if (getPeriodeValiditeDateExamen().contient(conteneur.getDateRecherche())) {
        retour = true;
      }
    }
    else
    {
      leverAlertes(conteneur);
      DecorReglementaire decorEnCours = AccesDecorReglementaire.getInstance().recupererDecorReglementaireEnCoursADate(conteneur);
      if (decorEnCours != null)
      {
        Damj datePivot = decorEnCours.getDatePivot(conteneur);
        if ((datePivot != null) && (getPeriodeValidite().contient(datePivot)))
        {
          Damj dateExamen = conteneur.getDemande().getDateRecherche();
          retour = estDateExamenDansPeriodeValidite(dateExamen);
        }
      }
    }
    return retour;
  }
  
  protected boolean estDateExamenDansPeriodeValidite(Damj dateExamen)
  {
    return (dateExamen != null) && (getPeriodeValiditeDateExamen().contient(dateExamen));
  }
  
  protected Damj getDatePivot(ConteneurAccesDecorReglementaire conteneur)
    throws CoucheLogiqueException
  {
    Damj retour = conteneur.getDateFinContrat();
    if (DetectionTypeChomage.estChomageEconomique(conteneur.getCodeMotifRupture())) {
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
 * Qualified Name:     DecorReglementaire2014Beta
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */