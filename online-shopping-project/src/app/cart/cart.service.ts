import { Injectable } from "@angular/core";
import { Subject } from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class CartService {
    //temp = [{id:0,name:'faker',price:0,category:'fake',fav:false,quantity:0}]
    temp = []
    items = new Subject()

    addItem(item){
        var added = false
        this.temp.forEach(x => {
            if(x.id == item.id) {
                item.quantity += 1
                added = true
            }
        })
        if (added == false) {
            item.quantity += 1
            this.temp.push(item)
        }
        this.items.next(this.temp)
    }

    removeItem(item) {
        this.temp.forEach(x => {
            if(x.id == item.id) {
                item.quantity -=1
            }
        })
        this.items.next(this.temp)
    }

    getItems(){
        return this.items
    }
}