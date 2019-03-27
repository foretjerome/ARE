package fr.unedic.cali.dom;

import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.util.temps.Damj;
import java.util.Collection;
import java.util.Iterator;

public class AppelGaecReduit
{
  private int m_modeAppel = 0;
  private JustificationAppelGaecReduit m_dateDebutFenetreAppel = null;
  private JustificationAppelGaecReduit m_dateDebutFenetreAppelOptionnelle = null;
  private JustificationAppelGaecReduit m_dateDebutFenetreAppelValide = null;
  private JustificationAppelGaecReduit m_dateFinFenetreAppel = null;
  private Damj m_dateExecutionCalcul = null;
  private boolean m_pnd = false;
  private boolean m_dnj = false;
  private Collection m_typePeriodes = null;
  private String m_identifiantPeriodeGaec = null;
  private boolean m_appelPeriodeUnique = false;
  
  public int getModeAppel()
  {
    return m_modeAppel;
  }
  
  public void setModeAppel(int p_modeAppel)
  {
    m_modeAppel = p_modeAppel;
  }
  
  public boolean isAppelPeriodeUnique()
  {
    return m_appelPeriodeUnique;
  }
  
  public void setAppelPeriodeUnique(boolean p_appelPeriodeUnique)
  {
    m_appelPeriodeUnique = p_appelPeriodeUnique;
  }
  
  public JustificationAppelGaecReduit getDateDebutJustifieeFenetreAppel()
  {
    return m_dateDebutFenetreAppel;
  }
  
  public void setDateDebutFenetreAppel(JustificationAppelGaecReduit p_dateDebutFenetreAppel)
  {
    m_dateDebutFenetreAppel = p_dateDebutFenetreAppel;
    setDateDebutFenetreAppelValide();
  }
  
  public JustificationAppelGaecReduit getDateDebutJustifieeFenetreAppelOptionnelle()
  {
    return m_dateDebutFenetreAppelOptionnelle;
  }
  
  public void setDateDebutFenetreAppelOptionnelle(JustificationAppelGaecReduit p_dateDebutFenetreAppelOptionnelle)
  {
    m_dateDebutFenetreAppelOptionnelle = p_dateDebutFenetreAppelOptionnelle;
    setDateDebutFenetreAppelValide();
  }
  
  public JustificationAppelGaecReduit getDateFinJustifieeFenetreAppel()
  {
    return m_dateFinFenetreAppel;
  }
  
  public void setDateFinFenetreAppel(JustificationAppelGaecReduit p_dateFinFenetreAppel)
  {
    m_dateFinFenetreAppel = p_dateFinFenetreAppel;
  }
  
  public boolean isDnj()
  {
    return m_dnj;
  }
  
  public void setDnj(boolean p_dnj)
  {
    m_dnj = p_dnj;
  }
  
  public boolean isPnd()
  {
    return m_pnd;
  }
  
  public void setPnd(boolean p_pnd)
  {
    m_pnd = p_pnd;
  }
  
  public Collection getTypePeriodes()
  {
    return m_typePeriodes;
  }
  
  public void setTypePeriodes(Collection p_typePeriodes)
  {
    m_typePeriodes = p_typePeriodes;
  }
  
  public String getIdentifiantPeriodeGaec()
  {
    return m_identifiantPeriodeGaec;
  }
  
  public void setIdentifiantPeriodeGaec(String p_identifiantPeriodeGaec)
  {
    m_identifiantPeriodeGaec = p_identifiantPeriodeGaec;
  }
  
  public JustificationAppelGaecReduit getDateDebutJustifieeFenetreAppelValide()
  {
    return m_dateDebutFenetreAppelValide;
  }
  
  public Damj getDateDebutFenetreAppelValide()
  {
    if (m_dateDebutFenetreAppelValide == null) {
      return null;
    }
    return m_dateDebutFenetreAppelValide.getDate();
  }
  
  private void setDateDebutFenetreAppelValide()
  {
    if (m_dateDebutFenetreAppelOptionnelle != null) {
      m_dateDebutFenetreAppelValide = m_dateDebutFenetreAppelOptionnelle;
    } else if (m_dateDebutFenetreAppel != null) {
      m_dateDebutFenetreAppelValide = m_dateDebutFenetreAppel;
    } else {
      m_dateDebutFenetreAppelValide = null;
    }
  }
  
  public void compareEtSetDateDebutFenetreAppel(JustificationAppelGaecReduit p_dateJustifiee)
  {
    if (p_dateJustifiee != null) {
      compareEtSetDateDebutFenetreAppel(p_dateJustifiee.getDate(), p_dateJustifiee.getJustification(), p_dateJustifiee.getIdDemande());
    }
  }
  
  public void compareEtSetDateDebutFenetreAppel(Damj p_date, String p_justification, String p_idDemande)
  {
    if (p_date != null)
    {
      Damj dateCourante = null;
      if (m_dateDebutFenetreAppel != null) {
        dateCourante = m_dateDebutFenetreAppel.getDate();
      }
      if ((dateCourante == null) || (p_date.estAvant(dateCourante))) {
        setDateDebutFenetreAppel(new JustificationAppelGaecReduit(p_date, p_justification, p_idDemande));
      }
    }
  }
  
  public void compareEtSetDateDebutFenetreAppelOptionnelle(JustificationAppelGaecReduit p_dateJustifiee)
  {
    if (p_dateJustifiee != null) {
      compareEtSetDateDebutFenetreAppelOptionnelle(p_dateJustifiee.getDate(), p_dateJustifiee.getJustification(), p_dateJustifiee.getIdDemande());
    }
  }
  
  public void compareEtSetDateDebutFenetreAppelOptionnelle(Damj p_date, String p_justification, String p_idDemande)
  {
    if (p_date != null)
    {
      Damj dateCourante = null;
      if (m_dateDebutFenetreAppelOptionnelle != null) {
        dateCourante = m_dateDebutFenetreAppelOptionnelle.getDate();
      }
      if ((dateCourante == null) || (p_date.estAvant(dateCourante))) {
        setDateDebutFenetreAppelOptionnelle(new JustificationAppelGaecReduit(p_date, p_justification, p_idDemande));
      }
    }
  }
  
  public void compareEtSetDateFinFenetreAppel(JustificationAppelGaecReduit p_dateJustifiee)
  {
    if (p_dateJustifiee != null) {
      compareEtSetDateFinFenetreAppel(p_dateJustifiee.getDate(), p_dateJustifiee.getJustification(), p_dateJustifiee.getIdDemande());
    }
  }
  
  public void compareEtSetDateFinFenetreAppel(Damj p_date, String p_justification, String p_idDemande)
  {
    if (p_date != null)
    {
      Damj dateCourante = null;
      if (m_dateFinFenetreAppel != null) {
        dateCourante = m_dateFinFenetreAppel.getDate();
      }
      if ((dateCourante == null) || (p_date.estApres(dateCourante))) {
        setDateFinFenetreAppel(new JustificationAppelGaecReduit(p_date, p_justification, p_idDemande));
      }
    }
  }
  
  public Damj getDateDebutFenetreAppel()
  {
    if (m_dateDebutFenetreAppel == null) {
      return null;
    }
    return m_dateDebutFenetreAppel.getDate();
  }
  
  public Damj getDateDebutFenetreAppelOptionnelle()
  {
    if (m_dateDebutFenetreAppelOptionnelle == null) {
      return null;
    }
    return m_dateDebutFenetreAppelOptionnelle.getDate();
  }
  
  public Damj getDateFinFenetreAppel()
  {
    if (m_dateFinFenetreAppel == null) {
      return null;
    }
    return m_dateFinFenetreAppel.getDate();
  }
  
  public String getJustificationDateDebutFenetre()
  {
    if (m_dateDebutFenetreAppel == null) {
      return null;
    }
    return m_dateDebutFenetreAppel.getJustification();
  }
  
  public String getJustificationDateDebutOptionnelleFenetre()
  {
    if (m_dateDebutFenetreAppelOptionnelle == null) {
      return null;
    }
    return m_dateDebutFenetreAppelOptionnelle.getJustification();
  }
  
  public String getJustificationDateFinFenetre()
  {
    if (m_dateFinFenetreAppel == null) {
      return null;
    }
    return m_dateFinFenetreAppel.getJustification();
  }
  
  public void afficherTracesGaecReduit()
  {
    afficherTracesGaecReduit(Niveau.DEBUG);
  }
  
  public void afficherTracesGaecReduit(Niveau p_niveauDeTracage)
  {
    String libelleTrace = "tracerAppelGaecReduit";
    
    Log.ecritTrace(p_niveauDeTracage, getClass(), libelleTrace, "*** AppelGaecReduit ***");
    
    String modeAppel = "";
    switch (getModeAppel())
    {
    case 0: 
      modeAppel = "Aucun";
      break;
    case 1: 
      modeAppel = "Partiel";
      break;
    case 2: 
      modeAppel = "Total";
    }
    Log.ecritTrace(p_niveauDeTracage, getClass(), libelleTrace, "Mode appel : " + modeAppel);
    if (getModeAppel() == 1)
    {
      if (m_dateDebutFenetreAppel != null) {
        Log.ecritTrace(p_niveauDeTracage, getClass(), libelleTrace, "Bornage - Date debut : " + m_dateDebutFenetreAppel.getJustification() + " = " + m_dateDebutFenetreAppel.getDate().formater());
      } else {
        Log.ecritTrace(p_niveauDeTracage, getClass(), libelleTrace, "Bornage - Date debut : Aucun bornage");
      }
      if (m_dateDebutFenetreAppelOptionnelle != null) {
        Log.ecritTrace(p_niveauDeTracage, getClass(), libelleTrace, "Bornage - Date debut optionnelle : " + m_dateDebutFenetreAppelOptionnelle.getJustification() + " = " + m_dateDebutFenetreAppelOptionnelle.getDate().formater());
      } else {
        Log.ecritTrace(p_niveauDeTracage, getClass(), libelleTrace, "Bornage - Date debut optionnelle : Aucun bornage");
      }
      if (m_dateDebutFenetreAppelValide != null) {
        Log.ecritTrace(p_niveauDeTracage, getClass(), libelleTrace, "Bornage - Date debut utilisee : " + m_dateDebutFenetreAppelValide.getJustification() + " = " + m_dateDebutFenetreAppelValide.getDate().formater());
      } else {
        Log.ecritTrace(p_niveauDeTracage, getClass(), libelleTrace, "Bornage - Date debut utilisee : Aucun bornage");
      }
      if (m_dateFinFenetreAppel != null) {
        Log.ecritTrace(p_niveauDeTracage, getClass(), libelleTrace, "Bornage - Date fin : " + m_dateFinFenetreAppel.getJustification() + " = " + m_dateFinFenetreAppel.getDate().formater());
      } else {
        Log.ecritTrace(p_niveauDeTracage, getClass(), libelleTrace, "Bornage - Date fin : Aucun bornage");
      }
      Log.ecritTrace(p_niveauDeTracage, getClass(), libelleTrace, "Pnd : " + m_pnd);
      Log.ecritTrace(p_niveauDeTracage, getClass(), libelleTrace, "Dnj : " + m_dnj);
      
      Log.ecritTrace(p_niveauDeTracage, getClass(), libelleTrace, "Periode Gaec unique : " + m_appelPeriodeUnique);
      if (m_identifiantPeriodeGaec != null) {
        Log.ecritTrace(p_niveauDeTracage, getClass(), libelleTrace, "Identifiant periode Gaec unique : " + m_identifiantPeriodeGaec);
      } else {
        Log.ecritTrace(p_niveauDeTracage, getClass(), libelleTrace, "Identifiant periode Gaec unique : null");
      }
      if (m_typePeriodes != null)
      {
        Iterator itTypesPeriodes = m_typePeriodes.iterator();
        String typePeriodes = "";
        while (itTypesPeriodes.hasNext())
        {
          String typePeriode = (String)itTypesPeriodes.next();
          if (typePeriode != null) {
            typePeriodes = typePeriodes.concat(typePeriode);
          }
        }
        typePeriodes = typePeriodes.trim();
        if (typePeriodes.length() > 0) {
          Log.ecritTrace(p_niveauDeTracage, getClass(), libelleTrace, "Types de periode Gaec : " + typePeriodes);
        } else {
          Log.ecritTrace(p_niveauDeTracage, getClass(), libelleTrace, "Types de periode Gaec : tous");
        }
      }
      else
      {
        Log.ecritTrace(p_niveauDeTracage, getClass(), libelleTrace, "Types de periode Gaec : tous");
      }
      Log.ecritTrace(p_niveauDeTracage, getClass(), libelleTrace, "*************************");
    }
  }
  
  public Damj getDateExecutionCalcul()
  {
    return m_dateExecutionCalcul;
  }
  
  public void setDateExecutionCalcul(Damj p_dateExecutionCalcul)
  {
    m_dateExecutionCalcul = p_dateExecutionCalcul;
  }
}

/* Location:
 * Qualified Name:     AppelGaecReduit
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */