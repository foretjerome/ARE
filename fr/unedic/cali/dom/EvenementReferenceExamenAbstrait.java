package fr.unedic.cali.dom;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.gen.EvenementReferenceExamenAbstraitGen;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;

public abstract class EvenementReferenceExamenAbstrait
  extends EvenementReferenceExamenAbstraitGen
  implements EvenementReferenceExamenSpec
{
  protected transient Damj m_dateDeclenchementExamen;
  
  protected EvenementReferenceExamenAbstrait()
  {
    setDateEvenement(null);
  }
  
  public EvenementReferenceExamenAbstrait(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  protected EvenementReferenceExamenAbstrait(Damj p_dateEvenement)
  {
    super(p_dateEvenement);
  }
  
  public String getIdentifiant()
  {
    return DomManager.getIdentifiant(this);
  }
  
  public void jdoPostLoad() {}
  
  public void jdoPreStore() {}
  
  public void jdoPreClear() {}
  
  public void jdoPreDelete() {}
  
  public void marquerGraphePersistant() {}
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    EvenementReferenceExamenAbstrait copie = (EvenementReferenceExamenAbstrait)p_copie;
    
    copie.setDateEvenement(getDateEvenement());
    copie.setDateDeclenchementExamen(getDateDeclenchementExamen());
  }
  
  public void setDateDeclenchementExamen(Damj p_dateDeclenchementExamen)
  {
    m_dateDeclenchementExamen = p_dateDeclenchementExamen;
  }
  
  public Damj getDateDeclenchementExamen()
  {
    return m_dateDeclenchementExamen;
  }
  
  public Damj getDateDeclenchementExamenPourAffichage(DemandeSpec p_demande)
  {
    return getDateDeclenchementExamen(p_demande);
  }
  
  public String getTypeSegment()
  {
    return "LE1D";
  }
  
  public boolean mettreEnBasePivot()
  {
    return true;
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
  
  public void verifierContexte(DemandeSpec p_demande)
    throws ApplicativeException
  {}
  
  public void verifierPostContexte(DemandeSpec p_demande)
    throws CoucheLogiqueException
  {}
  
  public boolean verifierBesoinChargementTotalGaec()
  {
    return false;
  }
  
  public boolean mettreEnBasePivotAideNcp()
  {
    return false;
  }
  
  public void verifierContexteExamen(DemandeSpec p_demande)
    throws ApplicativeException
  {}
}

/* Location:
 * Qualified Name:     EvenementReferenceExamenAbstrait
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */