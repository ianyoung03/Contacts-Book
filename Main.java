import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.*;
import java.util.Scanner;
class Main 
{
  /////////method to delete contact
	public static void deleteContact(List<Contact> people)
	{
		Scanner scan = new Scanner (System.in);	
		
		System.out.println("Choose a contact to delete (type 1 for the first person in the list, 2 for the second person, etc)");

		people.remove(Integer.parseInt(scan.nextLine()) - 1);

	}
	//////////method to sort by phone number
	public static void sortByNumber(List<Contact> people)
	{
		Contact temp = new Contact();
		
		for (int i = 0; i < people.size() - 1; i++)
		{
			for (int j = 0; j < people.size() - 1 - i; j++)
			{
				if ((people.get(j)).getPhoneNumber() > (people.get(j+1)).getPhoneNumber())
				{
					temp = people.get(j);
					
					people.set(j, people.get(j+1));
					
					people.set(j+1, temp);
				}
			}
		}
	}
	////////method to search for a contact by first name
	public static int findName(List<Contact> people, String key)
	{
		sortByFirstName(people, people.size());

		int mid = people.size()/2;
		int first = 0;
		int last = people.size() -1;

		while (first <= last)
		{
			if ((people.get(mid).getFirstName()).compareTo(key) < 0)
			{
				first = mid + 1;
			}

			else if ((people.get(mid).getFirstName()).compareTo(key) == 0)
			{
				return mid;
			}
			else
			{
				last = mid -1;
			}

			mid = (first+last)/2;
			if (first > last)
			{
				return -1;
			}
		}
		return -1;
	}
	/////////sort by first name method
	public static void sortByFirstName(List<Contact> people, int n)
	{
		for (int i = 0; i < n-1; i++)
		{
			if ((people.get(i).getFirstName()).compareTo(people.get(i+1).getFirstName()) > 0)
			{
				Contact temp = new Contact();

				temp = people.get(i);

				people.set(i, people.get(i+1));

				people.set(i+1, temp);
			}
			sortByFirstName(people, n-1);
		}
		if (n == 1);
			return;
	}
	////////method to add a contact
	public static void addContact(List<Contact> people)
	{
		String newFirstName;
		String newLastName;
		long newPhoneNumber;
		String newEmail;
		int newAge;
		Scanner scan = new Scanner (System.in);

		System.out.println("Enter first name");
		newFirstName = scan.nextLine();	
		System.out.println("Enter last name");
		newLastName = scan.nextLine();	
		System.out.println("Enter phone number");
		newPhoneNumber = Long.parseLong(scan.nextLine());	
		System.out.println("Enter email");
		newEmail = scan.nextLine();	
		System.out.println("Enter age");
		newAge = Integer.parseInt(scan.nextLine());	

		people.add(new Contact(newFirstName, newLastName, newPhoneNumber, newEmail, newAge));
		

	}
	/////////method to scan the input file
	public static void scanFile(List<Contact> people) throws IOException
	{
		String newFirstName;
		String newLastName;
		long newPhoneNumber;
		String newEmail;
		int newAge;
		File myFile = new File("ContactInfo.txt");
		Scanner myReader = new Scanner(myFile);

		while (myReader.hasNextLine())
		{
			newFirstName = myReader.nextLine();
			newLastName = myReader.nextLine();
			newPhoneNumber = Long.parseLong(myReader.nextLine());
			newEmail = myReader.nextLine();
			newAge = Integer.parseInt(myReader.nextLine());
			
			people.add(new Contact(newFirstName, newLastName, newPhoneNumber, newEmail, newAge));
		}
		myReader.close();	
	}

	/////////method to print the contacts
	public static void printContacts(List<Contact>people)
	{
		for (int i = 0; i < people.size(); i++)
		{
			System.out.println("\n" + (people.get(i)).getContactOutput());
		}
		
	}
	//////////method to print the contacts in reverse
	public static void printContactsReverse(List<Contact>people)
	{
		for (int i = people.size() - 1; i >= 0; i--)
		{
			System.out.println("\n" + (people.get(i)).getContactOutput());
		}
		
	}

	////////method to prin the menu
	public static void printMenu()
	{
		System.out.println("\nWhat would you like to do with the contacts? Click the numbers that correspond with what you want to do");
		System.out.println("1. Add a contact");
		System.out.println("2. Delete a contact");
		System.out.println("3. Display all contacts sorted by phone number");
		System.out.println("4. Search for contacts by their first name using binary search");	
		System.out.println("5. Display the contacts sorted by age");
		System.out.println("0. Quit");
	}


	/////////method for getting number inputs
	public static int getNumber()
   {
      Scanner scan = new Scanner (System.in);
      boolean checker = true;
			int number = 0;
      while(checker)
      {
         try
         {
            number = Integer.parseInt(scan.nextLine());
            if (number< 0  || number > 5)
               throw new Exception("");
            
						checker = false;
         }
         catch (Exception e)
         {
            System.out.println("Invalid input. Please input between 1 and 5 or 0 to quit");
         }
      }
      return number;
   }



	////////method to get name string inputs 
	public static String getName()
	{
		Scanner scan = new Scanner (System.in);
		String key;
		System.out.println("Please enter the name");
		key = scan.nextLine();
		return key;
	}

	////////method to sort by age
	public static void sortByAge(List<Contact> people)
	{
		Contact temp = new Contact();
		
		for (int i = 0; i < people.size() - 1; i++)
		{
			for (int j = 0; j < people.size() - 1 - i; j++)
			{
				if ((people.get(j)).getAge() > (people.get(j+1)).getAge())
				{
					temp = people.get(j);
					
					people.set(j, people.get(j+1));
					
					people.set(j+1, temp);
				}
			}
		}
	}
	///////method to print to a file
	public static void printToFile(List<Contact> people) throws IOException
	{
		File myFile = new File("UpdatedContactInfo.txt");

		myFile.createNewFile();

		FileWriter myWriter = new FileWriter("UpdatedContactInfo.txt");

		for (int i = 0; i < people.size(); i++)
		{
			myWriter.write(people.get(i).getFirstName() + "\n");
			myWriter.write(people.get(i).getLastName() + "\n");
			myWriter.write(people.get(i).getPhoneNumber() + "\n");
			myWriter.write(people.get(i).getEmail() + "\n");
			myWriter.write(people.get(i).getAge() + "\n");
		}
		myWriter.close();
	}
	////////main method
	public static void main(String[] args) throws IOException
	{
		///////declaring variables
    List<Contact> people = new ArrayList<Contact>();
		int choice = 1;
		String key;

		/////scanning in contacts file and printing contacts
		scanFile(people);
		printContacts(people);
		///////main loop
		while (choice != 0)
		{			
			printMenu();
			choice = getNumber();
			
			if (choice == 1)
			{
				addContact(people);
				printContacts(people);
			}	
			else if (choice == 2)
			{
				deleteContact(people);
				printContacts(people);
			}
			else if (choice == 3)
			{
				sortByNumber(people);
				printContacts(people);
			}
			else if (choice == 4)
			{
				try
				{
					key = getName();
					System.out.println(people.get(findName(people,key)).getContactOutput() + "\n\n");
				}
				catch (Exception e)
				{
					System.out.println("Name not found");
				}
			}
			
			else if (choice == 5)
			{
				sortByAge(people);
				System.out.println("Do you want to print it in order or reverse order? 1 for in order, 2 for reverse");
				choice = getNumber();
				if (choice == 1)
					printContacts(people);
				else
					printContactsReverse(people);
			}
			else
				break;
		}
		///////printing to the updated file at the end
		printToFile(people);
  }
}