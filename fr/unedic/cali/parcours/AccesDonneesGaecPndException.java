package fr.unedic.cali.parcours;

public class AccesDonneesGaecPndException
  extends AccesDonneesGaecException
{
  private static final long serialVersionUID = 5966308468035783309L;
  
  public AccesDonneesGaecPndException(String p_codeErreur)
  {
    super(p_codeErreur);
  }
  
  public AccesDonneesGaecPndException(String p_codeErreur, String p_libelle)
  {
    super(p_codeErreur, p_libelle);
  }
  
  public AccesDonneesGaecPndException(String p_codeErreur, Throwable p_origine)
  {
    super(p_codeErreur, p_origine);
  }
  
  public AccesDonneesGaecPndException(String p_codeErreur, String p_libelle, Throwable p_origine)
  {
    super(p_codeErreur, p_libelle, p_origine);
  }
}

/* Location:
 * Qualified Name:     AccesDonneesGaecPndException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */