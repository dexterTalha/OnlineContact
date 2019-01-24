<?php
 require_once('connection.php');
 $username = $_GET['username'];
 $password = $_GET['password'];
 $mobile = $_GET['mobile'];
 $sql_select = "SELECT username FROM users WHERE username = '$username'";
 $d = $db->query($sql_select);
 $cnt = mysqli_fetch_array($d);
 $r = null;
 if($cnt > 0){
     $r["response"][]=array('response'=>'username already exists');
      echo json_encode($r);
 }else{
    $sql = "INSERT INTO users VALUES('','$username','$password','$mobile')";
    $data = $db->query($sql);
    if($data){
        $r["response"][]=array('response'=>'USER REGISTERED');
      echo json_encode($r);
    }else{
        $r["response"][]=array('response'=>'REGISTRATION FAILED');
      echo json_encode($r);
    }
}

		

?>