package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import fr.unedic.util.temps.Damj;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _FluxPeriodeAbsenceFormationImpl
  extends FluxPeriodeAbsenceFormation
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _FluxPeriodeAbsenceFormation m_fluxPeriodeAbsenceFormationInfra;
  
  public _FluxPeriodeAbsenceFormationImpl()
  {
    m_fluxPeriodeAbsenceFormationInfra = new _FluxPeriodeAbsenceFormation();
  }
  
  public _FluxPeriodeAbsenceFormationImpl(_FluxPeriodeAbsenceFormation pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("FluxPeriodeAbsenceFormationInfra", pValeur);
    
    m_fluxPeriodeAbsenceFormationInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_fluxPeriodeAbsenceFormationInfra;
  }
  
  public String getIdentifiant()
  {
    return m_fluxPeriodeAbsenceFormationInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_fluxPeriodeAbsenceFormationInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_fluxPeriodeAbsenceFormationInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_fluxPeriodeAbsenceFormationInfra.set_C_ETAT(pCode);
  }
  
  public Damj getDateDebutAbsence()
  {
    return m_fluxPeriodeAbsenceFormationInfra.getDateDebutAbsence();
  }
  
  public String getCodeErreurDateDebutAbsence()
  {
    return m_fluxPeriodeAbsenceFormationInfra.getDateDebutAbsence_C_ERR();
  }
  
  public void setDateDebutAbsence(Damj pValeur)
  {
    m_fluxPeriodeAbsenceFormationInfra.setDateDebutAbsence(pValeur);
  }
  
  public void setCodeErreurDateDebutAbsence(String pCodeErreur)
  {
    m_fluxPeriodeAbsenceFormationInfra.setDateDebutAbsence_C_ERR(pCodeErreur);
  }
  
  public Damj getDateFinAbsence()
  {
    return m_fluxPeriodeAbsenceFormationInfra.getDateFinAbsence();
  }
  
  public String getCodeErreurDateFinAbsence()
  {
    return m_fluxPeriodeAbsenceFormationInfra.getDateFinAbsence_C_ERR();
  }
  
  public void setDateFinAbsence(Damj pValeur)
  {
    m_fluxPeriodeAbsenceFormationInfra.setDateFinAbsence(pValeur);
  }
  
  public void setCodeErreurDateFinAbsence(String pCodeErreur)
  {
    m_fluxPeriodeAbsenceFormationInfra.setDateFinAbsence_C_ERR(pCodeErreur);
  }
  
  public String getCodeAction()
  {
    return m_fluxPeriodeAbsenceFormationInfra.getCodeAction();
  }
  
  public String getCodeErreurCodeAction()
  {
    return m_fluxPeriodeAbsenceFormationInfra.getCodeAction_C_ERR();
  }
  
  public void setCodeAction(String pValeur)
  {
    m_fluxPeriodeAbsenceFormationInfra.setCodeAction(pValeur);
  }
  
  public void setCodeErreurCodeAction(String pCodeErreur)
  {
    m_fluxPeriodeAbsenceFormationInfra.setCodeAction_C_ERR(pCodeErreur);
  }
  
  public String getMotifAbsence()
  {
    return m_fluxPeriodeAbsenceFormationInfra.getMotifAbsence();
  }
  
  public String getCodeErreurMotifAbsence()
  {
    return m_fluxPeriodeAbsenceFormationInfra.getMotifAbsence_C_ERR();
  }
  
  public void setMotifAbsence(String pValeur)
  {
    m_fluxPeriodeAbsenceFormationInfra.setMotifAbsence(pValeur);
  }
  
  public void setCodeErreurMotifAbsence(String pCodeErreur)
  {
    m_fluxPeriodeAbsenceFormationInfra.setMotifAbsence_C_ERR(pCodeErreur);
  }
  
  public _FluxPeriodeAbsenceFormation getFluxPeriodeAbsenceFormationInfra()
  {
    return m_fluxPeriodeAbsenceFormationInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    if ((getCodeErreurDateDebutAbsence() != null) && 
      ("".equals(getCodeErreurDateDebutAbsence()))) {
      return true;
    }
    if ((getCodeErreurDateFinAbsence() != null) && 
      ("".equals(getCodeErreurDateFinAbsence()))) {
      return true;
    }
    if ((getCodeErreurCodeAction() != null) && 
      ("".equals(getCodeErreurCodeAction()))) {
      return true;
    }
    if ((getCodeErreurMotifAbsence() != null) && 
      ("".equals(getCodeErreurMotifAbsence()))) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxPeriodeAbsenceFormationImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */