package selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.Assert;

public class AproveitandoCodigo_dsl {
	
	private Dsl dsl;
	private WebDriver driver;
	
	@Before 
	public void inicializa() {
		driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("http://127.0.0.1:5500/componentes.html");
		dsl = new Dsl(driver);
	}
	
	@After 
	public void finalizar() {
		driver.quit();
	}
	
	@Test
	public void testInserirNome() {
		
		/* como estamos reaproveitando código, só precisamos chamar 
		 * a função abaixo e passar os parâmetros, primeiro o ID
		 * e depois o TEXTO que eu quero
		 */
		dsl.escreve("elementosForm:nome", "DARLISON");
		Assert.assertEquals("DARLISON", dsl.obterValorCampo("elementosForm:nome"));
	}
	
	
	@Test
	public void testandoRadioButton() {
		dsl.clicarRadio("elementosForm:sexo:0");
	}
	
	@Test
	public void testandoRadiuButtonComida() {
		dsl.clicarChebox("elementosForm:comidaFavorita:0");
		
		// verificando se o radioButton está selecionado
		Assert.assertTrue(dsl.isRadioButtonMarcado("elementosForm:comidaFavorita:0"));
	}
	
	
	@Test
	public void tetandoComboBoxFormacao() {
		dsl.selecionarComboBox("elementosForm:escolaridade", "Superior");
		Assert.assertEquals("Superior", dsl.obterValorcomboBox("elementosForm:escolaridade"));
	}
	
	@Test
	public void testClicarBotao() {
		dsl.clicarBotao("elementosForm:cadastrar");
	}
	
	@Test
	public void clicarLinkVoltar() {
		dsl.clicarLink("Voltar");
		Assert.assertEquals("Voltou!", dsl.obterTexto("resultado"));
	}
	
	
	
	
	
	
	
	

}
