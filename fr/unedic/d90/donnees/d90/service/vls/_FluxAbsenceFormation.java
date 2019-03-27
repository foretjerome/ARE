package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.databean.Attribute;
import fr.unedic.archi.databean.DataBean;
import fr.unedic.archi.databean.DataBeanImpl;
import fr.unedic.archi.databean.GettersHandler;
import fr.unedic.archi.databean.PropertyInfo;
import fr.unedic.archi.databean.SettersHandler;
import fr.unedic.archi.databean.StringAttribute;
import fr.unedic.util.temps.Damj;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

public class _FluxAbsenceFormation
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private String m__C_ETAT;
  private String m__IDENT;
  private BigDecimal m_idNationalDE;
  private String m_idNationalDE_C_ERR;
  private String m_identifiantDESurPE;
  private String m_identifiantDESurPE_C_ERR;
  private String m_identifiantPE;
  private String m_identifiantPE_C_ERR;
  private Damj m_dateTraitement;
  private String m_dateTraitement_C_ERR;
  private String m_moisActualisation;
  private String m_moisActualisation_C_ERR;
  private BigDecimal m_identifiantPlanFormation;
  private String m_identifiantPlanFormation_C_ERR;
  private BigDecimal m_nbOccurrencePeriodesAbsence;
  private String m_nbOccurrencePeriodesAbsence_C_ERR;
  private String m_indicateurFinListe;
  private String m_indicateurFinListe_C_ERR;
  private String m_indicateurPresenceRubrique;
  private String m_indicateurPresenceRubrique_C_ERR;
  private _ListeFluxPeriodesAbsenceFormation m_listeFluxPeriodesAbsenceFormation;
  private String m_listeFluxPeriodesAbsenceFormation_C_ERR;
  
  public String get_C_ETAT()
  {
    return m__C_ETAT;
  }
  
  public String get_IDENT()
  {
    return m__IDENT;
  }
  
  public void set_C_ETAT(String pCETAT)
  {
    m__C_ETAT = pCETAT;
  }
  
  public void set_IDENT(String pIDENT)
  {
    m__IDENT = pIDENT;
  }
  
  public BigDecimal getIdNationalDE()
  {
    return m_idNationalDE;
  }
  
  public String getIdNationalDE_C_ERR()
  {
    return m_idNationalDE_C_ERR;
  }
  
  public void setIdNationalDE(BigDecimal pValeur)
  {
    m_idNationalDE = pValeur;
  }
  
  public void setIdNationalDE_C_ERR(String pValeur_C_ERR)
  {
    m_idNationalDE_C_ERR = pValeur_C_ERR;
  }
  
  public String getIdentifiantDESurPE()
  {
    return m_identifiantDESurPE;
  }
  
  public String getIdentifiantDESurPE_C_ERR()
  {
    return m_identifiantDESurPE_C_ERR;
  }
  
  public void setIdentifiantDESurPE(String pValeur)
  {
    m_identifiantDESurPE = pValeur;
  }
  
  public void setIdentifiantDESurPE_C_ERR(String pValeur_C_ERR)
  {
    m_identifiantDESurPE_C_ERR = pValeur_C_ERR;
  }
  
  public String getIdentifiantPE()
  {
    return m_identifiantPE;
  }
  
  public String getIdentifiantPE_C_ERR()
  {
    return m_identifiantPE_C_ERR;
  }
  
  public void setIdentifiantPE(String pValeur)
  {
    m_identifiantPE = pValeur;
  }
  
  public void setIdentifiantPE_C_ERR(String pValeur_C_ERR)
  {
    m_identifiantPE_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateTraitement()
  {
    return m_dateTraitement;
  }
  
  public String getDateTraitement_C_ERR()
  {
    return m_dateTraitement_C_ERR;
  }
  
  public void setDateTraitement(Damj pValeur)
  {
    m_dateTraitement = pValeur;
  }
  
  public void setDateTraitement_C_ERR(String pValeur_C_ERR)
  {
    m_dateTraitement_C_ERR = pValeur_C_ERR;
  }
  
  public String getMoisActualisation()
  {
    return m_moisActualisation;
  }
  
  public String getMoisActualisation_C_ERR()
  {
    return m_moisActualisation_C_ERR;
  }
  
  public void setMoisActualisation(String pValeur)
  {
    m_moisActualisation = pValeur;
  }
  
  public void setMoisActualisation_C_ERR(String pValeur_C_ERR)
  {
    m_moisActualisation_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getIdentifiantPlanFormation()
  {
    return m_identifiantPlanFormation;
  }
  
  public String getIdentifiantPlanFormation_C_ERR()
  {
    return m_identifiantPlanFormation_C_ERR;
  }
  
  public void setIdentifiantPlanFormation(BigDecimal pValeur)
  {
    m_identifiantPlanFormation = pValeur;
  }
  
  public void setIdentifiantPlanFormation_C_ERR(String pValeur_C_ERR)
  {
    m_identifiantPlanFormation_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getNbOccurrencePeriodesAbsence()
  {
    return m_nbOccurrencePeriodesAbsence;
  }
  
  public String getNbOccurrencePeriodesAbsence_C_ERR()
  {
    return m_nbOccurrencePeriodesAbsence_C_ERR;
  }
  
  public void setNbOccurrencePeriodesAbsence(BigDecimal pValeur)
  {
    m_nbOccurrencePeriodesAbsence = pValeur;
  }
  
  public void setNbOccurrencePeriodesAbsence_C_ERR(String pValeur_C_ERR)
  {
    m_nbOccurrencePeriodesAbsence_C_ERR = pValeur_C_ERR;
  }
  
  public String getIndicateurFinListe()
  {
    return m_indicateurFinListe;
  }
  
  public String getIndicateurFinListe_C_ERR()
  {
    return m_indicateurFinListe_C_ERR;
  }
  
  public void setIndicateurFinListe(String pValeur)
  {
    m_indicateurFinListe = pValeur;
  }
  
  public void setIndicateurFinListe_C_ERR(String pValeur_C_ERR)
  {
    m_indicateurFinListe_C_ERR = pValeur_C_ERR;
  }
  
  public String getIndicateurPresenceRubrique()
  {
    return m_indicateurPresenceRubrique;
  }
  
  public String getIndicateurPresenceRubrique_C_ERR()
  {
    return m_indicateurPresenceRubrique_C_ERR;
  }
  
  public void setIndicateurPresenceRubrique(String pValeur)
  {
    m_indicateurPresenceRubrique = pValeur;
  }
  
  public void setIndicateurPresenceRubrique_C_ERR(String pValeur_C_ERR)
  {
    m_indicateurPresenceRubrique_C_ERR = pValeur_C_ERR;
  }
  
  public _ListeFluxPeriodesAbsenceFormation getListeFluxPeriodesAbsenceFormation()
  {
    return m_listeFluxPeriodesAbsenceFormation;
  }
  
  public String getListeFluxPeriodesAbsenceFormation_C_ERR()
  {
    return m_listeFluxPeriodesAbsenceFormation_C_ERR;
  }
  
  public void setListeFluxPeriodesAbsenceFormation(_ListeFluxPeriodesAbsenceFormation pValeur)
  {
    m_listeFluxPeriodesAbsenceFormation = pValeur;
  }
  
  public void setListeFluxPeriodesAbsenceFormation_C_ERR(String pValeur_C_ERR)
  {
    m_listeFluxPeriodesAbsenceFormation_C_ERR = pValeur_C_ERR;
  }
  
  public Class _getAttributeType(String pPropertyName, String pAttributeName)
  {
    StringBuffer attr = new StringBuffer();
    attr.append("m_");
    if (pPropertyName != null) {
      attr.append(pPropertyName);
    }
    attr.append("_").append(pAttributeName);
    String attrName = attr.toString();
    if ("m__C_ETAT".equals(attrName)) {
      return String.class;
    }
    if ("m__IDENT".equals(attrName)) {
      return String.class;
    }
    if ("m_idNationalDE_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_identifiantDESurPE_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_identifiantPE_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateTraitement_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_moisActualisation_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_identifiantPlanFormation_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nbOccurrencePeriodesAbsence_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_indicateurFinListe_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_indicateurPresenceRubrique_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_listeFluxPeriodesAbsenceFormation_C_ERR".equals(attrName)) {
      return String.class;
    }
    return null;
  }
  
  public PropertyInfo _getPropertyInfo(String pElementName)
    throws TechniqueException
  {
    if ("idNationalDE".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("identifiantDESurPE".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("identifiantPE".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("dateTraitement".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("moisActualisation".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("identifiantPlanFormation".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("nbOccurrencePeriodesAbsence".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("indicateurFinListe".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("indicateurPresenceRubrique".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("ListeFluxPeriodesAbsenceFormation".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, _ListeFluxPeriodesAbsenceFormation.class, false);
      return info;
    }
    return null;
  }
  
  public int _getPropertyLength(String pElementName)
  {
    if ("idNationalDE".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("identifiantDESurPE".equals(pElementName)) {
      return 8;
    }
    if ("identifiantPE".equals(pElementName)) {
      return 3;
    }
    if ("dateTraitement".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("moisActualisation".equals(pElementName)) {
      return 6;
    }
    if ("identifiantPlanFormation".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("nbOccurrencePeriodesAbsence".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("indicateurFinListe".equals(pElementName)) {
      return 1;
    }
    if ("indicateurPresenceRubrique".equals(pElementName)) {
      return 1;
    }
    if ("ListeFluxPeriodesAbsenceFormation".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    return -1;
  }
  
  public Object _getProperty(String pName)
    throws Exception
  {
    if ("idNationalDE".equals(pName)) {
      return m_idNationalDE;
    }
    if ("identifiantDESurPE".equals(pName)) {
      return m_identifiantDESurPE;
    }
    if ("identifiantPE".equals(pName)) {
      return m_identifiantPE;
    }
    if ("dateTraitement".equals(pName)) {
      return m_dateTraitement;
    }
    if ("moisActualisation".equals(pName)) {
      return m_moisActualisation;
    }
    if ("identifiantPlanFormation".equals(pName)) {
      return m_identifiantPlanFormation;
    }
    if ("nbOccurrencePeriodesAbsence".equals(pName)) {
      return m_nbOccurrencePeriodesAbsence;
    }
    if ("indicateurFinListe".equals(pName)) {
      return m_indicateurFinListe;
    }
    if ("indicateurPresenceRubrique".equals(pName)) {
      return m_indicateurPresenceRubrique;
    }
    if ("ListeFluxPeriodesAbsenceFormation".equals(pName)) {
      return m_listeFluxPeriodesAbsenceFormation;
    }
    return null;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    liste.add("idNationalDE");
    liste.add("identifiantDESurPE");
    liste.add("identifiantPE");
    liste.add("dateTraitement");
    liste.add("moisActualisation");
    liste.add("identifiantPlanFormation");
    liste.add("nbOccurrencePeriodesAbsence");
    liste.add("indicateurFinListe");
    liste.add("indicateurPresenceRubrique");
    liste.add("ListeFluxPeriodesAbsenceFormation");
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("idNationalDE");
    pListe.add("identifiantDESurPE");
    pListe.add("identifiantPE");
    pListe.add("dateTraitement");
    pListe.add("moisActualisation");
    pListe.add("identifiantPlanFormation");
    pListe.add("nbOccurrencePeriodesAbsence");
    pListe.add("indicateurFinListe");
    pListe.add("indicateurPresenceRubrique");
    pListe.add("ListeFluxPeriodesAbsenceFormation");
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("idNationalDE".equals(pName)) {
      m_idNationalDE = ((BigDecimal)pValeur);
    }
    if ("identifiantDESurPE".equals(pName)) {
      m_identifiantDESurPE = ((String)pValeur);
    }
    if ("identifiantPE".equals(pName)) {
      m_identifiantPE = ((String)pValeur);
    }
    if ("dateTraitement".equals(pName)) {
      m_dateTraitement = ((Damj)pValeur);
    }
    if ("moisActualisation".equals(pName)) {
      m_moisActualisation = ((String)pValeur);
    }
    if ("identifiantPlanFormation".equals(pName)) {
      m_identifiantPlanFormation = ((BigDecimal)pValeur);
    }
    if ("nbOccurrencePeriodesAbsence".equals(pName)) {
      m_nbOccurrencePeriodesAbsence = ((BigDecimal)pValeur);
    }
    if ("indicateurFinListe".equals(pName)) {
      m_indicateurFinListe = ((String)pValeur);
    }
    if ("indicateurPresenceRubrique".equals(pName)) {
      m_indicateurPresenceRubrique = ((String)pValeur);
    }
    if ("ListeFluxPeriodesAbsenceFormation".equals(pName)) {
      m_listeFluxPeriodesAbsenceFormation = ((_ListeFluxPeriodesAbsenceFormation)pValeur);
    }
  }
  
  public void _setAttribute(String pPropertyName, String pAttributeName, String pValeur)
    throws Exception
  {
    StringBuffer attr = new StringBuffer();
    attr.append("m_");
    if (pPropertyName != null) {
      attr.append(pPropertyName);
    }
    attr.append("_").append(pAttributeName);
    String attrName = attr.toString();
    if ("m__C_ETAT".equals(attrName)) {
      m__C_ETAT = pValeur;
    }
    if ("m__IDENT".equals(attrName)) {
      m__IDENT = pValeur;
    }
    if ("m_idNationalDE_C_ERR".equals(attrName)) {
      m_idNationalDE_C_ERR = pValeur;
    }
    if ("m_identifiantDESurPE_C_ERR".equals(attrName)) {
      m_identifiantDESurPE_C_ERR = pValeur;
    }
    if ("m_identifiantPE_C_ERR".equals(attrName)) {
      m_identifiantPE_C_ERR = pValeur;
    }
    if ("m_dateTraitement_C_ERR".equals(attrName)) {
      m_dateTraitement_C_ERR = pValeur;
    }
    if ("m_moisActualisation_C_ERR".equals(attrName)) {
      m_moisActualisation_C_ERR = pValeur;
    }
    if ("m_identifiantPlanFormation_C_ERR".equals(attrName)) {
      m_identifiantPlanFormation_C_ERR = pValeur;
    }
    if ("m_nbOccurrencePeriodesAbsence_C_ERR".equals(attrName)) {
      m_nbOccurrencePeriodesAbsence_C_ERR = pValeur;
    }
    if ("m_indicateurFinListe_C_ERR".equals(attrName)) {
      m_indicateurFinListe_C_ERR = pValeur;
    }
    if ("m_indicateurPresenceRubrique_C_ERR".equals(attrName)) {
      m_indicateurPresenceRubrique_C_ERR = pValeur;
    }
    if ("m_listeFluxPeriodesAbsenceFormation_C_ERR".equals(attrName)) {
      m_listeFluxPeriodesAbsenceFormation_C_ERR = pValeur;
    }
  }
  
  public String _getAttribute(String pPropertyName, String pAttributeName)
  {
    StringBuffer attr = new StringBuffer();
    attr.append("m_");
    if (pPropertyName != null) {
      attr.append(pPropertyName);
    }
    attr.append("_").append(pAttributeName);
    String attrName = attr.toString();
    if ("m__C_ETAT".equals(attrName)) {
      return m__C_ETAT;
    }
    if ("m__IDENT".equals(attrName)) {
      return m__IDENT;
    }
    if ("m_idNationalDE_C_ERR".equals(attrName)) {
      return m_idNationalDE_C_ERR;
    }
    if ("m_identifiantDESurPE_C_ERR".equals(attrName)) {
      return m_identifiantDESurPE_C_ERR;
    }
    if ("m_identifiantPE_C_ERR".equals(attrName)) {
      return m_identifiantPE_C_ERR;
    }
    if ("m_dateTraitement_C_ERR".equals(attrName)) {
      return m_dateTraitement_C_ERR;
    }
    if ("m_moisActualisation_C_ERR".equals(attrName)) {
      return m_moisActualisation_C_ERR;
    }
    if ("m_identifiantPlanFormation_C_ERR".equals(attrName)) {
      return m_identifiantPlanFormation_C_ERR;
    }
    if ("m_nbOccurrencePeriodesAbsence_C_ERR".equals(attrName)) {
      return m_nbOccurrencePeriodesAbsence_C_ERR;
    }
    if ("m_indicateurFinListe_C_ERR".equals(attrName)) {
      return m_indicateurFinListe_C_ERR;
    }
    if ("m_indicateurPresenceRubrique_C_ERR".equals(attrName)) {
      return m_indicateurPresenceRubrique_C_ERR;
    }
    if ("m_listeFluxPeriodesAbsenceFormation_C_ERR".equals(attrName)) {
      return m_listeFluxPeriodesAbsenceFormation_C_ERR;
    }
    return null;
  }
  
  public boolean equals(Object pObjet)
  {
    if (!(pObjet instanceof _FluxAbsenceFormation)) {
      return false;
    }
    _FluxAbsenceFormation x = (_FluxAbsenceFormation)pObjet;
    if (m_idNationalDE == null)
    {
      if (m_idNationalDE != null) {
        return false;
      }
    }
    else
    {
      if (m_idNationalDE == null) {
        return false;
      }
      if (!m_idNationalDE.equals(m_idNationalDE)) {
        return false;
      }
    }
    if (m_identifiantDESurPE == null)
    {
      if (m_identifiantDESurPE != null) {
        return false;
      }
    }
    else
    {
      if (m_identifiantDESurPE == null) {
        return false;
      }
      if (!m_identifiantDESurPE.equals(m_identifiantDESurPE)) {
        return false;
      }
    }
    if (m_identifiantPE == null)
    {
      if (m_identifiantPE != null) {
        return false;
      }
    }
    else
    {
      if (m_identifiantPE == null) {
        return false;
      }
      if (!m_identifiantPE.equals(m_identifiantPE)) {
        return false;
      }
    }
    if (m_dateTraitement == null)
    {
      if (m_dateTraitement != null) {
        return false;
      }
    }
    else
    {
      if (m_dateTraitement == null) {
        return false;
      }
      if (!m_dateTraitement.equals(m_dateTraitement)) {
        return false;
      }
    }
    if (m_moisActualisation == null)
    {
      if (m_moisActualisation != null) {
        return false;
      }
    }
    else
    {
      if (m_moisActualisation == null) {
        return false;
      }
      if (!m_moisActualisation.equals(m_moisActualisation)) {
        return false;
      }
    }
    if (m_identifiantPlanFormation == null)
    {
      if (m_identifiantPlanFormation != null) {
        return false;
      }
    }
    else
    {
      if (m_identifiantPlanFormation == null) {
        return false;
      }
      if (!m_identifiantPlanFormation.equals(m_identifiantPlanFormation)) {
        return false;
      }
    }
    if (m_nbOccurrencePeriodesAbsence == null)
    {
      if (m_nbOccurrencePeriodesAbsence != null) {
        return false;
      }
    }
    else
    {
      if (m_nbOccurrencePeriodesAbsence == null) {
        return false;
      }
      if (!m_nbOccurrencePeriodesAbsence.equals(m_nbOccurrencePeriodesAbsence)) {
        return false;
      }
    }
    if (m_indicateurFinListe == null)
    {
      if (m_indicateurFinListe != null) {
        return false;
      }
    }
    else
    {
      if (m_indicateurFinListe == null) {
        return false;
      }
      if (!m_indicateurFinListe.equals(m_indicateurFinListe)) {
        return false;
      }
    }
    if (m_indicateurPresenceRubrique == null)
    {
      if (m_indicateurPresenceRubrique != null) {
        return false;
      }
    }
    else
    {
      if (m_indicateurPresenceRubrique == null) {
        return false;
      }
      if (!m_indicateurPresenceRubrique.equals(m_indicateurPresenceRubrique)) {
        return false;
      }
    }
    if (m_listeFluxPeriodesAbsenceFormation == null)
    {
      if (m_listeFluxPeriodesAbsenceFormation != null) {
        return false;
      }
    }
    else
    {
      if (m_listeFluxPeriodesAbsenceFormation == null) {
        return false;
      }
      if (!m_listeFluxPeriodesAbsenceFormation.equals(m_listeFluxPeriodesAbsenceFormation)) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = 0;
    if (m_idNationalDE != null) {
      result += m_idNationalDE.hashCode();
    }
    if (m_identifiantDESurPE != null) {
      result += m_identifiantDESurPE.hashCode();
    }
    if (m_identifiantPE != null) {
      result += m_identifiantPE.hashCode();
    }
    if (m_dateTraitement != null) {
      result += m_dateTraitement.hashCode();
    }
    if (m_moisActualisation != null) {
      result += m_moisActualisation.hashCode();
    }
    if (m_identifiantPlanFormation != null) {
      result += m_identifiantPlanFormation.hashCode();
    }
    if (m_nbOccurrencePeriodesAbsence != null) {
      result += m_nbOccurrencePeriodesAbsence.hashCode();
    }
    if (m_indicateurFinListe != null) {
      result += m_indicateurFinListe.hashCode();
    }
    if (m_indicateurPresenceRubrique != null) {
      result += m_indicateurPresenceRubrique.hashCode();
    }
    if (m_listeFluxPeriodesAbsenceFormation != null) {
      result += m_listeFluxPeriodesAbsenceFormation.hashCode();
    }
    result *= 17;
    return result;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _FluxAbsenceFormation clone_FluxAbsenceFormation = new _FluxAbsenceFormation();
    clone_FluxAbsenceFormation.populateFrom_FluxAbsenceFormation(this);
    return clone_FluxAbsenceFormation;
  }
  
  public void populateFrom_FluxAbsenceFormation(_FluxAbsenceFormation pSource)
  {
    setIdNationalDE(pSource.getIdNationalDE());setIdentifiantDESurPE(pSource.getIdentifiantDESurPE());setIdentifiantPE(pSource.getIdentifiantPE());setDateTraitement(pSource.getDateTraitement());setMoisActualisation(pSource.getMoisActualisation());setIdentifiantPlanFormation(pSource.getIdentifiantPlanFormation());setNbOccurrencePeriodesAbsence(pSource.getNbOccurrencePeriodesAbsence());setIndicateurFinListe(pSource.getIndicateurFinListe());setIndicateurPresenceRubrique(pSource.getIndicateurPresenceRubrique());setListeFluxPeriodesAbsenceFormation(pSource.getListeFluxPeriodesAbsenceFormation());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_FluxAbsenceFormation");
    subToString(s);
    s.append("]");
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", idNationalDE: ");
    pSource.append(m_idNationalDE);
    pSource.append(", identifiantDESurPE: ");
    pSource.append(m_identifiantDESurPE);
    pSource.append(", identifiantPE: ");
    pSource.append(m_identifiantPE);
    pSource.append(", dateTraitement: ");
    pSource.append(m_dateTraitement);
    pSource.append(", moisActualisation: ");
    pSource.append(m_moisActualisation);
    pSource.append(", identifiantPlanFormation: ");
    pSource.append(m_identifiantPlanFormation);
    pSource.append(", nbOccurrencePeriodesAbsence: ");
    pSource.append(m_nbOccurrencePeriodesAbsence);
    pSource.append(", indicateurFinListe: ");
    pSource.append(m_indicateurFinListe);
    pSource.append(", indicateurPresenceRubrique: ");
    pSource.append(m_indicateurPresenceRubrique);
    pSource.append(", ListeFluxPeriodesAbsenceFormation: ");
    pSource.append(m_listeFluxPeriodesAbsenceFormation);
  }
  
  public void goThrough(GettersHandler pHandler)
    throws Exception
  {
    pHandler.startGoThrough(new Attribute[] { new StringAttribute("C_ETAT", get_C_ETAT()), new StringAttribute("IDENT", get_IDENT()) });
    
    subGoThrough(pHandler);
    
    pHandler.endGoThrough();
  }
  
  protected void subGoThrough(GettersHandler pHandler)
    throws Exception
  {
    pHandler.property("idNationalDE", getIdNationalDE(), new Attribute[] { new StringAttribute("C_ERR", getIdNationalDE_C_ERR()) });
    
    pHandler.property("identifiantDESurPE", getIdentifiantDESurPE(), new Attribute[] { new StringAttribute("C_ERR", getIdentifiantDESurPE_C_ERR()) });
    
    pHandler.property("identifiantPE", getIdentifiantPE(), new Attribute[] { new StringAttribute("C_ERR", getIdentifiantPE_C_ERR()) });
    
    pHandler.property("dateTraitement", getDateTraitement(), new Attribute[] { new StringAttribute("C_ERR", getDateTraitement_C_ERR()) });
    
    pHandler.property("moisActualisation", getMoisActualisation(), new Attribute[] { new StringAttribute("C_ERR", getMoisActualisation_C_ERR()) });
    
    pHandler.property("identifiantPlanFormation", getIdentifiantPlanFormation(), new Attribute[] { new StringAttribute("C_ERR", getIdentifiantPlanFormation_C_ERR()) });
    
    pHandler.property("nbOccurrencePeriodesAbsence", getNbOccurrencePeriodesAbsence(), new Attribute[] { new StringAttribute("C_ERR", getNbOccurrencePeriodesAbsence_C_ERR()) });
    
    pHandler.property("indicateurFinListe", getIndicateurFinListe(), new Attribute[] { new StringAttribute("C_ERR", getIndicateurFinListe_C_ERR()) });
    
    pHandler.property("indicateurPresenceRubrique", getIndicateurPresenceRubrique(), new Attribute[] { new StringAttribute("C_ERR", getIndicateurPresenceRubrique_C_ERR()) });
    
    DataBean ListeFluxPeriodesAbsenceFormation_Value = getListeFluxPeriodesAbsenceFormation();
    GettersHandler ListeFluxPeriodesAbsenceFormation_GettersHandler = pHandler.property("ListeFluxPeriodesAbsenceFormation", ListeFluxPeriodesAbsenceFormation_Value, new Attribute[] { new StringAttribute("C_ERR", getListeFluxPeriodesAbsenceFormation_C_ERR()) });
    if ((ListeFluxPeriodesAbsenceFormation_GettersHandler != null) && (ListeFluxPeriodesAbsenceFormation_Value != null)) {
      ListeFluxPeriodesAbsenceFormation_Value.goThrough(ListeFluxPeriodesAbsenceFormation_GettersHandler);
    }
  }
  
  public void goThrough(SettersHandler pHandler)
    throws Exception
  {
    pHandler.startGoThrough();
    
    subGoThrough(pHandler);
    
    pHandler.endGoThrough();
  }
  
  protected void subGoThrough(SettersHandler pHandler)
    throws Exception
  {
    set_C_ETAT(pHandler.stringAttribute("C_ETAT"));
    set_IDENT(pHandler.stringAttribute("IDENT"));
    setIdNationalDE((BigDecimal)pHandler.objectProperty("idNationalDE", BigDecimal.class));
    setIdNationalDE_C_ERR(pHandler.stringAttribute("idNationalDE", "C_ERR"));
    
    setIdentifiantDESurPE((String)pHandler.objectProperty("identifiantDESurPE", String.class));
    setIdentifiantDESurPE_C_ERR(pHandler.stringAttribute("identifiantDESurPE", "C_ERR"));
    
    setIdentifiantPE((String)pHandler.objectProperty("identifiantPE", String.class));
    setIdentifiantPE_C_ERR(pHandler.stringAttribute("identifiantPE", "C_ERR"));
    
    setDateTraitement((Damj)pHandler.objectProperty("dateTraitement", Damj.class));
    setDateTraitement_C_ERR(pHandler.stringAttribute("dateTraitement", "C_ERR"));
    
    setMoisActualisation((String)pHandler.objectProperty("moisActualisation", String.class));
    setMoisActualisation_C_ERR(pHandler.stringAttribute("moisActualisation", "C_ERR"));
    
    setIdentifiantPlanFormation((BigDecimal)pHandler.objectProperty("identifiantPlanFormation", BigDecimal.class));
    setIdentifiantPlanFormation_C_ERR(pHandler.stringAttribute("identifiantPlanFormation", "C_ERR"));
    
    setNbOccurrencePeriodesAbsence((BigDecimal)pHandler.objectProperty("nbOccurrencePeriodesAbsence", BigDecimal.class));
    setNbOccurrencePeriodesAbsence_C_ERR(pHandler.stringAttribute("nbOccurrencePeriodesAbsence", "C_ERR"));
    
    setIndicateurFinListe((String)pHandler.objectProperty("indicateurFinListe", String.class));
    setIndicateurFinListe_C_ERR(pHandler.stringAttribute("indicateurFinListe", "C_ERR"));
    
    setIndicateurPresenceRubrique((String)pHandler.objectProperty("indicateurPresenceRubrique", String.class));
    setIndicateurPresenceRubrique_C_ERR(pHandler.stringAttribute("indicateurPresenceRubrique", "C_ERR"));
    
    setListeFluxPeriodesAbsenceFormation((_ListeFluxPeriodesAbsenceFormation)pHandler.databeanProperty("ListeFluxPeriodesAbsenceFormation", _ListeFluxPeriodesAbsenceFormation.class));
    setListeFluxPeriodesAbsenceFormation_C_ERR(pHandler.stringAttribute("ListeFluxPeriodesAbsenceFormation", "C_ERR"));
  }
  
  public String _getDatabeanName()
  {
    return "FluxAbsenceFormation";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("idNationalDE".equals(pElementName)) {
      return true;
    }
    if ("identifiantDESurPE".equals(pElementName)) {
      return true;
    }
    if ("identifiantPE".equals(pElementName)) {
      return true;
    }
    if ("dateTraitement".equals(pElementName)) {
      return true;
    }
    if ("moisActualisation".equals(pElementName)) {
      return true;
    }
    if ("identifiantPlanFormation".equals(pElementName)) {
      return true;
    }
    if ("nbOccurrencePeriodesAbsence".equals(pElementName)) {
      return true;
    }
    if ("indicateurFinListe".equals(pElementName)) {
      return true;
    }
    if ("indicateurPresenceRubrique".equals(pElementName)) {
      return true;
    }
    if ("ListeFluxPeriodesAbsenceFormation".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxAbsenceFormation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */