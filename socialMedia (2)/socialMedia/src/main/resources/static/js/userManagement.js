
function myButtonClick() {
	alert("Button is Clicked");
}

function addUser() {
	let name = document.getElementById('name').value;
	let email = document.getElementById('email').value;
	let birthDate = document.getElementById('birthDate').value;

	fetch('http://localhost:9090/jpa/users', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify({

			name: name,
			birthDate: birthDate,
			email: email
		})
	}
	).then(
		response => {
			if (!response.ok) {
				throw new Error("Failed to run");
			}

			alert("Added User");
		}

	);
}

function fetchUsers() {
	let userTable = document.getElementById('userTable');
	let existingTBody = document.querySelector('#userTable tbody');

	if (existingTBody) {
		existingTBody.remove();
	}

	let tbody = document.createElement('tbody');
	tbody.innerHTML = "<tr><td>Loading.....</td></tr>";
	userTable.appendChild(tbody);

	fetch('http://localhost:9090/jpa/users')
		.then(response => response.json())
		.then(users => {
			tbody.innerHTML = '<tr><th>ID</th><th>Name</th><th>Email</th><th>BirthDate</th></tr>';

			users.forEach(user => {
				let row = document.createElement('tr');
				row.innerHTML = `<td>${user.id}<td>${user.name}</td><td>${user.email}</td><td>${user.birthDate}</td>`;
				tbody.appendChild(row);
			}
			);

			userTable.appendChild(tbody);

		});
}