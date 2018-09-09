package constructorInheritance;

class Person {
	
	 Person(int a)
     {
              System.out.println("Constructor of person class"+a);
      }
	 
	 Person()
     {
              System.out.println("Constructor of person class");
      }
	 
	 
	

}


class Employee extends Person
{
     Employee()
     {
    	
              System.out.println("Constructor of employee class");
      }


}


class PermanentEmployee extends Person
{
     PermanentEmployee()
     {
    	    
             System.out.println("Constructor of permanent employee class");
      }

	public PermanentEmployee(int i) {
		super(i);
		
		System.out.println(i);
	}
}

