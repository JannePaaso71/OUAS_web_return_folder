const TODOS = 'todos'
const input = document.querySelector('input');
const list = document.querySelector('table');
const sort = document.querySelector('span');
let todos = JSON.parse(localStorage.getItem(TODOS))

const addRow = () => {
    const newTodo = input.value
    todos.push(newTodo)
    addTadleRow(newTodo)  
    input.value = ''
    localStorage.setItem(TODOS, JSON.stringify(todos))
}

const renderArray = () => {
    for (let i = 0; i < todos.length; i++) {
        addTadleRow(todos[i])
    }
}

input.addEventListener('keypress', (event) => {
    if (event.key === 'Enter') {
        addRow()
    }
})

sort.addEventListener('click', () => {
    todos.sort()
    for (let i = todos.length - 1; i >= 0; i--) {
        list.deleteRow(i)
    }

    renderArray()
})

const deleteRow = (todo) => {
    const index = todos.indexOf(todo)
    todos.splice(index, 1)
    list.deleteRow(index)
    localStorage.setItem(TODOS, JSON.stringify(todos))
}

const addTadleRow = (text) => {
    const row = list.insertRow()
    const col1 = row.insertCell(0)
    const col2 = row.insertCell(1)

    col1.innerHTML = text
    col2.innerHTML = '<a href="#" onclick="deleteRow(\'' + Text + '\')">X</a>'
}

if (todos === null) {
    todos = []
}

renderArray()