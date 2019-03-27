package fr.unedic.cali.autresdoms.ga.mapping;

import fr.unedic.cali.autresdoms.ga.dom.Metier;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeMesureActivite;
import fr.unedic.cali.autresdoms.ga.dom.TravailSalarie;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ListeQuantiteTravail;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.QuantiteTravail;
import fr.unedic.util.Mathematiques;
import fr.unedic.util.Quantite;
import fr.unedic.util.Unite;
import fr.unedic.util.UniteAffiliation;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Iterator;

class MapperQuantiteTravail
{
  static final int SEUIL_CACHET_GROUPE = 5;
  private static final Unite UNITE_HEURE_TRAVAIL = Unite.get("heure de travail");
  private static final BigDecimal FACTEUR_CONVERSION_JOURS_HEURES_E301 = new BigDecimal("6");
  private static final BigDecimal CONVERSION_JOUR_HEURES = new BigDecimal(5);
  
  static void ajouter(TravailSalarie pasGaec, ListeQuantiteTravail listeQuantiteTravailGaec, boolean initialiserSansQuantiteTravail)
  {
    if (listeQuantiteTravailGaec != null)
    {
      int nbElements = listeQuantiteTravailGaec.getNbListQuantiteTravail();
      for (int i = 0; i < nbElements; i++)
      {
        QuantiteTravail qteTravailGaec = listeQuantiteTravailGaec.getListeQuantiteTravail(i);
        if (initialiserSansQuantiteTravail)
        {
          QuantiteTravail qt = QuantiteTravail.getInstance();
          qt.setDateDebut(qteTravailGaec.getDateDebut());
          qt.setDateFin(qteTravailGaec.getDateFin());
          qt.setQuantiteTravail(new BigDecimal(0));
          qt.setNatureQuantiteTravail("");
          qteTravailGaec = qt;
        }
        Periode periode = FabriquePeriode.creer(qteTravailGaec.getDateDebut(), qteTravailGaec.getDateFin());
        if (periode.chevauche(pasGaec.getPeriode())) {
          ajouter(pasGaec, qteTravailGaec);
        }
      }
    }
    if (!initialiserSansQuantiteTravail) {
      completerPMAs(pasGaec);
    }
  }
  
  static void ajouter(TravailSalarie pasGaec, QuantiteTravail qteTravailGaec)
  {
    String nomUniteGaec = qteTravailGaec.getNatureQuantiteTravail();
    UniteAffiliation uniteCali = null;
    if ((nomUniteGaec != null) && (!nomUniteGaec.equals("")))
    {
      uniteCali = convertirUniteMesureActivite(pasGaec.getDuree(), nomUniteGaec);
      
      Periode periodeTotale = FabriquePeriode.creer(qteTravailGaec.getDateDebut(), qteTravailGaec.getDateFin());
      int dureeTotale = periodeTotale.getDuree();
      
      Periode periodeIncluse = periodeTotale.periodeIntersection(pasGaec.getPeriode());
      int dureeIncluse = periodeIncluse.getDuree();
      
      BigDecimal qteTravail = qteTravailGaec.getQuantiteTravail();
      if (dureeIncluse != dureeTotale) {
        qteTravail = Mathematiques.proratiser(qteTravail, new BigDecimal(dureeIncluse), new BigDecimal(dureeTotale));
      }
      BigDecimal quantiteHeures = qteTravailGaec.getHeureComplSpectacle();
      
      PeriodeMesureActivite mesureActiviteCali = new PeriodeMesureActivite(periodeIncluse);
      Quantite qte = new Quantite(qteTravail, uniteCali);
      if ((uniteCali.equals(UniteAffiliation.CACHET_GROUPE)) || (uniteCali.equals(UniteAffiliation.CACHET_ISOLE))) {
        if ((quantiteHeures != null) && (!quantiteHeures.equals(new BigDecimal(0))))
        {
          Quantite quantiteHeureComplementaire = new Quantite(quantiteHeures, UniteAffiliation.HEURE_TRAVAIL);
          
          mesureActiviteCali.ajouterQuantiteAffiliation(quantiteHeureComplementaire);
          mesureActiviteCali.setPresenceHeureComplementaire(true);
        }
      }
      mesureActiviteCali.ajouterQuantiteAffiliation(qte);
      
      pasGaec.ajouterPeriodeMesureActivite(mesureActiviteCali);
    }
    else
    {
      Periode periodeTotale = FabriquePeriode.creer(qteTravailGaec.getDateDebut(), qteTravailGaec.getDateFin());
      Periode periodeIncluse = periodeTotale.periodeIntersection(pasGaec.getPeriode());
      PeriodeMesureActivite mesureActiviteCali = new PeriodeMesureActivite(periodeIncluse);
      if ((pasGaec.getMetier() != null) && (30 == pasGaec.getMetier().getContratTypeParticulier()))
      {
        BigDecimal dureePeriode = new BigDecimal(periodeIncluse.getDuree());
        Quantite quantite = new Quantite(CONVERSION_JOUR_HEURES.multiply(dureePeriode), UniteAffiliation.HEURE_TRAVAIL);
        mesureActiviteCali.ajouterQuantiteAffiliation(quantite);
      }
      pasGaec.ajouterPeriodeMesureActivite(mesureActiviteCali);
    }
  }
  
  private static UniteAffiliation convertirUniteMesureActivite(int dureePas, String pUniteGaec)
  {
    int uniteGaec = Integer.parseInt(pUniteGaec);
    String nomUniteCali;
    if (uniteGaec == 1)
    {
      nomUniteCali = "jour d'affiliation";
    }
    else
    {
      String nomUniteCali;
      if (uniteGaec == 2)
      {
        nomUniteCali = "heure de travail";
      }
      else
      {
        String nomUniteCali;
        if (uniteGaec == 3)
        {
          nomUniteCali = dureePas >= 5 ? "cachet groupe" : "cachet isole";
        }
        else
        {
          String nomUniteCali;
          if (uniteGaec == 4)
          {
            nomUniteCali = "vacation";
          }
          else
          {
            String nomUniteCali;
            if (uniteGaec == 5)
            {
              nomUniteCali = "embarquement administratif";
            }
            else
            {
              String nomUniteCali;
              if (uniteGaec == 6)
              {
                nomUniteCali = "cachet groupe";
              }
              else
              {
                String nomUniteCali;
                if (uniteGaec == 7) {
                  nomUniteCali = "cachet isole";
                } else {
                  throw new RuntimeException("Erreur de mapping de l'unite GA " + pUniteGaec);
                }
              }
            }
          }
        }
      }
    }
    String nomUniteCali;
    return (UniteAffiliation)UniteAffiliation.get(nomUniteCali);
  }
  
  static void completerPMAs(TravailSalarie pasGaec)
  {
    Chronologie listeNewPMAs = new ChronologiePeriodes();
    Damj dateFinPMAPrec = pasGaec.getDateDebut().veille();
    for (Iterator iter = pasGaec.getListePeriodesMesureActivite().iterer(); iter.hasNext();)
    {
      PeriodeMesureActivite pma = (PeriodeMesureActivite)iter.next();
      if (pma.getDateDebut().joursEntre(dateFinPMAPrec) > 1)
      {
        Periode periode = new Periode(dateFinPMAPrec.lendemain(), pma.getDateDebut().veille());
        listeNewPMAs.ajouter(new PeriodeMesureActivite(periode));
      }
      dateFinPMAPrec = pma.getDateFin();
    }
    if (pasGaec.getDateFin().joursEntre(dateFinPMAPrec) > 0)
    {
      Periode periode = new Periode(dateFinPMAPrec.lendemain(), pasGaec.getDateFin());
      listeNewPMAs.ajouter(new PeriodeMesureActivite(periode));
    }
    for (Iterator iter = listeNewPMAs.iterer(); iter.hasNext();)
    {
      PeriodeMesureActivite pma = (PeriodeMesureActivite)iter.next();
      pasGaec.ajouterPeriodeMesureActivite(pma);
    }
  }
  
  static void completerQuantiteTravail(PeriodeActiviteSalarie pasGaec)
  {
    boolean contratE301OuU1 = pasGaec.getCollectionOrigineInformationPAS().contains(Integer.valueOf(10));
    PeriodeMesureActivite pmaCourante;
    Quantite quantiteHeuresPmaCourante;
    BigDecimal nombreHeuresPmaCourante;
    Iterator iter;
    if (contratE301OuU1)
    {
      pmaCourante = null;
      quantiteHeuresPmaCourante = null;
      nombreHeuresPmaCourante = new BigDecimal("0");
      for (iter = pasGaec.getListePeriodesMesureActivite().iterer(); iter.hasNext();)
      {
        pmaCourante = (PeriodeMesureActivite)iter.next();
        
        quantiteHeuresPmaCourante = pmaCourante.getQuantiteAffiliation(UNITE_HEURE_TRAVAIL);
        if (quantiteHeuresPmaCourante == null)
        {
          nombreHeuresPmaCourante = new BigDecimal(pmaCourante.getDuree()).multiply(FACTEUR_CONVERSION_JOURS_HEURES_E301);
          quantiteHeuresPmaCourante = new Quantite(nombreHeuresPmaCourante, UNITE_HEURE_TRAVAIL);
          pmaCourante.ajouterQuantiteAffiliation(quantiteHeuresPmaCourante);
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     MapperQuantiteTravail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */