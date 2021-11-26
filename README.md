# Instructions

## Steps to run the system
1. Change PATH variable in application.properties to the path of /Gemini-5_OCS/ocs.mv.db on your machine.<br>
2. Change Java SDK to version 16. <br> &emsp; 
2.1 Go to File -> Project Structure -> Project ->Project SDK <br> &emsp; 
2.2 Select openjdk-16 version 16.0.1 from the drop down. <br> &emsp; 
2.3 If not then select Add SDK, then select Download JDK <br> &emsp; 
2.4 Select version 16 and select download <br> 
3. Right click on OCS.jar then click **Add as library**
4. Run the program in IntelliJ <br>
5. Go to http://localhost:5000/ <br> &emsp;
6.1 Port can be change in application.properties under server.port
7. Perform action according to each use case

## Note
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;After broswing the http://localhost:5000/, the log in interface will show up. If the user have an account, they can log in right away. Otherwise, they need to register to get "Username" and "Password" first.<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Once log in successed, the system will show exsisting plan page whcih can click and link to Create a Science Plan page, Edit Science Plan page, Submit a Science Plan and Test a Science Plan.

### Use Case 1: Create a Science Plan
1. Log in as an astronomer user<br>
2. Click Create Science Plan on the navigation bar <br>
3. Fill in the information of the science plan, then click save <br> &emsp;
3.1  If you fill all the information, in the action column, the existing plan page will have edit and submit button <br> &emsp;
3.2 If you didn’t fill all the information, the action column in the existing plan page will have only an edit button. <br>
4. The status of science plan will change to CREATED <br>

### Use Case 2: Submit a Science Plan
1. Log in as an astronomer user<br>
2. User can search for the existing science plan by entering location<br>
3. User can click submit to submit the science plan in the action column <br>
4. The status of the science plan will change to SUBMITED <br />

### Use Case 3: Test a Science Plan
1. Log in as an astronomer user<br>
2. User can search for the existing science plan by entering location<br>
3. User can click to test the plan in the action column, then the page will redirect to test page <br>
4. Click test and then wait for the plan to test <br>
5. After finish testing the test result will show <br>
6. When we go back to the existing plan page, the status will change to TESTED <br>

## Pattern
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;For the design pattern, we decided to use the Factory method to be a way to create objects. Since we have class User as a superclass, and class Astronomer as a sub-class. In the future, we may have more subclasses as well like Science Observer, or Telescope Operator. That’s why we consider the Factory method design pattern is suitable for our project because we can create objects without exposing the creation logic to the client by having subclasses create the instance of the class. By having a UserFactory class to generate objects of concrete classes based on a given role, the client can just pass the role of the user whether it be astronomer, science observer, and so on, and then it will create an object based on the given role.<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;In the code, we have an Astronomer class that extends a User class, and also a UserFactory class as shown in the class diagram. In this class, we have a method getUser() to return a new object based on the given role.



