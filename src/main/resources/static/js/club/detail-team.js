const url = window.location.href;
const idStartIndex = url.lastIndexOf('/') + 1;
const id = url.substring(idStartIndex);

const seasonsContainer = document.getElementById('team-details-container');
const playersContainer = document.getElementById('players-container');

async function fetchSeasons() {
  const baseUrl = 'http://localhost:8089/api/teams/';
  const apiUrl = `${baseUrl}${id}`;
  const response = await fetch(apiUrl);
  const seasonsData = await response.json();
  console.log(seasonsData);

  const seasonElement = document.createElement('div');
  seasonElement.className = "team-info";
  seasonElement.innerHTML = `
    <div class="info-left">
      <h2>Thông tin</h2>
      <form id="team-info-form">
        <label for="team-name">Tên đội bóng:</label>
        <input type="text" id="team-name" name="team-name" value="${seasonsData.tenDoiBong}" readonly>

        <label for="stadium">Sân vận động:</label>
        <input type="text" id="stadium" name="stadium" value="${seasonsData.sanVanDong}" readonly>

        <label for="coach">Huấn luyện viên:</label>
        <input type="text" id="coach" name="coach" value="${seasonsData.huanLuyenVien}" readonly>
      </form>
      <div class="form-buttons">
        <button id="edit-button">Chỉnh sửa</button>
        <button id="update-button" style="display: none;">Cập nhật</button>
      </div>
    </div>

    <div class="info-right">
      <img src="800px-Logo_Real_Madrid.svg.png" alt="Logo đội bóng">
    </div>

  `;
  seasonsContainer.appendChild(seasonElement);
  const editButton = document.getElementById('edit-button');
  const updateButton = document.getElementById('update-button');

  editButton.addEventListener('click', () => {
    const formInputs = seasonElement.querySelectorAll('input[type="text"]');
    formInputs.forEach(input => input.readOnly = false);
    editButton.style.display = 'none';
    updateButton.style.display = 'block';
  });
  updateButton.addEventListener('click', async () => {
    const formData = new FormData(document.getElementById('team-info-form'));
    const updatedData = {
      "ten_doi_bong": formData.get('team-name'),
      "san_van_dong": formData.get('stadium'),
      "huan_luyen_vien": formData.get('coach')
    };
    console.log(updatedData)
    console.log(`${baseUrl}${id}`)
    const updateResponse = await fetch(apiUrl, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(updatedData)
    });

    if (updateResponse.ok) {
      console.log('Form data updated successfully!');
      const formInputs = seasonElement.querySelectorAll('input[type="text"]');
      formInputs.forEach(input => input.readOnly = true);
      editButton.style.display = 'block';
      updateButton.style.display = 'none';
    } else {
      console.error('Error updating form data:', await updateResponse.text());
    }
  });
}
async function fetchPlayer() {
  let baseUrl = 'http://localhost:8089/api/teams/';
  const apiUrl = `${baseUrl}${id}`;
  const response = await fetch(apiUrl);
  const seasonsData = await response.json();
  const playersData = seasonsData.players;
  const seasonsList = playersData.map(team => {
    const seasonElement = document.createElement('tr');
    seasonElement.innerHTML = `
            <td>${team.tenCauThu}</td>
            <td>${team.loaiCauThu}</td>
            <td>${team.ngaySinh}</td>
            <td>
                <button class="update-button">Cập nhật</button>
                <button class="delete-button" data-player-id="${team.idCauThu}">Xóa</button>
            </td>
    `;

    const deleteButton = seasonElement.querySelector('.delete-button');
    const updateButton = seasonElement.querySelector('.update-button');
    deleteButton.addEventListener('click', async () => {
      const playerId = deleteButton.getAttribute('data-player-id');
      baseUrl='http://localhost:8089/api/';
      const deleteUrl = `${baseUrl}players/${playerId}`;

      try {
        const deleteResponse = await fetch(deleteUrl, {
          method: 'DELETE'
        });

        if (deleteResponse.ok) {
          console.log('Player deleted successfully!');
          // Remove the player row from the UI
          seasonElement.remove();
        } else {
          console.error('Error deleting player:', await deleteResponse.text());
        }
      } catch (error) {
        console.error('Error deleting player:', error.message);
      }
    });

    // Thêm sự kiện click cho nút "Cập nhật" trong fetchPlayer()
    updateButton.addEventListener('click', () => {
        // Hiển thị form cập nhật
        const updateForm = document.createElement('div');
        // Chuyển đổi định dạng ngày
        const formatDate = (dateString) => {
          const date = new Date(dateString);
          const year = date.getFullYear();
          let month = date.getMonth() + 1;
          month = month < 10 ? `0${month}` : month;
          let day = date.getDate();
          day = day < 10 ? `0${day}` : day;
          return `${year}-${month}-${day}`;
        };
        // Sử dụng formatDate để chuyển đổi định dạng ngày
        const formattedBirthdate = formatDate(team.ngaySinh);
        updateForm.className = "update-form";
        updateForm.innerHTML = `
            <h2>Cập nhật cầu thủ</h2>
            <form id="update-player-form">
                <label for="player-name">Tên cầu thủ:</label>
                <input type="text" id="player-name" name="player-name" value="${team.tenCauThu}" required>

                <label for="player-type">Loại cầu thủ:</label>
                <input type="text" id="player-type" name="player-type" value="${team.loaiCauThu}" required>

                <label for="player-birthdate">Ngày sinh:</label>
                <input type="date" id="player-birthdate" name="player-birthdate" value="${formattedBirthdate}" required>
                <button type="submit" id="submit-update">Cập nhật</button>
            </form>
        `;
        seasonElement.innerHTML = '';
        seasonElement.appendChild(updateForm);
        updateButton.style.display = 'none';
        deleteButton.style.display = 'none';
        const updateFormElement = document.getElementById('update-player-form');
        updateFormElement.addEventListener('submit', async (event) => {
            event.preventDefault();
            const playerName = document.getElementById('player-name').value;
            const playerType = document.getElementById('player-type').value;
            const playerBirthdate = document.getElementById('player-birthdate').value;
            const updatedPlayerData = {
                "ten_cau_thu": playerName,
                "loai_cau_thu": playerType,
                "ngay_sinh": playerBirthdate
            };
            baseUrl='http://localhost:8089/api/';
            const updateUrl = `${baseUrl}players/${team.idCauThu}`;
            try {
                const updateResponse = await fetch(updateUrl, {
                    method: 'PUT',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(updatedPlayerData)
                });

                if (updateResponse.ok) {
                    console.log('Player updated successfully!');
                    fetchPlayer();
                } else {
                    console.error('Error updating player:', await updateResponse.text());
                }
            } catch (error) {
                console.error('Error updating player:', error.message);
            }
        });
    });

    return seasonElement;
  });

  playersContainer.innerHTML = '';
  playersContainer.append(...seasonsList);
}
fetchPlayer();
fetchSeasons();
