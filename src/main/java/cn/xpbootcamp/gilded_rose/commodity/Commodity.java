package cn.xpbootcamp.gilded_rose.commodity;

import lombok.Getter;
import lombok.Setter;

import static java.lang.Math.max;

@Getter
public class Commodity {

  private double quality;

  @Setter
  private int sellIn;

  private static final double DEFAULT_QUALITY_DROPDOWN_PER_DAY = 1.0;

  private static final double MAX_QUALITY = 50.0;
  private static final double MIN_QUALITY = 0.0;

  public void setQuality(double quality) {
    if (quality > MAX_QUALITY || quality < MIN_QUALITY) {
      throw new IllegalArgumentException(String.format("Quality must be between [%s, %s]", MIN_QUALITY, MAX_QUALITY));
    }

    this.quality = quality;
  }

  public void passDays(int i) {
    sellIn -= i;

    if (sellIn < 0) {
      quality = max(0.0, quality - DEFAULT_QUALITY_DROPDOWN_PER_DAY * 2 * i);
    } else {
      quality = max(0.0, quality - DEFAULT_QUALITY_DROPDOWN_PER_DAY * 1 * i);
    }
  }
}
