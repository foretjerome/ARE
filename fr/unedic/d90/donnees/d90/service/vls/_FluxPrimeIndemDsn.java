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

public class _FluxPrimeIndemDsn
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private String m__C_ETAT;
  private String m__IDENT;
  private String m_typeEnreg;
  private String m_typeEnreg_C_ERR;
  private String m_numNIRCertifie;
  private String m_numNIRCertifie_C_ERR;
  private String m_nomDeclare;
  private String m_nomDeclare_C_ERR;
  private String m_prenomDeclare;
  private String m_prenomDeclare_C_ERR;
  private Damj m_dateNaissance;
  private String m_dateNaissance_C_ERR;
  private String m_contexteEmission;
  private String m_contexteEmission_C_ERR;
  private String m_codeMessage;
  private String m_codeMessage_C_ERR;
  private BigDecimal m_numeroVersion;
  private String m_numeroVersion_C_ERR;
  private BigDecimal m_numeroSousVersion;
  private String m_numeroSousVersion_C_ERR;
  private String m_codeAction;
  private String m_codeAction_C_ERR;
  private BigDecimal m_idTechnique;
  private String m_idTechnique_C_ERR;
  private String m_numeroRCI;
  private String m_numeroRCI_C_ERR;
  private String m_cxass;
  private String m_cxass_C_ERR;
  private String m_rsin;
  private String m_rsin_C_ERR;
  private _ListeFluxPrimeIndemVerseesDsn m_listeFluxPrimeIndemVerseesDsn;
  private String m_listeFluxPrimeIndemVerseesDsn_C_ERR;
  private String m_idFlux;
  private String m_idFlux_C_ERR;
  
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
  
  public String getTypeEnreg()
  {
    return m_typeEnreg;
  }
  
  public String getTypeEnreg_C_ERR()
  {
    return m_typeEnreg_C_ERR;
  }
  
  public void setTypeEnreg(String pValeur)
  {
    m_typeEnreg = pValeur;
  }
  
  public void setTypeEnreg_C_ERR(String pValeur_C_ERR)
  {
    m_typeEnreg_C_ERR = pValeur_C_ERR;
  }
  
  public String getNumNIRCertifie()
  {
    return m_numNIRCertifie;
  }
  
  public String getNumNIRCertifie_C_ERR()
  {
    return m_numNIRCertifie_C_ERR;
  }
  
  public void setNumNIRCertifie(String pValeur)
  {
    m_numNIRCertifie = pValeur;
  }
  
  public void setNumNIRCertifie_C_ERR(String pValeur_C_ERR)
  {
    m_numNIRCertifie_C_ERR = pValeur_C_ERR;
  }
  
  public String getNomDeclare()
  {
    return m_nomDeclare;
  }
  
  public String getNomDeclare_C_ERR()
  {
    return m_nomDeclare_C_ERR;
  }
  
  public void setNomDeclare(String pValeur)
  {
    m_nomDeclare = pValeur;
  }
  
  public void setNomDeclare_C_ERR(String pValeur_C_ERR)
  {
    m_nomDeclare_C_ERR = pValeur_C_ERR;
  }
  
  public String getPrenomDeclare()
  {
    return m_prenomDeclare;
  }
  
  public String getPrenomDeclare_C_ERR()
  {
    return m_prenomDeclare_C_ERR;
  }
  
  public void setPrenomDeclare(String pValeur)
  {
    m_prenomDeclare = pValeur;
  }
  
  public void setPrenomDeclare_C_ERR(String pValeur_C_ERR)
  {
    m_prenomDeclare_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateNaissance()
  {
    return m_dateNaissance;
  }
  
  public String getDateNaissance_C_ERR()
  {
    return m_dateNaissance_C_ERR;
  }
  
  public void setDateNaissance(Damj pValeur)
  {
    m_dateNaissance = pValeur;
  }
  
  public void setDateNaissance_C_ERR(String pValeur_C_ERR)
  {
    m_dateNaissance_C_ERR = pValeur_C_ERR;
  }
  
  public String getContexteEmission()
  {
    return m_contexteEmission;
  }
  
  public String getContexteEmission_C_ERR()
  {
    return m_contexteEmission_C_ERR;
  }
  
  public void setContexteEmission(String pValeur)
  {
    m_contexteEmission = pValeur;
  }
  
  public void setContexteEmission_C_ERR(String pValeur_C_ERR)
  {
    m_contexteEmission_C_ERR = pValeur_C_ERR;
  }
  
  public String getCodeMessage()
  {
    return m_codeMessage;
  }
  
  public String getCodeMessage_C_ERR()
  {
    return m_codeMessage_C_ERR;
  }
  
  public void setCodeMessage(String pValeur)
  {
    m_codeMessage = pValeur;
  }
  
  public void setCodeMessage_C_ERR(String pValeur_C_ERR)
  {
    m_codeMessage_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getNumeroVersion()
  {
    return m_numeroVersion;
  }
  
  public String getNumeroVersion_C_ERR()
  {
    return m_numeroVersion_C_ERR;
  }
  
  public void setNumeroVersion(BigDecimal pValeur)
  {
    m_numeroVersion = pValeur;
  }
  
  public void setNumeroVersion_C_ERR(String pValeur_C_ERR)
  {
    m_numeroVersion_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getNumeroSousVersion()
  {
    return m_numeroSousVersion;
  }
  
  public String getNumeroSousVersion_C_ERR()
  {
    return m_numeroSousVersion_C_ERR;
  }
  
  public void setNumeroSousVersion(BigDecimal pValeur)
  {
    m_numeroSousVersion = pValeur;
  }
  
  public void setNumeroSousVersion_C_ERR(String pValeur_C_ERR)
  {
    m_numeroSousVersion_C_ERR = pValeur_C_ERR;
  }
  
  public String getCodeAction()
  {
    return m_codeAction;
  }
  
  public String getCodeAction_C_ERR()
  {
    return m_codeAction_C_ERR;
  }
  
  public void setCodeAction(String pValeur)
  {
    m_codeAction = pValeur;
  }
  
  public void setCodeAction_C_ERR(String pValeur_C_ERR)
  {
    m_codeAction_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getIdTechnique()
  {
    return m_idTechnique;
  }
  
  public String getIdTechnique_C_ERR()
  {
    return m_idTechnique_C_ERR;
  }
  
  public void setIdTechnique(BigDecimal pValeur)
  {
    m_idTechnique = pValeur;
  }
  
  public void setIdTechnique_C_ERR(String pValeur_C_ERR)
  {
    m_idTechnique_C_ERR = pValeur_C_ERR;
  }
  
  public String getNumeroRCI()
  {
    return m_numeroRCI;
  }
  
  public String getNumeroRCI_C_ERR()
  {
    return m_numeroRCI_C_ERR;
  }
  
  public void setNumeroRCI(String pValeur)
  {
    m_numeroRCI = pValeur;
  }
  
  public void setNumeroRCI_C_ERR(String pValeur_C_ERR)
  {
    m_numeroRCI_C_ERR = pValeur_C_ERR;
  }
  
  public String getCxass()
  {
    return m_cxass;
  }
  
  public String getCxass_C_ERR()
  {
    return m_cxass_C_ERR;
  }
  
  public void setCxass(String pValeur)
  {
    m_cxass = pValeur;
  }
  
  public void setCxass_C_ERR(String pValeur_C_ERR)
  {
    m_cxass_C_ERR = pValeur_C_ERR;
  }
  
  public String getRsin()
  {
    return m_rsin;
  }
  
  public String getRsin_C_ERR()
  {
    return m_rsin_C_ERR;
  }
  
  public void setRsin(String pValeur)
  {
    m_rsin = pValeur;
  }
  
  public void setRsin_C_ERR(String pValeur_C_ERR)
  {
    m_rsin_C_ERR = pValeur_C_ERR;
  }
  
  public _ListeFluxPrimeIndemVerseesDsn getListeFluxPrimeIndemVerseesDsn()
  {
    return m_listeFluxPrimeIndemVerseesDsn;
  }
  
  public _ListeFluxPrimeIndemVerseesDsn getListeFluxPrimIndemVerseesDsn()
  {
    return m_listeFluxPrimeIndemVerseesDsn;
  }
  
  public String getListeFluxPrimeIndemVerseesDsn_C_ERR()
  {
    return m_listeFluxPrimeIndemVerseesDsn_C_ERR;
  }
  
  public String getListeFluxPrimIndemVerseesDsn_C_ERR()
  {
    return m_listeFluxPrimeIndemVerseesDsn_C_ERR;
  }
  
  public void setListeFluxPrimeIndemVerseesDsn(_ListeFluxPrimeIndemVerseesDsn pValeur)
  {
    m_listeFluxPrimeIndemVerseesDsn = pValeur;
  }
  
  public void setListeFluxPrimIndemVerseesDsn(_ListeFluxPrimeIndemVerseesDsn pValeur)
  {
    m_listeFluxPrimeIndemVerseesDsn = pValeur;
  }
  
  public void setListeFluxPrimeIndemVerseesDsn_C_ERR(String pValeur_C_ERR)
  {
    m_listeFluxPrimeIndemVerseesDsn_C_ERR = pValeur_C_ERR;
  }
  
  public void setListeFluxPrimIndemVerseesDsn_C_ERR(String pValeur_C_ERR)
  {
    m_listeFluxPrimeIndemVerseesDsn_C_ERR = pValeur_C_ERR;
  }
  
  public String getIdFlux()
  {
    return m_idFlux;
  }
  
  public String getIdFlux_C_ERR()
  {
    return m_idFlux_C_ERR;
  }
  
  public void setIdFlux(String pValeur)
  {
    m_idFlux = pValeur;
  }
  
  public void setIdFlux_C_ERR(String pValeur_C_ERR)
  {
    m_idFlux_C_ERR = pValeur_C_ERR;
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
    if ("m_typeEnreg_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numNIRCertifie_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nomDeclare_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_prenomDeclare_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateNaissance_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_contexteEmission_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeMessage_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numeroVersion_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numeroSousVersion_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeAction_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_idTechnique_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numeroRCI_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_cxass_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_rsin_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_listeFluxPrimeIndemVerseesDsn_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_idFlux_C_ERR".equals(attrName)) {
      return String.class;
    }
    return null;
  }
  
  public PropertyInfo _getPropertyInfo(String pElementName)
    throws TechniqueException
  {
    if ("typeEnreg".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("numNIRCertifie".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("nomDeclare".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("prenomDeclare".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("dateNaissance".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("contexteEmission".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("codeMessage".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("numeroVersion".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("numeroSousVersion".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("codeAction".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("idTechnique".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("numeroRCI".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("cxass".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("rsin".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("ListeFluxPrimeIndemVerseesDsn".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, _ListeFluxPrimeIndemVerseesDsn.class, false);
      return info;
    }
    if ("idFlux".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    return null;
  }
  
  public int _getPropertyLength(String pElementName)
  {
    if ("typeEnreg".equals(pElementName)) {
      return 2;
    }
    if ("numNIRCertifie".equals(pElementName)) {
      return 13;
    }
    if ("nomDeclare".equals(pElementName)) {
      return 80;
    }
    if ("prenomDeclare".equals(pElementName)) {
      return 40;
    }
    if ("dateNaissance".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("contexteEmission".equals(pElementName)) {
      return 2;
    }
    if ("codeMessage".equals(pElementName)) {
      return 3;
    }
    if ("numeroVersion".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("numeroSousVersion".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("codeAction".equals(pElementName)) {
      return 1;
    }
    if ("idTechnique".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("numeroRCI".equals(pElementName)) {
      return 10;
    }
    if ("cxass".equals(pElementName)) {
      return 2;
    }
    if ("rsin".equals(pElementName)) {
      return 8;
    }
    if ("ListeFluxPrimeIndemVerseesDsn".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("idFlux".equals(pElementName)) {
      return 10;
    }
    return -1;
  }
  
  public Object _getProperty(String pName)
    throws Exception
  {
    if ("typeEnreg".equals(pName)) {
      return m_typeEnreg;
    }
    if ("numNIRCertifie".equals(pName)) {
      return m_numNIRCertifie;
    }
    if ("nomDeclare".equals(pName)) {
      return m_nomDeclare;
    }
    if ("prenomDeclare".equals(pName)) {
      return m_prenomDeclare;
    }
    if ("dateNaissance".equals(pName)) {
      return m_dateNaissance;
    }
    if ("contexteEmission".equals(pName)) {
      return m_contexteEmission;
    }
    if ("codeMessage".equals(pName)) {
      return m_codeMessage;
    }
    if ("numeroVersion".equals(pName)) {
      return m_numeroVersion;
    }
    if ("numeroSousVersion".equals(pName)) {
      return m_numeroSousVersion;
    }
    if ("codeAction".equals(pName)) {
      return m_codeAction;
    }
    if ("idTechnique".equals(pName)) {
      return m_idTechnique;
    }
    if ("numeroRCI".equals(pName)) {
      return m_numeroRCI;
    }
    if ("cxass".equals(pName)) {
      return m_cxass;
    }
    if ("rsin".equals(pName)) {
      return m_rsin;
    }
    if ("ListeFluxPrimeIndemVerseesDsn".equals(pName)) {
      return m_listeFluxPrimeIndemVerseesDsn;
    }
    if ("idFlux".equals(pName)) {
      return m_idFlux;
    }
    return null;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    liste.add("typeEnreg");
    liste.add("numNIRCertifie");
    liste.add("nomDeclare");
    liste.add("prenomDeclare");
    liste.add("dateNaissance");
    liste.add("contexteEmission");
    liste.add("codeMessage");
    liste.add("numeroVersion");
    liste.add("numeroSousVersion");
    liste.add("codeAction");
    liste.add("idTechnique");
    liste.add("numeroRCI");
    liste.add("cxass");
    liste.add("rsin");
    liste.add("ListeFluxPrimeIndemVerseesDsn");
    liste.add("idFlux");
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("typeEnreg");
    pListe.add("numNIRCertifie");
    pListe.add("nomDeclare");
    pListe.add("prenomDeclare");
    pListe.add("dateNaissance");
    pListe.add("contexteEmission");
    pListe.add("codeMessage");
    pListe.add("numeroVersion");
    pListe.add("numeroSousVersion");
    pListe.add("codeAction");
    pListe.add("idTechnique");
    pListe.add("numeroRCI");
    pListe.add("cxass");
    pListe.add("rsin");
    pListe.add("ListeFluxPrimeIndemVerseesDsn");
    pListe.add("idFlux");
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("typeEnreg".equals(pName)) {
      m_typeEnreg = ((String)pValeur);
    }
    if ("numNIRCertifie".equals(pName)) {
      m_numNIRCertifie = ((String)pValeur);
    }
    if ("nomDeclare".equals(pName)) {
      m_nomDeclare = ((String)pValeur);
    }
    if ("prenomDeclare".equals(pName)) {
      m_prenomDeclare = ((String)pValeur);
    }
    if ("dateNaissance".equals(pName)) {
      m_dateNaissance = ((Damj)pValeur);
    }
    if ("contexteEmission".equals(pName)) {
      m_contexteEmission = ((String)pValeur);
    }
    if ("codeMessage".equals(pName)) {
      m_codeMessage = ((String)pValeur);
    }
    if ("numeroVersion".equals(pName)) {
      m_numeroVersion = ((BigDecimal)pValeur);
    }
    if ("numeroSousVersion".equals(pName)) {
      m_numeroSousVersion = ((BigDecimal)pValeur);
    }
    if ("codeAction".equals(pName)) {
      m_codeAction = ((String)pValeur);
    }
    if ("idTechnique".equals(pName)) {
      m_idTechnique = ((BigDecimal)pValeur);
    }
    if ("numeroRCI".equals(pName)) {
      m_numeroRCI = ((String)pValeur);
    }
    if ("cxass".equals(pName)) {
      m_cxass = ((String)pValeur);
    }
    if ("rsin".equals(pName)) {
      m_rsin = ((String)pValeur);
    }
    if ("ListeFluxPrimeIndemVerseesDsn".equals(pName)) {
      m_listeFluxPrimeIndemVerseesDsn = ((_ListeFluxPrimeIndemVerseesDsn)pValeur);
    }
    if ("idFlux".equals(pName)) {
      m_idFlux = ((String)pValeur);
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
    if ("m_typeEnreg_C_ERR".equals(attrName)) {
      m_typeEnreg_C_ERR = pValeur;
    }
    if ("m_numNIRCertifie_C_ERR".equals(attrName)) {
      m_numNIRCertifie_C_ERR = pValeur;
    }
    if ("m_nomDeclare_C_ERR".equals(attrName)) {
      m_nomDeclare_C_ERR = pValeur;
    }
    if ("m_prenomDeclare_C_ERR".equals(attrName)) {
      m_prenomDeclare_C_ERR = pValeur;
    }
    if ("m_dateNaissance_C_ERR".equals(attrName)) {
      m_dateNaissance_C_ERR = pValeur;
    }
    if ("m_contexteEmission_C_ERR".equals(attrName)) {
      m_contexteEmission_C_ERR = pValeur;
    }
    if ("m_codeMessage_C_ERR".equals(attrName)) {
      m_codeMessage_C_ERR = pValeur;
    }
    if ("m_numeroVersion_C_ERR".equals(attrName)) {
      m_numeroVersion_C_ERR = pValeur;
    }
    if ("m_numeroSousVersion_C_ERR".equals(attrName)) {
      m_numeroSousVersion_C_ERR = pValeur;
    }
    if ("m_codeAction_C_ERR".equals(attrName)) {
      m_codeAction_C_ERR = pValeur;
    }
    if ("m_idTechnique_C_ERR".equals(attrName)) {
      m_idTechnique_C_ERR = pValeur;
    }
    if ("m_numeroRCI_C_ERR".equals(attrName)) {
      m_numeroRCI_C_ERR = pValeur;
    }
    if ("m_cxass_C_ERR".equals(attrName)) {
      m_cxass_C_ERR = pValeur;
    }
    if ("m_rsin_C_ERR".equals(attrName)) {
      m_rsin_C_ERR = pValeur;
    }
    if ("m_listeFluxPrimeIndemVerseesDsn_C_ERR".equals(attrName)) {
      m_listeFluxPrimeIndemVerseesDsn_C_ERR = pValeur;
    }
    if ("m_idFlux_C_ERR".equals(attrName)) {
      m_idFlux_C_ERR = pValeur;
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
    if ("m_typeEnreg_C_ERR".equals(attrName)) {
      return m_typeEnreg_C_ERR;
    }
    if ("m_numNIRCertifie_C_ERR".equals(attrName)) {
      return m_numNIRCertifie_C_ERR;
    }
    if ("m_nomDeclare_C_ERR".equals(attrName)) {
      return m_nomDeclare_C_ERR;
    }
    if ("m_prenomDeclare_C_ERR".equals(attrName)) {
      return m_prenomDeclare_C_ERR;
    }
    if ("m_dateNaissance_C_ERR".equals(attrName)) {
      return m_dateNaissance_C_ERR;
    }
    if ("m_contexteEmission_C_ERR".equals(attrName)) {
      return m_contexteEmission_C_ERR;
    }
    if ("m_codeMessage_C_ERR".equals(attrName)) {
      return m_codeMessage_C_ERR;
    }
    if ("m_numeroVersion_C_ERR".equals(attrName)) {
      return m_numeroVersion_C_ERR;
    }
    if ("m_numeroSousVersion_C_ERR".equals(attrName)) {
      return m_numeroSousVersion_C_ERR;
    }
    if ("m_codeAction_C_ERR".equals(attrName)) {
      return m_codeAction_C_ERR;
    }
    if ("m_idTechnique_C_ERR".equals(attrName)) {
      return m_idTechnique_C_ERR;
    }
    if ("m_numeroRCI_C_ERR".equals(attrName)) {
      return m_numeroRCI_C_ERR;
    }
    if ("m_cxass_C_ERR".equals(attrName)) {
      return m_cxass_C_ERR;
    }
    if ("m_rsin_C_ERR".equals(attrName)) {
      return m_rsin_C_ERR;
    }
    if ("m_listeFluxPrimeIndemVerseesDsn_C_ERR".equals(attrName)) {
      return m_listeFluxPrimeIndemVerseesDsn_C_ERR;
    }
    if ("m_idFlux_C_ERR".equals(attrName)) {
      return m_idFlux_C_ERR;
    }
    return null;
  }
  
  public boolean equals(Object pObjet)
  {
    if (!(pObjet instanceof _FluxPrimeIndemDsn)) {
      return false;
    }
    _FluxPrimeIndemDsn x = (_FluxPrimeIndemDsn)pObjet;
    if (m_typeEnreg == null)
    {
      if (m_typeEnreg != null) {
        return false;
      }
    }
    else
    {
      if (m_typeEnreg == null) {
        return false;
      }
      if (!m_typeEnreg.equals(m_typeEnreg)) {
        return false;
      }
    }
    if (m_numNIRCertifie == null)
    {
      if (m_numNIRCertifie != null) {
        return false;
      }
    }
    else
    {
      if (m_numNIRCertifie == null) {
        return false;
      }
      if (!m_numNIRCertifie.equals(m_numNIRCertifie)) {
        return false;
      }
    }
    if (m_nomDeclare == null)
    {
      if (m_nomDeclare != null) {
        return false;
      }
    }
    else
    {
      if (m_nomDeclare == null) {
        return false;
      }
      if (!m_nomDeclare.equals(m_nomDeclare)) {
        return false;
      }
    }
    if (m_prenomDeclare == null)
    {
      if (m_prenomDeclare != null) {
        return false;
      }
    }
    else
    {
      if (m_prenomDeclare == null) {
        return false;
      }
      if (!m_prenomDeclare.equals(m_prenomDeclare)) {
        return false;
      }
    }
    if (m_dateNaissance == null)
    {
      if (m_dateNaissance != null) {
        return false;
      }
    }
    else
    {
      if (m_dateNaissance == null) {
        return false;
      }
      if (!m_dateNaissance.equals(m_dateNaissance)) {
        return false;
      }
    }
    if (m_contexteEmission == null)
    {
      if (m_contexteEmission != null) {
        return false;
      }
    }
    else
    {
      if (m_contexteEmission == null) {
        return false;
      }
      if (!m_contexteEmission.equals(m_contexteEmission)) {
        return false;
      }
    }
    if (m_codeMessage == null)
    {
      if (m_codeMessage != null) {
        return false;
      }
    }
    else
    {
      if (m_codeMessage == null) {
        return false;
      }
      if (!m_codeMessage.equals(m_codeMessage)) {
        return false;
      }
    }
    if (m_numeroVersion == null)
    {
      if (m_numeroVersion != null) {
        return false;
      }
    }
    else
    {
      if (m_numeroVersion == null) {
        return false;
      }
      if (!m_numeroVersion.equals(m_numeroVersion)) {
        return false;
      }
    }
    if (m_numeroSousVersion == null)
    {
      if (m_numeroSousVersion != null) {
        return false;
      }
    }
    else
    {
      if (m_numeroSousVersion == null) {
        return false;
      }
      if (!m_numeroSousVersion.equals(m_numeroSousVersion)) {
        return false;
      }
    }
    if (m_codeAction == null)
    {
      if (m_codeAction != null) {
        return false;
      }
    }
    else
    {
      if (m_codeAction == null) {
        return false;
      }
      if (!m_codeAction.equals(m_codeAction)) {
        return false;
      }
    }
    if (m_idTechnique == null)
    {
      if (m_idTechnique != null) {
        return false;
      }
    }
    else
    {
      if (m_idTechnique == null) {
        return false;
      }
      if (!m_idTechnique.equals(m_idTechnique)) {
        return false;
      }
    }
    if (m_numeroRCI == null)
    {
      if (m_numeroRCI != null) {
        return false;
      }
    }
    else
    {
      if (m_numeroRCI == null) {
        return false;
      }
      if (!m_numeroRCI.equals(m_numeroRCI)) {
        return false;
      }
    }
    if (m_cxass == null)
    {
      if (m_cxass != null) {
        return false;
      }
    }
    else
    {
      if (m_cxass == null) {
        return false;
      }
      if (!m_cxass.equals(m_cxass)) {
        return false;
      }
    }
    if (m_rsin == null)
    {
      if (m_rsin != null) {
        return false;
      }
    }
    else
    {
      if (m_rsin == null) {
        return false;
      }
      if (!m_rsin.equals(m_rsin)) {
        return false;
      }
    }
    if (m_listeFluxPrimeIndemVerseesDsn == null)
    {
      if (m_listeFluxPrimeIndemVerseesDsn != null) {
        return false;
      }
    }
    else
    {
      if (m_listeFluxPrimeIndemVerseesDsn == null) {
        return false;
      }
      if (!m_listeFluxPrimeIndemVerseesDsn.equals(m_listeFluxPrimeIndemVerseesDsn)) {
        return false;
      }
    }
    if (m_idFlux == null)
    {
      if (m_idFlux != null) {
        return false;
      }
    }
    else
    {
      if (m_idFlux == null) {
        return false;
      }
      if (!m_idFlux.equals(m_idFlux)) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = 0;
    if (m_typeEnreg != null) {
      result += m_typeEnreg.hashCode();
    }
    if (m_numNIRCertifie != null) {
      result += m_numNIRCertifie.hashCode();
    }
    if (m_nomDeclare != null) {
      result += m_nomDeclare.hashCode();
    }
    if (m_prenomDeclare != null) {
      result += m_prenomDeclare.hashCode();
    }
    if (m_dateNaissance != null) {
      result += m_dateNaissance.hashCode();
    }
    if (m_contexteEmission != null) {
      result += m_contexteEmission.hashCode();
    }
    if (m_codeMessage != null) {
      result += m_codeMessage.hashCode();
    }
    if (m_numeroVersion != null) {
      result += m_numeroVersion.hashCode();
    }
    if (m_numeroSousVersion != null) {
      result += m_numeroSousVersion.hashCode();
    }
    if (m_codeAction != null) {
      result += m_codeAction.hashCode();
    }
    if (m_idTechnique != null) {
      result += m_idTechnique.hashCode();
    }
    if (m_numeroRCI != null) {
      result += m_numeroRCI.hashCode();
    }
    if (m_cxass != null) {
      result += m_cxass.hashCode();
    }
    if (m_rsin != null) {
      result += m_rsin.hashCode();
    }
    if (m_listeFluxPrimeIndemVerseesDsn != null) {
      result += m_listeFluxPrimeIndemVerseesDsn.hashCode();
    }
    if (m_idFlux != null) {
      result += m_idFlux.hashCode();
    }
    result *= 17;
    return result;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _FluxPrimeIndemDsn clone_FluxPrimeIndemDsn = new _FluxPrimeIndemDsn();
    clone_FluxPrimeIndemDsn.populateFrom_FluxPrimeIndemDsn(this);
    return clone_FluxPrimeIndemDsn;
  }
  
  public void populateFrom_FluxPrimeIndemDsn(_FluxPrimeIndemDsn pSource)
  {
    setTypeEnreg(pSource.getTypeEnreg());setNumNIRCertifie(pSource.getNumNIRCertifie());setNomDeclare(pSource.getNomDeclare());setPrenomDeclare(pSource.getPrenomDeclare());setDateNaissance(pSource.getDateNaissance());setContexteEmission(pSource.getContexteEmission());setCodeMessage(pSource.getCodeMessage());setNumeroVersion(pSource.getNumeroVersion());setNumeroSousVersion(pSource.getNumeroSousVersion());setCodeAction(pSource.getCodeAction());setIdTechnique(pSource.getIdTechnique());setNumeroRCI(pSource.getNumeroRCI());setCxass(pSource.getCxass());setRsin(pSource.getRsin());setListeFluxPrimeIndemVerseesDsn(pSource.getListeFluxPrimeIndemVerseesDsn());setIdFlux(pSource.getIdFlux());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_FluxPrimeIndemDsn");
    subToString(s);
    s.append("]");
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", typeEnreg: ");
    pSource.append(m_typeEnreg);
    pSource.append(", numNIRCertifie: ");
    pSource.append(m_numNIRCertifie);
    pSource.append(", nomDeclare: ");
    pSource.append(m_nomDeclare);
    pSource.append(", prenomDeclare: ");
    pSource.append(m_prenomDeclare);
    pSource.append(", dateNaissance: ");
    pSource.append(m_dateNaissance);
    pSource.append(", contexteEmission: ");
    pSource.append(m_contexteEmission);
    pSource.append(", codeMessage: ");
    pSource.append(m_codeMessage);
    pSource.append(", numeroVersion: ");
    pSource.append(m_numeroVersion);
    pSource.append(", numeroSousVersion: ");
    pSource.append(m_numeroSousVersion);
    pSource.append(", codeAction: ");
    pSource.append(m_codeAction);
    pSource.append(", idTechnique: ");
    pSource.append(m_idTechnique);
    pSource.append(", numeroRCI: ");
    pSource.append(m_numeroRCI);
    pSource.append(", cxass: ");
    pSource.append(m_cxass);
    pSource.append(", rsin: ");
    pSource.append(m_rsin);
    pSource.append(", ListeFluxPrimeIndemVerseesDsn: ");
    pSource.append(m_listeFluxPrimeIndemVerseesDsn);
    pSource.append(", idFlux: ");
    pSource.append(m_idFlux);
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
    pHandler.property("typeEnreg", getTypeEnreg(), new Attribute[] { new StringAttribute("C_ERR", getTypeEnreg_C_ERR()) });
    
    pHandler.property("numNIRCertifie", getNumNIRCertifie(), new Attribute[] { new StringAttribute("C_ERR", getNumNIRCertifie_C_ERR()) });
    
    pHandler.property("nomDeclare", getNomDeclare(), new Attribute[] { new StringAttribute("C_ERR", getNomDeclare_C_ERR()) });
    
    pHandler.property("prenomDeclare", getPrenomDeclare(), new Attribute[] { new StringAttribute("C_ERR", getPrenomDeclare_C_ERR()) });
    
    pHandler.property("dateNaissance", getDateNaissance(), new Attribute[] { new StringAttribute("C_ERR", getDateNaissance_C_ERR()) });
    
    pHandler.property("contexteEmission", getContexteEmission(), new Attribute[] { new StringAttribute("C_ERR", getContexteEmission_C_ERR()) });
    
    pHandler.property("codeMessage", getCodeMessage(), new Attribute[] { new StringAttribute("C_ERR", getCodeMessage_C_ERR()) });
    
    pHandler.property("numeroVersion", getNumeroVersion(), new Attribute[] { new StringAttribute("C_ERR", getNumeroVersion_C_ERR()) });
    
    pHandler.property("numeroSousVersion", getNumeroSousVersion(), new Attribute[] { new StringAttribute("C_ERR", getNumeroSousVersion_C_ERR()) });
    
    pHandler.property("codeAction", getCodeAction(), new Attribute[] { new StringAttribute("C_ERR", getCodeAction_C_ERR()) });
    
    pHandler.property("idTechnique", getIdTechnique(), new Attribute[] { new StringAttribute("C_ERR", getIdTechnique_C_ERR()) });
    
    pHandler.property("numeroRCI", getNumeroRCI(), new Attribute[] { new StringAttribute("C_ERR", getNumeroRCI_C_ERR()) });
    
    pHandler.property("cxass", getCxass(), new Attribute[] { new StringAttribute("C_ERR", getCxass_C_ERR()) });
    
    pHandler.property("rsin", getRsin(), new Attribute[] { new StringAttribute("C_ERR", getRsin_C_ERR()) });
    
    DataBean ListeFluxPrimeIndemVerseesDsn_Value = getListeFluxPrimeIndemVerseesDsn();
    GettersHandler ListeFluxPrimeIndemVerseesDsn_GettersHandler = pHandler.property("ListeFluxPrimeIndemVerseesDsn", ListeFluxPrimeIndemVerseesDsn_Value, new Attribute[] { new StringAttribute("C_ERR", getListeFluxPrimeIndemVerseesDsn_C_ERR()) });
    if ((ListeFluxPrimeIndemVerseesDsn_GettersHandler != null) && (ListeFluxPrimeIndemVerseesDsn_Value != null)) {
      ListeFluxPrimeIndemVerseesDsn_Value.goThrough(ListeFluxPrimeIndemVerseesDsn_GettersHandler);
    }
    pHandler.property("idFlux", getIdFlux(), new Attribute[] { new StringAttribute("C_ERR", getIdFlux_C_ERR()) });
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
    setTypeEnreg((String)pHandler.objectProperty("typeEnreg", String.class));
    setTypeEnreg_C_ERR(pHandler.stringAttribute("typeEnreg", "C_ERR"));
    
    setNumNIRCertifie((String)pHandler.objectProperty("numNIRCertifie", String.class));
    setNumNIRCertifie_C_ERR(pHandler.stringAttribute("numNIRCertifie", "C_ERR"));
    
    setNomDeclare((String)pHandler.objectProperty("nomDeclare", String.class));
    setNomDeclare_C_ERR(pHandler.stringAttribute("nomDeclare", "C_ERR"));
    
    setPrenomDeclare((String)pHandler.objectProperty("prenomDeclare", String.class));
    setPrenomDeclare_C_ERR(pHandler.stringAttribute("prenomDeclare", "C_ERR"));
    
    setDateNaissance((Damj)pHandler.objectProperty("dateNaissance", Damj.class));
    setDateNaissance_C_ERR(pHandler.stringAttribute("dateNaissance", "C_ERR"));
    
    setContexteEmission((String)pHandler.objectProperty("contexteEmission", String.class));
    setContexteEmission_C_ERR(pHandler.stringAttribute("contexteEmission", "C_ERR"));
    
    setCodeMessage((String)pHandler.objectProperty("codeMessage", String.class));
    setCodeMessage_C_ERR(pHandler.stringAttribute("codeMessage", "C_ERR"));
    
    setNumeroVersion((BigDecimal)pHandler.objectProperty("numeroVersion", BigDecimal.class));
    setNumeroVersion_C_ERR(pHandler.stringAttribute("numeroVersion", "C_ERR"));
    
    setNumeroSousVersion((BigDecimal)pHandler.objectProperty("numeroSousVersion", BigDecimal.class));
    setNumeroSousVersion_C_ERR(pHandler.stringAttribute("numeroSousVersion", "C_ERR"));
    
    setCodeAction((String)pHandler.objectProperty("codeAction", String.class));
    setCodeAction_C_ERR(pHandler.stringAttribute("codeAction", "C_ERR"));
    
    setIdTechnique((BigDecimal)pHandler.objectProperty("idTechnique", BigDecimal.class));
    setIdTechnique_C_ERR(pHandler.stringAttribute("idTechnique", "C_ERR"));
    
    setNumeroRCI((String)pHandler.objectProperty("numeroRCI", String.class));
    setNumeroRCI_C_ERR(pHandler.stringAttribute("numeroRCI", "C_ERR"));
    
    setCxass((String)pHandler.objectProperty("cxass", String.class));
    setCxass_C_ERR(pHandler.stringAttribute("cxass", "C_ERR"));
    
    setRsin((String)pHandler.objectProperty("rsin", String.class));
    setRsin_C_ERR(pHandler.stringAttribute("rsin", "C_ERR"));
    
    setListeFluxPrimeIndemVerseesDsn((_ListeFluxPrimeIndemVerseesDsn)pHandler.databeanProperty("ListeFluxPrimeIndemVerseesDsn", _ListeFluxPrimeIndemVerseesDsn.class));
    setListeFluxPrimeIndemVerseesDsn_C_ERR(pHandler.stringAttribute("ListeFluxPrimeIndemVerseesDsn", "C_ERR"));
    setIdFlux((String)pHandler.objectProperty("idFlux", String.class));
    setIdFlux_C_ERR(pHandler.stringAttribute("idFlux", "C_ERR"));
  }
  
  public String _getDatabeanName()
  {
    return "FluxPrimeIndemDsn";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("typeEnreg".equals(pElementName)) {
      return true;
    }
    if ("numNIRCertifie".equals(pElementName)) {
      return true;
    }
    if ("nomDeclare".equals(pElementName)) {
      return true;
    }
    if ("prenomDeclare".equals(pElementName)) {
      return true;
    }
    if ("dateNaissance".equals(pElementName)) {
      return true;
    }
    if ("contexteEmission".equals(pElementName)) {
      return true;
    }
    if ("codeMessage".equals(pElementName)) {
      return true;
    }
    if ("numeroVersion".equals(pElementName)) {
      return true;
    }
    if ("numeroSousVersion".equals(pElementName)) {
      return true;
    }
    if ("codeAction".equals(pElementName)) {
      return true;
    }
    if ("idTechnique".equals(pElementName)) {
      return true;
    }
    if ("numeroRCI".equals(pElementName)) {
      return true;
    }
    if ("cxass".equals(pElementName)) {
      return true;
    }
    if ("rsin".equals(pElementName)) {
      return true;
    }
    if ("ListeFluxPrimeIndemVerseesDsn".equals(pElementName)) {
      return true;
    }
    if ("idFlux".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxPrimeIndemDsn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */