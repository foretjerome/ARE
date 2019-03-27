package fr.unedic.cali.dom.affectation;

public class LigneInrAdr03
  extends LigneAbstrait
{
  private static LigneInrAdr03 s_instanceUnique;
  
  public static LigneInrAdr03 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneInrAdr03();
    }
    return s_instanceUnique;
  }
  
  protected static LigneSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneInrAdr03();
    }
    return s_instanceUnique;
  }
  
  private LigneInrAdr03()
  {
    ajouterProduit(ProduitInrAdr03P02.getInstancePourInitialisation());
    setNomUnique("INR_ADR03");
    setLibelle("Ligne 6 Aide à la Reprise ou Création d’Entreprise");
  }
}

/* Location:
 * Qualified Name:     LigneInrAdr03
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */