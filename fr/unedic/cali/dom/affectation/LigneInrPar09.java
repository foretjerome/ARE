package fr.unedic.cali.dom.affectation;

public final class LigneInrPar09
  extends LigneAbstrait
{
  private static final long serialVersionUID = -7565412961188936825L;
  private static LigneInrPar09 instanceUnique;
  
  public static synchronized LigneInrPar09 getInstance()
  {
    
    if (instanceUnique == null) {
      instanceUnique = new LigneInrPar09();
    }
    return instanceUnique;
  }
  
  protected static synchronized LigneSpec getInstancePourInitialisation()
  {
    if (instanceUnique == null) {
      instanceUnique = new LigneInrPar09();
    }
    return instanceUnique;
  }
  
  private LigneInrPar09()
  {
    ajouterProduit(ProduitInrPar09P01.getInstancePourInitialisation());
    setNomUnique("INR_PAR09");
    setLibelle("Ligne 9 Prime au reclassement");
  }
}

/* Location:
 * Qualified Name:     LigneInrPar09
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */