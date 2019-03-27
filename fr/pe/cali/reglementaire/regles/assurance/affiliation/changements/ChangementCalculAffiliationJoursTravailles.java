package fr.pe.cali.reglementaire.regles.assurance.affiliation.changements;

import fr.pe.cali.reglementaire.decors.changements.ChangementCorpsRegle;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.outils.impl.OutilCalculAffiliationJourTravaille;

public class ChangementCalculAffiliationJoursTravailles
  extends ChangementCorpsRegle
{
  private static ChangementCalculAffiliationJoursTravailles instance = new ChangementCalculAffiliationJoursTravailles();
  
  private ChangementCalculAffiliationJoursTravailles()
  {
    setNomCorpsRegle("CalculAffiliationJoursTravailles");
    initialiserListeCorpsRegles();
    ajouterCorpsRegle(new OutilCalculAffiliationJourTravaille());
  }
  
  public static ChangementCalculAffiliationJoursTravailles getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ChangementCalculAffiliationJoursTravailles
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */