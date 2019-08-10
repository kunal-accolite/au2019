import { Component, OnInit } from '@angular/core';
import { AssingmentServiceService } from '../assingment-service.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-employeedetail',
  templateUrl: './employeedetail.component.html',
  styleUrls: ['./employeedetail.component.css']
})
export class EmployeedetailComponent implements OnInit {

  public employee:any;
  public employee1:any;
  constructor(private employeeservice:AssingmentServiceService,private route :ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe(x=>{
        this.employee=this.employeeservice.getEmployeeById(x.id);
        //this.employee1=JSON.stringify(this.employee);
    });
  }

}
