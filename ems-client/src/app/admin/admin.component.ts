import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  constructor(private http: HttpClient) { }

  ngOnInit() { 
  console.log(`AdminComponent OnInit`);
   this.getAdmin();
  }
   getAdmin() {
		this.http.get('/server/admin').subscribe((data:any) => {
      // this.user = user;
			console.log('Logged User in app: ', JSON.stringify(data));
		})
  };

}
