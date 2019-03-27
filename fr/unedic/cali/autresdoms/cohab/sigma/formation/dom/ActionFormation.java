package fr.unedic.cali.autresdoms.cohab.sigma.formation.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.formation.dom.spec.ActionFormationSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.formation.dom.spec.PeriodeFormationSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Chronologies;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriode;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ActionFormation
  extends ObjetChronoPeriode
  implements ActionFormationSpec
{
  private int m_identifiantActionFormation;
  private String m_libelleOrganisme;
  private String m_numeroConvention;
  private String m_typeConvention;
  private String m_libelleLieu;
  private String m_affDerogatoire;
  private String m_typePlanFormation;
  private Quantite m_quantiteHoraireTotal;
  private Quantite m_quantiteHoraireHebdo;
  private String m_typeMesureEmploi;
  private int m_motifRupture;
  private int m_formacode;
  private String m_libelle;
  private String m_intitule;
  private String m_codeTiersOrganisme;
  private String m_identifiantConvention;
  private BigDecimal m_plafondConvention;
  private BigDecimal m_pourcentageEngage;
  private String m_etat;
  private Damj m_datePrescription;
  private int m_beneficiaireRSA;
  private int m_categorieFinancement;
  private boolean m_presencePrescriptionFormation = false;
  private String m_origineSaisieFormation;
  
  public String getOrigineSaisieFormation()
  {
    return m_origineSaisieFormation;
  }
  
  public void setOrigineSaisieFormation(String saisieFormation)
  {
    m_origineSaisieFormation = saisieFormation;
  }
  
  public Damj getDatePrescription()
  {
    return m_datePrescription;
  }
  
  public void setDatePrescription(Damj prescription)
  {
    m_datePrescription = prescription;
  }
  
  private Collection m_collectionPeriodesFormation = new ArrayList();
  
  public String getAffDerogatoire()
  {
    return m_affDerogatoire;
  }
  
  public int getIdentifiantActionFormation()
  {
    return m_identifiantActionFormation;
  }
  
  public String getLibelleLieu()
  {
    return m_libelleLieu;
  }
  
  public String getLibelleOrganisme()
  {
    return m_libelleOrganisme;
  }
  
  public String getNumeroConvention()
  {
    return m_numeroConvention;
  }
  
  public Quantite getQuantiteHoraireHebdo()
  {
    return m_quantiteHoraireHebdo;
  }
  
  public Quantite getQuantiteHoraireTotal()
  {
    return m_quantiteHoraireTotal;
  }
  
  public String getTypeConvention()
  {
    return m_typeConvention;
  }
  
  public void setAffDerogatoire(String p_affDerogatoire)
  {
    m_affDerogatoire = p_affDerogatoire;
  }
  
  public void setIdentifiantActionFormation(int p_identifiant)
  {
    m_identifiantActionFormation = p_identifiant;
  }
  
  public void setLibelleLieu(String p_libelleLieu)
  {
    m_libelleLieu = p_libelleLieu;
  }
  
  public void setLibelleOrganisme(String p_libelleOrganisme)
  {
    m_libelleOrganisme = p_libelleOrganisme;
  }
  
  public void setNumeroConvention(String p_numeroConvention)
  {
    m_numeroConvention = p_numeroConvention;
  }
  
  public void setQuantiteHoraireHebdo(Quantite p_quantiteHebdo)
  {
    m_quantiteHoraireHebdo = p_quantiteHebdo;
  }
  
  public void setQuantiteHoraireTotal(Quantite p_quantiteTotal)
  {
    m_quantiteHoraireTotal = p_quantiteTotal;
  }
  
  public void setTypeConvention(String p_typeConvention)
  {
    m_typeConvention = p_typeConvention;
  }
  
  public Chronologie getCollectionPeriodesFormation()
  {
    ChronologiePeriodes chrono = new ChronologiePeriodes();
    chrono.ajouter(m_collectionPeriodesFormation);
    
    return Chronologies.unmodifiableChronologiePeriode(chrono);
  }
  
  public void ajouterPeriodeFormation(PeriodeFormationSpec p_periodeFormation)
  {
    m_collectionPeriodesFormation.add(p_periodeFormation);
  }
  
  public String getTypePlanFormation()
  {
    return m_typePlanFormation;
  }
  
  public void setTypePlanFormation(String p_typePlanFormation)
  {
    m_typePlanFormation = p_typePlanFormation;
  }
  
  public String getTypeMesureEmploi()
  {
    return m_typeMesureEmploi;
  }
  
  public void setTypeMesureEmploi(String p_mesureEmploi)
  {
    m_typeMesureEmploi = p_mesureEmploi;
  }
  
  public int getMotifRupture()
  {
    return m_motifRupture;
  }
  
  public void setMotifRupture(int p_motifRupture)
  {
    m_motifRupture = p_motifRupture;
  }
  
  public String getCodeTiersOrganisme()
  {
    return m_codeTiersOrganisme;
  }
  
  public void setCodeTiersOrganisme(String p_codeTiersOrganisme)
  {
    m_codeTiersOrganisme = p_codeTiersOrganisme;
  }
  
  public int getFormacode()
  {
    return m_formacode;
  }
  
  public void setFormacode(int p_formacode)
  {
    m_formacode = p_formacode;
  }
  
  public String getIdentifiantConvention()
  {
    return m_identifiantConvention;
  }
  
  public void setIdentifiantConvention(String p_identifiantConvention)
  {
    m_identifiantConvention = p_identifiantConvention;
  }
  
  public String getIntitule()
  {
    return m_intitule;
  }
  
  public void setIntitule(String p_intitule)
  {
    m_intitule = p_intitule;
  }
  
  public String getLibelle()
  {
    return m_libelle;
  }
  
  public void setLibelle(String p_libelle)
  {
    m_libelle = p_libelle;
  }
  
  public BigDecimal getPlafondConvention()
  {
    return m_plafondConvention;
  }
  
  public void setPlafondConvention(BigDecimal p_plafondConvention)
  {
    m_plafondConvention = p_plafondConvention;
  }
  
  public BigDecimal getPourcentageEngage()
  {
    return m_pourcentageEngage;
  }
  
  public void setPourcentageEngage(BigDecimal p_pourcentageEngage)
  {
    m_pourcentageEngage = p_pourcentageEngage;
  }
  
  public String getEtat()
  {
    return m_etat;
  }
  
  public void setEtat(String p_etat)
  {
    m_etat = p_etat;
  }
  
  public int getBeneficiaireRSA()
  {
    return m_beneficiaireRSA;
  }
  
  public void setBeneficiaireRSA(int m_beneficiairersa)
  {
    m_beneficiaireRSA = m_beneficiairersa;
  }
  
  public String toString()
  {
    String retour = "Action de Formation n." + getIdentifiantActionFormation() + " :\n\t" + "AffDerogatoire   : " + getAffDerogatoire() + "\n\t" + "Lieu             : " + getLibelleLieu() + "\n\t" + "Organisme        : " + getLibelleOrganisme() + "\n\t" + "No. Convention   : " + getNumeroConvention() + "\n\t" + "Type Convention  : " + getTypeConvention() + "\n\t" + "Type Plan        : " + getTypePlanFormation() + "\n\t" + "Date de Debut    : " + (getDateDebut() == null ? null : getDateDebut().formater()) + "\n\t" + "Date de Fin      : " + (getDateFin() == null ? null : getDateFin().formater()) + "\n\t" + "Nb. heures Hebdo : " + getQuantiteHoraireHebdo() + "\n\t" + "Nb. heures Total : " + getQuantiteHoraireTotal() + "\n\t" + "Periodes de Formation : ";
    
    Iterator it = m_collectionPeriodesFormation.iterator();
    while (it.hasNext()) {
      retour = retour + "\n" + it.next().toString();
    }
    return retour;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    throw new UnsupportedOperationException("La méthode copieElements(ObjetMetierSpec) n'est pas implémentée.");
  }
  
  public ObjetMetierSpec copie()
  {
    throw new UnsupportedOperationException("La méthode copie() n'est pas implémentée.");
  }
  
  public int getCategorieFinancement()
  {
    return m_categorieFinancement;
  }
  
  public void setCategorieFinancement(int financement)
  {
    m_categorieFinancement = financement;
  }
  
  public boolean isPresencePrescriptionFormation()
  {
    return m_presencePrescriptionFormation;
  }
  
  public void setPresencePrescriptionFormation(boolean p_presencePrescriptionFormation)
  {
    m_presencePrescriptionFormation = p_presencePrescriptionFormation;
  }
}

/* Location:
 * Qualified Name:     ActionFormation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */