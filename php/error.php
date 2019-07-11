<?php
    
    $con = mysqli_connect("127.0.0.1", "cilab", "cilabbaspose", "baspost");
    
    $filename = $_POST["filename"];

    //$filename = "VID_20190528_120605.mp4";
    
    
    $statement = mysqli_prepare($con, "SELECT * FROM error WHERE filename = ?");
    mysqli_stmt_bind_param($statement, "s", $filename);
    mysqli_stmt_execute($statement);
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $id, $error, $filename);


    
    $response = array();
    $response["success"] = false;  

    
    while(mysqli_stmt_fetch($statement)){
        
        $response["success"] = true;  
        $response["error"] = $error;
        
    }



    echo json_encode($response);
?>
