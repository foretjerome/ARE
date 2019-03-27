package fr.unedic.cali.dom;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.cohab.sigma.demande.dom.spec.DemandeSpec;
import fr.unedic.cali.autresdoms.d12i.dom.DemandeInstruction;
import fr.unedic.cali.autresdoms.d12i.dom.IndividuInstructionAbstrait;
import fr.unedic.util.services.CoucheLogiqueException;

public class IndividuNonPersistant
  extends Individu
{
  private transient boolean investigationFraude;
  private transient boolean estAbonneGaec;
  
  public IndividuNonPersistant()
  {
    super(new IndividuId());
  }
  
  public IndividuNonPersistant(IndividuIdSpec id)
  {
    super(id);
  }
  
  public void fabricationIndividu(IndividuIdSpec identifiant)
  {
    individuGA = new fr.unedic.cali.autresdoms.ga.dom.IndividuImplNonPersistant(identifiant);
    
    individuCohab = new fr.unedic.cali.autresdoms.cohab.dom.IndividuImplNonPersistant(identifiant);
    
    individuInstruction = new fr.unedic.cali.autresdoms.d12i.dom.IndividuImplNonPersistant(identifiant);
    
    individuCali = new IndividuImplNonPersistant(identifiant);
    
    setIndividuId(identifiant);
  }
  
  public void finiTraitement()
  {
    throw new UnsupportedOperationException();
  }
  
  public void supprimer()
  {
    throw new UnsupportedOperationException();
  }
  
  protected boolean isPersistant()
  {
    return false;
  }
  
  public boolean isInvestigationFraude()
  {
    return investigationFraude;
  }
  
  public void setInvestigationFraude(boolean pInvestigationFraude)
  {
    investigationFraude = pInvestigationFraude;
  }
  
  public void marquerGraphePersistance() {}
  
  public boolean isEstAbonneGaec()
  {
    return estAbonneGaec;
  }
  
  public void setEstAbonneGaec(boolean pEstAbonneGaec)
  {
    estAbonneGaec = pEstAbonneGaec;
  }
  
  public void ajouterDemandeInstruction(String referenceExterne, DemandeInstruction demande)
  {
    individuInstruction.ajouterDonneesDAL(referenceExterne, demande);
  }
  
  public void ajouterDemandeV1(DemandeSpec demande, String typeDemande)
  {
    ((fr.unedic.cali.autresdoms.cohab.dom.IndividuImplNonPersistant)individuCohab).ajouterDemandeV1(demande, typeDemande);
  }
  
  public void activerModeSansRebond()
  {
    ((fr.unedic.cali.autresdoms.ga.dom.IndividuImplNonPersistant)individuGA).setSansRebond(true);
    ((fr.unedic.cali.autresdoms.cohab.dom.IndividuImplNonPersistant)individuCohab).setSansRebond(true);
    ((fr.unedic.cali.autresdoms.d12i.dom.IndividuImplNonPersistant)individuInstruction).setSansRebond(true);
    
    ((fr.unedic.cali.autresdoms.ga.dom.IndividuImplNonPersistant)individuGA).setEstCharge(false);
    ((fr.unedic.cali.autresdoms.cohab.dom.IndividuImplNonPersistant)individuCohab).setEstCharge(false);
    ((fr.unedic.cali.autresdoms.d12i.dom.IndividuImplNonPersistant)individuInstruction).setEstCharge(false);
  }
  
  public void chargerIndividuGaec()
    throws ApplicativeException, TechniqueException
  {
    if (((fr.unedic.cali.autresdoms.ga.dom.IndividuImplNonPersistant)individuGA).isSansRebond()) {
      throw new CoucheLogiqueException("Chargement Gaec !");
    }
    super.chargerIndividuGaec();
  }
  
  public void chargerIndividuGaecReduit()
    throws ApplicativeException, TechniqueException
  {
    if (((fr.unedic.cali.autresdoms.ga.dom.IndividuImplNonPersistant)individuGA).isSansRebond()) {
      throw new CoucheLogiqueException("Chargement GaecReduit !");
    }
    super.chargerIndividuGaecReduit();
  }
  
  public void chargerIndividuCohab()
    throws ApplicativeException, TechniqueException
  {
    if (((fr.unedic.cali.autresdoms.cohab.dom.IndividuImplNonPersistant)individuCohab).isSansRebond()) {
      throw new CoucheLogiqueException("Chargement Cohab !");
    }
    super.chargerIndividuCohab();
  }
  
  public void chargerIndividuInstruction()
    throws ApplicativeException, TechniqueException
  {
    throw new UnsupportedOperationException("on ne charge plus Instruction en totalité");
  }
}

/* Location:
 * Qualified Name:     IndividuNonPersistant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */