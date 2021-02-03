public class Contact
{	
	////////declaring class attributes
	private String firstName;
	private String lastName;
	private long phoneNumber;
	private String email;
	private int age;

	///////constructor
	public Contact (String firstName, String lastName, long phoneNumber, String email,int age)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.age = age;
	}

	///////empty constructor for temp variables
	public Contact()
	{
	
	}

	//////getter methods
	public long getPhoneNumber()
	{
		return phoneNumber;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public int getAge()
	{
		return age;
	}

	public String getLastName()
	{
		return lastName;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	/////////method to get a contact output as a string
	public String getContactOutput()
	{
		return "First Name: \u001B[34m" + firstName + "\u001B[0m\nLast Name: \u001B[34m" + lastName + "\u001B[0m\nPhone Number: \u001B[33m" + phoneNumber + "\u001B[0m\nEmail: " + email + "\nAge: " + age;
	}
}