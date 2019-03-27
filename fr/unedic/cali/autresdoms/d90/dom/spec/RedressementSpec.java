package fr.unedic.cali.autresdoms.d90.dom.spec;

import fr.unedic.util.temps.Damj;
import java.util.List;

public abstract interface RedressementSpec
{
  public static final String ETAT_REEXAMEN_RECONDUIT_AVEC_ECART = "E";
  public static final String ETAT_REEXAMEN_RECONDUIT_SANS_ECART = "V";
  public static final String ETAT_REEXAMEN_MIS_EN_REEXAMEN = "R";
  public static final String ETAT_REEXAMEN_SANS_OBJET = "O";
  public static final String MODE_CREATION_SELECTION = "S";
  public static final String MODE_CREATION_REEXECUTION = "R";
  
  public abstract Damj getDatePassage();
  
  public abstract void setDatePassage(Damj paramDamj);
  
  public abstract String getLibelleRedressement();
  
  public abstract void setLibelleRedressement(String paramString);
  
  public abstract String getModeRedressement();
  
  public abstract void setModeRedressement(String paramString);
  
  public abstract String getNumeroPassage();
  
  public abstract void setNumeroPassage(String paramString);
  
  public abstract List<?> getListePopulation();
  
  public abstract void setListePopulation(List<?> paramList);
  
  public abstract String getCodeAssedic();
  
  public abstract void setCodeAssedic(String paramString);
  
  public abstract String getIdentifiantRapport();
  
  public abstract void setIdentifiantRapport(String paramString);
}

/* Location:
 * Qualified Name:     RedressementSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */