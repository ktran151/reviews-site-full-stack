const id = window.location.pathname.split('/')[2]
fetch(`api/doggos/${id}`)
	.then(res => res.json())
	.then(data => {
		const body = document.body
		const pageTitle = `<h1>${data.title}</h1>`
		const category = `<h2>${data.category}</h2>`
		const img = `<img src="@{|/images/${data.url}|}">`
		const tags = 
		`<ul > /*iterate each???*/

		`


	})