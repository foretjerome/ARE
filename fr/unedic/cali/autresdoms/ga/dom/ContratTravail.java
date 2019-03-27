package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

public class ContratTravail
{
  private int pays;
  private Preavis preavis;
  private Damj dernierJourTravaillePaye;
  private int statutParticulier;
  private int nature;
  private int niveauQualification;
  private int codeMotifFin;
  private int contexteDemission;
  private boolean transactionEnCours;
  private boolean transactionEffective;
  private Damj dateInitialeFCD;
  private Damj dateRuptureContratTravail;
  private int pohf;
  private boolean derogationPlafondMensuel;
  private Damj dateEngagementProcedureLicenciement;
  private boolean lienParenteAvecChefEntreprise;
  private int nbreJoursCongesPris;
  private boolean licenceAEM;
  private boolean labelAEM;
  private boolean ccsAEM;
  private boolean organisateurOccasionnelSpectacle;
  private boolean estDernierContratCaliCreePourDecoupage;
  private int investigationFrauduleuse;
  private String codeAffectation;
  private String numeroConventionGestion;
  private String idExterneEmployeurPublic;
  private BigDecimal refusFne;
  private boolean estSuspensionChomageSansRCT;
  private boolean estSuspensionDecoupee;
  private Collection<String> contextesDecoupage = null;
  private BigDecimal ancienneteCSP;
  private String etudeMandataire;
  private String ressortissant;
  private String idccEmployeur;
  private String idccPrestataire;
  
  public ContratTravail()
  {
    estDernierContratCaliCreePourDecoupage = false;
    estSuspensionChomageSansRCT = false;
    investigationFrauduleuse = 0;
  }
  
  public Damj getDernierJourTravaillePaye()
  {
    return dernierJourTravaillePaye;
  }
  
  public void setDernierJourTravaillePaye(Damj dernierJourTravaillePaye)
  {
    this.dernierJourTravaillePaye = dernierJourTravaillePaye;
  }
  
  public int getNature()
  {
    return nature;
  }
  
  public void setNature(int nature)
  {
    this.nature = nature;
  }
  
  public int getStatutParticulier()
  {
    return statutParticulier;
  }
  
  public void setStatutParticulier(int statutParticulier)
  {
    this.statutParticulier = statutParticulier;
  }
  
  public Preavis getPreavis()
  {
    return preavis;
  }
  
  public void setPreavis(Preavis preavis)
  {
    this.preavis = preavis;
  }
  
  public int getNiveauQualification()
  {
    return niveauQualification;
  }
  
  public void setNiveauQualification(int niveauQualification)
  {
    this.niveauQualification = niveauQualification;
  }
  
  public int getCodeMotifFin()
  {
    return codeMotifFin;
  }
  
  public void setCodeMotifFin(int codeMotifFin)
  {
    this.codeMotifFin = codeMotifFin;
  }
  
  public boolean isLicenciementEconomique()
  {
    return getCodeMotifFin() == 1;
  }
  
  public int getPays()
  {
    return pays;
  }
  
  public void setPays(int pays)
  {
    this.pays = pays;
  }
  
  public boolean isTransactionEnCours()
  {
    return transactionEnCours;
  }
  
  public void setTransactionEffective(boolean transactionEffective)
  {
    this.transactionEffective = transactionEffective;
  }
  
  public boolean isTransactionEffective()
  {
    return transactionEffective;
  }
  
  public void setTransactionEnCours(boolean transactionEnCours)
  {
    this.transactionEnCours = transactionEnCours;
  }
  
  public Damj getDateInitialeFCD()
  {
    return dateInitialeFCD;
  }
  
  public void setDateInitialeFCD(Damj dateInitialeFCD)
  {
    this.dateInitialeFCD = dateInitialeFCD;
  }
  
  public Damj getDateRuptureContratTravail()
  {
    return dateRuptureContratTravail;
  }
  
  public void setDateRuptureContratTravail(Damj dateRuptureContratTravail)
  {
    this.dateRuptureContratTravail = dateRuptureContratTravail;
  }
  
  public boolean getLicenceAEM()
  {
    return licenceAEM;
  }
  
  public boolean getLabelAEM()
  {
    return labelAEM;
  }
  
  public boolean getCCSAEM()
  {
    return ccsAEM;
  }
  
  public void setLabelAEM(boolean lab)
  {
    labelAEM = lab;
  }
  
  public void setCCSAEM(boolean ccs)
  {
    ccsAEM = ccs;
  }
  
  public void setLicenceAEM(boolean lic)
  {
    licenceAEM = lic;
  }
  
  public int getPohf()
  {
    return pohf;
  }
  
  public void setPohf(int pohf)
  {
    this.pohf = pohf;
  }
  
  public boolean isDerogationPlafondMensuel()
  {
    return derogationPlafondMensuel;
  }
  
  public void setDerogationPlafondMensuel(boolean derogationPlafondMensuel)
  {
    this.derogationPlafondMensuel = derogationPlafondMensuel;
  }
  
  public int getContexteDemission()
  {
    return contexteDemission;
  }
  
  public void setContexteDemission(int contexte)
  {
    contexteDemission = contexte;
  }
  
