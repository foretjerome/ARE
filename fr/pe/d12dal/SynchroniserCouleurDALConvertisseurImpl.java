package fr.pe.d12dal;

import fr.pe.d12dal.service.es.completude._CritereSynchroniserCouleurDAL;
import fr.pe.d12dal.service.es.completude._CritereSynchroniserCouleurDALImpl;
import fr.pe.d12dal.service.es.completude._RetourSynchroniserCouleurDAL;
import fr.pe.d12dal.service.es.completude._RetourSynchroniserCouleurDALImpl;
import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.CodesErreurs;
import fr.unedic.archi.logique.adaptateur.ConvertisseurInterfaceService;
import fr.unedic.archi.logique.adaptateur.ConvertisseurInterfaceServiceAbstrait;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import fr.unedic.archi.util.xml.DeserialiseurXML;
import fr.unedic.archi.util.xml.SerialiseurXML;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;

public class SynchroniserCouleurDALConvertisseurImpl
  extends ConvertisseurInterfaceServiceAbstrait
  implements ConvertisseurInterfaceService
{
  public Object deserialiseEntreeService(Reader pLecteur, DeserialiseurXML pDeserialiseur)
    throws TechniqueException
  {
    Reader rd = pLecteur;
    _CritereSynchroniserCouleurDAL obj = (_CritereSynchroniserCouleurDAL)pDeserialiseur.deserialise(_CritereSynchroniserCouleurDAL.class, rd);
    return new _CritereSynchroniserCouleurDALImpl(obj);
  }
  
  public Object deserialiseSortieService(Reader pLecteur, DeserialiseurXML pDeserialiseur)
    throws TechniqueException
  {
    Reader rd = pLecteur;
    _RetourSynchroniserCouleurDAL obj = (_RetourSynchroniserCouleurDAL)pDeserialiseur.deserialise(_RetourSynchroniserCouleurDAL.class, rd);
    return new _RetourSynchroniserCouleurDALImpl(obj);
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
 * Qualified Name:     SynchroniserCouleurDALConvertisseurImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */