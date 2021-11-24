async function registerProcess(event) {
  event.preventDefault();
  try {
    const nameField = document.getElementById("name");
    const emailField = document.getElementById("email");
    const passwordField = document.getElementById("password");
    const passwordConfirmField = document.getElementById("confirm_password");
    if (nameField && emailField && passwordField && passwordConfirmField) {
      const nameValue = nameField.value.trim();
      const emailValue = emailField.value.trim();
      const passwordValue = passwordField.value.trim();
      const passwordConfirmValue = passwordConfirmField.value.trim();
      if(nameValue != ""){
        console.log(`el nombre es válido`);
        if (emailValue != "") {
          console.log(`el email es válido`);
          if (passwordValue != "") {
            console.log(`el password es válido`);
            if (passwordConfirmValue == passwordValue) {
              console.log(`la confirmación es correcta`);

              await sendDataSync(emailValue, passwordValue, nameValue); //llamado del backend usando async y await
              console.log(`he llamado al servidor`);
              //voy a enviar la información al backend, el email y la contraseña
            } else {
              console.log(`la confirmación no es válida`);
              alert(`las contraseñas no coinciden`);
            }
          } else {
            console.log(`la contraseña no es válida`);
            }
        } else {
          console.log(`el email no es válido`);
        } 
      } else {
          console.log(`el nombre no es válido`);
        }

      console.log(`nameValue`, nameValue);
      console.log(`emailValue`, emailValue);
      console.log(`passwordValue`, passwordValue);
    } else {
      alert("alguno de los campos no existe");
    }
  } catch (error) {
    console.log(`se presentó un error inesperado`, error);
  }

  console.log(`he sido enviado`);
}

async function sendDataSync(em, pass, name) {
  try {
    const url = `http://144.22.225.106:8080/api/user/new`;
    const body = {
      email: em,
      password: pass,
      name: name
    };
    const fetchOptions = {
      method: "POST",
      body: JSON.stringify(body),
      headers: {
        "Content-type": "application/json; charset=UTF-8",
        "Access-Control-Allow-Origin": "*",
      },
    };
    const response = await fetch(url, fetchOptions); //si necesito enviar el cuerpo de la petición POST|PATCH|DELETE|PUT
    //const response = await fetch(url);
    const convertedJson = await response.json();
    console.log(`convertedJson`, convertedJson);
    if (convertedJson.name) {
      console.log(`Usuario registrado exitosamente`);
      alert(`Usuario registrado exitosamente`);
      window.location= "index.html";
    } else {
      console.log(`las credenciales no son válidas`);
    }
  } catch (error) {
    console.log(`se presentó un error: `, error);
  }
}