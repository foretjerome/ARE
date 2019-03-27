package fr.unedic.cali.calcul.outilsfonctionnels;

import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteNonSalariePeriodique;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeAvecRevenu;
import fr.unedic.cali.autresdoms.ga.dom.PeriodePansAvecRevenu;
import fr.unedic.cali.calcul.dom.periode.Pans;
import fr.unedic.cali.calcul.dom.periode.PansMensuel;
import fr.unedic.cali.calcul.dom.periode.PansSupraMensuel;
import fr.unedic.cali.calcul.dom.periode.PeriodeNonDeclaree;
import fr.unedic.util.Mathematiques;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class GestionPans
{
  public static ChronologiePeriodes creerPans(PeriodeActiviteNonSalariePeriodique p_periodeActivite, PeriodeAvecRevenu p_periodeAvecRevenu)
  {
    ChronologiePeriodes chronoPans = new ChronologiePeriodes();
    
    Damj dateAccordDdte = p_periodeActivite.getDateValidationPANS();
    if ((dateAccordDdte != null) && (p_periodeAvecRevenu.getDateDebut().estAvant(dateAccordDdte)) && (p_periodeAvecRevenu.getDateFin().estApres(dateAccordDdte)) && (p_periodeActivite.getDateDebut().estAvant(dateAccordDdte)) && (p_periodeActivite.getDateFin().estApresOuCoincideAvec(dateAccordDdte)))
    {
      Damj veilleDateAccordDDte = dateAccordDdte.veille();
      Pans pansCalculAvantAccordDdte = new Pans(p_periodeAvecRevenu.getDateDebut(), veilleDateAccordDDte);
      pansCalculAvantAccordDdte.setTypeRevenu(p_periodeAvecRevenu.getTypeRevenu());
      if (p_periodeAvecRevenu.getTypeRevenu() == 3)
      {
        Collection collectionPNDAvantAccordDdte = getCollectionPndSurPeriode(p_periodeAvecRevenu.getDateDebut(), veilleDateAccordDDte, p_periodeActivite);
        if ((collectionPNDAvantAccordDdte != null) && (!collectionPNDAvantAccordDdte.isEmpty())) {
          pansCalculAvantAccordDdte.setCollectionPND(collectionPNDAvantAccordDdte);
        }
      }
      pansCalculAvantAccordDdte.setGain(Mathematiques.proratiser(p_periodeAvecRevenu.getMontant(), new BigDecimal(veilleDateAccordDDte.joursEntre(p_periodeAvecRevenu.getDateDebut()) + 1), new BigDecimal(p_periodeAvecRevenu.getDateFin().joursEntre(p_periodeAvecRevenu.getDateDebut()) + 1)));
      
      pansCalculAvantAccordDdte.setPeriodeInitiale(new Periode(p_periodeAvecRevenu.getDateDebut(), veilleDateAccordDDte));
      pansCalculAvantAccordDdte.setPeriodeOrigine(new Periode(p_periodeActivite.getDateDebut(), veilleDateAccordDDte));
      
      pansCalculAvantAccordDdte.setIdentifiant(p_periodeActivite.getIdentifiant());
      chronoPans.ajouter(pansCalculAvantAccordDdte);
      
      Pans pansCalculApresAccordDdte = new Pans(dateAccordDdte, p_periodeAvecRevenu.getDateFin());
      pansCalculApresAccordDdte.setTypeRevenu(p_periodeAvecRevenu.getTypeRevenu());
      if (p_periodeAvecRevenu.getTypeRevenu() == 3)
      {
        Collection collectionPNDApresAccordDdte = getCollectionPndSurPeriode(dateAccordDdte, p_periodeAvecRevenu.getDateFin(), p_periodeActivite);
        if ((collectionPNDApresAccordDdte != null) && (!collectionPNDApresAccordDdte.isEmpty())) {
          pansCalculApresAccordDdte.setCollectionPND(collectionPNDApresAccordDdte);
        }
      }
      pansCalculApresAccordDdte.setGain(p_periodeAvecRevenu.getMontant().subtract(pansCalculAvantAccordDdte.getGain()));
      pansCalculApresAccordDdte.miseAjourDDTE(p_periodeActivite);
      pansCalculApresAccordDdte.setPeriodeInitiale(new Periode(dateAccordDdte, p_periodeAvecRevenu.getDateFin()));
      pansCalculApresAccordDdte.setPeriodeOrigine(p_periodeActivite.getPeriode());
      
      pansCalculApresAccordDdte.setIdentifiant(p_periodeActivite.getIdentifiant());
      chronoPans.ajouter(pansCalculApresAccordDdte);
    }
    else
    {
      Pans pansCalcul = new Pans(p_periodeAvecRevenu.getDateDebut(), p_periodeAvecRevenu.getDateFin());
      pansCalcul.setTypeRevenu(p_periodeAvecRevenu.getTypeRevenu());
      if (p_periodeAvecRevenu.getTypeRevenu() == 3)
      {
        Collection collectionPND = getCollectionPndSurPeriode(p_periodeAvecRevenu.getDateDebut(), p_periodeAvecRevenu.getDateFin(), p_periodeActivite);
        if ((collectionPND != null) && (!collectionPND.isEmpty())) {
          pansCalcul.setCollectionPND(collectionPND);
        }
      }
      pansCalcul.setGain(p_periodeAvecRevenu.getMontant());
      pansCalcul.miseAjourDDTE(p_periodeActivite);
      pansCalcul.setPeriodeInitiale(new Periode(p_periodeAvecRevenu.getDateDebut(), p_periodeAvecRevenu.getDateFin()));
      pansCalcul.setPeriodeOrigine(p_periodeActivite.getPeriode());
      
      pansCalcul.setIdentifiant(p_periodeActivite.getIdentifiant());
      chronoPans.ajouter(pansCalcul);
    }
    return chronoPans;
  }
  
  private static Collection getCollectionPndSurPeriode(Damj p_dateDebut, Damj p_dateFin, PeriodeActiviteNonSalariePeriodique p_periodeActivite)
  {
    Collection collectionPND = new ArrayList();
    
    Iterator it = p_periodeActivite.getCollectionPND().iterator();
    
    Periode pndCourante = null;
    while (it.hasNext())
    {
      pndCourante = (Periode)it.next();
      if ((pndCourante.getDebut().estApresOuCoincideAvec(p_dateDebut)) && (pndCourante.getDebut().estAvantOuCoincideAvec(p_dateFin))) {
        collectionPND.add(new PeriodeNonDeclaree(pndCourante.getDebut(), pndCourante.getFin()));
      }
    }
    return collectionPND;
  }
  
  public static ChronologiePeriodes creerPansMensuelOuSupraMensuel(PeriodeActiviteNonSalariePeriodique periodeActivite, PeriodePansAvecRevenu periodePansAvecRevenu)
  {
    ChronologiePeriodes chronoPans = new ChronologiePeriodes();
    if (periodePansAvecRevenu.estUnePeriodeEmploiJustifiableMensuellement())
    {
      PansMensuel pansMensuel = new PansMensuel(periodePansAvecRevenu.getDateDebut(), periodePansAvecRevenu.getDateFin());
      if (periodePansAvecRevenu.getMontant() != null)
      {
        pansMensuel.setGain(periodePansAvecRevenu.getMontant());
        pansMensuel.setGainsSurPeriodePresent(true);
      }
      else
      {
        pansMensuel.setGain(BigDecimal.ZERO);
      }
      pansMensuel.setPeriodeOrigine(periodePansAvecRevenu.getPeriode());
      pansMensuel.setIdentifiant(periodeActivite.getIdentifiant());
      chronoPans.ajouter(pansMensuel);
    }
    else
    {
      PansSupraMensuel pansSupraMensuel = new PansSupraMensuel(periodePansAvecRevenu.getDateDebut(), periodePansAvecRevenu.getDateFin());
      if (periodePansAvecRevenu.getMontant() != null)
      {
        pansSupraMensuel.setGain(periodePansAvecRevenu.getMontant());
        pansSupraMensuel.setGainsSurPeriodePresent(true);
      }
      else
      {
        pansSupraMensuel.setGain(BigDecimal.ZERO);
      }
      pansSupraMensuel.setPeriodeOrigine(periodePansAvecRevenu.getPeriode());
      pansSupraMensuel.setIdentifiant(periodeActivite.getIdentifiant());
      pansSupraMensuel.setDateEcheanceJustificationRevenu(periodePansAvecRevenu.getDateEcheance());
      chronoPans.ajouter(pansSupraMensuel);
    }
    return chronoPans;
  }
}

/* Location:
 * Qualified Name:     GestionPans
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */