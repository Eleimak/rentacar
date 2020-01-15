<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Person</title>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
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
