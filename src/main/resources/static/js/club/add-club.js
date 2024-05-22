document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('register').addEventListener('submit', function(event) {
        event.preventDefault();
        var teamName = document.getElementById('tendoibong').value;
        var stadium = document.getElementById('svd').value;
        var coach = document.getElementById('hlv').value;
        var id = document.getElementById('seasonId').value;
        console.log(teamName);
        console.log(stadium); 
        console.log(coach);
        console.log(id); 
        fetch("/api/teams", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          ten_doi_bong: teamName,
          san_van_dong: stadium,
          huan_luyen_vien: coach,
          id_mua_giai: id
        }),
      })
        .then(function(response) {
            if (!response.ok) {
                throw new Error('Đăng ký không thành công');
            }
            return response.json();
        })
        .then(function(data) {
            console.log(data);
            alert('Đăng ký thành công!');
        })
        .catch(function(error) {
            console.error('Error:', error.message);
            alert('Đăng ký không thành công: ' + error.message);
        });
    });
});