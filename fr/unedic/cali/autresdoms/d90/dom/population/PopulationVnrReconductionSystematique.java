package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.autresdoms.d90.dom.comportement.ComportementBatchReconductionSystematique;

public class PopulationVnrReconductionSystematique
  extends PopulationVnr
{
  private static final String LIBELLE = "POP_CALI_Population_Vnr_Reconduction_Syst_Junit";
  private static final int IDENTIFIANT_POPULATION = "POP_CALI_Population_Vnr_Reconduction_Syst_Junit".hashCode();
  private static final int PRIORITE = 755;
  
  public PopulationVnrReconductionSystematique()
  {
    setId(IDENTIFIANT_POPULATION);
    setTopSelection(" ");
    setPriorite(755);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("POP_CALI_Population_Vnr_Reconduction_Syst_Junit");
    setNumeroDSMS("000000");
    setConsequenceFinanciereRecalcul(" ");
    setMaxCodeConsequenceSelection(" ");
    setComportement(new ComportementBatchReconductionSystematique());
  }
}

/* Location:
 * Qualified Name:     PopulationVnrReconductionSystematique
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */