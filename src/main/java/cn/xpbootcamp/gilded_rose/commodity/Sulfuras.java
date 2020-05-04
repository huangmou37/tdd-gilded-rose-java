package cn.xpbootcamp.gilded_rose.commodity;

public class Sulfuras extends Commodity {

  public Sulfuras(double quality) {
    super(quality, Integer.MAX_VALUE);
  }

  @Override
  public void passDays(int days) {
    // quality will always remain the same
  }
}
