import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import cs5010.register.CashRegister;
import cs5010.register.InsufficientCashException;
import cs5010.register.SimpleRegister;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CashRegisterTest {

  /**
   * Test to check if a penny is added successfully.
   */
  @Test
  public void addPennies() {

    CashRegister reg = new SimpleRegister();
    reg.addPennies(1);
    assertEquals(new HashMap<Integer, Integer>() {
      {
        put(1, 1);
      }
    }, reg.getContents());

    reg.addPennies(100);
    assertEquals(new HashMap<Integer, Integer>() {
      {
        put(1, 101);
      }
    }, reg.getContents());

    try {
      reg.addPennies(-1);
    } catch (Exception e) {
      assertEquals("money cannot be in negative", e.getMessage());
    }

    assertEquals(new HashMap<Integer, Integer>() {
      {
        put(1, 101);
      }
    }, reg.getContents());

  }


  /**
   * Test to check if a nickle is added successfully.
   */

  @Test
  public void addNickles() {

    CashRegister reg = new SimpleRegister();
    reg.addNickels(1);
    assertEquals(new HashMap<Integer, Integer>() {
      {
        put(5, 1);
      }
    }, reg.getContents());

    reg.addNickels(100);
    assertEquals(new HashMap<Integer, Integer>() {
      {
        put(5, 101);
      }
    }, reg.getContents());

    try {
      reg.addNickels(-1);
    } catch (Exception e) {
      assertEquals("money cannot be in negative", e.getMessage());
    }

    assertEquals(new HashMap<Integer, Integer>() {
      {
        put(5, 101);
      }
    }, reg.getContents());

  }


  /**
   * Test to check if a dime is added successfully.
   */

  @Test
  public void addDime() {

    CashRegister reg = new SimpleRegister();
    reg.addDimes(1);
    assertEquals(new HashMap<Integer, Integer>() {
      {
        put(10, 1);
      }
    }, reg.getContents());

    reg.addDimes(100);
    assertEquals(new HashMap<Integer, Integer>() {
      {
        put(10, 101);
      }
    }, reg.getContents());

    try {
      reg.addDimes(-1);
    } catch (Exception e) {
      assertEquals("money cannot be in negative", e.getMessage());
    }

    assertEquals(new HashMap<Integer, Integer>() {
      {
        put(10, 101);
      }
    }, reg.getContents());

  }

  /**
   * Test to check if a quarter is added successfully.
   */

  @Test
  public void addQuarter() {

    CashRegister reg = new SimpleRegister();
    reg.addQuarters(1);
    assertEquals(new HashMap<Integer, Integer>() {
      {
        put(25, 1);
      }
    }, reg.getContents());

    reg.addQuarters(100);
    assertEquals(new HashMap<Integer, Integer>() {
      {
        put(25, 101);
      }
    }, reg.getContents());

    try {
      reg.addQuarters(-1);
    } catch (Exception e) {
      assertEquals("money cannot be in negative", e.getMessage());
    }

    assertEquals(new HashMap<Integer, Integer>() {
      {
        put(25, 101);
      }
    }, reg.getContents());

  }

  /**
   * Test to check if a dollar is added successfully.
   */

  @Test
  public void addOnes() {

    CashRegister reg = new SimpleRegister();
    reg.addOnes(1);
    assertEquals(new HashMap<Integer, Integer>() {
      {
        put(100, 1);
      }
    }, reg.getContents());

    reg.addOnes(100);
    assertEquals(new HashMap<Integer, Integer>() {
      {
        put(100, 101);
      }
    }, reg.getContents());

    try {
      reg.addOnes(-1);
    } catch (Exception e) {
      assertEquals("money cannot be in negative", e.getMessage());
    }

    assertEquals(new HashMap<Integer, Integer>() {
      {
        put(100, 101);
      }
    }, reg.getContents());

  }

  /**
   * Test to check if a five dollar note is added successfully.
   */

  @Test
  public void addFives() {

    CashRegister reg = new SimpleRegister();
    reg.addFives(1);
    assertEquals(new HashMap<Integer, Integer>() {
      {
        put(500, 1);
      }
    }, reg.getContents());

    reg.addFives(100);
    assertEquals(new HashMap<Integer, Integer>() {
      {
        put(500, 101);
      }
    }, reg.getContents());

    try {
      reg.addFives(-1);
    } catch (Exception e) {
      assertEquals("money cannot be in negative", e.getMessage());
    }

    assertEquals(new HashMap<Integer, Integer>() {
      {
        put(500, 101);
      }
    }, reg.getContents());

  }

  /**
   * Test to check if a ten dollar note is added successfully.
   */

  @Test
  public void addTens() {

    CashRegister reg = new SimpleRegister();
    reg.addTens(1);
    assertEquals(new HashMap<Integer, Integer>() {
      {
        put(1000, 1);
      }
    }, reg.getContents());

    reg.addTens(100);
    assertEquals(new HashMap<Integer, Integer>() {
      {
        put(1000, 101);
      }
    }, reg.getContents());

    try {
      reg.addTens(-1);
    } catch (Exception e) {
      assertEquals("money cannot be in negative", e.getMessage());
    }

    assertEquals(new HashMap<Integer, Integer>() {
      {
        put(1000, 101);
      }
    }, reg.getContents());

  }

  @Test
  public void addingMultipleCoins() {
    CashRegister reg = new SimpleRegister();
    reg.addTens(10);
    assertEquals(new HashMap<Integer, Integer>() {
      {
        put(1000, 10);
      }
    }, reg.getContents());

    reg.addFives(20);
    assertEquals(new HashMap<Integer, Integer>() {
      {
        put(1000, 10);
        put(500, 20);
      }
    }, reg.getContents());

    reg.addOnes(30);
    assertEquals(new HashMap<Integer, Integer>() {
      {
        put(1000, 10);
        put(500, 20);
        put(100, 30);
      }
    }, reg.getContents());

    reg.addQuarters(40);
    assertEquals(new HashMap<Integer, Integer>() {
      {
        put(1000, 10);
        put(500, 20);
        put(100, 30);
        put(25, 40);
      }
    }, reg.getContents());

    reg.addDimes(50);
    assertEquals(new HashMap<Integer, Integer>() {
      {
        put(1000, 10);
        put(500, 20);
        put(100, 30);
        put(25, 40);
        put(10, 50);
      }
    }, reg.getContents());

    reg.addNickels(60);
    assertEquals(new HashMap<Integer, Integer>() {
      {
        put(1000, 10);
        put(500, 20);
        put(100, 30);
        put(25, 40);
        put(10, 50);
        put(5, 60);
      }
    }, reg.getContents());

    reg.addPennies(70);
    assertEquals(new HashMap<Integer, Integer>() {
      {
        put(1000, 10);
        put(500, 20);
        put(100, 30);
        put(25, 40);
        put(10, 50);
        put(5, 60);
        put(1, 70);
      }
    }, reg.getContents());

    reg.addPennies(10);
    reg.addPennies(10);
    reg.addNickels(5);
    reg.addDimes(5);
    reg.addQuarters(5);
    reg.addOnes(5);
    reg.addFives(5);
    reg.addTens(5);


    assertEquals(new HashMap<Integer, Integer>() {
      {
        put(1000, 15);
        put(500, 25);
        put(100, 35);
        put(25, 45);
        put(10, 55);
        put(5, 65);
        put(1, 90);
      }
    }, reg.getContents());

  }

  /**
   * Method to test withdrawal.
   *
   * @throws InsufficientCashException if not enough money available.
   */
  @Test
  public void testWithdrawal() throws InsufficientCashException {

    CashRegister reg = new SimpleRegister();
    reg.addPennies(2);
    reg.addNickels(1);
    reg.addDimes(5);
    reg.addQuarters(1);
    reg.addOnes(5);
    reg.addFives(5);
    reg.addTens(5);


    Map<Integer, Integer> handout = reg.withdraw(1, 20);

    assertEquals(new HashMap<Integer, Integer>() {
      {
        put(100, 1);
        put(10, 2);
      }
    }, handout);

    assertEquals(new HashMap<Integer, Integer>() {
      {
        put(1000, 5);
        put(500, 5);
        put(100, 4);
        put(25, 1);
        put(10, 3);
        put(5, 1);
        put(1, 2);
      }
    }, reg.getContents());


    Map<Integer, Integer> handout1 = reg.withdraw(10, 0);

    assertEquals(new HashMap<Integer, Integer>() {
      {
        put(1000, 1);
      }
    }, handout1);

    assertEquals(new HashMap<Integer, Integer>() {
      {
        put(1000, 4);
        put(500, 5);
        put(100, 4);
        put(25, 1);
        put(10, 3);
        put(5, 1);
        put(1, 2);
      }
    }, reg.getContents());


    try {
      reg.withdraw(2, 23);
    } catch (Exception e) {
      assertEquals("no money!", e.getMessage());
      assertEquals(new HashMap<Integer, Integer>() {
        {
          put(1000, 4);
          put(500, 5);
          put(100, 4);
          put(25, 1);
          put(10, 3);
          put(5, 1);
          put(1, 2);
        }
      }, reg.getContents());
    }


    try {
      reg.withdraw(1000, 50);
    } catch (Exception e) {
      assertEquals("no money!", e.getMessage());
      assertEquals(new HashMap<Integer, Integer>() {
        {
          put(1000, 4);
          put(500, 5);
          put(100, 4);
          put(25, 1);
          put(10, 3);
          put(5, 1);
          put(1, 2);
        }
      }, reg.getContents());
    }


    try {
      reg.withdraw(-1, 20);
      fail();
    } catch (Exception e) {
      assertEquals("money cannot be in negative", e.getMessage());
    }

    try {
      reg.withdraw(1, -20);
      fail();
    } catch (Exception e) {
      assertEquals("money cannot be in negative", e.getMessage());
    }

    try {
      reg.withdraw(-1, -20);
      fail();
    } catch (Exception e) {
      assertEquals("money cannot be in negative", e.getMessage());
    }

  }

  /**
   * method to test get audit method.
   *
   * @throws InsufficientCashException if enough money is not avaiable.
   */
  @Test
  public void testGetAudit() throws InsufficientCashException {
    CashRegister reg = new SimpleRegister();
    reg.addPennies(2);
    assertEquals("Deposit: 0.02", reg.getAuditLog());
    reg.addNickels(1);
    assertEquals("Deposit: 0.02\nDeposit: 0.05", reg.getAuditLog());
    reg.addDimes(5);
    assertEquals("Deposit: 0.02\n" +
            "Deposit: 0.05\n" +
            "Deposit: 0.50", reg.getAuditLog());
    reg.addQuarters(1);
    assertEquals("Deposit: 0.02\n" +
            "Deposit: 0.05\n" +
            "Deposit: 0.50\n" +
            "Deposit: 0.25", reg.getAuditLog());
    reg.addOnes(5);
    assertEquals("Deposit: 0.02\n" +
            "Deposit: 0.05\n" +
            "Deposit: 0.50\n" +
            "Deposit: 0.25\n" +
            "Deposit: 5.00", reg.getAuditLog());
    reg.addFives(5);
    assertEquals("Deposit: 0.02\n" +
            "Deposit: 0.05\n" +
            "Deposit: 0.50\n" +
            "Deposit: 0.25\n" +
            "Deposit: 5.00\n" +
            "Deposit: 25.00", reg.getAuditLog());
    reg.addTens(5);
    assertEquals("Deposit: 0.02\n" +
            "Deposit: 0.05\n" +
            "Deposit: 0.50\n" +
            "Deposit: 0.25\n" +
            "Deposit: 5.00\n" +
            "Deposit: 25.00\n" +
            "Deposit: 50.00", reg.getAuditLog());
    Map<Integer, Integer> handout = reg.withdraw(1, 20);
    assertEquals("Deposit: 0.02\n" +
            "Deposit: 0.05\n" +
            "Deposit: 0.50\n" +
            "Deposit: 0.25\n" +
            "Deposit: 5.00\n" +
            "Deposit: 25.00\n" +
            "Deposit: 50.00\n" +
            "Withdraw: 1.20", reg.getAuditLog());
  }


}

