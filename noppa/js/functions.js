
const button = document.querySelector('button');

button.addEventListener('click', rolldice);

const images = ["./images/1.png", "./images/2.png", "./images/3.png", "./images/4.png", "./images/5.png", "./images/6.png"];

function getRandomIntNumberInRange(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
}

function rolldice() {
 
    const imageElement = document.querySelector('#dice');
    const randomIndex = getRandomIntNumberInRange(0, images.length - 1);
    imageElement.src = images[randomIndex];
}