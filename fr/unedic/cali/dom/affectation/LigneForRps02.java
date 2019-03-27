package fr.unedic.cali.dom.affectation;

public class LigneForRps02
  extends LigneAbstrait
{
  private static final long serialVersionUID = 1L;
  private static LigneForRps02 s_instanceUnique;
  private static final String LIBELLE_LIGNE = "Rémunération Public des Stagiaires (RPS)";
  
  public static LigneForRps02 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneForRps02();
    }
    return s_instanceUnique;
  }
  
  protected static LigneSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new LigneForRps02();
    }
    return s_instanceUnique;
  }
  
  private LigneForRps02()
  {
    ajouterProduit(ProduitForRps02P01.getInstancePourInitialisation());
    setNomUnique("FOR_RPS02");
    setLibelle("Rémunération Public des Stagiaires (RPS)");
  }
}

/* Location:
 * Qualified Name:     LigneForRps02
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */