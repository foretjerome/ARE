package fr.unedic.cali.calcul.aides;

import fr.unedic.cali.calcul.dom.EvenementPaiementProduitPonctuel;
import fr.unedic.cali.calcul.dom.Somme;
import fr.unedic.cali.calcul.dom.UniteTraitement;
import fr.unedic.cali.calcul.pbjc.dom.AideNcp;
import fr.unedic.cali.calcul.pbjc.dom.PbjcNcp;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriode;

public abstract interface FacadeAidesProduitSpec
{
  public abstract boolean controlerExecutionAides(AttributionSpec paramAttributionSpec);
  
  public abstract void positionnerAIDEASupprimer(PbjcNcp paramPbjcNcp, ObjetChronoPeriode paramObjetChronoPeriode);
  
  public abstract void ajouterGroupeMontantProduit(AideNcp paramAideNcp, AttributionSpec paramAttributionSpec, Somme paramSomme, UniteTraitement paramUniteTraitement);
  
  public abstract int retournerReliquatDureeMax(UniteTraitement paramUniteTraitement, ChronologiePeriodes paramChronologiePeriodes, AttributionSpec paramAttributionSpec);
  
  public abstract Quantite retournerQuantiteIndemnisationInitialeDroit(AttributionSpec paramAttributionSpec);
  
  public abstract void traiterAIDEsAPosteriori(ChronologiePeriodes paramChronologiePeriodes, AttributionSpec paramAttributionSpec)
    throws CoucheLogiqueException;
  
  public abstract ChronologiePeriodes supprimerAIDEsANePasPrendreEnCompte(ChronologiePeriodes paramChronologiePeriodes);
  
  public abstract boolean creerAIDEsurUT(AttributionSpec paramAttributionSpec, UniteTraitement paramUniteTraitement);
  
  public abstract void qualifierAIDESuspensive(AideNcp paramAideNcp, ObjetChronoPeriode paramObjetChronoPeriode);
  
  public abstract boolean retournerTopPeriodeRessourcesSuperieuresPlafond(Somme paramSomme);
  
  public abstract ChronologiePeriodes traitementPeriodesSuspensives(ChronologiePeriodes paramChronologiePeriodes, UniteTraitement paramUniteTraitement);
  
  public abstract boolean creerAIDEsurSomme(AttributionSpec paramAttributionSpec, Somme paramSomme);
  
  public abstract AideNcp creerAideNcp(UniteTraitement paramUniteTraitement, AttributionSpec paramAttributionSpec, Damj paramDamj1, Damj paramDamj2)
    throws CoucheLogiqueException;
  
  public abstract AideNcp creerAideProduitPonctuelNcp(EvenementPaiementProduitPonctuel paramEvenementPaiementProduitPonctuel, AttributionSpec paramAttributionSpec)
    throws CoucheLogiqueException;
}

/* Location:
 * Qualified Name:     FacadeAidesProduitSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */