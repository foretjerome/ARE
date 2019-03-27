package fr.unedic.cali.dom.affectation;

public class LigneAsuSpe02
  extends LigneAbstrait
{
  private static final long serialVersionUID = 1L;
  private static LigneAsuSpe02 instanceUnique;
  
  private LigneAsuSpe02()
  {
    ajouterProduit(ProduitAsuSpe02P01.getInstancePourInitialisation());
    ajouterProduit(ProduitAsuSpe02P03.getInstancePourInitialisation());
    ajouterProduit(ProduitAsuSpe02P04.getInstancePourInitialisation());
    ajouterProduit(ProduitAsuSpe02P05.getInstancePourInitialisation());
    ajouterProduit(ProduitAsuSpe02P06.getInstancePourInitialisation());
    setNomUnique("ASU_SPE02");
    setLibelle("Ligne 2 Cinéma / Spectacle");
  }
  
  public static LigneAsuSpe02 getInstance()
  {
    
    if (instanceUnique == null) {
      instanceUnique = new LigneAsuSpe02();
    }
    return instanceUnique;
  }
  
  protected static LigneSpec getInstancePourInitialisation()
  {
    if (instanceUnique == null) {
      instanceUnique = new LigneAsuSpe02();
    }
    return instanceUnique;
  }
}

/* Location:
 * Qualified Name:     LigneAsuSpe02
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */