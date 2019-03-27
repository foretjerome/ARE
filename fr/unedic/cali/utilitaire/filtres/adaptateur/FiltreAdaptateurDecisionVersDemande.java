package fr.unedic.cali.utilitaire.filtres.adaptateur;

import fr.unedic.cali.dom.DecisionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.utilitaire.convertisseur.ConvertisseurDemandeDecision;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Temporel;

public class FiltreAdaptateurDecisionVersDemande
  implements FiltreCaliSpec
{
  private static final long serialVersionUID = 1L;
  FiltreCaliSpec m_filtre;
  
  public FiltreAdaptateurDecisionVersDemande(FiltreCaliSpec p_filtre)
  {
    m_filtre = p_filtre;
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    return accepterElement(p_temporel);
  }
  
  public int getTypeElementManipule()
  {
    return 1;
  }
  
  public boolean accepterElement(Temporel p_temporel)
  {
    if (!(p_temporel instanceof DecisionSpec)) {
      try
      {
        GestionnaireErreur.getInstance().genererException("PR_CALI_OBJET_TYPE_ATTENDUE", new Object[] { "DecisionSpec" }, 3);
      }
      catch (CoucheLogiqueException ex) {}
    }
    DecisionSpec decision = (DecisionSpec)p_temporel;
    boolean accepter = false;
    DemandeSpec demande = ConvertisseurDemandeDecision.convertirDecisionEnDemande(decision);
    accepter = m_filtre.accepterElement(demande);
    return accepter;
  }
  
  public void initialiserCache()
  {
    m_filtre.initialiserCache();
  }
}

/* Location:
 * Qualified Name:     FiltreAdaptateurDecisionVersDemande
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */