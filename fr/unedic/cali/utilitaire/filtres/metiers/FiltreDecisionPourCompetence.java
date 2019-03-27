package fr.unedic.cali.utilitaire.filtres.metiers;

import fr.unedic.cali.dom.DecisionAssuranceSpec;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDemandePourNumeroGamme;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreET;
import fr.unedic.util.temps.Temporel;

public class FiltreDecisionPourCompetence
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = 1L;
  public int mCompetenceAdministrative;
  public int mCompetenceFinanciere;
  public static final int COMPETENCE_NON_RENSEIGNEE = 0;
  public static final int COMPETENCE_SECTEUR_PUBLIC = 2;
  public static final int COMPETENCE_ASSEDIC = 1;
  
  public FiltreDecisionPourCompetence(int pCompetenceAdministrative, int pCompetenceFinanciere)
  {
    mCompetenceAdministrative = pCompetenceAdministrative;
    mCompetenceFinanciere = pCompetenceFinanciere;
  }
  
  public boolean accepterElement(Temporel temporel)
  {
    boolean accepter = false;
    
    FiltreET filtrePrerequis = new FiltreET();
    filtrePrerequis.ajouterFiltre(new FiltreDemandePourNumeroGamme(1));
    if (filtrePrerequis.accepter(temporel))
    {
      DecisionAssuranceSpec decision = (DecisionAssuranceSpec)temporel;
      int competenceAdministrative = decision.getCompetenceAdministrative();
      int competenceFinanciere = decision.getCompetenceFinanciere();
      if (((mCompetenceAdministrative == 0) || (competenceAdministrative == mCompetenceAdministrative)) && ((mCompetenceFinanciere == 0) || (competenceFinanciere == mCompetenceFinanciere))) {
        accepter = true;
      }
    }
    return accepter;
  }
  
  public int getTypeElementManipule()
  {
    return 1;
  }
}

/* Location:
 * Qualified Name:     FiltreDecisionPourCompetence
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */