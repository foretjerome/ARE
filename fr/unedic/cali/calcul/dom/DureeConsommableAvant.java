package fr.unedic.cali.calcul.dom;

import fr.unedic.cali.dom.EtatQuantiteDroit;
import fr.unedic.cali.dom.EtatQuantiteDroitActive;
import fr.unedic.cali.dom.EtatQuantiteDroitEpuisee;
import fr.unedic.cali.dom.EtatQuantiteDroitInactive;
import fr.unedic.cali.dom.ImputationJour;
import fr.unedic.cali.dom.ImputationSpec;
import fr.unedic.cali.dom.QuantiteDroit;
import fr.unedic.cali.dom.QuantiteIndemnisationSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.temps.Periode;

public class DureeConsommableAvant
  extends QuantiteDroit
  implements QuantiteIndemnisationSpec
{
  private static final long serialVersionUID = 1L;
  public static final int TYPE_PMC = 0;
  public static final int TYPE_DIFFERE_STANDARD = 1;
  public static final int TYPE_DIFFERE_SPECIFIQUE = 2;
  public static final int TYPE_DELAI_ATTENTE = 3;
  public static final int TYPE_PREAVIS_LEGAL = 4;
  public static final int TYPE_FRANCHISE_CONGE_PAYE = 5;
  public static final int TYPE_FRANCHISE_SALAIRE = 6;
  private transient int m_typeDureeConsommable;
  private transient String m_codeFormuleMontant;
  private transient int m_etat = 0;
  private transient Quantite m_quantiteCourante;
  private transient Quantite m_quantiteInitial;
  private transient Periode m_periodeApplicationCarence = null;
  
  protected DomPCSpec createPC()
  {
    return null;
  }
  
  public DureeConsommableAvant() {}
  
  public DureeConsommableAvant(int p_typeDureeConsommable, Quantite p_quantiteInitiale)
  {
    setTypeDureeConsommable(p_typeDureeConsommable);
    setQuantiteInitial(p_quantiteInitiale);
  }
  
  public String getCodeFormuleMontant()
  {
    return m_codeFormuleMontant;
  }
  
  public void setCodeFormuleMontant(String p_codeFormuleMontant)
  {
    m_codeFormuleMontant = p_codeFormuleMontant;
  }
  
  public void activer()
  {
    setEtat(1);
    setQuantiteCourante(new Quantite(getQuantiteInitial().getValeur(), getQuantiteInitial().getUnite()));
  }
  
  public void epuiser()
  {
    setEtat(2);
  }
  
  public boolean estStrictementType(Class p_type)
  {
    return false;
  }
  
  public boolean estType(Class p_type)
  {
    return false;
  }
  
  public int getEtat()
  {
    return m_etat;
  }
  
  public EtatQuantiteDroit getEtatQuantiteDroit()
  {
    EtatQuantiteDroit etatQuantiteDroit = null;
    switch (getEtat())
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
  
  public Quantite getQuantiteCourante()
  {
    return m_quantiteCourante;
  }
  
  public Quantite getQuantiteInitial()
  {
    return m_quantiteInitial;
  }
  
  public void imputer(Quantite p_quantite)
  {
    setQuantiteCourante(getQuantiteCourante().soustraire(p_quantite));
  }
  
  public void inactiver()
  {
    setEtat(0);
  }
  
  public void setEtat(int p_etat)
  {
    m_etat = p_etat;
  }
  
  public void setQuantiteCourante(Quantite p_quantite)
  {
    m_quantiteCourante = p_quantite;
  }
  
  public void setQuantiteInitial(Quantite p_quantite)
  {
    m_quantiteInitial = p_quantite;
  }
  
  public ImputationSpec simulerImputer(Quantite p_quantite)
  {
    ImputationJour monImputation = (ImputationJour)getEtatQuantiteDroit().accepteVisiteur(new SimulateurImputeurDureeConsommableAvant(this, p_quantite));
    
    return monImputation;
  }
  
  public int getTypeDureeConsommable()
  {
    return m_typeDureeConsommable;
  }
  
  public void setTypeDureeConsommable(int p_typeDureeConsommable)
  {
    m_typeDureeConsommable = p_typeDureeConsommable;
  }
  
  public String getIdentifiant()
  {
    return "";
  }
  
  public void marquerGraphePersistant() {}
  
  public ObjetMetierSpec copie()
  {
    DureeConsommableAvant copie = new DureeConsommableAvant();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    DureeConsommableAvant copie = (DureeConsommableAvant)p_copie;
    
    super.copieElements(copie);
    
    copie.setEtat(getEtat());
    copie.setQuantiteCourante(getQuantiteCourante());
    copie.setQuantiteInitial(getQuantiteInitial());
    copie.setTypeDureeConsommable(getTypeDureeConsommable());
    copie.setPeriodeApplicationCarence(getPeriodeApplicationCarence());
  }
  
  public void jdoPreClear() {}
  
  public void jdoPreDelete() {}
  
  public void jdoPostLoad() {}
  
  public void jdoPreStore() {}
  
  public Periode getPeriodeApplicationCarence()
  {
    return m_periodeApplicationCarence;
  }
  
  public void setPeriodeApplicationCarence(Periode p_periodeApplicationCarence)
  {
    m_periodeApplicationCarence = p_periodeApplicationCarence;
  }
}

/* Location:
 * Qualified Name:     DureeConsommableAvant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */