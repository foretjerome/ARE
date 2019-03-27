package fr.unedic.cali.dom.affectation;

public class LigneForRfp04
  extends LigneAbstrait
{
  private static final long serialVersionUID = 1L;
  private static LigneForRfp04 s_instanceUnique;
  
  public static LigneForRfp04 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneForRfp04();
    }
    return s_instanceUnique;
  }
  
  protected static LigneSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneForRfp04();
    }
    return s_instanceUnique;
  }
  
  private LigneForRfp04()
  {
    ajouterProduit(ProduitForRfp04P01.getInstancePourInitialisation());
    setNomUnique("FOR_RFP04");
    setLibelle("Ligne 4 Rémunération de Formation Pôle Emploi");
  }
}

/* Location:
 * Qualified Name:     LigneForRfp04
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */