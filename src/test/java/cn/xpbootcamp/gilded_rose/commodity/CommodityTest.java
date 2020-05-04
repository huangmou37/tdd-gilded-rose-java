package cn.xpbootcamp.gilded_rose.commodity;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CommodityTest {

  @Test
  void shouldReturnQualityThatAlwaysBetweenZeroAndFifty() {
    Commodity commodity = new Commodity();
    commodity.setQuality(50);
    commodity.setSellIn(10);

    commodity.passDays(Integer.MAX_VALUE);
    assertThat(commodity.getQuality() >= 0 && commodity.getQuality() <= 50, is(true));
  }

  @Test
  void shouldThrowIllegalArgumentExceptionWhenSetQualityNotBetweenZeroAndFifty() {
    Commodity commodity = new Commodity();
    assertThrows(IllegalArgumentException.class, () -> commodity.setQuality(-1));
    assertThrows(IllegalArgumentException.class, () -> commodity.setQuality(51));
  }

  @Test
  void shouldReturnQualityThatDropDownInDefaultSpeedWhenNotExpired() {
    Commodity commodity = new Commodity();
    commodity.setSellIn(5);
    commodity.setQuality(30);

    for (int i = 0; i < 5; i++) {
      double originalQuality = commodity.getQuality();
      commodity.passDays(1);
      double newQuality = commodity.getQuality();
      assertThat(newQuality, is(originalQuality - 1.0));
    }
  }

  @Test
  void shouldReturnQualityThatDropDownInDoubleSpeedWhenExpired() {
    Commodity commodity = new Commodity();
    commodity.setSellIn(0);
    commodity.setQuality(30);

    for (int i = 0; i < 5; i++) {
      double originalQuality = commodity.getQuality();
      commodity.passDays(1);
      double newQuality = commodity.getQuality();
      assertThat(newQuality, is(originalQuality - 2.0));
    }
  }
}