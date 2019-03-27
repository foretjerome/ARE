package fr.unedic.cali.dom.affectation;

public class LigneForAff03
  extends LigneAbstrait
{
  private static final long serialVersionUID = 1L;
  private static LigneForAff03 s_instanceUnique;
  
  public static LigneForAff03 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneForAff03();
    }
    return s_instanceUnique;
  }
  
  protected static LigneSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneForAff03();
    }
    return s_instanceUnique;
  }
  
  private LigneForAff03()
  {
    ajouterProduit(ProduitForAff03P01.getInstancePourInitialisation());
    ajouterProduit(ProduitForAff03P03.getInstancePourInitialisation());
    setNomUnique("FOR_AFF03");
    setLibelle("Ligne 3 Aide Fin de Formation");
  }
}

/* Location:
 * Qualified Name:     LigneForAff03
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */