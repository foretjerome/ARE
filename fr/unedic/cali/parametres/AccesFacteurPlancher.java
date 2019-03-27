package fr.unedic.cali.parametres;

import fr.unedic.cali.util.ParametresAbstrait;
import java.math.BigDecimal;
import java.util.Hashtable;

public class AccesFacteurPlancher
  extends ParametresAbstrait
{
  private static AccesFacteurPlancher instance;
  
  public AccesFacteurPlancher()
  {
    initialiser();
  }
  
  public static AccesFacteurPlancher getInstance()
  {
    if (instance == null) {
      instance = new AccesFacteurPlancher();
    }
    return instance;
  }
  
  protected void initialiser()
  {
    ajouter("ASU_CAA14_01", new ValeurParametre(new BigDecimal("0.574")));
    ajouter("ASU_CAA14_02", new ValeurParametre(new BigDecimal("0.574")));
    ajouter("ASU_CAA14_03", new ValeurParametre(new BigDecimal("0.574")));
    ajouter("ASU_CGE01_02", new ValeurParametre(new BigDecimal("0.574")));
    ajouter("ASU_CGE01_03", new ValeurParametre(new BigDecimal("0.574")));
    ajouter("ASU_CGE01_04", new ValeurParametre(new BigDecimal("0.574")));
    ajouter("ASU_CGE01_05", new ValeurParametre(new BigDecimal("0.574")));
    ajouter("ASU_CVA10_01", new ValeurParametre(new BigDecimal("0.574")));
    ajouter("ASU_CVA10_02", new ValeurParametre(new BigDecimal("0.574")));
    ajouter("ASU_CVA10_03", new ValeurParametre(new BigDecimal("0.574")));
    ajouter("ASU_CVE13_01", new ValeurParametre(new BigDecimal("0.574")));
    ajouter("ASU_EXP03_01", new ValeurParametre(new BigDecimal("0.574")));
    ajouter("ASU_CSA06_01", new ValeurParametre(new BigDecimal("0.574")));
    ajouter("ASU_CSA06_02", new ValeurParametre(new BigDecimal("0.574")));
    ajouter("ASU_CSA06_03", new ValeurParametre(new BigDecimal("0.574")));
    ajouter("ASU_CSA06_04", new ValeurParametre(new BigDecimal("0.574")));
    ajouter("ASU_CSR04_01", new ValeurParametre(new BigDecimal("0.574")));
    ajouter("ASU_CGE01_06", new ValeurParametre(new BigDecimal("0.57")));
    ajouter("ASU_CGE01_07", new ValeurParametre(new BigDecimal("0.57")));
    ajouter("ASU_CGE01_6B", new ValeurParametre(new BigDecimal("0.57")));
    ajouter("ASU_CSA06_05", new ValeurParametre(new BigDecimal("0.57")));
    ajouter("ASU_CSA06_5B", new ValeurParametre(new BigDecimal("0.57")));
    ajouter("ASU_CSA06_06", new ValeurParametre(new BigDecimal("0.57")));
  }
  
  public BigDecimal getValeurPlancher(String produit)
  {
    ValeurParametre plancher = (ValeurParametre)m_table.get(produit);
    return plancher.getValeur();
  }
}

/* Location:
 * Qualified Name:     AccesFacteurPlancher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */