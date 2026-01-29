function registerPatient() {

    var nameEl = document.getElementById("name");
    var ageEl = document.getElementById("age");
    var genderEl = document.getElementById("gender");
    var contactEl = document.getElementById("contact");

    if (!nameEl || !ageEl || !genderEl || !contactEl) {
        alert("Form element IDs do not match JavaScript – check HTML input IDs");
        return;
    }

    const patient = {
        name: nameEl.value,
        age: ageEl.value,
        gender: genderEl.value,
        contact: contactEl.value
    };

    fetch("http://localhost:8080/api/patient/add", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(patient)
    })
    .then(response => response.text())
    .then(data => {
        alert(data);
    })
    .catch(error => {
        console.log("Error:", error);
        alert("Patient not registered – API error");
    });
}


