package selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class TesteCadastro {
	
	private WebDriver driver;
	private Dsl dsl;
	private CampoTreinamento_Page page;
		
	
	@Before 
	public void inicializa() {
		driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("http://127.0.0.1:5500/componentes.html");
		page = new CampoTreinamento_Page(driver);
	}
	
	@After   
	public void finalizar() {
		driver.quit();
	}
	
	@Test
	public void testandoCadastro() {
		
		page.setNome("DARLISON");
		page.setSobreNome("SILVA");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		
		new Select(driver.findElement(By.id("elementosForm:escolaridade")))
		    .selectByVisibleText("Superior");
		
		new Select(driver.findElement(By.id("elementosForm:esportes")))
	        .selectByVisibleText("Futebol");
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
		Assert.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("DARLISON"));
		Assert.assertEquals("Sobrenome: SILVA", driver.findElement(By.id("descSobrenome")).getText());
		Assert.assertEquals("Sexo: Masculino", driver.findElement(By.id("descSexo")).getText());
		Assert.assertEquals("Comida: Carne", driver.findElement(By.id("descComida")).getText());
		Assert.assertEquals("Escolaridade: superior", driver.findElement(By.id("descEscolaridade")).getText());
		Assert.assertEquals("Esportes: Futebol", driver.findElement(By.id("descEsportes")).getText());
		
	}

}
