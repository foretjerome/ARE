package fr.unedic.cali.dom.affectation;

public class LigneSolAta06
  extends LigneAbstrait
{
  private static final long serialVersionUID = 1L;
  private static LigneSolAta06 s_instanceUnique;
  
  public static LigneSolAta06 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneSolAta06();
    }
    return s_instanceUnique;
  }
  
  protected static LigneSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneSolAta06();
    }
    return s_instanceUnique;
  }
  
  private LigneSolAta06()
  {
    ajouterProduit(ProduitSolAta06P01.getInstancePourInitialisation());
    setNomUnique("SOL_ATA06");
    setLibelle("Ligne Sol ATA");
  }
}

/* Location:
 * Qualified Name:     LigneSolAta06
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */