package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.ClassementAdministratif;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.GammeAsu;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreDemandeAtp;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreDemandeAtpFinDroit;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologieDebuts;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltresTemporel;

public class OutilAtp
  extends OutilDroitAvecFinDroit
{
  public static boolean estFinDroitAtpNonInstalle(DemandeSpec p_demandeCourante, AttributionSpec p_attributionPrecedente)
  {
    if ((p_attributionPrecedente != null) && ((OutilDemande.estUneDemandeAtp(p_attributionPrecedente.getDemande())) || (estUnProduitAtp(p_attributionPrecedente.getProduit()))) && (!OutilDemande.estUneDemandeFinDroitAtp(p_demandeCourante)))
    {
      DemandeSpec demandeFinAtpSuivantDemandeAtp = rechercherDemandeFinAtpSuivantDemandeAtp(p_attributionPrecedente.getDemande());
      if ((demandeFinAtpSuivantDemandeAtp == null) || (p_demandeCourante.getDateExamen() == null) || (!demandeFinAtpSuivantDemandeAtp.getDateRecherche().estAvantOuCoincideAvec(p_demandeCourante.getDateExamen()))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean estDemandeAtpOuFinAtp(DemandeSpec p_demandeCourante)
  {
    return (OutilDemande.estUneDemandeAtp(p_demandeCourante)) || (OutilDemande.estUneDemandeFinDroitAtp(p_demandeCourante));
  }
  
  public static DemandeSpec rechercherDemandeFinAtpSuivantDemandeAtp(DemandeSpec p_demande)
  {
    DemandeSpec demandeRetour = null;
    if ((p_demande != null) && (OutilDemande.estUneDemandeAtp(p_demande)))
    {
      FiltresTemporel listeFiltres = new FiltresTemporel();
      listeFiltres.ajouterFiltre(new FiltreDemandeAtpFinDroit());
      Chronologie chronologieDemandes = p_demande.getDemandeur().getChronoDemandes().copier(listeFiltres);
      chronologieDemandes.iterer();
      while (chronologieDemandes.encoreSuivant())
      {
        DemandeSpec demande = (DemandeSpec)chronologieDemandes.elementSuivant();
        if (((demande.getClassementAdministratif() == null) || (demande.getClassementAdministratif().getTypeClassement().equalsIgnoreCase("SP"))) && (demande.getDateRecherche().estApresOuCoincideAvec(p_demande.getDateRecherche())))
        {
          demandeRetour = demande;
          break;
        }
      }
    }
    return demandeRetour;
  }
  
  public static DemandeSpec getDemandeAtpPrecedente(DemandeSpec p_demande, Damj p_dateRecherche)
  {
    FiltresTemporel listeFiltres = new FiltresTemporel();
    listeFiltres.ajouterFiltre(new FiltreDemandeAtp());
    
    DemandeSpec demandeRetour = null;
    Chronologie chronologieDemandes = p_demande.getDemandeur().getChronoDemandes().copier(listeFiltres);
    chronologieDemandes.setComparateur(new ComparateurSurDateDeclenchementDemandeDecroissante());
    chronologieDemandes.iterer();
    while (chronologieDemandes.encoreSuivant())
    {
      DemandeSpec demande = (DemandeSpec)chronologieDemandes.elementSuivant();
      if ((demande.estDecisionnee()) && (demande.getDateRecherche().estAvantOuCoincideAvec(p_dateRecherche)))
      {
        demandeRetour = demande;
        break;
      }
    }
    return demandeRetour;
  }
  
  public static boolean estFinancementPartage(DemandeSpec p_demandeAtp)
  {
    return GammeAsu.getInstance().estFinancementPartage(p_demandeAtp);
  }
}

/* Location:
 * Qualified Name:     OutilAtp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */