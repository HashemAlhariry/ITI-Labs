window.onload = function () {

    var retrievedObject = localStorage.getItem('arrayItems');
    console.log();

    var arr = JSON.parse(retrievedObject);
    if (arr === null) {
        arr = 0;
    }
    for (var i = 0; i < arr.length; i++) {
        addItemfromLocalDB(new TodoItem(arr[i].item, arr[i].color, arr[i].time, arr[i].id));
    }


}

var arrayLength;
let table = document.createElement('table');
let tbody = document.createElement('tbody');


table.appendChild(tbody);

document.getElementById('body').appendChild(table);

function TodoItem(item, color, time, id) {

    this.item = item;
    this.color = color;
    this.time = time;
    this.id = id;


}

function addItemfromLocalDB(item) {
    allTodoItems.push(item);
    renderingTable(item);
}

function addItem() {

    var today = new Date();
    var date = today.getFullYear() + '-' + (today.getMonth() + 1) + '-' + today.getDate() + '_' + today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
    console.log(date);


    var todoItem = new TodoItem(document.getElementById("item").value,
        document.getElementById("color").value,
        date,
        allTodoItems.length

    );

    console.log(todoItem);
    console.log(todoItem.item + " " + todoItem.color + " " + todoItem.time);
    allTodoItems.push(todoItem);
    console.log("ARRAY LENGTH " + allTodoItems.length);
    localStorage.setItem('arrayItems', JSON.stringify(allTodoItems));

    renderingTable(todoItem);

}





function renderingTable(user) {

    let row = document.createElement('tr');
    let arrLength = allTodoItems.length;
    row.setAttribute('id', arrLength);
    var div = document.createElement('div');
    div.innerHTML = user.time + "<br> <br>" + user.item;

    div.id = arrLength;
    div.style.height = '200px';
    div.style.width = '200px';
    div.style.backgroundColor = user.color;
    div.draggable = true;
    div.ondragstart = drag;

    var btn = document.createElement('input');

    btn.setAttribute('id', (arrLength - 1));
    btn.type = "button";
    btn.className = "btn";
    btn.value = "DELETE";

    btn.onclick = (function () {

        document.getElementById(this.id).remove();
        console.log("ITEM DELETE" + this.id);
        allTodoItems.splice(this.id - 1, 1);
        localStorage.setItem('arrayItems', JSON.stringify(allTodoItems));

    });

    row.appendChild(div);
    row.appendChild(btn);
    tbody.appendChild(row);

}
var allTodoItems = [];

function allowDrop(ev) {
    ev.preventDefault();
}


function drag(ev) {
    ev.dataTransfer.setData("text", ev.target.id);


}

function deleteItem(index) {
    console.log(index);
}
function drop(ev) {

    document.getElementById(ev.dataTransfer.getData("text")).remove();
    allTodoItems.splice(ev.dataTransfer.getData("text") - 2, 1);
    localStorage.setItem('arrayItems', JSON.stringify(allTodoItems));

}

