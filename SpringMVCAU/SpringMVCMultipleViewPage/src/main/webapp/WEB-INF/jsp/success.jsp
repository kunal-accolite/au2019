<html> 
<head>
    <title>Greeting Message using JavaScript</title> 
</head>
<body style="background-image:url('https://i.ytimg.com/vi/SnMA4UAk-sw/maxresdefault.jpg');">
    <label id="lblGreetings"></label>
</body>

<script>
    var myDate = new Date();
    var hrs = myDate.getHours();

    var greet;

    if (hrs < 12)
        greet = 'GOOD MORNING';
    else if (hrs >= 12 && hrs <= 17)
        greet = 'GOOD AFTERNOON';
    else if (hrs >= 17 && hrs <= 24)
        greet = 'GOOD EVENING';

    document.getElementById('lblGreetings').innerHTML =
        '<b>' + greet + '  ${ucase} </b> AND WELCOME TO ';
</script> 
</html>