  public void setDateEngagementProcedureLicenciement(Damj date)
  {
    dateEngagementProcedureLicenciement = date;
  }
  
  public Damj getDateEngagementProcedureLicenciement()
  {
    return dateEngagementProcedureLicenciement;
  }
  
  public boolean estLienParenteAvecChefEntreprise()
  {
    return lienParenteAvecChefEntreprise;
  }
  
  public void setLienParenteAvecChefEntreprise(boolean lienParenteAvecChefEntreprise)
  {
    this.lienParenteAvecChefEntreprise = lienParenteAvecChefEntreprise;
  }
  
  public String getNumeroConventionGestion()
  {
    return numeroConventionGestion;
  }
  
  public void setNumeroConventionGestion(String numeroConventionGestion)
  {
    this.numeroConventionGestion = numeroConventionGestion;
  }
  
  public BigDecimal getRefusFne()
  {
    return refusFne;
  }
  
  public void setRefusFne(BigDecimal refusFne)
  {
    this.refusFne = refusFne;
  }
  
  public boolean isOrganisateurOccasionnelSpectacle()
  {
    return organisateurOccasionnelSpectacle;
  }
  
  public void setOrganisateurOccasionnelSpectacle(boolean organisateurOccasionnelSpectacle)
  {
    this.organisateurOccasionnelSpectacle = organisateurOccasionnelSpectacle;
  }
  
  public int getNbreJoursCongesPris()
  {
    return nbreJoursCongesPris;
  }
  
  public void setNbreJoursCongesPris(int nbreJoursCongesPris)
  {
    this.nbreJoursCongesPris = nbreJoursCongesPris;
  }
  
  public boolean estDernierContratCaliCreePourDecoupage()
  {
    return estDernierContratCaliCreePourDecoupage;
  }
  
  public void setEstDernierContratCaliCreePourDecoupage(boolean estDernierContratCaliCreePourDecoupage)
  {
    this.estDernierContratCaliCreePourDecoupage = estDernierContratCaliCreePourDecoupage;
  }
  
  public int getInvestigationFrauduleuse()
  {
    return investigationFrauduleuse;
  }
  
  public void setInvestigationFrauduleuse(int investigationFrauduleuse)
  {
    this.investigationFrauduleuse = investigationFrauduleuse;
  }
  
  public String getCodeAffectation()
  {
    return codeAffectation;
  }
  
  public void setCodeAffectation(String codeAffectation)
  {
    this.codeAffectation = codeAffectation;
  }
  
  public String getIdExterneEmployeurPublic()
  {
    return idExterneEmployeurPublic;
  }
  
  public void setIdExterneEmployeurPublic(String idExterneEmployeurPublic)
  {
    this.idExterneEmployeurPublic = idExterneEmployeurPublic;
  }
  
  public boolean estSuspensionChomageSansRCT()
  {
    return (estEnContexteDecoupage("CSR")) && (estSuspensionDecoupee);
  }
  
  public void setEstSuspensionChomageSansRCT(boolean estSuspensionChomageSansRCT)
  {
    this.estSuspensionChomageSansRCT = estSuspensionChomageSansRCT;
  }
  
  public boolean estSuspensionDecoupee()
  {
    return estSuspensionDecoupee;
  }
  
  public void setEstSuspensionDecoupee(boolean estSuspensionDecoupee)
  {
    this.estSuspensionDecoupee = estSuspensionDecoupee;
  }
  
  public void setContextesDecoupage(Collection<String> contextesDecoupage)
  {
    this.contextesDecoupage = contextesDecoupage;
  }
  
  public void ajouterContexteDecoupage(String contexteDecoupage)
  {
    if (contextesDecoupage == null) {
      contextesDecoupage = new ArrayList();
    }
    contextesDecoupage.add(contexteDecoupage);
  }
  
  public Collection<String> getContextesDecoupage()
  {
    return contextesDecoupage;
  }
  
  public boolean estEnContexteDecoupage(String contexte)
  {
    boolean retour = false;
    if (contextesDecoupage != null) {
      retour = contextesDecoupage.contains(contexte);
    }
    return retour;
  }
  
  public BigDecimal getAncienneteCSP()
  {
    return ancienneteCSP;
  }
  
  public void setAncienneteCSP(BigDecimal ancienneteCSP)
  {
    this.ancienneteCSP = ancienneteCSP;
  }
  
  public String getEtudeMandataire()
  {
    return etudeMandataire;
  }
  
  public void setEtudeMandataire(String etudeMandataire)
  {
    this.etudeMandataire = etudeMandataire;
  }
  
  public String getRessortissant()
  {
    return ressortissant;
  }
  
  public void setRessortissant(String ressortissant)
  {
    this.ressortissant = ressortissant;
  }
  
  public String getIdccEmployeur()
  {
    return idccEmployeur;
  }
  
  public void setIdccEmployeur(String idccEmployeur)
  {
    this.idccEmployeur = idccEmployeur;
  }
  
  public String getIdccPrestataire()
  {
    return idccPrestataire;
  }
  
  public void setIdccPrestataire(String idccPrestataire)
  {
    this.idccPrestataire = idccPrestataire;
  }
}

/* Location:
 * Qualified Name:     ContratTravail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */