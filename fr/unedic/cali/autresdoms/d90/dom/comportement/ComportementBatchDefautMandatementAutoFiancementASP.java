package fr.unedic.cali.autresdoms.d90.dom.comportement;

public class ComportementBatchDefautMandatementAutoFiancementASP
  extends ComportementBatchDefaut
{
  private String identifiant = "comportementBatchDefautMandatementAuto";
  private String libelle = "Comportement par défaut d'un occasionnel avec mandatement auto";
  public static final String CONTEXTE_EXECUTION_BATCH_MANDATEMENT_AUTO_ASP_FINANCEMENT = "3";
  
  public ComportementBatchDefautMandatementAutoFiancementASP()
  {
    identifiantComportement = identifiant;
    libelleComportement = libelle;
    typeMandatement = "3";
  }
}

/* Location:
 * Qualified Name:     ComportementBatchDefautMandatementAutoFiancementASP
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */