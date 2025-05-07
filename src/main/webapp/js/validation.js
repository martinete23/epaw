const form = document.getElementById('registerForm');
const password = document.getElementById('password');
const confirmPassword = document.getElementById('confirmPassword');

// check passwords are equal
confirmPassword.addEventListener('input', () => {
  confirmPassword.setCustomValidity(
    confirmPassword.value !== password.value ? "Passwords do not match." : ""
  );
});

Object.entries(serverErrors).forEach(([field, message]) => {
  const input = document.getElementsByName(field)[0];
  if (input) {
    input.setCustomValidity(message);
    input.reportValidity();
    input.addEventListener('input', () => input.setCustomValidity(''));
  }
});

// check before submit
form.addEventListener('submit', event => {
  if (!form.checkValidity()) {
    event.preventDefault();
    form.reportValidity();
  }
});
