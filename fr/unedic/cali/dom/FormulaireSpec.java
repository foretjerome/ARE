package fr.unedic.cali.dom;

import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Temporel;

public abstract interface FormulaireSpec
  extends ObjetPersistantSpec, Temporel
{
  public static final String DEFAULT_STRING = "";
  public static final int DEFAULT_INT = -1;
  
  public abstract Damj getDateDepot();
  
  public abstract DemandeSpec getDemande();
  
  public abstract int getIdPec();
  
  public abstract String getReferenceExterne();
  
  public abstract String getPresenceAe();
  
  public abstract String getDemandeLiquidable();
  
  public abstract String getMotifEnvoi();
  
  public abstract String getPresenceCarteSs();
  
  public abstract GammeSpec getGamme();
  
  public abstract String getNomGamme();
  
  public abstract String getNomLigne();
  
  public abstract String getNomProduit();
  
  public abstract Damj getDateCreationDal();
  
  public abstract void miseAjour(FormulaireSpec paramFormulaireSpec);
  
  public abstract boolean estDalNonRecevable();
  
  public abstract String getNumeroSuivi();
  
  public abstract boolean estEnvoiDalEffectue();
  
  public abstract int getReferenceExterneDemandeLiee();
}

/* Location:
 * Qualified Name:     FormulaireSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */