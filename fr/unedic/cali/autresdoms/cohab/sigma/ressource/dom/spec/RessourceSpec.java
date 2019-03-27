package fr.unedic.cali.autresdoms.cohab.sigma.ressource.dom.spec;

import fr.unedic.util.QuantiteEuro;
import fr.unedic.util.temps.Damj;

public abstract interface RessourceSpec
{
  public static final String SITUATION_FAMILIALE_SEULE = "S";
  public static final String SITUATION_FAMILIALE_COUPLE = "C";
  public static final String ORIGINE_ANCIEN_SYSTEME = "0";
  public static final String ORIGINE_ANNUELLE = "D";
  public static final String ORIGINE_DDTE_SANS_DEPOT_TARDIF = "C";
  public static final String ORIGINE_DDTE_SUITE_DEPOT_TARDIF = "T";
  public static final String ORIGINE_SEMESTRIELLE = "S";
  public static final String ORIGINE_OUVERTURE_DROIT = "O";
  public static final String ORIGINE_DROIT_AER = "A";
  public static final String ORIGINE_EXAMEN_AER = "E";
  public static final String CERTIFICATION_DECLARE = "D";
  public static final String CERTIFICATION_CONFIRME_DDTE = "C";
  
  public abstract String getIdentifiantDemande();
  
  public abstract void setIdentifiantDemande(String paramString);
  
  public abstract String getCodeSituationFamiliale();
  
  public abstract void setCodeSituationFamiliale(String paramString);
  
  public abstract QuantiteEuro getMontant();
  
  public abstract void setMontant(QuantiteEuro paramQuantiteEuro);
  
  public abstract String getCodeCertification();
  
  public abstract void setCodeCertification(String paramString);
  
  public abstract int getRang();
  
  public abstract void setRang(int paramInt);
  
  public abstract String getOrigine();
  
  public abstract void setOrigine(String paramString);
  
  public abstract Damj getDateEffet();
  
  public abstract void setDateEffet(Damj paramDamj);
  
  public abstract QuantiteEuro getRessourcesAllocataire();
  
  public abstract void setRessourcesAllocataire(QuantiteEuro paramQuantiteEuro);
  
  public abstract QuantiteEuro getRessourcesConjoint();
  
  public abstract void setRessourcesConjoint(QuantiteEuro paramQuantiteEuro);
  
  public abstract void setDateReference(Damj paramDamj);
  
  public abstract Damj getDateReference();
}

/* Location:
 * Qualified Name:     RessourceSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */