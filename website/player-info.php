<?php
// Code contributed by NubbyTM
$playerName=$_GET["playerName"];
$playerRank="Error occurred while getting information";
$playerLevel="Error occurred while getting information";
function curl_get($url, array $get = NULL, array $options = array()) {    
    $defaults = array( 
        CURLOPT_URL => $url. (strpos($url, '?') === FALSE ? '?' : ''). http_build_query($get), 
        CURLOPT_HEADER => 0, 
        CURLOPT_RETURNTRANSFER => TRUE, 
        CURLOPT_TIMEOUT => 4 
    ); 
    
    $ch = curl_init(); 
    curl_setopt_array($ch, ($options + $defaults)); 
    if( ! $result = curl_exec($ch)) 
    { 
        trigger_error(curl_error($ch)); 
    } 
    curl_close($ch); 
    return $result; 
}
if (empty($_COOKIE["apikey"])){
    header("http://api.mineplex.com/auth.php");
} else {
    $playerJson = curl_get("http://api.mineplex.com/pc/player/" . $playerName . "/");
    var_dump(json_decode($playerJson, true));
    $playerRank = $playerJson["rank"];
    $playerLevel = $playerJson["level"];
}
?>
<html>
<head>
<!-- willy is "willy" bad -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.4/semantic.min.css">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300" rel="stylesheet">
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
        }
        .wrapper{
            font-family: 'Open Sans', sans-serif;
        }</style>
        
</head>
<body>
<div id="wrapper" class="center-div">
        <img src="img/logo-full.png" class="center-block" />
    Player info for <b><?php echo $playerName;?></b>:<br />Rank: <b><?php echo $playerRank;?></b><br />Mineplex Level: <?php echo $playerLevel;?>
    </div>
</body>
</html>
