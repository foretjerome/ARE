package fr.pe.cali.reglementaire.regles.assurance.cep.datelimite.dom;

import fr.pe.cali.reglementaire.regles.assurance.cep.datelimite.outils.spec.IOutilFonctionnelDateLimiteSpectacle2016;
import fr.unedic.cali.autresdoms.cohab.dom.spec.TrimestreRetraiteSpec;
import fr.unedic.util.temps.Damj;

public class DonneesEntreeDateLimiteSpectacle
{
  private Damj dateFaitGenerateur;
  private Damj dateNaissance;
  private TrimestreRetraiteSpec trimestreRetraite;
  private Damj dateLiquidationRetraite;
  private Damj dateRetraiteAnticipee;
  private String motifRetraiteAnticipee;
  private Damj dateExamen;
  private IOutilFonctionnelDateLimiteSpectacle2016 outilFonctionnel;
  private Damj dateLimiteIndemnisationForcee;
  
  public Damj getDateFaitGenerateur()
  {
    return dateFaitGenerateur;
  }
  
  public void setDateFaitGenerateur(Damj dateFaitGenerateur)
  {
    this.dateFaitGenerateur = dateFaitGenerateur;
  }
  
  public Damj getDateNaissance()
  {
    return dateNaissance;
  }
  
  public void setDateNaissance(Damj dateNaissance)
  {
    this.dateNaissance = dateNaissance;
  }
  
  public TrimestreRetraiteSpec getTrimestreRetraite()
  {
    return trimestreRetraite;
  }
  
  public void setTrimestreRetraite(TrimestreRetraiteSpec trimestreRetraite)
  {
    this.trimestreRetraite = trimestreRetraite;
  }
  
  public Damj getDateExamen()
  {
    return dateExamen;
  }
  
  public void setDateExamen(Damj dateExamen)
  {
    this.dateExamen = dateExamen;
  }
  
  public Damj getDateLiquidationRetraite()
  {
    return dateLiquidationRetraite;
  }
  
  public void setDateLiquidationRetraite(Damj dateLiquidationRetraite)
  {
    this.dateLiquidationRetraite = dateLiquidationRetraite;
  }
  
  public Damj getDateRetraiteAnticipee()
  {
    return dateRetraiteAnticipee;
  }
  
  public void setDateRetraiteAnticipee(Damj dateRetraiteAnticipee)
  {
    this.dateRetraiteAnticipee = dateRetraiteAnticipee;
  }
  
  public IOutilFonctionnelDateLimiteSpectacle2016 getOutilFonctionnel()
  {
    return outilFonctionnel;
  }
  
  public void setOutilFonctionnel(IOutilFonctionnelDateLimiteSpectacle2016 outilFonctionnel)
  {
    this.outilFonctionnel = outilFonctionnel;
  }
  
  public String getMotifRetraiteAnticipee()
  {
    return motifRetraiteAnticipee;
  }
  
  public void setMotifRetraiteAnticipee(String motifRetraiteAnticipee)
  {
    this.motifRetraiteAnticipee = motifRetraiteAnticipee;
  }
  
  public Damj getDateLimiteIndemnisationForcee()
  {
    return dateLimiteIndemnisationForcee;
  }
  
  public void setDateLimiteIndemnisationForcee(Damj dateLimiteIndemnisationForcee)
  {
    this.dateLimiteIndemnisationForcee = dateLimiteIndemnisationForcee;
  }
}

/* Location:
 * Qualified Name:     DonneesEntreeDateLimiteSpectacle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */