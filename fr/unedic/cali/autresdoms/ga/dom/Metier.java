package fr.unedic.cali.autresdoms.ga.dom;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Metier
{
  private int categorieEmploiParticulier;
  private int contratTypeParticulier;
  private int codeEmploi;
  private int champApplication;
  private int champApplicationRenseigne;
  private List listeRegimeRetraite;
  private int regimeSecu;
  private HashSet listeCategoriesEmploiSpe;
  
  public Metier()
  {
    listeRegimeRetraite = new ArrayList();
    listeCategoriesEmploiSpe = new HashSet();
  }
  
  public int getCategorieEmploiParticulier()
  {
    return categorieEmploiParticulier;
  }
  
  public void setCategorieEmploiParticulier(int categorie)
  {
    categorieEmploiParticulier = categorie;
  }
  
  public int getChampApplication()
  {
    return champApplication;
  }
  
  public void setChampApplication(int champApplication)
  {
    this.champApplication = champApplication;
    champApplicationRenseigne = champApplication;
    if ((champApplication == 13) || (champApplication == 14)) {
      this.champApplication = 5;
    }
  }
  
  public int getChampApplicationRenseigne()
  {
    return champApplicationRenseigne;
  }
  
  public void ajouter(RegimeRetraite regimeRetraite)
  {
    listeRegimeRetraite.add(regimeRetraite);
  }
  
  public List getListeRegimeRetraite()
  {
    return listeRegimeRetraite;
  }
  
  public int getCodeEmploi()
  {
    return codeEmploi;
  }
  
  public void setCodeEmploi(int i)
  {
    codeEmploi = i;
  }
  
  public int getRegimeSecu()
  {
    return regimeSecu;
  }
  
  public void setRegimeSecu(int i)
  {
    regimeSecu = i;
  }
  
  public int getContratTypeParticulier()
  {
    return contratTypeParticulier;
  }
  
  public void setContratTypeParticulier(int pContratTypeParticulier)
  {
    contratTypeParticulier = pContratTypeParticulier;
  }
  
  public HashSet getListeCategoriesEmploiSpe()
  {
    return listeCategoriesEmploiSpe;
  }
  
  public void setListeCategoriesEmploiSpe(HashSet pListeCategoriesEmploiSpe)
  {
    listeCategoriesEmploiSpe = pListeCategoriesEmploiSpe;
  }
}

/* Location:
 * Qualified Name:     Metier
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */