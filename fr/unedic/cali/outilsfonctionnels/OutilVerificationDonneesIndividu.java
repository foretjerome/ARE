package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.cali.parcours.DomDonneesIndividu;
import fr.unedic.util.services.CoucheLogiqueException;

public class OutilVerificationDonneesIndividu
{
  private static final int MIN_FILIERE = 0;
  private static final int MAX_FILIERE_COURTE = 1;
  private static final int MAX_FILIERE_INTERMEDIAIRE = 2;
  private static final int MAX_FILIERE_LONGUE = 3;
  
  public static void verifierDonneesIndividu(DomDonneesIndividu p_dom)
    throws CoucheLogiqueException
  {
    if ((p_dom.getAttributionsAfdFiliereCourte() < 0) || (p_dom.getAttributionsAfdFiliereCourte() > 1)) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_N_CALI_DONNEES_INDIVIDU_FILIERE_COURTE");
    }
    if ((p_dom.getAttributionsAfdFiliereIntermediaire() < 0) || (p_dom.getAttributionsAfdFiliereIntermediaire() > 2)) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_N_CALI_DONNEES_INDIVIDU_FILIERE_INT");
    }
    if ((p_dom.getAttributionsAfdFiliereLongue() < 0) || (p_dom.getAttributionsAfdFiliereLongue() > 3)) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_N_CALI_DONNEES_INDIVIDU_FILIERE_LONGUE");
    }
  }
}

/* Location:
 * Qualified Name:     OutilVerificationDonneesIndividu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */