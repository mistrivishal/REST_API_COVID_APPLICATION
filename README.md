# REST API - COVID APLLICATON

This application will facilitate the citizen with an option to register and schedule the vaccination session online in Centers of their choice. The Citizen self-registration module will ensure fool-proof identification of deserving candidates for receiving the vaccines.

# Features

- Data Authentication and Validation for all the users (Admin and Member)
- REST API documentation using swagger puglins

## Admin Features

- Admin can access all the information of vaccination centers and Member Information.
- Admin can access perform all CRUD operation related to vaccination center and members as well.

## Customer Features

- Customer can login in the application and update their information using their username and password.
- Customer can book trips using pickup location and destination.
- Customer can access the bill after the trip is completed.

# Installation & Run

- Before running the API server, you should update the database config inside the application.properties file.
- Update the port number, username and password as per your local database configuration.

```
    server.port=8080

    spring.datasource.url=jdbc:mysql://localhost:3306/cowindb;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root
```

# API Root Endpoint
```
https://localhost:8080/
```
```
http://localhost:8080/swagger-ui/
```
# API Reference

## Customer Requests

### Member Controller

| Request | METHOD     |  URI | Description                |
| :-------- | :------- | :----- | :------------------------- |
| `PUT` | `Update` | `http://localhost:8080/user/update` | Update existing user |
| `POST` | `register` | `http://localhost:8080/user/register` | Register new user |
| `POST` | `Login` | `http://localhost:8080/user/login` | User Login |
| `POST` | `Book Appointment` | `http://localhost:8080/user/bookappointment` | Book Appoinment |
| `POST` | `Appointment Detail` | `http://localhost:8080/user/appointmentdetails` | Appointment Detail |
| `POST` | `Get Member` | `http://localhost:8080/user/getmeber/mobile` | Get Member By Mobile Number |
| `GET` | `Center List` | `http://localhost:8080/user/allcenters` | Center List |
| `DELETE` | `Delete` | `http://localhost:8080/user/delete` | Delete existing user |
| `DELETE` | `Cancel Appointment` | `http://localhost:8080/user/cancelappointment` | Cancel Appoinment |

## Admin Requests

### Vaccine Center Admin Controller :

| Request | METHOD     |  URI | Description                |
| :-------- | :------- | :----- | :------------------------- |
| `PUT` | `Update Center` | `http://localhost:8080/admin/updatecenter` | Update Center Details |
| `DELETE` | `Delete Center` | `http://localhost:8080/admin/removecenter` | Remove Center Details |
| `GET` | `Center List` | `http://localhost:8080/admin/allcenters` | Get All center Details |
| `POST` | `Create Center` | `http://localhost:8080/admin/savecenter` | Save new center details |
| `POST` | `Center By Id` | `http://localhost:8080/admin/getcenterbyid` | Get Center details by center ID |


# Sample API response - Member Registeration

### Request Type
```
POST
```

### Request URI
```
http://localhost:8080/customer/create
```

### Request Body
```
{
    "mobileno": "9953805224",
    "passWord":"ram@123",
    "adharcard": {
        "adharNo": "224319664199",
        "name": "Ramesh",
        "dob": "08/15/1995",
        "gender": "M",
        "addressline": "Ayodhya",
        "city": "Ayodhya",
        "state": "UP",
        "pincode": "432939"
    }
}
```
### Response Body

```
{
    "memberId": 5,
    "mobileno": "9953805224",
    "passWord": "ram@123",
    "adharcard": {
        "adharNo": "224319664199",
        "name": "Ramesh",
        "dob": "08/15/1995",
        "gender": "M",
        "addressline": "Ayodhya",
        "city": "Ayodhya",
        "state": "UP",
        "pincode": "432939"
    }
}

```

### This is a collaborative project, completed by a team of 5 backend developers at Masai School.

# Collaborators

- [Vishal Mistri](https://www.github.com/mistrivishal)
- [Shivam Rajput](https://www.github.com/CodingShivam)
- [Sanjay Kushwaha](https://www.github.com/kushites)
- [Shubham Sing Bhadouria](https://www.github.com/Shubhambhadouria)

# - Tech Stack
- Java
- Hibernate
- Spring Framework
- Spring Boot
- Spring Data JPA
- MySQL
- Swagger UI
- Maven