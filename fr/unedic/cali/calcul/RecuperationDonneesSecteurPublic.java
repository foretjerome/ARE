package fr.unedic.cali.calcul;

import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeAttributionSecteurPublic;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeDemandeClassementSP;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierExamenSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreAttributionAutreQueRenoncement;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreAttributionSecteurPublic;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreDateDeclenchementExamenContenueDansPeriode;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreDecisionNonEnReexamen;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologieDebuts;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import fr.unedic.util.temps.Temporel;
import java.util.Iterator;
import java.util.List;

public class RecuperationDonneesSecteurPublic
{
  public static void recupererDemandeClassementSP(ChronologiePeriodes p_periodesIndividuelles, AttributionSpec p_attribution)
  {
    Iterator iterateur = null;
    Temporel objetPeriode = null;
    iterateur = p_attribution.getDemandeur().getListeDemandesSP().iterator();
    while (iterateur.hasNext())
    {
      ObjetChronoPeriodeDemandeClassementSP objetChronoPeriodeDemandeClassementSP = null;
      objetPeriode = (Temporel)iterateur.next();
      DemandeSpec demande = (DemandeSpec)objetPeriode;
      if ((demande != null) && (demande.getDateDeclenchementExamen() != null))
      {
        objetChronoPeriodeDemandeClassementSP = new ObjetChronoPeriodeDemandeClassementSP(demande.getDateDeclenchementExamen());
        if (objetChronoPeriodeDemandeClassementSP != null) {
          p_periodesIndividuelles.ajouter(objetChronoPeriodeDemandeClassementSP);
        }
      }
    }
  }
  
  public static void rechercherAdmissionSecteurPublic(ChronologiePeriodes p_periodesIndividuelles, AttributionSpec p_attribution)
  {
    Chronologie decisions = p_attribution.getDemandeur().getChronoDemandeAssurance().copier(new FiltreDecisionNonEnReexamen());
    
    Chronologie chronoDemandesAEtudier = decisions.copier(new FiltreDateDeclenchementExamenContenueDansPeriode(new Periode(p_attribution.getDateAttribution(), Damj.FIN_DES_TEMPS)));
    
    Chronologie attributionFiltreSP = chronoDemandesAEtudier.copier(new FiltreAttributionSecteurPublic());
    
    Chronologie attributionsFiltreSPSansRenoncement = attributionFiltreSP.copier(new FiltreAttributionAutreQueRenoncement());
    
    attributionsFiltreSPSansRenoncement.iterer();
    while (attributionsFiltreSPSansRenoncement.encoreSuivant())
    {
      DemandeSpec demandeAEtudier = (DemandeSpec)attributionsFiltreSPSansRenoncement.elementSuivant();
      DossierExamenSpec dossier = getDossierExamen(demandeAEtudier);
      if (dossier != null) {
        p_periodesIndividuelles.ajouter(new ObjetChronoPeriodeAttributionSecteurPublic(dossier.getDateEffet(), (AttributionSpec)dossier));
      }
    }
  }
  
  private static DossierExamenSpec getDossierExamen(DemandeSpec p_demande)
  {
    DossierExamenSpec dossier = null;
    List listeDossier = p_demande.getListeDossiersExamen();
    if ((listeDossier != null) && (!listeDossier.isEmpty())) {
      dossier = (DossierExamenSpec)listeDossier.get(0);
    }
    return dossier;
  }
}

/* Location:
 * Qualified Name:     RecuperationDonneesSecteurPublic
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */