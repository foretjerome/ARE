package fr.unedic.cali.dom;

import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.UtilitairesClasse;

public abstract class QuantiteDroitNonSumatra
  implements QuantiteDroitSpec
{
  protected int m_etat = 0;
  protected Quantite m_quantiteCourante;
  protected Quantite m_quantiteInitial;
  
  public void activer()
  {
    setEtat(1);
    setQuantiteCourante(new Quantite(getQuantiteInitial().getValeur(), getQuantiteInitial().getUnite()));
  }
  
  public void inactiver()
  {
    setEtat(0);
  }
  
  public void epuiser()
  {
    setEtat(2);
  }
  
  public void imputer(Quantite p_quantite)
  {
    setQuantiteCourante(getQuantiteCourante().soustraire(p_quantite));
  }
  
  public Quantite getQuantiteCourante()
  {
    return m_quantiteCourante;
  }
  
  public Quantite getQuantiteInitial()
  {
    return m_quantiteInitial;
  }
  
  public void setQuantiteCourante(Quantite p_quantiteCourante)
  {
    m_quantiteCourante = p_quantiteCourante;
  }
  
  public void setQuantiteInitial(Quantite p_quantiteInitial)
  {
    m_quantiteInitial = p_quantiteInitial;
  }
  
  public abstract void setEtat(int paramInt);
  
  public abstract int getEtat();
  
  public EtatQuantiteDroit getEtatQuantiteDroit()
  {
    EtatQuantiteDroit etatQuantiteDroit = null;
    switch (m_etat)
    {
    case 1: 
      etatQuantiteDroit = new EtatQuantiteDroitActive();
      break;
    case 0: 
      etatQuantiteDroit = new EtatQuantiteDroitInactive();
      break;
    case 2: 
      etatQuantiteDroit = new EtatQuantiteDroitEpuisee();
    }
    return etatQuantiteDroit;
  }
  
  public boolean estStrictementType(Class p_type)
  {
    return UtilitairesClasse.getNomComplet(this).equalsIgnoreCase(p_type.getName());
  }
  
  public boolean estType(Class p_type)
  {
    return p_type.isAssignableFrom(getClass());
  }
  
  public abstract ImputationSpec simulerImputer(Quantite paramQuantite);
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    QuantiteDroitNonSumatra copie = (QuantiteDroitNonSumatra)p_copie;
    copie.setEtat(getEtat());
    copie.setQuantiteCourante(getQuantiteCourante());
    copie.setQuantiteInitial(getQuantiteInitial());
  }
  
  public String toString()
  {
    StringBuffer string = new StringBuffer();
    
    string.append("Type quantite: ").append(getClass().getName().substring(getClass().getName().lastIndexOf(".") + 1)).append("\n");
    if (getQuantiteCourante() != null) {
      string.append("\nQuantite courante : " + getQuantiteCourante().getValeur() + " " + getQuantiteCourante().getUnite());
    }
    if (getQuantiteInitial() != null) {
      string.append("\nQuantite initiale : " + getQuantiteInitial().getValeur() + " " + getQuantiteInitial().getUnite());
    }
    string.append("\nEtat : " + getEtatQuantiteDroit());
    
    return string.toString();
  }
  
  public String getIdentifiant()
  {
    return DomManager.getIdentifiant(this);
  }
  
  public void jdoPostLoad() {}
  
  public void jdoPreClear() {}
  
  public void jdoPreDelete() {}
  
  public void marquerGraphePersistant() {}
  
  public void jdoPreStore() {}
}

/* Location:
 * Qualified Name:     QuantiteDroitNonSumatra
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */