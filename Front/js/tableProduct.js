function getProduct() {
    $.ajax({
        url: "http://144.22.225.106:8080/api/laptop/all",
        type: "GET",
        datatype: "JSON",
        success: function (response) {
            console.log(response);
            printListProduct(response);
        }
    });
}

function printListProduct(response) {
    let myTable = `    
    <table>
    <tr>
    <th>Imagen</th>
    <th>Marca</th>
    <th>Modelo</th>
    <th>Procesador</th>
    <th>OS</th>
    <th>Descripción</th>
    <th>Memoria</th>
    <th>Disco duro</th>
    <th>Disponibilidad</th>
    <th>Precio</th>
    <th>Cantidad</th>
    <th colspan="2">Acciones</th>
    </tr>`
    for (i = 0; i < response.length; i++) {
        const obj = btoa(JSON.stringify(response[i]));
        myTable += `<tr>
        <td>${response[i].photography}</td>
        <td>${response[i].brand}</td>
        <td>${response[i].model}</td>
        <td>${response[i].procesor}</td>
        <td>${response[i].os}</td>
        <td>${response[i].description}</td>
        <td>${response[i].memory}</td>
        <td>${response[i].hardDrive}</td>`
        if (response[i].availability == true) {
            myTable += `<td>Disponible</td>`
        } else {
            myTable += `<td>No disponible</td>`
        }
        myTable += `<td>${response[i].price}</td>
        <td>${response[i].quantity}</td>
        <td><button class = "form-btn" onclick="deleteProduct(' ${response[i].id} ')">Borrar</button></td>
        <td><button class = "form-btn" onclick= "openFormUpdate(' ${obj} ')">Actualizar</button></td>
        </tr>`
    }
    myTable += "</table>";
    $("#tableResponse").html(myTable);
}

function createProduct(prod) {
    let data = {
        brand: $("#brandProd").val(),
        model: $("#modelProd").val(),
        procesor: $("#procesorProd").val(),
        os: $("#osProd").val(),
        description: $("#descriptionProd").val(),
        memory: $("#memoryProd").val(),
        hardDrive: $("#hardDriveProd").val(),
        availability: $("#availabilityProd").val(),
        price: $("#priceProd").val(),
        quantity: $("#quantityProd").val(),
        photography: $("#photography").val()
    }

    let datosPeticion = JSON.stringify(data)

    $.ajax({
        url: "http://144.22.225.106:8080/api/laptop/new",
        data: datosPeticion,
        type: 'POST',
        contentType: "application/JSON",
        dataType: 'json',
        success: function (respuesta) {
            console.log(respuesta);
            getProduct();
            alert("Se ha creado correctamente.");
        },
        error: function (xhr, status) {
            console.log("algo falló");
        },
        complete: function (xhr, status) {
            $("#brandProd").val("");
            $("#modelProd").val("");
            $("#procesorProd").val("");
            $("#osProd").val("");
            $("#descriptionProd").val("");
            $("#memoryProd").val("");
            $("#hardDriveProd").val("");
            $("#availabilityProd").val("");
            $("#priceProd").val("");
            $("#quantityProd").val("");
            $("#photography").val("");
        }
    });
}

function deleteProduct(idProd) {
    var element = {
        id: idProd
    }
    var dataToSend = JSON.stringify(element);

    $.ajax({
        dataType: 'json',
        data: dataToSend,
        url: "http://144.22.225.106:8080/api/laptop/" + idProd,
        type: 'DELETE',
        contentType: "application/JSON",
        success: function (response) {
            console.log(response);
            getProduct();
            alert("Se ha Eliminado Correctamente.")
        },

        error: function (jqXHR, textStatus, errorThrown) {
            alert("No se Elimino Correctamente!")
        }
    });
}


function updateProduct(idProd) {

    if ($("#brandProd").val().length == 0 || $("#modelProd").val().length == 0 || $("#procesorProd").val().length == 0
        || $("#osProd").val().length == 0 || $("#descriptionProd").val().length == 0 || $("#memoryProd").val().length == 0
        || $("#hardDriveProd").val().length == 0 || $("#availabilityProd").val().length == 0 || $("#priceProd").val().length == 0
        || $("#quantityProd").val().length == 0) {
        alert("Todos los campos deben estar llenos")
    } else {
        let element = {
            id: idProd,
            brand: $("#brandProd").val(),
            model: $("#modelProd").val(),
            procesor: $("#procesorProd").val(),
            os: $("#osProd").val(),
            description: $("#descriptionProd").val(),
            memory: $("#memoryProd").val(),
            hardDrive: $("#hardDriveProd").val(),
            availability: $("#availabilityProd").val(),
            price: $("#priceProd").val(),
            quantity: $("#quantityProd").val(),
            photography: $("#photography").val()
        }
        let dataToSend = JSON.stringify(element);

        $.ajax({
            datatype: 'json',
            data: dataToSend,
            contentType: "application/JSON",
            url: "http://144.22.225.106:8080/api/laptop/update",
            type: "PUT",

            success: function (response) {
                getProduct();
                closeForm();
                alert("Se ha actualizado correctamente.")
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert("No se ha podido actualizar.")
            }
        });
    }
}