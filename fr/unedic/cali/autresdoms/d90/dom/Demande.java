package fr.unedic.cali.autresdoms.d90.dom;

import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Demande
{
  private String m_idDemande;
  private boolean m_estdecisionnee;
  private boolean m_estImpacte;
  private String m_etatReexamen;
  private boolean m_estReexecute;
  private Damj m_dateAttribution;
  private int m_codeProduit;
  private String m_typeDemande;
  private BigDecimal m_deltaPJI;
  private BigDecimal m_deltaDJI;
  private List m_elementsComparaisonReexamen;
  private int m_typeDecision;
  private boolean m_estMigree;
  private boolean m_estFigee;
  private boolean m_estNeutralisee;
  private Damj m_djiAvant;
  private Damj m_djiApres;
  private Damj m_pjiAvant;
  private Damj m_pjiApres;
  private Collection m_listeEcartsBases;
  
  public Damj getDjiApres()
  {
    return m_djiApres;
  }
  
  public void setDjiApres(Damj p_djaApres)
  {
    m_djiApres = p_djaApres;
  }
  
  public Damj getDjiAvant()
  {
    return m_djiAvant;
  }
  
  public void setDjiAvant(Damj p_djaAvant)
  {
    m_djiAvant = p_djaAvant;
  }
  
  public Damj getPjiApres()
  {
    return m_pjiApres;
  }
  
  public void setPjiApres(Damj p_pjiApres)
  {
    m_pjiApres = p_pjiApres;
  }
  
  public Damj getPjiAvant()
  {
    return m_pjiAvant;
  }
  
  public void setPjiAvant(Damj p_pjiAvant)
  {
    m_pjiAvant = p_pjiAvant;
  }
  
  public Demande()
  {
    m_estReexecute = false;
    m_estImpacte = false;
    m_estdecisionnee = false;
    m_elementsComparaisonReexamen = new ArrayList();
    m_estMigree = false;
    m_estFigee = false;
    m_estNeutralisee = false;
  }
  
  public int getCodeProduit()
  {
    return m_codeProduit;
  }
  
  public void setCodeProduit(int p_codeProduit)
  {
    m_codeProduit = p_codeProduit;
  }
  
  public Damj getDateAttribution()
  {
    return m_dateAttribution;
  }
  
  public void setDateAttribution(Damj p_dateAttribution)
  {
    m_dateAttribution = p_dateAttribution;
  }
  
  public BigDecimal getDeltaDJI()
  {
    return m_deltaDJI;
  }
  
  public void setDeltaDJI(BigDecimal p_deltaDJI)
  {
    m_deltaDJI = p_deltaDJI;
  }
  
  public BigDecimal getDeltaPJI()
  {
    return m_deltaPJI;
  }
  
  public void setDeltaPJI(BigDecimal p_deltaPJI)
  {
    m_deltaPJI = p_deltaPJI;
  }
  
  public boolean isEstdecisionnee()
  {
    return m_estdecisionnee;
  }
  
  public void setEstdecisionnee(boolean p_estdecisionnee)
  {
    m_estdecisionnee = p_estdecisionnee;
  }
  
  public boolean isEstImpacte()
  {
    return m_estImpacte;
  }
  
  public void setEstImpacte(boolean p_estImpacte)
  {
    m_estImpacte = p_estImpacte;
  }
  
  public String getEtatReexamen()
  {
    return m_etatReexamen;
  }
  
  public void setEtatReexamen(String p_etatReexamen)
  {
    m_etatReexamen = p_etatReexamen;
  }
  
  public boolean isEstReexecutee()
  {
    return m_estReexecute;
  }
  
  public void setEstReexecutee(boolean p_estReexecutee)
  {
    m_estReexecute = p_estReexecutee;
  }
  
  public String getTypeDemande()
  {
    return m_typeDemande;
  }
  
  public void setTypeDemande(String p_typeDemande)
  {
    m_typeDemande = p_typeDemande;
  }
  
  public String getIdDemande()
  {
    return m_idDemande;
  }
  
  public void setIdDemande(String p_idDemande)
  {
    m_idDemande = p_idDemande;
  }
  
  public List getElementsComparaisonReexamen()
  {
    return m_elementsComparaisonReexamen;
  }
  
  public void setElementsComparaisonReexamen(List p_elementsComparaisonReexamen)
  {
    m_elementsComparaisonReexamen = p_elementsComparaisonReexamen;
  }
  
  public int getTypeDecision()
  {
    return m_typeDecision;
  }
  
  public void setTypeDecision(int p_typeDecision)
  {
    m_typeDecision = p_typeDecision;
  }
  
  public boolean estFigee()
  {
    return m_estFigee;
  }
  
  public void setEstFigee(boolean p_estFigee)
  {
    m_estFigee = p_estFigee;
  }
  
  public boolean estMigree()
  {
    return m_estMigree;
  }
  
  public void setEstMigree(boolean p_estMigree)
  {
    m_estMigree = p_estMigree;
  }
  
  public boolean estNeutralisee()
  {
    return m_estNeutralisee;
  }
  
  public void setEstNeutralisee(boolean p_estNeutralisee)
  {
    m_estNeutralisee = p_estNeutralisee;
  }
  
  public Collection getListeEcartsBases()
  {
    return m_listeEcartsBases;
  }
  
  public void setListeEcartsBases(Collection p_listeEcartsBases)
  {
    m_listeEcartsBases = p_listeEcartsBases;
  }
}

/* Location:
 * Qualified Name:     Demande
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */