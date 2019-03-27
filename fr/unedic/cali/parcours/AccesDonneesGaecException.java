package fr.unedic.cali.parcours;

import fr.unedic.util.services.CoucheLogiqueException;

public class AccesDonneesGaecException
  extends CoucheLogiqueException
{
  private static final long serialVersionUID = -3838125673197656676L;
  private static final String VARIABLE_DANS_MESSAGE = "%ARG%";
  
  public AccesDonneesGaecException(String p_codeErreur)
  {
    super(p_codeErreur);
  }
  
  public AccesDonneesGaecException(String p_codeErreur, String p_libelle)
  {
    super(p_codeErreur, p_libelle);
  }
  
  public AccesDonneesGaecException(String p_codeErreur, Throwable p_origine)
  {
    super(p_codeErreur, p_origine);
  }
  
  public AccesDonneesGaecException(String p_codeErreur, String p_libelle, Throwable p_origine)
  {
    super(p_codeErreur, p_libelle, p_origine);
  }
  
  public static String creerMessageParametres(String p_libelleErreur, Object[] p_args)
  {
    if (p_args != null) {
      for (int i = 0; i < p_args.length; i++) {
        p_libelleErreur = p_libelleErreur.replaceFirst("%ARG%", p_args[i].toString());
      }
    }
    return p_libelleErreur;
  }
}

/* Location:
 * Qualified Name:     AccesDonneesGaecException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */