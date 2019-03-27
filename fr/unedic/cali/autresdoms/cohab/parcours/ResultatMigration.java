package fr.unedic.cali.autresdoms.cohab.parcours;

import fr.unedic.cali.autresdoms.cohab.dom.DemandeMigreeEnErreur;
import fr.unedic.cali.dom.Erreur;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ResultatMigration
  extends Resultat
{
  private Collection m_listeDemandesMigreesEnErreur;
  private Collection m_listeErreurs;
  private int m_rsodnc;
  private Damj m_ddorkb;
  private boolean m_migreEnSimplifie;
  private boolean m_presenceEcartDroitsPasses;
  private boolean m_presenceEcartDroitEnCours;
  
  public ResultatMigration()
  {
    m_listeDemandesMigreesEnErreur = new ArrayList();
    m_listeErreurs = new ArrayList();
  }
  
  public Collection getListeDemandesMigreesEnErreur()
  {
    return m_listeDemandesMigreesEnErreur;
  }
  
  public DemandeMigreeEnErreur getDemandeMigreeEnErreur(String p_reference)
  {
    DemandeMigreeEnErreur laDemandeEnErreur = null;
    Iterator iterator = m_listeDemandesMigreesEnErreur.iterator();
    while ((iterator.hasNext()) && (laDemandeEnErreur == null))
    {
      DemandeMigreeEnErreur uneDemandeEnErreur = (DemandeMigreeEnErreur)iterator.next();
      if (uneDemandeEnErreur.getReference().equals(p_reference)) {
        laDemandeEnErreur = uneDemandeEnErreur;
      }
    }
    return laDemandeEnErreur;
  }
  
  public void setListeDemandesMigreesEnErreur(Collection p_listeDemandesMigreesEnErreur)
  {
    m_listeDemandesMigreesEnErreur = p_listeDemandesMigreesEnErreur;
  }
  
  public void ajouterDemandeMigreeEnErreur(DemandeMigreeEnErreur p_demande)
  {
    getListeDemandesMigreesEnErreur().add(p_demande);
  }
  
  public boolean estSatisfait()
  {
    boolean estSatisfait = true;
    
    Iterator iterDemandesEnErreur = getListeDemandesMigreesEnErreur().iterator();
    while ((iterDemandesEnErreur.hasNext()) && (estSatisfait == true))
    {
      DemandeMigreeEnErreur element = (DemandeMigreeEnErreur)iterDemandesEnErreur.next();
      if (element.getNiveauErreurGlobal() == 3) {
        estSatisfait = false;
      }
    }
    Iterator iterErreurs = getListeErreurs().iterator();
    while ((iterErreurs.hasNext()) && (estSatisfait == true))
    {
      Erreur element = (Erreur)iterErreurs.next();
      if (element.getNiveau() == 3) {
        estSatisfait = false;
      }
    }
    return estSatisfait;
  }
  
  public Collection getListeErreurs()
  {
    return m_listeErreurs;
  }
  
  public void setListeErreurs(Collection p_listeErreurs)
  {
    m_listeErreurs = p_listeErreurs;
  }
  
  public void ajouterErreur(Erreur p_erreur)
  {
    getListeErreurs().add(p_erreur);
  }
  
  public Damj getDdorkb()
  {
    return m_ddorkb;
  }
  
  public void setDdorkb(Damj p_ddorkb)
  {
    m_ddorkb = p_ddorkb;
  }
  
  public boolean isMigreEnSimplifie()
  {
    return m_migreEnSimplifie;
  }
  
  public void setMigreEnSimplifie(boolean p_migreEnSimplifie)
  {
    m_migreEnSimplifie = p_migreEnSimplifie;
  }
  
  public int getRsodnc()
  {
    return m_rsodnc;
  }
  
  public void setRsodnc(int p_rsodnc)
  {
    m_rsodnc = p_rsodnc;
  }
  
  public boolean isPresenceEcartDroitEnCours()
  {
    return m_presenceEcartDroitEnCours;
  }
  
  public void setPresenceEcartDroitEnCours(boolean p_presenceEcartDroitEnCours)
  {
    m_presenceEcartDroitEnCours = p_presenceEcartDroitEnCours;
  }
  
  public boolean isPresenceEcartDroitsPasses()
  {
    return m_presenceEcartDroitsPasses;
  }
  
  public void setPresenceEcartDroitsPasses(boolean p_presenceEcartDroitsPasses)
  {
    m_presenceEcartDroitsPasses = p_presenceEcartDroitsPasses;
  }
}

/* Location:
 * Qualified Name:     ResultatMigration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */