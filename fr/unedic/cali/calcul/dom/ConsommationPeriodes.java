package fr.unedic.cali.calcul.dom;

import fr.unedic.util.temps.Periode;
import java.util.ArrayList;
import java.util.List;

public class ConsommationPeriodes
{
  private static List typesListe = new ArrayList();
  private transient Periode periodePmc;
  private transient Periode periodePreavisLegal;
  private transient Periode periodeDiffereStandard;
  private transient Periode periodeDiffereSpecifique;
  private transient Periode periodeDelaiAttente;
  private transient Periode periodeFranchiseCP;
  private transient Periode periodeFranchiseSalaire;
  
  static
  {
    typesListe.add(Integer.valueOf(0));
    typesListe.add(Integer.valueOf(4));
    typesListe.add(Integer.valueOf(1));
    typesListe.add(Integer.valueOf(2));
    typesListe.add(Integer.valueOf(3));
    typesListe.add(Integer.valueOf(5));
    typesListe.add(Integer.valueOf(6));
  }
  
  public ConsommationPeriodes()
  {
    periodePmc = null;
    periodePreavisLegal = null;
    periodeDiffereStandard = null;
    periodeDiffereSpecifique = null;
    periodeDelaiAttente = null;
    periodeFranchiseCP = null;
    periodeFranchiseSalaire = null;
  }
  
  public Periode getPeriodesParTypologie(int type)
  {
    Periode result = null;
    switch (type)
    {
    case 0: 
      result = getPeriodePmc();
      break;
    case 4: 
      result = getPeriodePreavisLegal();
      break;
    case 1: 
      result = getPeriodeDiffereStandard();
      break;
    case 2: 
      result = getPeriodeDiffereSpecifique();
      break;
    case 5: 
      result = getPeriodeFranchiseCP();
      break;
    case 6: 
      result = getPeriodeFranchiseSalaire();
      break;
    case 3: 
      result = getPeriodeDelaiAttente();
    }
    return result;
  }
  
  public static List getTypesList()
  {
    return typesListe;
  }
  
  public Periode getPeriodePmc()
  {
    return periodePmc;
  }
  
  public Periode getPeriodeDiffereStandard()
  {
    return periodeDiffereStandard;
  }
  
  public Periode getPeriodeDiffereSpecifique()
  {
    return periodeDiffereSpecifique;
  }
  
  public Periode getPeriodeDelaiAttente()
  {
    return periodeDelaiAttente;
  }
  
  public Periode getPeriodePreavisLegal()
  {
    return periodePreavisLegal;
  }
  
  public void setPeriodePmc(Periode periodePmc)
  {
    this.periodePmc = periodePmc;
  }
  
  public void setPeriodeDiffereStandard(Periode periodeDiffereStandard)
  {
    this.periodeDiffereStandard = periodeDiffereStandard;
  }
  
  public void setPeriodeDiffereSpecifique(Periode periodeDiffereSpecifique)
  {
    this.periodeDiffereSpecifique = periodeDiffereSpecifique;
  }
  
  public void setPeriodeDelaiAttente(Periode periodeDelaiAttente)
  {
    this.periodeDelaiAttente = periodeDelaiAttente;
  }
  
  public void setPeriodePreavisLegal(Periode periodePreavisLegal)
  {
    this.periodePreavisLegal = periodePreavisLegal;
  }
  
  public Periode getPeriodeFranchiseCP()
  {
    return periodeFranchiseCP;
  }
  
  public void setPeriodeFranchiseCP(Periode periodeFranchiseCP)
  {
    this.periodeFranchiseCP = periodeFranchiseCP;
  }
  
  public Periode getPeriodeFranchiseSalaire()
  {
    return periodeFranchiseSalaire;
  }
  
  public void setPeriodeFranchiseSalaire(Periode periodeFranchiseSalaire)
  {
    this.periodeFranchiseSalaire = periodeFranchiseSalaire;
  }
  
  public void setPeriodesParTypologie(int periodeType, Periode periode)
  {
    switch (periodeType)
    {
    case 0: 
      setPeriodePmc(periode);
      break;
    case 4: 
      setPeriodePreavisLegal(periode);
      break;
    case 1: 
      setPeriodeDiffereStandard(periode);
      break;
    case 2: 
      setPeriodeDiffereSpecifique(periode);
      break;
    case 5: 
      setPeriodeFranchiseCP(periode);
      break;
    case 6: 
      setPeriodeFranchiseSalaire(periode);
      break;
    case 3: 
      setPeriodeDelaiAttente(periode);
    }
  }
}

/* Location:
 * Qualified Name:     ConsommationPeriodes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */