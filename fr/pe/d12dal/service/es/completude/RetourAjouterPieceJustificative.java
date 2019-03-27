package fr.pe.d12dal.service.es.completude;

import fr.pe.d12dal.dictionnaire.CodeRetourAppelServiceEnumeration;

public abstract class RetourAjouterPieceJustificative
{
  public static RetourAjouterPieceJustificative getInstance()
  {
    return new _RetourAjouterPieceJustificativeImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract CodeRetourAppelServiceEnumeration getEnumerationCodeRetour();
  
  public abstract String getCodeRetour();
  
  public abstract void setEnumerationCodeRetour(CodeRetourAppelServiceEnumeration paramCodeRetourAppelServiceEnumeration);
  
  public abstract String getCodeErreurCodeRetour();
  
  public abstract void setCodeErreurCodeRetour(String paramString);
}

/* Location:
 * Qualified Name:     RetourAjouterPieceJustificative
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */