package fr.unedic.cali.dom;

import fr.unedic.cali.dom.persistance.util.DomManager;

public class IndividuPersistant
  extends Individu
{
  public IndividuPersistant()
  {
    super(new IndividuId());
  }
  
  public IndividuPersistant(IndividuIdSpec id)
  {
    super(id);
  }
  
  public void fabricationIndividu(IndividuIdSpec identifiant)
  {
    individuGA = new fr.unedic.cali.autresdoms.ga.dom.IndividuImplPersistant(identifiant);
    
    individuCohab = new fr.unedic.cali.autresdoms.cohab.dom.IndividuImplPersistant(identifiant);
    
    individuInstruction = new fr.unedic.cali.autresdoms.d12i.dom.IndividuImplPersistant(identifiant);
    
    individuCali = new IndividuImplPersistant(identifiant);
    
    setIndividuId(identifiant);
  }
  
  public void fabricationIndividu(IndividuCaliAbstrait pIndividuCali)
  {
    IndividuIdSpec pIdentifiant = pIndividuCali.getIndividuId();
    
    individuGA = new fr.unedic.cali.autresdoms.ga.dom.IndividuImplPersistant(pIdentifiant);
    
    individuCohab = new fr.unedic.cali.autresdoms.cohab.dom.IndividuImplPersistant(pIdentifiant);
    
    individuInstruction = new fr.unedic.cali.autresdoms.d12i.dom.IndividuImplPersistant(pIdentifiant);
    
    individuCali = pIndividuCali;
    
    setIndividuId(pIdentifiant);
  }
  
  public void finiTraitement()
  {
    if ((individuCali instanceof ObjetPersistantSpec))
    {
      DomManager.persisterEnProfondeur((ObjetPersistantSpec)individuCali);
      setEstDejaCree(true);
    }
  }
  
  public void supprimer()
  {
    if ((individuCali instanceof ObjetPersistantSpec))
    {
      DomManager.supprimerAbsolument((ObjetPersistantSpec)individuCali);
      setEstDejaCree(false);
    }
  }
  
  protected boolean isPersistant()
  {
    return true;
  }
  
  public boolean isInvestigationFraude()
  {
    return ((IndividuImplPersistant)individuCali).isInvestigationFraude();
  }
  
  public void setInvestigationFraude(boolean pInvestigationFraude)
  {
    ((IndividuImplPersistant)individuCali).setInvestigationFraude(pInvestigationFraude);
  }
  
  public void marquerGraphePersistance()
  {
    ((IndividuImplPersistant)individuCali).marquerGraphePersistant();
  }
  
  public boolean isEstAbonneGaec()
  {
    return ((IndividuImplPersistant)individuCali).isEstAbonneGaec();
  }
  
  public void setEstAbonneGaec(boolean estAbonneGaec)
  {
    ((IndividuImplPersistant)individuCali).setEstAbonneGaec(estAbonneGaec);
  }
}

/* Location:
 * Qualified Name:     IndividuPersistant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */