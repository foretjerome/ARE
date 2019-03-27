package fr.pe.cali.reglementaire.decors.fabrique;

import fr.pe.cali.reglementaire.decors.produitsreglementaires.ProduitReglementaire;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.ReferentielProduitReglementaire;
import fr.pe.cali.reglementaire.dom.impl.CriteresFabriqueReglementaire;
import fr.pe.cali.reglementaire.outils.logs.OutilLog;
import fr.pe.cali.reglementaire.outils.spec.IOutilCorpsRegle;
import java.util.Collection;

public abstract class FabriqueCorpsRegle
{
  private static final String NOM_ELEMENT = "Nom CR";
  private String nomCorpsRegle;
  private OutilLog outilLog;
  
  protected FabriqueCorpsRegle()
  {
    outilLog = new OutilLog();
  }
  
  protected IOutilCorpsRegle recupererOutilCorpsRegle(CriteresFabriqueReglementaire criteres)
  {
    gererLogPourEntreeDansLaFabrique(criteres);
    ProduitReglementaire produitReglementaire = recupererProduitReglementaire(criteres.getCodeProduit());
    StringBuffer traceLog = initialiserTraceLogResultat(produitReglementaire);
    IOutilCorpsRegle outil = produitReglementaire.recupererOutilReglementaire(getNomCorpsRegle(), criteres, traceLog);
    gererLogPourSortieDeLaFabrique(traceLog, outil);
    return outil;
  }
  
  protected ProduitReglementaire recupererProduitReglementaire(String codeProduit)
  {
    return ReferentielProduitReglementaire.getInstance().recupererProduitReglementaire(codeProduit);
  }
  
  protected void verifierCoherence()
  {
    Collection<ProduitReglementaire> listeProduits = ReferentielProduitReglementaire.getInstance().getListeProduitReglementaire();
    for (ProduitReglementaire produitCourant : listeProduits) {
      produitCourant.verifierCoherenceListeChangement();
    }
  }
  
  protected void desactiverTraceLog()
  {
    outilLog.desactiverLog();
  }
  
  protected void gererLogPourEntreeDansLaFabrique(CriteresFabriqueReglementaire criteres)
  {
    if (outilLog.isLogActive()) {
      OutilLog.ecrireTrace(OutilLog.formaterDonneesEnEntreeFabrique(formaterDonneesEnEntree(criteres)));
    }
  }
  
  protected String formaterDonneesEnEntree(CriteresFabriqueReglementaire criteres)
  {
    StringBuffer buffer = new StringBuffer();
    buffer.append(this);
    buffer.append(criteres);
    return buffer.toString();
  }
  
  protected StringBuffer initialiserTraceLogResultat(ProduitReglementaire produit)
  {
    StringBuffer buffer = null;
    if (outilLog.isLogActive())
    {
      buffer = new StringBuffer();
      buffer.append(produit);
    }
    return buffer;
  }
  
  protected void gererLogPourSortieDeLaFabrique(StringBuffer buffer, IOutilCorpsRegle outil)
  {
    if (outilLog.isLogActive()) {
      OutilLog.ecrireTrace(OutilLog.formaterDonneesResultatFabrique(formaterResultat(buffer, outil)));
    }
  }
  
  protected String formaterResultat(StringBuffer buffer, IOutilCorpsRegle outil)
  {
    buffer.append(OutilLog.formaterOutilReglementaire(outil));
    return buffer.toString();
  }
  
  public String toString()
  {
    return OutilLog.formaterElement("Nom CR", getNomCorpsRegle());
  }
  
  protected String getNomCorpsRegle()
  {
    return nomCorpsRegle;
  }
  
  protected void setNomCorpsRegle(String nomCorpsRegle)
  {
    this.nomCorpsRegle = nomCorpsRegle;
  }
}

/* Location:
 * Qualified Name:     FabriqueCorpsRegle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */