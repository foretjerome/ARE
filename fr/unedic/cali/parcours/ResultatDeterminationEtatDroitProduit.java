package fr.unedic.cali.parcours;

import fr.unedic.cali.dom.FormuleMontantSpec;
import fr.unedic.cali.dom.MontantBaseSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.temps.Periode;

public class ResultatDeterminationEtatDroitProduit
  extends ResultatDetailleProduit
{
  private static final long serialVersionUID = 627295219026438687L;
  private MontantBaseSpec montant = null;
  private int nbJourFormation = 0;
  private int etatAttribution = 0;
  private Quantite reliquatAREAvecMaintien;
  private Quantite reliquatProlongation;
  private Quantite capitalVerse;
  private transient Periode periodePriseEnCompteEvtsReducteurs;
  private int cumulJourIndemnise = 0;
  private boolean estEnAttenteRenouvellement = false;
  private Quantite capitalADR;
  private int nombreMoisIndemnisationAssurance = 0;
  private boolean estNombreMoisIndemnisationAssuranceAlimente = false;
  private int seuilRenumerationAssurance = 0;
  private Quantite montantIndemNonDerog = null;
  private Quantite montantIndemDerog = null;
  private FormuleMontantSpec formuleMontant = null;
  private Quantite reliquatDelaiAttente = null;
  private Quantite reliquatFranchiseSalaire = null;
  private Quantite reliquatFranchiseCP = null;
  private Periode periodeApplicationDelaiAttente = null;
  
  public Quantite getCapitalADR()
  {
    return capitalADR;
  }
  
  public void setCapitalADR(Quantite capitalADR)
  {
    this.capitalADR = capitalADR;
  }
  
  public int getNombreMoisIndemnisationAssurance()
  {
    return nombreMoisIndemnisationAssurance;
  }
  
  public void setNombreMoisIndemnisationAssurance(int nombreMoisIndemnisationAssurance)
  {
    this.nombreMoisIndemnisationAssurance = nombreMoisIndemnisationAssurance;
  }
  
  public int getSeuilRenumerationAssurance()
  {
    return seuilRenumerationAssurance;
  }
  
  public void setSeuilRenumerationAssurance(int seuilRenumerationAssurance)
  {
    this.seuilRenumerationAssurance = seuilRenumerationAssurance;
  }
  
  public int getCumulJourIndemnise()
  {
    return cumulJourIndemnise;
  }
  
  public void setCumulJourIndemnise(int cumulJourIndemnise)
  {
    this.cumulJourIndemnise = cumulJourIndemnise;
  }
  
  public MontantBaseSpec getMontant()
  {
    return montant;
  }
  
  public void setMontant(MontantBaseSpec montant)
  {
    this.montant = montant;
  }
  
  public int getEtatAttribution()
  {
    return etatAttribution;
  }
  
  public void setEtatAttribution(int etatAttribution)
  {
    this.etatAttribution = etatAttribution;
  }
  
  public int getNbJourFormation()
  {
    return nbJourFormation;
  }
  
  public void setNbJourFormation(int nbJourFormation)
  {
    this.nbJourFormation = nbJourFormation;
  }
  
  public Quantite getReliquatAREAvecMaintien()
  {
    return reliquatAREAvecMaintien;
  }
  
  public void setReliquatAREAvecMaintien(Quantite reliquatAREAvecMaintien)
  {
    this.reliquatAREAvecMaintien = reliquatAREAvecMaintien;
  }
  
  public Quantite getCapitalVerse()
  {
    return capitalVerse;
  }
  
  public void setCapitalVerse(Quantite capital)
  {
    capitalVerse = capital;
  }
  
  public Periode getPeriodePriseEnCompteEvtsReducteurs()
  {
    return periodePriseEnCompteEvtsReducteurs;
  }
  
  public void setPeriodePriseEnCompteEvtsReducteurs(Periode periodePriseEnCompteEvtsReducteurs)
  {
    this.periodePriseEnCompteEvtsReducteurs = periodePriseEnCompteEvtsReducteurs;
  }
  
  public Quantite getReliquatDureeIndemnisation()
  {
    return null;
  }
  
  public int getCumulMoisActiviteReduite()
  {
    return 0;
  }
  
  public boolean isEstEnAttenteRenouvellement()
  {
    return estEnAttenteRenouvellement;
  }
  
  public void setEstEnAttenteRenouvellement(boolean estEnAttenteRenouvellement)
  {
    this.estEnAttenteRenouvellement = estEnAttenteRenouvellement;
  }
  
  public Quantite getReliquatDureeRenouvellement()
  {
    return null;
  }
  
  public boolean isEstNombreMoisIndemnisationAssuranceAlimente()
  {
    return estNombreMoisIndemnisationAssuranceAlimente;
  }
  
  public void setEstNombreMoisIndemnisationAssuranceAlimente(boolean estNombreMoisIndemnisationAssuranceAlimente)
  {
    this.estNombreMoisIndemnisationAssuranceAlimente = estNombreMoisIndemnisationAssuranceAlimente;
  }
  
  public Quantite getReliquatProlongation()
  {
    return reliquatProlongation;
  }
  
  public void setReliquatProlongation(Quantite reliquatProlongation)
  {
    this.reliquatProlongation = reliquatProlongation;
  }
  
  public Quantite getMontantIndemDerog()
  {
    return montantIndemDerog;
  }
  
  public void setMontantIndemDerog(Quantite montantIndemDerog)
  {
    this.montantIndemDerog = montantIndemDerog;
  }
  
  public Quantite getMontantIndemNonDerog()
  {
    return montantIndemNonDerog;
  }
  
  public void setMontantIndemNonDerog(Quantite montantIndemNonDerog)
  {
    this.montantIndemNonDerog = montantIndemNonDerog;
  }
  
  public FormuleMontantSpec getFormuleMontant()
  {
    return formuleMontant;
  }
  
  public void setFormuleMontant(FormuleMontantSpec formuleMontant)
  {
    this.formuleMontant = formuleMontant;
  }
  
  public Quantite getReliquatDelaiAttente()
  {
    return reliquatDelaiAttente;
  }
  
  public void setReliquatDelaiAttente(Quantite reliquatDelaiAttente)
  {
    this.reliquatDelaiAttente = reliquatDelaiAttente;
  }
  
  public Quantite getReliquatFranchiseSalaire()
  {
    return reliquatFranchiseSalaire;
  }
  
  public void setReliquatFranchiseSalaire(Quantite reliquatFranchiseSalaire)
  {
    this.reliquatFranchiseSalaire = reliquatFranchiseSalaire;
  }
  
  public Quantite getReliquatFranchiseCP()
  {
    return reliquatFranchiseCP;
  }
  
  public void setReliquatFranchiseCP(Quantite reliquatFranchiseCP)
  {
    this.reliquatFranchiseCP = reliquatFranchiseCP;
  }
  
  public Periode getPeriodeApplicationDelaiAttente()
  {
    return periodeApplicationDelaiAttente;
  }
  
  public void setPeriodeApplicationDelaiAttente(Periode periodeApplicationDelaiAttente)
  {
    this.periodeApplicationDelaiAttente = periodeApplicationDelaiAttente;
  }
}

/* Location:
 * Qualified Name:     ResultatDeterminationEtatDroitProduit
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */