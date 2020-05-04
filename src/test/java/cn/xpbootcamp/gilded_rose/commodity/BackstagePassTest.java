package cn.xpbootcamp.gilded_rose.commodity;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class BackstagePassTest {

  @Test
  void shouldIncreaseQualityByOneWhenSellInLargerThanTen() {
    Commodity backstagePass = new BackstagePass();
    backstagePass.setQuality(10);
    backstagePass.setSellIn(30);

    for (int i = 30; i > 10; i--) {
      double originalQuality = backstagePass.getQuality();
      backstagePass.passDays(1);
      assertThat(backstagePass.getQuality(), is(originalQuality + 1.0));
    }
  }

  @Test
  void shouldIncreaseQualityByTwoWhenSellInBetweenFiveAndTen() {
    Commodity backstagePass = new BackstagePass();
    backstagePass.setQuality(10);
    backstagePass.setSellIn(10);

    for (int i = 10; i > 5; i--) {
      double originalQuality = backstagePass.getQuality();
      backstagePass.passDays(1);
      assertThat(backstagePass.getQuality(), is(originalQuality + 2.0));
    }
  }

  @Test
  void shouldIncreaseQualityByTwoWhenSellInBetweenZeroAndFive() {
    Commodity backstagePass = new BackstagePass();
    backstagePass.setQuality(10);
    backstagePass.setSellIn(5);

    for (int i = 5; i >= 0; i--) {
      double originalQuality = backstagePass.getQuality();
      backstagePass.passDays(1);
      assertThat(backstagePass.getQuality(), is(originalQuality + 3.0));
    }
  }

  @Test
  void shouldReturnQualityAsZeroWhenExpire() {
    Commodity backstagePass = new BackstagePass();
    backstagePass.setQuality(10);
    backstagePass.setSellIn(0);

    backstagePass.passDays(1);
    assertThat(backstagePass.getQuality(), is(0.0));
  }
}