package fr.unedic.cali.dom;

import fr.unedic.util.temps.Damj;

public abstract interface ComportementExamenFilEauSpec
{
  public static final int NOMBRE_MAXIMUM_FCT_A_TRAITER_COMPORTEMENT_AUTO = 10;
  public static final int NOMBRE_MAXIMUM_FCT_A_TRAITER_COMPORTEMENT_MANUEL = 1;
  public static final String LIB_COMPORTEMENT_EXAMEN_FIL_EAU_AUTO = "Comportement examen au fil de l'eau automatique";
  public static final String LIB_COMPORTEMENT_EXAMEN_FIL_EAU_MANUEL = "Comportement examen au fil de l'eau manuel";
  public static final Integer ID_COMPORTEMENT_EFE_AUTO = Integer.valueOf(0);
  public static final Integer ID_COMPORTEMENT_EFE_MANUEL = Integer.valueOf(1);
  
  public abstract String getLibelleComportement();
  
  public abstract Integer getIdentifiantComportement();
  
  public abstract void setLibelleComportement(String paramString);
  
  public abstract boolean isModeSimulationActif();
  
  public abstract void setModeSimulationActif(boolean paramBoolean);
  
  public abstract boolean isCalculAffiliationSimplifieeActif();
  
  public abstract void setCalculAffiliationSimplifieeActif(boolean paramBoolean);
  
  public abstract int getNombreMaximumFctATraiter();
  
  public abstract void setNombreMaximumFctATraiter(int paramInt);
  
  public abstract Damj getDateEvenementDeclencheur();
  
  public abstract void setDateEvenementDeclencheur(Damj paramDamj);
  
  public abstract int getNatureEvenementDeclencheur();
  
  public abstract void setNatureEvenementDeclencheur(int paramInt);
}

/* Location:
 * Qualified Name:     ComportementExamenFilEauSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */