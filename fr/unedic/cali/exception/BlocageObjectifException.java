package fr.unedic.cali.exception;

import fr.unedic.util.services.CoucheLogiqueException;

public class BlocageObjectifException
  extends CoucheLogiqueException
{
  private static final long serialVersionUID = 1L;
  
  public BlocageObjectifException(String p_codeErreur)
  {
    super(p_codeErreur);
  }
  
  public BlocageObjectifException(String p_codeErreur, String p_libelle)
  {
    super(p_codeErreur, p_libelle);
  }
}

/* Location:
 * Qualified Name:     BlocageObjectifException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */