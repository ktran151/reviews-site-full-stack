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

fetch(`api/doggos/${id}`)
	.then(res => res.json())
	.then(data => {
		console.log(`${data.title}`)
		const tagSection = document.querySelector('#tags')
		const tagList = `<ul id="tags"></ul>`
		data.tags.forEach(tag => {
			let item = `<li><a href="|/tags/${tag.tagName}|">${tag.tagName}</a></li>`
			tagList.appendChild(item)
		})
		tagSection.appendChild(tagList)
	})

const input = document.querySelector('#tagInput')
const addTagButton = document.querySelector('.tagButton')

addTagButton.addEventListener('click', () => {
	fetch(`/api/doggos/${id}/tags/add`, {
		method: 'post',
		body: JSON.stringify({
			tagName: input.value,
			
		}),
	})
		.then(res => res.json())
		.then(data => console.log(data))
})