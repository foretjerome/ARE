package fr.unedic.cali.outilsfonctionnels;

public class ComparateurSurDateAttributionEtPrioriteDemandeDecroissante
  extends ComparateurSurDateAttributionEtPrioriteDemande
{
  public int compare(Object p_arg0, Object p_arg1)
  {
    return -super.compare(p_arg0, p_arg1);
  }
}

/* Location:
 * Qualified Name:     ComparateurSurDateAttributionEtPrioriteDemandeDecroissante
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */