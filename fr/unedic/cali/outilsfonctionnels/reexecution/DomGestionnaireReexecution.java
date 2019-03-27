package fr.unedic.cali.outilsfonctionnels.reexecution;

import fr.unedic.cali.autresdoms.d90.dom.spec.ComportementSpec;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.outilsfonctionnels.EvenementReexamen;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DomGestionnaireReexecution
{
  private IndividuSpec individu;
  private DemandeSpec demandeAValider;
  private EvenementReexamen evenementReexamen;
  private Damj dateReexecutionInitiale;
  private Damj dateReexecutionCourante;
  private List<DemandeSpec> listeDemandesAReliquider;
  private List<DemandeSpec> listeDemandesAReliquiderInitiale;
  private List<AttributionSpec> listeAttributionsAReexecuter;
  private List<DemandeSpec> listeAttributionsANettoyer;
  private ComportementSpec comportement;
  private HashMap<DemandeSpec, Integer> compteurLiquidationDemande;
  private boolean examenFilEauDesactive = false;
  private String contexteEmission;
  
  public DomGestionnaireReexecution()
  {
    listeAttributionsANettoyer = new ArrayList();
    listeAttributionsAReexecuter = new ArrayList();
    listeDemandesAReliquider = new ArrayList();
    compteurLiquidationDemande = new HashMap();
  }
  
  public ComportementSpec getComportement()
  {
    return comportement;
  }
  
  public void setComportement(ComportementSpec comportement)
  {
    this.comportement = comportement;
  }
  
  public Damj getDateReexecutionCourante()
  {
    return dateReexecutionCourante;
  }
  
  public void setDateReexecutionCourante(Damj dateReexecutionCourante)
  {
    this.dateReexecutionCourante = dateReexecutionCourante;
  }
  
  public Damj getDateReexecutionInitiale()
  {
    return dateReexecutionInitiale;
  }
  
  public void setDateReexecutionInitiale(Damj dateReexecutionInitiale)
  {
    this.dateReexecutionInitiale = dateReexecutionInitiale;
  }
  
  public EvenementReexamen getEvenementReexamen()
  {
    return evenementReexamen;
  }
  
  public void setEvenementReexamen(EvenementReexamen evenementReexamen)
  {
    this.evenementReexamen = evenementReexamen;
  }
  
  public IndividuSpec getIndividu()
  {
    return individu;
  }
  
  public void setIndividu(IndividuSpec individu)
  {
    this.individu = individu;
  }
  
  public List<DemandeSpec> getListeAttributionsANettoyer()
  {
    return listeAttributionsANettoyer;
  }
  
  public void setListeAttributionsANettoyer(List<DemandeSpec> listeAttributionsANettoyer)
  {
    this.listeAttributionsANettoyer = listeAttributionsANettoyer;
  }
  
  public List<AttributionSpec> getListeAttributionsAReexecuter()
  {
    return listeAttributionsAReexecuter;
  }
  
  public void setListeAttributionsAReexecuter(List<AttributionSpec> listeAttributionsAReexecuter)
  {
    this.listeAttributionsAReexecuter = listeAttributionsAReexecuter;
  }
  
  public List<DemandeSpec> getListeDemandesAReliquider()
  {
    return listeDemandesAReliquider;
  }
  
  public void setListeDemandesAReliquider(List<DemandeSpec> listeDemandesAReliquider)
  {
    this.listeDemandesAReliquider = listeDemandesAReliquider;
  }
  
  public DemandeSpec getDemandeAValider()
  {
    return demandeAValider;
  }
  
  public void setDemandeAValider(DemandeSpec demandeAValider)
  {
    this.demandeAValider = demandeAValider;
  }
  
  public HashMap<DemandeSpec, Integer> getCompteurLiquidationDemande()
  {
    return compteurLiquidationDemande;
  }
  
  public List<DemandeSpec> getListeDemandesAReliquiderInitiale()
  {
    return listeDemandesAReliquiderInitiale;
  }
  
  public void setListeDemandesAReliquiderInitiale(List<DemandeSpec> listeDemandesAReliquiderInitiale)
  {
    this.listeDemandesAReliquiderInitiale = listeDemandesAReliquiderInitiale;
  }
  
  public boolean isExamenFilEauDesactive()
  {
    return examenFilEauDesactive;
  }
  
  public void setExamenFilEauDesactive(boolean examenFilEauDesactive)
  {
    this.examenFilEauDesactive = examenFilEauDesactive;
  }
  
  public String getContexteEmission()
  {
    return contexteEmission;
  }
  
  public void setContexteEmission(String contexteEmission)
  {
    this.contexteEmission = contexteEmission;
  }
}

/* Location:
 * Qualified Name:     DomGestionnaireReexecution
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */