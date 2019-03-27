package fr.unedic.cali.dom.affectation;

public class LigneRbfMob07
  extends LigneAbstrait
{
  private static final long serialVersionUID = 1L;
  private static LigneRbfMob07 s_instanceUnique;
  
  public static LigneRbfMob07 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneRbfMob07();
    }
    return s_instanceUnique;
  }
  
  protected static LigneSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneRbfMob07();
    }
    return s_instanceUnique;
  }
  
  private LigneRbfMob07()
  {
    ajouterProduit(ProduitRbfMob07P01.getInstancePourInitialisation());
    setNomUnique("RBF_MOB07");
    setLibelle("Ligne 1 - Aide à la mobilité");
  }
}

/* Location:
 * Qualified Name:     LigneRbfMob07
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */