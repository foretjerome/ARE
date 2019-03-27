package fr.unedic.cali.dom.affectation;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.FormuleMontantSpec;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ProduitDecCge01P01
  extends ProduitDecAbstrait
{
  private static final long serialVersionUID = -3064500834932429168L;
  private static ProduitDecCge01P01 s_instanceUnique = null;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.dec.cge01.p01.ProduitDelegue";
  private static final String LIB_COURT = "AC DECES 01";
  private static final String LIB_LONG = "Allocation décès";
  private static final Damj DATE_DEBUT_VALIDITE = new Damj(2010, 4, 1);
  private static final Damj DATE_FIN_VALIDITE = Damj.FIN_DES_TEMPS;
  
  public static ProduitDecCge01P01 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitDecCge01P01();
    }
    return s_instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitDecCge01P01();
    }
    return s_instanceUnique;
  }
  
  protected ProduitDecCge01P01()
  {
    setLibelleCourt("AC DECES 01");
    setLibelleLong("Allocation décès");
    setPeriodeValidite(new Periode(DATE_DEBUT_VALIDITE, DATE_FIN_VALIDITE));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.dec.cge01.p01.ProduitDelegue"));
    setCode(53);
    setNomUnique("DEC_CGE01_01");
  }
  
  public int getTypePaiement()
  {
    return 1;
  }
  
  public Resultat traiterObjectifAdmission(Contexte p_contexte)
    throws ApplicativeException
  {
    return getProduitDecDelegue().traiterObjectifAdmission(p_contexte);
  }
  
  public AttributionSpec creerAttribution()
  {
    return getProduitDecDelegue().creerAttribution();
  }
  
  public FormuleMontantSpec getFormuleMontant(String p_code)
  {
    return getProduitDecDelegue().getFormuleMontant(p_code);
  }
}

/* Location:
 * Qualified Name:     ProduitDecCge01P01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */