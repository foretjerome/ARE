package fr.unedic.cali.parcours;

import fr.unedic.util.services.Resultat;
import java.util.ArrayList;
import java.util.Collection;

public class ResultatEnregistrerDecisionMigreeEnReexamen
  extends Resultat
{
  private Collection m_listeErreurs = null;
  
  public ResultatEnregistrerDecisionMigreeEnReexamen()
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
 * Qualified Name:     ResultatEnregistrerDecisionMigreeEnReexamen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */