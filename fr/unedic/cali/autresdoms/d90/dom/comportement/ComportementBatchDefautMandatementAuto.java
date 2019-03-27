package fr.unedic.cali.autresdoms.d90.dom.comportement;

public class ComportementBatchDefautMandatementAuto
  extends ComportementBatchDefaut
{
  private String identifiant = "comportementBatchDefautMandatementAuto";
  private String libelle = "Comportement par défaut d'un occasionnel avec mandatement auto";
  
  public ComportementBatchDefautMandatementAuto()
  {
    identifiantComportement = identifiant;
    libelleComportement = libelle;
    typeMandatement = "1";
  }
}

/* Location:
 * Qualified Name:     ComportementBatchDefautMandatementAuto
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */