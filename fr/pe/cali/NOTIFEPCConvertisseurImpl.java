package fr.pe.cali;

import fr.pe.cali.logique.donnees.vls._Notification;
import fr.pe.cali.logique.donnees.vls._NotificationImpl;
import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ConvertisseurInterfaceFlux;
import fr.unedic.archi.logique.adaptateur.ConvertisseurInterfaceFluxAbstrait;
import fr.unedic.archi.util.xml.DeserialiseurXML;
import java.io.Reader;

public class NOTIFEPCConvertisseurImpl
  extends ConvertisseurInterfaceFluxAbstrait
  implements ConvertisseurInterfaceFlux
{
  public Object deserialiseEntreeFlux(Reader p_lecteur, DeserialiseurXML p_deserialiseur)
    throws TechniqueException
  {
    Reader rd = p_lecteur;
    _Notification obj = (_Notification)p_deserialiseur.deserialise(_Notification.class, p_lecteur);
    return new _NotificationImpl(obj);
  }
  
  public Object deserialiseSortieFlux(Reader p_lecteur, DeserialiseurXML p_deserialiseur)
    throws TechniqueException
  {
    return ExceptionUtil.shouldNotPassHere("Pas d'objet en sortie");
  }
}

/* Location:
 * Qualified Name:     NOTIFEPCConvertisseurImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */