package fr.unedic.cali.calcul.dom;

import fr.unedic.cali.calcul.dom.gen.CalendrierExecutionAvantGen;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class CalendrierExecutionAvant
  extends CalendrierExecutionAvantGen
  implements CalendrierExecutionAvantSpec
{
  private static final long serialVersionUID = 1L;
  public static final int ETAT_AVANT_EXECUTION = 1;
  public static final int ETAT_PENDANT_EXECUTION = 2;
  public static final int ETAT_APRES_EXECUTION = 3;
  private transient Chronologie m_chronologieUnitesTraitements;
  private transient int m_etatExecutionAvant;
  private transient Damj debutPeriodePECEvenementReducteurs;
  
  public CalendrierExecutionAvant() {}
  
  public CalendrierExecutionAvant(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public Damj getPremierJourAvant()
  {
    return getDateDebut();
  }
  
  public void setPremierJourAvant(Damj p_premierJourIndemnisable)
  {
    setDateDebut(p_premierJourIndemnisable);
  }
  
  public Damj getDernierJourAvant()
  {
    return getDateFin();
  }
  
  public void setDernierJourAvant(Damj p_dernierJourIndemnisable)
  {
    setDateFin(p_dernierJourIndemnisable);
  }
  
  public Periode getPeriode()
  {
    return super.getPeriode();
  }
  
  public void setPeriode(Periode p_periode)
  {
    super.setPeriode(p_periode);
  }
  
  public void setDateDebut(Damj p_dateDebut)
  {
    if (p_dateDebut != null)
    {
      Damj dateFin = getDateFin();
      if (dateFin != null)
      {
        if (p_dateDebut.estApres(dateFin)) {
          dateFin = p_dateDebut;
        }
        setPeriode(new Periode(p_dateDebut, dateFin));
      }
    }
  }
  
  public void setDateFin(Damj p_dateFin)
  {
    if (p_dateFin != null)
    {
      Damj dateDebut = getDateDebut();
      if (dateDebut != null)
      {
        if (p_dateFin.estAvant(dateDebut)) {
          dateDebut = p_dateFin;
        }
        setPeriode(new Periode(dateDebut, p_dateFin));
      }
    }
  }
  
  public void ajouterUniteTraitementAvant(UniteTraitementAvant p_utAvant)
  {
    if (p_utAvant != null) {
      getChronologieUnitesTraitements().ajouter(p_utAvant);
    }
  }
  
  public void supprimerUniteTraitementAvant(UniteTraitementAvant p_utAvant)
  {
    if (p_utAvant != null) {
      getChronologieUnitesTraitements().supprimer(p_utAvant);
    }
  }
  
  public Chronologie getChronologieUnitesTraitements()
  {
    if (m_chronologieUnitesTraitements == null) {
      m_chronologieUnitesTraitements = new ChronologiePeriodes();
    }
    return m_chronologieUnitesTraitements;
  }
  
  public void setListChronologieUnitesTraitements(Chronologie p_chronologieUnitesTraitements)
  {
    Chronologie chronologieExistante = getChronologieUnitesTraitements();
    
    p_chronologieUnitesTraitements.iterer();
    while (p_chronologieUnitesTraitements.encoreSuivant())
    {
      UniteTraitementAvant utAvant = (UniteTraitementAvant)p_chronologieUnitesTraitements.elementSuivant();
      if (!chronologieExistante.contientElement(utAvant)) {
        ajouterUniteTraitementAvant(utAvant);
      }
    }
    p_chronologieUnitesTraitements.iterer();
    while (chronologieExistante.encoreSuivant())
    {
      UniteTraitementAvant utAvant = (UniteTraitementAvant)chronologieExistante.elementSuivant();
      if (!p_chronologieUnitesTraitements.contientElement(utAvant)) {
        supprimerUniteTraitementAvant(utAvant);
      }
    }
  }
  
  public int getEtatExecutionAvant()
  {
    return m_etatExecutionAvant;
  }
  
  public void setEtatExecutionAvant(int p_etatExecutionAvant)
  {
    m_etatExecutionAvant = p_etatExecutionAvant;
  }
  
  public ObjetMetierSpec copie()
  {
    CalendrierExecutionAvant copie = new CalendrierExecutionAvant();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    CalendrierExecutionAvant copie = (CalendrierExecutionAvant)p_copie;
    copie.setDateDebut(getDateDebut());
    copie.setDateFin(getDateFin());
    copie.setEtatAuDernierJourAvant(getEtatAuDernierJourAvant());
    copie.setEtatExecutionAvant(getEtatExecutionAvant());
    copie.setChronologieUnitesTraitements(getChronologieUnitesTraitements());
    copie.setDateDrv(getDateDrv());
  }
  
  private void setChronologieUnitesTraitements(Chronologie p_chronologieUnitesTraitements)
  {
    m_chronologieUnitesTraitements = p_chronologieUnitesTraitements;
  }
  
  public String getIdentifiant()
  {
    return DomManager.getIdentifiant(this);
  }
  
  public void marquerGraphePersistant()
  {
    DomManager.persisterEnProfondeur(super.getEtatAuDernierJourAvant());
  }
  
  public void setEtatAuDernierJourAvant(EtatAuDernierJourAvant etatAuDernierJourAvant)
  {
    DomManager.supprimer(super.getEtatAuDernierJourAvant(), etatAuDernierJourAvant);
    super.setEtatAuDernierJourAvant(etatAuDernierJourAvant);
  }
  
  public void setDebutPeriodePECEvenementReducteurs(Damj debutPeriodePECEvenementReducteurs)
  {
    this.debutPeriodePECEvenementReducteurs = debutPeriodePECEvenementReducteurs;
  }
  
  public Damj getDebutPeriodePECEvenementReducteurs()
  {
    return debutPeriodePECEvenementReducteurs;
  }
}

/* Location:
 * Qualified Name:     CalendrierExecutionAvant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */