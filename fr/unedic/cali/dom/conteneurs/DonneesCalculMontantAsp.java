package fr.unedic.cali.dom.conteneurs;

import fr.unedic.cali.dom.affectation.ProduitSpec;
import java.math.BigDecimal;
import java.util.Collection;

public class DonneesCalculMontantAsp
{
  private ProduitSpec produitAreSousJacent = null;
  private BigDecimal montantPreavis = null;
  private Collection<DonneesEntreesRecuperationMontant> listeDonneesEntreesRecuperationMontant = null;
  private boolean estDureePostPrimeEpuisee;
  private boolean contextePAPPresent = false;
  private boolean contextePapParlementaire = false;
  
  public BigDecimal getMontantPreavis()
  {
    return montantPreavis;
  }
  
  public void setMontantPreavis(BigDecimal montantPreavis)
  {
    this.montantPreavis = montantPreavis;
  }
  
  public ProduitSpec getProduitAreSousJacent()
  {
    return produitAreSousJacent;
  }
  
  public void setProduitAreSousJacent(ProduitSpec produitAreSousJacent)
  {
    this.produitAreSousJacent = produitAreSousJacent;
  }
  
  public DonneesCalculMontantAsp copie()
  {
    DonneesCalculMontantAsp copie = new DonneesCalculMontantAsp();
    copie.setMontantPreavis(getMontantPreavis());
    copie.setProduitAreSousJacent(getProduitAreSousJacent());
    copie.setListeDonneesEntreesRecuperationMontant(getListeDonneesEntreesRecuperationMontant());
    copie.setEstDureePostPrimeEpuisee(isEstDureePostPrimeEpuisee());
    copie.setContextePAPPresent(isContextePAPPresent());
    copie.setContextePapParlementaire(isContextePapParlementaire());
    return copie;
  }
  
  public void setListeDonneesEntreesRecuperationMontant(Collection<DonneesEntreesRecuperationMontant> listeDonneesEntreesRecuperationMontant)
  {
    this.listeDonneesEntreesRecuperationMontant = listeDonneesEntreesRecuperationMontant;
  }
  
  public Collection<DonneesEntreesRecuperationMontant> getListeDonneesEntreesRecuperationMontant()
  {
    return listeDonneesEntreesRecuperationMontant;
  }
  
  public boolean isEstDureePostPrimeEpuisee()
  {
    return estDureePostPrimeEpuisee;
  }
  
  public void setEstDureePostPrimeEpuisee(boolean estDureePostPrimeEpuisee)
  {
    this.estDureePostPrimeEpuisee = estDureePostPrimeEpuisee;
  }
  
  public boolean isContextePAPPresent()
  {
    return contextePAPPresent;
  }
  
  public void setContextePAPPresent(boolean contextPap)
  {
    contextePAPPresent = contextPap;
  }
  
  public boolean isContextePapParlementaire()
  {
    return contextePapParlementaire;
  }
  
  public void setContextePapParlementaire(boolean contextePapParlementaire)
  {
    this.contextePapParlementaire = contextePapParlementaire;
  }
}

/* Location:
 * Qualified Name:     DonneesCalculMontantAsp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */