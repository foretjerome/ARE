package fr.pe.cali;

import fr.pe.cali.logique.donnees.vls._FluxSillageIn;
import fr.pe.cali.logique.donnees.vls._FluxSillageInImpl;
import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ConvertisseurInterfaceFlux;
import fr.unedic.archi.logique.adaptateur.ConvertisseurInterfaceFluxAbstrait;
import fr.unedic.archi.util.xml.DeserialiseurXML;
import java.io.Reader;

public class A12INVFRAUDConvertisseurImpl
  extends ConvertisseurInterfaceFluxAbstrait
  implements ConvertisseurInterfaceFlux
{
  public Object deserialiseEntreeFlux(Reader p_lecteur, DeserialiseurXML p_deserialiseur)
    throws TechniqueException
  {
    Reader rd = p_lecteur;
    _FluxSillageIn obj = (_FluxSillageIn)p_deserialiseur.deserialise(_FluxSillageIn.class, p_lecteur);
    return new _FluxSillageInImpl(obj);
  }
  
  public Object deserialiseSortieFlux(Reader p_lecteur, DeserialiseurXML p_deserialiseur)
    throws TechniqueException
  {
    return ExceptionUtil.shouldNotPassHere("Pas d'objet en sortie");
  }
}

/* Location:
 * Qualified Name:     A12INVFRAUDConvertisseurImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */