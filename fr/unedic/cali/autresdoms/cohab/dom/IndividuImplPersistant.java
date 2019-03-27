package fr.unedic.cali.autresdoms.cohab.dom;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.cohab.mapping.MapperIndividuGroupe;
import fr.unedic.cali.autresdoms.cohab.sigma.servicecali.dom.ResultatServiceCaliV1;
import fr.unedic.cali.dom.FormulaireSpec;
import fr.unedic.cali.dom.IndividuChargementSpec;
import fr.unedic.cali.dom.IndividuIdSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.outilsfonctionnels.AppelServicesCojac;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.CoucheLogiqueException;
import java.util.Collection;
import java.util.Iterator;

public class IndividuImplPersistant
  extends IndividuCohabAbstrait
{
  public IndividuImplPersistant(IndividuIdSpec individuIdSpec)
  {
    super(individuIdSpec);
    
    setEstModifiable(false);
    setEstCharge(false);
  }
  
  private ContexteService getContexteService()
  {
    return getIndividuId().getIndividu().getContexteService();
  }
  
  public IndividuChargementSpec charger()
    throws ApplicativeException, TechniqueException
  {
    IndividuCohabAbstrait individu = this;
    
    ResultatServiceCaliV1 resultatServiceIndividuCojac = AppelServicesCojac.lireIndividuGlobal(getNumeroAllocataire(), getContexteService());
    MapperIndividuGroupe.mapperIndividuGroupe(individu, resultatServiceIndividuCojac);
    
    setEstCharge(true);
    return this;
  }
  
  private String getNumeroAllocataire()
  {
    String numeroAllocataire = null;
    if (getIndividuId() != null) {
      numeroAllocataire = getIndividuId().toString();
    }
    return numeroAllocataire;
  }
  
  public FormulaireSpec getFormulaire(fr.unedic.cali.dom.DemandeSpec demandeSpec)
  {
    FormulaireSpec formulaire = null;
    
    fr.unedic.cali.autresdoms.cohab.sigma.demande.dom.spec.DemandeSpec demande = null;
    boolean bFound = false;
    Collection listeDemandesCojac = getDemandes();
    if (listeDemandesCojac != null)
    {
      Iterator iterDemandesCojac = listeDemandesCojac.iterator();
      while ((iterDemandesCojac.hasNext()) && (!bFound))
      {
        demande = (fr.unedic.cali.autresdoms.cohab.sigma.demande.dom.spec.DemandeSpec)iterDemandesCojac.next();
        if ((getNumeroAllocataire().equals(demandeSpec.getDemandeur().getNumeroAllocataire())) && (demandeSpec.getFormulaire().getReferenceExterne().equals(demande.getIdentifiantDemande())))
        {
          bFound = true;
          String sGamme = demande.getGamme();
          if ((sGamme != null) && (!sGamme.trim().equals("")))
          {
            GammeSpec gamme = Parametres.getGamme(sGamme);
            if (gamme != null) {
              formulaire = gamme.creerFormulaire(demande);
            }
          }
        }
      }
    }
    return formulaire;
  }
  
  public LireEnveloppeAidesResultat getEnveloppeAides(CriteresCaliServiceEnveloppe criteres)
    throws CoucheLogiqueException
  {
    LireEnveloppeAidesResultat enveloppeAides = super.getEnveloppeAides(criteres);
    if (enveloppeAides == null)
    {
      enveloppeAides = AppelServicesCojac.verifierEngagementMontantAides(criteres);
      setEnveloppeAides(enveloppeAides);
    }
    return enveloppeAides;
  }
}

/* Location:
 * Qualified Name:     IndividuImplPersistant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */