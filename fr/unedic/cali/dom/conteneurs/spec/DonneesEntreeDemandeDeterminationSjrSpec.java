package fr.unedic.cali.dom.conteneurs.spec;

import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.ContexteDemandeSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.dom.affectation.Reglement;
import fr.unedic.util.Quantite;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

public abstract interface DonneesEntreeDemandeDeterminationSjrSpec
{
  public abstract Damj getDateAttribution();
  
  public abstract void setDateAttribution(Damj paramDamj);
  
  public abstract Damj getDateExamen();
  
  public abstract void setDateExamen(Damj paramDamj);
  
  public abstract Damj getDateFaitGenerateurDroitCourant();
  
  public abstract void setDateFaitGenerateurDroitCourant(Damj paramDamj);
  
  public abstract Damj getDateFaitGenerateurDroitPrecedent();
  
  public abstract void setDateFaitGenerateurDroitPrecedent(Damj paramDamj);
  
  public abstract Quantite getDonneeForceeSjr();
  
  public abstract void setDonneeForceeSjr(Quantite paramQuantite);
  
  public abstract Quantite getDonneeForceeSjrPerteActConservee();
  
  public abstract void setDonneeForceeSjrPerteActConservee(Quantite paramQuantite);
  
  public abstract Quantite getDonneeForceeSjc();
  
  public abstract void setDonneeForceeSjc(Quantite paramQuantite);
  
  public abstract Quantite getDonneeForceeSjcPerteActConservee();
  
  public abstract void setDonneeForceeSjcPerteActConservee(Quantite paramQuantite);
  
  public abstract IndividuSpec getIndividu();
  
  public abstract void setIndividu(IndividuSpec paramIndividuSpec);
  
  public abstract Reglement getReglementApplicable();
  
  public abstract void setReglementApplicable(Reglement paramReglement);
  
  public abstract boolean isPrimoDemandeurA3A4A5();
  
  public abstract void setPrimoDemandeurA3A4A5(boolean paramBoolean);
  
  public abstract DonneesEntreeDemandeDeterminationSjrSpec copier();
  
  public abstract void setCategorieA2bForcee(Integer paramInteger);
  
  public abstract Integer getCategorieA2bForcee();
  
  public abstract Collection getListePlafonnementAffiliation();
  
  public abstract void setListePlafonnementAffiliation(Collection paramCollection);
  
  public abstract String getContexteDemande();
  
  public abstract void setContexteDemande(String paramString);
  
  public abstract List<ContexteDemandeSpec> getListeContexteDemande();
  
  public abstract ProduitSpec getProduit();
  
  public abstract void setProduit(ProduitSpec paramProduitSpec);
  
  public abstract Quantite getQuantiteAppartenanceJoursPrincipale();
  
  public abstract void setQuantiteAppartenanceJoursPrincipale(Quantite paramQuantite);
  
  public abstract boolean isEstDemandeDeRechargement();
  
  public abstract void setEstDemandeDeRechargement(boolean paramBoolean);
  
  public abstract BigDecimal getDiviseurCasGeneralForcee();
  
  public abstract void setDiviseurCasGeneralForcee(BigDecimal paramBigDecimal);
}

/* Location:
 * Qualified Name:     DonneesEntreeDemandeDeterminationSjrSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */