package fr.pe.cali.reglementaire.regles.assurance.affiliation.outils.impl;

import fr.pe.cali.reglementaire.dom.impl.CriteresFabriqueReglementaire;
import fr.pe.cali.reglementaire.outils.spec.IOutilCorpsRegle;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.outils.spec.IOutilFonctionnelAffiliationJoursTravailles;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.outils.spec.IOutilPeriodeNonAssimilable;
import fr.unedic.cali.autresdoms.ga.dom.spec.IncidentSpec;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Periode;
import java.util.ArrayList;

public class OutilPeriodeNonAssimilableFgdApres2018
  implements IOutilPeriodeNonAssimilable
{
  private static final String NOM_OUTIL = "OutilPeriodeAssimilableFgdApres2018";
  
  public boolean estAssimilable(IncidentSpec incident, IOutilFonctionnelAffiliationJoursTravailles outilFonctionnel)
  {
    boolean estAssimilable;
    boolean estAssimilable;
    if (recupererListeNaturePepNonAssimilable().contains(Integer.valueOf(incident.getNature())))
    {
      estAssimilable = false;
    }
    else
    {
      boolean estAssimilable;
      if (recupererListeNatureAssimilable().contains(Integer.valueOf(incident.getNature())))
      {
        estAssimilable = true;
      }
      else
      {
        ChronologiePeriodes chronologiePeriodesHorsChamp = outilFonctionnel.recupererPeriodesHorsChamp();
        boolean incidentPendantActiviteHorsChamp = incident.getPeriode().inter(chronologiePeriodesHorsChamp) == incident.getPeriode().getDuree();
        
        estAssimilable = !incidentPendantActiviteHorsChamp;
      }
    }
    return estAssimilable;
  }
  
  private ArrayList<Integer> recupererListeNaturePepNonAssimilable()
  {
    ArrayList<Integer> listeNatureNonAutorisee = new ArrayList();
    listeNatureNonAutorisee.add(Integer.valueOf(55));
    listeNatureNonAutorisee.add(Integer.valueOf(11));
    listeNatureNonAutorisee.add(Integer.valueOf(56));
    listeNatureNonAutorisee.add(Integer.valueOf(57));
    listeNatureNonAutorisee.add(Integer.valueOf(58));
    listeNatureNonAutorisee.add(Integer.valueOf(59));
    listeNatureNonAutorisee.add(Integer.valueOf(14));
    return listeNatureNonAutorisee;
  }
  
  private ArrayList<Integer> recupererListeNatureAssimilable()
  {
    ArrayList<Integer> listeNatureAutorisee = new ArrayList();
    listeNatureAutorisee.add(Integer.valueOf(10));
    listeNatureAutorisee.add(Integer.valueOf(49));
    
    return listeNatureAutorisee;
  }
  
  public boolean estApplicablePourCriteres(CriteresFabriqueReglementaire criteres)
  {
    return true;
  }
  
  public IOutilCorpsRegle creerNouvelleInstance()
  {
    return new OutilPeriodeNonAssimilableFgdApres2018();
  }
  
  public String getNomOutil()
  {
    return "OutilPeriodeAssimilableFgdApres2018";
  }
}

/* Location:
 * Qualified Name:     OutilPeriodeNonAssimilableFgdApres2018
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */