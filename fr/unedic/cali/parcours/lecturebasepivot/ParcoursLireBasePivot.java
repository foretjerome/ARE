package fr.unedic.cali.parcours.lecturebasepivot;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.cali.dom.pivot.Aides;
import fr.unedic.cali.dom.pivot.Decision;
import fr.unedic.cali.dom.pivot.DemandePivot;
import fr.unedic.cali.parcours.AccesDonneesGaecException;
import fr.unedic.cali.parcours.ParcoursServiceAbstrait;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.Resultat;
import java.util.ArrayList;
import java.util.List;

public class ParcoursLireBasePivot
  extends ParcoursServiceAbstrait
{
  protected Resultat demarrerParcours(Contexte contexte)
    throws ApplicativeException
  {
    DomLireBasePivot donnees = (DomLireBasePivot)contexte.getDonnees();
    ResultatLireBasePivot resultat = new ResultatLireBasePivot();
    
    List<DemandePivot> listeDemandesPivots = DomManager.getDemandesPivot();
    if ((donnees.getReferenceExterne() != null) && (!"".equals(donnees.getReferenceExterne())))
    {
      List<DemandePivot> liste = new ArrayList();
      DemandePivot demande = recupererDemandePivot(donnees.getReferenceExterne(), listeDemandesPivots);
      if (demande != null) {
        liste.add(demande);
      }
      resultat.setListeDemandes(liste);
    }
    else
    {
      resultat.setListeDemandes(listeDemandesPivots);
    }
    resultat.setEtat(0);
    return resultat;
  }
  
  protected DemandePivot recupererDemandePivot(String referenceExterne, List<DemandePivot> listeDemandes)
  {
    DemandePivot demande = null;
    for (DemandePivot demandeCourante : listeDemandes) {
      if ((estDecisionPivotRecherchee(referenceExterne, demandeCourante)) || (estAidesPivotRecherchee(referenceExterne, demandeCourante)))
      {
        demande = demandeCourante;
        break;
      }
    }
    return demande;
  }
  
  protected boolean estDecisionPivotRecherchee(String referenceExterne, DemandePivot demande)
  {
    return (demande.getDecision() != null) && (referenceExterne.equals(demande.getDecision().getReferenceExterneDemande()));
  }
  
  protected boolean estAidesPivotRecherchee(String referenceExterne, DemandePivot demande)
  {
    return (demande.getAides() != null) && (referenceExterne.equals(demande.getAides().getReferenceExterne()));
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu individu)
  {
    return 0;
  }
  
  protected void alimenterAgregatGaec(Individu individu, String idDemande) {}
  
  protected void controlerPostTraitement(Individu individu)
    throws AccesDonneesGaecException
  {}
}

/* Location:
 * Qualified Name:     ParcoursLireBasePivot
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */