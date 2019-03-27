package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.DossierExamenSpec;
import fr.unedic.cali.dom.affectation.LigneSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;
import java.util.Iterator;
import java.util.List;

public class FiltreLigne
  implements FiltreTemporel
{
  private LigneSpec m_ligne;
  
  public FiltreLigne(LigneSpec p_ligne)
  {
    m_ligne = p_ligne;
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    if (p_temporel.estType(DemandeSpec.class))
    {
      DemandeSpec demande = (DemandeSpec)p_temporel;
      
      boolean trouve = false;
      if (demande.getListeDossiersExamen() != null)
      {
        Iterator iterateur = demande.getListeDossiersExamen().iterator();
        while (iterateur.hasNext())
        {
          DossierExamenSpec dosEx = (DossierExamenSpec)iterateur.next();
          if ((dosEx.getDossierAffecte() != null) && 
            (dosEx.getDossierAffecte().getProduit() != null) && 
            (m_ligne.equals(dosEx.getDossierAffecte().getProduit().getLigne()))) {
            trouve = true;
          }
        }
      }
      return trouve;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreLigne
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */