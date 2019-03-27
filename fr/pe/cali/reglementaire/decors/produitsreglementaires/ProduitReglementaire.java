package fr.pe.cali.reglementaire.decors.produitsreglementaires;

import fr.pe.cali.reglementaire.decors.changements.Changement;
import fr.pe.cali.reglementaire.dom.impl.CriteresFabriqueReglementaire;
import fr.pe.cali.reglementaire.outils.logs.OutilLog;
import fr.pe.cali.reglementaire.outils.spec.IOutilCorpsRegle;
import fr.unedic.util.services.ApplicativeRuntimeException;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriodeConcrete;
import fr.unedic.util.temps.Periode;
import fr.unedic.util.temps.Temporel;
import java.util.ArrayList;
import java.util.List;

public abstract class ProduitReglementaire
{
  private static final String NOM_ELEMENT = "ProduitReglementaire";
  private String codeProduit;
  private String libelleCourt;
  private String libelleLong;
  private Periode periodeApplication;
  private List<Changement> listeChangements;
  
  public IOutilCorpsRegle recupererOutilReglementaire(String nomCorpsRegle, CriteresFabriqueReglementaire criteres, StringBuffer traceLog)
  {
    Changement changement = trouverChangement(criteres.getDate());
    if (traceLog != null) {
      traceLog.append(changement.toString());
    }
    return changement.recupererOutilReglementaire(nomCorpsRegle, criteres);
  }
  
  protected Changement trouverChangement(Damj dateRecherche)
  {
    List<Changement> resultat = new ArrayList();
    for (Changement changementCourant : getListeChangements()) {
      if (changementCourant.estChangementApplicable(dateRecherche)) {
        resultat.add(changementCourant);
      }
    }
    if (resultat.isEmpty()) {
      if (getListeChangements().isEmpty()) {
        leverExceptionSiAucunChangementTrouve();
      } else {
        resultat.add(getListeChangements().get(getListeChangements().size() - 1));
      }
    }
    if (resultat.size() > 1) {
      leverExceptionSiPlusieursChangementsTrouves();
    }
    return (Changement)resultat.get(0);
  }
  
  public void verifierCoherenceListeChangement()
  {
    if (getListeChangements() == null) {
      leverExceptionListeChangementNonInitialise();
    }
    ChronologiePeriodes chronologiePeriodes = new ChronologiePeriodes();
    for (Changement changement : getListeChangements()) {
      chronologiePeriodes.ajouter(new ObjetChronoPeriodeConcrete(changement.getPeriodeApplication()));
    }
    if (chronologiePeriodes.contientChevauchementElements()) {
      leverExceptionChevauchementEntreChangements();
    }
    Damj dateFinChangementPrecedente = null;
    for (Changement changement : getListeChangements())
    {
      if ((dateFinChangementPrecedente != null) && (dateFinChangementPrecedente.estApres(changement.getPeriodeApplication().getDebut()))) {
        leverExceptionChangementsMalTries();
      }
      dateFinChangementPrecedente = changement.getPeriodeApplication().getFin();
    }
    boolean presenceTrous = (!chronologiePeriodes.premierElement().getDateDebut().coincideAvec(getPeriodeApplication().getDebut())) || (!chronologiePeriodes.dernierElement().getDateFin().coincideAvec(getPeriodeApplication().getFin()));
    
    chronologiePeriodes.iterer();
    
    Temporel periodePrecedente = null;
    while ((!presenceTrous) && (chronologiePeriodes.encoreSuivant()))
    {
      Temporel periodeCourante = chronologiePeriodes.elementSuivant();
      if (periodePrecedente != null)
      {
        if (!periodePrecedente.getDateFin().lendemain().coincideAvec(periodeCourante.getDateDebut())) {
          presenceTrous = true;
        }
      }
      else {
        periodePrecedente = periodeCourante;
      }
    }
    if (presenceTrous) {
      leverExceptionTrouEntreLesChangements();
    }
  }
  
  public String toString()
  {
    return OutilLog.formaterElement("ProduitReglementaire", getLibelleCourt());
  }
  
  protected String getLibelleCourt()
  {
    return libelleCourt;
  }
  
  protected String getLibelleLong()
  {
    return libelleLong;
  }
  
  protected Periode getPeriodeApplication()
  {
    return periodeApplication;
  }
  
  protected void setPeriodeApplication(Periode periodeApplication)
  {
    this.periodeApplication = periodeApplication;
  }
  
  protected void setLibelleCourt(String libelleCourt)
  {
    this.libelleCourt = libelleCourt;
  }
  
  protected void setLibelleLong(String libelleLong)
  {
    this.libelleLong = libelleLong;
  }
  
  protected void initialiserListeChangement()
  {
    listeChangements = new ArrayList();
  }
  
  protected void ajouterChangement(Changement changement)
  {
    listeChangements.add(changement);
  }
  
  private List<Changement> getListeChangements()
  {
    return listeChangements;
  }
  
  public String getCodeProduit()
  {
    return codeProduit;
  }
  
  protected void setCodeProduit(String codeProduit)
  {
    this.codeProduit = codeProduit;
  }
  
  private void leverExceptionSiAucunChangementTrouve()
  {
    throw new ApplicativeRuntimeException("");
  }
  
  private void leverExceptionSiPlusieursChangementsTrouves()
  {
    throw new ApplicativeRuntimeException("");
  }
  
  private void leverExceptionListeChangementNonInitialise()
  {
    throw new ApplicativeRuntimeException("");
  }
  
  private void leverExceptionChevauchementEntreChangements()
  {
    throw new ApplicativeRuntimeException("");
  }
  
  private void leverExceptionTrouEntreLesChangements()
  {
    throw new ApplicativeRuntimeException("");
  }
  
  private void leverExceptionChangementsMalTries()
  {
    throw new ApplicativeRuntimeException("");
  }
}

/* Location:
 * Qualified Name:     ProduitReglementaire
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */