package fr.unedic.cali.dom;

import fr.unedic.util.temps.Damj;

public class Retraite
{
  private Damj date;
  private int type;
  private String motif;
  public static final int BASE = 1;
  public static final int ANTICIPE = 2;
  public static final String MOTIF_AUCUN = "0";
  public static final String MOTIF_PENIBILITE = "PEN";
  public static final String MOTIF_CARRIERE_LONGUE = "LON";
  public static final String MOTIF_TRAVAILLEURS_HANDICAPES = "HAN";
  public static final String MOTIF_INCAPACITE_PERMATENTE = "INC";
  public static final String MOTIF_AMIANTE = "AMI";
  
  public Retraite(Damj date, int type)
  {
    this.date = date;
    this.type = type;
    motif = "0";
  }
  
  public Retraite(Damj date, int type, String motif)
  {
    this.date = date;
    this.type = type;
    this.motif = motif;
  }
  
  public boolean estTypeBase()
  {
    return type == 1;
  }
  
  public boolean estTypeAnticipe()
  {
    return type == 2;
  }
  
  public Damj getDate()
  {
    return date;
  }
  
  public void setDate(Damj date)
  {
    this.date = date;
  }
  
  public int getType()
  {
    return type;
  }
  
  public void setType(int type)
  {
    this.type = type;
  }
  
  public String getMotif()
  {
    String res = "";
    if (motif.equals("AMI")) {
      res = "OV";
    } else if (motif.equals("LON")) {
      res = "OT";
    } else if (motif.equals("INC")) {
      res = "OX";
    } else if (motif.equals("PEN")) {
      res = "OU";
    } else if (motif.equals("HAN")) {
      res = "OW";
    }
    return res;
  }
  
  public void setMotif(String motif)
  {
    this.motif = motif;
  }
}

/* Location:
 * Qualified Name:     Retraite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */