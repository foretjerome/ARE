package fr.unedic.cali.dom.affectation;

public class LigneInrCes06
  extends LigneAbstrait
{
  private static LigneInrCes06 s_instanceUnique;
  
  public static LigneInrCes06 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneInrCes06();
    }
    return s_instanceUnique;
  }
  
  protected static LigneSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneInrCes06();
    }
    return s_instanceUnique;
  }
  
  private LigneInrCes06()
  {
    ajouterProduit(ProduitInrCes06P01.getInstancePourInitialisation());
    setNomUnique("INR_CES06");
    setLibelle("Ligne 6 Repreneur d'entreprise en ASS");
  }
}

/* Location:
 * Qualified Name:     LigneInrCes06
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */