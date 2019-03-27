package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import fr.unedic.util.temps.Damj;
import java.io.Serializable;
import java.math.BigDecimal;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _FluxGUSOImpl
  extends FluxGUSO
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _FluxGUSO m_fluxGUSOInfra;
  
  public _FluxGUSOImpl()
  {
    m_fluxGUSOInfra = new _FluxGUSO();
  }
  
  public _FluxGUSOImpl(_FluxGUSO pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("FluxGUSOInfra", pValeur);
    
    m_fluxGUSOInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_fluxGUSOInfra;
  }
  
  public String getIdentifiant()
  {
    return m_fluxGUSOInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_fluxGUSOInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_fluxGUSOInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_fluxGUSOInfra.set_C_ETAT(pCode);
  }
  
  public String getCodeMouvement()
  {
    return m_fluxGUSOInfra.getCodeMouvement();
  }
  
  public String getCodeErreurCodeMouvement()
  {
    return m_fluxGUSOInfra.getCodeMouvement_C_ERR();
  }
  
  public void setCodeMouvement(String pValeur)
  {
    m_fluxGUSOInfra.setCodeMouvement(pValeur);
  }
  
  public void setCodeErreurCodeMouvement(String pCodeErreur)
  {
    m_fluxGUSOInfra.setCodeMouvement_C_ERR(pCodeErreur);
  }
  
  public String getPrenomEmployeur()
  {
    return m_fluxGUSOInfra.getPrenomEmployeur();
  }
  
  public String getCodeErreurPrenomEmployeur()
  {
    return m_fluxGUSOInfra.getPrenomEmployeur_C_ERR();
  }
  
  public void setPrenomEmployeur(String pValeur)
  {
    m_fluxGUSOInfra.setPrenomEmployeur(pValeur);
  }
  
  public void setCodeErreurPrenomEmployeur(String pCodeErreur)
  {
    m_fluxGUSOInfra.setPrenomEmployeur_C_ERR(pCodeErreur);
  }
  
  public String getNumeroGuso()
  {
    return m_fluxGUSOInfra.getNumeroGuso();
  }
  
  public String getCodeErreurNumeroGuso()
  {
    return m_fluxGUSOInfra.getNumeroGuso_C_ERR();
  }
  
  public void setNumeroGuso(String pValeur)
  {
    m_fluxGUSOInfra.setNumeroGuso(pValeur);
  }
  
  public void setCodeErreurNumeroGuso(String pCodeErreur)
  {
    m_fluxGUSOInfra.setNumeroGuso_C_ERR(pCodeErreur);
  }
  
  public String getCodeNAF()
  {
    return m_fluxGUSOInfra.getCodeNAF();
  }
  
  public String getCodeErreurCodeNAF()
  {
    return m_fluxGUSOInfra.getCodeNAF_C_ERR();
  }
  
  public void setCodeNAF(String pValeur)
  {
    m_fluxGUSOInfra.setCodeNAF(pValeur);
  }
  
  public void setCodeErreurCodeNAF(String pCodeErreur)
  {
    m_fluxGUSOInfra.setCodeNAF_C_ERR(pCodeErreur);
  }
  
  public String getIdentifiantBNI()
  {
    return m_fluxGUSOInfra.getIdentifiantBNI();
  }
  
  public String getCodeErreurIdentifiantBNI()
  {
    return m_fluxGUSOInfra.getIdentifiantBNI_C_ERR();
  }
  
  public void setIdentifiantBNI(String pValeur)
  {
    m_fluxGUSOInfra.setIdentifiantBNI(pValeur);
  }
  
  public void setCodeErreurIdentifiantBNI(String pCodeErreur)
  {
    m_fluxGUSOInfra.setIdentifiantBNI_C_ERR(pCodeErreur);
  }
  
  public String getNom()
  {
    return m_fluxGUSOInfra.getNom();
  }
  
  public String getCodeErreurNom()
  {
    return m_fluxGUSOInfra.getNom_C_ERR();
  }
  
  public void setNom(String pValeur)
  {
    m_fluxGUSOInfra.setNom(pValeur);
  }
  
  public void setCodeErreurNom(String pCodeErreur)
  {
    m_fluxGUSOInfra.setNom_C_ERR(pCodeErreur);
  }
  
  public String getPrenom()
  {
    return m_fluxGUSOInfra.getPrenom();
  }
  
  public String getCodeErreurPrenom()
  {
    return m_fluxGUSOInfra.getPrenom_C_ERR();
  }
  
  public void setPrenom(String pValeur)
  {
    m_fluxGUSOInfra.setPrenom(pValeur);
  }
  
  public void setCodeErreurPrenom(String pCodeErreur)
  {
    m_fluxGUSOInfra.setPrenom_C_ERR(pCodeErreur);
  }
  
  public String getNIRIntermittent()
  {
    return m_fluxGUSOInfra.getNIRIntermittent();
  }
  
  public String getCodeErreurNIRIntermittent()
  {
    return m_fluxGUSOInfra.getNIRIntermittent_C_ERR();
  }
  
  public void setNIRIntermittent(String pValeur)
  {
    m_fluxGUSOInfra.setNIRIntermittent(pValeur);
  }
  
  public void setCodeErreurNIRIntermittent(String pCodeErreur)
  {
    m_fluxGUSOInfra.setNIRIntermittent_C_ERR(pCodeErreur);
  }
  
  public String getEmploiOccupe()
  {
    return m_fluxGUSOInfra.getEmploiOccupe();
  }
  
  public String getCodeErreurEmploiOccupe()
  {
    return m_fluxGUSOInfra.getEmploiOccupe_C_ERR();
  }
  
  public void setEmploiOccupe(String pValeur)
  {
    m_fluxGUSOInfra.setEmploiOccupe(pValeur);
  }
  
  public void setCodeErreurEmploiOccupe(String pCodeErreur)
  {
    m_fluxGUSOInfra.setEmploiOccupe_C_ERR(pCodeErreur);
  }
  
  public String getIdPrestation()
  {
    return m_fluxGUSOInfra.getIdPrestation();
  }
  
  public String getCodeErreurIdPrestation()
  {
    return m_fluxGUSOInfra.getIdPrestation_C_ERR();
  }
  
  public void setIdPrestation(String pValeur)
  {
    m_fluxGUSOInfra.setIdPrestation(pValeur);
  }
  
  public void setCodeErreurIdPrestation(String pCodeErreur)
  {
    m_fluxGUSOInfra.setIdPrestation_C_ERR(pCodeErreur);
  }
  
  public String getNatureActivite()
  {
    return m_fluxGUSOInfra.getNatureActivite();
  }
  
  public String getCodeErreurNatureActivite()
  {
    return m_fluxGUSOInfra.getNatureActivite_C_ERR();
  }
  
  public void setNatureActivite(String pValeur)
  {
    m_fluxGUSOInfra.setNatureActivite(pValeur);
  }
  
  public void setCodeErreurNatureActivite(String pCodeErreur)
  {
    m_fluxGUSOInfra.setNatureActivite_C_ERR(pCodeErreur);
  }
  
  public String getMotifFCT()
  {
    return m_fluxGUSOInfra.getMotifFCT();
  }
  
  public String getCodeErreurMotifFCT()
  {
    return m_fluxGUSOInfra.getMotifFCT_C_ERR();
  }
  
  public void setMotifFCT(String pValeur)
  {
    m_fluxGUSOInfra.setMotifFCT(pValeur);
  }
  
  public void setCodeErreurMotifFCT(String pCodeErreur)
  {
    m_fluxGUSOInfra.setMotifFCT_C_ERR(pCodeErreur);
  }
  
  public String getCodeDevise()
  {
    return m_fluxGUSOInfra.getCodeDevise();
  }
  
  public String getCodeErreurCodeDevise()
  {
    return m_fluxGUSOInfra.getCodeDevise_C_ERR();
  }
  
  public void setCodeDevise(String pValeur)
  {
    m_fluxGUSOInfra.setCodeDevise(pValeur);
  }
  
  public void setCodeErreurCodeDevise(String pCodeErreur)
  {
    m_fluxGUSOInfra.setCodeDevise_C_ERR(pCodeErreur);
  }
  
  public String getIdentifiantBNE()
  {
    return m_fluxGUSOInfra.getIdentifiantBNE();
  }
  
  public String getCodeErreurIdentifiantBNE()
  {
    return m_fluxGUSOInfra.getIdentifiantBNE_C_ERR();
  }
  
  public void setIdentifiantBNE(String pValeur)
  {
    m_fluxGUSOInfra.setIdentifiantBNE(pValeur);
  }
  
  public void setCodeErreurIdentifiantBNE(String pCodeErreur)
  {
    m_fluxGUSOInfra.setIdentifiantBNE_C_ERR(pCodeErreur);
  }
  
  public String getSiretBNE()
  {
    return m_fluxGUSOInfra.getSiretBNE();
  }
  
  public String getCodeErreurSiretBNE()
  {
    return m_fluxGUSOInfra.getSiretBNE_C_ERR();
  }
  
  public void setSiretBNE(String pValeur)
  {
    m_fluxGUSOInfra.setSiretBNE(pValeur);
  }
  
  public void setCodeErreurSiretBNE(String pCodeErreur)
  {
    m_fluxGUSOInfra.setSiretBNE_C_ERR(pCodeErreur);
  }
  
  public String getRaisonSocialeBNE()
  {
    return m_fluxGUSOInfra.getRaisonSocialeBNE();
  }
  
  public String getCodeErreurRaisonSocialeBNE()
  {
    return m_fluxGUSOInfra.getRaisonSocialeBNE_C_ERR();
  }
  
  public void setRaisonSocialeBNE(String pValeur)
  {
    m_fluxGUSOInfra.setRaisonSocialeBNE(pValeur);
  }
  
  public void setCodeErreurRaisonSocialeBNE(String pCodeErreur)
  {
    m_fluxGUSOInfra.setRaisonSocialeBNE_C_ERR(pCodeErreur);
  }
  
  public String getNumeroRueBNE()
  {
    return m_fluxGUSOInfra.getNumeroRueBNE();
  }
  
  public String getCodeErreurNumeroRueBNE()
  {
    return m_fluxGUSOInfra.getNumeroRueBNE_C_ERR();
  }
  
  public void setNumeroRueBNE(String pValeur)
  {
    m_fluxGUSOInfra.setNumeroRueBNE(pValeur);
  }
  
  public void setCodeErreurNumeroRueBNE(String pCodeErreur)
  {
    m_fluxGUSOInfra.setNumeroRueBNE_C_ERR(pCodeErreur);
  }
  
  public String getAdresse1BNE()
  {
    return m_fluxGUSOInfra.getAdresse1BNE();
  }
  
  public String getCodeErreurAdresse1BNE()
  {
    return m_fluxGUSOInfra.getAdresse1BNE_C_ERR();
  }
  
  public void setAdresse1BNE(String pValeur)
  {
    m_fluxGUSOInfra.setAdresse1BNE(pValeur);
  }
  
  public void setCodeErreurAdresse1BNE(String pCodeErreur)
  {
    m_fluxGUSOInfra.setAdresse1BNE_C_ERR(pCodeErreur);
  }
  
  public String getAdresse2BNE()
  {
    return m_fluxGUSOInfra.getAdresse2BNE();
  }
  
  public String getCodeErreurAdresse2BNE()
  {
    return m_fluxGUSOInfra.getAdresse2BNE_C_ERR();
  }
  
  public void setAdresse2BNE(String pValeur)
  {
    m_fluxGUSOInfra.setAdresse2BNE(pValeur);
  }
  
  public void setCodeErreurAdresse2BNE(String pCodeErreur)
  {
    m_fluxGUSOInfra.setAdresse2BNE_C_ERR(pCodeErreur);
  }
  
  public String getCodePostalBNE()
  {
    return m_fluxGUSOInfra.getCodePostalBNE();
  }
  
  public String getCodeErreurCodePostalBNE()
  {
    return m_fluxGUSOInfra.getCodePostalBNE_C_ERR();
  }
  
  public void setCodePostalBNE(String pValeur)
  {
    m_fluxGUSOInfra.setCodePostalBNE(pValeur);
  }
  
  public void setCodeErreurCodePostalBNE(String pCodeErreur)
  {
    m_fluxGUSOInfra.setCodePostalBNE_C_ERR(pCodeErreur);
  }
  
  public String getLibelleCommuneBNE()
  {
    return m_fluxGUSOInfra.getLibelleCommuneBNE();
  }
  
  public String getCodeErreurLibelleCommuneBNE()
  {
    return m_fluxGUSOInfra.getLibelleCommuneBNE_C_ERR();
  }
  
  public void setLibelleCommuneBNE(String pValeur)
  {
    m_fluxGUSOInfra.setLibelleCommuneBNE(pValeur);
  }
  
  public void setCodeErreurLibelleCommuneBNE(String pCodeErreur)
  {
    m_fluxGUSOInfra.setLibelleCommuneBNE_C_ERR(pCodeErreur);
  }
  
  public String getAssedicAffiliationBNE()
  {
    return m_fluxGUSOInfra.getAssedicAffiliationBNE();
  }
  
  public String getCodeErreurAssedicAffiliationBNE()
  {
    return m_fluxGUSOInfra.getAssedicAffiliationBNE_C_ERR();
  }
  
  public void setAssedicAffiliationBNE(String pValeur)
  {
    m_fluxGUSOInfra.setAssedicAffiliationBNE(pValeur);
  }
  
  public void setCodeErreurAssedicAffiliationBNE(String pCodeErreur)
  {
    m_fluxGUSOInfra.setAssedicAffiliationBNE_C_ERR(pCodeErreur);
  }
  
  public String getNumeroAffiliationBNE()
  {
    return m_fluxGUSOInfra.getNumeroAffiliationBNE();
  }
  
  public String getCodeErreurNumeroAffiliationBNE()
  {
    return m_fluxGUSOInfra.getNumeroAffiliationBNE_C_ERR();
  }
  
  public void setNumeroAffiliationBNE(String pValeur)
  {
    m_fluxGUSOInfra.setNumeroAffiliationBNE(pValeur);
  }
  
  public void setCodeErreurNumeroAffiliationBNE(String pCodeErreur)
  {
    m_fluxGUSOInfra.setNumeroAffiliationBNE_C_ERR(pCodeErreur);
  }
  
  public String getNouveauCodeNAF()
  {
    return m_fluxGUSOInfra.getNouveauCodeNAF();
  }
  
  public String getCodeErreurNouveauCodeNAF()
  {
    return m_fluxGUSOInfra.getNouveauCodeNAF_C_ERR();
  }
  
  public void setNouveauCodeNAF(String pValeur)
  {
    m_fluxGUSOInfra.setNouveauCodeNAF(pValeur);
  }
  
  public void setCodeErreurNouveauCodeNAF(String pCodeErreur)
  {
    m_fluxGUSOInfra.setNouveauCodeNAF_C_ERR(pCodeErreur);
  }
  
  public String getRaisonSocialeEmployeur()
  {
    return m_fluxGUSOInfra.getRaisonSocialeEmployeur();
  }
  
  public String getCodeErreurRaisonSocialeEmployeur()
  {
    return m_fluxGUSOInfra.getRaisonSocialeEmployeur_C_ERR();
  }
  
  public void setRaisonSocialeEmployeur(String pValeur)
  {
    m_fluxGUSOInfra.setRaisonSocialeEmployeur(pValeur);
  }
  
  public void setCodeErreurRaisonSocialeEmployeur(String pCodeErreur)
  {
    m_fluxGUSOInfra.setRaisonSocialeEmployeur_C_ERR(pCodeErreur);
  }
  
  public String getNumeroTelephone()
  {
    return m_fluxGUSOInfra.getNumeroTelephone();
  }
  
  public String getCodeErreurNumeroTelephone()
  {
    return m_fluxGUSOInfra.getNumeroTelephone_C_ERR();
  }
  
  public void setNumeroTelephone(String pValeur)
  {
    m_fluxGUSOInfra.setNumeroTelephone(pValeur);
  }
  
  public void setCodeErreurNumeroTelephone(String pCodeErreur)
  {
    m_fluxGUSOInfra.setNumeroTelephone_C_ERR(pCodeErreur);
  }
  
  public String getNumeroFax()
  {
    return m_fluxGUSOInfra.getNumeroFax();
  }
  
  public String getCodeErreurNumeroFax()
  {
    return m_fluxGUSOInfra.getNumeroFax_C_ERR();
  }
  
  public void setNumeroFax(String pValeur)
  {
    m_fluxGUSOInfra.setNumeroFax(pValeur);
  }
  
  public void setCodeErreurNumeroFax(String pCodeErreur)
  {
    m_fluxGUSOInfra.setNumeroFax_C_ERR(pCodeErreur);
  }
  
  public String getPremiereLigneAdresseEmployeurCourrier()
  {
    return m_fluxGUSOInfra.getPremiereLigneAdresseEmployeurCourrier();
  }
  
  public String getCodeErreurPremiereLigneAdresseEmployeurCourrier()
  {
    return m_fluxGUSOInfra.getPremiereLigneAdresseEmployeurCourrier_C_ERR();
  }
  
  public void setPremiereLigneAdresseEmployeurCourrier(String pValeur)
  {
    m_fluxGUSOInfra.setPremiereLigneAdresseEmployeurCourrier(pValeur);
  }
  
  public void setCodeErreurPremiereLigneAdresseEmployeurCourrier(String pCodeErreur)
  {
    m_fluxGUSOInfra.setPremiereLigneAdresseEmployeurCourrier_C_ERR(pCodeErreur);
  }
  
  public String getDeuxiemeLigneAdresseEmployeurCourrier()
  {
    return m_fluxGUSOInfra.getDeuxiemeLigneAdresseEmployeurCourrier();
  }
  
  public String getCodeErreurDeuxiemeLigneAdresseEmployeurCourrier()
  {
    return m_fluxGUSOInfra.getDeuxiemeLigneAdresseEmployeurCourrier_C_ERR();
  }
  
  public void setDeuxiemeLigneAdresseEmployeurCourrier(String pValeur)
  {
    m_fluxGUSOInfra.setDeuxiemeLigneAdresseEmployeurCourrier(pValeur);
  }
  
  public void setCodeErreurDeuxiemeLigneAdresseEmployeurCourrier(String pCodeErreur)
  {
    m_fluxGUSOInfra.setDeuxiemeLigneAdresseEmployeurCourrier_C_ERR(pCodeErreur);
  }
  
  public String getTroisiemeLigneAdresseEmployeurCourrier()
  {
    return m_fluxGUSOInfra.getTroisiemeLigneAdresseEmployeurCourrier();
  }
  
  public String getCodeErreurTroisiemeLigneAdresseEmployeurCourrier()
  {
    return m_fluxGUSOInfra.getTroisiemeLigneAdresseEmployeurCourrier_C_ERR();
  }
  
  public void setTroisiemeLigneAdresseEmployeurCourrier(String pValeur)
  {
    m_fluxGUSOInfra.setTroisiemeLigneAdresseEmployeurCourrier(pValeur);
  }
  
  public void setCodeErreurTroisiemeLigneAdresseEmployeurCourrier(String pCodeErreur)
  {
    m_fluxGUSOInfra.setTroisiemeLigneAdresseEmployeurCourrier_C_ERR(pCodeErreur);
  }
  
  public String getQuatriemeLigneAdresseEmployeurCourrier()
  {
    return m_fluxGUSOInfra.getQuatriemeLigneAdresseEmployeurCourrier();
  }
  
  public String getCodeErreurQuatriemeLigneAdresseEmployeurCourrier()
  {
    return m_fluxGUSOInfra.getQuatriemeLigneAdresseEmployeurCourrier_C_ERR();
  }
  
  public void setQuatriemeLigneAdresseEmployeurCourrier(String pValeur)
  {
    m_fluxGUSOInfra.setQuatriemeLigneAdresseEmployeurCourrier(pValeur);
  }
  
  public void setCodeErreurQuatriemeLigneAdresseEmployeurCourrier(String pCodeErreur)
  {
    m_fluxGUSOInfra.setQuatriemeLigneAdresseEmployeurCourrier_C_ERR(pCodeErreur);
  }
  
  public String getSiret()
  {
    return m_fluxGUSOInfra.getSiret();
  }
  
  public String getCodeErreurSiret()
  {
    return m_fluxGUSOInfra.getSiret_C_ERR();
  }
  
  public void setSiret(String pValeur)
  {
    m_fluxGUSOInfra.setSiret(pValeur);
  }
  
  public void setCodeErreurSiret(String pCodeErreur)
  {
    m_fluxGUSOInfra.setSiret_C_ERR(pCodeErreur);
  }
  
  public String getFormeJuridique()
  {
    return m_fluxGUSOInfra.getFormeJuridique();
  }
  
  public String getCodeErreurFormeJuridique()
  {
    return m_fluxGUSOInfra.getFormeJuridique_C_ERR();
  }
  
  public void setFormeJuridique(String pValeur)
  {
    m_fluxGUSOInfra.setFormeJuridique(pValeur);
  }
  
  public void setCodeErreurFormeJuridique(String pCodeErreur)
  {
    m_fluxGUSOInfra.setFormeJuridique_C_ERR(pCodeErreur);
  }
  
  public String getPseudo()
  {
    return m_fluxGUSOInfra.getPseudo();
  }
  
  public String getCodeErreurPseudo()
  {
    return m_fluxGUSOInfra.getPseudo_C_ERR();
  }
  
  public void setPseudo(String pValeur)
  {
    m_fluxGUSOInfra.setPseudo(pValeur);
  }
  
  public void setCodeErreurPseudo(String pCodeErreur)
  {
    m_fluxGUSOInfra.setPseudo_C_ERR(pCodeErreur);
  }
  
  public String getPremiereLigneAdresseIntermittentCourrier()
  {
    return m_fluxGUSOInfra.getPremiereLigneAdresseIntermittentCourrier();
  }
  
  public String getCodeErreurPremiereLigneAdresseIntermittentCourrier()
  {
    return m_fluxGUSOInfra.getPremiereLigneAdresseIntermittentCourrier_C_ERR();
  }
  
  public void setPremiereLigneAdresseIntermittentCourrier(String pValeur)
  {
    m_fluxGUSOInfra.setPremiereLigneAdresseIntermittentCourrier(pValeur);
  }
  
  public void setCodeErreurPremiereLigneAdresseIntermittentCourrier(String pCodeErreur)
  {
    m_fluxGUSOInfra.setPremiereLigneAdresseIntermittentCourrier_C_ERR(pCodeErreur);
  }
  
  public String getDeuxiemeLigneAdresseIntermittentCourrier()
  {
    return m_fluxGUSOInfra.getDeuxiemeLigneAdresseIntermittentCourrier();
  }
  
  public String getCodeErreurDeuxiemeLigneAdresseIntermittentCourrier()
  {
    return m_fluxGUSOInfra.getDeuxiemeLigneAdresseIntermittentCourrier_C_ERR();
  }
  
  public void setDeuxiemeLigneAdresseIntermittentCourrier(String pValeur)
  {
    m_fluxGUSOInfra.setDeuxiemeLigneAdresseIntermittentCourrier(pValeur);
  }
  
  public void setCodeErreurDeuxiemeLigneAdresseIntermittentCourrier(String pCodeErreur)
  {
    m_fluxGUSOInfra.setDeuxiemeLigneAdresseIntermittentCourrier_C_ERR(pCodeErreur);
  }
  
  public String getTroisiemeLigneAdresseIntermittentCourrier()
  {
    return m_fluxGUSOInfra.getTroisiemeLigneAdresseIntermittentCourrier();
  }
  
  public String getCodeErreurTroisiemeLigneAdresseIntermittentCourrier()
  {
    return m_fluxGUSOInfra.getTroisiemeLigneAdresseIntermittentCourrier_C_ERR();
  }
  
  public void setTroisiemeLigneAdresseIntermittentCourrier(String pValeur)
  {
    m_fluxGUSOInfra.setTroisiemeLigneAdresseIntermittentCourrier(pValeur);
  }
  
  public void setCodeErreurTroisiemeLigneAdresseIntermittentCourrier(String pCodeErreur)
  {
    m_fluxGUSOInfra.setTroisiemeLigneAdresseIntermittentCourrier_C_ERR(pCodeErreur);
  }
  
  public String getQuatriemeLigneAdresseIntermittentCourrier()
  {
    return m_fluxGUSOInfra.getQuatriemeLigneAdresseIntermittentCourrier();
  }
  
  public String getCodeErreurQuatriemeLigneAdresseIntermittentCourrier()
  {
    return m_fluxGUSOInfra.getQuatriemeLigneAdresseIntermittentCourrier_C_ERR();
  }
  
  public void setQuatriemeLigneAdresseIntermittentCourrier(String pValeur)
  {
    m_fluxGUSOInfra.setQuatriemeLigneAdresseIntermittentCourrier(pValeur);
  }
  
  public void setCodeErreurQuatriemeLigneAdresseIntermittentCourrier(String pCodeErreur)
  {
    m_fluxGUSOInfra.setQuatriemeLigneAdresseIntermittentCourrier_C_ERR(pCodeErreur);
  }
  
  public String getPositionEmployeur()
  {
    return m_fluxGUSOInfra.getPositionEmployeur();
  }
  
  public String getCodeErreurPositionEmployeur()
  {
    return m_fluxGUSOInfra.getPositionEmployeur_C_ERR();
  }
  
  public void setPositionEmployeur(String pValeur)
  {
    m_fluxGUSOInfra.setPositionEmployeur(pValeur);
  }
  
  public void setCodeErreurPositionEmployeur(String pCodeErreur)
  {
    m_fluxGUSOInfra.setPositionEmployeur_C_ERR(pCodeErreur);
  }
  
  public String getPositionAutreEmployeur()
  {
    return m_fluxGUSOInfra.getPositionAutreEmployeur();
  }
  
  public String getCodeErreurPositionAutreEmployeur()
  {
    return m_fluxGUSOInfra.getPositionAutreEmployeur_C_ERR();
  }
  
  public void setPositionAutreEmployeur(String pValeur)
  {
    m_fluxGUSOInfra.setPositionAutreEmployeur(pValeur);
  }
  
  public void setCodeErreurPositionAutreEmployeur(String pCodeErreur)
  {
    m_fluxGUSOInfra.setPositionAutreEmployeur_C_ERR(pCodeErreur);
  }
  
  public String getCodeAssedic()
  {
    return m_fluxGUSOInfra.getCodeAssedic();
  }
  
  public String getCodeErreurCodeAssedic()
  {
    return m_fluxGUSOInfra.getCodeAssedic_C_ERR();
  }
  
  public void setCodeAssedic(String pValeur)
  {
    m_fluxGUSOInfra.setCodeAssedic(pValeur);
  }
  
  public void setCodeErreurCodeAssedic(String pCodeErreur)
  {
    m_fluxGUSOInfra.setCodeAssedic_C_ERR(pCodeErreur);
  }
  
  public String getRsin()
  {
    return m_fluxGUSOInfra.getRsin();
  }
  
  public String getCodeErreurRsin()
  {
    return m_fluxGUSOInfra.getRsin_C_ERR();
  }
  
  public void setRsin(String pValeur)
  {
    m_fluxGUSOInfra.setRsin(pValeur);
  }
  
  public void setCodeErreurRsin(String pCodeErreur)
  {
    m_fluxGUSOInfra.setRsin_C_ERR(pCodeErreur);
  }
  
  public String getCodeNAFBNE()
  {
    return m_fluxGUSOInfra.getCodeNAFBNE();
  }
  
  public String getCodeErreurCodeNAFBNE()
  {
    return m_fluxGUSOInfra.getCodeNAFBNE_C_ERR();
  }
  
  public void setCodeNAFBNE(String pValeur)
  {
    m_fluxGUSOInfra.setCodeNAFBNE(pValeur);
  }
  
  public void setCodeErreurCodeNAFBNE(String pCodeErreur)
  {
    m_fluxGUSOInfra.setCodeNAFBNE_C_ERR(pCodeErreur);
  }
  
  public String getCodeEmploiOccupe()
  {
    return m_fluxGUSOInfra.getCodeEmploiOccupe();
  }
  
  public String getCodeErreurCodeEmploiOccupe()
  {
    return m_fluxGUSOInfra.getCodeEmploiOccupe_C_ERR();
  }
  
  public void setCodeEmploiOccupe(String pValeur)
  {
    m_fluxGUSOInfra.setCodeEmploiOccupe(pValeur);
  }
  
  public void setCodeErreurCodeEmploiOccupe(String pCodeErreur)
  {
    m_fluxGUSOInfra.setCodeEmploiOccupe_C_ERR(pCodeErreur);
  }
  
  public String getNumeroObjet()
  {
    return m_fluxGUSOInfra.getNumeroObjet();
  }
  
  public String getCodeErreurNumeroObjet()
  {
    return m_fluxGUSOInfra.getNumeroObjet_C_ERR();
  }
  
  public void setNumeroObjet(String pValeur)
  {
    m_fluxGUSOInfra.setNumeroObjet(pValeur);
  }
  
  public void setCodeErreurNumeroObjet(String pCodeErreur)
  {
    m_fluxGUSOInfra.setNumeroObjet_C_ERR(pCodeErreur);
  }
  
  public String getCadre()
  {
    return m_fluxGUSOInfra.getCadre();
  }
  
  public String getCodeErreurCadre()
  {
    return m_fluxGUSOInfra.getCadre_C_ERR();
  }
  
  public void setCadre(String pValeur)
  {
    m_fluxGUSOInfra.setCadre(pValeur);
  }
  
  public void setCodeErreurCadre(String pCodeErreur)
  {
    m_fluxGUSOInfra.setCadre_C_ERR(pCodeErreur);
  }
  
  public String getForfaitUrssaf()
  {
    return m_fluxGUSOInfra.getForfaitUrssaf();
  }
  
  public String getCodeErreurForfaitUrssaf()
  {
    return m_fluxGUSOInfra.getForfaitUrssaf_C_ERR();
  }
  
  public void setForfaitUrssaf(String pValeur)
  {
    m_fluxGUSOInfra.setForfaitUrssaf(pValeur);
  }
  
  public void setCodeErreurForfaitUrssaf(String pCodeErreur)
  {
    m_fluxGUSOInfra.setForfaitUrssaf_C_ERR(pCodeErreur);
  }
  
  public String getTopAlsaceMoselle()
  {
    return m_fluxGUSOInfra.getTopAlsaceMoselle();
  }
  
  public String getCodeErreurTopAlsaceMoselle()
  {
    return m_fluxGUSOInfra.getTopAlsaceMoselle_C_ERR();
  }
  
  public void setTopAlsaceMoselle(String pValeur)
  {
    m_fluxGUSOInfra.setTopAlsaceMoselle(pValeur);
  }
  
  public void setCodeErreurTopAlsaceMoselle(String pCodeErreur)
  {
    m_fluxGUSOInfra.setTopAlsaceMoselle_C_ERR(pCodeErreur);
  }
  
  public Damj getDateDebutContrat()
  {
    return m_fluxGUSOInfra.getDateDebutContrat();
  }
  
  public String getCodeErreurDateDebutContrat()
  {
    return m_fluxGUSOInfra.getDateDebutContrat_C_ERR();
  }
  
  public void setDateDebutContrat(Damj pValeur)
  {
    m_fluxGUSOInfra.setDateDebutContrat(pValeur);
  }
  
  public void setCodeErreurDateDebutContrat(String pCodeErreur)
  {
    m_fluxGUSOInfra.setDateDebutContrat_C_ERR(pCodeErreur);
  }
  
  public Damj getDateFinContrat()
  {
    return m_fluxGUSOInfra.getDateFinContrat();
  }
  
  public String getCodeErreurDateFinContrat()
  {
    return m_fluxGUSOInfra.getDateFinContrat_C_ERR();
  }
  
  public void setDateFinContrat(Damj pValeur)
  {
    m_fluxGUSOInfra.setDateFinContrat(pValeur);
  }
  
  public void setCodeErreurDateFinContrat(String pCodeErreur)
  {
    m_fluxGUSOInfra.setDateFinContrat_C_ERR(pCodeErreur);
  }
  
  public Damj getDateCreation()
  {
    return m_fluxGUSOInfra.getDateCreation();
  }
  
  public String getCodeErreurDateCreation()
  {
    return m_fluxGUSOInfra.getDateCreation_C_ERR();
  }
  
  public void setDateCreation(Damj pValeur)
  {
    m_fluxGUSOInfra.setDateCreation(pValeur);
  }
  
  public void setCodeErreurDateCreation(String pCodeErreur)
  {
    m_fluxGUSOInfra.setDateCreation_C_ERR(pCodeErreur);
  }
  
  public Damj getDateOrigineInformation()
  {
    return m_fluxGUSOInfra.getDateOrigineInformation();
  }
  
  public String getCodeErreurDateOrigineInformation()
  {
    return m_fluxGUSOInfra.getDateOrigineInformation_C_ERR();
  }
  
  public void setDateOrigineInformation(Damj pValeur)
  {
    m_fluxGUSOInfra.setDateOrigineInformation(pValeur);
  }
  
  public void setCodeErreurDateOrigineInformation(String pCodeErreur)
  {
    m_fluxGUSOInfra.setDateOrigineInformation_C_ERR(pCodeErreur);
  }
  
  public Damj getDateCreationFeuillet()
  {
    return m_fluxGUSOInfra.getDateCreationFeuillet();
  }
  
  public String getCodeErreurDateCreationFeuillet()
  {
    return m_fluxGUSOInfra.getDateCreationFeuillet_C_ERR();
  }
  
  public void setDateCreationFeuillet(Damj pValeur)
  {
    m_fluxGUSOInfra.setDateCreationFeuillet(pValeur);
  }
  
  public void setCodeErreurDateCreationFeuillet(String pCodeErreur)
  {
    m_fluxGUSOInfra.setDateCreationFeuillet_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getNbJoursTravailles()
  {
    return m_fluxGUSOInfra.getNbJoursTravailles();
  }
  
  public String getCodeErreurNbJoursTravailles()
  {
    return m_fluxGUSOInfra.getNbJoursTravailles_C_ERR();
  }
  
  public void setNbJoursTravailles(BigDecimal pValeur)
  {
    m_fluxGUSOInfra.setNbJoursTravailles(pValeur);
  }
  
  public void setCodeErreurNbJoursTravailles(String pCodeErreur)
  {
    m_fluxGUSOInfra.setNbJoursTravailles_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getNbHeuresTravaillees()
  {
    return m_fluxGUSOInfra.getNbHeuresTravaillees();
  }
  
  public String getCodeErreurNbHeuresTravaillees()
  {
    return m_fluxGUSOInfra.getNbHeuresTravaillees_C_ERR();
  }
  
  public void setNbHeuresTravaillees(BigDecimal pValeur)
  {
    m_fluxGUSOInfra.setNbHeuresTravaillees(pValeur);
  }
  
  public void setCodeErreurNbHeuresTravaillees(String pCodeErreur)
  {
    m_fluxGUSOInfra.setNbHeuresTravaillees_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getNbCachets()
  {
    return m_fluxGUSOInfra.getNbCachets();
  }
  
  public String getCodeErreurNbCachets()
  {
    return m_fluxGUSOInfra.getNbCachets_C_ERR();
  }
  
  public void setNbCachets(BigDecimal pValeur)
  {
    m_fluxGUSOInfra.setNbCachets(pValeur);
  }
  
  public void setCodeErreurNbCachets(String pCodeErreur)
  {
    m_fluxGUSOInfra.setNbCachets_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getSalaireBrutNonAbattu()
  {
    return m_fluxGUSOInfra.getSalaireBrutNonAbattu();
  }
  
  public String getCodeErreurSalaireBrutNonAbattu()
  {
    return m_fluxGUSOInfra.getSalaireBrutNonAbattu_C_ERR();
  }
  
  public void setSalaireBrutNonAbattu(BigDecimal pValeur)
  {
    m_fluxGUSOInfra.setSalaireBrutNonAbattu(pValeur);
  }
  
  public void setCodeErreurSalaireBrutNonAbattu(String pCodeErreur)
  {
    m_fluxGUSOInfra.setSalaireBrutNonAbattu_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getSalaireBrutAbattu()
  {
    return m_fluxGUSOInfra.getSalaireBrutAbattu();
  }
  
  public String getCodeErreurSalaireBrutAbattu()
  {
    return m_fluxGUSOInfra.getSalaireBrutAbattu_C_ERR();
  }
  
  public void setSalaireBrutAbattu(BigDecimal pValeur)
  {
    m_fluxGUSOInfra.setSalaireBrutAbattu(pValeur);
  }
  
  public void setCodeErreurSalaireBrutAbattu(String pCodeErreur)
  {
    m_fluxGUSOInfra.setSalaireBrutAbattu_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getNumeroChrono()
  {
    return m_fluxGUSOInfra.getNumeroChrono();
  }
  
  public String getCodeErreurNumeroChrono()
  {
    return m_fluxGUSOInfra.getNumeroChrono_C_ERR();
  }
  
  public void setNumeroChrono(BigDecimal pValeur)
  {
    m_fluxGUSOInfra.setNumeroChrono(pValeur);
  }
  
  public void setCodeErreurNumeroChrono(String pCodeErreur)
  {
    m_fluxGUSOInfra.setNumeroChrono_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getMontantIccp()
  {
    return m_fluxGUSOInfra.getMontantIccp();
  }
  
  public String getCodeErreurMontantIccp()
  {
    return m_fluxGUSOInfra.getMontantIccp_C_ERR();
  }
  
  public void setMontantIccp(BigDecimal pValeur)
  {
    m_fluxGUSOInfra.setMontantIccp(pValeur);
  }
  
  public void setCodeErreurMontantIccp(String pCodeErreur)
  {
    m_fluxGUSOInfra.setMontantIccp_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getMontantAvantageNature()
  {
    return m_fluxGUSOInfra.getMontantAvantageNature();
  }
  
  public String getCodeErreurMontantAvantageNature()
  {
    return m_fluxGUSOInfra.getMontantAvantageNature_C_ERR();
  }
  
  public void setMontantAvantageNature(BigDecimal pValeur)
  {
    m_fluxGUSOInfra.setMontantAvantageNature(pValeur);
  }
  
  public void setCodeErreurMontantAvantageNature(String pCodeErreur)
  {
    m_fluxGUSOInfra.setMontantAvantageNature_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getMontantFraisProfessionnel()
  {
    return m_fluxGUSOInfra.getMontantFraisProfessionnel();
  }
  
  public String getCodeErreurMontantFraisProfessionnel()
  {
    return m_fluxGUSOInfra.getMontantFraisProfessionnel_C_ERR();
  }
  
  public void setMontantFraisProfessionnel(BigDecimal pValeur)
  {
    m_fluxGUSOInfra.setMontantFraisProfessionnel(pValeur);
  }
  
  public void setCodeErreurMontantFraisProfessionnel(String pCodeErreur)
  {
    m_fluxGUSOInfra.setMontantFraisProfessionnel_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getTauxAbattement()
  {
    return m_fluxGUSOInfra.getTauxAbattement();
  }
  
  public String getCodeErreurTauxAbattement()
  {
    return m_fluxGUSOInfra.getTauxAbattement_C_ERR();
  }
  
  public void setTauxAbattement(BigDecimal pValeur)
  {
    m_fluxGUSOInfra.setTauxAbattement(pValeur);
  }
  
  public void setCodeErreurTauxAbattement(String pCodeErreur)
  {
    m_fluxGUSOInfra.setTauxAbattement_C_ERR(pCodeErreur);
  }
  
  public _FluxGUSO getFluxGUSOInfra()
  {
    return m_fluxGUSOInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    if ((getCodeErreurCodeMouvement() != null) && 
      ("".equals(getCodeErreurCodeMouvement()))) {
      return true;
    }
    if ((getCodeErreurPrenomEmployeur() != null) && 
      ("".equals(getCodeErreurPrenomEmployeur()))) {
      return true;
    }
    if ((getCodeErreurNumeroGuso() != null) && 
      ("".equals(getCodeErreurNumeroGuso()))) {
      return true;
    }
    if ((getCodeErreurCodeNAF() != null) && 
      ("".equals(getCodeErreurCodeNAF()))) {
      return true;
    }
    if ((getCodeErreurIdentifiantBNI() != null) && 
      ("".equals(getCodeErreurIdentifiantBNI()))) {
      return true;
    }
    if ((getCodeErreurNom() != null) && 
      ("".equals(getCodeErreurNom()))) {
      return true;
    }
    if ((getCodeErreurPrenom() != null) && 
      ("".equals(getCodeErreurPrenom()))) {
      return true;
    }
    if ((getCodeErreurNIRIntermittent() != null) && 
      ("".equals(getCodeErreurNIRIntermittent()))) {
      return true;
    }
    if ((getCodeErreurEmploiOccupe() != null) && 
      ("".equals(getCodeErreurEmploiOccupe()))) {
      return true;
    }
    if ((getCodeErreurIdPrestation() != null) && 
      ("".equals(getCodeErreurIdPrestation()))) {
      return true;
    }
    if ((getCodeErreurNatureActivite() != null) && 
      ("".equals(getCodeErreurNatureActivite()))) {
      return true;
    }
    if ((getCodeErreurMotifFCT() != null) && 
      ("".equals(getCodeErreurMotifFCT()))) {
      return true;
    }
    if ((getCodeErreurCodeDevise() != null) && 
      ("".equals(getCodeErreurCodeDevise()))) {
      return true;
    }
    if ((getCodeErreurIdentifiantBNE() != null) && 
      ("".equals(getCodeErreurIdentifiantBNE()))) {
      return true;
    }
    if ((getCodeErreurSiretBNE() != null) && 
      ("".equals(getCodeErreurSiretBNE()))) {
      return true;
    }
    if ((getCodeErreurRaisonSocialeBNE() != null) && 
      ("".equals(getCodeErreurRaisonSocialeBNE()))) {
      return true;
    }
    if ((getCodeErreurNumeroRueBNE() != null) && 
      ("".equals(getCodeErreurNumeroRueBNE()))) {
      return true;
    }
    if ((getCodeErreurAdresse1BNE() != null) && 
      ("".equals(getCodeErreurAdresse1BNE()))) {
      return true;
    }
    if ((getCodeErreurAdresse2BNE() != null) && 
      ("".equals(getCodeErreurAdresse2BNE()))) {
      return true;
    }
    if ((getCodeErreurCodePostalBNE() != null) && 
      ("".equals(getCodeErreurCodePostalBNE()))) {
      return true;
    }
    if ((getCodeErreurLibelleCommuneBNE() != null) && 
      ("".equals(getCodeErreurLibelleCommuneBNE()))) {
      return true;
    }
    if ((getCodeErreurAssedicAffiliationBNE() != null) && 
      ("".equals(getCodeErreurAssedicAffiliationBNE()))) {
      return true;
    }
    if ((getCodeErreurNumeroAffiliationBNE() != null) && 
      ("".equals(getCodeErreurNumeroAffiliationBNE()))) {
      return true;
    }
    if ((getCodeErreurNouveauCodeNAF() != null) && 
      ("".equals(getCodeErreurNouveauCodeNAF()))) {
      return true;
    }
    if ((getCodeErreurRaisonSocialeEmployeur() != null) && 
      ("".equals(getCodeErreurRaisonSocialeEmployeur()))) {
      return true;
    }
    if ((getCodeErreurNumeroTelephone() != null) && 
      ("".equals(getCodeErreurNumeroTelephone()))) {
      return true;
    }
    if ((getCodeErreurNumeroFax() != null) && 
      ("".equals(getCodeErreurNumeroFax()))) {
      return true;
    }
    if ((getCodeErreurPremiereLigneAdresseEmployeurCourrier() != null) && 
      ("".equals(getCodeErreurPremiereLigneAdresseEmployeurCourrier()))) {
      return true;
    }
    if ((getCodeErreurDeuxiemeLigneAdresseEmployeurCourrier() != null) && 
      ("".equals(getCodeErreurDeuxiemeLigneAdresseEmployeurCourrier()))) {
      return true;
    }
    if ((getCodeErreurTroisiemeLigneAdresseEmployeurCourrier() != null) && 
      ("".equals(getCodeErreurTroisiemeLigneAdresseEmployeurCourrier()))) {
      return true;
    }
    if ((getCodeErreurQuatriemeLigneAdresseEmployeurCourrier() != null) && 
      ("".equals(getCodeErreurQuatriemeLigneAdresseEmployeurCourrier()))) {
      return true;
    }
    if ((getCodeErreurSiret() != null) && 
      ("".equals(getCodeErreurSiret()))) {
      return true;
    }
    if ((getCodeErreurFormeJuridique() != null) && 
      ("".equals(getCodeErreurFormeJuridique()))) {
      return true;
    }
    if ((getCodeErreurPseudo() != null) && 
      ("".equals(getCodeErreurPseudo()))) {
      return true;
    }
    if ((getCodeErreurPremiereLigneAdresseIntermittentCourrier() != null) && 
      ("".equals(getCodeErreurPremiereLigneAdresseIntermittentCourrier()))) {
      return true;
    }
    if ((getCodeErreurDeuxiemeLigneAdresseIntermittentCourrier() != null) && 
      ("".equals(getCodeErreurDeuxiemeLigneAdresseIntermittentCourrier()))) {
      return true;
    }
    if ((getCodeErreurTroisiemeLigneAdresseIntermittentCourrier() != null) && 
      ("".equals(getCodeErreurTroisiemeLigneAdresseIntermittentCourrier()))) {
      return true;
    }
    if ((getCodeErreurQuatriemeLigneAdresseIntermittentCourrier() != null) && 
      ("".equals(getCodeErreurQuatriemeLigneAdresseIntermittentCourrier()))) {
      return true;
    }
    if ((getCodeErreurPositionEmployeur() != null) && 
      ("".equals(getCodeErreurPositionEmployeur()))) {
      return true;
    }
    if ((getCodeErreurPositionAutreEmployeur() != null) && 
      ("".equals(getCodeErreurPositionAutreEmployeur()))) {
      return true;
    }
    if ((getCodeErreurCodeAssedic() != null) && 
      ("".equals(getCodeErreurCodeAssedic()))) {
      return true;
    }
    if ((getCodeErreurRsin() != null) && 
      ("".equals(getCodeErreurRsin()))) {
      return true;
    }
    if ((getCodeErreurCodeNAFBNE() != null) && 
      ("".equals(getCodeErreurCodeNAFBNE()))) {
      return true;
    }
    if ((getCodeErreurCodeEmploiOccupe() != null) && 
      ("".equals(getCodeErreurCodeEmploiOccupe()))) {
      return true;
    }
    if ((getCodeErreurNumeroObjet() != null) && 
      ("".equals(getCodeErreurNumeroObjet()))) {
      return true;
    }
    if ((getCodeErreurCadre() != null) && 
      ("".equals(getCodeErreurCadre()))) {
      return true;
    }
    if ((getCodeErreurForfaitUrssaf() != null) && 
      ("".equals(getCodeErreurForfaitUrssaf()))) {
      return true;
    }
    if ((getCodeErreurTopAlsaceMoselle() != null) && 
      ("".equals(getCodeErreurTopAlsaceMoselle()))) {
      return true;
    }
    if ((getCodeErreurDateDebutContrat() != null) && 
      ("".equals(getCodeErreurDateDebutContrat()))) {
      return true;
    }
    if ((getCodeErreurDateFinContrat() != null) && 
      ("".equals(getCodeErreurDateFinContrat()))) {
      return true;
    }
    if ((getCodeErreurDateCreation() != null) && 
      ("".equals(getCodeErreurDateCreation()))) {
      return true;
    }
    if ((getCodeErreurDateOrigineInformation() != null) && 
      ("".equals(getCodeErreurDateOrigineInformation()))) {
      return true;
    }
    if ((getCodeErreurDateCreationFeuillet() != null) && 
      ("".equals(getCodeErreurDateCreationFeuillet()))) {
      return true;
    }
    if ((getCodeErreurNbJoursTravailles() != null) && 
      ("".equals(getCodeErreurNbJoursTravailles()))) {
      return true;
    }
    if ((getCodeErreurNbHeuresTravaillees() != null) && 
      ("".equals(getCodeErreurNbHeuresTravaillees()))) {
      return true;
    }
    if ((getCodeErreurNbCachets() != null) && 
      ("".equals(getCodeErreurNbCachets()))) {
      return true;
    }
    if ((getCodeErreurSalaireBrutNonAbattu() != null) && 
      ("".equals(getCodeErreurSalaireBrutNonAbattu()))) {
      return true;
    }
    if ((getCodeErreurSalaireBrutAbattu() != null) && 
      ("".equals(getCodeErreurSalaireBrutAbattu()))) {
      return true;
    }
    if ((getCodeErreurNumeroChrono() != null) && 
      ("".equals(getCodeErreurNumeroChrono()))) {
      return true;
    }
    if ((getCodeErreurMontantIccp() != null) && 
      ("".equals(getCodeErreurMontantIccp()))) {
      return true;
    }
    if ((getCodeErreurMontantAvantageNature() != null) && 
      ("".equals(getCodeErreurMontantAvantageNature()))) {
      return true;
    }
    if ((getCodeErreurMontantFraisProfessionnel() != null) && 
      ("".equals(getCodeErreurMontantFraisProfessionnel()))) {
      return true;
    }
    if ((getCodeErreurTauxAbattement() != null) && 
      ("".equals(getCodeErreurTauxAbattement()))) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxGUSOImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */