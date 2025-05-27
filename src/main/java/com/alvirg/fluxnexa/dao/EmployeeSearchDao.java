package com.alvirg.fluxnexa.dao;

import com.alvirg.fluxnexa.models.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmployeeSearchDao {

    private final EntityManager entityManager;

    public List<Employee> findAllBySimpleQuery(String firstName, String lastName, String email){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);

        // select * from employee

        Root<Employee> root = criteriaQuery.from(Employee.class);

        // prepare WHERE clause
        // WHERE firstName like %ali%

        Predicate firstNamePredicate = criteriaBuilder
                .like(root.get("firstName"), "%" + firstName + "%");

        Predicate lastNamePredicate = criteriaBuilder
                .like(root.get("lastName"), "%" + lastName + "%");

        Predicate emailPredicate = criteriaBuilder
                .like(root.get("email"), "%" + email + "%");

        Predicate firstNameOrLastNamePredicate = criteriaBuilder.or(
                firstNamePredicate,
                lastNamePredicate);

        // => final query ==> select * from employee WHERE firstName like '%ali%'
        // or lastName like '%alik%' and email like'%email%'

        Predicate andEmailPredicate = criteriaBuilder.and(firstNameOrLastNamePredicate, emailPredicate);
        criteriaQuery.where(andEmailPredicate);

        TypedQuery<Employee> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();


//        return entityManager.createQuery(criteriaQuery).getResultList();
//
    }


}
