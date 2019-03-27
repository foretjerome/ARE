package fr.unedic.cali.dom.affectation;

public class LigneRbfTpt02
  extends LigneAbstrait
{
  private static LigneRbfTpt02 s_instanceUnique;
  
  public static LigneRbfTpt02 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneRbfTpt02();
    }
    return s_instanceUnique;
  }
  
  protected static LigneSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneRbfTpt02();
    }
    return s_instanceUnique;
  }
  
  private LigneRbfTpt02()
  {
    ajouterProduit(ProduitRbfTpt02P01.getInstancePourInitialisation());
    ajouterProduit(ProduitRbfTpt02P02.getInstancePourInitialisation());
    setNomUnique("RBF_TPT02");
    setLibelle("Ligne 1 - Remboursement frais de transport");
  }
}

/* Location:
 * Qualified Name:     LigneRbfTpt02
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */