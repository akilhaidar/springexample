<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!-- <img src="../images/ak.jpg" alt="" height="100" width="100"> -->

<ul class="mylinks">
     <li><a href="#">HOME</a><li>
     <li><a href="#">ABOUT US</a><li>
     <li><a href="#">PORT FOLIO</a><li>
     <li><a href="#">COMPANY</a><li>

</ul>

</body>

<style type="text/css">


body { 
  /* The image used */
  background-image: url("../images/img.jpg");

  /* Full height */
  height: 100%;
  width: 100%; 

  /* Center and scale the image nicely */
  /*background-position: center;*/
  background-repeat: no-repeat;
  background-size: cover;
}

	.mylinks li{
    float:left;   /* Fit all your links nicely in one line*/
    margin:0 15px; /* Give them to the left and right a little room to breathe */
    /* You can adjust the space by modifying the 5px value, */
    /* the 0 modifies the top/bottom spacing */
text-decoration: none;
}

ul {
  list-style-type: none;

}
a{
	text-decoration: none;
}
.mylinks a{
   color:red;
}
.mylinks{
	{
      color: #9000A1;
      font-family:"Times New Roman", Times, serif;
}
}
</style>
</html>