import { Component } from '@angular/core';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent {
  postTitle:string = 'My First Blog Post'
  description:string = 'This is my first blog post... and this is my description. It has to be longer so that I can test the formating and make sure that it wraps over multiple lines nicely. So I just have to keep typing to take up some more space.'
  hidden:boolean = true
  visibleText:string = 'hidden'
  buttonText:string = 'Show'

  //constructor(title:string) {
  //  this.postTitle = title
  // }

  hide() {
    this.hidden = !this.hidden
    if (this.hidden == true) {
      this.buttonText = 'Show'
      this.visibleText = 'hidden'
    }
    else {
      this.buttonText = 'Hide'
      this.visibleText = 'visible'
    }
  }

}
