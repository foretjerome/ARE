package fr.unedic.cali.parcours;

import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.List;

public class DomListerEtatPrestationsServies
  extends DomCaliOptimise
  implements DomCali
{
  private ContexteService m_contexteService;
  private IndividuSpec m_individu;
  private String m_rsin;
  private String m_cxala;
  private String m_cxass;
  private Damj m_dateDebutRecherche;
  private Damj m_dateFinRecherche;
  private Damj m_dateDernierJourCalcule;
  private Periode m_periode;
  private int m_rsod;
  private int m_rsrp;
  private int m_rang;
  private String m_motif;
  private String m_motifCloture;
  private Damj m_dateOd;
  private List m_listeJustif;
  private String m_codeProduit;
  private String m_codeMotifNonPaiement;
  private Damj m_dateDebutEtat;
  private Damj m_dateObtention;
  private boolean m_contexteOccasionnel;
  private String m_nature;
  private String m_codeRadiation;
  
  public ContexteService getContexteService()
  {
    return m_contexteService;
  }
  
  public IndividuSpec getIndividu()
  {
    return m_individu;
  }
  
  public void setContexteService(ContexteService p_contexteService)
  {
    m_contexteService = p_contexteService;
  }
  
  public void setIndividu(IndividuSpec p_individu)
  {
    m_individu = p_individu;
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
  
  public Damj getDateDebutRecherche()
  {
    return m_dateDebutRecherche;
  }
  
  public void setDateDebutRecherche(Damj p_dateDebutRecherche)
  {
    m_dateDebutRecherche = p_dateDebutRecherche;
  }
  
  public Damj getDateDernierJourCalcule()
  {
    return m_dateDernierJourCalcule;
  }
  
  public void setDateDernierJourCalcule(Damj p_dateDernierJourCalcule)
  {
    m_dateDernierJourCalcule = p_dateDernierJourCalcule;
  }
  
  public Damj getDateFinRecherche()
  {
    return m_dateFinRecherche;
  }
  
  public void setDateFinRecherche(Damj p_dateFinRecherche)
  {
    m_dateFinRecherche = p_dateFinRecherche;
  }
  
  public String getRsin()
  {
    return m_rsin;
  }
  
  public void setRsin(String p_rsin)
  {
    m_rsin = p_rsin;
  }
  
  public Damj getDateOd()
  {
    return m_dateOd;
  }
  
  public void setDateOd(Damj p_dateOd)
  {
    m_dateOd = p_dateOd;
  }
  
  public List getListeJustif()
  {
    return m_listeJustif;
  }
  
  public void setListeJustif(List p_listeJustif)
  {
    m_listeJustif = p_listeJustif;
  }
  
  public String getMotif()
  {
    return m_motif;
  }
  
  public void setMotif(String p_motif)
  {
    m_motif = p_motif;
  }
  
  public String getMotifCloture()
  {
    return m_motifCloture;
  }
  
  public void setMotifCloture(String p_motifCloture)
  {
    m_motifCloture = p_motifCloture;
  }
  
  public Periode getPeriode()
  {
    return m_periode;
  }
  
  public void setPeriode(Periode p_periode)
  {
    m_periode = p_periode;
  }
  
  public int getRang()
  {
    return m_rang;
  }
  
  public void setRang(int p_rang)
  {
    m_rang = p_rang;
  }
  
  public int getRsod()
  {
    return m_rsod;
  }
  
  public void setRsod(int p_rsod)
  {
    m_rsod = p_rsod;
  }
  
  public int getRsrp()
  {
    return m_rsrp;
  }
  
  public void setRsrp(int p_rsrp)
  {
    m_rsrp = p_rsrp;
  }
  
  public String getCodeProduit()
  {
    return m_codeProduit;
  }
  
  public void setCodeProduit(String p_codeProduit)
  {
    m_codeProduit = p_codeProduit;
  }
  
  public String getCodeMotifNonPaiement()
  {
    return m_codeMotifNonPaiement;
  }
  
  public void setCodeMotifNonPaiement(String p_codeMotifNonPaiement)
  {
    m_codeMotifNonPaiement = p_codeMotifNonPaiement;
  }
  
  public Damj getDateDebutEtat()
  {
    return m_dateDebutEtat;
  }
  
  public void setDateDebutEtat(Damj p_dateDebutEtat)
  {
    m_dateDebutEtat = p_dateDebutEtat;
  }
  
  public Damj getDateObtention()
  {
    return m_dateObtention;
  }
  
  public void setDateObtention(Damj p_dateObtention)
  {
    m_dateObtention = p_dateObtention;
  }
  
  public boolean isContexteOccasionnel()
  {
    return m_contexteOccasionnel;
  }
  
  public void setContexteOccasionnel(boolean p_contexteOccasionnel)
  {
    m_contexteOccasionnel = p_contexteOccasionnel;
  }
  
  public String getNature()
  {
    return m_nature;
  }
  
  public void setNature(String p_nature)
  {
    m_nature = p_nature;
  }
  
  public String getCodeRadiation()
  {
    return m_codeRadiation;
  }
  
  public void setCodeRadiation(String p_codeRadiation)
  {
    m_codeRadiation = p_codeRadiation;
  }
}

/* Location:
 * Qualified Name:     DomListerEtatPrestationsServies
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */