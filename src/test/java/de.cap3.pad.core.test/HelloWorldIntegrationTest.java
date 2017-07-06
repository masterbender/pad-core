package de.cap3.pad.core.test;


import de.cap3.pad.core.HelloWorld;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.junit.Test;

import javax.inject.Inject;

@RunWith(Arquillian.class)
public class HelloWorldIntegrationTest {
    @Deployment
    public static JavaArchive createDeployment() {
        JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
                .addClass(HelloWorld.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        System.out.println(jar.toString(true));
        return jar;
    }

    @Inject
    HelloWorld hello;

    @Test
    public void should_create_greeting() {
        Assert.assertEquals("Jhonny",
                hello.getFirstName().toString());
        System.out.println(hello.getFirstName());
    }
}
