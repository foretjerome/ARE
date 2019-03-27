package fr.unedic.cali.outilsfonctionnels.reexecution;

import fr.unedic.cali.autresdoms.d90.dom.Individu;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.ElementComparaisonReexamen;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class ResultatGestionnaireReexecution
  implements ResultatGestionnaireReexecutionSpec
{
  private Collection<DemandeSpec> demandesReliquidees;
  private Collection<AttributionSpec> attributionsReexecutees;
  private Individu individuVisu;
  private Damj dateReexecution;
  private boolean demandeEnReexamen = false;
  private HashMap<DemandeSpec, List<ElementComparaisonReexamen>> resultatLiquidationSurDemande;
  
  public ResultatGestionnaireReexecution()
  {
    demandesReliquidees = new ArrayList();
    attributionsReexecutees = new ArrayList();
    resultatLiquidationSurDemande = new HashMap();
  }
  
  public Collection<DemandeSpec> getDemandesReliquidees()
  {
    return demandesReliquidees;
  }
  
  public Collection<AttributionSpec> getAttributionsReexecutees()
  {
    return attributionsReexecutees;
  }
  
  public Individu getIndividuVisu()
  {
    return individuVisu;
  }
  
  protected void setIndividuVisu(Individu individu)
  {
    individuVisu = individu;
  }
  
  public Damj getDateReexecution()
  {
    return dateReexecution;
  }
  
  protected void setDateReexecution(Damj dateReexecution)
  {
    this.dateReexecution = dateReexecution;
  }
  
  public boolean isDemandeEnReexamen()
  {
    return demandeEnReexamen;
  }
  
  public void setDemandeEnReexamen(boolean demandeEnReexamen)
  {
    this.demandeEnReexamen = demandeEnReexamen;
  }
  
  public HashMap<DemandeSpec, List<ElementComparaisonReexamen>> getResultatLiquidationSurDemande()
  {
    return resultatLiquidationSurDemande;
  }
}

/* Location:
 * Qualified Name:     ResultatGestionnaireReexecution
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */