package fr.unedic.cali.autresdoms.d90.dom;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DeltaMontantMensuel
{
  private int mois;
  private int annee;
  private BigDecimal montantIndemniseAvant = BigDecimal.ZERO;
  private BigDecimal montantIndemniseApres = BigDecimal.ZERO;
  private BigDecimal deltaMontantFinancement = BigDecimal.ZERO;
  private BigDecimal deltaMontantCadt = BigDecimal.ZERO;
  private BigDecimal deltaMontantCrc = BigDecimal.ZERO;
  private Map<String, DeltaProduit> deltasProduits;
  
  public DeltaMontantMensuel()
  {
    deltasProduits = new HashMap();
  }
  
  public int getMois()
  {
    return mois;
  }
  
  public void setMois(int mois)
  {
    this.mois = mois;
  }
  
  public int getAnnee()
  {
    return annee;
  }
  
  public void setAnnee(int annee)
  {
    this.annee = annee;
  }
  
  public BigDecimal getMontantIndemniseAvant()
  {
    return montantIndemniseAvant;
  }
  
  public void setMontantIndemniseAvant(BigDecimal montantIndemniseAvant)
  {
    this.montantIndemniseAvant = montantIndemniseAvant;
  }
  
  public BigDecimal getMontantIndemniseApres()
  {
    return montantIndemniseApres;
  }
  
  public void setMontantIndemniseApres(BigDecimal montantIndemniseApres)
  {
    this.montantIndemniseApres = montantIndemniseApres;
  }
  
  public BigDecimal getDeltaMontantCadt()
  {
    return deltaMontantCadt;
  }
  
  public void setDeltaMontantCadt(BigDecimal deltaMontantCadt)
  {
    this.deltaMontantCadt = deltaMontantCadt;
  }
  
  public BigDecimal getDeltaMontantCrc()
  {
    return deltaMontantCrc;
  }
  
  public void setDeltaMontantCrc(BigDecimal deltaMontantCrc)
  {
    this.deltaMontantCrc = deltaMontantCrc;
  }
  
  public BigDecimal getDeltaMontantFinancement()
  {
    return deltaMontantFinancement;
  }
  
  public void setDeltaMontantFinancement(BigDecimal deltaMontantFinancement)
  {
    this.deltaMontantFinancement = deltaMontantFinancement;
  }
  
  public Collection<DeltaProduit> getDeltasProduits()
  {
    return deltasProduits.values();
  }
  
  public void ajouterDeltaProduit(DeltaProduit deltaProduit)
  {
    deltasProduits.put(deltaProduit.getCodeProduit(), deltaProduit);
  }
  
  public void supprimerDeltaProduit(String codeProduit)
  {
    deltasProduits.remove(codeProduit);
  }
  
  public DeltaProduit getDeltaProduit(String codeProduit)
  {
    return (DeltaProduit)deltasProduits.get(codeProduit);
  }
}

/* Location:
 * Qualified Name:     DeltaMontantMensuel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */