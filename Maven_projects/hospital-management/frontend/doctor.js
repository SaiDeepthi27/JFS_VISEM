function registerDoctor() {

    const nameEl = document.getElementById("dname");
    const specEl = document.getElementById("dspecialization");
    const availEl = document.getElementById("davailability");

    if (!nameEl || !specEl || !availEl) {
        alert("Doctor form elements not found");
        return;
    }

    const doctor = {
        name: nameEl.value,
        specialization: specEl.value,
        availability: availEl.value
    };

    fetch("http://localhost:8080/api/doctor/add", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(doctor)
    })
    .then(response => response.text())
    .then(msg => {
        alert("Doctor Registered Successfully!");
        nameEl.value = "";
        specEl.value = "";
        availEl.value = "";
        loadDoctors();
    })
    .catch(error => {
        alert("Unable to register doctor");
    });
}

function loadDoctors() {

    const listDiv = document.getElementById("doctorList");

    fetch("http://localhost:8080/api/doctor/all")
    .then(response => response.json())
    .then(doctors => {

        let html = "";

        doctors.forEach(d => {
            html += `<p>
                        <b>Name:</b> ${d.name}<br>
                        <b>Specialization:</b> ${d.specialization}<br>
                        <b>Availability:</b> ${d.availability}
                     </p><hr>`;
        });

        listDiv.innerHTML = html;

    })
    .catch(error => {
        alert("Unable to load doctors");
    });
}
