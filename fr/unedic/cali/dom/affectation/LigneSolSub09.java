package fr.unedic.cali.dom.affectation;

public class LigneSolSub09
  extends LigneAbstrait
{
  private static final long serialVersionUID = 1L;
  private static LigneSolSub09 s_instanceUnique;
  
  public static LigneSolSub09 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneSolSub09();
    }
    return s_instanceUnique;
  }
  
  protected static LigneSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneSolSub09();
    }
    return s_instanceUnique;
  }
  
  private LigneSolSub09()
  {
    ajouterProduit(ProduitSolSub09P01.getInstancePourInitialisation());
    setNomUnique("SOL_SUB09");
    setLibelle("Ligne 9 Subsidiaire");
  }
}

/* Location:
 * Qualified Name:     LigneSolSub09
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */