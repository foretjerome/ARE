package fr.unedic.cali.dom;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.cohab.dom.IndividuCohabAbstrait;
import fr.unedic.cali.autresdoms.ga.dom.IndividuGaecAbstrait;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.outilsfonctionnels.ReductionAppelGaec;
import fr.unedic.util.services.ContexteService;
import java.util.Collection;
import java.util.Iterator;

public abstract class Individu
  extends IndividuAbstrait
{
  private boolean mCriteresQualificationPositionnes = false;
  
  protected Individu(IndividuIdSpec id)
  {
    super(id);
  }
  
  protected Individu() {}
  
  public static IndividuSpec getIndividu(boolean persistance, IndividuIdSpec id)
  {
    IndividuSpec individu = null;
    if (persistance)
    {
      IndividuIdSpec idIndividu;
      if (id == null)
      {
        IndividuIdSpec idIndividu = new IndividuId();
        individu = new IndividuPersistant(idIndividu);
      }
      else
      {
        idIndividu = id;
        individu = new IndividuPersistant(idIndividu);
      }
      ((IndividuPersistant)individu).fabricationIndividu(idIndividu);
    }
    else
    {
      if (id == null) {
        individu = new IndividuNonPersistant();
      } else {
        individu = new IndividuNonPersistant(id);
      }
      ((IndividuNonPersistant)individu).fabricationIndividu(id);
    }
    return individu;
  }
  
  public void chargerIndividuCali()
    throws ApplicativeException, TechniqueException
  {
    individuCali = ((IndividuCaliAbstrait)individuCali.charger());
    
    individuCali.setIndividuId(getIndividuId());
    
    Collection<?> collectionDemandes = getDemandes();
    Iterator<?> iterDemande = collectionDemandes.iterator();
    while (iterDemande.hasNext())
    {
      DemandeSpec demande = (DemandeSpec)iterDemande.next();
      demande.setDemandeur(this);
      demande.getGamme().initialiserDemandeAssociee(this, demande);
    }
    Collection<?> listeLA2K = individuCali.getListeLA2K();
    listeLA2K.clear();
    
    setEstDejaCree(individuCali.estDejaCree());
  }
  
  public void chargerIndividuGaec()
    throws ApplicativeException, TechniqueException
  {
    individuGA = ((IndividuGaecAbstrait)individuGA.charger());
  }
  
  public void chargerIndividuGaecReduit()
    throws ApplicativeException, TechniqueException
  {
    AppelGaecReduit appelGaecReduit = ReductionAppelGaec.reduireAppelGaec(this);
    individuGA = ((IndividuGaecAbstrait)individuGA.charger(appelGaecReduit));
  }
  
  public void chargerIndividuCohab()
    throws ApplicativeException, TechniqueException
  {
    individuCohab = ((IndividuCohabAbstrait)individuCohab.charger());
  }
  
  public void chargerIndividuInstruction()
    throws ApplicativeException, TechniqueException
  {
    throw new UnsupportedOperationException("On ne doit plus charger Instruction complémentement");
  }
  
  public static Individu verifierExistenceIndividu(IndividuSpec individu, boolean lectureForcee, ContexteService contexteService)
  {
    throw new UnsupportedOperationException("Passez plutot par la méthode ChargerIndividuCali ! ");
  }
  
  public abstract void fabricationIndividu(IndividuIdSpec paramIndividuIdSpec);
  
  protected abstract boolean isPersistant();
  
  public boolean isCriteresQualificationPositionnes()
  {
    return mCriteresQualificationPositionnes;
  }
  
  public void setCriteresQualificationPositionnes(boolean pCriteresQualificationPositionnes)
  {
    mCriteresQualificationPositionnes = pCriteresQualificationPositionnes;
  }
}

/* Location:
 * Qualified Name:     Individu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */