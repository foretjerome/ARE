package fr.unedic.cali.calcul.pbjc.outilsfonctionnels;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.temps.Damj;
import java.util.List;
import java.util.Map;

public class GenerateurTablesEchangesCalcul
{
  public static void alimenterTableEchangesCalcul(List p_listeAttributions, Map p_mapCalendrier, Damj p_dateDebutGeneration, Damj p_dateBlocageActualisation, String p_libelleBlocageActualisation, IndividuSpec p_individu)
    throws ApplicativeException
  {
    GenerateurPBJCs.enregistrerChronologiePBJCs(GenerateurPBJCs.creerChronologiePBJCs(p_listeAttributions, p_mapCalendrier, p_dateDebutGeneration, p_dateBlocageActualisation, p_libelleBlocageActualisation, p_individu), p_dateDebutGeneration, p_individu, 0);
    
    GenerateurPrimes.enregistrerPrimePbjcNcp(GenerateurPrimes.creerCollectionPrimes(p_listeAttributions, p_mapCalendrier, p_dateDebutGeneration), p_dateDebutGeneration, p_individu);
    
    GenerateurAIDEs.enregistrerChronologieAIDEs(GenerateurAIDEs.creerChronologieAIDEs(p_listeAttributions, p_mapCalendrier, p_dateDebutGeneration, p_dateBlocageActualisation, p_libelleBlocageActualisation, p_individu), p_dateDebutGeneration, p_individu);
  }
}

/* Location:
 * Qualified Name:     GenerateurTablesEchangesCalcul
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */