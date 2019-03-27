package fr.unedic.cali.dom.affectation;

public class LigneDecCge01
  extends LigneAbstrait
{
  private static final long serialVersionUID = 9005976669004551641L;
  private static LigneDecCge01 s_instanceUnique;
  
  public static LigneDecCge01 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneDecCge01();
    }
    return s_instanceUnique;
  }
  
  protected static LigneSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneDecCge01();
    }
    return s_instanceUnique;
  }
  
  private LigneDecCge01()
  {
    ajouterProduit(ProduitDecCge01P01.getInstancePourInitialisation());
    setNomUnique("DEC_CGE01");
    setLibelle("Ligne allocation décès");
  }
}

/* Location:
 * Qualified Name:     LigneDecCge01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */