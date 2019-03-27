package fr.unedic.cali.dom.affectation;

public class LigneAsuEur05
  extends LigneAbstrait
{
  private static final long serialVersionUID = 1L;
  private static LigneAsuEur05 s_instanceUnique;
  
  public static LigneAsuEur05 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneAsuEur05();
    }
    return s_instanceUnique;
  }
  
  protected static LigneSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneAsuEur05();
    }
    return s_instanceUnique;
  }
  
  private LigneAsuEur05()
  {
    ajouterProduit(ProduitAsuEur05P01.getInstancePourInitialisation());
    setNomUnique("ASU_EUR05");
    setLibelle("Ligne 1 Allocation Union Européenne");
  }
}

/* Location:
 * Qualified Name:     LigneAsuEur05
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */