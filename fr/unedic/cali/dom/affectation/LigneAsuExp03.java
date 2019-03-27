package fr.unedic.cali.dom.affectation;

public class LigneAsuExp03
  extends LigneAbstrait
{
  private static final long serialVersionUID = 125531316865877076L;
  private static LigneAsuExp03 s_instanceUnique;
  
  public static LigneAsuExp03 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneAsuExp03();
    }
    return s_instanceUnique;
  }
  
  protected static LigneSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneAsuExp03();
    }
    return s_instanceUnique;
  }
  
  private LigneAsuExp03()
  {
    ajouterProduit(ProduitAsuExp03P01.getInstancePourInitialisation());
    setNomUnique("ASU_EXP03");
    setLibelle("Ligne 3 Expatriés");
  }
}

/* Location:
 * Qualified Name:     LigneAsuExp03
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */