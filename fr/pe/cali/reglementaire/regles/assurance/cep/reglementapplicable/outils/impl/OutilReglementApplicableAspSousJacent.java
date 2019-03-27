package fr.pe.cali.reglementaire.regles.assurance.cep.reglementapplicable.outils.impl;

import fr.pe.cali.reglementaire.dom.impl.CriteresFabriqueReglementaire;
import fr.pe.cali.reglementaire.outils.spec.IOutilCorpsRegle;
import fr.pe.cali.reglementaire.regles.assurance.cep.reglementapplicable.dom.DonneesEntreesRegleReglementApplicable;
import fr.pe.cali.reglementaire.regles.assurance.cep.reglementapplicable.dom.ResultatRegleReglementApplicable;
import fr.pe.cali.reglementaire.regles.assurance.cep.reglementapplicable.outils.spec.IOutilCorpsRegleReglementApplicable;
import fr.unedic.archi.logique.exception.ApplicativeException;
import java.util.List;

public class OutilReglementApplicableAspSousJacent
  implements IOutilCorpsRegleReglementApplicable
{
  private static final String NOM_OUTIL = "OutilReglementApplicableAspSousJacent";
  private static final OutilReglementApplicableAspSousJacent instance = new OutilReglementApplicableAspSousJacent();
  
  public boolean estApplicablePourCriteres(CriteresFabriqueReglementaire criteres)
  {
    return (criteres.getListeContextesReglementaires() != null) && (criteres.getListeContextesReglementaires().contains("ReglementApplicableContexteAspSousJacent"));
  }
  
  public IOutilCorpsRegle creerNouvelleInstance()
  {
    return new OutilReglementApplicableAspSousJacent();
  }
  
  public String getNomOutil()
  {
    return "OutilReglementApplicableAspSousJacent";
  }
  
  public static OutilReglementApplicableAspSousJacent getInstance()
  {
    return instance;
  }
  
  public ResultatRegleReglementApplicable determinerReglementApplicable(DonneesEntreesRegleReglementApplicable donneesEntrees)
    throws ApplicativeException
  {
    ResultatRegleReglementApplicable resultat = new ResultatRegleReglementApplicable();
    resultat.setReglementApplicable(donneesEntrees.getReglementDernierSinistre());
    return resultat;
  }
}

/* Location:
 * Qualified Name:     OutilReglementApplicableAspSousJacent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */