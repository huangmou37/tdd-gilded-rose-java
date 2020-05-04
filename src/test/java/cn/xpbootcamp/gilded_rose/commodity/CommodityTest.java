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
    Exception except1 = assertThrows(IllegalArgumentException.class, () -> commodity.setQuality(-1));
    assertThat(except1.getMessage(), is("Quality must be between [0.0, 50.0]"));

    Exception except2 = assertThrows(IllegalArgumentException.class, () -> commodity.setQuality(51));
    assertThat(except2.getMessage(), is("Quality must be between [0.0, 50.0]"));
  }

  @Test
  void shouldThrowIllegalArgumentExceptionWhenPassDaysLessThanOne() {
    Commodity commodity = new Commodity();
    commodity.setQuality(10.0);
    commodity.setSellIn(5);

    Exception except = assertThrows(IllegalArgumentException.class, () -> commodity.passDays(0));
    assertThat(except.getMessage(), is("'days' should be larger than 0"));
  }

  @Test
  void shouldReturnQualityThatDropDownInDefaultSpeedWhenNotExpired() {
    Commodity commodity = new Commodity();
    commodity.setSellIn(10);
    commodity.setQuality(30);

    commodity.passDays(5);
    assertThat(commodity.getQuality(), is(25.0));
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