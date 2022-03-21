let table = document.createElement('table');
let thead = document.createElement('thead');
let tbody = document.createElement('tbody');

let row_1 = document.createElement('tr');
let heading_1 = document.createElement('th');
heading_1.innerHTML = "First Name";
let heading_2 = document.createElement('th');
heading_2.innerHTML = "Last Name";
let heading_3 = document.createElement('th');
heading_3.innerHTML = "Date Of Birth";
let heading_4 = document.createElement('th');
heading_4.innerHTML = "Department";

table.appendChild(thead);
table.appendChild(tbody);

row_1.appendChild(heading_1);
row_1.appendChild(heading_2);
row_1.appendChild(heading_3);
row_1.appendChild(heading_4);
thead.appendChild(row_1);


document.getElementById('body').appendChild(table);

function User(fName, lName, birthDate, department) {

    this.fName = fName;
    this.lName = lName;
    this.birthDate = birthDate;
    this.department = department;

}

function addUser() {

    var user = new User(document.getElementById("Uname").value,
        document.getElementById("lName").value,
        document.getElementById("birthDate").value,
        document.getElementById("department").value);
    console.log(user);
    console.log(user.fName + " " + user.lName + " " + user.birthDate + " " + user.department);
    allUsers.push(user);
    console.log("ARRAY LENGTH " + allUsers.length);
    renderingTable(user);

}

function renderingTable(user) {


    let row = document.createElement('tr');
    let arrLength = allUsers.length;
    row.setAttribute('id', arrLength);
    //console.log(arrLength + " " + row.getAttribute('id'));
    let row_data_1 = document.createElement('td');
    row_data_1.innerHTML = user.fName;
    let row_data_2 = document.createElement('td');
    row_data_2.innerHTML = user.lName;
    let row_data_3 = document.createElement('td');
    row_data_3.innerHTML = user.birthDate;
    let row_data_4 = document.createElement('td');
    row_data_4.innerHTML = user.department;
    var btn = document.createElement('input');
    btn.setAttribute('id', arrLength);
    btn.type = "button";
    btn.className = "btn";
    btn.value = "DELETE";
    
    btn.onclick = (function () {
        document.getElementById(this.id).remove();
    });

    row.appendChild(row_data_1);
    row.appendChild(row_data_2);
    row.appendChild(row_data_3);
    row.appendChild(row_data_4);
    row.appendChild(btn);
    tbody.appendChild(row);

}
var allUsers = [];

