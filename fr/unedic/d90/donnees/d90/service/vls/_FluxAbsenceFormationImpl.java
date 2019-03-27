package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import fr.unedic.util.temps.Damj;
import java.io.Serializable;
import java.math.BigDecimal;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _FluxAbsenceFormationImpl
  extends FluxAbsenceFormation
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _FluxAbsenceFormation m_fluxAbsenceFormationInfra;
  
  public _FluxAbsenceFormationImpl()
  {
    m_fluxAbsenceFormationInfra = new _FluxAbsenceFormation();
  }
  
  public _FluxAbsenceFormationImpl(_FluxAbsenceFormation pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("FluxAbsenceFormationInfra", pValeur);
    
    m_fluxAbsenceFormationInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_fluxAbsenceFormationInfra;
  }
  
  public String getIdentifiant()
  {
    return m_fluxAbsenceFormationInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_fluxAbsenceFormationInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_fluxAbsenceFormationInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_fluxAbsenceFormationInfra.set_C_ETAT(pCode);
  }
  
  public BigDecimal getIdNationalDE()
  {
    return m_fluxAbsenceFormationInfra.getIdNationalDE();
  }
  
  public String getCodeErreurIdNationalDE()
  {
    return m_fluxAbsenceFormationInfra.getIdNationalDE_C_ERR();
  }
  
  public void setIdNationalDE(BigDecimal pValeur)
  {
    m_fluxAbsenceFormationInfra.setIdNationalDE(pValeur);
  }
  
  public void setCodeErreurIdNationalDE(String pCodeErreur)
  {
    m_fluxAbsenceFormationInfra.setIdNationalDE_C_ERR(pCodeErreur);
  }
  
  public String getIdentifiantDESurPE()
  {
    return m_fluxAbsenceFormationInfra.getIdentifiantDESurPE();
  }
  
  public String getCodeErreurIdentifiantDESurPE()
  {
    return m_fluxAbsenceFormationInfra.getIdentifiantDESurPE_C_ERR();
  }
  
  public void setIdentifiantDESurPE(String pValeur)
  {
    m_fluxAbsenceFormationInfra.setIdentifiantDESurPE(pValeur);
  }
  
  public void setCodeErreurIdentifiantDESurPE(String pCodeErreur)
  {
    m_fluxAbsenceFormationInfra.setIdentifiantDESurPE_C_ERR(pCodeErreur);
  }
  
  public String getIdentifiantPE()
  {
    return m_fluxAbsenceFormationInfra.getIdentifiantPE();
  }
  
  public String getCodeErreurIdentifiantPE()
  {
    return m_fluxAbsenceFormationInfra.getIdentifiantPE_C_ERR();
  }
  
  public void setIdentifiantPE(String pValeur)
  {
    m_fluxAbsenceFormationInfra.setIdentifiantPE(pValeur);
  }
  
  public void setCodeErreurIdentifiantPE(String pCodeErreur)
  {
    m_fluxAbsenceFormationInfra.setIdentifiantPE_C_ERR(pCodeErreur);
  }
  
  public Damj getDateTraitement()
  {
    return m_fluxAbsenceFormationInfra.getDateTraitement();
  }
  
  public String getCodeErreurDateTraitement()
  {
    return m_fluxAbsenceFormationInfra.getDateTraitement_C_ERR();
  }
  
  public void setDateTraitement(Damj pValeur)
  {
    m_fluxAbsenceFormationInfra.setDateTraitement(pValeur);
  }
  
  public void setCodeErreurDateTraitement(String pCodeErreur)
  {
    m_fluxAbsenceFormationInfra.setDateTraitement_C_ERR(pCodeErreur);
  }
  
  public String getMoisActualisation()
  {
    return m_fluxAbsenceFormationInfra.getMoisActualisation();
  }
  
  public String getCodeErreurMoisActualisation()
  {
    return m_fluxAbsenceFormationInfra.getMoisActualisation_C_ERR();
  }
  
  public void setMoisActualisation(String pValeur)
  {
    m_fluxAbsenceFormationInfra.setMoisActualisation(pValeur);
  }
  
  public void setCodeErreurMoisActualisation(String pCodeErreur)
  {
    m_fluxAbsenceFormationInfra.setMoisActualisation_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getIdentifiantPlanFormation()
  {
    return m_fluxAbsenceFormationInfra.getIdentifiantPlanFormation();
  }
  
  public String getCodeErreurIdentifiantPlanFormation()
  {
    return m_fluxAbsenceFormationInfra.getIdentifiantPlanFormation_C_ERR();
  }
  
  public void setIdentifiantPlanFormation(BigDecimal pValeur)
  {
    m_fluxAbsenceFormationInfra.setIdentifiantPlanFormation(pValeur);
  }
  
  public void setCodeErreurIdentifiantPlanFormation(String pCodeErreur)
  {
    m_fluxAbsenceFormationInfra.setIdentifiantPlanFormation_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getNbOccurrencePeriodesAbsence()
  {
    return m_fluxAbsenceFormationInfra.getNbOccurrencePeriodesAbsence();
  }
  
  public String getCodeErreurNbOccurrencePeriodesAbsence()
  {
    return m_fluxAbsenceFormationInfra.getNbOccurrencePeriodesAbsence_C_ERR();
  }
  
  public void setNbOccurrencePeriodesAbsence(BigDecimal pValeur)
  {
    m_fluxAbsenceFormationInfra.setNbOccurrencePeriodesAbsence(pValeur);
  }
  
  public void setCodeErreurNbOccurrencePeriodesAbsence(String pCodeErreur)
  {
    m_fluxAbsenceFormationInfra.setNbOccurrencePeriodesAbsence_C_ERR(pCodeErreur);
  }
  
  public String getIndicateurFinListe()
  {
    return m_fluxAbsenceFormationInfra.getIndicateurFinListe();
  }
  
  public String getCodeErreurIndicateurFinListe()
  {
    return m_fluxAbsenceFormationInfra.getIndicateurFinListe_C_ERR();
  }
  
  public void setIndicateurFinListe(String pValeur)
  {
    m_fluxAbsenceFormationInfra.setIndicateurFinListe(pValeur);
  }
  
  public void setCodeErreurIndicateurFinListe(String pCodeErreur)
  {
    m_fluxAbsenceFormationInfra.setIndicateurFinListe_C_ERR(pCodeErreur);
  }
  
  public String getIndicateurPresenceRubrique()
  {
    return m_fluxAbsenceFormationInfra.getIndicateurPresenceRubrique();
  }
  
  public String getCodeErreurIndicateurPresenceRubrique()
  {
    return m_fluxAbsenceFormationInfra.getIndicateurPresenceRubrique_C_ERR();
  }
  
  public void setIndicateurPresenceRubrique(String pValeur)
  {
    m_fluxAbsenceFormationInfra.setIndicateurPresenceRubrique(pValeur);
  }
  
  public void setCodeErreurIndicateurPresenceRubrique(String pCodeErreur)
  {
    m_fluxAbsenceFormationInfra.setIndicateurPresenceRubrique_C_ERR(pCodeErreur);
  }
  
  public ListeFluxPeriodesAbsenceFormation getListeFluxPeriodesAbsenceFormation()
  {
    _ListeFluxPeriodesAbsenceFormation infraItem = m_fluxAbsenceFormationInfra.getListeFluxPeriodesAbsenceFormation();
    _ListeFluxPeriodesAbsenceFormationImpl resultat = null;
    if (infraItem != null) {
      resultat = new _ListeFluxPeriodesAbsenceFormationImpl(infraItem);
    }
    return resultat;
  }
  
  public void setListeFluxPeriodesAbsenceFormation(ListeFluxPeriodesAbsenceFormation pValeur)
  {
    if (pValeur == null)
    {
      m_fluxAbsenceFormationInfra.setListeFluxPeriodesAbsenceFormation(null);
    }
    else
    {
      _ListeFluxPeriodesAbsenceFormationImpl subImpl = (_ListeFluxPeriodesAbsenceFormationImpl)pValeur;
      m_fluxAbsenceFormationInfra.setListeFluxPeriodesAbsenceFormation(subImpl.getListeFluxPeriodesAbsenceFormationInfra());
    }
  }
  
  public ListeFluxPeriodesAbsenceFormation setNewListeFluxPeriodesAbsenceFormation()
  {
    _ListeFluxPeriodesAbsenceFormationImpl item = new _ListeFluxPeriodesAbsenceFormationImpl();
    m_fluxAbsenceFormationInfra.setListeFluxPeriodesAbsenceFormation(item.getListeFluxPeriodesAbsenceFormationInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public ListeFluxPeriodesAbsenceFormation setNewListeFluxPeriodesAbsenceFormation_listeFluxPeriodesAbsenceFormation()
  {
    return setNewListeFluxPeriodesAbsenceFormation();
  }
  
  public _FluxAbsenceFormation getFluxAbsenceFormationInfra()
  {
    return m_fluxAbsenceFormationInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    if ((getCodeErreurIdNationalDE() != null) && 
      ("".equals(getCodeErreurIdNationalDE()))) {
      return true;
    }
    if ((getCodeErreurIdentifiantDESurPE() != null) && 
      ("".equals(getCodeErreurIdentifiantDESurPE()))) {
      return true;
    }
    if ((getCodeErreurIdentifiantPE() != null) && 
      ("".equals(getCodeErreurIdentifiantPE()))) {
      return true;
    }
    if ((getCodeErreurDateTraitement() != null) && 
      ("".equals(getCodeErreurDateTraitement()))) {
      return true;
    }
    if ((getCodeErreurMoisActualisation() != null) && 
      ("".equals(getCodeErreurMoisActualisation()))) {
      return true;
    }
    if ((getCodeErreurIdentifiantPlanFormation() != null) && 
      ("".equals(getCodeErreurIdentifiantPlanFormation()))) {
      return true;
    }
    if ((getCodeErreurNbOccurrencePeriodesAbsence() != null) && 
      ("".equals(getCodeErreurNbOccurrencePeriodesAbsence()))) {
      return true;
    }
    if ((getCodeErreurIndicateurFinListe() != null) && 
      ("".equals(getCodeErreurIndicateurFinListe()))) {
      return true;
    }
    if ((getCodeErreurIndicateurPresenceRubrique() != null) && 
      ("".equals(getCodeErreurIndicateurPresenceRubrique()))) {
      return true;
    }
    Object objListeFluxPeriodesAbsenceFormation = getListeFluxPeriodesAbsenceFormation();
    if ((objListeFluxPeriodesAbsenceFormation != null) && 
      (getListeFluxPeriodesAbsenceFormation().isEnErreur())) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxAbsenceFormationImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */