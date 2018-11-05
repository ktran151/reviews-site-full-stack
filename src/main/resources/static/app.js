// const id = window.location.pathname.split('/')[2]

// fetch(`api/doggos/${id}`)
// 	.then(res => res.json())
// 	.then(data => {
// 		const body = document.body
// 		const pageTitle = `<h1>${data.title}</h1>`
// 		const category = `<h2>${data.category}</h2>`
// 		const img = `<img src="@{|/images/${data.url}|}">`
// 		const tagList = document.createElement('ul')
// 		${data.tags}.forEach( tag => {
// 			let item = `<li>${tag.tagName}</li>`
// 			tagList.appendChild(item)
// 		})

// 		body.innerHTML += pageTitle
// 		body.innerHTML += category
// 		body.innerHTML += img
// 		body.innerHTML += tagList
// 	})

// const input = document.querySelector('input')
// const addTagButton = document.querySelector('button')

// addTagButton.addEventListener('click', () => {
// 	fetch('/api/doggos/${id}/tags/add', {
// 		method: 'post',
// 		body: JSON.stringify({
// 			tagName: input.value,
// 		}),
// 	})
// 		.then(res => res.json())
// 		.then(data => console.log)
// })