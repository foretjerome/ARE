package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import java.util.List;
import java.util.Map;

public abstract interface ParcoursMigrationCalculPilotageSpec
{
  public static final int TYPE_POST_TRAITEMENT_MIGRATION_CALCUL = 1;
  
  public abstract int getTypeDePostTraitement();
  
  public abstract void setTypeDePostTraitement(int paramInt);
  
  public abstract void preTraitement(DomCalculPilotage paramDomCalculPilotage, Damj paramDamj1, Damj paramDamj2)
    throws CoucheLogiqueException;
  
  public abstract ResultatPilotage postTraitement(List paramList, Map paramMap, DomCalculPilotage paramDomCalculPilotage, Damj paramDamj1, Damj paramDamj2)
    throws ApplicativeException;
}

/* Location:
 * Qualified Name:     ParcoursMigrationCalculPilotageSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */