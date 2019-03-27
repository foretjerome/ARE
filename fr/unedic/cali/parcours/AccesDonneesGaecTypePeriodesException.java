package fr.unedic.cali.parcours;

public class AccesDonneesGaecTypePeriodesException
  extends AccesDonneesGaecException
{
  private static final long serialVersionUID = -3282562990025557236L;
  
  public AccesDonneesGaecTypePeriodesException(String p_codeErreur)
  {
    super(p_codeErreur);
  }
  
  public AccesDonneesGaecTypePeriodesException(String p_codeErreur, String p_libelle)
  {
    super(p_codeErreur, p_libelle);
  }
  
  public AccesDonneesGaecTypePeriodesException(String p_codeErreur, Throwable p_origine)
  {
    super(p_codeErreur, p_origine);
  }
  
  public AccesDonneesGaecTypePeriodesException(String p_codeErreur, String p_libelle, Throwable p_origine)
  {
    super(p_codeErreur, p_libelle, p_origine);
  }
}

/* Location:
 * Qualified Name:     AccesDonneesGaecTypePeriodesException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */