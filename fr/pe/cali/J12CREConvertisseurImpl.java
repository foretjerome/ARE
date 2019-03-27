package fr.pe.cali;

import fr.pe.cali.logique.donnees.vls._CREM_IN;
import fr.pe.cali.logique.donnees.vls._CREM_INImpl;
import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ConvertisseurInterfaceFlux;
import fr.unedic.archi.logique.adaptateur.ConvertisseurInterfaceFluxAbstrait;
import fr.unedic.archi.util.xml.DeserialiseurXML;
import java.io.Reader;

public class J12CREConvertisseurImpl
  extends ConvertisseurInterfaceFluxAbstrait
  implements ConvertisseurInterfaceFlux
{
  public Object deserialiseEntreeFlux(Reader p_lecteur, DeserialiseurXML p_deserialiseur)
    throws TechniqueException
  {
    Reader rd = p_lecteur;
    _CREM_IN obj = (_CREM_IN)p_deserialiseur.deserialise(_CREM_IN.class, p_lecteur);
    return new _CREM_INImpl(obj);
  }
  
  public Object deserialiseSortieFlux(Reader p_lecteur, DeserialiseurXML p_deserialiseur)
    throws TechniqueException
  {
    return ExceptionUtil.shouldNotPassHere("Pas d'objet en sortie");
  }
}

/* Location:
 * Qualified Name:     J12CREConvertisseurImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */