<?php

$target_dir = "/home/data/uploads/";

$target_file_name = $target_dir . basename($_FILES["file"]["name"]);
    
$file_name = ($_FILES["file"]["name"]);
    
$datetime = date ("Y-m-d H:i:s" , mktime(date('H')+8, date('i'), date('s'), date('m'), date('d'), date('Y')));
echo $datetime;
    
    
$response = array();  
    
    
if (file_exists($_FILES["file"]["tmp_name"]))
{
 if (move_uploaded_file($_FILES["file"]["tmp_name"], $target_file_name))
 {
     
    $conn = mysqli_connect("127.0.0.1", "cilab", "cilabbaspose", "baspost")or die('Could not connect');
    //$sql = "INSERT INTO video(path) VALUES ('$target_file_name')";
    $sql = "INSERT INTO video (path,date) VALUES ('$file_name','$datetime')";
     
     
     if ( mysqli_query($conn, $sql) ) {
         $success = true;
         $message = "upload video success and path to database success ";
         
     } else {
         
         $success = false;
         $message = "Error while path to database";
     }
 }
 else
 {
  $success = false;
  $message = "Error while uploading video";
 }
}
else
{
 $success = false;
 $message = "Required Field Missing";
 $message .= ": ";
 $message .= "[" . $_FILES["file"]["error"] . "] ";
 $message .= "\"" . $_FILES["file"]["tmp_name"] . "\"";
}

$response["success"] = $success;
$response["message"] = $message;
echo json_encode($response);

?>
