package fr.unedic.cali.parcours;

import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.EvenementReferenceExamenSpec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.GammeAsuSpec;
import fr.unedic.cali.dom.affectation.GammeForSpec;
import fr.unedic.cali.dom.affectation.GammeInrSpec;
import fr.unedic.cali.dom.affectation.GammeRbfSpec;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;
import java.util.Collection;
import java.util.Iterator;

public class RechercherDemandeParMultiCritere
  extends ParcoursServiceAbstrait
{
  public void controlerContexte(Contexte p_contexte)
    throws ContexteException
  {
    if (((DomLiquidationDemande)p_contexte.getDonnees()).getIndividu().getIndividuId() == null) {
      throw new ContexteException("HG_PR_CALI_L_ERR_CTX_ABS_DEMANDEUR", "Le numero d'allocataire n'est pas renseigné ");
    }
  }
  
  public Resultat demarrerParcours(Contexte p_contexte)
    throws CoucheLogiqueException
  {
    ResultatRechercherDemandeParMultiCritere resultatRechercherDemandeParMultiCritere = new ResultatRechercherDemandeParMultiCritere();
    
    resultatRechercherDemandeParMultiCritere.setEtat(1);
    if (Log.isTraceActive(RechercherDemandeParMultiCritere.class, Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, RechercherDemandeParMultiCritere.class, "demarrer", "\t\t******** Début Parcours RechercherDemandeParMultiCritere ********\n");
    }
    IndividuSpec individuCali = getIndividu(p_contexte);
    
    resultatRechercherDemandeParMultiCritere.setChronoDemandes(individuCali.getChronoDemandes());
    resultatRechercherDemandeParMultiCritere.setEtat(0);
    if (Log.isTraceActive(RechercherDemandeParMultiCritere.class, Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, RechercherDemandeParMultiCritere.class, "demarrer", "\t\t******** Fin Parcours RechercherDemandeParMultiCritere ********\n");
    }
    return resultatRechercherDemandeParMultiCritere;
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu p_individu)
  {
    return 2;
  }
  
  protected void alimenterAgregatGaec(Individu p_individu, String p_idDemande)
  {
    if (estEnContexteDeChargementPartiel(p_individu)) {
      alimenterAgregatGaecTypesPeriodes(p_individu);
    } else {
      p_individu.getDonneesChargementGaec().getAgregatGaec().initModeAppel();
    }
  }
  
  protected void controlerPostTraitement(Individu p_individu)
    throws AccesDonneesGaecException
  {
    DonneesChargementGaec chargementGaec = p_individu.getDonneesChargementGaec();
    if (chargementGaec.getAgregatGaec().getModeAppel() == 1) {
      controlerPostTraitementTypesPeriodes(p_individu);
    } else {
      controlerModeAppel(chargementGaec.getAppelGaecReduit(), 0);
    }
  }
  
  private boolean estEnContexteDeChargementPartiel(Individu p_individu)
  {
    AgregatGaec agregat = p_individu.getDonneesChargementGaec().getAgregatGaec();
    Collection gammes = agregat.getGammes();
    
    boolean chargementPartiel = false;
    if (gammes != null)
    {
      Iterator iterGammes = gammes.iterator();
      while ((iterGammes.hasNext()) && (!chargementPartiel))
      {
        GammeSpec gamme = (GammeSpec)iterGammes.next();
        if (gamme != null) {
          if ((gamme instanceof GammeAsuSpec)) {
            chargementPartiel = estEnContexteDeChargementPartielGammeAsu(p_individu, agregat, gamme);
          } else if ((gamme instanceof GammeForSpec)) {
            chargementPartiel = true;
          } else if (((gamme instanceof GammeRbfSpec)) || ((gamme instanceof GammeInrSpec))) {
            chargementPartiel = estEnContexteDeChargementPartielGammeRbfInr(p_individu, agregat, gamme);
          }
        }
      }
    }
    return chargementPartiel;
  }
  
  private boolean estEnContexteDeChargementPartielGammeAsu(Individu p_individu, AgregatGaec p_agregat, GammeSpec p_gamme)
  {
    boolean chargementPartiel = false;
    Collection idDemandes = p_agregat.getIdDemandesPourGamme(p_gamme);
    if (idDemandes != null)
    {
      Iterator iterIdDemandes = idDemandes.iterator();
      while ((iterIdDemandes.hasNext()) && (!chargementPartiel))
      {
        String idDemande = (String)iterIdDemandes.next();
        if (idDemande != null)
        {
          DemandeSpec demande = p_individu.rechercherDemande(idDemande);
          if (demande != null)
          {
            String nomTypeEre = demande.getEvenementReferenceExamen().getTypeExamen();
            if (("ASU_07".equals(nomTypeEre)) || ("ASU_28".equals(nomTypeEre))) {
              if (((!demande.estDecisionnee()) && (!demande.estDemandeLiquidee())) || (demande.estEnReExamen())) {
                chargementPartiel = true;
              }
            }
          }
        }
      }
    }
    return chargementPartiel;
  }
  
  private boolean estEnContexteDeChargementPartielGammeRbfInr(Individu p_individu, AgregatGaec p_agregat, GammeSpec p_gamme)
  {
    boolean chargementPartiel = false;
    Collection idDemandes = p_agregat.getIdDemandesPourGamme(p_gamme);
    if (idDemandes != null)
    {
      Iterator iterIdDemandes = idDemandes.iterator();
      while ((iterIdDemandes.hasNext()) && (!chargementPartiel))
      {
        String idDemande = (String)iterIdDemandes.next();
        if (idDemande != null)
        {
          DemandeSpec demande = p_individu.rechercherDemande(idDemande);
          if ((demande != null) && (
            ((!demande.estDecisionnee()) && (!demande.estDemandeLiquidee())) || (demande.estEnReExamen()))) {
            chargementPartiel = true;
          }
        }
      }
    }
    return chargementPartiel;
  }
}

/* Location:
 * Qualified Name:     RechercherDemandeParMultiCritere
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */