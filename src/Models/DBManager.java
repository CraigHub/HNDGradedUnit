
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import static javax.swing.text.StyleConstants.Size;


/**
 *
 * @author Project Manager
 */
public class DBManager {
    
    private String dbAddress = "jdbc:ucanaccess://C:\\Users\\Project Manager\\Desktop\\Graded Unit\\Maxi Cycles 2.0\\data\\MaxiShopDB.accdb";
    
    /////
    ///////CUSTOMER///////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////
    //This will register a new customers details into the database
    public boolean registerCustomer(Customer newCustomer)
    {
        //Connects to the DB allowing access to the file
        //Runs by inserting the new customer information into the database, Customers section.
        //Returns true if details are a new customer
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Project Manager\\Desktop\\Graded Unit\\Maxi Cycles 2.0\\data\\MaxiShopDB.accdb");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO Customers (Username, Password, FirstName, LastName, AddressLine1, AddressLine2, Town, Postcode) VALUES " +
                    "('" +  newCustomer.getUsername() + 
                    "','" + newCustomer.getPassword() + 
                    "','" + newCustomer.getFirstName() + 
                    "','" + newCustomer.getLastName() + 
                    "','" + newCustomer.getAddressLine1() + 
                    "','" + newCustomer.getAddressLine2() + 
                    "','" + newCustomer.getTown() + 
                    "','" + newCustomer.getPostcode() + "')");
            conn.close();
            return true;
        }
        //Exception message displayed if the details already exist in the DB
        catch(Exception ex)
        {
            String message = ex.getMessage();
            return false;
        }
    }
    
    public void updateCustomer(Customer newCustomer)
    {
        //Connects to the database and allows access to the file
        //Finds the correct customer by looking at the username
        //Runs by updating new information entered into the DB
       try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Project Manager\\Desktop\\Graded Unit\\Maxi Cycles 2.0\\data\\MaxiShopDB.accdb");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(
                    "UPDATE Customers SET Password = '" + newCustomer.getPassword() + "', " +
                    "FirstName = '" + newCustomer.getFirstName() + "', " +
                    "LastName = '" + newCustomer.getLastName() + "', " + 
                    "AddressLine1 = '" + newCustomer.getAddressLine1() + "', " +
                    "AddressLine2 = '" + newCustomer.getAddressLine2() + "', " +
                    "Town = '" + newCustomer.getTown() + "', " +
                    "Postcode = '" + newCustomer.getPostcode() + "' " +
                    "WHERE Username = '" + newCustomer.getUsername() + "'");
            conn.close();
        }
       //Exception message displayed if the details already exist
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
    
    //Find Customer Login
    public Customer customerLogin(String Username, String password)
    {
        //Call the LoadCustomers method
        HashMap<String, Customer> customers = loadCustomers();
        
        //Search customers to check if key is being searched
        //Finds customers username and compares with entered password
        //If credentials match, customer will be found
        if(customers.containsKey(Username))
        {
            Customer foundCustomer = customers.get(Username);
            if(foundCustomer.getPassword().equals(password))
            {
                return foundCustomer;
            }
        }
        //if not found
        return null;
    }
    
    //Loads customer information from the database
    public HashMap<String,Customer> loadCustomers()
    {
        //New hashmap to load the customers information into
        HashMap<String,Customer> customers = new HashMap<>();
        
        //Connects to database to allow access to the file
        //Looks in a specific section of the database - Customers.
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Project Manager\\Desktop\\Graded Unit\\Maxi Cycles 2.0\\data\\MaxiShopDB.accdb");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Customers");
            while(rs.next())
            {
                //This will read all the columns in the database and create attributes 
                //which the program can use
                String username = rs.getString("Username");
                String password = rs.getString("Password");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String houseNo = rs.getString("AddressLine1");
                String street = rs.getString("AddressLine2");
                String town = rs.getString("Town");
                String postCode = rs.getString("PostCode");
            
                //Overloaded constructor array to allow access fro the DB and connect to the customer class
                Customer loadedCustomer = new Customer(username, password, firstName, lastName, houseNo, street, town, postCode);      
            
                //Usrname is stored as a key which loads LoadedCustomer and returns the details
                customers.put(username, loadedCustomer);
            
            }
            conn.close();
        }
        //This exception message will display instead of crashing the system
        //If there are problems loading the customers information
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
        finally
        {
            //Uses the LoadCustomer method to load the customer order and orderline, passing it in the hashmap
            customers = loadOrders(customers);
            customers = loadOrderLines(customers);
            return customers;
        }
    }
    //Deletes customer information from the database
    public void deleteCustomer(Customer customer)
    {
        //Connects to the database to allow access to the file
        //Finds the correct customer using the isername and executes the statement
        //Runs by deleting the customers information from the database
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Project Manager\\Desktop\\Graded Unit\\Maxi Cycles 2.0\\data\\MaxiShopDB.accdb");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM Customers WHERE Username = '" + customer.getUsername() + "'");
        }
        //Exception message displayed if the customer is not found
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
    
    
    /////
    ////////STAFF////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////
     public Staff staffLogin(String username, String password)
    {
        HashMap<String, Staff> staffs = loadStaff();
        if(staffs.containsKey(username))
        {
            Staff foundStaff = staffs.get(username);
            if(foundStaff.getPassword().equals(password))
            {
                return foundStaff;
            }
        }
        //if not found
        return null;
    }
     
     //Load staff information from database
     public HashMap<String,Staff> loadStaff()
    {
        //New hashmap to load the information into
        HashMap<String,Staff> staffs = new HashMap<>();
        
        //Connects to the database to allow access to the file
        //Looks into the Staff section of the file
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Project Manager\\Desktop\\Graded Unit\\Maxi Cycles 2.0\\data\\MaxiShopDB.accdb");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Staff");
            while(rs.next())
            {
                //Thiss reads all the colunms in the database and
                //creates attributes which the program can use
                String username = rs.getString("Username");
                String password = rs.getString("Password");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                
                
            
                Staff loadedStaff = new Staff(username, password, firstName, lastName);      
                //Username is stored as a key because it is unique which loads the loadedStaff and returns details
                staffs.put(username, loadedStaff);
            
            }
            conn.close();
        }
        //Exception message displayed
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
        finally
        {
            //Returns the staff details
            return staffs;
        }
    }
     
     
     /////
     ////////PRODUCTS//////////////////////////////////////////////////////////////////////////////////////////
     //////////////////////////////////////////////////////////////////////////////////////////////////////////
     /////
     
     //Adds new products into the database
     public void addProduct(Product newProduct)
    {
        //attributes
        String type = "";
        //Size is NULL to keep the column empty when needed
        String frameSize = "NULL";
        //access the skateboard class, looking through the Model package
        if(newProduct.getClass().getName().equals("Models.Skateboard"))
        {
            //Declare new attribute to access the skateboard class
            Skateboard newSkateboard = (Skateboard)newProduct;
            //type attribute equals the get.Type from the skateboard class
            type = newSkateboard.getType();
        }
        else
        {
            //Declare the bike attribute to access the bike class, making the product assign to Bike
            Bike newBike = (Bike)newProduct;
            //Cast to string to convert from an integer
            frameSize = String.valueOf(newBike.getFrameSize());
        }
        
        try
        {
            
            //Connects to the database to allow access to the file
            //Looks into the Products section of the file
            //Runs by inserting new products cerated by the user by accessing the getters in the product class 
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Project Manager\\Desktop\\Graded Unit\\Maxi Cycles 2.0\\data\\MaxiShopDB.accdb");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(
                    "INSERT INTO Products (ProductName, Price, StockLevel, Type, FrameSize) "
                    + "VALUES ('" + newProduct.getProductName() + "','" 
                    + newProduct.getPrice() + "','" 
                    + newProduct.getStockLevel() + "','" 
                    + type + "'," 
                    + frameSize + ")");
            conn.close();
        }
        //Exception message displayed
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
     
     //Updates products in the database
     public void updateProducts(Product newProduct)
    {
        //Declare attributes
        String type = "";
        int frameSize = 0;
        
        //To access the Skateboard class, finding through the package Models
        if(newProduct.getClass().getName().equals("Models.Skateboard"))
        {
            //Declare new attribute to access the skateboard class, making the product assigned to skateboard
            Skateboard newSkateboard = (Skateboard)newProduct;
            //type attribute to equal the get.Type from the Skateboard class
            type = newSkateboard.getType();
        }
        else
        {
            //Declare new attribute to access the Bike class, making the product assigned to BIke
            Bike newBike = (Bike)newProduct;
            //frameSize attribute to equal the get.frameSize from the Bike class
            frameSize = newBike.getFrameSize();
            
        }
        
        try
        {
            //Connects to the database to allow access to the file
            //Looks into the Products section of the file
            //Runs by updating products with new information netered
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Project Manager\\Desktop\\Graded Unit\\Maxi Cycles 2.0\\data\\MaxiShopDB.accdb");
            Statement stmt = conn.createStatement();
           stmt.executeUpdate("UPDATE Products SET ProductName = '" + newProduct.getProductName() + "', " +
                    "Price = '" + newProduct.getPrice() + "', " +
                    "StockLevel = '" + newProduct.getStockLevel() + "', " +
                    "Type = '" + type + "', " +
                    "FrameSize = '" + frameSize + "' " +
                    "WHERE ProductId = '" + newProduct.getProductId() + "'");
            
            conn.close();
        }
        //Exception message
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
     
     public void deleteProduct(Product product)
    {
        try
        {
            //Connects to the database to allow access to the file
            //Looks into the Products section of the file
            //Runs by deleting product information from the database
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Project Manager\\Desktop\\Graded Unit\\Maxi Cycles 2.0\\data\\MaxiShopDB.accdb");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM Products WHERE ProductID = '" + product.getProductId() + "'");
        }
        //Exception message
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
     
     //Loads product information from the DB
     public HashMap<Integer, Product> loadProducts()
    {
        //New hashma to load the product information into
        HashMap<Integer, Product> products = new HashMap();
        
        try
        {
            //Connects to the database to allow access to the file
            //Looks into the Products section of the file
            //Runs by updating new information entered
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Project Manager\\Desktop\\Graded Unit\\Maxi Cycles 2.0\\data\\MaxiShopDB.accdb");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Products");
            while(rs.next())
            {
                int productId = rs.getInt("ProductID");
                String productName = rs.getString("ProductName");
                double price = rs.getDouble("Price");
                int stockLevel = rs.getInt("StockLevel");
                String type = rs.getString("Type");
                int frameSize = rs.getInt("FrameSize");
                

                //If type input is empty or NULL, it will return Bike
                if(type == null || type.equals(""))
                {
                    //Uses the unique productId which loads the loadedBike
                     Bike loadedBike = new Bike(productId, productName, price, stockLevel, frameSize);
                    products.put(productId, loadedBike);
                }
                else
                {
                    //Else it will return Skateboard
                    //Uses the unique product Id to return loadedSkateboard
                   Skateboard loadedSkateboard = new Skateboard(productId, productName, price, stockLevel, type);
                    products.put(productId, loadedSkateboard);
                }
            }
            conn.close();
        }
        //Exception message displayed
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
        finally
        {
            return products;
        }    
    }
     
     public void updateProductQuantity(Product product)
    {
        try
        {
            //Connects to the database to allow access to the file
            //Looks into the Products section of the file
            //Updates the stock level column using the unique ProductId
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Project Manager\\Desktop\\Graded Unit\\Maxi Cycles 2.0\\data\\MaxiShopDB.accdb");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE Products SET StockLevel = " 
                    + product.getStockLevel()
                    + " WHERE ProductID = '" + product.getProductId() + "'");
            conn.close();
        }
        //Exception Message displayed
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
     
     
     /////
     ////////ORDER////////////////////////////////////////////////////////////////////////////////////////////
     /////////////////////////////////////////////////////////////////////////////////////////////////////////
     /////
     
     //Adds new orders to the database, passing in Username and Order
     public int addOrder(String Username, Order o)
    {
        //declare variable
        int orderId = 0;
        
        try
        {
            //Connects to the database to allow access to the file
            //Inserts the order information into the Orders section
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Project Manager\\Desktop\\Graded Unit\\Maxi Cycles 2.0\\data\\MaxiShopDB.accdb");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO Orders (OrderDate, Username, OrderTotal, Status) " +
                    "VALUES ('" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(o.getOrderDate()) + "','" +
                            Username +
                    "','" + o.getOrderTotal() + "','" + 
                    o.getStatus() + "')");
            
            //This retrieves auto generated keys the database creates
            ResultSet rs = stmt.getGeneratedKeys();
            
            //For each row make sure order Id's are integers, this is used to get the number
            if(rs.next())
            {
                orderId = rs.getInt(1);
            }        
            conn.close();
        }
        //Exception message 
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
        //Returns the Order id
        return orderId;
    }
     //Loads orders from the database
     public HashMap<String, Customer> loadOrders(HashMap<String, Customer> customers)
    {
       try
        {
            //Connects to the database to allow access to the file
            //Looks at the Order table
            //Runs by selecting the rows in the order table
            //This reads all columns and rows in the DB
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Project Manager\\Desktop\\Graded Unit\\Maxi Cycles 2.0\\data\\MaxiShopDB.accdb");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Orders");

            //for each row it will check the created orders
            while (rs.next())
            {
                int orderId = rs.getInt("OrderId");
                Date orderDate = rs.getDate("OrderDate");
                String username = rs.getString("Username");
                double orderTotal = rs.getDouble("OrderTotal");
                String status = rs.getString("Status");
                
                //if the username matches the customer it will get the orders that customer created
                if(customers.containsKey(username)) 
                {        
                    Customer customer = customers.get(username);
                    Order order = new Order(orderId, orderDate, customer, orderTotal, status);
                    customer.getOrders().put(orderId, order); 
                }
            }
            conn.close();           
        }
       //Exception message
        catch(Exception ex)
        {
            String message = ex.getMessage();
            
        }
        finally
        {
            //Returns customer 
            return customers;
        } 
    }
     //Completes the order process
     public void completeOrder(int orderId)
    {
        try
        {
            //Connection to the database to allow access to the file
            //Finds the Order Id to allow the DB to update the correct order
            //Updates the order information
            //Updates the orderDate with current date and sets status to complete
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Project Manager\\Desktop\\Graded Unit\\Maxi Cycles 2.0\\data\\MaxiShopDB.accdb");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE Orders SET OrderDate = '" 
                    + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "',"
                    + " Status = 'Complete' WHERE OrderId = '" + orderId + "'");
            conn.close();
        }
        //Exception message
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
     
     public void cancelOrder(int orderId)
    {
        try
        {
            //Connection to the database to allow access to the file
            //Finds the Order Id to allow the DB to update the correct order
            //Updates the order information
            //Updates the orderDate with current date and sets status to complete
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Project Manager\\Desktop\\Graded Unit\\Maxi Cycles 2.0\\data\\MaxiShopDB.accdb");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DELETE from Orders WHERE OrderId = '" + orderId + "'");
            conn.close();
        }
        //Exception message
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
     
     
     //Update order total information to be used with the addOrder method
     //Passing in OrderId and LineTotal
     public void updateOrderTotal(int orderId, double lineTotal)
    {
        try
        {
            //Connects to the database to allow access to the file
            //Finds the OrderId to update the correct order
            //Updates the order information in the Orderline section of the DB
            //Adding lineTotal and orderTotal to create final amount
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Project Manager\\Desktop\\Graded Unit\\Maxi Cycles 2.0\\data\\MaxiShopDB.accdb");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE Orders SET OrderTotal = OrderTotal + " + lineTotal +
                    " WHERE OrderId = '" + orderId + "'");
            conn.close();
        }
        //Exception message
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
     
     
     /////
     /////////ORDER LINES/////////////////////////////////////////////////////////////////////////////////////////
     /////////////////////////////////////////////////////////////////////////////////////////////////////////////
     /////
     
     
     public void addOrderLine(int orderId, OrderLine oLine)
    {
        try
        {
            //Connects to database t allow access to the file
            //Inserts new orderline information into the Orderlines section of the DB
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Project Manager\\Desktop\\Graded Unit\\Maxi Cycles 2.0\\data\\MaxiShopDB.accdb");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO OrderLines (ProductID, Quantity, LineTotal, OrderId) " +
                    "VALUES ('" + oLine.getProduct().getProductId() + "','" + 
                    oLine.getQuantity() + "','" + oLine.getLineTotal() + "','" + orderId + "')"); 
            conn.close();
            //Calls the updateOrderTotal method, passing in the order id and the line total
            //allowing the database to be updated
            updateOrderTotal(orderId, oLine.getLineTotal());
        }
        //Exception message
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
     //Loads all orderlines created by the system
     public HashMap<String, Customer> loadOrderLines(HashMap<String, Customer> customers)
    {
        //Loads another method, placing the products in a hashmap to be called when needed
        HashMap<Integer, Product> product = loadProducts();
        try
        {
            //Connects to the database to allow access to the file
            //Looks at the orderlines table
            //Runs by selecting all rows in the orderline
            //Reads every column and row inside the database
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Project Manager\\Desktop\\Graded Unit\\Maxi Cycles 2.0\\data\\MaxiShopDB.accdb");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM OrderLines");
            while (rs.next())
            {
                int orderLineId = rs.getInt("OrderLineId");
                int productId = rs.getInt("ProductId");
                int quantity = rs.getInt("Quantity");
                double lineTotal = rs.getDouble("LineTotal");
                int orderId = rs.getInt("OrderId");
                Product loadProduct = product.get(productId);
                
                //for loop round the customers to get the orders the customers created
                for(Map.Entry<String, Customer> cEntry : customers.entrySet()) 
                {
                    //Gets the value of the customer
                    Customer customer = cEntry.getValue();
                   
                    //If a value contains an order id, it will load the orderlines connected to that id
                    if(customer.getOrders().containsKey(orderId))
                    {   
                        
                       //Loads the orderline
                        //passing in the order to find the orderline thorugh the id
                        OrderLine oLine = new OrderLine(orderLineId, loadProduct, lineTotal, quantity);
                        customer.getOrders().get(orderId).getOrderLines().put(orderLineId, oLine);                    
                    }        
                }
            }
            conn.close();           
        }
        //Exception message
        catch(Exception ex)
        {
            String message = ex.getMessage();
            
        }
        finally
        {
            //returns customer
            return customers;
        } 
    }
     
     //Deletes product from orderline
     public void deleteOrderLine(int orderId, int productId)
    {
        try
        {
            //Connection to the database to allow access to the file
            //Deletes the orderline information from the database
            //Using ProductId and OrderId
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Project Manager\\Desktop\\Graded Unit\\Maxi Cycles 2.0\\data\\MaxiShopDB.accdb");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM OrderLines WHERE ProductID = '" + productId + "' AND "
                    + "OrderId = '" + orderId + "'");
        }
        //Exception message
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
    
    /////
    /////GENERATED METHODS/////////
    /////
    
    private void Longboard() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
