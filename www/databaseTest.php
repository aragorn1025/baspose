<?php
$servername = "127.0.0.1";
$username = "cilab";
$password = "cilabbaspose";
$databaseName = "baspost";

$con = mysqli_connect($servername, $username, $password);

if (!$con) {
       die("Connection failed: " . mysqli_connect_error());
   }
else{
    die("sucess");
}

?> 
