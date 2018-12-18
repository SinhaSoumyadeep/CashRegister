package cs5010.register;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * This is the concrete implementation of a the Cash Register which provides various operations to
 * add money as well as withdraw money from the case register. It also provides a way to maintain
 * the history of the transactions and see the content of the register.
 */
public class SimpleRegister implements CashRegister {

  private SortedMap<Integer, Integer> register;
  private Map<Integer, Integer> handout;
  private String auditLog = "";

  /**
   * this constructor is used to initialize the register and handout maps.
   */
  public SimpleRegister() {
    register = new TreeMap<Integer, Integer>() {
      {
        put(1000, 0);
        put(500, 0);
        put(100, 0);
        put(25, 0);
        put(10, 0);
        put(5, 0);
        put(1, 0);
      }
    };

    handout = new HashMap<Integer, Integer>() {
      {
        put(1000, 0);
        put(500, 0);
        put(100, 0);
        put(25, 0);
        put(10, 0);
        put(5, 0);
        put(1, 0);
      }
    };
  }


  /**
   * This is a helper method that addsMoney to a particular slot in the cash register.
   *
   * @param hashValue the hashvalue of the money.
   * @param num       the number of money to be placed.
   */
  private void addMoney(int hashValue, int num) {
    Integer numberOfMoney = register.get(hashValue);
    numberOfMoney = numberOfMoney + num;
    register.put(hashValue, numberOfMoney);

  }

  /**
   * Add pennies to the register.
   *
   * @param num number of pennies to be added
   * @throws IllegalArgumentException when the number of pennies added is negative.
   */
  @Override
  public void addPennies(int num) throws IllegalArgumentException {


    if (num < 0) {
      throw new IllegalArgumentException("money cannot be in negative");
    }

    addMoney(1, num);
    Double number = num / 100.0;

    auditLog = auditLog + "Deposit: " + String.format("%.2f", number) + "\n";

  }

  /**
   * Add nickels to the register.
   *
   * @param num number of nickels to be added
   * @throws IllegalArgumentException when the number of nickles added is negative.
   */
  @Override
  public void addNickels(int num) {
    if (num < 0) {
      throw new IllegalArgumentException("money cannot be in negative");
    }

    addMoney(5, num);

    Double number = num / 20.0;

    auditLog = auditLog + "Deposit: " + String.format("%.2f", number) + "\n";
  }

  /**
   * Add dimes to the register.
   *
   * @param num number of dimes to be added
   * @throws IllegalArgumentException when the number of dimes added is negative.
   */
  @Override
  public void addDimes(int num) {
    if (num < 0) {
      throw new IllegalArgumentException("money cannot be in negative");
    }
    addMoney(10, num);

    Double number = num / 10.0;

    auditLog = auditLog + "Deposit: " + String.format("%.2f", number) + "\n";
  }


  /**
   * Add quarters to the register.
   *
   * @param num number of quarters to be added
   * @throws IllegalArgumentException when the number of quarters added is negative.
   */
  @Override
  public void addQuarters(int num) {
    if (num < 0) {
      throw new IllegalArgumentException("money cannot be in negative");
    }
    addMoney(25, num);

    Double number = num / 4.0;
    auditLog = auditLog + "Deposit: " + String.format("%.2f", number) + "\n";
  }

  /**
   * Add one-dollar bills to the register.
   *
   * @param num number of ones to be added
   * @throws IllegalArgumentException when the number of one dollar bill added is negative.
   */
  @Override
  public void addOnes(int num) {
    if (num < 0) {
      throw new IllegalArgumentException("money cannot be in negative");
    }

    addMoney(100, num);

    Double number = num * 1.0;

    auditLog = auditLog + "Deposit: " + String.format("%.2f", number) + "\n";
  }

  /**
   * Add five-dollar bills to the register.
   *
   * @param num number of fives to be added
   * @throws IllegalArgumentException when the number of five dollar bill added is negative.
   */
  @Override
  public void addFives(int num) {
    if (num < 0) {
      throw new IllegalArgumentException("money cannot be in negative");
    }
    addMoney(500, num);

    Double number = num * 5.0;

    auditLog = auditLog + "Deposit: " + String.format("%.2f", number) + "\n";
  }

  /**
   * Add ten-dollar bills to the register.
   *
   * @param num number of tens to be added
   * @throws IllegalArgumentException when the number of ten dollar bills added is negative.
   */
  @Override
  public void addTens(int num) {
    if (num < 0) {
      throw new IllegalArgumentException("money cannot be in negative");
    }

    addMoney(1000, num);

    Double number = num * 10.0;

    auditLog = auditLog + "Deposit: " + String.format("%.2f", number) + "\n";

  }

  /**
   * Withdraw the provided amount from the cash register, if there is enough. The input is provided
   * in dollars and cents, instead of a floating-point number to avoid precision errors, as only two
   * decimal places of precision are realistic.
   *
   * <p>It works as follows:
   * 1. Start from highest denomination. 2. Find the highest number of coins/notes of current
   * denomination such that their value is less than required value. 3. Take that many notes/coins
   * out of the cash register, and reduce the required value by the appropriate amount. 4. If the
   * required value is greater than 0 and there is a lesser denomination, go to step 2. 5. If there
   * are no more denominations, throw an exception because the amount cannot be dispensed with what
   * the register contains.
   *
   * @param dollars the dollar amount to be withdrawn
   * @param cents   the cent amount to be withdrawn
   * @return if dispensing is possible, a map of &lt;value of coin/bill in cents.
   * @throws InsufficientCashException when the fund is insufficient.
   * @throws IllegalArgumentException  when the dollar and cent is negative.
   */
  @Override
  public Map<Integer, Integer> withdraw(int dollars, int cents)
          throws InsufficientCashException, IllegalArgumentException {


    if (dollars < 0 || cents < 0) {
      throw new IllegalArgumentException("money cannot be in negative");
    }
    int dollarInCents = dollars * 100 + cents;
    handout = new HashMap<Integer, Integer>() {
      {
        put(1000, 0);
        put(500, 0);
        put(100, 0);
        put(25, 0);
        put(10, 0);
        put(5, 0);
        put(1, 0);
      }
    };

    HashMap<Integer, Integer> copyOfRegister = new HashMap<>(register);
    HashMap<Integer, Integer> finalReturn = new HashMap<>();

    try {
      finalReturn = new HashMap<>(withdraw(dollarInCents));
      List<Integer> keys = new ArrayList<>(finalReturn.keySet());

      for (Integer key : keys) {
        if (finalReturn.get(key) == 0) {
          finalReturn.remove(key);
        }
      }
      auditLog = auditLog + "Withdraw: " + dollars + "." + cents + "\n";
      return finalReturn;

    } catch (InsufficientCashException e) {
      register = new TreeMap<Integer, Integer>(copyOfRegister);
      throw new InsufficientCashException("no money!");
    }


  }

  /**
   * Withdraw the provided amount from the cash register, if there is enough. The input is provided
   * in dollars and cents, instead of a floating-point number to avoid precision errors, as only two
   * decimal places of precision are realistic.
   *
   * @param dollarInCents total money in cents.
   * @return if dispensing is possible, a map of value of coin/bill in cents
   * @throws InsufficientCashException when the fund is insufficient.
   */
  private Map<Integer, Integer> withdraw(Integer dollarInCents) throws InsufficientCashException {


    List<Integer> keyList = new ArrayList<>(register.keySet());
    Collections.sort(keyList, Collections.reverseOrder());

    Integer checkKey = 0;
    for (Integer keys : keyList) {
      if (keys <= dollarInCents) {


        checkKey = keys;

        Integer how_many_notes = register.get(checkKey);

        if (register.get(checkKey) != 0) {
          break;
        }

      }
    }

    if (register.get(checkKey) == 0) {
      throw new InsufficientCashException("no money to give!");
    }


    Integer moneyReceivedInThisIteration = checkKey;

    Integer money = handout.get(checkKey);
    money = money + 1;
    handout.put(checkKey, money);


    register.put(checkKey, register.get(checkKey) - 1);

    Integer howMuchLeft = dollarInCents - moneyReceivedInThisIteration;

    if (howMuchLeft == 0) {
      return handout;
    }

    this.handout = withdraw(howMuchLeft);

    return this.handout;
  }


  /**
   * Return the contents of this register as a map of &lt; value of coin/bill in cents,number of
   * coins/bills &gt;.
   *
   * @return the contents of this register as a map
   */
  @Override
  public Map<Integer, Integer> getContents() {
    HashMap<Integer, Integer> cloneRegister = new HashMap<Integer, Integer>(register);
    List<Integer> keys = new ArrayList<>(register.keySet());

    for (Integer key : keys) {
      if (cloneRegister.get(key) == 0) {
        cloneRegister.remove(key);
      }
    }
    return cloneRegister;
  }

  /**
   * Returns a string describing the history of transactions performed on the cash register. The
   * audit log is a series of transactions (1 per line). Each line is of the form: "Deposit: $x.y"
   * or "Withdraw: $x.y", where x is the dollar amount and y is cents up to 2 decimal places.
   *
   * @return the string of the audit log
   */
  @Override
  public String getAuditLog() {
    return auditLog.trim();
  }
}
