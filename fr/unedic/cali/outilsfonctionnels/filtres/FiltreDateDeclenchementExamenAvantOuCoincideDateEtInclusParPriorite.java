package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.EvenementReferenceExamenSpec;
import fr.unedic.cali.dom.FormulaireSpec;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreDateDeclenchementExamenAvantOuCoincideDateEtInclusParPriorite
  implements FiltreTemporel
{
  private Damj m_dateSeuil;
  private DemandeSpec m_demandeReference;
  private EvenementReferenceExamenSpec m_ere;
  
  public FiltreDateDeclenchementExamenAvantOuCoincideDateEtInclusParPriorite(Damj p_dateSeuil, DemandeSpec p_demande)
  {
    m_dateSeuil = p_dateSeuil;
    m_demandeReference = p_demande;
    m_ere = p_demande.getEvenementReferenceExamen();
  }
  
  public FiltreDateDeclenchementExamenAvantOuCoincideDateEtInclusParPriorite(Damj p_dateSeuil, DemandeSpec p_demande, EvenementReferenceExamenSpec p_ere)
  {
    m_dateSeuil = p_dateSeuil;
    m_demandeReference = p_demande;
    m_ere = p_ere;
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    DemandeSpec demande = (DemandeSpec)p_temporel;
    Damj dde = ((DemandeSpec)p_temporel).getDateDeclenchementExamen();
    EvenementReferenceExamenSpec ere = ((DemandeSpec)p_temporel).getEvenementReferenceExamen();
    if (dde != null)
    {
      if (dde.estAvant(m_dateSeuil)) {
        return true;
      }
      if ((dde.coincideAvec(getDateSeuil())) && (getDemandeReference().getGamme().getPriorite() < demande.getGamme().getPriorite())) {
        return true;
      }
      if ((dde.coincideAvec(getDateSeuil())) && (getDemandeReference().getGamme().getPriorite() == demande.getGamme().getPriorite()) && (getDemandeReference().getEvenementReferenceExamen().getPriorite() < ere.getPriorite())) {
        return true;
      }
      if ((dde.coincideAvec(getDateSeuil())) && (getDemandeReference().getGamme().getPriorite() == demande.getGamme().getPriorite()) && (getDemandeReference().getEvenementReferenceExamen().getPriorite() <= ere.getPriorite())) {
        if ((getDemandeReference().getDateDepot() != null) && (demande.getDateDepot() != null))
        {
          if (getDemandeReference().getDateDepot().compareTo(demande.getDateDepot()) > 0) {
            return true;
          }
        }
        else if ((getDemandeReference().getFormulaire().getDateCreationDal() != null) && (demande.getFormulaire().getDateCreationDal() != null) && 
          (getDemandeReference().getFormulaire().getDateCreationDal().compareTo(demande.getFormulaire().getDateCreationDal()) > 0)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public Damj getDateSeuil()
  {
    return m_dateSeuil;
  }
  
  public void setDateSeuil(Damj p_dateSeuil)
  {
    m_dateSeuil = p_dateSeuil;
  }
  
  public DemandeSpec getDemandeReference()
  {
    return m_demandeReference;
  }
  
  public void setDemandeReference(DemandeSpec p_demandeReference)
  {
    m_demandeReference = p_demandeReference;
  }
  
  public EvenementReferenceExamenSpec getEre()
  {
    return m_ere;
  }
  
  public void setEre(EvenementReferenceExamenSpec p_ere)
  {
    m_ere = p_ere;
  }
}

/* Location:
 * Qualified Name:     FiltreDateDeclenchementExamenAvantOuCoincideDateEtInclusParPriorite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */