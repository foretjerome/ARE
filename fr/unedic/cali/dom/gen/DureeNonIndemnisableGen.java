package fr.unedic.cali.dom.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.dom.QuantiteDroit;
import fr.unedic.cali.dom.pc.DureeNonIndemnisablePC;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.temps.Periode;

public abstract class DureeNonIndemnisableGen
  extends QuantiteDroit
  implements DomGenSpec
{
  private Quantite m_reliquat;
  private Periode m_periodeDA;
  private String m_type;
  private Quantite m_reliquatMaxMois;
  private Quantite m_quantiteCourante;
  
  public DureeNonIndemnisableGen(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public DureeNonIndemnisableGen() {}
  
  protected DomPCSpec createPC()
  {
    return new DureeNonIndemnisablePC();
  }
  
  protected Quantite rawGetReliquat()
  {
    return ((DureeNonIndemnisablePC)getPC()).getReliquat();
  }
  
  public Quantite getReliquat()
  {
    return ((DureeNonIndemnisablePC)getPC()).getReliquat();
  }
  
  public void setReliquat(Quantite p_reliquat)
  {
    if ((m_reliquat == null) || (p_reliquat == null))
    {
      m_reliquat = p_reliquat;
      ((DureeNonIndemnisablePC)getPC()).setReliquat(p_reliquat);
    }
    else if ((m_reliquat != null) && (p_reliquat != null) && (!p_reliquat.equals(m_reliquat)))
    {
      m_reliquat = p_reliquat;
      ((DureeNonIndemnisablePC)getPC()).setReliquat(p_reliquat);
    }
  }
  
  protected Periode rawGetPeriodeDA()
  {
    return ((DureeNonIndemnisablePC)getPC()).getPeriodeDA();
  }
  
  public Periode getPeriodeDA()
  {
    return ((DureeNonIndemnisablePC)getPC()).getPeriodeDA();
  }
  
  public void setPeriodeDA(Periode p_periodeDA)
  {
    if ((m_periodeDA == null) || (p_periodeDA == null))
    {
      m_periodeDA = p_periodeDA;
      ((DureeNonIndemnisablePC)getPC()).setPeriodeDA(p_periodeDA);
    }
    else if ((m_periodeDA != null) && (p_periodeDA != null) && (!p_periodeDA.equals(m_periodeDA)))
    {
      m_periodeDA = p_periodeDA;
      ((DureeNonIndemnisablePC)getPC()).setPeriodeDA(p_periodeDA);
    }
  }
  
  protected String rawGetType()
  {
    return ((DureeNonIndemnisablePC)getPC()).getType();
  }
  
  public String getType()
  {
    return ((DureeNonIndemnisablePC)getPC()).getType();
  }
  
  public void setType(String p_type)
  {
    if ((m_type == null) || (p_type == null))
    {
      m_type = p_type;
      ((DureeNonIndemnisablePC)getPC()).setType(p_type);
    }
    else if ((m_type != null) && (p_type != null) && (!p_type.equals(m_type)))
    {
      m_type = p_type;
      ((DureeNonIndemnisablePC)getPC()).setType(p_type);
    }
  }
  
  protected Quantite rawGetReliquatMaxMois()
  {
    return ((DureeNonIndemnisablePC)getPC()).getReliquatMaxMois();
  }
  
  public Quantite getReliquatMaxMois()
  {
    return ((DureeNonIndemnisablePC)getPC()).getReliquatMaxMois();
  }
  
  public void setReliquatMaxMois(Quantite p_reliquatMaxMois)
  {
    if ((m_reliquatMaxMois == null) || (p_reliquatMaxMois == null))
    {
      m_reliquatMaxMois = p_reliquatMaxMois;
      ((DureeNonIndemnisablePC)getPC()).setReliquatMaxMois(p_reliquatMaxMois);
    }
    else if ((m_reliquatMaxMois != null) && (p_reliquatMaxMois != null) && (!p_reliquatMaxMois.equals(m_reliquatMaxMois)))
    {
      m_reliquatMaxMois = p_reliquatMaxMois;
      ((DureeNonIndemnisablePC)getPC()).setReliquatMaxMois(p_reliquatMaxMois);
    }
  }
  
  protected int rawGetEtat()
  {
    return ((DureeNonIndemnisablePC)getPC()).getEtat();
  }
  
  public int getEtat()
  {
    return ((DureeNonIndemnisablePC)getPC()).getEtat();
  }
  
  public void setEtat(int p_etat)
  {
    ((DureeNonIndemnisablePC)getPC()).setEtat(p_etat);
  }
  
  protected Quantite rawGetQuantiteCourante()
  {
    return ((DureeNonIndemnisablePC)getPC()).getQuantiteCourante();
  }
  
  public Quantite getQuantiteCourante()
  {
    return ((DureeNonIndemnisablePC)getPC()).getQuantiteCourante();
  }
  
  public void setQuantiteCourante(Quantite p_quantiteCourante)
  {
    if ((m_quantiteCourante == null) || (p_quantiteCourante == null))
    {
      m_quantiteCourante = p_quantiteCourante;
      ((DureeNonIndemnisablePC)getPC()).setQuantiteCourante(p_quantiteCourante);
    }
    else if ((m_quantiteCourante != null) && (p_quantiteCourante != null) && (!p_quantiteCourante.equals(m_quantiteCourante)))
    {
      m_quantiteCourante = p_quantiteCourante;
      ((DureeNonIndemnisablePC)getPC()).setQuantiteCourante(p_quantiteCourante);
    }
  }
  
  public void supprimerEnProfondeur(ContexteSuppressionEnProfondeur p_contexteSuppression)
    throws TechniqueException
  {
    p_contexteSuppression.addElementEnCoursDeSuppression(this);
    
    super.supprimerEnProfondeur(p_contexteSuppression);
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    super.copieElements(p_copie);
  }
}

/* Location:
 * Qualified Name:     DureeNonIndemnisableGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */