package fr.unedic.cali.dom.affectation.outilsfonctionnels.qualification;

import fr.unedic.cali.autresdoms.ga.dom.ContratTravail;
import fr.unedic.cali.autresdoms.ga.dom.Entreprise;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteSalarie;
import java.util.HashSet;
import java.util.Set;

public class ValidationAnnexe8Convention2016AvecNaf
  extends ValidationAnnexe8
{
  private static final ValidationAnnexe10Convention2016 VALIDATION_A10 = new ValidationAnnexe10Convention2016();
  private static Set<String> codesNafGroupe24b = new HashSet(1, 1.0F);
  private static Set<String> codesNafGroupe24a = new HashSet(3, 1.0F);
  private static Set<String> codesNafGroupe10 = new HashSet(5, 1.0F);
  private static Set<String> codesNafGroupe29 = new HashSet(2, 1.0F);
  
  static
  {
    codesNafGroupe24b.add("9002Z");
    codesNafGroupe24a.add("5911C");
    codesNafGroupe24a.add("5912Z");
    codesNafGroupe24a.add("5920Z");
    
    codesNafGroupe10.add("5911A");
    codesNafGroupe10.add("5911B");
    codesNafGroupe10.add("5911C");
    codesNafGroupe10.add("5912Z");
    codesNafGroupe10.add("5920Z");
    
    codesNafGroupe29.add("6020A");
    codesNafGroupe29.add("6020B");
  }
  
  public boolean validerPeriode(PeriodeActiviteSalarie periode)
  {
    return (!VALIDATION_A10.validerRealisateur(periode)) && (super.validerPeriode(periode));
  }
  
  protected boolean validerGroupeOuvrierTechnicienSpectacle(PeriodeActiviteSalarie periode)
  {
    return (super.validerGroupeOuvrierTechnicienSpectacle(periode)) || (validerGroupe24b(periode)) || (validerGroupe24a(periode)) || (validerGroupe29(periode)) || (validerGroupe10(periode));
  }
  
  protected boolean validerRealisateur(PeriodeActiviteSalarie periode)
  {
    return (super.validerRealisateur(periode)) || ((periode.getCategorieEmploiParticulier() == 43) && ((validerRealisateurCas10(periode)) || (validerRealisateurCas29(periode))));
  }
  
  private boolean validerGroupe24b(PeriodeActiviteSalarie periode)
  {
    return (origineAemOuAA13(periode)) && (validerCodeNaf(periode, codesNafGroupe24b)) && (periode.getContratTravail().getLabelAEM()) && (testEmploiDansListe(periode, 23));
  }
  
  private boolean validerGroupe24a(PeriodeActiviteSalarie periode)
  {
    return (origineAemOuAA13(periode)) && (validerCodeNaf(periode, codesNafGroupe24a)) && (periode.getEntreprise().isCertificationSocialeEntreprise()) && (testEmploiDansListe(periode, 24));
  }
  
  private boolean validerRealisateurCas10(PeriodeActiviteSalarie periode)
  {
    boolean origineOK = origineAemOuAA13(periode);
    boolean codeNAFOK = validerCodeNaf(periode, codesNafGroupe10);
    boolean listeEmploiOK = testEmploiDansListe(periode, 25);
    return (origineOK) && (listeEmploiOK) && (codeNAFOK);
  }
  
  private boolean validerRealisateurCas29(PeriodeActiviteSalarie periode)
  {
    boolean origineOK = origineAemOuAA13(periode);
    boolean codeNAFOK = validerCodeNaf(periode, codesNafGroupe29);
    boolean listeEmploiOK = testEmploiDansListe(periode, 26);
    return (origineOK) && (listeEmploiOK) && (codeNAFOK);
  }
  
  private boolean validerGroupe10(PeriodeActiviteSalarie periode)
  {
    return (origineAemOuAA13(periode)) && (validerCodeNaf(periode, codesNafGroupe10)) && (testEmploiDansListe(periode, 25));
  }
  
  private boolean validerGroupe29(PeriodeActiviteSalarie periode)
  {
    return (origineAemOuAA13(periode)) && (validerCodeNaf(periode, codesNafGroupe29)) && (testEmploiDansListe(periode, 26));
  }
}

/* Location:
 * Qualified Name:     ValidationAnnexe8Convention2016AvecNaf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */