function signinUser(event) {
    event.preventDefault();
    // Get the reCAPTCHA response
    const recaptchaResponse = grecaptcha.getResponse();
    if (!recaptchaResponse) {
        // If the reCAPTCHA response is empty, show an error message
        document.getElementById('errorMessage').innerText = 'Please complete the reCAPTCHA';
        return;
    }
    // Validate the email and password fields
    const email = document.getElementById('email').value.trim();
    const password = document.getElementById('password').value.trim();

// If the reCAPTCHA response is not empty and the email/password fields are filled,
// proceed with sign-in
var myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");
const thisForm = document.getElementById('signinform');
const formData = new FormData(thisForm).entries();
var raw = JSON.stringify(Object.fromEntries(formData));

try {
    fetch("http://"+window.location.hostname+":8081/api/auth/signin", {
        // fetch("http://localhost:8081/api/auth/signin", {
        method: 'POST',
        headers: myHeaders,
        body: raw,
        redirect: 'follow'
    }).then(response => {
        if (response.status === 200) {
            console.log("Login successful");
            response.json().then(data => {
                localStorage.setItem('access_token', data.accessToken);
                localStorage.setItem('email', data.email);
                localStorage.setItem('username', data.username);
    
                // Redirect to the dashboard page
                window.location.href = 'dashboard-exp.html?username=' + encodeURIComponent(data.username);
            });
        } else if (response.status === 400) {
            // Login failed
            const errorMessage = 'Login failed';
            document.getElementById('errorMessage').innerText = errorMessage;
            document.getElementById('errorMessage').style.display = 'block';
        } else if (response.status === 401) {
            // Login failed
            const errorMessage = 'Incorrect password. Please try again.';
            document.getElementById('errorMessage').innerText = errorMessage;
            document.getElementById('errorMessage').style.display = 'block';
        } else if (response.status === 404) {
            // Login failed
            const errorMessage = 'Bad credential. Please try again.';
            document.getElementById('errorMessage').innerText = errorMessage;
            document.getElementById('errorMessage').style.display = 'block';
        } else {
            // Login failed
            const errorMessage = 'An unexpected error occurred. Please try again.';
            document.getElementById('errorMessage').innerText = errorMessage;
            document.getElementById('errorMessage').style.display = 'block';
        }
    }).catch(error => {
        console.error('There was a problem with the fetch operation:', error);
    });
} catch (error) {
    console.error(error);
}
}
