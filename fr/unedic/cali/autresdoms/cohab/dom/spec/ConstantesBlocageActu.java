package fr.unedic.cali.autresdoms.cohab.dom.spec;

public abstract interface ConstantesBlocageActu
{
  public static final String PENSION_INVALIDITE = "blocage pour signal. pension d'inval. sur le DSM";
  public static final String PENSION_RETRAITE = "blocage pour signal. pension de retraite sur le DSM";
  public static final String ARRET_RECHERCHE_EMPLOIS = "blocage pour arret recherche d'empl. sign. sur le DSM";
  public static final String MATERNITE_SANS_DATE = "blocage pour signal maternité sans date sur le DSM";
  public static final String MULTI_DECLARATION = "DSM en multi-déclaration recyclée";
  public static final String MOTIF_DIVERS = "blocage pour motif divers";
  public static final String ACTU_SANS_DECLARATION_TO = "blocage ADE si actu sans déclaration TO";
  public static final String ACTU_SANS_DECLARATION_CTP_TO = "blocage pour D.E. en CTP ayant déclaré du TO";
  public static final String CHANGEMENT_SITUATION_D_E_CRP = "blocage pour changement de situation et D.E. en CRP";
  public static final String CHANGEMENT_SITUATION_D_E_CTP = "blocage pour changement de situation et D.E. en CTP";
  public static final String SIGNAL_FORMATION = "blocage pour signal formation";
  public static final String PAIEMENT_MIGRE_NCP_REN = "blocage paiement pour DE migre NCP en renouvellement";
  public static final String ACTU_AVEC_DECLARATION_CT_CTP = "Blocage pour actu avec activité déclarée en CTP";
  public static final String ACTU_AVEC_DECLARATION_TO_CTP = "Blocage pour actu avec activité déclarée en CTP";
  public static final String ACTU_BLOCAGE_DECES_CERTIFIE = "Blocage suite info CNAV décès certifié";
  public static final String ACTU_BLOCAGE_DECES_PRESUME = "Blocage suite info CNAV décès présumé";
  public static final String ACTU_BLOCAGE_RIDE_FIN_FORM = "Blocage indemnisation pour DE en fin de formation";
}

/* Location:
 * Qualified Name:     ConstantesBlocageActu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */