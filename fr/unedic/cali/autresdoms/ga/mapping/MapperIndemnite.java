package fr.unedic.cali.autresdoms.ga.mapping;

import fr.unedic.cali.autresdoms.ga.dom.TravailSalarie;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ListeIndemnites;
import fr.unedic.util.QuantiteEuro;
import fr.unedic.util.QuantiteJoursCalendaires;
import fr.unedic.util.QuantiteJoursOuvrables;
import fr.unedic.util.QuantiteJoursOuvres;
import java.math.BigDecimal;

class MapperIndemnite
{
  static void ajouter(TravailSalarie pasGaec, ListeIndemnites listeIndemnitesGaec)
  {
    if (listeIndemnitesGaec == null) {
      return;
    }
    for (int i = 0; i < listeIndemnitesGaec.getNbListIndemnite(); i++)
    {
      fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.Indemnite indemniteGa = listeIndemnitesGaec.getListeIndemnites(i);
      fr.unedic.cali.autresdoms.ga.dom.Indemnite indemniteCali = new fr.unedic.cali.autresdoms.ga.dom.Indemnite();
      
      String typeIndemnite = indemniteGa.getTypeIndemnite();
      if (typeIndemnite != null) {
        indemniteCali.setTypeIndemnite(Integer.parseInt(typeIndemnite));
      }
      BigDecimal montantIndemnite = indemniteGa.getMontantIndemnite();
      if (montantIndemnite != null) {
        indemniteCali.setMontant(new QuantiteEuro(montantIndemnite));
      }
      pasGaec.ajouterIndemnite(indemniteCali);
      
      ajouter(pasGaec, indemniteGa);
    }
  }
  
  static void ajouter(TravailSalarie pasGaec, fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.Indemnite indemniteGaec)
  {
    if ((indemniteGaec.getTypeIndemnite() != null) && (!"".equals(indemniteGaec.getTypeIndemnite())))
    {
      int typeIndemnite = Integer.parseInt(indemniteGaec.getTypeIndemnite());
      switch (typeIndemnite)
      {
      case 201: 
        traiterICCP(pasGaec, indemniteGaec);
        break;
      case 3: 
        break;
      case 4: 
        if (indemniteGaec.getMontantIndemnite() != null) {
          pasGaec.setQuantiteEuroIndemniteTransactionnelle(new QuantiteEuro(indemniteGaec.getMontantIndemnite()));
        }
        break;
      case 126: 
        if (indemniteGaec.getMontantIndemnite() != null) {
          pasGaec.setNbHeuresDiff(indemniteGaec.getNbHeuresDIF());
        }
        break;
      }
    }
  }
  
  private static void traiterICCP(TravailSalarie pasGaec, fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.Indemnite indemniteGaec)
  {
    if (indemniteGaec.getMontantIndemnite() != null) {
      pasGaec.setQuantiteEuroIccp(new QuantiteEuro(indemniteGaec.getMontantIndemnite()));
    }
    if ((indemniteGaec.getNbJours() != null) && (indemniteGaec.getCodeNatureJour() != null)) {
      if (indemniteGaec.getCodeNatureJour().equals("01")) {
        pasGaec.setQuantiteJourIccp(new QuantiteJoursOuvrables(indemniteGaec.getNbJours()));
      } else if (indemniteGaec.getCodeNatureJour().equals("02")) {
        pasGaec.setQuantiteJourIccp(new QuantiteJoursOuvres(indemniteGaec.getNbJours()));
      } else if (indemniteGaec.getCodeNatureJour().equals("03")) {
        pasGaec.setQuantiteJourIccp(new QuantiteJoursCalendaires(indemniteGaec.getNbJours()));
      }
    }
    if (indemniteGaec.getCodeCaisseProfessionnelle() != null) {
      pasGaec.setCodeCaisseProfessionnelle(indemniteGaec.getCodeCaisseProfessionnelle());
    }
  }
}

/* Location:
 * Qualified Name:     MapperIndemnite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */