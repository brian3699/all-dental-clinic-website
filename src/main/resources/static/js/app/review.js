var main = {
    init : function () {
        var _this = this;
        $('#btn-save-review').on('click', function () {
            _this.save();
        });

        $('#btn-update-review').on('click', function () {
            _this.update();
        });

        $('#btn-delete-review').on('click', function () {
            _this.delete();
        });
    },

    save : function () {
        var data = {
            title: $('#title').val(),
            name: $('#name').val(),
            body: $('#body').val(),
            visitDate: $('#visitDate').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/review',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('리뷰가 입력되었습니다');
            window.location.href = '/';
        }).fail(function (error) {
            alert("모든 항목을 입력해주세요");
        });
    },
    update : function () {
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('Your post has been updated');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    delete : function () {
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function() {
            alert('Post deleted');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }

};

main.init();
