public class Contact
{	
	////////declaring class attributes
	private String firstName;
	private String lastName;
	private long phoneNumber;
	private String email;
	private int age;

	///////constructor
	public Contact (String newFirstName, String newLastName, long newPhoneNumber, String newEmail,int newAge)
	{
		this.firstName = newFirstName;
		this.lastName = newLastName;
		this.phoneNumber = newPhoneNumber;
		this.email = newEmail;
		this.age = newAge;
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
	
	/////////method to get a string that is a contact output
	public String getContactOutput()
	{
		return "First Name: \u001B[34m" + firstName + "\u001B[0m\nLast Name: \u001B[34m" + lastName + "\u001B[0m\nPhone Number: \u001B[33m" + phoneNumber + "\u001B[0m\nEmail: " + email + "\nAge: " + age;
	}
}