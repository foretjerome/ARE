package fr.unedic.cali.dom.affectation;

public class LigneRbfHbt01
  extends LigneAbstrait
{
  private static final long serialVersionUID = 1701767086814142218L;
  private static LigneRbfHbt01 s_instanceUnique;
  
  public static LigneRbfHbt01 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneRbfHbt01();
    }
    return s_instanceUnique;
  }
  
  protected static LigneSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneRbfHbt01();
    }
    return s_instanceUnique;
  }
  
  private LigneRbfHbt01()
  {
    ajouterProduit(ProduitRbfHbt01P01.getInstancePourInitialisation());
    ajouterProduit(ProduitRbfHbt01P02.getInstancePourInitialisation());
    setNomUnique("RBF_HBT01");
    setLibelle("Ligne 1 - Remboursement frais d'hébergement");
  }
}

/* Location:
 * Qualified Name:     LigneRbfHbt01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */