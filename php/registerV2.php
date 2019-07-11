<?php

if ($_SERVER['REQUEST_METHOD'] =='POST'){

    $username = $_POST['username'];
    $email = $_POST['email'];
    $password = $_POST['password'];
    $nickname = $_POST['nickname'];

    //$password = password_hash($password, PASSWORD_DEFAULT);

    //require_once 'connect2018.php';
    //$conn = mysqli_connect("localhost", "root", "", "baspost")or die('Unable to Connect');
    $conn = mysqli_connect("127.0.0.1", "cilab", "cilabbaspose", "baspost")or die('Could not connect');

    $sql = "INSERT INTO user (username, email, password,nickname) VALUES ('$username', '$email', '$password','$nickname')";

    if ( mysqli_query($conn, $sql) ) {
        $result["success"] = "1";
        $result["message"] = "success";

        echo json_encode($result);
        mysqli_close($conn);

    } else {

        $result["success"] = "0";
        $result["message"] = "error";

        echo json_encode($result);
        mysqli_close($conn);
    }
}

?>
