package fr.unedic.cali.autresdoms.cohab.sigma.enveloppe.dom.spec;

import java.math.BigDecimal;

public abstract interface StructureInEnveloppeSpec
{
  public static final char TYPE_AIDE_STATISTIQUE_FORMATION_AFPE = 'P';
  public static final char TYPE_AIDE_STATISTIQUE_FORMATION_HOMOLOGUEE_PRIORITAIRE = 'I';
  public static final char TYPE_AIDE_STATISTIQUE_FORMATION_CONVENTIONNEE = 'C';
  public static final char TYPE_AIDE_STATISTIQUE_FORMATION_HOMOLOGUEE_NON_PRIORITAIRE_OFAA = 'J';
  public static final char TYPE_AIDE_STATISTIQUE_FORMATION_HOMOLOGUEE_PAR_DEFAUT = 'H';
  public static final String MOTIF_MONTANT_DISPONIBLE_INSUFFISANT = "M60D";
  
  public abstract BigDecimal getMontantEngagerAvant();
  
  public abstract void setMontantEngagerAvant(BigDecimal paramBigDecimal);
  
  public abstract BigDecimal getMontantEngagerApres();
  
  public abstract void setMontantEngagerApres(BigDecimal paramBigDecimal);
  
  public abstract int getExerciceAvant();
  
  public abstract void setExerciceAvant(int paramInt);
  
  public abstract int getExerciceApres();
  
  public abstract void setExerciceApres(int paramInt);
  
  public abstract String getTypeConventionFormation();
  
  public abstract void setTypeConventionFormation(String paramString);
  
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
 * Qualified Name:     StructureInEnveloppeSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */