package fr.unedic.cali.dom.affectation;

public class LigneAsuDdm16
  extends LigneAbstrait
{
  private static final long serialVersionUID = 1L;
  private static LigneAsuDdm16 s_instanceUnique;
  
  public static LigneAsuDdm16 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneAsuDdm16();
    }
    return s_instanceUnique;
  }
  
  protected static LigneSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneAsuDdm16();
    }
    return s_instanceUnique;
  }
  
  private LigneAsuDdm16()
  {
    ajouterProduit(ProduitAsuDdm16P01.getInstancePourInitialisation());
    setNomUnique("ASU_DDM16");
    setLibelle("Droit des mineurs");
  }
}

/* Location:
 * Qualified Name:     LigneAsuDdm16
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */