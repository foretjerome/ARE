package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.cali.autresdoms.ga.dom.spec.RemunerationSpec;
import fr.unedic.cali.outilsfonctionnels.DeterminationRemuneration;
import fr.unedic.cali.parametres.EvenementParametre;
import fr.unedic.cali.parametres.ParametresIndemnisation;
import fr.unedic.util.Mathematiques;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.QuantiteEuro;
import fr.unedic.util.Unite;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.builder.EqualsBuilder;

public class Salaire
  extends ObjetChronoPeriode
  implements RemunerationSpec
{
  private static final long serialVersionUID = 2899206992189106825L;
  private static final BigDecimal ZERO = BigDecimal.ZERO;
  private static final BigDecimal UN = BigDecimal.ONE;
  private static final BigDecimal HORAIRE_JOURNALIER_PAR_DEFAUT = BigDecimal.valueOf(6L);
  private PeriodeActiviteSalarie periodeActiviteSalarie;
  private Damj datePaie;
  private Damj dateConnaissanceInfo;
  private QuantiteEuro montantBrutBase;
  private QuantiteEuro montantSoumisAContribution;
  private BigDecimal tauxAbattementFraisProfessionnel;
  private Quantite quantiteAbsence;
  private BigDecimal tauxIccp;
  private Quantite montantIccp;
  private BigDecimal tauxIndemnisationPrecarite;
  private Collection<PeriodeNonDeclaree> collectionPND;
  private boolean exclus;
  private String natureAExclure;
  private BigDecimal montantBrutAutreRemuneration;
  private BigDecimal fraisProfessionnels;
  private BigDecimal nombreJoursTravailles;
  private Map<Damj, BigDecimal> repartitionJoursSurMoisCivils = new HashMap();
  
  public Salaire(Damj dateDebut, Damj dateFin)
  {
    super(dateDebut, dateFin);
    initInstance();
  }
  
  public Salaire(Periode periode)
  {
    super(periode);
    initInstance();
  }
  
  private void initInstance()
  {
    tauxAbattementFraisProfessionnel = BigDecimal.ZERO;
    fraisProfessionnels = BigDecimal.ZERO;
    tauxIccp = BigDecimal.ZERO;
    tauxIndemnisationPrecarite = BigDecimal.ZERO;
    collectionPND = new ArrayList();
  }
  
  private BigDecimal getNombreJoursAbsence()
  {
    if (estExclus()) {
      return new BigDecimal(String.valueOf(getDuree()));
    }
    if ((quantiteAbsence != null) && (quantiteAbsence.getUnite() == Unite.get("jour"))) {
      return quantiteAbsence.getValeur();
    }
    if ((quantiteAbsence != null) && (quantiteAbsence.getUnite() == Unite.get("heure")))
    {
      BigDecimal nbHeuresAbsence = quantiteAbsence.getValeur();
      
      BigDecimal nbMoisParAn = new BigDecimal("12");
      BigDecimal nbSemParAn = new BigDecimal("52");
      
      PeriodeIntensite horaires = periodeActiviteSalarie.rechercherIntensite(getPeriode());
      BigDecimal denominateur;
      BigDecimal denominateur;
      if (horaires != null)
      {
        BigDecimal horaireHebdoSalarie;
        BigDecimal horaireHebdoSalarie;
        if (horaires.getUniteHoraire() == 1)
        {
          horaireHebdoSalarie = horaires.getHorairesSalarie();
        }
        else
        {
          BigDecimal horaireHebdoSalarie;
          if (horaires.getUniteHoraire() == 2)
          {
            BigDecimal horaireAnnuelSalarie = horaires.getHorairesSalarie();
            horaireHebdoSalarie = Mathematiques.diviseParDefaut(horaireAnnuelSalarie, nbSemParAn);
          }
          else
          {
            BigDecimal horaireAnnuelSalarie = horaires.getHorairesSalarie().multiply(nbMoisParAn);
            horaireHebdoSalarie = Mathematiques.diviseParDefaut(horaireAnnuelSalarie, nbSemParAn);
          }
        }
        BigDecimal denominateur;
        if (nbHeuresAbsence.compareTo(horaireHebdoSalarie) < 0) {
          denominateur = Mathematiques.diviseParDefaut(horaireHebdoSalarie, new BigDecimal("5"));
        } else {
          denominateur = Mathematiques.diviseParDefaut(horaireHebdoSalarie, new BigDecimal("7"));
        }
      }
      else
      {
        denominateur = HORAIRE_JOURNALIER_PAR_DEFAUT;
      }
      BigDecimal nbJoursAbsence = Mathematiques.diviseASup(nbHeuresAbsence, denominateur, 2);
      
      return nbJoursAbsence;
    }
    return new BigDecimal("0");
  }
  
  public BigDecimal determinerNombreJoursAbsence(Periode periodeReference)
  {
    BigDecimal nombreJoursAbsence = getNombreJoursAbsence();
    if ((nombreJoursAbsence.compareTo(new BigDecimal("0")) > 0) && (periodeReference != null))
    {
      BigDecimal nbJoursPeriodeSalaireDansPeriodeRef = new BigDecimal(inter(periodeReference));
      BigDecimal nbJoursPeriodeSalaire = new BigDecimal(getDuree());
      nombreJoursAbsence = Mathematiques.proratiser(nombreJoursAbsence, nbJoursPeriodeSalaireDansPeriodeRef, nbJoursPeriodeSalaire);
    }
    return nombreJoursAbsence;
  }
  
  public Damj getDatePaie()
  {
    return datePaie;
  }
  
  public Damj getDateConnaissanceInfo()
  {
    return dateConnaissanceInfo;
  }
  
  public QuantiteEuro getMontantBrutBase()
  {
    return montantBrutBase;
  }
  
  public QuantiteEuro getMontantSoumisAContribution()
  {
    return montantSoumisAContribution;
  }
  
  public BigDecimal getTauxAbattementFraisProfessionnel()
  {
    return tauxAbattementFraisProfessionnel;
  }
  
  public void setDatePaie(Damj datePaie)
  {
    this.datePaie = datePaie;
  }
  
  public void setDateConnaissanceInfo(Damj dateConnaissanceInfo)
  {
    this.dateConnaissanceInfo = dateConnaissanceInfo;
  }
  
  public void setMontantBrutBase(QuantiteEuro montantBrutBase)
  {
    this.montantBrutBase = montantBrutBase;
  }
  
  public void setMontantSoumisAContribution(QuantiteEuro montantSoumisAContribution)
  {
    this.montantSoumisAContribution = montantSoumisAContribution;
  }
  
  public void setQuantiteAbsence(Quantite quantiteAbsence)
  {
    this.quantiteAbsence = quantiteAbsence;
  }
  
  public void setTauxAbattementFraisProfessionnel(BigDecimal tauxAbattementFraisProfessionnel)
  {
    this.tauxAbattementFraisProfessionnel = tauxAbattementFraisProfessionnel;
  }
  
  public String toString()
  {
    StringBuffer chaineRetour = new StringBuffer();
    chaineRetour.append(super.toString() + "\n");
    chaineRetour.append("Date Paie : " + datePaie + "\n");
    chaineRetour.append("Montant Brut de Base : " + montantBrutBase + "\n");
    chaineRetour.append("Montant Soumis à contribution : " + montantSoumisAContribution + "\n");
    chaineRetour.append("Taux Abattement Frais Professionnel : " + tauxAbattementFraisProfessionnel + "\n");
    chaineRetour.append("Nombre de jours d'absence : " + getNombreJoursAbsence() + "\n");
    chaineRetour.append("Détermination du nbre de jours d'absence --> " + determinerNombreJoursAbsence(null) + "\n");
    chaineRetour.append("Détermination de la rémunération --> " + DeterminationRemuneration.determinerRemuneration(this) + "\n");
    chaineRetour.append("Exclusion --> " + estExclus() + "\n");
    return chaineRetour.toString();
  }
  
  public Periode getPeriode()
  {
    return super.getPeriode();
  }
  
  public void setPeriodeActiviteSalarieGaec(PeriodeActiviteSalarie pas)
  {
    periodeActiviteSalarie = pas;
  }
  
  public PeriodeActiviteSalarie getPeriodeActiviteSalarieGaec()
  {
    return periodeActiviteSalarie;
  }
  
  public Quantite getMontantIccp()
  {
    return montantIccp;
  }
  
  public Quantite getQuantiteAbsence()
  {
    return quantiteAbsence;
  }
  
  public BigDecimal getTauxIccp()
  {
    return tauxIccp;
  }
  
  public BigDecimal getTauxIndemnisationPrecarite()
  {
    return tauxIndemnisationPrecarite;
  }
  
  public void setMontantIccp(Quantite quantite)
  {
    montantIccp = quantite;
  }
  
  public void setTauxIccp(BigDecimal decimal)
  {
    tauxIccp = decimal;
  }
  
  public void setTauxIndemnisationPrecarite(BigDecimal decimal)
  {
    tauxIndemnisationPrecarite = decimal;
  }
  
  private BigDecimal calculerAbattementApprentis()
  {
    BigDecimal abattementApprentis = ZERO;
    
    Damj dateDebutAnnee = new Damj(getDateFin().getAnnee(), 1, 1);
    BigDecimal valeurSmicMensuel = ParametresIndemnisation.getParametresIndemnisation().getElementActif(dateDebutAnnee).getSmicMensuelBase35h();
    if (valeurSmicMensuel != null)
    {
      abattementApprentis = valeurSmicMensuel.multiply(getTauxAbattementFraisProfessionnel());
      if ((!getDateDebut().estLeDebutDuMois()) || (!getDateFin().estLaFinDuMois()) || ((getNombreJoursAbsence() != null) && (getNombreJoursAbsence().compareTo(new BigDecimal("0")) > 0)))
      {
        BigDecimal nominateur1 = abattementApprentis;
        
        BigDecimal nominateur2 = new BigDecimal(String.valueOf(getDuree()));
        if ((getNombreJoursAbsence() != null) && (getNombreJoursAbsence().compareTo(new BigDecimal("0")) > 0)) {
          nominateur2 = ZERO.max(nominateur2.subtract(getNombreJoursAbsence()));
        }
        Periode periodeMoisCivilEntier = new Periode(getDateDebut().getDebutMois(), getDateDebut().getFinMois());
        
        BigDecimal denominateur = new BigDecimal(String.valueOf(periodeMoisCivilEntier.getDuree()));
        abattementApprentis = Mathematiques.proratiser(nominateur1, nominateur2, denominateur);
      }
    }
    return abattementApprentis;
  }
  
  public void calculerMontantSoumisContribution()
  {
    BigDecimal montantSoumisContribution = getMontantBrutBase().getValeur();
    
    montantSoumisContribution = deduireTauxAbattement(montantSoumisContribution);
    
    montantSoumisContribution = deduireTauxIccp(montantSoumisContribution);
    
    montantSoumisContribution = deduireTauxIpe(montantSoumisContribution);
    
    montantSoumisContribution = Mathematiques.arrondiASup(montantSoumisContribution, 2);
    
    setMontantSoumisAContribution(new QuantiteEuro(montantSoumisContribution));
  }
  
  public void calculerMontantSoumisContributionRaA3()
  {
    BigDecimal montantSoumisContribution = getMontantBrutBase().getValeur();
    if ((getMontantIccp() != null) && (getMontantIccp().getValeur() != null) && (getMontantIccp().getValeur().compareTo(ZERO) > 0)) {
      montantSoumisContribution = montantSoumisContribution.add(getMontantIccp().getValeur());
    }
    montantSoumisContribution = deduireTauxAbattement(montantSoumisContribution);
    
    montantSoumisContribution = deduireTauxIpe(montantSoumisContribution);
    
    montantSoumisContribution = Mathematiques.arrondiASup(montantSoumisContribution, 2);
    
    setMontantSoumisAContribution(new QuantiteEuro(montantSoumisContribution));
  }
  
  public BigDecimal determinerMontantIccp()
  {
    BigDecimal montantIccpRetourne = null;
    if ((getMontantIccp() != null) && (getMontantIccp().getValeur() != null))
    {
      montantIccpRetourne = getMontantIccp().getValeur();
    }
    else if ((getTauxIccp() != null) && (getTauxIccp().compareTo(ZERO) > 0))
    {
      BigDecimal montantBrutApresAbattement = deduireTauxAbattement(getMontantBrutBase().getValeur());
      
      BigDecimal montantBrutApresDeductionIccp = deduireTauxIccp(montantBrutApresAbattement);
      
      montantIccpRetourne = montantBrutApresAbattement.subtract(montantBrutApresDeductionIccp);
      
      montantIccpRetourne = Mathematiques.arrondiASup(montantIccpRetourne, 2);
    }
    return montantIccpRetourne;
  }
  
  private BigDecimal deduireTauxAbattement(BigDecimal montant)
  {
    BigDecimal montantRetour = montant;
    BigDecimal abattementADeduire = ZERO;
    if ((getTauxAbattementFraisProfessionnel() != null) && (getTauxAbattementFraisProfessionnel().compareTo(ZERO) > 0))
    {
      if ((periodeActiviteSalarie != null) && (periodeActiviteSalarie.estContratApprenti()))
      {
        abattementADeduire = calculerAbattementApprentis();
      }
      else
      {
        montantRetour = montantRetour.add(getFraisProfessionnels());
        
        abattementADeduire = montantRetour.multiply(getTauxAbattementFraisProfessionnel());
      }
      montantRetour = ZERO.max(montantRetour.subtract(abattementADeduire));
    }
    return montantRetour;
  }
  
  private BigDecimal deduireTauxIccp(BigDecimal montant)
  {
    BigDecimal montantRetour = montant;
    BigDecimal denominateur = ZERO;
    if ((getTauxIccp() != null) && (getTauxIccp().compareTo(ZERO) > 0))
    {
      denominateur = UN.add(getTauxIccp());
      
      montantRetour = Mathematiques.diviseParDefaut(montantRetour, denominateur);
    }
    return montantRetour;
  }
  
  private BigDecimal deduireTauxIpe(BigDecimal montant)
  {
    BigDecimal montantRetour = montant;
    BigDecimal denominateur = ZERO;
    if ((getTauxIndemnisationPrecarite() != null) && (getTauxIndemnisationPrecarite().compareTo(ZERO) > 0))
    {
      denominateur = UN.add(getTauxIndemnisationPrecarite());
      
      montantRetour = Mathematiques.diviseParDefaut(montantRetour, denominateur);
    }
    return montantRetour;
  }
  
  public Collection<PeriodeNonDeclaree> getCollectionPND()
  {
    return collectionPND;
  }
  
  public void setCollectionPND(Collection<PeriodeNonDeclaree> collectionPND)
  {
    this.collectionPND = collectionPND;
  }
  
  public ObjetMetierSpec copie()
  {
    return this;
  }
  
  public void copieElements(ObjetMetierSpec copie) {}
  
  public boolean estExclus()
  {
    return exclus;
  }
  
  public void setExclus(boolean exclus)
  {
    this.exclus = exclus;
  }
  
  public boolean estIdentiqueA(Object objet)
  {
    if (!(objet instanceof Salaire)) {
      return false;
    }
    Salaire aComparer = (Salaire)objet;
    EqualsBuilder eqb = new EqualsBuilder();
    return eqb.append(getDateDebut(), aComparer.getDateDebut()).append(getDateFin(), aComparer.getDateFin()).append(getDatePaie(), aComparer.getDatePaie()).append(getMontantBrutBase(), aComparer.getMontantBrutBase()).append(getTauxAbattementFraisProfessionnel(), aComparer.getTauxAbattementFraisProfessionnel()).append(getTauxIccp(), aComparer.getTauxIccp()).append(getTauxIndemnisationPrecarite(), aComparer.getTauxIndemnisationPrecarite()).append(getQuantiteAbsence(), aComparer.getQuantiteAbsence()).append(getMontantIccp(), aComparer.getMontantIccp()).append(estExclus(), aComparer.estExclus()).isEquals();
  }
  
  public BigDecimal getMontantBrutAutreRemuneration()
  {
    return montantBrutAutreRemuneration;
  }
  
  public void setMontantBrutAutreRemuneration(BigDecimal montantBrutAutreRemuneration)
  {
    this.montantBrutAutreRemuneration = montantBrutAutreRemuneration;
  }
  
  public BigDecimal getFraisProfessionnels()
  {
    return fraisProfessionnels;
  }
  
  public void setFraisProfessionnels(BigDecimal fraisProfessionnels)
  {
    this.fraisProfessionnels = fraisProfessionnels;
  }
  
  public BigDecimal getNombreJoursTravailles()
  {
    return nombreJoursTravailles;
  }
  
  public void setNombreJoursTravailles(BigDecimal nombreJoursTravailles)
  {
    this.nombreJoursTravailles = nombreJoursTravailles;
  }
  
  public void setRepartitionJoursSurMoisCivils(Map<Damj, BigDecimal> repartitionJoursSurMoisCivils)
  {
    this.repartitionJoursSurMoisCivils = repartitionJoursSurMoisCivils;
  }
  
  public Map<Damj, BigDecimal> getRepartitionJoursSurMoisCivils()
  {
    return repartitionJoursSurMoisCivils;
  }
  
  public String getNatureAExclure()
  {
    return natureAExclure;
  }
  
  public void setNatureAExclure(String natureAExclure)
  {
    this.natureAExclure = natureAExclure;
  }
}

/* Location:
 * Qualified Name:     Salaire
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */