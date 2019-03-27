package fr.unedic.cali.parcours;

public class AccesDonneesGaecModeAppelException
  extends AccesDonneesGaecException
{
  private static final long serialVersionUID = -5119188056326150696L;
  
  public AccesDonneesGaecModeAppelException(String p_codeErreur)
  {
    super(p_codeErreur);
  }
  
  public AccesDonneesGaecModeAppelException(String p_codeErreur, String p_libelle)
  {
    super(p_codeErreur, p_libelle);
  }
  
  public AccesDonneesGaecModeAppelException(String p_codeErreur, Throwable p_origine)
  {
    super(p_codeErreur, p_origine);
  }
  
  public AccesDonneesGaecModeAppelException(String p_codeErreur, String p_libelle, Throwable p_origine)
  {
    super(p_codeErreur, p_libelle, p_origine);
  }
}

/* Location:
 * Qualified Name:     AccesDonneesGaecModeAppelException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */