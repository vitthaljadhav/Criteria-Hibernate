package com.iz.zm;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import com.iz.zm.entities.Customer;
import com.iz.zm.util.HibernateUtil;

import javassist.compiler.Lex;

public class FetchDataFromCriteria {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(Customer.class);

			// Criterion address = (Criterion) criteria.add(Restrictions.eq("address",
			// "solapur"));
			// Criterion fname = (Criterion) criteria.add(Restrictions.eq("fname",
			// "pranali"));
			// LogicalExpression logicalExpression = Restrictions.and(address, fname);
			Criterion address = Restrictions.eq("address", "solapur");
			Criterion fname = Restrictions.eq("fname", "pranali");
			Conjunction conjunction = Restrictions.conjunction();
			conjunction.add(fname);
			conjunction.add(address);
			criteria.add(conjunction);
			List<Customer> list = criteria.list();
			Iterator<Customer> iterator = list.iterator();
			while (iterator.hasNext()) {
				Customer customer = iterator.next();
				System.out.println(customer);
			}
		} catch (Exception e) {

		}
	}
}
