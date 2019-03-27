package fr.unedic.cali.dom;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoEvenementDebut;

public abstract class EvenementReferenceExamenAbstraitCustomMapped
  extends ObjetChronoEvenementDebut
  implements EvenementReferenceExamenSpec
{
  protected transient Damj m_dateDeclenchementExamen;
  
  public EvenementReferenceExamenAbstraitCustomMapped()
  {
    setDateEvenement(null);
  }
  
  public EvenementReferenceExamenAbstraitCustomMapped(Damj p_dateEvenement)
  {
    super(p_dateEvenement);
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    EvenementReferenceExamenAbstraitCustomMapped copie = (EvenementReferenceExamenAbstraitCustomMapped)p_copie;
    
    copie.setDateEvenement(getDateEvenement());
    copie.setDateDeclenchementExamen(getDateDeclenchementExamen());
  }
  
  public String toString()
  {
    StringBuffer sb = new StringBuffer();
    sb.append("ERE, type : ");
    sb.append(getClass().getName());
    sb.append(" - date déclenchement : ");
    sb.append(getDateDeclenchementExamen());
    sb.append(" - Date d'effet (= date examen demande) : ");
    sb.append(getDateEffet());
    return sb.toString();
  }
  
  public Damj getDateEvenement()
  {
    return m_dateEvenement;
  }
  
  public void setDateEvenement(Damj p_dateEvenement)
  {
    m_dateEvenement = p_dateEvenement;
  }
  
  public String getTypeSegment()
  {
    return "LE1D";
  }
  
  public boolean mettreEnBasePivot()
  {
    return true;
  }
  
  public Damj getDateDeclenchementExamen()
  {
    return m_dateDeclenchementExamen;
  }
  
  public Damj getDateDeclenchementExamenPourAffichage(DemandeSpec p_demande)
  {
    return getDateDeclenchementExamen(p_demande);
  }
  
  public void setDateDeclenchementExamen(Damj p_dateDeclenchementExamen)
  {
    m_dateDeclenchementExamen = p_dateDeclenchementExamen;
  }
  
  public void verifierContexte(DemandeSpec p_demande)
    throws ApplicativeException
  {}
  
  public void verifierPostContexte(DemandeSpec p_demande)
    throws CoucheLogiqueException
  {}
  
  public String getIdentifiant()
  {
    return DomManager.getIdentifiant(this);
  }
  
  public void jdoPostLoad() {}
  
  public void jdoPreStore() {}
  
  public void jdoPreClear() {}
  
  public void jdoPreDelete() {}
  
  public void marquerGraphePersistant() {}
  
  public boolean mettreEnBasePivotAideNcp()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     EvenementReferenceExamenAbstraitCustomMapped
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */