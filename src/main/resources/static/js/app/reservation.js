var main = {
    init : function () {
        var _this = this;
        $('#btn-save-reservation').on('click', function () {
            _this.save();
        });

        $('#btn-update-reservation').on('click', function () {
            _this.update();
        });

        $('#btn-delete-reservation').on('click', function () {
            _this.delete();
        });
    },


    save : function () {
        var data = {
            uid: $('#uid').val(),
            reservationDate: $('#reservationDate').val(),
            reservationTime: $('#reservationTime').val(),
            service: $('#service').val(),
            name: $('#name').val(),
            phoneNumber: $('#phoneNumber').val()
        };


        $.ajax({
            type: 'POST',
            url: '/api/reservation',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('Your reservation has been registered. See you soon!');
            window.location.href = '/reservation';
        }).fail(function (error) {
            alert('Please enter all required information');
        });
    },

    update : function () {
        var data = {
            reservationDate: $('#reservationDate').val(),
            reservationTime: $('#reservationTime').val(),
            service: $('#service').val(),
            phoneNumber: $('#phoneNumber').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/reservation/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('Your reservation has been updated');
            window.location.href = '/reservation';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    delete : function () {
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/reservation/' + id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function() {
            alert('Reservation cancelled');
            window.location.href = '/reservation';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }

};

main.init();
