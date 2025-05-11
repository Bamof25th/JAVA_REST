Spring Data JPA Links (Bookmark them!)
1.	API Docs : 
https://docs.spring.io/spring-data/data-jpa/docs/current/api/
2. Ref docs : 
https://docs.spring.io/spring-data/jpa/docs/current-SNAPSHOT/reference/html/#reference
3. Spring java docs
Link : https://docs.spring.io/spring-framework/docs/current/javadoc-api/
4. https://www.w3schools.com/tags/ref_httpmessages.asp

1. Revise 
1.1 Back end development of full stack application
1.2 Annotations
@ResponseBody
@RestController
@RequestBody
@PathVariable
@CrossOrigin
(Refer to readme - day16-data\day16_help\REST\RestController vs MVC Controller n Annotations.txt)

Solve
Objectives – 
1.	As per RESTful norms , instead of sending only response body , send entire response packet (at least containing – Status code n body)
How ? – ResponseEntity<T>
T – type of the response body

2.	 Response packet should contain -
In case of restaurants available – SC 200 + List<Restaurant>
Otherwise – SC 204
Refer - "day16_help\Advanced REST\readmes\regarding ResponseEntity.txt"
2. Add new Restaurant
Successful response – SC 201 n
DTO - Data Transfer object conataining a message+timestamp
Failure response – Suitable error code + DTO 

3. Delete restaurant details
i/p - Restaurant id (soft delete)
Successful response – SC 200 n 
DTO - Data Transfer object conataining a message+timestamp
Failure response – Suitable error code + DTO
4. Enter Advanced REST 
(E-R with REST API)
4.1 Add the association from Restaurant class.
4.2 Run the end point - get all restaurants | get restaurant details by id
Observation – 
lazy initialization | stack overflow to due recursion
root cause - bi dir association
(during serialization Jackson converter ,  tries to serialize  food items from Restaurant n from food item tries to serialize  Restaurant)
(For seeing the problem - run postman client)

4.3 Technically speaking – you can Use @JsonIgnore (jackson annotation) to tell Jackson(vendor for ser n de-ser) to skip a field during ser n de-ser.
Not an effective solution !
Reason - If REST clnt needs to fetch Restaurant + food item details - it won't be possible, since @JsonIgnore is used !!!
4.4 Clean n recommended solution -
DO NOT expose entities for data exchange between REST clnt n REST server , use them only for persistence.
Instead use DTO(Data transfer obj) pattern to exchange data between client n server.
Entity --> DTO (is required during serialization.)
Create DTO instance , read data from entity(getter) --> set the data in DTO (setter)
DTO --> Entity (is required during de-serialization)
Create entity instance , read data from dto(getter) --> set the data in entity (setter)
4.5  Instead of doing these conversion ourselves --there are ready made 3rd party libraries -
meant for src object --> dest object conversion.
eg : ModelMapper, MapStruct
Refer - "day17_help\Advanced REST\readmes\Regarding ModelMapper.txt"
Objective - Create RestaurantDTO , with required fields.
Control property access (@JsonProperty) , if required.
Refer - "day17_help\Advanced REST\readmes\Content Negotiation.txt"
Modify service layer , to return List of Restaurant entity or DTO ?
DTO
Test it !
4.6 Fix errors in 
getAllRestaurants
addNewRestaurant

5. Solve (Lab work )
Add new end point to get Restaurant n all blog food items associated
URL http://host:port/restaurants/{RestaurantId} /food items
URI variable - Restaurant id
Response - Restaurant + food item details(id , creation tm , update time, title , desc , contents)

6. Solve- Add new Food item
	 *  URL - http://host:port/food_items
	 * Method - POST 
	 * payload - FoodItemcReqDTO (Restaurant Id food item details) 
	 * Successful Resp - SC 201  + mesg (ApiResponse)
	 * Error resp - SC 400 , error mesg -wrapped in DTO(ApiResponse)

6. Solve – Lab work
Assign user address
Which controller ? - 
Desc - Assign user address
URL – http://host:port/users/{userId}/address
Method – POST
Payload – dto (address details+user Id)
Success resp- Api Resp with success mesg | address dto
Error resp - Api Resp with err mesg

7. Get all food items by specific restaurant (Lab work)
i/p – resturant id
resp – List<Food item>
8.Spring Boot Testing
Refer - "day17-data\day17_help\Advanced REST\Advanced REST\readmes\Regarding Spring Boot Testing.txt"

7.1 Write unit test for DAO layer testing of user signin.
7.2 Write integration test (service layer test) for assigning user address.
7.3 Write integration test to get all users by specified city
7.4 Write unit test for getting all available food items  by specified Restaurant


8. 
Objective : User sign in endpoint 
URL : http://host:port/users/signin
Method : POST (for adding email n pwd : in request body as additional security.)
Desc - User signin
	 *  URL - http://host:port/users/signin
	 * Method - POST 
	 * payload - dto (email n pwd)
	 * Successful Resp - SC 200,  user details - all (dto) excluding password
	 * Error resp - SC 400 , error mesg -wrapped in DTO(ApiResponse)

