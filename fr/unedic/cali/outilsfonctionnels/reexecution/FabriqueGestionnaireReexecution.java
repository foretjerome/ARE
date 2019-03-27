package fr.unedic.cali.outilsfonctionnels.reexecution;

public final class FabriqueGestionnaireReexecution
{
  private static GestionnaireReexecutionSpec s_gestionnaire;
  
  public static synchronized GestionnaireReexecutionSpec getGestionnaire()
  {
    if (s_gestionnaire == null) {
      s_gestionnaire = new GestionnaireReexecutionAvecJustification();
    }
    return s_gestionnaire;
  }
}

/* Location:
 * Qualified Name:     FabriqueGestionnaireReexecution
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */