package fr.unedic.cali.autresdoms.d90.dom.comportement;

import fr.unedic.cali.autresdoms.d90.dom.spec.ComportementSpec;
import fr.unedic.cali.utilitaire.decideur.spec.DecideurDecisionSpec;

public abstract class ComportementAbstrait
  implements ComportementSpec
{
  protected String libelleComportement;
  protected String rexamenDecisionMigrees;
  protected boolean reexucutionDecisionMigrees;
  protected String typeMandatement;
  protected boolean applicationSurPremiereDecision;
  protected String identifiantComportement;
  protected boolean ecrireEnBaseVisu;
  protected boolean utilise;
  protected boolean reexamenAlertesNonBloquantes;
  protected boolean comparerBasesPivotsEchanges;
  protected DecideurDecisionSpec decideur;
  
  public String getIdentifiantComportement()
  {
    return identifiantComportement;
  }
  
  public String getLibelleComportement()
  {
    return libelleComportement;
  }
  
  public boolean isApplicationSurPremiereDecision()
  {
    return applicationSurPremiereDecision;
  }
  
  public boolean isReexucutionDecisionMigrees()
  {
    return reexucutionDecisionMigrees;
  }
  
  public String getRexamenDecisionMigrees()
  {
    return rexamenDecisionMigrees;
  }
  
  public String getTypeMandatement()
  {
    return typeMandatement;
  }
  
  public boolean isEcrireEnBaseVisu()
  {
    return ecrireEnBaseVisu;
  }
  
  public boolean isUtilise()
  {
    return utilise;
  }
  
  public void setUtilise(boolean utilise)
  {
    this.utilise = utilise;
  }
  
  public boolean isReexamenAlertesNonBloquantes()
  {
    return reexamenAlertesNonBloquantes;
  }
  
  public boolean isComparerBasesPivotsEchanges()
  {
    return comparerBasesPivotsEchanges;
  }
  
  public DecideurDecisionSpec getDecideur()
  {
    return decideur;
  }
  
  public void setDecideur(DecideurDecisionSpec decideur)
  {
    this.decideur = decideur;
  }
}

/* Location:
 * Qualified Name:     ComportementAbstrait
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */