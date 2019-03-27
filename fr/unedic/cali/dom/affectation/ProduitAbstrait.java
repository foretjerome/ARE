package fr.unedic.cali.dom.affectation;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.calcul.outilsfonctionnels.ElementForcable;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DecisionSpec;
import fr.unedic.cali.dom.DossierExamenSpec;
import fr.unedic.cali.dom.echange.Decision;
import fr.unedic.cali.dom.pivot.DemandePivot;
import fr.unedic.cali.migration.GrapheLiquidationSpec;
import fr.unedic.cali.occasionnel.outilsfonctionnels.CriteresExecutionPopulation;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

public abstract class ProduitAbstrait
  implements ProduitSpec
{
  private String nomUnique;
  private int code;
  private String libelleCourt;
  private String libelleLong;
  private LigneSpec ligne;
  private List listeReglements = new ArrayList();
  private List listeElementsForcables = new ArrayList();
  private Periode periodeValidite = null;
  private transient ProduitDelegueSpec produitDelegue;
  protected static final HashMap groupeTypesProduits = new HashMap();
  
  static
  {
    List listeTypeProduitAss = new ArrayList();
    listeTypeProduitAss.add(new BigDecimal(9));
    listeTypeProduitAss.add(new BigDecimal(10));
    groupeTypesProduits.put(new BigDecimal(3), listeTypeProduitAss);
    
    List listeTypeProduitAts = new ArrayList();
    listeTypeProduitAts.add(new BigDecimal(52));
    listeTypeProduitAts.add(new BigDecimal(55));
    groupeTypesProduits.put(new BigDecimal(4), listeTypeProduitAts);
    
    List listeTypeProduitPmvs = new ArrayList();
    listeTypeProduitPmvs.add(new BigDecimal(48));
    listeTypeProduitPmvs.add(new BigDecimal(60));
    listeTypeProduitPmvs.add(new BigDecimal(72));
    listeTypeProduitPmvs.add(new BigDecimal(62));
    listeTypeProduitPmvs.add(new BigDecimal(51));
    listeTypeProduitPmvs.add(new BigDecimal(50));
    listeTypeProduitPmvs.add(new BigDecimal(66));
    listeTypeProduitPmvs.add(new BigDecimal(67));
    groupeTypesProduits.put(new BigDecimal(7), listeTypeProduitPmvs);
    
    List listeTypeProduitCrp = new ArrayList();
    listeTypeProduitCrp.add(new BigDecimal(37));
    listeTypeProduitCrp.add(new BigDecimal(36));
    groupeTypesProduits.put(new BigDecimal(1), listeTypeProduitCrp);
    
    List listeTypeProduitCsp = new ArrayList();
    listeTypeProduitCsp.add(new BigDecimal(50));
    listeTypeProduitCsp.add(new BigDecimal(51));
    listeTypeProduitCsp.add(new BigDecimal(66));
    listeTypeProduitCsp.add(new BigDecimal(67));
    groupeTypesProduits.put(new BigDecimal(2), listeTypeProduitCsp);
    
    List listeTypeProduitSpectacle = new ArrayList();
    listeTypeProduitSpectacle.add(new BigDecimal(28));
    listeTypeProduitSpectacle.add(new BigDecimal(29));
    listeTypeProduitSpectacle.add(new BigDecimal(76));
    listeTypeProduitSpectacle.add(new BigDecimal(3));
    listeTypeProduitSpectacle.add(new BigDecimal(20));
    listeTypeProduitSpectacle.add(new BigDecimal(64));
    listeTypeProduitSpectacle.add(new BigDecimal(71));
    listeTypeProduitSpectacle.add(new BigDecimal(74));
    listeTypeProduitSpectacle.add(new BigDecimal(27));
    listeTypeProduitSpectacle.add(new BigDecimal(65));
    listeTypeProduitSpectacle.add(new BigDecimal(75));
    groupeTypesProduits.put(new BigDecimal(6), listeTypeProduitSpectacle);
    
    List listeTypeProduitAre = new ArrayList();
    listeTypeProduitAre.add(new BigDecimal(1));
    listeTypeProduitAre.add(new BigDecimal(13));
    listeTypeProduitAre.add(new BigDecimal(31));
    listeTypeProduitAre.add(new BigDecimal(48));
    listeTypeProduitAre.add(new BigDecimal(60));
    listeTypeProduitAre.add(new BigDecimal(72));
    listeTypeProduitAre.add(new BigDecimal(62));
    listeTypeProduitAre.add(new BigDecimal(8));
    listeTypeProduitAre.add(new BigDecimal(14));
    listeTypeProduitAre.add(new BigDecimal(32));
    listeTypeProduitAre.add(new BigDecimal(49));
    listeTypeProduitAre.add(new BigDecimal(61));
    listeTypeProduitAre.add(new BigDecimal(73));
    listeTypeProduitAre.add(new BigDecimal(63));
    listeTypeProduitAre.add(new BigDecimal(45));
    listeTypeProduitAre.add(new BigDecimal(15));
    listeTypeProduitAre.add(new BigDecimal(19));
    listeTypeProduitAre.add(new BigDecimal(33));
    listeTypeProduitAre.add(new BigDecimal(3));
    listeTypeProduitAre.add(new BigDecimal(20));
    listeTypeProduitAre.add(new BigDecimal(64));
    listeTypeProduitAre.add(new BigDecimal(71));
    listeTypeProduitAre.add(new BigDecimal(74));
    
    groupeTypesProduits.put(new BigDecimal(5), listeTypeProduitAre);
    
    List listeTypeProduitRechargement = new ArrayList();
    listeTypeProduitRechargement.add(new BigDecimal(1));
    listeTypeProduitRechargement.add(new BigDecimal(13));
    listeTypeProduitRechargement.add(new BigDecimal(31));
    listeTypeProduitRechargement.add(new BigDecimal(48));
    listeTypeProduitRechargement.add(new BigDecimal(60));
    listeTypeProduitRechargement.add(new BigDecimal(62));
    listeTypeProduitRechargement.add(new BigDecimal(72));
    listeTypeProduitRechargement.add(new BigDecimal(8));
    listeTypeProduitRechargement.add(new BigDecimal(14));
    listeTypeProduitRechargement.add(new BigDecimal(32));
    listeTypeProduitRechargement.add(new BigDecimal(49));
    listeTypeProduitRechargement.add(new BigDecimal(61));
    listeTypeProduitRechargement.add(new BigDecimal(63));
    listeTypeProduitRechargement.add(new BigDecimal(45));
    listeTypeProduitRechargement.add(new BigDecimal(15));
    listeTypeProduitRechargement.add(new BigDecimal(19));
    listeTypeProduitRechargement.add(new BigDecimal(33));
    
    groupeTypesProduits.put(new BigDecimal(8), listeTypeProduitRechargement);
  }
  
  public static boolean estDuType(int type, int produit)
  {
    List listeTypeAttribution = (List)groupeTypesProduits.get(new BigDecimal(type));
    return listeTypeAttribution.contains(new BigDecimal(produit));
  }
  
  public static boolean estDuType(int type, ProduitSpec produit)
  {
    boolean retour = false;
    if (produit != null)
    {
      List listeTypeAttribution = (List)groupeTypesProduits.get(new BigDecimal(type));
      retour = listeTypeAttribution.contains(new BigDecimal(produit.getCode()));
    }
    return retour;
  }
  
  protected ProduitDelegueSpec creerProduitDelegue(String classeProduit)
  {
    ProduitDelegueSpec produitDelegueARetourner = null;
    try
    {
      produitDelegueARetourner = (ProduitDelegueSpec)Class.forName(classeProduit).newInstance();
    }
    catch (Exception e) {}
    return produitDelegueARetourner;
  }
  
  public String getLibelleCourt()
  {
    return libelleCourt;
  }
  
  public String getLibelleLong()
  {
    return libelleLong;
  }
  
  public LigneSpec getLigne()
  {
    return ligne;
  }
  
  public String getNom()
  {
    return getNomUnique();
  }
  
  public Periode getPeriodeValidite()
  {
    return periodeValidite;
  }
  
  public ProduitDelegueSpec getProduitDelegue()
  {
    return produitDelegue;
  }
  
  public void setLibelleCourt(String libCourt)
  {
    libelleCourt = libCourt;
  }
  
  public void setLibelleLong(String libLong)
  {
    libelleLong = libLong;
  }
  
  public void setLigne(LigneSpec ligneAPositionner)
  {
    ligne = ligneAPositionner;
  }
  
  protected void setProduitDelegue(ProduitDelegueSpec produitDelegueAPositionner)
  {
    produitDelegue = produitDelegueAPositionner;
  }
  
  public boolean estActif(Damj date)
  {
    return date.estContenueDans(getPeriodeValidite());
  }
  
  public void ajouterReglement(Reglement reglement)
  {
    if (reglement != null)
    {
      getListeReglements().add(reglement);
      if (reglement.getProduit() != this) {
        reglement.setProduit(this);
      }
    }
  }
  
  public boolean contientReglement(String nomReglement)
  {
    return getReglement(nomReglement) != null;
  }
  
  public boolean contientReglement(Reglement reglement)
  {
    return contientReglement(reglement.getNomReglement());
  }
  
  public List getListeReglements()
  {
    return listeReglements;
  }
  
  public void setListeReglements(List listeReglementsAPositionner)
  {
    listeReglements = listeReglementsAPositionner;
  }
  
  public void setPeriodeValidite(Periode periodeValiditeAPositionner)
  {
    periodeValidite = periodeValiditeAPositionner;
  }
  
  public Reglement getReglement(String nomReglement)
  {
    for (Iterator listeReglementsIterator = getListeReglements().iterator(); listeReglementsIterator.hasNext();)
    {
      Reglement reglement = (Reglement)listeReglementsIterator.next();
      if (reglement.getNomReglement().equalsIgnoreCase(nomReglement)) {
        return reglement;
      }
    }
    return null;
  }
  
  public String getNomUnique()
  {
    return nomUnique;
  }
  
  public void setNomUnique(String nomUniqueAPositionner)
  {
    nomUnique = nomUniqueAPositionner;
  }
  
  public int getCode()
  {
    return code;
  }
  
  public void setCode(int codeParametre)
  {
    code = codeParametre;
  }
  
  public void ajouterElementForcable(ElementForcable elementForcable)
  {
    if (elementForcable != null)
    {
      getListeElementsForcables().add(elementForcable);
      if (elementForcable.getProduit() != this) {
        elementForcable.setProduit(this);
      }
    }
  }
  
  public boolean contientElementForcable(ElementForcable elementForcable)
  {
    return contientElementForcable(elementForcable.getNomElementForcable());
  }
  
  public ElementForcable getElementForcable(String nomElementForcable)
  {
    for (Iterator listeElementsForcablesIter = getListeElementsForcables().iterator(); listeElementsForcablesIter.hasNext();)
    {
      ElementForcable elementForcable = (ElementForcable)listeElementsForcablesIter.next();
      if (elementForcable.getNomElementForcable().equalsIgnoreCase(nomElementForcable)) {
        return elementForcable;
      }
    }
    return null;
  }
  
  public boolean contientElementForcable(String nomElementForcable)
  {
    return getElementForcable(nomElementForcable) != null;
  }
  
  public boolean contientReglement(ElementForcable elementForcable)
  {
    return contientReglement(elementForcable.getNomElementForcable());
  }
  
  public List getListeElementsForcables()
  {
    return listeElementsForcables;
  }
  
  public void setListeElementsForcables(List listeElementsForcablesParametre)
  {
    listeElementsForcables = listeElementsForcablesParametre;
  }
  
  public String toString()
  {
    return getNom();
  }
  
  public boolean comparerDecisions(DecisionSpec decision1, DecisionSpec decision2)
  {
    if (getProduitDelegue() != null) {
      return getProduitDelegue().comparerDecisions(decision1, decision2);
    }
    return false;
  }
  
  public void alimenterBasePivotProduit(DossierExamenSpec dossierExamen, DemandePivot demandePivot)
    throws ApplicativeException
  {
    if (getProduitDelegue() != null) {
      getProduitDelegue().alimenterBasePivotProduit(dossierExamen, demandePivot);
    }
  }
  
  public void alimenterBaseEchangesProduit(DossierExamenSpec dossierExamen, Decision demandeEchange)
    throws ApplicativeException
  {
    if (getProduitDelegue() != null) {
      getProduitDelegue().alimenterBaseEchangesProduit(dossierExamen, demandeEchange);
    }
  }
  
  public ArrayList alimenterDecisionsReexamen(Contexte contexte)
    throws CoucheLogiqueException
  {
    if (getProduitDelegue() == null) {
      return null;
    }
    return getProduitDelegue().alimenterDecisionsReexamen(contexte);
  }
  
  public Hashtable recupererElementsConstituant(DossierExamenSpec dossierExamen)
    throws CoucheLogiqueException
  {
    if (getProduitDelegue() != null) {
      return getProduitDelegue().recupererElementsConstituant(dossierExamen);
    }
    return null;
  }
  
  public GrapheLiquidationSpec creerGraphe(int natureDecision, boolean classement)
  {
    if (getProduitDelegue() != null) {
      return getProduitDelegue().creerGraphe(natureDecision, classement);
    }
    return null;
  }
  
  public ArrayList getParametres()
  {
    if (getProduitDelegue() != null) {
      return getProduitDelegue().getParametres();
    }
    return null;
  }
  
  public boolean estReexecutable(CriteresExecutionPopulation criteres)
  {
    return getProduitDelegue().estReexecutable(criteres);
  }
  
  public boolean estCompetenceFinanciereSecteurPublic(AttributionSpec attribution)
  {
    return false;
  }
  
  public void alimenterBasePivotAidesProduit(DossierExamenSpec dossierExamen, DemandePivot demandePivot)
    throws ApplicativeException
  {
    if (getProduitDelegue() != null) {
      getProduitDelegue().alimenterBasePivotAidesProduit(dossierExamen, demandePivot);
    }
  }
  
  public void alimenterBasePivotProduitAides(DossierExamenSpec dossierExamen, DemandePivot demandePivot)
    throws ApplicativeException
  {}
}

/* Location:
 * Qualified Name:     ProduitAbstrait
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */