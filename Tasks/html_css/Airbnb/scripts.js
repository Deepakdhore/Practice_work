window.addEventListener("DOMContentLoaded", function () {
    var profileBtn = document.getElementById("profileBtn");
    var profileCard = document.getElementById("profileCard");
    if (profileBtn && profileCard) {
        profileBtn.addEventListener("click", function () {
            profileCard.classList.toggle("profile_hidden");
        });
    }
});
window.addEventListener("DOMContentLoaded", function () {
    var guestSection = document.getElementById("guest_section");
    var guestCatagories = document.getElementById("guestCatagories");
    if (guestSection && guestCatagories) {
        guestSection.addEventListener("click", function () {
            guestCatagories.classList.toggle("guest_hidden");
        });
    }
});
window.addEventListener("DOMContentLoaded", function () {
    console.log("adult count block loaded");
    var minusButton = document.getElementById("minusButton");
    var plusButton = document.getElementById("plusButton");
    var adultNumber = document.getElementById("adultNumber");
    var guestCount = document.getElementById("guestCount");
    if (minusButton && plusButton && adultNumber && guestCount) {
        console.log("increment button");
        plusButton.addEventListener("click", function () {
            var current = parseInt(adultNumber.textContent || "0", 10);
            adultNumber.textContent = String(current + 1);
            guestCount.textContent = String(current + 1);
            console.log("incementing");
        });
        minusButton.addEventListener("click", function () {
            console.log("decrment button");
            var current = parseInt(adultNumber.textContent || "0", 10);
            if (current >= 1) {
                adultNumber.textContent = String(current - 1);
                guestCount.textContent = String(current - 1);
            }
        });
    }
});
