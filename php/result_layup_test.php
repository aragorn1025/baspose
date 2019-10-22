<?php
    
    $con = mysqli_connect("127.0.0.1", "cilab", "cilabbaspose", "baspost");
    
    $filename = "1V_20191008_114832_N0.mp4";

    $statement = mysqli_prepare($con, "SELECT * FROM layup WHERE filename = ?");
    mysqli_stmt_bind_param($statement, "s", $filename);
    mysqli_stmt_execute($statement);
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $id, $step1, $traveling, $straight, $filename, $date);

    $response = array();
    $response["success"] = false;

    
    while(mysqli_stmt_fetch($statement)){
        
        $response["success"] = true;
        $response["step1"] = $step1;
        $response["traveling"] = $traveling;
        $response["straight"] = $straight;
        $response["date"] = $date;
    }

    echo json_encode($response);
?>
