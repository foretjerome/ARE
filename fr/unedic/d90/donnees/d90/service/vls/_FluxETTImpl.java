package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import fr.unedic.util.temps.Damj;
import java.io.Serializable;
import java.math.BigDecimal;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _FluxETTImpl
  extends FluxETT
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _FluxETT m_fluxETTInfra;
  
  public _FluxETTImpl()
  {
    m_fluxETTInfra = new _FluxETT();
  }
  
  public _FluxETTImpl(_FluxETT pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("FluxETTInfra", pValeur);
    
    m_fluxETTInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_fluxETTInfra;
  }
  
  public String getIdentifiant()
  {
    return m_fluxETTInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_fluxETTInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_fluxETTInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_fluxETTInfra.set_C_ETAT(pCode);
  }
  
  public String getNir()
  {
    return m_fluxETTInfra.getNir();
  }
  
  public String getCodeErreurNir()
  {
    return m_fluxETTInfra.getNir_C_ERR();
  }
  
  public void setNir(String pValeur)
  {
    m_fluxETTInfra.setNir(pValeur);
  }
  
  public void setCodeErreurNir(String pCodeErreur)
  {
    m_fluxETTInfra.setNir_C_ERR(pCodeErreur);
  }
  
  public String getNom()
  {
    return m_fluxETTInfra.getNom();
  }
  
  public String getCodeErreurNom()
  {
    return m_fluxETTInfra.getNom_C_ERR();
  }
  
  public void setNom(String pValeur)
  {
    m_fluxETTInfra.setNom(pValeur);
  }
  
  public void setCodeErreurNom(String pCodeErreur)
  {
    m_fluxETTInfra.setNom_C_ERR(pCodeErreur);
  }
  
  public String getPrenom()
  {
    return m_fluxETTInfra.getPrenom();
  }
  
  public String getCodeErreurPrenom()
  {
    return m_fluxETTInfra.getPrenom_C_ERR();
  }
  
  public void setPrenom(String pValeur)
  {
    m_fluxETTInfra.setPrenom(pValeur);
  }
  
  public void setCodeErreurPrenom(String pCodeErreur)
  {
    m_fluxETTInfra.setPrenom_C_ERR(pCodeErreur);
  }
  
  public String getCodeNationalite()
  {
    return m_fluxETTInfra.getCodeNationalite();
  }
  
  public String getCodeErreurCodeNationalite()
  {
    return m_fluxETTInfra.getCodeNationalite_C_ERR();
  }
  
  public void setCodeNationalite(String pValeur)
  {
    m_fluxETTInfra.setCodeNationalite(pValeur);
  }
  
  public void setCodeErreurCodeNationalite(String pCodeErreur)
  {
    m_fluxETTInfra.setCodeNationalite_C_ERR(pCodeErreur);
  }
  
  public String getCodePostal()
  {
    return m_fluxETTInfra.getCodePostal();
  }
  
  public String getCodeErreurCodePostal()
  {
    return m_fluxETTInfra.getCodePostal_C_ERR();
  }
  
  public void setCodePostal(String pValeur)
  {
    m_fluxETTInfra.setCodePostal(pValeur);
  }
  
  public void setCodeErreurCodePostal(String pCodeErreur)
  {
    m_fluxETTInfra.setCodePostal_C_ERR(pCodeErreur);
  }
  
  public String getIdentifiantBNE()
  {
    return m_fluxETTInfra.getIdentifiantBNE();
  }
  
  public String getCodeErreurIdentifiantBNE()
  {
    return m_fluxETTInfra.getIdentifiantBNE_C_ERR();
  }
  
  public void setIdentifiantBNE(String pValeur)
  {
    m_fluxETTInfra.setIdentifiantBNE(pValeur);
  }
  
  public void setCodeErreurIdentifiantBNE(String pCodeErreur)
  {
    m_fluxETTInfra.setIdentifiantBNE_C_ERR(pCodeErreur);
  }
  
  public String getSiret()
  {
    return m_fluxETTInfra.getSiret();
  }
  
  public String getCodeErreurSiret()
  {
    return m_fluxETTInfra.getSiret_C_ERR();
  }
  
  public void setSiret(String pValeur)
  {
    m_fluxETTInfra.setSiret(pValeur);
  }
  
  public void setCodeErreurSiret(String pCodeErreur)
  {
    m_fluxETTInfra.setSiret_C_ERR(pCodeErreur);
  }
  
  public String getRaisonSociale()
  {
    return m_fluxETTInfra.getRaisonSociale();
  }
  
  public String getCodeErreurRaisonSociale()
  {
    return m_fluxETTInfra.getRaisonSociale_C_ERR();
  }
  
  public void setRaisonSociale(String pValeur)
  {
    m_fluxETTInfra.setRaisonSociale(pValeur);
  }
  
  public void setCodeErreurRaisonSociale(String pCodeErreur)
  {
    m_fluxETTInfra.setRaisonSociale_C_ERR(pCodeErreur);
  }
  
  public String getNumeroVoie()
  {
    return m_fluxETTInfra.getNumeroVoie();
  }
  
  public String getCodeErreurNumeroVoie()
  {
    return m_fluxETTInfra.getNumeroVoie_C_ERR();
  }
  
  public void setNumeroVoie(String pValeur)
  {
    m_fluxETTInfra.setNumeroVoie(pValeur);
  }
  
  public void setCodeErreurNumeroVoie(String pCodeErreur)
  {
    m_fluxETTInfra.setNumeroVoie_C_ERR(pCodeErreur);
  }
  
  public String getLibelleVoie()
  {
    return m_fluxETTInfra.getLibelleVoie();
  }
  
  public String getCodeErreurLibelleVoie()
  {
    return m_fluxETTInfra.getLibelleVoie_C_ERR();
  }
  
  public void setLibelleVoie(String pValeur)
  {
    m_fluxETTInfra.setLibelleVoie(pValeur);
  }
  
  public void setCodeErreurLibelleVoie(String pCodeErreur)
  {
    m_fluxETTInfra.setLibelleVoie_C_ERR(pCodeErreur);
  }
  
  public String getComplementAdresse()
  {
    return m_fluxETTInfra.getComplementAdresse();
  }
  
  public String getCodeErreurComplementAdresse()
  {
    return m_fluxETTInfra.getComplementAdresse_C_ERR();
  }
  
  public void setComplementAdresse(String pValeur)
  {
    m_fluxETTInfra.setComplementAdresse(pValeur);
  }
  
  public void setCodeErreurComplementAdresse(String pCodeErreur)
  {
    m_fluxETTInfra.setComplementAdresse_C_ERR(pCodeErreur);
  }
  
  public String getCodePostalETT()
  {
    return m_fluxETTInfra.getCodePostalETT();
  }
  
  public String getCodeErreurCodePostalETT()
  {
    return m_fluxETTInfra.getCodePostalETT_C_ERR();
  }
  
  public void setCodePostalETT(String pValeur)
  {
    m_fluxETTInfra.setCodePostalETT(pValeur);
  }
  
  public void setCodeErreurCodePostalETT(String pCodeErreur)
  {
    m_fluxETTInfra.setCodePostalETT_C_ERR(pCodeErreur);
  }
  
  public String getLibelleCommuneCNAVTS()
  {
    return m_fluxETTInfra.getLibelleCommuneCNAVTS();
  }
  
  public String getCodeErreurLibelleCommuneCNAVTS()
  {
    return m_fluxETTInfra.getLibelleCommuneCNAVTS_C_ERR();
  }
  
  public void setLibelleCommuneCNAVTS(String pValeur)
  {
    m_fluxETTInfra.setLibelleCommuneCNAVTS(pValeur);
  }
  
  public void setCodeErreurLibelleCommuneCNAVTS(String pCodeErreur)
  {
    m_fluxETTInfra.setLibelleCommuneCNAVTS_C_ERR(pCodeErreur);
  }
  
  public String getIndicateurRappelSalaire()
  {
    return m_fluxETTInfra.getIndicateurRappelSalaire();
  }
  
  public String getCodeErreurIndicateurRappelSalaire()
  {
    return m_fluxETTInfra.getIndicateurRappelSalaire_C_ERR();
  }
  
  public void setIndicateurRappelSalaire(String pValeur)
  {
    m_fluxETTInfra.setIndicateurRappelSalaire(pValeur);
  }
  
  public void setCodeErreurIndicateurRappelSalaire(String pCodeErreur)
  {
    m_fluxETTInfra.setIndicateurRappelSalaire_C_ERR(pCodeErreur);
  }
  
  public String getCodeMonnaie()
  {
    return m_fluxETTInfra.getCodeMonnaie();
  }
  
  public String getCodeErreurCodeMonnaie()
  {
    return m_fluxETTInfra.getCodeMonnaie_C_ERR();
  }
  
  public void setCodeMonnaie(String pValeur)
  {
    m_fluxETTInfra.setCodeMonnaie(pValeur);
  }
  
  public void setCodeErreurCodeMonnaie(String pCodeErreur)
  {
    m_fluxETTInfra.setCodeMonnaie_C_ERR(pCodeErreur);
  }
  
  public String getMotifFinContrat()
  {
    return m_fluxETTInfra.getMotifFinContrat();
  }
  
  public String getCodeErreurMotifFinContrat()
  {
    return m_fluxETTInfra.getMotifFinContrat_C_ERR();
  }
  
  public void setMotifFinContrat(String pValeur)
  {
    m_fluxETTInfra.setMotifFinContrat(pValeur);
  }
  
  public void setCodeErreurMotifFinContrat(String pCodeErreur)
  {
    m_fluxETTInfra.setMotifFinContrat_C_ERR(pCodeErreur);
  }
  
  public String getNumeroContrat()
  {
    return m_fluxETTInfra.getNumeroContrat();
  }
  
  public String getCodeErreurNumeroContrat()
  {
    return m_fluxETTInfra.getNumeroContrat_C_ERR();
  }
  
  public void setNumeroContrat(String pValeur)
  {
    m_fluxETTInfra.setNumeroContrat(pValeur);
  }
  
  public void setCodeErreurNumeroContrat(String pCodeErreur)
  {
    m_fluxETTInfra.setNumeroContrat_C_ERR(pCodeErreur);
  }
  
  public String getCaisseAgirc()
  {
    return m_fluxETTInfra.getCaisseAgirc();
  }
  
  public String getCodeErreurCaisseAgirc()
  {
    return m_fluxETTInfra.getCaisseAgirc_C_ERR();
  }
  
  public void setCaisseAgirc(String pValeur)
  {
    m_fluxETTInfra.setCaisseAgirc(pValeur);
  }
  
  public void setCodeErreurCaisseAgirc(String pCodeErreur)
  {
    m_fluxETTInfra.setCaisseAgirc_C_ERR(pCodeErreur);
  }
  
  public String getCaisseArrco()
  {
    return m_fluxETTInfra.getCaisseArrco();
  }
  
  public String getCodeErreurCaisseArrco()
  {
    return m_fluxETTInfra.getCaisseArrco_C_ERR();
  }
  
  public void setCaisseArrco(String pValeur)
  {
    m_fluxETTInfra.setCaisseArrco(pValeur);
  }
  
  public void setCodeErreurCaisseArrco(String pCodeErreur)
  {
    m_fluxETTInfra.setCaisseArrco_C_ERR(pCodeErreur);
  }
  
  public String getCadre()
  {
    return m_fluxETTInfra.getCadre();
  }
  
  public String getCodeErreurCadre()
  {
    return m_fluxETTInfra.getCadre_C_ERR();
  }
  
  public void setCadre(String pValeur)
  {
    m_fluxETTInfra.setCadre(pValeur);
  }
  
  public void setCodeErreurCadre(String pCodeErreur)
  {
    m_fluxETTInfra.setCadre_C_ERR(pCodeErreur);
  }
  
  public String getDernierEmploiTenu()
  {
    return m_fluxETTInfra.getDernierEmploiTenu();
  }
  
  public String getCodeErreurDernierEmploiTenu()
  {
    return m_fluxETTInfra.getDernierEmploiTenu_C_ERR();
  }
  
  public void setDernierEmploiTenu(String pValeur)
  {
    m_fluxETTInfra.setDernierEmploiTenu(pValeur);
  }
  
  public void setCodeErreurDernierEmploiTenu(String pCodeErreur)
  {
    m_fluxETTInfra.setDernierEmploiTenu_C_ERR(pCodeErreur);
  }
  
  public String getNiveauQualification()
  {
    return m_fluxETTInfra.getNiveauQualification();
  }
  
  public String getCodeErreurNiveauQualification()
  {
    return m_fluxETTInfra.getNiveauQualification_C_ERR();
  }
  
  public void setNiveauQualification(String pValeur)
  {
    m_fluxETTInfra.setNiveauQualification(pValeur);
  }
  
  public void setCodeErreurNiveauQualification(String pCodeErreur)
  {
    m_fluxETTInfra.setNiveauQualification_C_ERR(pCodeErreur);
  }
  
  public String getIndicateurQualiteNIR()
  {
    return m_fluxETTInfra.getIndicateurQualiteNIR();
  }
  
  public String getCodeErreurIndicateurQualiteNIR()
  {
    return m_fluxETTInfra.getIndicateurQualiteNIR_C_ERR();
  }
  
  public void setIndicateurQualiteNIR(String pValeur)
  {
    m_fluxETTInfra.setIndicateurQualiteNIR(pValeur);
  }
  
  public void setCodeErreurIndicateurQualiteNIR(String pCodeErreur)
  {
    m_fluxETTInfra.setIndicateurQualiteNIR_C_ERR(pCodeErreur);
  }
  
  public String getLieuMission()
  {
    return m_fluxETTInfra.getLieuMission();
  }
  
  public String getCodeErreurLieuMission()
  {
    return m_fluxETTInfra.getLieuMission_C_ERR();
  }
  
  public void setLieuMission(String pValeur)
  {
    m_fluxETTInfra.setLieuMission(pValeur);
  }
  
  public void setCodeErreurLieuMission(String pCodeErreur)
  {
    m_fluxETTInfra.setLieuMission_C_ERR(pCodeErreur);
  }
  
  public String getFiller()
  {
    return m_fluxETTInfra.getFiller();
  }
  
  public String getCodeErreurFiller()
  {
    return m_fluxETTInfra.getFiller_C_ERR();
  }
  
  public void setFiller(String pValeur)
  {
    m_fluxETTInfra.setFiller(pValeur);
  }
  
  public void setCodeErreurFiller(String pCodeErreur)
  {
    m_fluxETTInfra.setFiller_C_ERR(pCodeErreur);
  }
  
  public String getBneSiret()
  {
    return m_fluxETTInfra.getBneSiret();
  }
  
  public String getCodeErreurBneSiret()
  {
    return m_fluxETTInfra.getBneSiret_C_ERR();
  }
  
  public void setBneSiret(String pValeur)
  {
    m_fluxETTInfra.setBneSiret(pValeur);
  }
  
  public void setCodeErreurBneSiret(String pCodeErreur)
  {
    m_fluxETTInfra.setBneSiret_C_ERR(pCodeErreur);
  }
  
  public String getBneRaisonSociale()
  {
    return m_fluxETTInfra.getBneRaisonSociale();
  }
  
  public String getCodeErreurBneRaisonSociale()
  {
    return m_fluxETTInfra.getBneRaisonSociale_C_ERR();
  }
  
  public void setBneRaisonSociale(String pValeur)
  {
    m_fluxETTInfra.setBneRaisonSociale(pValeur);
  }
  
  public void setCodeErreurBneRaisonSociale(String pCodeErreur)
  {
    m_fluxETTInfra.setBneRaisonSociale_C_ERR(pCodeErreur);
  }
  
  public String getBneNumeroVoirie()
  {
    return m_fluxETTInfra.getBneNumeroVoirie();
  }
  
  public String getCodeErreurBneNumeroVoirie()
  {
    return m_fluxETTInfra.getBneNumeroVoirie_C_ERR();
  }
  
  public void setBneNumeroVoirie(String pValeur)
  {
    m_fluxETTInfra.setBneNumeroVoirie(pValeur);
  }
  
  public void setCodeErreurBneNumeroVoirie(String pCodeErreur)
  {
    m_fluxETTInfra.setBneNumeroVoirie_C_ERR(pCodeErreur);
  }
  
  public String getBneLibelleVoieAdresse()
  {
    return m_fluxETTInfra.getBneLibelleVoieAdresse();
  }
  
  public String getCodeErreurBneLibelleVoieAdresse()
  {
    return m_fluxETTInfra.getBneLibelleVoieAdresse_C_ERR();
  }
  
  public void setBneLibelleVoieAdresse(String pValeur)
  {
    m_fluxETTInfra.setBneLibelleVoieAdresse(pValeur);
  }
  
  public void setCodeErreurBneLibelleVoieAdresse(String pCodeErreur)
  {
    m_fluxETTInfra.setBneLibelleVoieAdresse_C_ERR(pCodeErreur);
  }
  
  public String getBneComplAdresse()
  {
    return m_fluxETTInfra.getBneComplAdresse();
  }
  
  public String getCodeErreurBneComplAdresse()
  {
    return m_fluxETTInfra.getBneComplAdresse_C_ERR();
  }
  
  public void setBneComplAdresse(String pValeur)
  {
    m_fluxETTInfra.setBneComplAdresse(pValeur);
  }
  
  public void setCodeErreurBneComplAdresse(String pCodeErreur)
  {
    m_fluxETTInfra.setBneComplAdresse_C_ERR(pCodeErreur);
  }
  
  public String getBneCodePostal()
  {
    return m_fluxETTInfra.getBneCodePostal();
  }
  
  public String getCodeErreurBneCodePostal()
  {
    return m_fluxETTInfra.getBneCodePostal_C_ERR();
  }
  
  public void setBneCodePostal(String pValeur)
  {
    m_fluxETTInfra.setBneCodePostal(pValeur);
  }
  
  public void setCodeErreurBneCodePostal(String pCodeErreur)
  {
    m_fluxETTInfra.setBneCodePostal_C_ERR(pCodeErreur);
  }
  
  public String getBneLibelleCommune()
  {
    return m_fluxETTInfra.getBneLibelleCommune();
  }
  
  public String getCodeErreurBneLibelleCommune()
  {
    return m_fluxETTInfra.getBneLibelleCommune_C_ERR();
  }
  
  public void setBneLibelleCommune(String pValeur)
  {
    m_fluxETTInfra.setBneLibelleCommune(pValeur);
  }
  
  public void setCodeErreurBneLibelleCommune(String pCodeErreur)
  {
    m_fluxETTInfra.setBneLibelleCommune_C_ERR(pCodeErreur);
  }
  
  public String getBneAssedicAffiliation()
  {
    return m_fluxETTInfra.getBneAssedicAffiliation();
  }
  
  public String getCodeErreurBneAssedicAffiliation()
  {
    return m_fluxETTInfra.getBneAssedicAffiliation_C_ERR();
  }
  
  public void setBneAssedicAffiliation(String pValeur)
  {
    m_fluxETTInfra.setBneAssedicAffiliation(pValeur);
  }
  
  public void setCodeErreurBneAssedicAffiliation(String pCodeErreur)
  {
    m_fluxETTInfra.setBneAssedicAffiliation_C_ERR(pCodeErreur);
  }
  
  public String getBneNumAffiliation()
  {
    return m_fluxETTInfra.getBneNumAffiliation();
  }
  
  public String getCodeErreurBneNumAffiliation()
  {
    return m_fluxETTInfra.getBneNumAffiliation_C_ERR();
  }
  
  public void setBneNumAffiliation(String pValeur)
  {
    m_fluxETTInfra.setBneNumAffiliation(pValeur);
  }
  
  public void setCodeErreurBneNumAffiliation(String pCodeErreur)
  {
    m_fluxETTInfra.setBneNumAffiliation_C_ERR(pCodeErreur);
  }
  
  public String getBneRetraiteAgirc1()
  {
    return m_fluxETTInfra.getBneRetraiteAgirc1();
  }
  
  public String getCodeErreurBneRetraiteAgirc1()
  {
    return m_fluxETTInfra.getBneRetraiteAgirc1_C_ERR();
  }
  
  public void setBneRetraiteAgirc1(String pValeur)
  {
    m_fluxETTInfra.setBneRetraiteAgirc1(pValeur);
  }
  
  public void setCodeErreurBneRetraiteAgirc1(String pCodeErreur)
  {
    m_fluxETTInfra.setBneRetraiteAgirc1_C_ERR(pCodeErreur);
  }
  
  public String getBneRetraiteAgirc2()
  {
    return m_fluxETTInfra.getBneRetraiteAgirc2();
  }
  
  public String getCodeErreurBneRetraiteAgirc2()
  {
    return m_fluxETTInfra.getBneRetraiteAgirc2_C_ERR();
  }
  
  public void setBneRetraiteAgirc2(String pValeur)
  {
    m_fluxETTInfra.setBneRetraiteAgirc2(pValeur);
  }
  
  public void setCodeErreurBneRetraiteAgirc2(String pCodeErreur)
  {
    m_fluxETTInfra.setBneRetraiteAgirc2_C_ERR(pCodeErreur);
  }
  
  public String getBneLibelleRetraiteAgirc1()
  {
    return m_fluxETTInfra.getBneLibelleRetraiteAgirc1();
  }
  
  public String getCodeErreurBneLibelleRetraiteAgirc1()
  {
    return m_fluxETTInfra.getBneLibelleRetraiteAgirc1_C_ERR();
  }
  
  public void setBneLibelleRetraiteAgirc1(String pValeur)
  {
    m_fluxETTInfra.setBneLibelleRetraiteAgirc1(pValeur);
  }
  
  public void setCodeErreurBneLibelleRetraiteAgirc1(String pCodeErreur)
  {
    m_fluxETTInfra.setBneLibelleRetraiteAgirc1_C_ERR(pCodeErreur);
  }
  
  public String getBneLibelleRetraiteAgirc2()
  {
    return m_fluxETTInfra.getBneLibelleRetraiteAgirc2();
  }
  
  public String getCodeErreurBneLibelleRetraiteAgirc2()
  {
    return m_fluxETTInfra.getBneLibelleRetraiteAgirc2_C_ERR();
  }
  
  public void setBneLibelleRetraiteAgirc2(String pValeur)
  {
    m_fluxETTInfra.setBneLibelleRetraiteAgirc2(pValeur);
  }
  
  public void setCodeErreurBneLibelleRetraiteAgirc2(String pCodeErreur)
  {
    m_fluxETTInfra.setBneLibelleRetraiteAgirc2_C_ERR(pCodeErreur);
  }
  
  public String getBneIdentifiantBne()
  {
    return m_fluxETTInfra.getBneIdentifiantBne();
  }
  
  public String getCodeErreurBneIdentifiantBne()
  {
    return m_fluxETTInfra.getBneIdentifiantBne_C_ERR();
  }
  
  public void setBneIdentifiantBne(String pValeur)
  {
    m_fluxETTInfra.setBneIdentifiantBne(pValeur);
  }
  
  public void setCodeErreurBneIdentifiantBne(String pCodeErreur)
  {
    m_fluxETTInfra.setBneIdentifiantBne_C_ERR(pCodeErreur);
  }
  
  public String getIndicateurMontantIccp()
  {
    return m_fluxETTInfra.getIndicateurMontantIccp();
  }
  
  public String getCodeErreurIndicateurMontantIccp()
  {
    return m_fluxETTInfra.getIndicateurMontantIccp_C_ERR();
  }
  
  public void setIndicateurMontantIccp(String pValeur)
  {
    m_fluxETTInfra.setIndicateurMontantIccp(pValeur);
  }
  
  public void setCodeErreurIndicateurMontantIccp(String pCodeErreur)
  {
    m_fluxETTInfra.setIndicateurMontantIccp_C_ERR(pCodeErreur);
  }
  
  public String getIndicateurMotifFinContrat()
  {
    return m_fluxETTInfra.getIndicateurMotifFinContrat();
  }
  
  public String getCodeErreurIndicateurMotifFinContrat()
  {
    return m_fluxETTInfra.getIndicateurMotifFinContrat_C_ERR();
  }
  
  public void setIndicateurMotifFinContrat(String pValeur)
  {
    m_fluxETTInfra.setIndicateurMotifFinContrat(pValeur);
  }
  
  public void setCodeErreurIndicateurMotifFinContrat(String pCodeErreur)
  {
    m_fluxETTInfra.setIndicateurMotifFinContrat_C_ERR(pCodeErreur);
  }
  
  public String getIndicateurNombreHeuresMision()
  {
    return m_fluxETTInfra.getIndicateurNombreHeuresMision();
  }
  
  public String getCodeErreurIndicateurNombreHeuresMision()
  {
    return m_fluxETTInfra.getIndicateurNombreHeuresMision_C_ERR();
  }
  
  public void setIndicateurNombreHeuresMision(String pValeur)
  {
    m_fluxETTInfra.setIndicateurNombreHeuresMision(pValeur);
  }
  
  public void setCodeErreurIndicateurNombreHeuresMision(String pCodeErreur)
  {
    m_fluxETTInfra.setIndicateurNombreHeuresMision_C_ERR(pCodeErreur);
  }
  
  public String getIndicateurMontantIfm()
  {
    return m_fluxETTInfra.getIndicateurMontantIfm();
  }
  
  public String getCodeErreurIndicateurMontantIfm()
  {
    return m_fluxETTInfra.getIndicateurMontantIfm_C_ERR();
  }
  
  public void setIndicateurMontantIfm(String pValeur)
  {
    m_fluxETTInfra.setIndicateurMontantIfm(pValeur);
  }
  
  public void setCodeErreurIndicateurMontantIfm(String pCodeErreur)
  {
    m_fluxETTInfra.setIndicateurMontantIfm_C_ERR(pCodeErreur);
  }
  
  public String getIndicateurRappelMission()
  {
    return m_fluxETTInfra.getIndicateurRappelMission();
  }
  
  public String getCodeErreurIndicateurRappelMission()
  {
    return m_fluxETTInfra.getIndicateurRappelMission_C_ERR();
  }
  
  public void setIndicateurRappelMission(String pValeur)
  {
    m_fluxETTInfra.setIndicateurRappelMission(pValeur);
  }
  
  public void setCodeErreurIndicateurRappelMission(String pCodeErreur)
  {
    m_fluxETTInfra.setIndicateurRappelMission_C_ERR(pCodeErreur);
  }
  
  public String getIndicateurNouveauProtocole()
  {
    return m_fluxETTInfra.getIndicateurNouveauProtocole();
  }
  
  public String getCodeErreurIndicateurNouveauProtocole()
  {
    return m_fluxETTInfra.getIndicateurNouveauProtocole_C_ERR();
  }
  
  public void setIndicateurNouveauProtocole(String pValeur)
  {
    m_fluxETTInfra.setIndicateurNouveauProtocole(pValeur);
  }
  
  public void setCodeErreurIndicateurNouveauProtocole(String pCodeErreur)
  {
    m_fluxETTInfra.setIndicateurNouveauProtocole_C_ERR(pCodeErreur);
  }
  
  public Damj getDateNaissance()
  {
    return m_fluxETTInfra.getDateNaissance();
  }
  
  public String getCodeErreurDateNaissance()
  {
    return m_fluxETTInfra.getDateNaissance_C_ERR();
  }
  
  public void setDateNaissance(Damj pValeur)
  {
    m_fluxETTInfra.setDateNaissance(pValeur);
  }
  
  public void setCodeErreurDateNaissance(String pCodeErreur)
  {
    m_fluxETTInfra.setDateNaissance_C_ERR(pCodeErreur);
  }
  
  public Damj getDateDebutPeriode()
  {
    return m_fluxETTInfra.getDateDebutPeriode();
  }
  
  public String getCodeErreurDateDebutPeriode()
  {
    return m_fluxETTInfra.getDateDebutPeriode_C_ERR();
  }
  
  public void setDateDebutPeriode(Damj pValeur)
  {
    m_fluxETTInfra.setDateDebutPeriode(pValeur);
  }
  
  public void setCodeErreurDateDebutPeriode(String pCodeErreur)
  {
    m_fluxETTInfra.setDateDebutPeriode_C_ERR(pCodeErreur);
  }
  
  public Damj getDateFinPeriode()
  {
    return m_fluxETTInfra.getDateFinPeriode();
  }
  
  public String getCodeErreurDateFinPeriode()
  {
    return m_fluxETTInfra.getDateFinPeriode_C_ERR();
  }
  
  public void setDateFinPeriode(Damj pValeur)
  {
    m_fluxETTInfra.setDateFinPeriode(pValeur);
  }
  
  public void setCodeErreurDateFinPeriode(String pCodeErreur)
  {
    m_fluxETTInfra.setDateFinPeriode_C_ERR(pCodeErreur);
  }
  
  public Damj getDateFichierExterne()
  {
    return m_fluxETTInfra.getDateFichierExterne();
  }
  
  public String getCodeErreurDateFichierExterne()
  {
    return m_fluxETTInfra.getDateFichierExterne_C_ERR();
  }
  
  public void setDateFichierExterne(Damj pValeur)
  {
    m_fluxETTInfra.setDateFichierExterne(pValeur);
  }
  
  public void setCodeErreurDateFichierExterne(String pCodeErreur)
  {
    m_fluxETTInfra.setDateFichierExterne_C_ERR(pCodeErreur);
  }
  
  public Damj getDateTraitement()
  {
    return m_fluxETTInfra.getDateTraitement();
  }
  
  public String getCodeErreurDateTraitement()
  {
    return m_fluxETTInfra.getDateTraitement_C_ERR();
  }
  
  public void setDateTraitement(Damj pValeur)
  {
    m_fluxETTInfra.setDateTraitement(pValeur);
  }
  
  public void setCodeErreurDateTraitement(String pCodeErreur)
  {
    m_fluxETTInfra.setDateTraitement_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getSieclePeriodeRef()
  {
    return m_fluxETTInfra.getSieclePeriodeRef();
  }
  
  public String getCodeErreurSieclePeriodeRef()
  {
    return m_fluxETTInfra.getSieclePeriodeRef_C_ERR();
  }
  
  public void setSieclePeriodeRef(BigDecimal pValeur)
  {
    m_fluxETTInfra.setSieclePeriodeRef(pValeur);
  }
  
  public void setCodeErreurSieclePeriodeRef(String pCodeErreur)
  {
    m_fluxETTInfra.setSieclePeriodeRef_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getMoisPeriodeRef()
  {
    return m_fluxETTInfra.getMoisPeriodeRef();
  }
  
  public String getCodeErreurMoisPeriodeRef()
  {
    return m_fluxETTInfra.getMoisPeriodeRef_C_ERR();
  }
  
  public void setMoisPeriodeRef(BigDecimal pValeur)
  {
    m_fluxETTInfra.setMoisPeriodeRef(pValeur);
  }
  
  public void setCodeErreurMoisPeriodeRef(String pCodeErreur)
  {
    m_fluxETTInfra.setMoisPeriodeRef_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getSalaireBrut()
  {
    return m_fluxETTInfra.getSalaireBrut();
  }
  
  public String getCodeErreurSalaireBrut()
  {
    return m_fluxETTInfra.getSalaireBrut_C_ERR();
  }
  
  public void setSalaireBrut(BigDecimal pValeur)
  {
    m_fluxETTInfra.setSalaireBrut(pValeur);
  }
  
  public void setCodeErreurSalaireBrut(String pCodeErreur)
  {
    m_fluxETTInfra.setSalaireBrut_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getMontantIccp()
  {
    return m_fluxETTInfra.getMontantIccp();
  }
  
  public String getCodeErreurMontantIccp()
  {
    return m_fluxETTInfra.getMontantIccp_C_ERR();
  }
  
  public void setMontantIccp(BigDecimal pValeur)
  {
    m_fluxETTInfra.setMontantIccp(pValeur);
  }
  
  public void setCodeErreurMontantIccp(String pCodeErreur)
  {
    m_fluxETTInfra.setMontantIccp_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getNombreHeuresMission()
  {
    return m_fluxETTInfra.getNombreHeuresMission();
  }
  
  public String getCodeErreurNombreHeuresMission()
  {
    return m_fluxETTInfra.getNombreHeuresMission_C_ERR();
  }
  
  public void setNombreHeuresMission(BigDecimal pValeur)
  {
    m_fluxETTInfra.setNombreHeuresMission(pValeur);
  }
  
  public void setCodeErreurNombreHeuresMission(String pCodeErreur)
  {
    m_fluxETTInfra.setNombreHeuresMission_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getMontantIfm()
  {
    return m_fluxETTInfra.getMontantIfm();
  }
  
  public String getCodeErreurMontantIfm()
  {
    return m_fluxETTInfra.getMontantIfm_C_ERR();
  }
  
  public void setMontantIfm(BigDecimal pValeur)
  {
    m_fluxETTInfra.setMontantIfm(pValeur);
  }
  
  public void setCodeErreurMontantIfm(String pCodeErreur)
  {
    m_fluxETTInfra.setMontantIfm_C_ERR(pCodeErreur);
  }
  
  public _FluxETT getFluxETTInfra()
  {
    return m_fluxETTInfra;
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
 * Qualified Name:     _FluxETTImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */