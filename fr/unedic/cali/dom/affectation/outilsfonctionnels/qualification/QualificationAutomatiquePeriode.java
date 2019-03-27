package fr.unedic.cali.dom.affectation.outilsfonctionnels.qualification;

import fr.unedic.cali.affectation.parametres.CriteresQualification;
import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.Metier;
import fr.unedic.cali.dom.affectation.DecorReglementaire;
import fr.unedic.cali.dom.affectation.ProduitAsuCge01P02;
import fr.unedic.cali.dom.affectation.ProduitAsuCge01P03;
import fr.unedic.cali.dom.affectation.ProduitAsuCge01P04;
import fr.unedic.cali.dom.affectation.ProduitAsuCge01P05;
import fr.unedic.cali.dom.affectation.ProduitAsuCge01P06;
import fr.unedic.cali.dom.affectation.ProduitAsuCge01P07;
import fr.unedic.cali.dom.affectation.ProduitAsuCge01P6B;
import fr.unedic.cali.dom.affectation.ProduitAsuExp03P01;
import fr.unedic.cali.dom.affectation.ProduitAsuSpe02P01;
import fr.unedic.cali.dom.affectation.ProduitAsuSpe02P03;
import fr.unedic.cali.dom.affectation.ProduitAsuSpe02P04;
import fr.unedic.cali.dom.affectation.ProduitAsuSpe02P05;
import fr.unedic.cali.dom.affectation.ProduitAsuSpe02P06;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.dom.affectation.QualificationPeriodeActiviteSalarie;
import fr.unedic.cali.dom.affectation.Reglement;
import fr.unedic.cali.dom.affectation.outilsfonctionnels.qualification.fabriques.FabriqueStrategieCoordinationEuropeenneQualification;
import fr.unedic.cali.dom.affectation.outilsfonctionnels.qualification.strategies.spec.StrategieCoordinationEuropeenneQualificationSpec;
import fr.unedic.cali.outilsfonctionnels.strategies.CritereStrategie;
import fr.unedic.util.services.ApplicativeRuntimeException;
import fr.unedic.util.services.CoucheLogiqueException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class QualificationAutomatiquePeriode
{
  public static final int ALGO_NON_EFFECTUE = 0;
  public static final int ALGO_EFFECTUE = 1;
  private static Map<String, ValidationReglementSpec> listeOutilsValidation = new HashMap();
  private static Map<String, ValidationReglementSpec> listeOutilsValidationParticulier = new HashMap();
  
  static
  {
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("RG", ProduitAsuCge01P02.getInstance())), new ValidationReglementGeneral());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("OP", ProduitAsuCge01P02.getInstance())), new ValidationReglementGeneralOuvrierPresse());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A1", ProduitAsuCge01P02.getInstance())), new ValidationAnnexe1());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A2a", ProduitAsuCge01P02.getInstance())), new ValidationAnnexe2a());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A2b", ProduitAsuCge01P02.getInstance())), new ValidationAnnexe2b());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A3", ProduitAsuCge01P02.getInstance())), new ValidationAnnexe3());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A4", ProduitAsuCge01P02.getInstance())), new ValidationAnnexe4());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A5", ProduitAsuCge01P02.getInstance())), new ValidationAnnexe5());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A9A", ProduitAsuCge01P02.getInstance())), new ValidationAnnexe9A());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A9B", ProduitAsuCge01P02.getInstance())), new ValidationAnnexe9B());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("RGP", ProduitAsuCge01P02.getInstance())), new ValidationReglementGeneralParticulier());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A8", ProduitAsuSpe02P01.getInstance())), new ValidationAnnexe8());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A10", ProduitAsuSpe02P01.getInstance())), new ValidationAnnexe10());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("RG", ProduitAsuCge01P03.getInstance())), new ValidationReglementGeneral());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("OP", ProduitAsuCge01P03.getInstance())), new ValidationReglementGeneralOuvrierPresse());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A1", ProduitAsuCge01P03.getInstance())), new ValidationAnnexe1());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A2a", ProduitAsuCge01P03.getInstance())), new ValidationAnnexe2a());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A2b", ProduitAsuCge01P03.getInstance())), new ValidationAnnexe2b());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A3", ProduitAsuCge01P03.getInstance())), new ValidationAnnexe3());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A4", ProduitAsuCge01P03.getInstance())), new ValidationAnnexe4());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A5", ProduitAsuCge01P03.getInstance())), new ValidationAnnexe5());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A9A", ProduitAsuCge01P03.getInstance())), new ValidationAnnexe9A());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A9B", ProduitAsuCge01P03.getInstance())), new ValidationAnnexe9B());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("RG", ProduitAsuCge01P03.getInstance())), new ValidationReglementGeneralParticulier());
    
    listeOutilsValidationParticulier.put(getNomUnique(Reglement.getInstance("A4", ProduitAsuCge01P02.getInstance())), new ValidationAnnexe4CasParticulier());
    
    listeOutilsValidationParticulier.put(getNomUnique(Reglement.getInstance("A4", ProduitAsuCge01P03.getInstance())), new ValidationAnnexe4CasParticulier());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("RG", ProduitAsuCge01P04.getInstance())), new ValidationReglementGeneral());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("RG", ProduitAsuCge01P04.getInstance())), new ValidationReglementGeneralOuvrierPresse());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A1", ProduitAsuCge01P04.getInstance())), new ValidationAnnexe1());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A2a", ProduitAsuCge01P04.getInstance())), new ValidationAnnexe2a());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A2b", ProduitAsuCge01P04.getInstance())), new ValidationAnnexe2b());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A3", ProduitAsuCge01P04.getInstance())), new ValidationAnnexe3());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A4", ProduitAsuCge01P04.getInstance())), new ValidationAnnexe4());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A5", ProduitAsuCge01P04.getInstance())), new ValidationAnnexe5());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A9A", ProduitAsuCge01P04.getInstance())), new ValidationAnnexe9A());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("RG", ProduitAsuCge01P04.getInstance())), new ValidationReglementGeneralParticulier());
    
    listeOutilsValidationParticulier.put(getNomUnique(Reglement.getInstance("A4", ProduitAsuCge01P04.getInstance())), new ValidationAnnexe4CasParticulier());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("RG", ProduitAsuCge01P05.getInstance())), new ValidationReglementGeneral());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("RG", ProduitAsuCge01P05.getInstance())), new ValidationReglementGeneralOuvrierPresse());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A1", ProduitAsuCge01P05.getInstance())), new ValidationAnnexe1());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A2a", ProduitAsuCge01P05.getInstance())), new ValidationAnnexe2a());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A2b", ProduitAsuCge01P05.getInstance())), new ValidationAnnexe2b());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A3", ProduitAsuCge01P05.getInstance())), new ValidationAnnexe3());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A4", ProduitAsuCge01P05.getInstance())), new ValidationAnnexe4());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A5", ProduitAsuCge01P05.getInstance())), new ValidationAnnexe5());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A9A", ProduitAsuCge01P05.getInstance())), new ValidationAnnexe9A());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("RG", ProduitAsuCge01P05.getInstance())), new ValidationReglementGeneralParticulier());
    
    listeOutilsValidationParticulier.put(getNomUnique(Reglement.getInstance("A4", ProduitAsuCge01P05.getInstance())), new ValidationAnnexe4CasParticulier());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("RG", ProduitAsuCge01P06.getInstance())), new ValidationReglementGeneral());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("RG", ProduitAsuCge01P06.getInstance())), new ValidationReglementGeneralOuvrierPresse());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A1", ProduitAsuCge01P06.getInstance())), new ValidationAnnexe1());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A2a", ProduitAsuCge01P06.getInstance())), new ValidationAnnexe2a());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A2b", ProduitAsuCge01P06.getInstance())), new ValidationAnnexe2b());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A3", ProduitAsuCge01P06.getInstance())), new ValidationAnnexe3());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A4", ProduitAsuCge01P06.getInstance())), new ValidationAnnexe4Convention2014());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A5", ProduitAsuCge01P06.getInstance())), new ValidationAnnexe5());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A9A", ProduitAsuCge01P06.getInstance())), new ValidationAnnexe9A());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("RG", ProduitAsuCge01P06.getInstance())), new ValidationReglementGeneralParticulier());
    
    listeOutilsValidationParticulier.put(getNomUnique(Reglement.getInstance("A4", ProduitAsuCge01P06.getInstance())), new ValidationAnnexe4CasParticulierConvention2014());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("RG", ProduitAsuCge01P6B.getInstance())), new ValidationReglementGeneral());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("RG", ProduitAsuCge01P6B.getInstance())), new ValidationReglementGeneralOuvrierPresse());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A1", ProduitAsuCge01P6B.getInstance())), new ValidationAnnexe1());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A2a", ProduitAsuCge01P6B.getInstance())), new ValidationAnnexe2a());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A2b", ProduitAsuCge01P6B.getInstance())), new ValidationAnnexe2b());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A3", ProduitAsuCge01P6B.getInstance())), new ValidationAnnexe3());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A4", ProduitAsuCge01P6B.getInstance())), new ValidationAnnexe4Convention2014());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A5", ProduitAsuCge01P6B.getInstance())), new ValidationAnnexe5());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A9A", ProduitAsuCge01P6B.getInstance())), new ValidationAnnexe9A());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("RG", ProduitAsuCge01P6B.getInstance())), new ValidationReglementGeneralParticulier());
    
    listeOutilsValidationParticulier.put(getNomUnique(Reglement.getInstance("A4", ProduitAsuCge01P6B.getInstance())), new ValidationAnnexe4CasParticulierConvention2014());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("RG", ProduitAsuCge01P07.getInstance())), new ValidationReglementGeneral());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("RG", ProduitAsuCge01P07.getInstance())), new ValidationReglementGeneralOuvrierPresse());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A1", ProduitAsuCge01P07.getInstance())), new ValidationAnnexe1());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A2a", ProduitAsuCge01P07.getInstance())), new ValidationAnnexe2a());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A2b", ProduitAsuCge01P07.getInstance())), new ValidationAnnexe2b());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A3", ProduitAsuCge01P07.getInstance())), new ValidationAnnexe3());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A5", ProduitAsuCge01P07.getInstance())), new ValidationAnnexe5());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A9A", ProduitAsuCge01P07.getInstance())), new ValidationAnnexe9A());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("RG", ProduitAsuCge01P07.getInstance())), new ValidationReglementGeneralParticulier());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A9B", ProduitAsuExp03P01.getInstance())), new ValidationAnnexe9B());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A8", ProduitAsuSpe02P03.getInstance())), new ValidationAnnexe8());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A10", ProduitAsuSpe02P03.getInstance())), new ValidationAnnexe10());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A8", ProduitAsuSpe02P04.getInstance())), new ValidationAnnexe8());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A10", ProduitAsuSpe02P04.getInstance())), new ValidationAnnexe10());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A8", ProduitAsuSpe02P05.getInstance())), new ValidationAnnexe8Convention2016());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A10", ProduitAsuSpe02P05.getInstance())), new ValidationAnnexe10Convention2016());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A8", ProduitAsuSpe02P06.getInstance())), new ValidationAnnexe8Convention2016());
    
    listeOutilsValidation.put(getNomUnique(Reglement.getInstance("A10", ProduitAsuSpe02P06.getInstance())), new ValidationAnnexe10Convention2016());
  }
  
  private static String getNomUnique(Reglement reglement)
  {
    return reglement.getNomReglement() + "|" + reglement.getProduit().getNom();
  }
  
  public static QualificationPeriodeActiviteSalarie qualifierTransientePeriode(ActiviteSalarie periode)
  {
    QualificationPeriodeActiviteSalarie qualificationPeriodeActiviteSalarie = null;
    
    Reglement reglement = determineReglementPeriode(periode);
    if (reglement != null) {
      qualificationPeriodeActiviteSalarie = new QualificationPeriodeActiviteSalarie(reglement, periode.getCriteresQualification());
    }
    return qualificationPeriodeActiviteSalarie;
  }
  
  public static Reglement determineReglementPeriode(ActiviteSalarie periode, DecorReglementaire decor)
    throws ApplicativeRuntimeException
  {
    return determineReglementPeriode(periode, decor, false);
  }
  
  public static Reglement determineReglementPeriode(ActiviteSalarie periode, DecorReglementaire decor, boolean coordinationCEE)
    throws ApplicativeRuntimeException
  {
    CriteresQualification criteresQualification = new CriteresQualification(decor, periode, coordinationCEE);
    
    periode.setCriteresQualification(criteresQualification);
    
    return determineReglementPeriode(periode);
  }
  
  public static Reglement determineReglementPeriode(ActiviteSalarie periode)
  {
    Reglement reglementTrouve = null;
    StringBuilder reglementsValides = new StringBuilder();
    CriteresQualification critereQualification = periode.getCriteresQualification();
    boolean estContexteMayotte = critereQualification.isEstContexteMayotte();
    DecorReglementaire decor = critereQualification.getDecor();
    if (decor != null)
    {
      ProduitSpec produitParDefaut = decor.getProduitParDefaut();
      
      int compteur = 0;
      
      reglementTrouve = lancerQualificationCoordinationEuropenne(periode);
      compteur = gererReglementTrouve(reglementTrouve, compteur, reglementsValides);
      if ((estContexteMayotte) || (periode.isEstPeriodeMayotte())) {
        reglementTrouve = reglementRg(produitParDefaut);
      }
      if (reglementTrouve == null) {
        reglementTrouve = lancerQualificationAutomatiqueClassique(periode, compteur, decor, reglementsValides, produitParDefaut);
      }
    }
    return reglementTrouve;
  }
  
  private static Reglement lancerQualificationCoordinationEuropenne(ActiviteSalarie periode)
  {
    Reglement reglementTrouve = null;
    try
    {
      CritereStrategie critereStrategie = new CritereStrategie();
      
      critereStrategie.setDatePivot(periode.getCriteresQualification().getDateFinDernierSinistre());
      StrategieCoordinationEuropeenneQualificationSpec strategieCoordinationEuropeenneQualificationCourante = (StrategieCoordinationEuropeenneQualificationSpec)FabriqueStrategieCoordinationEuropeenneQualification.getInstance().getStrategie(critereStrategie);
      
      reglementTrouve = strategieCoordinationEuropeenneQualificationCourante.determineReglementPeriodeEnCoordinationEuropeenne(periode);
    }
    catch (CoucheLogiqueException ex)
    {
      reglementTrouve = null;
    }
    return reglementTrouve;
  }
  
  private static Reglement lancerQualificationAutomatiqueClassique(ActiviteSalarie periode, int compteurReglement, DecorReglementaire decor, StringBuilder reglementsValides, ProduitSpec produitParDefaut)
  {
    Reglement reglementTrouve = null;
    int compteur = compteurReglement;
    if (periode.estQualifiable())
    {
      List listeReglementsATester = decor.getReglements();
      Iterator iterateur = listeReglementsATester.iterator();
      while (iterateur.hasNext())
      {
        Reglement reglementCourant = (Reglement)iterateur.next();
        
        ValidationReglementSpec validationReglement = (ValidationReglementSpec)listeOutilsValidation.get(getNomUnique(reglementCourant));
        if ((validationReglement != null) && (validationReglement.validerPeriode(periode.getPeriodeActiviteSalarieGaec())))
        {
          reglementTrouve = reglementCourant;
          compteur = gererReglementTrouve(reglementTrouve, compteur, reglementsValides);
        }
      }
      if (reglementTrouve == null)
      {
        Reglement reglementTeste = Reglement.getInstance("A4", produitParDefaut);
        ValidationReglementSpec validationReglement = (ValidationReglementSpec)listeOutilsValidationParticulier.get(getNomUnique(reglementTeste));
        if (estReglementValidePourPeriode(validationReglement, periode))
        {
          reglementTrouve = reglementTeste;
          compteur = gererReglementTrouve(reglementTrouve, compteur, reglementsValides);
        }
      }
      if (reglementTrouve == null)
      {
        reglementTrouve = reglementRg(produitParDefaut);
        compteur = gererReglementTrouve(reglementTrouve, compteur, reglementsValides);
      }
      if (compteur > 1)
      {
        StringBuilder libelleErreur = new StringBuilder();
        libelleErreur.append("Erreur : plus d'un règlement valide a été trouvé lors de la qualif. auto. d'une période");
        libelleErreur.append(" [ ");
        libelleErreur.append(reglementsValides.toString());
        libelleErreur.append("]");
        
        throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_PLUS_D_UN_REGLEMENT_VALIDE_AUTO", libelleErreur.toString(), new CoucheLogiqueException("HG_PR_CALI_L_ERR_PLUS_D_UN_REGLEMENT_VALIDE_AUTO", libelleErreur.toString()));
      }
    }
    else
    {
      reglementTrouve = gererCasParticulierPeriodeNonQualifiableCertifieeNonAttestee(periode, produitParDefaut);
    }
    return reglementTrouve;
  }
  
  private static boolean estReglementValidePourPeriode(ValidationReglementSpec validationReglement, ActiviteSalarie periode)
  {
    return (validationReglement != null) && (validationReglement.validerPeriode(periode.getPeriodeActiviteSalarieGaec()));
  }
  
  private static Reglement gererCasParticulierPeriodeNonQualifiableCertifieeNonAttestee(ActiviteSalarie periode, ProduitSpec produitParDefaut)
  {
    Reglement reglementTrouve = null;
    if ((!periode.estAtteste()) || (periode.getMetier().getChampApplication() == 2) || (periode.getMetier().getChampApplication() == 8)) {
      reglementTrouve = reglementRg(produitParDefaut);
    }
    return reglementTrouve;
  }
  
  private static int gererReglementTrouve(Reglement reglementTrouve, int compteurPrecedent, StringBuilder reglementsValides)
  {
    int compteur = compteurPrecedent;
    if (reglementTrouve != null)
    {
      compteur++;
      reglementsValides.append(reglementTrouve.getLibelleCourt());
      reglementsValides.append(" ");
    }
    return compteur;
  }
  
  private static Reglement reglementRg(ProduitSpec produitParDefaut)
  {
    Reglement retour = null;
    if (produitParDefaut != null) {
      retour = Reglement.getInstance("RG", produitParDefaut);
    }
    return retour;
  }
}

/* Location:
 * Qualified Name:     QualificationAutomatiquePeriode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */