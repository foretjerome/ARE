package fr.pe.cali.reglementaire.regles.assurance.cep.reglementapplicable.outils.impl;

import fr.pe.cali.reglementaire.dom.impl.CriteresFabriqueReglementaire;
import fr.pe.cali.reglementaire.outils.spec.IOutilCorpsRegle;
import fr.pe.cali.reglementaire.regles.assurance.cep.reglementapplicable.dom.DonneesEntreesRegleReglementApplicable;
import fr.pe.cali.reglementaire.regles.assurance.cep.reglementapplicable.dom.ResultatRegleReglementApplicable;
import fr.pe.cali.reglementaire.regles.assurance.cep.reglementapplicable.outils.spec.IOutilCorpsRegleReglementApplicable;
import fr.unedic.archi.logique.exception.ApplicativeException;
import java.util.List;

public class OutilReglementApplicableClassique
  implements IOutilCorpsRegleReglementApplicable
{
  private static final String NOM_OUTIL = "OutilReglementApplicableClassique";
  private static OutilReglementApplicableClassique instance = new OutilReglementApplicableClassique();
  
  public boolean estApplicablePourCriteres(CriteresFabriqueReglementaire criteres)
  {
    return (criteres.getListeContextesReglementaires() == null) || (!criteres.getListeContextesReglementaires().contains("ReglementApplicableContexteAspSousJacent"));
  }
  
  public IOutilCorpsRegle creerNouvelleInstance()
  {
    return new OutilReglementApplicableClassique();
  }
  
  public String getNomOutil()
  {
    return "OutilReglementApplicableClassique";
  }
  
  public static OutilReglementApplicableClassique getInstance()
  {
    return instance;
  }
  
  public ResultatRegleReglementApplicable determinerReglementApplicable(DonneesEntreesRegleReglementApplicable donneesEntrees)
    throws ApplicativeException
  {
    ResultatRegleReglementApplicable resultat = new ResultatRegleReglementApplicable();
    resultat.setReglementApplicable(donneesEntrees.getReglementValidationProduit());
    return resultat;
  }
}

/* Location:
 * Qualified Name:     OutilReglementApplicableClassique
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */