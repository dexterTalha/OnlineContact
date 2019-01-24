<?php
 require_once('connection.php');
 $username = $_GET['username'];
 $email = $_GET['email'];
 $mobile = $_GET['mobile'];
 $name = $_GET['name'];
 $address = $_GET['address'];
 $r = null;
    $sql = "INSERT INTO contacts VALUES('','$username','$name','$mobile','$email','$address')";
    $data = $db->query($sql);
    if($data){
        $r["response"][]=array('response'=>'Contact Added');
      echo json_encode($r);
    }else{
        $r["response"][]=array('response'=>'FAILED');
      echo json_encode($r);
    }


		

?>