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
      const url = `http://144.22.225.106:8080/api/admin/${em}/${pass}`; //REMPLAZAR BASE_URL POR LA URL DEL BACKEND
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
      if (convertedJson.name != "NO DEFINIDO" && convertedJson.name != "" && convertedJson.name != null) {
        console.log(`bienvenido` + convertedJson.name);
        alert(`Bienvenido ` + convertedJson.name);
        window.location.href = "./tableUser.html";
      } else {
        console.log(`las credenciales no son válidas`);
        alert("El email o la contraseña son incorrectos");
      }
    } catch (error) {
      console.log(`se presentó un error: `, error);
    }
  }