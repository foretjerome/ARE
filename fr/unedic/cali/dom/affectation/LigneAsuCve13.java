package fr.unedic.cali.dom.affectation;

public class LigneAsuCve13
  extends LigneAbstrait
{
  private static final long serialVersionUID = 1L;
  private static LigneAsuCve13 s_instanceUnique;
  
  public static LigneAsuCve13 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneAsuCve13();
    }
    return s_instanceUnique;
  }
  
  protected static LigneSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneAsuCve13();
    }
    return s_instanceUnique;
  }
  
  private LigneAsuCve13()
  {
    ajouterProduit(ProduitAsuCve13P01.getInstancePourInitialisation());
    setNomUnique("ASU_CVE13");
    setLibelle("Conversion Etat");
  }
}

/* Location:
 * Qualified Name:     LigneAsuCve13
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */