package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.autresdoms.d90.dom.comportement.ComportementBatchDefaut;

public class PopulationVnrReconductionAuto
  extends PopulationVnr
{
  private static final String LIBELLE = "POP_CALI_Population_Vnr_Reconduction_Auto_Junit";
  private static final int IDENTIFIANT_POPULATION = "POP_CALI_Population_Vnr_Reconduction_Auto_Junit".hashCode();
  private static final int PRIORITE = 755;
  
  public PopulationVnrReconductionAuto()
  {
    setId(IDENTIFIANT_POPULATION);
    setTopSelection(" ");
    setPriorite(755);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("POP_CALI_Population_Vnr_Reconduction_Auto_Junit");
    setNumeroDSMS("000000");
    setConsequenceFinanciereRecalcul(" ");
    setMaxCodeConsequenceSelection(" ");
    setComportement(new ComportementBatchDefaut());
  }
}

/* Location:
 * Qualified Name:     PopulationVnrReconductionAuto
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */