package fr.unedic.cali.dom.affectation;

public class LigneAsuFds12
  extends LigneAbstrait
{
  private static LigneAsuFds12 instanceUnique;
  
  private LigneAsuFds12()
  {
    ajouterProduit(ProduitAsuFds12P02.getInstancePourInitialisation());
    ajouterProduit(ProduitAsuFds12P03.getInstancePourInitialisation());
    
    setNomUnique("ASU_FDS12");
    setLibelle("Ligne Fin de Droit Intermittent du Spectacle");
  }
  
  public static LigneAsuFds12 getInstance()
  {
    
    if (instanceUnique == null) {
      instanceUnique = new LigneAsuFds12();
    }
    return instanceUnique;
  }
  
  protected static LigneSpec getInstancePourInitialisation()
  {
    if (instanceUnique == null) {
      instanceUnique = new LigneAsuFds12();
    }
    return instanceUnique;
  }
}

/* Location:
 * Qualified Name:     LigneAsuFds12
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */