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