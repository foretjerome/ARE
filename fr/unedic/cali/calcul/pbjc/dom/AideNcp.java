package fr.unedic.cali.calcul.pbjc.dom;

import fr.unedic.cali.autresdoms.d90.dom.spec.ElementBasePivotEchangeComparableSpec;
import fr.unedic.cali.autresdoms.d90.outilsfonctionnels.OutilComparaison;
import fr.unedic.cali.calcul.pbjc.dom.gen.AideNcpGen;
import fr.unedic.cali.dom.ObjetPersistantSpec;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import xcalia.lido.api.LiDOHelper;

public class AideNcp
  extends AideNcpGen
  implements ObjetPersistantSpec, ElementBasePivotEchangeComparableSpec
{
  private static final long serialVersionUID = 354671214180918120L;
  protected transient Periode m_periode;
  protected transient Date m_tspElementPourEcartsBase = null;
  
  public AideNcp() {}
  
  public AideNcp(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
    setDateDebutAide(p_dateDebut);
    setDateFinAide(p_dateFin);
  }
  
  public AideNcp(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public void setType(String p_codeProduit)
  {
    super.setCodeProduit(p_codeProduit);
  }
  
  public String toString()
  {
    StringBuffer bufferARetourner = new StringBuffer();
    bufferARetourner.append("\n");
    bufferARetourner.append("--------------------------------\n");
    bufferARetourner.append("Aide du  : " + getDateDebutAide() + " au " + getDateFinAide() + "\n");
    bufferARetourner.append("Date versement de l'aide             : " + getDateVersementAide() + "\n");
    bufferARetourner.append("Code produit            : " + getCodeProduit() + "\n");
    bufferARetourner.append("Montant unitaire 1                 : " + getMontantUnitaireAide1() + "\n");
    bufferARetourner.append("Montant totale 1                : " + getMontantTotalAide1() + "\n");
    bufferARetourner.append("Nb aide imdenisé sur la période 1                 : " + getNbAidesIndemniseesPeriode1() + "\n");
    bufferARetourner.append("Code sous produit 1                 : " + getCodeNatureDerogatoireSousProduit1() + "\n");
    bufferARetourner.append("Montant unitaire 2                 : " + getMontantUnitaireAide2() + "\n");
    bufferARetourner.append("Montant totale 2                : " + getMontantTotalAide2() + "\n");
    bufferARetourner.append("Nb aide imdenisé sur la période 2                 : " + getNbAidesIndemniseesPeriode2() + "\n");
    bufferARetourner.append("Code sous produit 2                 : " + getCodeNatureDerogatoireSousProduit2() + "\n");
    bufferARetourner.append("Montant unitaire 3                 : " + getMontantUnitaireAide3() + "\n");
    bufferARetourner.append("Montant totale 3                : " + getMontantTotalAide3() + "\n");
    bufferARetourner.append("Nb aide imdenisé sur la période 3                 : " + getNbAidesIndemniseesPeriode3() + "\n");
    bufferARetourner.append("Code sous produit 3                 : " + getCodeNatureDerogatoireSousProduit3() + "\n");
    bufferARetourner.append("Montant unitaire 4                 : " + getMontantUnitaireAide4() + "\n");
    bufferARetourner.append("Montant totale 4                : " + getMontantTotalAide4() + "\n");
    bufferARetourner.append("Nb aide imdenisé sur la période 4                 : " + getNbAidesIndemniseesPeriode4() + "\n");
    bufferARetourner.append("Code sous produit 4                 : " + getCodeNatureDerogatoireSousProduit4() + "\n");
    bufferARetourner.append("Code nature aide reclassement               : " + getCodeNatureAide() + "\n");
    bufferARetourner.append("Siecle annee affectation au reclassement                : " + getSiecleAnneeAffectationDecision() + "\n");
    
    bufferARetourner.append("--------------------------------\n");
    
    return bufferARetourner.toString();
  }
  
  public String getIdentifiant()
  {
    return DomManager.getIdentifiant(this);
  }
  
  public void marquerGraphePersistant() {}
  
  public ObjetMetierSpec copie()
  {
    AideNcp copie = new AideNcp();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    AideNcp copie = (AideNcp)p_copie;
    copie.setDateDebut(getDateDebut());
    copie.setDateFin(getDateFin());
    copie.setDateVersementAide(getDateVersementAide());
    copie.setDateDebutAide(getDateDebutAide());
    copie.setDateFinAide(getDateFinAide());
    copie.setCodeProduit(getCodeProduit());
    copie.setMontantUnitaireAide1(getMontantUnitaireAide1());
    copie.setMontantTotalAide1(getMontantTotalAide1());
    copie.setNbAidesIndemniseesPeriode1(getNbAidesIndemniseesPeriode1());
    copie.setCodeNatureDerogatoireSousProduit1(getCodeNatureDerogatoireSousProduit1());
    copie.setMontantUnitaireAide2(getMontantUnitaireAide2());
    copie.setMontantTotalAide2(getMontantTotalAide2());
    copie.setNbAidesIndemniseesPeriode2(getNbAidesIndemniseesPeriode2());
    copie.setCodeNatureDerogatoireSousProduit2(getCodeNatureDerogatoireSousProduit2());
    copie.setMontantUnitaireAide3(getMontantUnitaireAide3());
    copie.setMontantTotalAide3(getMontantTotalAide3());
    copie.setNbAidesIndemniseesPeriode3(getNbAidesIndemniseesPeriode3());
    copie.setCodeNatureDerogatoireSousProduit3(getCodeNatureDerogatoireSousProduit3());
    copie.setMontantUnitaireAide4(getMontantUnitaireAide4());
    copie.setMontantTotalAide4(getMontantTotalAide4());
    copie.setNbAidesIndemniseesPeriode4(getNbAidesIndemniseesPeriode4());
    copie.setCodeNatureDerogatoireSousProduit4(getCodeNatureDerogatoireSousProduit4());
    copie.setCodeNatureAide(getCodeNatureAide());
    copie.setSiecleAnneeAffectationDecision(getSiecleAnneeAffectationDecision());
    copie.setReferenceExterne(getReferenceExterne());
    copie.setTypePopulation1(getTypePopulation1());
    copie.setSousTypePopulation1(getSousTypePopulation1());
    copie.setStatutPrestation1(getStatutPrestation1());
    copie.setTypePopulation2(getTypePopulation2());
    copie.setSousTypePopulation2(getSousTypePopulation2());
    copie.setStatutPrestation2(getStatutPrestation2());
    copie.setTypePopulation3(getTypePopulation3());
    copie.setSousTypePopulation3(getSousTypePopulation3());
    copie.setStatutPrestation3(getStatutPrestation3());
    copie.setTypePopulation4(getTypePopulation4());
    copie.setSousTypePopulation4(getSousTypePopulation4());
    copie.setStatutPrestation4(getStatutPrestation4());
    copie.setTypePopulation5(getTypePopulation5());
    copie.setSousTypePopulation5(getSousTypePopulation5());
    copie.setStatutPrestation5(getStatutPrestation5());
    copie.setIdPlanFormation(getIdPlanFormation());
    copie.setIdStageFormation(getIdStageFormation());
    copie.setComplementTypeMontant1(getComplementTypeMontant1());
    copie.setComplementTypeMontant2(getComplementTypeMontant2());
    copie.setComplementTypeMontant3(getComplementTypeMontant3());
    copie.setComplementTypeMontant4(getComplementTypeMontant4());
    copie.setCodeSousProduit1(getCodeSousProduit1());
    copie.setCodeSousProduit2(getCodeSousProduit2());
    copie.setCodeSousProduit3(getCodeSousProduit3());
    copie.setCodeSousProduit4(getCodeSousProduit4());
    copie.setCodeSousProduit(getCodeSousProduit());
    if (getTspElementPourEcartsBases() != null)
    {
      copie.setTspElementPourEcartsBases(getTspElementPourEcartsBases());
    }
    else
    {
      Date dateTimestampAvant = (Date)LiDOHelper.getSyntheticValue(getPC(), "{version}");
      if (dateTimestampAvant != null) {
        copie.setTspElementPourEcartsBases(dateTimestampAvant);
      }
    }
  }
  
  public void jdoPreClear() {}
  
  public void jdoPreDelete() {}
  
  public void jdoPostLoad() {}
  
  public void jdoPreStore() {}
  
  public void ajouterTypeSousTypePopulation(String p_type, String p_sousType)
  {
    if (!contientTypeSousTypePopulation(p_type, p_sousType)) {
      if (super.getTypePopulation1() == null)
      {
        super.setTypePopulation1(p_type);
        super.setSousTypePopulation1(p_sousType);
      }
      else if (super.getTypePopulation2() == null)
      {
        super.setTypePopulation2(p_type);
        super.setSousTypePopulation2(p_sousType);
      }
      else if (super.getTypePopulation3() == null)
      {
        super.setTypePopulation3(p_type);
        super.setSousTypePopulation3(p_sousType);
      }
      else if (super.getTypePopulation4() == null)
      {
        super.setTypePopulation4(p_type);
        super.setSousTypePopulation4(p_sousType);
      }
      else if (super.getTypePopulation5() == null)
      {
        super.setTypePopulation5(p_type);
        super.setSousTypePopulation5(p_sousType);
      }
    }
  }
  
  public boolean contientTypeSousTypePopulation(String p_type, String p_sousType)
  {
    if ((p_type != null) && (p_sousType != null))
    {
      if ((p_type.equals(super.getTypePopulation1())) && (p_sousType.equals(super.getSousTypePopulation1()))) {
        return true;
      }
      if ((p_type.equals(super.getTypePopulation2())) && (p_sousType.equals(super.getSousTypePopulation2()))) {
        return true;
      }
      if ((p_type.equals(super.getTypePopulation3())) && (p_sousType.equals(super.getSousTypePopulation3()))) {
        return true;
      }
      if ((p_type.equals(super.getTypePopulation4())) && (p_sousType.equals(super.getSousTypePopulation4()))) {
        return true;
      }
      if ((p_type.equals(super.getTypePopulation5())) && (p_sousType.equals(super.getSousTypePopulation5()))) {
        return true;
      }
    }
    else if (p_type != null)
    {
      if ((p_type.equals(super.getTypePopulation1())) && (super.getSousTypePopulation1() == null)) {
        return true;
      }
      if ((p_type.equals(super.getTypePopulation2())) && (super.getSousTypePopulation2() == null)) {
        return true;
      }
      if ((p_type.equals(super.getTypePopulation3())) && (super.getSousTypePopulation3() == null)) {
        return true;
      }
      if ((p_type.equals(super.getTypePopulation4())) && (super.getSousTypePopulation4() == null)) {
        return true;
      }
      if ((p_type.equals(super.getTypePopulation5())) && (super.getSousTypePopulation5() == null)) {
        return true;
      }
    }
    return false;
  }
  
  public Collection getListeMethodesAExclurePourComparaison()
  {
    Collection listeMethodesAExclure = new ArrayList();
    listeMethodesAExclure.add("getEvenementDebut");
    listeMethodesAExclure.add("getEvenemetFin");
    listeMethodesAExclure.add("estType");
    listeMethodesAExclure.add("estStrictementType");
    listeMethodesAExclure.add("getEtatIndemnisation");
    listeMethodesAExclure.add("getQualificationPeriode");
    listeMethodesAExclure.add("getEtatIndemnisation");
    listeMethodesAExclure.add("getIdentifiantReprise");
    return listeMethodesAExclure;
  }
  
  public Map recupererParametresEcartsBases()
  {
    Map<Object, Object> parametresEcartsBases = new HashMap();
    parametresEcartsBases.put("attributType", "Aide");
    parametresEcartsBases.put("cleTechnique", getIdentifiant());
    String cleFonctionnelle = getDateEffet().formater();
    parametresEcartsBases.put("cleFonctionnelle", cleFonctionnelle);
    parametresEcartsBases.put("timestampAvant", getTspElementPourEcartsBases());
    return parametresEcartsBases;
  }
  
  public boolean estComparableAvec(ElementBasePivotEchangeComparableSpec p_elementAComparer)
  {
    AideNcp elementAComparer = (AideNcp)p_elementAComparer;
    return getDateEffet().coincideAvec(elementAComparer.getDateEffet());
  }
  
  public Collection comparer(ElementBasePivotEchangeComparableSpec p_elementAComparer)
    throws CoucheLogiqueException
  {
    Collection listeEcartsBases = OutilComparaison.comparer(this, p_elementAComparer);
    return listeEcartsBases;
  }
  
  public Date getTspElementPourEcartsBases()
  {
    return m_tspElementPourEcartsBase;
  }
  
  public void setTspElementPourEcartsBases(Date p_tspElementPourEcartBase)
  {
    m_tspElementPourEcartsBase = p_tspElementPourEcartBase;
  }
  
  protected Periode getPeriode()
  {
    return m_periode;
  }
  
  protected void setPeriode(Periode p_periode)
  {
    m_periode = p_periode;
  }
  
  public void ajouterGroupeMontants(String p_codeSousProduit, String p_codeNatureDerogatoire, int p_complementTypeMontant, int p_nbAide, BigDecimal p_montantUnitaire, BigDecimal p_montantTotal)
  {
    if (super.getCodeSousProduit1() == null)
    {
      super.setCodeSousProduit1(p_codeSousProduit);
      super.setComplementTypeMontant1(p_complementTypeMontant);
      super.setCodeNatureDerogatoireSousProduit1(p_codeNatureDerogatoire);
      super.setNbAidesIndemniseesPeriode1(p_nbAide);
      super.setMontantUnitaireAide1(p_montantUnitaire);
      super.setMontantTotalAide1(p_montantTotal);
    }
    else if (super.getCodeSousProduit2() == null)
    {
      super.setCodeSousProduit2(p_codeSousProduit);
      super.setComplementTypeMontant2(p_complementTypeMontant);
      super.setCodeNatureDerogatoireSousProduit2(p_codeNatureDerogatoire);
      super.setNbAidesIndemniseesPeriode2(p_nbAide);
      super.setMontantUnitaireAide2(p_montantUnitaire);
      super.setMontantTotalAide2(p_montantTotal);
    }
    else if (super.getCodeSousProduit3() == null)
    {
      super.setCodeSousProduit3(p_codeSousProduit);
      super.setComplementTypeMontant3(p_complementTypeMontant);
      super.setCodeNatureDerogatoireSousProduit3(p_codeNatureDerogatoire);
      super.setNbAidesIndemniseesPeriode3(p_nbAide);
      super.setMontantUnitaireAide3(p_montantUnitaire);
      super.setMontantTotalAide3(p_montantTotal);
    }
    else if (super.getCodeSousProduit4() == null)
    {
      super.setCodeSousProduit4(p_codeSousProduit);
      super.setComplementTypeMontant4(p_complementTypeMontant);
      super.setCodeNatureDerogatoireSousProduit4(p_codeNatureDerogatoire);
      super.setNbAidesIndemniseesPeriode4(p_nbAide);
      super.setMontantUnitaireAide4(p_montantUnitaire);
      super.setMontantTotalAide4(p_montantTotal);
    }
  }
  
  public void setDateDebutAide(Damj p_dateDebutAide)
  {
    setDateDebut(p_dateDebutAide);
    super.setDateDebutAide(p_dateDebutAide);
  }
  
  public void setDateFinAide(Damj p_dateFinAide)
  {
    setDateFin(p_dateFinAide);
    super.setDateFinAide(p_dateFinAide);
  }
}

/* Location:
 * Qualified Name:     AideNcp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */