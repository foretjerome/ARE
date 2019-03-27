package fr.pe.cali.reglementaire.regles.assurance.affiliation.parametres.unites.outils.impl;

import fr.pe.cali.reglementaire.dom.impl.CriteresFabriqueReglementaire;
import fr.pe.cali.reglementaire.outils.spec.IOutilCorpsRegle;
import fr.unedic.util.Unite;
import fr.unedic.util.UniteAffiliation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OutilAccesListeUniteApresConvention2017ClauseSauvegarde
  extends OutilAccesListeUniteGenerique
{
  private static final String NOM_OUTIL = "OutilAccesListeUniteApresConvention2017";
  
  public OutilAccesListeUniteApresConvention2017ClauseSauvegarde()
  {
    List<Unite> listeUnitesGeneral = new ArrayList();
    listeUnitesGeneral.add(UniteAffiliation.JOUR_TRAVAILLE);
    listeUnitesGeneral.add(UniteAffiliation.HEURE_TRAVAIL);
    
    List<Unite> listeUnitesGeneralInterimaire = new ArrayList();
    listeUnitesGeneralInterimaire.add(UniteAffiliation.HEURE_TRAVAIL);
    
    List<Unite> listeUnitesOP = new ArrayList();
    listeUnitesOP.add(UniteAffiliation.JOUR_TRAVAILLE);
    listeUnitesOP.add(UniteAffiliation.HEURE_TRAVAIL);
    
    List<Unite> listeUnitesAnnexe1 = new ArrayList();
    listeUnitesAnnexe1.add(UniteAffiliation.JOUR_TRAVAILLE);
    
    List<Unite> listeUnitesAnnexe2A = new ArrayList();
    listeUnitesAnnexe2A.add(UniteAffiliation.EMBARQUEMENT_ADMINISTRATIF);
    listeUnitesAnnexe2A.add(UniteAffiliation.HEURE_TRAVAIL);
    
    List<Unite> listeUnitesAnnexe2B = new ArrayList();
    listeUnitesAnnexe2B.add(UniteAffiliation.EMBARQUEMENT_ADMINISTRATIF);
    
    List<Unite> listeUnitesAnnexe3 = new ArrayList();
    listeUnitesAnnexe3.add(UniteAffiliation.VACATION);
    
    List<Unite> listeUnitesAnnexe5 = new ArrayList();
    listeUnitesAnnexe5.add(UniteAffiliation.HEURE_TRAVAIL);
    
    List<Unite> listeUnitesAnnexe9A = new ArrayList();
    listeUnitesAnnexe9A.add(UniteAffiliation.JOUR_TRAVAILLE);
    listeUnitesAnnexe9A.add(UniteAffiliation.HEURE_TRAVAIL);
    
    List<Unite> listeUnitesAnnexe9B = new ArrayList();
    listeUnitesAnnexe9B.add(UniteAffiliation.JOUR);
    
    List<Unite> listeUnitesSpe = new ArrayList();
    listeUnitesSpe.add(UniteAffiliation.CACHET_GROUPE);
    listeUnitesSpe.add(UniteAffiliation.CACHET_ISOLE);
    listeUnitesSpe.add(UniteAffiliation.HEURE_TRAVAIL);
    
    parametres.put("RG", listeUnitesGeneral);
    parametres.put("RG5", listeUnitesGeneralInterimaire);
    parametres.put("RGP", listeUnitesGeneral);
    parametres.put("OP", listeUnitesOP);
    parametres.put("A1", listeUnitesAnnexe1);
    parametres.put("A2a", listeUnitesAnnexe2A);
    parametres.put("A2b", listeUnitesAnnexe2B);
    parametres.put("A3", listeUnitesAnnexe3);
    parametres.put("A5", listeUnitesAnnexe5);
    parametres.put("A9A", listeUnitesAnnexe9A);
    parametres.put("A9B", listeUnitesAnnexe9B);
    parametres.put("A8", listeUnitesSpe);
    parametres.put("A10", listeUnitesSpe);
  }
  
  public boolean estApplicablePourCriteres(CriteresFabriqueReglementaire criteres)
  {
    return true;
  }
  
  protected boolean estPasRechargement(List<String> contextes)
  {
    return (contextes == null) || (!contextes.contains("conditionMinimalRechargement"));
  }
  
  protected boolean estRechercheReglementApplicable(List<String> contextes)
  {
    return (contextes != null) && (contextes.contains("rechercheReglementApplicable"));
  }
  
  protected boolean estCouvertureDv(List<String> contextes)
  {
    return (contextes != null) && (contextes.contains("couvertureChomageInvolontaire"));
  }
  
  protected boolean estInopposabiliteDv(List<String> contextes)
  {
    return (contextes != null) && (contextes.contains("inopposabiliteChomageInvolontaire"));
  }
  
  public IOutilCorpsRegle creerNouvelleInstance()
  {
    return new OutilAccesListeUniteApresConvention2017ClauseSauvegarde();
  }
  
  public String getNomOutil()
  {
    return "OutilAccesListeUniteApresConvention2017";
  }
}

/* Location:
 * Qualified Name:     OutilAccesListeUniteApresConvention2017ClauseSauvegarde
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */