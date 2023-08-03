function signupUser(form,event) {
  event.preventDefault();
  var myHeaders = new Headers();
  myHeaders.append("Content-Type", "application/json");
  var formData = {};
  $(form)
    .serializeArray()
    .forEach(function (field) {
      formData[field.name] = field.value;
    });
  var raw = JSON.stringify(formData);
  fetch("http://localhost:8081/api/auth/signup", {
    method: "POST",
    headers: myHeaders,
    body: raw,
    redirect: 'follow'
  })
    .then(response => {
      if (response.status === 200) {
        return response.json();
      } else if (response.status === 400) {
        return response.json().then(errorData => {
          const errorMessageElement = document.getElementById('errorMessage');
          errorMessageElement.textContent = errorData.message;
          const successMessageElement = document.getElementById('successMessage');
          successMessageElement.textContent = '';
        });
      } else {
        throw new Error('Network response was not ok.');
      }
    })
    .then(data => {
      console.log(data.message);
      const successMessage = document.getElementById('successMessage');
      successMessage.textContent = data.message;
      const errorMessageElement = document.getElementById('errorMessage');
      errorMessageElement.textContent = '';
    })
    .catch(error => {
      console.error('There was a problem with the fetch operation:', error);
    });
}
