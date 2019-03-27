package fr.unedic.cali.dom.affectation;

public class LigneRbfFpo04
  extends LigneAbstrait
{
  private static LigneRbfFpo04 s_instanceUnique;
  
  public static LigneRbfFpo04 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneRbfFpo04();
    }
    return s_instanceUnique;
  }
  
  protected static LigneSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneRbfFpo04();
    }
    return s_instanceUnique;
  }
  
  private LigneRbfFpo04()
  {
    ajouterProduit(ProduitRbfFpo04P01.getInstancePourInitialisation());
    ajouterProduit(ProduitRbfFpo04P02.getInstancePourInitialisation());
    setNomUnique("RBF_FPO04");
    setLibelle("Ligne 1 - Remboursement frais pédagogique");
  }
}

/* Location:
 * Qualified Name:     LigneRbfFpo04
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */