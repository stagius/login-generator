package geco;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LoginServiceTest {

  LoginService login;

  @Before
  public void setUp() {
    login = new LoginService(new String[] {"AB", "ABC", "AC"});
  }

  @Test
  public void loginExists() {
    assertTrue(login.loginExists("ABC"));
  }

  @Test
  public void addLogin() {
    String newLogin = "AD";
    login.addLogin(newLogin);
    assertTrue(login.loginExists("AD"));
  }

  @Test
  public void findAllLoginsStartingWith() {
    String prefix = "AB";
    List<String> list = login.findAllLoginsStartingWith(prefix);
    assertEquals(2, list.size());
  }

  @Test
  public void findAllLogins() {
    List<String> expected = new ArrayList<>();
    expected.add("AB");
    expected.add("ABC");
    expected.add("AC");

    List<String> actual = login.findAllLogins();
    assertTrue(actual.equals(expected));
  }
}