<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Customers List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
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
<div class="container-fluid">
    <br>
    <h3>Customers List</h3>
    <br>
    <div>
        <table class="table table-sm table-striped table-bordered">
            <tr class="thead-dark">
                <th scope="col">ID</th>
                <th scope="col">Client</th>
                <th scope="col">Address</th>
                <th scope="col">Phone</th>
                <th scope="col">E-Mail</th>
                <th scope="col">Car</th>
                <th scope="col">Has Taken A Car</th>
                <th scope="col">Delete</th>
                <th scope="col">Edit</th>
            </tr>
            <#list customers as customer>
                <tr>
                    <td>${customer.id}</td>
                    <td>${customer.client.firstName}</td>
                    <td>${customer.address}</td>
                    <td>${customer.phone}</td>
                    <td>${customer.email}</td>
                    <td>${customer.car.licensePlate}</td>
                    <td>true</td>
                    <td><a href="/web/customer/delete/${customer.id}" Type="Button" class="btn btn-danger" >Delete</a></td><!-- навесить route на кнопку -->
                    <!--Поставить фотку урны вместо конпки удаления-->
                    <td><a href="/web/customer/edit/${customer.id}" Type="Button" class="btn btn-danger" >Edit</a></td>
                </tr>
            </#list>

        </table>
        </form>
    </div>

    <a href="/web/customer/add">Add new customer</a>

</div>
</body>
</html>
