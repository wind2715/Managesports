function getAllSeasons() {
    fetch('http://localhost:8089/api/seasons', {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json'
      }
    })
    .then(response => response.json())
    .then(data => {
      const seasonsContainer = document.getElementById('seasons-container');
      console.log('Data received:', data);
      data.forEach(season => {
        const seasonCol = document.createElement('div');
        seasonCol.classList.add('col-sm-6', 'col-lg-3');
  
        const seasonCard = document.createElement('div');
        seasonCard.classList.add('card', 'shadow-sm');
        seasonCol.appendChild(seasonCard);

         const seasonNameHeader = document.createElement('h5');
         seasonNameHeader.classList.add('card-header');
         seasonNameHeader.textContent = season.tenMuaGiai;
         seasonCard.appendChild(seasonNameHeader);

        const cardBody = document.createElement('div');
        cardBody.classList.add('card-body');
        seasonCard.appendChild(cardBody);
  
        const seasonName = document.createElement('h5');
        seasonName.classList.add('card-title');
        seasonName.textContent = season.name;
        cardBody.appendChild(seasonName);
  
        const seasonImage = document.createElement('img');
        seasonImage.src = '/public/assets/img/season/vleague.jpg';
        cardBody.appendChild(seasonImage);
  
        const detailButton = document.createElement('a');
        detailButton.href = '#'; // Đặt href tạm thời là #
        detailButton.classList.add('btn', 'btn-primary', 'col-sm-12', 'detail-button');
        detailButton.setAttribute('data-id', season.idMuaGiai); // Thiết lập thuộc tính data-id
        detailButton.textContent = 'Xem chi tiết';
        cardBody.appendChild(detailButton);
  
        seasonsContainer.appendChild(seasonCol);
      });
      // Đặt sự kiện click cho từng nút "Xem chi tiết"
        document.querySelectorAll('.detail-button').forEach(button => {
            button.addEventListener('click', function(event) {
                event.preventDefault(); // Ngăn chặn hành động mặc định của thẻ <a>

                const seasonId = this.getAttribute('data-id'); // Lấy ID mùa giải từ thuộc tính data-id

                // Chuyển hướng người dùng đến đường link tương ứng với ID mùa giải
                window.location.href = '/season-detail';
            });
        });
    })
    .catch((error) => {
      console.error('Error:', error);
    });
  }