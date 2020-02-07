<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Customer</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <style>
        body {
            background-image: url('/img/logo.png');
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-size: 110px 90px;
            background-position: center top;
        }

        input[type=submit]{
            background-color: #f1fff5;
            border: rgba(0,0,0,0.44);
            color: white;
            padding: 16px 32px;
            text-decoration: none;
            margin: 4px 2px;
            cursor: pointer;
        }
    </style>

</head>
<body>

<div>
    <fieldset>
        <legend>Add customer</legend>
        <form name="customer" action="" method="POST">

            <#--     Client:<@spring.formInput "customerForm.client" "" "text"/> -->

      Client:<@spring.formSingleSelect "customerForm.client", prsl, ""/>
   <br>
   Address:<@spring.formInput "customerForm.address" "" "text"/>
   <br>
   Phone:<@spring.formInput "customerForm.phone" "" "text"/>
   <br>
   E-Mail:<@spring.formInput "customerForm.email" "" "text"/>
   <br>
 <#--  Car:<@spring.formInput "customerForm.car" "" "text"/>-->

  Car:<@spring.formSingleSelect "customerForm.car", crsl, "" />
  <br>
  Has Taken A Car:<@spring.formInput "customerForm.tookCar" "" "text"/>
  <br>
  <input type="submit" value="Save"/>
</form>
</fieldset>
</div>

<br>

<a href="http://localhost:8080/web/customer/list" type="button" class="btn btn-light"><i class="fa fa-chevron-circle-left">
    </i>Back to table</a>

</body>
</html>