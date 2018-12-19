# SWE1_Project_20160115
A project for our faculty to develop an app that used for search for the items we lost.
An user will find the item then post it on the app and set some questions about the item.
The other one will find the post and try to answer the questions if he answered right then we should make a connection between them by exchanging their contact information.

# MySQLConnector class
MySQLConnector class is used to connect with MySQL Database.
<br>
use "openConnection" method to open the connection 
then use the suitable method to execute your query then use the "closeConnection" method to close the connection.
<br>
there are two execute methods:
<br><br>
1- executeUpdate : which used to execute queries that perform an updates and don't return any thing like select, update and delete.
<br>
2- executeQuery : which used to execute select queries and it returns the result in "java.sql.ResultSet" object.
