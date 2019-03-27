package fr.unedic.cali.autresdoms.d90.dom;

import fr.unedic.cali.autresdoms.d90.dom.spec.PopulationSpec;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Individu
{
  public static final String ETAT_INDIVIDU_TRAITE = "0";
  public static final String ETAT_INDIVIDU_ECARTE = "1";
  public static final String ETAT_INDIVIDU_TRAITE_AVEC_REEXAMEN = "R";
  public static final Integer ETAT_TRAITEMENT_INDIVIDU_ENCOURS = Integer.valueOf(1);
  public static final Integer ETAT_TRAITEMENT_INDIVIDU_TRAITE = Integer.valueOf(2);
  public static final Integer ETAT_TRAITEMENT_INDIVIDU_SANSOBJET = Integer.valueOf(3);
  private String m_rsin;
  private String m_cxass;
  private String m_cxala;
  private String m_modeCreation;
  private BigDecimal m_deltaMontantBrut;
  private Map m_listeDemandes;
  private PopulationSpec m_population;
  private Damj m_dateReexecution;
  private String m_antenne;
  private String m_etatIndividu;
  private Damj m_dja;
  private Collection m_listeEcartsBases;
  private Collection m_listeDeltasMontantsMensuels;
  private Integer m_etatTraitement;
  
  public Individu()
  {
    m_listeDemandes = new HashMap();
    
    m_deltaMontantBrut = new BigDecimal(0);
  }
  
  public PopulationSpec getPopulation()
  {
    return m_population;
  }
  
  public void setPopulation(PopulationSpec p_population)
  {
    m_population = p_population;
  }
  
  public String getCxala()
  {
    return m_cxala;
  }
  
  public void setCxala(String p_cxala)
  {
    m_cxala = p_cxala;
  }
  
  public String getCxass()
  {
    return m_cxass;
  }
  
  public void setCxass(String p_cxass)
  {
    m_cxass = p_cxass;
  }
  
  public BigDecimal getDeltaMontantBrut()
  {
    return m_deltaMontantBrut;
  }
  
  public void setDeltaMontantBrut(BigDecimal p_deltaMontantBrut)
  {
    m_deltaMontantBrut = p_deltaMontantBrut;
  }
  
  public String getModeCreation()
  {
    return m_modeCreation;
  }
  
  public void setModeCreation(String p_modeCreation)
  {
    m_modeCreation = p_modeCreation;
  }
  
  public String getRsin()
  {
    return m_rsin;
  }
  
  public void setRsin(String p_rsin)
  {
    m_rsin = p_rsin;
  }
  
  public Collection getListeDemandes()
  {
    return m_listeDemandes.values();
  }
  
  public void ajouterDemande(Demande p_demande)
  {
    m_listeDemandes.put(p_demande.getIdDemande(), p_demande);
    if ("R".equals(p_demande.getEtatReexamen())) {
      setEtatIndividu("R");
    }
  }
  
  public Demande getDemande(String p_identifiantDemande)
  {
    return (Demande)m_listeDemandes.get(p_identifiantDemande);
  }
  
  public Damj getDateReexecution()
  {
    return m_dateReexecution;
  }
  
  public void setDateReexecution(Damj p_dateReexecution)
  {
    m_dateReexecution = p_dateReexecution;
  }
  
  public String getAntenne()
  {
    return m_antenne;
  }
  
  public void setAntenne(String p_antenne)
  {
    m_antenne = p_antenne;
  }
  
  public String getEtatIndividu()
  {
    return m_etatIndividu;
  }
  
  public void setEtatIndividu(String p_etatIndividu)
  {
    m_etatIndividu = p_etatIndividu;
  }
  
  public Damj getDja()
  {
    return m_dja;
  }
  
  public void setDja(Damj p_dja)
  {
    m_dja = p_dja;
  }
  
  public Collection getListeEcartsBases()
  {
    return m_listeEcartsBases;
  }
  
  public void setListeEcartsBases(Collection p_listeEcartsBases)
  {
    m_listeEcartsBases = p_listeEcartsBases;
  }
  
  public Collection getListeDeltasMontantsMensuels()
  {
    return m_listeDeltasMontantsMensuels;
  }
  
  public void setListeDeltasMontantsMensuels(Collection p_listeDeltasMontantsMensuels)
  {
    m_listeDeltasMontantsMensuels = p_listeDeltasMontantsMensuels;
  }
  
  public Integer getEtatTraitement()
  {
    return m_etatTraitement;
  }
  
  public void setEtatTraitement(Integer p_etatTraitement)
  {
    m_etatTraitement = p_etatTraitement;
  }
}

/* Location:
 * Qualified Name:     Individu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */