import { Component } from '@angular/core';
import { ApiService } from './api.service';
import { HttpClient } from '@angular/common/http';
import { isArray } from 'util';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'EMS';
  user: Object;
  roles:Array<string>[] = [];
  tempflag:boolean = false;
  constructor(public dataService: ApiService,private http: HttpClient) { } 
  ngOnInit() { console.log(`AppComponent OnInit`);
   this.getUser();
   this.getRoles();
  }
   getUser() {
		this.http.get('/server/user').subscribe(user => {
			this.user = user;
			console.log('Logged User in app: ', JSON.stringify(this.user));
		})
  };
  getRoles() {
		this.http.get('/server/roles').subscribe(roles => {
      console.log('User Roles in app1: ', isArray(this.roles),this.roles);
			this.roles.push(roles[0]);
			console.log('User Roles in app: ', isArray(this.roles),this.roles);
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
