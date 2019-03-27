package fr.unedic.cali.parcours;

public class AccesDonneesGaecFenetrageException
  extends AccesDonneesGaecException
{
  private static final long serialVersionUID = -3282562990025557236L;
  
  public AccesDonneesGaecFenetrageException(String p_codeErreur)
  {
    super(p_codeErreur);
  }
  
  public AccesDonneesGaecFenetrageException(String p_codeErreur, String p_libelle)
  {
    super(p_codeErreur, p_libelle);
  }
  
  public AccesDonneesGaecFenetrageException(String p_codeErreur, Throwable p_origine)
  {
    super(p_codeErreur, p_origine);
  }
  
  public AccesDonneesGaecFenetrageException(String p_codeErreur, String p_libelle, Throwable p_origine)
  {
    super(p_codeErreur, p_libelle, p_origine);
  }
  
  public AccesDonneesGaecFenetrageException(String p_codeErreur, String p_libelle, Object[] p_args)
  {
    super(p_codeErreur, AccesDonneesGaecException.creerMessageParametres(p_libelle, p_args));
  }
}

/* Location:
 * Qualified Name:     AccesDonneesGaecFenetrageException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */