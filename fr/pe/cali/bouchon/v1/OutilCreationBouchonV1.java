package fr.pe.cali.bouchon.v1;

import fr.unedic.cali.autresdoms.cohab.dom.IndividuCohabAbstrait;
import fr.unedic.cali.autresdoms.cohab.dom.ObjetChronoPeriodePriseEnCharge;
import fr.unedic.cali.autresdoms.cohab.dom.ObjetChronoPeriodePriseEnChargeSansFiltre;
import fr.unedic.cali.autresdoms.cohab.dom.Ressources;
import fr.unedic.cali.autresdoms.cohab.sigma.demande.dom.Demande;
import fr.unedic.cali.autresdoms.cohab.sigma.demande.dom.spec.DemandeSpec;
import fr.unedic.cali.outilsfonctionnels.ConstructionCSOIA;
import fr.unedic.util.QuantiteEuro;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.Collection;

public final class OutilCreationBouchonV1
{
  public static final String TYPE_DAL = "DAL";
  public static final String TYPE_RNV = "RNV";
  private static final String SITUATION_EMPLOI_ARCE = "CEN";
  
  public static OutilCreationBouchonV1 getInstance()
  {
    return new OutilCreationBouchonV1();
  }
  
  public DemandeSpec ajouterDemandeV1(Damj dateDepot, Damj dateDemande, int idPec, String refExterne, String numeroSuivi, String typeExamen, String gamme, IndividuCohabAbstrait individu, String typeDal)
  {
    DemandeSpec demande = new Demande();
    demande.setGamme(ConstructionCSOIA.getGammeDepuisTypeExamen(typeExamen));
    demande.setLigne(ConstructionCSOIA.getLigneDepuisTypeExamen(typeExamen));
    demande.setProduit(ConstructionCSOIA.getProduitDepuisTypeExamen(typeExamen));
    demande.setTypeExamen(ConstructionCSOIA.getCSOIADepuisTypeExamen(typeExamen));
    demande.setDateDepot(dateDepot);
    demande.setDateDemande(dateDemande);
    demande.setIdentifiantPec(idPec);
    demande.setIdentifiantDemande(refExterne);
    demande.setNumeroSuivi(numeroSuivi);
    demande.setGamme(gamme);
    individu.getDemandes().add(demande);
    if ("DAL".equals(typeDal)) {
      individu.getDemandesV1DAL().add(demande);
    } else if ("RNV".equals(typeDal)) {
      individu.getDemandesV1RNV().add(demande);
    }
    return demande;
  }
  
  public void initIndividu(IndividuCohabAbstrait individu)
  {
    individu.setDemandes(new ArrayList());
    individu.setDemandesV1DAL(new ArrayList());
    individu.setDemandesV1RNV(new ArrayList());
    individu.setChronologiePecFusionneesFinCI(new ChronologiePeriodes());
    individu.setChronologiePecNonFusionneesFinCI(new ChronologiePeriodes());
    individu.setDateNaissance(new Damj(1980, 1, 1));
  }
  
  public Ressources creerRessourceV1(String referenceExterne, Damj dateEffet, String ressourcesAlloc, String ressourcesMensuelles, int situationFamiliale)
  {
    Ressources ressource = new Ressources();
    QuantiteEuro ressourcesAllocataire = new QuantiteEuro(ressourcesAlloc);
    QuantiteEuro montantRessourcesMensuelles = new QuantiteEuro(ressourcesMensuelles);
    ressource.setRessourcesAllocataire(ressourcesAllocataire);
    ressource.setMontantRessourcesMensuelles(montantRessourcesMensuelles);
    ressource.setSituationFamiliale(situationFamiliale);
    ressource.setDateEffet(dateEffet);
    ressource.setDateFinPeriodeReference(dateEffet.getFinMois());
    ressource.setReferenceExterne(referenceExterne);
    
    return ressource;
  }
  
  public ObjetChronoPeriodePriseEnChargeSansFiltre creerPecNonFusionnee(int numero, Damj debut, Damj fin, String type, String sousType, String situationEmploi)
  {
    ObjetChronoPeriodePriseEnChargeSansFiltre pec = new ObjetChronoPeriodePriseEnChargeSansFiltre();
    initialiserPec(pec, numero, debut, fin, type, sousType, situationEmploi);
    return pec;
  }
  
  public ObjetChronoPeriodePriseEnCharge creerPecFusionnee(int numero, Damj debut, Damj fin, String type, String sousType, String situationEmploi)
  {
    ObjetChronoPeriodePriseEnCharge pec = new ObjetChronoPeriodePriseEnChargeSansFiltre();
    initialiserPec(pec, numero, debut, fin, type, sousType, situationEmploi);
    return pec;
  }
  
  private void initialiserPec(ObjetChronoPeriodePriseEnCharge pec, int numero, Damj debut, Damj fin, String type, String sousType, String situationEmploi)
  {
    pec.setIdentifiantPec(numero);
    pec.setDateDebut(debut);
    pec.setDateFin(fin);
    pec.setTypePec(type);
    pec.setSousType(sousType);
    pec.setSituationEmploi(situationEmploi);
    setDemandeurEmploiEtActualise(pec);
  }
  
  private void setDemandeurEmploiEtActualise(ObjetChronoPeriodePriseEnCharge pec)
  {
    boolean demandeurEmploi = false;
    boolean actualise = false;
    if ((estCategorie1(pec)) || (estCategorie2(pec)) || (estPecARCE(pec)))
    {
      demandeurEmploi = true;
      actualise = true;
    }
    else if ("4".equals(pec.getTypePec()))
    {
      demandeurEmploi = true;
    }
    else if ((estPecAREF(pec)) || (pec.estUnePecCTP()))
    {
      actualise = true;
    }
    pec.setDemandeurEmploi(demandeurEmploi);
    pec.setActualise(actualise);
  }
  
  private boolean estCategorie1(ObjetChronoPeriodePriseEnCharge pec)
  {
    return ("1".equals(pec.getTypePec())) && (("1".equals(pec.getSousType())) || ("2".equals(pec.getSousType())) || ("3".equals(pec.getSousType())));
  }
  
  private boolean estCategorie2(ObjetChronoPeriodePriseEnCharge pec)
  {
    return ("2".equals(pec.getTypePec())) && (("1".equals(pec.getSousType())) || ("2".equals(pec.getSousType())) || ("5".equals(pec.getSousType())));
  }
  
  private boolean estPecARCE(ObjetChronoPeriodePriseEnCharge pec)
  {
    return ("1".equals(pec.getTypePec())) && ("7".equals(pec.getSousType())) && ("CEN".equals(pec.getSituationEmploi()));
  }
  
  private boolean estPecAREF(ObjetChronoPeriodePriseEnCharge pec)
  {
    return (("1".equals(pec.getTypePec())) && ("6".equals(pec.getSousType()))) || (("2".equals(pec.getTypePec())) && ("6".equals(pec.getSousType())));
  }
}

/* Location:
 * Qualified Name:     OutilCreationBouchonV1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */