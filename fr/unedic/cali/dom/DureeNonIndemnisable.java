package fr.unedic.cali.dom;

import fr.unedic.cali.dom.gen.DureeNonIndemnisableGen;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.QuantiteJour;
import fr.unedic.util.Unite;
import fr.unedic.util.temps.UniteDuree;
import java.math.BigDecimal;

public class DureeNonIndemnisable
  extends DureeNonIndemnisableGen
{
  private static final long serialVersionUID = 1L;
  private transient Quantite rythmeConsomation;
  private transient Quantite quantiteRestanteAConsommeSurMois;
  public static final Unite UNITE_DEFAUT = UniteDuree.JOUR;
  
  public DureeNonIndemnisable() {}
  
  public DureeNonIndemnisable(DomPCSpec pc)
  {
    super(pc);
  }
  
  public DureeNonIndemnisable(int quantiteInitial)
  {
    setQuantiteInitial(new Quantite(new BigDecimal(Integer.toString(quantiteInitial)), UNITE_DEFAUT));
    setQuantiteCourante(new Quantite(BigDecimal.ZERO, UNITE_DEFAUT));
  }
  
  public void setRythmeConsomation(Quantite rythmeConsomation)
  {
    this.rythmeConsomation = rythmeConsomation;
  }
  
  public Quantite getRythmeConsomation()
  {
    return rythmeConsomation;
  }
  
  public ImputationSpec simulerImputer(Quantite quantite)
  {
    return null;
  }
  
  public ObjetMetierSpec copie()
  {
    DureeNonIndemnisable copie = new DureeNonIndemnisable();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec pcopie)
  {
    DureeNonIndemnisable copie = (DureeNonIndemnisable)pcopie;
    super.copieElements(copie);
    copie.setRythmeConsomation(getRythmeConsomation());
    copie.setQuantiteRestanteAConsommeSurMois(getQuantiteRestanteAConsommeSurMois());
    copie.setReliquat(getReliquat());
    copie.setReliquatMaxMois(getReliquatMaxMois());
    copie.setType(getType());
    copie.setPeriodeDA(getPeriodeDA());
  }
  
  public Quantite getQuantiteRestanteAConsommeSurMois()
  {
    return quantiteRestanteAConsommeSurMois;
  }
  
  public void setQuantiteRestanteAConsommeSurMois(Quantite quantiteRestanteAConsommeSurMois)
  {
    this.quantiteRestanteAConsommeSurMois = quantiteRestanteAConsommeSurMois;
  }
  
  public void imputerQuantite(Quantite quantite)
  {
    if (getEtat() == 1)
    {
      Quantite quantiteMaxAImputer = getQuantiteCourante().min(quantite).max(new QuantiteJour(BigDecimal.ZERO));
      imputer(quantiteMaxAImputer);
    }
    if (getQuantiteCourante().getValeur().compareTo(BigDecimal.ZERO) == 0) {
      epuiser();
    }
  }
}

/* Location:
 * Qualified Name:     DureeNonIndemnisable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */