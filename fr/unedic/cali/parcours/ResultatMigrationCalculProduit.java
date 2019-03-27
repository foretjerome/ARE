package fr.unedic.cali.parcours;

import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public class ResultatMigrationCalculProduit
  extends ResultatDetailleProduit
  implements ResultatMigrationCalculProduitSpec, ObjetMetierSpec
{
  BigDecimal m_quantiteIndemnisee = null;
  Quantite m_capitalindemnise = null;
  Quantite m_montantJourBrutDJI = null;
  Damj m_premierMoisEnEcart = null;
  
  public Quantite getMontantJourBrutDJI()
  {
    return m_montantJourBrutDJI;
  }
  
  public void setMontantJourBrutDJI(Quantite p_montantJourBrutDJI)
  {
    m_montantJourBrutDJI = p_montantJourBrutDJI;
  }
  
  public Quantite getCapitalindemnise()
  {
    return m_capitalindemnise;
  }
  
  public void setCapitalindemnise(Quantite p_capitalindemnise)
  {
    m_capitalindemnise = p_capitalindemnise;
  }
  
  public BigDecimal getQuantiteIndemnisee()
  {
    return m_quantiteIndemnisee;
  }
  
  public void setQuantiteIndemnisee(BigDecimal p_quantiteIndemnisee)
  {
    m_quantiteIndemnisee = p_quantiteIndemnisee;
  }
  
  public Damj getPremierMoisEnEcart()
  {
    return m_premierMoisEnEcart;
  }
  
  public void setPremierMoisEnEcart(Damj p_premierMoisEnEcart)
  {
    m_premierMoisEnEcart = p_premierMoisEnEcart;
  }
  
  public int getCumulHeureActiviteReduite()
  {
    return 0;
  }
  
  public int getCumulMoisActiviteReduite()
  {
    return 0;
  }
  
  public Quantite getReliquatDureeIndemnisation()
  {
    return null;
  }
  
  public void setCumulHeureActiviteReduite(int p_cumulHeureActiviteReduite) {}
  
  public void setCumulMoisActiviteReduite(int p_cumulMoisActiviteReduite) {}
  
  public void setReliquatDureeIndemnisation(Quantite p_reliquatDureeIndemnisation) {}
  
  public ObjetMetierSpec copie()
  {
    ResultatMigrationCalculProduit copie = new ResultatMigrationCalculProduit();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    ResultatMigrationCalculProduit copie = (ResultatMigrationCalculProduit)p_copie;
    copie.setAttribution(getAttribution());
    
    copie.setCalendrierExecutionCalcul((CalendrierExecutionCalculSpec)getCalendrierExecutionCalcul().copie());
    
    copie.setCapitalindemnise(getCapitalindemnise());
    copie.setMontantJourBrutDJI(getMontantJourBrutDJI());
    copie.setQuantiteIndemnisee(getQuantiteIndemnisee());
    copie.setPremierMoisEnEcart(getPremierMoisEnEcart());
    copie.setEtat(getEtat());
  }
}

/* Location:
 * Qualified Name:     ResultatMigrationCalculProduit
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */