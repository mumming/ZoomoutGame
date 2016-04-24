<?php
session_start();
 
function loginForm(){
    echo'
    <div id="loginform">
    <form action="index.php" method="post">
        <p>Indtast dit navn for start spil</p>
        <label for="name">Navn:</label>
        <input type="text" name="name" id="name" />
        <input type="submit" name="enter" id="enter" value="Enter" />
    </form>
    </div>
    ';
}

if(isset($_GET['logout'])){ 
     
    //Log ud msg
    $fp = fopen("log.html", 'a');
    fwrite($fp, "<div class='msgln'><i>Bruger: ". $_SESSION['name'] ." forladt chat session.</i><br></div>");
    fclose($fp);
     
    session_destroy();
    header("Location: index.php"); //Redirect the user
} 
 
if(isset($_POST['enter'])){
    if($_POST['name'] != ""){
        $_SESSION['name'] = stripslashes(htmlspecialchars($_POST['name']));
    }
    else{
        echo '<span class="error">Indtaste venligt dit navn</span>';
    }
}
?>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Startside</title>
	<style type='text/css'>
	

body {
    font:12px arial;
    color: #222;
    text-align:center;
    padding:35px; 
}
  
form, p, span {
    margin:0;
    padding:0; 
}

  
input { font:12px arial; }
  
a {
    color:#0000FF;
    text-decoration:none; 
}
  
a:hover { 
	text-decoration:underline; 
}
  
#player{
	width:200px;
	height:378px;
	padding-bottom:25px;
	background:#fff;
	float:left;
	border:1px solid #ACD8F0;
}  
  
#picture{
	margin:0 auto;
    padding-bottom:25px;
    width:504px;
	height:380px;
	float:left;
	margin-left:36px;
    border:1px solid #ACD8F0;
}

#chat{
	width:504px;
	height:380px;
	float:right;
}
 
#chatbox, #loginform {
    margin:0 auto;
    padding-bottom:25px;
    background:#EBF4FB;
    width:504px;
	height:380px;
    border:1px solid #ACD8F0;
	}
  
#loginform { padding-top:18px; }
  
#loginform p { margin: 5px; }
  
#msgbox {
    text-align:left;
    margin:0 auto;
    margin-bottom:25px;
    padding:10px;
    background:#fff;
    height:270px;
    width:430px;
    border:1px solid #ACD8F0;
    overflow:auto; }
  
#usermsg {
    width:395px;
    border:1px solid #ACD8F0; }
	  
#submit { width: 60px; }
  
.error { color: #ff0000; }
  
#menu { padding:12.5px 25px 12.5px 25px; }
  
.welcome { float:left; }

.logout { float:right; }
  
.msgln { margin:0 0 2px 0; }
	
	</style>
</head>

<body>
<div id="player">Spiller</div>
<div id="picture">
<img src="test.jpg" alt="test" width="504" height="400">
</div>

<div id="chat">

<?php
if(!isset($_SESSION['name'])){
    loginForm();
}
else{
?>
<div id="chatbox">
    <div id="menu">
        <p class="welcome">Velkomme, <b><?php echo $_SESSION['name']; ?></b></p>
        <p class="logout"><a id="exit" href="#">Log ud</a></p>
        <div style="clear:both"></div>
    </div>    
    <div id="msgbox"><?php
	
	if(file_exists("log.html") && filesize("log.html") > 0){
    $handle = fopen("log.html", "r");
    $contents = fread($handle, filesize("log.html"));
    fclose($handle);
     
    echo $contents;
	}
	?></div>
     
    <form name="message" action="">
        <input name="usermsg" type="text" id="usermsg" size="63" />
        <input name="submitmsg" type="submit"  id="submitmsg" value="Send" />
    </form>
</div>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js"></script>
<script type="text/javascript">

// jQuery Document
$(document).ready(function(){
	
	//Hvis bruger vil end deres session
	$("#exit").click(function(){
	var exit = confirm("Er du sikker på du vil log ud?");
	if(exit==true){window.location = 'index.php?logout=true';}		
	});
	
	//Bruger send knap
	$("#submitmsg").click(function(){	
		var clientmsg = $("#usermsg").val();
		$.post("post.php", {text: clientmsg});				
		$("#usermsg").attr("value", "");	
		$("#msgbox").load("log.html");
		$("#msgbox").load("log.html");
		$("#msgbox").animate({ scrollTop: 1000 }, 2000);
		return false;
	
	});
	
});
</script>
<?php
}
?>

</body>
</html>