package fr.pe.cali.reglementaire.regles.assurance.cep.delaisreports.dom;

import fr.unedic.util.temps.Periode;
import java.util.List;

public class MoisCivilJustificationFranchiseCP
{
  private Periode moisCivil;
  private int nombreJoursTravailles;
  private int nombreJoursTravaillesRetenus;
  private List<DetailJoursTravaillesJustificationFranchiseCP> details;
  
  public Periode getMoisCivil()
  {
    return moisCivil;
  }
  
  public void setMoisCivil(Periode moisCivil)
  {
    this.moisCivil = moisCivil;
  }
  
  public int getNombreJoursTravailles()
  {
    return nombreJoursTravailles;
  }
  
  public void setNombreJoursTravailles(int nombreJoursTravailles)
  {
    this.nombreJoursTravailles = nombreJoursTravailles;
  }
  
  public int getNombreJoursTravaillesRetenus()
  {
    return nombreJoursTravaillesRetenus;
  }
  
  public void setNombreJoursTravaillesRetenus(int nombreJoursTravaillesRetenus)
  {
    this.nombreJoursTravaillesRetenus = nombreJoursTravaillesRetenus;
  }
  
  public List<DetailJoursTravaillesJustificationFranchiseCP> getDetails()
  {
    return details;
  }
  
  public void setDetails(List<DetailJoursTravaillesJustificationFranchiseCP> details)
  {
    this.details = details;
  }
}

/* Location:
 * Qualified Name:     MoisCivilJustificationFranchiseCP
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */