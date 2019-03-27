package fr.unedic.cali.dom.affectation;

public class LigneRbfRtn03
  extends LigneAbstrait
{
  private static LigneRbfRtn03 s_instanceUnique;
  
  public static LigneRbfRtn03 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneRbfRtn03();
    }
    return s_instanceUnique;
  }
  
  protected static LigneSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneRbfRtn03();
    }
    return s_instanceUnique;
  }
  
  private LigneRbfRtn03()
  {
    ajouterProduit(ProduitRbfRtn03P01.getInstancePourInitialisation());
    ajouterProduit(ProduitRbfRtn03P02.getInstancePourInitialisation());
    setNomUnique("RBF_RTN03");
    setLibelle("Ligne 1 - Remboursement frais de restauration");
  }
}

/* Location:
 * Qualified Name:     LigneRbfRtn03
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */