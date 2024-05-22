document.addEventListener('DOMContentLoaded', (event) => {
    const seasonId = '1';
    fetch('/api/teams/season/' + seasonId)
    .then(response => response.json())
    .then(data => {
        displayTeams(data);
    })
    .catch(error => {
        console.error('Error fetching teams:', error);
    });
});
function displayTeams(teams) {
    const teamsContainer = document.getElementById('teamsContainer');
    teams.forEach(team => {
        const teamCol = document.createElement('div');
        teamCol.classList.add('col-sm-6', 'col-lg-3');
        const teamCard = document.createElement('div');
        teamCard.classList.add('card', 'shadow-sm');
        teamCol.appendChild(teamCard);
        const teamNameHeader = document.createElement('h5');
        teamNameHeader.classList.add('card-header');
        teamNameHeader.textContent = team.tenDoiBong;
        teamCard.appendChild(teamNameHeader);
        const cardBody = document.createElement('div');
        cardBody.classList.add('card-body');
        teamCard.appendChild(cardBody);
        const teamImage = document.createElement('img');
        teamImage.src = '/public/assets/img/season/vleague.jpg';
        cardBody.appendChild(teamImage);
        const detailButton = document.createElement('button');
        detailButton.type = 'button';
        detailButton.classList.add('btn', 'btn-primary', 'col-sm-12', 'detail-button');
        detailButton.setAttribute('data-id', team.idDoiBong); // Thiết lập thuộc tính data-id
        detailButton.textContent = 'Xem chi tiết';
        cardBody.appendChild(detailButton);
        detailButton.addEventListener('click', () => {
            const clickedTeamId = detailButton.getAttribute('data-id'); // Lấy ID của đội bóng từ thuộc tính data-id
            console.log(`Clicked Team ID: ${clickedTeamId}`); // In ra ID của đội bóng đã được nhấp
            const teamDetailsUrl = `/team-details/${clickedTeamId}`; // Thay thế với mẫu URL chi tiết đội bóng của bạn
            window.location.href = teamDetailsUrl; // Chuyển hướng đến trang chi tiết của đội bóng
        });
        teamsContainer.appendChild(teamCol);
    });
}
