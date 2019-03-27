package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.logique.exception.CoherenceException;
import fr.unedic.cali.calcul.dom.ConstituantsCalculActiviteReduiteSpec;
import fr.unedic.cali.calcul.dom.ConstituantsIndemnisation;
import fr.unedic.cali.calcul.dom.EtatAuDji;
import fr.unedic.cali.calcul.dom.UniteTraitement;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.DureeIndemnisationAbstraite;
import fr.unedic.cali.dom.DureeRenouvellementAbstraite;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.Resultat;
import java.math.BigDecimal;

public class ParcoursLireDonneesMigrationCalcul
  extends ParcoursDonneesMigrationCalculAbstrait
{
  public void controlerContexte(Contexte p_contexte)
    throws ContexteException
  {
    IndividuSpec individuCourant = getIndividu(p_contexte);
    if (individuCourant == null) {
      throw new ContexteException("HG_PR_CALI_L_ERR_CTX_ABS_DEMANDEUR", "Individu absent du contexte");
    }
    String idDemande = getIdDemande(p_contexte);
    if (idDemande == null) {
      throw new ContexteException("HG_PR_CALI_L_CONTEXTE_ABSENCE_DEMANDE_ASSURANCE", "Identifiant demande absente du contexte");
    }
    DemandeSpec demande = individuCourant.rechercherDemande(idDemande);
    if (demande == null) {
      throw new ContexteException("HG_PR_CALI_L_ERR_CONTEXTE", "Demande inexistante en base");
    }
    getDom(p_contexte).setDemande(demande);
  }
  
  private String getIdDemande(Contexte p_contexte)
  {
    return getDom(p_contexte).getIdDemande();
  }
  
  private DomLireDonneesMigrationCalcul getDom(Contexte p_contexte)
  {
    return (DomLireDonneesMigrationCalcul)p_contexte.getDonnees();
  }
  
  public Resultat demarrerParcours(Contexte p_contexte)
    throws ApplicativeException
  {
    ResultatLireDonneesMigrationCalcul resultat = new ResultatLireDonneesMigrationCalcul();
    int reliquatIndemnisation = 0;
    int cumulMoisActiviteReduite = 0;
    int cumulHeuresActiviteReduite = 0;
    
    resultat.setEtat(1);
    DemandeSpec demande = getDom(p_contexte).getDemande();
    int numeroGamme = demande.getNumeroGamme();
    if (demande.estNeutraliseeCalcul())
    {
      EtatAuDji etatAuDji = getEtatAuDjiFigee(demande);
      if ((numeroGamme == 1) || (numeroGamme == 2))
      {
        reliquatIndemnisation = etatAuDji.getReliquatDureeIndemnisation().getValeur().intValue();
        
        cumulMoisActiviteReduite = etatAuDji.getCumulMoisActiviteReduite();
        if (numeroGamme == 2) {
          cumulHeuresActiviteReduite = etatAuDji.getCumulHeuresActiviteReduite();
        }
      }
      else
      {
        throw new CoherenceException("HG_PR_CALI_L_ERR_CONTEXTE", "Impossible de forcer post-migration pour un droit différent de la gamme ASU ou de la gamme SOL");
      }
    }
    else
    {
      UniteTraitement uniteTraitement = getUniteTraitementFigee(demande);
      
      reliquatIndemnisation = lireReliquatIndemnisationNonNeutraliseeCalcul(demande, uniteTraitement);
      
      cumulMoisActiviteReduite = lireCumulMoisActiviteReduiteNonNeutraliseeCalcul(demande, uniteTraitement);
      if (numeroGamme == 2) {
        cumulHeuresActiviteReduite = lireCumulHeuresActiviteReduiteNonNeutraliseeCalcul(demande, uniteTraitement);
      }
    }
    resultat.setReliquatIndemnisation(reliquatIndemnisation);
    resultat.setCumulMoisActiviteReduite(cumulMoisActiviteReduite);
    resultat.setCumulHeuresActiviteReduite(cumulHeuresActiviteReduite);
    resultat.setEtat(0);
    
    return resultat;
  }
  
  private int lireReliquatIndemnisationNonNeutraliseeCalcul(DemandeSpec p_demande, UniteTraitement p_uniteTraitement)
    throws ApplicativeException
  {
    int reliquatIndemnisation = 0;
    ConstituantsIndemnisation constituantsIndemnisation = p_uniteTraitement.getConstituantsIndemnisationEnFinUT();
    switch (p_demande.getNumeroGamme())
    {
    case 1: 
      if (constituantsIndemnisation.getDureeIndemnisation().getQuantiteCourante() != null) {
        reliquatIndemnisation = constituantsIndemnisation.getDureeIndemnisation().getQuantiteCourante().getValeur().intValue();
      }
      break;
    case 2: 
      if (constituantsIndemnisation.getDureeRenouvellement().getQuantiteCourante() != null) {
        reliquatIndemnisation = constituantsIndemnisation.getDureeRenouvellement().getQuantiteCourante().getValeur().intValue();
      }
      break;
    default: 
      throw new CoherenceException("HG_PR_CALI_L_ERR_CONTEXTE", "Impossible de forcer post-migration pour un droit différent de la gamme ASU ou de la gamme SOL");
    }
    return reliquatIndemnisation;
  }
  
  private int lireCumulMoisActiviteReduiteNonNeutraliseeCalcul(DemandeSpec p_demande, UniteTraitement p_uniteTraitement)
    throws ApplicativeException
  {
    int cumulMoisActiviteReduite = 0;
    ConstituantsCalculActiviteReduiteSpec constituantsActiviteReduite = null;
    int numeroGamme = p_demande.getNumeroGamme();
    if ((numeroGamme == 1) || (numeroGamme == 2))
    {
      constituantsActiviteReduite = p_uniteTraitement.getConstituantsCalculActiviteReduiteEnFinUT();
      cumulMoisActiviteReduite = constituantsActiviteReduite.getCumul();
    }
    else
    {
      throw new CoherenceException("HG_PR_CALI_L_ERR_CONTEXTE", "Impossible de forcer post-migration pour un droit différent de la gamme ASU ou de la gamme SOL");
    }
    return cumulMoisActiviteReduite;
  }
  
  private int lireCumulHeuresActiviteReduiteNonNeutraliseeCalcul(DemandeSpec p_demande, UniteTraitement p_uniteTraitement)
    throws ApplicativeException
  {
    int cumulHeuresActiviteReduite = 0;
    ConstituantsCalculActiviteReduiteSpec constituantsActiviteReduite = null;
    if (p_demande.getNumeroGamme() == 2)
    {
      constituantsActiviteReduite = p_uniteTraitement.getConstituantsCalculActiviteReduiteEnFinUT();
      if (constituantsActiviteReduite.getCumulHeuresAR() != null) {
        cumulHeuresActiviteReduite = constituantsActiviteReduite.getCumulHeuresAR().intValue();
      }
    }
    else
    {
      throw new CoherenceException("HG_PR_CALI_L_ERR_CONTEXTE", "Le forçage du cumul d'heure d'activité réduite est uniquemment possible pour la gamme solidarité");
    }
    return cumulHeuresActiviteReduite;
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu p_individu)
  {
    return 2;
  }
  
  protected void alimenterAgregatGaec(Individu p_individu, String p_idDemande)
  {
    if (p_individu != null) {
      p_individu.getDonneesChargementGaec().getAgregatGaec().setModeAppel(0);
    }
  }
  
  protected void controlerPostTraitement(Individu p_individu)
    throws AccesDonneesGaecException
  {
    controlerModeAppel(p_individu.getDonneesChargementGaec().getAppelGaecReduit(), 0);
  }
}

/* Location:
 * Qualified Name:     ParcoursLireDonneesMigrationCalcul
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */