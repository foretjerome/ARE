package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.cali.dom.DemandeSpec;

public class ComparateurSurDateDeclenchementDemandeDecroissante
  extends ComparateurSurDateDeclenchementEtPrioriteDemande
{
  private static final long serialVersionUID = 1L;
  
  public int compare(DemandeSpec arg0, DemandeSpec arg1)
  {
    return -super.compare(arg0, arg1);
  }
}

/* Location:
 * Qualified Name:     ComparateurSurDateDeclenchementDemandeDecroissante
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */