package cn.xpbootcamp.gilded_rose.commodity;

import lombok.Getter;
import lombok.Setter;

import static java.lang.Math.max;

@Getter
public class Commodity {

  private double quality;

  @Setter
  private int sellIn;

  protected static final double DEFAULT_QUALITY_DROPDOWN_PER_DAY = 1.0;

  protected static final double MAX_QUALITY = 50.0;
  protected static final double MIN_QUALITY = 0.0;

  public Commodity(double quality, int sellIn) {
    setQuality(quality);
    setSellIn(sellIn);
  }

  public void setQuality(double quality) {
    if (quality > MAX_QUALITY || quality < MIN_QUALITY) {
      throw new IllegalArgumentException(String.format("Quality must be between [%s, %s]", MIN_QUALITY, MAX_QUALITY));
    }

    this.quality = quality;
  }

  public void passDays(int days) {
    if (days <= 0) {
      throw new IllegalArgumentException("'days' should be larger than 0");
    }

    setSellIn(getSellIn() - days);

    if (sellIn < 0) {
      setQuality(max(0.0, quality - DEFAULT_QUALITY_DROPDOWN_PER_DAY * 2 * days));
    } else {
      setQuality(max(0.0, quality - DEFAULT_QUALITY_DROPDOWN_PER_DAY * 1 * days));
    }
  }
}
