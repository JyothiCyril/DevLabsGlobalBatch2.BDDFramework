package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AmazonPages {
	
	WebDriver driver;
	
//	Syntax:
//		
//		@FindBy(locator="value")
//		WebElement ref_name;
//	
//		// getter method that can return this web element
//	
//		public WebElement getref_name() {
//			return ref_name;
//		}
//	
	
	@FindBy(id="twotabsearchtextbox")
	WebElement SearchTxtField;
	
	public WebElement getSearchTxtField() {
		return SearchTxtField;
	}
	
	@FindBy(id="nav-search-submit-button")
	WebElement MagnifierBtn;
	
	public WebElement getMagnifierBtn() {
		return MagnifierBtn;
	}
	
	
	@FindBy(name="url")
	WebElement Category;
	
	public Select getCategory() {
		Select cat = new Select(Category);		
		return cat;
	}
	
	@FindAll(@FindBy(xpath="//span[@class='a-size-medium a-color-base a-text-normal']"))
	List<WebElement> allItems;
	
	public List<WebElement> getallItems(){
		return allItems;
	}
	
	@FindAll(@FindBy(className="nav_a"))
	List<WebElement> FooterLinks;
	
	public List<WebElement> getFooterLinks(){
		return FooterLinks;
	}
	
	
	@FindBy(id="nav-link-accountList")
	WebElement AccountandLists;
	
	public WebElement getAccountandLists() {
		return AccountandLists;
	}
	
	@FindBy(linkText="Start here.")
	WebElement startHereLink;
	
	public WebElement getstartHereLink() {
		return startHereLink;
	}
	
	@FindBy(name="customerName")
	WebElement CustomerNameTxtField;
	
	public WebElement getCustomerNameTxtField() {
		return CustomerNameTxtField;
	}
	
	@FindBy(linkText="Careers")
	WebElement CareersLink;
	
	public WebElement getCareersLink() {
		return CareersLink;
	}
	
	public AmazonPages(WebDriver rDriver) {
		this.driver = rDriver;
		PageFactory.initElements(rDriver, this);		
	}

}
