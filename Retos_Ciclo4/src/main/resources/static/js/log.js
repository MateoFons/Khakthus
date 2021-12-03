async function loginProcess(event) {
    event.preventDefault();
    try {
      const emailField = document.getElementById("email");
      const passwordField = document.querySelector("#password");
      if (emailField && passwordField) {
        const emailValue = emailField.value.trim();
        const passwordValue = passwordField.value.trim();
        if (emailValue != "") {
          console.log(`el email es válido`);
          if (passwordValue != "") {
            passwordField.style.backgroundColor = "inherit";

            await sendDataSync(emailValue, passwordValue); //llamado del backend usando async y await
            console.log(`he llamado al servidor`);
            //voy a enviar la información al backend, el email y la contraseña
          } else {
            console.log(`la contraseña no es válida`);
          }
        } else {
          console.log(`el email no es válido`);
        }

        console.log(`emailValue`, emailValue);
        console.log(`passwordValue`, passwordValue);
      } else {
        alert("alguno de los campos no existe");
      }
    } catch (error) {
      console.log(`se presentó un error inesperado`, error);
    }
  }
  
  async function sendDataSync(em, pass) {
    try {
      const url = `http://150.230.95.85:8080/api/user/${em}/${pass}`;
      const body = {
        email: em,
        password: pass,
      };
      const fetchOptions = {
        method: "GET",
        body: JSON.stringify(body),
        headers: {
          "Content-type": "application/json; charset=UTF-8",
          "Access-Control-Allow-Origin": "*",
        },
      };

      const response = await fetch(url);
      const convertedJson = await response.json();
      console.log(`convertedJson`, convertedJson);
      if (convertedJson.name != "NO DEFINIDO" && convertedJson.name != "") {
        console.log(`bienvenido` + convertedJson.name);
        alert(`Bienvenido ` + convertedJson.name);
        window.location.reload();
      } else {
        console.log(`las credenciales no son válidas`);
        alert("El email o la contraseña son incorrectos");
        window.location.reload();
      }
    } catch (error) {
      console.log(`se presentó un error: `, error);
    }
  }


  async function autoInit() {
    try {
      const url = `http://localhost:8080/api/user/all`;
      const fetchOptions = {
        method: "GET",
        body: JSON.stringify(),
        headers: {
          "Content-type": "application/json; charset=UTF-8",
          "Access-Control-Allow-Origin": "*",
        },
      };

      const response = await fetch(url);
      const convertedJson = await response.json();
      console.log(`convertedJson`, convertedJson);
      paintTable(convertedJson);
    } catch (error) {
      console.log(`se presentó un error: `, error);
    }
  }

  function paintTable(data) {
    let myTable = "<table>";
    myTable += "<tr>";
    myTable += "<th>Nombre</th>"
    myTable += "<th>Descripción</th>"
    myTable += "<th>Actualizar</th>"
    myTable += "<th>Borrar</th>"
    myTable += "</tr>";
    for (i = 0; i < respuesta.length; i++) {
        myTable += "<tr>";
        myTable += "<td>" + respuesta[i].name + "</td>";
        myTable += "<td>" + respuesta[i].description + "</td>";
        myTable += "<td> <button onclick='actualizarInfoCategory(" + respuesta[i].id + ")'><i class='fas fa-sync'></i></button></td>";
        myTable += "<td> <button onclick='borrarInfoCategory(" + respuesta[i].id + ")'><i class='fas fa-times-circle'></i></button></td>";
        myTable += "</tr>";
    }
    myTable += "</table>";
