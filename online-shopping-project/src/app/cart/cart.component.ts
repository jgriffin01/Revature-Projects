import { Component, OnInit } from '@angular/core';
import { CartService } from './cart.service';

@Component({
    selector: 'app-cart',
    templateUrl: './cart.component.html',
    styleUrls: ['./cart.component.css']
})
export class CartComponent {
    items = []
    subTotal = 0

    constructor(private cService:CartService) {}

    ngOnInit(){
        this.cService.getItems().subscribe((data:[])=>{
            this.items = data
            let total = 0
            this.items.forEach(i=> {
                total+=(i.price * i.quantity)
            })
            console.log(total)
            this.subTotal = total
        })
    }

    increment(item) {
        this.cService.addItem(item)
    }
    decrement(item) {
        if (item.quantity > 0) {
            this.cService.removeItem(item)
        }
    }

    updatePrice() {
        this.cService.getItems().subscribe((data:[])=> {
            this.items = data
            let total = 0
            this.items.forEach(i => {
                total += (i.price * i.quantity)
            })
            this.subTotal = total
        })
    }
}
