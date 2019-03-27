package fr.unedic.cali.dom.affectation;

public class LigneRbfAge08
  extends LigneAbstrait
{
  private static final long serialVersionUID = 1L;
  private static LigneRbfAge08 s_instanceUnique;
  
  public static LigneRbfAge08 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneRbfAge08();
    }
    return s_instanceUnique;
  }
  
  protected static LigneSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneRbfAge08();
    }
    return s_instanceUnique;
  }
  
  private LigneRbfAge08()
  {
    ajouterProduit(ProduitRbfAge08P01.getInstancePourInitialisation());
    setNomUnique("RBF_AGE08");
    setLibelle("Ligne 1 - Aide à la garde d'enfant");
  }
}

/* Location:
 * Qualified Name:     LigneRbfAge08
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */