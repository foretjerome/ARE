package fr.unedic.cali.dom.affectation;

public class LigneSolCpa02
  extends LigneAbstrait
{
  private static LigneSolCpa02 s_instanceUnique;
  
  public static LigneSolCpa02 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneSolCpa02();
    }
    return s_instanceUnique;
  }
  
  protected static LigneSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneSolCpa02();
    }
    return s_instanceUnique;
  }
  
  private LigneSolCpa02()
  {
    ajouterProduit(ProduitSolCpa02P01.getInstancePourInitialisation());
    
    setNomUnique("SOL_CPA02");
    setLibelle("Ligne 2 ASS Catégorie PArticuliére");
  }
}

/* Location:
 * Qualified Name:     LigneSolCpa02
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */