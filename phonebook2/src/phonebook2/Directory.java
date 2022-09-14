package phonebook2;

import java.util.Arrays;
import java.util.Scanner;

public class Directory {

	ContactInfo[] phoneBook = new ContactInfo[0];

	public void addEntry(ContactInfo newPerson) {

		ContactInfo[] tempArray = new ContactInfo[phoneBook.length + 1];

		for (int i = 0; i < phoneBook.length; i++) {

			tempArray[i] = phoneBook[i];
		}

		tempArray[tempArray.length - 1] = newPerson;

		phoneBook = tempArray;
	}

	public void searchByName(String searchTerm) {

		String[] orderedArray = new String[phoneBook.length];

		for (int i = 0; i < phoneBook.length; i++) {
			orderedArray[i] = phoneBook[i].getFullName();
		}

		Arrays.sort(orderedArray);

		for (int j = 0; j < orderedArray.length; j++) {
			for (int k = 0; k < phoneBook.length; k++) {
				if (orderedArray[j] == phoneBook[k].getFullName()) {
					if (phoneBook[k].toString().contains(searchTerm)) {
						System.out.println(phoneBook[k]);
					} else {
						System.out.println("No Matches Found!");
					}
				}
			}
		}

		System.out.println("Press enter to return main menu:");
		Scanner input = new Scanner(System.in);
		String returnMainMenu = input.nextLine();

	}

	public void displayAll() {
		if (phoneBook.length != 0) {

			String[] orderedArray = new String[phoneBook.length];

			for (int i = 0; i < phoneBook.length; i++) {
				orderedArray[i] = phoneBook[i].getFullName();
			}

			Arrays.sort(orderedArray);

			for (int j = 0; j < orderedArray.length; j++) {
				for (int k = 0; k < phoneBook.length; k++) {
					if (orderedArray[j] == phoneBook[k].getFullName()) {
						System.out.println(phoneBook[k]);
					}
				}
			}
		} else {
			System.out.println("No Entries found!");
		}

		System.out.println("Press enter to return main menu:");
		Scanner input = new Scanner(System.in);
		String returnMainMenu = input.nextLine();

	}

	public void searchEntryByPhoneNumber(String searchTerm) {
		for (int i = 0; i < phoneBook.length; i++) {
			if (phoneBook[i].toString().contains(searchTerm)) {
				System.out.println(phoneBook[i]);
			} else {
				System.out.println("No Matches Found!");
			}
		}

		System.out.println("Press enter to return main menu:");
		Scanner input = new Scanner(System.in);
		String returnMainMenu = input.nextLine();
	}

	public void deleteEntryByPhoneNumber(String searchTerm) {

		ContactInfo[] tempArray = new ContactInfo[phoneBook.length - 1];

		int x = 0;

		for (int y = 0; y < phoneBook.length; y++) {
			if (phoneBook[y].toString().contains(searchTerm)) {

				for (int i = 0; i < phoneBook.length; i++) {
					if (!phoneBook[i].toString().contains(searchTerm)) {
						tempArray[x] = phoneBook[i];
						x++;
					}
				}
				phoneBook = tempArray;
			} else {
				System.out.println("No Matches Found!");
			}

		}

	}

	public void updateEntryByPhoneNumber(String searchTerm) {

		for (int i = 0; i < phoneBook.length; i++) {
			if (phoneBook[i].toString().contains(searchTerm)) {

				System.out.println("What do you want to update? \n"
						+ "-1. Full name\n" + "-2. Street address\n" + "-3. City\n" + "-4. State\n" + "-5. Zip code\n"
						+ "-6. Phone number\n" + "-7. Finished updating\n");
				Scanner newInput = new Scanner(System.in);
				String updateNeeded = newInput.nextLine();

				switch (updateNeeded) {
				case "1":
					System.out.println("Enter full name:");
					String a = newInput.nextLine();
					phoneBook[i].setFullName(a);
					break;
				case "2":
					System.out.println("Enter street address:");
					String b = newInput.nextLine();
					phoneBook[i].setStreetAddress(b);
					break;
				case "3":
					System.out.println("Enter city:");
					String c = newInput.nextLine();
					phoneBook[i].setCityName(c);
					break;
				case "4":
					System.out.println("Enter state (i.e. MO):");
					String d = newInput.nextLine();
					phoneBook[i].setStateName(d);
					break;
				case "5":
					System.out.println("Enter zip code:");
					String e = newInput.nextLine();
					phoneBook[i].setZipCode(e);
					break;
				case "6":
					System.out.println("Enter phone number:");
					String f = newInput.nextLine();
					phoneBook[i].setPhoneNumber(f);
					break;
				default:
					System.out.println("Invalid entry. Please select again");
					break;
				}

			} else {
				System.out.println("Phone number not found");
			}
		}
		System.out.println("Press enter to return main menu:");
		Scanner input = new Scanner(System.in);
		String returnMainMenu = input.nextLine();
	}
}