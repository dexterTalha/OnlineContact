<?php
  require_once('connection.php');
  @$username = $_GET['username'];
  $sql = "SELECT * FROM users WHERE username = '$username'";
  $data = $db->query($sql);
  $r=null;
  while($fetch = mysqli_fetch_assoc($data)){
      $r['userdata'][] = array(
                        'username' => $fetch['username'],
                        'password' => $fetch['password'],
                        'mobile' => $fetch['mobileno'],
                            );
  }
  //header('content-type: application/json');
  $json = $r;
  
  echo json_encode($json);
  
  @mysqli_close();
  
  ?>