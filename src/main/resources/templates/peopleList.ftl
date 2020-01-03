<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>People List</title>
</head>
<body>
<div class="container-fluid">
    <br>
    <h3>Car List</h3>
    <br>
    <div>
            <table class="table table-sm table-striped table-bordered table-dark">
                <tr class="bg-success">
                    <th>ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Gender</th>
                </tr>
                <#list people as person>
        <tr>
            <td>${person.id}</td>
            <td>${person.firstName}</td>
            <td>${person.lastName}</td>
            <td>${person.gender}</td>
        </tr>
    </#list>

    </table>
    </form>
</div>

</div>
</body>
</html>
