import { Component } from '@angular/core';

@Component({
  selector: 'app-first',
  templateUrl: './app.component.html',
  /*template: `
  <div>
    {{title}}
    {{sayHello()}}
  </div>
  `,*/
  styleUrls: ['./app.component.css']
  //styles:[dic{backgounf-color:#FFF}]

})
export class AppComponent {
  title = 'my-first-angular-project';
  active = false
  name = 'John'
  submit(){
    console.log('submitting form...')
  }

  sayHello(){
    return 'Hi there!'
  }

  changeNameHandler(e:any) {
    this.name = e.target.value
  }
}
