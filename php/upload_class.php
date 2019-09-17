<?php
    
    $type = $_POST['type'];
    
    $conn = mysqli_connect("127.0.0.1", "cilab", "cilabbaspose", "baspost")or die('Could not connect');
    
    //$sql="insert into userdata(name,email,password) values('".$username."','".$useremail."','".$userpassword."');";
    
    $sql = "INSERT INTO video (type) VALUES ('".$type."')";
    
    
    if(mysqli_query($conn,$sql)){
        echo  "data inserted";
        
    }else{
        echo "Failed";
    }


//$type = $_GET['type'];
//
//
//$response = array();
//
//
//$conn = mysqli_connect("127.0.0.1", "cilab", "cilabbaspose", "baspost")or die('Could not connect');
//
//
//$sql = "INSERT INTO video (type) VALUES ('$type')";
//
//     if ( mysqli_query($conn, $sql) ) {
//         $success = true;
//         $message = "upload class type success";
//
//     } else {
//
//         $success = false;
//         $message = "Error while class type to database";
//     }
// }
//
//
//
//$response["success"] = $success;
//$response["message"] = $message;
//echo json_encode($response);
    
    
    
    


?>
