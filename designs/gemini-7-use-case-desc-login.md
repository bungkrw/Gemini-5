| **Use Case Name** | Log in |
| :---              | :--- |
| **ID** | 6 |
| **Importance Level** | High |
| **Primary Actor** | Users |
| **Use case Type**| Detail, Essential |
| **Stakeholders and Interests** | Users— needs to log into the system |
| **Brief Description** | The use case describes how a user log in to the system. |
| **Trigger** | Users want to access the system. |
| **Type** | External |
| **Relationships** | Association: Users <br> Include: <br> Extend: <br> Generalization: |
| **Normal Flow of Events** | 1. User input username  <br>2. User input password <br>3. User press login  <br>4. System checks for existing account database. <br> &emsp;If the account is existing, check username and password [sub-flow is performed.] <br> &emsp;If the account is not existing, notify an error message for user return to login again. <br> |
| **Sub flows** | [S-1 check username and password] <br> &emsp;If username and password is valid, system notifies user that login successful and system will accepts user for accessing into home page. <br> &emsp;If username and password is invalid, system return to login again. |
| **Alternate/Exceptional Flow** | If username and password is invalid, system will notify the user an error message. |
