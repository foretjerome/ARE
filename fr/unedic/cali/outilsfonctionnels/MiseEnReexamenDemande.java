package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.util.services.OutilFonctionnel;
import java.util.Iterator;
import java.util.List;

public class MiseEnReexamenDemande
  implements OutilFonctionnel
{
  public static void miseEnReexamen(DemandeSpec p_demande, EvenementReexamen p_evenement)
  {
    if ((p_demande.estDecisionnee()) && (p_demande.estLiquidableOuReexecutable())) {
      p_demande.ajouterMotifReexamen(p_evenement.getTypeReexamen());
    }
  }
  
  public static void miseEnReexamen(List p_demandesAMettreEnReexamen)
  {
    if (p_demandesAMettreEnReexamen != null)
    {
      Iterator iteratorDemandesInvalides = p_demandesAMettreEnReexamen.iterator();
      DemandeSpec demandeInvalide = null;
      while (iteratorDemandesInvalides.hasNext())
      {
        demandeInvalide = (DemandeSpec)iteratorDemandesInvalides.next();
        if (demandeInvalide.estLiquidableOuReexecutable()) {
          demandeInvalide.ajouterMotifReexamen("4");
        }
      }
    }
  }
  
  public static void miseEnReexamen(DemandeSpec p_demandeAMettreEnReexamen)
  {
    if ((p_demandeAMettreEnReexamen.estDecisionnee()) && (p_demandeAMettreEnReexamen.estLiquidableOuReexecutable())) {
      p_demandeAMettreEnReexamen.ajouterMotifReexamen("4");
    }
  }
}

/* Location:
 * Qualified Name:     MiseEnReexamenDemande
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */