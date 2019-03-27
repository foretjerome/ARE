package fr.unedic.cali.dom.conteneurs.spec;

public abstract interface DonneesEntreeDeterminationSjrSpec
  extends ConteneurDonneesEntreeSpec
{
  public abstract DonneesEntreeComportementSpec getDonneesEntreeComportement();
  
  public abstract void setDonneesEntreeComportement(DonneesEntreeComportementSpec paramDonneesEntreeComportementSpec);
  
  public abstract DonneesEntreeComplementairesDeterminationSjrSpec getDonneesEntreeComplementaires();
  
  public abstract void setDonneesEntreeComplementaires(DonneesEntreeComplementairesDeterminationSjrSpec paramDonneesEntreeComplementairesDeterminationSjrSpec);
  
  public abstract DonneesEntreeDemandeDeterminationSjrSpec getDonneesEntreeDemande();
  
  public abstract void setDonneesEntreeDemande(DonneesEntreeDemandeDeterminationSjrSpec paramDonneesEntreeDemandeDeterminationSjrSpec);
  
  public abstract DonneesEntreeProduitDeterminationSjrSpec getDonneesEntreeProduit();
  
  public abstract void setDonneesEntreeProduit(DonneesEntreeProduitDeterminationSjrSpec paramDonneesEntreeProduitDeterminationSjrSpec);
}

/* Location:
 * Qualified Name:     DonneesEntreeDeterminationSjrSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */