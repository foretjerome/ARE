package fr.unedic.cali.dom.affectation;

public class LigneRetAco01
  extends LigneAbstrait
{
  private static final long serialVersionUID = 1L;
  private static LigneRetAco01 s_instanceUnique;
  
  public static LigneRetAco01 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneRetAco01();
    }
    return s_instanceUnique;
  }
  
  protected static LigneSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneRetAco01();
    }
    return s_instanceUnique;
  }
  
  private LigneRetAco01()
  {
    ajouterProduit(ProduitRetAco01P01.getInstancePourInitialisation());
    setNomUnique("RET_ACO01");
    setLibelle("Ligne 1 Allocation Complémentaire");
  }
}

/* Location:
 * Qualified Name:     LigneRetAco01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */