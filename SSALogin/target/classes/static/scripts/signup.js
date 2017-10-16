function removeAllAlerts() {
	var alert = document.getElementsByClassName('alert');
	while (alert[0]) {
		alert[0].parentNode.removeChild(alert[0]);
	}
}

function validateForm() {
	removeAllAlerts();
	validatePassword();
	validateLogin();
	if (document.getElementsByClassName('alert')[0]) {
		if (event.preventDefault) {
			event.preventDefault();
		}
		return false;
	}
	return true;
}

var loginRegEx = new RegExp("^[a-zA-z0-9].{4,255}$");
var passwordRegEx = new RegExp("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,255}$");

function createErrorMessage(error) {
	var h4 = document.createElement("h4");
	h4.className = 'alert alert-danger';
	h4.innerHTML = error;
	var refElem = document.getElementById('info');
	refElem.parentNode.insertBefore(h4, refElem.nextSibling);
}
function validateLogin() {
	document.getElementById("login").value.replace(/^\s+|\s+$/g, ''); // trim()
	if (!loginRegEx.test(document.getElementById("login").value)) {
		createErrorMessage("Имя пользователя должно быть длиннее 4 символов и состоять из цифр и букв английского алфавита");
	}
}

function validatePassword() {
	if (document.getElementById("password").value !== document.getElementById("password-confirm").value)
		createErrorMessage("Пароли должны совпадать");
	if (!passwordRegEx.test(document.getElementById("password").value))
		createErrorMessage("Пароль недостаточно сложен: должны быть цифры, заглавные и строчные буквы и длина минимум 8 символов");
}