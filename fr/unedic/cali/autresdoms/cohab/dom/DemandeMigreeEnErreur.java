package fr.unedic.cali.autresdoms.cohab.dom;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.Erreur;
import fr.unedic.cohabitation.sigma.migration.dom.DemandeMigreeV1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class DemandeMigreeEnErreur
{
  private String m_reference;
  private String m_codeProduit;
  private String m_libelle;
  private Collection m_listeErreurs;
  private DonneesAuDJIMigration m_donneeAuDJI;
  private DemandeSpec m_demande;
  private DemandeMigreeV1 m_demandeV1;
  
  public DemandeMigreeEnErreur()
  {
    m_listeErreurs = new ArrayList();
  }
  
  public String getCodeProduit()
  {
    return m_codeProduit;
  }
  
  public void setCodeProduit(String p_codeProduit)
  {
    m_codeProduit = p_codeProduit;
  }
  
  public Collection getListeErreurs()
  {
    return m_listeErreurs;
  }
  
  public boolean hasErreurs()
  {
    return !getListeErreurs().isEmpty();
  }
  
  public void ajouterErreur(Erreur p_erreur)
  {
    if (!m_listeErreurs.contains(p_erreur)) {
      m_listeErreurs.add(p_erreur);
    }
  }
  
  public String getReference()
  {
    return m_reference;
  }
  
  public void setReference(String p_reference)
  {
    m_reference = p_reference;
  }
  
  public int getNiveauErreurGlobal()
  {
    int niveauMax = 0;
    
    Iterator iterErreurs = getListeErreurs().iterator();
    while (iterErreurs.hasNext())
    {
      Erreur element = (Erreur)iterErreurs.next();
      niveauMax = Erreur.niveauMax(niveauMax, element.getNiveau());
    }
    return niveauMax;
  }
  
  public String getLibelle()
  {
    return m_libelle;
  }
  
  public void setLibelle(String p_libelle)
  {
    m_libelle = p_libelle;
  }
  
  public DonneesAuDJIMigration getDonneeAuDJI()
  {
    return m_donneeAuDJI;
  }
  
  public void setDonneeAuDJI(DonneesAuDJIMigration p_donneeAuDJI)
  {
    m_donneeAuDJI = p_donneeAuDJI;
  }
  
  public DemandeSpec getDemande()
  {
    return m_demande;
  }
  
  public void setDemande(DemandeSpec p_demande)
  {
    m_demande = p_demande;
  }
  
  public String toString()
  {
    StringBuffer buffer = new StringBuffer();
    
    String ref = getReference() != null ? getReference() : "NC";
    String codeProduit = getCodeProduit() != null ? getCodeProduit() : "NC";
    String libelle = getLibelle() != null ? getLibelle() : "NC";
    
    buffer.append("Demande Migrée En Erreur : ");
    buffer.append("[Ref:");
    buffer.append(ref);
    buffer.append("; CodeProduit:");
    buffer.append(codeProduit);
    buffer.append("; Libellé:");
    buffer.append(libelle);
    buffer.append("]\n");
    
    Iterator it = getListeErreurs().iterator();
    int cpt = 1;
    Erreur err = null;
    while (it.hasNext())
    {
      err = (Erreur)it.next();
      
      buffer.append("\t\tErreur n°" + cpt + " : ");
      buffer.append(err.toString() + "\n");
      
      cpt++;
    }
    return buffer.toString();
  }
  
  public DemandeMigreeV1 getDemandeV1()
  {
    return m_demandeV1;
  }
  
  public void setDemandeV1(DemandeMigreeV1 p_demandeV1)
  {
    m_demandeV1 = p_demandeV1;
  }
}

/* Location:
 * Qualified Name:     DemandeMigreeEnErreur
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */