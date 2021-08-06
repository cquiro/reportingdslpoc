package com.qdevs.reportingdslpoc.reports.infrastructure.api.v1

import com.qdevs.reportingdslpoc.employee.domain.Employee
import com.qdevs.reportingdslpoc.reports.application.CreateEmployeeReport
import com.qdevs.reportingdslpoc.reports.domain.EmployeesReport
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/employees")
class EmployeeReportsController(val createEmployeeReport: CreateEmployeeReport) {

    @PostMapping("/generate")
    fun generate(): ResponseEntity<EmployeesReport> {
        val employees = listOf(
                Employee(id = 1, firstName = "Roberto", lastName = "Quesada"),
                Employee(id = 2, firstName = "Carlos Andres", lastName = "Quiroga"),
        )

        return ResponseEntity(createEmployeeReport.execute(employees), HttpStatus.CREATED)
    }
}