package fr.pe.cali.reglementaire.regles.assurance.cep.delaisreports.dom;

import fr.unedic.util.temps.Periode;
import java.util.List;

public class JustificationFranchiseCP
{
  private String formuleUtilisee;
  private Periode periodeCalculFranchiseCp;
  private int nombreJoursTravaillesRetenusDansPra;
  private List<MoisCivilJustificationFranchiseCP> listeMoisCivils;
  
  public String getFormuleUtilisee()
  {
    return formuleUtilisee;
  }
  
  public void setFormuleUtilisee(String formuleUtilisee)
  {
    this.formuleUtilisee = formuleUtilisee;
  }
  
  public Periode getPeriodeCalculFranchiseCp()
  {
    return periodeCalculFranchiseCp;
  }
  
  public void setPeriodeCalculFranchiseCp(Periode periodeCalculFranchiseCp)
  {
    this.periodeCalculFranchiseCp = periodeCalculFranchiseCp;
  }
  
  public int getNombreJoursTravaillesRetenusDansPra()
  {
    return nombreJoursTravaillesRetenusDansPra;
  }
  
  public void setNombreJoursTravaillesRetenusDansPra(int nombreJoursTravaillesRetenusDansPra)
  {
    this.nombreJoursTravaillesRetenusDansPra = nombreJoursTravaillesRetenusDansPra;
  }
  
  public List<MoisCivilJustificationFranchiseCP> getListeMoisCivils()
  {
    return listeMoisCivils;
  }
  
  public void setListeMoisCivils(List<MoisCivilJustificationFranchiseCP> listeMoisCivils)
  {
    this.listeMoisCivils = listeMoisCivils;
  }
}

/* Location:
 * Qualified Name:     JustificationFranchiseCP
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */