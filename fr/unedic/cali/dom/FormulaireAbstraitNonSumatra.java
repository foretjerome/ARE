package fr.unedic.cali.dom;

import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoEvenementDebut;

public abstract class FormulaireAbstraitNonSumatra
  extends ObjetChronoEvenementDebut
  implements FormulaireSpec
{
  private transient boolean m_isDalNonRecevable;
  private transient Damj m_dateCreationDal;
  protected String m_motifEnvoi;
  private transient String m_nomProduit;
  private transient String m_nomLigne;
  private transient String m_nomGamme;
  
  public String getIdentifiant()
  {
    return DomManager.getIdentifiant(this);
  }
  
  public void setDateDepot(Damj p_dateDepot)
  {
    setDateEvenement(p_dateDepot);
  }
  
  public Damj getDateDepot()
  {
    return getDateEvenement();
  }
  
  public void jdoPostLoad() {}
  
  public void jdoPreClear() {}
  
  public void jdoPreStore() {}
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    FormulaireAbstraitNonSumatra copie = (FormulaireAbstraitNonSumatra)p_copie;
    copie.setDateCreationDal(getDateCreationDal());
    copie.setMotifEnvoi(getMotifEnvoi());
  }
  
  public void miseAjour(FormulaireAbstraitNonSumatra p_formulaire)
  {
    if (p_formulaire.getDateDepot() != null)
    {
      if (getDateDepot() != null)
      {
        if (p_formulaire.getDateDepot().compareTo(getDateDepot()) != 0) {
          setDateDepot(p_formulaire.getDateDepot());
        }
      }
      else {
        setDateDepot(p_formulaire.getDateDepot());
      }
    }
    else {
      setDalNonRecevable(true);
    }
    setDateCreationDal(p_formulaire.getDateCreationDal());
    setMotifEnvoi(p_formulaire.getMotifEnvoi());
  }
  
  public boolean estDalNonRecevable()
  {
    return m_isDalNonRecevable;
  }
  
  public void setDalNonRecevable(boolean p_isDalNonRecevable)
  {
    m_isDalNonRecevable = p_isDalNonRecevable;
  }
  
  public Damj getDateCreationDal()
  {
    return m_dateCreationDal;
  }
  
  public void setDateCreationDal(Damj p_dateCreationDal)
  {
    m_dateCreationDal = p_dateCreationDal;
  }
  
  public void jdoPreDelete() {}
  
  public void marquerGraphePersistant() {}
  
  public String getMotifEnvoi()
  {
    return m_motifEnvoi;
  }
  
  public void setMotifEnvoi(String p_motifEnvoi)
  {
    m_motifEnvoi = p_motifEnvoi;
  }
  
  public String getNomGamme()
  {
    return m_nomGamme;
  }
  
  public void setNomGamme(String p_nomGamme)
  {
    m_nomGamme = p_nomGamme;
  }
  
  public String getNomLigne()
  {
    return m_nomLigne;
  }
  
  public void setNomLigne(String p_nomLigne)
  {
    m_nomLigne = p_nomLigne;
  }
  
  public String getNomProduit()
  {
    return m_nomProduit;
  }
  
  public void setNomProduit(String p_nomProduit)
  {
    m_nomProduit = p_nomProduit;
  }
}

/* Location:
 * Qualified Name:     FormulaireAbstraitNonSumatra
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */