package com.philip.first;

import org.testng.annotations.Test;
import com.philip.tools.DynInvoker;
import org.testng.Assert;

public class InvokeTest {
  @Test
  public void f() {
	  DynInvoker di = new DynInvoker();
	  String[] args = { "10", "what" };
	  String ret = di.Invoke("com.philip.first.Simple", "computeRentalCost", args);
	  System.out.println(ret);
	  Assert.assertNotEquals(ret, "", "empty ret string");
  }
}
