package fr.unedic.cali.dom;

import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

public class AgregatGaec
{
  public static final int TYPE_SERVICE_NON_RENSEIGNE = 0;
  public static final int TYPE_SERVICE_LECTURE = 1;
  public static final int TYPE_SERVICE_LIQUIDATION = 2;
  public static final int TYPE_SERVICE_MODIFICATION_CREATION = 3;
  public static final int TYPE_SERVICE_PRISE_EN_COMPTE_EVENEMENT = 4;
  public static final int TYPE_SERVICE_SUPPRESSION = 5;
  public static final int TYPE_SERVICE_OCCASIONNELS = 6;
  public static final int TYPE_SERVICE_TEST_CHAINE_DE_LIAISON = 7;
  public static final String NOM_SERVICE_DETERMINER_DATE_DEBUT_EXECUTION = "fr.unedic.cali.service.ServiceDeterminerDateDebutExecution";
  public static final String NOM_SERVICE_LECTURE_DEMANDE_ASSURANCE_DUDE = "fr.unedic.cali.service.ServiceLectureDemandeAssuranceDude";
  public static final String NOM_SERVICE_LECTURE_DEMANDE_MAINTIEN = "fr.unedic.cali.service.ServiceLectureDemandeMaintien";
  public static final String NOM_SERVICE_AFFICHER_APPLET_LIQUIDATION = "fr.unedic.cali.service.ServiceAfficherAppletLiquidation";
  public static final int DOMAINE_NON_RENSEIGNE = 0;
  public static final int DOMAINE_LIQUIDATION = 1;
  public static final int DOMAINE_LIQUIDATION_CALCUL = 2;
  public static final int DOMAINE_CALCUL = 3;
  public static final int CODE_SERVICE_LIRE_DEMANDE = 1;
  public static final int CODE_SERVICE_LIRE_LIQUIDATION = 3;
  private int m_modeAppel = 0;
  private int m_typeService = 0;
  private String m_nomService = null;
  private Hashtable m_gammes = null;
  private Hashtable m_produits = null;
  private int m_domaine = 0;
  private String m_idPeriode = null;
  private String m_idDemande = null;
  Collection m_typePeriodesGaec = null;
  private boolean m_optimisationPasDeChargementGaec = false;
  private Damj m_dateEvtPrisEnCompte = null;
  private Damj m_dateEvtPrisEnCompteParCaliReexecManager = null;
  private int m_codeService;
  
  public AgregatGaec()
  {
    m_typeService = 0;
    
    m_gammes = new Hashtable();
    m_produits = new Hashtable();
  }
  
  public void initModeAppel()
  {
    m_modeAppel = 0;
  }
  
  public int getModeAppel()
  {
    return m_modeAppel;
  }
  
  public void setModeAppel(int p_modeAppel)
  {
    if (p_modeAppel > m_modeAppel) {
      m_modeAppel = p_modeAppel;
    }
  }
  
  public int getTypeService()
  {
    return m_typeService;
  }
  
  public void setTypeService(int p_typeService)
  {
    m_typeService = p_typeService;
  }
  
  public String getNomService()
  {
    return m_nomService;
  }
  
  public void setNomService(String p_nomService)
  {
    m_nomService = p_nomService;
  }
  
  public Enumeration getEnumerationGammes()
  {
    return m_gammes.keys();
  }
  
  public Collection getGammes()
  {
    GammeSpec gamme = null;
    Collection collectionGamme = new ArrayList();
    for (Enumeration gammeEnum = m_gammes.keys(); gammeEnum.hasMoreElements();)
    {
      gamme = (GammeSpec)gammeEnum.nextElement();
      collectionGamme.add(gamme);
    }
    return collectionGamme;
  }
  
  public ProduitSpec getPremierProduit()
  {
    Collection produits = getProduits();
    if ((produits != null) && (produits.size() > 0)) {
      return (ProduitSpec)((ArrayList)produits).get(0);
    }
    return null;
  }
  
  public Enumeration getEnumerationProduits()
  {
    return m_produits.keys();
  }
  
  public Collection getProduits()
  {
    ProduitSpec produit = null;
    Collection collectionProduit = new ArrayList();
    for (Enumeration produitEnum = m_produits.keys(); produitEnum.hasMoreElements();)
    {
      produit = (ProduitSpec)produitEnum.nextElement();
      collectionProduit.add(produit);
    }
    return collectionProduit;
  }
  
  public ProduitSpec getProduit(String p_idDemande)
  {
    for (Enumeration enumProduits = getEnumerationProduits(); enumProduits.hasMoreElements();)
    {
      ProduitSpec produit = (ProduitSpec)enumProduits.nextElement();
      if (produit != null)
      {
        Collection idDemandes = getIdDemandesPourProduit(produit);
        if (idDemandes != null)
        {
          Iterator itIdDemandes = idDemandes.iterator();
          while (itIdDemandes.hasNext())
          {
            String idDemande = (String)itIdDemandes.next();
            if (idDemande.equals(p_idDemande)) {
              return produit;
            }
          }
        }
      }
    }
    return null;
  }
  
  public void ajouterGamme(GammeSpec p_gamme, String p_idDemande)
  {
    Collection listeIdDemandes = null;
    if (m_gammes.containsKey(p_gamme))
    {
      listeIdDemandes = (Collection)m_gammes.get(p_gamme);
      if (!listeIdDemandes.contains(p_idDemande)) {
        listeIdDemandes.add(p_idDemande);
      }
    }
    else
    {
      listeIdDemandes = new ArrayList();
      listeIdDemandes.add(p_idDemande);
      m_gammes.put(p_gamme, listeIdDemandes);
    }
  }
  
  public void ajouterProduit(ProduitSpec p_produit, String p_idDemande)
  {
    Collection listeIdDemandes = null;
    if (m_produits.containsKey(p_produit))
    {
      listeIdDemandes = (Collection)m_produits.get(p_produit);
      if (!listeIdDemandes.contains(p_idDemande)) {
        listeIdDemandes.add(p_idDemande);
      }
    }
    else
    {
      listeIdDemandes = new ArrayList();
      listeIdDemandes.add(p_idDemande);
      m_produits.put(p_produit, listeIdDemandes);
    }
  }
  
  public int getDomaine()
  {
    return m_domaine;
  }
  
  public void setDomaine(int p_domaine)
  {
    m_domaine = p_domaine;
  }
  
  public String getIdPeriode()
  {
    return m_idPeriode;
  }
  
  public void setIdPeriode(String p_idPeriode)
  {
    m_idPeriode = p_idPeriode;
  }
  
  public Collection getTypePeriodesGaec()
  {
    return m_typePeriodesGaec;
  }
  
  public String getIdDemande()
  {
    return m_idDemande;
  }
  
  public void setIdDemande(String p_idDemande)
  {
    m_idDemande = p_idDemande;
  }
  
  public void setTypePeriodesGaec(Collection p_typePeriodesGaec)
  {
    m_typePeriodesGaec = p_typePeriodesGaec;
  }
  
  public Collection getIdDemandesPourGamme(GammeSpec p_gamme)
  {
    if (m_gammes == null) {
      return null;
    }
    return (Collection)m_gammes.get(p_gamme);
  }
  
  public Collection getIdDemandesPourProduit(ProduitSpec p_produit)
  {
    if (m_produits == null) {
      return null;
    }
    return (Collection)m_produits.get(p_produit);
  }
  
  public boolean isOptimisationPasDeChargementGaec()
  {
    return m_optimisationPasDeChargementGaec;
  }
  
  public void setOptimisationPasDeChargementGaec(boolean p_optimisationPasDeChargementGaec)
  {
    m_optimisationPasDeChargementGaec = p_optimisationPasDeChargementGaec;
  }
  
  public Damj getDateEvtPrisEnCompte()
  {
    return m_dateEvtPrisEnCompte;
  }
  
  public void setDateEvtPrisEnCompte(Damj p_dateEvtPrisEnCompte)
  {
    m_dateEvtPrisEnCompte = p_dateEvtPrisEnCompte;
  }
  
  public Damj getDateEvtPrisEnCompteParCaliReexecManager()
  {
    return m_dateEvtPrisEnCompteParCaliReexecManager;
  }
  
  public void setDateEvtPrisEnCompteParCaliReexecManager(Damj p_dateEvtPrisEnCompteParCaliReexecManager)
  {
    m_dateEvtPrisEnCompteParCaliReexecManager = p_dateEvtPrisEnCompteParCaliReexecManager;
  }
  
  public int getCodeService()
  {
    return m_codeService;
  }
  
  public void setCodeService(int p_codeService)
  {
    m_codeService = p_codeService;
  }
}

/* Location:
 * Qualified Name:     AgregatGaec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */