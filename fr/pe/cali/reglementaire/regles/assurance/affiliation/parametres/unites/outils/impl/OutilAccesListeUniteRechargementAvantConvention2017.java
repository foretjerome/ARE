package fr.pe.cali.reglementaire.regles.assurance.affiliation.parametres.unites.outils.impl;

import fr.pe.cali.reglementaire.dom.impl.CriteresFabriqueReglementaire;
import fr.pe.cali.reglementaire.outils.spec.IOutilCorpsRegle;
import fr.unedic.util.Unite;
import fr.unedic.util.UniteAffiliation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OutilAccesListeUniteRechargementAvantConvention2017
  extends OutilAccesListeUniteGenerique
{
  private static final String NOM_OUTIL = "OutilAccesListeUniteRechargementAvantConvention2017";
  
  public OutilAccesListeUniteRechargementAvantConvention2017()
  {
    List<Unite> listeUnitesGeneralRech = new ArrayList();
    listeUnitesGeneralRech.add(UniteAffiliation.HEURE_TRAVAIL);
    
    List<Unite> listeUnitesOPRech = new ArrayList();
    listeUnitesOPRech.add(UniteAffiliation.HEURE_TRAVAIL);
    
    List<Unite> listeUnitesAnnexe1Rech = new ArrayList();
    listeUnitesAnnexe1Rech.add(UniteAffiliation.JOUR);
    
    List<Unite> listeUnitesAnnexe2ARech = new ArrayList();
    listeUnitesAnnexe2ARech.add(UniteAffiliation.HEURE_TRAVAIL);
    
    List<Unite> listeUnitesAnnexe2BRech = new ArrayList();
    listeUnitesAnnexe2BRech.add(UniteAffiliation.EMBARQUEMENT_ADMINISTRATIF);
    
    List<Unite> listeUnitesAnnexe3Rech = new ArrayList();
    listeUnitesAnnexe3Rech.add(UniteAffiliation.VACATION);
    
    List<Unite> listeUnitesAnnexe4Rech = new ArrayList();
    listeUnitesAnnexe4Rech.add(UniteAffiliation.HEURE_TRAVAIL);
    
    List<Unite> listeUnitesAnnexe5Rech = new ArrayList();
    listeUnitesAnnexe5Rech.add(UniteAffiliation.HEURE_TRAVAIL);
    
    List<Unite> listeUnitesAnnexe6Rech = new ArrayList();
    listeUnitesAnnexe6Rech.add(UniteAffiliation.HEURE_TRAVAIL);
    
    List<Unite> listeUnitesAnnexe7Rech = new ArrayList();
    listeUnitesAnnexe7Rech.add(UniteAffiliation.HEURE_TRAVAIL);
    
    List<Unite> listeUnitesAnnexe9ARech = new ArrayList();
    listeUnitesAnnexe9ARech.add(UniteAffiliation.HEURE_TRAVAIL);
    
    List<Unite> listeUnitesAnnexe9BRech = new ArrayList();
    listeUnitesAnnexe9BRech.add(UniteAffiliation.JOUR);
    
    List<Unite> listeUnitesSpeRech = new ArrayList();
    listeUnitesSpeRech.add(UniteAffiliation.HEURE_TRAVAIL);
    
    parametres.put("RG", listeUnitesGeneralRech);
    parametres.put("RGP", listeUnitesGeneralRech);
    parametres.put("OP", listeUnitesOPRech);
    parametres.put("A1", listeUnitesAnnexe1Rech);
    parametres.put("A2a", listeUnitesAnnexe2ARech);
    parametres.put("A2b", listeUnitesAnnexe2BRech);
    parametres.put("A3", listeUnitesAnnexe3Rech);
    parametres.put("A4", listeUnitesAnnexe4Rech);
    parametres.put("A5", listeUnitesAnnexe5Rech);
    parametres.put("A6", listeUnitesAnnexe6Rech);
    parametres.put("A7", listeUnitesAnnexe7Rech);
    parametres.put("A9A", listeUnitesAnnexe9ARech);
    parametres.put("A9B", listeUnitesAnnexe9BRech);
    parametres.put("A8", listeUnitesSpeRech);
    parametres.put("A10", listeUnitesSpeRech);
  }
  
  public boolean estApplicablePourCriteres(CriteresFabriqueReglementaire criteres)
  {
    return (criteres.getListeContextesReglementaires() != null) && (criteres.getListeContextesReglementaires().contains("conditionMinimalRechargement")) && (criteres.getListeContextesFonctionnels() != null) && (criteres.getListeContextesFonctionnels().contains("rechercheReglementApplicable"));
  }
  
  public IOutilCorpsRegle creerNouvelleInstance()
  {
    return new OutilAccesListeUniteRechargementAvantConvention2017();
  }
  
  public String getNomOutil()
  {
    return "OutilAccesListeUniteRechargementAvantConvention2017";
  }
}

/* Location:
 * Qualified Name:     OutilAccesListeUniteRechargementAvantConvention2017
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */