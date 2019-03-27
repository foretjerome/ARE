package fr.pe.cali.crem.dom;

import fr.pe.cali.crem.dom.spec.IDonneesFonctionnellesCrem;
import java.sql.Timestamp;

public class ObjetMetierCrem
{
  private String cxass;
  private String identifiant;
  private String type;
  private Timestamp dateCreation;
  private String codeEvenementMetier;
  private String typeOperation;
  private String statutEmission;
  private Timestamp dateDerniereEmission;
  private Timestamp dateReception;
  private String statutTraitement;
  private Timestamp dateTraitement;
  private String typeGeneration;
  private MetaDonneeCrem premiereMetaDonnee;
  private MetaDonneeCrem deuxiemeMetaDonnee;
  private MetaDonneeCrem troisiemeMetaDonnee;
  private MetaDonneeCrem quatriemeMetaDonnee;
  private MetaDonneeCrem cinquiemeMetaDonnee;
  private IDonneesFonctionnellesCrem donneesFonctionnelles;
  private String versionObjetMetier;
  
  public String getCxass()
  {
    return cxass;
  }
  
  public void setCxass(String cxass)
  {
    this.cxass = cxass;
  }
  
  public String getIdentifiant()
  {
    return identifiant;
  }
  
  public void setIdentifiant(String identifiant)
  {
    this.identifiant = identifiant;
  }
  
  public String getType()
  {
    return type;
  }
  
  public void setType(String type)
  {
    this.type = type;
  }
  
  public Timestamp getDateCreation()
  {
    return dateCreation;
  }
  
  public void setDateCreation(Timestamp dateCreation)
  {
    this.dateCreation = dateCreation;
  }
  
  public String getCodeEvenementMetier()
  {
    return codeEvenementMetier;
  }
  
  public void setCodeEvenementMetier(String codeEvenementMetier)
  {
    this.codeEvenementMetier = codeEvenementMetier;
  }
  
  public String getTypeOperation()
  {
    return typeOperation;
  }
  
  public void setTypeOperation(String typeOperation)
  {
    this.typeOperation = typeOperation;
  }
  
  public String getStatutEmission()
  {
    return statutEmission;
  }
  
  public void setStatutEmission(String statutEmission)
  {
    this.statutEmission = statutEmission;
  }
  
  public Timestamp getDateDerniereEmission()
  {
    return dateDerniereEmission;
  }
  
  public void setDateDerniereEmission(Timestamp dateDerniereEmission)
  {
    this.dateDerniereEmission = dateDerniereEmission;
  }
  
  public Timestamp getDateReception()
  {
    return dateReception;
  }
  
  public void setDateReception(Timestamp dateReception)
  {
    this.dateReception = dateReception;
  }
  
  public String getStatutTraitement()
  {
    return statutTraitement;
  }
  
  public void setStatutTraitement(String statutTraitement)
  {
    this.statutTraitement = statutTraitement;
  }
  
  public Timestamp getDateTraitement()
  {
    return dateTraitement;
  }
  
  public void setDateTraitement(Timestamp dateTraitement)
  {
    this.dateTraitement = dateTraitement;
  }
  
  public String getTypeGeneration()
  {
    return typeGeneration;
  }
  
  public void setTypeGeneration(String typeGeneration)
  {
    this.typeGeneration = typeGeneration;
  }
  
  public MetaDonneeCrem getPremiereMetaDonnee()
  {
    return premiereMetaDonnee;
  }
  
  public void setPremiereMetaDonnee(MetaDonneeCrem premiereMetaDonnee)
  {
    this.premiereMetaDonnee = premiereMetaDonnee;
  }
  
  public MetaDonneeCrem getDeuxiemeMetaDonnee()
  {
    return deuxiemeMetaDonnee;
  }
  
  public void setDeuxiemeMetaDonnee(MetaDonneeCrem deuxiemeMetaDonnee)
  {
    this.deuxiemeMetaDonnee = deuxiemeMetaDonnee;
  }
  
  public MetaDonneeCrem getTroisiemeMetaDonnee()
  {
    return troisiemeMetaDonnee;
  }
  
  public void setTroisiemeMetaDonnee(MetaDonneeCrem troisiemeMetaDonnee)
  {
    this.troisiemeMetaDonnee = troisiemeMetaDonnee;
  }
  
  public MetaDonneeCrem getQuatriemeMetaDonnee()
  {
    return quatriemeMetaDonnee;
  }
  
  public void setQuatriemeMetaDonnee(MetaDonneeCrem quatriemeMetaDonnee)
  {
    this.quatriemeMetaDonnee = quatriemeMetaDonnee;
  }
  
  public MetaDonneeCrem getCinquiemeMetaDonnee()
  {
    return cinquiemeMetaDonnee;
  }
  
  public void setCinquiemeMetaDonnee(MetaDonneeCrem cinquiemeMetaDonnee)
  {
    this.cinquiemeMetaDonnee = cinquiemeMetaDonnee;
  }
  
  public IDonneesFonctionnellesCrem getDonneesFonctionnelles()
  {
    return donneesFonctionnelles;
  }
  
  public void setDonneesFonctionnelles(IDonneesFonctionnellesCrem donneesFonctionnelles)
  {
    this.donneesFonctionnelles = donneesFonctionnelles;
  }
  
  public String getVersionObjetMetier()
  {
    return versionObjetMetier;
  }
  
  public void setVersionObjetMetier(String versionObjetMetier)
  {
    this.versionObjetMetier = versionObjetMetier;
  }
}

/* Location:
 * Qualified Name:     ObjetMetierCrem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */