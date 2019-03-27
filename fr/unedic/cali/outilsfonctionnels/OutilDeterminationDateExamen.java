package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.EvenementReferenceExamenSpec;
import fr.unedic.util.temps.Damj;

public class OutilDeterminationDateExamen
{
  public static OutilDeterminationDateExamen getInstance()
  {
    return new OutilDeterminationDateExamen();
  }
  
  public Damj determinerDateExamen(DemandeSpec p_demande)
    throws ApplicativeException
  {
    EvenementReferenceExamenSpec ere = p_demande.getEvenementReferenceExamen();
    
    ere.setDateEvenement(null);
    
    return ere.getDateExamen(p_demande);
  }
}

/* Location:
 * Qualified Name:     OutilDeterminationDateExamen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */