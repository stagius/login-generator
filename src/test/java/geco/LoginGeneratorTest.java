package geco;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginGeneratorTest {

  LoginService loginService;
  LoginGenerator generator;

  @Before
  public void setUp() {
    loginService = new LoginService(new String[]{"JROL", "BPER", "CGUR", "JDU", "JRAL", "JRAL1"});
    generator = new LoginGenerator(loginService);
  }

  @Test
  public void generateLoginForNomAndPrenom() {
    String login = generator.generateLoginForNomAndPrenom("Durand", "Paul");
    assertEquals("PDUR", login);
  }
}