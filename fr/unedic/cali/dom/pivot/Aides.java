package fr.unedic.cali.dom.pivot;

import fr.unedic.cali.autresdoms.d90.dom.spec.ElementBasePivotEchangeComparableSpec;
import fr.unedic.cali.autresdoms.d90.outilsfonctionnels.OutilComparaison;
import fr.unedic.cali.dom.ObjetPersistantSpec;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.cali.dom.pivot.gen.AidesGen;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import xcalia.lido.api.LiDOHelper;

public class Aides
  extends AidesGen
  implements ObjetPersistantSpec, ElementBasePivotEchangeComparableSpec
{
  private static final long serialVersionUID = -8882212237259886115L;
  public static final String ETAT_ENREGISTRE = "E";
  public static final String ETAT_VALIDE_ASSEDIC = "V";
  public static final String ETAT_VALIDE_ANPE = "N";
  public static final String ETAT_ANNULE = "A";
  public static final String ETAT_BLOQUE = "V";
  public static final String ETAT_REJETE = "R";
  public static final String ETAT_PAYE = "P";
  public static final String ETAT_SOLDE = "S";
  public static final String ETAT_CERTIFIE = "C";
  public static final String BENEF_INDIVIDU = "I";
  public static final String BENEF_OF = "O";
  public static final String TYPE_FRAIS_HT = "HT";
  public static final String PLAFOND_MAJORE_OUI = "O";
  public static final String PLAFOND_MAJORE_NON = "N";
  protected transient Date tspElementPourEcartsBase = null;
  
  public Aides() {}
  
  public Aides(DomPCSpec pc)
  {
    super(pc);
  }
  
  public String getIdentifiant()
  {
    return DomManager.getIdentifiant(this);
  }
  
  public ObjetMetierSpec copie()
  {
    Aides copieAides = new Aides();
    copieElements(copieAides);
    return copieAides;
  }
  
  public void copieElements(ObjetMetierSpec pcopie)
  {
    Aides copieAides = (Aides)pcopie;
    copieAides.setAnneeAffectation(getAnneeAffectation());
    copieAides.setBeneficiaireAideFraisP(getBeneficiaireAideFraisP());
    copieAides.setDateValidationANPE(getDateValidationANPE());
    copieAides.setDateValidationAssedic(getDateValidationAssedic());
    copieAides.setEtat(getEtat());
    copieAides.setIdentifiantActionFormation(getIdentifiantActionFormation());
    copieAides.setMontantCoutStageFraisP(getMontantCoutStageFraisP());
    copieAides.setMontantFraisRestantStagiaireFraisP(getMontantFraisRestantStagiaireFraisP());
    copieAides.setMontantFraisRestantStagiaireNonPlafonneFraisP(getMontantFraisRestantStagiaireNonPlafonneFraisP());
    copieAides.setMontantTotalEngageFraisH(getMontantTotalEngageFraisH());
    copieAides.setMontantTotalEngageFraisP(getMontantTotalEngageFraisP());
    copieAides.setMontantTotalEngageFraisR(getMontantTotalEngageFraisR());
    copieAides.setMontantTotalEngageFraisT(getMontantTotalEngageFraisT());
    copieAides.setMontantTotalPaye(getMontantTotalPaye());
    copieAides.setIdentifiantConvention(getIdentifiantConvention());
    copieAides.setTypeAide(getTypeAide());
    copieAides.setEtatDemande(getEtatDemande());
    copieAides.setTypeActionReclassement(getTypeActionReclassement());
    copieAides.setMontantAideDerogatoire(getMontantAideDerogatoire());
    copieAides.setMontantBonTransport(getMontantBonTransport());
    copieAides.setDateLimiteIndemnisation(getDateLimiteIndemnisation());
    copieAides.setPlafondDerogatoireAvantAide(getPlafondDerogatoireAvantAide());
    copieAides.setPlafondAvantAide(getPlafondAvantAide());
    copieAides.setSituationMobilite(getSituationMobilite());
    copieAides.setDateDebutActionReclassement(getDateDebutActionReclassement());
    copieAides.setTypeDerogation(getTypeDerogation());
    copieAides.setDateFinActionReclassement(getDateFinActionReclassement());
    copieAides.setCodeProduit(getCodeProduit());
    copieAides.setMotifEchec(getMotifEchec());
    copieAides.setReferenceExterne(getReferenceExterne());
    
    copieAides.clearCollectionPeriodeLieu();
    Iterator<?> iter = getCollectionPeriodeLieu().iterator();
    while (iter.hasNext())
    {
      PeriodeLieu pl = (PeriodeLieu)iter.next();
      PeriodeLieu copiePl = (PeriodeLieu)pl.copie();
      copieAides.ajouterPeriodeLieu(copiePl);
    }
    copieAides.clearCollectionDerogation();
    Iterator<?> iterDerog = getCollectionDerogation().iterator();
    while (iterDerog.hasNext())
    {
      Derogation derogation = (Derogation)iterDerog.next();
      Derogation copieDerogation = (Derogation)derogation.copie();
      copieAides.ajouterDerogation(copieDerogation);
    }
    if (getTspElementPourEcartsBases() != null)
    {
      copieAides.setTspElementPourEcartsBases(getTspElementPourEcartsBases());
    }
    else
    {
      Date dateTimestampAvant = (Date)LiDOHelper.getSyntheticValue(getPC(), "{version}");
      if (dateTimestampAvant != null) {
        copieAides.setTspElementPourEcartsBases(dateTimestampAvant);
      }
    }
    copieAides.setLibelleDerogatoire(getLibelleDerogatoire());
    copieAides.setNumeroBon(getNumeroBon());
    copieAides.setMontantBonEnLettres(getMontantBonEnLettres());
    copieAides.setTypeBon(getTypeBon());
    copieAides.setClefControleBon(getClefControleBon());
    copieAides.setOrigineDemande(super.getOrigineDemande());
    copieAides.setTypeDemandeWeb(super.getTypeDemandeWeb());
    copieAides.setGareAllerDepart(getGareAllerDepart());
    copieAides.setGareAllerArrivee(getGareAllerArrivee());
  }
  
  public void ajouterPeriodeLieu(PeriodeLieu pl)
  {
    super.ajouterPeriodeLieu(pl);
  }
  
  public void marquerGraphePersistant()
  {
    DomManager.persisterEnProfondeur(getCollectionPeriodeLieu());
    DomManager.persisterEnProfondeur(getCollectionDerogation());
  }
  
  public Collection getPeriodesLieu()
  {
    return super.getCollectionPeriodeLieu();
  }
  
  public Collection getListeMethodesAExclurePourComparaison()
  {
    return new ArrayList();
  }
  
  public Map<String, Object> recupererParametresEcartsBases()
  {
    Map<String, Object> parametresEcartsBases = new HashMap();
    parametresEcartsBases.put("attributType", "Aides Pivot");
    parametresEcartsBases.put("cleTechnique", getIdentifiant());
    String cleFonctionnelle = getReferenceExterne();
    if (cleFonctionnelle == null) {
      cleFonctionnelle = getIdentifiant();
    }
    parametresEcartsBases.put("cleFonctionnelle", cleFonctionnelle);
    parametresEcartsBases.put("timestampAvant", getTspElementPourEcartsBases());
    return parametresEcartsBases;
  }
  
  public boolean estComparableAvec(ElementBasePivotEchangeComparableSpec elmntAComparer)
  {
    Aides elementAComparer = (Aides)elmntAComparer;
    return getIdentifiant().equals(elementAComparer.getIdentifiant());
  }
  
  public Collection comparer(ElementBasePivotEchangeComparableSpec elementAComparer)
    throws CoucheLogiqueException
  {
    return OutilComparaison.comparer(this, elementAComparer);
  }
  
  public Date getTspElementPourEcartsBases()
  {
    return tspElementPourEcartsBase;
  }
  
  public void setTspElementPourEcartsBases(Date tspElementPourEcartBase)
  {
    tspElementPourEcartsBase = tspElementPourEcartBase;
  }
  
  public void initInstance()
  {
    Aides aidesVide = new Aides();
    aidesVide.copieElements(this);
  }
  
  public void clearCollectionDerogation()
  {
    for (Iterator<?> iter = getCollectionDerogation().iterator(); iter.hasNext();)
    {
      Derogation element = (Derogation)iter.next();
      DomManager.supprimer(element);
    }
    super.clearCollectionDerogation();
  }
  
  public void clearCollectionPeriodeLieu()
  {
    for (Iterator<?> iter = getCollectionPeriodeLieu().iterator(); iter.hasNext();)
    {
      PeriodeLieu element = (PeriodeLieu)iter.next();
      DomManager.supprimer(element);
    }
    super.clearCollectionPeriodeLieu();
  }
  
  public void remplacerCollectionPeriodeLieu(Collection collectionACopier)
  {
    for (Iterator<?> i = super.getCollectionPeriodeLieu().iterator(); i.hasNext();)
    {
      PeriodeLieu objet = (PeriodeLieu)i.next();
      DomManager.supprimer(objet);
    }
    super.remplacerCollectionPeriodeLieu(collectionACopier);
  }
  
  public void remplacerCollectionDerogation(Collection collectionACopier)
  {
    for (Iterator<?> i = super.getCollectionDerogation().iterator(); i.hasNext();)
    {
      Derogation objet = (Derogation)i.next();
      DomManager.supprimer(objet);
    }
    super.remplacerCollectionDerogation(collectionACopier);
  }
}

/* Location:
 * Qualified Name:     Aides
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */