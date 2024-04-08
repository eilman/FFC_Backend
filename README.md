# HAVEKITCHEN APP
The HAVEKITCHEN application enables users can manage orders&amp;restaurants.
This repository includes Backend side of the HaveKitchen Application.
Java and Springboot were used.

# Build Instructions 
Simply import existing project into workspace from your cloned folder.
Install the dependencies and run the Springboot project.

# BaseURL: http://localhost:8081/ffc

# Authentication
Endpoint: POST /login
Parameters: username(String), password(String)
Since some of the JWT methods were deprecated and full with errors, simple username-password check method was used to login.

# User Functionalities
Get All Users
Endpoint: GET /users
Output: Users(List)

Get A User
Endpoint: GET /getUser/{userId}
Parameters: userId(Long)
Output: Users(List)

# Order Functionalities
Get All Orders
Endpoint: GET /orders
Output: Orders(List)

Create Order
Endpoint: POST /createOrder/{userId}
Parameters: PathVariable Long userId(Long), RequestBody savedRequest(Orders)
Output: Order(Order)

Update Order
Endpoint: PUT /updateOrder/{orderId}
Parameters: PathVariable Long orderId(Long), RequestBody savedRequest(Orders)
Output: Order(Order)

Delete Order
Endpoint: DELETE /deleteOrder/{orderId}
Parameters: PathVariable Long orderId(Long)
Output: -

# Restaurant Functionalities
Get All Restaurants
Endpoint: GET /restaurants
Output: Restaurants(List)

Create Restaurant
Endpoint: POST /createRestaurant
Output: Restaurant(Restaurant)

Update Restaurant
Endpoint: PUT /updateRestaurant/{restaurantId}
Parameters: PathVariable Long userId(Long), RequestBody savedRequest(Restaurant)
Output: Restaurant(Restaurant)

Delete Restaurant
Endpoint: DELETE /deleteRestaurant/{restaurantId}
Parameters: PathVariable Long restaurantId(Long)
Output: -

# Project Structure
controller: Contains controller classes that handle API requests.
service: Contains service classes that implement business logic.
repository: Contains repository classes that perform database operations.
entity: Contains entity classes that represent database tables.
request: Contains request classes.

# Entity Classes
Users: An entity class representing user information.
Orders: An entity class representing orders.
Restaurants: An entity class representing restaurants.

# Repository Classes
UserRepository: A repository class that performs database operations related to users.
OrderRepository: A repository class that performs database operations related to orders.
RestaurantRepository: A repository class that performs database operations related to restaurants .

# Service Classes
UserService: A service class that implements business logic related to users.
OrderService: A service class that implements business logic related to orders.
RestaurantService: A service class that implements business logic related to restaurants.

# Controller Classes
UserController: A controller class that handles API requests related to users.
OrderController: A controller class that handles API requests related to orders.
RestaurantController: A controller class that handles API requests related to restaurants.

# Usage Information and Assumptions
After logging in to the HaveKitchen application, we are redirected to the Home page. Click on the SideBar button that becomes active on the left and click on the relevant page on the bar. 

There are add, edit, delete functions for Order and Restaurant components. We can perform it via Material Table both to reduce code clutter and because it is a more user-friendly design. We can perform add, edit, delete operations inline through the table. As desired, the fields are empty during add and the information of the relevant record is seen during edit. Search and pagination features are available in tables. When you click on the column names in the table, it sorts.

General managers and restaurant managers can see all records in the Order table, while customers can only see their own records. Customers' order creation process will be performed through this table. They can create a new order with the add button, update it with edit and delete it with delete button. They can only do these on their own orders.

General manager and restaurant managers have access to the Restaurant table. Customers cannot access the table. While the general manager can access all records, restaurant managers can only view the restaurants connected to them. The display button in this table redirects to the order table and the orders of the related restaurant can be displayed.
Users can logout by pressing the Logout button in the sidebar and the Logout icon in the upper right corner.

PostgreSQL is used for database operations. There are 3 tables; Users, Restaurants and Orders. Orders table contains dependencies to User and Restaurant tables. In the Restaurant table, there is a dependency on the Users table. 

In order to start the application locally, you can connect to the relevant database using the credentials in the application.properties file from the PostgreSQL application. Backend uses Java and Springboot. Before launching the application, the dependencies should be updated, then the project is run and the backend is launched. 







