package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.util.temps.Damj;

public abstract class FluxMSA
{
  public static FluxMSA getInstance()
  {
    return new _FluxMSAImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract String getTypeEnregistrement();
  
  public abstract void setTypeEnregistrement(String paramString);
  
  public abstract String getCodeErreurTypeEnregistrement();
  
  public abstract void setCodeErreurTypeEnregistrement(String paramString);
  
  public abstract String getCodeMSA();
  
  public abstract void setCodeMSA(String paramString);
  
  public abstract String getCodeErreurCodeMSA();
  
  public abstract void setCodeErreurCodeMSA(String paramString);
  
  public abstract String getNumeroAllocataire();
  
  public abstract void setNumeroAllocataire(String paramString);
  
  public abstract String getCodeErreurNumeroAllocataire();
  
  public abstract void setCodeErreurNumeroAllocataire(String paramString);
  
  public abstract String getNIRRectifie();
  
  public abstract void setNIRRectifie(String paramString);
  
  public abstract String getCodeErreurNIRRectifie();
  
  public abstract void setCodeErreurNIRRectifie(String paramString);
  
  public abstract String getIdentifiantEchangeMSA();
  
  public abstract void setIdentifiantEchangeMSA(String paramString);
  
  public abstract String getCodeErreurIdentifiantEchangeMSA();
  
  public abstract void setCodeErreurIdentifiantEchangeMSA(String paramString);
  
  public abstract String getNomPatronymique();
  
  public abstract void setNomPatronymique(String paramString);
  
  public abstract String getCodeErreurNomPatronymique();
  
  public abstract void setCodeErreurNomPatronymique(String paramString);
  
  public abstract String getPrenom();
  
  public abstract void setPrenom(String paramString);
  
  public abstract String getCodeErreurPrenom();
  
  public abstract void setCodeErreurPrenom(String paramString);
  
  public abstract String getCodePopulation();
  
  public abstract void setCodePopulation(String paramString);
  
  public abstract String getCodeErreurCodePopulation();
  
  public abstract void setCodeErreurCodePopulation(String paramString);
  
  public abstract String getDeptNumeroInseeCommune();
  
  public abstract void setDeptNumeroInseeCommune(String paramString);
  
  public abstract String getCodeErreurDeptNumeroInseeCommune();
  
  public abstract void setCodeErreurDeptNumeroInseeCommune(String paramString);
  
  public abstract String getNumeroIdentification();
  
  public abstract void setNumeroIdentification(String paramString);
  
  public abstract String getCodeErreurNumeroIdentification();
  
  public abstract void setCodeErreurNumeroIdentification(String paramString);
  
  public abstract String getCodeStatut();
  
  public abstract void setCodeStatut(String paramString);
  
  public abstract String getCodeErreurCodeStatut();
  
  public abstract void setCodeErreurCodeStatut(String paramString);
  
  public abstract String getIdentifiantIndividuBNI();
  
  public abstract void setIdentifiantIndividuBNI(String paramString);
  
  public abstract String getCodeErreurIdentifiantIndividuBNI();
  
  public abstract void setCodeErreurIdentifiantIndividuBNI(String paramString);
  
  public abstract String getNomMarital();
  
  public abstract void setNomMarital(String paramString);
  
  public abstract String getCodeErreurNomMarital();
  
  public abstract void setCodeErreurNomMarital(String paramString);
  
  public abstract String getCodeAnteriorite();
  
  public abstract void setCodeAnteriorite(String paramString);
  
  public abstract String getCodeErreurCodeAnteriorite();
  
  public abstract void setCodeErreurCodeAnteriorite(String paramString);
  
  public abstract String getZoneInfos();
  
  public abstract void setZoneInfos(String paramString);
  
  public abstract String getCodeErreurZoneInfos();
  
  public abstract void setCodeErreurZoneInfos(String paramString);
  
  public abstract Damj getDateDebutClcaAjpp();
  
  public abstract void setDateDebutClcaAjpp(Damj paramDamj);
  
  public abstract String getCodeErreurDateDebutClcaAjpp();
  
  public abstract void setCodeErreurDateDebutClcaAjpp(String paramString);
  
  public abstract Damj getDateFinClcaAjpp();
  
  public abstract void setDateFinClcaAjpp(Damj paramDamj);
  
  public abstract String getCodeErreurDateFinClcaAjpp();
  
  public abstract void setCodeErreurDateFinClcaAjpp(String paramString);
  
  public abstract Damj getDateNaissance();
  
  public abstract void setDateNaissance(Damj paramDamj);
  
  public abstract String getCodeErreurDateNaissance();
  
  public abstract void setCodeErreurDateNaissance(String paramString);
}

/* Location:
 * Qualified Name:     FluxMSA
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */