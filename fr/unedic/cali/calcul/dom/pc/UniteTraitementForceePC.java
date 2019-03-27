package fr.unedic.cali.calcul.dom.pc;

import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.temps.ObjetChronoPeriodePC;
import fr.unedic.util.temps.Periode;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import javax.jdo.JDOFatalInternalException;
import javax.jdo.JDOUnsupportedOptionException;
import javax.jdo.JDOUserException;
import javax.jdo.PersistenceManager;
import javax.jdo.spi.JDOImplHelper;
import javax.jdo.spi.JDOPermission;
import javax.jdo.spi.PersistenceCapable;
import javax.jdo.spi.PersistenceCapable.ObjectIdFieldConsumer;
import javax.jdo.spi.PersistenceCapable.ObjectIdFieldSupplier;
import javax.jdo.spi.StateManager;
import xcalia.lido.internal.sm.CommonStateManager;

public abstract class UniteTraitementForceePC
  extends ObjetChronoPeriodePC
  implements DomPCSpec, PersistenceCapable
{
  protected int m_statut;
  protected boolean m_isStatutForce;
  protected Quantite m_creditDecalage;
  protected boolean m_isCreditDecalageForce;
  protected Quantite m_creditDecalagePNDS;
  protected boolean m_isCreditDecalagePNDSForce;
  protected int m_commissionParitaire;
  protected boolean m_isCommissionParitaireForcee;
  protected int m_repriseMemeEmployeur;
  protected boolean m_isRepriseMemeEmployeurForcee;
  protected int m_typeNeutralisation;
  protected boolean m_typeNeutralisationForce;
  protected int m_estNeutralisee;
  protected boolean m_estNeutraliseForcee;
  protected boolean m_estDeblocageVariationRenumeration;
  protected boolean m_isDeblocageVariationRenumeration;
  protected boolean m_estDeblocageSeuil;
  protected boolean m_isDeblocageSeuil;
  private BigDecimal m_montantNetRevenusActiviteReprise;
  private boolean m_isMontantNetRevenusActiviteReprise;
  private boolean m_isCumulARSurUtForce;
  private int m_cumulARsurUtForce;
  private boolean m_passsDesactive;
  private boolean m_estLeverBlocageDV;
  private boolean m_estIgnorerAEDV;
  protected String m_motif;
  protected transient byte jdoFlags;
  protected transient StateManager jdoStateManager;
  private static int jdoInheritedFieldCount = 0;
  private static String[] jdoFieldNames = { "m_periode", "m_statut", "m_isStatutForce", "m_creditDecalage", "m_isCreditDecalageForce", "m_creditDecalagePNDS", "m_isCreditDecalagePNDSForce", "m_commissionParitaire", "m_isCommissionParitaireForcee", "m_repriseMemeEmployeur", "m_isRepriseMemeEmployeurForcee", "m_typeNeutralisation", "m_typeNeutralisationForce", "m_estNeutralisee", "m_estNeutraliseForcee", "m_estDeblocageVariationRenumeration", "m_isDeblocageVariationRenumeration", "m_estDeblocageSeuil", "m_isDeblocageSeuil", "m_montantNetRevenusActiviteReprise", "m_isMontantNetRevenusActiviteReprise", "m_isCumulARSurUtForce", "m_cumulARsurUtForce", "m_passsDesactive", "m_estLeverBlocageDV", "m_estIgnorerAEDV", "m_motif" };
  private static Class[] jdoFieldTypes = { Periode.class, Integer.TYPE, Boolean.TYPE, Quantite.class, Boolean.TYPE, Quantite.class, Boolean.TYPE, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, BigDecimal.class, Boolean.TYPE, Boolean.TYPE, Integer.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, String.class };
  private static byte[] jdoFieldFlags = { (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE) };
  private static Class jdoPersistenceCapableSuperclass = null;
  static final long serialVersionUID = 2872843796327541844L;
  
  public UniteTraitementForceePC()
  {
    jdoSetm_typeNeutralisationForce(this, false);
    
    jdoSetm_estNeutraliseForcee(this, false);
    
    jdoSetm_passsDesactive(this, false);
    jdoSetm_estLeverBlocageDV(this, false);
    jdoSetm_estIgnorerAEDV(this, false);
  }
  
  public abstract Object createOM();
  
  public int getStatut()
  {
    return jdoGetm_statut(this);
  }
  
  public final void setStatut(int p_statut)
  {
    jdoSetm_statut(this, p_statut);
  }
  
  public boolean isIsStatutForce()
  {
    return jdoGetm_isStatutForce(this);
  }
  
  public final void setIsStatutForce(boolean p_isStatutForce)
  {
    jdoSetm_isStatutForce(this, p_isStatutForce);
  }
  
  public Quantite getCreditDecalage()
  {
    return jdoGetm_creditDecalage(this);
  }
  
  public final void setCreditDecalage(Quantite p_creditDecalage)
  {
    jdoSetm_creditDecalage(this, p_creditDecalage);
  }
  
  public boolean isIsCreditDecalageForce()
  {
    return jdoGetm_isCreditDecalageForce(this);
  }
  
  public final void setIsCreditDecalageForce(boolean p_isCreditDecalageForce)
  {
    jdoSetm_isCreditDecalageForce(this, p_isCreditDecalageForce);
  }
  
  public Quantite getCreditDecalagePNDS()
  {
    return jdoGetm_creditDecalagePNDS(this);
  }
  
  public final void setCreditDecalagePNDS(Quantite p_creditDecalagePNDS)
  {
    jdoSetm_creditDecalagePNDS(this, p_creditDecalagePNDS);
  }
  
  public boolean isIsCreditDecalagePNDSForce()
  {
    return jdoGetm_isCreditDecalagePNDSForce(this);
  }
  
  public final void setIsCreditDecalagePNDSForce(boolean p_isCreditDecalagePNDSForce)
  {
    jdoSetm_isCreditDecalagePNDSForce(this, p_isCreditDecalagePNDSForce);
  }
  
  public int getCommissionParitaire()
  {
    return jdoGetm_commissionParitaire(this);
  }
  
  public final void setCommissionParitaire(int p_commissionParitaire)
  {
    jdoSetm_commissionParitaire(this, p_commissionParitaire);
  }
  
  public boolean isIsCommissionParitaireForcee()
  {
    return jdoGetm_isCommissionParitaireForcee(this);
  }
  
  public final void setIsCommissionParitaireForcee(boolean p_isCommissionParitaireForcee)
  {
    jdoSetm_isCommissionParitaireForcee(this, p_isCommissionParitaireForcee);
  }
  
  public int getRepriseMemeEmployeur()
  {
    return jdoGetm_repriseMemeEmployeur(this);
  }
  
  public final void setRepriseMemeEmployeur(int p_repriseMemeEmployeur)
  {
    jdoSetm_repriseMemeEmployeur(this, p_repriseMemeEmployeur);
  }
  
  public boolean isIsRepriseMemeEmployeurForcee()
  {
    return jdoGetm_isRepriseMemeEmployeurForcee(this);
  }
  
  public final void setIsRepriseMemeEmployeurForcee(boolean p_isRepriseMemeEmployeurForcee)
  {
    jdoSetm_isRepriseMemeEmployeurForcee(this, p_isRepriseMemeEmployeurForcee);
  }
  
  public int getTypeNeutralisation()
  {
    return jdoGetm_typeNeutralisation(this);
  }
  
  public final void setTypeNeutralisation(int p_typeNeutralisation)
  {
    jdoSetm_typeNeutralisation(this, p_typeNeutralisation);
  }
  
  public boolean isTypeNeutralisationForce()
  {
    return jdoGetm_typeNeutralisationForce(this);
  }
  
  public final void setTypeNeutralisationForce(boolean p_typeNeutralisationForce)
  {
    jdoSetm_typeNeutralisationForce(this, p_typeNeutralisationForce);
  }
  
  public int getEstNeutralisee()
  {
    return jdoGetm_estNeutralisee(this);
  }
  
  public final void setEstNeutralisee(int p_estNeutralisee)
  {
    jdoSetm_estNeutralisee(this, p_estNeutralisee);
  }
  
  public boolean isEstNeutraliseForcee()
  {
    return jdoGetm_estNeutraliseForcee(this);
  }
  
  public final void setEstNeutraliseForcee(boolean p_estNeutraliseForcee)
  {
    jdoSetm_estNeutraliseForcee(this, p_estNeutraliseForcee);
  }
  
  public boolean isEstDeblocageVariationRenumeration()
  {
    return jdoGetm_estDeblocageVariationRenumeration(this);
  }
  
  public final void setEstDeblocageVariationRenumeration(boolean p_estDeblocageVariationRenumeration)
  {
    jdoSetm_estDeblocageVariationRenumeration(this, p_estDeblocageVariationRenumeration);
  }
  
  public boolean isIsDeblocageVariationRenumeration()
  {
    return jdoGetm_isDeblocageVariationRenumeration(this);
  }
  
  public final void setIsDeblocageVariationRenumeration(boolean p_isDeblocageVariationRenumeration)
  {
    jdoSetm_isDeblocageVariationRenumeration(this, p_isDeblocageVariationRenumeration);
  }
  
  public boolean isEstDeblocageSeuil()
  {
    return jdoGetm_estDeblocageSeuil(this);
  }
  
  public final void setEstDeblocageSeuil(boolean p_estDeblocageSeuil)
  {
    jdoSetm_estDeblocageSeuil(this, p_estDeblocageSeuil);
  }
  
  public boolean isIsDeblocageSeuil()
  {
    return jdoGetm_isDeblocageSeuil(this);
  }
  
  public final void setIsDeblocageSeuil(boolean p_isDeblocageSeuil)
  {
    jdoSetm_isDeblocageSeuil(this, p_isDeblocageSeuil);
  }
  
  public BigDecimal getMontantNetRevenusActiviteReprise()
  {
    return jdoGetm_montantNetRevenusActiviteReprise(this);
  }
  
  public final void setMontantNetRevenusActiviteReprise(BigDecimal p_montantNetRevenusActiviteReprise)
  {
    jdoSetm_montantNetRevenusActiviteReprise(this, p_montantNetRevenusActiviteReprise);
  }
  
  public boolean isIsMontantNetRevenusActiviteReprise()
  {
    return jdoGetm_isMontantNetRevenusActiviteReprise(this);
  }
  
  public final void setIsMontantNetRevenusActiviteReprise(boolean p_isMontantNetRevenusActiviteReprise)
  {
    jdoSetm_isMontantNetRevenusActiviteReprise(this, p_isMontantNetRevenusActiviteReprise);
  }
  
  public boolean isIsCumulARSurUtForce()
  {
    return jdoGetm_isCumulARSurUtForce(this);
  }
  
  public final void setIsCumulARSurUtForce(boolean p_isCumulARSurUtForce)
  {
    jdoSetm_isCumulARSurUtForce(this, p_isCumulARSurUtForce);
  }
  
  public int getCumulARsurUtForce()
  {
    return jdoGetm_cumulARsurUtForce(this);
  }
  
  public final void setCumulARsurUtForce(int p_cumulARsurUtForce)
  {
    jdoSetm_cumulARsurUtForce(this, p_cumulARsurUtForce);
  }
  
  public boolean isPasssDesactive()
  {
    return jdoGetm_passsDesactive(this);
  }
  
  public final void setPasssDesactive(boolean p_passsDesactive)
  {
    jdoSetm_passsDesactive(this, p_passsDesactive);
  }
  
  public boolean isEstLeverBlocageDV()
  {
    return jdoGetm_estLeverBlocageDV(this);
  }
  
  public final void setEstLeverBlocageDV(boolean p_estLeverBlocageDV)
  {
    jdoSetm_estLeverBlocageDV(this, p_estLeverBlocageDV);
  }
  
  public boolean isEstIgnorerAEDV()
  {
    return jdoGetm_estIgnorerAEDV(this);
  }
  
  public final void setEstIgnorerAEDV(boolean p_estIgnorerAEDV)
  {
    jdoSetm_estIgnorerAEDV(this, p_estIgnorerAEDV);
  }
  
  public String getMotif()
  {
    return jdoGetm_motif(this);
  }
  
  public final void setMotif(String p_motif)
  {
    jdoSetm_motif(this, p_motif);
  }
  
  static
  {
    JDOImplHelper.registerClass(UniteTraitementForceePC.class, jdoFieldNames, jdoFieldTypes, jdoFieldFlags, jdoPersistenceCapableSuperclass, null);
  }
  
  protected static final Periode jdoGetm_periode(UniteTraitementForceePC pc)
  {
    if (jdoFlags <= 0) {
      return m_periode;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 0)) {
        return m_periode;
      }
      return (Periode)sm.getObjectField(pc, jdoInheritedFieldCount + 0, m_periode);
    }
    return m_periode;
  }
  
  protected static final int jdoGetm_statut(UniteTraitementForceePC pc)
  {
    if (jdoFlags <= 0) {
      return m_statut;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 1)) {
        return m_statut;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 1, m_statut);
    }
    return m_statut;
  }
  
  protected static final boolean jdoGetm_isStatutForce(UniteTraitementForceePC pc)
  {
    if (jdoFlags <= 0) {
      return m_isStatutForce;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 2)) {
        return m_isStatutForce;
      }
      return sm.getBooleanField(pc, jdoInheritedFieldCount + 2, m_isStatutForce);
    }
    return m_isStatutForce;
  }
  
  protected static final Quantite jdoGetm_creditDecalage(UniteTraitementForceePC pc)
  {
    if (jdoFlags <= 0) {
      return m_creditDecalage;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 3)) {
        return m_creditDecalage;
      }
      return (Quantite)sm.getObjectField(pc, jdoInheritedFieldCount + 3, m_creditDecalage);
    }
    return m_creditDecalage;
  }
  
  protected static final boolean jdoGetm_isCreditDecalageForce(UniteTraitementForceePC pc)
  {
    if (jdoFlags <= 0) {
      return m_isCreditDecalageForce;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 4)) {
        return m_isCreditDecalageForce;
      }
      return sm.getBooleanField(pc, jdoInheritedFieldCount + 4, m_isCreditDecalageForce);
    }
    return m_isCreditDecalageForce;
  }
  
  protected static final Quantite jdoGetm_creditDecalagePNDS(UniteTraitementForceePC pc)
  {
    if (jdoFlags <= 0) {
      return m_creditDecalagePNDS;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 5)) {
        return m_creditDecalagePNDS;
      }
      return (Quantite)sm.getObjectField(pc, jdoInheritedFieldCount + 5, m_creditDecalagePNDS);
    }
    return m_creditDecalagePNDS;
  }
  
  protected static final boolean jdoGetm_isCreditDecalagePNDSForce(UniteTraitementForceePC pc)
  {
    if (jdoFlags <= 0) {
      return m_isCreditDecalagePNDSForce;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 6)) {
        return m_isCreditDecalagePNDSForce;
      }
      return sm.getBooleanField(pc, jdoInheritedFieldCount + 6, m_isCreditDecalagePNDSForce);
    }
    return m_isCreditDecalagePNDSForce;
  }
  
  protected static final int jdoGetm_commissionParitaire(UniteTraitementForceePC pc)
  {
    if (jdoFlags <= 0) {
      return m_commissionParitaire;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 7)) {
        return m_commissionParitaire;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 7, m_commissionParitaire);
    }
    return m_commissionParitaire;
  }
  
  protected static final boolean jdoGetm_isCommissionParitaireForcee(UniteTraitementForceePC pc)
  {
    if (jdoFlags <= 0) {
      return m_isCommissionParitaireForcee;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 8)) {
        return m_isCommissionParitaireForcee;
      }
      return sm.getBooleanField(pc, jdoInheritedFieldCount + 8, m_isCommissionParitaireForcee);
    }
    return m_isCommissionParitaireForcee;
  }
  
  protected static final int jdoGetm_repriseMemeEmployeur(UniteTraitementForceePC pc)
  {
    if (jdoFlags <= 0) {
      return m_repriseMemeEmployeur;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 9)) {
        return m_repriseMemeEmployeur;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 9, m_repriseMemeEmployeur);
    }
    return m_repriseMemeEmployeur;
  }
  
  protected static final boolean jdoGetm_isRepriseMemeEmployeurForcee(UniteTraitementForceePC pc)
  {
    if (jdoFlags <= 0) {
      return m_isRepriseMemeEmployeurForcee;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 10)) {
        return m_isRepriseMemeEmployeurForcee;
      }
      return sm.getBooleanField(pc, jdoInheritedFieldCount + 10, m_isRepriseMemeEmployeurForcee);
    }
    return m_isRepriseMemeEmployeurForcee;
  }
  
  protected static final int jdoGetm_typeNeutralisation(UniteTraitementForceePC pc)
  {
    if (jdoFlags <= 0) {
      return m_typeNeutralisation;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 11)) {
        return m_typeNeutralisation;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 11, m_typeNeutralisation);
    }
    return m_typeNeutralisation;
  }
  
  protected static final boolean jdoGetm_typeNeutralisationForce(UniteTraitementForceePC pc)
  {
    if (jdoFlags <= 0) {
      return m_typeNeutralisationForce;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 12)) {
        return m_typeNeutralisationForce;
      }
      return sm.getBooleanField(pc, jdoInheritedFieldCount + 12, m_typeNeutralisationForce);
    }
    return m_typeNeutralisationForce;
  }
  
  protected static final int jdoGetm_estNeutralisee(UniteTraitementForceePC pc)
  {
    if (jdoFlags <= 0) {
      return m_estNeutralisee;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 13)) {
        return m_estNeutralisee;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 13, m_estNeutralisee);
    }
    return m_estNeutralisee;
  }
  
  protected static final boolean jdoGetm_estNeutraliseForcee(UniteTraitementForceePC pc)
  {
    if (jdoFlags <= 0) {
      return m_estNeutraliseForcee;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 14)) {
        return m_estNeutraliseForcee;
      }
      return sm.getBooleanField(pc, jdoInheritedFieldCount + 14, m_estNeutraliseForcee);
    }
    return m_estNeutraliseForcee;
  }
  
  protected static final boolean jdoGetm_estDeblocageVariationRenumeration(UniteTraitementForceePC pc)
  {
    if (jdoFlags <= 0) {
      return m_estDeblocageVariationRenumeration;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 15)) {
        return m_estDeblocageVariationRenumeration;
      }
      return sm.getBooleanField(pc, jdoInheritedFieldCount + 15, m_estDeblocageVariationRenumeration);
    }
    return m_estDeblocageVariationRenumeration;
  }
  
  protected static final boolean jdoGetm_isDeblocageVariationRenumeration(UniteTraitementForceePC pc)
  {
    if (jdoFlags <= 0) {
      return m_isDeblocageVariationRenumeration;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 16)) {
        return m_isDeblocageVariationRenumeration;
      }
      return sm.getBooleanField(pc, jdoInheritedFieldCount + 16, m_isDeblocageVariationRenumeration);
    }
    return m_isDeblocageVariationRenumeration;
  }
  
  protected static final boolean jdoGetm_estDeblocageSeuil(UniteTraitementForceePC pc)
  {
    if (jdoFlags <= 0) {
      return m_estDeblocageSeuil;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 17)) {
        return m_estDeblocageSeuil;
      }
      return sm.getBooleanField(pc, jdoInheritedFieldCount + 17, m_estDeblocageSeuil);
    }
    return m_estDeblocageSeuil;
  }
  
  protected static final boolean jdoGetm_isDeblocageSeuil(UniteTraitementForceePC pc)
  {
    if (jdoFlags <= 0) {
      return m_isDeblocageSeuil;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 18)) {
        return m_isDeblocageSeuil;
      }
      return sm.getBooleanField(pc, jdoInheritedFieldCount + 18, m_isDeblocageSeuil);
    }
    return m_isDeblocageSeuil;
  }
  
  private static final BigDecimal jdoGetm_montantNetRevenusActiviteReprise(UniteTraitementForceePC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantNetRevenusActiviteReprise;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 19)) {
        return m_montantNetRevenusActiviteReprise;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 19, m_montantNetRevenusActiviteReprise);
    }
    return m_montantNetRevenusActiviteReprise;
  }
  
  private static final boolean jdoGetm_isMontantNetRevenusActiviteReprise(UniteTraitementForceePC pc)
  {
    if (jdoFlags <= 0) {
      return m_isMontantNetRevenusActiviteReprise;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 20)) {
        return m_isMontantNetRevenusActiviteReprise;
      }
      return sm.getBooleanField(pc, jdoInheritedFieldCount + 20, m_isMontantNetRevenusActiviteReprise);
    }
    return m_isMontantNetRevenusActiviteReprise;
  }
  
  private static final boolean jdoGetm_isCumulARSurUtForce(UniteTraitementForceePC pc)
  {
    if (jdoFlags <= 0) {
      return m_isCumulARSurUtForce;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 21)) {
        return m_isCumulARSurUtForce;
      }
      return sm.getBooleanField(pc, jdoInheritedFieldCount + 21, m_isCumulARSurUtForce);
    }
    return m_isCumulARSurUtForce;
  }
  
  private static final int jdoGetm_cumulARsurUtForce(UniteTraitementForceePC pc)
  {
    if (jdoFlags <= 0) {
      return m_cumulARsurUtForce;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 22)) {
        return m_cumulARsurUtForce;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 22, m_cumulARsurUtForce);
    }
    return m_cumulARsurUtForce;
  }
  
  private static final boolean jdoGetm_passsDesactive(UniteTraitementForceePC pc)
  {
    if (jdoFlags <= 0) {
      return m_passsDesactive;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 23)) {
        return m_passsDesactive;
      }
      return sm.getBooleanField(pc, jdoInheritedFieldCount + 23, m_passsDesactive);
    }
    return m_passsDesactive;
  }
  
  private static final boolean jdoGetm_estLeverBlocageDV(UniteTraitementForceePC pc)
  {
    if (jdoFlags <= 0) {
      return m_estLeverBlocageDV;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 24)) {
        return m_estLeverBlocageDV;
      }
      return sm.getBooleanField(pc, jdoInheritedFieldCount + 24, m_estLeverBlocageDV);
    }
    return m_estLeverBlocageDV;
  }
  
  private static final boolean jdoGetm_estIgnorerAEDV(UniteTraitementForceePC pc)
  {
    if (jdoFlags <= 0) {
      return m_estIgnorerAEDV;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 25)) {
        return m_estIgnorerAEDV;
      }
      return sm.getBooleanField(pc, jdoInheritedFieldCount + 25, m_estIgnorerAEDV);
    }
    return m_estIgnorerAEDV;
  }
  
  protected static final String jdoGetm_motif(UniteTraitementForceePC pc)
  {
    if (jdoFlags <= 0) {
      return m_motif;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 26)) {
        return m_motif;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 26, m_motif);
    }
    return m_motif;
  }
  
  protected static final void jdoSetm_periode(UniteTraitementForceePC pc, Periode newValue)
  {
    if (jdoFlags == 0)
    {
      m_periode = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 0, m_periode, newValue);
    } else {
      m_periode = newValue;
    }
  }
  
  protected static final void jdoSetm_statut(UniteTraitementForceePC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_statut = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 1, m_statut, newValue);
    } else {
      m_statut = newValue;
    }
  }
  
  protected static final void jdoSetm_isStatutForce(UniteTraitementForceePC pc, boolean newValue)
  {
    if (jdoFlags == 0)
    {
      m_isStatutForce = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setBooleanField(pc, jdoInheritedFieldCount + 2, m_isStatutForce, newValue);
    } else {
      m_isStatutForce = newValue;
    }
  }
  
  protected static final void jdoSetm_creditDecalage(UniteTraitementForceePC pc, Quantite newValue)
  {
    if (jdoFlags == 0)
    {
      m_creditDecalage = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 3, m_creditDecalage, newValue);
    } else {
      m_creditDecalage = newValue;
    }
  }
  
  protected static final void jdoSetm_isCreditDecalageForce(UniteTraitementForceePC pc, boolean newValue)
  {
    if (jdoFlags == 0)
    {
      m_isCreditDecalageForce = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setBooleanField(pc, jdoInheritedFieldCount + 4, m_isCreditDecalageForce, newValue);
    } else {
      m_isCreditDecalageForce = newValue;
    }
  }
  
  protected static final void jdoSetm_creditDecalagePNDS(UniteTraitementForceePC pc, Quantite newValue)
  {
    if (jdoFlags == 0)
    {
      m_creditDecalagePNDS = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 5, m_creditDecalagePNDS, newValue);
    } else {
      m_creditDecalagePNDS = newValue;
    }
  }
  
  protected static final void jdoSetm_isCreditDecalagePNDSForce(UniteTraitementForceePC pc, boolean newValue)
  {
    if (jdoFlags == 0)
    {
      m_isCreditDecalagePNDSForce = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setBooleanField(pc, jdoInheritedFieldCount + 6, m_isCreditDecalagePNDSForce, newValue);
    } else {
      m_isCreditDecalagePNDSForce = newValue;
    }
  }
  
  protected static final void jdoSetm_commissionParitaire(UniteTraitementForceePC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_commissionParitaire = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 7, m_commissionParitaire, newValue);
    } else {
      m_commissionParitaire = newValue;
    }
  }
  
  protected static final void jdoSetm_isCommissionParitaireForcee(UniteTraitementForceePC pc, boolean newValue)
  {
    if (jdoFlags == 0)
    {
      m_isCommissionParitaireForcee = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setBooleanField(pc, jdoInheritedFieldCount + 8, m_isCommissionParitaireForcee, newValue);
    } else {
      m_isCommissionParitaireForcee = newValue;
    }
  }
  
  protected static final void jdoSetm_repriseMemeEmployeur(UniteTraitementForceePC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_repriseMemeEmployeur = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 9, m_repriseMemeEmployeur, newValue);
    } else {
      m_repriseMemeEmployeur = newValue;
    }
  }
  
  protected static final void jdoSetm_isRepriseMemeEmployeurForcee(UniteTraitementForceePC pc, boolean newValue)
  {
    if (jdoFlags == 0)
    {
      m_isRepriseMemeEmployeurForcee = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setBooleanField(pc, jdoInheritedFieldCount + 10, m_isRepriseMemeEmployeurForcee, newValue);
    } else {
      m_isRepriseMemeEmployeurForcee = newValue;
    }
  }
  
  protected static final void jdoSetm_typeNeutralisation(UniteTraitementForceePC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_typeNeutralisation = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 11, m_typeNeutralisation, newValue);
    } else {
      m_typeNeutralisation = newValue;
    }
  }
  
  protected static final void jdoSetm_typeNeutralisationForce(UniteTraitementForceePC pc, boolean newValue)
  {
    if (jdoFlags == 0)
    {
      m_typeNeutralisationForce = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setBooleanField(pc, jdoInheritedFieldCount + 12, m_typeNeutralisationForce, newValue);
    } else {
      m_typeNeutralisationForce = newValue;
    }
  }
  
  protected static final void jdoSetm_estNeutralisee(UniteTraitementForceePC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_estNeutralisee = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 13, m_estNeutralisee, newValue);
    } else {
      m_estNeutralisee = newValue;
    }
  }
  
  protected static final void jdoSetm_estNeutraliseForcee(UniteTraitementForceePC pc, boolean newValue)
  {
    if (jdoFlags == 0)
    {
      m_estNeutraliseForcee = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setBooleanField(pc, jdoInheritedFieldCount + 14, m_estNeutraliseForcee, newValue);
    } else {
      m_estNeutraliseForcee = newValue;
    }
  }
  
  protected static final void jdoSetm_estDeblocageVariationRenumeration(UniteTraitementForceePC pc, boolean newValue)
  {
    if (jdoFlags == 0)
    {
      m_estDeblocageVariationRenumeration = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setBooleanField(pc, jdoInheritedFieldCount + 15, m_estDeblocageVariationRenumeration, newValue);
    } else {
      m_estDeblocageVariationRenumeration = newValue;
    }
  }
  
  protected static final void jdoSetm_isDeblocageVariationRenumeration(UniteTraitementForceePC pc, boolean newValue)
  {
    if (jdoFlags == 0)
    {
      m_isDeblocageVariationRenumeration = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setBooleanField(pc, jdoInheritedFieldCount + 16, m_isDeblocageVariationRenumeration, newValue);
    } else {
      m_isDeblocageVariationRenumeration = newValue;
    }
  }
  
  protected static final void jdoSetm_estDeblocageSeuil(UniteTraitementForceePC pc, boolean newValue)
  {
    if (jdoFlags == 0)
    {
      m_estDeblocageSeuil = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setBooleanField(pc, jdoInheritedFieldCount + 17, m_estDeblocageSeuil, newValue);
    } else {
      m_estDeblocageSeuil = newValue;
    }
  }
  
  protected static final void jdoSetm_isDeblocageSeuil(UniteTraitementForceePC pc, boolean newValue)
  {
    if (jdoFlags == 0)
    {
      m_isDeblocageSeuil = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setBooleanField(pc, jdoInheritedFieldCount + 18, m_isDeblocageSeuil, newValue);
    } else {
      m_isDeblocageSeuil = newValue;
    }
  }
  
  private static final void jdoSetm_montantNetRevenusActiviteReprise(UniteTraitementForceePC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantNetRevenusActiviteReprise = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 19, m_montantNetRevenusActiviteReprise, newValue);
    } else {
      m_montantNetRevenusActiviteReprise = newValue;
    }
  }
  
  private static final void jdoSetm_isMontantNetRevenusActiviteReprise(UniteTraitementForceePC pc, boolean newValue)
  {
    if (jdoFlags == 0)
    {
      m_isMontantNetRevenusActiviteReprise = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setBooleanField(pc, jdoInheritedFieldCount + 20, m_isMontantNetRevenusActiviteReprise, newValue);
    } else {
      m_isMontantNetRevenusActiviteReprise = newValue;
    }
  }
  
  private static final void jdoSetm_isCumulARSurUtForce(UniteTraitementForceePC pc, boolean newValue)
  {
    if (jdoFlags == 0)
    {
      m_isCumulARSurUtForce = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setBooleanField(pc, jdoInheritedFieldCount + 21, m_isCumulARSurUtForce, newValue);
    } else {
      m_isCumulARSurUtForce = newValue;
    }
  }
  
  private static final void jdoSetm_cumulARsurUtForce(UniteTraitementForceePC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_cumulARsurUtForce = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 22, m_cumulARsurUtForce, newValue);
    } else {
      m_cumulARsurUtForce = newValue;
    }
  }
  
  private static final void jdoSetm_passsDesactive(UniteTraitementForceePC pc, boolean newValue)
  {
    if (jdoFlags == 0)
    {
      m_passsDesactive = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setBooleanField(pc, jdoInheritedFieldCount + 23, m_passsDesactive, newValue);
    } else {
      m_passsDesactive = newValue;
    }
  }
  
  private static final void jdoSetm_estLeverBlocageDV(UniteTraitementForceePC pc, boolean newValue)
  {
    if (jdoFlags == 0)
    {
      m_estLeverBlocageDV = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setBooleanField(pc, jdoInheritedFieldCount + 24, m_estLeverBlocageDV, newValue);
    } else {
      m_estLeverBlocageDV = newValue;
    }
  }
  
  private static final void jdoSetm_estIgnorerAEDV(UniteTraitementForceePC pc, boolean newValue)
  {
    if (jdoFlags == 0)
    {
      m_estIgnorerAEDV = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setBooleanField(pc, jdoInheritedFieldCount + 25, m_estIgnorerAEDV, newValue);
    } else {
      m_estIgnorerAEDV = newValue;
    }
  }
  
  protected static final void jdoSetm_motif(UniteTraitementForceePC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_motif = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 26, m_motif, newValue);
    } else {
      m_motif = newValue;
    }
  }
  
  public void jdoProvideField(int fieldNumber)
  {
    int relativeField = fieldNumber - jdoInheritedFieldCount;
    switch (relativeField)
    {
    case 0: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_periode);
      break;
    case 1: 
      jdoStateManager.providedIntField(this, fieldNumber, m_statut);
      break;
    case 2: 
      jdoStateManager.providedBooleanField(this, fieldNumber, m_isStatutForce);
      break;
    case 3: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_creditDecalage);
      break;
    case 4: 
      jdoStateManager.providedBooleanField(this, fieldNumber, m_isCreditDecalageForce);
      break;
    case 5: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_creditDecalagePNDS);
      break;
    case 6: 
      jdoStateManager.providedBooleanField(this, fieldNumber, m_isCreditDecalagePNDSForce);
      break;
    case 7: 
      jdoStateManager.providedIntField(this, fieldNumber, m_commissionParitaire);
      break;
    case 8: 
      jdoStateManager.providedBooleanField(this, fieldNumber, m_isCommissionParitaireForcee);
      break;
    case 9: 
      jdoStateManager.providedIntField(this, fieldNumber, m_repriseMemeEmployeur);
      break;
    case 10: 
      jdoStateManager.providedBooleanField(this, fieldNumber, m_isRepriseMemeEmployeurForcee);
      break;
    case 11: 
      jdoStateManager.providedIntField(this, fieldNumber, m_typeNeutralisation);
      break;
    case 12: 
      jdoStateManager.providedBooleanField(this, fieldNumber, m_typeNeutralisationForce);
      break;
    case 13: 
      jdoStateManager.providedIntField(this, fieldNumber, m_estNeutralisee);
      break;
    case 14: 
      jdoStateManager.providedBooleanField(this, fieldNumber, m_estNeutraliseForcee);
      break;
    case 15: 
      jdoStateManager.providedBooleanField(this, fieldNumber, m_estDeblocageVariationRenumeration);
      break;
    case 16: 
      jdoStateManager.providedBooleanField(this, fieldNumber, m_isDeblocageVariationRenumeration);
      break;
    case 17: 
      jdoStateManager.providedBooleanField(this, fieldNumber, m_estDeblocageSeuil);
      break;
    case 18: 
      jdoStateManager.providedBooleanField(this, fieldNumber, m_isDeblocageSeuil);
      break;
    case 19: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantNetRevenusActiviteReprise);
      break;
    case 20: 
      jdoStateManager.providedBooleanField(this, fieldNumber, m_isMontantNetRevenusActiviteReprise);
      break;
    case 21: 
      jdoStateManager.providedBooleanField(this, fieldNumber, m_isCumulARSurUtForce);
      break;
    case 22: 
      jdoStateManager.providedIntField(this, fieldNumber, m_cumulARsurUtForce);
      break;
    case 23: 
      jdoStateManager.providedBooleanField(this, fieldNumber, m_passsDesactive);
      break;
    case 24: 
      jdoStateManager.providedBooleanField(this, fieldNumber, m_estLeverBlocageDV);
      break;
    case 25: 
      jdoStateManager.providedBooleanField(this, fieldNumber, m_estIgnorerAEDV);
      break;
    case 26: 
      jdoStateManager.providedStringField(this, fieldNumber, m_motif);
      break;
    default: 
      throw new JDOFatalInternalException("index of field is out of bound");
    }
  }
  
  public void jdoReplaceField(int fieldNumber)
  {
    int relativeField = fieldNumber - jdoInheritedFieldCount;
    switch (relativeField)
    {
    case 0: 
      m_periode = ((Periode)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 1: 
      m_statut = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 2: 
      m_isStatutForce = jdoStateManager.replacingBooleanField(this, fieldNumber);
      break;
    case 3: 
      m_creditDecalage = ((Quantite)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 4: 
      m_isCreditDecalageForce = jdoStateManager.replacingBooleanField(this, fieldNumber);
      break;
    case 5: 
      m_creditDecalagePNDS = ((Quantite)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 6: 
      m_isCreditDecalagePNDSForce = jdoStateManager.replacingBooleanField(this, fieldNumber);
      break;
    case 7: 
      m_commissionParitaire = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 8: 
      m_isCommissionParitaireForcee = jdoStateManager.replacingBooleanField(this, fieldNumber);
      break;
    case 9: 
      m_repriseMemeEmployeur = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 10: 
      m_isRepriseMemeEmployeurForcee = jdoStateManager.replacingBooleanField(this, fieldNumber);
      break;
    case 11: 
      m_typeNeutralisation = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 12: 
      m_typeNeutralisationForce = jdoStateManager.replacingBooleanField(this, fieldNumber);
      break;
    case 13: 
      m_estNeutralisee = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 14: 
      m_estNeutraliseForcee = jdoStateManager.replacingBooleanField(this, fieldNumber);
      break;
    case 15: 
      m_estDeblocageVariationRenumeration = jdoStateManager.replacingBooleanField(this, fieldNumber);
      break;
    case 16: 
      m_isDeblocageVariationRenumeration = jdoStateManager.replacingBooleanField(this, fieldNumber);
      break;
    case 17: 
      m_estDeblocageSeuil = jdoStateManager.replacingBooleanField(this, fieldNumber);
      break;
    case 18: 
      m_isDeblocageSeuil = jdoStateManager.replacingBooleanField(this, fieldNumber);
      break;
    case 19: 
      m_montantNetRevenusActiviteReprise = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 20: 
      m_isMontantNetRevenusActiviteReprise = jdoStateManager.replacingBooleanField(this, fieldNumber);
      break;
    case 21: 
      m_isCumulARSurUtForce = jdoStateManager.replacingBooleanField(this, fieldNumber);
      break;
    case 22: 
      m_cumulARsurUtForce = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 23: 
      m_passsDesactive = jdoStateManager.replacingBooleanField(this, fieldNumber);
      break;
    case 24: 
      m_estLeverBlocageDV = jdoStateManager.replacingBooleanField(this, fieldNumber);
      break;
    case 25: 
      m_estIgnorerAEDV = jdoStateManager.replacingBooleanField(this, fieldNumber);
      break;
    case 26: 
      m_motif = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    default: 
      throw new JDOFatalInternalException("index of field is out of bound");
    }
  }
  
  public void jdoProvideFields(int[] fieldNumbers)
  {
    for (int i = 0; i < fieldNumbers.length; i++)
    {
      int fieldNumber = fieldNumbers[i];
      jdoProvideField(fieldNumber);
    }
  }
  
  public void jdoReplaceFields(int[] fieldNumbers)
  {
    for (int i = 0; i < fieldNumbers.length; i++)
    {
      int fieldNumber = fieldNumbers[i];
      jdoReplaceField(fieldNumber);
    }
  }
  
  public synchronized void jdoReplaceStateManager(StateManager sm)
  {
    if (jdoStateManager != null)
    {
      jdoStateManager = jdoStateManager.replacingStateManager(this, sm);
    }
    else
    {
      SecurityManager securityManager = System.getSecurityManager();
      if (securityManager != null) {
        securityManager.checkPermission(JDOPermission.SET_STATE_MANAGER);
      }
      jdoStateManager = sm;
    }
  }
  
  public boolean jdoIsPersistent()
  {
    if (jdoStateManager != null) {
      return jdoStateManager.isPersistent(this);
    }
    return false;
  }
  
  public boolean jdoIsTransactional()
  {
    if (jdoStateManager != null) {
      return jdoStateManager.isTransactional(this);
    }
    return false;
  }
  
  public boolean jdoIsNew()
  {
    if (jdoStateManager != null) {
      return jdoStateManager.isNew(this);
    }
    return false;
  }
  
  public boolean jdoIsDirty()
  {
    if (jdoStateManager != null) {
      return jdoStateManager.isDirty(this);
    }
    return false;
  }
  
  public boolean jdoIsDeleted()
  {
    if (jdoStateManager != null) {
      return jdoStateManager.isDeleted(this);
    }
    return false;
  }
  
  public void jdoMakeDirty(String fieldName)
  {
    if (jdoStateManager != null) {
      jdoStateManager.makeDirty(this, fieldName);
    }
  }
  
  public void jdoReplaceFlags()
  {
    if (jdoStateManager != null)
    {
      jdoFlags = jdoStateManager.replacingFlags(this);
      return;
      jdoFlags = 0;
    }
  }
  
  public boolean jdoIsDetached()
  {
    if (jdoStateManager != null) {
      return ((CommonStateManager)jdoStateManager).isDetached();
    }
    return false;
  }
  
  /* Error */
  public PersistenceCapable jdoNewInstance(StateManager sm)
  {
    // Byte code:
    //   0: new 194	javax/jdo/JDOFatalInternalException
    //   3: dup
    //   4: ldc_w 665
    //   7: invokespecial 570	javax/jdo/JDOFatalInternalException:<init>	(Ljava/lang/String;)V
    //   10: athrow
    //   11: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	12	0	this	UniteTraitementForceePC
    //   0	12	1	sm	StateManager
  }
  
  /* Error */
  public PersistenceCapable jdoNewInstance(StateManager sm, Object oid)
  {
    // Byte code:
    //   0: new 194	javax/jdo/JDOFatalInternalException
    //   3: dup
    //   4: ldc_w 665
    //   7: invokespecial 570	javax/jdo/JDOFatalInternalException:<init>	(Ljava/lang/String;)V
    //   10: athrow
    //   11: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	12	0	this	UniteTraitementForceePC
    //   0	12	1	sm	StateManager
    //   0	12	2	oid	Object
  }
  
  public static int jdoGetManagedFieldCount()
  {
    return jdoInheritedFieldCount + 27;
  }
  
  public void jdoCopyFields(Object pc, int[] fieldNumbers)
  {
    if (!(pc instanceof UniteTraitementForceePC)) {
      throw new JDOFatalInternalException("Can't copy fields from a different class");
    }
    UniteTraitementForceePC other = (UniteTraitementForceePC)pc;
    if (jdoStateManager != jdoStateManager) {
      throw new JDOUserException("Source object should have the same StateManager");
    }
    for (int i = 0; i < fieldNumbers.length; i++)
    {
      int relativeField = fieldNumbers[i] - jdoInheritedFieldCount;
      switch (relativeField)
      {
      case 0: 
        m_periode = m_periode;
        break;
      case 1: 
        m_statut = m_statut;
        break;
      case 2: 
        m_isStatutForce = m_isStatutForce;
        break;
      case 3: 
        m_creditDecalage = m_creditDecalage;
        break;
      case 4: 
        m_isCreditDecalageForce = m_isCreditDecalageForce;
        break;
      case 5: 
        m_creditDecalagePNDS = m_creditDecalagePNDS;
        break;
      case 6: 
        m_isCreditDecalagePNDSForce = m_isCreditDecalagePNDSForce;
        break;
      case 7: 
        m_commissionParitaire = m_commissionParitaire;
        break;
      case 8: 
        m_isCommissionParitaireForcee = m_isCommissionParitaireForcee;
        break;
      case 9: 
        m_repriseMemeEmployeur = m_repriseMemeEmployeur;
        break;
      case 10: 
        m_isRepriseMemeEmployeurForcee = m_isRepriseMemeEmployeurForcee;
        break;
      case 11: 
        m_typeNeutralisation = m_typeNeutralisation;
        break;
      case 12: 
        m_typeNeutralisationForce = m_typeNeutralisationForce;
        break;
      case 13: 
        m_estNeutralisee = m_estNeutralisee;
        break;
      case 14: 
        m_estNeutraliseForcee = m_estNeutraliseForcee;
        break;
      case 15: 
        m_estDeblocageVariationRenumeration = m_estDeblocageVariationRenumeration;
        break;
      case 16: 
        m_isDeblocageVariationRenumeration = m_isDeblocageVariationRenumeration;
        break;
      case 17: 
        m_estDeblocageSeuil = m_estDeblocageSeuil;
        break;
      case 18: 
        m_isDeblocageSeuil = m_isDeblocageSeuil;
        break;
      case 19: 
        m_montantNetRevenusActiviteReprise = m_montantNetRevenusActiviteReprise;
        break;
      case 20: 
        m_isMontantNetRevenusActiviteReprise = m_isMontantNetRevenusActiviteReprise;
        break;
      case 21: 
        m_isCumulARSurUtForce = m_isCumulARSurUtForce;
        break;
      case 22: 
        m_cumulARsurUtForce = m_cumulARsurUtForce;
        break;
      case 23: 
        m_passsDesactive = m_passsDesactive;
        break;
      case 24: 
        m_estLeverBlocageDV = m_estLeverBlocageDV;
        break;
      case 25: 
        m_estIgnorerAEDV = m_estIgnorerAEDV;
        break;
      case 26: 
        m_motif = m_motif;
      }
    }
  }
  
  public void jdoCopyKeyFieldsToObjectId(Object object)
  {
    throw new JDOUnsupportedOptionException("Can't be used without Application Identity");
  }
  
  public void jdoCopyKeyFieldsToObjectId(PersistenceCapable.ObjectIdFieldSupplier supplier, Object object)
  {
    throw new JDOUnsupportedOptionException("Can't be used without Application Identity");
  }
  
  protected void jdoCopyKeyFieldsFromObjectId(Object object) {}
  
  public void jdoCopyKeyFieldsFromObjectId(PersistenceCapable.ObjectIdFieldConsumer consumer, Object object)
  {
    throw new JDOUnsupportedOptionException("Can't be used without Application Identity");
  }
  
  public Object jdoNewObjectIdInstance()
  {
    return null;
  }
  
  public Object jdoNewObjectIdInstance(Object str)
  {
    return null;
  }
  
  public Object jdoGetObjectId()
  {
    if (jdoStateManager != null) {
      return jdoStateManager.getObjectId(this);
    }
    return null;
  }
  
  public PersistenceManager jdoGetPersistenceManager()
  {
    if (jdoStateManager != null) {
      return jdoStateManager.getPersistenceManager(this);
    }
    return null;
  }
  
  private void jdoPreSerialize()
  {
    if (jdoStateManager != null) {
      jdoStateManager.preSerialize(this);
    }
  }
  
  private void writeObject(ObjectOutputStream out)
    throws IOException
  {
    jdoPreSerialize();
    out.defaultWriteObject();
  }
  
  public Object jdoGetTransactionalObjectId()
  {
    if (jdoStateManager != null) {
      return jdoStateManager.getTransactionalObjectId(this);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     UniteTraitementForceePC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */