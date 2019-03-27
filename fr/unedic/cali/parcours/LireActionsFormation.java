package fr.unedic.cali.parcours;

import fr.unedic.cali.autresdoms.ga.dom.ActionFormation;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.AppelGaecReduit;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.EvenementReferenceExamenSpec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.GammeFor;
import fr.unedic.cali.dom.affectation.GammeRbf;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.outilsfonctionnels.OutilDemande;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliSpec;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDemandePourERE;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreOU;
import fr.unedic.cali.utilitaire.outils.OutilRecherche;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologieDebuts;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

public class LireActionsFormation
  extends ParcoursServiceAbstrait
{
  private static final Damj DEBUT_PARAMETRES = new Damj(2003, 4, 1);
  private static final String IDENTIFIANT_MULTI_DEMANDE = "MULTI_DEMANDE";
  
  public Resultat demarrerParcours(Contexte contexte)
    throws CoucheLogiqueException
  {
    ResultatServiceLireActionsFormation resultat = new ResultatServiceLireActionsFormation();
    Collection actionsFormation = new ArrayList();
    boolean filtrage = false;
    Collection listeIdActionsNonLiees = new ArrayList();
    
    IndividuSpec individu = getIndividu(contexte);
    if (!((DomLectureActionsFormation)contexte.getDonnees()).isAppelParEcranLiaison())
    {
      String idDemande = ((DomLectureActionsFormation)contexte.getDonnees()).getIdDemandeRbf();
      
      actionsFormation = getActionsFormation(individu, idDemande);
      filtrage = false;
    }
    else
    {
      String idActionFormationLiee = ((DomLectureActionsFormation)contexte.getDonnees()).getIdActionFormationLiee();
      if ((idActionFormationLiee != null) && (!idActionFormationLiee.equals("")))
      {
        ActionFormation actionLiee = (ActionFormation)individu.rechercherPeriodePasseProfessionnel(idActionFormationLiee);
        if (actionLiee == null) {
          GestionnaireErreur.getInstance().genererException("HG_PR_CALI_L_RBF_ACTION_FORMATION_INCONNUE", new String[] { idActionFormationLiee }, 1);
        }
        actionsFormation.add(actionLiee);
        
        filtrage = false;
        
        mettreAJourLiaison(actionLiee, individu);
      }
      else
      {
        String idDemandeRbf = ((DomLectureActionsFormation)contexte.getDonnees()).getIdDemandeRbf();
        
        actionsFormation = getActionsFormation(individu, idDemandeRbf);
        
        filtrage = true;
        listeIdActionsNonLiees = determinerActionsFormationsNonLiees(individu, actionsFormation, idDemandeRbf);
      }
    }
    actionsFormation = filtrerListeActionsFomation(actionsFormation);
    
    resultat.setCollectionActionsFormation(actionsFormation);
    resultat.setNumeroAllocataire(getNumeroAllocataire(contexte));
    resultat.setFiltrageSurActionsNonLiees(filtrage);
    resultat.setCollectionIdActionsNonLiees(listeIdActionsNonLiees);
    return resultat;
  }
  
  private Collection getActionsFormation(IndividuSpec individu, String idDemande)
  {
    DemandeSpec demande = individu.rechercherDemande(idDemande);
    Collection actionsFormations;
    Collection actionsFormations;
    if (OutilDemande.estUneDemandeRPS(demande))
    {
      actionsFormations = individu.getActionsFormationRps();
    }
    else
    {
      Collection actionsFormations;
      if (OutilDemande.estUneDemandeAgepi(demande)) {
        actionsFormations = individu.getActionFormationRpsRbf();
      } else {
        actionsFormations = individu.getActionsFormation();
      }
    }
    return actionsFormations;
  }
  
  protected Collection determinerActionsFormationsNonLiees(IndividuSpec individu, Collection listeActionsFormation, String pIdDemandeRbf)
  {
    Collection listeRetour = new ArrayList();
    Iterator iterParam = listeActionsFormation.iterator();
    while (iterParam.hasNext()) {
      listeRetour.add(((ActionFormation)iterParam.next()).getIdentifiant().trim());
    }
    DemandeSpec demande = individu.rechercherDemande(pIdDemandeRbf);
    
    String typeExamen = demande.getEvenementReferenceExamen().getTypeExamen();
    
    FiltreCaliSpec filtre = null;
    if (("RBF_01".equals(typeExamen)) || ("RBF_02".equals(typeExamen)))
    {
      FiltreOU filtreTemp = new FiltreOU();
      filtreTemp.ajouterFiltre(new FiltreDemandePourERE("RBF_01"));
      filtreTemp.ajouterFiltre(new FiltreDemandePourERE("RBF_02"));
      filtre = filtreTemp;
    }
    else
    {
      filtre = new FiltreDemandePourERE(typeExamen);
    }
    Chronologie chronoDemandes = OutilRecherche.rechercherDemandesPrecedentes(individu.getChronoDemandes(), Damj.FIN_DES_TEMPS, filtre);
    
    Iterator iter = chronoDemandes.iterer();
    
    String idFormationCali = null;
    String idDemandeRbf = null;
    while (iter.hasNext())
    {
      DemandeSpec demandeCourante = (DemandeSpec)iter.next();
      
      idFormationCali = null;
      if (OutilDemande.estUneDemandeRBF(demande)) {
        idFormationCali = GammeRbf.getInstance().getIdActionFormationLiee(demandeCourante);
      } else {
        idFormationCali = GammeFor.getInstance().getIdActionFormationLiee(demandeCourante);
      }
      if ((idFormationCali != null) && (!idFormationCali.trim().equals("")))
      {
        idDemandeRbf = demandeCourante.getIdentifiant();
        if (!idDemandeRbf.equalsIgnoreCase(pIdDemandeRbf)) {
          listeRetour.remove(idFormationCali.trim());
        }
      }
    }
    return listeRetour;
  }
  
  private String getNumeroAllocataire(Contexte contexte)
  {
    return getIndividu(contexte).getNumeroAllocataire();
  }
  
  public void controlerContexte(Contexte contexte)
    throws ContexteException
  {
    if (contexte != null)
    {
      if ((getNumeroAllocataire(contexte) == null) || (getNumeroAllocataire(contexte).equals(""))) {
        throw new ContexteException("HG_PR_CALI_L_CONTEXTE_ABSENCE_ID_INDIVIDU", "la demande ne peut être rattachée à aucun individu.");
      }
    }
    else {
      throw new ContexteException("HG_PR_CALI_L_ERR_CONTEXTE_ABSENT", "Le contexte ne doit pas être null");
    }
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu individu)
  {
    return 2;
  }
  
  protected void alimenterAgregatGaec(Individu individu, String idDemande)
  {
    if (individu != null)
    {
      Collection typePeriodesGaec = new ArrayList();
      ajouterSiNouveau("5", typePeriodesGaec);
      
      individu.getDonneesChargementGaec().getAgregatGaec().setModeAppel(1);
      individu.getDonneesChargementGaec().getAgregatGaec().setTypePeriodesGaec(typePeriodesGaec);
    }
  }
  
  protected void controlerPostTraitement(Individu individu)
    throws AccesDonneesGaecException
  {
    AppelGaecReduit gaecReduit = individu.getDonneesChargementGaec().getAppelGaecReduit();
    
    controlerModeAppel(gaecReduit, 1);
    
    controlerTypePeriode(gaecReduit.getTypePeriodes(), "5");
  }
  
  private void mettreAJourLiaison(ActionFormation actionLiee, IndividuSpec individu)
  {
    ChronologieDebuts chronoRBF = individu.getChronoDemandeRemboursementFrais();
    
    ListIterator it = chronoRBF.iterer();
    while (it.hasNext())
    {
      DemandeSpec demande = (DemandeSpec)it.next();
      String idActionFormation = GammeRbf.getInstance().getIdActionFormationLiee(demande);
      if ((idActionFormation != null) && (actionLiee != null) && (idActionFormation.equals(actionLiee.getIdentifiant()))) {
        if (actionLiee.getIdDemandeRBFLiee() == null) {
          actionLiee.setIdDemandeRBFLiee(demande.getIdentifiant());
        } else {
          actionLiee.setIdDemandeRBFLiee("MULTI_DEMANDE");
        }
      }
    }
  }
  
  private Collection filtrerListeActionsFomation(Collection listeEntree)
  {
    Collection retour = new ArrayList();
    if (listeEntree != null)
    {
      Iterator i = listeEntree.iterator();
      while (i.hasNext())
      {
        ActionFormation formation = (ActionFormation)i.next();
        if ((formation != null) && (formation.getDateDebut() != null) && (!formation.getDateDebut().estAvant(DEBUT_PARAMETRES))) {
          retour.add(formation);
        }
      }
    }
    return retour;
  }
}

/* Location:
 * Qualified Name:     LireActionsFormation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */