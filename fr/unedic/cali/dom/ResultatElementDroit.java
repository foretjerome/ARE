package fr.unedic.cali.dom;

import fr.unedic.cali.dom.gen.ResultatElementDroitGen;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;

public class ResultatElementDroit
  extends ResultatElementDroitGen
  implements ObjetMetierSpec
{
  public static final int SATISFAIT = 0;
  public static final int NON_SATISFAIT = 1;
  public static final int SANS_OBJET = 2;
  
  public ResultatElementDroit()
  {
    setCodeMotifEchec(0);
    setEtat(2);
  }
  
  public ResultatElementDroit(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public boolean estSatisfait()
  {
    return getEtat() == 0;
  }
  
  public void setEtatSatisfait(boolean p_etatSatisfait)
  {
    if (p_etatSatisfait) {
      setEtat(0);
    } else {
      setEtat(1);
    }
  }
  
  public String toString()
  {
    StringBuffer trace = new StringBuffer();
    trace.append("Etat : " + estSatisfait());
    if (getEtat() == 1) {
      trace.append("\nMotif Echec : " + getCodeMotifEchec());
    }
    return trace.toString();
  }
  
  public ObjetMetierSpec copie()
  {
    ResultatElementDroit copie = new ResultatElementDroit();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    ResultatElementDroit copie = (ResultatElementDroit)p_copie;
    copie.setCodeMotifEchec(getCodeMotifEchec());
    copie.setEtat(getEtat());
  }
}

/* Location:
 * Qualified Name:     ResultatElementDroit
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */