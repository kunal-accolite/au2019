import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AssingmentServiceService } from '../assingment-service.service';


@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})

export class EmployeeComponent implements OnInit {
 public emparray :any;


  constructor(private route : Router,private employeeservice: AssingmentServiceService) { }

  ngOnInit() {
    this.employeeservice.emplistobs.subscribe(x=>{
      this.emparray=x;
    });
  }

  getDetails(emp:any){
    this.route.navigate(['/employee',emp.id]);
  }
  deleteEmployee(employee: any) {
    var result = this.arrayRemove(this.emparray, employee);
    this.employeeservice.setemplist(result);
  }

  arrayRemove(array, value) {
    return array.filter(function (element) {
      return element != value;
    });
  }
 
}
