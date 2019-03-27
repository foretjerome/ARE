package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.ArrayList;
import java.util.Collection;

public class PeriodeActiviteNonSalariePeriodique
  extends TravailNonSalarie
{
  private static final long serialVersionUID = 1494999256189003586L;
  private Collection collectionPND;
  private int motifRupture;
  private boolean etatProfessionnelGlobalPourAppletLiq;
  private Entreprise entreprise;
  private Collection collectionPeriodeAvecRevenu;
  private Collection collectionPeriodeEtatNonProfessionnel;
  private String etudeMandataire;
  private Collection<PeriodePansAvecRevenu> collectionPeriodePansAvecRevenu;
  private Collection<PeriodePansSansRevenu> collectionPeriodePansSansRevenu;
  
  public Collection<PeriodePansSansRevenu> getCollectionPeriodePansSansRevenu()
  {
    if (collectionPeriodePansSansRevenu == null) {
      collectionPeriodePansSansRevenu = new ArrayList();
    }
    return collectionPeriodePansSansRevenu;
  }
  
  public void setCollectionPeriodePansSansRevenu(Collection<PeriodePansSansRevenu> collectionPeriodePansSansRevenu)
  {
    this.collectionPeriodePansSansRevenu = collectionPeriodePansSansRevenu;
  }
  
  public Collection<PeriodePansAvecRevenu> getCollectionPeriodePansAvecRevenu()
  {
    if (collectionPeriodePansAvecRevenu == null) {
      collectionPeriodePansAvecRevenu = new ArrayList();
    }
    return collectionPeriodePansAvecRevenu;
  }
  
  public void setCollectionPeriodePansAvecRevenu(Collection<PeriodePansAvecRevenu> collectionPeriodePansAvecRevenu)
  {
    this.collectionPeriodePansAvecRevenu = collectionPeriodePansAvecRevenu;
  }
  
  private int statusDDTE = 0;
  private int activiteEntreprise = 0;
  private Damj dateValidationPans = null;
  
  public PeriodeActiviteNonSalariePeriodique()
  {
    initInstance();
  }
  
  public PeriodeActiviteNonSalariePeriodique(Damj dateDebut, Damj dateFin)
  {
    super(dateDebut, dateFin);
    initInstance();
  }
  
  public PeriodeActiviteNonSalariePeriodique(Periode periode)
  {
    super(periode);
    initInstance();
  }
  
  private void initInstance()
  {
    collectionPeriodeAvecRevenu = new ArrayList();
    collectionPND = new ArrayList();
    collectionPeriodeEtatNonProfessionnel = new ArrayList();
  }
  
  public int getMotifRupture()
  {
    return motifRupture;
  }
  
  public void setMotifRupture(int motifRupture)
  {
    this.motifRupture = motifRupture;
  }
  
  public Collection getCollectionPND()
  {
    return collectionPND;
  }
  
  public void setCollectionPND(Collection collectionPND)
  {
    this.collectionPND = collectionPND;
  }
  
  public boolean estQualifiable()
  {
    return false;
  }
  
  public boolean isEtatProfessionnelGlobalPourAppletLiq()
  {
    return etatProfessionnelGlobalPourAppletLiq;
  }
  
  public void setEtatProfessionnelGlobalPourAppletLiq(boolean etatProfessionnelGlobalPourAppletLiq)
  {
    this.etatProfessionnelGlobalPourAppletLiq = etatProfessionnelGlobalPourAppletLiq;
  }
  
  public Entreprise getEntreprise()
  {
    return entreprise;
  }
  
  public void setEntreprise(Entreprise entreprise)
  {
    this.entreprise = entreprise;
  }
  
  public int getStatusDDTE()
  {
    return statusDDTE;
  }
  
  public void setStatusDDTE(int status)
  {
    statusDDTE = status;
  }
  
  public int getActiviteEntreprise()
  {
    return activiteEntreprise;
  }
  
  public void setActiviteEntreprise(int activite)
  {
    activiteEntreprise = activite;
  }
  
  public Damj getDateValidationPANS()
  {
    return dateValidationPans;
  }
  
  public void setDateValidationPANS(Damj date)
  {
    dateValidationPans = date;
  }
  
  public Collection getCollectionPeriodeAvecRevenu()
  {
    return collectionPeriodeAvecRevenu;
  }
  
  public void setCollectionPeriodeAvecRevenu(Collection collectionPeriodeAvecRevenu)
  {
    this.collectionPeriodeAvecRevenu = collectionPeriodeAvecRevenu;
  }
  
  public void ajouterPeriodeAvecRevenu(PeriodeAvecRevenu periodeAvecRevenu)
  {
    collectionPeriodeAvecRevenu.add(periodeAvecRevenu);
  }
  
  public Collection getCollectionPeriodeEtatNonProfessionnel()
  {
    return collectionPeriodeEtatNonProfessionnel;
  }
  
  public void setCollectionPeriodeEtatNonProfessionnel(Collection collectionPeriodeEtatNonProfessionnel)
  {
    this.collectionPeriodeEtatNonProfessionnel = collectionPeriodeEtatNonProfessionnel;
  }
  
  public void ajouterPeriodeEtatNonProfessionnel(PeriodeEtatNonProfessionnel periodeEtatNonProfessionnel)
  {
    collectionPeriodeEtatNonProfessionnel.add(periodeEtatNonProfessionnel);
  }
  
  public String getEtudeMandataire()
  {
    return etudeMandataire;
  }
  
  public void setEtudeMandataire(String etudeMandataire)
  {
    this.etudeMandataire = etudeMandataire;
  }
}

/* Location:
 * Qualified Name:     PeriodeActiviteNonSalariePeriodique
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */