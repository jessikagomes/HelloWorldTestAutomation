package iterasys;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Consulta {
	
	String url;
	WebDriver driver;
	
	@Before
	public void iniciar() {
		url = "https://www.iterasys.com.br";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jessi\\eclipse-workspace\\iterasys\\drivers\\chrome\\89\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	}
	
	@After
	public void finalizar() {
		driver.quit();
	}

	@Given("^the user acces the Iterasys webpage$")
	public void the_user_acces_the_Iterasys_webpage() throws Throwable {
		driver.get(url);
	}

	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String arg1) throws Throwable {
		WebElement input = driver.findElement(By.id("searchtext"));
		input.sendKeys(arg1);
		input.sendKeys(Keys.ENTER);
	}

	@When("^show a list of courses$")
	public void show_a_list_of_courses() throws Throwable {
		assertNotNull(driver.findElement(By.id("all_courses_search")));
	    
	}

	@When("^i click on Incio Rapido em Teste de software$")
	public void i_click_on_Incio_Rapido_em_Teste_de_software() throws Throwable {
		driver.findElement(By.cssSelector("#all_courses_search>li:nth-child(3)")).click();
	}

	@Then("^I see the duration of the course is \"([^\"]*)\" hours$")
	public void i_see_the_duration_of_the_course_is_hours(String arg1) throws Throwable {
		assertEquals("060 Horas de duração",driver.findElement(By.cssSelector("li.carga-horaria")).getText());
	}

}
