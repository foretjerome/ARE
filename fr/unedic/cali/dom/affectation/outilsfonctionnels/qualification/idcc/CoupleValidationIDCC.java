package fr.unedic.cali.dom.affectation.outilsfonctionnels.qualification.idcc;

public class CoupleValidationIDCC
{
  private ValidationIDCC idccE;
  private ValidationIDCC idccP;
  
  public CoupleValidationIDCC(ValidationIDCC validationIdccE, ValidationIDCC validationIdccP)
  {
    idccE = validationIdccE;
    idccP = validationIdccP;
  }
  
  public boolean validerPeriode(String idccEmp, String idccPrest, boolean estCertifSociale, boolean estLicence, String codeNaf)
  {
    return (idccE.validerIdcc(idccEmp, estCertifSociale, estLicence, codeNaf)) && (idccP.validerIdcc(idccPrest, estCertifSociale, estLicence, codeNaf));
  }
}

/* Location:
 * Qualified Name:     CoupleValidationIDCC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */