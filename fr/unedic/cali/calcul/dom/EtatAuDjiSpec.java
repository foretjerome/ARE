package fr.unedic.cali.calcul.dom;

import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeDispositifSpec;
import fr.unedic.cali.dom.MontantBaseAbstrait;
import fr.unedic.util.Quantite;
import java.math.BigDecimal;

public abstract interface EtatAuDjiSpec
{
  public abstract Quantite getReliquatDureeIndemnisation();
  
  public abstract int getCumulMoisActiviteReduite();
  
  public abstract int getCumulHeuresActiviteReduite();
  
  public abstract boolean isEstFigee();
  
  public abstract void setEstFigee(boolean paramBoolean);
  
  public abstract void setCumulMoisActiviteReduite(int paramInt);
  
  public abstract void setCumulHeuresActiviteReduite(int paramInt);
  
  public abstract void setReliquatDureeIndemnisation(Quantite paramQuantite);
  
  public abstract MontantBaseAbstrait getMontant();
  
  public abstract int getNbJourAREF();
  
  public abstract void setNbJourAREF(int paramInt);
  
  public abstract Quantite getReliquatDureeProlongation();
  
  public abstract void setReliquatDureeProlongation(Quantite paramQuantite);
  
  public abstract Quantite getReliquatDureeRenouvellement();
  
  public abstract void setReliquatDureeRenouvellement(Quantite paramQuantite);
  
  public abstract int getNbMoisInactivite();
  
  public abstract void setNbMoisInactivite(int paramInt);
  
  public abstract BigDecimal getCapitalVerse();
  
  public abstract void setCapitalVerse(BigDecimal paramBigDecimal);
  
  public abstract boolean getEstEnAttenteRenouvellement();
  
  public abstract void setEstEnAttenteRenouvellement(boolean paramBoolean);
  
  public abstract ObjetChronoPeriodeDispositifSpec getPeriodeDispositifSpec();
  
  public abstract void setPeriodeDispositifSpec(ObjetChronoPeriodeDispositifSpec paramObjetChronoPeriodeDispositifSpec);
  
  public abstract int getCumulJoursIndemnise();
  
  public abstract void setCumulJoursIndemnise(int paramInt);
  
  public abstract int getNbMoisIndemniseAsu();
  
  public abstract void setNbMoisIndemniseAsu(int paramInt);
  
  public abstract Quantite getCapitalADR();
  
  public abstract void setCapitalADR(Quantite paramQuantite);
  
  public abstract boolean isEstNbMoisIndemniseAsu();
  
  public abstract void setEstNbMoisIndemniseAsu(boolean paramBoolean);
  
  public abstract int getCumulJoursAR();
  
  public abstract void setCumulJoursAR(int paramInt);
  
  public abstract void setReliquatDureeIndemnisationAvecMaintien(Quantite paramQuantite);
  
  public abstract EtatAuDji dupliquer();
}

/* Location:
 * Qualified Name:     EtatAuDjiSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */