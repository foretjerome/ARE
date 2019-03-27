package fr.unedic.cali.autresdoms.cohab.sigma.enveloppe.dom.spec;

import fr.unedic.cali.autresdoms.cohab.sigma.dom.Spec.CriteresSpec;
import java.math.BigDecimal;

public abstract interface CriteresEnveloppeSpec
  extends CriteresSpec
{
  public abstract String getNumeroAllocataire();
  
  public abstract void setNumeroAllocataire(String paramString);
  
  public abstract BigDecimal getMontantEngagerAvant();
  
  public abstract void setMontantEngagerAvant(BigDecimal paramBigDecimal);
  
  public abstract BigDecimal getMontantEngagerApres();
  
  public abstract void setMontantEngagerApres(BigDecimal paramBigDecimal);
  
  public abstract int getExerciceAvant();
  
  public abstract void setExerciceAvant(int paramInt);
  
  public abstract int getExerciceApres();
  
  public abstract void setExerciceApres(int paramInt);
  
  public abstract String getNumeroConventionFormation();
  
  public abstract void setNumeroConventionFormation(String paramString);
  
  public abstract int getIdentifiantActionFormation();
  
  public abstract void setIdentifiantActionFormation(int paramInt);
  
  public abstract int getStatutAvant();
  
  public abstract void setStatutAvant(int paramInt);
  
  public abstract int getStatutApres();
  
  public abstract void setStatutApres(int paramInt);
  
  public abstract String getClassementAdministratif();
  
  public abstract void setClassementAdministratif(String paramString);
  
  public abstract int getNatureDecision();
  
  public abstract void setNatureDecision(int paramInt);
  
  public abstract String getOrigineFonctionnelle();
  
  public abstract void setOrigineFonctionnelle(String paramString);
}

/* Location:
 * Qualified Name:     CriteresEnveloppeSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */