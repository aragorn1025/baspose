<?php
    
    $con = mysqli_connect("127.0.0.1", "cilab", "cilabbaspose", "baspost");
    
    //$date = $_POST["date"];

    $date = "2019-10-14 19:36:04";
    //$filename = "V_20190528_093503_N0.mp4";
    //$filename = "filename_test";

    $statement = mysqli_prepare($con, "SELECT * FROM mmg WHERE date = ?");
    mysqli_stmt_bind_param($statement, "s", $date);
    mysqli_stmt_execute($statement);
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $id, $mmg, $date);

    $response = array();
    $response["success"] = false;

    
    while(mysqli_stmt_fetch($statement)){
        
        $response["success"] = true;
        $response["mmg"] = $mmg;
        $response["date"] = $date;
    }

    echo json_encode($response);
?>
