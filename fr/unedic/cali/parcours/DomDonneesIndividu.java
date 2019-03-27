package fr.unedic.cali.parcours;

import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.util.Hashtable;

public class DomDonneesIndividu
  extends DomCaliOptimise
  implements DomCali
{
  private IndividuSpec individu = null;
  private ContexteService contexteService;
  private boolean estAppelCalculTotal;
  private int attributionsAfdFiliereCourte;
  private int attributionsAfdFiliereIntermediaire;
  private int attributionsAfdFiliereLongue;
  private Damj dernierJourIndemnisableAreSpe;
  private Hashtable donneesIndividuAvant;
  private Hashtable donneesIndividuApres;
  private String codeTransaction;
  private String domaineSourceFlux;
  private boolean estArretReexecution;
  private boolean estDesactivationEfe;
  private boolean estExecutionDesactive;
  private String referenceExterneDemandeExpresse;
  private Damj dateDepotDemandeExpresse;
  
  public Hashtable getDonneesIndividuApres()
  {
    return donneesIndividuApres;
  }
  
  public void setDonneesIndividuApres(Hashtable donneesIndividuApres)
  {
    this.donneesIndividuApres = donneesIndividuApres;
  }
  
  public Hashtable getDonneesIndividuAvant()
  {
    return donneesIndividuAvant;
  }
  
  public void setDonneesIndividuAvant(Hashtable donneesIndividuAvant)
  {
    this.donneesIndividuAvant = donneesIndividuAvant;
  }
  
  public ContexteService getContexteService()
  {
    return contexteService;
  }
  
  public IndividuSpec getIndividu()
  {
    return individu;
  }
  
  public void setContexteService(ContexteService contexteService)
  {
    this.contexteService = contexteService;
  }
  
  public void setIndividu(IndividuSpec individu)
  {
    this.individu = individu;
  }
  
  public boolean isEstAppelCalculTotal()
  {
    return estAppelCalculTotal;
  }
  
  public void setEstAppelCalculTotal(boolean estAppelCalculTotal)
  {
    this.estAppelCalculTotal = estAppelCalculTotal;
  }
  
  public int getAttributionsAfdFiliereCourte()
  {
    return attributionsAfdFiliereCourte;
  }
  
  public void setAttributionsAfdFiliereCourte(int attributionsAfdFiliereCourte)
  {
    this.attributionsAfdFiliereCourte = attributionsAfdFiliereCourte;
  }
  
  public int getAttributionsAfdFiliereIntermediaire()
  {
    return attributionsAfdFiliereIntermediaire;
  }
  
  public void setAttributionsAfdFiliereIntermediaire(int attributionsAfdFiliereIntermediaire)
  {
    this.attributionsAfdFiliereIntermediaire = attributionsAfdFiliereIntermediaire;
  }
  
  public int getAttributionsAfdFiliereLongue()
  {
    return attributionsAfdFiliereLongue;
  }
  
  public void setAttributionsAfdFiliereLongue(int attributionsAfdFiliereLongue)
  {
    this.attributionsAfdFiliereLongue = attributionsAfdFiliereLongue;
  }
  
  public Damj getDernierJourIndemnisableAreSpe()
  {
    return dernierJourIndemnisableAreSpe;
  }
  
  public void setDernierJourIndemnisableAreSpe(Damj dernierJourIndemnisableAreSpe)
  {
    this.dernierJourIndemnisableAreSpe = dernierJourIndemnisableAreSpe;
  }
  
  public String getCodeTransaction()
  {
    return codeTransaction;
  }
  
  public void setCodeTransaction(String codeTransaction)
  {
    this.codeTransaction = codeTransaction;
  }
  
  public String getDomaineSourceFlux()
  {
    return domaineSourceFlux;
  }
  
  public void setDomaineSourceFlux(String sourceDomaineFlux)
  {
    domaineSourceFlux = sourceDomaineFlux;
  }
  
  public void setEstArretReexecution(boolean estArretReexecution)
  {
    this.estArretReexecution = estArretReexecution;
  }
  
  public boolean isEstArretReexecution()
  {
    return estArretReexecution;
  }
  
  public void setEstDesactivationEfe(boolean estDesactivationEfe)
  {
    this.estDesactivationEfe = estDesactivationEfe;
  }
  
  public boolean estDesactivationEfe()
  {
    return estDesactivationEfe;
  }
  
  public void setEstExecutionDiffereFluxDesactive(boolean estExecutionDesactive)
  {
    this.estExecutionDesactive = estExecutionDesactive;
  }
  
  public boolean estExecutionDiffereFluxDesactive()
  {
    return estExecutionDesactive;
  }
  
  public Damj getDateDepotDemandeExpresse()
  {
    return dateDepotDemandeExpresse;
  }
  
  public void setDateDepotDemandeExpresse(Damj dateDepotDemandeExpresse)
  {
    this.dateDepotDemandeExpresse = dateDepotDemandeExpresse;
  }
  
  public String getReferenceExterneDemandeExpresse()
  {
    return referenceExterneDemandeExpresse;
  }
  
  public void setReferenceExterneDemandeExpresse(String referenceExterneDemandeExpresse)
  {
    this.referenceExterneDemandeExpresse = referenceExterneDemandeExpresse;
  }
}

/* Location:
 * Qualified Name:     DomDonneesIndividu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */