package fr.unedic.cali.dom;

import fr.unedic.cali.affectation.parametres.CriteresQualification;
import fr.unedic.cali.dom.affectation.DecorReglementaire;
import fr.unedic.cali.dom.affectation.QualificationPeriodeActiviteSalarie;
import fr.unedic.cali.dom.affectation.Reglement;
import fr.unedic.cali.dom.pnds.PeriodeNonDeclareeSanction;
import fr.unedic.util.temps.Temporel;

public abstract interface PeriodeActiviteSalarieCaliSpec
  extends ObjetPersistantSpec, Temporel
{
  public abstract Reglement getReglement();
  
  public abstract void ajouterQualification(QualificationPeriodeActiviteSalarie paramQualificationPeriodeActiviteSalarie);
  
  public abstract QualificationPeriodeActiviteSalarie getQualification(CriteresQualification paramCriteresQualification);
  
  public abstract boolean estQualifiable();
  
  public abstract boolean estLiquidable();
  
  public abstract void setEstLiquidable(boolean paramBoolean);
  
  public abstract boolean estFctPrincipale();
  
  public abstract void setEstFctPrincipale(boolean paramBoolean);
  
  public abstract DecorReglementaire getDecorCourant();
  
  public abstract void setDecorCourant(DecorReglementaire paramDecorReglementaire);
  
  public abstract CriteresQualification getCriteresQualification();
  
  public abstract void setCriteresQualification(CriteresQualification paramCriteresQualification);
  
  public abstract boolean estPndsSpectacleCharge();
  
  public abstract void setPndsSpectacleCharge(boolean paramBoolean);
  
  public abstract PeriodeNonDeclareeSanction getPndsSpectacle();
  
  public abstract void setPndsSpectacle(PeriodeNonDeclareeSanction paramPeriodeNonDeclareeSanction);
}

/* Location:
 * Qualified Name:     PeriodeActiviteSalarieCaliSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */