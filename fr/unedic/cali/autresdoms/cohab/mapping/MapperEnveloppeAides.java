package fr.unedic.cali.autresdoms.cohab.mapping;

import fr.unedic.cali.autresdoms.cohab.dom.LireEnveloppeAidesResultat;
import fr.unedic.cali.autresdoms.cohab.sigma.enveloppe.dom.spec.EnveloppeAidesSpec;

public class MapperEnveloppeAides
{
  public static LireEnveloppeAidesResultat mapper(EnveloppeAidesSpec enveloppe)
  {
    LireEnveloppeAidesResultat enveloppeCali = null;
    if (enveloppe != null)
    {
      enveloppeCali = new LireEnveloppeAidesResultat();
      enveloppeCali.setEstEngagementPossible(enveloppe.isEngagementPossible());
      enveloppeCali.setEstMontantInsuffisant(enveloppe.isMontantDisponibleInsuffisant());
      
      enveloppeCali.setMotifImpossibiliteEngagement(enveloppe.getMotifImpossibiliteEngagement());
    }
    return enveloppeCali;
  }
}

/* Location:
 * Qualified Name:     MapperEnveloppeAides
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */