package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.util.Mathematiques;
import java.math.BigDecimal;

public class OutilCalculEstimationCotisationsSociales
{
  private static final BigDecimal SEUIL_EXONERATION = new BigDecimal("50");
  private static final BigDecimal ABATTEMENT_ASSIETTE = new BigDecimal("0.9825");
  private static final BigDecimal TAUX_CSG = new BigDecimal("0.062");
  private static final BigDecimal TAUX_CRDS = new BigDecimal("0.005");
  private static final BigDecimal TAUX_CCAM = new BigDecimal("0.015");
  private static final BigDecimal ZERO = new BigDecimal("0");
  
  public static BigDecimal calculerCsg(BigDecimal p_montantBrut, BigDecimal p_crc)
  {
    BigDecimal montantBrut = getMontantBrut(p_montantBrut, p_crc);
    BigDecimal assiette = getAssiette(montantBrut);
    BigDecimal montantTheorique = getPrelevementTheorique(assiette, TAUX_CSG);
    
    BigDecimal baseExoneration = montantBrut;
    BigDecimal baseNonExoneration = baseExoneration.subtract(montantTheorique);
    BigDecimal montantEffectif = getMontantEffectif(baseExoneration, baseNonExoneration, montantTheorique);
    
    return montantEffectif;
  }
  
  public static BigDecimal calculerCrds(BigDecimal p_montantBrut, BigDecimal p_crc, BigDecimal p_csg)
  {
    BigDecimal montantBrut = getMontantBrut(p_montantBrut, p_crc);
    BigDecimal assiette = getAssiette(montantBrut);
    BigDecimal montantTheorique = getPrelevementTheorique(assiette, TAUX_CRDS);
    
    BigDecimal baseExoneration = montantBrut.subtract(p_csg);
    BigDecimal baseNonExoneration = baseExoneration.subtract(montantTheorique);
    BigDecimal montantEffectif = getMontantEffectif(baseExoneration, baseNonExoneration, montantTheorique);
    
    return montantEffectif;
  }
  
  public static BigDecimal calculerCcam(BigDecimal p_montantBrut, BigDecimal p_crc, BigDecimal p_csg, BigDecimal p_crds, boolean p_topAlsaceMoselle)
  {
    BigDecimal montantEffectif = ZERO;
    if (p_topAlsaceMoselle)
    {
      BigDecimal montantBrut = getMontantBrut(p_montantBrut, p_crc);
      BigDecimal assiette = getAssiette(montantBrut);
      BigDecimal montantTheorique = getPrelevementTheorique(assiette, TAUX_CCAM);
      
      BigDecimal baseExoneration = montantBrut.subtract(p_csg).subtract(p_crds);
      BigDecimal baseNonExoneration = baseExoneration.subtract(montantTheorique);
      montantEffectif = getMontantEffectif(baseExoneration, baseNonExoneration, montantTheorique);
    }
    return montantEffectif;
  }
  
  public static BigDecimal calculerMontantNet(BigDecimal p_montantBrut, BigDecimal p_crc, BigDecimal p_csg, BigDecimal p_crds, BigDecimal p_ccam)
  {
    return p_montantBrut.subtract(p_crc).subtract(p_csg).subtract(p_crds).subtract(p_ccam);
  }
  
  private static BigDecimal getMontantEffectif(BigDecimal p_baseExoneration, BigDecimal p_baseNonExoneration, BigDecimal p_montantTheorique)
  {
    BigDecimal montantEffectif = ZERO;
    if (SEUIL_EXONERATION.compareTo(p_baseExoneration) >= 0) {
      montantEffectif = ZERO;
    } else if (SEUIL_EXONERATION.compareTo(p_baseNonExoneration) <= 0) {
      montantEffectif = p_montantTheorique;
    } else {
      montantEffectif = p_baseExoneration.subtract(SEUIL_EXONERATION);
    }
    return montantEffectif;
  }
  
  private static BigDecimal getMontantBrut(BigDecimal p_montantBrut, BigDecimal p_crc)
  {
    return p_montantBrut.subtract(p_crc);
  }
  
  private static BigDecimal getAssiette(BigDecimal p_montantBrut)
  {
    return p_montantBrut.multiply(ABATTEMENT_ASSIETTE);
  }
  
  private static BigDecimal getPrelevementTheorique(BigDecimal p_assiette, BigDecimal p_taux)
  {
    return Mathematiques.arrondiASup(p_assiette.multiply(p_taux), 2);
  }
}

/* Location:
 * Qualified Name:     OutilCalculEstimationCotisationsSociales
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */