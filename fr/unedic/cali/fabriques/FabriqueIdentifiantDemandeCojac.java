package fr.unedic.cali.fabriques;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.EvenementReferenceExamenSpec;
import fr.unedic.cali.dom.IndividuSpec;
import java.util.Collection;
import java.util.Iterator;

public class FabriqueIdentifiantDemandeCojac
{
  private static final int NB_CHIFFRE_NUMERO = 3;
  private static FabriqueIdentifiantDemandeCojac s_instance = new FabriqueIdentifiantDemandeCojac();
  
  public static FabriqueIdentifiantDemandeCojac getInstance()
  {
    return s_instance;
  }
  
  public String getIdentifiantDemandeCojac(IndividuSpec p_individu, String p_typeDemande)
  {
    int numeroI = 1;
    Collection demandes = p_individu.getDemandes();
    
    Iterator iterateur = demandes.iterator();
    while (iterateur.hasNext())
    {
      DemandeSpec demande = (DemandeSpec)iterateur.next();
      String typeSegment = demande.getEvenementReferenceExamen().getTypeSegment();
      if (typeSegment.equals("")) {
        numeroI++;
      }
    }
    String trigramme = p_typeDemande.substring(0, 3);
    String numeroS = bourrageATrois(numeroI);
    return trigramme + "_" + numeroS;
  }
  
  private static String bourrageATrois(int p_int)
  {
    String string = "" + p_int;
    while (string.length() < 3) {
      string = "0" + string;
    }
    return string;
  }
}

/* Location:
 * Qualified Name:     FabriqueIdentifiantDemandeCojac
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */