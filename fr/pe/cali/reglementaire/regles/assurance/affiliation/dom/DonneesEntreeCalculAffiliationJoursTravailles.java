package fr.pe.cali.reglementaire.regles.assurance.affiliation.dom;

import fr.pe.cali.reglementaire.regles.assurance.affiliation.outils.spec.IOutilFonctionnelAffiliationJoursTravailles;
import fr.unedic.cali.autresdoms.ga.dom.spec.PeriodeGaecSpec;
import fr.unedic.cali.dom.affectation.ContexteDemandeSpec;
import fr.unedic.cali.dom.affectation.ProduitAsuSpec;
import fr.unedic.cali.dom.pnds.PeriodeNonDeclareeSanction;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.List;
import java.util.Map;

public class DonneesEntreeCalculAffiliationJoursTravailles
{
  private Chronologie passeProfessionnel;
  private Periode periodeRecherche;
  private boolean assimilerSuspensionNonAssimilables;
  private boolean ignorerPNDS;
  private boolean ignorerAssimiliation;
  private Map<PeriodeGaecSpec, PeriodeNonDeclareeSanction> pnds;
  private Damj dateExamen;
  private Damj dateFaitGenerateur;
  private List<ContexteDemandeSpec> listeContexte;
  private IOutilFonctionnelAffiliationJoursTravailles outilFonctionnel;
  private ProduitAsuSpec produit;
  
  public Chronologie getPasseProfessionnel()
  {
    return passeProfessionnel;
  }
  
  public void setPasseProfessionnel(Chronologie passeProfessionnel)
  {
    this.passeProfessionnel = passeProfessionnel;
  }
  
  public Periode getPeriodeRecherche()
  {
    return periodeRecherche;
  }
  
  public void setPeriodeRecherche(Periode periodeRecherche)
  {
    this.periodeRecherche = periodeRecherche;
  }
  
  public boolean isAssimilerSuspensionNonAssimilables()
  {
    return assimilerSuspensionNonAssimilables;
  }
  
  public void setAssimilerSuspensionNonAssimilables(boolean assimilerSuspensionNonAssimilables)
  {
    this.assimilerSuspensionNonAssimilables = assimilerSuspensionNonAssimilables;
  }
  
  public boolean isIgnorerPNDS()
  {
    return ignorerPNDS;
  }
  
  public void setIgnorerPNDS(boolean ignorerPNDS)
  {
    this.ignorerPNDS = ignorerPNDS;
  }
  
  public Map<PeriodeGaecSpec, PeriodeNonDeclareeSanction> getPnds()
  {
    return pnds;
  }
  
  public void setPnds(Map<PeriodeGaecSpec, PeriodeNonDeclareeSanction> pnds)
  {
    this.pnds = pnds;
  }
  
  public Damj getDateExamen()
  {
    return dateExamen;
  }
  
  public void setDateExamen(Damj dateExamen)
  {
    this.dateExamen = dateExamen;
  }
  
  public List<ContexteDemandeSpec> getListeContexte()
  {
    return listeContexte;
  }
  
  public void setListeContexte(List<ContexteDemandeSpec> listeContexte)
  {
    this.listeContexte = listeContexte;
  }
  
  public IOutilFonctionnelAffiliationJoursTravailles getOutilFonctionnel()
  {
    return outilFonctionnel;
  }
  
  public void setOutilFonctionnel(IOutilFonctionnelAffiliationJoursTravailles outilFonctionnel)
  {
    this.outilFonctionnel = outilFonctionnel;
  }
  
  public boolean isIgnorerAssimiliation()
  {
    return ignorerAssimiliation;
  }
  
  public void setIgnorerAssimiliation(boolean ignorerAssimiliation)
  {
    this.ignorerAssimiliation = ignorerAssimiliation;
  }
  
  public Damj getDateFaitGenerateur()
  {
    return dateFaitGenerateur;
  }
  
  public void setDateFaitGenerateur(Damj dateFaitGenerateur)
  {
    this.dateFaitGenerateur = dateFaitGenerateur;
  }
  
  public ProduitAsuSpec getProduit()
  {
    return produit;
  }
  
  public void setProduit(ProduitAsuSpec produit)
  {
    this.produit = produit;
  }
}

/* Location:
 * Qualified Name:     DonneesEntreeCalculAffiliationJoursTravailles
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */