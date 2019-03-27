package fr.pe.d12dal;

import fr.pe.d12dal.service.es.completude.CritereAjouterPieceJustificative;
import fr.pe.d12dal.service.es.completude.CritereSynchroniserCouleurDAL;
import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;

public abstract interface DomaineD12DALServiceAsync
{
  public abstract void AjouterPieceJustificative(CritereAjouterPieceJustificative paramCritereAjouterPieceJustificative)
    throws ApplicativeException, TechniqueException;
  
  public abstract void SynchroniserCouleurDAL(CritereSynchroniserCouleurDAL paramCritereSynchroniserCouleurDAL)
    throws ApplicativeException, TechniqueException;
}

/* Location:
 * Qualified Name:     DomaineD12DALServiceAsync
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */