document.addEventListener("DOMContentLoaded", function () {
  document
    .getElementById("registerForm")
    .addEventListener("submit", function (event) {
      event.preventDefault();

      var seasonName = document.getElementById("tenMuaGiai").value;
      var startDateString = document.getElementById("dateStart").value;
      var endDateString = document.getElementById("dateEnd").value;

      // Convert date strings from "DD/MM/YYYY" to "MM/DD/YYYY"
      var startDateParts = startDateString.split("/");
      var endDateParts = endDateString.split("/");

      var startDateStringFormatted = `${startDateParts[1]}/${startDateParts[0]}/${startDateParts[2]}`;
      var endDateStringFormatted = `${endDateParts[1]}/${endDateParts[0]}/${endDateParts[2]}`;

      // Check if the date strings are valid
      if (
        isNaN(Date.parse(startDateStringFormatted)) ||
        isNaN(Date.parse(endDateStringFormatted))
      ) {
        console.error("Invalid date");
        return;
      }

      var startDate = new Date(startDateStringFormatted);
      var endDate = new Date(endDateStringFormatted);
      // Convert dates to "yyyy-MM-dd" format
      var startDateFormatted = startDate.toISOString().split("T")[0];
      var endDateFormatted = endDate.toISOString().split("T")[0];

      console.log(seasonName);
      console.log(startDateFormatted);
      console.log(endDateFormatted);

      fetch("/api/seasons", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          ten_mua_giai: seasonName,
          ngay_bat_dau: startDateFormatted,
          ngay_ket_thuc: endDateFormatted,
        }),
      })
        .then((response) => {
          if (!response.ok) {
            throw new Error("Network response was not ok");
          }
          return response.json();
        })
        .then((data) => {
          console.log("Success:", data);
          alert("Successfully added the season");
        })
        .catch((error) => {
          console.error("Error:", error);
        });
    });
});
