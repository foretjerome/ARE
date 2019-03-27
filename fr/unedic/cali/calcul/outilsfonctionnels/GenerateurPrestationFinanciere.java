package fr.unedic.cali.calcul.outilsfonctionnels;

import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculPeriodique;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculPonctuel;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculSpec;
import fr.unedic.cali.calcul.dom.ConstituantsIndemnisation;
import fr.unedic.cali.calcul.dom.EvenementPaiementProduitPonctuel;
import fr.unedic.cali.calcul.dom.UniteTraitement;
import fr.unedic.cali.calcul.outilsfonctionnels.dom.prestationfinanciere.PrestationFinancierePeriodique;
import fr.unedic.cali.calcul.outilsfonctionnels.dom.prestationfinanciere.PrestationFinancierePonctuelle;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.MontantBaseSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.temps.ChronologiePeriodes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class GenerateurPrestationFinanciere
{
  public static ChronologiePeriodes creerPrestationFinanciere(AttributionSpec p_attribution, CalendrierExecutionCalculSpec p_calendrier)
  {
    ChronologiePeriodes chronologiePrestationFinanciere = null;
    ChronologiePeriodes chronologieUniteTraitement = null;
    UniteTraitement uniteTraitement = null;
    Collection sommes = null;
    ArrayList sommesPrestationFinanciere = null;
    fr.unedic.cali.calcul.dom.Somme sommeUT = null;
    fr.unedic.cali.calcul.outilsfonctionnels.dom.prestationfinanciere.Somme sommePF = null;
    if (p_calendrier != null)
    {
      if (p_attribution.getProduit().getTypePaiement() == 0)
      {
        chronologiePrestationFinanciere = new ChronologiePeriodes();
        
        chronologieUniteTraitement = (ChronologiePeriodes)((CalendrierExecutionCalculPeriodique)p_calendrier).getChronologieUnitesTraitements();
        
        chronologieUniteTraitement.iterer();
        while (chronologieUniteTraitement.encoreSuivant())
        {
          uniteTraitement = (UniteTraitement)chronologieUniteTraitement.elementSuivant();
          sommes = uniteTraitement.getCollectionSommes();
          sommesPrestationFinanciere = new ArrayList();
          if (sommes != null)
          {
            Iterator iteratorSomme = sommes.iterator();
            while (iteratorSomme.hasNext())
            {
              sommeUT = (fr.unedic.cali.calcul.dom.Somme)iteratorSomme.next();
              sommePF = new fr.unedic.cali.calcul.outilsfonctionnels.dom.prestationfinanciere.Somme(sommeUT.getDateDebut(), sommeUT.getDateFin(), sommeUT.getNbBase(), sommeUT.getMontant().getMontantBrut());
              
              sommesPrestationFinanciere.add(sommePF);
            }
          }
          PrestationFinancierePeriodique prestationFinanciere = new PrestationFinancierePeriodique();
          prestationFinanciere.setDateDebut(uniteTraitement.getDateDebut());
          prestationFinanciere.setDateFin(uniteTraitement.getDateFin());
          prestationFinanciere.setQuantiteIndemnisable(uniteTraitement.getQuantiteIndemnisable());
          prestationFinanciere.setQuantiteIndemnisee(uniteTraitement.getQuantiteIndemnisee());
          prestationFinanciere.setQuantiteNonIndemnisee(uniteTraitement.getQuantiteNonIndemnisee());
          prestationFinanciere.setListeSommes(sommesPrestationFinanciere);
          prestationFinanciere.setPeriodesQualifiees(uniteTraitement.getQualificationPeriodes());
          prestationFinanciere.setCollectionQuantiteDroit(uniteTraitement.getConstituantsIndemnisationEnFinUT().getCollectionQuantiteDroit());
          
          prestationFinanciere.setDernierJourIndemnise(p_calendrier.getDernierJourIndemnisable());
          prestationFinanciere.setPremierJourIndemnise(p_calendrier.getPremierJourIndemnisable());
          prestationFinanciere.setCreditDecalage(uniteTraitement.getCreditDecalage());
          prestationFinanciere.setCreditDecalagePNDS(uniteTraitement.getCreditDecalagePNDS());
          
          chronologiePrestationFinanciere.ajouter(prestationFinanciere);
        }
      }
      if (p_attribution.getProduit().getTypePaiement() == 1)
      {
        chronologiePrestationFinanciere = new ChronologiePeriodes();
        PrestationFinancierePonctuelle prestationFinanciere = null;
        
        EvenementPaiementProduitPonctuel evenementPaiementProduitPonctuel = ((CalendrierExecutionCalculPonctuel)p_calendrier).getEvenementPaiementProduitPonctuel();
        
        prestationFinanciere = new PrestationFinancierePonctuelle();
        prestationFinanciere.setDateDePaiement(evenementPaiementProduitPonctuel.getDateDePaiement());
        prestationFinanciere.setMontant(evenementPaiementProduitPonctuel.getMontant().getMontantBrut().getValeur());
        
        chronologiePrestationFinanciere.ajouter(prestationFinanciere);
      }
    }
    return chronologiePrestationFinanciere;
  }
}

/* Location:
 * Qualified Name:     GenerateurPrestationFinanciere
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */