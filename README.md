# MoneyLion Assignment
- To run this you can either run it using maven through the terminal or by opening the project in eclipse and running AssignmentApplication.java
- The application uses H2 database

# Seeded users (user/pass)
- admin/admin
- user/user

# Endpoints
- POST /auth/login
  - Accepts `username` and `password` form data in x-www-form-urlencoded format
  - Logs current user in and creates user session
- POST /auth/logout
  - Logs out current user
- GET /feature
  - Accepts `email` and `featureName`
  - `featureName` only accepts `test` and `feature`
  - Returns whether or not the feature is enabled for the user
- POST /feature
  - Accepts `email`, `featureName` and `enable`
  - `featureName` only accepts `test` and `feature`
  - Enables/disables the feature for the user
  - 200 upon success, 304 if there are no changes made
- GET / 
  
# General errors
- 400 means the syntax of the data provided for the endpoint is erroneous
- 401 means the user was not authenticated
- 403 means the user was authenticated but is not authorized for accessing the resource
- 503 means the data provided by the user was correct, but an unknown error caused the service to fail, and it might not succeed unless there is an intervention

