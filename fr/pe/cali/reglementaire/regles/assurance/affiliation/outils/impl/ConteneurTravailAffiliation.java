package fr.pe.cali.reglementaire.regles.assurance.affiliation.outils.impl;

import fr.pe.cali.reglementaire.regles.assurance.affiliation.dom.DonneesEntreeCalculAffiliationJoursTravailles;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.dom.PeriodeAssimilee;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.dom.SemaineCivile;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.outils.spec.IOutilFonctionnelAffiliationJoursTravailles;
import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.spec.PeriodeGaecSpec;
import fr.unedic.cali.dom.affectation.ContexteDemandeSpec;
import fr.unedic.cali.dom.affectation.ProduitAsuSpec;
import fr.unedic.cali.dom.pnds.PeriodeNonDeclareeSanction;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ConteneurTravailAffiliation
{
  private Chronologie passeProfessionnel;
  private Periode periodeRecherche;
  private boolean assimilerSuspensionNonAssimilables;
  private boolean ignorerAssimiliation;
  private boolean ignorerPNDS;
  private Map<PeriodeGaecSpec, PeriodeNonDeclareeSanction> pnds;
  private Damj dateExamen;
  private Damj dateFaitGenerateur;
  private List<ContexteDemandeSpec> listeContexte;
  private IOutilFonctionnelAffiliationJoursTravailles outilFonctionnel;
  private ProduitAsuSpec produit;
  private Map<Integer, Chronologie> periodesParticipantes;
  private ActiviteSalarie activiteCourante;
  private List<Damj> listePndsCourantes;
  private Map<String, List<Damj>> joursTravaillesParActivite;
  private Map<Damj, SemaineCivile> semainesCiviles;
  private int quantiteAffiliation = 0;
  private int quantiteAssimilation = 0;
  private int plafondAssimilation = 0;
  private List<PeriodeAssimilee> periodesAssimilees;
  
  public ConteneurTravailAffiliation(DonneesEntreeCalculAffiliationJoursTravailles donneesEntreeCalculAffiliationJoursTravailles)
  {
    passeProfessionnel = donneesEntreeCalculAffiliationJoursTravailles.getPasseProfessionnel();
    periodeRecherche = donneesEntreeCalculAffiliationJoursTravailles.getPeriodeRecherche();
    assimilerSuspensionNonAssimilables = donneesEntreeCalculAffiliationJoursTravailles.isAssimilerSuspensionNonAssimilables();
    dateFaitGenerateur = donneesEntreeCalculAffiliationJoursTravailles.getDateFaitGenerateur();
    ignorerPNDS = donneesEntreeCalculAffiliationJoursTravailles.isIgnorerPNDS();
    pnds = donneesEntreeCalculAffiliationJoursTravailles.getPnds();
    joursTravaillesParActivite = new HashMap();
    semainesCiviles = new HashMap();
    dateExamen = donneesEntreeCalculAffiliationJoursTravailles.getDateExamen();
    listeContexte = donneesEntreeCalculAffiliationJoursTravailles.getListeContexte();
    outilFonctionnel = donneesEntreeCalculAffiliationJoursTravailles.getOutilFonctionnel();
    periodesAssimilees = new ArrayList();
    ignorerAssimiliation = donneesEntreeCalculAffiliationJoursTravailles.isIgnorerAssimiliation();
    produit = donneesEntreeCalculAffiliationJoursTravailles.getProduit();
  }
  
  public Chronologie getPasseProfessionnel()
  {
    return passeProfessionnel;
  }
  
  public void setPasseProfessionel(Chronologie passeProfessionnel)
  {
    this.passeProfessionnel = passeProfessionnel;
  }
  
  public Periode getPeriodeRecherche()
  {
    return periodeRecherche;
  }
  
  public void setPeriodeRecherche(Periode periodeRecherche)
  {
    this.periodeRecherche = periodeRecherche;
  }
  
  public boolean isAssimilerSuspensionNonAssimilables()
  {
    return assimilerSuspensionNonAssimilables;
  }
  
  public void setAssimilerSuspensionNonAssimilables(boolean assimilerSuspensionNonAssimilables)
  {
    this.assimilerSuspensionNonAssimilables = assimilerSuspensionNonAssimilables;
  }
  
  public boolean isIgnorerPNDS()
  {
    return ignorerPNDS;
  }
  
  public void setIgnorerPNDS(boolean ignorerPNDS)
  {
    this.ignorerPNDS = ignorerPNDS;
  }
  
  public Map<PeriodeGaecSpec, PeriodeNonDeclareeSanction> getPnds()
  {
    return pnds;
  }
  
  public void setPnds(Map<PeriodeGaecSpec, PeriodeNonDeclareeSanction> pnds)
  {
    this.pnds = pnds;
  }
  
  public Map<String, List<Damj>> getJoursTravaillesParActivite()
  {
    return joursTravaillesParActivite;
  }
  
  public void setJoursTravaillesParActivite(Map<String, List<Damj>> joursTravaillesParActivite)
  {
    this.joursTravaillesParActivite = joursTravaillesParActivite;
  }
  
  public Map<Damj, SemaineCivile> getSemainesCiviles()
  {
    return semainesCiviles;
  }
  
  public void setSemainesCiviles(Map<Damj, SemaineCivile> semainesCiviles)
  {
    this.semainesCiviles = semainesCiviles;
  }
  
  public int getQuantiteAffiliation()
  {
    return quantiteAffiliation;
  }
  
  public void setQuantiteAffiliation(int quantiteAffiliation)
  {
    this.quantiteAffiliation = quantiteAffiliation;
  }
  
  public Map<Integer, Chronologie> getPeriodesParticipantes()
  {
    return periodesParticipantes;
  }
  
  public void setPeriodesParticipantes(Map<Integer, Chronologie> periodesParticipantes)
  {
    this.periodesParticipantes = periodesParticipantes;
  }
  
  public Damj getDateExamen()
  {
    return dateExamen;
  }
  
  public void setDateExamen(Damj dateExamen)
  {
    this.dateExamen = dateExamen;
  }
  
  public List<ContexteDemandeSpec> getListeContexte()
  {
    return listeContexte;
  }
  
  public void setListeContexte(List<ContexteDemandeSpec> listeContexte)
  {
    this.listeContexte = listeContexte;
  }
  
  public ActiviteSalarie getActiviteCourante()
  {
    return activiteCourante;
  }
  
  public void setActiviteCourante(ActiviteSalarie activiteCourante)
  {
    this.activiteCourante = activiteCourante;
  }
  
  public IOutilFonctionnelAffiliationJoursTravailles getOutilFonctionnel()
  {
    return outilFonctionnel;
  }
  
  public void setOutilFonctionnel(IOutilFonctionnelAffiliationJoursTravailles outilFonctionnel)
  {
    this.outilFonctionnel = outilFonctionnel;
  }
  
  public boolean isIgnorerAssimiliation()
  {
    return ignorerAssimiliation;
  }
  
  public void setIgnorerAssimiliation(boolean ignorerAssimiliation)
  {
    this.ignorerAssimiliation = ignorerAssimiliation;
  }
  
  public int getQuantiteAssimilation()
  {
    return quantiteAssimilation;
  }
  
  public void setQuantiteAssimilation(int quantiteAssimilation)
  {
    this.quantiteAssimilation = quantiteAssimilation;
  }
  
  public int getPlafondAssimilation()
  {
    return plafondAssimilation;
  }
  
  public void setPlafondAssimilation(int plafondAssimilation)
  {
    this.plafondAssimilation = plafondAssimilation;
  }
  
  public List<PeriodeAssimilee> getPeriodesAssimilees()
  {
    return periodesAssimilees;
  }
  
  public void setPeriodesAssimilees(List<PeriodeAssimilee> periodesAssimilees)
  {
    this.periodesAssimilees = periodesAssimilees;
  }
  
  public List<Damj> getListePndsCourantes()
  {
    return listePndsCourantes;
  }
  
  public void setListePndsCourantes(List<Damj> listePndsCourantes)
  {
    this.listePndsCourantes = listePndsCourantes;
  }
  
  public Damj getDateFaitGenerateur()
  {
    return dateFaitGenerateur;
  }
  
  public void setDateFaitGenerateur(Damj dateFaitGenerateur)
  {
    this.dateFaitGenerateur = dateFaitGenerateur;
  }
  
  public ProduitAsuSpec getProduit()
  {
    return produit;
  }
  
  public void setProduit(ProduitAsuSpec produit)
  {
    this.produit = produit;
  }
}

/* Location:
 * Qualified Name:     ConteneurTravailAffiliation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */