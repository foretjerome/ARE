package fr.unedic.cali.dom;

import fr.unedic.cali.calcul.dom.CalendrierExecutionAvantSpec;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculSpec;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.util.temps.Damj;
import java.util.Collection;

public abstract interface AttributionSpec
  extends DecisionSpec
{
  public abstract Damj getPji();
  
  public abstract void setPjiEffectif(Damj paramDamj);
  
  public abstract Damj getPjiEffectif();
  
  public abstract boolean estPjiEffectif();
  
  public abstract CalendrierExecutionCalculSpec getCalendrierExecutionCalcul();
  
  public abstract void setCalendrierExecutionCalcul(CalendrierExecutionCalculSpec paramCalendrierExecutionCalculSpec);
  
  public abstract CalendrierExecutionAvantSpec getCalendrierExecutionAvant();
  
  public abstract void setCalendrierExecutionAvant(CalendrierExecutionAvantSpec paramCalendrierExecutionAvantSpec);
  
  public abstract void setReferenceExterne(String paramString);
  
  public abstract String getReferenceExterne();
  
  public abstract String getRsod();
  
  public abstract String getRsrp();
  
  public abstract boolean estExecutable();
  
  public abstract Collection getAttributionLiees();
  
  public abstract FormuleMontantSpec getFormuleMontant(String paramString);
  
  public abstract IndividuSpec getDemandeur();
  
  public abstract GammeSpec getGamme();
  
  public abstract Damj getDateExamen();
  
  public abstract ProduitSpec getProduit();
  
  public abstract ProduitSpec getProduitExecution();
  
  public abstract void setReexecutee(boolean paramBoolean);
  
  public abstract String getIdentifiantDemande();
  
  public abstract boolean estEnReexamen();
  
  public abstract Damj getDateFinAbonnement();
  
  public abstract boolean estMigree();
  
  public abstract boolean estMigreeEnSimplifiee();
  
  public abstract boolean estNeutralise();
  
  public abstract String getTypeExamen();
  
  public abstract String getSituationParticuliere();
  
  public abstract DemandeSpec getDemandeSuivantePourTraitementReliquat();
  
  public abstract void setDemandeSuivantePourTraitementReliquat(DemandeSpec paramDemandeSpec);
}

/* Location:
 * Qualified Name:     AttributionSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */