package fr.pe.cali.reglementaire.regles.assurance.cep.delaisreports.dom;

import fr.unedic.util.temps.Periode;

public class EtatDifferePrecedent
{
  private boolean differePrecedentEntame;
  private Periode periodeApplicationDiffere;
  
  public boolean isDifferePrecedentEntame()
  {
    return differePrecedentEntame;
  }
  
  public void setDifferePrecedentEntame(boolean differePrecedentEntame)
  {
    this.differePrecedentEntame = differePrecedentEntame;
  }
  
  public Periode getPeriodeApplicationDiffere()
  {
    return periodeApplicationDiffere;
  }
  
  public void setPeriodeApplicationDiffere(Periode periodeApplicationDiffere)
  {
    this.periodeApplicationDiffere = periodeApplicationDiffere;
  }
}

/* Location:
 * Qualified Name:     EtatDifferePrecedent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */