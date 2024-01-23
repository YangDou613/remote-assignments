const headline = document.querySelector('.headline')
const button = document.querySelector('.button')
const hideContainer = document.querySelector('.hide-container')

headline.addEventListener('click', () => {
  headline.textContent = 'Have a Good Time!'
});

button.addEventListener('click', () => {
  if (hideContainer.style.display === 'none') {
    hideContainer.removeAttribute('style');
  } else {
    hideContainer.style.display = 'none';
  }
});
