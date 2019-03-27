package fr.unedic.cali.calcul.dom;

import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeDispositifSpec;
import fr.unedic.cali.dom.ObjetPersistantSpec;
import fr.unedic.cali.dom.SalaireJournalierSpec;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public abstract interface ConstituantsCalculActiviteReduiteSpec
  extends ObjetPersistantSpec
{
  public static final int LIMITATION_TAILLE_NB_MOIS_ACTIVITE_REDUITE = 99;
  public static final int LIMITATION_TAILLE_NB_HEURE_ACTIVITE_REDUITE = 9999;
  
  public abstract String getCumulActiviteReduite();
  
  public abstract int getCumul();
  
  public abstract ObjetChronoPeriodeDispositifSpec getObjetChronoPeriodeDispositifADate(Damj paramDamj);
  
  public abstract BigDecimal getCumulHeuresAR();
  
  public abstract int getNbMoisInactivite();
  
  public abstract void setNbMoisInactivite(int paramInt);
  
  public abstract boolean estConnuNbMoisInactivite();
  
  public abstract void setCumul(int paramInt);
  
  public abstract void setCumulHeuresAR(BigDecimal paramBigDecimal);
  
  public abstract void setSjrProduit(SalaireJournalierSpec paramSalaireJournalierSpec);
  
  public abstract SalaireJournalierSpec getSjrProduit();
  
  public abstract void setSjcProduit(SalaireJournalierSpec paramSalaireJournalierSpec);
  
  public abstract SalaireJournalierSpec getSjcProduit();
  
  public abstract int getCumulJours();
  
  public abstract int getCumulMoisNonIndemnise();
  
  public abstract void setCumulMoisNonIndemnise(int paramInt);
}

/* Location:
 * Qualified Name:     ConstituantsCalculActiviteReduiteSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */