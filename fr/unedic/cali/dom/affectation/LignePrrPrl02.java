package fr.unedic.cali.dom.affectation;

public class LignePrrPrl02
  extends LigneAbstrait
{
  private static final long serialVersionUID = 3705476250359757194L;
  private static LignePrrPrl02 s_instanceUnique;
  
  public static LignePrrPrl02 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new LignePrrPrl02();
    }
    return s_instanceUnique;
  }
  
  protected static LigneSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new LignePrrPrl02();
    }
    return s_instanceUnique;
  }
  
  private LignePrrPrl02()
  {
    ajouterProduit(ProduitPrrPrl02P01.getInstancePourInitialisation());
    setNomUnique("PRR_PRL02");
    setLibelle("Ligne Préretraite licenciement");
  }
}

/* Location:
 * Qualified Name:     LignePrrPrl02
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */