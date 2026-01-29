function bookAppointment() {

    const pEl = document.getElementById("patientId");
    const dEl = document.getElementById("doctorId");
    const dateEl = document.getElementById("appointmentDate");

    if (!pEl || !dEl || !dateEl) {
        alert("Appointment form elements not found");
        return;
    }

    const appointment = {
        patientId: pEl.value,
        doctorId: dEl.value,
        appointmentDate: dateEl.value,
        status: "BOOKED"
    };

    fetch("http://localhost:8080/api/appointment/add", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(appointment)
    })
    .then(response => response.text())
    .then(msg => {
        alert("Appointment booked successfully!");
        loadAppointments();
    })
    .catch(err => {
        alert("Unable to book appointment");
    });
}

function loadAppointments() {

    const listDiv = document.getElementById("appointmentList");

    fetch("http://localhost:8080/api/appointment/all")
    .then(res => res.json())
    .then(data => {

        let html = "";

        data.forEach(a => {
            html += `<p>
                        <b>Appointment ID:</b> ${a.id}<br>
                        <b>Patient ID:</b> ${a.patientId}<br>
                        <b>Doctor ID:</b> ${a.doctorId}<br>
                        <b>Date:</b> ${a.appointmentDate}<br>
                        <b>Status:</b> ${a.status}
                     </p><hr>`;
        });

        listDiv.innerHTML = html;

    })
    .catch(err => {
        alert("Unable to load appointments");
    });
}
