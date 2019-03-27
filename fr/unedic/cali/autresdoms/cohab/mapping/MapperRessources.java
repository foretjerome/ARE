package fr.unedic.cali.autresdoms.cohab.mapping;

import fr.unedic.cali.autresdoms.cohab.dom.IndividuCohabAbstrait;
import fr.unedic.cali.autresdoms.cohab.dom.Ressources;
import fr.unedic.cali.autresdoms.cohab.sigma.listeressource.dom.spec.RessourceSpec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class MapperRessources
{
  public static void mapperRessources(IndividuCohabAbstrait individu, Collection listeRessourcesV1)
  {
    Collection listeRessourcesLieeADemandeMappee = new ArrayList();
    Collection listeRessourcesDdteMappee = new ArrayList();
    if (listeRessourcesV1 != null)
    {
      Iterator iterRessourcesV1 = listeRessourcesV1.iterator();
      while (iterRessourcesV1.hasNext())
      {
        RessourceSpec ressourceV1 = (RessourceSpec)iterRessourcesV1.next();
        if ((ressourceV1.getOrigine() != null) && (ressourceV1.getReferenceExterne() != null)) {
          listeRessourcesLieeADemandeMappee.add(mapperRessources(ressourceV1));
        }
        if ((ressourceV1.getOrigine() != null) && (ressourceV1.getOrigine().equals("C"))) {
          listeRessourcesDdteMappee.add(mapperRessources(ressourceV1));
        }
      }
    }
    if (!listeRessourcesLieeADemandeMappee.isEmpty())
    {
      Iterator<?> iterRessourcesAssedic = listeRessourcesLieeADemandeMappee.iterator();
      while (iterRessourcesAssedic.hasNext())
      {
        Ressources ressource = (Ressources)iterRessourcesAssedic.next();
        individu.setRessourcesLieesADemande(ressource.getReferenceExterne(), ressource);
      }
    }
    individu.setRessourcesDdte(listeRessourcesDdteMappee);
  }
  
  private static Ressources mapperRessources(RessourceSpec ressourceV1)
  {
    Ressources ressourceCali = new Ressources();
    ressourceCali.setOrigine(ressourceV1.getOrigine());
    if (ressourceV1.getRessourcesAllocataire() != null) {
      ressourceCali.setRessourcesAllocataire(ressourceV1.getRessourcesAllocataire());
    }
    if (ressourceV1.getRessourcesConjoint() != null) {
      ressourceCali.setRessourcesConjoint(ressourceV1.getRessourcesConjoint());
    }
    if (ressourceV1.getMontant() != null) {
      ressourceCali.setMontantRessourcesMensuelles(ressourceV1.getMontant());
    }
    if (ressourceV1.getCodeSituationFamiliale().equals("S")) {
      ressourceCali.setSituationFamiliale(1);
    } else {
      ressourceCali.setSituationFamiliale(2);
    }
    ressourceCali.setDateFinPeriodeReference(ressourceV1.getDateReference());
    if (ressourceV1.getDateEffet() != null) {
      ressourceCali.setDateEffet(ressourceV1.getDateEffet());
    }
    if (ressourceV1.getReferenceExterne() != null) {
      ressourceCali.setReferenceExterne(ressourceV1.getReferenceExterne());
    }
    ressourceCali.setRang(ressourceV1.getRang());
    
    ressourceCali.setNombreEnfants(ressourceV1.getNombreEnfant());
    
    return ressourceCali;
  }
}

/* Location:
 * Qualified Name:     MapperRessources
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */