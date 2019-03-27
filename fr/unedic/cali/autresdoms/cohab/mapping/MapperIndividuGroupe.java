package fr.unedic.cali.autresdoms.cohab.mapping;

import fr.unedic.cali.autresdoms.cohab.dom.IndividuCohabAbstrait;
import fr.unedic.cali.autresdoms.cohab.dom.TrimestreRetraite;
import fr.unedic.cali.autresdoms.cohab.sigma.individu.dom.spec.IndividuSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.individu.dom.spec.TrimestreRetraiteSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.servicecali.dom.ResultatServiceCaliV1;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

public class MapperIndividuGroupe
{
  public static void mapperIndividuGroupe(IndividuCohabAbstrait individu, ResultatServiceCaliV1 resultatServiceIndividuCojac)
    throws CoucheLogiqueException
  {
    if (resultatServiceIndividuCojac != null)
    {
      mapperIndividu(individu, resultatServiceIndividuCojac.getIndividu());
      
      MapperDecisionsSuivi.mapper(individu, resultatServiceIndividuCojac.getListeDecisions());
      
      MapperRessources.mapperRessources(individu, resultatServiceIndividuCojac.getListeRessourcesV1());
      
      MapperPec.mapperPec(individu, resultatServiceIndividuCojac.getListePeriodesPecV2());
      
      MapperPec.mapperPecSansFiltre(individu, resultatServiceIndividuCojac.getListePeriodesPecV1());
      
      MapperPensionsInvaliditeEtAvantagesVieillesse.mapper(individu, resultatServiceIndividuCojac.getPension());
      
      MapperPensionsInvaliditeChainees.mapper(individu, resultatServiceIndividuCojac.getPension());
      
      MapperEvtActualisation.mapper(individu, resultatServiceIndividuCojac.getBlocageActu());
      
      mapperDemandes(individu, resultatServiceIndividuCojac);
      
      MapperPeriodesAAH.mapperPeriodesAAH(individu, resultatServiceIndividuCojac.getListePeriodeAAH());
    }
  }
  
  private static void mapperDemandes(IndividuCohabAbstrait individu, ResultatServiceCaliV1 resultatService)
  {
    Collection<?> listeDemandesDAL = resultatService.getListeDemandesDAL();
    Collection<?> listeDemandesRNV = resultatService.getListeDemandesRNV();
    individu.setDemandesV1DAL(listeDemandesDAL);
    individu.setDemandesV1RNV(listeDemandesRNV);
    
    Collection listeDemandes = new ArrayList();
    if ((listeDemandesRNV != null) && (!listeDemandesRNV.isEmpty())) {
      listeDemandes.addAll(listeDemandesRNV);
    }
    if ((listeDemandesDAL != null) && (!listeDemandesDAL.isEmpty())) {
      listeDemandes.addAll(listeDemandesDAL);
    }
    individu.setDemandes(listeDemandes);
  }
  
  public static void mapperIndividu(IndividuCohabAbstrait individu, IndividuSpec allocataireGdp)
  {
    individu.setDateNaissance(allocataireGdp.getDateNaissance());
    individu.setDernierJourAtteste(allocataireGdp.getDernierJourAtteste());
    individu.setDateLiquidationRetraite(allocataireGdp.getDateLiquidationRetraite());
    individu.setDateRetraiteAnticipe(allocataireGdp.getDateRetraiteAnticipe());
    individu.setMotifRetraiteAnticipe(allocataireGdp.getMotifRetraiteAnticipe());
    individu.setPensionCan(false);
    individu.setEstBeneficiaireSapa(allocataireGdp.isBeneficiaireSapa());
    individu.setEstBeneficiaireRsa(allocataireGdp.isBeneficiaireRsa());
    individu.setEstExclusionIndividuelle(allocataireGdp.isExclusionIndividuelle());
    individu.setEstAcompteNonSolde(allocataireGdp.isAcompteNonSolde());
    individu.setDateBlocageIndemnisation(allocataireGdp.getDateLimiteIndemnisation());
    individu.setIdDemandeSigmaBlocageTransfert(allocataireGdp.getReferenceExterne());
    individu.setRsodDerniereOdSigmaNonMigree(allocataireGdp.getRsodDernierAdmission());
    individu.setEtatMigration(allocataireGdp.getEtatMigration());
    individu.setIndividuMigre(allocataireGdp.isIndividuMigre());
    individu.setDdorkb(allocataireGdp.getDateDeCalculAuPlusTot());
    individu.setDatePeremptionTitreSejour(allocataireGdp.getDatePeremptionTitreSejour());
    individu.setDjams(allocataireGdp.getDjams());
    individu.setEstAlerteAD(allocataireGdp.estAlerteAD());
    if (allocataireGdp.getDateDeces() != null) {
      individu.setDateDeces(allocataireGdp.getDateDeces().veille());
    }
    TrimestreRetraite trimestreRetraite = new TrimestreRetraite();
    if (allocataireGdp.getTrimestreRetraite() != null)
    {
      individu.setDateCentTrimestres(allocataireGdp.getTrimestreRetraite().getDateCentTrimestres());
      trimestreRetraite.setDateEvenement(allocataireGdp.getTrimestreRetraite().getDateValeurTrimestre());
      trimestreRetraite.setNombreTrimestre(Integer.valueOf(new BigDecimal(allocataireGdp.getTrimestreRetraite().getNombreTrimestre()).intValue()));
    }
    individu.setTrimestreRetraite(trimestreRetraite);
  }
}

/* Location:
 * Qualified Name:     MapperIndividuGroupe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */