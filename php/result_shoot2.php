<?php
    
    $con = mysqli_connect("127.0.0.1", "cilab", "cilabbaspose", "baspost");
    
    $filename = $_POST["filename"];

    //$filename = "V_20190528_093503_N0.mp4";
    
    
    $statement = mysqli_prepare($con, "SELECT * FROM shootBefore WHERE filename = ?");
    mysqli_stmt_bind_param($statement, "s", $filename);
    mysqli_stmt_execute($statement);
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $id, $angle, $judge, $comment, $filename, $date);

    $statement2 = mysqli_prepare($con, "SELECT * FROM shootAfter WHERE filename = ?");
    mysqli_stmt_bind_param($statement2, "s", $filename);
    mysqli_stmt_execute($statement2);
    mysqli_stmt_store_result($statement2);
    mysqli_stmt_bind_result($statement2, $id, $angle, $judge, $comment, $filename, $wrist, $date);


    
    $response = array();
    $response["successbefore"] = false;  
    $response["successafter"] = false; 
    
    while(mysqli_stmt_fetch($statement)){
        
        $response["successbefore"] = true;  
        $response["anglebefore"] = $angle;
        $response["commentbefore"] = $comment;
        $response["date"] = $date;
        
    }


    while(mysqli_stmt_fetch($statement2)){
        
        $response["successafter"] = true;  
        $response["angleafter"] = $angle;
        $response["commentafter"] = $comment;
        $response["wrist"] = $wrist;
       
        
    }


    echo json_encode($response);
?>
