<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Vehicles List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
    <style>

        body {
            background-image: url('/img/logo.png');
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-size: 110px 90px;
            background-position: center top;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <br>
    <h3>Vehicles List</h3>
    <br>

    <div>
        <fieldset>
            <legend>Find  brand</legend>
            <form name="search" action="" method="POST">
                Brand name:<@spring.formInput "searchForm.string" "" "text"/>
                <br>
                <input type="submit" value="Search"/>
            </form>
        </fieldset>
    </div>

    <div>
        <table class="table table-sm table-striped table-bordered">
            <tr class="thead-dark">
                <th scope="col">ID</th>
                <th scope="col">Brand</th>
                <th scope="col">Model</th>
                <th scope="col">Cost</th>
                <th scope="col">License Plate Number</th>
                <th scope="col">Type</th>
                <th scope="col">Year of Issue</th>
                <th scope="col">Rental Price <a href="/web/vehicle/list/sorted" type="button" class="btn btn-outline-light"</th>
                <th scope="col">Is being repaired</th>
                <th scope="col">Taken</th>
                <th scope="col">Minutes left</th>
                <th scope="col">Delete</th>
                <th scope="col">Edit</th>
            </tr>
            <#list carset as car>

                <#assign repair = "">
                <#if car.maintenance == true>
                    <#assign repair = "yes">
                <#else>
                    <#assign repair = "no">
                </#if>
                <#assign rent = "">
                <#if car.taken == true>
                    <#assign rent = "yes">
                <#else>
                    <#assign rent = "no">
                </#if>
<#--
                <#assign minutes = 0>
                <#if car.hourBack >
                    <#assign minutes = car.hourBack>
                </#if>
-->

                <tr>
                    <td>${car.id}</td>
                    <td>${car.brand}</td>
                    <td>${car.model}</td>
                    <td>${car.cost}</td>
                    <td>${car.licensePlate}</td>
                    <td>${car.type}</td>
                    <td>${car.yearOfIssue}</td>
                    <td>${car.rentalFee}</td>
                    <td>${repair}</td>
                    <td>${rent}</td>
                    <td>${car.hourBack}</td>
                    <td><a href="/web/vehicle/delete/${car.id}" Type="Button" class="btn btn-danger" >Delete</a></td><!-- навесить route на кнопку -->
                    <!--Поставить фотку урны вместо конпки удаления-->
                    <td><a href="/web/vehicle/edit/${car.id}" Type="Button" class="btn btn-danger" >Edit</a></td>
                </tr>
            </#list>

        </table>
        </form>
    </div>

    <a href="/web/vehicle/add">Add new car</a>

</div>
</body>
</html>

