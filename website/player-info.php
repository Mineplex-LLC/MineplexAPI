<?php
$playerName=$_GET["playerName"];
$playerConn = curl_init("http://api.mineplex.com/pc/player/" . $playerName . "/");
?>
<html>
<head>
<!-- willy is "willy" bad -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.4/semantic.min.css">
<style>img {
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
        }</style>
        
</head>
<body>
<div id="wrapper" class="center-div">
        <img src="img/logo-full.png" class="center-block" />
        Player info for <b><?php echo $playerName;?></b>:<br />
    </div>
</body>
</html>
