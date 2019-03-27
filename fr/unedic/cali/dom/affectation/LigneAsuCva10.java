package fr.unedic.cali.dom.affectation;

public class LigneAsuCva10
  extends LigneAbstrait
{
  private static final long serialVersionUID = 1L;
  private static LigneAsuCva10 s_instanceUnique;
  
  public static LigneAsuCva10 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneAsuCva10();
    }
    return s_instanceUnique;
  }
  
  protected static LigneSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneAsuCva10();
    }
    return s_instanceUnique;
  }
  
  private LigneAsuCva10()
  {
    ajouterProduit(ProduitAsuCva10P01.getInstancePourInitialisation());
    ajouterProduit(ProduitAsuCva10P02.getInstancePourInitialisation());
    ajouterProduit(ProduitAsuCva10P03.getInstancePourInitialisation());
    setNomUnique("ASU_CVA10");
    setLibelle("Conservation Assurance droit commun (CVA)");
  }
}

/* Location:
 * Qualified Name:     LigneAsuCva10
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */