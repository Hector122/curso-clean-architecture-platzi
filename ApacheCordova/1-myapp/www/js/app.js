document.getElementById("clickMe").addEventListener("click", sayHello);

function sayHello() {
  var name = document.getElementById("myName").value;

  ons.notification.alert("Hello " + name);
  ons.notification.toast("From toast " + name, { timeout: 2000 });
}

document.getElementById("clear").addEventListener("click", clear);
function clear() {
  document.getElementById("myName").value = "";
}
