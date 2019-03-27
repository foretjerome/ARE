package fr.unedic.cali.dom.affectation;

public class LigneSolAer05
  extends LigneAbstrait
{
  private static final long serialVersionUID = 6255584152285965138L;
  private static LigneSolAer05 s_instanceUnique;
  
  public static LigneSolAer05 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneSolAer05();
    }
    return s_instanceUnique;
  }
  
  protected static LigneSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneSolAer05();
    }
    return s_instanceUnique;
  }
  
  private LigneSolAer05()
  {
    ajouterProduit(ProduitSolAer05P01.getInstancePourInitialisation());
    ajouterProduit(ProduitSolAer05P02.getInstancePourInitialisation());
    ajouterProduit(ProduitSolAer05P03.getInstancePourInitialisation());
    ajouterProduit(ProduitSolAer05P04.getInstancePourInitialisation());
    setNomUnique("SOL_AER05");
    setLibelle("Ligne 2 AER");
  }
}

/* Location:
 * Qualified Name:     LigneSolAer05
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */