import { Component, OnInit } from '@angular/core';
import { AssingmentServiceService } from '../assingment-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-department',
  templateUrl: './department.component.html',
  styleUrls: ['./department.component.css']
})
export class DepartmentComponent implements OnInit {

  public deptarray :any;


  constructor(private departmentservice: AssingmentServiceService , private route:Router) { }

  ngOnInit() {
    this.departmentservice.deptlistobs.subscribe(x=>{
      this.deptarray=x;
    });
  }
  getDetails(dept:any){
    this.route.navigate(['/department',dept.id]);
  }
  deleteDepartment(department: any) {
    var result = this.arrayRemove(this.deptarray, department);
    this.departmentservice.setdeptlist(result);
  }

  arrayRemove(array, value) {
    return array.filter(function (element) {
      return element != value;
    });

}
}
