package fr.pe.cali.reglementaire.decors.changements;

import fr.pe.cali.reglementaire.dom.impl.CriteresFabriqueReglementaire;
import fr.pe.cali.reglementaire.outils.logs.OutilLog;
import fr.pe.cali.reglementaire.outils.spec.IOutilCorpsRegle;
import fr.unedic.util.services.ApplicativeRuntimeException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.HashMap;
import java.util.Map;

public abstract class Changement
{
  private static final String NOM_ELEMENT = "Changement";
  private String libelle;
  private Periode periodeApplication;
  private Map<String, ChangementCorpsRegle> collectionChangementsCorpsRegles;
  
  public IOutilCorpsRegle recupererOutilReglementaire(String nomCorpsRegle, CriteresFabriqueReglementaire criteres)
  {
    ChangementCorpsRegle changementCorpsRegle = recupererChangementCorpsRegle(nomCorpsRegle);
    return changementCorpsRegle.recupererOutilReglementaire(criteres);
  }
  
  public boolean estChangementApplicable(Damj dateApplication)
  {
    boolean applicable = false;
    if (dateApplication != null) {
      applicable = dateApplication.estContenueDans(getPeriodeApplication());
    }
    return applicable;
  }
  
  protected ChangementCorpsRegle recupererChangementCorpsRegle(String nomCorpsRegle)
  {
    if (collectionChangementsCorpsRegles == null) {
      leverExceptionChangementNonInitialise();
    }
    ChangementCorpsRegle resultat = (ChangementCorpsRegle)collectionChangementsCorpsRegles.get(nomCorpsRegle);
    if (resultat == null) {
      leverExeptionAucunChangementCorpsDeRegleTrouve();
    }
    return resultat;
  }
  
  public String toString()
  {
    return OutilLog.formaterElement("Changement", getPeriodeApplication().formater());
  }
  
  protected String getLibelle()
  {
    return libelle;
  }
  
  protected void setLibelle(String libelle)
  {
    this.libelle = libelle;
  }
  
  public Periode getPeriodeApplication()
  {
    return periodeApplication;
  }
  
  protected void setPeriodeApplication(Periode periodeApplication)
  {
    this.periodeApplication = periodeApplication;
  }
  
  protected void initialiserCollectionChangementsCorpsRegle()
  {
    collectionChangementsCorpsRegles = new HashMap();
  }
  
  protected void ajouterChangementCorpsRegle(String nomCorpsRegle, ChangementCorpsRegle changementCorpsRegle)
  {
    collectionChangementsCorpsRegles.put(nomCorpsRegle, changementCorpsRegle);
  }
  
  private void leverExeptionAucunChangementCorpsDeRegleTrouve()
  {
    throw new ApplicativeRuntimeException("");
  }
  
  private void leverExceptionChangementNonInitialise()
  {
    throw new ApplicativeRuntimeException("");
  }
}

/* Location:
 * Qualified Name:     Changement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */