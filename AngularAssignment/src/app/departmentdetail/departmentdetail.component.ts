import { Component, OnInit } from '@angular/core';
import { AssingmentServiceService } from '../assingment-service.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-departmentdetail',
  templateUrl: './departmentdetail.component.html',
  styleUrls: ['./departmentdetail.component.css']
})
export class DepartmentdetailComponent implements OnInit {
public department:any;
  constructor(private departmentservice:AssingmentServiceService,private route:ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe(x=>{
        this.department=this.departmentservice.getDepartmentById(x.id);
    });
  }

}
