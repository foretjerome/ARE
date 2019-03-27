package fr.pe.cali.reglementaire.regles.assurance.cep.delaisreports.dom;

import fr.unedic.util.temps.Periode;

public class ResultatDelaisReportsSpectacle
{
  private int nombreJoursFranchiseCP;
  private JustificationFranchiseCP justification;
  private boolean appliquerDiffere = false;
  private Periode delaiAttentePrecedent = null;
  private int nombreJoursDelaiAttente;
  
  public int getNombreJoursFranchiseCP()
  {
    return nombreJoursFranchiseCP;
  }
  
  public void setNombreJoursFranchiseCP(int nombreJoursFranchiseCP)
  {
    this.nombreJoursFranchiseCP = nombreJoursFranchiseCP;
  }
  
  public JustificationFranchiseCP getJustification()
  {
    return justification;
  }
  
  public void setJustification(JustificationFranchiseCP justification)
  {
    this.justification = justification;
  }
  
  public void setAppliquerDiffere(boolean appliquerDiffere)
  {
    this.appliquerDiffere = appliquerDiffere;
  }
  
  public boolean isAppliquerDiffere()
  {
    return appliquerDiffere;
  }
  
  public void setDelaiAttentePrecedent(Periode delaiAttentePrecedent)
  {
    this.delaiAttentePrecedent = delaiAttentePrecedent;
  }
  
  public Periode getDelaiAttentePrecedent()
  {
    return delaiAttentePrecedent;
  }
  
  public int getNombreJoursDelaiAttente()
  {
    return nombreJoursDelaiAttente;
  }
  
  public void setNombreJoursDelaiAttente(int nombreJoursDelaiAttente)
  {
    this.nombreJoursDelaiAttente = nombreJoursDelaiAttente;
  }
}

/* Location:
 * Qualified Name:     ResultatDelaisReportsSpectacle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */