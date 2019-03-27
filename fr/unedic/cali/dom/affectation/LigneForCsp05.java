package fr.unedic.cali.dom.affectation;

public class LigneForCsp05
  extends LigneAbstrait
{
  private static final long serialVersionUID = 1L;
  private static LigneForCsp05 s_instanceUnique;
  
  public static LigneForCsp05 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneForCsp05();
    }
    return s_instanceUnique;
  }
  
  protected static LigneSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneForCsp05();
    }
    return s_instanceUnique;
  }
  
  private LigneForCsp05()
  {
    ajouterProduit(ProduitForCsp05P01.getInstancePourInitialisation());
    setNomUnique("FOR_CSP05");
    setLibelle("Prime CSP");
  }
}

/* Location:
 * Qualified Name:     LigneForCsp05
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */