import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AppService } from './app.service';
import { Router } from '@angular/router';
import { finalize } from "rxjs/operators";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
    title = 'Demo';
    authenticated = false;
    greeting : any = {};

    constructor(private http: HttpClient, private router: Router) {
      this.authenticate();
    }

    authenticate() {

      this.http.get('user').subscribe(response => {
          if (response['name']) {
              this.authenticated = true;
              this.http.get('employees').subscribe(data => this.greeting = data);
          } else {
              this.authenticated = false;
          }
      }, () => { this.authenticated = false; });

    }
    logout() {
        this.http.post('logout', {}).pipe(
            finalize(() => {
                this.authenticated = false;
                this.router.navigateByUrl('/login');
            })).subscribe();
    }
}
