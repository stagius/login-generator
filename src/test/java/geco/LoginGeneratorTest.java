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

  @Test
  public void generateLoginCT1WhenExisting() {
    String login = generator.generateLoginForNomAndPrenom("Ralling", "John");
    assertEquals("JRAL2", login);
  }

  @Test
  public void generateLoginCT2() {
    String login = generator.generateLoginForNomAndPrenom("Rolling", "Jean");
    assertEquals("JROL1", login);
  }

  @Test
  public void generateLoginCT3() {
    String login = generator.generateLoginForNomAndPrenom("Dùrand", "Paul");
    assertEquals("PDUR", login);
  }

  @Test
  public void generateLoginCT4Hotfix() {
    String login = generator.generateLoginForNomAndPrenom("Du", "Paul");
    assertEquals("PDU", login);
  }
}