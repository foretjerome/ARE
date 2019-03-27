package fr.unedic.cali.dom.affectation.outilsfonctionnels.qualification;

import fr.unedic.cali.autresdoms.ga.dom.ContratTravail;
import fr.unedic.cali.autresdoms.ga.dom.Entreprise;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteSalarie;
import fr.unedic.cali.dom.affectation.outilsfonctionnels.qualification.idcc.CoupleValidationIDCC;
import fr.unedic.cali.dom.affectation.outilsfonctionnels.qualification.idcc.ValidationIDCC;
import java.util.ArrayList;
import java.util.HashSet;

public class ValidationAnnexe8Convention2016AvecIDCC
  extends ValidationAnnexe8
{
  private static final ValidationAnnexe10Convention2016 VALIDATION_A10 = new ValidationAnnexe10Convention2016();
  private static String codeNaf1820Z = "1820Z";
  private static ArrayList<String> listeCodeNaf1820Z = new ArrayList();
  private static HashSet<CoupleValidationIDCC> listeCoupleIdccEligible = new HashSet();
  private static HashSet<ValidationIDCC> idccEmpListe31 = new HashSet(2);
  private static HashSet<ValidationIDCC> idccPrestListe31 = new HashSet(1);
  private static HashSet<ValidationIDCC> idccEmpListe22 = new HashSet(1);
  private static HashSet<ValidationIDCC> idccPrestListe22 = new HashSet(1);
  private static HashSet<ValidationIDCC> idccEmpListe33 = new HashSet(1);
  private static HashSet<ValidationIDCC> idccPrestListe33 = new HashSet(1);
  private static HashSet<ValidationIDCC> idccEmpListe24a = new HashSet(1);
  private static HashSet<ValidationIDCC> idccPrestListe24a = new HashSet(1);
  private static HashSet<ValidationIDCC> idccEmpListe24b = new HashSet(1);
  private static HashSet<ValidationIDCC> idccEmpListe15 = new HashSet(4);
  private static HashSet<ValidationIDCC> idccEmpListe15Realisateur = new HashSet(4);
  private static HashSet<ValidationIDCC> idccEmpListe2627Cas1 = new HashSet(2);
  private static HashSet<ValidationIDCC> idccPrestListe2627Cas1 = new HashSet(2);
  private static HashSet<ValidationIDCC> idccEmpNonAutoriseListe2627Cas2 = new HashSet(1);
  private static HashSet<ValidationIDCC> idccEmpListe2627Cas4 = new HashSet(4);
  private static HashSet<ValidationIDCC> idccEmpListe2627Cas5 = new HashSet(1);
  private static HashSet<ValidationIDCC> idccEmpListe10 = new HashSet(2);
  private static HashSet<ValidationIDCC> idccPrestListe10 = new HashSet(1);
  private static HashSet<ValidationIDCC> idccEmpListe29 = new HashSet(7);
  private static HashSet<ValidationIDCC> idccPrestListe29 = new HashSet(1);
  
  static
  {
    listeCodeNaf1820Z.add(codeNaf1820Z);
    
    listeCoupleIdccEligible.add(new CoupleValidationIDCC(new ValidationIDCC("3097"), new ValidationIDCC("2642")));
    listeCoupleIdccEligible.add(new CoupleValidationIDCC(new ValidationIDCC("2412"), new ValidationIDCC("2642")));
    listeCoupleIdccEligible.add(new CoupleValidationIDCC(new ValidationIDCC("2717", true, false, listeCodeNaf1820Z), new ValidationIDCC("2642")));
    
    listeCoupleIdccEligible.add(new CoupleValidationIDCC(new ValidationIDCC("2642"), new ValidationIDCC("3097")));
    listeCoupleIdccEligible.add(new CoupleValidationIDCC(new ValidationIDCC("2642"), new ValidationIDCC("2770")));
    listeCoupleIdccEligible.add(new CoupleValidationIDCC(new ValidationIDCC("2642"), new ValidationIDCC("2717", true, false)));
    listeCoupleIdccEligible.add(new CoupleValidationIDCC(new ValidationIDCC("3097"), new ValidationIDCC("2717", true, false)));
    
    listeCoupleIdccEligible.add(new CoupleValidationIDCC(new ValidationIDCC("2717", false, true), new ValidationIDCC("1285")));
    listeCoupleIdccEligible.add(new CoupleValidationIDCC(new ValidationIDCC("2717", false, true), new ValidationIDCC("3090")));
    
    listeCoupleIdccEligible.add(new CoupleValidationIDCC(new ValidationIDCC("2642"), new ValidationIDCC("2411")));
    listeCoupleIdccEligible.add(new CoupleValidationIDCC(new ValidationIDCC("2642"), new ValidationIDCC("2412")));
    listeCoupleIdccEligible.add(new CoupleValidationIDCC(new ValidationIDCC("3097"), new ValidationIDCC("2412")));
    listeCoupleIdccEligible.add(new CoupleValidationIDCC(new ValidationIDCC("2717", true, false, listeCodeNaf1820Z), new ValidationIDCC("2412")));
    
    idccEmpListe31.add(new ValidationIDCC("2642"));
    idccEmpListe31.add(new ValidationIDCC("5582"));
    idccPrestListe31.add(new ValidationIDCC("2642"));
    
    idccEmpListe22.add(new ValidationIDCC("3097"));
    idccPrestListe22.add(new ValidationIDCC("3097"));
    
    idccEmpListe33.add(new ValidationIDCC("2770"));
    idccPrestListe33.add(new ValidationIDCC("2770"));
    
    idccEmpListe24a.add(new ValidationIDCC("2717", true, false, listeCodeNaf1820Z));
    idccPrestListe24a.add(new ValidationIDCC("2717", true, false, listeCodeNaf1820Z));
    
    idccEmpListe24b.add(new ValidationIDCC("2717"));
    
    idccEmpListe15.add(new ValidationIDCC("1922"));
    idccEmpListe15.add(new ValidationIDCC("5580"));
    idccEmpListe15.add(new ValidationIDCC("6705"));
    idccEmpListe15.add(new ValidationIDCC("6759"));
    
    idccEmpListe15Realisateur.add(new ValidationIDCC("1922"));
    idccEmpListe15Realisateur.add(new ValidationIDCC("5580"));
    idccEmpListe15Realisateur.add(new ValidationIDCC("6705"));
    idccEmpListe15Realisateur.add(new ValidationIDCC("6759"));
    
    idccEmpListe2627Cas1.add(new ValidationIDCC("1285", false, true));
    idccEmpListe2627Cas1.add(new ValidationIDCC("3090", false, true));
    
    idccPrestListe2627Cas1.add(new ValidationIDCC("1285", false, true));
    idccPrestListe2627Cas1.add(new ValidationIDCC("3090", false, true));
    
    idccEmpNonAutoriseListe2627Cas2.add(new ValidationIDCC("1790"));
    
    idccEmpListe2627Cas4.add(new ValidationIDCC("5569"));
    idccEmpListe2627Cas4.add(new ValidationIDCC("5570"));
    idccEmpListe2627Cas4.add(new ValidationIDCC("5580"));
    idccEmpListe2627Cas4.add(new ValidationIDCC("6767"));
    
    idccEmpListe2627Cas5.add(new ValidationIDCC("1790", false, true));
    
    idccEmpListe10.add(new ValidationIDCC("2412"));
    idccEmpListe10.add(new ValidationIDCC("5582"));
    
    idccPrestListe10.add(new ValidationIDCC("2412"));
    
    idccEmpListe29.add(new ValidationIDCC("2411"));
    idccEmpListe29.add(new ValidationIDCC("5579"));
    idccEmpListe29.add(new ValidationIDCC("5565"));
    idccEmpListe29.add(new ValidationIDCC("5574"));
    idccEmpListe29.add(new ValidationIDCC("5575"));
    idccEmpListe29.add(new ValidationIDCC("6759"));
    idccEmpListe29.add(new ValidationIDCC("6709"));
    
    idccPrestListe29.add(new ValidationIDCC("2411"));
  }
  
  public boolean validerPeriode(PeriodeActiviteSalarie periode)
  {
    return (!VALIDATION_A10.validerRealisateur(periode)) && (super.validerPeriode(periode));
  }
  
  protected boolean validerRealisateur(PeriodeActiviteSalarie periode)
  {
    return (periode.getCategorieEmploiParticulier() == 43) && ((validerRealisateurListe31(periode)) || (validerRealisateurListe22(periode)) || (validerRealisateurListe33(periode)) || (validerRealisateurListe15(periode)) || (validerRealisateurListe2627(periode)) || (validerRealisateurListe10(periode)) || (validerRealisateurListe29(periode)));
  }
  
  protected boolean validerGroupeOuvrierTechnicienSpectacle(PeriodeActiviteSalarie periode)
  {
    return (validerOuvrierTechnicienSpectacleListe31(periode)) || (validerOuvrierTechnicienSpectacleListe22(periode)) || (validerOuvrierTechnicienSpectacleListe33(periode)) || (validerOuvrierTechnicienSpectacleListe24a(periode)) || (validerOuvrierTechnicienSpectacleListe24b(periode)) || (validerOuvrierTechnicienSpectacleListe15(periode)) || (validerOuvrierTechnicienSpectacleListe2627(periode)) || (validerOuvrierTechnicienSpectacleListe10(periode)) || (validerOuvrierTechnicienSpectacleListe29(periode));
  }
  
  private boolean validerOuvrierTechnicienSpectacleListe31(PeriodeActiviteSalarie periode)
  {
    return (origineAemOuAA13(periode)) && (validerIDCC(periode.getContratTravail().getIdccEmployeur(), periode.getContratTravail().getIdccPrestataire(), idccEmpListe31, idccPrestListe31, periode.getEntreprise().getCodeNAF(), periode.getEntreprise().isCertificationSocialeEntreprise(), periode.getContratTravail().getLicenceAEM())) && (testEmploiDansListe(periode, 19));
  }
  
  private boolean validerOuvrierTechnicienSpectacleListe22(PeriodeActiviteSalarie periode)
  {
    return (origineAemOuAA13(periode)) && (validerIDCC(periode.getContratTravail().getIdccEmployeur(), periode.getContratTravail().getIdccPrestataire(), idccEmpListe22, idccPrestListe22, periode.getEntreprise().getCodeNAF(), periode.getEntreprise().isCertificationSocialeEntreprise(), periode.getContratTravail().getLicenceAEM())) && (testEmploiDansListe(periode, 21));
  }
  
  private boolean validerOuvrierTechnicienSpectacleListe33(PeriodeActiviteSalarie periode)
  {
    return (origineAemOuAA13(periode)) && (validerIDCC(periode.getContratTravail().getIdccEmployeur(), periode.getContratTravail().getIdccPrestataire(), idccEmpListe33, idccPrestListe33, periode.getEntreprise().getCodeNAF(), periode.getEntreprise().isCertificationSocialeEntreprise(), periode.getContratTravail().getLicenceAEM())) && (testEmploiDansListe(periode, 20));
  }
  
  private boolean validerOuvrierTechnicienSpectacleListe24a(PeriodeActiviteSalarie periode)
  {
    return (origineAemOuAA13(periode)) && (validerIDCC(periode.getContratTravail().getIdccEmployeur(), periode.getContratTravail().getIdccPrestataire(), idccEmpListe24a, idccPrestListe24a, periode.getEntreprise().getCodeNAF(), periode.getEntreprise().isCertificationSocialeEntreprise(), periode.getContratTravail().getLicenceAEM())) && (periode.getEntreprise().isCertificationSocialeEntreprise()) && (testEmploiDansListe(periode, 24));
  }
  
  private boolean validerOuvrierTechnicienSpectacleListe24b(PeriodeActiviteSalarie periode)
  {
    return (origineAemOuAA13(periode)) && (validerIDCC(periode.getContratTravail().getIdccEmployeur(), periode.getContratTravail().getIdccPrestataire(), idccEmpListe24b, null, periode.getEntreprise().getCodeNAF(), periode.getEntreprise().isCertificationSocialeEntreprise(), periode.getContratTravail().getLicenceAEM())) && (testEmploiDansListe(periode, 23)) && (periode.getContratTravail().getLabelAEM());
  }
  
  private boolean validerOuvrierTechnicienSpectacleListe15(PeriodeActiviteSalarie periode)
  {
    return (origineAemOuAA13(periode)) && (validerIDCC(periode.getContratTravail().getIdccEmployeur(), periode.getContratTravail().getIdccPrestataire(), idccEmpListe15, null, periode.getEntreprise().getCodeNAF(), periode.getEntreprise().isCertificationSocialeEntreprise(), periode.getContratTravail().getLicenceAEM())) && (testEmploiDansListe(periode, 14));
  }
  
  private boolean validerOuvrierTechnicienSpectacleListe2627(PeriodeActiviteSalarie periode)
  {
    return (validerOuvrierTechnicienSpectacleListe2627Cas1(periode)) || (validerOuvrierTechnicienSpectacleListe2627Cas2(periode)) || (validerOuvrierTechnicienSpectacleListe2627Cas3(periode)) || (validerOuvrierTechnicienSpectacleListe2627Cas4(periode)) || (validerOuvrierTechnicienSpectacleListe2627Cas5(periode));
  }
  
  private boolean validerOuvrierTechnicienSpectacleListe2627Cas1(PeriodeActiviteSalarie periode)
  {
    return (origineAemOuAA13(periode)) && (validerIDCC(periode.getContratTravail().getIdccEmployeur(), periode.getContratTravail().getIdccPrestataire(), idccEmpListe2627Cas1, idccPrestListe2627Cas1, periode.getEntreprise().getCodeNAF(), periode.getEntreprise().isCertificationSocialeEntreprise(), periode.getContratTravail().getLicenceAEM())) && (testEmploiDansListe(periode, 22)) && (periode.getContratTravail().getLicenceAEM());
  }
  
  private boolean validerOuvrierTechnicienSpectacleListe2627Cas2(PeriodeActiviteSalarie periode)
  {
    boolean estLicenceEtCCS = (periode.getContratTravail().getLicenceAEM()) && (periode.getContratTravail().getCCSAEM());
    
    return (origineAemOuAA13(periode)) && (!validerIDCC(periode.getContratTravail().getIdccEmployeur(), periode.getContratTravail().getIdccPrestataire(), idccEmpNonAutoriseListe2627Cas2, null, periode.getEntreprise().getCodeNAF(), periode.getEntreprise().isCertificationSocialeEntreprise(), periode.getContratTravail().getLicenceAEM())) && (testEmploiDansListe(periode, 22)) && (estLicenceEtCCS);
  }
  
  private boolean validerOuvrierTechnicienSpectacleListe2627Cas3(PeriodeActiviteSalarie periode)
  {
    boolean estOOS = periode.getContratTravail().isOrganisateurOccasionnelSpectacle();
    return (origineAemOuAA13(periode)) && (testEmploiDansListe(periode, 22)) && (estOOS);
  }
  
  private boolean validerOuvrierTechnicienSpectacleListe2627Cas4(PeriodeActiviteSalarie periode)
  {
    return (origineAemOuAA13(periode)) && (validerIDCC(periode.getContratTravail().getIdccEmployeur(), periode.getContratTravail().getIdccPrestataire(), idccEmpListe2627Cas4, null, periode.getEntreprise().getCodeNAF(), periode.getEntreprise().isCertificationSocialeEntreprise(), periode.getContratTravail().getLicenceAEM())) && (testEmploiDansListe(periode, 22));
  }
  
  private boolean validerOuvrierTechnicienSpectacleListe2627Cas5(PeriodeActiviteSalarie periode)
  {
    boolean estLicenseEtCcs = (periode.getContratTravail().getLicenceAEM()) && (periode.getContratTravail().getCCSAEM());
    return (origineAemOuAA13(periode)) && (validerIDCC(periode.getContratTravail().getIdccEmployeur(), periode.getContratTravail().getIdccPrestataire(), idccEmpListe2627Cas5, null, periode.getEntreprise().getCodeNAF(), periode.getEntreprise().isCertificationSocialeEntreprise(), periode.getContratTravail().getLicenceAEM())) && (testEmploiDansListe(periode, 22)) && (estLicenseEtCcs);
  }
  
  private boolean validerOuvrierTechnicienSpectacleListe10(PeriodeActiviteSalarie periode)
  {
    return (origineAemOuAA13(periode)) && (validerIDCC(periode.getContratTravail().getIdccEmployeur(), periode.getContratTravail().getIdccPrestataire(), idccEmpListe10, idccPrestListe10, periode.getEntreprise().getCodeNAF(), periode.getEntreprise().isCertificationSocialeEntreprise(), periode.getContratTravail().getLicenceAEM())) && (testEmploiDansListe(periode, 25));
  }
  
  private boolean validerOuvrierTechnicienSpectacleListe29(PeriodeActiviteSalarie periode)
  {
    return (origineAemOuAA13(periode)) && (validerIDCC(periode.getContratTravail().getIdccEmployeur(), periode.getContratTravail().getIdccPrestataire(), idccEmpListe29, idccPrestListe29, periode.getEntreprise().getCodeNAF(), periode.getEntreprise().isCertificationSocialeEntreprise(), periode.getContratTravail().getLicenceAEM())) && (testEmploiDansListe(periode, 26));
  }
  
  private boolean validerRealisateurListe31(PeriodeActiviteSalarie periode)
  {
    boolean origineOK = origineAemOuAA13(periode);
    boolean codeIDCCOK = validerIDCC(periode.getContratTravail().getIdccEmployeur(), periode.getContratTravail().getIdccPrestataire(), idccEmpListe31, idccPrestListe31, periode.getEntreprise().getCodeNAF(), periode.getEntreprise().isCertificationSocialeEntreprise(), periode.getContratTravail().getLicenceAEM());
    
    boolean listeEmploiOK = testEmploiDansListe(periode, 19);
    
    return (origineOK) && (codeIDCCOK) && (listeEmploiOK);
  }
  
  private boolean validerRealisateurListe22(PeriodeActiviteSalarie periode)
  {
    boolean origineOK = origineAemOuAA13(periode);
    boolean codeIDCCOK = validerIDCC(periode.getContratTravail().getIdccEmployeur(), periode.getContratTravail().getIdccPrestataire(), idccEmpListe22, idccPrestListe22, periode.getEntreprise().getCodeNAF(), periode.getEntreprise().isCertificationSocialeEntreprise(), periode.getContratTravail().getLicenceAEM());
    
    boolean listeEmploiOK = testEmploiDansListe(periode, 21);
    
    return (origineOK) && (codeIDCCOK) && (listeEmploiOK);
  }
  
  private boolean validerRealisateurListe33(PeriodeActiviteSalarie periode)
  {
    boolean origineOK = origineAemOuAA13(periode);
    boolean codeIDCCOK = validerIDCC(periode.getContratTravail().getIdccEmployeur(), periode.getContratTravail().getIdccPrestataire(), idccEmpListe33, idccPrestListe33, periode.getEntreprise().getCodeNAF(), periode.getEntreprise().isCertificationSocialeEntreprise(), periode.getContratTravail().getLicenceAEM());
    
    boolean listeEmploiOK = testEmploiDansListe(periode, 20);
    
    return (origineOK) && (codeIDCCOK) && (listeEmploiOK);
  }
  
  private boolean validerRealisateurListe15(PeriodeActiviteSalarie periode)
  {
    boolean origineOK = origineAemOuAA13(periode);
    boolean codeIDCCOK = validerIDCC(periode.getContratTravail().getIdccEmployeur(), periode.getContratTravail().getIdccPrestataire(), idccEmpListe15Realisateur, null, periode.getEntreprise().getCodeNAF(), periode.getEntreprise().isCertificationSocialeEntreprise(), periode.getContratTravail().getLicenceAEM());
    
    boolean listeEmploiOK = testEmploiDansListe(periode, 14);
    
    return (origineOK) && (codeIDCCOK) && (listeEmploiOK);
  }
  
  private boolean validerRealisateurListe2627(PeriodeActiviteSalarie periode)
  {
    return (validerRealisateurListe2627Cas1(periode)) || (validerRealisateurListe2627Cas2(periode)) || (validerRealisateurListe2627Cas3(periode)) || (validerRealisateurListe2627Cas4(periode)) || (validerRealisateurListe2627Cas5(periode));
  }
  
  private boolean validerRealisateurListe2627Cas1(PeriodeActiviteSalarie periode)
  {
    boolean origineOK = origineAemOuAA13(periode);
    boolean codeIDCCOK = validerIDCC(periode.getContratTravail().getIdccEmployeur(), periode.getContratTravail().getIdccPrestataire(), idccEmpListe2627Cas1, idccPrestListe2627Cas1, periode.getEntreprise().getCodeNAF(), periode.getEntreprise().isCertificationSocialeEntreprise(), periode.getContratTravail().getLicenceAEM());
    
    boolean listeEmploiOK = testEmploiDansListe(periode, 22);
    boolean estLicenseAEM = periode.getContratTravail().getLicenceAEM();
    
    return (origineOK) && (codeIDCCOK) && (listeEmploiOK) && (estLicenseAEM);
  }
  
  private boolean validerRealisateurListe2627Cas2(PeriodeActiviteSalarie periode)
  {
    boolean origineOK = origineAemOuAA13(periode);
    boolean codeIDCCOK = !validerIDCC(periode.getContratTravail().getIdccEmployeur(), periode.getContratTravail().getIdccPrestataire(), idccEmpNonAutoriseListe2627Cas2, null, periode.getEntreprise().getCodeNAF(), periode.getEntreprise().isCertificationSocialeEntreprise(), periode.getContratTravail().getLicenceAEM());
    
    boolean listeEmploiOK = testEmploiDansListe(periode, 22);
    boolean estLicenseEtCcs = (periode.getContratTravail().getLicenceAEM()) && (periode.getContratTravail().getCCSAEM());
    
    return (origineOK) && (codeIDCCOK) && (listeEmploiOK) && (estLicenseEtCcs);
  }
  
  private boolean validerRealisateurListe2627Cas3(PeriodeActiviteSalarie periode)
  {
    boolean origineOK = origineAemOuAA13(periode);
    boolean codeIDCCOK = true;
    boolean listeEmploiOK = testEmploiDansListe(periode, 22);
    boolean estOOS = periode.getContratTravail().isOrganisateurOccasionnelSpectacle();
    
    return (origineOK) && (codeIDCCOK) && (listeEmploiOK) && (estOOS);
  }
  
  private boolean validerRealisateurListe2627Cas4(PeriodeActiviteSalarie periode)
  {
    boolean origineOK = origineAemOuAA13(periode);
    boolean codeIDCCOK = validerIDCC(periode.getContratTravail().getIdccEmployeur(), periode.getContratTravail().getIdccPrestataire(), idccEmpListe2627Cas4, null, periode.getEntreprise().getCodeNAF(), periode.getEntreprise().isCertificationSocialeEntreprise(), periode.getContratTravail().getLicenceAEM());
    
    boolean listeEmploiOK = testEmploiDansListe(periode, 22);
    
    return (origineOK) && (codeIDCCOK) && (listeEmploiOK);
  }
  
  private boolean validerRealisateurListe2627Cas5(PeriodeActiviteSalarie periode)
  {
    boolean origineOK = origineAemOuAA13(periode);
    boolean codeIDCCOK = validerIDCC(periode.getContratTravail().getIdccEmployeur(), periode.getContratTravail().getIdccPrestataire(), idccEmpListe2627Cas5, null, periode.getEntreprise().getCodeNAF(), periode.getEntreprise().isCertificationSocialeEntreprise(), periode.getContratTravail().getLicenceAEM());
    
    boolean listeEmploiOK = testEmploiDansListe(periode, 22);
    
    boolean estLicenseEtCcs = (periode.getContratTravail().getLicenceAEM()) && (periode.getContratTravail().getCCSAEM());
    
    return (origineOK) && (codeIDCCOK) && (listeEmploiOK) && (estLicenseEtCcs);
  }
  
  private boolean validerRealisateurListe10(PeriodeActiviteSalarie periode)
  {
    boolean origineOK = origineAemOuAA13(periode);
    boolean codeIDCCOK = validerIDCC(periode.getContratTravail().getIdccEmployeur(), periode.getContratTravail().getIdccPrestataire(), idccEmpListe10, idccPrestListe10, periode.getEntreprise().getCodeNAF(), periode.getEntreprise().isCertificationSocialeEntreprise(), periode.getContratTravail().getLicenceAEM());
    
    boolean listeEmploiOK = testEmploiDansListe(periode, 25);
    
    return (origineOK) && (codeIDCCOK) && (listeEmploiOK);
  }
  
  private boolean validerRealisateurListe29(PeriodeActiviteSalarie periode)
  {
    boolean origineOK = origineAemOuAA13(periode);
    boolean codeIDCCOK = validerIDCC(periode.getContratTravail().getIdccEmployeur(), periode.getContratTravail().getIdccPrestataire(), idccEmpListe29, idccPrestListe29, periode.getEntreprise().getCodeNAF(), periode.getEntreprise().isCertificationSocialeEntreprise(), periode.getContratTravail().getLicenceAEM());
    
    boolean listeEmploiOK = testEmploiDansListe(periode, 26);
    
    return (origineOK) && (codeIDCCOK) && (listeEmploiOK);
  }
  
  protected boolean validerIDCC(String idccEmployeurPeriode, String idccPrestationPeriode, HashSet<ValidationIDCC> idccEmployeurAutorise, HashSet<ValidationIDCC> idccPrestataireAutorise, String codeNaf, boolean estCertifSociale, boolean estLicence)
  {
    boolean estValide = false;
    for (ValidationIDCC idccListe : idccEmployeurAutorise)
    {
      estValide = idccListe.validerIdcc(idccEmployeurPeriode, estCertifSociale, estLicence, codeNaf);
      if (estValide) {
        break;
      }
    }
    if ((idccPrestataireAutorise != null) && (!estValide) && (estCoupleEligibleClauseMiroir(idccEmployeurPeriode, idccPrestationPeriode, codeNaf, estCertifSociale, estLicence))) {
      for (ValidationIDCC idccPrestataireListe : idccPrestataireAutorise)
      {
        estValide = idccPrestataireListe.validerIdcc(idccPrestationPeriode, estCertifSociale, estLicence, codeNaf);
        if (estValide) {
          break;
        }
      }
    }
    return estValide;
  }
  
  protected boolean estCoupleEligibleClauseMiroir(String iddcE, String idccP, String codeNaf, boolean estCertifSociale, boolean estLicence)
  {
    boolean estCoupleEligible = false;
    for (CoupleValidationIDCC couple : listeCoupleIdccEligible)
    {
      estCoupleEligible = couple.validerPeriode(iddcE, idccP, estCertifSociale, estLicence, codeNaf);
      if (estCoupleEligible) {
        break;
      }
    }
    return estCoupleEligible;
  }
}

/* Location:
 * Qualified Name:     ValidationAnnexe8Convention2016AvecIDCC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */