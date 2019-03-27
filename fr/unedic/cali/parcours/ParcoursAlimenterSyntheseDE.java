package fr.unedic.cali.parcours;

import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.FormulaireSpec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.ChronologieDebuts;
import java.util.ArrayList;
import java.util.Collection;

public class ParcoursAlimenterSyntheseDE
  extends ParcoursServiceAbstrait
{
  public void controlerContexte(Contexte p_contexte)
    throws ContexteException
  {
    DomAlimenterSyntheseDE domCourant = (DomAlimenterSyntheseDE)p_contexte.getDonnees();
    
    Collection listeReferenceExterne = domCourant.getColReferenceExterneFormuliare();
    if ((listeReferenceExterne == null) || (listeReferenceExterne.size() == 0)) {
      throw new ContexteException("HG_PR_CALI_L_ERR_CONTEXTE", "La liste des références externes est absente.");
    }
  }
  
  public Resultat demarrerParcours(Contexte p_contexte)
    throws CoucheLogiqueException
  {
    Collection listeIdDemandesSyntheseDE = null;
    Collection listeReferenceExterne = null;
    if (Log.isTraceActive(ParcoursAlimenterSyntheseDE.class, Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, ParcoursAlimenterSyntheseDE.class, "demarrer", "\t\t******** Début Parcours AlimenterSyntheseDE ********\n");
    }
    ResultatAlimenterSyntheseDE resultatParcours = new ResultatAlimenterSyntheseDE(0);
    DomAlimenterSyntheseDE domCourant = (DomAlimenterSyntheseDE)p_contexte.getDonnees();
    
    listeReferenceExterne = domCourant.getColReferenceExterneFormuliare();
    
    IndividuSpec individu = getIndividu(p_contexte);
    
    ChronologieDebuts chronoDemandesDuDemandeur = individu.getChronoDemandes();
    if (!chronoDemandesDuDemandeur.estVide())
    {
      listeIdDemandesSyntheseDE = new ArrayList();
      chronoDemandesDuDemandeur.iterer();
      while (chronoDemandesDuDemandeur.encoreSuivant())
      {
        DemandeSpec demandeCourante = (DemandeSpec)chronoDemandesDuDemandeur.elementSuivant();
        if ((demandeCourante.getFormulaire() != null) && (demandeCourante.getFormulaire().getReferenceExterne() != null) && (listeReferenceExterne.contains(demandeCourante.getFormulaire().getReferenceExterne()))) {
          listeIdDemandesSyntheseDE.add(demandeCourante.getIdentifiant());
        }
      }
    }
    resultatParcours.setListeIdentifiantDemande(listeIdDemandesSyntheseDE);
    if (Log.isTraceActive(ParcoursAlimenterSyntheseDE.class, Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, ParcoursAlimenterSyntheseDE.class, "demarrer", "\n\t\t******** Fin Parcours AlimenterSyntheseDE ********\n");
    }
    return resultatParcours;
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu p_individu)
  {
    return 2;
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
 * Qualified Name:     ParcoursAlimenterSyntheseDE
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */