package cn.xpbootcamp.gilded_rose.commodity;

import static java.lang.Math.min;

public class BackstagePass extends Commodity {

  private static final double QUALITY_INCREASE_PER_DAY = 1.0;

  public BackstagePass(double quality, int sellIn) {
    super(quality, sellIn);
  }

  @Override
  public void passDays(int days) {
    if (days <= 0) {
      throw new IllegalArgumentException("'days' should be larger than 0");
    }

    int counter = days;
    do {
      passOneDay();
      counter--;
    } while (counter > 0);
  }

  private void passOneDay() {
    int currentSellIn = getSellIn();
    if (currentSellIn > 10) {
      setQuality(min(MAX_QUALITY, getQuality() + QUALITY_INCREASE_PER_DAY));
    } else if (currentSellIn > 5) {
      setQuality(min(MAX_QUALITY, getQuality() + QUALITY_INCREASE_PER_DAY * 2));
    } else if (currentSellIn > 0) {
      setQuality(min(MAX_QUALITY, getQuality() + QUALITY_INCREASE_PER_DAY * 3));
    } else {
      setQuality(0.0);
    }

    setSellIn(getSellIn() - 1);
  }
}
