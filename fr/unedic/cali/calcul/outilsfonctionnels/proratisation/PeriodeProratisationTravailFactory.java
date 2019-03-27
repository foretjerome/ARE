package fr.unedic.cali.calcul.outilsfonctionnels.proratisation;

import fr.unedic.cali.calcul.OutillagePeriodes;
import fr.unedic.cali.calcul.dom.periode.PeriodeActiviteEmploiCalcul;
import fr.unedic.cali.calcul.dom.periode.PeriodeNonDeclaree;
import fr.unedic.cali.calcul.dom.periode.PeriodeNonDeclareeSanction;
import fr.unedic.cali.calcul.dom.periode.PeriodeTravail;
import fr.unedic.cali.calcul.dom.periode.PeriodeTravailJustifiee;
import fr.unedic.util.Mathematiques;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.Temporel;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Iterator;

public class PeriodeProratisationTravailFactory
{
  public static ChronologiePeriodes decoupeEtProratise(Collection p_periodesActivite, Damj p_debut, Damj p_fin)
    throws CoucheLogiqueException
  {
    if (p_periodesActivite == null) {
      return null;
    }
    ChronologiePeriodes periodesARetourner = new ChronologiePeriodes();
    
    Iterator iterateurActivites = p_periodesActivite.iterator();
    if ((p_debut != null) || (p_fin != null)) {}
    while (iterateurActivites.hasNext())
    {
      PeriodeTravail periodeProratise = decoupeEtProratise((PeriodeTravail)iterateurActivites.next(), p_debut, p_fin);
      if (periodeProratise != null) {
        periodesARetourner.ajouter(periodeProratise);
      }
      continue;
      while (iterateurActivites.hasNext())
      {
        PeriodeTravail periode = (PeriodeTravail)iterateurActivites.next();
        periodesARetourner.ajouter((Temporel)periode.copie());
      }
    }
    return periodesARetourner;
  }
  
  private static PeriodeTravail decoupeEtProratise(PeriodeTravail p_periodeTravailCalcul, Damj p_debut, Damj p_fin)
  {
    PeriodeTravail periode = (PeriodeTravail)OutillagePeriodes.decoupe((ObjetChronoPeriode)p_periodeTravailCalcul, p_debut, p_fin);
    if ((periode != null) && (periode.getDuree() > 0))
    {
      periode.setGain(Mathematiques.proratiser(p_periodeTravailCalcul.getGain(), new BigDecimal(Integer.toString(periode.getDuree())), new BigDecimal(Integer.toString(p_periodeTravailCalcul.getDuree()))));
      
      periode.setGain(periode.getGain().setScale(p_periodeTravailCalcul.getGain().scale(), 6));
      
      periode.setNombreHeures(Mathematiques.proratiser(p_periodeTravailCalcul.getNombreHeures(), new BigDecimal(Integer.toString(periode.getDuree())), new BigDecimal(Integer.toString(p_periodeTravailCalcul.getDuree()))));
      
      periode.setNombreHeures(periode.getNombreHeures().setScale(p_periodeTravailCalcul.getNombreHeures().scale(), 6));
      if ((p_periodeTravailCalcul instanceof PeriodeTravailJustifiee))
      {
        PeriodeTravailJustifiee periodeCourante = (PeriodeTravailJustifiee)periode;
        if ((periodeCourante.getCollectionPND() != null) && (!periodeCourante.getCollectionPND().isEmpty()))
        {
          Iterator iter = periodeCourante.getCollectionPND().iterator();
          while (iter.hasNext())
          {
            PeriodeNonDeclaree pndCourante = (PeriodeNonDeclaree)iter.next();
            if ((!periodeCourante.getDateDebut().estAvantOuCoincideAvec(pndCourante.getDateDebut())) || (!periodeCourante.getDateFin().estApresOuCoincideAvec(pndCourante.getDateFin()))) {
              iter.remove();
            }
          }
        }
      }
      if ((p_periodeTravailCalcul instanceof PeriodeActiviteEmploiCalcul))
      {
        PeriodeActiviteEmploiCalcul periodeCourante = (PeriodeActiviteEmploiCalcul)periode;
        
        periodeCourante.setIccp(Mathematiques.proratiser(((PeriodeActiviteEmploiCalcul)p_periodeTravailCalcul).getIccp(), new BigDecimal(Integer.toString(periode.getDuree())), new BigDecimal(Integer.toString(p_periodeTravailCalcul.getDuree()))));
        
        periodeCourante.setIccp(periodeCourante.getIccp().setScale(((PeriodeActiviteEmploiCalcul)p_periodeTravailCalcul).getIccp().scale(), 6));
      }
      if ((p_periodeTravailCalcul instanceof PeriodeNonDeclareeSanction))
      {
        PeriodeNonDeclareeSanction periodeCourante = (PeriodeNonDeclareeSanction)periode;
        
        periodeCourante.setIccp(Mathematiques.proratiser(((PeriodeNonDeclareeSanction)p_periodeTravailCalcul).getIccp(), new BigDecimal(Integer.toString(periode.getDuree())), new BigDecimal(Integer.toString(p_periodeTravailCalcul.getDuree()))));
        
        periodeCourante.setIccp(periodeCourante.getIccp().setScale(((PeriodeNonDeclareeSanction)p_periodeTravailCalcul).getIccp().scale(), 6));
      }
      periode.setEstMigree(p_periodeTravailCalcul.estMigree());
      
      periode.setIdentifiant(p_periodeTravailCalcul.getIdentifiant());
    }
    return periode;
  }
}

/* Location:
 * Qualified Name:     PeriodeProratisationTravailFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */