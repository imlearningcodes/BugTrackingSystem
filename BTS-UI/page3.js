// // // function getTable() {
// // //     ordersPrint=
// // //    <table>
// // // <thead>
// // //     <div>
// // //         <th>PROJECT ID</th>
// // //         <th>STATUS</th>
// // //         <th>PRIORITY</th>
// // //         <th>BUILD VERSION</th>
// // //         <th>SUBMITTED ON</th>

// // //     </div>
   
// // // </thead>
// // // <tbody id>
// // //     <tr>
// // //         <td>IDFF</td>
// // //         <td>OPEN</td>
// // //         <td>
// // //             HIGH
// // //         </td>
// // //         <td> 2.0</td>
// // //         <td>2nd May</td>
// // //     </tr>
// // // </tbody>
// // //    </table>
// // //     document.getElementById("orders").innerHTML = ordersPrint;

// // // }
// // function generate_table() {
// //     // get the reference for the body
// //     var body = document.getElementsByTagName("body")[0];
  
// //     // creates a <table> element and a <tbody> element
// //     var tbl = document.createElement("table");
// //     var tblBody = document.createElement("tbody");
  
// //     // creating all cells
// //     for (var i = 0; i < 2; i++) {
// //       // creates a table row
// //       var row = document.createElement("tr");
  
// //       for (var j = 0; j < 2; j++) {
// //         // Create a <td> element and a text node, make the text
// //         // node the contents of the <td>, and put the <td> at
// //         // the end of the table row
// //         var cell = document.createElement("td");
// //         var cellText = document.createTextNode("cell in row "+i+", column "+j);
// //         cell.appendChild(cellText);
// //         row.appendChild(cell);
// //       }
  
// //       // add the row to the end of the table body
// //       tblBody.appendChild(row);
// //     }
  
// //     // put the <tbody> in the <table>
// //     tbl.appendChild(tblBody);
// //     // appends <table> into <body>
// //     body.appendChild(tbl);
// //     // sets the border attribute of tbl to 2;
// //     tbl.setAttribute("border", "2");
// //   }
// function generate_table(){
// window.addEventListener("load", function(){
//     // (B) PARSE THE JSON STRING INTO OBJECT FIRST
//     var data = '{"Name":"John Doe","Email":"john@doe.com","Gender":"male"}';
//     data = JSON.parse(data);
//     // console.table(data);
   
//     // (C) GENERATE TABLE
//     // (C1) CREATE EMPTY TABLE
//     var table = document.createElement("table"), row, cellA, cellB;
//   //  document.getElementById("demoA").appendChild(table);
//     for (let key in data) {
//       // (C2) ROWS & CELLS
//       row = document.createElement("tr");
//       cellA = document.createElement("td");
//       cellB = document.createElement("td");
   
//       // (C3) KEY & VALUE
//       cellA.innerHTML = key;
//       cellB.innerHTML = data[key];
   
//       // (C4) ATTACH ROW & CELLS
//       table.appendChild(row);
//       row.appendChild(cellA);
//       row.appendChild(cellB);
//     }
//   });}

function generate_table() {
    var Bugs = [
        {   "Bug_ID" : 1,
            "Project ID": "1DFT",
            "STATUS": "OPEN",
            "PRIORITY": "HIGH",
            "BUILD VERSON": 2.0,
            "SUBMITTED ON": "16-03-2021"
        },
        {
            "Bug_ID" : 2,
            "Project ID": "2IPH",
            "STATUS": "CLOSED",
            "PRIORITY": "HIGH",
            "BUILD VERSON": 2.0,
            "SUBMITTED ON": "01-09-2020"
        },
        {
            "Bug_ID" : 3,
            "Project ID": "3RTY",
            "STATUS": "REJECTED",
            "PRIORITY": "MILD",
            "BUILD VERSON": 2.19,
            "SUBMITTED ON": "26-09-2021"
        },
    ]

    // EXTRACT VALUE FOR HTML HEADER. 
   
    var col = [];
    for (var i = 0; i < Bugs.length; i++) {
        for (var key in Bugs[i]) {
            if (col.indexOf(key) === -1) {
                col.push(key);
            }
        }
    }

    // CREATE DYNAMIC TABLE.
    var table = document.createElement("table");

    // CREATE HTML TABLE HEADER ROW USING THE EXTRACTED HEADERS ABOVE.

    var tr = table.insertRow(-1);                   // TABLE ROW.

    for (var i = 0; i < col.length; i++) {
        var th = document.createElement("th");      // TABLE HEADER.
        th.innerHTML = col[i];
        tr.appendChild(th);
    }
    var p= document.getElementById("bugID").value;
    console.log(p);
    // for (var i = 0; i < Bugs.length; i++){
    //     // look for the entry with a matching `code` value
    //     if (Bugs[i].Bug_ID == p){
    //        // we found it
    //       console.log("found it!");
    //     }
    //   }
    // ADD JSON DATA TO THE TABLE AS ROWS.
  
     for (var i = 0; i < Bugs.length; i++) {
         
         tr = table.insertRow(-1);

         for (var j = 0; j < col.length; j++) {
         var tabCell = tr.insertCell(-1);
         if (Bugs[i].Bug_ID == p){
            tabCell.innerHTML = Bugs[i][col[j]];
           console.log("found it!");
           
         }
        
       }
        
     }
    

    // FINALLY ADD THE NEWLY CREATED TABLE WITH JSON DATA TO A CONTAINER.
    var divContainer = document.getElementById("showData");
    divContainer.innerHTML = "";
    divContainer.appendChild(table);
}