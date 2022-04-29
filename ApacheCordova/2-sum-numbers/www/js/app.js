document.getElementById("addButton").addEventListener("click", addNumbers);
function addNumbers() {
  var numberOne = document.getElementById("numberOne").value;
  var numberTwo = document.getElementById("numberTwo").value;

  var value = Number(numberOne) + Number(numberTwo);

  ons.notification.toast("The sum is: " + value, { timeout: 2500 });
}

document.getElementById("clearButton").addEventListener("click", clear);
function clear() {
  document.getElementById("numberOne").value = "";
  document.getElementById("numberTwo").value = "";
}
