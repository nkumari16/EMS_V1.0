import { Component } from '@angular/core';
import { ApiService } from './api.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { isArray } from 'util';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'EMS';
  user: any;
  roles:Array<string>[] = [];
  temp: Array<string>=['a','b'];
  // temp2: ['a','b'];
  tempflag:boolean = false;
  activeLinkIndex = -1; 
  navLinks: any[];
  constructor(public dataService: ApiService,private http: HttpClient,private router: Router) { 
    

  this.navLinks = [
    {
        label: 'Home',
        link: './',
        index: 0
    }, {
        label: 'Admin',
        link: './admin',
        index: 1
    }, {
        label: 'Employee',
        link: './employee',
        index: 2
    }, 
];
  } 
  ngOnInit() { 
    console.log(`AppComponent OnInit`);
   this.getUser();
  //  this.getRoles();
  this.router.events.subscribe((res) => {
    this.activeLinkIndex = this.navLinks.indexOf(this.navLinks.find(tab => tab.link === '.' + this.router.url));
});
  }
   getUser() {
		this.http.get('/server/user').subscribe((user:any) => {
      this.user = user;
     for (let index in this.user.authorities) {
        this.roles.push(this.user.authorities[index].authority);
     }
			console.log('Logged User in app: ', JSON.stringify(this.user),this.roles);
		})
  };
  // getRoles() {
	// 	this.http.get('/server/roles').subscribe(roles => {
  //     console.log('User Roles in app1: ', isArray(this.roles),this.roles);
	// 		this.roles.push(roles[0]);
	// 		console.log('User Roles in app: ', isArray(this.roles),this.roles);
	// 	})
	// };
 myFunct(){
  // this.http.get('/server/').subscribe(user => {
  //   this.user = user;
  //   console.log('Logged User : ', this.user);
  // })
  window.location.href='http://localhost:8080/'
}
}
