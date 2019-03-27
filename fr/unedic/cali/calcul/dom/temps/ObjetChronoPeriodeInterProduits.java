package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.cali.calcul.dom.Somme;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ObjetChronoPeriodeInterProduits
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 287303367268623405L;
  public static final int TYPE_PERIODE_DOD = 1;
  public static final int TYPE_PERIODE_PJI = 2;
  public static final int TYPE_PERIODE_SOMME = 3;
  public static final int TYPE_PERIODE_DJI = 4;
  public static final int TYPE_PERIODE_LENDEMAIN_DJI = 5;
  public static final int TYPE_PERIODE_LIEU = 6;
  public static final int TYPE_PERIODE_INDEMNISATION_RFPE = 7;
  public static final int TYPE_PERIODE_INDEMNISATION_PRODUIT_SUSP = 8;
  private int m_typePeriode = 0;
  private String m_nomProduit = null;
  private String m_gamme = null;
  private AttributionSpec m_attribution = null;
  private Somme m_somme = null;
  
  public ObjetChronoPeriodeInterProduits() {}
  
  public ObjetChronoPeriodeInterProduits(Damj debut, Damj fin, int typePeriode, AttributionSpec attribution)
  {
    super(debut, fin);
    setTypePeriode(typePeriode);
    setAttribution(attribution);
    setNomProduit(getAttribution().getProduit().getNom());
    setGamme(getAttribution().getGamme().getNomUnique());
  }
  
  public boolean estProduitMayotte()
  {
    return (getNomProduit().equals("ASU_MAY17_02")) || (getNomProduit().equals("ASU_MAY17_03"));
  }
  
  public String getNomProduit()
  {
    return m_nomProduit;
  }
  
  public void setNomProduit(String nomProduit)
  {
    m_nomProduit = nomProduit;
  }
  
  public String getGamme()
  {
    return m_gamme;
  }
  
  public void setGamme(String gamme)
  {
    m_gamme = gamme;
  }
  
  public void setAttribution(AttributionSpec attribution)
  {
    m_attribution = attribution;
  }
  
  public void setTypePeriode(int typePeriode)
  {
    m_typePeriode = typePeriode;
  }
  
  public int getTypePeriode()
  {
    return m_typePeriode;
  }
  
  public AttributionSpec getAttribution()
  {
    return m_attribution;
  }
  
  public Somme getSomme()
  {
    return m_somme;
  }
  
  public void setSomme(Somme somme)
  {
    m_somme = somme;
  }
  
  public Periode getPeriode()
  {
    return m_periode;
  }
  
  public void setPeriode(Periode periode)
  {
    m_periode = periode;
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoPeriodeInterProduits copie = new ObjetChronoPeriodeInterProduits();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec objetMetierCopie)
  {
    ObjetChronoPeriodeInterProduits copie = (ObjetChronoPeriodeInterProduits)objetMetierCopie;
    super.copieElements(copie);
    m_typePeriode = getTypePeriode();
    m_nomProduit = getNomProduit();
    m_gamme = getGamme();
    m_attribution = getAttribution();
    if (getSomme() != null) {
      m_somme = ((Somme)getSomme().copie());
    }
  }
}

/* Location:
 * Qualified Name:     ObjetChronoPeriodeInterProduits
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */