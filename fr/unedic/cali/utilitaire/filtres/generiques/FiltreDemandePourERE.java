package fr.unedic.cali.utilitaire.filtres.generiques;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.EvenementReferenceExamenSpec;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.util.temps.Temporel;

public class FiltreDemandePourERE
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = 1L;
  private String m_typeExamen;
  
  public FiltreDemandePourERE(String p_typeExamen)
  {
    m_typeExamen = p_typeExamen;
  }
  
  public boolean accepterElement(Temporel p_temporel)
  {
    DemandeSpec demande = (DemandeSpec)p_temporel;
    String typeExamen = demande.getEvenementReferenceExamen().getTypeExamen();
    return m_typeExamen.equals(typeExamen);
  }
  
  public int getTypeElementManipule()
  {
    return 2;
  }
}

/* Location:
 * Qualified Name:     FiltreDemandePourERE
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */