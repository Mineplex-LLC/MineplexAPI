<?php 
/*
 * Version 0.1 by NubbyTM
 * expect bugs and errors, it's nubby.
 */
if (isset($_POST["authKey"])){
  $_COOKIE["authkey"] = $_POST["authKey"];
  header("http://api.mineplex.com/");
}
?>
<html>
  <head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.4/semantic.min.css">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300" rel="stylesheet">
    <style>
        img {
            width: 100%;
            vertical-align: middle;
        }
        .center-div {
            position: absolute;
            margin: auto;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            width: 60%;
            height: 30%;
        }
        .center-block {
            margin-left: auto;
            margin-right: auto;
            display: block;
        }
        body {
            background: url("img/stardust.png");
        }
        .wrapper{
            font-family: 'Open Sans', sans-serif;
        }
    </style>
  </head>
  <body>
      <div id="wrapper" class="center-div">
        <img src="img/logo-full.png" class="center-block" /><br />
        <form method="POST" action="https://api.mineplex.com/auth.php">
        Enter authentication key: <input name="apiKey" placeholder="Type /api in-game"></input>
        </form>
    </div>
  </body>
</html>
