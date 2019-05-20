import { Component } from '@angular/core';
import { ApiService } from './api.service';
import { HttpClient } from '@angular/common/http';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'EMS';
  user: Object;
  tempflag:boolean = false;
  constructor(public dataService: ApiService,private http: HttpClient) { } 
  ngOnInit() { console.log(`AppComponent OnInit`);
   this.getUser();}
   getUser() {
		this.http.get('/server/user').subscribe(user => {
			this.user = user;
			console.log('Logged User in app: ', JSON.stringify(this.user));
		})
	};
 myFunct(){
  // this.http.get('/server/').subscribe(user => {
  //   this.user = user;
  //   console.log('Logged User : ', this.user);
  // })
  window.location.href='http://localhost:8080/'
}
}
