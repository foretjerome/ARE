package fr.unedic.cali.dom;

import fr.unedic.cali.dom.gen.EntretienGen;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;

public class Entretien
  extends EntretienGen
  implements ObjetPersistantSpec
{
  private static final long serialVersionUID = 2390266344207567297L;
  
  public Entretien(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public Entretien() {}
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    Entretien copie = (Entretien)p_copie;
    copie.setAExerceActiviteSalarie(isAExerceActiviteSalarie());
    copie.setASuiviFormation(isASuiviFormation());
    copie.setDateCessationInscription(getDateCessationInscription());
    copie.setDateDebutPra(getDateDebutPra());
    copie.setDateFinContrat(getDateFinContrat());
    copie.setDateFinPra(getDateFinPra());
    copie.setQuantiteAffiliation(getQuantiteAffiliation());
  }
  
  public String getIdentifiant()
  {
    return DomManager.getIdentifiant(this);
  }
  
  public void marquerGraphePersistant() {}
  
  public ObjetMetierSpec copie()
  {
    Entretien copie = new Entretien();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     Entretien
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */