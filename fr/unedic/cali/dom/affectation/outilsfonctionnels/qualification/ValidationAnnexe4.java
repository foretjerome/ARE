package fr.unedic.cali.dom.affectation.outilsfonctionnels.qualification;

import fr.unedic.cali.autresdoms.ga.dom.ContratTravail;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteSalarie;
import fr.unedic.cali.dom.affectation.outilsfonctionnels.qualification.abstraite.ValidationAnnexeAbstraite;
import java.util.Collection;

public class ValidationAnnexe4
  extends ValidationAnnexeAbstraite
{
  public boolean validerPeriode(PeriodeActiviteSalarie periode)
  {
    return (testNatureContratTravailCdd(periode)) && (testCategorieEmploiParticulier(periode)) && (testOriginePeriode(periode)) && (testPohf(periode));
  }
  
  protected boolean testOriginePeriode(PeriodeActiviteSalarie periode)
  {
    Collection<Integer> origines = periode.getCollectionOrigineInformationPAS();
    
    boolean estPeriodeOrigineAE = testOrigineAe(origines, periode.getDateConnaissanceInfo());
    boolean estPeriodeOrigineCrpCspCtp = testOrigineCrpCspCtp(origines);
    boolean estPeriodeOrigineMultiple = testOrigineMultiple(origines);
    boolean estPeriodeOrigineSpecifique = (origines.contains(Integer.valueOf(71))) || (origines.contains(Integer.valueOf(74))) || (origines.contains(Integer.valueOf(9))) || (origines.contains(Integer.valueOf(110)));
    
    return (estPeriodeOrigineAE) || (estPeriodeOrigineCrpCspCtp) || (estPeriodeOrigineMultiple) || (estPeriodeOrigineSpecifique);
  }
  
  private boolean testOrigineCrpCspCtp(Collection<Integer> origines)
  {
    return (origines.contains(Integer.valueOf(33))) || (origines.contains(Integer.valueOf(56))) || (origines.contains(Integer.valueOf(34)));
  }
  
  private boolean testOrigineMultiple(Collection<Integer> origines)
  {
    boolean estOrigineCTetBS = (origines.contains(Integer.valueOf(3))) && (origines.contains(Integer.valueOf(12)));
    
    boolean estOrigineCertifTravailEtBs = (origines.contains(Integer.valueOf(11))) && (origines.contains(Integer.valueOf(12)));
    
    boolean estOrigineCTetBSimporte = (origines.contains(Integer.valueOf(3))) && (origines.contains(Integer.valueOf(15)));
    
    boolean estOrigineCertifTravailEtBsImporte = (origines.contains(Integer.valueOf(11))) && (origines.contains(Integer.valueOf(15)));
    
    return (estOrigineCTetBS) || (estOrigineCertifTravailEtBs) || (estOrigineCTetBSimporte) || (estOrigineCertifTravailEtBsImporte);
  }
  
  private boolean testNatureContratTravailCdd(PeriodeActiviteSalarie periode)
  {
    return periode.getContratTravail().getNature() == 2;
  }
  
  protected boolean testCategorieEmploiParticulier(PeriodeActiviteSalarie periode)
  {
    switch (periode.getCategorieEmploiParticulier())
    {
    case 34: 
    case 35: 
    case 49: 
    case 52: 
      return true;
    }
    return false;
  }
  
  private boolean testPohf(PeriodeActiviteSalarie periode)
  {
    int pohf = periode.getContratTravail().getPohf();
    switch (pohf)
    {
    case 0: 
    case 1: 
    case 7: 
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     ValidationAnnexe4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */