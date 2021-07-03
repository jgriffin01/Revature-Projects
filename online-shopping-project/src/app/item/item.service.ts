import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root'
})
export class ItemService {

    items = [{id:1,name:'IPad',price:99.99,category:'Electronics',fav:false,quantity:0},
        {id:2,name:'Computer',price:359.99,category:'Electronics',fav:false,quantity:0},
        {id:3,name:'HoverBoard',price:524.49,category:'Electronics',fav:false,quantity:0},
        {id:4,name:'Camera',price:29.99,category:'Electronics',fav:false,quantity:0},
        {id:5,name:'Hammock',price:49.99,category:'Furniture',fav:false,quantity:0},
        {id:6,name:'Recliner',price:42.99,category:'Furniture',fav:false,quantity:0},
        {id:7,name:'Couch',price:65.99,category:'Furniture',fav:false,quantity:0},
        {id:8,name:'Microwave',price:29.99,category:'Appliances',fav:false,quantity:0},
        {id:9,name:'Washing Machine',price:99.99,category:'Appliances',fav:false,quantity:0},
        {id:10,name:'Refrigerator',price:84.99,category:'Appliances',fav:false,quantity:0},
        {id:11,name:'Helicopter',price:49999.99,category:'Vehicles',fav:true,quantity:0},
        {id:12,name:'Submarine',price:29999.99,category:'Vehicles',fav:false,quantity:0},
        {id:13,name:'Monster Truck',price:11999.99,category:'Vehicles',fav:false,quantity:0},
        {id:14,name:'Jet Fighter',price:119999.99,category:'Vehicles',fav:false,quantity:0},
        {id:15,name:'Book Shelf', price:19.99, category:'Furniture',fav:false,quantity:0},
        {id:16,name:'Cieling Fan',price:39.99, category:'Appliances',fav:false,quantity:0}]

    getItems() {
        return this.items
    }

    getFavorites() {
        return this.items.filter(x=>x.fav === true)
    }

    filterItems(category) {
        return this.items.filter(x=>x.category === category)
    }

    toggleFav(id) {
        this.items.forEach(x => {
            if(x.id === id) {
                x.fav = !x.fav
            }
        })
    }
}