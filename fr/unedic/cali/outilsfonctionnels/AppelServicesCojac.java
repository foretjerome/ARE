package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.autresdoms.cohab.dom.CriteresCaliServiceEnveloppe;
import fr.unedic.cali.autresdoms.cohab.dom.IndividuPopulationImpl;
import fr.unedic.cali.autresdoms.cohab.dom.LireEnveloppeAidesResultat;
import fr.unedic.cali.autresdoms.cohab.dom.PreInscriptionAude;
import fr.unedic.cali.autresdoms.cohab.dom.TripletteIndividu;
import fr.unedic.cali.autresdoms.cohab.mapping.MapperAllocataire;
import fr.unedic.cali.autresdoms.cohab.mapping.MapperEnveloppeAides;
import fr.unedic.cali.autresdoms.cohab.sigma.chaineliaison.dom.CriteresChaineLiaison;
import fr.unedic.cali.autresdoms.cohab.sigma.chaineliaison.dom.spec.ResultatChaineLiaisonSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.enveloppe.dom.CriteresEnveloppe;
import fr.unedic.cali.autresdoms.cohab.sigma.enveloppe.dom.spec.EnveloppeAidesSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.individubni.dom.CriteresIndividuBni;
import fr.unedic.cali.autresdoms.cohab.sigma.individubni.dom.spec.AllocataireBniSigmaR0Spec;
import fr.unedic.cali.autresdoms.cohab.sigma.rechercheAliasNCP.dom.CriteresIndividuNCP;
import fr.unedic.cali.autresdoms.cohab.sigma.rechercheAliasNCP.dom.spec.AllocataireNcpSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.rechercheAliasNCP.dom.spec.CriteresIndividuNCPSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.restitutioninscrdude.dom.CriteresRestitutionInscriptionDude;
import fr.unedic.cali.autresdoms.cohab.sigma.restitutioninscrdude.dom.spec.CriteresRestitutionInscriptionDudeSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.restitutioninscrdude.dom.spec.RestitutionInscriptionDudeSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.servicecali.dom.CriteresCali;
import fr.unedic.cali.autresdoms.cohab.sigma.servicecali.dom.ResultatServiceCaliV1;
import fr.unedic.cali.autresdoms.cohab.sigma.tranchedevie.dom.spec.CriteresTrancheDeVieSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.tranchedevie.dom.spec.InfoTrancheDeVieSpec;
import fr.unedic.cali.autresdoms.ga.services.AppelServicesGaec;
import fr.unedic.cali.dom.ClassementAdministratif;
import fr.unedic.cali.dom.FormulaireSpec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.outilsfonctionnels.cohabitation.sigma.chaineliaison.LectureChaineLiaison;
import fr.unedic.cali.outilsfonctionnels.cohabitation.sigma.enveloppe.LectureEnveloppe;
import fr.unedic.cali.outilsfonctionnels.cohabitation.sigma.individubni.LectureIndividuBni;
import fr.unedic.cali.outilsfonctionnels.cohabitation.sigma.rechercheAliasNCP.LectureRechercheAliasNCP;
import fr.unedic.cali.outilsfonctionnels.cohabitation.sigma.restitutioninscrdude.LectureRestitutionInscriptionDude;
import fr.unedic.cali.outilsfonctionnels.cohabitation.sigma.servicecali.LectureCali;
import fr.unedic.cali.outilsfonctionnels.cohabitation.sigma.tranchedevie.LectureTrancheDeVie;
import fr.unedic.cali.parcours.ResultatControleTestChaineLiaison;
import fr.unedic.util.services.ApplicativeRuntimeException;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologieDebuts;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class AppelServicesCojac
{
  public static ArrayList determinerDalsNonRetournees(Collection dalsCojac, Individu individu, String codeGamme, String idDalFlux, Damj dateCreationDAL)
    throws CoucheLogiqueException
  {
    ArrayList resultat = new ArrayList();
    
    Collection dalsAInstaller = new ArrayList();
    HashMap dalsAssurance = new HashMap();
    boolean dalParametreDejaConnue = false;
    if (dalsCojac != null)
    {
      for (Iterator iter = dalsCojac.iterator(); iter.hasNext();)
      {
        fr.unedic.cali.autresdoms.cohab.sigma.demande.dom.spec.DemandeSpec dal = (fr.unedic.cali.autresdoms.cohab.sigma.demande.dom.spec.DemandeSpec)iter.next();
        if (dal.getGamme().equals(codeGamme))
        {
          if ((dateCreationDAL != null) && ((dal.getDateDemande().estAvant(dateCreationDAL)) || ((dal.getDateDemande().coincideAvec(dateCreationDAL)) && (dal.getIdentifiantDemande().compareTo(idDalFlux) < 0)))) {
            if (!dal.getIdentifiantDemande().equals(idDalFlux))
            {
              String typeExamenDal;
              try
              {
                typeExamenDal = ConstructionCSOIA.getTypeExamenDepuisV1(dal.getGamme(), dal.getLigne(), dal.getProduit(), dal.getTypeExamen());
              }
              catch (CoucheLogiqueException ex)
              {
                typeExamenDal = null;
              }
              if ((typeExamenDal != null) && ((typeExamenDal.equals("ASU_01")) || (typeExamenDal.equals("ASU_03")) || (typeExamenDal.equals("ASU_08")) || (typeExamenDal.equals("ASU_27")) || (typeExamenDal.equals("ASU_28")))) {
                dalsAssurance.put(dal.getIdentifiantDemande(), dal);
              }
            }
          }
          if (dal.getIdentifiantDemande().equals(idDalFlux)) {
            dalsAssurance.put(dal.getIdentifiantDemande(), dal);
          }
        }
      }
      Iterator iter = individu.getChronoDemandeAssurance().iterer();
      String refExterneDalConnue = "";
      while (iter.hasNext())
      {
        refExterneDalConnue = ((fr.unedic.cali.dom.DemandeSpec)iter.next()).getFormulaire().getReferenceExterne();
        dalsAssurance.remove(refExterneDalConnue);
        if ((idDalFlux != null) && (refExterneDalConnue.equals(idDalFlux))) {
          dalParametreDejaConnue = true;
        }
      }
      dalsAInstaller = dalsAssurance.values();
    }
    if (((dalsAInstaller == null) || (dalsAInstaller.isEmpty())) && (!dalParametreDejaConnue)) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_FLUX_RETOUR_DAL_DMD_V1_NON_RETOURNEE", new Object[] { idDalFlux });
    }
    resultat.add(dalsAInstaller);
    resultat.add(Boolean.valueOf(dalParametreDejaConnue));
    return resultat;
  }
  
  public static LireEnveloppeAidesResultat verifierEngagementMontantAides(CriteresCaliServiceEnveloppe criteres)
    throws CoucheLogiqueException
  {
    LireEnveloppeAidesResultat resultatEnveloppe = null;
    
    CriteresEnveloppe criteresEnveloppe = new CriteresEnveloppe();
    if (criteres != null)
    {
      criteresEnveloppe.setContexteService(criteres.getContexteService());
      
      criteresEnveloppe.setIdentifiantActionFormation(criteres.getIdActionFormation());
      
      criteresEnveloppe.setNumeroConventionFormation(criteres.getNumeroConvention());
      
      criteresEnveloppe.setNumeroAllocataire(criteres.getNumeroAllocataire());
      
      criteresEnveloppe.setMontantEngagerAvant(criteres.getMontantAvantEngagement());
      
      criteresEnveloppe.setMontantEngagerApres(criteres.getMontantApresEngagement());
      
      criteresEnveloppe.setNatureDecision(criteres.getNatureDecision());
      if (criteres.getClassementAdministratif() != null) {
        criteresEnveloppe.setClassementAdministratif(criteres.getClassementAdministratif().getTypeClassement());
      }
      criteresEnveloppe.setStatutAvant(criteres.estStatutAvant());
      
      criteresEnveloppe.setStatutApres(criteres.estStatutApres());
      
      criteresEnveloppe.setExerciceAvant(criteres.getExerciceAvant());
      
      criteresEnveloppe.setExerciceApres(criteres.getExerciceApres());
      
      criteresEnveloppe.setOrigineFonctionnelle(criteres.getOrigineFonctionnelle());
    }
    EnveloppeAidesSpec enveloppeAides = null;
    try
    {
      enveloppeAides = new LectureEnveloppe().lireEnveloppeAides(criteresEnveloppe);
    }
    catch (ApplicativeException ex)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_APPEL_CALI_GDP", "Problème lors de l'appel de service de CALI vers GDP" + ex.getMessage(), ex);
    }
    catch (TechniqueException ex)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_APPEL_CALI_GDP", "Problème lors de l'appel de service de CALI vers GDP" + ex.getMessage(), ex);
    }
    if (enveloppeAides != null) {
      resultatEnveloppe = MapperEnveloppeAides.mapper(enveloppeAides);
    }
    return resultatEnveloppe;
  }
  
  public static TripletteIndividu lireIndividuBniR0(String cxala)
  {
    CriteresIndividuBni criteres = new CriteresIndividuBni();
    
    criteres.setNumeroAllocataire(cxala);
    AllocataireBniSigmaR0Spec resultat = null;
    TripletteIndividu triplette = null;
    try
    {
      resultat = new LectureIndividuBni().lireIndividuBniR0(criteres);
    }
    catch (ApplicativeException ex)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_APPEL_CALI_GDP", "Problème lors de l'appel de service de CALI vers GDP" + ex.getMessage(), ex);
    }
    catch (TechniqueException ex)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_APPEL_CALI_GDP", "Problème lors de l'appel de service de CALI vers GDP" + ex.getMessage(), ex);
    }
    if (resultat != null) {
      triplette = MapperAllocataire.mapperPopNCP(resultat);
    }
    return triplette;
  }
  
  public static InfoTrancheDeVieSpec lectureTrancheDeVie(CriteresTrancheDeVieSpec crit)
    throws TechniqueException, CoucheLogiqueException
  {
    return new LectureTrancheDeVie().lireTrancheDeVie(crit);
  }
  
  public static IndividuPopulationImpl lireAliasNCP(String cxala, String codeAssedic)
  {
    CriteresIndividuNCPSpec criteres = new CriteresIndividuNCP();
    
    criteres.setAliasNcp(cxala);
    criteres.setCodeAssedic(codeAssedic);
    
    AllocataireNcpSpec resultat = null;
    IndividuPopulationImpl individuPopulation = null;
    try
    {
      resultat = new LectureRechercheAliasNCP().lireIndividuReferent(criteres);
    }
    catch (ApplicativeException ex)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_APPEL_CALI_GDP", "Problème lors de l'appel de service de CALI vers GDP" + ex.getMessage(), ex);
    }
    catch (TechniqueException ex)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_APPEL_CALI_GDP", "Problème lors de l'appel de service de CALI vers GDP" + ex.getMessage(), ex);
    }
    if (resultat != null) {
      individuPopulation = MapperAllocataire.mapperPopNCP(resultat);
    }
    return individuPopulation;
  }
  
  public static ResultatServiceCaliV1 lireIndividuGlobal(String numeroAllocataire, ContexteService contexteService)
    throws ApplicativeException
  {
    CriteresCali criteresCaliSpec = new CriteresCali();
    criteresCaliSpec.setNumeroAllocataire(numeroAllocataire);
    if (contexteService != null)
    {
      contexteService.setIdEntiteAutre(numeroAllocataire);
      criteresCaliSpec.setContexteService(contexteService);
    }
    ResultatServiceCaliV1 resultat = null;
    try
    {
      resultat = new LectureCali().lireCali(criteresCaliSpec);
    }
    catch (ApplicativeException ex)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_APPEL_CALI_GDP", "Problème lors de l'appel de service de CALI vers GDP" + ex.getMessage(), ex);
    }
    catch (TechniqueException ex)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_APPEL_CALI_GDP", "Problème lors de l'appel de service de CALI vers GDP" + ex.getMessage(), ex);
    }
    return resultat;
  }
  
  public static void controleTestProductionCohabitation(ContexteService contexteService, ResultatControleTestChaineLiaison resultat)
  {
    try
    {
      resultat.setAsyncV2(false);
      resultat.setFluxGaec(false);
      resultat.setFluxSigma(false);
      resultat.setSyncV1(false);
      
      CriteresChaineLiaison criteres = new CriteresChaineLiaison();
      criteres.setCodeAssedic(contexteService.getSrcCodeAssedic());
      criteres.setContexteService(contexteService);
      criteres.setDateEvenement(Damj.damjVersDate(contexteService.getDateTraitement()));
      criteres.setIdentifiantIndividu(contexteService.getRsin());
      
      ResultatChaineLiaisonSpec result = new LectureChaineLiaison().lireChaineLiaison(criteres);
      
      resultat.setAsyncV2(result.isFluxV2V1Correct());
      resultat.setFluxGaec(result.isFluxV2V2Correct());
      resultat.setFluxSigma(result.isFluxV1V2Correct());
      
      resultat.setSyncV1(true);
    }
    catch (ApplicativeException e)
    {
      if (Log.isTraceActive(AppelServicesCojac.class, Niveau.DEBUG)) {
        Log.ecritTrace(Niveau.DEBUG, AppelServicesCojac.class, "testProductionCohabitation", e);
      }
    }
    catch (TechniqueException e)
    {
      if (Log.isTraceActive(AppelServicesGaec.class, Niveau.DEBUG)) {
        Log.ecritTrace(Niveau.DEBUG, AppelServicesCojac.class, "testProductionCohabitation", e);
      }
    }
  }
  
  public static PreInscriptionAude lireRestitutionInscriptionDude(String cxala, String cxin, String cxass)
  {
    CriteresRestitutionInscriptionDudeSpec criteresRestitution = new CriteresRestitutionInscriptionDude();
    criteresRestitution.setCodeAssedic(cxass);
    criteresRestitution.setIdentifiantSigma(cxin);
    criteresRestitution.setNumeroAllocataire(cxala);
    
    RestitutionInscriptionDudeSpec resultatRestitution = null;
    PreInscriptionAude preInscriptionAude = null;
    try
    {
      resultatRestitution = new LectureRestitutionInscriptionDude().lireRestitutionInscriptionDude(criteresRestitution);
    }
    catch (ApplicativeException ex)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_APPEL_CALI_GDP", "Problème lors de l'appel de service de CALI vers GDP" + ex.getMessage(), ex);
    }
    catch (TechniqueException ex)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_APPEL_CALI_GDP", "Problème lors de l'appel de service de CALI vers GDP" + ex.getMessage(), ex);
    }
    if (resultatRestitution != null)
    {
      preInscriptionAude = new PreInscriptionAude();
      preInscriptionAude.setDatePreInscription(resultatRestitution.getDatePreInscription());
      preInscriptionAude.setSousTypePEC(resultatRestitution.getSousTypePEC());
      preInscriptionAude.setTypePEC(resultatRestitution.getTypePEC());
    }
    return preInscriptionAude;
  }
}

/* Location:
 * Qualified Name:     AppelServicesCojac
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */