const button = document.getElementById('button');
const result = document.getElementById('result');

button.addEventListener('click', ()=>{
    const number = parseInt(document.getElementById('number').value);
    // let answer = 0;
    // for (let i = 1; i <= number; i++) {
    //     answer += i;
    // }
    // result.innerHTML = `The result is: ${answer.toString()}!`;
    fetch(`http://localhost:3000/data?number=${number}`)
        .then(response => response.text())
        .then(data => {
            result.innerHTML = `The result is: ${data}!`;
        })
        .catch(error => {
            console.error('Error fetching data:', error);
            result.innerHTML = 'Error fetching data';
        });
});