<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>People List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <br>
    <h3>Vehicle List</h3>
    <br>
    <div>
        <table class="table table-sm table-striped table-bordered">
            <tr class="thead-dark">
                <th scope="col">ID</th>
                <th scope="col">Brand</th>
                <th scope="col">Model</th>
                <th scope="col">Cost</th>
                <th scope="col">Delete</th>
                <th scope="col">Edit</th>
            </tr>
            <#list carset as car>
                <tr>
                    <td>${car.id}</td>
                    <td>${car.brand}</td>
                    <td>${car.model}</td>
                    <td>${car.cost}</td>
                    <td><a href="/web/car/delete/${car.id}" Type="Button" class="btn btn-danger" >Delete</a></td><!-- навесить route на кнопку -->
                    <!--Поставить фотку урны вместо конпки удаления-->
                    <td><a href="/web/car/edit/${car.id}" Type="Button" class="btn btn-danger" >Edit</a></td>
                </tr>
            </#list>

        </table>
        </form>
    </div>

    <a href="/web/car/add">Add new car</a>

</div>
</body>
</html>

