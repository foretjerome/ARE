package fr.unedic.cali.dom.affectation;

public class LigneAsuCsa06
  extends LigneAsuCge
{
  private static final long serialVersionUID = 1L;
  private static LigneAsuCsa06 instanceUnique;
  
  private LigneAsuCsa06()
  {
    ajouterProduit(ProduitAsuCsa06P01.getInstancePourInitialisation());
    ajouterProduit(ProduitAsuCsa06P02.getInstancePourInitialisation());
    ajouterProduit(ProduitAsuCsa06P03.getInstancePourInitialisation());
    ajouterProduit(ProduitAsuCsa06P04.getInstancePourInitialisation());
    ajouterProduit(ProduitAsuCsa06P05.getInstancePourInitialisation());
    ajouterProduit(ProduitAsuCsa06P5B.getInstancePourInitialisation());
    ajouterProduit(ProduitAsuCsa06P06.getInstancePourInitialisation());
    setNomUnique("ASU_CSA06");
    setLibelle("Ligne 6 Clause de Sauvegarde");
  }
  
  public static LigneAsuCsa06 getInstance()
  {
    
    if (instanceUnique == null) {
      instanceUnique = new LigneAsuCsa06();
    }
    return instanceUnique;
  }
  
  protected static LigneSpec getInstancePourInitialisation()
  {
    if (instanceUnique == null) {
      instanceUnique = new LigneAsuCsa06();
    }
    return instanceUnique;
  }
}

/* Location:
 * Qualified Name:     LigneAsuCsa06
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */