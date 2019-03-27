package fr.pe.cali.client;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.client.configuration.ConfigurationBouchon;

public class ManagerAppelsServicesD01
  extends AbstractManagerAppelsServicesD01
{
  protected ConfigurationBouchon getConfigurationBouchon()
    throws TechniqueException
  {
    ConfigurationBouchon configurationBouchon = new ConfigurationBouchon("", "fr.pe.fmk.test.bouchonnage.ConnecteurBouchonSuivantEntreePassant");
    
    return configurationBouchon;
  }
}

/* Location:
 * Qualified Name:     ManagerAppelsServicesD01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */