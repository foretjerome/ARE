package fr.unedic.cali.dom.spec;

import fr.unedic.cali.dom.DonneesEntreeDeterminationListePra;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import java.util.Collection;

public abstract interface ConstructionPRASpec
{
  public abstract Collection determinerListePraQuantiteAppartenance(DonneesEntreeDeterminationListePra paramDonneesEntreeDeterminationListePra)
    throws CoucheLogiqueException;
  
  public abstract PraSpec determinerPram(String paramString);
  
  public abstract PraSpec determinerPraPourDV(String paramString);
  
  public abstract PraSpec determinerPraCouvertureSuiteDV(String paramString);
  
  public abstract PraSpec determinerPraOppositionDV(String paramString, Damj paramDamj);
}

/* Location:
 * Qualified Name:     ConstructionPRASpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */