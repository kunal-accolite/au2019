import { Injectable } from '@angular/core';
import * as EmployeeJson from "../assets/Employee.json";
import * as DepartmentJson from "../assets/Department.json";
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AssingmentServiceService {
  private emplist=EmployeeJson.default;
  private deptlist=DepartmentJson.default;

  private Emplist=new BehaviorSubject(this.emplist);
  emplistobs=this.Emplist.asObservable();

  private Deptlist=new BehaviorSubject(this.deptlist);
  deptlistobs=this.Deptlist.asObservable();

  constructor() { }

  getemplist(){
    return this.emplist;
  }
  getdeptlist()
  {
    return this.deptlist;
  }

  setemplist(val:any)
  {
    return this.Emplist.next(val);
  }
  setdeptlist(val:any)
  {
    return this.Deptlist.next(val);
  }
  getEmployeeById(id:any)
  {
    var e=this.emplist.find(function(element){
      return element.id==id;
    });
    return e;
  }
  getDepartmentById(id:any)
  {
    var d=this.deptlist.find(function(element){
      return element.id==id;
    });
    return d;
  }
}
