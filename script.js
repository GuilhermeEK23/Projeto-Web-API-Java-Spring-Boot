const form = document.querySelector("form")
const username = document.querySelector("#username")
const user = document.querySelector("#user")
const email = document.querySelector("#email")
const password = document.querySelector("#password")
const phone = document.querySelector("#phone")

function cadastrar (){
    fetch ("http://localhost:8080/usuarios", 
        {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: "POST",
            body: JSON.stringify({
                name: user.value,
                username: username.value,
                email: email.value,
                password: password.value,
                phone: phone.value
        })
    })
    .then(function (res) {console.log(res)})
    .catch(function (res) {console.log(res)})
}

function limpar(){
    user.value = ""
    username.value = ""
    email.value = ""
    password.value = ""
    phone.value = ""
}

form.addEventListener('submit', function(event) {
    event.preventDefault()

    cadastrar()
    limpar()
})