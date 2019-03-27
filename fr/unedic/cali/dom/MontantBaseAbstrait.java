package fr.unedic.cali.dom;

import fr.unedic.cali.dom.gen.MontantBaseAbstraitGen;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.services.CoucheLogiqueException;
import java.math.BigDecimal;

public abstract class MontantBaseAbstrait
  extends MontantBaseAbstraitGen
  implements MontantBaseSpec
{
  protected transient BigDecimal m_coefficientSaisonnier = null;
  
  protected MontantBaseAbstrait() {}
  
  public MontantBaseAbstrait(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public abstract String getType();
  
  public boolean getAvecPrecompteCRC()
  {
    return super.isEstAvecPrecompte();
  }
  
  public void setAvecPrecompteCRC(boolean p_avecPrecompteCRC)
  {
    super.setEstAvecPrecompte(p_avecPrecompteCRC);
  }
  
  public abstract String getJustificationCalculMontant();
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    MontantBaseAbstrait copie = (MontantBaseAbstrait)p_copie;
    copie.setMontantBrut(getMontantBrut());
    copie.setCrc(getCrc());
    copie.setAvecPrecompteCRC(getAvecPrecompteCRC());
  }
  
  public String getIdentifiant()
  {
    return DomManager.getIdentifiant(this);
  }
  
  public void marquerGraphePersistant() {}
  
  public void jdoPreClear() {}
  
  public void jdoPreDelete() {}
  
  public void jdoPostLoad() {}
  
  public void jdoPreStore() {}
  
  protected Object clone()
    throws CloneNotSupportedException
  {
    return super.clone();
  }
  
  public boolean equals(Object p_arg0)
  {
    return super.equals(p_arg0);
  }
  
  protected void finalize()
    throws Throwable
  {
    super.finalize();
  }
  
  public int hashCode()
  {
    return super.hashCode();
  }
  
  public String toString()
  {
    return super.toString();
  }
  
  public Quantite getBase()
  {
    return null;
  }
  
  public BigDecimal getBaseCalculCrc()
  {
    return null;
  }
  
  public Quantite getCotisationContribution()
  {
    return null;
  }
  
  public Quantite getCrds()
  {
    return null;
  }
  
  public Quantite getCsg()
  {
    return null;
  }
  
  public Quantite getMini()
  {
    return null;
  }
  
  public Quantite getMontantBrutSansPensionInvaliditeADeduire()
  {
    return null;
  }
  
  public Quantite getMontantBrutSansAvantageVieillesseDeduit()
    throws CoucheLogiqueException
  {
    GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_PRODUIT_METHODE_NON_IMPLEMENTE");
    return null;
  }
  
  public Quantite getMontantJournalierAvantageVieillesse()
  {
    return null;
  }
  
  public Quantite getMontantJournalierAvantageVieillesseDeduit()
  {
    return null;
  }
  
  public Quantite getMontantNet()
  {
    return null;
  }
  
  public BigDecimal getMontantPrecompte()
  {
    return null;
  }
  
  public Quantite getMontantPrecompteEffectif()
  {
    return null;
  }
  
  public Quantite getPensionInvaliditeADeduirePriseEnCompte()
  {
    return null;
  }
  
  public Quantite getPlafond()
  {
    return null;
  }
  
  public Quantite getPlancher()
  {
    return null;
  }
  
  public String getPositionExonerationCrc()
  {
    return null;
  }
  
  public BigDecimal getSjrNonReduit()
  {
    return null;
  }
  
  public BigDecimal getTauxCrc()
  {
    return null;
  }
  
  public void setJustificationCalculMontant(String p_justificationCalculMontant) {}
  
  public void setType(String p_type) {}
  
  public Quantite getMontant80PcentPreavis()
  {
    return null;
  }
  
  public Quantite getMiniFormation()
  {
    return null;
  }
  
  public BigDecimal getMontantFinancement()
  {
    return null;
  }
  
  public BigDecimal getMontantReduit()
  {
    return null;
  }
  
  public ObjetMetierSpec copie()
  {
    return null;
  }
  
  protected DomPCSpec createPC()
  {
    return null;
  }
  
  public BigDecimal getCoefficientSaisonnier()
  {
    return m_coefficientSaisonnier;
  }
  
  public void setCoefficientSaisonnier(BigDecimal p_coefficientSaisonnier)
  {
    m_coefficientSaisonnier = p_coefficientSaisonnier;
  }
}

/* Location:
 * Qualified Name:     MontantBaseAbstrait
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */