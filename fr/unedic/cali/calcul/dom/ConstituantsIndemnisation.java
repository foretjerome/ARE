package fr.unedic.cali.calcul.dom;

import fr.unedic.cali.calcul.dom.gen.ConstituantsIndemnisationGen;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeHomogene;
import fr.unedic.cali.dom.CapitalIndemnisationAbstrait;
import fr.unedic.cali.dom.DureeDetectionMaintienAbstraite;
import fr.unedic.cali.dom.DureeFinancementAbstraite;
import fr.unedic.cali.dom.DureeIndemnisationAbstraite;
import fr.unedic.cali.dom.DureeNonIndemnisable;
import fr.unedic.cali.dom.DureeProlongationAbstraite;
import fr.unedic.cali.dom.DureeRenouvellementAbstraite;
import fr.unedic.cali.dom.ElementBaseIndemnisationSpec;
import fr.unedic.cali.dom.ObjetPersistantSpec;
import fr.unedic.cali.dom.QuantiteDroitSpec;
import fr.unedic.cali.dom.RemboursementFraisIndemnisationAbstrait;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ConstituantsIndemnisation
  extends ConstituantsIndemnisationGen
  implements ObjetPersistantSpec
{
  private static final long serialVersionUID = -9066498807862240210L;
  private transient Collection collectionQuantiteDroit = null;
  private transient ElementBaseIndemnisationSpec elementBaseIndemnisationCourant = null;
  private transient int cumulAR = 0;
  private transient BigDecimal cumulGainARsurUT = BigDecimal.ZERO;
  private transient BigDecimal cumulNbHeuresARsurUT = BigDecimal.ZERO;
  private transient BigDecimal montantServiNonCumule = BigDecimal.ZERO;
  private transient BigDecimal montantDeroNonCumule = BigDecimal.ZERO;
  private transient BigDecimal montantNonDeroNonCumule = BigDecimal.ZERO;
  
  public ConstituantsIndemnisation() {}
  
  public ConstituantsIndemnisation(DomPCSpec pc)
  {
    super(pc);
  }
  
  public Collection getCollectionQuantiteDroit()
  {
    if (collectionQuantiteDroit == null)
    {
      collectionQuantiteDroit = new ArrayList();
      if (getDureeIndemnisation() != null) {
        collectionQuantiteDroit.add(super.getDureeIndemnisation());
      }
      if (getDureeDetectionMaintien() != null) {
        collectionQuantiteDroit.add(super.getDureeDetectionMaintien());
      }
      if (getDureeRenouvellement() != null) {
        collectionQuantiteDroit.add(super.getDureeRenouvellement());
      }
      if (getFraisRemboursementIndemnisation() != null) {
        collectionQuantiteDroit.add(super.getFraisRemboursementIndemnisation());
      }
      if (getDureeProlongation() != null) {
        collectionQuantiteDroit.add(super.getDureeProlongation());
      }
      if (getCapitalIndemnisation() != null) {
        collectionQuantiteDroit.add(super.getCapitalIndemnisation());
      }
      if (getDureeFinancement() != null) {
        collectionQuantiteDroit.add(super.getDureeFinancement());
      }
    }
    return collectionQuantiteDroit;
  }
  
  public void setCollectionQuantiteDroit(Collection collectionQuantiteDroit)
  {
    Iterator iterator = null;
    QuantiteDroitSpec element = null;
    
    iterator = getCollectionQuantiteDroit().iterator();
    while (iterator.hasNext())
    {
      element = (QuantiteDroitSpec)iterator.next();
      if (collectionQuantiteDroit.contains(element))
      {
        collectionQuantiteDroit.remove(element);
      }
      else
      {
        iterator.remove();
        DomManager.supprimer(element);
        if ((element instanceof DureeIndemnisationAbstraite)) {
          setDureeIndemnisation(null);
        } else if ((element instanceof DureeRenouvellementAbstraite)) {
          setDureeRenouvellement(null);
        } else if ((element instanceof DureeDetectionMaintienAbstraite)) {
          setDureeDetectionMaintien(null);
        } else if ((element instanceof RemboursementFraisIndemnisationAbstrait)) {
          setFraisRemboursementIndemnisation(null);
        } else if ((element instanceof DureeProlongationAbstraite)) {
          setDureeProlongation(null);
        } else if ((element instanceof CapitalIndemnisationAbstrait)) {
          setCapitalIndemnisation(null);
        } else if ((element instanceof DureeFinancementAbstraite)) {
          setDureeFinancement(null);
        }
      }
    }
    List listeDureeIndemnisation = new ArrayList();
    List listeDureeRenouvellement = new ArrayList();
    List listeDureeDetectionMaintien = new ArrayList();
    List listeRemboursementFraisIndemnisation = new ArrayList();
    List listeDureeProlongation = new ArrayList();
    List listeCapitalIndemnisation = new ArrayList();
    List listeDureeFinancement = new ArrayList();
    
    DureeIndemnisationAbstraite dureeIndemnisation = null;
    DureeRenouvellementAbstraite dureeRenouvellement = null;
    DureeDetectionMaintienAbstraite dureeDetectionMaintien = null;
    RemboursementFraisIndemnisationAbstrait remboursementFraisIndemnisation = null;
    DureeProlongationAbstraite dureeProlongation = null;
    CapitalIndemnisationAbstrait capitalIndemnisationAbstrait = null;
    DureeFinancementAbstraite dureeFinancementAbstraite = null;
    
    iterator = collectionQuantiteDroit.iterator();
    while (iterator.hasNext())
    {
      QuantiteDroitSpec quantiteDroit = (QuantiteDroitSpec)iterator.next();
      if ((quantiteDroit instanceof DureeIndemnisationAbstraite))
      {
        listeDureeIndemnisation.add(quantiteDroit);
        if (dureeIndemnisation == null) {
          dureeIndemnisation = (DureeIndemnisationAbstraite)quantiteDroit;
        }
      }
      else if ((quantiteDroit instanceof DureeRenouvellementAbstraite))
      {
        listeDureeRenouvellement.add(quantiteDroit);
        if (dureeRenouvellement == null) {
          dureeRenouvellement = (DureeRenouvellementAbstraite)quantiteDroit;
        }
      }
      else if ((quantiteDroit instanceof DureeDetectionMaintienAbstraite))
      {
        listeDureeDetectionMaintien.add(quantiteDroit);
        if (dureeDetectionMaintien == null) {
          dureeDetectionMaintien = (DureeDetectionMaintienAbstraite)quantiteDroit;
        }
      }
      else if ((quantiteDroit instanceof RemboursementFraisIndemnisationAbstrait))
      {
        listeRemboursementFraisIndemnisation.add(quantiteDroit);
        if ((remboursementFraisIndemnisation == null) || (remboursementFraisIndemnisation.getPeriodeHomogene().getDateDebut().estApres(((RemboursementFraisIndemnisationAbstrait)quantiteDroit).getPeriodeHomogene().getDateDebut()))) {
          remboursementFraisIndemnisation = (RemboursementFraisIndemnisationAbstrait)quantiteDroit;
        }
      }
      else if ((quantiteDroit instanceof DureeProlongationAbstraite))
      {
        listeDureeProlongation.add(quantiteDroit);
        if (dureeProlongation == null) {
          dureeProlongation = (DureeProlongationAbstraite)quantiteDroit;
        }
      }
      else if ((quantiteDroit instanceof CapitalIndemnisationAbstrait))
      {
        listeCapitalIndemnisation.add(quantiteDroit);
        if (capitalIndemnisationAbstrait == null) {
          capitalIndemnisationAbstrait = (CapitalIndemnisationAbstrait)quantiteDroit;
        }
      }
      else if ((quantiteDroit instanceof DureeFinancementAbstraite))
      {
        listeDureeFinancement.add(quantiteDroit);
        if (dureeFinancementAbstraite == null) {
          dureeFinancementAbstraite = (DureeFinancementAbstraite)quantiteDroit;
        }
      }
    }
    ajouterQuantiteDroit(listeDureeIndemnisation, dureeIndemnisation);
    ajouterQuantiteDroit(listeDureeRenouvellement, dureeRenouvellement);
    ajouterQuantiteDroit(listeDureeDetectionMaintien, dureeDetectionMaintien);
    ajouterQuantiteDroit(listeRemboursementFraisIndemnisation, remboursementFraisIndemnisation);
    ajouterQuantiteDroit(listeDureeProlongation, dureeProlongation);
    ajouterQuantiteDroit(listeCapitalIndemnisation, capitalIndemnisationAbstrait);
    ajouterQuantiteDroit(listeDureeFinancement, dureeFinancementAbstraite);
  }
  
  public void ajouterQuantiteDroit(Collection listeQuantite, QuantiteDroitSpec quantiteDroitReference)
  {
    Iterator iterateurQuantites = listeQuantite.iterator();
    while (iterateurQuantites.hasNext())
    {
      QuantiteDroitSpec quantite = (QuantiteDroitSpec)iterateurQuantites.next();
      
      boolean estASauvegarder = true;
      
      getCollectionQuantiteDroit().add(quantite);
      if ((listeQuantite.size() > 1) && ((quantite instanceof RemboursementFraisIndemnisationAbstrait)) && (!((RemboursementFraisIndemnisationAbstrait)quantite).getPeriodeHomogene().getDateDebut().coincideAvec(((RemboursementFraisIndemnisationAbstrait)quantiteDroitReference).getPeriodeHomogene().getDateDebut()))) {
        estASauvegarder = false;
      }
      if ((listeQuantite.size() > 1) && ((quantite instanceof DureeIndemnisationAbstraite)) && (!quantite.getClass().equals(quantiteDroitReference.getClass()))) {
        estASauvegarder = false;
      }
      if (estASauvegarder) {
        if ((quantite instanceof DureeIndemnisationAbstraite)) {
          setDureeIndemnisation((DureeIndemnisationAbstraite)quantite);
        } else if ((quantite instanceof DureeRenouvellementAbstraite)) {
          setDureeRenouvellement((DureeRenouvellementAbstraite)quantite);
        } else if ((quantite instanceof DureeDetectionMaintienAbstraite)) {
          setDureeDetectionMaintien((DureeDetectionMaintienAbstraite)quantite);
        } else if ((quantite instanceof RemboursementFraisIndemnisationAbstrait)) {
          setFraisRemboursementIndemnisation((RemboursementFraisIndemnisationAbstrait)quantite);
        } else if ((quantite instanceof DureeProlongationAbstraite)) {
          setDureeProlongation((DureeProlongationAbstraite)quantite);
        } else if ((quantite instanceof CapitalIndemnisationAbstrait)) {
          setCapitalIndemnisation((CapitalIndemnisationAbstrait)quantite);
        } else if ((quantite instanceof DureeFinancementAbstraite)) {
          setDureeFinancement((DureeFinancementAbstraite)quantite);
        }
      }
    }
  }
  
  public void supprimerQuantiteDroit(QuantiteDroitSpec quantiteDroit)
  {
    getCollectionQuantiteDroit().remove(quantiteDroit);
    if ((quantiteDroit instanceof DureeIndemnisationAbstraite)) {
      setDureeIndemnisation(null);
    } else if ((quantiteDroit instanceof DureeRenouvellementAbstraite)) {
      setDureeRenouvellement(null);
    } else if ((quantiteDroit instanceof DureeDetectionMaintienAbstraite)) {
      setDureeDetectionMaintien(null);
    } else if ((quantiteDroit instanceof RemboursementFraisIndemnisationAbstrait)) {
      setFraisRemboursementIndemnisation(null);
    } else if ((quantiteDroit instanceof DureeProlongationAbstraite)) {
      setDureeProlongation(null);
    } else if ((quantiteDroit instanceof CapitalIndemnisationAbstrait)) {
      setCapitalIndemnisation(null);
    } else if ((quantiteDroit instanceof DureeFinancementAbstraite)) {
      setDureeFinancement(null);
    }
    DomManager.supprimer(quantiteDroit);
  }
  
  public void setDureeIndemnisation(DureeIndemnisationAbstraite dureeIndemnisation)
  {
    DomManager.supprimer(super.getDureeIndemnisation(), dureeIndemnisation);
    super.setDureeIndemnisation(dureeIndemnisation);
  }
  
  public void setDureeRenouvellement(DureeRenouvellementAbstraite dureeRenouvellement)
  {
    DomManager.supprimer(super.getDureeRenouvellement(), dureeRenouvellement);
    super.setDureeRenouvellement(dureeRenouvellement);
  }
  
  public void setDureeDetectionMaintien(DureeDetectionMaintienAbstraite dureeDetectionMaintien)
  {
    DomManager.supprimer(super.getDureeDetectionMaintien(), dureeDetectionMaintien);
    super.setDureeDetectionMaintien(dureeDetectionMaintien);
  }
  
  public void setFraisRemboursementIndemnisation(RemboursementFraisIndemnisationAbstrait fraisRemboursementIndemnisation)
  {
    DomManager.supprimer(super.getFraisRemboursementIndemnisation(), fraisRemboursementIndemnisation);
    super.setFraisRemboursementIndemnisation(fraisRemboursementIndemnisation);
  }
  
  public void setDureeProlongation(DureeProlongationAbstraite dureeProlongation)
  {
    DomManager.supprimer(super.getDureeProlongation(), dureeProlongation);
    super.setDureeProlongation(dureeProlongation);
  }
  
  public void setCapitalIndemnisation(CapitalIndemnisationAbstrait capitalIndemnisation)
  {
    DomManager.supprimer(super.getCapitalIndemnisation(), capitalIndemnisation);
    super.setCapitalIndemnisation(capitalIndemnisation);
  }
  
  public void setDureeFinancement(DureeFinancementAbstraite dureeFinancement)
  {
    DomManager.supprimer(super.getDureeFinancement(), dureeFinancement);
    super.setDureeFinancement(dureeFinancement);
  }
  
  public void setElementBaseIndemnisationCourant(ElementBaseIndemnisationSpec eBICourant)
  {
    elementBaseIndemnisationCourant = eBICourant;
  }
  
  public ElementBaseIndemnisationSpec getElementBaseIndemnisationCourant()
  {
    return elementBaseIndemnisationCourant;
  }
  
  public String toString()
  {
    StringBuffer string = new StringBuffer();
    
    string.append("\nFormule Montant : " + getCodeFormuleMontant() + "\n");
    
    string.append("\n-------------------- DEBUT QUANTITE DROIT --------------------");
    
    Iterator iterator = getCollectionQuantiteDroit().iterator();
    while (iterator.hasNext()) {
      string.append("\n" + iterator.next().toString() + "\n");
    }
    string.append("\n--------------------  FIN QUANTITE DROIT  --------------------");
    
    string.append("\n" + getElementBaseIndemnisationCourant());
    
    return string.toString();
  }
  
  public String getIdentifiant()
  {
    return DomManager.getIdentifiant(this);
  }
  
  public void jdoPostLoad() {}
  
  public void jdoPreStore() {}
  
  public void jdoPreClear() {}
  
  public void jdoPreDelete()
  {
    DomManager.supprimer(super.getDureeIndemnisation());
    DomManager.supprimer(super.getDureeRenouvellement());
    DomManager.supprimer(super.getDureeDetectionMaintien());
    DomManager.supprimer(super.getFraisRemboursementIndemnisation());
    DomManager.supprimer(super.getDureeProlongation());
    DomManager.supprimer(super.getCapitalIndemnisation());
    DomManager.supprimer(super.getDureeFinancement());
  }
  
  public void marquerGraphePersistant()
  {
    DomManager.persisterEnProfondeur(super.getDureeIndemnisation());
    DomManager.persisterEnProfondeur(super.getDureeRenouvellement());
    DomManager.persisterEnProfondeur(super.getDureeDetectionMaintien());
    DomManager.persisterEnProfondeur(super.getFraisRemboursementIndemnisation());
    DomManager.persisterEnProfondeur(super.getDureeProlongation());
    DomManager.persisterEnProfondeur(super.getCapitalIndemnisation());
    DomManager.persisterEnProfondeur(super.getDureeFinancement());
    DomManager.persisterEnProfondeur(super.getCollectionListeDureeNonIndemnisables());
  }
  
  public void remplacerCollectionListeDureeNonIndemnisables(Collection collectionACopier)
  {
    for (Iterator iter = super.getCollectionListeDureeNonIndemnisables().iterator(); iter.hasNext();)
    {
      DureeNonIndemnisable element = (DureeNonIndemnisable)iter.next();
      DomManager.supprimer(element);
    }
    super.remplacerCollectionListeDureeNonIndemnisables(collectionACopier);
  }
  
  public ObjetMetierSpec copie()
  {
    ConstituantsIndemnisation copie = new ConstituantsIndemnisation();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec paramCopie)
  {
    ConstituantsIndemnisation copie = (ConstituantsIndemnisation)paramCopie;
    copie.setCodeFormuleMontant(getCodeFormuleMontant());
    if (getElementBaseIndemnisationCourant() != null) {
      copie.setElementBaseIndemnisationCourant((ElementBaseIndemnisationSpec)getElementBaseIndemnisationCourant().copie());
    }
    if (getDureeDetectionMaintien() != null) {
      copie.setDureeDetectionMaintien((DureeDetectionMaintienAbstraite)getDureeDetectionMaintien().copie());
    }
    if (getDureeRenouvellement() != null) {
      copie.setDureeRenouvellement((DureeRenouvellementAbstraite)getDureeRenouvellement().copie());
    }
    if (getFraisRemboursementIndemnisation() != null) {
      copie.setFraisRemboursementIndemnisation((RemboursementFraisIndemnisationAbstrait)getFraisRemboursementIndemnisation().copie());
    }
    if (getDureeIndemnisation() != null) {
      copie.setDureeIndemnisation((DureeIndemnisationAbstraite)getDureeIndemnisation().copie());
    }
    if (getCapitalIndemnisation() != null) {
      copie.setCapitalIndemnisation((CapitalIndemnisationAbstrait)getCapitalIndemnisation().copie());
    }
    if (getDureeFinancement() != null) {
      copie.setDureeFinancement((DureeFinancementAbstraite)getDureeFinancement().copie());
    }
    List listeDureeIndemnisation = new ArrayList();
    List listeDureeRenouvellement = new ArrayList();
    List listeDureeDetectionMaintien = new ArrayList();
    List listeRemboursementFraisIndemnisation = new ArrayList();
    List listeDureeProlongation = new ArrayList();
    List listeCapitalIndemnisation = new ArrayList();
    List listeDureeFinancement = new ArrayList();
    
    DureeIndemnisationAbstraite dureeIndemnisation = null;
    DureeRenouvellementAbstraite dureeRenouvellement = null;
    DureeDetectionMaintienAbstraite dureeDetectionMaintien = null;
    RemboursementFraisIndemnisationAbstrait remboursementFraisIndemnisation = null;
    DureeProlongationAbstraite dureeProlongation = null;
    CapitalIndemnisationAbstrait capitalIndemnisationAbstrait = null;
    DureeFinancementAbstraite dureeFinancementAbstraite = null;
    
    Iterator iterator = getCollectionQuantiteDroit().iterator();
    copie.setCollectionQuantiteDroit(new ArrayList());
    while (iterator.hasNext())
    {
      QuantiteDroitSpec element = (QuantiteDroitSpec)iterator.next();
      if ((element != null) && (element.getEtat() != 2)) {
        if ((element instanceof DureeIndemnisationAbstraite))
        {
          listeDureeIndemnisation.add(element.copie());
          if (dureeIndemnisation == null) {
            dureeIndemnisation = (DureeIndemnisationAbstraite)element.copie();
          }
          if (listeDureeIndemnisation.size() > 1) {
            dureeIndemnisation = getDureeIndemnisation();
          }
        }
        else if ((element instanceof DureeRenouvellementAbstraite))
        {
          listeDureeRenouvellement.add(element.copie());
          if (dureeRenouvellement == null) {
            dureeRenouvellement = (DureeRenouvellementAbstraite)element.copie();
          }
        }
        else if ((element instanceof DureeDetectionMaintienAbstraite))
        {
          listeDureeDetectionMaintien.add(element.copie());
          if (dureeDetectionMaintien == null) {
            dureeDetectionMaintien = (DureeDetectionMaintienAbstraite)element.copie();
          }
        }
        else if ((element instanceof RemboursementFraisIndemnisationAbstrait))
        {
          listeRemboursementFraisIndemnisation.add(element.copie());
          if ((remboursementFraisIndemnisation == null) || (remboursementFraisIndemnisation.getPeriodeHomogene().getDateDebut().estApres(((RemboursementFraisIndemnisationAbstrait)element).getPeriodeHomogene().getDateDebut()))) {
            remboursementFraisIndemnisation = (RemboursementFraisIndemnisationAbstrait)element.copie();
          }
        }
        else if ((element instanceof DureeProlongationAbstraite))
        {
          listeDureeProlongation.add(element.copie());
          if (dureeProlongation == null) {
            dureeProlongation = (DureeProlongationAbstraite)element.copie();
          }
        }
        else if ((element instanceof CapitalIndemnisationAbstrait))
        {
          listeCapitalIndemnisation.add(element.copie());
          if (capitalIndemnisationAbstrait == null) {
            capitalIndemnisationAbstrait = (CapitalIndemnisationAbstrait)element.copie();
          }
        }
        else if ((element instanceof DureeFinancementAbstraite))
        {
          listeDureeFinancement.add(element.copie());
          if (dureeFinancementAbstraite == null) {
            dureeFinancementAbstraite = (DureeFinancementAbstraite)element.copie();
          }
        }
      }
    }
    copie.ajouterQuantiteDroit(listeDureeIndemnisation, dureeIndemnisation);
    copie.ajouterQuantiteDroit(listeDureeRenouvellement, dureeRenouvellement);
    copie.ajouterQuantiteDroit(listeDureeDetectionMaintien, dureeDetectionMaintien);
    copie.ajouterQuantiteDroit(listeRemboursementFraisIndemnisation, remboursementFraisIndemnisation);
    copie.ajouterQuantiteDroit(listeDureeProlongation, dureeProlongation);
    copie.ajouterQuantiteDroit(listeCapitalIndemnisation, capitalIndemnisationAbstrait);
    copie.ajouterQuantiteDroit(listeDureeFinancement, dureeFinancementAbstraite);
    
    copie.setCumulAR(getCumulAR());
    if (getCumulGainARsurUT() != null) {
      copie.setCumulGainARsurUT(getCumulGainARsurUT());
    }
    if (getCumulNbHeuresARsurUT() != null) {
      copie.setCumulNbHeuresARsurUT(getCumulNbHeuresARsurUT());
    }
    if (getMontantServi() != null) {
      copie.setMontantServi(getMontantServi());
    }
    if (getMontantIndemNonDerog() != null) {
      copie.setMontantIndemNonDerog(getMontantIndemNonDerog());
    }
    if (getMontantIndemDerog() != null) {
      copie.setMontantIndemDerog(getMontantIndemDerog());
    }
    if (getDateFinDispositifCSP() != null) {
      copie.setDateFinDispositifCSP(getDateFinDispositifCSP());
    }
    copie.setRangTranche(getRangTranche());
    
    Iterator<DureeNonIndemnisable> iteDureeNi = getListListeDureeNonIndemnisables().iterator();
    while (iteDureeNi.hasNext()) {
      copie.ajouterListeDureeNonIndemnisables((DureeNonIndemnisable)((DureeNonIndemnisable)iteDureeNi.next()).copie());
    }
    copie.setCumulTotalAllongementAREF(getCumulTotalAllongementAREF());
  }
  
  public int getCumulAR()
  {
    return cumulAR;
  }
  
  public void setCumulAR(int paramCumulAR)
  {
    cumulAR = paramCumulAR;
  }
  
  public BigDecimal getCumulGainARsurUT()
  {
    return cumulGainARsurUT;
  }
  
  public void setCumulGainARsurUT(BigDecimal paramCumulGainARsurUT)
  {
    cumulGainARsurUT = paramCumulGainARsurUT;
  }
  
  public BigDecimal getCumulNbHeuresARsurUT()
  {
    return cumulNbHeuresARsurUT;
  }
  
  public void setCumulNbHeuresARsurUT(BigDecimal cumulNbHeuresARUT)
  {
    cumulNbHeuresARsurUT = cumulNbHeuresARUT;
  }
  
  public BigDecimal getMontantServiNonCumule()
  {
    return montantServiNonCumule;
  }
  
  public void setMontantServiNonCumule(BigDecimal montantServiNonCumul)
  {
    montantServiNonCumule = montantServiNonCumul;
  }
  
  public BigDecimal getMontantDeroNonCumule()
  {
    return montantDeroNonCumule;
  }
  
  public void setMontantDeroNonCumule(BigDecimal montantDeroNonCumul)
  {
    montantDeroNonCumule = montantDeroNonCumul;
  }
  
  public BigDecimal getMontantNonDeroNonCumule()
  {
    return montantNonDeroNonCumule;
  }
  
  public void setMontantNonDeroNonCumule(BigDecimal montantNonDeroNonCumul)
  {
    montantNonDeroNonCumule = montantNonDeroNonCumul;
  }
}

/* Location:
 * Qualified Name:     ConstituantsIndemnisation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */