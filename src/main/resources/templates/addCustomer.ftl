<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Customer</title>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
</head>
<body>

<div>
    <fieldset>
        <legend>Add customer</legend>
        <form name="customer" action="" method="POST">
            Client:<@spring.formInput "customerForm.client" "" "text"/>
            <br>
            Address:<@spring.formInput "customerForm.address" "" "text"/>
            <br>
            Phone:<@spring.formInput "customerForm.phone" "" "text"/>
            <br>
            E-Mail:<@spring.formInput "customerForm.email" "" "text"/>
            <br>
            Car:<@spring.formInput "customerForm.car" "" "text"/>
            <br>
            Has Taken A Car:<@spring.formInput "customerForm.tookCar" "" "text"/>
            <br>
            <input type="submit" value="Save"/>
        </form>
    </fieldset>
</div>

</body>
</html>