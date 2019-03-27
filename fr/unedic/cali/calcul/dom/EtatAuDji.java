package fr.unedic.cali.calcul.dom;

import fr.unedic.cali.calcul.dom.gen.EtatAuDjiGen;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeDispositifSpec;
import fr.unedic.cali.dom.MontantBaseAbstrait;
import fr.unedic.cali.dom.ObjetPersistantSpec;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.Quantite;
import java.math.BigDecimal;

public class EtatAuDji
  extends EtatAuDjiGen
  implements ObjetMetierSpec, ObjetPersistantSpec, EtatAuDjiSpec
{
  private static final long serialVersionUID = 428354114401443602L;
  
  public EtatAuDji() {}
  
  public EtatAuDji(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public ObjetMetierSpec copie()
  {
    EtatAuDji copie = new EtatAuDji();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    EtatAuDji copie = (EtatAuDji)p_copie;
    copie.setMontant(getMontant());
    copie.setEstFigee(isEstFigee());
    copie.setCumulNbJourAct(getCumulNbJourAct());
  }
  
  public String getIdentifiant()
  {
    return DomManager.getIdentifiant(this);
  }
  
  public void marquerGraphePersistant()
  {
    DomManager.persisterEnProfondeur(super.getMontant());
  }
  
  public void jdoPreClear() {}
  
  public void jdoPreDelete()
  {
    DomManager.supprimer(super.getMontant());
  }
  
  public void jdoPostLoad() {}
  
  public void jdoPreStore() {}
  
  public int getCumulHeuresActiviteReduite()
  {
    return 0;
  }
  
  public int getCumulMoisActiviteReduite()
  {
    return 0;
  }
  
  public Quantite getReliquatDureeIndemnisation()
  {
    return null;
  }
  
  public void setCumulHeuresActiviteReduite(int p_cumulHeuresActiviteReduite) {}
  
  public void setCumulMoisActiviteReduite(int p_cumulMoisActiviteReduite) {}
  
  public void setReliquatDureeIndemnisation(Quantite p_reliquatDureeIndemnisation) {}
  
  public int getNbJourAREF()
  {
    return 0;
  }
  
  public void setNbJourAREF(int p_nbJourAREF) {}
  
  public Quantite getReliquatDureeProlongation()
  {
    return null;
  }
  
  public void setReliquatDureeProlongation(Quantite p_reliquatDureeProlongation) {}
  
  public Quantite getReliquatDureeRenouvellement()
  {
    return null;
  }
  
  public void setReliquatDureeRenouvellement(Quantite p_reliquatDureeRenouvellement) {}
  
  public int getNbMoisInactivite()
  {
    return 0;
  }
  
  public void setNbMoisInactivite(int p_nbMoisInactivite) {}
  
  public BigDecimal getCapitalVerse()
  {
    return new BigDecimal(0);
  }
  
  public ObjetChronoPeriodeDispositifSpec getPeriodeDispositifSpec()
  {
    return null;
  }
  
  public void setPeriodeDispositifSpec(ObjetChronoPeriodeDispositifSpec p_periodeDispositif) {}
  
  public void setCapitalVerse(BigDecimal p_capitalVerse) {}
  
  public boolean getEstEnAttenteRenouvellement()
  {
    return false;
  }
  
  public void setEstEnAttenteRenouvellement(boolean p_attente) {}
  
  public Quantite getReliquatDureeIndemnisationAvecMaintien()
  {
    return null;
  }
  
  public void setReliquatDureeIndemnisationAvecMaintien(Quantite p_reliquatDureeIndemnisationAvecMaintien) {}
  
  public int getNbMoisIndemniseAsu()
  {
    return 0;
  }
  
  public void setNbMoisIndemniseAsu(int p_nbMoisIndemniseAsu) {}
  
  public Quantite getCapitalADR()
  {
    return null;
  }
  
  public void setCapitalADR(Quantite p_capitalADR) {}
  
  public boolean isEstNbMoisIndemniseAsu()
  {
    return false;
  }
  
  public void setEstNbMoisIndemniseAsu(boolean p_estNbMoisIndemniseAsu) {}
  
  public Quantite getReliquatDureeFinancement()
  {
    return null;
  }
  
  public void setReliquatDureeFinancement(Quantite p_quantite) {}
  
  public int getCumulJoursAR()
  {
    return 0;
  }
  
  public void setCumulJoursAR(int p_cumulJoursActiviteReduite) {}
  
  public EtatAuDji dupliquer()
  {
    return null;
  }
  
  public void setMontant(MontantBaseAbstrait montant)
  {
    DomManager.supprimer(super.getMontant(), montant);
    super.setMontant(montant);
  }
}

/* Location:
 * Qualified Name:     EtatAuDji
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */