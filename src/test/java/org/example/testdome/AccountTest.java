package org.example.testdome;

import org.junit.Assert;
import org.junit.Test;

public class AccountTest {
  private double epsilon = 1e-6;

  @Test
  public void accountCannotHaveNegativeOverdraftLimit() {
    Account account = new Account(-20);

    Assert.assertEquals(0d, account.getOverdraftLimit(), epsilon);
  }

  @Test
  public void depositCannotAcceptNegativeValue() {
    Account account = new Account(10);
    double negativeAmount = -1.0;

    boolean result = account.deposit(negativeAmount);

    Assert.assertEquals(false, result);
  }

  @Test
  public void withdrawCannotAcceptNegativeValue() {
    Account account = new Account(10);
    double negativeAmount = -1.0;

    boolean result = account.withdraw(negativeAmount);

    Assert.assertEquals(false, result);
  }

  @Test
  public void accountCannotOverstepOverdraftLimit() {
    double overdraftLimit = 10.0;
    double amount = overdraftLimit + 1;
    Account account = new Account(overdraftLimit);

    boolean result = account.withdraw(amount);

    Assert.assertEquals(false, result);
  }

  @Test
  public void depositAmountBalanceCalculatedSuccessfully() {
    Account account = new Account(10.0);

    account.deposit(20.0);
    double resultBalance = account.getBalance();

    Assert.assertEquals(20.0, resultBalance, epsilon);
  }

  @Test
  public void withdrawAmountBalanceCalculatedSuccessfully() {
    Account account = new Account(10.0);

    account.withdraw(5.0);
    double resultBalance = account.getBalance();

    Assert.assertEquals(-5.0, resultBalance, epsilon);
  }

  @Test
  public void depositAmountCorrectResult() {
    Account account = new Account(10.0);

    boolean result = account.deposit(20.0);

    Assert.assertEquals(true, result);
  }

  @Test
  public void withdrawAmountCorrectResult() {
    Account account = new Account(10.0);

    boolean result = account.withdraw(5.0);

    Assert.assertEquals(true, result);
  }
}