package fr.pe.cali.crem.outils;

import fr.pe.cali.crem.dom.MetaDonneeCrem;
import fr.pe.cali.crem.dom.ObjetMetierCrem;
import fr.pe.cali.crem.dom.spec.IDonneesFonctionnellesCrem;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.ContexteService;
import java.sql.Timestamp;
import java.util.Calendar;

public abstract class OutilGenerationObjetMetier
{
  public ObjetMetierCrem genererObjetMetier(DemandeSpec demande, ContexteService contexteService, boolean effectuerComparaison)
    throws ApplicativeException
  {
    ObjetMetierCrem crem = null;
    boolean estEligibleSuppression = estEligibleSuppression(demande);
    boolean estDemandeEligible = verifierDemandeEligible(demande);
    if ((estDemandeEligible) || ((effectuerComparaison) && (estEligibleSuppression)))
    {
      crem = new ObjetMetierCrem();
      alimenterDonneesDemandePourCREM(crem, demande);
      alimenterDonneesContexteServicePourCREM(crem, contexteService);
      alimenterMetaDonnees(crem, contexteService, demande);
      alimenterDonneesFonctionnelles(crem, contexteService, demande);
      if (effectuerComparaison) {
        crem = traiterComparaison(crem, demande.getDemandeur().getCacheCrem(), (!estDemandeEligible) && (estEligibleSuppression));
      }
    }
    return crem;
  }
  
  protected abstract boolean estEligibleSuppression(DemandeSpec paramDemandeSpec);
  
  protected ObjetMetierCrem traiterComparaison(ObjetMetierCrem crem, CacheCrem cache, boolean estEligibleSuppression)
  {
    ObjetMetierCrem resultat = crem;
    ObjetMetierCrem cremCache = recupererAncienCremDansCache(resultat.getIdentifiant(), cache);
    if (estEligibleSuppression)
    {
      resultat.setTypeOperation("S");
    }
    else if (cremCache != null)
    {
      IDonneesFonctionnellesCrem donneesCrem = resultat.getDonneesFonctionnelles();
      boolean estIdentique = donneesCrem.estIdentique(cremCache.getDonneesFonctionnelles());
      if (!estIdentique) {
        resultat.setTypeOperation("M");
      } else {
        resultat = null;
      }
    }
    return resultat;
  }
  
  protected abstract ObjetMetierCrem recupererAncienCremDansCache(String paramString, CacheCrem paramCacheCrem);
  
  public ObjetMetierCrem genererObjetMetier(DemandeSpec demande, ContexteService contexteService)
    throws ApplicativeException
  {
    return genererObjetMetier(demande, contexteService, true);
  }
  
  protected abstract boolean verifierDemandeEligible(DemandeSpec paramDemandeSpec);
  
  protected void alimenterDonneesDemandePourCREM(ObjetMetierCrem objetMetier, DemandeSpec demande)
  {
    alimenterDonneesDemandePourCREMSpecifiques(objetMetier, demande);
    objetMetier.setDateCreation(new Timestamp(Calendar.getInstance().getTimeInMillis()));
    objetMetier.setTypeOperation("C");
    objetMetier.setStatutEmission("0");
    objetMetier.setVersionObjetMetier("0");
  }
  
  protected abstract void alimenterDonneesDemandePourCREMSpecifiques(ObjetMetierCrem paramObjetMetierCrem, DemandeSpec paramDemandeSpec);
  
  protected void alimenterDonneesContexteServicePourCREM(ObjetMetierCrem objetMetier, ContexteService contexteService)
  {
    objetMetier.setCxass(contexteService.getAssedicAllocataire());
    if (estModeTP(contexteService)) {
      objetMetier.setTypeGeneration("TP");
    } else if (estModeBatch(contexteService)) {
      objetMetier.setTypeGeneration("BA");
    }
  }
  
  protected boolean estModeTP(ContexteService contexteService)
  {
    return "TP".equals(contexteService.getContexteEmission());
  }
  
  protected boolean estModeBatch(ContexteService contexteService)
  {
    return "TD".equals(contexteService.getContexteEmission());
  }
  
  protected void alimenterMetaDonnees(ObjetMetierCrem objetMetier, ContexteService contexteService, DemandeSpec demande)
  {
    objetMetier.setPremiereMetaDonnee(new MetaDonneeCrem("CXASS", contexteService.getAssedicAllocataire()));
    objetMetier.setDeuxiemeMetaDonnee(new MetaDonneeCrem("CXALA", String.valueOf(contexteService.getCxala())));
    objetMetier.setTroisiemeMetaDonnee(new MetaDonneeCrem("RSIN", contexteService.getRsin()));
    alimenterMetaDonneesSpecifiques(objetMetier, demande);
  }
  
  protected abstract void alimenterMetaDonneesSpecifiques(ObjetMetierCrem paramObjetMetierCrem, DemandeSpec paramDemandeSpec);
  
  protected abstract void alimenterDonneesFonctionnelles(ObjetMetierCrem paramObjetMetierCrem, ContexteService paramContexteService, DemandeSpec paramDemandeSpec)
    throws ApplicativeException;
  
  public void mettreAJourCremSuiteEmission(ObjetMetierCrem objetMetier)
  {
    objetMetier.setStatutEmission("1");
    objetMetier.setDateDerniereEmission(new Timestamp(Calendar.getInstance().getTimeInMillis()));
  }
}

/* Location:
 * Qualified Name:     OutilGenerationObjetMetier
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */