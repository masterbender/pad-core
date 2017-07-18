package de.cap3.pad.core.test;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.GenericArchive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.importer.ExplodedImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.Filters;

import static org.junit.Assert.assertEquals;


import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.arquillian.drone.api.annotation.Drone;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;
import de.cap3.pad.core.HelloWorld;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import java.io.File;

@RunWith(Arquillian.class)
public class HelloWorldIntegrationTest {
    private static final String WEBAPP_SRC = "src/main/webapp";

    @Deployment(testable = false)
    public static Archive<?> createDeployment() {

        File[] files = Maven.resolver().loadPomFromFile("pom.xml")
        .importRuntimeDependencies().resolve().withTransitivity().asFile();


        WebArchive war = ShrinkWrap.create(WebArchive.class, "test.war")
                .addClass(HelloWorld.class)
                .addAsWebResource(new File(WEBAPP_SRC, "helloworld.xhtml"))
                .addAsLibraries(files)
                .setWebXML(new File(WEBAPP_SRC + "/WEB-INF/web.xml"));
        System.out.println(war.toString(true));
        return war;
    }

//    @Test
//    public void bean_should_be_injected() {
//        Assert.assertNotNull(Hello);
//    }

    @FindBy(id = "myform:sub")
    private WebElement sendButton;

    @Inject
    private HelloWorld hello = new HelloWorld();

    @Drone
    private WebDriver browser;

    @ArquillianResource
    private URL deploymentURL;

    @Test
    public void should_run_as_client() {
        browser.get(deploymentURL.toExternalForm().trim() + "helloworld.xhtml");
        WebElement btn = browser.findElement(By.id("myform:sub"));
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        btn.click();
    }

}
