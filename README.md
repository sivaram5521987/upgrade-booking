
## Tech stack
 - Spring boot 
 - Maven
 - Swagger

## Swagger URL after deploy locally

`http://localhost:8080/api/swagger-ui.html`


## API to book a reservation 

1. http://localhost:8080/booking <br/>
   Type: POST <br/>
   Body: {
           "bookingFrom": "2020-08-08",
           "days": 2,
           "email": "string",
           "firstName": "string",
           "lastName": "string"
         } <br/>
   Response: {
               "bookingIdentifier": "778e2514-5a89-48e9-979f-e13784a314ed"
             }
             
             