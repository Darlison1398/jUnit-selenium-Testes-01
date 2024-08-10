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
		page.setSexoMasculino();
		page.setComidaFavorita();
		page.setEscolaridade("Superior");
		page.setEsporte("Futebol");
		page.cadastrar();
		
		// obtendo resultado
		Assert.assertTrue(page.obterResultadoCadastro().startsWith("Cadastrado!"));
		Assert.assertTrue(page.obterNomeCadastrado().endsWith("DARLISON"));
		Assert.assertEquals("Sobrenome: SILVA", page.obterSobreNomeCadastrado());
		Assert.assertEquals("Sexo: Masculino", page.obterSexoCadastrado());
		Assert.assertEquals("Comida: Carne", page.obterComidaCadastrado());
		Assert.assertEquals("Escolaridade: superior", page.obterEscolaridadeCadastrado());
		Assert.assertEquals("Esportes: Futebol", page.obterEsporteCadastrado());
		
	}

}
