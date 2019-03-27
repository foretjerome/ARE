package fr.unedic.cali.dom.affectation.outilsfonctionnels.qualification;

import fr.unedic.cali.autresdoms.ga.dom.ContratTravail;
import fr.unedic.cali.autresdoms.ga.dom.Entreprise;
import fr.unedic.cali.autresdoms.ga.dom.Metier;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteSalarie;
import fr.unedic.cali.parametres.GestionnaireDateApplication;
import fr.unedic.util.services.ApplicativeRuntimeException;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang.StringUtils;

public class ValidationAnnexe8
  implements ValidationReglementSpec
{
  protected static final int UN = 1;
  protected static final int DEUX = 2;
  protected static final int TROIS = 3;
  protected static final int QUATRE = 4;
  protected static final int CINQ = 5;
  protected static final int SEPT = 7;
  protected static final int NEUF = 9;
  private static Set<String> codesNafGroupe1a = new HashSet(7, 1.0F);
  private static Set<String> codesNafGroupe1b = new HashSet(4, 1.0F);
  private static Set<String> codesNafGroupe2 = new HashSet(9, 1.0F);
  private static Set<String> codesNafGroupe3 = new HashSet(5, 1.0F);
  private static Set<String> codesNafGroupe4 = new HashSet(4, 1.0F);
  private static Set<String> codesNafGroupe5 = new HashSet(2, 1.0F);
  private static Set<String> codesNafGroupe6Cas1 = new HashSet(3, 1.0F);
  private static Set<String> codesNafGroupe7 = new HashSet(2, 1.0F);
  private static Set<String> codesNafGroupe11 = new HashSet(2, 1.0F);
  private static Set<String> codesNafGroupe12 = new HashSet(1, 1.0F);
  private static Set<String> codesNafGroupe13 = new HashSet(1, 1.0F);
  private static Set<String> codesNafGroupe14a = new HashSet(3, 1.0F);
  private static Set<String> codesNafGroupe14b = new HashSet(1, 1.0F);
  private static Set<String> codesNafGroupe15 = new HashSet(1, 1.0F);
  private static Set<String> codesNafGroupe1617Cas1 = new HashSet(1, 1.0F);
  private static Set<String> codesNafGroupe2627Cas1 = new HashSet(1, 1.0F);
  private static Set<String> codesNafGroupe18 = new HashSet(2, 1.0F);
  private static Set<String> codesNafGroupe19 = new HashSet(4, 1.0F);
  private static Set<String> codesNafGroupe23 = new HashSet(1, 1.0F);
  private static Map<String, ValidationCodeNaf> codesNafGroupe31 = new HashMap(3);
  private static Set<String> codesNafGroupe33 = new HashSet(1, 1.0F);
  private static Map<String, ValidationCodeNaf> codesNafGroupe22 = new HashMap(2);
  private static Set<String> codesNafRealisateurGroupe1a = new HashSet(7, 1.0F);
  private static Set<String> codesNafRealisateurGroupe1b = new HashSet(4, 1.0F);
  private static Set<String> codesNafRealisateurGroupe2 = new HashSet(9, 1.0F);
  private static Set<String> codesNafRealisateurGroupe3 = new HashSet(5, 1.0F);
  private static Set<String> codesNafRealisateurGroupe4 = new HashSet(4, 1.0F);
  private static Set<String> codesNafRealisateurGroupe5 = new HashSet(2, 1.0F);
  private static Set<String> codesNafRealisateurGroupe6 = new HashSet(3, 1.0F);
  private static Set<String> codesNafRealisateurGroupe7 = new HashSet(2, 1.0F);
  private static String sirenGroupe1b = "302421193";
  private static String sirenGroupe3 = "326408267";
  private static String sirenRealisateur = "302421193";
  
  static
  {
    codesNafGroupe1a.add("921A");
    codesNafGroupe1a.add("921B");
    codesNafGroupe1a.add("921C");
    codesNafGroupe1a.add("922B");
    codesNafGroupe1a.add("5911A");
    codesNafGroupe1a.add("5911B");
    codesNafGroupe1a.add("5911C");
    
    codesNafGroupe1b.add("922D");
    codesNafGroupe1b.add("922E");
    codesNafGroupe1b.add("6020A");
    codesNafGroupe1b.add("6020B");
    
    codesNafGroupe2.add("921A");
    codesNafGroupe2.add("921B");
    codesNafGroupe2.add("921C");
    codesNafGroupe2.add("921D");
    codesNafGroupe2.add("5911A");
    codesNafGroupe2.add("5911B");
    codesNafGroupe2.add("5911C");
    codesNafGroupe2.add("5912Z");
    codesNafGroupe2.add("5920Z");
    
    codesNafGroupe3.add("922A");
    codesNafGroupe3.add("922D");
    codesNafGroupe3.add("5920Z");
    codesNafGroupe3.add("6010Z");
    codesNafGroupe3.add("6020A");
    
    codesNafGroupe4.add("921D");
    codesNafGroupe4.add("5911C");
    codesNafGroupe4.add("5912Z");
    codesNafGroupe4.add("5920Z");
    
    codesNafGroupe5.add("221G");
    codesNafGroupe5.add("5920Z");
    
    codesNafGroupe6Cas1.add("923A");
    codesNafGroupe6Cas1.add("923K");
    codesNafGroupe6Cas1.add("9001Z");
    
    codesNafGroupe7.add("923B");
    codesNafGroupe7.add("9002Z");
    
    codesNafGroupe11.add("5911A");
    codesNafGroupe11.add("5911B");
    
    codesNafGroupe12.add("5911C");
    
    codesNafGroupe13.add("5920Z");
    
    codesNafGroupe14a.add("5911C");
    codesNafGroupe14a.add("5912Z");
    codesNafGroupe14a.add("5920Z");
    
    codesNafGroupe14b.add("9002Z");
    
    codesNafGroupe15.add("6010Z");
    codesNafGroupe15.add("5920Z");
    
    codesNafGroupe1617Cas1.add("9001Z");
    codesNafGroupe2627Cas1.add("9001Z");
    
    codesNafGroupe18.add("6020A");
    codesNafGroupe18.add("6020B");
    
    codesNafGroupe19.add("5911A");
    codesNafGroupe19.add("5911B");
    codesNafGroupe19.add("5911C");
    codesNafGroupe19.add("5912Z");
    
    codesNafGroupe23.add("5920Z");
    
    codesNafGroupe31.put("5911A", ValidationCodeNaf.TOUJOURS_VALIDE);
    codesNafGroupe31.put("5911B", ValidationCodeNaf.TOUJOURS_VALIDE);
    codesNafGroupe31.put("5911C", getValidationListe17SI1());
    
    codesNafGroupe33.add("5920Z");
    
    codesNafGroupe22.put("5911C", ValidationCodeNaf.TOUJOURS_VALIDE);
    codesNafGroupe22.put("5911B", getValidation5911BListe22());
    codesNafGroupe22.put("5911A", getValidationListe17SI1());
    
    codesNafRealisateurGroupe1a.add("921A");
    codesNafRealisateurGroupe1a.add("5911A");
    codesNafRealisateurGroupe1a.add("921B");
    codesNafRealisateurGroupe1a.add("5911B");
    codesNafRealisateurGroupe1a.add("921C");
    codesNafRealisateurGroupe1a.add("5911C");
    codesNafRealisateurGroupe1a.add("922B");
    
    codesNafRealisateurGroupe1b.add("922E");
    codesNafRealisateurGroupe1b.add("6020B");
    codesNafRealisateurGroupe1b.add("922D");
    codesNafRealisateurGroupe1b.add("6020A");
    
    codesNafRealisateurGroupe2.add("921A");
    codesNafRealisateurGroupe2.add("5911A");
    codesNafRealisateurGroupe2.add("921B");
    codesNafRealisateurGroupe2.add("5911B");
    codesNafRealisateurGroupe2.add("921C");
    codesNafRealisateurGroupe2.add("5911C");
    codesNafRealisateurGroupe2.add("921D");
    codesNafRealisateurGroupe2.add("5912Z");
    codesNafRealisateurGroupe2.add("5920Z");
    
    codesNafRealisateurGroupe3.add("922A");
    codesNafRealisateurGroupe3.add("5920Z");
    codesNafRealisateurGroupe3.add("6010Z");
    codesNafRealisateurGroupe3.add("922D");
    codesNafRealisateurGroupe3.add("6020A");
    
    codesNafRealisateurGroupe4.add("921D");
    codesNafRealisateurGroupe4.add("5911C");
    codesNafRealisateurGroupe4.add("5912Z");
    codesNafRealisateurGroupe4.add("5920Z");
    
    codesNafRealisateurGroupe5.add("221G");
    codesNafRealisateurGroupe5.add("5920Z");
    
    codesNafRealisateurGroupe6.add("923A");
    codesNafRealisateurGroupe6.add("9001Z");
    codesNafRealisateurGroupe6.add("923K");
    
    codesNafRealisateurGroupe7.add("923B");
    codesNafRealisateurGroupe7.add("9002Z");
  }
  
  private static ValidationCodeNaf getValidationListe17SI1()
  {
    GestionnaireDateApplication gestionnaire;
    try
    {
      gestionnaire = GestionnaireDateApplication.getInstance();
    }
    catch (CoucheLogiqueException ex)
    {
      throw new RuntimeException(ex);
    }
    Damj fin = Damj.FIN_DES_TEMPS;
    Damj connaissance = gestionnaire.recupererDateApplication("Modification des listes Spectacles en 17SI1");
    
    return new ValidationCodeNaf(null, new Periode(connaissance, fin));
  }
  
  private static ValidationCodeNaf getValidation5911BListe22()
  {
    GestionnaireDateApplication gestionnaire;
    try
    {
      gestionnaire = GestionnaireDateApplication.getInstance();
    }
    catch (CoucheLogiqueException ex)
    {
      throw new RuntimeException(ex);
    }
    Damj fin = Damj.FIN_DES_TEMPS;
    Damj debut = gestionnaire.recupererDateApplication("Prise en compte des entreprises 5911B pour les A8 liste 22");
    Damj connaissance = gestionnaire.recupererDateApplication("Prise en compte des entreprises 5911B pour les A8 liste 22 2");
    
    return new ValidationCodeNaf(new Periode(debut, fin), new Periode(connaissance, fin));
  }
  
  public boolean validerPeriode(PeriodeActiviteSalarie periode)
  {
    return (testTypeContratTravailCdd(periode)) && ((validerOuvrierTechnicienSpectacle(periode)) || (validerRealisateur(periode)) || (validerCifCDD(periode)) || (validerAvecGuso(periode)));
  }
  
  protected boolean validerOuvrierTechnicienSpectacle(PeriodeActiviteSalarie periode)
  {
    return (testCategorieEmploiParticulierOuvrierTechnicienSpectacle(periode)) && (validerGroupeOuvrierTechnicienSpectacle(periode));
  }
  
  protected boolean validerGroupeOuvrierTechnicienSpectacle(PeriodeActiviteSalarie periode)
  {
    return (validerGroupe1a(periode)) || (validerGroupe1b(periode)) || (validerGroupe2(periode)) || (validerGroupe3(periode)) || (validerGroupe4(periode)) || (validerGroupe5(periode)) || (validerGroupe6(periode)) || (validerGroupe7(periode)) || (validerGroupe11(periode)) || (validerGroupe12(periode)) || (validerGroupe13(periode)) || (validerGroupe14a(periode)) || (validerGroupe14b(periode)) || (validerGroupe15(periode)) || (validerGroupe1617(periode)) || (validerGroupe18(periode)) || (validerGroupe19(periode)) || (validerGroupe23(periode)) || (validerGroupe31(periode)) || (validerGroupe33(periode)) || (validerGroupe22(periode)) || (validerGroupe2627(periode));
  }
  
  protected boolean origineAemOuAA13(PeriodeActiviteSalarie periode)
  {
    Collection<Integer> origines = periode.getCollectionOrigineInformationPAS();
    if (origines.contains(Integer.valueOf(4))) {
      return true;
    }
    if (origines.contains(Integer.valueOf(71))) {
      return true;
    }
    return false;
  }
  
  private boolean origineAA13OuAE(PeriodeActiviteSalarie periode)
  {
    Collection<Integer> origines = periode.getCollectionOrigineInformationPAS();
    if (origines.contains(Integer.valueOf(1))) {
      return true;
    }
    return origineAA13(periode);
  }
  
  private boolean origineAA13(PeriodeActiviteSalarie periode)
  {
    Collection<Integer> origines = periode.getCollectionOrigineInformationPAS();
    if (origines.contains(Integer.valueOf(71))) {
      return true;
    }
    return false;
  }
  
  private boolean origineFeuilletGuso(PeriodeActiviteSalarie periode)
  {
    Collection<Integer> origines = periode.getCollectionOrigineInformationPAS();
    if (origines.contains(Integer.valueOf(5))) {
      return true;
    }
    return false;
  }
  
  private boolean validerGroupe1a(PeriodeActiviteSalarie periode)
  {
    return (origineAemOuAA13(periode)) && (validerCodeNaf(periode, codesNafGroupe1a)) && (testEmploiDansListe(periode, 1));
  }
  
  private boolean validerGroupe1b(PeriodeActiviteSalarie periode)
  {
    return (origineAemOuAA13(periode)) && ((validerCodeNaf(periode, codesNafGroupe1b)) || (equalsNotNull(periode.getEntreprise().getSiren(), sirenGroupe1b))) && (testEmploiDansListe(periode, 2));
  }
  
  private boolean validerGroupe2(PeriodeActiviteSalarie periode)
  {
    return (origineAemOuAA13(periode)) && (validerCodeNaf(periode, codesNafGroupe2)) && (testEmploiDansListe(periode, 3));
  }
  
  private boolean validerGroupe3(PeriodeActiviteSalarie periode)
  {
    return (origineAemOuAA13(periode)) && ((validerCodeNaf(periode, codesNafGroupe3)) || (equalsNotNull(periode.getEntreprise().getSiren(), sirenGroupe3))) && (testEmploiDansListe(periode, 4));
  }
  
  private boolean validerGroupe4(PeriodeActiviteSalarie periode)
  {
    return (origineAemOuAA13(periode)) && (validerCodeNaf(periode, codesNafGroupe4)) && (testEmploiDansListe(periode, 5));
  }
  
  private boolean validerGroupe5(PeriodeActiviteSalarie periode)
  {
    return (origineAemOuAA13(periode)) && (validerCodeNaf(periode, codesNafGroupe5)) && (testEmploiDansListe(periode, 6));
  }
  
  private boolean validerGroupe6(PeriodeActiviteSalarie periode)
  {
    return (validerGroupe6Cas1(periode)) || (validerGroupe6Cas2(periode)) || (validerGroupe6Cas3(periode));
  }
  
  private boolean validerGroupe6Cas1(PeriodeActiviteSalarie periode)
  {
    return (origineAemOuAA13(periode)) && (validerCodeNaf(periode, codesNafGroupe6Cas1)) && (periode.getContratTravail().getLicenceAEM()) && (testEmploiDansListe(periode, 7));
  }
  
  private boolean validerGroupe6Cas2(PeriodeActiviteSalarie periode)
  {
    return (origineAemOuAA13(periode)) && (periode.getContratTravail().getLicenceAEM()) && (periode.getContratTravail().getCCSAEM()) && (testEmploiDansListe(periode, 7));
  }
  
  private boolean validerGroupe6Cas3(PeriodeActiviteSalarie periode)
  {
    return (origineAemOuAA13(periode)) && (periode.getContratTravail().isOrganisateurOccasionnelSpectacle()) && (testEmploiDansListe(periode, 7));
  }
  
  private boolean validerGroupe7(PeriodeActiviteSalarie periode)
  {
    return (origineAemOuAA13(periode)) && (validerCodeNaf(periode, codesNafGroupe7)) && (periode.getContratTravail().getLabelAEM()) && (testEmploiDansListe(periode, 8));
  }
  
  private boolean validerGroupe11(PeriodeActiviteSalarie periode)
  {
    return (origineAemOuAA13(periode)) && (validerCodeNaf(periode, codesNafGroupe11)) && (testEmploiDansListe(periode, 9));
  }
  
  private boolean validerGroupe12(PeriodeActiviteSalarie periode)
  {
    return (origineAemOuAA13(periode)) && (validerCodeNaf(periode, codesNafGroupe12)) && (testEmploiDansListe(periode, 10));
  }
  
  private boolean validerGroupe13(PeriodeActiviteSalarie periode)
  {
    return (origineAemOuAA13(periode)) && (validerCodeNaf(periode, codesNafGroupe13)) && (testEmploiDansListe(periode, 11));
  }
  
  private boolean validerGroupe14a(PeriodeActiviteSalarie periode)
  {
    boolean validationGroupe14a = (origineAemOuAA13(periode)) && (validerCodeNaf(periode, codesNafGroupe14a)) && (testEmploiDansListe(periode, 12)) && (estPriseEnCompteCertificationSociale(periode));
    
    return validationGroupe14a;
  }
  
  private boolean validerGroupe14b(PeriodeActiviteSalarie periode)
  {
    return (origineAemOuAA13(periode)) && (validerCodeNaf(periode, codesNafGroupe14b)) && (periode.getContratTravail().getLabelAEM()) && (testEmploiDansListe(periode, 13));
  }
  
  private boolean validerGroupe15(PeriodeActiviteSalarie periode)
  {
    return (origineAemOuAA13(periode)) && (validerCodeNaf(periode, codesNafGroupe15)) && (testEmploiDansListe(periode, 14));
  }
  
  private boolean validerGroupe1617(PeriodeActiviteSalarie periode)
  {
    return (validerGroupe1617Cas1(periode)) || (validerGroupe1617Cas2(periode)) || (validerGroupe1617Cas3(periode));
  }
  
  private boolean validerGroupe1617Cas1(PeriodeActiviteSalarie periode)
  {
    return (origineAemOuAA13(periode)) && (validerCodeNaf(periode, codesNafGroupe1617Cas1)) && (periode.getContratTravail().getLicenceAEM()) && (testEmploiDansListe(periode, 15));
  }
  
  private boolean validerGroupe1617Cas2(PeriodeActiviteSalarie periode)
  {
    return (origineAemOuAA13(periode)) && (periode.getContratTravail().getLicenceAEM()) && (periode.getContratTravail().getCCSAEM()) && (testEmploiDansListe(periode, 15));
  }
  
  private boolean validerGroupe1617Cas3(PeriodeActiviteSalarie periode)
  {
    return (origineAemOuAA13(periode)) && (periode.getContratTravail().isOrganisateurOccasionnelSpectacle()) && (testEmploiDansListe(periode, 15));
  }
  
  private boolean validerGroupe2627(PeriodeActiviteSalarie periode)
  {
    return (validerGroupe2627Cas1(periode)) || (validerGroupe2627Cas2(periode)) || (validerGroupe2627Cas3(periode));
  }
  
  private boolean validerGroupe2627Cas1(PeriodeActiviteSalarie periode)
  {
    return (origineAemOuAA13(periode)) && (validerCodeNaf(periode, codesNafGroupe2627Cas1)) && (periode.getContratTravail().getLicenceAEM()) && (testEmploiDansListe(periode, 22));
  }
  
  private boolean validerGroupe2627Cas2(PeriodeActiviteSalarie periode)
  {
    return (origineAemOuAA13(periode)) && (periode.getContratTravail().getLicenceAEM()) && (periode.getContratTravail().getCCSAEM()) && (testEmploiDansListe(periode, 22));
  }
  
  private boolean validerGroupe2627Cas3(PeriodeActiviteSalarie periode)
  {
    return (origineAemOuAA13(periode)) && (periode.getContratTravail().isOrganisateurOccasionnelSpectacle()) && (testEmploiDansListe(periode, 22));
  }
  
  private boolean validerGroupe18(PeriodeActiviteSalarie periode)
  {
    return (origineAemOuAA13(periode)) && (validerCodeNaf(periode, codesNafGroupe18)) && (testEmploiDansListe(periode, 16));
  }
  
  private boolean validerGroupe19(PeriodeActiviteSalarie periode)
  {
    return (origineAemOuAA13(periode)) && (validerCodeNaf(periode, codesNafGroupe19)) && (testEmploiDansListe(periode, 17));
  }
  
  private boolean validerGroupe23(PeriodeActiviteSalarie periode)
  {
    return (origineAemOuAA13(periode)) && (validerCodeNaf(periode, codesNafGroupe23)) && (testEmploiDansListe(periode, 18));
  }
  
  private boolean validerGroupe31(PeriodeActiviteSalarie periode)
  {
    return (origineAemOuAA13(periode)) && (validerCodeNaf(periode, codesNafGroupe31)) && (testEmploiDansListe(periode, 19));
  }
  
  private boolean validerGroupe33(PeriodeActiviteSalarie periode)
  {
    return (origineAemOuAA13(periode)) && (validerCodeNaf(periode, codesNafGroupe33)) && (testEmploiDansListe(periode, 20));
  }
  
  private boolean validerGroupe22(PeriodeActiviteSalarie periode)
  {
    return (origineAemOuAA13(periode)) && (validerCodeNaf(periode, codesNafGroupe22)) && (testEmploiDansListe(periode, 21));
  }
  
  protected boolean validerRealisateur(PeriodeActiviteSalarie periode)
  {
    return (periode.getCategorieEmploiParticulier() == 43) && ((validerRealisateurCas1a(periode)) || (validerRealisateurCas1b(periode)) || (validerRealisateurCas2(periode)) || (validerRealisateurCas3(periode)) || (validerRealisateurCas4(periode)) || (validerRealisateurCas5(periode)) || (validerRealisateurCas6(periode)) || (validerRealisateurCas7(periode)) || (validerRealisateurCas11(periode)) || (validerRealisateurCas12(periode)) || (validerRealisateurCas13(periode)) || (validerRealisateurCas14a(periode)) || (validerRealisateurCas14b(periode)) || (validerRealisateurCas15(periode)) || (validerRealisateurCas1617(periode)) || (validerRealisateurCas18(periode)) || (validerRealisateurCas19(periode)) || (validerRealisateurCas23(periode)) || (validerRealisateurCas31(periode)) || (validerRealisateurCas33(periode)) || (validerRealisateurCas22(periode)) || (validerRealisateurCas2627(periode)));
  }
  
  protected boolean validerCodeNaf(PeriodeActiviteSalarie periode, Set<String> listeEmploi)
  {
    return listeEmploi.contains(toUpperCaseNotNull(periode.getEntreprise().getCodeNAF()));
  }
  
  private boolean validerCodeNaf(PeriodeActiviteSalarie periode, Map<String, ValidationCodeNaf> listeEmploi)
  {
    String naf = toUpperCaseNotNull(periode.getEntreprise().getCodeNAF());
    ValidationCodeNaf validation = (ValidationCodeNaf)listeEmploi.get(naf);
    return (validation != null) && (validation.estApplicable(periode));
  }
  
  private boolean validerRealisateurCas1a(PeriodeActiviteSalarie periode)
  {
    boolean origineOK = origineAemOuAA13(periode);
    boolean codeNAFOK = validerCodeNaf(periode, codesNafRealisateurGroupe1a);
    boolean listeEmploiOK = testEmploiDansListe(periode, 1);
    boolean presenceSirenRealisateur = equalsNotNull(periode.getEntreprise().getSiren(), sirenRealisateur);
    
    return (origineOK) && (listeEmploiOK) && ((codeNAFOK) || (presenceSirenRealisateur));
  }
  
  private boolean validerRealisateurCas1b(PeriodeActiviteSalarie periode)
  {
    boolean origineOK = origineAemOuAA13(periode);
    boolean codeNAFOK = validerCodeNaf(periode, codesNafRealisateurGroupe1b);
    boolean listeEmploiOK = testEmploiDansListe(periode, 2);
    
    return (origineOK) && (listeEmploiOK) && (codeNAFOK);
  }
  
  private boolean validerRealisateurCas2(PeriodeActiviteSalarie periode)
  {
    boolean origineOK = origineAemOuAA13(periode);
    boolean codeNAFOK = validerCodeNaf(periode, codesNafRealisateurGroupe2);
    boolean listeEmploiOK = testEmploiDansListe(periode, 3);
    
    return (origineOK) && (listeEmploiOK) && (codeNAFOK);
  }
  
  private boolean validerRealisateurCas3(PeriodeActiviteSalarie periode)
  {
    boolean origineOK = origineAemOuAA13(periode);
    boolean codeNAFOK = validerCodeNaf(periode, codesNafRealisateurGroupe3);
    boolean listeEmploiOK = testEmploiDansListe(periode, 4);
    
    return (origineOK) && (listeEmploiOK) && (codeNAFOK);
  }
  
  private boolean validerRealisateurCas4(PeriodeActiviteSalarie periode)
  {
    boolean origineOK = origineAemOuAA13(periode);
    boolean codeNAFOK = validerCodeNaf(periode, codesNafRealisateurGroupe4);
    boolean listeEmploiOK = testEmploiDansListe(periode, 5);
    
    return (origineOK) && (listeEmploiOK) && (codeNAFOK);
  }
  
  private boolean validerRealisateurCas5(PeriodeActiviteSalarie periode)
  {
    boolean origineOK = origineAemOuAA13(periode);
    boolean codeNAFOK = validerCodeNaf(periode, codesNafRealisateurGroupe5);
    boolean listeEmploiOK = testEmploiDansListe(periode, 6);
    
    return (origineOK) && (listeEmploiOK) && (codeNAFOK);
  }
  
  private boolean validerRealisateurCas6(PeriodeActiviteSalarie periode)
  {
    boolean origineOK = origineAemOuAA13(periode);
    boolean codeNAFOK = validerCodeNaf(periode, codesNafRealisateurGroupe6);
    boolean listeEmploiOK = testEmploiDansListe(periode, 7);
    boolean presenceLicenceOK = periode.getContratTravail().getLicenceAEM();
    boolean presenceCCSOK = periode.getContratTravail().getCCSAEM();
    boolean organisateurOccasSpe = periode.getContratTravail().isOrganisateurOccasionnelSpectacle();
    
    return (origineOK) && (listeEmploiOK) && (((codeNAFOK) && (presenceLicenceOK)) || ((presenceLicenceOK) && (presenceCCSOK)) || (organisateurOccasSpe));
  }
  
  private boolean validerRealisateurCas7(PeriodeActiviteSalarie periode)
  {
    boolean origineOK = origineAemOuAA13(periode);
    boolean codeNAFOK = validerCodeNaf(periode, codesNafRealisateurGroupe7);
    boolean listeEmploiOK = testEmploiDansListe(periode, 8);
    boolean presenceLabelOK = periode.getContratTravail().getLabelAEM();
    
    return (origineOK) && (listeEmploiOK) && (codeNAFOK) && (presenceLabelOK);
  }
  
  private boolean validerRealisateurCas11(PeriodeActiviteSalarie periode)
  {
    boolean origineOK = origineAemOuAA13(periode);
    boolean codeNAFOK = validerCodeNaf(periode, codesNafGroupe11);
    boolean listeEmploiOK = testEmploiDansListe(periode, 9);
    
    return (origineOK) && (listeEmploiOK) && (codeNAFOK);
  }
  
  private boolean validerRealisateurCas12(PeriodeActiviteSalarie periode)
  {
    boolean origineOK = origineAemOuAA13(periode);
    boolean codeNAFOK = validerCodeNaf(periode, codesNafGroupe12);
    boolean listeEmploiOK = testEmploiDansListe(periode, 10);
    
    return (origineOK) && (listeEmploiOK) && (codeNAFOK);
  }
  
  private boolean validerRealisateurCas13(PeriodeActiviteSalarie periode)
  {
    boolean origineOK = origineAemOuAA13(periode);
    boolean codeNAFOK = validerCodeNaf(periode, codesNafGroupe13);
    boolean listeEmploiOK = testEmploiDansListe(periode, 11);
    
    return (origineOK) && (listeEmploiOK) && (codeNAFOK);
  }
  
  private boolean validerRealisateurCas14a(PeriodeActiviteSalarie periode)
  {
    boolean origineOK = origineAemOuAA13(periode);
    boolean codeNAFOK = validerCodeNaf(periode, codesNafGroupe14a);
    boolean listeEmploiOK = testEmploiDansListe(periode, 12);
    boolean estPriseEnCompteCertificationSociale = estPriseEnCompteCertificationSociale(periode);
    return (origineOK) && (listeEmploiOK) && (codeNAFOK) && (estPriseEnCompteCertificationSociale);
  }
  
  private boolean validerRealisateurCas14b(PeriodeActiviteSalarie periode)
  {
    boolean origineOK = origineAemOuAA13(periode);
    boolean codeNAFOK = validerCodeNaf(periode, codesNafGroupe14b);
    boolean listeEmploiOK = testEmploiDansListe(periode, 13);
    boolean presenceLabelOK = periode.getContratTravail().getLabelAEM();
    
    return (origineOK) && (listeEmploiOK) && (codeNAFOK) && (presenceLabelOK);
  }
  
  private boolean validerRealisateurCas15(PeriodeActiviteSalarie periode)
  {
    boolean origineOK = origineAemOuAA13(periode);
    boolean codeNAFOK = validerCodeNaf(periode, codesNafGroupe15);
    boolean listeEmploiOK = testEmploiDansListe(periode, 14);
    
    return (origineOK) && (listeEmploiOK) && (codeNAFOK);
  }
  
  private boolean validerRealisateurCas1617(PeriodeActiviteSalarie periode)
  {
    boolean origineOK = origineAemOuAA13(periode);
    boolean codeNAFOK = validerCodeNaf(periode, codesNafGroupe1617Cas1);
    boolean listeEmploiOK = testEmploiDansListe(periode, 15);
    boolean presenceLicenceOK = periode.getContratTravail().getLicenceAEM();
    boolean presenceCCSOK = periode.getContratTravail().getCCSAEM();
    boolean organisateurOccasSpe = periode.getContratTravail().isOrganisateurOccasionnelSpectacle();
    
    return (origineOK) && (listeEmploiOK) && (((codeNAFOK) && (presenceLicenceOK)) || ((presenceLicenceOK) && (presenceCCSOK)) || (organisateurOccasSpe));
  }
  
  private boolean validerRealisateurCas2627(PeriodeActiviteSalarie periode)
  {
    boolean origineOK = origineAemOuAA13(periode);
    boolean codeNAFOK = validerCodeNaf(periode, codesNafGroupe2627Cas1);
    boolean listeEmploiOK = testEmploiDansListe(periode, 22);
    boolean presenceLicenceOK = periode.getContratTravail().getLicenceAEM();
    boolean presenceCCSOK = periode.getContratTravail().getCCSAEM();
    boolean organisateurOccasSpe = periode.getContratTravail().isOrganisateurOccasionnelSpectacle();
    
    return (origineOK) && (listeEmploiOK) && (((codeNAFOK) && (presenceLicenceOK)) || ((presenceLicenceOK) && (presenceCCSOK)) || (organisateurOccasSpe));
  }
  
  private boolean validerRealisateurCas18(PeriodeActiviteSalarie periode)
  {
    boolean origineOK = origineAemOuAA13(periode);
    boolean codeNAFOK = validerCodeNaf(periode, codesNafGroupe18);
    boolean listeEmploiOK = testEmploiDansListe(periode, 16);
    
    return (origineOK) && (listeEmploiOK) && (codeNAFOK);
  }
  
  private boolean validerRealisateurCas19(PeriodeActiviteSalarie periode)
  {
    boolean origineOK = origineAemOuAA13(periode);
    boolean codeNAFOK = validerCodeNaf(periode, codesNafGroupe19);
    boolean listeEmploiOK = testEmploiDansListe(periode, 17);
    
    return (origineOK) && (listeEmploiOK) && (codeNAFOK);
  }
  
  private boolean validerRealisateurCas23(PeriodeActiviteSalarie periode)
  {
    boolean origineOK = origineAemOuAA13(periode);
    boolean codeNAFOK = validerCodeNaf(periode, codesNafGroupe23);
    boolean listeEmploiOK = testEmploiDansListe(periode, 18);
    
    return (origineOK) && (listeEmploiOK) && (codeNAFOK);
  }
  
  private boolean validerRealisateurCas31(PeriodeActiviteSalarie periode)
  {
    boolean origineOK = origineAemOuAA13(periode);
    boolean codeNAFOK = validerCodeNaf(periode, codesNafGroupe31);
    boolean listeEmploiOK = testEmploiDansListe(periode, 19);
    
    return (origineOK) && (listeEmploiOK) && (codeNAFOK);
  }
  
  private boolean validerRealisateurCas33(PeriodeActiviteSalarie periode)
  {
    boolean origineOK = origineAemOuAA13(periode);
    boolean codeNAFOK = validerCodeNaf(periode, codesNafGroupe33);
    boolean listeEmploiOK = testEmploiDansListe(periode, 20);
    
    return (origineOK) && (listeEmploiOK) && (codeNAFOK);
  }
  
  private boolean validerRealisateurCas22(PeriodeActiviteSalarie periode)
  {
    boolean origineOK = origineAemOuAA13(periode);
    boolean codeNAFOK = validerCodeNaf(periode, codesNafGroupe22);
    boolean listeEmploiOK = testEmploiDansListe(periode, 21);
    
    return (origineOK) && (listeEmploiOK) && (codeNAFOK);
  }
  
  private boolean validerCifCDD(PeriodeActiviteSalarie periode)
  {
    return (origineAA13OuAE(periode)) && ((testCategorieEmploiParticulierOuvrierTechnicienSpectacle(periode)) || (periode.getCategorieEmploiParticulier() == 43)) && (periode.getContratTypeParticulier() == 8);
  }
  
  private boolean validerAvecGuso(PeriodeActiviteSalarie periode)
  {
    boolean origineContratOK = origineFeuilletGuso(periode);
    boolean categorieEmploiPartOK = (periode.getCategorieEmploiParticulier() == 43) || (periode.getCategorieEmploiParticulier() == 39) || (periode.getCategorieEmploiParticulier() == 44);
    
    boolean listeEmploiOK = (testEmploiDansListe(periode, 7)) || (testEmploiDansListe(periode, 8)) || (testEmploiDansListe(periode, 13)) || (testEmploiDansListe(periode, 15)) || (testEmploiDansListe(periode, 22));
    
    boolean numeroGusoSurAffilEmployeurOK = StringUtils.isNotEmpty(periode.getEntreprise().getNumeroGuso());
    
    return (origineContratOK) && (categorieEmploiPartOK) && (listeEmploiOK) && (numeroGusoSurAffilEmployeurOK);
  }
  
  protected static boolean testEmploiDansListe(PeriodeActiviteSalarie periode, int constanteListeEmploi)
  {
    return periode.getMetier().getListeCategoriesEmploiSpe().contains(Integer.valueOf(constanteListeEmploi));
  }
  
  protected boolean testCategorieEmploiParticulierOuvrierTechnicienSpectacle(PeriodeActiviteSalarie periode)
  {
    switch (periode.getCategorieEmploiParticulier())
    {
    case 39: 
    case 44: 
      return true;
    }
    return false;
  }
  
  private boolean testTypeContratTravailCdd(PeriodeActiviteSalarie periode)
  {
    return periode.getContratTravail().getNature() == 2;
  }
  
  private boolean estPriseEnCompteCertificationSociale(PeriodeActiviteSalarie periode)
  {
    Damj dateDebutContrat = periode.getDateDebut();
    Damj dateConnaissanceInfo = periode.getDateConnaissanceInfo();
    try
    {
      GestionnaireDateApplication gestionnaire = GestionnaireDateApplication.getInstance();
      
      Damj dateApplicationCertificationDebutContrat = gestionnaire.recupererDateApplication("Prise en compte de la certification sociale des entreprise du spectacle : date début contrat");
      Damj dateApplicationCertificationConnaissanceInfo = gestionnaire.recupererDateApplication("Prise en compte de la certification sociale des entreprise du spectacle : date connaissance info");
      boolean estContextePriseEnCompteCertifSociale = (dateApplicationCertificationDebutContrat.estAvantOuCoincideAvec(dateDebutContrat)) && (dateApplicationCertificationConnaissanceInfo.estAvantOuCoincideAvec(dateConnaissanceInfo));
      if (estContextePriseEnCompteCertifSociale) {
        return periode.getEntreprise().isCertificationSocialeEntreprise();
      }
      return true;
    }
    catch (CoucheLogiqueException ex)
    {
      throw new ApplicativeRuntimeException(ex.getCode(), ex);
    }
  }
  
  protected static boolean equalsNotNull(Object o1, Object o2)
  {
    if (o1 == null) {
      return o2 == null;
    }
    if (o2 == null) {
      return false;
    }
    return o1.equals(o2);
  }
  
  protected static String toUpperCaseNotNull(String chaine)
  {
    if (chaine == null) {
      return "";
    }
    return chaine.toUpperCase();
  }
}

/* Location:
 * Qualified Name:     ValidationAnnexe8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */