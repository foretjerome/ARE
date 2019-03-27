package fr.unedic.cali.outilsfonctionnels.cohabitation.sigma.tranchedevie;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.autresdoms.cohab.sigma.tranchedevie.dom.InfoTrancheDeVie;
import fr.unedic.cali.autresdoms.cohab.sigma.tranchedevie.dom.StructureInTrancheDeVie;
import fr.unedic.cali.autresdoms.cohab.sigma.tranchedevie.dom.spec.CriteresTrancheDeVieSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.tranchedevie.dom.spec.InfoTrancheDeVieSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.tranchedevie.dom.spec.StructureInTrancheDeVieSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.tranchedevie.dom.spec.StructureOutTrancheDeVieSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import java.math.BigDecimal;

public class LectureTrancheDeVie
{
  public InfoTrancheDeVieSpec lireTrancheDeVie(CriteresTrancheDeVieSpec crit)
    throws CoucheLogiqueException, TechniqueException
  {
    StructureInTrancheDeVieSpec structIn = creerStructureIn(crit);
    StructureOutTrancheDeVieSpec structOut = getOutilFonctionnel().lireTrancheDeVie(structIn);
    return creerTrancheDeVie(structOut);
  }
  
  public AppelTrancheDeVie getOutilFonctionnel()
  {
    return new AppelTrancheDeVie();
  }
  
  private InfoTrancheDeVieSpec creerTrancheDeVie(StructureOutTrancheDeVieSpec structOut)
  {
    InfoTrancheDeVieSpec tdvOut = new InfoTrancheDeVie();
    
    tdvOut.setCodeAntenne(structOut.getCodeAntenne());
    tdvOut.setCodeAssedic(structOut.getCodeAssedic());
    tdvOut.setIdentifiantBNI(formateCXALA(structOut.getIdentifiantBNI()));
    tdvOut.setIdentifiantDNA(structOut.getIdentifiantDNA());
    tdvOut.setIdentifiantNCP(structOut.getIdentifiantNCP());
    tdvOut.setRSIN(structOut.getRSIN());
    tdvOut.setTopReferent(formateTop(structOut.getTopReferent()));
    
    return tdvOut;
  }
  
  private Boolean formateTop(String topReferent)
  {
    return new Boolean("O".equals(topReferent));
  }
  
  private String formateCXALA(BigDecimal identifiantBNI)
  {
    String out = identifiantBNI.toString();
    String pattern = "0000000000";
    
    return pattern.substring(out.length()) + out;
  }
  
  private StructureInTrancheDeVieSpec creerStructureIn(CriteresTrancheDeVieSpec crit)
  {
    StructureInTrancheDeVieSpec structIn = new StructureInTrancheDeVie();
    
    structIn.setCodeAssedic(crit.getCodeAssedic());
    structIn.setRSIN(crit.getRSIN());
    structIn.setIdentifiantNCP(crit.getIdentifiantNCP());
    
    return structIn;
  }
}

/* Location:
 * Qualified Name:     LectureTrancheDeVie
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */