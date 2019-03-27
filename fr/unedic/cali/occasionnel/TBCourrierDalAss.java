package fr.unedic.cali.occasionnel;

import fr.pe.cali.client.ManagerAppelsServicesD90;
import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.cohab.dom.TripletteIndividu;
import fr.unedic.cali.outilsfonctionnels.AppelServicesAbstrait;
import fr.unedic.cali.outilsfonctionnels.AppelServicesCojac;
import fr.unedic.d90.donnees.d90.service.vls.CriteresEcrireIndividu;
import fr.unedic.d90.donnees.d90.service.vls.Individu;
import fr.unedic.d90.donnees.d90.service.vls.ListeIndividus;
import fr.unedic.d90.donnees.d90.service.vls.ListeParametres;
import fr.unedic.d90.donnees.d90.service.vls.Parametre;
import fr.unedic.util.services.ApplicativeRuntimeException;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.ResultatService;
import fr.unedic.util.services.batch.ContexteOccasionnel;
import fr.unedic.util.services.batch.TBOccasionnelAbstrait;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

public class TBCourrierDalAss
  extends TBOccasionnelAbstrait
{
  private static final String NOM_TABLE_CALI_INDIVIDUS = "P1299B_ATTRIB";
  protected static final String REQ_SOUSTRAITEMENT = "SELECT %ID FROM %TABLE WHERE %ASSEDIC=? AND ?<=%ID AND %ID<=? AND cprod LIKE 'ASU_CGE01_%' AND DFDTN > CURRENT DATE ORDER BY %ID";
  private static final String NOM_COLONNE_ASSEDIC = "CXASS";
  private static final String NOM_COLONNE_CXALA = "CXALAF";
  
  public TBCourrierDalAss()
  {
    super("P1299B_ATTRIB");
  }
  
  protected ResultatService traiterEnregistrement(ContexteOccasionnel contexte, String id)
    throws TechniqueException
  {
    return new ResultatService();
  }
  
  public ResultatService executer(ContexteOccasionnel contexte)
    throws TechniqueException, ApplicativeException
  {
    ResultatService resultatCumul = new ResultatService(0);
    List<?> listeIDs = lireEnregistrements(contexte);
    
    ecrireIndividu(listeIDs, "0", contexte);
    
    return resultatCumul;
  }
  
  public void ecrireIndividu(List<?> listIndividuSelection, String numeroPassage, ContexteOccasionnel contexteOccasionnel)
    throws CoucheLogiqueException
  {
    ContexteService contexteService = new ContexteService();
    contexteService.setCodeActivite(contexteOccasionnel.getNomTraitement());
    contexteService.setCodeAntenne(contexteOccasionnel.getCodeAssedic());
    contexteService.setDateTraitement(contexteOccasionnel.getDateTraitement());
    try
    {
      ManagerAppelsServicesD90 domaineD90 = new ManagerAppelsServicesD90();
      CriteresEcrireIndividu criteresEcrireIndividu = CriteresEcrireIndividu.getInstance();
      
      criteresEcrireIndividu.setNewListeParametres();
      Parametre vlsParametre = criteresEcrireIndividu.getListeParametres().addParametre();
      vlsParametre.setId("NUMERO_PASSAGE");
      vlsParametre.setValeur(numeroPassage);
      
      vlsParametre = criteresEcrireIndividu.getListeParametres().addParametre();
      vlsParametre.setId("NOM_OCCASIONNEL");
      vlsParametre.setValeur(contexteOccasionnel.getNomTraitement());
      
      vlsParametre = criteresEcrireIndividu.getListeParametres().addParametre();
      vlsParametre.setId("CODE_ASSEDIC");
      vlsParametre.setValeur(contexteOccasionnel.getCodeAssedic());
      
      criteresEcrireIndividu.setNewListeIndividus();
      
      Iterator<?> iteratorIndividuSelection = listIndividuSelection.iterator();
      while (iteratorIndividuSelection.hasNext())
      {
        String cxalaSelection = (String)iteratorIndividuSelection.next();
        
        Individu vlsIndividu = criteresEcrireIndividu.getListeIndividus().addIndividu();
        
        TripletteIndividu triplette = AppelServicesCojac.lireIndividuBniR0(cxalaSelection);
        if (triplette != null) {}
        vlsIndividu.setIdentifiantBNI(new BigDecimal(cxalaSelection));
        vlsIndividu.setIdentifiantSigma(triplette.getNumeroAllocataireRsin());
        
        vlsIndividu.setCodeAntenne(" ");
      }
      criteresEcrireIndividu.setContexteService(AppelServicesAbstrait.contexteServiceDomVersVlsD90(contexteService));
      
      domaineD90.ecrireIndividu(criteresEcrireIndividu);
    }
    catch (ApplicativeException e)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_APPEL_CALI_D90", "Problème lors de l'appel de service de CALI vers D90", e);
    }
    catch (TechniqueException e)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_APPEL_CALI_D90", "Problème lors de l'appel de service de CALI vers D90", e);
    }
  }
  
  protected String getNomColonne(int colonne)
  {
    String nomColonne = "";
    switch (colonne)
    {
    case 1: 
      nomColonne = "CXASS";
      break;
    case 2: 
    case 3: 
      nomColonne = "CXALAF";
      break;
    }
    return nomColonne;
  }
}

/* Location:
 * Qualified Name:     TBCourrierDalAss
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */