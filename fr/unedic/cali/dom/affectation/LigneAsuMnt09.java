package fr.unedic.cali.dom.affectation;

public class LigneAsuMnt09
  extends LigneAbstrait
{
  private static LigneAsuMnt09 s_instanceUnique;
  
  public static LigneAsuMnt09 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneAsuMnt09();
    }
    return s_instanceUnique;
  }
  
  protected static LigneSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneAsuMnt09();
    }
    return s_instanceUnique;
  }
  
  private LigneAsuMnt09()
  {
    ajouterProduit(ProduitAsuMnt09P01.getInstancePourInitialisation());
    setNomUnique("ASU_MNT09");
    setLibelle("Ligne 9 Cas général");
  }
}

/* Location:
 * Qualified Name:     LigneAsuMnt09
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */