package fr.unedic.cali.parcours;

import fr.pe.cali.crem.outils.CacheCrem;
import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.AppelGaecReduit;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.DossierExamenSpec;
import fr.unedic.cali.dom.EvenementReferenceExamenSpec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.JustificationAppelGaecReduit;
import fr.unedic.cali.dom.affectation.GammeAsu;
import fr.unedic.cali.dom.affectation.GammeAsuSpec;
import fr.unedic.cali.dom.affectation.GammeForSpec;
import fr.unedic.cali.dom.affectation.GammeInrSpec;
import fr.unedic.cali.dom.affectation.GammeMnt;
import fr.unedic.cali.dom.affectation.GammeRbf;
import fr.unedic.cali.dom.affectation.GammeRbfSpec;
import fr.unedic.cali.dom.affectation.GammeSol;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.dom.affectation.ProduitAsuMnt09P01;
import fr.unedic.cali.dom.affectation.ProduitAsuSpe02P03;
import fr.unedic.cali.dom.affectation.ProduitAsuSpec;
import fr.unedic.cali.dom.affectation.ProduitAsuSsp07P03;
import fr.unedic.cali.dom.affectation.ProduitForAff03P01;
import fr.unedic.cali.dom.affectation.ProduitForAff03P03;
import fr.unedic.cali.dom.affectation.ProduitForRfp04P01;
import fr.unedic.cali.dom.affectation.ProduitInrAdr03P02;
import fr.unedic.cali.dom.affectation.ProduitInrCes06P01;
import fr.unedic.cali.dom.affectation.ProduitInrPar09P01;
import fr.unedic.cali.dom.affectation.ProduitInrRce04P01;
import fr.unedic.cali.dom.affectation.ProduitSolAer05P01;
import fr.unedic.cali.dom.affectation.ProduitSolAer05P02;
import fr.unedic.cali.dom.affectation.ProduitSolAer05P03;
import fr.unedic.cali.dom.affectation.ProduitSolAta06P01;
import fr.unedic.cali.dom.affectation.ProduitSolCge01P01;
import fr.unedic.cali.dom.affectation.ProduitSolCpa02P01;
import fr.unedic.cali.dom.affectation.ProduitSolSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDemandePourReferenceExterne;
import fr.unedic.cali.utilitaire.outils.OutilRecherche;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.Dom;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class ParcoursServiceAbstrait
  extends ParcoursCali
  implements ParcoursService
{
  protected abstract Resultat demarrerParcours(Contexte paramContexte)
    throws ApplicativeException;
  
  protected abstract int getModeChargementDebrayageDossiersLourds(Individu paramIndividu);
  
  protected void initialiserContexteParcour(Contexte contexte)
  {
    ContexteParcoursCali contexteParcours = (ContexteParcoursCali)ContexteParcoursCali.getContexte();
    contexteParcours.setModeTrace(contexte.isModeTrace());
    
    DomCali domCali = (DomCali)contexte.getDonnees();
    contexteParcours.affecteIndividu((Individu)domCali.getIndividu());
  }
  
  protected void preAlimenterAgregatGaec(Individu individu, String idDemande)
  {
    if (individu != null)
    {
      AgregatGaec agregat = individu.getDonneesChargementGaec().getAgregatGaec();
      
      agregat.initModeAppel();
      
      agregat.setIdDemande(idDemande);
      
      Collection demandes = individu.getDemandes();
      Iterator iterateurDemandes = demandes.iterator();
      while (iterateurDemandes.hasNext())
      {
        DemandeSpec demande = (DemandeSpec)iterateurDemandes.next();
        alimenterGammesEtProduitsDeAgregatGaec(demande, agregat);
      }
    }
  }
  
  protected abstract void alimenterAgregatGaec(Individu paramIndividu, String paramString);
  
  private void alimenterGammesEtProduitsDeAgregatGaec(DemandeSpec demande, AgregatGaec agregat)
  {
    if (demande != null)
    {
      GammeSpec gamme = demande.getGamme();
      String idDemande = demande.getIdentifiant();
      
      agregat.ajouterGamme(gamme, idDemande);
      if ((gamme instanceof GammeRbf))
      {
        Collection listeProduits = GammeRbf.getInstance().getProduits(demande);
        if (listeProduits != null)
        {
          Iterator itProduits = listeProduits.iterator();
          while (itProduits.hasNext())
          {
            ProduitSpec produit = (ProduitSpec)itProduits.next();
            if (produit != null) {
              agregat.ajouterProduit(produit, idDemande);
            }
          }
        }
      }
      else
      {
        DossierAffectationSpec dossierAffectation = demande.getDossierAffectation();
        if (dossierAffectation != null)
        {
          ProduitSpec produit = dossierAffectation.getProduit();
          if (produit != null) {
            agregat.ajouterProduit(produit, idDemande);
          } else {
            alimenterProduitsDeAgregatGaecDepuisEre(demande, agregat);
          }
        }
      }
    }
  }
  
  private void alimenterProduitsDeAgregatGaecDepuisEre(DemandeSpec demande, AgregatGaec agregat)
  {
    String typeEre = demande.getEvenementReferenceExamen().getTypeExamen();
    String idDemande = demande.getIdentifiant();
    if ("INR_01".equals(typeEre))
    {
      agregat.ajouterProduit(ProduitInrCes06P01.getInstance(), idDemande);
    }
    else if ("INR_03".equals(typeEre))
    {
      agregat.ajouterProduit(ProduitInrAdr03P02.getInstance(), idDemande);
    }
    else if ("INR_02".equals(typeEre))
    {
      agregat.ajouterProduit(ProduitInrRce04P01.getInstance(), idDemande);
    }
    else if ("INR_04".equals(typeEre))
    {
      agregat.ajouterProduit(ProduitInrPar09P01.getInstance(), idDemande);
    }
    else if ("FOR_02".equals(typeEre))
    {
      agregat.ajouterProduit(ProduitForAff03P01.getInstance(), idDemande);
      agregat.ajouterProduit(ProduitForAff03P03.getInstance(), idDemande);
    }
    else if ("FOR_03".equals(typeEre))
    {
      agregat.ajouterProduit(ProduitForRfp04P01.getInstance(), idDemande);
    }
    else if ("SOL_11".equals(typeEre))
    {
      agregat.ajouterProduit(ProduitSolAta06P01.getInstance(), idDemande);
    }
    else if ("SOL_12".equals(typeEre))
    {
      agregat.ajouterProduit(ProduitSolAta06P01.getInstance(), idDemande);
    }
    else if ("SOL_13".equals(typeEre))
    {
      agregat.ajouterProduit(ProduitSolAta06P01.getInstance(), idDemande);
    }
    else if ("SOL_14".equals(typeEre))
    {
      agregat.ajouterProduit(ProduitSolAta06P01.getInstance(), idDemande);
    }
    else if ("SOL_15".equals(typeEre))
    {
      agregat.ajouterProduit(ProduitSolAta06P01.getInstance(), idDemande);
    }
    else if ("SOL_16".equals(typeEre))
    {
      agregat.ajouterProduit(ProduitSolAta06P01.getInstance(), idDemande);
    }
    else if ("SOL_02".equals(typeEre))
    {
      agregat.ajouterProduit(ProduitSolAer05P01.getInstance(), idDemande);
    }
    else if ("SOL_08".equals(typeEre))
    {
      agregat.ajouterProduit(ProduitSolAer05P01.getInstance(), idDemande);
    }
    else if ("SOL_21".equals(typeEre))
    {
      agregat.ajouterProduit(ProduitSolAer05P02.getInstance(), idDemande);
      agregat.ajouterProduit(ProduitSolAer05P03.getInstance(), idDemande);
    }
    else if ("SOL_01".equals(typeEre))
    {
      agregat.ajouterProduit(ProduitSolCge01P01.getInstance(), idDemande);
    }
    else if ("SOL_03".equals(typeEre))
    {
      agregat.ajouterProduit(ProduitSolCge01P01.getInstance(), idDemande);
    }
    else if ("SOL_04".equals(typeEre))
    {
      agregat.ajouterProduit(ProduitSolCge01P01.getInstance(), idDemande);
    }
    else if ("SOL_22".equals(typeEre))
    {
      agregat.ajouterProduit(ProduitSolCge01P01.getInstance(), idDemande);
    }
    else if ("SOL_23".equals(typeEre))
    {
      agregat.ajouterProduit(ProduitSolCge01P01.getInstance(), idDemande);
    }
    else if ("SOL_06".equals(typeEre))
    {
      agregat.ajouterProduit(ProduitSolCge01P01.getInstance(), idDemande);
    }
    else if ("SOL_07".equals(typeEre))
    {
      agregat.ajouterProduit(ProduitSolCge01P01.getInstance(), idDemande);
    }
    else if ("SOL_09".equals(typeEre))
    {
      agregat.ajouterProduit(ProduitSolCge01P01.getInstance(), idDemande);
    }
    else if ("SOL_10".equals(typeEre))
    {
      agregat.ajouterProduit(ProduitSolCge01P01.getInstance(), idDemande);
    }
    else if ("SOL_26".equals(typeEre))
    {
      agregat.ajouterProduit(ProduitSolCge01P01.getInstance(), idDemande);
      agregat.ajouterProduit(ProduitSolCpa02P01.getInstance(), idDemande);
    }
    else if ("SOL_05".equals(typeEre))
    {
      agregat.ajouterProduit(ProduitSolCpa02P01.getInstance(), idDemande);
    }
    else if ("SOL_20".equals(typeEre))
    {
      agregat.ajouterProduit(ProduitSolCge01P01.getInstance(), idDemande);
      agregat.ajouterProduit(ProduitSolCpa02P01.getInstance(), idDemande);
      agregat.ajouterProduit(ProduitSolAta06P01.getInstance(), idDemande);
    }
    else if ("SOL_24".equals(typeEre))
    {
      agregat.ajouterProduit(ProduitSolCpa02P01.getInstance(), idDemande);
    }
    else if ("ASU_06".equals(typeEre))
    {
      agregat.ajouterProduit(ProduitAsuMnt09P01.getInstance(), idDemande);
    }
  }
  
  protected void alimenterAgregatGaecTypesPeriodes(Individu individu)
  {
    if (individu != null)
    {
      Collection typePeriodesGaec = new ArrayList();
      int modeAppel = determinerModeAppelEtTypesPeriodes(individu, typePeriodesGaec);
      
      individu.getDonneesChargementGaec().getAgregatGaec().setModeAppel(modeAppel);
      individu.getDonneesChargementGaec().getAgregatGaec().setTypePeriodesGaec(typePeriodesGaec);
    }
  }
  
  protected int determinerModeAppelEtTypesPeriodes(Individu individu, Collection typePeriodesGaec)
  {
    return determinerModeAppelEtTypesPeriodes(individu, typePeriodesGaec, false);
  }
  
  protected int determinerModeAppelEtTypesPeriodesPourDemandesEnReexamen(Individu individu, Collection typePeriodesGaec)
  {
    return determinerModeAppelEtTypesPeriodes(individu, typePeriodesGaec, true);
  }
  
  private int determinerModeAppelEtTypesPeriodes(Individu individu, Collection typePeriodesGaec, boolean demandesEnReexamenSeulement)
  {
    AgregatGaec agregatGaec = individu.getDonneesChargementGaec().getAgregatGaec();
    
    boolean prendreEnCompteLaGamme = true;
    int modeAppel = 0;
    Collection gammes = agregatGaec.getGammes();
    if (gammes != null)
    {
      Iterator itGammes = gammes.iterator();
      while (itGammes.hasNext())
      {
        GammeSpec gamme = (GammeSpec)itGammes.next();
        if (gamme != null)
        {
          prendreEnCompteLaGamme = true;
          if (demandesEnReexamenSeulement)
          {
            Collection demandes = agregatGaec.getIdDemandesPourGamme(gamme);
            Iterator itDemandes = demandes.iterator();
            
            boolean auMoinsUnedemandeEnReexamen = false;
            while ((itDemandes.hasNext()) && (!auMoinsUnedemandeEnReexamen))
            {
              String idDemande = (String)itDemandes.next();
              DemandeSpec demande = individu.rechercherDemande(idDemande);
              auMoinsUnedemandeEnReexamen = demande.estEnReExamen();
            }
            prendreEnCompteLaGamme = auMoinsUnedemandeEnReexamen;
          }
          if (prendreEnCompteLaGamme) {
            if ((gamme instanceof GammeAsuSpec))
            {
              modeAppel = Math.max(modeAppel, 1);
              ajouterSiNouveau("9", typePeriodesGaec);
            }
            else if ((gamme instanceof GammeSol))
            {
              modeAppel = Math.max(modeAppel, 0);
            }
            else if ((gamme instanceof GammeForSpec))
            {
              modeAppel = Math.max(modeAppel, 1);
              ajouterSiNouveau("5", typePeriodesGaec);
            }
            else if ((gamme instanceof GammeRbfSpec))
            {
              modeAppel = Math.max(modeAppel, 1);
              ajouterSiNouveau("5", typePeriodesGaec);
            }
            else if ((gamme instanceof GammeInrSpec))
            {
              modeAppel = Math.max(modeAppel, 1);
              
              Collection produits = agregatGaec.getProduits();
              Iterator itProduits = produits.iterator();
              while (itProduits.hasNext())
              {
                ProduitSpec produit = (ProduitSpec)itProduits.next();
                if (produit != null)
                {
                  if ((produit instanceof ProduitInrAdr03P02)) {
                    ajouterSiNouveau("9", typePeriodesGaec);
                  }
                  if ((produit instanceof ProduitInrCes06P01))
                  {
                    ajouterSiNouveau("17", typePeriodesGaec);
                    ajouterSiNouveau("18", typePeriodesGaec);
                  }
                  if ((produit instanceof ProduitInrRce04P01))
                  {
                    ajouterSiNouveau("17", typePeriodesGaec);
                    ajouterSiNouveau("18", typePeriodesGaec);
                  }
                }
              }
            }
            else if ((gamme instanceof GammeMnt))
            {
              modeAppel = Math.max(modeAppel, 0);
            }
          }
        }
      }
    }
    return modeAppel;
  }
  
  protected void ajouterSiNouveau(String typePeriodeGaec, Collection collection)
  {
    if ((typePeriodeGaec != null) && (collection != null)) {
      if (typePeriodeGaec.equals("999"))
      {
        collection.clear();
        collection.add(typePeriodeGaec);
      }
      else if ((!collection.contains("999")) && (!collection.contains(typePeriodeGaec)))
      {
        collection.add(typePeriodeGaec);
      }
    }
  }
  
  private Individu getIndividuCali(Contexte contexte)
  {
    Dom dom = contexte.getDonnees();
    if ((dom instanceof DomCali)) {
      return (Individu)((DomCali)dom).getIndividu();
    }
    return null;
  }
  
  private String getIdDemande(Contexte contexte)
  {
    Dom dom = contexte.getDonnees();
    if ((dom instanceof DomLiquidationDemande)) {
      return ((DomLiquidationDemande)dom).getIdDemande();
    }
    return null;
  }
  
  public void alimentationAgregatGaec(Individu individu, String idDemandeCourante)
    throws ApplicativeException
  {
    if (individu.isForcageAppelGaecTotal())
    {
      int modeAppel = getModeChargementDebrayageDossiersLourds(individu);
      individu.getDonneesChargementGaec().getAgregatGaec().setModeAppel(modeAppel);
    }
    else
    {
      preAlimenterAgregatGaec(individu, idDemandeCourante);
      
      alimenterAgregatGaec(individu, idDemandeCourante);
    }
    individu.getDonneesChargementGaec().setModeAppelInitialise(true);
  }
  
  public Resultat demarrer(Contexte contexte)
    throws ApplicativeException
  {
    Resultat resultat = null;
    
    Individu individu = getIndividuCali(contexte);
    String idDemandeCourante = getIdDemande(contexte);
    
    boolean appliquerPatron = appliquerPatron(individu);
    if (appliquerPatron)
    {
      if ((idDemandeCourante == null) && (getReferenceExterneDemande(contexte) != null))
      {
        DemandeSpec demandeLue = OutilRecherche.rechercherDemandePrecedente(individu.getChronoDemandes(), Damj.FIN_DES_TEMPS, new FiltreDemandePourReferenceExterne(getReferenceExterneDemande(contexte)));
        
        idDemandeCourante = demandeLue.getIdentifiant();
      }
      alimentationAgregatGaec(individu, idDemandeCourante);
      
      chargerGaecReduit(individu);
    }
    Dom dom = contexte.getDonnees();
    if (((dom instanceof DomCali)) && (((DomCali)dom).isSauvegarderCrem())) {
      recupererObjetCremAvantTraitementFonctionnel(contexte);
    }
    resultat = demarrerParcours(contexte);
    if (appliquerPatron) {
      controlerPostTraitementAvecOuSansForcage(individu);
    }
    return resultat;
  }
  
  protected void recupererObjetCremAvantTraitementFonctionnel(Contexte contexte)
    throws ApplicativeException
  {
    DomCali dom = (DomCali)contexte.getDonnees();
    Individu individu = (Individu)dom.getIndividu();
    CacheCrem cacheCrem = getCacheCrem();
    
    ContexteParcoursCali contexteParcours = (ContexteParcoursCali)ContexteParcoursCali.getContexte();
    contexteParcours.setModeTrace(contexte.isModeTrace());
    contexteParcours.affecteIndividu(individu);
    cacheCrem.sauvegarderCremDalLiquidation(individu.getChronoDemandes());
    cacheCrem.sauvegarderCremDecisionLiquidation(individu.getChronoDemandes());
    individu.setCacheCrem(cacheCrem);
  }
  
  protected CacheCrem getCacheCrem()
  {
    return new CacheCrem();
  }
  
  private boolean appliquerPatron(Individu individu)
  {
    boolean appliquerPatron = false;
    boolean individuCaliCharge = false;
    if (individu != null)
    {
      try
      {
        individu.getCodeTransfert();
        individuCaliCharge = true;
      }
      catch (UnsupportedOperationException ex)
      {
        individuCaliCharge = false;
      }
      if ((!individu.getDonneesChargementGaec().getAgregatGaec().isOptimisationPasDeChargementGaec()) && (individuCaliCharge)) {
        appliquerPatron = !individu.getDonneesChargementGaec().isModeAppelInitialise();
      }
    }
    return appliquerPatron;
  }
  
  protected void chargerGaecReduit(Individu individu)
    throws ApplicativeException
  {
    try
    {
      if (individu != null) {
        individu.chargerIndividuGaecReduit();
      }
    }
    catch (TechniqueException ex)
    {
      throw new AccesDonneesGaecException("");
    }
  }
  
  protected void controlerModeAppel(AppelGaecReduit appelGaecReduit, int modeAppelAttendu)
    throws AccesDonneesGaecException
  {
    if (appelGaecReduit.getModeAppel() != modeAppelAttendu) {
      throw new AccesDonneesGaecException("HG_PR_CALI_L_ERR_ACCES_DONNEES_GAEC_MODE_APPEL", "Liquidation impossible suite restriction appel GAEC (Erreur de mode d'appel)");
    }
  }
  
  protected void controlerPostTraitementAvecOuSansForcage(Individu individu)
    throws AccesDonneesGaecException
  {
    AppelGaecReduit gaecReduit = individu.getDonneesChargementGaec().getAppelGaecReduit();
    if (individu.isForcageAppelGaecTotal())
    {
      controlerModeAppel(gaecReduit, getModeChargementDebrayageDossiersLourds(individu));
    }
    else
    {
      controlerPostTraitement(individu);
      if (gaecReduit.getModeAppel() == 1) {
        controlerPostTraitementDatesFenetrage(individu);
      }
    }
  }
  
  protected abstract void controlerPostTraitement(Individu paramIndividu)
    throws AccesDonneesGaecException;
  
  protected void controlerPostTraitementDatesFenetrage(Individu individu)
    throws AccesDonneesGaecException
  {
    AgregatGaec agregat = individu.getDonneesChargementGaec().getAgregatGaec();
    AppelGaecReduit gaecReduit = individu.getDonneesChargementGaec().getAppelGaecReduit();
    if ((agregat != null) && (gaecReduit != null))
    {
      JustificationAppelGaecReduit dateDebutFenetrageAppliquee = gaecReduit.getDateDebutJustifieeFenetreAppelValide();
      JustificationAppelGaecReduit dateFinFenetrageAppliquee = gaecReduit.getDateFinJustifieeFenetreAppel();
      
      Damj dateExecutionCalcul = gaecReduit.getDateExecutionCalcul();
      String typePeriode = null;
      if ((gaecReduit.getTypePeriodes() != null) && (!gaecReduit.getTypePeriodes().isEmpty())) {
        typePeriode = (String)((ArrayList)gaecReduit.getTypePeriodes()).get(0);
      }
      Damj dateDebutFenetrageRecalculee = null;
      Damj dateFinFenetrageRecalculee = null;
      String justificationDebutFenetrageRecalculee = null;
      String justificationFinFenetrageRecalculee = null;
      if (dateDebutFenetrageAppliquee != null)
      {
        DemandeSpec demande = individu.rechercherDemande(dateDebutFenetrageAppliquee.getIdDemande());
        ProduitSpec produitPostTraitement = null;
        ProduitSpec produit = null;
        if (!demande.getListeDossiersExamen().isEmpty())
        {
          DossierAffectationSpec dossierAffecte = ((DossierExamenSpec)demande.getListeDossiersExamen().get(0)).getDossierAffecte();
          if (dossierAffecte != null) {
            produitPostTraitement = dossierAffecte.getProduit();
          }
        }
        if (produitPostTraitement != null) {
          produit = produitPostTraitement;
        } else {
          produit = agregat.getProduit(dateDebutFenetrageAppliquee.getIdDemande());
        }
        if (produit != null)
        {
          String justification = dateDebutFenetrageAppliquee.getJustification();
          if ((justification.equals("Prs")) || (justification.equals("Pra")) || (justification.equals("Prc")))
          {
            JustificationAppelGaecReduit dateJustifiee = null;
            if ((produit instanceof ProduitAsuSpec)) {
              dateJustifiee = ((ProduitAsuSpec)produit).getDateDebutFenetrageAppelGaec(demande);
            } else if ((produit instanceof ProduitSolSpec)) {
              dateJustifiee = ((ProduitSolSpec)produit).getDateDebutFenetrageAppelGaec(demande);
            }
            if (dateJustifiee != null)
            {
              dateDebutFenetrageRecalculee = dateJustifiee.getDate();
              justificationDebutFenetrageRecalculee = dateJustifiee.getJustification();
            }
          }
          if (justification.equals("Fgd OD précédente")) {
            if ((produit instanceof ProduitAsuSpec)) {
              if ((produit instanceof ProduitAsuSsp07P03))
              {
                dateDebutFenetrageRecalculee = GammeAsu.getInstance().getDateFaitGenerateurOdPrecedenteSaufAfd(demande);
                justificationDebutFenetrageRecalculee = "Fgd OD précédente";
              }
              else if ((produit instanceof ProduitAsuSpe02P03))
              {
                dateDebutFenetrageRecalculee = GammeAsu.getInstance().getDateFaitGenerateurOdPrecedenteSaufAfdEtAps(demande);
                justificationDebutFenetrageRecalculee = "Fgd OD précédente";
              }
              else
              {
                dateDebutFenetrageRecalculee = GammeAsu.getInstance().getDateFaitGenerateurOdPrecedente(demande);
                justificationDebutFenetrageRecalculee = "Fgd OD précédente";
              }
            }
          }
        }
      }
      if (dateFinFenetrageAppliquee != null)
      {
        DemandeSpec demande = individu.rechercherDemande(dateFinFenetrageAppliquee.getIdDemande());
        String justification = dateFinFenetrageAppliquee.getJustification();
        if (justification.equals("Date d'examen"))
        {
          dateFinFenetrageRecalculee = demande.getDateExamen();
          justificationFinFenetrageRecalculee = "Date d'examen";
        }
      }
      validerBornageInferieur(dateDebutFenetrageAppliquee, dateDebutFenetrageRecalculee, dateFinFenetrageAppliquee, justificationDebutFenetrageRecalculee);
      
      validerBornageSuperieur(dateFinFenetrageAppliquee, dateFinFenetrageRecalculee, dateDebutFenetrageAppliquee, justificationFinFenetrageRecalculee);
      if ((dateDebutFenetrageAppliquee != null) && (dateExecutionCalcul != null))
      {
        if (dateDebutFenetrageAppliquee.getDate().estApres(dateExecutionCalcul)) {
          throw new AccesDonneesGaecFenetrageException("HG_PR_CALI_L_ERR_ACCES_DONNEES_GAEC_FENETRAGE", "HG_Appel Calcul impossible suite restriction fenetrage appel GAEC");
        }
        if ((typePeriode != null) && (!typePeriode.equals("999"))) {
          throw new AccesDonneesGaecTypePeriodesException("HG_PR_CALI_L_ERR_ACCES_DONNEES_GAEC_PERIODES_CAL", "Calcul impossible suite restriction appel GAEC (Erreur de type de période)");
        }
      }
    }
  }
  
  private void validerBornageInferieur(JustificationAppelGaecReduit dateDebutFenetrageAppliquee, Damj dateDebutFenetrageRecalculee, JustificationAppelGaecReduit dateFinFenetrageAppliquee, String justificationDebutFenetrageRecalculee)
    throws AccesDonneesGaecFenetrageException
  {
    if ((dateDebutFenetrageAppliquee != null) && (dateDebutFenetrageRecalculee != null) && (dateDebutFenetrageRecalculee.estAvant(dateDebutFenetrageAppliquee.getDate())))
    {
      String dateFinAppliquee = null;
      if (dateFinFenetrageAppliquee != null) {
        dateFinAppliquee = dateFinFenetrageAppliquee.getDate().formater();
      } else {
        dateFinAppliquee = new String("");
      }
      throw new AccesDonneesGaecFenetrageException("HG_PR_CALI_L_ERR_ACCES_DONNEES_GAEC_FENETRAGE_DEB", "Liquidation impossible suite restriction appel GAEC (%ARG%=%ARG% hors fenêtre (%ARG%-%ARG%))", new Object[] { justificationDebutFenetrageRecalculee, dateDebutFenetrageRecalculee, dateDebutFenetrageAppliquee.getDate(), dateFinAppliquee });
    }
  }
  
  private void validerBornageSuperieur(JustificationAppelGaecReduit dateFinFenetrageAppliquee, Damj dateFinFenetrageRecalculee, JustificationAppelGaecReduit dateDebutFenetrageAppliquee, String justificationFinFenetrageRecalculee)
    throws AccesDonneesGaecFenetrageException
  {
    if ((dateFinFenetrageAppliquee != null) && (dateFinFenetrageRecalculee != null) && (dateFinFenetrageRecalculee.estApres(dateFinFenetrageAppliquee.getDate())))
    {
      String dateDebutAppliquee = null;
      if (dateDebutFenetrageAppliquee != null) {
        dateDebutAppliquee = dateDebutFenetrageAppliquee.getDate().formater();
      } else {
        dateDebutAppliquee = new String("");
      }
      throw new AccesDonneesGaecFenetrageException("HG_PR_CALI_L_ERR_ACCES_DONNEES_GAEC_FENETRAGE_FIN", "Liquidation impossible suite restriction appel GAEC (%ARG%=%ARG% hors fenêtre (%ARG%-%ARG%))", new Object[] { justificationFinFenetrageRecalculee, dateFinFenetrageRecalculee, dateDebutAppliquee, dateFinFenetrageAppliquee.getDate() });
    }
  }
  
  protected void controlerPostTraitementTypesPeriodes(Individu individu)
    throws AccesDonneesGaecException
  {
    Collection typePeriodesGaec = new ArrayList();
    int modeAppel = determinerModeAppelEtTypesPeriodes(individu, typePeriodesGaec);
    
    AppelGaecReduit gaecReduit = individu.getDonneesChargementGaec().getAppelGaecReduit();
    
    controlerModeAppel(gaecReduit, modeAppel);
    
    controlerTypesPeriodes(gaecReduit.getModeAppel(), gaecReduit.getTypePeriodes(), typePeriodesGaec);
  }
  
  protected void controlerTypePeriode(Collection typePeriodesGaecATester, String typePeriodeGaecPrevue)
    throws AccesDonneesGaecException
  {
    boolean typeValide = false;
    if ((typePeriodesGaecATester != null) && (typePeriodesGaecATester.size() == 1))
    {
      String typePeriode = (String)typePeriodesGaecATester.iterator().next();
      typeValide = (typePeriode != null) && (typePeriode.equals(typePeriodeGaecPrevue));
    }
    if (!typeValide) {
      throw new AccesDonneesGaecTypePeriodesException("HG_PR_CALI_L_ERR_ACCES_DONNEES_GAEC_TYPE_PERIODES", "Liquidation impossible suite restriction appel GAEC (Erreur de type de période)");
    }
  }
  
  protected void controlerTypesPeriodes(int modeAppel, Collection typePeriodesGaecATester, Collection typePeriodesGaecPrevues)
    throws AccesDonneesGaecException
  {
    if (modeAppel == 1)
    {
      boolean listeValide = false;
      
      boolean listeATesterVide = (typePeriodesGaecATester == null) || (typePeriodesGaecATester.size() == 0);
      boolean listePrevueVide = (typePeriodesGaecPrevues == null) || (typePeriodesGaecPrevues.size() == 0);
      if ((listeATesterVide) && (listePrevueVide))
      {
        listeValide = true;
      }
      else if ((typePeriodesGaecATester != null) && (typePeriodesGaecATester.size() == typePeriodesGaecPrevues.size()))
      {
        String valeurPrevue = null;
        Iterator itPrevues = typePeriodesGaecPrevues.iterator();
        Iterator itATester = typePeriodesGaecATester.iterator();
        
        int nbTypesTrouves = 0;
        boolean typeTrouve = true;
        for (; (itPrevues.hasNext()) && (typeTrouve); goto 138)
        {
          valeurPrevue = (String)itPrevues.next();
          typeTrouve = false;
          while ((itATester.hasNext()) && (!typeTrouve)) {
            if (valeurPrevue.equals((String)itATester.next()))
            {
              nbTypesTrouves++;
              typeTrouve = true;
            }
          }
        }
        listeValide = nbTypesTrouves == typePeriodesGaecPrevues.size();
      }
      if (!listeValide) {
        throw new AccesDonneesGaecTypePeriodesException("HG_PR_CALI_L_ERR_ACCES_DONNEES_GAEC_TYPE_PERIODES", "Liquidation impossible suite restriction appel GAEC (Erreur de type de période)");
      }
    }
  }
  
  private String getReferenceExterneDemande(Contexte contexte)
  {
    Dom dom = contexte.getDonnees();
    if ((dom instanceof DomLiquidationDemande)) {
      return ((DomLiquidationDemande)dom).getRefExtDemande();
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     ParcoursServiceAbstrait
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */