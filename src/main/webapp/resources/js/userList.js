var userList = new List('list-container', {
    valueNames: ['id', 'login', 'password', 'email', 'role', 'action'],
    page: 10,
    pagination: {
        innerWindow: 1,
        outerWindow: 1
    }
});

$('#search-field').on('keyup', function () {
    var searchString = $(this).val();
    userList.search(searchString);
});