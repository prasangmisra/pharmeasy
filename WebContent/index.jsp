<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link rel="icon" type="image/png" href="app-icon.png">
 <link rel="stylesheet" type="text/css" href="css/jquery.autocomplete.css" />
	<script src="http://www.google.com/jsapi"></script>  
	<script>  
		google.load("jquery", "1");
	</script>
	<script src="js/jquery.autocomplete.js"></script>  
	<style>
		input {
			font-size: 120%;
		}
	</style>
	<title>PharmEasy Project</title>
	
</head>
<body>
	
	<h3>Movies shot</h3>
	
	<form action="index2.jsp">
	<input type="text" id="country" name="location"/>
	
	<script>
		$("#country").autocomplete("getdata.jsp");
	</script>
	
	<input type="submit" value="Get info">
	</form>
<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d100940.14245968233!2d-122.43759999999999!3d37.75769999999999!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x80859a6d00690021%3A0x4a501367f076adff!2sSan+Francisco%2C+CA%2C+USA!5e0!3m2!1sen!2s!4v1442126099841" width=100% height="600" frameborder="0" style="border:0" allowfullscreen></iframe></body>
</html>