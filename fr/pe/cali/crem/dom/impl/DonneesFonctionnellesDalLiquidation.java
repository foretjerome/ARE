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
@XmlType(propOrder={"codePE", "rsin", "cxala", "identifiantObjetMetierPere", "identifiantObjetMetierCali", "horodatage", "codeAgent", "codeAntenneDE", "motifDecision", "topClassementSansSuite", "topDalWebKO", "topBlocage", "motifIneligibilite", "topDecisionAuto"})
public class DonneesFonctionnellesDalLiquidation
  implements IDonneesFonctionnellesCrem
{
  private String codePE;
  private String rsin;
  private String cxala;
  private String identifiantObjetMetierPere;
  private String identifiantObjetMetierCali;
  private String horodatage;
  private String codeAgent;
  private String codeAntenneDE;
  private String motifDecision;
  private String topClassementSansSuite;
  private String topDalWebKO;
  private String topBlocage;
  private String motifIneligibilite;
  private String topDecisionAuto;
  
  public String genererXML()
  {
    String donneesFonctionnelles = null;
    try
    {
      JAXBContext context = JAXBContext.newInstance(new Class[] { DonneesFonctionnellesDalLiquidation.class });
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
  
  @XmlElement(name="codePE")
  public String getCodePE()
  {
    return codePE;
  }
  
  public void setCodePE(String codePE)
  {
    this.codePE = codePE;
  }
  
  @XmlElement(name="idRegionalDE")
  public String getRsin()
  {
    return rsin;
  }
  
  public void setRsin(String rsin)
  {
    this.rsin = rsin;
  }
  
  @XmlElement(name="idNationalIndividu")
  public String getCxala()
  {
    return cxala;
  }
  
  public void setCxala(String cxala)
  {
    this.cxala = cxala;
  }
  
  @XmlElement(name="idOMPere")
  public String getIdentifiantObjetMetierPere()
  {
    return identifiantObjetMetierPere;
  }
  
  public void setIdentifiantObjetMetierPere(String identifiantObjetMetierPere)
  {
    this.identifiantObjetMetierPere = identifiantObjetMetierPere;
  }
  
  @XmlElement(name="idOM")
  public String getIdentifiantObjetMetierCali()
  {
    return identifiantObjetMetierCali;
  }
  
  public void setIdentifiantObjetMetierCali(String identifiantObjetMetierCali)
  {
    this.identifiantObjetMetierCali = identifiantObjetMetierCali;
  }
  
  @XmlElement(name="timestamp")
  public String getHorodatage()
  {
    return horodatage;
  }
  
  public void setHorodatage(String horodatage)
  {
    this.horodatage = horodatage;
  }
  
  @XmlElement(name="tcAgent")
  public String getCodeAgent()
  {
    return codeAgent;
  }
  
  public void setCodeAgent(String codeAgent)
  {
    this.codeAgent = codeAgent;
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
  
  @XmlElement(name="motifDecision")
  public String getMotifDecision()
  {
    return motifDecision;
  }
  
  public void setMotifDecision(String motifDecision)
  {
    this.motifDecision = motifDecision;
  }
  
  @XmlElement(name="classSansSuite")
  public String getTopClassementSansSuite()
  {
    return topClassementSansSuite;
  }
  
  public void setTopClassementSansSuite(String topClassementSansSuite)
  {
    this.topClassementSansSuite = topClassementSansSuite;
  }
  
  @XmlElement(name="dalWebKO")
  public String getTopDalWebKO()
  {
    return topDalWebKO;
  }
  
  public void setTopDalWebKO(String topDalWebKO)
  {
    this.topDalWebKO = topDalWebKO;
  }
  
  @XmlElement(name="blocage")
  public String getTopBlocage()
  {
    return topBlocage;
  }
  
  public void setTopBlocage(String topBlocage)
  {
    this.topBlocage = topBlocage;
  }
  
  @XmlElement(name="motifIneligibilite")
  public String getMotifIneligibilite()
  {
    return motifIneligibilite;
  }
  
  public void setMotifIneligibilite(String motifIneligibilite)
  {
    this.motifIneligibilite = motifIneligibilite;
  }
  
  @XmlElement(name="decisionAuto")
  public String getTopDecisionAuto()
  {
    return topDecisionAuto;
  }
  
  public void setTopDecisionAuto(String topDecisionAuto)
  {
    this.topDecisionAuto = topDecisionAuto;
  }
  
  public boolean estIdentique(IDonneesFonctionnellesCrem donneesFonctionnelles)
  {
    return false;
  }
  
  private boolean verifierDonneesContexte(DonneesFonctionnellesDalLiquidation donnees)
  {
    return (estDonneesDemandeurIdentiques(donnees)) && (estDonneesPeIdentiques(donnees));
  }
  
  private boolean estDonneesPeIdentiques(DonneesFonctionnellesDalLiquidation donnees)
  {
    return ((donnees.getCodePE() != null) && (donnees.getCodePE().equals(codePE))) || ((donnees.getCodePE() == null) && (codePE == null));
  }
  
  private boolean estDonneesDemandeurIdentiques(DonneesFonctionnellesDalLiquidation donnees)
  {
    boolean estRsinIdentique = ((donnees.getRsin() != null) && (donnees.getRsin().equals(rsin))) || ((donnees.getRsin() == null) && (rsin == null));
    
    boolean estCxalaIdentique = ((donnees.getCxala() != null) && (donnees.getCxala().equals(cxala))) || ((donnees.getCxala() == null) && (cxala == null));
    
    return (estRsinIdentique) && (estCxalaIdentique);
  }
  
  private boolean verifierDonneesDemande(DonneesFonctionnellesDalLiquidation donnees)
  {
    boolean topIdentiques = (estTopInstructionIdentiques(donnees)) && (estTopBlocageIdentique(donnees)) && (estClassementIdentique(donnees));
    boolean motifsIdentique = estMotifsIdentiques(donnees);
    
    return (estIdsObjetMetierIdentiques(donnees)) && (topIdentiques) && (motifsIdentique);
  }
  
  private boolean estTopBlocageIdentique(DonneesFonctionnellesDalLiquidation donnees)
  {
    return ((donnees.getTopBlocage() != null) && (donnees.getTopBlocage().equals(topBlocage))) || ((donnees.getTopBlocage() == null) && (topBlocage == null));
  }
  
  private boolean estClassementIdentique(DonneesFonctionnellesDalLiquidation donnees)
  {
    return ((donnees.getTopClassementSansSuite() != null) && (donnees.getTopClassementSansSuite().equals(topClassementSansSuite))) || ((donnees.getTopClassementSansSuite() == null) && (topClassementSansSuite == null));
  }
  
  private boolean estMotifsIdentiques(DonneesFonctionnellesDalLiquidation donnees)
  {
    boolean estMotifDecisionIdentique = ((donnees.getMotifDecision() != null) && (donnees.getMotifDecision().equals(motifDecision))) || ((donnees.getMotifDecision() == null) && (motifDecision == null));
    
    boolean estMotifIneligibiliteIdentique = ((donnees.getMotifIneligibilite() != null) && (donnees.getMotifIneligibilite().equals(motifIneligibilite))) || ((donnees.getMotifIneligibilite() == null) && (motifIneligibilite == null));
    
    return (estMotifDecisionIdentique) && (estMotifIneligibiliteIdentique);
  }
  
  private boolean estTopInstructionIdentiques(DonneesFonctionnellesDalLiquidation donnees)
  {
    boolean estTopDalWebKOIdentique = ((donnees.getTopDalWebKO() != null) && (donnees.getTopDalWebKO().equals(topDalWebKO))) || ((donnees.getTopDalWebKO() == null) && (topDalWebKO == null));
    
    boolean estTopDecisionAutoIdentique = ((donnees.getTopDecisionAuto() != null) && (donnees.getTopDecisionAuto().equals(topDecisionAuto))) || ((donnees.getTopDecisionAuto() == null) && (topDecisionAuto == null));
    
    return (estTopDecisionAutoIdentique) && (estTopDalWebKOIdentique);
  }
  
  private boolean estIdsObjetMetierIdentiques(DonneesFonctionnellesDalLiquidation donnees)
  {
    boolean estIdentifiantObjetMetierCaliIdentique = ((donnees.getIdentifiantObjetMetierCali() != null) && (donnees.getIdentifiantObjetMetierCali().equals(identifiantObjetMetierCali))) || ((donnees.getIdentifiantObjetMetierCali() == null) && (identifiantObjetMetierCali == null));
    
    boolean estIdentifiantObjetMetierPereIdentique = ((donnees.getIdentifiantObjetMetierPere() != null) && (donnees.getIdentifiantObjetMetierPere().equals(identifiantObjetMetierPere))) || ((donnees.getIdentifiantObjetMetierPere() == null) && (identifiantObjetMetierPere == null));
    
    return (estIdentifiantObjetMetierCaliIdentique) && (estIdentifiantObjetMetierPereIdentique);
  }
}

/* Location:
 * Qualified Name:     DonneesFonctionnellesDalLiquidation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */