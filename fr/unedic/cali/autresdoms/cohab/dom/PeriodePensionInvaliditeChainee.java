package fr.unedic.cali.autresdoms.cohab.dom;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.cali.autresdoms.cohab.dom.spec.PeriodePensionInvaliditeChaineeSpec;
import fr.unedic.cali.autresdoms.cohab.dom.spec.PeriodeSousPensionInvaliditeChaineeSpec;
import fr.unedic.cali.calcul.dom.periode.FinPeriodePensionInvaliditeChainee;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalculTransient;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class PeriodePensionInvaliditeChainee
  extends ObjetChronoPeriodeCalculTransient
  implements PeriodePensionInvaliditeChaineeSpec
{
  private static final long serialVersionUID = -3723401113741605610L;
  private String m_organismeFinanceur;
  private int m_statut;
  private Collection m_listePeriodesElementPensionInvalidite = new ArrayList();
  private Collection m_listeFinsPeriodesPensionInvalidite = new ArrayList();
  
  protected PeriodePensionInvaliditeChainee() {}
  
  public PeriodePensionInvaliditeChainee(Damj p_debut, Damj p_fin)
  {
    super(p_debut, p_fin);
  }
  
  public String getOrganismeFinanceur()
  {
    return m_organismeFinanceur;
  }
  
  public void setOrganismeFinanceur(String p_organismeFinanceur)
  {
    m_organismeFinanceur = p_organismeFinanceur;
  }
  
  public int getStatut()
  {
    return m_statut;
  }
  
  public void setStatut(int p_statut)
  {
    m_statut = p_statut;
  }
  
  public Collection getListeSousPensionInvalidite()
  {
    return Collections.unmodifiableCollection(getCollectionModifiablePeriodeSousPensionInvalidite());
  }
  
  private Collection getCollectionModifiablePeriodeSousPensionInvalidite()
  {
    if (m_listePeriodesElementPensionInvalidite == null) {
      m_listePeriodesElementPensionInvalidite = new ArrayList();
    }
    return m_listePeriodesElementPensionInvalidite;
  }
  
  public void ajouterPeriodeSousPensionInvalidite(PeriodeSousPensionInvaliditeChaineeSpec p_periodePension)
  {
    if (p_periodePension == null) {
      ExceptionUtil.assertInternalNotNull("La sous-période de pension d'invalidité ne devrait pas etre nulle", p_periodePension);
    }
    Collection listePeriodesSousPensionInvalidite = getCollectionModifiablePeriodeSousPensionInvalidite();
    if (!listePeriodesSousPensionInvalidite.contains(p_periodePension)) {
      listePeriodesSousPensionInvalidite.add(p_periodePension);
    }
  }
  
  public void supprimerPeriodeSousPensionInvalidite(PeriodeSousPensionInvaliditeChaineeSpec p_periodePension)
  {
    Collection listePeriodesSousPensionInvalidite = getCollectionModifiablePeriodeSousPensionInvalidite();
    if (listePeriodesSousPensionInvalidite.contains(p_periodePension)) {
      listePeriodesSousPensionInvalidite.remove(p_periodePension);
    }
  }
  
  public Collection getListeFinsPeriodesPensionInvalite()
  {
    return Collections.unmodifiableCollection(getCollectionModifiableFinsPeriodesPensionInvalidite());
  }
  
  private Collection getCollectionModifiableFinsPeriodesPensionInvalidite()
  {
    if (m_listeFinsPeriodesPensionInvalidite == null) {
      m_listeFinsPeriodesPensionInvalidite = new ArrayList();
    }
    return m_listeFinsPeriodesPensionInvalidite;
  }
  
  public void ajouterFinPeriodePensionInvalidite(FinPeriodePensionInvaliditeChainee p_finPeriode)
  {
    if (p_finPeriode == null) {
      ExceptionUtil.assertInternalNotNull("La fin de période de pension d'invalidité ne devrait pas etre nulle", p_finPeriode);
    }
    Collection listeFinsPeriodesPensionInvalidite = getCollectionModifiableFinsPeriodesPensionInvalidite();
    if (!listeFinsPeriodesPensionInvalidite.contains(p_finPeriode)) {
      listeFinsPeriodesPensionInvalidite.add(p_finPeriode);
    }
  }
  
  public void supprimerFinPeriodePensionInvalidite(FinPeriodePensionInvaliditeChainee p_finPeriode)
  {
    Collection listeFinsPeriodesPensionInvalidite = getCollectionModifiableFinsPeriodesPensionInvalidite();
    if (listeFinsPeriodesPensionInvalidite.contains(p_finPeriode)) {
      listeFinsPeriodesPensionInvalidite.remove(p_finPeriode);
    }
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetMetierSpec copie = new PeriodePensionInvaliditeChainee();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    PeriodePensionInvaliditeChainee copie = (PeriodePensionInvaliditeChainee)p_copie;
    super.copieElements(copie);
    
    m_organismeFinanceur = getOrganismeFinanceur();
    m_statut = getStatut();
    m_listePeriodesElementPensionInvalidite = getCopieCollectionPeriodeElementPensionInvalidite();
    m_listeFinsPeriodesPensionInvalidite = getCopieCollectionFinsPeriodesPensionInvalidite();
  }
  
  private Collection getCopieCollectionPeriodeElementPensionInvalidite()
  {
    ArrayList copie = new ArrayList();
    Collection listeACopier = getCollectionModifiablePeriodeSousPensionInvalidite();
    for (Iterator i = listeACopier.iterator(); i.hasNext();)
    {
      ObjetMetierSpec objet = ((ObjetMetierSpec)i.next()).copie();
      copie.add((PeriodeSousPensionInvaliditeChaineeSpec)objet);
    }
    return copie;
  }
  
  private Collection getCopieCollectionFinsPeriodesPensionInvalidite()
  {
    ArrayList copie = new ArrayList();
    Collection listeACopier = getCollectionModifiableFinsPeriodesPensionInvalidite();
    for (Iterator i = listeACopier.iterator(); i.hasNext();)
    {
      ObjetMetierSpec objet = ((ObjetMetierSpec)i.next()).copie();
      copie.add((PeriodeSousPensionInvaliditeChaineeSpec)objet);
    }
    return copie;
  }
  
  public int compareTo(Object p_o)
  {
    if ((p_o instanceof PeriodePensionInvaliditeChaineeSpec))
    {
      PeriodePensionInvaliditeChaineeSpec pensionAcomparer = (PeriodePensionInvaliditeChaineeSpec)p_o;
      if ((getOrganismeFinanceur().equalsIgnoreCase(pensionAcomparer.getOrganismeFinanceur())) && (getDateDebut().coincideAvec(pensionAcomparer.getDateDebut()))) {
        return 0;
      }
    }
    return -1;
  }
}

/* Location:
 * Qualified Name:     PeriodePensionInvaliditeChainee
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */