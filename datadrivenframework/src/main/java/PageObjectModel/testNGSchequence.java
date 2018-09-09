package PageObjectModel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testNGSchequence {	    
		@Test
		public void test1() 
		{
		  System.out.println("In the test1" );
		}	
		  
		@Test 
		public void test2() 
		{
			  System.out.println("In the test2");
		}

		@Test	  
		public void test3() 
		{
		System.out.println("In the test3");
		}
				  
		  
		  
		  @BeforeMethod
		  public void beforeMethod()
		  {
			  System.out.println("In the before method ");
		  }

		  @AfterMethod
		  public void afterMethod() 
		  {
			  System.out.println("In the After method");

		  }
		  

		  @BeforeTest
		  public void beforeTest()
		  {
			  System.out.println("In the before Test");

		  }

		  @AfterTest
		  public void afterTest() 
		  
		  {
			  System.out.println("In the After Test");

		  }


		}

