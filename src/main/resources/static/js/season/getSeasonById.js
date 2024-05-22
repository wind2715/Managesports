window.addEventListener('DOMContentLoaded', () => {
    const seasonId = '1'; // Chắc chắn rằng seasonId có giá trị phù hợp

    // Lấy thông tin mùa giải khi trang được load
    fetch('/api/seasons/' + seasonId)
        .then(response => response.json())
        .then(data => {
            console.log(data);
            // Populate thông tin mùa giải vào các trường của form
            document.getElementById('tenMuaGiai').value = data.tenMuaGiai;
            document.getElementById('dateStart').value = new Date(data.ngayBatDau).toISOString().split('T')[0];
            document.getElementById('dateEnd').value = new Date(data.ngayKetThuc).toISOString().split('T')[0];
        })
        .catch(error => console.error('Error:', error));

    // Thêm sự kiện click cho nút chỉnh sửa
    document.getElementById('editButton').addEventListener('click', () => {
        // Cho phép chỉnh sửa các trường trong form
        document.getElementById('tenMuaGiai').readOnly = false;
        document.getElementById('dateStart').readOnly = false;
        document.getElementById('dateEnd').readOnly = false;

        // Hiển thị nút cập nhật
        const updateButton = document.getElementById('updateButton');
        if (updateButton) {
            updateButton.style.display = 'block';
        }
    });

    // Thêm sự kiện click cho nút cập nhật
    const updateButton = document.getElementById('updateButton');
    if (updateButton) {
        updateButton.addEventListener('click', () => {
            updateSeason();
        });
    }
});

function updateSeason() {
    // Prevent the default form behavior
    event.preventDefault();

    // Get the form data
    const formData = new FormData(document.getElementById('registerForm'));
    const object = {};
    formData.forEach((value, key) => {
        object[key] = value;
    });

    // Access each attribute's value
    const tenMuaGiai = object['tenMuaGiai'];
    const dateStart = object['dateStart'];
    const dateEnd = object['dateEnd'];

    // Now you can use these variables to attach to your database
    // ...
    console.log(tenMuaGiai);
    const seasonId ='1';

    // Send a PUT request to the server to update the season information
    fetch('/api/seasons/'+seasonId, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          ten_mua_giai: tenMuaGiai,
          ngay_bat_dau: dateStart,
          ngay_ket_thuc: dateEnd,
        }),
      })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json();
    })
    .then(data => {
        // Handle the successful response from the server, such as displaying a message or updating the interface
    });
}