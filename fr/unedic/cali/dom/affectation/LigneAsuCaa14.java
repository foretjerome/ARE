package fr.unedic.cali.dom.affectation;

public class LigneAsuCaa14
  extends LigneAbstrait
{
  private static final long serialVersionUID = 1L;
  private static LigneAsuCaa14 s_instanceUnique;
  
  public static LigneAsuCaa14 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneAsuCaa14();
    }
    return s_instanceUnique;
  }
  
  protected static LigneSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneAsuCaa14();
    }
    return s_instanceUnique;
  }
  
  private LigneAsuCaa14()
  {
    ajouterProduit(ProduitAsuCaa14P01.getInstancePourInitialisation());
    ajouterProduit(ProduitAsuCaa14P02.getInstancePourInitialisation());
    ajouterProduit(ProduitAsuCaa14P03.getInstancePourInitialisation());
    setNomUnique("ASU_CAA14");
    setLibelle("Conversion Attribution ARE (CAA)");
  }
}

/* Location:
 * Qualified Name:     LigneAsuCaa14
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */