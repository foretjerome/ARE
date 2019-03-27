package fr.pe.cali.client;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.client.configuration.ConfigurationBouchon;

public class ManagerAppelsServicesD12DAL
  extends AbstractManagerAppelsServicesD12DAL
{
  protected ConfigurationBouchon getConfigurationBouchon()
    throws TechniqueException
  {
    ConfigurationBouchon configurationBouchon = new ConfigurationBouchon("", "fr.pe.fmk.test.bouchonnage.ConnecteurBouchonSuivantEntreePassant");
    
    return configurationBouchon;
  }
}

/* Location:
 * Qualified Name:     ManagerAppelsServicesD12DAL
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */