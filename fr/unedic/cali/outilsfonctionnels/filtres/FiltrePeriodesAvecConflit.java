package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.spec.ConflitSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodesAvecConflit
  extends FiltrePeriodesComplementaires
  implements FiltreTemporel
{
  private DemandeSpec m_demande = null;
  
  public FiltrePeriodesAvecConflit() {}
  
  public FiltrePeriodesAvecConflit(DemandeSpec p_demande)
  {
    m_demande = p_demande;
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    boolean periodeEnConflit = (p_temporel.estType(ConflitSpec.class)) && (super.getFiltreValorise(((ConflitSpec)p_temporel).estEnConflit()));
    if ((periodeEnConflit) && (m_demande != null)) {
      m_demande.setLiquideeAvecConflits(true);
    }
    return periodeEnConflit;
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodesAvecConflit
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */