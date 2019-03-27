package fr.unedic.d90.donnees.d90.service.vls;

import java.math.BigDecimal;

public abstract class ResultatService
{
  public static ResultatService getInstance()
  {
    return new _ResultatServiceImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract ListeErreurs getListeErreurs();
  
  public abstract void setListeErreurs(ListeErreurs paramListeErreurs);
  
  public abstract ListeErreurs setNewListeErreurs();
  
  public abstract ListeIndicateurs getListeIndicateurs();
  
  public abstract void setListeIndicateurs(ListeIndicateurs paramListeIndicateurs);
  
  public abstract ListeIndicateurs setNewListeIndicateurs();
  
  public abstract BigDecimal getEtat();
  
  public abstract void setEtat(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurEtat();
  
  public abstract void setCodeErreurEtat(String paramString);
  
  public abstract BigDecimal getIndividuNCP();
  
  public abstract void setIndividuNCP(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurIndividuNCP();
  
  public abstract void setCodeErreurIndividuNCP(String paramString);
}

/* Location:
 * Qualified Name:     ResultatService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */