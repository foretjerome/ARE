package fr.unedic.cali.dom.affectation;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.calcul.outilsfonctionnels.ElementForcable;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.Resultat;

public class ProduitPrrPrl02P01
  extends ProduitPrrAbstrait
{
  private static final long serialVersionUID = 7748665564686131836L;
  private static ProduitPrrPrl02P01 s_instanceUnique = null;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.prr.prl02.p01.ProduitDelegue";
  private static final String LIB_COURT = "AS-FNE";
  private static final String LIB_LONG = "Allocation Spéciale du Fonds National de l'Emploi";
  
  public static ProduitPrrPrl02P01 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitPrrPrl02P01();
    }
    return s_instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitPrrPrl02P01();
    }
    return s_instanceUnique;
  }
  
  protected ProduitPrrPrl02P01()
  {
    setLibelleCourt("AS-FNE");
    setLibelleLong("Allocation Spéciale du Fonds National de l'Emploi");
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.prr.prl02.p01.ProduitDelegue"));
    setCode(44);
    setNomUnique("PRR_PRL02_01");
    
    ajouterElementForcable(ElementForcable.getInstance("DECALAGE_CALCULE", this));
    ajouterElementForcable(ElementForcable.getInstance("DECALAGE_FORCE", this));
    ajouterElementForcable(ElementForcable.getInstance("STATUT_UT_FORCE", this));
  }
  
  public int getTypePaiement()
  {
    return 0;
  }
  
  public Resultat traiterObjectifAdmission(Contexte p_contexte)
    throws ApplicativeException
  {
    return getProduitPrrDelegue().traiterObjectifAdmission(p_contexte);
  }
  
  public AttributionSpec creerAttribution()
  {
    return getProduitPrrDelegue().creerAttribution();
  }
}

/* Location:
 * Qualified Name:     ProduitPrrPrl02P01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */