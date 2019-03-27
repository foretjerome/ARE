package fr.pe.cali.crem.dom.impl;

import fr.pe.cali.crem.dom.spec.IDonneesFonctionnellesCrem;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="donneesFonctionnelles")
@XmlType(propOrder={"identifiantObjetMetier", "cxalap", "codePE", "rsin", "referenceExterne", "identifiantTechniqueDemande", "typeAide", "contexteMobilite", "dateDepotDemande", "montantDesengageable", "montantTotalEngage", "montantTotalPaye", "codeAntenneDE"})
public class DonneesFonctionnellesDesengagementAide
  implements IDonneesFonctionnellesCrem
{
  private String identifiantObjetMetier;
  private String cxalap;
  private String codePE;
  private String rsin;
  private String referenceExterne;
  private String identifiantTechniqueDemande;
  private String typeAide;
  private String contexteMobilite;
  private String dateDepotDemande;
  private String montantDesengageable;
  private String montantTotalEngage;
  private String montantTotalPaye;
  private String codeAntenneDE;
  
  public String genererXML()
  {
    String donneesFonctionnelles = null;
    try
    {
      JAXBContext context = JAXBContext.newInstance(new Class[] { DonneesFonctionnellesDesengagementAide.class });
      Marshaller m = context.createMarshaller();
      
      StringWriter writer = new StringWriter();
      m.marshal(this, writer);
      donneesFonctionnelles = writer.toString();
    }
    catch (JAXBException ex)
    {
      donneesFonctionnelles = "";
    }
    return donneesFonctionnelles;
  }
  
  @XmlElement(name="identifiantObjetMetier")
  public String getIdentifiantObjetMetier()
  {
    return identifiantObjetMetier;
  }
  
  public void setIdentifiantObjetMetier(String identifiantObjetMetier)
  {
    this.identifiantObjetMetier = identifiantObjetMetier;
  }
  
  @XmlElement(name="referenceExterne")
  public String getReferenceExterne()
  {
    return referenceExterne;
  }
  
  public void setReferenceExterne(String referenceExterne)
  {
    this.referenceExterne = referenceExterne;
  }
  
  @XmlElement(name="codePE")
  public String getCodePE()
  {
    return codePE;
  }
  
  public void setCodePE(String codePE)
  {
    this.codePE = codePE;
  }
  
  @XmlElement(name="rsin")
  public String getRsin()
  {
    return rsin;
  }
  
  public void setRsin(String rsin)
  {
    this.rsin = rsin;
  }
  
  @XmlElement(name="cxalap")
  public String getCxalap()
  {
    return cxalap;
  }
  
  public void setCxalap(String cxalap)
  {
    this.cxalap = cxalap;
  }
  
  @XmlElement(name="codeAntenneDE")
  public String getCodeAntenneDE()
  {
    return codeAntenneDE;
  }
  
  public void setCodeAntenneDE(String codeAntenneDE)
  {
    this.codeAntenneDE = codeAntenneDE;
  }
  
  @XmlElement(name="identifiantTechniqueDemande")
  public String getIdentifiantTechniqueDemande()
  {
    return identifiantTechniqueDemande;
  }
  
  public void setIdentifiantTechniqueDemande(String identifiantTechniqueDemande)
  {
    this.identifiantTechniqueDemande = identifiantTechniqueDemande;
  }
  
  @XmlElement(name="typeAide")
  public String getTypeAide()
  {
    return typeAide;
  }
  
  public void setTypeAide(String typeAide)
  {
    this.typeAide = typeAide;
  }
  
  @XmlElement(name="contexteMobilite")
  public String getContexteMobilite()
  {
    return contexteMobilite;
  }
  
  public void setContexteMobilite(String contexteMobilite)
  {
    this.contexteMobilite = contexteMobilite;
  }
  
  @XmlElement(name="dateDepotDemande")
  public String getDateDepotDemande()
  {
    return dateDepotDemande;
  }
  
  public void setDateDepotDemande(String dateDepotDemande)
  {
    this.dateDepotDemande = dateDepotDemande;
  }
  
  @XmlElement(name="montantDesengageable")
  public String getMontantDesengageable()
  {
    return montantDesengageable;
  }
  
  public void setMontantDesengageable(String montantDesengageable)
  {
    this.montantDesengageable = montantDesengageable;
  }
  
  @XmlElement(name="montantTotalEngage")
  public String getMontantTotalEngage()
  {
    return montantTotalEngage;
  }
  
  public void setMontantTotalEngage(String montantTotalEngage)
  {
    this.montantTotalEngage = montantTotalEngage;
  }
  
  @XmlElement(name="montantTotalPaye")
  public String getMontantTotalPaye()
  {
    return montantTotalPaye;
  }
  
  public void setMontantTotalPaye(String montantTotalPaye)
  {
    this.montantTotalPaye = montantTotalPaye;
  }
  
  public boolean estIdentique(IDonneesFonctionnellesCrem donneesFonctionnelles)
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     DonneesFonctionnellesDesengagementAide
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */