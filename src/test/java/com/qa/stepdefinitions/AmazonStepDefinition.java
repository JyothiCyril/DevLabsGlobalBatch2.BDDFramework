package com.qa.stepdefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.qa.pages.AmazonPages;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class AmazonStepDefinition {

	WebDriver driver;
	AmazonPages AmazonOR;
	
	@Before
	public void setUp() {
		System.out.println("Starting...");
	}
	
	@After
	public void tearDown() {
		System.out.println("Stopping...");
	}


	@Given("the user launches the browser")
	public void the_user_launches_the_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		AmazonOR = new AmazonPages(driver);
	}

	@When("the url is entered")
	public void the_url_is_entered(){
		driver.get("https://www.amazon.in/");
	}

	@Then("the user should be landed on the home page")
	public void the_user_should_be_landed_on_the_home_page() {
		boolean contains = driver.getTitle().contains("Amazon");
		if(contains) {
			System.out.println("User is landed on amazon home page");
			Assert.assertTrue(contains);
		}else {
			System.out.println("User is not landed on amazon home page");
			Assert.assertTrue(contains);
		}
	}

	@Given("the user selects {string} as category")
	public void the_user_selects_as_category(String Category) {
		AmazonOR.getCategory().selectByVisibleText(Category);
	}

	@Then("the user types {string} in the search text field")
	public void the_user_types_in_the_search_text_field(String ItemName) {
		AmazonOR.getSearchTxtField().sendKeys(ItemName);
	}

	@When("the magnifier button is clicked")
	public void the_magnifier_button_is_clicked() {
		AmazonOR.getMagnifierBtn().click();
	}

	@Then("the title of the page should have {string}")
	public void the_title_of_the_page_should_have(String ItemName) {
		boolean contains = driver.getTitle().contains(ItemName);
		if(contains) {
			System.out.println("Page title is changed");
			Assert.assertTrue(contains);
		}else {
			System.out.println("Page title is not changed");
			Assert.assertTrue(contains);
		}
	}

	@Then("the items related to search term should be loaded")
	public void the_items_related_to_search_term_should_be_loaded() {
		
		List<WebElement> getallItems = AmazonOR.getallItems();
		for(WebElement item:getallItems) {
			System.out.println(item.getText());
		}
		
	}

	@Then("close the browser")
	public void close_the_browser() {
		driver.close();
	}

	@Given("the user does mouse over on accounts and list element")
	public void the_user_does_mouse_over_on_accounts_and_list_element() {
		
		WebElement ele = AmazonOR.getAccountandLists();
		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();
	}

	@When("the strat here link should be clicked")
	public void the_strat_here_link_should_be_clicked() {
		AmazonOR.getstartHereLink().click();
	}

	@Then("the user should be navigated to registration page")
	public void the_user_should_be_navigated_to_registration_page() {
		boolean contains = driver.getTitle().contentEquals("Registration");
		if(contains) {
			System.out.println("User is landed on registration page");
			Assert.assertTrue(contains);
		}else {
			System.out.println("User is not landed on registration page");
			Assert.assertTrue(contains);
		}
	}

	@Then("type {string} as customer name")
	public void type_as_customer_name(String UserName) {
		AmazonOR.getCustomerNameTxtField().sendKeys(UserName);
	}

	@Given("the user to fetch all the footer links present on the page")
	public void the_user_to_fetch_all_the_footer_links_present_on_the_page() {
		List<WebElement> footerLinks = AmazonOR.getFooterLinks();
		int size = footerLinks.size();
		Assert.assertEquals(52, size);
		for(WebElement link:footerLinks) {
			System.out.println(link.getText());
		}
	}


}
