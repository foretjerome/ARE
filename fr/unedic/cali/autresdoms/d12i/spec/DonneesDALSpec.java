package fr.unedic.cali.autresdoms.d12i.spec;

import fr.unedic.util.temps.Damj;

public abstract interface DonneesDALSpec
{
  public static final int CAT_NON_RENSEIGNEE = 0;
  public static final int CAT_ARTISTE_NON_SALARIE = 1;
  public static final int CAT_MARIN_PECHEUR = 2;
  public static final int CAT_DOCKER = 3;
  public static final int CAT_DETENU_LIBERE = 4;
  public static final int CAT_SALARIE_EXPATRIE = 5;
  public static final int CAT_APATRIDE = 6;
  public static final int CAT_VICTIME_TRAITE_HUMAINS = 7;
  public static final int CAT_BENEFICIAIRE_PROTECT_SUBSI = 8;
  public static final int CAT_FDD = 9;
  
  public abstract int getCategorieParticuliere();
  
  public abstract boolean estTopFinDeDroit();
  
  public abstract String getRefusPropositionFNE();
  
  public abstract String getTopPropositionCSP();
  
  public abstract Boolean estTopPropositionPAP();
  
  public abstract Damj getDernierJourAtteste();
}

/* Location:
 * Qualified Name:     DonneesDALSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */