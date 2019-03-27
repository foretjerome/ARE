package fr.unedic.cali.parcours;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.ObjetAlertesNonBloquantes;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;

public abstract class ParcoursRechercheAlertes
  extends ParcoursCali
{
  protected void presenceAlerteAD(DemandeSpec p_demande)
  {
    if (p_demande.getDemandeur().estAlerteAD())
    {
      Collection listePeriodes = new ArrayList();
      
      ObjetAlertesNonBloquantes objetAlerteNonBloquante = new ObjetAlertesNonBloquantes(Damj.NUIT_DES_TEMPS, Damj.FIN_DES_TEMPS, 999);
      
      listePeriodes.add(objetAlerteNonBloquante);
      p_demande.getAlertesNonBloquantes().put("AD1MNB1", listePeriodes);
    }
  }
}

/* Location:
 * Qualified Name:     ParcoursRechercheAlertes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */