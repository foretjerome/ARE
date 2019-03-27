package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalculTransient;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.Unite;
import fr.unedic.util.temps.Damj;

public class ActionFormation
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 3261187026674144871L;
  private int m_identifiantActionFormation;
  private String m_typePlan;
  private Quantite m_nbHeuresHebdo;
  private Quantite m_nbHeuresTotal;
  private int m_typeConvention;
  private Damj m_datePrescription;
  private Quantite m_nbJourPeriodeFormation;
  private boolean activerAREF;
  
  public Quantite getNbJourPeriodeFormation()
  {
    return m_nbJourPeriodeFormation;
  }
  
  public void setNbJourPeriodeFormation(Quantite p_nbJourPeriodeFormation)
  {
    m_nbJourPeriodeFormation = p_nbJourPeriodeFormation;
  }
  
  protected ActionFormation()
  {
    m_nbJourPeriodeFormation = new Quantite(0, Unite.get("jour"));
  }
  
  public ActionFormation(Damj p_debut, Damj p_fin)
  {
    super(p_debut, p_fin);
    m_nbJourPeriodeFormation = new Quantite(0, Unite.get("jour"));
  }
  
  public String getTypePlan()
  {
    return m_typePlan;
  }
  
  public void setTypePlan(String p_typePlan)
  {
    m_typePlan = p_typePlan;
  }
  
  public int getIdentifiantActionFormation()
  {
    return m_identifiantActionFormation;
  }
  
  public void setIdentifiantActionFormation(int p_identifiantActionFormation)
  {
    m_identifiantActionFormation = p_identifiantActionFormation;
  }
  
  public Quantite getQuantiteHoraireHebdo()
  {
    return m_nbHeuresHebdo;
  }
  
  public void setQuantiteHoraireHebdo(Quantite p_nbHeuresHebdomadaire)
  {
    m_nbHeuresHebdo = p_nbHeuresHebdomadaire;
  }
  
  public Quantite getQuantiteHoraireTotal()
  {
    return m_nbHeuresTotal;
  }
  
  public void setQuantiteHoraireTotal(Quantite p_nbHeuresTotal)
  {
    m_nbHeuresTotal = p_nbHeuresTotal;
  }
  
  public int getTypeConvention()
  {
    return m_typeConvention;
  }
  
  public void setTypeConvention(int p_typeConvention)
  {
    m_typeConvention = p_typeConvention;
  }
  
  public Damj getDatePrescription()
  {
    return m_datePrescription;
  }
  
  public void setDatePrescription(Damj p_datePrescription)
  {
    m_datePrescription = p_datePrescription;
  }
  
  public boolean estBasculeAutoriserEnContexteFormation()
  {
    return activerAREF;
  }
  
  public void setActiverAREF(boolean activerAREF)
  {
    this.activerAREF = activerAREF;
  }
  
  public ObjetMetierSpec copie()
  {
    ActionFormation copie = new ActionFormation();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    ActionFormation copie = (ActionFormation)p_copie;
    
    super.copieElements(copie);
    
    m_typePlan = getTypePlan();
    m_identifiantActionFormation = getIdentifiantActionFormation();
    m_nbHeuresHebdo = getQuantiteHoraireHebdo();
    m_nbHeuresTotal = getQuantiteHoraireTotal();
    m_typeConvention = getTypeConvention();
    m_datePrescription = getDatePrescription();
    activerAREF = estBasculeAutoriserEnContexteFormation();
  }
}

/* Location:
 * Qualified Name:     ActionFormation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */