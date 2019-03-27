package fr.unedic.cali.parcours;

import fr.unedic.util.services.Resultat;
import java.util.Collection;

public class ResultatLirePensionsInvalidite
  extends Resultat
{
  private static final long serialVersionUID = -2932552529057815707L;
  private Collection m_listePensionsInvalidite;
  
  public Collection getListePensionsInvalidite()
  {
    return m_listePensionsInvalidite;
  }
  
  public void setListePensionsInvalidite(Collection p_listePensionsInvalidite)
  {
    m_listePensionsInvalidite = p_listePensionsInvalidite;
  }
}

/* Location:
 * Qualified Name:     ResultatLirePensionsInvalidite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */