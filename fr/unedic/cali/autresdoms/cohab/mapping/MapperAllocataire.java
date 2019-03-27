package fr.unedic.cali.autresdoms.cohab.mapping;

import fr.unedic.cali.autresdoms.cohab.dom.IndividuPopulationImpl;
import fr.unedic.cali.autresdoms.cohab.dom.LireAllocataireResultat;
import fr.unedic.cali.autresdoms.cohab.dom.QuadrupletteIndividu;
import fr.unedic.cali.autresdoms.cohab.dom.TripletteIndividu;
import fr.unedic.cali.autresdoms.cohab.sigma.individu.dom.spec.IndividuSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.individu.dom.spec.TrimestreRetraiteSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.individubni.dom.spec.AllocataireBniSigmaR0Spec;
import fr.unedic.cali.autresdoms.cohab.sigma.rechercheAliasNCP.dom.spec.AllocataireNcpSpec;
import java.math.BigDecimal;

public final class MapperAllocataire
{
  private static final String INDIVIDU_NCP_TMP = "M";
  
  public static LireAllocataireResultat mapper(IndividuSpec allocataireGdp)
  {
    LireAllocataireResultat resultatService = new LireAllocataireResultat();
    
    resultatService.setNom(allocataireGdp.getNom());
    resultatService.setPrenom(allocataireGdp.getPrenom());
    resultatService.setDateDeNaissance(allocataireGdp.getDateNaissance());
    resultatService.setDateDeces(allocataireGdp.getDateDeces());
    resultatService.setDernierJourAtteste(allocataireGdp.getDernierJourAtteste());
    resultatService.setEstBeneficiaireSapa(allocataireGdp.isBeneficiaireSapa());
    resultatService.setEstBeneficiaireRsa(allocataireGdp.isBeneficiaireRsa());
    resultatService.setEstExclusionIndividuelle(allocataireGdp.isExclusionIndividuelle());
    resultatService.setEstAcompteNonSolde(allocataireGdp.isAcompteNonSolde());
    resultatService.setEtatMigration(allocataireGdp.getEtatMigration());
    resultatService.setIndividuMigre(allocataireGdp.isIndividuMigre());
    resultatService.setEstAlerteAD(allocataireGdp.estAlerteAD());
    resultatService.setDdorkb(allocataireGdp.getDateDeCalculAuPlusTot());
    if (allocataireGdp.getTrimestreRetraite() != null)
    {
      resultatService.setDateValeurTrimestre(allocataireGdp.getTrimestreRetraite().getDateValeurTrimestre());
      resultatService.setNbTrimestresAcquis(new BigDecimal(allocataireGdp.getTrimestreRetraite().getNombreTrimestre()));
      resultatService.setDateCentTrimestres(allocataireGdp.getTrimestreRetraite().getDateCentTrimestres());
    }
    if (allocataireGdp.getDateLiquidationRetraite() != null) {
      resultatService.setDateLiquidationRetraite(allocataireGdp.getDateLiquidationRetraite());
    }
    if (allocataireGdp.getDateRetraiteAnticipe() != null) {
      resultatService.setDateRetraiteAnticipe(allocataireGdp.getDateRetraiteAnticipe());
    }
    if (allocataireGdp.getMotifRetraiteAnticipe() != null) {
      resultatService.setMotifRetraiteAnticipe(allocataireGdp.getMotifRetraiteAnticipe());
    }
    resultatService.setDateBlocageIndemnisation(allocataireGdp.getDateLimiteIndemnisation());
    
    resultatService.setIdDemandeSigmaTransfert(allocataireGdp.getReferenceExterne());
    
    resultatService.setRsodDerniereAdmission(allocataireGdp.getRsodDernierAdmission());
    
    resultatService.setDatePeremptionTitreSejour(allocataireGdp.getDatePeremptionTitreSejour());
    
    resultatService.setDjams(allocataireGdp.getDjams());
    
    return resultatService;
  }
  
  public static TripletteIndividu mapper(AllocataireBniSigmaR0Spec allocataire)
  {
    TripletteIndividu triplette = new TripletteIndividu();
    triplette.setNumeroAllocataireBniCxala(allocataire.getNumeroAllocataire());
    triplette.setNumeroAllocataireRsin(allocataire.getIdentifiantSigma());
    triplette.setCodeAssedic(allocataire.getCodeAssedic());
    
    return triplette;
  }
  
  public static TripletteIndividu mapperPopNCP(AllocataireBniSigmaR0Spec allocataire)
  {
    TripletteIndividu triplette = null;
    if (allocataire.getCodeEtatMigrationNCP().equals("M"))
    {
      triplette = new TripletteIndividu();
      triplette.setNumeroAllocataireBniCxala(allocataire.getNumeroAllocataire());
      triplette.setNumeroAllocataireRsin(allocataire.getIdentifiantSigma());
      triplette.setCodeAssedic(allocataire.getCodeAssedic());
    }
    return triplette;
  }
  
  public static IndividuPopulationImpl mapperPopNCP(AllocataireNcpSpec allocataire)
  {
    QuadrupletteIndividu individuPopulation = new QuadrupletteIndividu();
    
    individuPopulation.setNumeroAllocataireBniCxala(allocataire.getNumeroAllocataire());
    individuPopulation.setNumeroAllocataireRsin(allocataire.getIdentifiantSigma());
    individuPopulation.setCodeAssedic(allocataire.getCodeAssedic());
    individuPopulation.setAliasNCP(allocataire.getAliasNcp());
    individuPopulation.setTopReferent(allocataire.getTopReferent());
    individuPopulation.setCodeAntenne(allocataire.getCodeAntenne());
    individuPopulation.setIdentifiantDNA(allocataire.getIdentifiantDNA());
    
    return individuPopulation;
  }
}

/* Location:
 * Qualified Name:     MapperAllocataire
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */