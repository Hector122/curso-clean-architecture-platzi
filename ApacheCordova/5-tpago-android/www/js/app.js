const SESSION_KEY = "session_key";
const BASE_URL = "https://tpagonet-dev.gcs-systems.com/dalek/";
const CONFIG = {
  MAIN_PAGE_URL: BASE_URL + "main?reset=-1",
  USERS_URL: BASE_URL + "api/userbase/users",
};

document.addEventListener("deviceready", onDeviceReady, false);
document.addEventListener("offline", whenApplicationOffline, false);
document.addEventListener("pause", onPause, false);
document.addEventListener("resume", onResume, false);
//alert(window.devicePixelRatio);

/**
 * Went the device's ready to interact with the user.
 */
function onDeviceReady() {
  //  _browserRef = window.open("#splashScreen", "_blank", "location=yes");
  setStatusBarColor("android", "#660052");

  window.setTimeout(function () {
    if (checkConnection()) {
      loadApplicationPage();

      navigator.splashscreen.hide();
    } else {
      whenApplicationOffline();
    }
  }, 2000);

  //Used to avoid scroll the windows
  document.addEventListener(
    "touchmove",
    function (e) {
      e.preventDefault();
    },
    false
  );
}

function onResume() {}

function onPause() {}
/**
 * Show dialog with no internet connection message.
 */
function whenApplicationOffline() {
  console.log("Not Internet Access...");

  exitApplicationWithAlertDialog("La aplicación no puede establecer conexión. Por favor, verifique e intente de nuevo.");
}

/**
 Check user registration to show the corresponding screen. 
 If true show the main page and load the data. 
 If false show the register or the SMS screen.
 */
function loadApplicationPage() {
  let sessionData = getSessionData();

  console.log("session data", sessionData);

  if (sessionData) {
    if (sessionData.token) {
      $.mobile.allowCrossDomainPages = true;
      $.mobile.pushStateEnabled = false;
      $.mobile.ajaxEnabled = true;
      $.mobile.ajaxLinksEnabled = true;
      $.support.cors = true;
      $.mobile.phonegapNavigationEnabled = true;

      $(document).bind("pagebeforechange", function (event, data) {
        data.options["reloadPage"] = false;
        data.options["changeHash"] = true;
        data.options["showLoadMsg"] = false;
      });

      loadState();

      window.setTimeout(function () {
        setStatusBarColor("ios", "#e4e4e4");
      }, 2000);
    } else {
      goToActivationScreen();
    }
  } else {
    goToRegisterScreen();
  }
}

/**
 * Call user menu main page "Inicio".
 */
function loadState() {
  if (window.shouldIgnoreError) {
    window.shouldIgnoreError = false;
    return;
  }

  let session = getSessionData();
  let device = session.deviceId;
  let token = session.token;

  $(":mobile-pagecontainer").pagecontainer("change", CONFIG.MAIN_PAGE_URL, {
    type: "post",
    changeHash: false,
    transition: "fade",
    data: { uid: device, token: token },
    //TODO data: { uid: "ABCD1234567890", token: "Android:63107162bd0fc1" },
  });
}
/**
 * Send a POST request to validate the user and send the OTP.
 */
function registerUser() {
  console.log("Validating Input User...!");
  //=======================================================
  let cedulaUsr = document.getElementById("txtNumeroCedula").value;
  let telefonoUsr = document.getElementById("txtNumeroTelefono").value;
  let deviceType = device.model;
  let deviceId = device.name + device.version;
  let deviceToken = device.platform + ":" + device.uuid;
  // TODO let deviceId = "ABCD1234567890";
  // TODO let deviceToken = "Android:63107162bd0fc1";
  //=======================================================

  if (validateEmptyInputUser(cedulaUsr, telefonoUsr)) {
    //Disable onclick action
    $("#btnRegistarUsuario").removeAttr("onclick");
    //showing message
    showMessage();

    window.setTimeout(function () {
      console.log("Sending [POST] request");
      $.ajax({
        type: "POST",
        contentType: "application/json",
        url: CONFIG.USERS_URL,
        data: JSON.stringify({
          cmd: "register",
          "device-type": deviceType,
          "device-id": deviceId,
          "device-token": deviceToken,
          "phone-number": telefonoUsr,
          "device-owner-id": cedulaUsr,
        }),
        success: function () {
          saveSessionData({ document: cedulaUsr, msidn: telefonoUsr });
          $.mobile.changePage("#scrRegisterScreenDialog", "flip");
        },
        error: function (error) {
          console.log(error.message);
          userInputErrorNotification("La entrada es incorrecta. Por favor verifique y trate de nuevo.");
        },
      });

      //Hide the Message Dialog
      hideMessage();

      // Enabled onclick action
      $("#btnRegistarUsuario").attr("onclick", "registerUser()");
    }, 3500);
  } else {
    userInputErrorNotification("La entrada es incorrecta. Por favor verifique y trate de nuevo.");
    $.mobile.changePage("#scrRegisterScreen", "fade");
  }
}

/**
 * Confirm User registration.
 */
function confirmUserRegister() {
  console.log("Validating Input User...!");
  //=======================================================
  let deviceType = device.model;
  let deviceId = device.name + device.version;
  let deviceToken = device.platform + ":" + device.uuid;
  // TODO let deviceId = "ABCD1234567890";
  // TODO let deviceToken = "Android:63107162bd0fc1";

  // Activation code.
  let smsCodeOtp = document.getElementById("txtCodigoActivacion").value;
  let cedulaUsr = document.getElementById("txtNumeroCedula").value;
  let telefonoUsr = document.getElementById("txtNumeroTelefono").value;

  //Significa que el usuario ha cerrado la aplicacion y no viene de la pantalla e registro.
  if (cedulaUsr == "" || telefonoUsr == "") {
    let session = getSessionData();

    cedulaUsr = session.document;
    telefonoUsr = session.msidn;
  }

  if (validateEmptyInputUser(smsCodeOtp, cedulaUsr, telefonoUsr)) {
    //disable onclick action
    $("#btnConfirmUserRegister").removeAttr("onclick");
    //showing message
    showMessage();

    window.setTimeout(function () {
      console.log("Sending [POST] request");
      $.ajax({
        type: "POST",
        contentType: "application/json",
        url: CONFIG.USERS_URL,
        data: JSON.stringify({
          cmd: "confirm",
          "device-type": deviceType,
          "device-id": deviceId,
          "device-token": $.trim(deviceToken),
          "phone-number": replaceLine(telefonoUsr),
          "device-owner-id": replaceLine(cedulaUsr),
          otp: replaceLine(smsCodeOtp),
        }),
        success: function () {
          console.log("Call Home menu...");
          saveSessionData({
            document: cedulaUsr,
            msidn: telefonoUsr,
            deviceId: deviceId,
            token: deviceToken,
          });
          $.mobile.allowCrossDomainPages = true;
          $.mobile.pushStateEnabled = false;
          $.mobile.ajaxEnabled = true;
          $.mobile.ajaxLinksEnabled = true;
          $.support.cors = true;
          $.mobile.phonegapNavigationEnabled = true;

          loadState();
        },
        error: function () {
          userInputErrorNotification("La entrada es incorrecta. Por favor verifique y trate de nuevo.");
          $("#btnConfirmUserRegister").attr("onclick", "confirmUserRegister()");
        },
      });
      hideMessage();
      //$('#btnConfirmUserRegister').attr("onclick","confirmUserRegister()");
    }, 3500);
  } else {
    userInputErrorNotification("La información ingresada es incorrecta. Por favor verifique y trate de nuevo.");
    $.mobile.changePage("#scrActivationScreen", "fade");
  }
}

/**
 * Change page to Regsiter screen.
 */
function goToRegisterScreen() {
  $.mobile.changePage("#scrRegisterScreen", "flip");
}

/**
 * Change page to Acivation screen.
 */
function goToActivationScreen() {
  $.mobile.changePage("#scrActivationScreen", "flip");
}

/**
 * Verify device internet connection.
 */
function checkConnection() {
  return window.navigator.onLine;
}

/**
 * Show a dialog to exit form the app.
 */
function exitApplication() {
  navigator.notification.confirm(
    "¿Está seguro que deseas salir de la aplicación?",
    function (buttonIndex) {
      if (buttonIndex == 2) {
        exitApplicationAndClearData();
      }
    },
    "Salir aplicación",
    ["No", "Si"]
  );
}

/**
 * Show a dialog with two button to exit the app.
 * @param {*String} message to display.
 */
function exitApplicationWhenOffline(message) {
  navigator.notification.alert(
    message,
    function (buttonIndex) {
      exitApplicationAndClearData();
    },
    "Cierre de sesión",
    "Aceptar"
  );
}

/**
 * Show a dialog message
 * @param {String} message
 */
function exitApplicationWithAlertDialog(message) {
  navigator.notification.alert(
    message,
    function (buttonIndex) {
      exitApplicationAndClearData();
    },
    "Salir aplicación",
    "Aceptar"
  );
}

/**
 * Show a dialog message.
 * @param {String} message user message.
 */
function userInputErrorNotification(message) {
  navigator.notification.alert(message, function (buttonIndex) {}, "!Lo sentimo!", "Aceptar");
}
/**
 * Show loading messge.
 */
function showMessage() {
  $.mobile.loading("show", { theme: "b", text: "Por favor, espere...!" });
}

/**
 * Hide loading message.
 */
function hideMessage() {
  $.mobile.loading("hide");
}

/**
 * Validate is any of parameter are empty.
 * @param  {...any} input
 * @returns {boolean} True is all parameters are not empty.
 */
function validateEmptyInputUser(...input) {
  for (let index in input) {
    if (input[index] === "") return false;
  }

  return true;
}

/**
 * Save user data object info.
 * @param {Object with the session information.} data
 */
function saveSessionData(data) {
  localStorage.setItem(SESSION_KEY, JSON.stringify(data));
}

/**
 * Get the user session data information.
 */
function getSessionData() {
  let session = localStorage.getItem(SESSION_KEY);
  if (session) {
    return JSON.parse(session);
  }
  return session;
}

/**
 * Clear all information about the user session.
 */
function clearSessionInfo() {
  window.localStorage.removeItem(SESSION_KEY);
}

/**
 * Call @clearSessionInfo and @goToRegisterScreen
 */
function goBackToRegister() {
  clearSessionInfo();
  goToRegisterScreen();
}

/**
 * Exit application. This plugin is used for iOS.
 */
function exitApplicationAndClearData() {
  clearSessionInfo();
  cordova.plugins.exit();
}

/**
 * Set the color of the status bar for ios.
 * @param {*} platformId ios, android, web, windows
 * @param {*} color HTML hex color.
 */
function setStatusBarColor(platformId, color) {
  if (cordova.platformId === platformId) {
    StatusBar.backgroundColorByHexString(color);
  }
}

/**
 * Regular expresion that remove the space.
 * @param {STRING} str String value.
 */
function replaceLine(str) {
  return str.replace(/(\r\n|\n|\r)/gm, "");
}

/**
 * Load assintace phone number.
 */
function cargarAsistencia() {
  loadExternalWebSite("https://wa.me/50241486913");
}

/**
 * Load tPago web site.
 */
function cargarWebSite() {
  loadExternalWebSite("http://www.tpago.com.gt");
}

/**
 * Make a intent to open with an application browser.
 * @param {String} url URL web site.
 */
function loadExternalWebSite(url) {
  $(document).ready(function () {
    $(document).bind("pagebeforechange", function (event, data) {
      data.options["reloadPage"] = false;
      data.options["changeHash"] = false;
      data.options["showLoadMsg"] = true;
    });

    window.open(encodeURI(url), "_system");
  });
}
