$(document).ready(() => {
    supportList()
})
function supportList() {
    $.ajax({
        url: '',
        type: 'GET',
        success: function (response) {
            alert(response)
            console.log(response)

            $("#application-list-data-table").DataTable({
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