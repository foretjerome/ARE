package fr.unedic.cali.utilitaire.filtres.generiques;

import fr.unedic.cali.dom.ClassementAdministratif;
import fr.unedic.cali.dom.ClassementAdministratifSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.util.temps.Temporel;

public class FiltreDemandePourClassement
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = 1L;
  private String classementRecherche;
  private boolean estClassementDoitEtreValide;
  
  public FiltreDemandePourClassement(String classement)
  {
    classementRecherche = classement;
  }
  
  public FiltreDemandePourClassement(String classementRecherche, boolean estClassementDoitEtreValide)
  {
    this.classementRecherche = classementRecherche;
    this.estClassementDoitEtreValide = estClassementDoitEtreValide;
  }
  
  public boolean accepterElement(Temporel temporel)
  {
    DemandeSpec demande = (DemandeSpec)temporel;
    boolean retour = false;
    boolean accepterClassement = true;
    boolean accepterTypeClassement = false;
    ClassementAdministratifSpec classementAdministratif = demande.getClassementAdministratif();
    if (classementAdministratif != null)
    {
      if (estClassementDoitEtreValide) {
        accepterClassement = classementAdministratif.estClassementValide();
      }
      if (classementRecherche.equals("tous classement")) {
        accepterTypeClassement = true;
      } else {
        accepterTypeClassement = demande.getClassementAdministratif().getTypeClassement().equalsIgnoreCase(classementRecherche);
      }
      retour = (accepterClassement) && (accepterTypeClassement);
    }
    return retour;
  }
  
  public int getTypeElementManipule()
  {
    return 2;
  }
}

/* Location:
 * Qualified Name:     FiltreDemandePourClassement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */