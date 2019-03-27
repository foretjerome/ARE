package fr.pe.cali.reglementaire.regles.assurance.affiliation.outils.impl;

import fr.unedic.util.Mathematiques;
import fr.unedic.util.Quantite;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;

public class OutilQuantiteAffiliation
{
  private static final OutilQuantiteAffiliation instance = new OutilQuantiteAffiliation();
  
  public static OutilQuantiteAffiliation getInstance()
  {
    return instance;
  }
  
  public Quantite proratiserQuantite(Quantite quantite, float nombreJourTotal, int nombreJourProrata)
  {
    if (quantite != null)
    {
      BigDecimal resultatProrata = Mathematiques.proratiser(quantite.getValeur(), BigDecimal.valueOf(nombreJourProrata), BigDecimal.valueOf(nombreJourTotal));
      
      return new Quantite(resultatProrata, quantite.getUnite());
    }
    return null;
  }
  
  public boolean isQuantiteValide(Quantite quantite)
  {
    return (quantite != null) && (quantite.getValeur().compareTo(BigDecimal.ZERO) > 0);
  }
  
  public int convertirEnJoursTravailles(Quantite quantite, BigDecimal coeffConversion, Periode periodeRecherche, Periode periodePma)
  {
    Quantite quantiteAConvertir;
    Quantite quantiteAConvertir;
    if (periodeRecherche.contient(periodePma)) {
      quantiteAConvertir = quantite;
    } else {
      quantiteAConvertir = getInstance().proratiserQuantite(quantite, periodePma.getDuree(), periodePma.inter(periodeRecherche));
    }
    return quantiteAConvertir.getValeur().multiply(coeffConversion).setScale(0, 0).intValue();
  }
}

/* Location:
 * Qualified Name:     OutilQuantiteAffiliation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */