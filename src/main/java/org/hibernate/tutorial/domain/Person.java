package org.hibernate.tutorial.domain; 

public class Person 
{ 
    private Long id;     
	private int age;
	private String firstName;
	private String lastName;
    
	// ctr
    public Person() {} 
    
	public Long getId() 
	{ 
        return id; 
    } 
    
	private void setId(Long id) 
	{ 
        this.id = id; 
    } 
    
	public int getAge()
	{
		return this.age;
	}                   
	
	public void setAge(int age)
	{
		this.age = age;
	}                  

	public String getLastName()
	{
		return this.lastName;
	}                         
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public String getFirstName()
	{
		return this.firstName;
	}                         
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
}