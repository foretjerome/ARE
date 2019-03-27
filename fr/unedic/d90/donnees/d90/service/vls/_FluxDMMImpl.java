package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import fr.unedic.util.temps.Damj;
import java.io.Serializable;
import java.math.BigDecimal;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _FluxDMMImpl
  extends FluxDMM
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _FluxDMM m_fluxDMMInfra;
  
  public _FluxDMMImpl()
  {
    m_fluxDMMInfra = new _FluxDMM();
  }
  
  public _FluxDMMImpl(_FluxDMM pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("FluxDMMInfra", pValeur);
    
    m_fluxDMMInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_fluxDMMInfra;
  }
  
  public String getIdentifiant()
  {
    return m_fluxDMMInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_fluxDMMInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_fluxDMMInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_fluxDMMInfra.set_C_ETAT(pCode);
  }
  
  public String getNir()
  {
    return m_fluxDMMInfra.getNir();
  }
  
  public String getCodeErreurNir()
  {
    return m_fluxDMMInfra.getNir_C_ERR();
  }
  
  public void setNir(String pValeur)
  {
    m_fluxDMMInfra.setNir(pValeur);
  }
  
  public void setCodeErreurNir(String pCodeErreur)
  {
    m_fluxDMMInfra.setNir_C_ERR(pCodeErreur);
  }
  
  public String getNom()
  {
    return m_fluxDMMInfra.getNom();
  }
  
  public String getCodeErreurNom()
  {
    return m_fluxDMMInfra.getNom_C_ERR();
  }
  
  public void setNom(String pValeur)
  {
    m_fluxDMMInfra.setNom(pValeur);
  }
  
  public void setCodeErreurNom(String pCodeErreur)
  {
    m_fluxDMMInfra.setNom_C_ERR(pCodeErreur);
  }
  
  public String getPrenom()
  {
    return m_fluxDMMInfra.getPrenom();
  }
  
  public String getCodeErreurPrenom()
  {
    return m_fluxDMMInfra.getPrenom_C_ERR();
  }
  
  public void setPrenom(String pValeur)
  {
    m_fluxDMMInfra.setPrenom(pValeur);
  }
  
  public void setCodeErreurPrenom(String pCodeErreur)
  {
    m_fluxDMMInfra.setPrenom_C_ERR(pCodeErreur);
  }
  
  public String getCodeNationalite()
  {
    return m_fluxDMMInfra.getCodeNationalite();
  }
  
  public String getCodeErreurCodeNationalite()
  {
    return m_fluxDMMInfra.getCodeNationalite_C_ERR();
  }
  
  public void setCodeNationalite(String pValeur)
  {
    m_fluxDMMInfra.setCodeNationalite(pValeur);
  }
  
  public void setCodeErreurCodeNationalite(String pCodeErreur)
  {
    m_fluxDMMInfra.setCodeNationalite_C_ERR(pCodeErreur);
  }
  
  public String getCodePostal()
  {
    return m_fluxDMMInfra.getCodePostal();
  }
  
  public String getCodeErreurCodePostal()
  {
    return m_fluxDMMInfra.getCodePostal_C_ERR();
  }
  
  public void setCodePostal(String pValeur)
  {
    m_fluxDMMInfra.setCodePostal(pValeur);
  }
  
  public void setCodeErreurCodePostal(String pCodeErreur)
  {
    m_fluxDMMInfra.setCodePostal_C_ERR(pCodeErreur);
  }
  
  public String getIdentifiantBNE()
  {
    return m_fluxDMMInfra.getIdentifiantBNE();
  }
  
  public String getCodeErreurIdentifiantBNE()
  {
    return m_fluxDMMInfra.getIdentifiantBNE_C_ERR();
  }
  
  public void setIdentifiantBNE(String pValeur)
  {
    m_fluxDMMInfra.setIdentifiantBNE(pValeur);
  }
  
  public void setCodeErreurIdentifiantBNE(String pCodeErreur)
  {
    m_fluxDMMInfra.setIdentifiantBNE_C_ERR(pCodeErreur);
  }
  
  public String getSiret()
  {
    return m_fluxDMMInfra.getSiret();
  }
  
  public String getCodeErreurSiret()
  {
    return m_fluxDMMInfra.getSiret_C_ERR();
  }
  
  public void setSiret(String pValeur)
  {
    m_fluxDMMInfra.setSiret(pValeur);
  }
  
  public void setCodeErreurSiret(String pCodeErreur)
  {
    m_fluxDMMInfra.setSiret_C_ERR(pCodeErreur);
  }
  
  public String getRaisonSociale()
  {
    return m_fluxDMMInfra.getRaisonSociale();
  }
  
  public String getCodeErreurRaisonSociale()
  {
    return m_fluxDMMInfra.getRaisonSociale_C_ERR();
  }
  
  public void setRaisonSociale(String pValeur)
  {
    m_fluxDMMInfra.setRaisonSociale(pValeur);
  }
  
  public void setCodeErreurRaisonSociale(String pCodeErreur)
  {
    m_fluxDMMInfra.setRaisonSociale_C_ERR(pCodeErreur);
  }
  
  public String getNumeroVoie()
  {
    return m_fluxDMMInfra.getNumeroVoie();
  }
  
  public String getCodeErreurNumeroVoie()
  {
    return m_fluxDMMInfra.getNumeroVoie_C_ERR();
  }
  
  public void setNumeroVoie(String pValeur)
  {
    m_fluxDMMInfra.setNumeroVoie(pValeur);
  }
  
  public void setCodeErreurNumeroVoie(String pCodeErreur)
  {
    m_fluxDMMInfra.setNumeroVoie_C_ERR(pCodeErreur);
  }
  
  public String getLibelleVoie()
  {
    return m_fluxDMMInfra.getLibelleVoie();
  }
  
  public String getCodeErreurLibelleVoie()
  {
    return m_fluxDMMInfra.getLibelleVoie_C_ERR();
  }
  
  public void setLibelleVoie(String pValeur)
  {
    m_fluxDMMInfra.setLibelleVoie(pValeur);
  }
  
  public void setCodeErreurLibelleVoie(String pCodeErreur)
  {
    m_fluxDMMInfra.setLibelleVoie_C_ERR(pCodeErreur);
  }
  
  public String getComplementAdresse()
  {
    return m_fluxDMMInfra.getComplementAdresse();
  }
  
  public String getCodeErreurComplementAdresse()
  {
    return m_fluxDMMInfra.getComplementAdresse_C_ERR();
  }
  
  public void setComplementAdresse(String pValeur)
  {
    m_fluxDMMInfra.setComplementAdresse(pValeur);
  }
  
  public void setCodeErreurComplementAdresse(String pCodeErreur)
  {
    m_fluxDMMInfra.setComplementAdresse_C_ERR(pCodeErreur);
  }
  
  public String getCodePostalETT()
  {
    return m_fluxDMMInfra.getCodePostalETT();
  }
  
  public String getCodeErreurCodePostalETT()
  {
    return m_fluxDMMInfra.getCodePostalETT_C_ERR();
  }
  
  public void setCodePostalETT(String pValeur)
  {
    m_fluxDMMInfra.setCodePostalETT(pValeur);
  }
  
  public void setCodeErreurCodePostalETT(String pCodeErreur)
  {
    m_fluxDMMInfra.setCodePostalETT_C_ERR(pCodeErreur);
  }
  
  public String getLibelleCommuneCNAVTS()
  {
    return m_fluxDMMInfra.getLibelleCommuneCNAVTS();
  }
  
  public String getCodeErreurLibelleCommuneCNAVTS()
  {
    return m_fluxDMMInfra.getLibelleCommuneCNAVTS_C_ERR();
  }
  
  public void setLibelleCommuneCNAVTS(String pValeur)
  {
    m_fluxDMMInfra.setLibelleCommuneCNAVTS(pValeur);
  }
  
  public void setCodeErreurLibelleCommuneCNAVTS(String pCodeErreur)
  {
    m_fluxDMMInfra.setLibelleCommuneCNAVTS_C_ERR(pCodeErreur);
  }
  
  public String getIndicateurRappelSalaire()
  {
    return m_fluxDMMInfra.getIndicateurRappelSalaire();
  }
  
  public String getCodeErreurIndicateurRappelSalaire()
  {
    return m_fluxDMMInfra.getIndicateurRappelSalaire_C_ERR();
  }
  
  public void setIndicateurRappelSalaire(String pValeur)
  {
    m_fluxDMMInfra.setIndicateurRappelSalaire(pValeur);
  }
  
  public void setCodeErreurIndicateurRappelSalaire(String pCodeErreur)
  {
    m_fluxDMMInfra.setIndicateurRappelSalaire_C_ERR(pCodeErreur);
  }
  
  public String getCodeMonnaie()
  {
    return m_fluxDMMInfra.getCodeMonnaie();
  }
  
  public String getCodeErreurCodeMonnaie()
  {
    return m_fluxDMMInfra.getCodeMonnaie_C_ERR();
  }
  
  public void setCodeMonnaie(String pValeur)
  {
    m_fluxDMMInfra.setCodeMonnaie(pValeur);
  }
  
  public void setCodeErreurCodeMonnaie(String pCodeErreur)
  {
    m_fluxDMMInfra.setCodeMonnaie_C_ERR(pCodeErreur);
  }
  
  public String getMotifFinContrat()
  {
    return m_fluxDMMInfra.getMotifFinContrat();
  }
  
  public String getCodeErreurMotifFinContrat()
  {
    return m_fluxDMMInfra.getMotifFinContrat_C_ERR();
  }
  
  public void setMotifFinContrat(String pValeur)
  {
    m_fluxDMMInfra.setMotifFinContrat(pValeur);
  }
  
  public void setCodeErreurMotifFinContrat(String pCodeErreur)
  {
    m_fluxDMMInfra.setMotifFinContrat_C_ERR(pCodeErreur);
  }
  
  public String getNumeroContrat()
  {
    return m_fluxDMMInfra.getNumeroContrat();
  }
  
  public String getCodeErreurNumeroContrat()
  {
    return m_fluxDMMInfra.getNumeroContrat_C_ERR();
  }
  
  public void setNumeroContrat(String pValeur)
  {
    m_fluxDMMInfra.setNumeroContrat(pValeur);
  }
  
  public void setCodeErreurNumeroContrat(String pCodeErreur)
  {
    m_fluxDMMInfra.setNumeroContrat_C_ERR(pCodeErreur);
  }
  
  public String getCaisseAgirc()
  {
    return m_fluxDMMInfra.getCaisseAgirc();
  }
  
  public String getCodeErreurCaisseAgirc()
  {
    return m_fluxDMMInfra.getCaisseAgirc_C_ERR();
  }
  
  public void setCaisseAgirc(String pValeur)
  {
    m_fluxDMMInfra.setCaisseAgirc(pValeur);
  }
  
  public void setCodeErreurCaisseAgirc(String pCodeErreur)
  {
    m_fluxDMMInfra.setCaisseAgirc_C_ERR(pCodeErreur);
  }
  
  public String getCaisseArrco()
  {
    return m_fluxDMMInfra.getCaisseArrco();
  }
  
  public String getCodeErreurCaisseArrco()
  {
    return m_fluxDMMInfra.getCaisseArrco_C_ERR();
  }
  
  public void setCaisseArrco(String pValeur)
  {
    m_fluxDMMInfra.setCaisseArrco(pValeur);
  }
  
  public void setCodeErreurCaisseArrco(String pCodeErreur)
  {
    m_fluxDMMInfra.setCaisseArrco_C_ERR(pCodeErreur);
  }
  
  public String getCadre()
  {
    return m_fluxDMMInfra.getCadre();
  }
  
  public String getCodeErreurCadre()
  {
    return m_fluxDMMInfra.getCadre_C_ERR();
  }
  
  public void setCadre(String pValeur)
  {
    m_fluxDMMInfra.setCadre(pValeur);
  }
  
  public void setCodeErreurCadre(String pCodeErreur)
  {
    m_fluxDMMInfra.setCadre_C_ERR(pCodeErreur);
  }
  
  public String getDernierEmploiTenu()
  {
    return m_fluxDMMInfra.getDernierEmploiTenu();
  }
  
  public String getCodeErreurDernierEmploiTenu()
  {
    return m_fluxDMMInfra.getDernierEmploiTenu_C_ERR();
  }
  
  public void setDernierEmploiTenu(String pValeur)
  {
    m_fluxDMMInfra.setDernierEmploiTenu(pValeur);
  }
  
  public void setCodeErreurDernierEmploiTenu(String pCodeErreur)
  {
    m_fluxDMMInfra.setDernierEmploiTenu_C_ERR(pCodeErreur);
  }
  
  public String getNiveauQualification()
  {
    return m_fluxDMMInfra.getNiveauQualification();
  }
  
  public String getCodeErreurNiveauQualification()
  {
    return m_fluxDMMInfra.getNiveauQualification_C_ERR();
  }
  
  public void setNiveauQualification(String pValeur)
  {
    m_fluxDMMInfra.setNiveauQualification(pValeur);
  }
  
  public void setCodeErreurNiveauQualification(String pCodeErreur)
  {
    m_fluxDMMInfra.setNiveauQualification_C_ERR(pCodeErreur);
  }
  
  public String getIndicateurQualiteNIR()
  {
    return m_fluxDMMInfra.getIndicateurQualiteNIR();
  }
  
  public String getCodeErreurIndicateurQualiteNIR()
  {
    return m_fluxDMMInfra.getIndicateurQualiteNIR_C_ERR();
  }
  
  public void setIndicateurQualiteNIR(String pValeur)
  {
    m_fluxDMMInfra.setIndicateurQualiteNIR(pValeur);
  }
  
  public void setCodeErreurIndicateurQualiteNIR(String pCodeErreur)
  {
    m_fluxDMMInfra.setIndicateurQualiteNIR_C_ERR(pCodeErreur);
  }
  
  public String getLieuMission()
  {
    return m_fluxDMMInfra.getLieuMission();
  }
  
  public String getCodeErreurLieuMission()
  {
    return m_fluxDMMInfra.getLieuMission_C_ERR();
  }
  
  public void setLieuMission(String pValeur)
  {
    m_fluxDMMInfra.setLieuMission(pValeur);
  }
  
  public void setCodeErreurLieuMission(String pCodeErreur)
  {
    m_fluxDMMInfra.setLieuMission_C_ERR(pCodeErreur);
  }
  
  public String getFiller()
  {
    return m_fluxDMMInfra.getFiller();
  }
  
  public String getCodeErreurFiller()
  {
    return m_fluxDMMInfra.getFiller_C_ERR();
  }
  
  public void setFiller(String pValeur)
  {
    m_fluxDMMInfra.setFiller(pValeur);
  }
  
  public void setCodeErreurFiller(String pCodeErreur)
  {
    m_fluxDMMInfra.setFiller_C_ERR(pCodeErreur);
  }
  
  public String getBneSiret()
  {
    return m_fluxDMMInfra.getBneSiret();
  }
  
  public String getCodeErreurBneSiret()
  {
    return m_fluxDMMInfra.getBneSiret_C_ERR();
  }
  
  public void setBneSiret(String pValeur)
  {
    m_fluxDMMInfra.setBneSiret(pValeur);
  }
  
  public void setCodeErreurBneSiret(String pCodeErreur)
  {
    m_fluxDMMInfra.setBneSiret_C_ERR(pCodeErreur);
  }
  
  public String getBneRaisonSociale()
  {
    return m_fluxDMMInfra.getBneRaisonSociale();
  }
  
  public String getCodeErreurBneRaisonSociale()
  {
    return m_fluxDMMInfra.getBneRaisonSociale_C_ERR();
  }
  
  public void setBneRaisonSociale(String pValeur)
  {
    m_fluxDMMInfra.setBneRaisonSociale(pValeur);
  }
  
  public void setCodeErreurBneRaisonSociale(String pCodeErreur)
  {
    m_fluxDMMInfra.setBneRaisonSociale_C_ERR(pCodeErreur);
  }
  
  public String getBneNumeroVoirie()
  {
    return m_fluxDMMInfra.getBneNumeroVoirie();
  }
  
  public String getCodeErreurBneNumeroVoirie()
  {
    return m_fluxDMMInfra.getBneNumeroVoirie_C_ERR();
  }
  
  public void setBneNumeroVoirie(String pValeur)
  {
    m_fluxDMMInfra.setBneNumeroVoirie(pValeur);
  }
  
  public void setCodeErreurBneNumeroVoirie(String pCodeErreur)
  {
    m_fluxDMMInfra.setBneNumeroVoirie_C_ERR(pCodeErreur);
  }
  
  public String getBneLibelleVoieAdresse()
  {
    return m_fluxDMMInfra.getBneLibelleVoieAdresse();
  }
  
  public String getCodeErreurBneLibelleVoieAdresse()
  {
    return m_fluxDMMInfra.getBneLibelleVoieAdresse_C_ERR();
  }
  
  public void setBneLibelleVoieAdresse(String pValeur)
  {
    m_fluxDMMInfra.setBneLibelleVoieAdresse(pValeur);
  }
  
  public void setCodeErreurBneLibelleVoieAdresse(String pCodeErreur)
  {
    m_fluxDMMInfra.setBneLibelleVoieAdresse_C_ERR(pCodeErreur);
  }
  
  public String getBneComplAdresse()
  {
    return m_fluxDMMInfra.getBneComplAdresse();
  }
  
  public String getCodeErreurBneComplAdresse()
  {
    return m_fluxDMMInfra.getBneComplAdresse_C_ERR();
  }
  
  public void setBneComplAdresse(String pValeur)
  {
    m_fluxDMMInfra.setBneComplAdresse(pValeur);
  }
  
  public void setCodeErreurBneComplAdresse(String pCodeErreur)
  {
    m_fluxDMMInfra.setBneComplAdresse_C_ERR(pCodeErreur);
  }
  
  public String getBneCodePostal()
  {
    return m_fluxDMMInfra.getBneCodePostal();
  }
  
  public String getCodeErreurBneCodePostal()
  {
    return m_fluxDMMInfra.getBneCodePostal_C_ERR();
  }
  
  public void setBneCodePostal(String pValeur)
  {
    m_fluxDMMInfra.setBneCodePostal(pValeur);
  }
  
  public void setCodeErreurBneCodePostal(String pCodeErreur)
  {
    m_fluxDMMInfra.setBneCodePostal_C_ERR(pCodeErreur);
  }
  
  public String getBneLibelleCommune()
  {
    return m_fluxDMMInfra.getBneLibelleCommune();
  }
  
  public String getCodeErreurBneLibelleCommune()
  {
    return m_fluxDMMInfra.getBneLibelleCommune_C_ERR();
  }
  
  public void setBneLibelleCommune(String pValeur)
  {
    m_fluxDMMInfra.setBneLibelleCommune(pValeur);
  }
  
  public void setCodeErreurBneLibelleCommune(String pCodeErreur)
  {
    m_fluxDMMInfra.setBneLibelleCommune_C_ERR(pCodeErreur);
  }
  
  public String getBneAssedicAffiliation()
  {
    return m_fluxDMMInfra.getBneAssedicAffiliation();
  }
  
  public String getCodeErreurBneAssedicAffiliation()
  {
    return m_fluxDMMInfra.getBneAssedicAffiliation_C_ERR();
  }
  
  public void setBneAssedicAffiliation(String pValeur)
  {
    m_fluxDMMInfra.setBneAssedicAffiliation(pValeur);
  }
  
  public void setCodeErreurBneAssedicAffiliation(String pCodeErreur)
  {
    m_fluxDMMInfra.setBneAssedicAffiliation_C_ERR(pCodeErreur);
  }
  
  public String getBneNumAffiliation()
  {
    return m_fluxDMMInfra.getBneNumAffiliation();
  }
  
  public String getCodeErreurBneNumAffiliation()
  {
    return m_fluxDMMInfra.getBneNumAffiliation_C_ERR();
  }
  
  public void setBneNumAffiliation(String pValeur)
  {
    m_fluxDMMInfra.setBneNumAffiliation(pValeur);
  }
  
  public void setCodeErreurBneNumAffiliation(String pCodeErreur)
  {
    m_fluxDMMInfra.setBneNumAffiliation_C_ERR(pCodeErreur);
  }
  
  public String getBneRetraiteAgirc1()
  {
    return m_fluxDMMInfra.getBneRetraiteAgirc1();
  }
  
  public String getCodeErreurBneRetraiteAgirc1()
  {
    return m_fluxDMMInfra.getBneRetraiteAgirc1_C_ERR();
  }
  
  public void setBneRetraiteAgirc1(String pValeur)
  {
    m_fluxDMMInfra.setBneRetraiteAgirc1(pValeur);
  }
  
  public void setCodeErreurBneRetraiteAgirc1(String pCodeErreur)
  {
    m_fluxDMMInfra.setBneRetraiteAgirc1_C_ERR(pCodeErreur);
  }
  
  public String getBneRetraiteAgirc2()
  {
    return m_fluxDMMInfra.getBneRetraiteAgirc2();
  }
  
  public String getCodeErreurBneRetraiteAgirc2()
  {
    return m_fluxDMMInfra.getBneRetraiteAgirc2_C_ERR();
  }
  
  public void setBneRetraiteAgirc2(String pValeur)
  {
    m_fluxDMMInfra.setBneRetraiteAgirc2(pValeur);
  }
  
  public void setCodeErreurBneRetraiteAgirc2(String pCodeErreur)
  {
    m_fluxDMMInfra.setBneRetraiteAgirc2_C_ERR(pCodeErreur);
  }
  
  public String getBneLibelleRetraiteAgirc1()
  {
    return m_fluxDMMInfra.getBneLibelleRetraiteAgirc1();
  }
  
  public String getCodeErreurBneLibelleRetraiteAgirc1()
  {
    return m_fluxDMMInfra.getBneLibelleRetraiteAgirc1_C_ERR();
  }
  
  public void setBneLibelleRetraiteAgirc1(String pValeur)
  {
    m_fluxDMMInfra.setBneLibelleRetraiteAgirc1(pValeur);
  }
  
  public void setCodeErreurBneLibelleRetraiteAgirc1(String pCodeErreur)
  {
    m_fluxDMMInfra.setBneLibelleRetraiteAgirc1_C_ERR(pCodeErreur);
  }
  
  public String getBneLibelleRetraiteAgirc2()
  {
    return m_fluxDMMInfra.getBneLibelleRetraiteAgirc2();
  }
  
  public String getCodeErreurBneLibelleRetraiteAgirc2()
  {
    return m_fluxDMMInfra.getBneLibelleRetraiteAgirc2_C_ERR();
  }
  
  public void setBneLibelleRetraiteAgirc2(String pValeur)
  {
    m_fluxDMMInfra.setBneLibelleRetraiteAgirc2(pValeur);
  }
  
  public void setCodeErreurBneLibelleRetraiteAgirc2(String pCodeErreur)
  {
    m_fluxDMMInfra.setBneLibelleRetraiteAgirc2_C_ERR(pCodeErreur);
  }
  
  public String getBneIdentifiantBne()
  {
    return m_fluxDMMInfra.getBneIdentifiantBne();
  }
  
  public String getCodeErreurBneIdentifiantBne()
  {
    return m_fluxDMMInfra.getBneIdentifiantBne_C_ERR();
  }
  
  public void setBneIdentifiantBne(String pValeur)
  {
    m_fluxDMMInfra.setBneIdentifiantBne(pValeur);
  }
  
  public void setCodeErreurBneIdentifiantBne(String pCodeErreur)
  {
    m_fluxDMMInfra.setBneIdentifiantBne_C_ERR(pCodeErreur);
  }
  
  public String getIndicateurMontantIccp()
  {
    return m_fluxDMMInfra.getIndicateurMontantIccp();
  }
  
  public String getCodeErreurIndicateurMontantIccp()
  {
    return m_fluxDMMInfra.getIndicateurMontantIccp_C_ERR();
  }
  
  public void setIndicateurMontantIccp(String pValeur)
  {
    m_fluxDMMInfra.setIndicateurMontantIccp(pValeur);
  }
  
  public void setCodeErreurIndicateurMontantIccp(String pCodeErreur)
  {
    m_fluxDMMInfra.setIndicateurMontantIccp_C_ERR(pCodeErreur);
  }
  
  public String getIndicateurMotifFinContrat()
  {
    return m_fluxDMMInfra.getIndicateurMotifFinContrat();
  }
  
  public String getCodeErreurIndicateurMotifFinContrat()
  {
    return m_fluxDMMInfra.getIndicateurMotifFinContrat_C_ERR();
  }
  
  public void setIndicateurMotifFinContrat(String pValeur)
  {
    m_fluxDMMInfra.setIndicateurMotifFinContrat(pValeur);
  }
  
  public void setCodeErreurIndicateurMotifFinContrat(String pCodeErreur)
  {
    m_fluxDMMInfra.setIndicateurMotifFinContrat_C_ERR(pCodeErreur);
  }
  
  public String getIndicateurNombreHeuresMision()
  {
    return m_fluxDMMInfra.getIndicateurNombreHeuresMision();
  }
  
  public String getCodeErreurIndicateurNombreHeuresMision()
  {
    return m_fluxDMMInfra.getIndicateurNombreHeuresMision_C_ERR();
  }
  
  public void setIndicateurNombreHeuresMision(String pValeur)
  {
    m_fluxDMMInfra.setIndicateurNombreHeuresMision(pValeur);
  }
  
  public void setCodeErreurIndicateurNombreHeuresMision(String pCodeErreur)
  {
    m_fluxDMMInfra.setIndicateurNombreHeuresMision_C_ERR(pCodeErreur);
  }
  
  public String getIndicateurMontantIfm()
  {
    return m_fluxDMMInfra.getIndicateurMontantIfm();
  }
  
  public String getCodeErreurIndicateurMontantIfm()
  {
    return m_fluxDMMInfra.getIndicateurMontantIfm_C_ERR();
  }
  
  public void setIndicateurMontantIfm(String pValeur)
  {
    m_fluxDMMInfra.setIndicateurMontantIfm(pValeur);
  }
  
  public void setCodeErreurIndicateurMontantIfm(String pCodeErreur)
  {
    m_fluxDMMInfra.setIndicateurMontantIfm_C_ERR(pCodeErreur);
  }
  
  public String getIndicateurRappelMission()
  {
    return m_fluxDMMInfra.getIndicateurRappelMission();
  }
  
  public String getCodeErreurIndicateurRappelMission()
  {
    return m_fluxDMMInfra.getIndicateurRappelMission_C_ERR();
  }
  
  public void setIndicateurRappelMission(String pValeur)
  {
    m_fluxDMMInfra.setIndicateurRappelMission(pValeur);
  }
  
  public void setCodeErreurIndicateurRappelMission(String pCodeErreur)
  {
    m_fluxDMMInfra.setIndicateurRappelMission_C_ERR(pCodeErreur);
  }
  
  public String getIndicateurNouveauProtocole()
  {
    return m_fluxDMMInfra.getIndicateurNouveauProtocole();
  }
  
  public String getCodeErreurIndicateurNouveauProtocole()
  {
    return m_fluxDMMInfra.getIndicateurNouveauProtocole_C_ERR();
  }
  
  public void setIndicateurNouveauProtocole(String pValeur)
  {
    m_fluxDMMInfra.setIndicateurNouveauProtocole(pValeur);
  }
  
  public void setCodeErreurIndicateurNouveauProtocole(String pCodeErreur)
  {
    m_fluxDMMInfra.setIndicateurNouveauProtocole_C_ERR(pCodeErreur);
  }
  
  public String getNumeroDocument()
  {
    return m_fluxDMMInfra.getNumeroDocument();
  }
  
  public String getCodeErreurNumeroDocument()
  {
    return m_fluxDMMInfra.getNumeroDocument_C_ERR();
  }
  
  public void setNumeroDocument(String pValeur)
  {
    m_fluxDMMInfra.setNumeroDocument(pValeur);
  }
  
  public void setCodeErreurNumeroDocument(String pCodeErreur)
  {
    m_fluxDMMInfra.setNumeroDocument_C_ERR(pCodeErreur);
  }
  
  public Damj getDateNaissance()
  {
    return m_fluxDMMInfra.getDateNaissance();
  }
  
  public String getCodeErreurDateNaissance()
  {
    return m_fluxDMMInfra.getDateNaissance_C_ERR();
  }
  
  public void setDateNaissance(Damj pValeur)
  {
    m_fluxDMMInfra.setDateNaissance(pValeur);
  }
  
  public void setCodeErreurDateNaissance(String pCodeErreur)
  {
    m_fluxDMMInfra.setDateNaissance_C_ERR(pCodeErreur);
  }
  
  public Damj getDateDebutPeriode()
  {
    return m_fluxDMMInfra.getDateDebutPeriode();
  }
  
  public String getCodeErreurDateDebutPeriode()
  {
    return m_fluxDMMInfra.getDateDebutPeriode_C_ERR();
  }
  
  public void setDateDebutPeriode(Damj pValeur)
  {
    m_fluxDMMInfra.setDateDebutPeriode(pValeur);
  }
  
  public void setCodeErreurDateDebutPeriode(String pCodeErreur)
  {
    m_fluxDMMInfra.setDateDebutPeriode_C_ERR(pCodeErreur);
  }
  
  public Damj getDateFinPeriode()
  {
    return m_fluxDMMInfra.getDateFinPeriode();
  }
  
  public String getCodeErreurDateFinPeriode()
  {
    return m_fluxDMMInfra.getDateFinPeriode_C_ERR();
  }
  
  public void setDateFinPeriode(Damj pValeur)
  {
    m_fluxDMMInfra.setDateFinPeriode(pValeur);
  }
  
  public void setCodeErreurDateFinPeriode(String pCodeErreur)
  {
    m_fluxDMMInfra.setDateFinPeriode_C_ERR(pCodeErreur);
  }
  
  public Damj getDateFichierExterne()
  {
    return m_fluxDMMInfra.getDateFichierExterne();
  }
  
  public String getCodeErreurDateFichierExterne()
  {
    return m_fluxDMMInfra.getDateFichierExterne_C_ERR();
  }
  
  public void setDateFichierExterne(Damj pValeur)
  {
    m_fluxDMMInfra.setDateFichierExterne(pValeur);
  }
  
  public void setCodeErreurDateFichierExterne(String pCodeErreur)
  {
    m_fluxDMMInfra.setDateFichierExterne_C_ERR(pCodeErreur);
  }
  
  public Damj getDateTraitement()
  {
    return m_fluxDMMInfra.getDateTraitement();
  }
  
  public String getCodeErreurDateTraitement()
  {
    return m_fluxDMMInfra.getDateTraitement_C_ERR();
  }
  
  public void setDateTraitement(Damj pValeur)
  {
    m_fluxDMMInfra.setDateTraitement(pValeur);
  }
  
  public void setCodeErreurDateTraitement(String pCodeErreur)
  {
    m_fluxDMMInfra.setDateTraitement_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getSieclePeriodeRef()
  {
    return m_fluxDMMInfra.getSieclePeriodeRef();
  }
  
  public String getCodeErreurSieclePeriodeRef()
  {
    return m_fluxDMMInfra.getSieclePeriodeRef_C_ERR();
  }
  
  public void setSieclePeriodeRef(BigDecimal pValeur)
  {
    m_fluxDMMInfra.setSieclePeriodeRef(pValeur);
  }
  
  public void setCodeErreurSieclePeriodeRef(String pCodeErreur)
  {
    m_fluxDMMInfra.setSieclePeriodeRef_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getMoisPeriodeRef()
  {
    return m_fluxDMMInfra.getMoisPeriodeRef();
  }
  
  public String getCodeErreurMoisPeriodeRef()
  {
    return m_fluxDMMInfra.getMoisPeriodeRef_C_ERR();
  }
  
  public void setMoisPeriodeRef(BigDecimal pValeur)
  {
    m_fluxDMMInfra.setMoisPeriodeRef(pValeur);
  }
  
  public void setCodeErreurMoisPeriodeRef(String pCodeErreur)
  {
    m_fluxDMMInfra.setMoisPeriodeRef_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getSalaireBrut()
  {
    return m_fluxDMMInfra.getSalaireBrut();
  }
  
  public String getCodeErreurSalaireBrut()
  {
    return m_fluxDMMInfra.getSalaireBrut_C_ERR();
  }
  
  public void setSalaireBrut(BigDecimal pValeur)
  {
    m_fluxDMMInfra.setSalaireBrut(pValeur);
  }
  
  public void setCodeErreurSalaireBrut(String pCodeErreur)
  {
    m_fluxDMMInfra.setSalaireBrut_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getMontantIccp()
  {
    return m_fluxDMMInfra.getMontantIccp();
  }
  
  public String getCodeErreurMontantIccp()
  {
    return m_fluxDMMInfra.getMontantIccp_C_ERR();
  }
  
  public void setMontantIccp(BigDecimal pValeur)
  {
    m_fluxDMMInfra.setMontantIccp(pValeur);
  }
  
  public void setCodeErreurMontantIccp(String pCodeErreur)
  {
    m_fluxDMMInfra.setMontantIccp_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getNombreHeuresMission()
  {
    return m_fluxDMMInfra.getNombreHeuresMission();
  }
  
  public String getCodeErreurNombreHeuresMission()
  {
    return m_fluxDMMInfra.getNombreHeuresMission_C_ERR();
  }
  
  public void setNombreHeuresMission(BigDecimal pValeur)
  {
    m_fluxDMMInfra.setNombreHeuresMission(pValeur);
  }
  
  public void setCodeErreurNombreHeuresMission(String pCodeErreur)
  {
    m_fluxDMMInfra.setNombreHeuresMission_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getMontantIfm()
  {
    return m_fluxDMMInfra.getMontantIfm();
  }
  
  public String getCodeErreurMontantIfm()
  {
    return m_fluxDMMInfra.getMontantIfm_C_ERR();
  }
  
  public void setMontantIfm(BigDecimal pValeur)
  {
    m_fluxDMMInfra.setMontantIfm(pValeur);
  }
  
  public void setCodeErreurMontantIfm(String pCodeErreur)
  {
    m_fluxDMMInfra.setMontantIfm_C_ERR(pCodeErreur);
  }
  
  public _FluxDMM getFluxDMMInfra()
  {
    return m_fluxDMMInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    if ((getCodeErreurNir() != null) && 
      ("".equals(getCodeErreurNir()))) {
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
    if ((getCodeErreurCodeNationalite() != null) && 
      ("".equals(getCodeErreurCodeNationalite()))) {
      return true;
    }
    if ((getCodeErreurCodePostal() != null) && 
      ("".equals(getCodeErreurCodePostal()))) {
      return true;
    }
    if ((getCodeErreurIdentifiantBNE() != null) && 
      ("".equals(getCodeErreurIdentifiantBNE()))) {
      return true;
    }
    if ((getCodeErreurSiret() != null) && 
      ("".equals(getCodeErreurSiret()))) {
      return true;
    }
    if ((getCodeErreurRaisonSociale() != null) && 
      ("".equals(getCodeErreurRaisonSociale()))) {
      return true;
    }
    if ((getCodeErreurNumeroVoie() != null) && 
      ("".equals(getCodeErreurNumeroVoie()))) {
      return true;
    }
    if ((getCodeErreurLibelleVoie() != null) && 
      ("".equals(getCodeErreurLibelleVoie()))) {
      return true;
    }
    if ((getCodeErreurComplementAdresse() != null) && 
      ("".equals(getCodeErreurComplementAdresse()))) {
      return true;
    }
    if ((getCodeErreurCodePostalETT() != null) && 
      ("".equals(getCodeErreurCodePostalETT()))) {
      return true;
    }
    if ((getCodeErreurLibelleCommuneCNAVTS() != null) && 
      ("".equals(getCodeErreurLibelleCommuneCNAVTS()))) {
      return true;
    }
    if ((getCodeErreurIndicateurRappelSalaire() != null) && 
      ("".equals(getCodeErreurIndicateurRappelSalaire()))) {
      return true;
    }
    if ((getCodeErreurCodeMonnaie() != null) && 
      ("".equals(getCodeErreurCodeMonnaie()))) {
      return true;
    }
    if ((getCodeErreurMotifFinContrat() != null) && 
      ("".equals(getCodeErreurMotifFinContrat()))) {
      return true;
    }
    if ((getCodeErreurNumeroContrat() != null) && 
      ("".equals(getCodeErreurNumeroContrat()))) {
      return true;
    }
    if ((getCodeErreurCaisseAgirc() != null) && 
      ("".equals(getCodeErreurCaisseAgirc()))) {
      return true;
    }
    if ((getCodeErreurCaisseArrco() != null) && 
      ("".equals(getCodeErreurCaisseArrco()))) {
      return true;
    }
    if ((getCodeErreurCadre() != null) && 
      ("".equals(getCodeErreurCadre()))) {
      return true;
    }
    if ((getCodeErreurDernierEmploiTenu() != null) && 
      ("".equals(getCodeErreurDernierEmploiTenu()))) {
      return true;
    }
    if ((getCodeErreurNiveauQualification() != null) && 
      ("".equals(getCodeErreurNiveauQualification()))) {
      return true;
    }
    if ((getCodeErreurIndicateurQualiteNIR() != null) && 
      ("".equals(getCodeErreurIndicateurQualiteNIR()))) {
      return true;
    }
    if ((getCodeErreurLieuMission() != null) && 
      ("".equals(getCodeErreurLieuMission()))) {
      return true;
    }
    if ((getCodeErreurFiller() != null) && 
      ("".equals(getCodeErreurFiller()))) {
      return true;
    }
    if ((getCodeErreurBneSiret() != null) && 
      ("".equals(getCodeErreurBneSiret()))) {
      return true;
    }
    if ((getCodeErreurBneRaisonSociale() != null) && 
      ("".equals(getCodeErreurBneRaisonSociale()))) {
      return true;
    }
    if ((getCodeErreurBneNumeroVoirie() != null) && 
      ("".equals(getCodeErreurBneNumeroVoirie()))) {
      return true;
    }
    if ((getCodeErreurBneLibelleVoieAdresse() != null) && 
      ("".equals(getCodeErreurBneLibelleVoieAdresse()))) {
      return true;
    }
    if ((getCodeErreurBneComplAdresse() != null) && 
      ("".equals(getCodeErreurBneComplAdresse()))) {
      return true;
    }
    if ((getCodeErreurBneCodePostal() != null) && 
      ("".equals(getCodeErreurBneCodePostal()))) {
      return true;
    }
    if ((getCodeErreurBneLibelleCommune() != null) && 
      ("".equals(getCodeErreurBneLibelleCommune()))) {
      return true;
    }
    if ((getCodeErreurBneAssedicAffiliation() != null) && 
      ("".equals(getCodeErreurBneAssedicAffiliation()))) {
      return true;
    }
    if ((getCodeErreurBneNumAffiliation() != null) && 
      ("".equals(getCodeErreurBneNumAffiliation()))) {
      return true;
    }
    if ((getCodeErreurBneRetraiteAgirc1() != null) && 
      ("".equals(getCodeErreurBneRetraiteAgirc1()))) {
      return true;
    }
    if ((getCodeErreurBneRetraiteAgirc2() != null) && 
      ("".equals(getCodeErreurBneRetraiteAgirc2()))) {
      return true;
    }
    if ((getCodeErreurBneLibelleRetraiteAgirc1() != null) && 
      ("".equals(getCodeErreurBneLibelleRetraiteAgirc1()))) {
      return true;
    }
    if ((getCodeErreurBneLibelleRetraiteAgirc2() != null) && 
      ("".equals(getCodeErreurBneLibelleRetraiteAgirc2()))) {
      return true;
    }
    if ((getCodeErreurBneIdentifiantBne() != null) && 
      ("".equals(getCodeErreurBneIdentifiantBne()))) {
      return true;
    }
    if ((getCodeErreurIndicateurMontantIccp() != null) && 
      ("".equals(getCodeErreurIndicateurMontantIccp()))) {
      return true;
    }
    if ((getCodeErreurIndicateurMotifFinContrat() != null) && 
      ("".equals(getCodeErreurIndicateurMotifFinContrat()))) {
      return true;
    }
    if ((getCodeErreurIndicateurNombreHeuresMision() != null) && 
      ("".equals(getCodeErreurIndicateurNombreHeuresMision()))) {
      return true;
    }
    if ((getCodeErreurIndicateurMontantIfm() != null) && 
      ("".equals(getCodeErreurIndicateurMontantIfm()))) {
      return true;
    }
    if ((getCodeErreurIndicateurRappelMission() != null) && 
      ("".equals(getCodeErreurIndicateurRappelMission()))) {
      return true;
    }
    if ((getCodeErreurIndicateurNouveauProtocole() != null) && 
      ("".equals(getCodeErreurIndicateurNouveauProtocole()))) {
      return true;
    }
    if ((getCodeErreurNumeroDocument() != null) && 
      ("".equals(getCodeErreurNumeroDocument()))) {
      return true;
    }
    if ((getCodeErreurDateNaissance() != null) && 
      ("".equals(getCodeErreurDateNaissance()))) {
      return true;
    }
    if ((getCodeErreurDateDebutPeriode() != null) && 
      ("".equals(getCodeErreurDateDebutPeriode()))) {
      return true;
    }
    if ((getCodeErreurDateFinPeriode() != null) && 
      ("".equals(getCodeErreurDateFinPeriode()))) {
      return true;
    }
    if ((getCodeErreurDateFichierExterne() != null) && 
      ("".equals(getCodeErreurDateFichierExterne()))) {
      return true;
    }
    if ((getCodeErreurDateTraitement() != null) && 
      ("".equals(getCodeErreurDateTraitement()))) {
      return true;
    }
    if ((getCodeErreurSieclePeriodeRef() != null) && 
      ("".equals(getCodeErreurSieclePeriodeRef()))) {
      return true;
    }
    if ((getCodeErreurMoisPeriodeRef() != null) && 
      ("".equals(getCodeErreurMoisPeriodeRef()))) {
      return true;
    }
    if ((getCodeErreurSalaireBrut() != null) && 
      ("".equals(getCodeErreurSalaireBrut()))) {
      return true;
    }
    if ((getCodeErreurMontantIccp() != null) && 
      ("".equals(getCodeErreurMontantIccp()))) {
      return true;
    }
    if ((getCodeErreurNombreHeuresMission() != null) && 
      ("".equals(getCodeErreurNombreHeuresMission()))) {
      return true;
    }
    if ((getCodeErreurMontantIfm() != null) && 
      ("".equals(getCodeErreurMontantIfm()))) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxDMMImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */