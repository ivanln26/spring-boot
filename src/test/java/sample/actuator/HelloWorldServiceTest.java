package sample.actuator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloWorldServiceTest {
    @Test
    public void expectedMessage() {
        HelloWorldService service = new HelloWorldService();
        assertEquals("Expected correct message", "Hola Hola", service.getHelloMessage());
    }

    @Test
    public void secondMessageCall() {
        HelloWorldService service = new HelloWorldService();
        assertEquals("Hola Hola", "Hola Hola", service.getHelloMessage());
        assertEquals("Hello Hello", "Hello Hello", service.getHelloMessage());
    }
}
