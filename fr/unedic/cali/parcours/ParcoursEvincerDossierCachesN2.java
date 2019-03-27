package fr.unedic.cali.parcours;

import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.ProduitAsuSpec;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.Collection;
import java.util.Iterator;

public class ParcoursEvincerDossierCachesN2
  extends ParcoursServiceAbstrait
{
  public Resultat demarrerParcours(Contexte p_contexte)
    throws CoucheLogiqueException
  {
    Collection listeAttributions = null;
    ResultatLireAttribution resultatLireAttribution = null;
    
    IndividuSpec individu = getIndividu(p_contexte);
    Damj dateDebut = ((DomLireAttribution)p_contexte.getDonnees()).getDateDebut();
    Damj dateFin = ((DomLireAttribution)p_contexte.getDonnees()).getDateFin();
    if (individu != null)
    {
      resultatLireAttribution = new ResultatLireAttribution();
      
      resultatLireAttribution.setEtat(1);
      if (Log.isTraceActive(ParcoursEvincerDossierCachesN2.class, Niveau.DEBUG)) {
        Log.ecritTrace(Niveau.DEBUG, ParcoursEvincerDossierCachesN2.class, "demarrer", "\t\t******** Début Parcours ParcoursLireAttribution ********\n");
      }
      Periode periode = new Periode(dateDebut, dateFin);
      listeAttributions = individu.getListeAttributionsASUPendantPeriode(periode);
      
      Damj dateDernierFaitGenerateur = null;
      Damj dateTemp = null;
      if ((listeAttributions != null) && (!listeAttributions.isEmpty()))
      {
        Iterator it = listeAttributions.iterator();
        AttributionSpec attributionCourante = null;
        while (it.hasNext())
        {
          attributionCourante = (AttributionSpec)it.next();
          
          dateTemp = ((ProduitAsuSpec)attributionCourante.getDossierAffecte().getProduit()).getDateFaitGenerateur(attributionCourante);
          if ((dateTemp != null) && ((dateDernierFaitGenerateur == null) || (dateTemp.estApres(dateDernierFaitGenerateur)))) {
            dateDernierFaitGenerateur = dateTemp;
          }
        }
      }
      resultatLireAttribution.setDateDernierFaitGenerateur(dateDernierFaitGenerateur);
      
      resultatLireAttribution.setListeAttributions(listeAttributions);
      resultatLireAttribution.setEtat(0);
      if (Log.isTraceActive(ParcoursEvincerDossierCachesN2.class, Niveau.DEBUG)) {
        Log.ecritTrace(Niveau.DEBUG, ParcoursEvincerDossierCachesN2.class, "demarrer", "\t\t******** Résultat Parcours ParcoursLireAttribution ********\n" + resultatLireAttribution);
      }
      if (Log.isTraceActive(ParcoursEvincerDossierCachesN2.class, Niveau.DEBUG)) {
        Log.ecritTrace(Niveau.DEBUG, ParcoursEvincerDossierCachesN2.class, "demarrer", "\t\t******** Fin Parcours ParcoursLireAttribution ********\n");
      }
    }
    return resultatLireAttribution;
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu p_individu)
  {
    return 0;
  }
  
  protected void alimenterAgregatGaec(Individu p_individu, String p_idDemande)
  {
    p_individu.getDonneesChargementGaec().getAgregatGaec().setModeAppel(0);
  }
  
  protected void controlerPostTraitement(Individu p_individu)
    throws AccesDonneesGaecException
  {
    controlerModeAppel(p_individu.getDonneesChargementGaec().getAppelGaecReduit(), 0);
  }
}

/* Location:
 * Qualified Name:     ParcoursEvincerDossierCachesN2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */