package fr.pe.d12dal;

import fr.pe.d12dal.service.es.completude.CritereAjouterPieceJustificative;
import fr.pe.d12dal.service.es.completude.CritereSynchroniserCouleurDAL;
import fr.pe.d12dal.service.es.completude.RetourAjouterPieceJustificative;
import fr.pe.d12dal.service.es.completude.RetourSynchroniserCouleurDAL;
import fr.pe.d12dal.service.es.dal.CritereLireDALCALI;
import fr.pe.d12dal.service.es.dal.RetourLireDALCALI;
import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;

public abstract interface InterfaceFacadeDomaineD12DAL
{
  public abstract RetourLireDALCALI LireDALCALI(CritereLireDALCALI paramCritereLireDALCALI)
    throws ApplicativeException, TechniqueException;
  
  public abstract RetourAjouterPieceJustificative AjouterPieceJustificative(CritereAjouterPieceJustificative paramCritereAjouterPieceJustificative)
    throws ApplicativeException, TechniqueException;
  
  public abstract RetourSynchroniserCouleurDAL SynchroniserCouleurDAL(CritereSynchroniserCouleurDAL paramCritereSynchroniserCouleurDAL)
    throws ApplicativeException, TechniqueException;
}

/* Location:
 * Qualified Name:     InterfaceFacadeDomaineD12DAL
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */