import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeComponent } from './employee/employee.component';
import { DepartmentComponent } from './department/department.component';
import { EmployeedetailComponent } from './employeedetail/employeedetail.component';
import { DepartmentdetailComponent } from './departmentdetail/departmentdetail.component';
import { TodoComponent } from './todo/todo.component';

const routes: Routes = [
  {
    path: "employee-list",
    component: EmployeeComponent
  },
  {
    path: "department",
    component: DepartmentComponent
  },
  {
    path: "employee/:id",
    component: EmployeedetailComponent
  },
  {
    path:"department/:id",
    component:DepartmentdetailComponent
  },
  {
    path:"todo",
    component:TodoComponent
  },
  {
    path:"todo/:id",
    component:TodoComponent
  }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
