import { Component } from '@angular/core';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'EMS';
  temp: Array<string>=['a','b'];
  // temp2: ['a','b'];
  tempflag:boolean = false;
 
  constructor() { 
  } 
  ngOnInit() { 

  }
 
  
  
 
}
