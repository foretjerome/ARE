package fr.unedic.cali.autresdoms.d90.dom.comportement;

import fr.unedic.cali.autresdoms.d90.dom.spec.ComportementSpec;

public class ComportementTPRestitutionSimu
  extends ComportementTPDefaut
{
  public static final String IDENTIFIANT = "comportementTPRestitutionSimu";
  private String identifiant = "comportementTPRestitutionSimu";
  private String libelle = "Comportement TP Restitution Simu";
  
  public ComportementTPRestitutionSimu()
  {
    identifiantComportement = identifiant;
    applicationSurPremiereDecision = false;
    libelleComportement = libelle;
    ecrireEnBaseVisu = true;
  }
  
  public ComportementSpec getComportementSansReexamenAuto()
  {
    return this;
  }
}

/* Location:
 * Qualified Name:     ComportementTPRestitutionSimu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */