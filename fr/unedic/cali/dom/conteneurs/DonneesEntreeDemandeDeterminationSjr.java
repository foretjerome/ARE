package fr.unedic.cali.dom.conteneurs;

import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.ContexteDemandeSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.dom.affectation.Reglement;
import fr.unedic.cali.dom.conteneurs.spec.DonneesEntreeDemandeDeterminationSjrSpec;
import fr.unedic.cali.util.OutilDomToString;
import fr.unedic.util.Quantite;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DonneesEntreeDemandeDeterminationSjr
  implements DonneesEntreeDemandeDeterminationSjrSpec
{
  private IndividuSpec individu;
  private Damj dateAttribution;
  private Damj dateExamen;
  private Damj dateFaitGenerateurDroitCourant;
  private Damj dateFaitGenerateurDroitPrecedent;
  private Reglement reglementApplicable;
  private Quantite donneeForceeSjr;
  private Quantite donneeForceeSjrPerteActConservee;
  private Quantite donneeForceeSjc;
  private Quantite donneeForceeSjcPerteActConservee;
  private boolean primoDemandeurA3A4A5;
  private Integer categorieA2b;
  private String contexteDemande;
  private List<ContexteDemandeSpec> listeContexteDemande;
  private ProduitSpec produit;
  private Quantite quantiteAppartenanceJoursPrincipale;
  private boolean estDemandeDeRechargement;
  private BigDecimal diviseurCasGeneralForcee;
  private Collection listePlafonnementAffiliation;
  
  public List<ContexteDemandeSpec> getListeContexteDemande()
  {
    return listeContexteDemande;
  }
  
  public void setListeContexteDemande(List<ContexteDemandeSpec> listeContexteDemande)
  {
    this.listeContexteDemande = listeContexteDemande;
  }
  
  public Damj getDateAttribution()
  {
    return dateAttribution;
  }
  
  public void setDateAttribution(Damj dateAttribution)
  {
    this.dateAttribution = dateAttribution;
  }
  
  public Damj getDateExamen()
  {
    return dateExamen;
  }
  
  public void setDateExamen(Damj dateExamen)
  {
    this.dateExamen = dateExamen;
  }
  
  public Damj getDateFaitGenerateurDroitCourant()
  {
    return dateFaitGenerateurDroitCourant;
  }
  
  public void setDateFaitGenerateurDroitCourant(Damj dateFaitGenerateurDroitCourant)
  {
    this.dateFaitGenerateurDroitCourant = dateFaitGenerateurDroitCourant;
  }
  
  public Damj getDateFaitGenerateurDroitPrecedent()
  {
    return dateFaitGenerateurDroitPrecedent;
  }
  
  public void setDateFaitGenerateurDroitPrecedent(Damj dateFaitGenerateurDroitPrecedent)
  {
    this.dateFaitGenerateurDroitPrecedent = dateFaitGenerateurDroitPrecedent;
  }
  
  public Quantite getDonneeForceeSjr()
  {
    return donneeForceeSjr;
  }
  
  public void setDonneeForceeSjr(Quantite donneeForceeSjr)
  {
    this.donneeForceeSjr = donneeForceeSjr;
  }
  
  public Quantite getDonneeForceeSjrPerteActConservee()
  {
    return donneeForceeSjrPerteActConservee;
  }
  
  public void setDonneeForceeSjrPerteActConservee(Quantite donneeForceeSjrPerteActConservee)
  {
    this.donneeForceeSjrPerteActConservee = donneeForceeSjrPerteActConservee;
  }
  
  public Quantite getDonneeForceeSjc()
  {
    return donneeForceeSjc;
  }
  
  public void setDonneeForceeSjc(Quantite donneeForceeSjc)
  {
    this.donneeForceeSjc = donneeForceeSjc;
  }
  
  public Quantite getDonneeForceeSjcPerteActConservee()
  {
    return donneeForceeSjcPerteActConservee;
  }
  
  public void setDonneeForceeSjcPerteActConservee(Quantite donneeForceeSjcPerteActConservee)
  {
    this.donneeForceeSjcPerteActConservee = donneeForceeSjcPerteActConservee;
  }
  
  public IndividuSpec getIndividu()
  {
    return individu;
  }
  
  public void setIndividu(IndividuSpec individu)
  {
    this.individu = individu;
  }
  
  public Reglement getReglementApplicable()
  {
    return reglementApplicable;
  }
  
  public void setReglementApplicable(Reglement reglementApplicable)
  {
    this.reglementApplicable = reglementApplicable;
  }
  
  public boolean isPrimoDemandeurA3A4A5()
  {
    return primoDemandeurA3A4A5;
  }
  
  public void setPrimoDemandeurA3A4A5(boolean primoDemandeurA3A4A5)
  {
    this.primoDemandeurA3A4A5 = primoDemandeurA3A4A5;
  }
  
  public Collection getListePlafonnementAffiliation()
  {
    if (listePlafonnementAffiliation == null) {
      listePlafonnementAffiliation = new ArrayList();
    }
    return listePlafonnementAffiliation;
  }
  
  public void setListePlafonnementAffiliation(Collection listePlafonnementAffiliation)
  {
    this.listePlafonnementAffiliation = listePlafonnementAffiliation;
  }
  
  public DonneesEntreeDemandeDeterminationSjrSpec copier()
  {
    DonneesEntreeDemandeDeterminationSjr copie = new DonneesEntreeDemandeDeterminationSjr();
    
    copie.setDateAttribution(getDateAttribution());
    copie.setDateExamen(getDateExamen());
    copie.setDateFaitGenerateurDroitCourant(getDateFaitGenerateurDroitCourant());
    copie.setDateFaitGenerateurDroitPrecedent(getDateFaitGenerateurDroitPrecedent());
    copie.setDonneeForceeSjc(getDonneeForceeSjc());
    copie.setDonneeForceeSjcPerteActConservee(getDonneeForceeSjcPerteActConservee());
    copie.setDonneeForceeSjr(getDonneeForceeSjr());
    copie.setDonneeForceeSjrPerteActConservee(getDonneeForceeSjrPerteActConservee());
    copie.setIndividu(getIndividu());
    copie.setPrimoDemandeurA3A4A5(isPrimoDemandeurA3A4A5());
    copie.setReglementApplicable(getReglementApplicable());
    copie.setListePlafonnementAffiliation(getListePlafonnementAffiliation());
    copie.setProduit(getProduit());
    
    return copie;
  }
  
  public String toString()
  {
    return OutilDomToString.toString(this);
  }
  
  public Integer getCategorieA2bForcee()
  {
    return categorieA2b;
  }
  
  public void setCategorieA2bForcee(Integer categorie)
  {
    categorieA2b = categorie;
  }
  
  public String getContexteDemande()
  {
    return contexteDemande;
  }
  
  public void setContexteDemande(String contexteDemande)
  {
    this.contexteDemande = contexteDemande;
  }
  
  public ProduitSpec getProduit()
  {
    return produit;
  }
  
  public void setProduit(ProduitSpec produit)
  {
    this.produit = produit;
  }
  
  public Quantite getQuantiteAppartenanceJoursPrincipale()
  {
    return quantiteAppartenanceJoursPrincipale;
  }
  
  public void setQuantiteAppartenanceJoursPrincipale(Quantite quantiteAppartenanceJoursPrincipale)
  {
    this.quantiteAppartenanceJoursPrincipale = quantiteAppartenanceJoursPrincipale;
  }
  
  public boolean isEstDemandeDeRechargement()
  {
    return estDemandeDeRechargement;
  }
  
  public void setEstDemandeDeRechargement(boolean estDemandeDeRechargement)
  {
    this.estDemandeDeRechargement = estDemandeDeRechargement;
  }
  
  public BigDecimal getDiviseurCasGeneralForcee()
  {
    return diviseurCasGeneralForcee;
  }
  
  public void setDiviseurCasGeneralForcee(BigDecimal diviseurCasGeneralForcee)
  {
    this.diviseurCasGeneralForcee = diviseurCasGeneralForcee;
  }
}

/* Location:
 * Qualified Name:     DonneesEntreeDemandeDeterminationSjr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */