package phonebook2;

import java.util.Scanner;

public class ProjectIndex {

	public static void main(String[] args) {

		String action = "";
		Directory dir1 = new Directory();

		do {

			System.out.println("Very Nice PhoneBook!!!");
			System.out.println("Select one of the below");
			System.out.println("1. Add a new entry :");
			System.out
					.println("2. Search for an existing entry: \n" + "      -by first name\n  " + "    -by last name\n"
							+ "      -by full name\n" + "      -by city or state\n" + "      -by telephone number");
			System.out.println("3. Search for existing entry by phone number:");
			System.out.println("4. Delete a record of a phone number:");
			System.out.println("5. Update a record of a phone number:");
			System.out.println("6. Show all entries:");
			System.out.println("7. Exit");
			System.out.println("Select from above");

			Scanner input = new Scanner(System.in);
			action = input.nextLine();

			if (action.equals("7")) {
				System.out.println("Thank you, Goodbye!");
				break;
			} else {

				switch (action) {

				case "1":
					Scanner a = new Scanner(System.in);
					System.out.println("What is your full name, address, and"
							+ " phone number? (e.g. Joe Rogan, 935 Rutgers, St Louis," + " MO, 63104, 9563378878:");
					String userEntry = a.nextLine();

					String[] userEntryArray = userEntry.split(",");
					ContactInfo newPerson = new ContactInfo(userEntryArray[0], userEntryArray[1], userEntryArray[2],
							userEntryArray[3], userEntryArray[4], userEntryArray[5]);

					dir1.addEntry(newPerson);
					break;

				case "2":

					System.out.println("Enter full name, last name, first name, city, or state abbreviation: ");
					Scanner b = new Scanner(System.in);

					String searchTerm = b.nextLine();

					dir1.searchByName(searchTerm);
					break;

				case "3":

					System.out.println("Enter phoneNumber (i.e. 9563378878:)");
					Scanner c = new Scanner(System.in);

					String searchNumber = c.nextLine();

					searchTerm = "(" + searchNumber.charAt(0) + searchNumber.charAt(1) + searchNumber.charAt(2) + ")-"
							+ searchNumber.charAt(3) + searchNumber.charAt(4) + searchNumber.charAt(5) + "-"
							+ searchNumber.charAt(6) + searchNumber.charAt(7) + searchNumber.charAt(8)
							+ searchNumber.charAt(9);

					dir1.searchEntryByPhoneNumber(searchTerm);
					break;
				case "4":

					System.out.println("Enter phoneNumber (i.e. 6366435698):");
					Scanner d = new Scanner(System.in);

					String searchNumber2 = d.nextLine();

					searchTerm = "(" + searchNumber2.charAt(0) + searchNumber2.charAt(1) + searchNumber2.charAt(2)
							+ ")-" + searchNumber2.charAt(3) + searchNumber2.charAt(4) + searchNumber2.charAt(5) + "-"
							+ searchNumber2.charAt(6) + searchNumber2.charAt(7) + searchNumber2.charAt(8)
							+ searchNumber2.charAt(9);

					dir1.deleteEntryByPhoneNumber(searchTerm);
					break;
				case "5":

					System.out.println("Enter the phone number of the entry to be updated:");

					Scanner e = new Scanner(System.in);
					String searchNumber3 = e.nextLine();

					searchTerm = "(" + searchNumber3.charAt(0) + searchNumber3.charAt(1) + searchNumber3.charAt(2)
							+ ")-" + searchNumber3.charAt(3) + searchNumber3.charAt(4) + searchNumber3.charAt(5) + "-"
							+ searchNumber3.charAt(6) + searchNumber3.charAt(7) + searchNumber3.charAt(8)
							+ searchNumber3.charAt(9);

					dir1.updateEntryByPhoneNumber(searchTerm);
					break;

				case "6":

					dir1.displayAll();
					break;

				default:
					System.out.println("Invalid entry. Try again!");
					break;
				}
			}

		} while (action != "7");
	}
}