# Library Management System

## Table of Contents
- [Overview](#overview)
- [Motivation](#motivation)
- [Features](#features)
  - [Book Management](#book-management)
  - [Member Management](#member-management)
  - [Borrowing Records](#borrowing-records)
- [Installation](#installation)
- [Usage Instructions](#usage-instructions)
- [Data Management](#data-management)
- [Known Limitations](#known-limitations)
- [Disclaimer](#disclaimer)
- [Future Plans](#future-plans)
- [Contributing](#contributing)
- [Prerequisites](#prerequisites)
- [License](#license)

## Overview
Welcome to the Library Management System! This console-based application, developed in Java, provides essential functionalities to manage books, members, and borrowing records within a library. This project is designed to reinforce Java programming concepts and offers a simple and straightforward approach to library management.

## Motivation
The primary motivation behind this project is to solidify the understanding of core Java concepts through practical application. By building a library management system, we explore various aspects of Java, including object-oriented programming, data structures, file handling, and serialization.

## Features

### Book Management
- **Add Book**: Add new books to the library collection.
- **Update Book**: Update information of existing books.
- **Search Book**: Search for books by title, ISBN, or ID.
- **Display Books**: Display all existing books.

### Member Management
- **Add Member**: Register new members with unique IDs.
- **Update Member**: Update information of existing members.
- **Search Member**: Search for members by name or ID.
- **Display Members**: Display all existing members.

### Borrowing Records
- **Add Borrow Record**: Record the borrowing of books by members.
- **Handle Return**: Manage the return of borrowed books.
- **Display Borrow Records**: Display all existing borrow records.

## Installation
1. Download the `Library_Management_System_v1.0.0.exe` file from the [Releases](https://github.com/yourusername/library-management-system/releases) page. (Will be released soon!)
2. Save the `.exe` file in a separate folder to ensure proper organization of generated save files.
3. Run the `.exe` file to start the application.

## Usage Instructions
- Upon starting the application, you will be prompted to load existing data (if available).
- Use the console interface to add, update, search, and display books, members, and borrowing records.
- At the end of the session, you will be prompted to save the current data.

## Data Management
- A new save files folder will be created automatically upon first run in the same folder as the `.exe` file.
- It is recommended to keep the `.exe` file in a separate folder to manage the save files efficiently.

## Known Limitations
- **No Deletion Support**: Currently, the system does not support deleting books, members, or borrow records. This feature will be added in future releases.
- **GUI**: The current version is console-based. A graphical user interface (GUI) is planned for future updates.
- **Data Security**: Data is saved in `.ser` format without encryption. Avoid using sensitive information.

## Disclaimer
This Java application is provided "as is", without warranty of any kind, express or implied, including but not limited to the warranties of merchantability, fitness for a particular purpose, and noninfringement. In no event shall the authors or copyright holders be liable for any claim, damages, or other liability, whether in an action of contract, tort or otherwise, arising from, out of, or in connection with the software or the use or other dealings in the software.

This project is developed as a part of an educational exercise and is intended for demonstration and learning purposes only. It is not designed to be used in a production environment or with real-world data. The current version lacks features such as deletion support, a graphical user interface (GUI), and data encryption, which are critical for a fully functional library management system. Future updates may address these limitations, but there is no guarantee of such enhancements.

Users are advised to exercise caution and not to rely on the software for any purpose that requires accurate and secure data handling. The developers assume no responsibility for any loss of data, system crashes, or any other damage that may occur from using the application. Contributions and feedback are welcome to help improve the project, but please be aware that this is a learning project and may not receive regular updates or support.

## Future Plans
- Implementing delete functionality for books, members, and borrowing records.
- Developing a graphical user interface (GUI) to enhance user experience.

## Contributing
We welcome contributions to improve this project! Please fork the repository and submit pull requests with descriptive messages. Future enhancements suggestions are highly encouraged.

## Prerequisites
To contribute to this project, you need to have the following version or above installed:
- JDK 17

## License
This project is licensed under the MIT License. See the `LICENSE` file for details.
