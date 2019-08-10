import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AssingmentServiceService } from '../assingment-service.service';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {

  public emparray :any;
  public eid: any;

  public emp: any;
  public _router: String;

  constructor(private ar : ActivatedRoute ,private route : Router,private employeeservice: AssingmentServiceService) {
    this._router = route.url;
   }

  ngOnInit() {
    this.employeeservice.emplistobs.subscribe(x=>{
      this.emparray=x;
    });

    this.ar.params.subscribe(x=>{
      this.eid = x.id;
      this.emp = this.employeeservice.getEmployeeById(this.eid);
    });
    //console.log(this.emp);
    console.log(this.eid);
    console.log(this.emp);
    console.log(this._router);
  }

  getDetails(emp:any){
    this.eid = emp.eid;
    this.route.navigate(['/todo',emp.id]);
  }




 
}
