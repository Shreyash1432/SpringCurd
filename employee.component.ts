import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.scss']
})
export class EmployeeComponent {
[x: string]: any;

  EmployeeArray : any[] = [];
  isResultLoaded = false;
  isUpdateFormActive = false;
  
  employeename: string | undefined;
  employeeaddress: string | undefined;
  mobile: Number | undefined;
  currentEmployeeID = "";
 
 
 
constructor(private http: HttpClient )
  {
    this.get();
  }
 
  get()
  {
    
    this.http.get("http://localhost:8080/api/v1/employee/get")
  
    .subscribe((resultData: any)=>
    {
        this.isResultLoaded = true;
        console.log(resultData);
        this.EmployeeArray = resultData;
    });
  }
  register()
  {
  
    let bodyData = {
      employeename : this.employeename,
      employeeaddress : this.employeeaddress,
      mobile : this.mobile
    };
    this.http.post("http://localhost:8080/api/v1/employee/",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
    {
        console.log(resultData);
        alert("Employee Registered Successfully");
        this.get();
 
      //  this.employeename = '';
      //this.employeeaddress = '';
        //this.mobile  = 0;
    });
  }
  setUpdate(data: any)
  {
   this.employeename = data.employeename;
   this.employeeaddress = data.employeeaddress;
   this.mobile = data.mobile;
   this.currentEmployeeID = data.employeeid;
  }
  UpdateRecords()
  {
    let bodyData = {
      "employeeid" : this.currentEmployeeID,
      "employeename" : this.employeename,
      "employeeaddress" : this.employeeaddress,
      "mobile" : this.mobile
    };
    
    this.http.put("http://localhost:8080/api/v1/employee/update",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
    {
        console.log(resultData);
        alert("Employee Registered Updateddd")
        this.get();
        //this.employeename = '';
        //this.employeeaddress = '';
        //this.mobile  = 0;
    });
  }
  save()
  {
    if(this.currentEmployeeID == '')
    {
        this.register();
    }
      else
      {
       this.UpdateRecords();
      }      
  }
  setDelete(data: any)
  {
    
    
    this.http.delete("http://localhost:8080/api/v1/employee/delete"+ "/"+ data.employeeid,{responseType: 'text'}).subscribe((resultData: any)=>
    {
        console.log(resultData);
        alert("Employee Deleted")
        this.get();
 
        this.employeename = '';
      this.employeeaddress = '';
        this.mobile  = 0;
  
    });
  }
}
