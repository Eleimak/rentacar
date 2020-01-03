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
    <h3>Car List</h3>
    <br>
    <div>
            <table class="table table-sm table-striped table-bordered">
                <tr class="thead-dark">
                    <th scope="col">ID</th>
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name</th>
                    <th scope="col">Gender</th>
                    <th scope="col">Delete</th>
                </tr>
                <#list people as person>
        <tr>
            <td>${person.id}</td>
            <td>${person.firstName}</td>
            <td>${person.lastName}</td>
            <td>${person.gender}</td>
            <td><a href="/web/person/delete/${person.id}" Type="Button" class="btn btn-danger" >Delete</a></td> <!-- навесить route на кнопку -->
        </tr>
    </#list>

    </table>
    </form>
</div>

</div>
</body>
</html>
