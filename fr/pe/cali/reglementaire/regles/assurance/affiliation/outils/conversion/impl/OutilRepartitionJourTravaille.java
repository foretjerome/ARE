package fr.pe.cali.reglementaire.regles.assurance.affiliation.outils.conversion.impl;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class OutilRepartitionJourTravaille
{
  private static OutilRepartitionJourTravaille instance = new OutilRepartitionJourTravaille();
  
  public static OutilRepartitionJourTravaille getInstance()
  {
    return instance;
  }
  
  public List<Damj> repartirJour(Periode periode, int nombreJoursTravailles)
  {
    BigDecimal nombreJoursCalendaires = determinerNombreJoursCalendaires(periode);
    BigDecimal intervalle = determinerIntervalleEntreJoursTravailles(BigDecimal.valueOf(nombreJoursTravailles), nombreJoursCalendaires);
    
    List<Integer> emplacements = determinerEmplacementJoursTravailles(intervalle, nombreJoursTravailles);
    
    return determinerJoursTravailles(emplacements, periode);
  }
  
  protected BigDecimal determinerNombreJoursCalendaires(Periode periode)
  {
    return BigDecimal.valueOf(periode.getDuree());
  }
  
  protected BigDecimal determinerIntervalleEntreJoursTravailles(BigDecimal nombreJoursTravailles, BigDecimal nombreJoursCalendaires)
  {
    BigDecimal retour = BigDecimal.ZERO;
    BigDecimal numerateur = nombreJoursCalendaires.subtract(nombreJoursTravailles);
    BigDecimal denominateur = nombreJoursTravailles.subtract(BigDecimal.ONE);
    if (denominateur.compareTo(BigDecimal.ZERO) != 0) {
      retour = numerateur.divide(denominateur, 10, 0);
    }
    return retour;
  }
  
  protected List<Integer> determinerEmplacementJoursTravailles(BigDecimal intervalle, int nombreJoursTravailles)
  {
    List<Integer> emplacements = new ArrayList();
    for (int index = 1; index <= nombreJoursTravailles; index++)
    {
      BigDecimal emplacement = BigDecimal.valueOf(index).subtract(BigDecimal.ONE).multiply(intervalle).add(BigDecimal.valueOf(index));
      emplacements.add(Integer.valueOf(emplacement.intValue()));
    }
    return emplacements;
  }
  
  protected List<Damj> determinerJoursTravailles(List<Integer> emplacements, Periode periode)
  {
    List<Damj> joursTravailles = new ArrayList();
    Damj dateCourante = periode.getDebut();
    for (int index = 1; index <= periode.getDuree(); index++)
    {
      if (emplacements.contains(Integer.valueOf(index))) {
        joursTravailles.add(dateCourante);
      }
      dateCourante = dateCourante.lendemain();
    }
    return joursTravailles;
  }
}

/* Location:
 * Qualified Name:     OutilRepartitionJourTravaille
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */