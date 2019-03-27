package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.PeriodeMesureActivite;
import fr.unedic.cali.autresdoms.ga.dom.spec.SalarieSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.Unite;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Periode;
import fr.unedic.util.temps.Temporel;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

public class FiltrePeriodeTravailDeclareAvecUnite
  implements FiltreTemporel
{
  private List m_listeUnitePriseEnCompte;
  private Periode m_periodeEtude;
  private boolean m_contientExclusivementUnitesDansListe;
  
  public FiltrePeriodeTravailDeclareAvecUnite(List p_listeUnitePriseEnCompte, Periode p_periodeEtude, boolean p_contientExclusivementUnitesDansListe)
  {
    m_listeUnitePriseEnCompte = p_listeUnitePriseEnCompte;
    m_periodeEtude = p_periodeEtude;
    m_contientExclusivementUnitesDansListe = p_contientExclusivementUnitesDansListe;
  }
  
  public FiltrePeriodeTravailDeclareAvecUnite(Periode p_periodeEtude, boolean p_contientExclusivementUnitesDansListe)
  {
    m_listeUnitePriseEnCompte = new ArrayList();
    m_periodeEtude = p_periodeEtude;
    m_contientExclusivementUnitesDansListe = p_contientExclusivementUnitesDansListe;
  }
  
  public void ajouterUnite(Unite p_unite)
  {
    m_listeUnitePriseEnCompte.add(p_unite);
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    if (p_temporel.estType(SalarieSpec.class))
    {
      SalarieSpec activiteSalariee = (SalarieSpec)p_temporel;
      boolean uniteTrouve = false;
      Chronologie listePeriodeMesureActivite = activiteSalariee.getListePeriodesMesureActivite();
      Iterator it = listePeriodeMesureActivite.iterer();
      while (it.hasNext())
      {
        PeriodeMesureActivite periodeMesureActivite = (PeriodeMesureActivite)it.next();
        Periode perMesureActivite = new Periode(periodeMesureActivite.getDateDebut(), periodeMesureActivite.getDateFin());
        if (m_periodeEtude.chevauche(perMesureActivite))
        {
          Enumeration interQuantiteAffiliation = periodeMesureActivite.getListeQuantitesAffiliation().elements();
          while (interQuantiteAffiliation.hasMoreElements())
          {
            Quantite quantiteAppartenance = (Quantite)interQuantiteAffiliation.nextElement();
            if (m_listeUnitePriseEnCompte.contains(quantiteAppartenance.getUnite()))
            {
              if (!m_contientExclusivementUnitesDansListe) {
                return true;
              }
              uniteTrouve = true;
            }
            else if (m_contientExclusivementUnitesDansListe)
            {
              return false;
            }
          }
        }
      }
      return uniteTrouve;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodeTravailDeclareAvecUnite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */