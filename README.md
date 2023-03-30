Overview
This project is a parking application that enables users to reserve parking slots using their mobile devices. The application is divided into two modules: the Admin module and the User module. The Admin module is written in Java and JavaFX, while the User module is written using Node.js and the Django and Spring Boot frameworks.
Database
Both modules utilize a MySQL database to store and manage data. The database stores information such as user account details, parking slot information, and reservation details. The database is accessed and manipulated through SQL queries from both the Admin module and the User module.

The database design follows a relational model, with tables designed to store data in a normalized format to minimize data redundancy and ensure data integrity. The use of indexes and constraints also helps to improve performance and prevent data inconsistencies.

Overall, the use of a MySQL database adds to the application's reliability and scalability, ensuring that it can handle large amounts of data efficiently and securely.

Admin Module
The Admin module is designed to enable parking lot administrators to manage the parking spaces, track occupancy levels, and monitor reservations. To access the Admin module, the administrator must first login or signup. Once logged in, the administrator is presented with a dashboard where they can view statistics about the parking lot, including reserved spaces, occupied spaces, and free spaces. The dashboard also provides the administrator with the ability to manage reservations, update parking slot information, and track payments.

User Module
The User module is designed to allow users to reserve parking slots using their mobile devices. Upon opening the application, the user is presented with a map that shows the parking lot based on their current location. The user can select a parking slot and reserve it. To make a payment, the user is redirected to a payment gateway that uses the Daraja M-Pesa API to process payments. Once the payment is successful, the user receives a confirmation text message with the reservation details.

The application provides a seamless and user-friendly experience, enabling users to reserve parking slots quickly and easily. The integration with the Daraja M-Pesa API ensures that payments are processed securely and efficiently, further enhancing the overall user experience.

Conclusion
In conclusion, this parking application provides a valuable service to users and administrators alike. The application's intuitive interface and robust features make it a valuable addition to any parking lot management system.



