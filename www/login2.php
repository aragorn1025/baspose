<?php

if ($_SERVER['REQUEST_METHOD']=='POST') {

    $username = $_POST['username'];
    $password = $_POST['password'];

    $conn = mysqli_connect("127.0.0.1", "cilab", "cilabbaspose", "baspost")or die('Could not connect');

    $sql = "SELECT * FROM user WHERE username = '$username' AND password = '$password'";

    $result = mysqli_query($conn, $sql);
    
    $check = mysqli_fetch_array($result);
    
    if(isset($check)){
        
        echo 'success';
    }else{
        echo 'failure';
        
    }
    
}

?>
