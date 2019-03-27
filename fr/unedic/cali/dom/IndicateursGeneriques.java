package fr.unedic.cali.dom;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class IndicateursGeneriques
{
  private HashMap m_listeIndicateurs;
  
  public IndicateursGeneriques()
  {
    m_listeIndicateurs = new HashMap();
  }
  
  private Indicateur creationIndicateur(String p_nom)
  {
    Indicateur indicateur = new Indicateur(p_nom, 0);
    m_listeIndicateurs.put(p_nom, indicateur);
    return indicateur;
  }
  
  public Indicateur getIndicateur(String p_nom)
  {
    Indicateur indicateur = (Indicateur)m_listeIndicateurs.get(p_nom);
    if (indicateur == null) {
      indicateur = creationIndicateur(p_nom);
    }
    return indicateur;
  }
  
  public int size()
  {
    if (m_listeIndicateurs == null) {
      m_listeIndicateurs = new HashMap();
    }
    return m_listeIndicateurs.size();
  }
  
  public void incrementeIndicateur(String p_nom)
  {
    if (m_listeIndicateurs == null) {
      m_listeIndicateurs = new HashMap();
    }
    Indicateur indicateur = (Indicateur)m_listeIndicateurs.get(p_nom);
    if (indicateur == null) {
      indicateur = creationIndicateur(p_nom);
    }
    indicateur.incremente();
  }
  
  public void decrementeIndicateur(String p_nom)
  {
    if (m_listeIndicateurs == null) {
      m_listeIndicateurs = new HashMap();
    }
    Indicateur indicateur = (Indicateur)m_listeIndicateurs.get(p_nom);
    if (indicateur == null) {
      indicateur = creationIndicateur(p_nom);
    }
    indicateur.decremente();
  }
  
  public void setValeur(String p_nom, int p_value)
  {
    if (m_listeIndicateurs == null) {
      m_listeIndicateurs = new HashMap();
    }
    Indicateur indicateur = (Indicateur)m_listeIndicateurs.get(p_nom);
    if (indicateur == null) {
      indicateur = creationIndicateur(p_nom);
    }
    indicateur.setValeur(p_value);
  }
  
  public void ajouteValeur(String p_nom, int p_value)
  {
    if (m_listeIndicateurs == null) {
      m_listeIndicateurs = new HashMap();
    }
    Indicateur indicateur = (Indicateur)m_listeIndicateurs.get(p_nom);
    if (indicateur == null) {
      indicateur = creationIndicateur(p_nom);
    }
    indicateur.setValeur(indicateur.getValeur() + p_value);
  }
  
  public Iterator iterator()
  {
    if (m_listeIndicateurs == null) {
      m_listeIndicateurs = new HashMap();
    }
    return m_listeIndicateurs.values().iterator();
  }
  
  public String toString()
  {
    if (m_listeIndicateurs == null) {
      m_listeIndicateurs = new HashMap();
    }
    return m_listeIndicateurs.values().toString();
  }
}

/* Location:
 * Qualified Name:     IndicateursGeneriques
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */