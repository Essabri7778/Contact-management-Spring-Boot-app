
# Contact management web application

## Introduction
In this project, we are developing a contact management application utilizing Spring Boot and a MariaDB database. Through this application, users gain the ability to store and manage their contacts efficiently.

## Features
- Create a new contact.
- Display the list of contacts in alphabetical order.
- Delete a contact.
- Modify a contact.
- Search for a contact by name.
- Search for a contact by phone number (entering either the personal or professional number will display the other information).
- Create groups. A group has a name (e.g., family, friends, etc.) and can consist of zero or more contacts.
- Delete a group. Deleting a group does not remove the associated contacts. Also, add the ability to search for a group by its name.
- Automatically create groups consisting of contacts with the same name.
- Improve the contact search by name using phonetic search (using the SQL SOUNDEX function).
- Improve the name search functionality to allow finding contacts even in case of minor misspellings in the entered name, using the String Edit Distance Algorithm.

## Technologies Used
- Back-end: Spring Boot, Spring Data JPA
- Front-end: JSP, JSTL, CSS, Bootstrap
- Database: MariaDB (MySQL)

