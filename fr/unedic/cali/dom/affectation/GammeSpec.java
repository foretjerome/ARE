package fr.unedic.cali.dom.affectation;

import fr.unedic.util.temps.Damj;
import java.io.Serializable;
import java.util.List;

public abstract interface GammeSpec
  extends Serializable, FacadeLiquidationGammeSpec
{
  public static final String ASSURANCE = "ASU";
  public static final int CODE_ASSURANCE = 1;
  public static final String MAINTIEN = "MNT";
  public static final int CODE_MAINTIEN = 2;
  public static final String SOLIDARITE = "SOL";
  public static final int CODE_SOLIDARITE = 3;
  public static final String REMBOURSEMENT_PRISE_EN_CHARGE_FRAIS = "RBF";
  public static final int CODE_REMBOURSEMENT_PRISE_EN_CHARGE_FRAIS = 4;
  public static final String FORMATION = "FOR";
  public static final int CODE_FORMATION = 5;
  public static final String INCITATION_RECLASSEMENT = "INR";
  public static final int CODE_INCITATION_RECLASSEMENT = 6;
  public static final String RET = "RET";
  public static final int CODE_RET = 7;
  public static final String ARI = "ARI";
  public static final int CODE_ARI = 8;
  public static final String PRE_RETRAITE = "PRR";
  public static final int CODE_PRE_RETRAITE = 9;
  public static final String DECES = "DEC";
  public static final int CODE_DECES = 10;
  public static final int PRIORITE_ASSURANCE = 12;
  public static final int PRIORITE_RBF = 10;
  public static final int PRIORITE_FORMATION = 11;
  public static final int PRIORITE_SOLIDARITE = 9;
  public static final int PRIORITE_INR = 8;
  public static final int PRIORITE_ARI = 7;
  public static final int PRIORITE_RET = 7;
  public static final int PRIORITE_DEFAUT = 100;
  public static final int PRIORITE_PRE_RETRAITE = 100;
  public static final int PRIORITE_DECES = 7;
  
  public abstract void ajouterLigne(LigneSpec paramLigneSpec);
  
  public abstract void setListeLignes(List<LigneSpec> paramList);
  
  public abstract List<LigneSpec> getListeLignes();
  
  public abstract List<ProduitSpec> getProduitsActifs(Damj paramDamj);
  
  public abstract void setLibelle(String paramString);
  
  public abstract String getLibelle();
  
  public abstract ProduitSpec getProduit(String paramString);
  
  public abstract String getNomUnique();
  
  public abstract void setNomUnique(String paramString);
  
  public abstract int getPriorite();
}

/* Location:
 * Qualified Name:     GammeSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */