package fr.unedic.cali.parcours;

import fr.unedic.cali.dom.FormulaireSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;

public class DomCreationDemandePrestation
  extends DomCaliOptimise
  implements DomCali
{
  private FormulaireSpec formulaire;
  private IndividuSpec individu;
  private ContexteService contexteService;
  private boolean liquidationAutomatiqueActivee;
  private Damj dateDepotDerniereDemande;
  private boolean ideDerniereDemande;
  
  public Damj getDateDepotDerniereDemande()
  {
    return dateDepotDerniereDemande;
  }
  
  public void setDateDepotDerniereDemande(Damj dateDepotDerniereDemande)
  {
    this.dateDepotDerniereDemande = dateDepotDerniereDemande;
  }
  
  public FormulaireSpec getFormulaire()
  {
    return formulaire;
  }
  
  public void setFormulaire(FormulaireSpec pFormulaire)
  {
    formulaire = pFormulaire;
  }
  
  public IndividuSpec getIndividu()
  {
    return individu;
  }
  
  public void setIndividu(IndividuSpec pIndividu)
  {
    individu = pIndividu;
  }
  
  public static IndividuSpec getIndividu(Contexte pContexte)
  {
    return ((DomCreationDemandePrestation)pContexte.getDonnees()).getIndividu();
  }
  
  public static FormulaireSpec getFormulaire(Contexte pContexte)
  {
    return ((DomCreationDemandePrestation)pContexte.getDonnees()).getFormulaire();
  }
  
  public ContexteService getContexteService()
  {
    return contexteService;
  }
  
  public void setContexteService(ContexteService pContexteService)
  {
    contexteService = pContexteService;
  }
  
  public static ContexteService getContexteService(Contexte pContexte)
  {
    return ((DomCreationDemandePrestation)pContexte.getDonnees()).getContexteService();
  }
  
  public boolean isLiquidationAutomatiqueActivee()
  {
    return liquidationAutomatiqueActivee;
  }
  
  public void setLiquidationAutomatiqueActivee(boolean liquidationAutomatiqueActivee)
  {
    this.liquidationAutomatiqueActivee = liquidationAutomatiqueActivee;
  }
  
  public boolean isIdeDerniereDemande()
  {
    return ideDerniereDemande;
  }
  
  public void setIdeDerniereDemande(boolean estIdeDerniereDemande)
  {
    ideDerniereDemande = estIdeDerniereDemande;
  }
}

/* Location:
 * Qualified Name:     DomCreationDemandePrestation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */