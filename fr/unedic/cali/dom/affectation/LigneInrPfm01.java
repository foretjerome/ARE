package fr.unedic.cali.dom.affectation;

public class LigneInrPfm01
  extends LigneAbstrait
{
  private static LigneInrPfm01 s_instanceUnique;
  
  public static LigneInrPfm01 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneInrPfm01();
    }
    return s_instanceUnique;
  }
  
  protected static LigneSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneInrPfm01();
    }
    return s_instanceUnique;
  }
  
  private LigneInrPfm01()
  {
    ajouterProduit(ProduitInrPfm01P01.getInstancePourInitialisation());
    setNomUnique("INR_PFM01");
    setLibelle("Ligne 6 Prime forfaitaire mensuelle");
  }
}

/* Location:
 * Qualified Name:     LigneInrPfm01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */