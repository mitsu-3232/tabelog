const stripe = Stripe('pk_test_51Ov6nBP3Yga9xd2mNtamDNcLkYxAMKZEL5kIkHD31drRXigCc080lvc7FmNrokzf2NPx0yj1kKBkHhN7yCsOioFE00SApanL42');
const paymentButton = document.querySelector('#paymentButton');

paymentButton.addEventListener('click', () => {
	stripe.redirectToCheckout({
		sessionId: sessionId
	})
});
