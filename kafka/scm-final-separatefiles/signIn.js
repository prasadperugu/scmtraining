function signinUser() {
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

  if (!email || !password) {
    // If email or password is empty, show an error message
    document.getElementById('errorMessage').innerText = 'Please enter your email and password';
    return;
  }

  // If the reCAPTCHA response is not empty and the email/password fields are filled,
  // proceed with sign-in
  var myHeaders = new Headers();
  myHeaders.append("Content-Type", "application/json");
  const thisForm = document.getElementById('signinform');
  const formData = new FormData(thisForm).entries();
  var raw = JSON.stringify(Object.fromEntries(formData));


  fetch("http://localhost:8081/api/auth/signin", {
    method: 'POST',
    headers: myHeaders,
    body: raw,
    redirect: 'follow'
}).then(response => {
    if (response.status === 200) {
        console.log("Login successful");
        response.json().then(data => {
            // Store the token and other data in localStorage
            localStorage.setItem('access_token', data.accessToken);
            localStorage.setItem('email', data.email);
            localStorage.setItem('username', data.username);

            // Redirect to the dashboard page
            window.location.href = 'dashboard-exp.html?username=' + encodeURIComponent(data.username);
        });
    } else if (response.status === 400) {
        console.log("User not found");
        alert("please Enter Correct Details")
        document.getElementById("error").innerHTML = "Invalid user. Please try again.";
    } else if (response.status === 404) {

        document.getElementById("error").innerHTML = "Bad credential. Please try again.";
    } else {

        document.getElementById("error").innerHTML = "user not found.";
    }
}).catch(error => {
    console.error('There was a problem with the fetch operation:', error);
});
}