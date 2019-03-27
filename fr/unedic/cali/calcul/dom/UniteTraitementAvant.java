package fr.unedic.cali.calcul.dom;

import fr.unedic.cali.calcul.dom.gen.UniteTraitementAvantGen;
import fr.unedic.cali.dom.ObjetPersistantSpec;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.Unite;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class UniteTraitementAvant
  extends UniteTraitementAvantGen
  implements ObjetPersistantSpec
{
  private static final long serialVersionUID = 1L;
  private transient DureeConsommableAvant m_dureePmcEnDebutUT;
  private transient DureeConsommableAvant m_dureePmcEnFinUT;
  private transient DureeConsommableAvant m_dureeDiffereStandardEnDebutUT;
  private transient DureeConsommableAvant m_dureeDiffereStandardEnFinUT;
  private transient DureeConsommableAvant m_dureeDiffereSpecifiqueEnDebutUT;
  private transient DureeConsommableAvant m_dureeDiffereSpecifiqueEnFinUT;
  private transient DureeConsommableAvant m_dureeDelaiAttenteEnDebutUT;
  private transient DureeConsommableAvant m_dureeDelaiAttenteEnFinUT;
  private transient DureeConsommableAvant m_dureePreavisLegalEnDebutUT;
  private transient DureeConsommableAvant m_dureePreavisLegalEnFinUT;
  private transient DureeConsommableAvant dureeFranchiseCPEnDebutUT;
  private transient DureeConsommableAvant dureeFranchiseCPEnFinUT;
  private transient DureeConsommableAvant dureeFranchiseSalaireEnDebutUT;
  private transient DureeConsommableAvant dureeFranchiseSalaireEnFinUT;
  private transient Quantite m_pmcConsomme;
  private transient Quantite m_differeStandardConsomme;
  private transient Quantite m_differeSpecifiqueConsomme;
  private transient Quantite m_delaiAttenteConsomme;
  private transient Quantite m_preavisLegalConsomme;
  private transient Quantite franchiseCPConsomme;
  private transient Quantite franchiseSalaireConsomme;
  private transient Unite m_uniteParDefautQuantites;
  private transient Collection m_collectionFinQuantiteDroit = null;
  private transient ArretProduitAvecRaison m_arretProduitAvecRaison = null;
  private transient boolean m_produitATerminerApresUT = false;
  private transient QualificationPeriodes m_qualificationPeriodes = null;
  private transient ConsommationPeriodes m_consommationPeriodes = null;
  private transient Quantite m_quantiteDecale = null;
  private transient int statut;
  private transient Damj dateDebutConsoDATheorique = null;
  private transient boolean traitementArEffectue;
  private transient Damj debutPeriodePECEvenementReducteurs;
  
  public UniteTraitementAvant(DomPCSpec pc)
  {
    super(pc);
  }
  
  public UniteTraitementAvant(Unite uniteParDefautQuantites, Periode periode)
  {
    super(periode);
    setUniteParDefautQuantites(uniteParDefautQuantites);
  }
  
  public DureeConsommableAvant getDureePmcEnDebutUT()
  {
    return m_dureePmcEnDebutUT;
  }
  
  public void setDureePmcEnDebutUT(DureeConsommableAvant dureePmcEnDebutUT)
  {
    m_dureePmcEnDebutUT = dureePmcEnDebutUT;
  }
  
  public DureeConsommableAvant getDureePmcEnFinUT()
  {
    return m_dureePmcEnFinUT;
  }
  
  public void setDureePmcEnFinUT(DureeConsommableAvant dureePmcEnFinUT)
  {
    m_dureePmcEnFinUT = dureePmcEnFinUT;
  }
  
  public Quantite getPmcConsomme()
  {
    return m_pmcConsomme;
  }
  
  public void setPmcConsomme(Quantite pmcConsomme)
  {
    m_pmcConsomme = pmcConsomme;
  }
  
  public DureeConsommableAvant getDureeDelaiAttenteEnDebutUT()
  {
    return m_dureeDelaiAttenteEnDebutUT;
  }
  
  public void setDureeDelaiAttenteEnDebutUT(DureeConsommableAvant dureeDelaiAttenteEnDebutUT)
  {
    m_dureeDelaiAttenteEnDebutUT = dureeDelaiAttenteEnDebutUT;
  }
  
  public DureeConsommableAvant getDureeDelaiAttenteEnFinUT()
  {
    return m_dureeDelaiAttenteEnFinUT;
  }
  
  public void setDureeDelaiAttenteEnFinUT(DureeConsommableAvant dureeDelaiAttenteEnFinUT)
  {
    m_dureeDelaiAttenteEnFinUT = dureeDelaiAttenteEnFinUT;
  }
  
  public DureeConsommableAvant getDureeDiffereSpecifiqueEnDebutUT()
  {
    return m_dureeDiffereSpecifiqueEnDebutUT;
  }
  
  public void setDureeDiffereSpecifiqueEnDebutUT(DureeConsommableAvant dureeDiffereSpecifiqueEnDebutUT)
  {
    m_dureeDiffereSpecifiqueEnDebutUT = dureeDiffereSpecifiqueEnDebutUT;
  }
  
  public DureeConsommableAvant getDureeDiffereSpecifiqueEnFinUT()
  {
    return m_dureeDiffereSpecifiqueEnFinUT;
  }
  
  public void setDureeDiffereSpecifiqueEnFinUT(DureeConsommableAvant dureeDiffereSpecifiqueEnFinUT)
  {
    m_dureeDiffereSpecifiqueEnFinUT = dureeDiffereSpecifiqueEnFinUT;
  }
  
  public DureeConsommableAvant getDureeDiffereStandardEnDebutUT()
  {
    return m_dureeDiffereStandardEnDebutUT;
  }
  
  public void setDureeDiffereStandardEnDebutUT(DureeConsommableAvant dureeDiffereStandardEnDebutUT)
  {
    m_dureeDiffereStandardEnDebutUT = dureeDiffereStandardEnDebutUT;
  }
  
  public DureeConsommableAvant getDureeDiffereStandardEnFinUT()
  {
    return m_dureeDiffereStandardEnFinUT;
  }
  
  public void setDureeDiffereStandardEnFinUT(DureeConsommableAvant dureeDiffereStandardEnFinUT)
  {
    m_dureeDiffereStandardEnFinUT = dureeDiffereStandardEnFinUT;
  }
  
  public DureeConsommableAvant getDureeFranchiseCPEnDebutUT()
  {
    return dureeFranchiseCPEnDebutUT;
  }
  
  public void setDureeFranchiseCPEnDebutUT(DureeConsommableAvant dureeFranchiseCPEnDebutUT)
  {
    this.dureeFranchiseCPEnDebutUT = dureeFranchiseCPEnDebutUT;
  }
  
  public DureeConsommableAvant getDureeFranchiseCPEnFinUT()
  {
    return dureeFranchiseCPEnFinUT;
  }
  
  public void setDureeFranchiseCPEnFinUT(DureeConsommableAvant dureeFranchiseCPEnFinUT)
  {
    this.dureeFranchiseCPEnFinUT = dureeFranchiseCPEnFinUT;
  }
  
  public DureeConsommableAvant getDureeFranchiseSalaireEnDebutUT()
  {
    return dureeFranchiseSalaireEnDebutUT;
  }
  
  public void setDureeFranchiseSalaireEnDebutUT(DureeConsommableAvant dureeFranchiseSalaireEnDebutUT)
  {
    this.dureeFranchiseSalaireEnDebutUT = dureeFranchiseSalaireEnDebutUT;
  }
  
  public DureeConsommableAvant getDureeFranchiseSalaireEnFinUT()
  {
    return dureeFranchiseSalaireEnFinUT;
  }
  
  public void setDureeFranchiseSalaireEnFinUT(DureeConsommableAvant dureeFranchiseSalaireEnFinUT)
  {
    this.dureeFranchiseSalaireEnFinUT = dureeFranchiseSalaireEnFinUT;
  }
  
  public Quantite getFranchiseCPConsomme()
  {
    return franchiseCPConsomme;
  }
  
  public void setFranchiseCPConsomme(Quantite franchiseCPConsomme)
  {
    this.franchiseCPConsomme = franchiseCPConsomme;
  }
  
  public Quantite getFranchiseSalaireConsomme()
  {
    return franchiseSalaireConsomme;
  }
  
  public void setFranchiseSalaireConsomme(Quantite franchiseSalaireConsomme)
  {
    this.franchiseSalaireConsomme = franchiseSalaireConsomme;
  }
  
  public DureeConsommableAvant getDureeConsommableAvantActiveEnDebutUt()
  {
    if ((getDureePmcEnDebutUT() != null) && (getDureePmcEnDebutUT().getEtat() == 1)) {
      return getDureePmcEnDebutUT();
    }
    if ((getDureePreavisLegalEnDebutUT() != null) && (getDureePreavisLegalEnDebutUT().getEtat() == 1)) {
      return getDureePreavisLegalEnDebutUT();
    }
    if ((getDureeDiffereStandardEnDebutUT() != null) && (getDureeDiffereStandardEnDebutUT().getEtat() == 1)) {
      return getDureeDiffereStandardEnDebutUT();
    }
    if ((getDureeDiffereSpecifiqueEnDebutUT() != null) && (getDureeDiffereSpecifiqueEnDebutUT().getEtat() == 1)) {
      return getDureeDiffereSpecifiqueEnDebutUT();
    }
    if ((getDureeDelaiAttenteEnDebutUT() != null) && (getDureeDelaiAttenteEnDebutUT().getEtat() == 1)) {
      return getDureeDelaiAttenteEnDebutUT();
    }
    if ((getDureeFranchiseCPEnDebutUT() != null) && (getDureeFranchiseCPEnDebutUT().getEtat() == 1)) {
      return getDureeFranchiseCPEnDebutUT();
    }
    if ((getDureeFranchiseSalaireEnDebutUT() != null) && (getDureeFranchiseSalaireEnDebutUT().getEtat() == 1)) {
      return getDureeFranchiseSalaireEnDebutUT();
    }
    return null;
  }
  
  public DureeConsommableAvant getDureeConsommableAvantActiveEnFinUt()
  {
    if ((getDureePmcEnFinUT() != null) && (getDureePmcEnFinUT().getEtat() == 1)) {
      return getDureePmcEnFinUT();
    }
    if ((getDureePreavisLegalEnFinUT() != null) && (getDureePreavisLegalEnFinUT().getEtat() == 1)) {
      return getDureePreavisLegalEnFinUT();
    }
    if ((getDureeDiffereStandardEnFinUT() != null) && (getDureeDiffereStandardEnFinUT().getEtat() == 1)) {
      return getDureeDiffereStandardEnFinUT();
    }
    if ((getDureeDiffereSpecifiqueEnFinUT() != null) && (getDureeDiffereSpecifiqueEnFinUT().getEtat() == 1)) {
      return getDureeDiffereSpecifiqueEnFinUT();
    }
    if ((getDureeDelaiAttenteEnFinUT() != null) && (getDureeDelaiAttenteEnFinUT().getEtat() == 1)) {
      return getDureeDelaiAttenteEnFinUT();
    }
    if ((getDureeFranchiseCPEnFinUT() != null) && (getDureeFranchiseCPEnFinUT().getEtat() == 1)) {
      return getDureeFranchiseCPEnFinUT();
    }
    if ((getDureeFranchiseSalaireEnFinUT() != null) && (getDureeFranchiseSalaireEnFinUT().getEtat() == 1)) {
      return getDureeFranchiseSalaireEnFinUT();
    }
    return null;
  }
  
  public Unite getUniteParDefautQuantites()
  {
    return m_uniteParDefautQuantites;
  }
  
  public void setUniteParDefautQuantites(Unite unite)
  {
    m_uniteParDefautQuantites = unite;
  }
  
  public Collection getCollectionFinQuantiteDroit()
  {
    if (m_collectionFinQuantiteDroit == null) {
      m_collectionFinQuantiteDroit = new ArrayList();
    }
    return m_collectionFinQuantiteDroit;
  }
  
  public void ajouterEvenementFinQuantiteDroit(EvenementFinQuantiteDroit ev)
  {
    getCollectionFinQuantiteDroit().add(ev);
  }
  
  public void ajouterEvenementsFinQuantiteDroit(Collection collectionEvFinQ)
  {
    for (Iterator it = collectionEvFinQ.iterator(); it.hasNext();) {
      ajouterEvenementFinQuantiteDroit((EvenementFinQuantiteDroit)it.next());
    }
  }
  
  public void supprimerEvenement(EvenementFinQuantiteDroit ev)
  {
    getCollectionFinQuantiteDroit().remove(ev);
  }
  
  public ArretProduitAvecRaison getArretProduitAvecRaison()
  {
    return m_arretProduitAvecRaison;
  }
  
  public void setArretProduitAvecRaison(ArretProduitAvecRaison arretProduitAvecRaison)
  {
    m_arretProduitAvecRaison = arretProduitAvecRaison;
  }
  
  public Quantite getDelaiAttenteConsomme()
  {
    return m_delaiAttenteConsomme;
  }
  
  public void setDelaiAttenteConsomme(Quantite delaiAttenteConsomme)
  {
    m_delaiAttenteConsomme = delaiAttenteConsomme;
  }
  
  public Quantite getDiffereSpecifiqueConsomme()
  {
    return m_differeSpecifiqueConsomme;
  }
  
  public void setDiffereSpecifiqueConsomme(Quantite differeSpecifiqueConsomme)
  {
    m_differeSpecifiqueConsomme = differeSpecifiqueConsomme;
  }
  
  public Quantite getDiffereStandardConsomme()
  {
    return m_differeStandardConsomme;
  }
  
  public void setDiffereStandardConsomme(Quantite differeStandardConsomme)
  {
    m_differeStandardConsomme = differeStandardConsomme;
  }
  
  public boolean isProduitATerminerApresUT()
  {
    return m_produitATerminerApresUT;
  }
  
  public void setProduitATerminerApresUT(boolean produitATerminerApresUT)
  {
    m_produitATerminerApresUT = produitATerminerApresUT;
  }
  
  public QualificationPeriodes getQualificationPeriodes()
  {
    return m_qualificationPeriodes;
  }
  
  public void setQualificationPeriodes(QualificationPeriodes periodes)
  {
    m_qualificationPeriodes = periodes;
  }
  
  public ConsommationPeriodes getConsommationPeriodes()
  {
    return m_consommationPeriodes;
  }
  
  public void setConsommationPeriodes(ConsommationPeriodes periodes)
  {
    m_consommationPeriodes = periodes;
  }
  
  public ObjetMetierSpec copie()
  {
    return null;
  }
  
  public Quantite getPreavisLegalConsomme()
  {
    return m_preavisLegalConsomme;
  }
  
  public void setPreavisLegalConsomme(Quantite preavisLegalConsomme)
  {
    m_preavisLegalConsomme = preavisLegalConsomme;
  }
  
  public DureeConsommableAvant getDureePreavisLegalEnDebutUT()
  {
    return m_dureePreavisLegalEnDebutUT;
  }
  
  public void setDureePreavisLegalEnDebutUT(DureeConsommableAvant dureePreavisLegalEnDebutUT)
  {
    m_dureePreavisLegalEnDebutUT = dureePreavisLegalEnDebutUT;
  }
  
  public DureeConsommableAvant getDureePreavisLegalEnFinUT()
  {
    return m_dureePreavisLegalEnFinUT;
  }
  
  public void setDureePreavisLegalEnFinUT(DureeConsommableAvant dureePreavisLegalEnFinUT)
  {
    m_dureePreavisLegalEnFinUT = dureePreavisLegalEnFinUT;
  }
  
  public String getIdentifiant()
  {
    return DomManager.getIdentifiant(this);
  }
  
  public void marquerGraphePersistant() {}
  
  public Quantite getQuantiteDecale()
  {
    return m_quantiteDecale;
  }
  
  public void setQuantiteDecale(Quantite quantiteDecale)
  {
    m_quantiteDecale = quantiteDecale;
  }
  
  public Damj getDateDebutConsoDATheorique()
  {
    return dateDebutConsoDATheorique;
  }
  
  public void setDateDebutConsoDATheorique(Damj dateDebutConsoDATheorique)
  {
    this.dateDebutConsoDATheorique = dateDebutConsoDATheorique;
  }
  
  public boolean isTraitementArEffectue()
  {
    return traitementArEffectue;
  }
  
  public void setTraitementArEffectue(boolean traitementArEffectue)
  {
    this.traitementArEffectue = traitementArEffectue;
  }
  
  public void setDebutPeriodePECEvenementReducteurs(Damj debutPeriodePECEvenementReducteurs)
  {
    this.debutPeriodePECEvenementReducteurs = debutPeriodePECEvenementReducteurs;
  }
  
  public Damj getDebutPeriodePECEvenementReducteurs()
  {
    return debutPeriodePECEvenementReducteurs;
  }
  
  public int getStatut()
  {
    return statut;
  }
  
  public void setStatut(int statut)
  {
    this.statut = statut;
  }
}

/* Location:
 * Qualified Name:     UniteTraitementAvant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */