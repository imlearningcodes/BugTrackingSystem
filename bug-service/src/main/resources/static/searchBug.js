function generate_onebug(){
	 let name = document.getElementById('bugName').value;
 
//const searchBug=document.getElementById('searchBug');
	//if(!searchBug.checkvalidity()){
			//alert('form is invalid');
			//return ;
		//}
		const promise = fetch('/bug/' + name);
    promise.then(function (response) {
        return response.json();
    })
        .then(function (bug) {
	
	console.log(bug);
	
	
            const table = document.getElementById('bugsTable');
            bugsTable.innerHTML=' ';
            const row = document.createElement('tr');
            const nameColumn = document.createElement('td');
            const descriptionColumn = document.createElement('td');
            const statusColumn = document.createElement('td');
            const submitOnDateColumn = document.createElement('td');
            const projectIdColumn = document.createElement('td');
			
            nameColumn.append(bug.name);
            descriptionColumn.append(bug.description);
            statusColumn.append(bug.status);
            submitOnDateColumn.append(bug.submittedOn);
          
            projectIdColumn.append(bug.projectId);
          
            row.appendChild(nameColumn);
            row.appendChild(descriptionColumn);
            row.appendChild(statusColumn);
           
            row.appendChild(submitOnDateColumn);
            row.appendChild(projectIdColumn);
            
            table.appendChild(row);
        })
}
function generate_table() {
    const promise = fetch('/bug');
    promise.then(function (response) {
        return response.json();
    })
        .then(function (bugs) {
            console.log(bugs);
            const table = document.getElementById('bugsTable');
			bugsTable.innerHTML=' ';
            for (let index = 0; index < bugs.length; index++) {
                console.log(bugs[index]);
                const currentBug = bugs[index];
                const row = document.createElement('tr');
                const nameColumn = document.createElement('td');
                const descriptionColumn = document.createElement('td');
                const statusColumn = document.createElement('td');
                
                const submitOnDateColumn = document.createElement('td');
                
                const projectIdColumn = document.createElement('td');
               

                nameColumn.append(currentBug.name);
                descriptionColumn.append(currentBug.description);
                statusColumn.append(currentBug.status);
                
                submitOnDateColumn.append(currentBug.submittedOn);
               
                projectIdColumn.append(currentBug.projectId);
               
                row.appendChild(nameColumn);
                row.appendChild(descriptionColumn);
                row.appendChild(statusColumn);
               
               
                row.appendChild(submitOnDateColumn);
                
                row.appendChild(projectIdColumn);
                
                table.appendChild(row);
            }
        })
}