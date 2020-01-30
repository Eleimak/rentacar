<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Person</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <style>
        body {
            background-image: url('img/logo.png');
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-size: cover;
        }
    </style>

</head>
<body>


<div>
    <fieldset>
        <legend>Add person</legend>
        <form name="person" action="" method="POST">
            First name:<@spring.formInput "personForm.firstName" "" "text"/>
            <br>
            Last name:<@spring.formInput "personForm.lastName" "" "text"/>
            <br>
            Gender:<@spring.formInput "personForm.gender" "" "text"/>
            <input type="submit" value="Save"/>
        </form>
    </fieldset>
</div>

</body>
</html>
