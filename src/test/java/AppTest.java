import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Words");
  }

  @Test
  public void WordIsCreatedTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a new word"));
    fill("#word").with("Hi");
    submit(".btn");
    assertThat(pageSource()).contains("Your word has been added to the dictionary!");
  }

  @Test
  public void WordIsDisplayedOnIndexTest() {
    goTo("http://localhost:4567/wordInput/new");
    fill("#word").with("Hello");
    submit(".btn");
    click("a", withText("View Words"));
    assertThat(pageSource()).contains("Hello");
  }

  @Test
  public void MultipleWordsAreDisplayedOnIndexTest() {
    goTo("http://localhost:4567/wordInput/new");
    fill("#word").with("Hi");
    submit(".btn");
    goTo("http://localhost:4567/wordInput/new");
    fill("#word").with("There");
    submit(".btn");
    click("a", withText("View Words"));
    assertThat(pageSource()).contains("Hi");
    assertThat(pageSource()).contains("There");
  }

  // @Test
  // public void WordShowPageDisplaysWord() {
  //   goTo("http://localhost:4567/wordInput/new");
  //   fill("#word").with("Hello");
  //   submit(".btn");
  //   click("a", withText("View Words"));
  //   click("a", withText("Hello"));
  //   assertThat(pageSource()).contains("Hello");
  // }

  @Test
  public void wordNotFoundMessageShown() {
    goTo("http://localhost:4567/wordInput/999");
    assertThat(pageSource()).contains("Word not found");
  }
}
