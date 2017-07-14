package de.cap3.pad.core.test;



import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;




@RunWith(Arquillian.class)
public class HelloWorldIntegrationTest {


    @Deployment
    public static  Archive<?> createDeployment() {
        WebArchive jar = ShrinkWrap.create(WebArchive.class, "test.war")
          //      .addClass(HelloWorld.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        System.out.println(jar.toString(true));
        return jar;
    }

    @Test
    public void should_create_greeting() {
        Assert.assertNull(null);
    }
}
