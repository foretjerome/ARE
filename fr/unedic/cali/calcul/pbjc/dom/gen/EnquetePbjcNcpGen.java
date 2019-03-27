package fr.unedic.cali.calcul.pbjc.dom.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.calcul.pbjc.dom.pc.EnquetePbjcNcpPC;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public abstract class EnquetePbjcNcpGen
  implements DomGenSpec
{
  protected transient DomPCSpec m_enquetePbjcNcpPC;
  private Damj m_dateSituationSuivi;
  private String m_codeProduit;
  private String m_situationParticuliere;
  private String m_codeSousProduit;
  
  public EnquetePbjcNcpGen(DomPCSpec p_pc)
  {
    setPC(p_pc);
  }
  
  public EnquetePbjcNcpGen()
  {
    setPC(createPC());
  }
  
  protected DomPCSpec createPC()
  {
    return new EnquetePbjcNcpPC();
  }
  
  public DomPCSpec getPC()
  {
    return m_enquetePbjcNcpPC;
  }
  
  public Object getGenericPC()
  {
    return getPC();
  }
  
  public void setPC(DomPCSpec p_enquetePbjcNcpPC)
  {
    m_enquetePbjcNcpPC = p_enquetePbjcNcpPC;
  }
  
  protected int rawGetIdentOuvertureDroit()
  {
    return ((EnquetePbjcNcpPC)getPC()).getIdentOuvertureDroit();
  }
  
  public int getIdentOuvertureDroit()
  {
    return ((EnquetePbjcNcpPC)getPC()).getIdentOuvertureDroit();
  }
  
  public void setIdentOuvertureDroit(int p_identOuvertureDroit)
  {
    ((EnquetePbjcNcpPC)getPC()).setIdentOuvertureDroit(p_identOuvertureDroit);
  }
  
  protected Damj rawGetDateSituationSuivi()
  {
    return ((EnquetePbjcNcpPC)getPC()).getDateSituationSuivi();
  }
  
  public Damj getDateSituationSuivi()
  {
    return ((EnquetePbjcNcpPC)getPC()).getDateSituationSuivi();
  }
  
  public void setDateSituationSuivi(Damj p_dateSituationSuivi)
  {
    if ((m_dateSituationSuivi == null) || (p_dateSituationSuivi == null))
    {
      m_dateSituationSuivi = p_dateSituationSuivi;
      ((EnquetePbjcNcpPC)getPC()).setDateSituationSuivi(p_dateSituationSuivi);
    }
    else if ((m_dateSituationSuivi != null) && (p_dateSituationSuivi != null) && (!p_dateSituationSuivi.equals(m_dateSituationSuivi)))
    {
      m_dateSituationSuivi = p_dateSituationSuivi;
      ((EnquetePbjcNcpPC)getPC()).setDateSituationSuivi(p_dateSituationSuivi);
    }
  }
  
  protected int rawGetTypeSituationSuivi()
  {
    return ((EnquetePbjcNcpPC)getPC()).getTypeSituationSuivi();
  }
  
  public int getTypeSituationSuivi()
  {
    return ((EnquetePbjcNcpPC)getPC()).getTypeSituationSuivi();
  }
  
  public void setTypeSituationSuivi(int p_typeSituationSuivi)
  {
    ((EnquetePbjcNcpPC)getPC()).setTypeSituationSuivi(p_typeSituationSuivi);
  }
  
  protected String rawGetCodeProduit()
  {
    return ((EnquetePbjcNcpPC)getPC()).getCodeProduit();
  }
  
  public String getCodeProduit()
  {
    return ((EnquetePbjcNcpPC)getPC()).getCodeProduit();
  }
  
  public void setCodeProduit(String p_codeProduit)
  {
    if ((m_codeProduit == null) || (p_codeProduit == null))
    {
      m_codeProduit = p_codeProduit;
      ((EnquetePbjcNcpPC)getPC()).setCodeProduit(p_codeProduit);
    }
    else if ((m_codeProduit != null) && (p_codeProduit != null) && (!p_codeProduit.equals(m_codeProduit)))
    {
      m_codeProduit = p_codeProduit;
      ((EnquetePbjcNcpPC)getPC()).setCodeProduit(p_codeProduit);
    }
  }
  
  protected int rawGetRangSituation()
  {
    return ((EnquetePbjcNcpPC)getPC()).getRangSituation();
  }
  
  public int getRangSituation()
  {
    return ((EnquetePbjcNcpPC)getPC()).getRangSituation();
  }
  
  public void setRangSituation(int p_rangSituation)
  {
    ((EnquetePbjcNcpPC)getPC()).setRangSituation(p_rangSituation);
  }
  
  protected int rawGetIdentReprisePorteuse()
  {
    return ((EnquetePbjcNcpPC)getPC()).getIdentReprisePorteuse();
  }
  
  public int getIdentReprisePorteuse()
  {
    return ((EnquetePbjcNcpPC)getPC()).getIdentReprisePorteuse();
  }
  
  public void setIdentReprisePorteuse(int p_identReprisePorteuse)
  {
    ((EnquetePbjcNcpPC)getPC()).setIdentReprisePorteuse(p_identReprisePorteuse);
  }
  
  protected boolean rawIsSituationAEmettre()
  {
    return ((EnquetePbjcNcpPC)getPC()).isSituationAEmettre();
  }
  
  public boolean isSituationAEmettre()
  {
    return ((EnquetePbjcNcpPC)getPC()).isSituationAEmettre();
  }
  
  public void setSituationAEmettre(boolean p_situationAEmettre)
  {
    ((EnquetePbjcNcpPC)getPC()).setSituationAEmettre(p_situationAEmettre);
  }
  
  protected String rawGetSituationParticuliere()
  {
    return ((EnquetePbjcNcpPC)getPC()).getSituationParticuliere();
  }
  
  public String getSituationParticuliere()
  {
    return ((EnquetePbjcNcpPC)getPC()).getSituationParticuliere();
  }
  
  public void setSituationParticuliere(String p_situationParticuliere)
  {
    if ((m_situationParticuliere == null) || (p_situationParticuliere == null))
    {
      m_situationParticuliere = p_situationParticuliere;
      ((EnquetePbjcNcpPC)getPC()).setSituationParticuliere(p_situationParticuliere);
    }
    else if ((m_situationParticuliere != null) && (p_situationParticuliere != null) && (!p_situationParticuliere.equals(m_situationParticuliere)))
    {
      m_situationParticuliere = p_situationParticuliere;
      ((EnquetePbjcNcpPC)getPC()).setSituationParticuliere(p_situationParticuliere);
    }
  }
  
  protected String rawGetCodeSousProduit()
  {
    return ((EnquetePbjcNcpPC)getPC()).getCodeSousProduit();
  }
  
  public String getCodeSousProduit()
  {
    return ((EnquetePbjcNcpPC)getPC()).getCodeSousProduit();
  }
  
  public void setCodeSousProduit(String p_codeSousProduit)
  {
    if ((m_codeSousProduit == null) || (p_codeSousProduit == null))
    {
      m_codeSousProduit = p_codeSousProduit;
      ((EnquetePbjcNcpPC)getPC()).setCodeSousProduit(p_codeSousProduit);
    }
    else if ((m_codeSousProduit != null) && (p_codeSousProduit != null) && (!p_codeSousProduit.equals(m_codeSousProduit)))
    {
      m_codeSousProduit = p_codeSousProduit;
      ((EnquetePbjcNcpPC)getPC()).setCodeSousProduit(p_codeSousProduit);
    }
  }
  
  public void supprimerEnProfondeur(ContexteSuppressionEnProfondeur p_contexteSuppression)
    throws TechniqueException
  {
    p_contexteSuppression.addElementEnCoursDeSuppression(this);
  }
  
  public void copieElements(ObjetMetierSpec p_copie) {}
}

/* Location:
 * Qualified Name:     EnquetePbjcNcpGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */