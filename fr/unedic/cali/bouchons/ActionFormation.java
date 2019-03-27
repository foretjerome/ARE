package fr.unedic.cali.bouchons;

import fr.unedic.cali.autresdoms.ga.dom.IndividuGaecAbstrait;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeFormation;
import fr.unedic.util.Quantite;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import fr.unedic.util.temps.UniteDuree;
import java.util.Collection;
import java.util.Iterator;

public class ActionFormation
{
  private static final int VINGT = 20;
  private static final int CENT = 100;
  private static final Quantite QUANTITE_HORAIRE_HEBDO = new Quantite(20, UniteDuree.HEURE);
  private static final Quantite DUREE_TOTALE = new Quantite(100, UniteDuree.HEURE);
  private static final String LIBELLE_LIEU = "BORDEAUX";
  private static final String NOM_ORGANISME_FORMATION = "AFPA";
  private static final String IDENTIFIANT = "1";
  private static final String AFF_DEROGATOIRE = "O";
  private static final int BORNE_INF = 10000000;
  private static final int BORNE_SUP = 99999999;
  
  public static void creerActionFormation(IndividuGaecAbstrait p_individuGa, Damj p_dateDebut, Damj p_dateFin, int p_typeConvention, boolean p_estEffective, boolean p_estAutomatise)
  {
    creerActionFormation(p_individuGa, p_dateDebut, p_dateFin, p_typeConvention, p_estEffective, p_estAutomatise, null, null);
  }
  
  public static void creerActionFormation(IndividuGaecAbstrait p_individuGa, Damj p_dateDebut, Damj p_dateFin, int p_typeConvention, boolean p_estEffective, boolean p_estAutomatise, String p_organismeFormation, Quantite p_dureeTotale)
  {
    fr.unedic.cali.autresdoms.ga.dom.ActionFormation actionFormationCali = new fr.unedic.cali.autresdoms.ga.dom.ActionFormation(p_dateDebut, p_dateFin);
    
    actionFormationCali.setQuantiteHoraireHebdo(QUANTITE_HORAIRE_HEBDO);
    if (p_dureeTotale == null) {
      actionFormationCali.setDureeTotale(DUREE_TOTALE);
    } else {
      actionFormationCali.setDureeTotale(p_dureeTotale);
    }
    actionFormationCali.setTypeConvention(p_typeConvention);
    actionFormationCali.setDateConnaissanceInfo(p_dateDebut);
    actionFormationCali.setNumeroConvention(new Integer(10000000 + (int)(Math.random() * 9.0E7D)).toString());
    actionFormationCali.setIdentifiantConvention(new Integer(Integer.parseInt(actionFormationCali.getNumeroConvention()) + 1).toString());
    actionFormationCali.setLibelleLieu("BORDEAUX");
    if (p_organismeFormation != null) {
      actionFormationCali.setNomOrganismeFormation(p_organismeFormation);
    } else {
      actionFormationCali.setNomOrganismeFormation("AFPA");
    }
    int idMax = 0;
    Iterator iter = p_individuGa.getActionsFormation().iterator();
    while (iter.hasNext())
    {
      fr.unedic.cali.autresdoms.ga.dom.ActionFormation actionFormation = (fr.unedic.cali.autresdoms.ga.dom.ActionFormation)iter.next();
      int idActionFormation = Integer.parseInt(actionFormation.getIdentifiant());
      if (idActionFormation > idMax) {
        idMax = idActionFormation;
      }
    }
    actionFormationCali.setIdentifiant(String.valueOf(idMax + 1));
    
    actionFormationCali.setDatePrescription(p_dateDebut);
    actionFormationCali.setAffDerogatoire("O");
    actionFormationCali.setTypeBeneficiaireRSA(0);
    PeriodeFormation periodeFormation = new PeriodeFormation(p_dateDebut, p_dateFin);
    if (p_estEffective) {
      periodeFormation.setPeriodeEffective(new Periode(p_dateDebut, p_dateFin));
    }
    periodeFormation.setIdentifiant("1");
    actionFormationCali.ajouterPeriodeFormation(periodeFormation);
    actionFormationCali.setTypePlanFormation("7");
    if (p_estAutomatise) {
      actionFormationCali.setOrigineSaisieFormation("A");
    }
    if (!p_individuGa.getChronoPeriodePasseProfessionnel().contientElement(actionFormationCali)) {
      p_individuGa.getChronoPeriodePasseProfessionnel().ajouter(actionFormationCali);
    }
  }
}

/* Location:
 * Qualified Name:     ActionFormation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */