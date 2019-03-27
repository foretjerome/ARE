package fr.unedic.cali.affectation.parametres;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.dom.ConteneurAccesDecorReglementaire;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.affectation.DecorReglementaire;
import fr.unedic.cali.dom.affectation.DecorReglementaire2003;
import fr.unedic.cali.dom.affectation.DecorReglementaire2006;
import fr.unedic.cali.dom.affectation.DecorReglementaire2007;
import fr.unedic.cali.dom.affectation.DecorReglementaire2009;
import fr.unedic.cali.dom.affectation.DecorReglementaire2011;
import fr.unedic.cali.dom.affectation.DecorReglementaire2014;
import fr.unedic.cali.dom.affectation.DecorReglementaire2014Beta;
import fr.unedic.cali.dom.affectation.DecorReglementaire2016;
import fr.unedic.cali.dom.affectation.DecorReglementaire2017;
import fr.unedic.cali.dom.affectation.LigneAbstrait;
import fr.unedic.cali.dom.affectation.LigneAsuCSR04;
import fr.unedic.cali.dom.affectation.LigneAsuCge01;
import fr.unedic.cali.dom.affectation.LigneAsuCsa06;
import fr.unedic.cali.dom.affectation.LigneAsuExp03;
import fr.unedic.cali.dom.affectation.LigneAsuSpe02;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.parametres.GestionnaireDateApplication;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.Periode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AccesDecorReglementaire
{
  private static AccesDecorReglementaire instance;
  protected static List<DecorReglementaire> listeDecors = new ArrayList();
  private static final Damj DATE_010103 = new Damj(2003, 1, 1);
  private static final Damj DATE_170106 = new Damj(2006, 1, 17);
  private static final Damj DATE_180106 = new Damj(2006, 1, 18);
  private static final Damj DATE_310307 = new Damj(2007, 3, 31);
  private static final Damj DATE_010407 = new Damj(2007, 4, 1);
  private static final Damj DATE_310309 = new Damj(2009, 3, 31);
  private static final Damj DATE_010409 = new Damj(2009, 4, 1);
  private static final Damj DATE_010611 = new Damj(2011, 6, 1);
  private static final Damj DATE_310511 = new Damj(2011, 5, 31);
  private static final Damj DATE_300614 = new Damj(2014, 6, 30);
  public static final Damj DATE_010714 = new Damj(2014, 7, 1);
  private static final Damj DATE_300914 = new Damj(2014, 9, 30);
  private static final Damj DATE_011014 = new Damj(2014, 10, 1);
  private static final Damj DATE_310716 = new Damj(2016, 7, 31);
  private static final Damj DATE_010816 = new Damj(2016, 8, 1);
  protected static final String ID_DECOR_2001 = "01";
  protected static final String ID_DECOR_2003 = "02";
  protected static final String ID_DECOR_2006 = "03";
  protected static final String ID_DECOR_2007 = "04";
  protected static final String ID_DECOR_2009 = "05";
  protected static final String ID_DECOR_2011 = "06";
  protected static final String ID_DECOR_2014B = "07";
  protected static final String ID_DECOR_2014 = "08";
  protected static final String ID_DECOR_2016 = "09";
  protected static final String ID_DECOR_2017 = "10";
  
  private AccesDecorReglementaire()
    throws CoucheLogiqueException
  {
    LigneAbstrait ligneAsuCge = LigneAsuCge01.getInstance();
    LigneAbstrait ligneAsuSpe = LigneAsuSpe02.getInstance();
    LigneAbstrait ligneAsuExp = LigneAsuExp03.getInstance();
    LigneAbstrait ligneAsuCsa = LigneAsuCsa06.getInstance();
    LigneAbstrait ligneAsuCsr = LigneAsuCSR04.getInstance();
    
    Periode periodeValidite2003 = new Periode(DATE_010103, DATE_170106);
    DecorReglementaire2003 decor2003 = new DecorReglementaire2003(periodeValidite2003, "02");
    decor2003.ajouterProduit(ligneAsuCge.getProduitActif(DATE_010103));
    decor2003.ajouterProduit(ligneAsuSpe.getProduitActif(DATE_010103));
    decor2003.ajouterProduit(ligneAsuCsa.getProduitActif(DATE_010103));
    decor2003.ajouterProduit(ligneAsuCsr.getProduitActif(DATE_010103));
    listeDecors.add(decor2003);
    
    Periode periodeValidite2006 = new Periode(DATE_180106, DATE_310307);
    DecorReglementaire2006 decor2006 = new DecorReglementaire2006(periodeValidite2006, "03");
    decor2006.ajouterProduit(ligneAsuCge.getProduitActif(DATE_180106));
    decor2006.ajouterProduit(ligneAsuSpe.getProduitActif(DATE_180106));
    decor2006.ajouterProduit(ligneAsuCsa.getProduitActif(DATE_180106));
    decor2006.ajouterProduit(ligneAsuCsr.getProduitActif(DATE_180106));
    listeDecors.add(decor2006);
    
    Periode periodeValidite2007 = new Periode(DATE_010407, DATE_310309);
    DecorReglementaire2007 decor2007 = new DecorReglementaire2007(periodeValidite2007, "04");
    decor2007.ajouterProduit(ligneAsuCge.getProduitActif(DATE_010407));
    decor2007.ajouterProduit(ligneAsuSpe.getProduitActif(DATE_010407));
    decor2007.ajouterProduit(ligneAsuCsa.getProduitActif(DATE_010407));
    decor2007.ajouterProduit(ligneAsuCsr.getProduitActif(DATE_010407));
    listeDecors.add(decor2007);
    
    Periode periodeValidite2009 = new Periode(DATE_010409, DATE_310511);
    DecorReglementaire2009 decor2009 = new DecorReglementaire2009(periodeValidite2009, "05");
    decor2009.ajouterProduit(ligneAsuCge.getProduitActif(DATE_010409));
    decor2009.ajouterProduit(ligneAsuSpe.getProduitActif(DATE_010409));
    decor2009.ajouterProduit(ligneAsuExp.getProduitActif(DATE_010409));
    decor2009.ajouterProduit(ligneAsuCsa.getProduitActif(DATE_010409));
    decor2009.ajouterProduit(ligneAsuCsr.getProduitActif(DATE_010409));
    listeDecors.add(decor2009);
    
    Periode periodeValidite2011 = new Periode(DATE_010611, DATE_300614);
    DecorReglementaire2011 decor2011 = new DecorReglementaire2011(periodeValidite2011, "06");
    decor2011.ajouterProduit(ligneAsuCge.getProduitActif(DATE_010611));
    decor2011.ajouterProduit(ligneAsuSpe.getProduitActif(DATE_010611));
    decor2011.ajouterProduit(ligneAsuExp.getProduitActif(DATE_010611));
    decor2011.ajouterProduit(ligneAsuCsa.getProduitActif(DATE_010611));
    decor2011.ajouterProduit(ligneAsuCsr.getProduitActif(DATE_010611));
    listeDecors.add(decor2011);
    
    Periode periodeValidite2014b = new Periode(DATE_010714, DATE_300914);
    Periode periodeValidite2014bDateExamen = new Periode(DATE_010714, DATE_300914);
    DecorReglementaire2014Beta decor2014b = new DecorReglementaire2014Beta(periodeValidite2014b, periodeValidite2014bDateExamen, "07");
    decor2014b.ajouterProduit(ligneAsuCge.getProduitActif(DATE_010714));
    decor2014b.ajouterProduit(ligneAsuSpe.getProduitActif(DATE_010714));
    decor2014b.ajouterProduit(ligneAsuExp.getProduitActif(DATE_010714));
    decor2014b.ajouterProduit(ligneAsuCsa.getProduitActif(DATE_010714));
    decor2014b.ajouterProduit(ligneAsuCsr.getProduitActif(DATE_010714));
    listeDecors.add(decor2014b);
    
    Periode periodeValidite2014 = new Periode(DATE_010714, DATE_310716);
    Periode periodeValidite2014DateExamen = new Periode(DATE_011014, Damj.FIN_DES_TEMPS);
    DecorReglementaire2014 decor2014 = new DecorReglementaire2014(periodeValidite2014, periodeValidite2014DateExamen, "08");
    decor2014.ajouterProduit(ligneAsuCge.getProduitActif(DATE_011014));
    decor2014.ajouterProduit(ligneAsuSpe.getProduitActif(DATE_011014));
    decor2014.ajouterProduit(ligneAsuExp.getProduitActif(DATE_011014));
    decor2014.ajouterProduit(ligneAsuCsa.getProduitActif(DATE_011014));
    decor2014.ajouterProduit(ligneAsuCsr.getProduitActif(DATE_011014));
    listeDecors.add(decor2014);
    
    Damj dateFinDecorReglementaire2016 = GestionnaireDateApplication.getInstance().recupererDateApplication("Date de fin du décor réglementaire 2016");
    Periode periodeValidite2016 = new Periode(DATE_010816, dateFinDecorReglementaire2016);
    DecorReglementaire2016 decor2016 = new DecorReglementaire2016(periodeValidite2016, "09");
    decor2016.ajouterProduit(ligneAsuCge.getProduitActif(DATE_010816));
    decor2016.ajouterProduit(ligneAsuSpe.getProduitActif(DATE_010816));
    decor2016.ajouterProduit(ligneAsuExp.getProduitActif(DATE_010816));
    decor2016.ajouterProduit(ligneAsuCsa.getProduitActif(DATE_010816));
    decor2016.ajouterProduit(ligneAsuCsr.getProduitActif(DATE_010816));
    listeDecors.add(decor2016);
    
    Damj dateDebutDecorReglementaire2017 = GestionnaireDateApplication.getInstance().recupererDateApplication("Date de debut du décor réglementaire 2017");
    Periode periodeValidite2017 = new Periode(dateDebutDecorReglementaire2017, Damj.FIN_DES_TEMPS);
    DecorReglementaire2017 decor2017 = new DecorReglementaire2017(periodeValidite2017, "10");
    decor2017.ajouterProduit(ligneAsuCge.getProduitActif(dateDebutDecorReglementaire2017));
    decor2017.ajouterProduit(ligneAsuSpe.getProduitActif(dateDebutDecorReglementaire2017));
    decor2017.ajouterProduit(ligneAsuExp.getProduitActif(dateDebutDecorReglementaire2017));
    decor2017.ajouterProduit(ligneAsuCsa.getProduitActif(dateDebutDecorReglementaire2017));
    decor2017.ajouterProduit(ligneAsuCsr.getProduitActif(dateDebutDecorReglementaire2017));
    listeDecors.add(decor2017);
  }
  
  public static synchronized AccesDecorReglementaire getInstance()
  {
    if (instance == null) {
      try
      {
        instance = new AccesDecorReglementaire();
      }
      catch (CoucheLogiqueException e) {}
    }
    return instance;
  }
  
  public List<DecorReglementaire> getListeDecors()
  {
    return listeDecors;
  }
  
  public DecorReglementaire getDecor(ConteneurAccesDecorReglementaire conteneur)
    throws CoucheLogiqueException
  {
    DecorReglementaire decorRetourne = null;
    List<DecorReglementaire> listeDecorRetourne = new ArrayList();
    if (conteneur != null) {
      for (DecorReglementaire decor : getListeDecors()) {
        if (decor.estValide(conteneur))
        {
          decorRetourne = decor;
          listeDecorRetourne.add(decorRetourne);
        }
      }
    }
    if (listeDecorRetourne.size() > 1) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_NOMBRE_DECOR_REGLEMENTAIRE");
    }
    return decorRetourne;
  }
  
  public DecorReglementaire recupererDecorReglementaireEnCoursADate(ConteneurAccesDecorReglementaire conteneur)
    throws CoucheLogiqueException
  {
    DecorReglementaire decorARetourner = null;
    List<DecorReglementaire> listeDecorRetourne = new ArrayList();
    for (DecorReglementaire decor : listeDecors) {
      if (decor.estDecorEnCoursSelonDate(conteneur))
      {
        decorARetourner = decor;
        listeDecorRetourne.add(decorARetourner);
      }
    }
    if (listeDecorRetourne.size() > 1) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_NOMBRE_DECOR_REGLEMENTAIRE");
    }
    return decorARetourner;
  }
  
  public void positionnerCriteresQualifSurPas(CriteresQualification critere, Individu individuCourant)
  {
    if (individuCourant != null)
    {
      Chronologie chronoPas = individuCourant.getChronoPeriodePasseProfessionnel();
      
      Iterator<?> iterPeriodes = chronoPas.iterer();
      while (iterPeriodes.hasNext())
      {
        ObjetChronoPeriode pas = (ObjetChronoPeriode)iterPeriodes.next();
        if ((pas instanceof ActiviteSalarie)) {
          ((ActiviteSalarie)pas).setCriteresQualification(critere);
        }
      }
      individuCourant.setCriteresQualificationPositionnes(true);
    }
  }
  
  public DecorReglementaire getDecorParId(String idDecor)
  {
    DecorReglementaire decorRetourne = null;
    if (idDecor != null) {
      for (DecorReglementaire decor : getListeDecors()) {
        if (decor.getIdDecor().equals(idDecor))
        {
          decorRetourne = decor;
          break;
        }
      }
    }
    return decorRetourne;
  }
}

/* Location:
 * Qualified Name:     AccesDecorReglementaire
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */