package fr.pe.cali.crem.outils;

import fr.pe.cali.crem.dom.ObjetMetierCrem;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.ContexteService;
import java.util.Collection;
import java.util.List;

public class OutilAjoutCremDalLiquidation
{
  private static OutilAjoutCremDalLiquidation instance;
  
  public static synchronized OutilAjoutCremDalLiquidation getInstance()
  {
    if (instance == null) {
      instance = new OutilAjoutCremDalLiquidation();
    }
    return instance;
  }
  
  public void ajouterCREMDemandesReexecutes(Collection<DemandeSpec> demandesReliquidees, IndividuSpec individu)
    throws ApplicativeException
  {
    if ((demandesReliquidees != null) && (individu != null)) {
      for (DemandeSpec demandeCourante : demandesReliquidees)
      {
        ObjetMetierCrem cremGenere = genererCREM(demandeCourante, individu.getContexteService());
        if (cremGenere != null) {
          individu.getListeCrem().add(cremGenere);
        }
      }
    }
  }
  
  protected ObjetMetierCrem genererCREM(DemandeSpec demande, ContexteService contexte)
    throws ApplicativeException
  {
    return OutilGenerationObjetMetierDalLiquidation.getInstance().genererObjetMetier(demande, contexte);
  }
}

/* Location:
 * Qualified Name:     OutilAjoutCremDalLiquidation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */