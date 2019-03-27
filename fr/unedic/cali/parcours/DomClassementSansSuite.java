package fr.unedic.cali.parcours;

import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.ContexteService;

public class DomClassementSansSuite
  extends DomCaliOptimise
  implements DomCali
{
  private IndividuSpec m_individu;
  private ContexteService m_contexteService;
  private String m_identifiantBNIAllocataire;
  private String m_referenceExterneFormulaire;
  private int m_motifClassement;
  private ResultatClassement m_resultatClassement;
  
  public ContexteService getContexteService()
  {
    return m_contexteService;
  }
  
  public void setContexteService(ContexteService p_contexteService)
  {
    m_contexteService = p_contexteService;
  }
  
  public IndividuSpec getIndividu()
  {
    return m_individu;
  }
  
  public void setIndividu(IndividuSpec p_individu)
  {
    m_individu = p_individu;
  }
  
  public String getIdentifiantBNIAllocataire()
  {
    return m_identifiantBNIAllocataire;
  }
  
  public void setIdentifiantBNIAllocataire(String p_identifiantBNIAllocataire)
  {
    m_identifiantBNIAllocataire = p_identifiantBNIAllocataire;
  }
  
  public int getMotifClassement()
  {
    return m_motifClassement;
  }
  
  public void setMotifClassement(int p_motifClassement)
  {
    m_motifClassement = p_motifClassement;
  }
  
  public String getReferenceExterneFormulaire()
  {
    return m_referenceExterneFormulaire;
  }
  
  public void setReferenceExterneFormulaire(String p_referenceExterneFormulaire)
  {
    m_referenceExterneFormulaire = p_referenceExterneFormulaire;
  }
  
  public ResultatClassement getResultatClassement()
  {
    return m_resultatClassement;
  }
  
  public void setResultatClassement(ResultatClassement p_resultatClassement)
  {
    m_resultatClassement = p_resultatClassement;
  }
}

/* Location:
 * Qualified Name:     DomClassementSansSuite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */