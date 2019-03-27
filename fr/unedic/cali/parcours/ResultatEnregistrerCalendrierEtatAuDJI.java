package fr.unedic.cali.parcours;

import fr.unedic.util.services.Resultat;
import java.util.ArrayList;
import java.util.Collection;

public class ResultatEnregistrerCalendrierEtatAuDJI
  extends Resultat
{
  private static final long serialVersionUID = 2923091243556298121L;
  private Collection m_listeErreurs = null;
  
  public ResultatEnregistrerCalendrierEtatAuDJI()
  {
    m_listeErreurs = new ArrayList();
  }
  
  public Collection getListeErreurs()
  {
    return m_listeErreurs;
  }
  
  public void setListeErreurs(Collection p_listeErreurs)
  {
    m_listeErreurs = p_listeErreurs;
  }
}

/* Location:
 * Qualified Name:     ResultatEnregistrerCalendrierEtatAuDJI
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */