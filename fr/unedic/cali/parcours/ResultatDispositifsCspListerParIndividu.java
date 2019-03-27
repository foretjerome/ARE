package fr.unedic.cali.parcours;

import fr.unedic.cali.calcul.pbjc.dom.DispositifNcp;
import fr.unedic.util.services.Resultat;
import java.util.List;

public class ResultatDispositifsCspListerParIndividu
  extends Resultat
{
  private static final long serialVersionUID = 271544412937269923L;
  private List<DispositifNcp> listeDispositifsCsp;
  
  public List<DispositifNcp> getListeDispositifsNcp()
  {
    return listeDispositifsCsp;
  }
  
  public void setListeDispositifsCsp(List<DispositifNcp> listeDispositifsCsp)
  {
    this.listeDispositifsCsp = listeDispositifsCsp;
  }
}

/* Location:
 * Qualified Name:     ResultatDispositifsCspListerParIndividu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */