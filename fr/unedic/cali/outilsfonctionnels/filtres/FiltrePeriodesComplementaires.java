package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public abstract class FiltrePeriodesComplementaires
  implements FiltreTemporel
{
  private boolean m_filtreComplementaire;
  public static final boolean FILTRE_MODE_NORMAL = true;
  public static final boolean FILTRE_MODE_COMPLEMENTAIRE = false;
  
  protected FiltrePeriodesComplementaires(boolean p_filtreComplementaire)
  {
    m_filtreComplementaire = p_filtreComplementaire;
  }
  
  protected FiltrePeriodesComplementaires()
  {
    m_filtreComplementaire = true;
  }
  
  protected boolean getFiltreValorise(boolean p_valeurFiltre)
  {
    return !p_valeurFiltre ? true : m_filtreComplementaire ? p_valeurFiltre : false;
  }
  
  public abstract boolean accepter(Temporel paramTemporel);
}

/* Location:
 * Qualified Name:     FiltrePeriodesComplementaires
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */