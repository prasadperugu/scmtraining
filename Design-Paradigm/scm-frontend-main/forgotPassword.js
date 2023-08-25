function Forgot(email) {
  var requestOptions = {
    method: 'POST',
    redirect: 'follow'
  };
  //?email is  query parameter.
  var url = "http://"+window.location.hostname+":8081/api/auth/forgot-password?email=" + encodeURIComponent(email);
  // var url = "http://localhost:8081/api/auth/forgot-password?email=" + encodeURIComponent(email);
  fetch(url, requestOptions)
    .then(response => {
      const successMessageElement = document.getElementById('successMessage');
      const errorMessageElement = document.getElementById('errorMessage');

      if (response.status === 200) {
        const successMessage = 'Please check your mail.';
        successMessageElement.textContent = successMessage;
        errorMessageElement.textContent = ''; // Clear error message
        return response.text();
      } else if (response.status === 404) {
        const errorMessage = 'Invalid email.';
        errorMessageElement.textContent = errorMessage;
        successMessageElement.textContent = ''; // Clear success message
      } else {
        console.log('Error', error);
      }
    })
    .catch(error => console.log('error', error));
}
