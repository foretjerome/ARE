package fr.pe.cali.reglementaire.regles.assurance.cep.delaisreports.dom;

import fr.pe.cali.reglementaire.regles.assurance.cep.delaisreports.outils.spec.IOutilFonctionnelRechercheDiffere;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;

public class DonneesEntreesDelaisReportsSpectacle
{
  private Chronologie passeProfessionnel;
  private Periode pra;
  private IOutilFonctionnelRechercheDiffere outilFonctionnel;
  private Damj debutTheoriqueDelaiAttente;
  private BigDecimal nombreJoursTravaillesForces;
  private Damj dateDernierFgd;
  
  public Chronologie getPasseProfessionnel()
  {
    return passeProfessionnel;
  }
  
  public void setPasseProfessionnel(Chronologie passeProfessionnel)
  {
    this.passeProfessionnel = passeProfessionnel;
  }
  
  public Periode getPra()
  {
    return pra;
  }
  
  public void setPra(Periode pra)
  {
    this.pra = pra;
  }
  
  public IOutilFonctionnelRechercheDiffere getOutilRechercheDiffere()
  {
    return outilFonctionnel;
  }
  
  public void setOutilRechercheDiffere(IOutilFonctionnelRechercheDiffere outilFonctionnel)
  {
    this.outilFonctionnel = outilFonctionnel;
  }
  
  public Damj getDebutTheoriqueDelaiAttente()
  {
    return debutTheoriqueDelaiAttente;
  }
  
  public void setDebutTheoriqueDelaiAttente(Damj debutTheoriqueDelaiAttente)
  {
    this.debutTheoriqueDelaiAttente = debutTheoriqueDelaiAttente;
  }
  
  public void setNombreJoursTravaillesForces(BigDecimal nombreJoursTravaillesForces)
  {
    this.nombreJoursTravaillesForces = nombreJoursTravaillesForces;
  }
  
  public BigDecimal getNombreJoursTravaillesForces()
  {
    return nombreJoursTravaillesForces;
  }
  
  public Damj getDateDernierFgd()
  {
    return dateDernierFgd;
  }
  
  public void setDateDernierFgd(Damj dateDernierFgd)
  {
    this.dateDernierFgd = dateDernierFgd;
  }
}

/* Location:
 * Qualified Name:     DonneesEntreesDelaisReportsSpectacle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */