<?php
  require_once('connection.php');
  @$username = $_GET['username'];
  $sql = "SELECT * FROM contacts WHERE username = '$username'";
  $data = $db->query($sql);
  $r=null;
  while($fetch = mysqli_fetch_assoc($data)){
      $r['contacts'][] = array(
                        'name' => $fetch['name'],
                        'email' => $fetch['email'],
                        'mobile' => $fetch['mobile'],
                        'address' => $fetch['address'],
                            );
  }
  //header('content-type: application/json');
  $json = $r;
  
  echo json_encode($json);
  
  @mysqli_close();
  
  ?>