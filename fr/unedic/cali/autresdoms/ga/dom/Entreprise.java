package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.util.temps.Damj;

public class Entreprise
{
  private static final int LIBELLE_ENTREPRISE = 40;
  private String libelleEntreprise;
  private String numeroAffiliation;
  private String codeNAF;
  private String siren;
  private String codePostalEntreprise;
  private String numeroConventionGestion;
  private String identifiantBNE;
  private String urssaf;
  private String numeroGuso;
  private Damj dateEntreeCTP;
  private int codeBassinCTP;
  private String effectif;
  private boolean estEmployeurAdherantATitreIrrevocable;
  private boolean estSecteurPublic;
  private boolean certificationSocialeEntreprise;
  
  public String getEffectif()
  {
    return effectif;
  }
  
  public void setEffectif(String pEffectif)
  {
    effectif = pEffectif;
  }
  
  public String getLibelleEntreprise()
  {
    return libelleEntreprise;
  }
  
  public void setLibelleEntreprise(String pLibelle)
  {
    if ((pLibelle != null) && (pLibelle.length() > 40)) {
      libelleEntreprise = pLibelle.substring(0, 40);
    } else {
      libelleEntreprise = pLibelle;
    }
  }
  
  public String getNumeroAffiliation()
  {
    return numeroAffiliation;
  }
  
  public void setNumeroAffiliation(String pNumeroAffiliation)
  {
    numeroAffiliation = pNumeroAffiliation;
  }
  
  public String getSiren()
  {
    return siren;
  }
  
  public void setSiren(String pSiren)
  {
    siren = pSiren;
  }
  
  public String getCodePostalEntreprise()
  {
    return codePostalEntreprise;
  }
  
  public String setCodePostalEntreprise(String pCodePostalEntreprise)
  {
    return codePostalEntreprise = pCodePostalEntreprise;
  }
  
  public String getIdentifiantBNE()
  {
    return identifiantBNE;
  }
  
  public void setIdentifiantBNE(String pIdentifiantBNE)
  {
    identifiantBNE = pIdentifiantBNE;
  }
  
  public String getNumeroConventionGestion()
  {
    return numeroConventionGestion;
  }
  
  public void setNumeroConventionGestion(String pNumeroConventionGestion)
  {
    numeroConventionGestion = pNumeroConventionGestion;
  }
  
  public String getCodeNAF()
  {
    return codeNAF;
  }
  
  public void setCodeNAF(String pCodeNAF)
  {
    codeNAF = pCodeNAF;
  }
  
  public String getUrssaf()
  {
    return urssaf;
  }
  
  public void setUrssaf(String pUrssaf)
  {
    urssaf = pUrssaf;
  }
  
  public String getNumeroGuso()
  {
    return numeroGuso;
  }
  
  public void setNumeroGuso(String pNumeroGuso)
  {
    numeroGuso = pNumeroGuso;
  }
  
  public int getCodeBassinCTP()
  {
    return codeBassinCTP;
  }
  
  public void setCodeBassinCTP(int pCodeBassinCTP)
  {
    codeBassinCTP = pCodeBassinCTP;
  }
  
  public Damj getDateEntreeCTP()
  {
    return dateEntreeCTP;
  }
  
  public void setDateEntreeCTP(Damj pDateEntreeCTP)
  {
    dateEntreeCTP = pDateEntreeCTP;
  }
  
  public boolean isEstEmployeurAdherantATitreIrrevocable()
  {
    return estEmployeurAdherantATitreIrrevocable;
  }
  
  public void setEstEmployeurAdherantATitreIrrevocable(boolean pEstEmployeurAdherantATitreIrrevocable)
  {
    estEmployeurAdherantATitreIrrevocable = pEstEmployeurAdherantATitreIrrevocable;
  }
  
  public boolean isEstSecteurPublic()
  {
    return estSecteurPublic;
  }
  
  public void setEstSecteurPublic(boolean pEstSecteurPublic)
  {
    estSecteurPublic = pEstSecteurPublic;
  }
  
  public void setCertificationSocialeEntreprise(boolean certificationSocialeEntreprise)
  {
    this.certificationSocialeEntreprise = certificationSocialeEntreprise;
  }
  
  public boolean isCertificationSocialeEntreprise()
  {
    return certificationSocialeEntreprise;
  }
}

/* Location:
 * Qualified Name:     Entreprise
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */