const btn = document.getElementById("toggleBtn");
const sidebar = document.getElementById("sidebar");
const content = document.getElementById("content");
const overlay = document.getElementById("overlay");

btn.addEventListener("click", () => {
  if (window.innerWidth <= 768) {
    sidebar.classList.toggle("sidebar--active");
    overlay.classList.toggle("overlay--active");
  } else {
    sidebar.classList.toggle("sidebar--collapsed");
    content.classList.toggle("content--full");
  }
});

overlay.addEventListener("click", () => {
  sidebar.classList.remove("sidebar--active");
  overlay.classList.remove("overlay--active");
});