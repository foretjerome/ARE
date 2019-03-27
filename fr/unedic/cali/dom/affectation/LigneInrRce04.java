package fr.unedic.cali.dom.affectation;

public class LigneInrRce04
  extends LigneAbstrait
{
  private static LigneInrRce04 s_instanceUnique;
  
  public static LigneInrRce04 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneInrRce04();
    }
    return s_instanceUnique;
  }
  
  protected static LigneSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneInrRce04();
    }
    return s_instanceUnique;
  }
  
  private LigneInrRce04()
  {
    ajouterProduit(ProduitInrRce04P01.getInstancePourInitialisation());
    setNomUnique("INR_RCE04");
    setLibelle("Ligne 6 Aide à la Reprise ou Création d’Entreprise");
  }
}

/* Location:
 * Qualified Name:     LigneInrRce04
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */