package fr.unedic.cali.dom.affectation;

public class LignePrrPlf03
  extends LigneAbstrait
{
  private static final long serialVersionUID = 1L;
  private static LignePrrPlf03 s_instanceUnique;
  
  public static LignePrrPlf03 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new LignePrrPlf03();
    }
    return s_instanceUnique;
  }
  
  protected static LigneSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new LignePrrPlf03();
    }
    return s_instanceUnique;
  }
  
  private LignePrrPlf03()
  {
    ajouterProduit(ProduitPrrPlf03P01.getInstancePourInitialisation());
    setNomUnique("PRR_PLF03");
    setLibelle("Ligne Préretraite licenciement Fractionné");
  }
}

/* Location:
 * Qualified Name:     LignePrrPlf03
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */