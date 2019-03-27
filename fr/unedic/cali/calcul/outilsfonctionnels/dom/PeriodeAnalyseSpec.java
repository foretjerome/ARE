package fr.unedic.cali.calcul.outilsfonctionnels.dom;

import fr.unedic.cali.calcul.dom.ConstituantsIndemnisation;
import fr.unedic.cali.calcul.dom.EvenementFinQuantiteDroit;
import fr.unedic.cali.calcul.dom.Somme;
import fr.unedic.util.Quantite;
import fr.unedic.util.Unite;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import fr.unedic.util.temps.Temporel;
import java.util.Collection;
import java.util.List;

public abstract interface PeriodeAnalyseSpec
  extends Temporel
{
  public abstract Periode getPeriode();
  
  public abstract Damj getDateDebut();
  
  public abstract void setDateDebut(Damj paramDamj);
  
  public abstract Damj getDateFin();
  
  public abstract void setDateFin(Damj paramDamj);
  
  public abstract int getDuree();
  
  public abstract ConstituantsIndemnisation getConstituantsIndemnisationEnDebutPA();
  
  public abstract ConstituantsIndemnisation getConstituantsIndemnisationEnFinPA();
  
  public abstract void setConstituantsIndemnisationEnDebutPA(ConstituantsIndemnisation paramConstituantsIndemnisation);
  
  public abstract void setConstituantsIndemnisationEnFinPA(ConstituantsIndemnisation paramConstituantsIndemnisation);
  
  public abstract List<Somme> getListeSommes();
  
  public abstract void setListeSommes(List<Somme> paramList);
  
  public abstract void setProduitATerminerApresUT(boolean paramBoolean);
  
  public abstract boolean isProduitATerminerApresPA();
  
  public abstract Collection<EvenementFinQuantiteDroit> getCollectionFinQuantiteDroit();
  
  public abstract void setCollectionFinQuantiteDroit(Collection<EvenementFinQuantiteDroit> paramCollection);
  
  public abstract void setNbJoursIndemnisesForce(boolean paramBoolean);
  
  public abstract boolean isNbJoursIndemnisesForce();
  
  public abstract Quantite getQuantiteIndemnisable();
  
  public abstract Quantite getQuantiteIndemnisee();
  
  public abstract Quantite getQuantiteNonIndemnisee();
  
  public abstract void setQuantiteIndemnisable(Quantite paramQuantite);
  
  public abstract void setQuantiteIndemnisee(Quantite paramQuantite);
  
  public abstract void setQuantiteNonIndemnisee(Quantite paramQuantite);
  
  public abstract Unite getUniteParDefautQuantites();
  
  public abstract void addEvenement(Temporel paramTemporel);
  
  public abstract void addEvenements(Collection<?> paramCollection);
  
  public abstract Collection<?> getEvenements();
  
  public abstract Quantite getQuantiteImputeeNonIndemnisee();
  
  public abstract void setQuantiteImputeeNonIndemnisee(Quantite paramQuantite);
  
  public abstract Quantite getQuantitePlafonnee();
  
  public abstract void setQuantitePlafonnee(Quantite paramQuantite);
  
  public abstract boolean isEstUnePaAvecPlafond();
  
  public abstract void setEstUnePaAvecPlafond(boolean paramBoolean);
  
  public abstract Quantite getQuantiteDecalee();
  
  public abstract void setQuantiteDecalee(Quantite paramQuantite);
  
  public abstract int getNbJoursAllongementAREF();
  
  public abstract void setNbJoursAllongementAREF(int paramInt);
}

/* Location:
 * Qualified Name:     PeriodeAnalyseSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */