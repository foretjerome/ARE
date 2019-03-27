package fr.unedic.cali.dom.affectation;

public class LigneRbfAides
  extends LigneAbstrait
{
  private static final long serialVersionUID = 1L;
  private static LigneRbfAides s_instanceUnique;
  
  public static LigneRbfAides getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneRbfAides();
    }
    return s_instanceUnique;
  }
  
  protected static LigneSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneRbfAides();
    }
    return s_instanceUnique;
  }
  
  private LigneRbfAides()
  {
    ajouterProduit(ProduitRbfAidesBan.getInstancePourInitialisation());
    setNomUnique("RBF_AIDES");
    setLibelle("Action locale");
  }
}

/* Location:
 * Qualified Name:     LigneRbfAides
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */