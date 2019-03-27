package fr.unedic.cali.utilitaire.filtres;

import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public abstract interface FiltreCaliSpec
  extends FiltreTemporel
{
  public static final int TOUT_TYPE = -1;
  public static final int SANS_OBJET = 0;
  public static final int TYPE_DECISION = 1;
  public static final int TYPE_DEMANDE = 2;
  public static final int TYPE_OBJET_CHRONO_PERIODE = 3;
  
  public abstract int getTypeElementManipule();
  
  public abstract boolean accepterElement(Temporel paramTemporel);
  
  public abstract void initialiserCache();
}

/* Location:
 * Qualified Name:     FiltreCaliSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */