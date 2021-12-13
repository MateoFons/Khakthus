function getUser() {
    $.ajax({
        url: "http://144.22.225.106:8080/api/user/all",
        type: "GET",
        datatype: "JSON",
        success: function (response) {
            console.log(response);
            printListUser(response);
        }
    });
}

function printListUser(response) {
    let myTable=`    
    <table>
    <tr>
    <th>Identificación</th>
    <th>Nombre</th>
    <th>Direccion</th>
    <th>Telefono</th>
    <th>Correo</th>
    <th>Contraseña</th>
    <th>Zona</th>
    <th>Tipo</th>
    <th colspan="2">Acciones</th>
    </tr>`
    for (i = 0; i < response.length; i++) {
        const obj=btoa(JSON.stringify(response[i]));
        myTable += `<tr>
        <td>${response[i].identification}</td>
        <td>${response[i].name}</td>
        <td>${response[i].address}</td>
        <td>${response[i].cellPhone}</td>
        <td>${response[i].email}</td>
        <td>${response[i].password}</td>
        <td>${response[i].zone}</td>
        <td>${response[i].type}</td>
        <td><button class = "form-btn" onclick="deleteUser(' ${ response[i].id} ')">Borrar</button></td>
        <td><button class = "form-btn" onclick= "openFormUpdate('${obj}')">Actualizar</button></td>
        </tr>`
    }
    myTable += "</table>";
    $("#tableResponse").html(myTable);
}

function createTableUser(user) {
    let data = {
        identification : $("#identificationUser").val(),
        name : $("#nameUser").val(),
        address : $("#addressUser").val(),
        cellPhone : $("#cellPhoneUser").val(),
        email : $("#emailUser").val(),
        password : $("#passwordUser").val(),
        zone : $("#zoneUser").val(),
        type : $("#typeUser").val()
    }

    let datosPeticion = JSON.stringify(data)

    $.ajax({
        url: "http://144.22.225.106:8080/api/user/new",
        data: datosPeticion,
        type: 'POST',
        contentType: "application/JSON",
        dataType: 'json',
        success: function (respuesta) {
            console.log(respuesta);
            getUser();
            alert("Se ha creado correctamente.");	
        },
        error: function (xhr, status) {
            console.log("algo falló");	
        },
        complete: function (xhr, status) {
            $("#identificationUser").val("");
            $("#nameUser").val("");
            $("#addressUser").val("");
            $("#cellPhoneUser").val("");
            $("#emailUser").val("");
            $("#passwordUser").val("");
            $("#zoneUser").val("");
            $("#typeUser").val("");
        }
    });
}

function deleteUser(idUser) {
    var element = {
        id: idUser
    }
    var dataToSend = JSON.stringify(element);

    $.ajax({
        dataType: 'json',
        data: dataToSend,
        url: "http://144.22.225.106:8080/api/user/" + idUser,
        type: 'DELETE',
        contentType: "application/JSON",
        success: function (response) {
            getUser();
            alert("Se ha eliminado correctamente.");
        },

        error: function (jqXHR, textStatus, errorThrown) {
            alert("No se ha podido eliminar.");
        }
    });
}


function updateUser2(idUser) {

    if ($("#identificationUser").val().length == 0 || $("#nameUser").val().length == 0 || $("#addressUser").val().length == 0 
    || $("#cellPhoneUser").val().length == 0 ||  $("#emailUser").val().length== 0  || $("#passwordUser").val().length==0
    || $("#zoneUser").val().length==0 ||   $("#typeUser").val().length==0)  {
        alert("Todos los campos deben estar llenos")
    } else {
        let element = {
            id: idUser,
            identification: $("#identificationUser").val(),
            name: $("#nameUser").val(),
            address: $("#addressUser").val(),
            cellPhone: $("#cellPhoneUser").val(),
            email:$("#emailUser").val(),
            password: $("#passwordUser").val(),
            zone:$("#zoneUser").val(),
            type:$("#typeUser").val()            
        }
        let dataToSend = JSON.stringify(element);

        $.ajax({
            datatype: 'json',
            data: dataToSend,
            contentType: "application/JSON",            
            url: "http://144.22.225.106:8080/api/user/update",
            type: "PUT",

            success: function (response) {
                getUser();
                closeForm();
                alert("Se ha actualizado correctamente.")              
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert("No se ha podido actualizar.")
            }
        });
    }
}