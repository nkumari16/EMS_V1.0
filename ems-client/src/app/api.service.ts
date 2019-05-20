import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  apiURL: string = 'http://localhost:8080/';
  constructor(public httpClient: HttpClient) { }
  Login(){
    alert(1)
    this.httpClient.get('/server').subscribe((res)=>{
      alert(2)
        console.log(res);
    });
}
}
