package fr.unedic.cali.autresdoms.ga.mapping;

import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.fabriques.FabriqueStrategiePECCACIRMAetCUI;
import fr.unedic.cali.outilsfonctionnels.strategies.CritereStrategie;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategiePECCACIRMAetCUISpec;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.CategorieEmploi;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ListeEmploi;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ListeRegimeRetraite;
import java.math.BigDecimal;
import java.util.HashSet;

public class MapperMetier
{
  public static int convertirChampApplication(fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.Metier p_metierGa)
  {
    int codeChampApplication = CodeGa.valueOf(p_metierGa.getChampApplication());
    int champApplicationMappe = codeChampApplication;
    if (codeChampApplication == 10) {
      champApplicationMappe = 1;
    } else if (codeChampApplication == 11) {
      champApplicationMappe = 3;
    } else if (codeChampApplication == 12) {
      champApplicationMappe = 4;
    }
    return champApplicationMappe;
  }
  
  public static boolean estChampApplicationMayotte(fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.Metier p_metierGa)
  {
    boolean retour = false;
    String champApplication = p_metierGa.getChampApplication();
    int codeChampApplication = CodeGa.valueOf(champApplication);
    if ((codeChampApplication == 10) || (codeChampApplication == 11) || (codeChampApplication == 12)) {
      retour = true;
    }
    return retour;
  }
  
  static fr.unedic.cali.autresdoms.ga.dom.Metier mapper(fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.Metier p_metierGa)
  {
    fr.unedic.cali.autresdoms.ga.dom.Metier metierCali = new fr.unedic.cali.autresdoms.ga.dom.Metier();
    
    metierCali.setCategorieEmploiParticulier(CodeGa.valueOf(p_metierGa.getCodeCatEmploiParticulier()));
    
    metierCali.setContratTypeParticulier(CodeGa.valueOf(p_metierGa.getContratTypeParticulier()));
    if ((metierCali.getContratTypeParticulier() == 22) || (metierCali.getContratTypeParticulier() == 21))
    {
      CritereStrategie critereCACIRMA = new CritereStrategie();
      critereCACIRMA.setDatePivot(p_metierGa.getDateDebMetier());
      StrategiePECCACIRMAetCUISpec strategieCACIRMA = (StrategiePECCACIRMAetCUISpec)FabriqueStrategiePECCACIRMAetCUI.getInstance().getStrategie(critereCACIRMA);
      
      metierCali.setContratTypeParticulier(strategieCACIRMA.mapperTypeContratParticulier(metierCali.getContratTypeParticulier()));
    }
    String codeEmploi = p_metierGa.getCodeEmploiTenu();
    metierCali.setCodeEmploi(CodeGa.valueOf(codeEmploi));
    
    metierCali.setChampApplication(convertirChampApplication(p_metierGa));
    
    ListeRegimeRetraite listeRegimeRetraite = p_metierGa.getListeRegimeRetraite();
    if (listeRegimeRetraite != null)
    {
      int nbRegimeRetraite = listeRegimeRetraite.getNbListRegimeRetraite();
      for (int i = 0; i < nbRegimeRetraite; i++)
      {
        fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.RegimeRetraite regimeRetraiteGa = listeRegimeRetraite.getListeRegimeRetraite(i);
        fr.unedic.cali.autresdoms.ga.dom.RegimeRetraite regimeRetraiteCali = creerRegimeRetraite(regimeRetraiteGa);
        metierCali.ajouter(regimeRetraiteCali);
      }
      if (nbRegimeRetraite > 0)
      {
        String regimeSecu = listeRegimeRetraite.getListeRegimeRetraite(0).getLibelleCaisseRegimeSpecial();
        int codeRegimeSecu = 0;
        try
        {
          if ((regimeSecu != null) && (!regimeSecu.equals(""))) {
            codeRegimeSecu = Integer.valueOf(regimeSecu).intValue();
          }
        }
        catch (NumberFormatException e)
        {
          if (Log.isTraceActive(MapperContratTravail.class, Niveau.DEBUG)) {
            Log.ecritTrace(Niveau.DEBUG, MapperContratTravail.class, "creerMetier", "pb mapping régime sécu, donnée reçue : " + regimeSecu);
          }
          throw e;
        }
        metierCali.setRegimeSecu(codeRegimeSecu);
      }
    }
    ListeEmploi listeCatEmploiSpe = p_metierGa.getListeEmploi();
    if (listeCatEmploiSpe != null) {
      for (int i = 0; i < listeCatEmploiSpe.getNbListCategorieEmploi(); i++)
      {
        CategorieEmploi catEmploiGa = listeCatEmploiSpe.getListeEmploi(i);
        String listeEmploiSpe = catEmploiGa.getListeEmploi();
        if (listeEmploiSpe != null) {
          metierCali.getListeCategoriesEmploiSpe().add(Integer.valueOf(CodeGa.valueOf(listeEmploiSpe)));
        }
      }
    }
    return metierCali;
  }
  
  private static fr.unedic.cali.autresdoms.ga.dom.RegimeRetraite creerRegimeRetraite(fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.RegimeRetraite p_regimeRetraiteGa)
  {
    fr.unedic.cali.autresdoms.ga.dom.RegimeRetraite regimeRetraiteCali = new fr.unedic.cali.autresdoms.ga.dom.RegimeRetraite();
    
    boolean regimeAlsaceMoselle = BooleanGa.valueOfAlsaceMoselle(p_regimeRetraiteGa.getRegimeAlsaceMoselle());
    regimeRetraiteCali.setAlsaceMoselle(regimeAlsaceMoselle);
    
    boolean caisseAbsente = false;
    if (p_regimeRetraiteGa.getEtatCaisseRetraite().intValue() == 3) {
      caisseAbsente = true;
    }
    regimeRetraiteCali.setCaisseRetraiteAbsente(caisseAbsente);
    
    return regimeRetraiteCali;
  }
}

/* Location:
 * Qualified Name:     MapperMetier
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */