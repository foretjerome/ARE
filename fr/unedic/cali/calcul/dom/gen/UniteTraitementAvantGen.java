package fr.unedic.cali.calcul.dom.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.calcul.dom.pc.UniteTraitementAvantPC;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.ObjetChronoPeriodeCREM;
import fr.unedic.util.temps.Periode;

public abstract class UniteTraitementAvantGen
  extends ObjetChronoPeriodeCREM
  implements DomGenSpec
{
  private Integer m_dureePmc;
  private Integer m_dureeIccp;
  private Integer m_dureeIslr;
  private Integer m_dureeDelaiAttente;
  
  public UniteTraitementAvantGen(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public UniteTraitementAvantGen() {}
  
  public UniteTraitementAvantGen(Periode p_periode)
  {
    super(p_periode);
  }
  
  protected DomPCSpec createPC()
  {
    return new UniteTraitementAvantPC();
  }
  
  protected Integer rawGetDureePmc()
  {
    return ((UniteTraitementAvantPC)getPC()).getDureePmc();
  }
  
  public Integer getDureePmc()
  {
    return ((UniteTraitementAvantPC)getPC()).getDureePmc();
  }
  
  public void setDureePmc(Integer p_dureePmc)
  {
    if ((m_dureePmc == null) || (p_dureePmc == null))
    {
      m_dureePmc = p_dureePmc;
      ((UniteTraitementAvantPC)getPC()).setDureePmc(p_dureePmc);
    }
    else if ((m_dureePmc != null) && (p_dureePmc != null) && (!p_dureePmc.equals(m_dureePmc)))
    {
      m_dureePmc = p_dureePmc;
      ((UniteTraitementAvantPC)getPC()).setDureePmc(p_dureePmc);
    }
  }
  
  protected Integer rawGetDureeIccp()
  {
    return ((UniteTraitementAvantPC)getPC()).getDureeIccp();
  }
  
  public Integer getDureeIccp()
  {
    return ((UniteTraitementAvantPC)getPC()).getDureeIccp();
  }
  
  public void setDureeIccp(Integer p_dureeIccp)
  {
    if ((m_dureeIccp == null) || (p_dureeIccp == null))
    {
      m_dureeIccp = p_dureeIccp;
      ((UniteTraitementAvantPC)getPC()).setDureeIccp(p_dureeIccp);
    }
    else if ((m_dureeIccp != null) && (p_dureeIccp != null) && (!p_dureeIccp.equals(m_dureeIccp)))
    {
      m_dureeIccp = p_dureeIccp;
      ((UniteTraitementAvantPC)getPC()).setDureeIccp(p_dureeIccp);
    }
  }
  
  protected Integer rawGetDureeIslr()
  {
    return ((UniteTraitementAvantPC)getPC()).getDureeIslr();
  }
  
  public Integer getDureeIslr()
  {
    return ((UniteTraitementAvantPC)getPC()).getDureeIslr();
  }
  
  public void setDureeIslr(Integer p_dureeIslr)
  {
    if ((m_dureeIslr == null) || (p_dureeIslr == null))
    {
      m_dureeIslr = p_dureeIslr;
      ((UniteTraitementAvantPC)getPC()).setDureeIslr(p_dureeIslr);
    }
    else if ((m_dureeIslr != null) && (p_dureeIslr != null) && (!p_dureeIslr.equals(m_dureeIslr)))
    {
      m_dureeIslr = p_dureeIslr;
      ((UniteTraitementAvantPC)getPC()).setDureeIslr(p_dureeIslr);
    }
  }
  
  protected Integer rawGetDureeDelaiAttente()
  {
    return ((UniteTraitementAvantPC)getPC()).getDureeDelaiAttente();
  }
  
  public Integer getDureeDelaiAttente()
  {
    return ((UniteTraitementAvantPC)getPC()).getDureeDelaiAttente();
  }
  
  public void setDureeDelaiAttente(Integer p_dureeDelaiAttente)
  {
    if ((m_dureeDelaiAttente == null) || (p_dureeDelaiAttente == null))
    {
      m_dureeDelaiAttente = p_dureeDelaiAttente;
      ((UniteTraitementAvantPC)getPC()).setDureeDelaiAttente(p_dureeDelaiAttente);
    }
    else if ((m_dureeDelaiAttente != null) && (p_dureeDelaiAttente != null) && (!p_dureeDelaiAttente.equals(m_dureeDelaiAttente)))
    {
      m_dureeDelaiAttente = p_dureeDelaiAttente;
      ((UniteTraitementAvantPC)getPC()).setDureeDelaiAttente(p_dureeDelaiAttente);
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
 * Qualified Name:     UniteTraitementAvantGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */