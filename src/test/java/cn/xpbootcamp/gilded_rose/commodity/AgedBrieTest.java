package cn.xpbootcamp.gilded_rose.commodity;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AgedBrieTest {

  @Test
  void shouldThrowIllegalArgumentExceptionWhenPassDaysLessThanOne() {
    Commodity agedBrie = new AgedBrie(30);

    Exception except = assertThrows(IllegalArgumentException.class, () -> agedBrie.passDays(0));
    assertThat(except.getMessage(), is("'days' should be larger than 0"));
  }

  @Test
  void shouldReturnQualityIncreasedEveryDay() {
    Commodity agedBrie = new AgedBrie(30);

    agedBrie.passDays(5);
    assertThat(agedBrie.getQuality(), is(35.0));
  }

  @Test
  void shouldReturnQualityAsFiftyWhenPassDaysWithMaximumValue() {
    Commodity agedBrie = new AgedBrie(30);

    agedBrie.passDays(Integer.MAX_VALUE);
    assertThat(agedBrie.getQuality(), is(50.0));
  }
}