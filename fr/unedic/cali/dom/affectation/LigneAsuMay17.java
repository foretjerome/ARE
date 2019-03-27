package fr.unedic.cali.dom.affectation;

public class LigneAsuMay17
  extends LigneAbstrait
{
  private static final long serialVersionUID = 1L;
  private static LigneAsuMay17 s_instanceUnique;
  
  public static LigneAsuMay17 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneAsuMay17();
    }
    return s_instanceUnique;
  }
  
  protected static LigneSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneAsuMay17();
    }
    return s_instanceUnique;
  }
  
  private LigneAsuMay17()
  {
    ajouterProduit(ProduitAsuMay17P02.getInstancePourInitialisation());
    ajouterProduit(ProduitAsuMay17P03.getInstancePourInitialisation());
    setNomUnique("ASU_MAY17");
    setLibelle("ARE Mayotte");
  }
}

/* Location:
 * Qualified Name:     LigneAsuMay17
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */