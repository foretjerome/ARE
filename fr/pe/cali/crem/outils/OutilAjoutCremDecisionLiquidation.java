package fr.pe.cali.crem.outils;

import fr.pe.cali.crem.dom.ObjetMetierCrem;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.IndividuSpec;
import java.util.Collection;
import java.util.List;

public class OutilAjoutCremDecisionLiquidation
{
  private static OutilAjoutCremDecisionLiquidation instance;
  
  public static synchronized OutilAjoutCremDecisionLiquidation getInstance()
  {
    if (instance == null) {
      instance = new OutilAjoutCremDecisionLiquidation();
    }
    return instance;
  }
  
  public void ajouterCREMDecisions(IndividuSpec individu)
    throws ApplicativeException
  {
    OutilGenerationObjetMetier outilGenerationObjetMetier;
    if ((individu != null) && (individu.getDemandes() != null))
    {
      Collection<DemandeSpec> listeDemandes = individu.getDemandes();
      outilGenerationObjetMetier = getOutilGenerationCrem();
      for (DemandeSpec demandeCourante : listeDemandes)
      {
        ObjetMetierCrem cremGenere = outilGenerationObjetMetier.genererObjetMetier(demandeCourante, individu.getContexteService());
        if (cremGenere != null) {
          individu.getListeCrem().add(cremGenere);
        }
      }
    }
  }
  
  protected OutilGenerationObjetMetier getOutilGenerationCrem()
  {
    return OutilGenerationObjetMetierDecisionLiquidation.getInstance();
  }
}

/* Location:
 * Qualified Name:     OutilAjoutCremDecisionLiquidation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */