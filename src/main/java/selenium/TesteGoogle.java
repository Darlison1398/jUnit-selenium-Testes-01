package selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class TesteGoogle {
	
	@Test
	public void teste() {
		
		// usando o navegador Firefox
		WebDriver driver = new FirefoxDriver();
		
		// usando o navegador Chrome
		//WebDriver driver = new ChromeDriver();
		
		// usando o navegador InternetExplore
		//WebDriver driver = new InternetExplorerDriver();
		
		/* Determinando um tamanho para tela do navegador. Não é obrigatório, 
		 * serve apenas para melhorar a visão
		 * Essas técnicas abaixo, são apenas para melhorar a visão
		 */
		//driver.manage().window().maximize();
		driver.manage().window().setSize(new Dimension(1200, 765));
		
		driver.get("http://www.google.com");
		
		//System.out.println(driver.getTitle());
		
		Assert.assertEquals("Google", driver.getTitle());
		
		// esse comando fecha e "mata" a instancia do driver
		driver.quit();
	}

}
