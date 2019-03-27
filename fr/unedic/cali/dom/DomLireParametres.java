package fr.unedic.cali.dom;

import fr.unedic.cali.parcours.DomCali;
import fr.unedic.cali.parcours.DomCaliOptimise;
import fr.unedic.util.services.ContexteService;
import java.util.ArrayList;

public class DomLireParametres
  extends DomCaliOptimise
  implements DomCali
{
  ArrayList m_listeGroupe1 = null;
  ArrayList m_listeGroupe2 = null;
  ArrayList m_listeGroupe3 = null;
  ArrayList m_listeGroupe4 = null;
  ArrayList m_listeGroupe5 = null;
  ArrayList m_listeGroupe6 = null;
  ArrayList m_listeGroupe7 = null;
  ArrayList m_listeGroupe8 = null;
  ArrayList m_listeGroupe9 = null;
  ArrayList m_listeGroupe101112 = null;
  ArrayList m_listeGroupe13 = null;
  ArrayList m_listeGroupe15 = null;
  ArrayList m_listeGroupeMontantITIH = null;
  ArrayList m_listePlafondATASeule = null;
  ArrayList m_listePlafondATACouple = null;
  ArrayList m_listeGroupeGammePreretraite = null;
  ArrayList m_listeParametresRFF = null;
  ArrayList m_listeParametresAFAFMayotte = null;
  ArrayList m_listeParametresASSMayotte = null;
  ArrayList m_listeParametresAREMayotte = null;
  ArrayList m_listeParametresPfm = null;
  private ContexteService m_contexteService;
  
  public void setListeGroupe1(ArrayList p_listeGroupe1)
  {
    m_listeGroupe1 = p_listeGroupe1;
  }
  
  public ArrayList getListeGroupe1()
  {
    return m_listeGroupe1;
  }
  
  public void setListeGroupe2(ArrayList p_listeGroupe2)
  {
    m_listeGroupe2 = p_listeGroupe2;
  }
  
  public ArrayList getListeGroupe2()
  {
    return m_listeGroupe2;
  }
  
  public void setListeGroupe3(ArrayList p_listeGroupe3)
  {
    m_listeGroupe3 = p_listeGroupe3;
  }
  
  public ArrayList getListeGroupe3()
  {
    return m_listeGroupe3;
  }
  
  public void setListeGroupe4(ArrayList p_listeGroupe4)
  {
    m_listeGroupe4 = p_listeGroupe4;
  }
  
  public ArrayList getListeGroupe4()
  {
    return m_listeGroupe4;
  }
  
  public void setListeGroupe5(ArrayList p_listeGroupe5)
  {
    m_listeGroupe5 = p_listeGroupe5;
  }
  
  public ArrayList getListeGroupe5()
  {
    return m_listeGroupe5;
  }
  
  public void setListeGroupe6(ArrayList p_listeGroupe6)
  {
    m_listeGroupe6 = p_listeGroupe6;
  }
  
  public ArrayList getListeGroupe6()
  {
    return m_listeGroupe6;
  }
  
  public void setListeGroupe7(ArrayList p_listeGroupe7)
  {
    m_listeGroupe7 = p_listeGroupe7;
  }
  
  public ArrayList getListeGroupe7()
  {
    return m_listeGroupe7;
  }
  
  public ArrayList getListeGroupe8()
  {
    return m_listeGroupe8;
  }
  
  public void setListeGroupe8(ArrayList p_listeGroupe8)
  {
    m_listeGroupe8 = p_listeGroupe8;
  }
  
  public ContexteService getContexteService()
  {
    return m_contexteService;
  }
  
  public IndividuSpec getIndividu()
  {
    return null;
  }
  
  public void setContexteService(ContexteService p_contexteService)
  {
    m_contexteService = p_contexteService;
  }
  
  public void setIndividu(IndividuSpec p_individu) {}
  
  public ArrayList getListeGroupe9()
  {
    return m_listeGroupe9;
  }
  
  public void setListeGroupe9(ArrayList p_listeGroupe9)
  {
    m_listeGroupe9 = p_listeGroupe9;
  }
  
  public ArrayList getListeGroupe101112()
  {
    return m_listeGroupe101112;
  }
  
  public void setListeGroupe101112(ArrayList p_listeGroupe101112)
  {
    m_listeGroupe101112 = p_listeGroupe101112;
  }
  
  public ArrayList getListeGroupe13()
  {
    return m_listeGroupe13;
  }
  
  public void setListeGroupe13(ArrayList p_listeGroupe13)
  {
    m_listeGroupe13 = p_listeGroupe13;
  }
  
  public ArrayList getListePlafondATASeule()
  {
    return m_listePlafondATASeule;
  }
  
  public void setListePlafondATASeule(ArrayList p_listePlafondATASeule)
  {
    m_listePlafondATASeule = p_listePlafondATASeule;
  }
  
  public void setListeGroupe15(ArrayList p_listeGroupe15)
  {
    m_listeGroupe15 = p_listeGroupe15;
  }
  
  public ArrayList getListeGroupe15()
  {
    return m_listeGroupe15;
  }
  
  public ArrayList getListeGroupeMontantITIH()
  {
    return m_listeGroupeMontantITIH;
  }
  
  public void setListeGroupeMontantITIH(ArrayList p_listeGroupeMontantITIH)
  {
    m_listeGroupeMontantITIH = p_listeGroupeMontantITIH;
  }
  
  public void setListeGroupeGammePreretraite(ArrayList p_listeGroupeGammePreretraite)
  {
    m_listeGroupeGammePreretraite = p_listeGroupeGammePreretraite;
  }
  
  public ArrayList getListeGroupeGammePreretraite()
  {
    return m_listeGroupeGammePreretraite;
  }
  
  public ArrayList getListeParametresRFF()
  {
    return m_listeParametresRFF;
  }
  
  public void setListeParametresRFF(ArrayList p_listeParametresRFF)
  {
    m_listeParametresRFF = p_listeParametresRFF;
  }
  
  public ArrayList getListeParametresAFAFMayotte()
  {
    return m_listeParametresAFAFMayotte;
  }
  
  public void setListeParametresAFAFMayotte(ArrayList p_listeParametresAFAFMayotte)
  {
    m_listeParametresAFAFMayotte = p_listeParametresAFAFMayotte;
  }
  
  public ArrayList getListeParametresASSMayotte()
  {
    return m_listeParametresASSMayotte;
  }
  
  public void setListeParametresASSMayotte(ArrayList p_listeParametresASSMayotte)
  {
    m_listeParametresASSMayotte = p_listeParametresASSMayotte;
  }
  
  public ArrayList getListeParametresPfm()
  {
    return m_listeParametresPfm;
  }
  
  public void setListeParametresPfm(ArrayList p_listeParametresPfm)
  {
    m_listeParametresPfm = p_listeParametresPfm;
  }
  
  public ArrayList getListeParametresAREMayotte()
  {
    return m_listeParametresAREMayotte;
  }
  
  public void setListeParametresAREMayotte(ArrayList p_listeParametresAREMayotte)
  {
    m_listeParametresAREMayotte = p_listeParametresAREMayotte;
  }
}

/* Location:
 * Qualified Name:     DomLireParametres
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */