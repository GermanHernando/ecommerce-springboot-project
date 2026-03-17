function togglePassword() {
		const input = document.getElementById('password');
		const btn = document.querySelector('.toggle-pw');
		input.type = input.type === 'password' ? 'text' : 'password';
		btn.textContent = input.type === 'password' ? 'mostrar' : 'ocultar';
	}