package geco;

import java.util.Random;

public class PasswordGenerator {

  /**
   * Longueur minimale mdp.
   */
  private static final int MIN_LENGTH = 5;

  /**
   * Longueur max généré.
   */
  private static final int RAND_LENGTH_MAX = 10;

  /**
   * Majuscule.
   */
  private char maj = 'A';

  /**
   * Alternance des majuscules.
   */
  private static final int MOD = 2;

  /**
   * Longueur alphabet.
   */
  private static final int ALPHA = 26;

  /**
   * Retourne un mot de passe généré au hasard.
   *
   * @return mdp
   */
  public String getRandomPassword() {
    String password = "";
    int length = MIN_LENGTH + new Random().nextInt(RAND_LENGTH_MAX) + 1;
    for (int i = 0; i < length; i++) {
      maj = (i % MOD == 0) ? 'a' : 'A';
      password += generateLetter();
    }
    return password;
  }

  /**
   * Retourne une lettre au hasard.
   * MOD
   *
   * @return lettre
   */
  public char generateLetter() {
    return (char) (new Random().nextInt(ALPHA) + maj);
  }

}
