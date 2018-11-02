/*const input = document.querySelector('.tagInput')
const addTagButton = document.querySelector('button')

addTagButton.addEventListener('click', () => {
	fetch(`api/doggos/${window.location.pathname.split('/')[2]}/tags/add`, {
		method: 'post',
		body: JSON.stringify({
			tagName: input.value,
		}),
	})
		.then(res => res.json())
		.then(data => console.log)
})*/

const input = document.querySelector('#tagInput')
const addTagButton = document.querySelector('button')

addTagButton.addEventListener('click', () => {
	fetch('/api/reviews/1/tags/add', {
		method: 'post',
		body: JSON.stringify({
			tagName: input.value,
		}),
	})
		.then(res => res.json())
		.then(data => console.log)
})