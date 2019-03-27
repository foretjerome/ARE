package fr.unedic.cali.dom.spec;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.affectation.Reglement;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.Periode;

public abstract interface CalculAppartenanceSpec
{
  public abstract QuantitesAppartenanceSpec calculer(DemandeSpec paramDemandeSpec, Periode paramPeriode, Chronologie paramChronologie, Reglement paramReglement, ParametresCalculAppartenanceSpec paramParametresCalculAppartenanceSpec)
    throws ApplicativeException;
}

/* Location:
 * Qualified Name:     CalculAppartenanceSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */