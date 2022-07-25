class VehicleService {
    constructor() {
    }

    vehicle = {
        licencePlate: "",
        route: "",
        contact: "",
        vehicleType: "",
        vehicleModel: "",
        numberOfpassengers: "",
        company: "",
        description: "",
        personnelList: []
    }

    owner = {
        firstName: "",
        lastName: "",
        contact: "",
        email: "",
        role: {
            id: 152
        },
        vehicleID: {
            id: "1"
        }
    }

    driver = {
        firstName: "",
        lastName: "",
        contact: "",
        email: "",
        role: {
            id: 153
        },
        vehicleID: {
            id: ""
        }
    }

    conductor = {
        firstName: "",
        lastName: "",
        contact: "",
        email: "",
        role: {
            id: 154
        },
        vehicleID: {
            id: ""
        }
    }

    saveVehicle() {
        console.log("saving vehicle")
        console.log(vehicleObj.vehicle)

        $.ajax({
            url: 'http://localhost:8094/api/v1/vehicle/save-vehicle',
            type: 'POST',
            dataType: "json",
            crossDomain: "true",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(vehicleObj.vehicle),
            success: function (response) {
                alert(response)
                console.log(response)

                vehicleObj.owner.vehicleID.id = response.id;
                vehicleObj.driver.vehicleID.id = response.id;
                vehicleObj.conductor.vehicleID.id = response.id;
            }
        }).fail(function (response) {
            console.log(response)
        })
    }

    vehicleCheck(licencePlate) {
        $.ajax({
            url: `http://localhost:8094/api/v1/vehicle/get-vehicle-by-licencePlate/${licencePlate}`,
            type: 'GET',
            success: function (response) {
                alert(response)
                console.log(response)

                if (response == null) {
                    swal("Good job!", "Vehicle details successfully added, you can now move to form number two ", "success")
                    document.getElementById("save-owner-btn").removeAttribute("disabled");
                } else {
                    swal("Error!", "Vehicle licence plate is already registered", "warning")
                    vehicleStatus = false;
                }
            }
        }).fail(function (response) {

        }).done((response) => {

        })
    }

    saveOwner() {
        console.log("saving owner")
        console.log(vehicleObj.owner)

        $.ajax({
            url: 'http://localhost:8094/api/v1/personnel/save-personnel',
            type: 'POST',
            dataType: "json",
            crossDomain: "true",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(vehicleObj.owner),
            success: function (response) {
                alert(response)
                console.log(response)
            }
        }).fail(function (response) {
            console.log(response)
        })
    }

    saveDriver() {
        console.log("saving driver")
        console.log(vehicleObj.driver)

        $.ajax({
            url: 'http://localhost:8094/api/v1/personnel/save-personnel',
            type: 'POST',
            dataType: "json",
            crossDomain: "true",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(vehicleObj.driver),
            success: function (response) {
                alert(response)
                console.log(response)
            }
        }).fail(function (response) {
            console.log(response)
        })
    }

    saveConductor() {
        console.log("saving conductor")
        console.log(vehicleObj.conductor)

        $.ajax({
            url: 'http://localhost:8094/api/v1/personnel/save-personnel',
            type: 'POST',
            dataType: "json",
            crossDomain: "true",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(vehicleObj.conductor),
            success: function (response) {
                alert(response)
                console.log(response)
            }
        }).fail(function (response) {
            console.log(response)
        })
    }
}

const vehicleObj = new VehicleService();
let vehicleStatus;


$(document).ready(() => {
    $('#save-vehicle-btn').on('onsubmit', function (e) {
        e.preventDefault();
        vehicleObj.vehicle.route = document.getElementById("vehicle-route").value;
        vehicleObj.vehicle.company = document.getElementById("vehicle-company").value;
        vehicleObj.vehicle.contact = document.getElementById("vehicle-contact").value;
        vehicleObj.vehicle.vehicleType = document.getElementById("vehicle-vehicleType").value;
        vehicleObj.vehicle.description = document.getElementById("vehicle-description").value;
        vehicleObj.vehicle.licencePlate = document.getElementById("vehicle-licencePlate").value;
        vehicleObj.vehicle.vehicleModel = document.getElementById("vehicle-VehicleModel").value;
        vehicleObj.vehicle.numberOfpassengers = document.getElementById("vehicle-numberOfPassengers").value;

        vehicleObj.vehicleCheck(vehicleObj.vehicle.licencePlate);
    });

    vehicleList();
})

function savePersonnel(role) {
    let personnel = role;

    console.log(document.getElementById(role + "-firstName").value);

    vehicleObj[role].firstName = document.getElementById(role + "-firstName").value;
    vehicleObj[role].lastName = document.getElementById(role + "-lastName").value;
    vehicleObj[role].contact = document.getElementById(role + "-contact").value;
    vehicleObj[role].email = document.getElementById(role + "-email").value;
    vehicleObj[role].bio = document.getElementById(role + "-bio").value;

    if (role == "owner") {
        if (checkProperties(vehicleObj.owner)) {
            alert("not empty")
        } else {
            console.log("field empty")
            console.log(vehicleObj.owner)
        }
        // vehicleObj.saveOwner();
    } else if (role == "driver") {
        vehicleObj.saveDriver();
    } else if (role == "conductor") {
        vehicleObj.saveConductor();
    }
}

function checkProperties(obj) {
    for (let key in obj) {
        if (obj[key] !== null || obj[key] != "")
            return false;
    }
    return true;
}

function vehicleList() {
    $.ajax({
        url: 'http://localhost:8094/api/v1/vehicle/get-all-vehicles',
        type: 'GET',
        success: function (response) {
            alert(response)
            console.log(response)

            $("#vehicle-list-data-table").DataTable({
                data: response,
                columns: [
                    {"data": "id"},
                    {
                        "data": function (row) {
                            return row.createdDate;
                        }
                    },
                    {
                        "data": function (row) {
                            return row.licencePlate;
                        }
                    },
                    {
                        "data": function (row) {
                            return row.route;
                        }
                    },
                    {
                        "data": function (row) {
                            return row.contact;
                        },
                        "sortable": false,
                        "searchable": false
                    },

                    {
                        "data": function (row) {
                            return row.vehicleType;
                        },
                        "sortable": false,
                        "searchable": true
                    },

                    {
                        "data": function (row) {
                            return row.company;
                        },
                        "sortable": false,
                        "searchable": false
                    }
                ],
                autoWidth: true,
                "lengthMenu": [
                    [10, 25, 50, 100, -1],
                    [10, 25, 50, 100, "All"]
                ],
                orderCellsTop: true,
                fixedHeader: true,
                dom: 'lBfrtip',
                buttons: [
                    {
                        extend:'copy',
                    },
                    {
                        extend:'csv'
                    },
                    {
                        extend:'excel'
                    },
                    {
                        extend:'pdf'
                    },
                    {
                        extend:'print'
                    }
                ]
            });

        }
    }).fail(function (response) {
        console.log(response)
    })
}