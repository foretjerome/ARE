package fr.unedic.cali.dom;

public abstract interface ClassementAdministratifSpec
{
  public static final String CLASSEMENT_SANS_OBJET = "SO";
  public static final String CLASSEMENT_SANS_OBJET_LONG = "Classement Sans Objet";
  public static final String CLASSEMENT_SANS_SUITE = "SS";
  public static final String CLASSEMENT_SANS_SUITE_LONG = "Classement Sans Suite";
  public static final String CLASSEMENT_PRESCRIPTION = "PS";
  public static final String CLASSEMENT_PRESCRIPTION_LONG = "Classement Prescription";
  public static final String CLASSEMENT_SECTEUR_PUBLIC = "SP";
  public static final String CLASSEMENT_SECTEUR_PUBLIC_LONG = "Classement Compétence Secteur Public";
  public static final String CLASSEMENT_DEPOT_TARDIF = "DT";
  public static final String CLASSEMENT_DEPOT_TARDIF_LONG = "Classement Dépot Tardif";
  public static final String CLASSEMENT_ADMINISTRATIF_VIDE = "  ";
  public static final String CLASSEMENT_ADMINISTRATIF_TOUS = "tous classement";
  
  public abstract boolean estClassementValide();
  
  public abstract String getTypeClassement();
  
  public abstract String getIdentifiant();
}

/* Location:
 * Qualified Name:     ClassementAdministratifSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */