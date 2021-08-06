package com.qdevs.reportingdslpoc.reports.application

import com.qdevs.reportingdslpoc.employee.domain.Employee
import com.qdevs.reportingdslpoc.reports.domain.EmployeeReportData
import com.qdevs.reportingdslpoc.reports.domain.EmployeesReport
import org.springframework.stereotype.Service

@Service
class CreateEmployeeReport() {

    fun execute(employees: List<Employee>): EmployeesReport {
        val employeesData = employees.map {
            EmployeeReportData(id = it.id, fullName = "${it.firstName} ${it.lastName}")
        }

        return EmployeesReport(employeesData)
    }
}