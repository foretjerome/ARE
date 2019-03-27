package fr.unedic.cali.dom.persistance.util;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.contexte.ContexteApplicatif;
import fr.unedic.archi.logique.contexte.fournisseur.ContexteFournisseur;
import fr.unedic.archi.logique.persistance.GestionnairePersistance;
import fr.unedic.util.services.ContexteLocal;
import fr.unedic.util.services.ContexteSpec;

public class ContextePersistance
  implements ContexteSpec
{
  public static final String NOM_CONFIG = "lido_cali";
  private GestionnairePersistance m_gestionnaire;
  private boolean m_isPersistant;
  
  public ContextePersistance()
  {
    m_isPersistant = true;
  }
  
  public static GestionnairePersistance getGestionnairePersistance()
    throws TechniqueException
  {
    ContextePersistance contexte = (ContextePersistance)getContexte();
    if ((m_gestionnaire == null) || (!m_gestionnaire.isUtilisable())) {
      m_gestionnaire = ContexteFournisseur.getContexteApplicatif().getGestionnairePersistance("lido_cali");
    }
    return m_gestionnaire;
  }
  
  public static boolean isPersistant()
  {
    ContextePersistance contexte = (ContextePersistance)getContexte();
    return m_isPersistant;
  }
  
  public void modeSimulation()
    throws TechniqueException
  {
    m_isPersistant = false;
    ContexteFournisseur.getContexteApplicatif().marquerTransactionPourAnnulation();
  }
  
  public void modeSimulationPourJunit()
  {
    m_isPersistant = false;
  }
  
  public void modeJunitPersistant()
  {
    m_isPersistant = true;
  }
  
  public static ContexteSpec getContexte()
  {
    ContextePersistance contexte = (ContextePersistance)ContexteLocal.getContexte(ContextePersistance.class);
    if (contexte == null)
    {
      contexte = new ContextePersistance();
      ContexteLocal.setContexte(contexte);
    }
    return contexte;
  }
  
  public void attache()
  {
    ContextePersistance contexte = (ContextePersistance)ContexteLocal.getContexte(ContextePersistance.class);
    if (contexte != null) {
      ContexteLocal.setContexte(contexte);
    }
  }
  
  public void close()
  {
    m_gestionnaire = null;
  }
}

/* Location:
 * Qualified Name:     ContextePersistance
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */