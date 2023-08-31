package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TargetHomePage extends BasePage
{

	public TargetHomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='search']")
	WebElement txtSearch;
	
	@FindBy(xpath="//button[normalize-space()='search']")
	WebElement btnSearch;
	
	@FindBy(xpath="//span[contains(text(),'$289.99')]")
	WebElement price;
	
	
	public void setSearch()
	{
		txtSearch.sendKeys("iPhone XR (64GB) - Yellow");
	}
	
	public void clickSearch()
	{
		btnSearch.click();
	}
	
	public String getPrice()
	{
		try
		{
			return(price.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
	
}
