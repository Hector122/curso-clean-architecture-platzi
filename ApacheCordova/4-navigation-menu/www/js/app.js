// window.fn = {};

// window.fn.open = function () {
//   var menu = document.getElementById("menu");
//   menu.open();
// };

// window.fn.load = function (page) {
//   var content = document.getElementById("content");
//   var menu = document.getElementById("menu");
//   content.load(page).then(menu.close.bind(menu));
// };


document.getElementById("menu").addEventListener("click", open);
function open (){
  var menu = document.getElementById("menu");
  menu.open();
}

function load(page){
  var content = document.getElementById("content");
  var menu = document.getElementById("menu");
  content.load(page).then(menu.close.bind(menu));
}


document.getElementById("addButton").addEventListener("click", addNumbers);
/**
 * 
 */
function addNumbers() {
  var numberOne = document.getElementById("numberOne").value;
  var numberTwo = document.getElementById("numberTwo").value;

  var value = Number(numberOne) + Number(numberTwo);

  ons.notification.toast("The sum is: " + value, { timeout: 2500 });
}

document.getElementById("clearButton").addEventListener("click", clear);
/**
 * 
 */
function clear() {
  document.getElementById("numberOne").value = "";
  document.getElementById("numberTwo").value = "";
}

