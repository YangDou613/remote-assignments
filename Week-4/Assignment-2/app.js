function ajax(src, callback) {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState === 4) {
			callback(JSON.parse(xhr.responseText));
		}
	};
	xhr.open('GET', src);
	xhr.send();
}

function render(data) {
	for (var i = 0; i < data.length; i++) {

		let div = document.createElement(`div`);
		div.id = `product${i}`

		let name = document.createElement('h1');
		name.textContent = data[i].name;

		let price = document.createElement('p');
		price.textContent = `$ ${data[i].price}`;

		let description = document.createElement('p');
		description.textContent = data[i].description;

		div.appendChild(name);
		div.appendChild(price);
		div.appendChild(description);

		document.body.appendChild(div);
	}
}

ajax('https://remote-assignment.s3.ap-northeast-1.amazonaws.com/products',
	function (response) {
		render(response);
	});
