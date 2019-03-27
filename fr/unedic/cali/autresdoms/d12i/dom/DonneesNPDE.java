package fr.unedic.cali.autresdoms.d12i.dom;

import fr.unedic.util.temps.Temporel;
import java.util.List;

public class DonneesNPDE
{
  private boolean estDemandeComplete;
  private boolean estLiquidable;
  private boolean estLiquAuto;
  private boolean estPresenceFormation;
  private List<Temporel> listePeriodeAffiliationDeclaree;
  private List<PeriodeAffiliationInstruction> listePeriodesEtPropositionCsp;
  private boolean liquidationStandardAutoPossible;
  private boolean demandeWebKO;
  private String identifiantDemandeInstruction;
  
  public boolean isEstDemandeComplete()
  {
    return estDemandeComplete;
  }
  
  public void setEstDemandeComplete(boolean estDemandeComplete)
  {
    this.estDemandeComplete = estDemandeComplete;
  }
  
  public boolean isEstLiquidable()
  {
    return estLiquidable;
  }
  
  public void setEstLiquidable(boolean estLiquidable)
  {
    this.estLiquidable = estLiquidable;
  }
  
  public boolean isEstLiquAuto()
  {
    return estLiquAuto;
  }
  
  public void setEstLiquAuto(boolean estLiquAuto)
  {
    this.estLiquAuto = estLiquAuto;
  }
  
  public boolean isEstPresenceFormation()
  {
    return estPresenceFormation;
  }
  
  public void setEstPresenceFormation(boolean estPresenceFormation)
  {
    this.estPresenceFormation = estPresenceFormation;
  }
  
  public List<Temporel> getListePeriodeAffiliationDeclaree()
  {
    return listePeriodeAffiliationDeclaree;
  }
  
  public void setListePeriodeAffiliationDeclaree(List<Temporel> listePeriodeAffiliationDeclaree)
  {
    this.listePeriodeAffiliationDeclaree = listePeriodeAffiliationDeclaree;
  }
  
  public void initialiserAFaux()
  {
    estDemandeComplete = false;
    estLiquAuto = false;
    estPresenceFormation = false;
    estLiquidable = false;
  }
  
  public String toString()
  {
    StringBuffer sb = new StringBuffer();
    sb.append(" complete : ");
    sb.append(estDemandeComplete);
    sb.append(" auto : ");
    sb.append(estLiquAuto);
    sb.append(" liquidable : ");
    sb.append(estLiquidable);
    sb.append(" formation : ");
    sb.append(estPresenceFormation);
    return sb.toString();
  }
  
  public List<PeriodeAffiliationInstruction> getListePeriodesEtPropositionCsp()
  {
    return listePeriodesEtPropositionCsp;
  }
  
  public void setListePeriodesEtPropositionCsp(List<PeriodeAffiliationInstruction> listePeriodesEtPropositionCsp)
  {
    this.listePeriodesEtPropositionCsp = listePeriodesEtPropositionCsp;
  }
  
  public boolean isLiquidationStandardAutoPossible()
  {
    return liquidationStandardAutoPossible;
  }
  
  public void setLiquidationStandardAutoPossible(boolean liquidationStandardAutoPossible)
  {
    this.liquidationStandardAutoPossible = liquidationStandardAutoPossible;
  }
  
  public boolean isDemandeWebKO()
  {
    return demandeWebKO;
  }
  
  public void setDemandeWebKO(boolean demandeWebKO)
  {
    this.demandeWebKO = demandeWebKO;
  }
  
  public String getIdentifiantDemandeInstruction()
  {
    return identifiantDemandeInstruction;
  }
  
  public void setIdentifiantDemandeInstruction(String identifiantDemandeInstruction)
  {
    this.identifiantDemandeInstruction = identifiantDemandeInstruction;
  }
}

/* Location:
 * Qualified Name:     DonneesNPDE
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */