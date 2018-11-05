const id = window.location.pathname.split('/')[2]
console.log(id)
//fetch(`api/doggos/${id}`)
//	.then(res => res.json())
//	.then(data => {
//		const body = document.body
//		const pageTitle = `<h1>${data.title}</h1>`
//		const category = `<h2>${data.category.name}</h2>`
//		const img = `<img src="@{|/images/${data.url}|}">`
//		const review = 
//
//		body.innerHTML += pageTitle
//		body.innerHTML += category
//		body.innerHTML += img
//	})

//fetch(`api/doggos/${id}/tags`)
//	.then(res => res.json())
//	.then(tags => {
//		const body = document.body
//		const tagList = document.createElement('ul')
//		tags.forEach(tag => {
//			let item = `<li>${tag.tagName}</li>`
//			tagList.appendChild(item)
//		})
//		body.innerHTML += tagList
//	})

const input = document.querySelector('input')
const addTagButton = document.querySelector('button')

addTagButton.addEventListener('click', () => {
	fetch('/api/doggos/${id}/tags/add', {
		method: 'post',
		body: JSON.stringify({
			tagName: input.value,
		}),
	})
		.then(res => res.json())
		.then(data => console.log)
})