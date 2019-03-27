package fr.unedic.cali.utilitaire.filtres.adaptateur;

import fr.unedic.cali.dom.DecisionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.utilitaire.convertisseur.ConvertisseurDemandeDecision;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.Temporel;

public class FiltreAdaptateurDemandeVersDecision
  implements FiltreCaliSpec
{
  private static final long serialVersionUID = 1L;
  FiltreCaliSpec m_filtre;
  
  public FiltreAdaptateurDemandeVersDecision(FiltreCaliSpec p_filtre)
  {
    m_filtre = p_filtre;
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    return accepterElement(p_temporel);
  }
  
  public int getTypeTemporelTraite()
  {
    return 2;
  }
  
  public int getTypeElementManipule()
  {
    return 2;
  }
  
  public boolean accepterElement(Temporel p_temporel)
  {
    if (!(p_temporel instanceof DemandeSpec)) {
      try
      {
        GestionnaireErreur.getInstance().genererException("PR_CALI_OBJET_TYPE_ATTENDUE", new Object[] { "DemandeSpec" }, 3);
      }
      catch (CoucheLogiqueException ex) {}
    }
    DemandeSpec demande = (DemandeSpec)p_temporel;
    Chronologie chronologie = ConvertisseurDemandeDecision.convertirDemandeEnDecisions(demande);
    chronologie.iterer();
    while (chronologie.encoreSuivant())
    {
      DecisionSpec decision = (DecisionSpec)chronologie.elementSuivant();
      if (m_filtre.accepterElement(decision)) {
        return true;
      }
    }
    return false;
  }
  
  public void initialiserCache()
  {
    m_filtre.initialiserCache();
  }
}

/* Location:
 * Qualified Name:     FiltreAdaptateurDemandeVersDecision
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */