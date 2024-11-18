package com.udea.sagoa.dominio.workorder.model;

import com.udea.sagoa.dominio.issuereport.model.IssueReport;
import com.udea.sagoa.dominio.user.model.User;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
@Table(name = "work_orders")

@Getter
public class WorkOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false, name = "issue_date")
    private Date issueDate;

    @Column(nullable = false, name = "scheduled_date")
    private Date scheduledDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_of_order")
    private TypeOfOrder typeOfOrder;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StateOfOrder state;

    @ManyToOne
    @JoinColumn(name = "maintenance_operator_id", referencedColumnName = "id")
    private User maintenanceOperator;

    @ManyToOne
    @JoinColumn(name = "work_order_assigner_id", referencedColumnName = "id")
    private User workOrderAssigner;

    @ManyToOne
    @JoinColumn(name = "issue_report_id", referencedColumnName = "id")
    private IssueReport issueReport;


    /*
    @ManyToMany
    @JoinTable(
            name = "maintenance_issuereport",
            joinColumns = @JoinColumn(name = "maintenance_id"),
            inverseJoinColumns = @JoinColumn(name = "issuereport_id"))
    private Set<IssueReport> issueReports;
     */


}
