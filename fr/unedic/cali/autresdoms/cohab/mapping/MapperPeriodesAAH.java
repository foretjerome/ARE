package fr.unedic.cali.autresdoms.cohab.mapping;

import fr.unedic.cali.autresdoms.cohab.dom.IndividuCohabAbstrait;
import fr.unedic.cali.dom.PeriodeDroitAAH;
import fr.unedic.cali.utilitaire.comparateurs.ComparateurPeriodeAAHSurDateCroissante;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MapperPeriodesAAH
{
  public static void mapperPeriodesAAH(IndividuCohabAbstrait individu, Collection<PeriodeDroitAAH> collectionPeriodesAAH)
  {
    individu.setListePeriodesDroitAAH(algorithmeFusionPeriode(collectionPeriodesAAH));
  }
  
  public static Collection<PeriodeDroitAAH> algorithmeFusionPeriode(Collection<PeriodeDroitAAH> collectionPeriodesAAH)
  {
    Collection<PeriodeDroitAAH> listePeriodesAAHaMappee = new ArrayList();
    List<PeriodeDroitAAH> listePeriodeAAH = new ArrayList();
    if (collectionPeriodesAAH != null)
    {
      listePeriodeAAH.addAll(collectionPeriodesAAH);
      Collections.sort(listePeriodeAAH, new ComparateurPeriodeAAHSurDateCroissante());
      Iterator<PeriodeDroitAAH> iterPeriodeAAH = listePeriodeAAH.iterator();
      
      PeriodeDroitAAH periodeAAHtraitee = null;
      while (iterPeriodeAAH.hasNext())
      {
        PeriodeDroitAAH periodeAAHenCours = (PeriodeDroitAAH)iterPeriodeAAH.next();
        if ((periodeAAHtraitee != null) && (dateFinNuitDesTemps(periodeAAHtraitee, periodeAAHenCours))) {
          majDateDebutDroitEnCours(periodeAAHtraitee, periodeAAHenCours);
        }
        majDateFinPeriodeEnCours(periodeAAHenCours);
        
        constructionFinalePeriode(periodeAAHenCours, iterPeriodeAAH, listePeriodesAAHaMappee);
        
        periodeAAHtraitee = periodeAAHenCours;
      }
    }
    if (listePeriodesAAHaMappee.isEmpty())
    {
      Periode periode = new Periode(Damj.FIN_DES_TEMPS, Damj.FIN_DES_TEMPS);
      PeriodeDroitAAH periodeDroit = new PeriodeDroitAAH(periode);
      listePeriodesAAHaMappee.add(periodeDroit);
    }
    return listePeriodesAAHaMappee;
  }
  
  private static boolean dateFinNuitDesTemps(PeriodeDroitAAH periodeAAHtraitee, PeriodeDroitAAH periodeAAHenCours)
  {
    if ((periodeAAHenCours.getPeriodeDroit().getFin().coincideAvec(Damj.FIN_DES_TEMPS)) || (periodeAAHtraitee.getPeriodeDroit().getFin().coincideAvec(Damj.FIN_DES_TEMPS))) {
      return true;
    }
    return false;
  }
  
  private static void majDateFinPeriodeEnCours(PeriodeDroitAAH periodeAAHenCours)
  {
    if (periodeAAHenCoursFermante(periodeAAHenCours)) {
      periodeAAHenCours.getPeriodeDroit().setFin(periodeAAHenCours.getPeriodeDroit().getFin());
    } else {
      periodeAAHenCours.getPeriodeDroit().setFin(Damj.FIN_DES_TEMPS);
    }
  }
  
  private static void majDateDebutDroitEnCours(PeriodeDroitAAH periodeAAHtraitee, PeriodeDroitAAH periodeAAHenCours)
  {
    if ((periodeAAHtraitee.getTypeFin().isEmpty()) || ("FM".equals(periodeAAHtraitee.getTypeFin()))) {
      periodeAAHenCours.getPeriodeDroit().setDebut(periodeAAHtraitee.getPeriodeDroit().getDebut());
    }
  }
  
  private static boolean periodeAAHenCoursFermante(PeriodeDroitAAH periodeAAHenCours)
  {
    if (("OF".equals(periodeAAHenCours.getTypeFin())) || ("FF".equals(periodeAAHenCours.getTypeFin())) || ("FD".equals(periodeAAHenCours.getTypeFin()))) {
      return true;
    }
    return false;
  }
  
  private static void constructionFinalePeriode(PeriodeDroitAAH periodeAAHenCours, Iterator<PeriodeDroitAAH> iterPeriodeAAH, Collection<PeriodeDroitAAH> listePeriodesAAHaMappee)
  {
    if (((!iterPeriodeAAH.hasNext()) || (periodeAAHenCoursFermante(periodeAAHenCours))) && (!periodeAAHenCours.getPeriodeDroit().getFin().equals(periodeAAHenCours.getPeriodeDroit().getDebut())))
    {
      if (!periodeAAHenCours.getPeriodeDroit().getFin().coincideAvec(Damj.FIN_DES_TEMPS)) {
        periodeAAHenCours.getPeriodeDroit().setFin(periodeAAHenCours.getPeriodeDroit().getFin().veille());
      }
      listePeriodesAAHaMappee.add(periodeAAHenCours);
    }
  }
}

/* Location:
 * Qualified Name:     MapperPeriodesAAH
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */