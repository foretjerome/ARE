package fr.unedic.cali.dom.affectation;

public class LigneAsuCge01
  extends LigneAsuCge
{
  private static final long serialVersionUID = -4306848024082107871L;
  private static LigneAsuCge01 instanceUnique;
  private static final String LIGNE_DELEGUE = "fr.unedic.cali.asu.cge01.LigneDelegue";
  
  private LigneAsuCge01()
  {
    setLigneDelegue(creerLigneDelegue("fr.unedic.cali.asu.cge01.LigneDelegue"));
    ajouterProduit(ProduitAsuCge01P02.getInstancePourInitialisation());
    ajouterProduit(ProduitAsuCge01P03.getInstancePourInitialisation());
    ajouterProduit(ProduitAsuCge01P04.getInstancePourInitialisation());
    ajouterProduit(ProduitAsuCge01P05.getInstancePourInitialisation());
    ajouterProduit(ProduitAsuCge01P06.getInstancePourInitialisation());
    ajouterProduit(ProduitAsuCge01P6B.getInstancePourInitialisation());
    ajouterProduit(ProduitAsuCge01P07.getInstancePourInitialisation());
    setNomUnique("ASU_CGE01");
    setLibelle("Ligne 1 Cas général");
  }
  
  public static LigneAsuCge01 getInstance()
  {
    
    if (instanceUnique == null) {
      instanceUnique = new LigneAsuCge01();
    }
    return instanceUnique;
  }
  
  protected static LigneSpec getInstancePourInitialisation()
  {
    if (instanceUnique == null) {
      instanceUnique = new LigneAsuCge01();
    }
    return instanceUnique;
  }
}

/* Location:
 * Qualified Name:     LigneAsuCge01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */