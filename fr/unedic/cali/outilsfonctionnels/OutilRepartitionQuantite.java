package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.cali.dom.PeriodeQuantite;
import fr.unedic.util.Mathematiques;
import fr.unedic.util.Quantite;
import fr.unedic.util.Unite;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OutilRepartitionQuantite
{
  private static final BigDecimal ZERO = new BigDecimal(0);
  private static final int ARRONDI_EURO = 2;
  private static final int ARRONDI_DEFAUT = 0;
  
  public static List repartirQuantiteSurMoisCivils(Periode p_periode, Quantite p_quantite)
  {
    List resultat = new ArrayList();
    
    List listePeriodes = p_periode.decouperEnMoisCivils();
    if ((listePeriodes != null) && (listePeriodes.size() > 1))
    {
      int nombreDeJoursDansLaPMA = p_periode.getDuree();
      
      PeriodeQuantite periodeQuantitePremierMois = new PeriodeQuantite();
      resultat.add(periodeQuantitePremierMois);
      
      BigDecimal totalSurNDerniersMois = ZERO;
      for (int i = 1; i < listePeriodes.size(); i++)
      {
        Periode moisCivil = (Periode)listePeriodes.get(i);
        
        BigDecimal quantiteProratisee = proratiser(nombreDeJoursDansLaPMA, moisCivil.getDuree(), p_quantite.getValeur());
        
        Quantite quantitePourPMA = creerQuantiteAvecArrondi(quantiteProratisee, p_quantite.getUnite());
        
        totalSurNDerniersMois = totalSurNDerniersMois.add(quantitePourPMA.getValeur());
        
        PeriodeQuantite periodeQuantite = new PeriodeQuantite(moisCivil, quantitePourPMA);
        resultat.add(periodeQuantite);
      }
      Periode premierMois = (Periode)listePeriodes.get(0);
      BigDecimal valeurSurPremierMois = p_quantite.getValeur().subtract(totalSurNDerniersMois);
      Quantite quantiteSurPremierMois = new Quantite(valeurSurPremierMois, p_quantite.getUnite());
      periodeQuantitePremierMois.setPeriode(premierMois);
      periodeQuantitePremierMois.setQuantite(quantiteSurPremierMois);
    }
    else
    {
      PeriodeQuantite periodeQuantite = new PeriodeQuantite(p_periode, p_quantite);
      resultat.add(periodeQuantite);
    }
    return resultat;
  }
  
  private static Quantite creerQuantiteAvecArrondi(BigDecimal p_quantite, Unite p_unite)
  {
    int precisionArrondi = 0;
    if (p_unite.getCode().equals("22")) {
      precisionArrondi = 2;
    }
    BigDecimal quantiteBaseArrondi = Mathematiques.arrondiASup(p_quantite, precisionArrondi);
    return new Quantite(quantiteBaseArrondi, p_unite);
  }
  
  private static BigDecimal proratiser(int p_nombreJoursTotal, int p_nombreJoursInclus, BigDecimal p_valeur)
  {
    return Mathematiques.proratiser(new BigDecimal(p_nombreJoursInclus), p_valeur, new BigDecimal(p_nombreJoursTotal));
  }
}

/* Location:
 * Qualified Name:     OutilRepartitionQuantite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */