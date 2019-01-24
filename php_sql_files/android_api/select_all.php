<?php
  require_once('connection.php');
  
  $sql = "SELECT * FROM users";
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