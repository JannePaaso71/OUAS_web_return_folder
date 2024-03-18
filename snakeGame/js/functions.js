var blockSizes = 25;
var rows = 20;
var cols = 20;
var context;
var gameboard;
var snakex = blockSizes * 10;
var snakey = blockSizes * 10;
var squareX;
var squareY;
var velocityX = 0;
var velocityY = 0;
var snake = [];
var gameover = false;

window.onload = function() {
    gameboard = document.getElementById('gameboard');
    gameboard.width = blockSizes * cols;
    gameboard.height = blockSizes * rows;
    context = gameboard.getContext('2d');

    placeX();
    document.addEventListener('keydown', changeDirection);
    setInterval(update, 1000/10);
}

function update() {
    if(gameover) {
        return;
    }

    context.fillStyle = "black";
    context.fillRect(0, 0, gameboard.width, gameboard.height);

    context.fillStyle = "green";
    snakex += velocityX * blockSizes;
    snakey += velocityY * blockSizes;
    context.fillRect(snakex, snakey, blockSizes, blockSizes);
    for(let i = 0; i < snake.length; i++) {
        context.fillRect(snake[i][0], snake[i][1], blockSizes, blockSizes);
    }

    context.fillStyle = "yellow";
    context.fillRect(squareX, squareY, blockSizes, blockSizes);
    if(snakex == squareX && snakey == squareY) {
        snake.push(squareX, squareY);
        placeX();
    }
    for(let i = snake.length - 1; i > 0; i--) {
        snake[i] = snake[i-1];
    }
    if(snake.length) {
        snake[0] = [snakex, snakey];
    }
    if(snakex < 0 || snakex >= gameboard.width || snakey < 0 || snakey >= gameboard.height){
        gameover = true;
        alert("Game Over");
    }
}

function placeX() {
    squareX = Math.floor(Math.random() * cols)*blockSizes;
    squareY = Math.floor(Math.random() * rows)*blockSizes;
    //update();
}

function changeDirection(e) {
    if(e.code == "ArrowUp") {
        velocityX = 0;
        velocityY = -1;
    } else if(e.code == "ArrowDown") {
        velocityX = 0;
        velocityY = 1;
    } else if(e.code == "ArrowLeft") {
        velocityX = -1;
        velocityY = 0;
    } else if(e.code == "ArrowRight") {
        velocityX = 1;
        velocityY = 0;
    }
}