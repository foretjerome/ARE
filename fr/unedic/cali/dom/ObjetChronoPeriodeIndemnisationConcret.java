package fr.unedic.cali.dom;

import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriodeConcrete;
import fr.unedic.util.temps.Periode;

public class ObjetChronoPeriodeIndemnisationConcret
  extends ObjetChronoPeriodeConcrete
{
  private static final long serialVersionUID = 1L;
  ProduitSpec produitAssociePeriode;
  String codeSousProduitAssociePeriode;
  
  public ObjetChronoPeriodeIndemnisationConcret() {}
  
  public ObjetChronoPeriodeIndemnisationConcret(Periode periode)
  {
    super(periode);
  }
  
  public ObjetChronoPeriodeIndemnisationConcret(Damj dateDebut, Damj dateFin)
  {
    super(dateDebut, dateFin);
  }
  
  public ObjetChronoPeriodeIndemnisationConcret(Damj dateDebut, Damj dateFin, ProduitSpec produitAssocie)
  {
    super(dateDebut, dateFin);
    setProduitAssociePeriode(produitAssocie);
  }
  
  public ObjetChronoPeriodeIndemnisationConcret(Damj dateDebut, Damj dateFin, ProduitSpec produitAssocie, String codeSousProduitAssociePeriode)
  {
    super(dateDebut, dateFin);
    setProduitAssociePeriode(produitAssocie);
    setCodeSousProduitAssociePeriode(codeSousProduitAssociePeriode);
  }
  
  public ProduitSpec getProduitAssociePeriode()
  {
    return produitAssociePeriode;
  }
  
  public void setProduitAssociePeriode(ProduitSpec produitAssociePeriode)
  {
    this.produitAssociePeriode = produitAssociePeriode;
  }
  
  public String getCodeSousProduitAssociePeriode()
  {
    return codeSousProduitAssociePeriode;
  }
  
  public void setCodeSousProduitAssociePeriode(String codeSousProduitAssociePeriode)
  {
    this.codeSousProduitAssociePeriode = codeSousProduitAssociePeriode;
  }
}

/* Location:
 * Qualified Name:     ObjetChronoPeriodeIndemnisationConcret
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */