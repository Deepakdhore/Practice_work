window.addEventListener("DOMContentLoaded", () => {
  const profileBtn = document.getElementById("profileBtn") as HTMLButtonElement | null;
  const profileCard = document.getElementById("profileCard") as HTMLElement | null;

  if (profileBtn && profileCard) {
    profileBtn.addEventListener("click", () => {
      profileCard.classList.toggle("profile_hidden");
    });
  }
});

window.addEventListener("DOMContentLoaded",()=>{
  const guestSection=document.getElementById("guest_section") as HTMLDivElement | null;
  const guestCatagories=document.getElementById("guestCatagories") as HTMLElement| null;

  if(guestSection && guestCatagories)
  {
    guestSection.addEventListener("click",()=>{
      guestCatagories.classList.toggle("guest_hidden");
    })
  }
})

window.addEventListener("DOMContentLoaded",()=>{
  console.log("adult count block loaded");

  const minusButton=document.getElementById("minusButton") as HTMLButtonElement|null;
  const plusButton=document.getElementById("plusButton") as HTMLButtonElement|null;
  const adultNumber=document.getElementById("adultNumber") as HTMLSpanElement |null;
  const guestCount=document.getElementById("guestCount") as HTMLSpanElement |null;
  if(minusButton && plusButton && adultNumber && guestCount)
  {
    console.log("increment button")
  plusButton.addEventListener("click",()=>{
    const current=parseInt(adultNumber.textContent || "0",10);
    adultNumber.textContent=String(current+1);
    guestCount.textContent=String(current+1);
    console.log("incementing");
  });

  minusButton.addEventListener("click",()=>{
    console.log("decrment button")
    const current=parseInt(adultNumber.textContent || "0",10);
    if(current>=1){
      adultNumber.textContent=String(current-1);
      guestCount.textContent=String(current-1);
    } 
   });
  }

  
})