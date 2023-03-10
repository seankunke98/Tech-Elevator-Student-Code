### http://localhost:8080 -- BASE URL

- /login POST -- allows the user to login **PROVIDED**
- /register POST -- able to register a new user **PROVIDED**
- /messages GET -- returns a list of all public messages
- /user/messages GET -- returns list of private messages associated with a user
- 
- 
  - /message POST -- creates a new message object and saves it to the database
    - make a message controller
      - @RequestMapping for this post
    - MessageDao -> addNewMessage();
    - JDBC implement MessageDao -> provide implementation for addNewMessage()

