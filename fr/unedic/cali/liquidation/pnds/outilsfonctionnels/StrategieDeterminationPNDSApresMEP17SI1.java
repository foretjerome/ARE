package fr.unedic.cali.liquidation.pnds.outilsfonctionnels;

import fr.unedic.cali.autresdoms.ga.dom.spec.PeriodeGaecSpec;
import fr.unedic.cali.calcul.dom.periode.PeriodeActiviteEmploiCalcul;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.pnds.PeriodeNonDeclareeSanction;
import fr.unedic.cali.parametres.GestionnaireDateApplication;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class StrategieDeterminationPNDSApresMEP17SI1
  extends StrategieDeterminationPNDSApresMEP09SI2
{
  private static final String NOM = "StrategieDeterminationPNDSApresMEP17SI1";
  
  protected Map<PeriodeGaecSpec, PeriodeNonDeclareeSanction> appliquerRegleDeChevauchementDesAttributions(IndividuSpec individu, Map<PeriodeGaecSpec, PeriodeNonDeclareeSanction> tablePnds, Damj dateExamen)
    throws CoucheLogiqueException
  {
    return tablePnds;
  }
  
  protected Periode determinationPeriodeRecherchePNDS(Damj debutPeriode, Damj finPeriode)
    throws CoucheLogiqueException
  {
    Damj debutPeriodeBorne = Damj.max(debutPeriode, GestionnaireDateApplication.getInstance().recupererDateApplication("Date de prise en compte d'une PND suite à la réactivation des PNDS"));
    
    return super.determinationPeriodeRecherchePNDS(debutPeriodeBorne, finPeriode);
  }
  
  public String getNomStrategie()
  {
    return "StrategieDeterminationPNDSApresMEP17SI1";
  }
  
  public Collection determinationPNDSPourCalcul(ChronologiePeriodes chronoPeriodeTravail, IndividuSpec individu)
  {
    chronoPeriodeTravail.iterer();
    ChronologiePeriodes listePNDsurleMois = new ChronologiePeriodes();
    ArrayList<?> listePNDS = new ArrayList();
    while (chronoPeriodeTravail.encoreSuivant())
    {
      PeriodeActiviteEmploiCalcul periodeTravail = (PeriodeActiviteEmploiCalcul)chronoPeriodeTravail.elementSuivant();
      listePNDsurleMois.ajouter(periodeTravail.getCollectionPND());
      listePNDS.addAll(periodeTravail.getCollectionPND());
    }
    appliquerRegleDesTroisJours(listePNDsurleMois, listePNDS);
    return listePNDS;
  }
  
  protected ChronologiePeriodes gererChevauchementPND(ChronologiePeriodes listePNDToutesActiviteSalariee)
  {
    return listePNDToutesActiviteSalariee.fusionnerChevauchementPeriodes();
  }
}

/* Location:
 * Qualified Name:     StrategieDeterminationPNDSApresMEP17SI1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */