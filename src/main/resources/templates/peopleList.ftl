<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>People List</title>
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
    <h3>People List</h3>


    <div >
        <fieldset>
            <legend>Find  person</legend>
            <form name="search" action="" method="POST">
                Last name:<@spring.formInput "searchForm.string" "" "text"/>
                <br>
                <input type="submit" value="Search"/>
            </form>
        </fieldset>
    </div>



    <br>
    <div>
            <table class="table table-sm table-striped table-bordered">
                <tr class="thead-dark">
                    <th scope="col">ID</th>
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name  ___ <a href="/web/person/list/sorted"   Type = "button">Click to sort</button></th>
                    <th scope="col">Gender</th>
                    <th scope="col">Delete</th>
                    <th scope="col">Edit</th>
                </tr>
                <#list people as person>
        <tr>
            <td>${person.id}</td>
            <td>${person.firstName}</td>
            <td>${person.lastName}</td>
            <td>${person.gender}</td>
            <td><a href="/web/person/delete/${person.id}" Type="Button" class="btn btn-danger" >Delete</a></td><!-- навесить route на кнопку -->
            <!--Поставить фотку урны вместо конпки удаления-->
            <td><a href="/web/person/edit/${person.id}" Type="Button" class="btn btn-danger" >Edit</a></td>
        </tr>
    </#list>

    </table>
    </form>
</div>

    <a href="/web/person/add">Add new person</a>

</div>
</body>
</html>
