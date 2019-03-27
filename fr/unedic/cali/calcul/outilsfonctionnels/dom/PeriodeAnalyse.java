package fr.unedic.cali.calcul.outilsfonctionnels.dom;

import fr.unedic.cali.calcul.dom.ConstituantsIndemnisation;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.Unite;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.Periode;
import fr.unedic.util.temps.Temporel;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PeriodeAnalyse
  extends ObjetChronoPeriode
  implements PeriodeAnalyseSpec
{
  private Periode m_periode;
  private ConstituantsIndemnisation m_constituantsIndemnisationEnDebutPA = null;
  private ConstituantsIndemnisation m_constituantsIndemnisationEnFinPA = null;
  private List m_listeSommes = new ArrayList();
  private List m_evenements = new ArrayList();
  private boolean m_produitAterminerApresPA = false;
  private boolean m_nbJoursIndemnisesForce = false;
  private Collection m_collectionFinQuantiteDroit = null;
  private Quantite m_quantiteIndemnisable = null;
  private Quantite m_quantiteNonIndemnisee = null;
  private Quantite m_quantiteIndemnisee = null;
  private Quantite m_quantiteImputeeNonIndemnisee = null;
  private Quantite m_quantitePlafonnee = null;
  private Quantite m_quantiteDecalee = null;
  private boolean estUnePaAvecPlafond = false;
  private int nbJoursAllongementAREF = 0;
  
  public Quantite getQuantitePlafonnee()
  {
    return m_quantitePlafonnee;
  }
  
  public void setQuantitePlafonnee(Quantite p_quantitePlafonnee)
  {
    m_quantitePlafonnee = p_quantitePlafonnee;
  }
  
  private Unite m_uniteParDefautQuantites = null;
  
  public PeriodeAnalyse(Unite p_uniteParDefautQuantites)
  {
    m_uniteParDefautQuantites = p_uniteParDefautQuantites;
    m_quantiteIndemnisable = new Quantite(new BigDecimal(0), m_uniteParDefautQuantites);
    m_quantiteNonIndemnisee = new Quantite(new BigDecimal(0), m_uniteParDefautQuantites);
    m_quantiteIndemnisee = new Quantite(new BigDecimal(0), m_uniteParDefautQuantites);
    m_quantiteImputeeNonIndemnisee = new Quantite(new BigDecimal(0), m_uniteParDefautQuantites);
    m_quantitePlafonnee = new Quantite(new BigDecimal(0), m_uniteParDefautQuantites);
  }
  
  public PeriodeAnalyse(Unite p_uniteParDefautQuantites, Periode p_periode)
  {
    m_periode = p_periode;
    
    m_uniteParDefautQuantites = p_uniteParDefautQuantites;
    m_quantiteIndemnisable = new Quantite(new BigDecimal(0), m_uniteParDefautQuantites);
    m_quantiteNonIndemnisee = new Quantite(new BigDecimal(0), m_uniteParDefautQuantites);
    m_quantiteIndemnisee = new Quantite(new BigDecimal(0), m_uniteParDefautQuantites);
    m_quantiteImputeeNonIndemnisee = new Quantite(new BigDecimal(0), m_uniteParDefautQuantites);
    m_quantitePlafonnee = new Quantite(new BigDecimal(0), m_uniteParDefautQuantites);
  }
  
  public Periode getPeriode()
  {
    return m_periode;
  }
  
  public ConstituantsIndemnisation getConstituantsIndemnisationEnDebutPA()
  {
    return m_constituantsIndemnisationEnDebutPA;
  }
  
  public ConstituantsIndemnisation getConstituantsIndemnisationEnFinPA()
  {
    return m_constituantsIndemnisationEnFinPA;
  }
  
  public void setConstituantsIndemnisationEnDebutPA(ConstituantsIndemnisation p_indemnisation)
  {
    m_constituantsIndemnisationEnDebutPA = p_indemnisation;
  }
  
  public void setConstituantsIndemnisationEnFinPA(ConstituantsIndemnisation p_indemnisation)
  {
    m_constituantsIndemnisationEnFinPA = p_indemnisation;
  }
  
  public List getListeSommes()
  {
    return m_listeSommes;
  }
  
  public void setListeSommes(List p_listeSommes)
  {
    m_listeSommes = p_listeSommes;
  }
  
  public void setProduitATerminerApresUT(boolean p_produitATerminerApresUT)
  {
    m_produitAterminerApresPA = p_produitATerminerApresUT;
  }
  
  public boolean isProduitATerminerApresPA()
  {
    return m_produitAterminerApresPA;
  }
  
  public Collection getCollectionFinQuantiteDroit()
  {
    return m_collectionFinQuantiteDroit;
  }
  
  public void setCollectionFinQuantiteDroit(Collection p_collectionFinQuantiteDroit)
  {
    m_collectionFinQuantiteDroit = p_collectionFinQuantiteDroit;
  }
  
  public void setNbJoursIndemnisesForce(boolean p_nbJoursIndemnisesForce)
  {
    m_nbJoursIndemnisesForce = p_nbJoursIndemnisesForce;
  }
  
  public boolean isNbJoursIndemnisesForce()
  {
    return m_nbJoursIndemnisesForce;
  }
  
  public Quantite getQuantiteIndemnisable()
  {
    return m_quantiteIndemnisable;
  }
  
  public Quantite getQuantiteIndemnisee()
  {
    return m_quantiteIndemnisee;
  }
  
  public Quantite getQuantiteNonIndemnisee()
  {
    return m_quantiteNonIndemnisee;
  }
  
  public void setQuantiteIndemnisable(Quantite p_quantiteIndemnisable)
  {
    m_quantiteIndemnisable = p_quantiteIndemnisable;
  }
  
  public void setQuantiteIndemnisee(Quantite p_quantiteIndemnisee)
  {
    m_quantiteIndemnisee = p_quantiteIndemnisee;
  }
  
  public void setQuantiteNonIndemnisee(Quantite p_quantiteNonIndemnisee)
  {
    m_quantiteNonIndemnisee = p_quantiteNonIndemnisee;
  }
  
  public Unite getUniteParDefautQuantites()
  {
    return m_uniteParDefautQuantites;
  }
  
  public void addEvenement(Temporel p_evt)
  {
    m_evenements.add(p_evt);
  }
  
  public Collection getEvenements()
  {
    return m_evenements;
  }
  
  public void addEvenements(Collection p_evts)
  {
    m_evenements.addAll(p_evts);
  }
  
  public ObjetMetierSpec copie()
  {
    return null;
  }
  
  public Quantite getQuantiteImputeeNonIndemnisee()
  {
    return m_quantiteImputeeNonIndemnisee;
  }
  
  public void setQuantiteImputeeNonIndemnisee(Quantite p_quantiteImputeeNonIndemnisee)
  {
    m_quantiteImputeeNonIndemnisee = p_quantiteImputeeNonIndemnisee;
  }
  
  public boolean isEstUnePaAvecPlafond()
  {
    return estUnePaAvecPlafond;
  }
  
  public void setEstUnePaAvecPlafond(boolean p_estUnePaAvecPlafond)
  {
    estUnePaAvecPlafond = p_estUnePaAvecPlafond;
  }
  
  public Quantite getQuantiteDecalee()
  {
    return m_quantiteDecalee;
  }
  
  public void setQuantiteDecalee(Quantite p_quantiteDecalee)
  {
    m_quantiteDecalee = p_quantiteDecalee;
  }
  
  public int getNbJoursAllongementAREF()
  {
    return nbJoursAllongementAREF;
  }
  
  public void setNbJoursAllongementAREF(int nbJoursAllongementAREF)
  {
    this.nbJoursAllongementAREF = nbJoursAllongementAREF;
  }
}

/* Location:
 * Qualified Name:     PeriodeAnalyse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */