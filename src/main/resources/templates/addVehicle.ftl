<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Vehicle</title>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
    <style>
        body {
            background-image: url('img/backgroundPicture.jpg');
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-size: cover;
        }
    </style>
</head>
<body>

<div>
    <fieldset>
        <legend>Add vehicle</legend>
        <form name="vehicle" action="" method="POST">
            Brand:<@spring.formInput "vehicleForm.brand" "" "text"/>
            <br>
            Model:<@spring.formInput "vehicleForm.model" "" "text"/>
            <br>
            Cost:<@spring.formInput "vehicleForm.cost" "" "text"/>
            <br>
            License Plate:<@spring.formInput "vehicleForm.licensePlate" "" "text"/>
            <br>
       <#--     Type:<@spring.formInput "vehicleForm.type" "" "text"/>-->
            Type:<@spring.formSingleSelect "vehicleForm.type", types, ""/>
            <br>
            Year of Issue:<@spring.formInput "vehicleForm.yearOfIssue" "" "text"/>
            <br>
            Rental Price:<@spring.formInput "vehicleForm.rentalFee" "" "text"/>
            <br>
            Is being repaired:<@spring.formInput "vehicleForm.maintenance" "" "text"/>
            <br>
            Taken:<@spring.formInput "vehicleForm.taken" "" "text"/>
            <br>
            <input type="submit" value="Save"/>
        </form>
    </fieldset>
</div>

</body>
</html>
