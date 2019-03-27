package fr.unedic.cali.dom.affectation.outilsfonctionnels.qualification.idcc;

import java.util.ArrayList;
import java.util.List;

public class ValidationIDCC
{
  private String codeIdcc;
  private boolean estCertifSocialeNecessaire;
  private List<String> listeCodesNafExclus = new ArrayList();
  private boolean estLicenceNecessaire;
  
  public ValidationIDCC(String idcc)
  {
    codeIdcc = idcc;
  }
  
  public ValidationIDCC(String idcc, boolean certifSocialeNecessaire, boolean licenceNecessaire, List<String> listeNafExclus)
  {
    codeIdcc = idcc;
    estCertifSocialeNecessaire = certifSocialeNecessaire;
    estLicenceNecessaire = licenceNecessaire;
    listeCodesNafExclus = listeNafExclus;
  }
  
  public ValidationIDCC(String idcc, boolean certifSocialeNecessaire, boolean licenceNecessaire)
  {
    codeIdcc = idcc;
    estCertifSocialeNecessaire = certifSocialeNecessaire;
    estLicenceNecessaire = licenceNecessaire;
  }
  
  public String getCodeIdcc()
  {
    return codeIdcc;
  }
  
  public boolean isEstCertifSocialeNecessaire()
  {
    return estCertifSocialeNecessaire;
  }
  
  public boolean isEstLicenceNecessaire()
  {
    return estLicenceNecessaire;
  }
  
  public List<String> getListeCodesNafExclus()
  {
    return listeCodesNafExclus;
  }
  
  public boolean validerIdcc(String idcc, boolean certifSociale, boolean licence, String codeNaf)
  {
    boolean estCertifSocialeEtLicence = ((!estCertifSocialeNecessaire) || (certifSociale)) && ((!estLicenceNecessaire) || (licence));
    return (codeIdcc.equals(idcc)) && (!listeCodesNafExclus.contains(codeNaf)) && (estCertifSocialeEtLicence);
  }
}

/* Location:
 * Qualified Name:     ValidationIDCC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */