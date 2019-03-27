package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public abstract class FluxCPAM
{
  public static FluxCPAM getInstance()
  {
    return new _FluxCPAMImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract String getNumeroAllocataire();
  
  public abstract void setNumeroAllocataire(String paramString);
  
  public abstract String getCodeErreurNumeroAllocataire();
  
  public abstract void setCodeErreurNumeroAllocataire(String paramString);
  
  public abstract String getIndicateurCarence();
  
  public abstract void setIndicateurCarence(String paramString);
  
  public abstract String getCodeErreurIndicateurCarence();
  
  public abstract void setCodeErreurIndicateurCarence(String paramString);
  
  public abstract String getNir();
  
  public abstract void setNir(String paramString);
  
  public abstract String getCodeErreurNir();
  
  public abstract void setCodeErreurNir(String paramString);
  
  public abstract String getNom();
  
  public abstract void setNom(String paramString);
  
  public abstract String getCodeErreurNom();
  
  public abstract void setCodeErreurNom(String paramString);
  
  public abstract String getNomUsuel();
  
  public abstract void setNomUsuel(String paramString);
  
  public abstract String getCodeErreurNomUsuel();
  
  public abstract void setCodeErreurNomUsuel(String paramString);
  
  public abstract String getPrenom();
  
  public abstract void setPrenom(String paramString);
  
  public abstract String getCodeErreurPrenom();
  
  public abstract void setCodeErreurPrenom(String paramString);
  
  public abstract String getCodeAssedic();
  
  public abstract void setCodeAssedic(String paramString);
  
  public abstract String getCodeErreurCodeAssedic();
  
  public abstract void setCodeErreurCodeAssedic(String paramString);
  
  public abstract String getCodePostal();
  
  public abstract void setCodePostal(String paramString);
  
  public abstract String getCodeErreurCodePostal();
  
  public abstract void setCodeErreurCodePostal(String paramString);
  
  public abstract Damj getDateDebut();
  
  public abstract void setDateDebut(Damj paramDamj);
  
  public abstract String getCodeErreurDateDebut();
  
  public abstract void setCodeErreurDateDebut(String paramString);
  
  public abstract Damj getDateFin();
  
  public abstract void setDateFin(Damj paramDamj);
  
  public abstract String getCodeErreurDateFin();
  
  public abstract void setCodeErreurDateFin(String paramString);
  
  public abstract Damj getDateNaissance();
  
  public abstract void setDateNaissance(Damj paramDamj);
  
  public abstract String getCodeErreurDateNaissance();
  
  public abstract void setCodeErreurDateNaissance(String paramString);
  
  public abstract BigDecimal getNumeroCPAM();
  
  public abstract void setNumeroCPAM(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurNumeroCPAM();
  
  public abstract void setCodeErreurNumeroCPAM(String paramString);
}

/* Location:
 * Qualified Name:     FluxCPAM
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */