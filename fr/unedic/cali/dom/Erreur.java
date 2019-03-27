package fr.unedic.cali.dom;

public class Erreur
{
  public static final int NIVEAU_NON_DEFINI = 0;
  public static final int NIVEAU_INFO = 1;
  public static final int NIVEAU_ALERTE = 2;
  public static final int NIVEAU_BLOQUANT = 3;
  private int m_niveau;
  private String m_code;
  private String m_libelle;
  
  public Erreur()
  {
    m_niveau = 0;
  }
  
  public Erreur(int p_niveau, String p_code, String p_libelle)
  {
    setNiveau(p_niveau);
    setCode(p_code);
    setLibelle(p_libelle);
  }
  
  public String getCode()
  {
    return m_code;
  }
  
  public void setCode(String p_code)
  {
    m_code = p_code;
  }
  
  public String getLibelle()
  {
    return m_libelle;
  }
  
  public void setLibelle(String p_libelle)
  {
    m_libelle = p_libelle;
  }
  
  public int getNiveau()
  {
    return m_niveau;
  }
  
  public void setNiveau(int p_niveau)
  {
    m_niveau = p_niveau;
  }
  
  public static int niveauMax(int p_niveauUn, int p_niveauDeux)
  {
    if (p_niveauUn == 3) {
      return p_niveauUn;
    }
    if (p_niveauDeux == 3) {
      return p_niveauDeux;
    }
    if (p_niveauUn == 2) {
      return p_niveauUn;
    }
    if (p_niveauDeux == 2) {
      return p_niveauDeux;
    }
    if (p_niveauUn == 1) {
      return p_niveauUn;
    }
    if (p_niveauDeux == 1) {
      return p_niveauDeux;
    }
    return p_niveauUn;
  }
  
  public String toString()
  {
    StringBuffer buffer = new StringBuffer();
    
    buffer.append("[Niveau:");
    buffer.append(getNiveau());
    buffer.append("; Code:");
    buffer.append(getCode());
    buffer.append("; Libellé:");
    buffer.append(getLibelle());
    buffer.append("]");
    
    return buffer.toString();
  }
}

/* Location:
 * Qualified Name:     Erreur
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */