import { Component } from '@angular/core';
import { ApiService } from './api.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'EMS';
  constructor(public dataService: ApiService) { } 
 myFunct(){
   window.location.href='http://localhost:8080/'
  //  this.dataService.Login();
}
}
