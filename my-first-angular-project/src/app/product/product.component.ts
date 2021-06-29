import { Component } from "@angular/core";

@Component({
	selector: 'app-product',
	template: `
		<div>
			<h4>Product: {{title}}</h4>
		</div>
	`
})
export class ProductComponent {
	title:string = 'Furniture'
}