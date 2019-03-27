package fr.unedic.cali.parcours;

public class AccesDonneesGaecDnjException
  extends AccesDonneesGaecException
{
  private static final long serialVersionUID = 5663380984137622374L;
  
  public AccesDonneesGaecDnjException(String p_codeErreur)
  {
    super(p_codeErreur);
  }
  
  public AccesDonneesGaecDnjException(String p_codeErreur, String p_libelle)
  {
    super(p_codeErreur, p_libelle);
  }
  
  public AccesDonneesGaecDnjException(String p_codeErreur, Throwable p_origine)
  {
    super(p_codeErreur, p_origine);
  }
  
  public AccesDonneesGaecDnjException(String p_codeErreur, String p_libelle, Throwable p_origine)
  {
    super(p_codeErreur, p_libelle, p_origine);
  }
}

/* Location:
 * Qualified Name:     AccesDonneesGaecDnjException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */