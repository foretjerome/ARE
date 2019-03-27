package fr.unedic.cali.calcul.dom;

import fr.unedic.cali.calcul.dom.gen.EtatAuDernierJourAvantGen;
import fr.unedic.cali.dom.ObjetPersistantSpec;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.temps.Periode;

public class EtatAuDernierJourAvant
  extends EtatAuDernierJourAvantGen
  implements ObjetMetierSpec, ObjetPersistantSpec
{
  private static final long serialVersionUID = 1L;
  
  public EtatAuDernierJourAvant() {}
  
  public EtatAuDernierJourAvant(DomPCSpec pc)
  {
    super(pc);
  }
  
  public EtatAuDernierJourAvant(UniteTraitementAvant utAvant, int etat, Periode periodePECEvenementsReducteurs)
  {
    DureeConsommableAvant reliquatDureePmc = utAvant.getDureePmcEnFinUT();
    DureeConsommableAvant reliquatDureeDiffereStandard = utAvant.getDureeDiffereStandardEnFinUT();
    DureeConsommableAvant reliquatDureeDiffereSpecifique = utAvant.getDureeDiffereSpecifiqueEnFinUT();
    DureeConsommableAvant reliquatDureeDelaiAttente = utAvant.getDureeDelaiAttenteEnFinUT();
    DureeConsommableAvant reliquatDureeFranchiseCP = utAvant.getDureeFranchiseCPEnFinUT();
    DureeConsommableAvant reliquatDureeFranchiseSalaire = utAvant.getDureeFranchiseSalaireEnFinUT();
    
    setReliquatCP(recupererReliquatCarence(reliquatDureeFranchiseCP));
    setReliquatSalaire(recupererReliquatCarence(reliquatDureeFranchiseSalaire));
    setReliquatPMC(recupererReliquatCarence(reliquatDureePmc));
    setReliquatICCP(recupererReliquatCarence(reliquatDureeDiffereStandard));
    setReliquatISLR(recupererReliquatCarence(reliquatDureeDiffereSpecifique));
    setReliquatDelaiAttente(recupererReliquatCarence(reliquatDureeDelaiAttente));
    if ((reliquatDureeDelaiAttente != null) && (reliquatDureeDelaiAttente.getEtat() != 0)) {
      setDelaiAttenteEntame(true);
    }
    setEtat(etat);
    
    setDureeInitialeCP(recupererDureeInitialeCarence(reliquatDureeFranchiseCP));
    setDureeInitialeSalaire(recupererDureeInitialeCarence(reliquatDureeFranchiseSalaire));
    setDureeInitialePMC(recupererDureeInitialeCarence(reliquatDureePmc));
    setDureeInitialeICCP(recupererDureeInitialeCarence(reliquatDureeDiffereStandard));
    setDureeInitialeISLR(recupererDureeInitialeCarence(reliquatDureeDiffereSpecifique));
    setDureeInitialeDelaiAttente(recupererDureeInitialeCarence(reliquatDureeDelaiAttente));
    
    setPeriodeApplicationCP(recupererPeriodeApplicationCarence(reliquatDureeFranchiseCP));
    setPeriodeApplicationSalaire(recupererPeriodeApplicationCarence(reliquatDureeFranchiseSalaire));
    setPeriodeApplicationPMC(recupererPeriodeApplicationCarence(reliquatDureePmc));
    setPeriodeApplicationICCP(recupererPeriodeApplicationCarence(reliquatDureeDiffereStandard));
    setPeriodeApplicationISLR(recupererPeriodeApplicationCarence(reliquatDureeDiffereSpecifique));
    setPeriodeApplicationDelaiAttente(recupererPeriodeApplicationCarence(reliquatDureeDelaiAttente));
    setPeriodePECEvenementReducteur(periodePECEvenementsReducteurs);
  }
  
  public ObjetMetierSpec copie()
  {
    EtatAuDernierJourAvant copie = new EtatAuDernierJourAvant();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec pcopie)
  {
    EtatAuDernierJourAvant copie = (EtatAuDernierJourAvant)pcopie;
    copie.setEtat(getEtat());
    copie.setDelaiAttenteEntame(isDelaiAttenteEntame());
    copie.setReliquatDelaiAttente(getReliquatDelaiAttente());
    copie.setReliquatICCP(getReliquatICCP());
    copie.setReliquatISLR(getReliquatISLR());
    copie.setReliquatPMC(getReliquatPMC());
    copie.setReliquatCP(getReliquatCP());
    copie.setReliquatSalaire(getReliquatSalaire());
    copie.setPeriodeApplicationCP(getPeriodeApplicationCP());
    copie.setPeriodeApplicationSalaire(getPeriodeApplicationSalaire());
    copie.setPeriodeApplicationPMC(getPeriodeApplicationPMC());
    copie.setPeriodeApplicationICCP(getPeriodeApplicationICCP());
    copie.setPeriodeApplicationISLR(getPeriodeApplicationISLR());
    copie.setPeriodeApplicationDelaiAttente(getPeriodeApplicationDelaiAttente());
    copie.setDureeInitialeCP(getDureeInitialeCP());
    copie.setDureeInitialeSalaire(getDureeInitialeSalaire());
    copie.setDureeInitialePMC(getDureeInitialePMC());
    copie.setDureeInitialeICCP(getDureeInitialeICCP());
    copie.setDureeInitialeISLR(getDureeInitialeISLR());
    copie.setDureeInitialeDelaiAttente(getDureeInitialeDelaiAttente());
  }
  
  private Integer recupererReliquatCarence(DureeConsommableAvant dureeConsommableAvant)
  {
    Integer reliquat = null;
    if (dureeConsommableAvant != null) {
      switch (dureeConsommableAvant.getEtat())
      {
      case 0: 
        if ((dureeConsommableAvant.getQuantiteInitial() != null) && (dureeConsommableAvant.getQuantiteInitial().getValeurEntiere() > 0)) {
          reliquat = Integer.valueOf(dureeConsommableAvant.getQuantiteInitial().getValeurEntiere());
        }
        break;
      case 1: 
      case 2: 
        if ((dureeConsommableAvant.getQuantiteInitial() != null) && (dureeConsommableAvant.getQuantiteInitial().getValeurEntiere() > 0)) {
          reliquat = Integer.valueOf(dureeConsommableAvant.getQuantiteCourante().getValeurEntiere());
        }
        break;
      }
    }
    return reliquat;
  }
  
  public String getIdentifiant()
  {
    return DomManager.getIdentifiant(this);
  }
  
  public void marquerGraphePersistant() {}
  
  private Periode recupererPeriodeApplicationCarence(DureeConsommableAvant dureeConsommableAvant)
  {
    Periode periodeApplicationCarence = null;
    if (dureeConsommableAvant != null) {
      periodeApplicationCarence = dureeConsommableAvant.getPeriodeApplicationCarence();
    }
    return periodeApplicationCarence;
  }
  
  private Integer recupererDureeInitialeCarence(DureeConsommableAvant dureeConsommableAvant)
  {
    Integer dureeInitialeCarence = null;
    if ((dureeConsommableAvant != null) && (dureeConsommableAvant.getQuantiteInitial() != null) && (dureeConsommableAvant.getQuantiteInitial().getValeurEntiere() > 0)) {
      dureeInitialeCarence = Integer.valueOf(dureeConsommableAvant.getQuantiteInitial().getValeurEntiere());
    }
    return dureeInitialeCarence;
  }
}

/* Location:
 * Qualified Name:     EtatAuDernierJourAvant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */