package cn.xpbootcamp.gilded_rose.commodity;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class SulfurasTest {

  @Test
  void shouldRemainQualityUnchangedWhenGivenAnySellInAndPassDays() {
    Commodity sulfuras = new Sulfuras(30);
    sulfuras.passDays(Integer.MAX_VALUE);

    assertThat(sulfuras.getQuality(), is(30.0));
  }
}