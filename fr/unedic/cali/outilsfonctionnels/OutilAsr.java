package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.ConditionAttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierExamenSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.RejetSpec;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreAttribution;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreDemandeAsr;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreDemandesEnReexamen;
import fr.unedic.util.Mathematiques;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologieDebuts;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltresTemporel;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

public class OutilAsr
  extends OutilDroitAvecFinDroit
{
  public static final int ECHEC_CAP_FIN_ASR = 801;
  
  public static DemandeSpec rechercherDemandeFinAsrSuivantDemandeAsr(DemandeSpec p_demande)
  {
    return rechercherDemandeFinDroitSuivantDemandeNecessitantFinDroit(p_demande, null);
  }
  
  public static boolean estFinDroitAsrEchecReliquat(DemandeSpec p_demande)
  {
    List listeDossierExamen = p_demande.getListeDossiersExamen();
    if ((listeDossierExamen != null) && (!listeDossierExamen.isEmpty()))
    {
      DossierExamenSpec dossierExamen = (DossierExamenSpec)listeDossierExamen.get(0);
      if ((dossierExamen instanceof RejetSpec))
      {
        Iterator iterateurCap = dossierExamen.getListConditionsAttribution().iterator();
        while (iterateurCap.hasNext())
        {
          ConditionAttributionSpec cap = (ConditionAttributionSpec)iterateurCap.next();
          if ((cap != null) && (801 == cap.getCodeMotifEchec())) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public static boolean estFinDroitAsrNonInstalle(DemandeSpec p_demandeCourante, AttributionSpec p_attributionPrecedente)
  {
    if ((p_attributionPrecedente != null) && ((OutilDemande.estUneDemandeAsr(p_attributionPrecedente.getDemande())) || (estUnProduitAsr(p_attributionPrecedente.getProduit()))) && (!OutilDemande.estUneDemandeDeRevision(p_demandeCourante)) && (!OutilDemande.estUneDemandeFinDroitAsr(p_demandeCourante)))
    {
      DemandeSpec demandeFinAsrSuivantDemandeAsr = rechercherDemandeFinAsrSuivantDemandeAsr(p_attributionPrecedente.getDemande());
      if ((demandeFinAsrSuivantDemandeAsr == null) || (p_demandeCourante.getDateExamen() == null) || (!demandeFinAsrSuivantDemandeAsr.getDateRecherche().estAvantOuCoincideAvec(p_demandeCourante.getDateExamen()))) {
        return true;
      }
    }
    return false;
  }
  
  public static BigDecimal calculerSommeAPayerDiff(BigDecimal p_nbHeuresDif, BigDecimal p_salaireHoraireDiff)
  {
    BigDecimal temp = p_nbHeuresDif.multiply(p_salaireHoraireDiff);
    return Mathematiques.diviseASup(temp, new BigDecimal("2"), 2);
  }
  
  public static DemandeSpec getDemandeAsrPrecedente(DemandeSpec p_demande, Damj p_dateRecherche)
  {
    FiltresTemporel listeFiltres = new FiltresTemporel();
    listeFiltres.ajouterFiltre(new FiltreDemandeAsr());
    
    listeFiltres.ajouterFiltre(new FiltreAttribution());
    listeFiltres.ajouterFiltre(new FiltreDemandesEnReexamen(false));
    
    DemandeSpec demandeRetour = null;
    Chronologie chronologieDemandes = p_demande.getDemandeur().getChronoDemandes().copier(listeFiltres);
    chronologieDemandes.setComparateur(new ComparateurSurDateDeclenchementDemandeDecroissante());
    chronologieDemandes.iterer();
    while (chronologieDemandes.encoreSuivant())
    {
      DemandeSpec demande = (DemandeSpec)chronologieDemandes.elementSuivant();
      if (demande.getDateRecherche().estAvantOuCoincideAvec(p_dateRecherche))
      {
        demandeRetour = demande;
        break;
      }
    }
    return demandeRetour;
  }
}

/* Location:
 * Qualified Name:     OutilAsr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */