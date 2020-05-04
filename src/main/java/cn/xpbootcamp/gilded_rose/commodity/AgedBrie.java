package cn.xpbootcamp.gilded_rose.commodity;

import static java.lang.Math.min;

public class AgedBrie extends Commodity {

  private static final double DEFAULT_QUALITY_INCREASE_PER_DAY = 1.0;

  @Override
  public void passDays(int days) {
    if (days <= 0) {
      throw new IllegalArgumentException("'days' should be larger than 0");
    }

    setQuality(min(50.0, getQuality() + DEFAULT_QUALITY_INCREASE_PER_DAY * days));
  }
}
