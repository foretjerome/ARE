package fr.unedic.d90.service.rac.commun.d90;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.CodesErreurs;
import fr.unedic.archi.logique.adaptateur.ConvertisseurInterfaceService;
import fr.unedic.archi.logique.adaptateur.ConvertisseurInterfaceServiceAbstrait;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import fr.unedic.archi.util.xml.DeserialiseurXML;
import fr.unedic.archi.util.xml.SerialiseurXML;
import fr.unedic.d90.donnees.d90.service.vls._CriteresEcrireEvenementAsynchrone;
import fr.unedic.d90.donnees.d90.service.vls._CriteresEcrireEvenementAsynchroneImpl;
import fr.unedic.d90.donnees.d90.service.vls._ResultatEcrireEvenementAsynchrone;
import fr.unedic.d90.donnees.d90.service.vls._ResultatEcrireEvenementAsynchroneImpl;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;

public class EcrireEvenementAsynchroneConvertisseurImpl
  extends ConvertisseurInterfaceServiceAbstrait
  implements ConvertisseurInterfaceService
{
  public Object deserialiseEntreeService(Reader pLecteur, DeserialiseurXML pDeserialiseur)
    throws TechniqueException
  {
    Reader rd = pLecteur;
    _CriteresEcrireEvenementAsynchrone obj = (_CriteresEcrireEvenementAsynchrone)pDeserialiseur.deserialise(_CriteresEcrireEvenementAsynchrone.class, rd);
    return new _CriteresEcrireEvenementAsynchroneImpl(obj);
  }
  
  public Object deserialiseSortieService(Reader pLecteur, DeserialiseurXML pDeserialiseur)
    throws TechniqueException
  {
    Reader rd = pLecteur;
    _ResultatEcrireEvenementAsynchrone obj = (_ResultatEcrireEvenementAsynchrone)pDeserialiseur.deserialise(_ResultatEcrireEvenementAsynchrone.class, rd);
    return new _ResultatEcrireEvenementAsynchroneImpl(obj);
  }
  
  public final void serialiseEntreeService(Object pDonnees, OutputStream pSortie, SerialiseurXML pSerialiseur)
    throws TechniqueException
  {
    ExceptionUtil.assertMethodParamNotNull("pDonnees", pDonnees);
    ExceptionUtil.assertInstanceOf("pDonnees", pDonnees, ObjetSerialisableFournisseur.class);
    
    ByteArrayOutputStream sortie = new ByteArrayOutputStream();
    
    ObjetSerialisableFournisseur objetSerialisableFournisseur = (ObjetSerialisableFournisseur)pDonnees;
    
    pSerialiseur.serialise(objetSerialisableFournisseur.getObjet(), sortie);
    try
    {
      pSortie.write(sortie.toString().getBytes());
    }
    catch (IOException e)
    {
      throw CodesErreurs.newERR_SERIALISATION_0014_SERIALISATION_XPP("java.io.OutputStream", String.class.getName(), e);
    }
  }
}

/* Location:
 * Qualified Name:     EcrireEvenementAsynchroneConvertisseurImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */