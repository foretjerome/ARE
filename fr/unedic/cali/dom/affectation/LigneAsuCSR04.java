package fr.unedic.cali.dom.affectation;

public class LigneAsuCSR04
  extends LigneAsuCge
{
  private static final long serialVersionUID = 1L;
  private static LigneAsuCSR04 s_instanceUnique;
  
  public static LigneAsuCSR04 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneAsuCSR04();
    }
    return s_instanceUnique;
  }
  
  protected static LigneSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneAsuCSR04();
    }
    return s_instanceUnique;
  }
  
  private LigneAsuCSR04()
  {
    ajouterProduit(ProduitAsuCSR04P01.getInstancePourInitialisation());
    setNomUnique("ASU_CSR04");
    setLibelle("Ligne 4 Chômage sans rupture");
  }
}

/* Location:
 * Qualified Name:     LigneAsuCSR04
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */