package fr.unedic.cali.autresdoms.ga.dom.spec;

public abstract interface NonSalarieSpec
  extends CertifieSpec
{
  public static final int NATURE_SERVICE_CONJOINT = 1;
  public static final int NATURE_ARTISANT = 2;
  public static final int NATURE_BENEVOLAT = 3;
  public static final int NATURE_COMMERCANT = 4;
  public static final int NATURE_DIRIGEANT = 5;
  public static final int NATURE_ENTREPRENEUR = 6;
  public static final int NATURE_GERANT_EGALITAIRE = 7;
  public static final int NATURE_GERANT_MINORITAIRE = 8;
  public static final int NATURE_MANDAT_ELECTIF = 9;
  public static final int NATURE_MANDAT_SOCIAL = 10;
  public static final int NATURE_MANDAT_SYNDICAL = 11;
  public static final int NATURE_PDG = 12;
  public static final int NATURE_PROFESSION_AGRICOLE = 13;
  public static final int NATURE_PROFESSION_LIBERALE = 14;
  public static final int NATURE_TRAVAIL_INTERET_GENERAL = 15;
  public static final int NATURE_ARTISTE_NON_SALARIE = 16;
  public static final int NATURE_AVOCAT_COMMIS_OFFICE = 17;
  public static final int NATURE_CONCESSION_LICENCE_BREVET = 18;
  public static final int NATURE_DROITS_AUTEUR = 19;
  public static final int NATURE_REDACTEUR_ARTICLE = 20;
  public static final int NATURE_EMPLOI_COTISANT_SOLIDARITE = 23;
  public static final int NATURE_EMPLOI_CONJOINT_CO_EXPLOITANT = 21;
  
  public abstract int getNatureActivite();
  
  public abstract void setNatureActivite(int paramInt);
}

/* Location:
 * Qualified Name:     NonSalarieSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */