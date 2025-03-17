
let cart = []; // 存儲購物車的內容
let cartBtn = document.getElementById('cart-btn');
let cartModal = document.getElementById('cart');
let closeCartBtn = document.getElementById('close-cart-btn');
let cartItemsList = document.getElementById('cart-items');
let totalPriceElem = document.getElementById('total-price');
let checkoutBtn = document.getElementById('checkout-btn');

cartBtn.addEventListener('click', () => {
    cartModal.style.display = 'block';
    renderCart();
});

closeCartBtn.addEventListener('click', () => {
    cartModal.style.display = 'none';
});

checkoutBtn.addEventListener('click', () => {
    alert('結帳成功！');
    cart = [];
    renderCart();
});

document.querySelectorAll('.add-to-cart-btn').forEach((button) => {
    button.addEventListener('click', (e) => {
        const menuItem = e.target.closest('.menu-item');
        const id = menuItem.getAttribute('data-id');
        const name = menuItem.querySelector('h3').textContent;
        const price = parseFloat(menuItem.querySelector('p').textContent.replace('價格：NT$', ''));

        const item = { id, name, price };
        cart.push(item);

        cartBtn.textContent = `查看購物車 (${cart.length})`;
        renderCart();
    });
});

function renderCart() {
    cartItemsList.innerHTML = '';
    let totalPrice = 0;

    cart.forEach(item => {
        const li = document.createElement('li');
        li.textContent = `${item.name} - NT$ ${item.price}`;
        cartItemsList.appendChild(li);
        totalPrice += item.price;
    });

    totalPriceElem.textContent = `總金額：NT$ ${totalPrice}`;
}
    