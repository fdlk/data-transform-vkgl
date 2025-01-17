package org.molgenis;

import java.util.HashMap;
import java.util.Map;

public class LumcMapper extends InputDataMapper {

  static {
    classificationTranslation = new HashMap<>();
    classificationTranslation.put("-", "b");
    classificationTranslation.put("-?", "lb");
    classificationTranslation.put("?", "v");
    classificationTranslation.put("+?", "lp");
    classificationTranslation.put("+", "p");
  }

  @Override
  public String getHeader() {
    return "refseq_build\tchromosome\thgvs_normalized\tvariant_effect\tgeneid\tcDNA\tProtein";
  }

  @Override
  public void mapData(Map body) {
    String originalClassification = body.get("variant_effect").toString();
    mapClassification(body, originalClassification);
    body.put("hgvs_normalized_vkgl", body.get("gDNA_normalized"));
    body.remove("gDNA_normalized");
  }
}
