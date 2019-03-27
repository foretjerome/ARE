package fr.unedic.cali.dom.affectation;

public class LigneSolCge01
  extends LigneAbstrait
{
  private static LigneSolCge01 s_instanceUnique;
  
  public static LigneSolCge01 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneSolCge01();
    }
    return s_instanceUnique;
  }
  
  protected static LigneSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneSolCge01();
    }
    return s_instanceUnique;
  }
  
  private LigneSolCge01()
  {
    ajouterProduit(ProduitSolCge01P01.getInstancePourInitialisation());
    
    setNomUnique("SOL_CGE01");
    setLibelle("Ligne 1 Cas général");
  }
}

/* Location:
 * Qualified Name:     LigneSolCge01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */