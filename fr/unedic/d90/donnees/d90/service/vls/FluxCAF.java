package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.util.temps.Damj;

public abstract class FluxCAF
{
  public static FluxCAF getInstance()
  {
    return new _FluxCAFImpl();
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
  
  public abstract String getCodeCAF();
  
  public abstract void setCodeCAF(String paramString);
  
  public abstract String getCodeErreurCodeCAF();
  
  public abstract void setCodeErreurCodeCAF(String paramString);
  
  public abstract String getNumeroAllocataire();
  
  public abstract void setNumeroAllocataire(String paramString);
  
  public abstract String getCodeErreurNumeroAllocataire();
  
  public abstract void setCodeErreurNumeroAllocataire(String paramString);
  
  public abstract String getNIR();
  
  public abstract void setNIR(String paramString);
  
  public abstract String getCodeErreurNIR();
  
  public abstract void setCodeErreurNIR(String paramString);
  
  public abstract String getIdentifiantDemandeurCAF();
  
  public abstract void setIdentifiantDemandeurCAF(String paramString);
  
  public abstract String getCodeErreurIdentifiantDemandeurCAF();
  
  public abstract void setCodeErreurIdentifiantDemandeurCAF(String paramString);
  
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
  
  public abstract String getNumeroInseeCommune();
  
  public abstract void setNumeroInseeCommune(String paramString);
  
  public abstract String getCodeErreurNumeroInseeCommune();
  
  public abstract void setCodeErreurNumeroInseeCommune(String paramString);
  
  public abstract String getNumeroIdentification();
  
  public abstract void setNumeroIdentification(String paramString);
  
  public abstract String getCodeErreurNumeroIdentification();
  
  public abstract void setCodeErreurNumeroIdentification(String paramString);
  
  public abstract String getCodeStatut();
  
  public abstract void setCodeStatut(String paramString);
  
  public abstract String getCodeErreurCodeStatut();
  
  public abstract void setCodeErreurCodeStatut(String paramString);
  
  public abstract String getIdentifiantIndividuRNA();
  
  public abstract void setIdentifiantIndividuRNA(String paramString);
  
  public abstract String getCodeErreurIdentifiantIndividuRNA();
  
  public abstract void setCodeErreurIdentifiantIndividuRNA(String paramString);
  
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
  
  public abstract String getMoisEntree();
  
  public abstract void setMoisEntree(String paramString);
  
  public abstract String getCodeErreurMoisEntree();
  
  public abstract void setCodeErreurMoisEntree(String paramString);
  
  public abstract String getMoisSortie();
  
  public abstract void setMoisSortie(String paramString);
  
  public abstract String getCodeErreurMoisSortie();
  
  public abstract void setCodeErreurMoisSortie(String paramString);
  
  public abstract Damj getDateNaissance();
  
  public abstract void setDateNaissance(Damj paramDamj);
  
  public abstract String getCodeErreurDateNaissance();
  
  public abstract void setCodeErreurDateNaissance(String paramString);
  
  public abstract Damj getDateFichierExterne();
  
  public abstract void setDateFichierExterne(Damj paramDamj);
  
  public abstract String getCodeErreurDateFichierExterne();
  
  public abstract void setCodeErreurDateFichierExterne(String paramString);
}

/* Location:
 * Qualified Name:     FluxCAF
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */