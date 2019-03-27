package fr.unedic.cali.dom;

import fr.pe.cali.crem.outils.CacheCrem;
import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.spec.PeriodeGaecSpec;
import fr.unedic.cali.calcul.pbjc.dom.AideNcp;
import fr.unedic.cali.calcul.pbjc.dom.DispositifNcp;
import fr.unedic.cali.calcul.pbjc.dom.EnquetePbjcNcp;
import fr.unedic.cali.calcul.pbjc.dom.IndividuPbjcNcp;
import fr.unedic.cali.calcul.pbjc.dom.PbjcNcp;
import fr.unedic.cali.dom.pnds.CachePndsSpectacle;
import fr.unedic.cali.dom.pnds.PeriodeNonDeclareeSanction;
import fr.unedic.util.temps.ChronologieDebuts;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public abstract interface IndividuCaliSpec
  extends IndividuDomaineSpec
{
  public static final int INDIVIDU_NON_MIGRE = 0;
  public static final int INDIVIDU_MIGRE = 1;
  public static final String ORIGINE_SAISIE_DJI_ARE_SPE_MIGRATION = "1";
  public static final String ORIGINE_SAISIE_DJI_ARE_SPE_ANTECEDENT = "2";
  
  public abstract void ajouterPeriodeActiviteSalariee(ActiviteSalarie paramActiviteSalarie);
  
  public abstract void supprimerPeriodeActiviteSalariee(ActiviteSalarie paramActiviteSalarie);
  
  public abstract Collection getListePeriodesActiviteSalariee();
  
  public abstract void setListePeriodesActiviteSalariee(Collection paramCollection);
  
  public abstract void remplacerCollectionActiviteSalarie(Collection paramCollection);
  
  public abstract void ajouterDemande(DemandeSpec paramDemandeSpec);
  
  public abstract void supprimerDemande(DemandeSpec paramDemandeSpec);
  
  public abstract ChronologieDebuts getChronoDemandes();
  
  public abstract Collection getDemandes();
  
  public abstract ChronologieDebuts getChronoDemandesNonTriees();
  
  public abstract void setChronoDemandes(ChronologieDebuts paramChronologieDebuts);
  
  public abstract ChronologieDebuts getChronoDemandeAssurance();
  
  public abstract ChronologieDebuts getChronoDemandeMaintien();
  
  public abstract ChronologieDebuts getChronoDemandeSolidarite();
  
  public abstract ChronologieDebuts getChronoDemandeFormation();
  
  public abstract ChronologieDebuts getChronoDemandeRemboursementFrais();
  
  public abstract ChronologieDebuts getChronoDemandeIncitationReclassement();
  
  public abstract ChronologieDebuts getChronoDemandeAri();
  
  public abstract ChronologieDebuts getChronoDemandePreRetraite();
  
  public abstract ChronologieDebuts getChronoDemandeDeces();
  
  public abstract DemandeSpec rechercherDemande(String paramString1, String paramString2);
  
  public abstract DemandeSpec rechercherDemande(String paramString);
  
  public abstract boolean getIndicateurEnregistrerQualifPeriodes();
  
  public abstract void setIndicateurEnregistrerQualifPeriodes(boolean paramBoolean);
  
  public abstract IndicateursGeneriques getIndicateursGeneriques();
  
  public abstract Collection getListeLA2K();
  
  public abstract Damj getDateBlocageIndemnisationConflitGAEC();
  
  public abstract void setDateBlocageIndemnisationConflitGAEC(Damj paramDamj);
  
  public abstract Damj getDateExecutionDifferee();
  
  public abstract void setDateExecutionDifferee(Damj paramDamj);
  
  public abstract String getCodeTransaction();
  
  public abstract void setCodeTransaction(String paramString);
  
  public abstract String getDomaineSrcFlux();
  
  public abstract void setDomaineSrcFlux(String paramString);
  
  public abstract int getCodeTransfert();
  
  public abstract Collection getListeStatutDSM();
  
  public abstract void setListeStatutDSM(Collection paramCollection);
  
  public abstract int getEstMigree();
  
  public abstract void setEstMigree(int paramInt);
  
  public abstract void ajouterStatistiqueExamenAuFilEau(StatistiqueExamenAuFilEau paramStatistiqueExamenAuFilEau);
  
  public abstract void supprimerStatistiqueExamenAuFilEau(StatistiqueExamenAuFilEau paramStatistiqueExamenAuFilEau);
  
  public abstract Collection getCollectionStatistiqueExamenAuFilEau();
  
  public abstract void setListePNDSIndividu(Map<PeriodeGaecSpec, PeriodeNonDeclareeSanction> paramMap);
  
  public abstract Map<PeriodeGaecSpec, PeriodeNonDeclareeSanction> getListePNDSIndividu();
  
  public abstract boolean isForcageAppelGaecTotal();
  
  public abstract void setForcageAppelGaecTotal(boolean paramBoolean);
  
  public abstract List getListPreInscription();
  
  public abstract void ajouterPreInscription(PreInscription paramPreInscription);
  
  public abstract void supprimerPreInscription(PreInscription paramPreInscription);
  
  public abstract int getAttributionsAfdFiliereCourte();
  
  public abstract int getAttributionsAfdFiliereIntermediaire();
  
  public abstract int getAttributionsAfdFiliereLongue();
  
  public abstract void setAttributionsAfdFiliereCourte(int paramInt);
  
  public abstract void setAttributionsAfdFiliereIntermediaire(int paramInt);
  
  public abstract void setAttributionsAfdFiliereLongue(int paramInt);
  
  public abstract Damj getDernierJourIndemnisableAreSpe();
  
  public abstract void setDernierJourIndemnisableAreSpe(Damj paramDamj);
  
  public abstract String getOrigineSaisieDernierJourIndemnisableAreSpe();
  
  public abstract void setOrigineSaisieDernierJourIndemnisableAreSpe(String paramString);
  
  public abstract ChronologiePeriodes getChronoPbjcs();
  
  public abstract ChronologiePeriodes getChronoPbjcsADate(Damj paramDamj);
  
  public abstract void ajouterPbjc(PbjcNcp paramPbjcNcp);
  
  public abstract void setChronoPbjc(ChronologiePeriodes paramChronologiePeriodes);
  
  public abstract Damj getDateDebutGenerationPbjcs();
  
  public abstract void setDateDebutGenerationPbjcs(Damj paramDamj);
  
  public abstract Collection getCollectionPrimes();
  
  public abstract void setCollectionPrimes(Collection paramCollection);
  
  public abstract void setDateDebutGenerationPrimes(Damj paramDamj);
  
  public abstract Damj getDateDebutGenerationPrimes();
  
  public abstract List getListDroitsPbjcsNcp();
  
  public abstract void setListDroitsPbjcsNcp(List paramList);
  
  public abstract Damj getDateDebutGenerationDroits();
  
  public abstract void setDateDebutGenerationDroits(Damj paramDamj);
  
  public abstract IndividuPbjcNcp getIndividuPbjcNcp();
  
  public abstract void setIndividuPbjcNcp(IndividuPbjcNcp paramIndividuPbjcNcp);
  
  public abstract List<EnquetePbjcNcp> getListEnquetesPbjcNcp();
  
  public abstract void setListEnquetesPbjcNcp(List paramList);
  
  public abstract Damj getDateDebutGenerationEnquete();
  
  public abstract void setDateDebutGenerationEnquete(Damj paramDamj);
  
  public abstract ChronologiePeriodes getChronoAides();
  
  public abstract ChronologiePeriodesGaec getChronoPeriodesCalcul();
  
  public abstract void setChronoPeriodesCalcul(ChronologiePeriodesGaec paramChronologiePeriodesGaec);
  
  public abstract void ajouterAide(AideNcp paramAideNcp);
  
  public abstract void setChronoAide(ChronologiePeriodes paramChronologiePeriodes);
  
  public abstract Damj getDateDebutGenerationAides();
  
  public abstract void setDateDebutGenerationAides(Damj paramDamj);
  
  public abstract void desactiverPNDS();
  
  public abstract void activerPNDS();
  
  public abstract boolean estPndsActive();
  
  public abstract boolean isEstArretReexecution();
  
  public abstract void setEstArretReexecution(boolean paramBoolean);
  
  public abstract void setEstDesactEFE(boolean paramBoolean);
  
  public abstract boolean isEstDesactEFE();
  
  public abstract void setEstNonExecutionReceptionFlux(boolean paramBoolean);
  
  public abstract boolean isEstNonExecutionReceptionFlux();
  
  public abstract Collection<DispositifNcp> getCollectionDispositifNcp();
  
  public abstract void ajouterDispositifNcp(DispositifNcp paramDispositifNcp);
  
  public abstract void setCollectionDispositifNcp(Collection<DispositifNcp> paramCollection);
  
  public abstract Damj getdateDebutGenerationDispositif();
  
  public abstract void setDateDebutGenerationDispositifNcp(Damj paramDamj);
  
  public abstract CachePndsSpectacle getCachePndsSpectacle();
  
  public abstract CacheCrem getCacheCrem();
  
  public abstract void setCacheCrem(CacheCrem paramCacheCrem);
}

/* Location:
 * Qualified Name:     IndividuCaliSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */