package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.ClassementAdministratif;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.EvenementReferenceExamenSpec;
import fr.unedic.cali.dom.FormulaireSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.RejetSpec;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.dom.echange.Decision;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.Damj;
import java.util.ListIterator;

public class AlimenterBaseEchanges
{
  public static Decision alimenterDonneesHorsGamme(DemandeSpec demandeCali, String idTracker)
    throws ApplicativeException
  {
    Decision demandeEchange = new Decision();
    if (idTracker != null) {
      demandeEchange.setIdentifiantEvenement(idTracker);
    } else {
      throw new CoucheLogiqueException("L'identifiant évènement : idTracker est null", null, null);
    }
    renseignerGamme(demandeCali, demandeEchange);
    
    renseignerEtatDemande(demandeCali, demandeEchange);
    if ((demandeCali.getClassementAdministratif() == null) || (!demandeCali.getClassementAdministratif().estClassementValide())) {
      demandeEchange.setClassementAdministratif(null);
    } else {
      demandeEchange.setClassementAdministratif(demandeCali.getClassementAdministratif().getTypeClassement());
    }
    int individuStable = individuStable(demandeCali.getDemandeur().getChronoDemandes());
    demandeEchange.setTopIndividuStable(individuStable);
    if (demandeCali.estNotifieeCourrier()) {
      demandeEchange.setIndicateurNotificationCourrier(1);
    } else {
      demandeEchange.setIndicateurNotificationCourrier(0);
    }
    demandeCali.getGamme().alimenterBaseEchanges(demandeCali, demandeEchange);
    
    return demandeEchange;
  }
  
  private static int individuStable(Chronologie chronoDemandes)
  {
    int individuStable = 1;
    
    ListIterator it = chronoDemandes.iterer();
    int nbDemandeEnReexamenLE1D = 0;
    int nbDemandeEnReexamenNONLE1D = 0;
    boolean bContinue = true;
    while ((it.hasNext()) && (bContinue))
    {
      DemandeSpec demande = (DemandeSpec)it.next();
      if (demande.getEvenementReferenceExamen().getTypeSegment() == "LE1D")
      {
        if (demande.estEnReExamen()) {
          nbDemandeEnReexamenLE1D++;
        }
      }
      else if (demande.estEnReExamen()) {
        nbDemandeEnReexamenNONLE1D++;
      }
      if (nbDemandeEnReexamenLE1D != 0) {
        bContinue = false;
      }
    }
    if (nbDemandeEnReexamenLE1D != 0) {
      individuStable = 0;
    } else if (nbDemandeEnReexamenNONLE1D != 0) {
      individuStable = 2;
    }
    return individuStable;
  }
  
  public static void alimenterDonneesCreationAttenteExamenFilEau(String typeAttente, Damj dateReference, String idTracker)
  {
    Decision demandeEchange = new Decision();
    demandeEchange.setIdentifiantEvenement(idTracker);
    
    demandeEchange.setCodeTypeAction("CA");
    
    demandeEchange.setCreationDALSuiteRejet(0);
    
    demandeEchange.setCodeTypeAttente(typeAttente);
    
    demandeEchange.setDateFCT(dateReference);
    
    DomManager.persisterEnProfondeur(demandeEchange);
  }
  
  public static void alimenterDonneesCreationDALExamenFilEau(String typeDal, Damj dateReference, String idTracker)
  {
    Decision demandeEchange = new Decision();
    demandeEchange.setIdentifiantEvenement(idTracker);
    
    demandeEchange.setCodeTypeAction("CD");
    
    demandeEchange.setCreationDALSuiteRejet(0);
    
    demandeEchange.setCodeTypeAttente("");
    
    demandeEchange.setDateFCT(dateReference);
    
    demandeEchange.setTypeExamenCreationDemande(typeDal);
    
    DomManager.persisterEnProfondeur(demandeEchange);
  }
  
  private static void renseignerGamme(DemandeSpec demandeCali, Decision demandeEchange)
  {
    demandeEchange.setGamme(demandeCali.getGamme().getNomUnique());
    
    demandeEchange.setReferenceExterneDemande(demandeCali.getFormulaire().getReferenceExterne());
    
    demandeEchange.setCodeSegment(demandeCali.getEvenementReferenceExamen().getTypeSegment());
    
    demandeEchange.setTypeExamen(determineTypeExamen(demandeCali));
  }
  
  public static String determineTypeExamen(DemandeSpec demande)
  {
    String retour = "";
    EvenementReferenceExamenSpec ere = demande.getEvenementReferenceExamen();
    if (ere != null) {
      retour = ConstructionCSOIA.getCSOIADepuisTypeExamen(ere.getTypeExamen());
    }
    return retour;
  }
  
  private static void renseignerEtatDemande(DemandeSpec demandeCali, Decision demandeEchange)
  {
    int etatDemande = 0;
    if (demandeCali.estEnReExamen())
    {
      etatDemande = 2;
      if (demandeCali.getMotifReexamenPrincipal() != null) {
        demandeEchange.setMotifReexamenPrincipal(Integer.parseInt(demandeCali.getMotifReexamenPrincipal()));
      }
    }
    else if (demandeCali.estClasseeOuDecisionneeValidee())
    {
      etatDemande = 1;
    }
    demandeEchange.setEtatDemande(etatDemande);
  }
  
  public static void renseignerCodeRejet(DemandeSpec demandeCali, Decision decision)
  {
    int motifRejet = 0;
    if ((demandeCali.getCodeMotifEchecPourSigma() != null) && (!demandeCali.getCodeMotifEchecPourSigma().equals(""))) {
      motifRejet = Integer.valueOf(demandeCali.getCodeMotifEchecPourSigma()).intValue();
    }
    if (((demandeCali.estEnReExamen()) || (((demandeCali.getDossierAffectation().getDossierExamen() instanceof RejetSpec)) && (motifRejet == 0))) && (demandeCali.getCodeMotifEchecPourSigmaSauvegarde() != null)) {
      motifRejet = Integer.valueOf(demandeCali.getCodeMotifEchecPourSigmaSauvegarde()).intValue();
    }
    decision.setMotifRejet(motifRejet);
  }
  
  public static String determineClassementAdministratif(DemandeSpec demande)
  {
    String cl = null;
    if (demande.getClassementAdministratif() != null)
    {
      ClassementAdministratif classementAdministratif = demande.getClassementAdministratif();
      if (classementAdministratif.estClassementValide()) {
        cl = classementAdministratif.getTypeClassement();
      }
    }
    return cl;
  }
}

/* Location:
 * Qualified Name:     AlimenterBaseEchanges
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */