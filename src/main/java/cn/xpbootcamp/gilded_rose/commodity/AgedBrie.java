package cn.xpbootcamp.gilded_rose.commodity;

import static java.lang.Math.min;

public class AgedBrie extends Commodity {

  private static final double QUALITY_INCREASE_PER_DAY = 1.0;

  public AgedBrie(double quality) {
    super(quality, Integer.MAX_VALUE);
  }

  @Override
  public void passDays(int days) {
    if (days <= 0) {
      throw new IllegalArgumentException("'days' should be larger than 0");
    }

    setQuality(min(MAX_QUALITY, getQuality() + QUALITY_INCREASE_PER_DAY * days));
  }
}
