package fr.unedic.cali.autresdoms.ga.outilsfonctionnels;

import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.Entreprise;
import fr.unedic.cali.autresdoms.ga.dom.Metier;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteSalarie;
import fr.unedic.util.services.OutilFonctionnel;
import java.util.ArrayList;
import java.util.List;

public class DeterminationSecteurActivite
  implements OutilFonctionnel
{
  private static List s_actSaisAgricolesList = new ArrayList();
  private static List s_actSaisLieeTourisme1List = new ArrayList();
  private static List s_exploitForestieresList = new ArrayList();
  private static List s_sportProList = new ArrayList();
  private static List s_actSaisLieeTourisme2List = new ArrayList();
  private static List s_casinoCerclesJeuxList = new ArrayList();
  private static List s_centreLoisirsVacancesList = new ArrayList();
  
  static
  {
    s_actSaisAgricolesList.add("011A");
    s_actSaisAgricolesList.add("011C");
    s_actSaisAgricolesList.add("011F");
    s_actSaisAgricolesList.add("011G");
    s_actSaisAgricolesList.add("0111Z");
    s_actSaisAgricolesList.add("0112Z");
    s_actSaisAgricolesList.add("0113Z");
    s_actSaisAgricolesList.add("0114Z");
    s_actSaisAgricolesList.add("0115Z");
    s_actSaisAgricolesList.add("0116Z");
    s_actSaisAgricolesList.add("0119Z");
    s_actSaisAgricolesList.add("0126Z");
    s_actSaisAgricolesList.add("0128Z");
    s_actSaisAgricolesList.add("0129Z");
    s_actSaisAgricolesList.add("0163Z");
    s_actSaisAgricolesList.add("0230Z");
    s_actSaisAgricolesList.add("0122Z");
    s_actSaisAgricolesList.add("0123Z");
    s_actSaisAgricolesList.add("0124Z");
    s_actSaisAgricolesList.add("0125Z");
    s_actSaisAgricolesList.add("0126Z");
    s_actSaisAgricolesList.add("0127Z");
    s_actSaisAgricolesList.add("0128Z");
    s_actSaisAgricolesList.add("0123A");
    s_actSaisAgricolesList.add("0121Z");
    s_actSaisAgricolesList.add("1102A");
    s_actSaisAgricolesList.add("1102B");
    
    s_actSaisLieeTourisme1List.add("551A");
    s_actSaisLieeTourisme1List.add("551C");
    s_actSaisLieeTourisme1List.add("5510Z");
    
    s_exploitForestieresList.add("020A");
    s_exploitForestieresList.add("020B");
    s_exploitForestieresList.add("020D");
    s_exploitForestieresList.add("0129Z");
    s_exploitForestieresList.add("0210Z");
    s_exploitForestieresList.add("0230Z");
    s_exploitForestieresList.add("0220Z");
    s_exploitForestieresList.add("1610A");
    s_exploitForestieresList.add("0240Z");
    
    s_sportProList.add("926C");
    s_sportProList.add("7990Z");
    s_sportProList.add("8551Z");
    s_sportProList.add("9312Z");
    s_sportProList.add("9319Z");
    s_sportProList.add("9329Z");
    
    s_actSaisLieeTourisme2List.add("552A");
    s_actSaisLieeTourisme2List.add("552C");
    s_actSaisLieeTourisme2List.add("552E");
    s_actSaisLieeTourisme2List.add("602C");
    s_actSaisLieeTourisme2List.add("5520Z");
    s_actSaisLieeTourisme2List.add("5530Z");
    s_actSaisLieeTourisme2List.add("5510Z");
    
    s_casinoCerclesJeuxList.add("927A");
    s_casinoCerclesJeuxList.add("9200Z");
    
    s_centreLoisirsVacancesList.add("927C");
    s_centreLoisirsVacancesList.add("7810Z");
    s_centreLoisirsVacancesList.add("7990Z");
    s_centreLoisirsVacancesList.add("8551Z");
    s_centreLoisirsVacancesList.add("9200Z");
    s_centreLoisirsVacancesList.add("9329Z");
  }
  
  public static int determiner(PeriodeActiviteSalarie p_pas)
  {
    int secteurActivite = 0;
    
    String codeNaf = p_pas.getEntreprise().getCodeNAF();
    int metier = p_pas.getMetier().getCodeEmploi();
    if (codeNaf != null)
    {
      codeNaf = codeNaf.toUpperCase();
      if (metier == 8)
      {
        if (s_actSaisAgricolesList.contains(codeNaf)) {
          secteurActivite = 1;
        }
      }
      else if (((metier == 66) || (metier == 68)) && 
        (s_actSaisLieeTourisme1List.contains(codeNaf))) {
        secteurActivite = 3;
      }
      if ((metier == 8) || (metier == 37)) {
        if (s_exploitForestieresList.contains(codeNaf)) {
          secteurActivite = 2;
        }
      }
      if (s_sportProList.contains(codeNaf))
      {
        if (metier == 74) {
          secteurActivite = 5;
        } else {
          secteurActivite = 6;
        }
      }
      else if (s_actSaisLieeTourisme2List.contains(codeNaf)) {
        secteurActivite = 3;
      } else if (s_casinoCerclesJeuxList.contains(codeNaf)) {
        secteurActivite = 4;
      } else if (s_centreLoisirsVacancesList.contains(codeNaf)) {
        secteurActivite = 6;
      }
    }
    else if (Log.isTraceActive(DeterminationSecteurActivite.class, Niveau.INFO))
    {
      Log.ecritTrace(Niveau.INFO, DeterminationSecteurActivite.class, "determiner", "Code NAF non renseigné pour période " + p_pas.toString());
    }
    return secteurActivite;
  }
  
  public static boolean estSaisonnier(ActiviteSalarie p_pas)
  {
    return p_pas.getSecteurActivite() != 0;
  }
}

/* Location:
 * Qualified Name:     DeterminationSecteurActivite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */