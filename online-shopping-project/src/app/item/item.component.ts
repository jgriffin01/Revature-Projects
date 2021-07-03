import { Component, Input, OnInit } from '@angular/core';
import { ItemService } from './item.service';
import { CartService } from '../cart/cart.service';

@Component({
    selector: 'app-item',
    templateUrl: './item.component.html',
    styleUrls: ['./item.component.css']
})
export class ItemComponent {

    items = []

    constructor(private iService:ItemService, private cService:CartService) {}

    ngOnInit() {
        this.items = this.iService.getItems()
    }

    filterItems(e){
        if(e.target.value == 'All Items'){
            this.items = this.iService.getItems()
        }
        else if(e.target.value == 'Favorites'){
            this.items = this.iService.getFavorites()
        }
        else {
            this.items = this.iService.filterItems(e.target.value)
        }
    }

    toggleFavorite(i) {
        this.iService.toggleFav(i.id)
    }

    addToCart(i) {
        this.cService.addItem(i)
    }
}
