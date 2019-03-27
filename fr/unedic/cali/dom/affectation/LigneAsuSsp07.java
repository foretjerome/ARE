package fr.unedic.cali.dom.affectation;

public class LigneAsuSsp07
  extends LigneAbstrait
{
  private static LigneAsuSsp07 instanceUnique;
  
  private LigneAsuSsp07()
  {
    ajouterProduit(ProduitAsuSsp07P03.getInstancePourInitialisation());
    ajouterProduit(ProduitAsuSsp07P04.getInstancePourInitialisation());
    ajouterProduit(ProduitAsuSsp07P05.getInstancePourInitialisation());
    setNomUnique("ASU_SSP07");
    setLibelle("Ligne Subsidiaire Spectacle");
  }
  
  public static LigneAsuSsp07 getInstance()
  {
    
    if (instanceUnique == null) {
      instanceUnique = new LigneAsuSsp07();
    }
    return instanceUnique;
  }
  
  protected static LigneSpec getInstancePourInitialisation()
  {
    if (instanceUnique == null) {
      instanceUnique = new LigneAsuSsp07();
    }
    return instanceUnique;
  }
}

/* Location:
 * Qualified Name:     LigneAsuSsp07
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */