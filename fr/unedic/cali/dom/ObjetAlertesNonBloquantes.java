package fr.unedic.cali.dom;

import fr.unedic.cali.autresdoms.ga.dom.spec.TravailSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ObjetAlertesNonBloquantes
{
  private boolean squeezerCodeDeMerde;
  private String libelleErreur;
  private Periode periode;
  private int typeNature;
  private String identifiantActivite;
  public static final int TYPE_PERIODE_ACTIVITE_INDETERMINEE = 999;
  public static final int TYPE_PERIODE_FORMATION_CIF_POUR_CDD = 1;
  public static final int TYPE_PERIODE_ACTIVITE_SALARIEE = 2;
  public static final int TYPE_PERIODE_FORMATION_NON_INDEMNISABLE_ASSIMILABLE = 3;
  public static final int TYPE_PERIODE_FORMATION_NON_INDEMNISABLE_NON_ASSIMILABLE = 4;
  public static final int TYPE_PERIODE_INACTIVITE = 5;
  public static final int TYPE_PERIODE_SERVICE_NATIONAL = 6;
  public static final int TYPE_PERIODE_NON_DECLAREE_SANCTIONNEE = 7;
  public static final int TYPE_PERIODE_FRAUDULEUSE = 8;
  public static final int TYPE_PERIODE_AFFILIATION_ALERTE = 9;
  public static final int TYPE_PERIODE_INCOHERENCE = 10;
  
  public ObjetAlertesNonBloquantes(String libelleErreur)
  {
    squeezerCodeDeMerde = true;
    this.libelleErreur = libelleErreur;
  }
  
  public ObjetAlertesNonBloquantes(TravailSpec travail)
  {
    squeezerCodeDeMerde = false;
    setPeriode(new Periode(travail.getDateDebut(), travail.getDateFin()));
    setTypeNature(conversion(travail.getTypePeriode()));
    setIdentifiantActivite(travail.getIdentifiant());
  }
  
  public ObjetAlertesNonBloquantes(Damj dateDebut, Damj dateFin, int typePeriode)
  {
    squeezerCodeDeMerde = false;
    setPeriode(new Periode(dateDebut, dateFin));
    setTypeNature(typePeriode);
  }
  
  protected static int conversion(int typePeriodeTravailSpec)
  {
    int type;
    switch (typePeriodeTravailSpec)
    {
    case 5: 
      type = 1;
      break;
    case 8: 
    case 9: 
    case 30: 
      type = 2;
      break;
    case 102: 
      type = 3;
      break;
    case 104: 
      type = 4;
      break;
    case 3: 
      type = 5;
      break;
    case 7: 
      type = 6;
      break;
    case 999: 
    default: 
      type = 999;
    }
    return type;
  }
  
  public boolean equals(Object arg0)
  {
    ObjetAlertesNonBloquantes objetAlertesNonBloquantes = (ObjetAlertesNonBloquantes)arg0;
    
    return (getPeriode().getDebut().coincideAvec(objetAlertesNonBloquantes.getPeriode().getDebut())) && (getPeriode().getFin().coincideAvec(objetAlertesNonBloquantes.getPeriode().getFin())) && (getTypeNature() == objetAlertesNonBloquantes.getTypeNature());
  }
  
  public Periode getPeriode()
  {
    return periode;
  }
  
  public void setPeriode(Periode periode)
  {
    this.periode = periode;
  }
  
  public int getTypeNature()
  {
    return typeNature;
  }
  
  public void setTypeNature(int typeNature)
  {
    this.typeNature = typeNature;
  }
  
  public String getLibelleErreur()
  {
    return libelleErreur;
  }
  
  public void setLibelleErreur(String libelleErreur)
  {
    this.libelleErreur = libelleErreur;
  }
  
  public boolean isSqueezerCodeDeMerde()
  {
    return squeezerCodeDeMerde;
  }
  
  public void setSqueezerCodeDeMerde(boolean squeezerCodeDeMerde)
  {
    this.squeezerCodeDeMerde = squeezerCodeDeMerde;
  }
  
  public String getIdentifiantActivite()
  {
    return identifiantActivite;
  }
  
  public void setIdentifiantActivite(String identifiantActivite)
  {
    this.identifiantActivite = identifiantActivite;
  }
}

/* Location:
 * Qualified Name:     ObjetAlertesNonBloquantes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */